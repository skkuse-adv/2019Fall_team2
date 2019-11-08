package kotlinx.coroutines;

import org.jetbrains.annotations.Nullable;

public final class JobImpl extends JobSupport {
    public JobImpl() {
        this(null, 1, null);
    }

    /* access modifiers changed from: protected */
    public boolean getCancelsParent() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean getHandlesException() {
        return false;
    }

    public boolean getOnCancelComplete$kotlinx_coroutines_core() {
        return true;
    }

    public JobImpl(@Nullable Job job) {
        super(true);
        initParentJobInternal$kotlinx_coroutines_core(job);
    }

    public /* synthetic */ JobImpl(Job job, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            job = null;
        }
        this(job);
    }
}
