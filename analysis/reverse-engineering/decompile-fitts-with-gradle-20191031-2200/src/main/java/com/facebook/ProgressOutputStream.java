package com.facebook;

import android.os.Handler;
import com.facebook.GraphRequestBatch.Callback;
import com.facebook.GraphRequestBatch.OnProgressCallback;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

class ProgressOutputStream extends FilterOutputStream implements RequestOutputStream {
    /* access modifiers changed from: private */
    public long batchProgress;
    private RequestProgress currentRequestProgress;
    private long lastReportedProgress;
    /* access modifiers changed from: private */
    public long maxProgress;
    private final Map<GraphRequest, RequestProgress> progressMap;
    /* access modifiers changed from: private */
    public final GraphRequestBatch requests;
    private final long threshold = FacebookSdk.getOnProgressThreshold();

    ProgressOutputStream(OutputStream outputStream, GraphRequestBatch graphRequestBatch, Map<GraphRequest, RequestProgress> map, long j) {
        super(outputStream);
        this.requests = graphRequestBatch;
        this.progressMap = map;
        this.maxProgress = j;
    }

    private void addProgress(long j) {
        RequestProgress requestProgress = this.currentRequestProgress;
        if (requestProgress != null) {
            requestProgress.addProgress(j);
        }
        this.batchProgress += j;
        long j2 = this.batchProgress;
        if (j2 >= this.lastReportedProgress + this.threshold || j2 >= this.maxProgress) {
            reportBatchProgress();
        }
    }

    private void reportBatchProgress() {
        if (this.batchProgress > this.lastReportedProgress) {
            for (Callback callback : this.requests.getCallbacks()) {
                if (callback instanceof OnProgressCallback) {
                    Handler callbackHandler = this.requests.getCallbackHandler();
                    final OnProgressCallback onProgressCallback = (OnProgressCallback) callback;
                    if (callbackHandler == null) {
                        onProgressCallback.onBatchProgress(this.requests, this.batchProgress, this.maxProgress);
                    } else {
                        callbackHandler.post(new Runnable() {
                            public void run() {
                                onProgressCallback.onBatchProgress(ProgressOutputStream.this.requests, ProgressOutputStream.this.batchProgress, ProgressOutputStream.this.maxProgress);
                            }
                        });
                    }
                }
            }
            this.lastReportedProgress = this.batchProgress;
        }
    }

    public void setCurrentRequest(GraphRequest graphRequest) {
        this.currentRequestProgress = graphRequest != null ? (RequestProgress) this.progressMap.get(graphRequest) : null;
    }

    public void write(byte[] bArr) throws IOException {
        this.out.write(bArr);
        addProgress((long) bArr.length);
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.out.write(bArr, i, i2);
        addProgress((long) i2);
    }

    public void write(int i) throws IOException {
        this.out.write(i);
        addProgress(1);
    }

    public void close() throws IOException {
        super.close();
        for (RequestProgress reportProgress : this.progressMap.values()) {
            reportProgress.reportProgress();
        }
        reportBatchProgress();
    }
}
