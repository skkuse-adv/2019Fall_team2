package kotlinx.coroutines;

import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class TimeoutCancellationException extends CancellationException {
    @Nullable
    public final Job coroutine;

    public TimeoutCancellationException(@NotNull String str, @Nullable Job job) {
        Intrinsics.checkParameterIsNotNull(str, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        super(str);
        this.coroutine = job;
    }

    public TimeoutCancellationException(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        this(str, null);
    }
}
