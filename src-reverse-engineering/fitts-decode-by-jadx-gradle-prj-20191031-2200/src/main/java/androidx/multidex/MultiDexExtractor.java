package androidx.multidex;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

final class MultiDexExtractor implements Closeable {
    private static final int BUFFER_SIZE = 16384;
    private static final String DEX_PREFIX = "classes";
    static final String DEX_SUFFIX = ".dex";
    private static final String EXTRACTED_NAME_EXT = ".classes";
    static final String EXTRACTED_SUFFIX = ".zip";
    private static final String KEY_CRC = "crc";
    private static final String KEY_DEX_CRC = "dex.crc.";
    private static final String KEY_DEX_NUMBER = "dex.number";
    private static final String KEY_DEX_TIME = "dex.time.";
    private static final String KEY_TIME_STAMP = "timestamp";
    private static final String LOCK_FILENAME = "MultiDex.lock";
    private static final int MAX_EXTRACT_ATTEMPTS = 3;
    private static final long NO_VALUE = -1;
    private static final String PREFS_FILE = "multidex.version";
    private static final String TAG = "MultiDex";
    private final FileLock cacheLock;
    private final File dexDir;
    private final FileChannel lockChannel;
    private final RandomAccessFile lockRaf;
    private final File sourceApk;
    private final long sourceCrc;

    private static class ExtractedDex extends File {
        public long crc = -1;

        public ExtractedDex(File file, String str) {
            super(file, str);
        }
    }

    MultiDexExtractor(File file, File file2) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("MultiDexExtractor(");
        sb.append(file.getPath());
        sb.append(", ");
        sb.append(file2.getPath());
        sb.append(")");
        sb.toString();
        this.sourceApk = file;
        this.dexDir = file2;
        this.sourceCrc = getZipCrc(file);
        File file3 = new File(file2, LOCK_FILENAME);
        this.lockRaf = new RandomAccessFile(file3, "rw");
        try {
            this.lockChannel = this.lockRaf.getChannel();
            try {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Blocking on lock ");
                sb2.append(file3.getPath());
                sb2.toString();
                this.cacheLock = this.lockChannel.lock();
                StringBuilder sb3 = new StringBuilder();
                sb3.append(file3.getPath());
                sb3.append(" locked");
                sb3.toString();
            } catch (IOException e) {
                e = e;
                closeQuietly(this.lockChannel);
                throw e;
            } catch (RuntimeException e2) {
                e = e2;
                closeQuietly(this.lockChannel);
                throw e;
            } catch (Error e3) {
                e = e3;
                closeQuietly(this.lockChannel);
                throw e;
            }
        } catch (IOException | Error | RuntimeException e4) {
            closeQuietly(this.lockRaf);
            throw e4;
        }
    }

    /* access modifiers changed from: 0000 */
    public List<? extends File> load(Context context, String str, boolean z) throws IOException {
        List<? extends File> list;
        StringBuilder sb = new StringBuilder();
        sb.append("MultiDexExtractor.load(");
        sb.append(this.sourceApk.getPath());
        String str2 = ", ";
        sb.append(str2);
        sb.append(z);
        sb.append(str2);
        sb.append(str);
        sb.append(")");
        sb.toString();
        if (this.cacheLock.isValid()) {
            if (z || isModified(context, this.sourceApk, this.sourceCrc, str)) {
                list = performExtractions();
                putStoredApkInfo(context, str, getTimeStamp(this.sourceApk), this.sourceCrc, list);
            } else {
                try {
                    list = loadExistingExtractions(context, str);
                } catch (IOException unused) {
                    list = performExtractions();
                    putStoredApkInfo(context, str, getTimeStamp(this.sourceApk), this.sourceCrc, list);
                }
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("load found ");
            sb2.append(list.size());
            sb2.append(" secondary dex files");
            sb2.toString();
            return list;
        }
        throw new IllegalStateException("MultiDexExtractor was closed");
    }

    public void close() throws IOException {
        this.cacheLock.release();
        this.lockChannel.close();
        this.lockRaf.close();
    }

    private List<ExtractedDex> loadExistingExtractions(Context context, String str) throws IOException {
        String str2 = str;
        StringBuilder sb = new StringBuilder();
        sb.append(this.sourceApk.getName());
        sb.append(EXTRACTED_NAME_EXT);
        String sb2 = sb.toString();
        SharedPreferences multiDexPreferences = getMultiDexPreferences(context);
        StringBuilder sb3 = new StringBuilder();
        sb3.append(str2);
        sb3.append(KEY_DEX_NUMBER);
        int i = multiDexPreferences.getInt(sb3.toString(), 1);
        ArrayList arrayList = new ArrayList(i - 1);
        int i2 = 2;
        while (i2 <= i) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(sb2);
            sb4.append(i2);
            sb4.append(EXTRACTED_SUFFIX);
            ExtractedDex extractedDex = new ExtractedDex(this.dexDir, sb4.toString());
            if (extractedDex.isFile()) {
                extractedDex.crc = getZipCrc(extractedDex);
                StringBuilder sb5 = new StringBuilder();
                sb5.append(str2);
                sb5.append(KEY_DEX_CRC);
                sb5.append(i2);
                long j = multiDexPreferences.getLong(sb5.toString(), -1);
                StringBuilder sb6 = new StringBuilder();
                sb6.append(str2);
                sb6.append(KEY_DEX_TIME);
                sb6.append(i2);
                long j2 = multiDexPreferences.getLong(sb6.toString(), -1);
                long lastModified = extractedDex.lastModified();
                if (j2 == lastModified) {
                    String str3 = sb2;
                    SharedPreferences sharedPreferences = multiDexPreferences;
                    if (j == extractedDex.crc) {
                        arrayList.add(extractedDex);
                        i2++;
                        multiDexPreferences = sharedPreferences;
                        sb2 = str3;
                    }
                }
                StringBuilder sb7 = new StringBuilder();
                sb7.append("Invalid extracted dex: ");
                sb7.append(extractedDex);
                sb7.append(" (key \"");
                sb7.append(str2);
                sb7.append("\"), expected modification time: ");
                sb7.append(j2);
                sb7.append(", modification time: ");
                sb7.append(lastModified);
                sb7.append(", expected crc: ");
                sb7.append(j);
                sb7.append(", file crc: ");
                sb7.append(extractedDex.crc);
                throw new IOException(sb7.toString());
            }
            StringBuilder sb8 = new StringBuilder();
            sb8.append("Missing extracted secondary dex file '");
            sb8.append(extractedDex.getPath());
            sb8.append("'");
            throw new IOException(sb8.toString());
        }
        return arrayList;
    }

    private static boolean isModified(Context context, File file, long j, String str) {
        SharedPreferences multiDexPreferences = getMultiDexPreferences(context);
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(KEY_TIME_STAMP);
        if (multiDexPreferences.getLong(sb.toString(), -1) == getTimeStamp(file)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(KEY_CRC);
            if (multiDexPreferences.getLong(sb2.toString(), -1) == j) {
                return false;
            }
        }
        return true;
    }

    private static long getTimeStamp(File file) {
        long lastModified = file.lastModified();
        return lastModified == -1 ? lastModified - 1 : lastModified;
    }

    private static long getZipCrc(File file) throws IOException {
        long zipCrc = ZipUtil.getZipCrc(file);
        return zipCrc == -1 ? zipCrc - 1 : zipCrc;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:12|13) */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r10 = new java.lang.StringBuilder();
        r10.append("Failed to read crc from ");
        r10.append(r8.getAbsolutePath());
        r10.toString();
        r10 = false;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0086 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.List<androidx.multidex.MultiDexExtractor.ExtractedDex> performExtractions() throws java.io.IOException {
        /*
            r14 = this;
            java.lang.String r0 = ".dex"
            java.lang.String r1 = "classes"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.io.File r3 = r14.sourceApk
            java.lang.String r3 = r3.getName()
            r2.append(r3)
            java.lang.String r3 = ".classes"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r14.clearDexDir()
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.zip.ZipFile r4 = new java.util.zip.ZipFile
            java.io.File r5 = r14.sourceApk
            r4.<init>(r5)
            r5 = 2
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0142 }
            r6.<init>()     // Catch:{ all -> 0x0142 }
            r6.append(r1)     // Catch:{ all -> 0x0142 }
            r6.append(r5)     // Catch:{ all -> 0x0142 }
            r6.append(r0)     // Catch:{ all -> 0x0142 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0142 }
            java.util.zip.ZipEntry r6 = r4.getEntry(r6)     // Catch:{ all -> 0x0142 }
        L_0x0041:
            if (r6 == 0) goto L_0x013e
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0142 }
            r7.<init>()     // Catch:{ all -> 0x0142 }
            r7.append(r2)     // Catch:{ all -> 0x0142 }
            r7.append(r5)     // Catch:{ all -> 0x0142 }
            java.lang.String r8 = ".zip"
            r7.append(r8)     // Catch:{ all -> 0x0142 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x0142 }
            androidx.multidex.MultiDexExtractor$ExtractedDex r8 = new androidx.multidex.MultiDexExtractor$ExtractedDex     // Catch:{ all -> 0x0142 }
            java.io.File r9 = r14.dexDir     // Catch:{ all -> 0x0142 }
            r8.<init>(r9, r7)     // Catch:{ all -> 0x0142 }
            r3.add(r8)     // Catch:{ all -> 0x0142 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0142 }
            r7.<init>()     // Catch:{ all -> 0x0142 }
            java.lang.String r9 = "Extraction is needed for file "
            r7.append(r9)     // Catch:{ all -> 0x0142 }
            r7.append(r8)     // Catch:{ all -> 0x0142 }
            r7.toString()     // Catch:{ all -> 0x0142 }
            r7 = 0
            r9 = 0
            r10 = 0
        L_0x0074:
            r11 = 3
            if (r9 >= r11) goto L_0x00fa
            if (r10 != 0) goto L_0x00fa
            int r9 = r9 + 1
            extract(r4, r6, r8, r2)     // Catch:{ all -> 0x0142 }
            long r10 = getZipCrc(r8)     // Catch:{ IOException -> 0x0086 }
            r8.crc = r10     // Catch:{ IOException -> 0x0086 }
            r10 = 1
            goto L_0x009b
        L_0x0086:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x0142 }
            r10.<init>()     // Catch:{ all -> 0x0142 }
            java.lang.String r11 = "Failed to read crc from "
            r10.append(r11)     // Catch:{ all -> 0x0142 }
            java.lang.String r11 = r8.getAbsolutePath()     // Catch:{ all -> 0x0142 }
            r10.append(r11)     // Catch:{ all -> 0x0142 }
            r10.toString()     // Catch:{ all -> 0x0142 }
            r10 = 0
        L_0x009b:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x0142 }
            r11.<init>()     // Catch:{ all -> 0x0142 }
            java.lang.String r12 = "Extraction "
            r11.append(r12)     // Catch:{ all -> 0x0142 }
            if (r10 == 0) goto L_0x00aa
            java.lang.String r12 = "succeeded"
            goto L_0x00ac
        L_0x00aa:
            java.lang.String r12 = "failed"
        L_0x00ac:
            r11.append(r12)     // Catch:{ all -> 0x0142 }
            java.lang.String r12 = " '"
            r11.append(r12)     // Catch:{ all -> 0x0142 }
            java.lang.String r12 = r8.getAbsolutePath()     // Catch:{ all -> 0x0142 }
            r11.append(r12)     // Catch:{ all -> 0x0142 }
            java.lang.String r12 = "': length "
            r11.append(r12)     // Catch:{ all -> 0x0142 }
            long r12 = r8.length()     // Catch:{ all -> 0x0142 }
            r11.append(r12)     // Catch:{ all -> 0x0142 }
            java.lang.String r12 = " - crc: "
            r11.append(r12)     // Catch:{ all -> 0x0142 }
            long r12 = r8.crc     // Catch:{ all -> 0x0142 }
            r11.append(r12)     // Catch:{ all -> 0x0142 }
            r11.toString()     // Catch:{ all -> 0x0142 }
            if (r10 != 0) goto L_0x0074
            r8.delete()     // Catch:{ all -> 0x0142 }
            boolean r11 = r8.exists()     // Catch:{ all -> 0x0142 }
            if (r11 == 0) goto L_0x0074
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x0142 }
            r11.<init>()     // Catch:{ all -> 0x0142 }
            java.lang.String r12 = "Failed to delete corrupted secondary dex '"
            r11.append(r12)     // Catch:{ all -> 0x0142 }
            java.lang.String r12 = r8.getPath()     // Catch:{ all -> 0x0142 }
            r11.append(r12)     // Catch:{ all -> 0x0142 }
            java.lang.String r12 = "'"
            r11.append(r12)     // Catch:{ all -> 0x0142 }
            r11.toString()     // Catch:{ all -> 0x0142 }
            goto L_0x0074
        L_0x00fa:
            if (r10 == 0) goto L_0x0116
            int r5 = r5 + 1
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0142 }
            r6.<init>()     // Catch:{ all -> 0x0142 }
            r6.append(r1)     // Catch:{ all -> 0x0142 }
            r6.append(r5)     // Catch:{ all -> 0x0142 }
            r6.append(r0)     // Catch:{ all -> 0x0142 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0142 }
            java.util.zip.ZipEntry r6 = r4.getEntry(r6)     // Catch:{ all -> 0x0142 }
            goto L_0x0041
        L_0x0116:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0142 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0142 }
            r1.<init>()     // Catch:{ all -> 0x0142 }
            java.lang.String r2 = "Could not create zip file "
            r1.append(r2)     // Catch:{ all -> 0x0142 }
            java.lang.String r2 = r8.getAbsolutePath()     // Catch:{ all -> 0x0142 }
            r1.append(r2)     // Catch:{ all -> 0x0142 }
            java.lang.String r2 = " for secondary dex ("
            r1.append(r2)     // Catch:{ all -> 0x0142 }
            r1.append(r5)     // Catch:{ all -> 0x0142 }
            java.lang.String r2 = ")"
            r1.append(r2)     // Catch:{ all -> 0x0142 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0142 }
            r0.<init>(r1)     // Catch:{ all -> 0x0142 }
            throw r0     // Catch:{ all -> 0x0142 }
        L_0x013e:
            r4.close()     // Catch:{ IOException -> 0x0141 }
        L_0x0141:
            return r3
        L_0x0142:
            r0 = move-exception
            r4.close()     // Catch:{ IOException -> 0x0146 }
        L_0x0146:
            goto L_0x0148
        L_0x0147:
            throw r0
        L_0x0148:
            goto L_0x0147
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.multidex.MultiDexExtractor.performExtractions():java.util.List");
    }

    private static void putStoredApkInfo(Context context, String str, long j, long j2, List<ExtractedDex> list) {
        Editor edit = getMultiDexPreferences(context).edit();
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(KEY_TIME_STAMP);
        edit.putLong(sb.toString(), j);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(KEY_CRC);
        edit.putLong(sb2.toString(), j2);
        StringBuilder sb3 = new StringBuilder();
        sb3.append(str);
        sb3.append(KEY_DEX_NUMBER);
        edit.putInt(sb3.toString(), list.size() + 1);
        int i = 2;
        for (ExtractedDex extractedDex : list) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(str);
            sb4.append(KEY_DEX_CRC);
            sb4.append(i);
            edit.putLong(sb4.toString(), extractedDex.crc);
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str);
            sb5.append(KEY_DEX_TIME);
            sb5.append(i);
            edit.putLong(sb5.toString(), extractedDex.lastModified());
            i++;
        }
        edit.commit();
    }

    private static SharedPreferences getMultiDexPreferences(Context context) {
        return context.getSharedPreferences(PREFS_FILE, VERSION.SDK_INT < 11 ? 0 : 4);
    }

    private void clearDexDir() {
        File[] listFiles = this.dexDir.listFiles(new FileFilter() {
            public boolean accept(File file) {
                return !file.getName().equals(MultiDexExtractor.LOCK_FILENAME);
            }
        });
        if (listFiles == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to list secondary dex dir content (");
            sb.append(this.dexDir.getPath());
            sb.append(").");
            sb.toString();
            return;
        }
        for (File file : listFiles) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Trying to delete old file ");
            sb2.append(file.getPath());
            sb2.append(" of size ");
            sb2.append(file.length());
            sb2.toString();
            if (!file.delete()) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Failed to delete old file ");
                sb3.append(file.getPath());
                sb3.toString();
            } else {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("Deleted old file ");
                sb4.append(file.getPath());
                sb4.toString();
            }
        }
    }

    private static void extract(ZipFile zipFile, ZipEntry zipEntry, File file, String str) throws IOException, FileNotFoundException {
        ZipOutputStream zipOutputStream;
        InputStream inputStream = zipFile.getInputStream(zipEntry);
        StringBuilder sb = new StringBuilder();
        sb.append("tmp-");
        sb.append(str);
        File createTempFile = File.createTempFile(sb.toString(), EXTRACTED_SUFFIX, file.getParentFile());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Extracting ");
        sb2.append(createTempFile.getPath());
        sb2.toString();
        try {
            zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(createTempFile)));
            ZipEntry zipEntry2 = new ZipEntry("classes.dex");
            zipEntry2.setTime(zipEntry.getTime());
            zipOutputStream.putNextEntry(zipEntry2);
            byte[] bArr = new byte[16384];
            for (int read = inputStream.read(bArr); read != -1; read = inputStream.read(bArr)) {
                zipOutputStream.write(bArr, 0, read);
            }
            zipOutputStream.closeEntry();
            zipOutputStream.close();
            if (createTempFile.setReadOnly()) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Renaming to ");
                sb3.append(file.getPath());
                sb3.toString();
                if (createTempFile.renameTo(file)) {
                    closeQuietly(inputStream);
                    createTempFile.delete();
                    return;
                }
                StringBuilder sb4 = new StringBuilder();
                sb4.append("Failed to rename \"");
                sb4.append(createTempFile.getAbsolutePath());
                sb4.append("\" to \"");
                sb4.append(file.getAbsolutePath());
                sb4.append("\"");
                throw new IOException(sb4.toString());
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("Failed to mark readonly \"");
            sb5.append(createTempFile.getAbsolutePath());
            sb5.append("\" (tmp of \"");
            sb5.append(file.getAbsolutePath());
            sb5.append("\")");
            throw new IOException(sb5.toString());
        } catch (Throwable th) {
            closeQuietly(inputStream);
            createTempFile.delete();
            throw th;
        }
    }

    private static void closeQuietly(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }
}
