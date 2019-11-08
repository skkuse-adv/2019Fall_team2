package photopicker.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

public final class CropUtil {
    public static final CropUtil INSTANCE = new CropUtil();
    private static final String SCHEME_CONTENT = "content";
    private static final String SCHEME_FILE = "file";

    private CropUtil() {
    }

    public final void closeSilently(@Nullable Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public final int getExifRotation(@Nullable File file) {
        int i = 0;
        if (file == null) {
            return 0;
        }
        try {
            int attributeInt = new ExifInterface(file.getAbsolutePath()).getAttributeInt(ExifInterface.TAG_ORIENTATION, 0);
            if (attributeInt == 3) {
                i = 180;
            } else if (attributeInt == 6) {
                i = 90;
            } else if (attributeInt == 8) {
                i = 270;
            }
        } catch (IOException unused) {
        }
        return i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0081, code lost:
        if (r3 != null) goto L_0x0083;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0083, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x008b, code lost:
        if (r3 != null) goto L_0x0083;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:38:0x008e */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x009a  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.io.File getFromMediaUri(@org.jetbrains.annotations.NotNull android.content.Context r10, @org.jetbrains.annotations.NotNull android.content.ContentResolver r11, @org.jetbrains.annotations.Nullable android.net.Uri r12) {
        /*
            r9 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r10, r0)
            java.lang.String r0 = "resolver"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r11, r0)
            r0 = 0
            if (r12 != 0) goto L_0x000e
            return r0
        L_0x000e:
            java.lang.String r1 = SCHEME_FILE
            java.lang.String r2 = r12.getScheme()
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r2)
            if (r1 == 0) goto L_0x0024
            java.io.File r10 = new java.io.File
            java.lang.String r11 = r12.getPath()
            r10.<init>(r11)
            return r10
        L_0x0024:
            java.lang.String r1 = SCHEME_CONTENT
            java.lang.String r2 = r12.getScheme()
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r2)
            if (r1 == 0) goto L_0x009e
            java.lang.String r1 = "_display_name"
            java.lang.String r2 = "_data"
            java.lang.String[] r5 = new java.lang.String[]{r2, r1}
            r6 = 0
            r7 = 0
            r8 = 0
            r3 = r11
            r4 = r12
            android.database.Cursor r3 = r3.query(r4, r5, r6, r7, r8)     // Catch:{ IllegalArgumentException -> 0x008e, SecurityException -> 0x008a }
            if (r3 == 0) goto L_0x0081
            boolean r4 = r3.moveToFirst()     // Catch:{ IllegalArgumentException -> 0x007f, SecurityException -> 0x007d, all -> 0x007b }
            if (r4 == 0) goto L_0x0081
            java.lang.String r4 = r12.toString()     // Catch:{ IllegalArgumentException -> 0x007f, SecurityException -> 0x007d, all -> 0x007b }
            java.lang.String r5 = "uri.toString()"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r4, r5)     // Catch:{ IllegalArgumentException -> 0x007f, SecurityException -> 0x007d, all -> 0x007b }
            java.lang.String r5 = "content://com.google.android.gallery3d"
            r6 = 0
            r7 = 2
            boolean r4 = kotlin.text.StringsKt__StringsJVMKt.startsWith$default(r4, r5, r6, r7, r0)     // Catch:{ IllegalArgumentException -> 0x007f, SecurityException -> 0x007d, all -> 0x007b }
            if (r4 == 0) goto L_0x0061
            int r1 = r3.getColumnIndex(r1)     // Catch:{ IllegalArgumentException -> 0x007f, SecurityException -> 0x007d, all -> 0x007b }
            goto L_0x0065
        L_0x0061:
            int r1 = r3.getColumnIndex(r2)     // Catch:{ IllegalArgumentException -> 0x007f, SecurityException -> 0x007d, all -> 0x007b }
        L_0x0065:
            r2 = -1
            if (r1 == r2) goto L_0x0081
            java.lang.String r1 = r3.getString(r1)     // Catch:{ IllegalArgumentException -> 0x007f, SecurityException -> 0x007d, all -> 0x007b }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ IllegalArgumentException -> 0x007f, SecurityException -> 0x007d, all -> 0x007b }
            if (r2 != 0) goto L_0x0081
            java.io.File r2 = new java.io.File     // Catch:{ IllegalArgumentException -> 0x007f, SecurityException -> 0x007d, all -> 0x007b }
            r2.<init>(r1)     // Catch:{ IllegalArgumentException -> 0x007f, SecurityException -> 0x007d, all -> 0x007b }
            r3.close()
            return r2
        L_0x007b:
            r10 = move-exception
            goto L_0x0098
        L_0x007d:
            goto L_0x008b
        L_0x007f:
            r0 = r3
            goto L_0x008e
        L_0x0081:
            if (r3 == 0) goto L_0x009e
        L_0x0083:
            r3.close()
            goto L_0x009e
        L_0x0087:
            r10 = move-exception
            r3 = r0
            goto L_0x0098
        L_0x008a:
            r3 = r0
        L_0x008b:
            if (r3 == 0) goto L_0x009e
            goto L_0x0083
        L_0x008e:
            java.io.File r10 = r9.getFromMediaUriPfd(r10, r11, r12)     // Catch:{ all -> 0x0087 }
            if (r0 == 0) goto L_0x0097
            r0.close()
        L_0x0097:
            return r10
        L_0x0098:
            if (r3 == 0) goto L_0x009d
            r3.close()
        L_0x009d:
            throw r10
        L_0x009e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: photopicker.utils.CropUtil.getFromMediaUri(android.content.Context, android.content.ContentResolver, android.net.Uri):java.io.File");
    }

    private final String getTempFilename(Context context) throws IOException {
        File createTempFile = File.createTempFile(MessengerShareContentUtility.MEDIA_IMAGE, "tmp", context.getCacheDir());
        Intrinsics.checkExpressionValueIsNotNull(createTempFile, "outputFile");
        String absolutePath = createTempFile.getAbsolutePath();
        Intrinsics.checkExpressionValueIsNotNull(absolutePath, "outputFile.absolutePath");
        return absolutePath;
    }

    private final File getFromMediaUriPfd(Context context, ContentResolver contentResolver, Uri uri) {
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        if (uri == null) {
            return null;
        }
        try {
            ParcelFileDescriptor openFileDescriptor = contentResolver.openFileDescriptor(uri, "r");
            if (openFileDescriptor == null) {
                Intrinsics.throwNpe();
            }
            fileInputStream = new FileInputStream(openFileDescriptor.getFileDescriptor());
            try {
                String tempFilename = getTempFilename(context);
                fileOutputStream = new FileOutputStream(tempFilename);
                try {
                    byte[] bArr = new byte[4096];
                    int read = fileInputStream.read(bArr);
                    while (read != -1) {
                        fileOutputStream.write(bArr, 0, read);
                    }
                    File file = new File(tempFilename);
                    closeSilently(fileInputStream);
                    closeSilently(fileOutputStream);
                    return file;
                } catch (IOException unused) {
                    closeSilently(fileInputStream);
                    closeSilently(fileOutputStream);
                    return null;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream2 = fileOutputStream;
                    closeSilently(fileInputStream);
                    closeSilently(fileOutputStream2);
                    throw th;
                }
            } catch (IOException unused2) {
                fileOutputStream = null;
                closeSilently(fileInputStream);
                closeSilently(fileOutputStream);
                return null;
            } catch (Throwable th2) {
                th = th2;
                closeSilently(fileInputStream);
                closeSilently(fileOutputStream2);
                throw th;
            }
        } catch (IOException unused3) {
            fileOutputStream = null;
            fileInputStream = null;
            closeSilently(fileInputStream);
            closeSilently(fileOutputStream);
            return null;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            closeSilently(fileInputStream);
            closeSilently(fileOutputStream2);
            throw th;
        }
    }
}
