package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import org.jetbrains.annotations.Nullable;

public final class ClosedSendChannelException extends CancellationException {
    public ClosedSendChannelException(@Nullable String str) {
        super(str);
    }
}
