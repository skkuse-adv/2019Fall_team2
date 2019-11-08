package com.facebook.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.facebook.internal.ImageRequest.Callback;
import com.facebook.internal.WorkQueue.WorkItem;
import java.util.HashMap;
import java.util.Map;

public class ImageDownloader {
    private static WorkQueue cacheReadQueue = new WorkQueue(2);
    private static WorkQueue downloadQueue = new WorkQueue(8);
    private static Handler handler;
    private static final Map<RequestKey, DownloaderContext> pendingRequests = new HashMap();

    private static class CacheReadWorkItem implements Runnable {
        private boolean allowCachedRedirects;
        private Context context;
        private RequestKey key;

        CacheReadWorkItem(Context context2, RequestKey requestKey, boolean z) {
            this.context = context2;
            this.key = requestKey;
            this.allowCachedRedirects = z;
        }

        public void run() {
            ImageDownloader.readFromCache(this.key, this.context, this.allowCachedRedirects);
        }
    }

    private static class DownloadImageWorkItem implements Runnable {
        private Context context;
        private RequestKey key;

        DownloadImageWorkItem(Context context2, RequestKey requestKey) {
            this.context = context2;
            this.key = requestKey;
        }

        public void run() {
            ImageDownloader.download(this.key, this.context);
        }
    }

    private static class DownloaderContext {
        boolean isCancelled;
        ImageRequest request;
        WorkItem workItem;

        private DownloaderContext() {
        }
    }

    private static class RequestKey {
        Object tag;
        Uri uri;

        RequestKey(Uri uri2, Object obj) {
            this.uri = uri2;
            this.tag = obj;
        }

        public int hashCode() {
            return ((1073 + this.uri.hashCode()) * 37) + this.tag.hashCode();
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof RequestKey)) {
                return false;
            }
            RequestKey requestKey = (RequestKey) obj;
            if (requestKey.uri == this.uri && requestKey.tag == this.tag) {
                return true;
            }
            return false;
        }
    }

    public static void downloadAsync(ImageRequest imageRequest) {
        if (imageRequest != null) {
            RequestKey requestKey = new RequestKey(imageRequest.getImageUri(), imageRequest.getCallerTag());
            synchronized (pendingRequests) {
                DownloaderContext downloaderContext = (DownloaderContext) pendingRequests.get(requestKey);
                if (downloaderContext != null) {
                    downloaderContext.request = imageRequest;
                    downloaderContext.isCancelled = false;
                    downloaderContext.workItem.moveToFront();
                } else {
                    enqueueCacheRead(imageRequest, requestKey, imageRequest.isCachedRedirectAllowed());
                }
            }
        }
    }

    public static boolean cancelRequest(ImageRequest imageRequest) {
        boolean z;
        RequestKey requestKey = new RequestKey(imageRequest.getImageUri(), imageRequest.getCallerTag());
        synchronized (pendingRequests) {
            DownloaderContext downloaderContext = (DownloaderContext) pendingRequests.get(requestKey);
            z = true;
            if (downloaderContext == null) {
                z = false;
            } else if (downloaderContext.workItem.cancel()) {
                pendingRequests.remove(requestKey);
            } else {
                downloaderContext.isCancelled = true;
            }
        }
        return z;
    }

    public static void prioritizeRequest(ImageRequest imageRequest) {
        RequestKey requestKey = new RequestKey(imageRequest.getImageUri(), imageRequest.getCallerTag());
        synchronized (pendingRequests) {
            DownloaderContext downloaderContext = (DownloaderContext) pendingRequests.get(requestKey);
            if (downloaderContext != null) {
                downloaderContext.workItem.moveToFront();
            }
        }
    }

    public static void clearCache(Context context) {
        ImageResponseCache.clearCache(context);
        UrlRedirectCache.clearCache();
    }

    private static void enqueueCacheRead(ImageRequest imageRequest, RequestKey requestKey, boolean z) {
        enqueueRequest(imageRequest, requestKey, cacheReadQueue, new CacheReadWorkItem(imageRequest.getContext(), requestKey, z));
    }

    private static void enqueueDownload(ImageRequest imageRequest, RequestKey requestKey) {
        enqueueRequest(imageRequest, requestKey, downloadQueue, new DownloadImageWorkItem(imageRequest.getContext(), requestKey));
    }

    private static void enqueueRequest(ImageRequest imageRequest, RequestKey requestKey, WorkQueue workQueue, Runnable runnable) {
        synchronized (pendingRequests) {
            DownloaderContext downloaderContext = new DownloaderContext();
            downloaderContext.request = imageRequest;
            pendingRequests.put(requestKey, downloaderContext);
            downloaderContext.workItem = workQueue.addActiveWorkItem(runnable);
        }
    }

    private static void issueResponse(RequestKey requestKey, Exception exc, Bitmap bitmap, boolean z) {
        DownloaderContext removePendingRequest = removePendingRequest(requestKey);
        if (removePendingRequest != null && !removePendingRequest.isCancelled) {
            final ImageRequest imageRequest = removePendingRequest.request;
            final Callback callback = imageRequest.getCallback();
            if (callback != null) {
                Handler handler2 = getHandler();
                final Exception exc2 = exc;
                final boolean z2 = z;
                final Bitmap bitmap2 = bitmap;
                AnonymousClass1 r1 = new Runnable() {
                    public void run() {
                        callback.onCompleted(new ImageResponse(imageRequest, exc2, z2, bitmap2));
                    }
                };
                handler2.post(r1);
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x001f  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x002a  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0017  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void readFromCache(com.facebook.internal.ImageDownloader.RequestKey r2, android.content.Context r3, boolean r4) {
        /*
            r0 = 0
            r1 = 0
            if (r4 == 0) goto L_0x0014
            android.net.Uri r4 = r2.uri
            android.net.Uri r4 = com.facebook.internal.UrlRedirectCache.getRedirectedUri(r4)
            if (r4 == 0) goto L_0x0014
            java.io.InputStream r4 = com.facebook.internal.ImageResponseCache.getCachedImageStream(r4, r3)
            if (r4 == 0) goto L_0x0015
            r0 = 1
            goto L_0x0015
        L_0x0014:
            r4 = r1
        L_0x0015:
            if (r0 != 0) goto L_0x001d
            android.net.Uri r4 = r2.uri
            java.io.InputStream r4 = com.facebook.internal.ImageResponseCache.getCachedImageStream(r4, r3)
        L_0x001d:
            if (r4 == 0) goto L_0x002a
            android.graphics.Bitmap r3 = android.graphics.BitmapFactory.decodeStream(r4)
            com.facebook.internal.Utility.closeQuietly(r4)
            issueResponse(r2, r1, r3, r0)
            goto L_0x0039
        L_0x002a:
            com.facebook.internal.ImageDownloader$DownloaderContext r3 = removePendingRequest(r2)
            if (r3 == 0) goto L_0x0039
            boolean r4 = r3.isCancelled
            if (r4 != 0) goto L_0x0039
            com.facebook.internal.ImageRequest r3 = r3.request
            enqueueDownload(r3, r2)
        L_0x0039:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.ImageDownloader.readFromCache(com.facebook.internal.ImageDownloader$RequestKey, android.content.Context, boolean):void");
    }

    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v1, types: [java.lang.Exception] */
    /* JADX WARNING: type inference failed for: r10v1, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r4v1 */
    /* JADX WARNING: type inference failed for: r8v0 */
    /* JADX WARNING: type inference failed for: r0v2 */
    /* JADX WARNING: type inference failed for: r4v3, types: [java.io.IOException] */
    /* JADX WARNING: type inference failed for: r10v2 */
    /* JADX WARNING: type inference failed for: r0v3, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r4v6, types: [java.io.IOException] */
    /* JADX WARNING: type inference failed for: r10v3 */
    /* JADX WARNING: type inference failed for: r10v4, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: type inference failed for: r10v5, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r10v6 */
    /* JADX WARNING: type inference failed for: r4v10, types: [java.io.IOException] */
    /* JADX WARNING: type inference failed for: r10v7 */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: type inference failed for: r4v11, types: [java.io.IOException] */
    /* JADX WARNING: type inference failed for: r10v10 */
    /* JADX WARNING: type inference failed for: r10v12 */
    /* JADX WARNING: type inference failed for: r10v15, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r5v2, types: [com.facebook.FacebookException] */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: type inference failed for: r0v7 */
    /* JADX WARNING: type inference failed for: r0v8 */
    /* JADX WARNING: type inference failed for: r0v9 */
    /* JADX WARNING: type inference failed for: r0v10 */
    /* JADX WARNING: type inference failed for: r4v18 */
    /* JADX WARNING: type inference failed for: r4v19 */
    /* JADX WARNING: type inference failed for: r0v11 */
    /* JADX WARNING: type inference failed for: r10v16 */
    /* JADX WARNING: type inference failed for: r10v17 */
    /* JADX WARNING: type inference failed for: r10v18 */
    /* JADX WARNING: type inference failed for: r10v19 */
    /* JADX WARNING: type inference failed for: r4v20 */
    /* JADX WARNING: type inference failed for: r4v21 */
    /* JADX WARNING: type inference failed for: r10v20 */
    /* JADX WARNING: type inference failed for: r10v21 */
    /* JADX WARNING: type inference failed for: r10v22 */
    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0095, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0096, code lost:
        r10 = 0;
        r2 = false;
        r4 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00a8, code lost:
        r9 = th;
        r0 = r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r0v4
  assigns: []
  uses: []
  mth insns count: 99
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1507)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1507)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00a8 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:3:0x001a] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown variable types count: 17 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void download(com.facebook.internal.ImageDownloader.RequestKey r9, android.content.Context r10) {
        /*
            r0 = 0
            r1 = 0
            r2 = 1
            java.net.URL r3 = new java.net.URL     // Catch:{ IOException -> 0x00b6, all -> 0x00ad }
            android.net.Uri r4 = r9.uri     // Catch:{ IOException -> 0x00b6, all -> 0x00ad }
            java.lang.String r4 = r4.toString()     // Catch:{ IOException -> 0x00b6, all -> 0x00ad }
            r3.<init>(r4)     // Catch:{ IOException -> 0x00b6, all -> 0x00ad }
            java.net.URLConnection r3 = r3.openConnection()     // Catch:{ IOException -> 0x00b6, all -> 0x00ad }
            java.lang.Object r3 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r3)     // Catch:{ IOException -> 0x00b6, all -> 0x00ad }
            java.net.URLConnection r3 = (java.net.URLConnection) r3     // Catch:{ IOException -> 0x00b6, all -> 0x00ad }
            java.net.HttpURLConnection r3 = (java.net.HttpURLConnection) r3     // Catch:{ IOException -> 0x00b6, all -> 0x00ad }
            r3.setInstanceFollowRedirects(r1)     // Catch:{ IOException -> 0x00aa, all -> 0x00a8 }
            int r4 = r3.getResponseCode()     // Catch:{ IOException -> 0x00aa, all -> 0x00a8 }
            r5 = 200(0xc8, float:2.8E-43)
            if (r4 == r5) goto L_0x0099
            r10 = 301(0x12d, float:4.22E-43)
            if (r4 == r10) goto L_0x0066
            r10 = 302(0x12e, float:4.23E-43)
            if (r4 == r10) goto L_0x0066
            java.io.InputStream r10 = r3.getErrorStream()     // Catch:{ IOException -> 0x00aa, all -> 0x00a8 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0064, all -> 0x0061 }
            r4.<init>()     // Catch:{ IOException -> 0x0064, all -> 0x0061 }
            if (r10 == 0) goto L_0x0050
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0064, all -> 0x0061 }
            r5.<init>(r10)     // Catch:{ IOException -> 0x0064, all -> 0x0061 }
            r6 = 128(0x80, float:1.794E-43)
            char[] r6 = new char[r6]     // Catch:{ IOException -> 0x0064, all -> 0x0061 }
        L_0x0041:
            int r7 = r6.length     // Catch:{ IOException -> 0x0064, all -> 0x0061 }
            int r7 = r5.read(r6, r1, r7)     // Catch:{ IOException -> 0x0064, all -> 0x0061 }
            if (r7 <= 0) goto L_0x004c
            r4.append(r6, r1, r7)     // Catch:{ IOException -> 0x0064, all -> 0x0061 }
            goto L_0x0041
        L_0x004c:
            com.facebook.internal.Utility.closeQuietly(r5)     // Catch:{ IOException -> 0x0064, all -> 0x0061 }
            goto L_0x0055
        L_0x0050:
            java.lang.String r5 = "Unexpected error while downloading an image."
            r4.append(r5)     // Catch:{ IOException -> 0x0064, all -> 0x0061 }
        L_0x0055:
            com.facebook.FacebookException r5 = new com.facebook.FacebookException     // Catch:{ IOException -> 0x0064, all -> 0x0061 }
            java.lang.String r4 = r4.toString()     // Catch:{ IOException -> 0x0064, all -> 0x0061 }
            r5.<init>(r4)     // Catch:{ IOException -> 0x0064, all -> 0x0061 }
            r4 = r0
            r0 = r5
            goto L_0x00a1
        L_0x0061:
            r9 = move-exception
            r0 = r10
            goto L_0x00af
        L_0x0064:
            r4 = move-exception
            goto L_0x00b9
        L_0x0066:
            java.lang.String r10 = "location"
            java.lang.String r10 = r3.getHeaderField(r10)     // Catch:{ IOException -> 0x0095, all -> 0x00a8 }
            boolean r2 = com.facebook.internal.Utility.isNullOrEmpty(r10)     // Catch:{ IOException -> 0x0095, all -> 0x00a8 }
            if (r2 != 0) goto L_0x0091
            android.net.Uri r10 = android.net.Uri.parse(r10)     // Catch:{ IOException -> 0x0095, all -> 0x00a8 }
            android.net.Uri r2 = r9.uri     // Catch:{ IOException -> 0x0095, all -> 0x00a8 }
            com.facebook.internal.UrlRedirectCache.cacheUriRedirect(r2, r10)     // Catch:{ IOException -> 0x0095, all -> 0x00a8 }
            com.facebook.internal.ImageDownloader$DownloaderContext r2 = removePendingRequest(r9)     // Catch:{ IOException -> 0x0095, all -> 0x00a8 }
            if (r2 == 0) goto L_0x0091
            boolean r4 = r2.isCancelled     // Catch:{ IOException -> 0x0095, all -> 0x00a8 }
            if (r4 != 0) goto L_0x0091
            com.facebook.internal.ImageRequest r2 = r2.request     // Catch:{ IOException -> 0x0095, all -> 0x00a8 }
            com.facebook.internal.ImageDownloader$RequestKey r4 = new com.facebook.internal.ImageDownloader$RequestKey     // Catch:{ IOException -> 0x0095, all -> 0x00a8 }
            java.lang.Object r5 = r9.tag     // Catch:{ IOException -> 0x0095, all -> 0x00a8 }
            r4.<init>(r10, r5)     // Catch:{ IOException -> 0x0095, all -> 0x00a8 }
            enqueueCacheRead(r2, r4, r1)     // Catch:{ IOException -> 0x0095, all -> 0x00a8 }
        L_0x0091:
            r10 = r0
            r4 = r10
            r2 = 0
            goto L_0x00a1
        L_0x0095:
            r4 = move-exception
            r10 = r0
            r2 = 0
            goto L_0x00b9
        L_0x0099:
            java.io.InputStream r10 = com.facebook.internal.ImageResponseCache.interceptAndCacheImageStream(r10, r3)     // Catch:{ IOException -> 0x00aa, all -> 0x00a8 }
            android.graphics.Bitmap r4 = android.graphics.BitmapFactory.decodeStream(r10)     // Catch:{ IOException -> 0x0064, all -> 0x0061 }
        L_0x00a1:
            com.facebook.internal.Utility.closeQuietly(r10)
            com.facebook.internal.Utility.disconnectQuietly(r3)
            goto L_0x00c2
        L_0x00a8:
            r9 = move-exception
            goto L_0x00af
        L_0x00aa:
            r4 = move-exception
            r10 = r0
            goto L_0x00b9
        L_0x00ad:
            r9 = move-exception
            r3 = r0
        L_0x00af:
            com.facebook.internal.Utility.closeQuietly(r0)
            com.facebook.internal.Utility.disconnectQuietly(r3)
            throw r9
        L_0x00b6:
            r4 = move-exception
            r10 = r0
            r3 = r10
        L_0x00b9:
            com.facebook.internal.Utility.closeQuietly(r10)
            com.facebook.internal.Utility.disconnectQuietly(r3)
            r8 = r4
            r4 = r0
            r0 = r8
        L_0x00c2:
            if (r2 == 0) goto L_0x00c7
            issueResponse(r9, r0, r4, r1)
        L_0x00c7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.ImageDownloader.download(com.facebook.internal.ImageDownloader$RequestKey, android.content.Context):void");
    }

    private static synchronized Handler getHandler() {
        Handler handler2;
        synchronized (ImageDownloader.class) {
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
            }
            handler2 = handler;
        }
        return handler2;
    }

    private static DownloaderContext removePendingRequest(RequestKey requestKey) {
        DownloaderContext downloaderContext;
        synchronized (pendingRequests) {
            downloaderContext = (DownloaderContext) pendingRequests.remove(requestKey);
        }
        return downloaderContext;
    }
}
