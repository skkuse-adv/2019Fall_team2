package com.bumptech.glide.request.target;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.transition.Transition;

public final class PreloadTarget<Z> extends SimpleTarget<Z> {
    private static final Handler HANDLER = new Handler(Looper.getMainLooper(), new Callback() {
        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            ((PreloadTarget) message.obj).clear();
            return true;
        }
    });
    private static final int MESSAGE_CLEAR = 1;
    private final RequestManager requestManager;

    public static <Z> PreloadTarget<Z> obtain(RequestManager requestManager2, int i, int i2) {
        return new PreloadTarget<>(requestManager2, i, i2);
    }

    private PreloadTarget(RequestManager requestManager2, int i, int i2) {
        super(i, i2);
        this.requestManager = requestManager2;
    }

    public void onResourceReady(@NonNull Z z, @Nullable Transition<? super Z> transition) {
        HANDLER.obtainMessage(1, this).sendToTarget();
    }

    /* access modifiers changed from: 0000 */
    public void clear() {
        this.requestManager.clear((Target<?>) this);
    }
}
