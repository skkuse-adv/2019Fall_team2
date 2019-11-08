package com.facebook.internal;

import android.content.Intent;
import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import com.kakao.auth.StringSet;
import java.util.HashMap;
import java.util.Map;

public final class CallbackManagerImpl implements CallbackManager {
    private static Map<Integer, Callback> staticCallbacks = new HashMap();
    private Map<Integer, Callback> callbacks = new HashMap();

    public interface Callback {
        boolean onActivityResult(int i, Intent intent);
    }

    public enum RequestCodeOffset {
        Login(0),
        Share(1),
        Message(2),
        Like(3),
        GameRequest(4),
        AppGroupCreate(5),
        AppGroupJoin(6),
        AppInvite(7),
        DeviceShare(8);
        
        private final int offset;

        private RequestCodeOffset(int i) {
            this.offset = i;
        }

        public int toRequestCode() {
            return FacebookSdk.getCallbackRequestCodeOffset() + this.offset;
        }
    }

    public static synchronized void registerStaticCallback(int i, Callback callback) {
        synchronized (CallbackManagerImpl.class) {
            Validate.notNull(callback, StringSet.PARAM_CALLBACK);
            if (!staticCallbacks.containsKey(Integer.valueOf(i))) {
                staticCallbacks.put(Integer.valueOf(i), callback);
            }
        }
    }

    private static synchronized Callback getStaticCallback(Integer num) {
        Callback callback;
        synchronized (CallbackManagerImpl.class) {
            callback = (Callback) staticCallbacks.get(num);
        }
        return callback;
    }

    private static boolean runStaticCallback(int i, int i2, Intent intent) {
        Callback staticCallback = getStaticCallback(Integer.valueOf(i));
        if (staticCallback != null) {
            return staticCallback.onActivityResult(i2, intent);
        }
        return false;
    }

    public void registerCallback(int i, Callback callback) {
        Validate.notNull(callback, StringSet.PARAM_CALLBACK);
        this.callbacks.put(Integer.valueOf(i), callback);
    }

    public void unregisterCallback(int i) {
        this.callbacks.remove(Integer.valueOf(i));
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        Callback callback = (Callback) this.callbacks.get(Integer.valueOf(i));
        if (callback != null) {
            return callback.onActivityResult(i2, intent);
        }
        return runStaticCallback(i, i2, intent);
    }
}
