package io.fabric.sdk.android.services.events;

import android.content.Context;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.CurrentTimeProvider;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class EventsFilesManager<T> {
    public static final int MAX_BYTE_SIZE_PER_FILE = 8000;
    public static final int MAX_FILES_IN_BATCH = 1;
    public static final int MAX_FILES_TO_KEEP = 100;
    public static final String ROLL_OVER_FILE_NAME_SEPARATOR = "_";
    protected final Context context;
    protected final CurrentTimeProvider currentTimeProvider;
    private final int defaultMaxFilesToKeep;
    protected final EventsStorage eventStorage;
    protected volatile long lastRollOverTime;
    protected final List<EventsStorageListener> rollOverListeners = new CopyOnWriteArrayList();
    protected final EventTransform<T> transform;

    static class FileWithTimestamp {
        final File file;
        final long timestamp;

        public FileWithTimestamp(File file2, long j) {
            this.file = file2;
            this.timestamp = j;
        }
    }

    /* access modifiers changed from: protected */
    public abstract String generateUniqueRollOverFileName();

    /* access modifiers changed from: protected */
    public int getMaxByteSizePerFile() {
        return 8000;
    }

    public EventsFilesManager(Context context2, EventTransform<T> eventTransform, CurrentTimeProvider currentTimeProvider2, EventsStorage eventsStorage, int i) throws IOException {
        this.context = context2.getApplicationContext();
        this.transform = eventTransform;
        this.eventStorage = eventsStorage;
        this.currentTimeProvider = currentTimeProvider2;
        this.lastRollOverTime = this.currentTimeProvider.getCurrentTimeMillis();
        this.defaultMaxFilesToKeep = i;
    }

    public void writeEvent(T t) throws IOException {
        byte[] bytes = this.transform.toBytes(t);
        rollFileOverIfNeeded(bytes.length);
        this.eventStorage.add(bytes);
    }

    public void registerRollOverListener(EventsStorageListener eventsStorageListener) {
        if (eventsStorageListener != null) {
            this.rollOverListeners.add(eventsStorageListener);
        }
    }

    public boolean rollFileOver() throws IOException {
        String str;
        boolean z = true;
        if (!this.eventStorage.isWorkingFileEmpty()) {
            str = generateUniqueRollOverFileName();
            this.eventStorage.rollOver(str);
            CommonUtils.logControlled(this.context, 4, Fabric.TAG, String.format(Locale.US, "generated new file %s", new Object[]{str}));
            this.lastRollOverTime = this.currentTimeProvider.getCurrentTimeMillis();
        } else {
            str = null;
            z = false;
        }
        triggerRollOverOnListeners(str);
        return z;
    }

    private void rollFileOverIfNeeded(int i) throws IOException {
        if (!this.eventStorage.canWorkingFileStore(i, getMaxByteSizePerFile())) {
            CommonUtils.logControlled(this.context, 4, Fabric.TAG, String.format(Locale.US, "session analytics events file is %d bytes, new event is %d bytes, this is over flush limit of %d, rolling it over", new Object[]{Integer.valueOf(this.eventStorage.getWorkingFileUsedSizeInBytes()), Integer.valueOf(i), Integer.valueOf(getMaxByteSizePerFile())}));
            rollFileOver();
        }
    }

    /* access modifiers changed from: protected */
    public int getMaxFilesToKeep() {
        return this.defaultMaxFilesToKeep;
    }

    public long getLastRollOverTime() {
        return this.lastRollOverTime;
    }

    private void triggerRollOverOnListeners(String str) {
        for (EventsStorageListener onRollOver : this.rollOverListeners) {
            try {
                onRollOver.onRollOver(str);
            } catch (Exception e) {
                CommonUtils.logControlledError(this.context, "One of the roll over listeners threw an exception", e);
            }
        }
    }

    public List<File> getBatchOfFilesToSend() {
        return this.eventStorage.getBatchOfFilesToSend(1);
    }

    public void deleteSentFiles(List<File> list) {
        this.eventStorage.deleteFilesInRollOverDirectory(list);
    }

    public void deleteAllEventsFiles() {
        EventsStorage eventsStorage = this.eventStorage;
        eventsStorage.deleteFilesInRollOverDirectory(eventsStorage.getAllFilesInRollOverDirectory());
        this.eventStorage.deleteWorkingFile();
    }

    public void deleteOldestInRollOverIfOverMax() {
        List<File> allFilesInRollOverDirectory = this.eventStorage.getAllFilesInRollOverDirectory();
        int maxFilesToKeep = getMaxFilesToKeep();
        if (allFilesInRollOverDirectory.size() > maxFilesToKeep) {
            int size = allFilesInRollOverDirectory.size() - maxFilesToKeep;
            CommonUtils.logControlled(this.context, String.format(Locale.US, "Found %d files in  roll over directory, this is greater than %d, deleting %d oldest files", new Object[]{Integer.valueOf(allFilesInRollOverDirectory.size()), Integer.valueOf(maxFilesToKeep), Integer.valueOf(size)}));
            TreeSet treeSet = new TreeSet(new Comparator<FileWithTimestamp>(this) {
                public int compare(FileWithTimestamp fileWithTimestamp, FileWithTimestamp fileWithTimestamp2) {
                    return (int) (fileWithTimestamp.timestamp - fileWithTimestamp2.timestamp);
                }
            });
            for (File file : allFilesInRollOverDirectory) {
                treeSet.add(new FileWithTimestamp(file, parseCreationTimestampFromFileName(file.getName())));
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = treeSet.iterator();
            while (it.hasNext()) {
                arrayList.add(((FileWithTimestamp) it.next()).file);
                if (arrayList.size() == size) {
                    break;
                }
            }
            this.eventStorage.deleteFilesInRollOverDirectory(arrayList);
        }
    }

    public long parseCreationTimestampFromFileName(String str) {
        String[] split = str.split("_");
        if (split.length != 3) {
            return 0;
        }
        try {
            return Long.valueOf(split[2]).longValue();
        } catch (NumberFormatException unused) {
            return 0;
        }
    }
}
