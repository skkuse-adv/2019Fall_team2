package kr.co.popone.fitts.services;

import android.app.Activity;
import org.jetbrains.annotations.NotNull;

public interface FittsSchemeHandler {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final int PAYMENT_DETAIL_REQUEST_CODE = 101;

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int PAYMENT_DETAIL_REQUEST_CODE = 101;

        private Companion() {
        }
    }

    boolean handleScheme(@NotNull Activity activity, @NotNull String str);
}
