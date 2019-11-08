package kotlinx.coroutines.internal;

import com.facebook.internal.ServerProtocol;
import kotlin.coroutines.CoroutineContext.Element;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.ThreadContextElement;
import org.jetbrains.annotations.NotNull;

final class ThreadContextKt$restoreState$1 extends Lambda implements Function2<ThreadState, Element, ThreadState> {
    public static final ThreadContextKt$restoreState$1 INSTANCE = new ThreadContextKt$restoreState$1();

    ThreadContextKt$restoreState$1() {
        super(2);
    }

    @NotNull
    public final ThreadState invoke(@NotNull ThreadState threadState, @NotNull Element element) {
        Intrinsics.checkParameterIsNotNull(threadState, ServerProtocol.DIALOG_PARAM_STATE);
        Intrinsics.checkParameterIsNotNull(element, "element");
        if (element instanceof ThreadContextElement) {
            ((ThreadContextElement) element).restoreThreadContext(threadState.getContext(), threadState.take());
        }
        return threadState;
    }
}
