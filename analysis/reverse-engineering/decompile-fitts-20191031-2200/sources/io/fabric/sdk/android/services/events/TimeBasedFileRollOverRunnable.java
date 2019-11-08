package io.fabric.sdk.android.services.events;

import android.content.Context;
import io.fabric.sdk.android.services.common.CommonUtils;

public class TimeBasedFileRollOverRunnable implements Runnable {
    private final Context context;
    private final FileRollOverManager fileRollOverManager;

    public TimeBasedFileRollOverRunnable(Context context2, FileRollOverManager fileRollOverManager2) {
        this.context = context2;
        this.fileRollOverManager = fileRollOverManager2;
    }

    public void run() {
        try {
            CommonUtils.logControlled(this.context, "Performing time based file roll over.");
            if (!this.fileRollOverManager.rollFileOver()) {
                this.fileRollOverManager.cancelTimeBasedFileRollOver();
            }
        } catch (Exception e) {
            CommonUtils.logControlledError(this.context, "Failed to roll over file", e);
        }
    }
}
