package kotlinx.coroutines;

import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class DispatchException extends RuntimeException {
    public DispatchException(@NotNull String str, @NotNull Throwable th) {
        Intrinsics.checkParameterIsNotNull(str, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        Intrinsics.checkParameterIsNotNull(th, "cause");
        super(str, th);
    }
}
