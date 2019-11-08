package kr.co.popone.fitts.feature.order;

import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class OrderTestData$OrderDataException extends RuntimeException {
    public OrderTestData$OrderDataException(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        super(str);
    }
}
