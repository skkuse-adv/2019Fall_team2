package com.bumptech.glide.request;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;

public class ThumbnailRequestCoordinator implements RequestCoordinator, Request {
    private Request full;
    private boolean isRunning;
    @Nullable
    private final RequestCoordinator parent;
    private Request thumb;

    @VisibleForTesting
    ThumbnailRequestCoordinator() {
        this(null);
    }

    public ThumbnailRequestCoordinator(@Nullable RequestCoordinator requestCoordinator) {
        this.parent = requestCoordinator;
    }

    public void setRequests(Request request, Request request2) {
        this.full = request;
        this.thumb = request2;
    }

    public boolean canSetImage(Request request) {
        return parentCanSetImage() && (request.equals(this.full) || !this.full.isResourceSet());
    }

    private boolean parentCanSetImage() {
        RequestCoordinator requestCoordinator = this.parent;
        return requestCoordinator == null || requestCoordinator.canSetImage(this);
    }

    public boolean canNotifyStatusChanged(Request request) {
        return parentCanNotifyStatusChanged() && request.equals(this.full) && !isAnyResourceSet();
    }

    public boolean canNotifyCleared(Request request) {
        return parentCanNotifyCleared() && request.equals(this.full);
    }

    private boolean parentCanNotifyCleared() {
        RequestCoordinator requestCoordinator = this.parent;
        return requestCoordinator == null || requestCoordinator.canNotifyCleared(this);
    }

    private boolean parentCanNotifyStatusChanged() {
        RequestCoordinator requestCoordinator = this.parent;
        return requestCoordinator == null || requestCoordinator.canNotifyStatusChanged(this);
    }

    public boolean isAnyResourceSet() {
        return parentIsAnyResourceSet() || isResourceSet();
    }

    public void onRequestSuccess(Request request) {
        if (!request.equals(this.thumb)) {
            RequestCoordinator requestCoordinator = this.parent;
            if (requestCoordinator != null) {
                requestCoordinator.onRequestSuccess(this);
            }
            if (!this.thumb.isComplete()) {
                this.thumb.clear();
            }
        }
    }

    public void onRequestFailed(Request request) {
        if (request.equals(this.full)) {
            RequestCoordinator requestCoordinator = this.parent;
            if (requestCoordinator != null) {
                requestCoordinator.onRequestFailed(this);
            }
        }
    }

    private boolean parentIsAnyResourceSet() {
        RequestCoordinator requestCoordinator = this.parent;
        return requestCoordinator != null && requestCoordinator.isAnyResourceSet();
    }

    public void begin() {
        this.isRunning = true;
        if (!this.full.isComplete() && !this.thumb.isRunning()) {
            this.thumb.begin();
        }
        if (this.isRunning && !this.full.isRunning()) {
            this.full.begin();
        }
    }

    public void clear() {
        this.isRunning = false;
        this.thumb.clear();
        this.full.clear();
    }

    public boolean isRunning() {
        return this.full.isRunning();
    }

    public boolean isComplete() {
        return this.full.isComplete() || this.thumb.isComplete();
    }

    public boolean isResourceSet() {
        return this.full.isResourceSet() || this.thumb.isResourceSet();
    }

    public boolean isCleared() {
        return this.full.isCleared();
    }

    public boolean isFailed() {
        return this.full.isFailed();
    }

    public void recycle() {
        this.full.recycle();
        this.thumb.recycle();
    }

    public boolean isEquivalentTo(Request request) {
        if (!(request instanceof ThumbnailRequestCoordinator)) {
            return false;
        }
        ThumbnailRequestCoordinator thumbnailRequestCoordinator = (ThumbnailRequestCoordinator) request;
        Request request2 = this.full;
        if (request2 == null) {
            if (thumbnailRequestCoordinator.full != null) {
                return false;
            }
        } else if (!request2.isEquivalentTo(thumbnailRequestCoordinator.full)) {
            return false;
        }
        Request request3 = this.thumb;
        Request request4 = thumbnailRequestCoordinator.thumb;
        if (request3 == null) {
            if (request4 != null) {
                return false;
            }
        } else if (!request3.isEquivalentTo(request4)) {
            return false;
        }
        return true;
    }
}
