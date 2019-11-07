package com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;

class ResourceRecycler {
    private final Handler handler = new Handler(Looper.getMainLooper(), new ResourceRecyclerCallback());
    private boolean isRecycling;

    private static final class ResourceRecyclerCallback implements Callback {
        static final int RECYCLE_RESOURCE = 1;

        ResourceRecyclerCallback() {
        }

        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            ((Resource) message.obj).recycle();
            return true;
        }
    }

    ResourceRecycler() {
    }

    /* access modifiers changed from: 0000 */
    public synchronized void recycle(Resource<?> resource) {
        if (this.isRecycling) {
            this.handler.obtainMessage(1, resource).sendToTarget();
        } else {
            this.isRecycling = true;
            resource.recycle();
            this.isRecycling = false;
        }
    }
}
