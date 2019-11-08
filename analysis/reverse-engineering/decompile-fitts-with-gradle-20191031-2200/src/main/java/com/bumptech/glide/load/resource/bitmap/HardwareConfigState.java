package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import android.util.Log;
import com.bumptech.glide.load.DecodeFormat;
import java.io.File;

final class HardwareConfigState {
    private static final File FD_SIZE_LIST = new File("/proc/self/fd");
    private static final int MAXIMUM_FDS_FOR_HARDWARE_CONFIGS = 700;
    private static final int MINIMUM_DECODES_BETWEEN_FD_CHECKS = 50;
    private static final int MIN_HARDWARE_DIMENSION = 128;
    private static volatile HardwareConfigState instance;
    private volatile int decodesSinceLastFdCheck;
    private volatile boolean isHardwareConfigAllowed = true;

    static HardwareConfigState getInstance() {
        if (instance == null) {
            synchronized (HardwareConfigState.class) {
                if (instance == null) {
                    instance = new HardwareConfigState();
                }
            }
        }
        return instance;
    }

    private HardwareConfigState() {
    }

    /* access modifiers changed from: 0000 */
    @TargetApi(26)
    public boolean setHardwareConfigIfAllowed(int i, int i2, Options options, DecodeFormat decodeFormat, boolean z, boolean z2) {
        if (!z || VERSION.SDK_INT < 26 || z2) {
            return false;
        }
        boolean z3 = i >= 128 && i2 >= 128 && isFdSizeBelowHardwareLimit();
        if (z3) {
            options.inPreferredConfig = Config.HARDWARE;
            options.inMutable = false;
        }
        return z3;
    }

    private synchronized boolean isFdSizeBelowHardwareLimit() {
        int i = this.decodesSinceLastFdCheck + 1;
        this.decodesSinceLastFdCheck = i;
        if (i >= 50) {
            boolean z = false;
            this.decodesSinceLastFdCheck = 0;
            int length = FD_SIZE_LIST.list().length;
            if (length < MAXIMUM_FDS_FOR_HARDWARE_CONFIGS) {
                z = true;
            }
            this.isHardwareConfigAllowed = z;
            if (!this.isHardwareConfigAllowed && Log.isLoggable("Downsampler", 5)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors ");
                sb.append(length);
                sb.append(", limit ");
                sb.append(MAXIMUM_FDS_FOR_HARDWARE_CONFIGS);
                sb.toString();
            }
        }
        return this.isHardwareConfigAllowed;
    }
}
