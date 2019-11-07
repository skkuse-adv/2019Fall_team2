package kotlinx.coroutines.internal;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class LockFreeLinkedListKt {
    @NotNull
    private static final Object ALREADY_REMOVED = new Symbol("ALREADY_REMOVED");
    @NotNull
    private static final Object CONDITION_FALSE = new Symbol("CONDITION_FALSE");
    public static final int FAILURE = 2;
    @NotNull
    private static final Object LIST_EMPTY = new Symbol("LIST_EMPTY");
    /* access modifiers changed from: private */
    public static final Object REMOVE_PREPARED = new Symbol("REMOVE_PREPARED");
    public static final int SUCCESS = 1;
    public static final int UNDECIDED = 0;

    public static /* synthetic */ void ALREADY_REMOVED$annotations() {
    }

    public static /* synthetic */ void CONDITION_FALSE$annotations() {
    }

    public static /* synthetic */ void FAILURE$annotations() {
    }

    public static /* synthetic */ void LIST_EMPTY$annotations() {
    }

    public static /* synthetic */ void SUCCESS$annotations() {
    }

    public static /* synthetic */ void UNDECIDED$annotations() {
    }

    @NotNull
    public static final Object getCONDITION_FALSE() {
        return CONDITION_FALSE;
    }

    @NotNull
    public static final Object getALREADY_REMOVED() {
        return ALREADY_REMOVED;
    }

    @NotNull
    public static final Object getLIST_EMPTY() {
        return LIST_EMPTY;
    }

    @NotNull
    public static final LockFreeLinkedListNode unwrap(@NotNull Object obj) {
        Intrinsics.checkParameterIsNotNull(obj, "receiver$0");
        Removed removed = (Removed) (!(obj instanceof Removed) ? null : obj);
        if (removed != null) {
            LockFreeLinkedListNode lockFreeLinkedListNode = removed.ref;
            if (lockFreeLinkedListNode != null) {
                return lockFreeLinkedListNode;
            }
        }
        return (LockFreeLinkedListNode) obj;
    }
}
