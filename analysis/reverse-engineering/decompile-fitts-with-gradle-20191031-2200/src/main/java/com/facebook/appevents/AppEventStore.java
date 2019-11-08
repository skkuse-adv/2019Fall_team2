package com.facebook.appevents;

import com.facebook.appevents.internal.AppEventUtility;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;

class AppEventStore {

    private static class MovedClassObjectInputStream extends ObjectInputStream {
        public MovedClassObjectInputStream(InputStream inputStream) throws IOException {
            super(inputStream);
        }

        /* access modifiers changed from: protected */
        public ObjectStreamClass readClassDescriptor() throws IOException, ClassNotFoundException {
            ObjectStreamClass readClassDescriptor = super.readClassDescriptor();
            if (readClassDescriptor.getName().equals("com.facebook.appevents.AppEventsLogger$AccessTokenAppIdPair$SerializationProxyV1")) {
                return ObjectStreamClass.lookup(SerializationProxyV1.class);
            }
            return readClassDescriptor.getName().equals("com.facebook.appevents.AppEventsLogger$AppEvent$SerializationProxyV1") ? ObjectStreamClass.lookup(SerializationProxyV1.class) : readClassDescriptor;
        }
    }

    AppEventStore() {
    }

    public static synchronized void persistEvents(AccessTokenAppIdPair accessTokenAppIdPair, SessionEventsState sessionEventsState) {
        synchronized (AppEventStore.class) {
            AppEventUtility.assertIsNotMainThread();
            PersistedEvents readAndClearStore = readAndClearStore();
            if (readAndClearStore.containsKey(accessTokenAppIdPair)) {
                readAndClearStore.get(accessTokenAppIdPair).addAll(sessionEventsState.getEventsToPersist());
            } else {
                readAndClearStore.addEvents(accessTokenAppIdPair, sessionEventsState.getEventsToPersist());
            }
            saveEventsToDisk(readAndClearStore);
        }
    }

    public static synchronized void persistEvents(AppEventCollection appEventCollection) {
        synchronized (AppEventStore.class) {
            AppEventUtility.assertIsNotMainThread();
            PersistedEvents readAndClearStore = readAndClearStore();
            for (AccessTokenAppIdPair accessTokenAppIdPair : appEventCollection.keySet()) {
                readAndClearStore.addEvents(accessTokenAppIdPair, appEventCollection.get(accessTokenAppIdPair).getEventsToPersist());
            }
            saveEventsToDisk(readAndClearStore);
        }
    }

    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r4v0, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r4v1 */
    /* JADX WARNING: type inference failed for: r4v2, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r4v3 */
    /* JADX WARNING: type inference failed for: r2v4, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r4v4, types: [com.facebook.appevents.AppEventStore$MovedClassObjectInputStream, java.io.Closeable, java.io.ObjectInputStream] */
    /* JADX WARNING: type inference failed for: r2v7 */
    /* JADX WARNING: type inference failed for: r2v12 */
    /* JADX WARNING: type inference failed for: r4v5 */
    /* JADX WARNING: type inference failed for: r4v6 */
    /* JADX WARNING: type inference failed for: r4v7 */
    /* JADX WARNING: Can't wrap try/catch for region: R(9:16|17|19|20|21|22|23|24|25) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x0040 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x0052 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x005e A[SYNTHETIC, Splitter:B:43:0x005e] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:24:0x0040=Splitter:B:24:0x0040, B:37:0x0052=Splitter:B:37:0x0052, B:19:0x0034=Splitter:B:19:0x0034} */
    /* JADX WARNING: Unknown variable types count: 5 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized com.facebook.appevents.PersistedEvents readAndClearStore() {
        /*
            java.lang.Class<com.facebook.appevents.AppEventStore> r0 = com.facebook.appevents.AppEventStore.class
            monitor-enter(r0)
            com.facebook.appevents.internal.AppEventUtility.assertIsNotMainThread()     // Catch:{ all -> 0x0065 }
            android.content.Context r1 = com.facebook.FacebookSdk.getApplicationContext()     // Catch:{ all -> 0x0065 }
            r2 = 0
            java.lang.String r3 = "AppEventsLogger.persistedevents"
            java.io.FileInputStream r3 = r1.openFileInput(r3)     // Catch:{ FileNotFoundException -> 0x0051, Exception -> 0x0041, all -> 0x0033 }
            com.facebook.appevents.AppEventStore$MovedClassObjectInputStream r4 = new com.facebook.appevents.AppEventStore$MovedClassObjectInputStream     // Catch:{ FileNotFoundException -> 0x0051, Exception -> 0x0041, all -> 0x0033 }
            java.io.BufferedInputStream r5 = new java.io.BufferedInputStream     // Catch:{ FileNotFoundException -> 0x0051, Exception -> 0x0041, all -> 0x0033 }
            r5.<init>(r3)     // Catch:{ FileNotFoundException -> 0x0051, Exception -> 0x0041, all -> 0x0033 }
            r4.<init>(r5)     // Catch:{ FileNotFoundException -> 0x0051, Exception -> 0x0041, all -> 0x0033 }
            java.lang.Object r3 = r4.readObject()     // Catch:{ FileNotFoundException -> 0x0052, Exception -> 0x0042, all -> 0x002f }
            com.facebook.appevents.PersistedEvents r3 = (com.facebook.appevents.PersistedEvents) r3     // Catch:{ FileNotFoundException -> 0x0052, Exception -> 0x0042, all -> 0x002f }
            com.facebook.internal.Utility.closeQuietly(r4)     // Catch:{ all -> 0x0065 }
            java.lang.String r2 = "AppEventsLogger.persistedevents"
            java.io.File r1 = r1.getFileStreamPath(r2)     // Catch:{ Exception -> 0x002d }
            r1.delete()     // Catch:{ Exception -> 0x002d }
        L_0x002d:
            r2 = r3
            goto L_0x005c
        L_0x002f:
            r2 = move-exception
            r3 = r2
            r2 = r4
            goto L_0x0034
        L_0x0033:
            r3 = move-exception
        L_0x0034:
            com.facebook.internal.Utility.closeQuietly(r2)     // Catch:{ all -> 0x0065 }
            java.lang.String r2 = "AppEventsLogger.persistedevents"
            java.io.File r1 = r1.getFileStreamPath(r2)     // Catch:{ Exception -> 0x0040 }
            r1.delete()     // Catch:{ Exception -> 0x0040 }
        L_0x0040:
            throw r3     // Catch:{ all -> 0x0065 }
        L_0x0041:
            r4 = r2
        L_0x0042:
            com.facebook.internal.Utility.closeQuietly(r4)     // Catch:{ all -> 0x0065 }
            java.lang.String r3 = "AppEventsLogger.persistedevents"
            java.io.File r1 = r1.getFileStreamPath(r3)     // Catch:{ Exception -> 0x004f }
        L_0x004b:
            r1.delete()     // Catch:{ Exception -> 0x004f }
            goto L_0x005c
        L_0x004f:
            goto L_0x005c
        L_0x0051:
            r4 = r2
        L_0x0052:
            com.facebook.internal.Utility.closeQuietly(r4)     // Catch:{ all -> 0x0065 }
            java.lang.String r3 = "AppEventsLogger.persistedevents"
            java.io.File r1 = r1.getFileStreamPath(r3)     // Catch:{ Exception -> 0x004f }
            goto L_0x004b
        L_0x005c:
            if (r2 != 0) goto L_0x0063
            com.facebook.appevents.PersistedEvents r2 = new com.facebook.appevents.PersistedEvents     // Catch:{ all -> 0x0065 }
            r2.<init>()     // Catch:{ all -> 0x0065 }
        L_0x0063:
            monitor-exit(r0)
            return r2
        L_0x0065:
            r1 = move-exception
            monitor-exit(r0)
            goto L_0x0069
        L_0x0068:
            throw r1
        L_0x0069:
            goto L_0x0068
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.AppEventStore.readAndClearStore():com.facebook.appevents.PersistedEvents");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0022, code lost:
        r6 = th;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0024 */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0022 A[ExcHandler: all (th java.lang.Throwable), PHI: r2 
  PHI: (r2v3 java.io.ObjectOutputStream) = (r2v0 java.io.ObjectOutputStream), (r2v2 java.io.ObjectOutputStream), (r2v2 java.io.ObjectOutputStream), (r2v0 java.io.ObjectOutputStream) binds: [B:1:0x0007, B:11:0x0024, B:12:?, B:2:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:1:0x0007] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void saveEventsToDisk(com.facebook.appevents.PersistedEvents r6) {
        /*
            java.lang.String r0 = "AppEventsLogger.persistedevents"
            android.content.Context r1 = com.facebook.FacebookSdk.getApplicationContext()
            r2 = 0
            java.io.ObjectOutputStream r3 = new java.io.ObjectOutputStream     // Catch:{ Exception -> 0x0024, all -> 0x0022 }
            java.io.BufferedOutputStream r4 = new java.io.BufferedOutputStream     // Catch:{ Exception -> 0x0024, all -> 0x0022 }
            r5 = 0
            java.io.FileOutputStream r5 = r1.openFileOutput(r0, r5)     // Catch:{ Exception -> 0x0024, all -> 0x0022 }
            r4.<init>(r5)     // Catch:{ Exception -> 0x0024, all -> 0x0022 }
            r3.<init>(r4)     // Catch:{ Exception -> 0x0024, all -> 0x0022 }
            r3.writeObject(r6)     // Catch:{ Exception -> 0x0020, all -> 0x001d }
            com.facebook.internal.Utility.closeQuietly(r3)
            goto L_0x0033
        L_0x001d:
            r6 = move-exception
            r2 = r3
            goto L_0x002c
        L_0x0020:
            r2 = r3
            goto L_0x0024
        L_0x0022:
            r6 = move-exception
            goto L_0x002c
        L_0x0024:
            java.io.File r6 = r1.getFileStreamPath(r0)     // Catch:{ Exception -> 0x0030, all -> 0x0022 }
            r6.delete()     // Catch:{ Exception -> 0x0030, all -> 0x0022 }
            goto L_0x0030
        L_0x002c:
            com.facebook.internal.Utility.closeQuietly(r2)
            throw r6
        L_0x0030:
            com.facebook.internal.Utility.closeQuietly(r2)
        L_0x0033:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.AppEventStore.saveEventsToDisk(com.facebook.appevents.PersistedEvents):void");
    }
}
