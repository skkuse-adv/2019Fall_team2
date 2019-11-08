package com.facebook;

import android.os.Handler;
import com.facebook.GraphRequest.Callback;
import com.facebook.GraphRequest.OnProgressCallback;

class RequestProgress {
    private final Handler callbackHandler;
    private long lastReportedProgress;
    private long maxProgress;
    private long progress;
    private final GraphRequest request;
    private final long threshold = FacebookSdk.getOnProgressThreshold();

    RequestProgress(Handler handler, GraphRequest graphRequest) {
        this.request = graphRequest;
        this.callbackHandler = handler;
    }

    /* access modifiers changed from: 0000 */
    public void addProgress(long j) {
        this.progress += j;
        long j2 = this.progress;
        if (j2 >= this.lastReportedProgress + this.threshold || j2 >= this.maxProgress) {
            reportProgress();
        }
    }

    /* access modifiers changed from: 0000 */
    public void addToMax(long j) {
        this.maxProgress += j;
    }

    /* access modifiers changed from: 0000 */
    public void reportProgress() {
        if (this.progress > this.lastReportedProgress) {
            Callback callback = this.request.getCallback();
            final long j = this.maxProgress;
            if (j > 0 && (callback instanceof OnProgressCallback)) {
                final long j2 = this.progress;
                final OnProgressCallback onProgressCallback = (OnProgressCallback) callback;
                Handler handler = this.callbackHandler;
                if (handler == null) {
                    onProgressCallback.onProgress(j2, j);
                } else {
                    AnonymousClass1 r1 = new Runnable(this) {
                        public void run() {
                            onProgressCallback.onProgress(j2, j);
                        }
                    };
                    handler.post(r1);
                }
                this.lastReportedProgress = this.progress;
            }
        }
    }
}
