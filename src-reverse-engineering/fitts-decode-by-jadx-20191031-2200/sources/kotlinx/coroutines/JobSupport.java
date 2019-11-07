package kotlinx.coroutines;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.internal.ServerProtocol;
import com.kakao.message.template.MessageTemplateProtocol;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.Element;
import kotlin.coroutines.CoroutineContext.Key;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.Job.DefaultImpls;
import kotlinx.coroutines.internal.ConcurrentKt;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.OpDescriptor;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import kotlinx.coroutines.selects.SelectClause0;
import kotlinx.coroutines.selects.SelectInstance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class JobSupport implements Job, ChildJob, ParentJob, SelectClause0 {
    private static final AtomicReferenceFieldUpdater _state$FU = AtomicReferenceFieldUpdater.newUpdater(JobSupport.class, Object.class, "_state");
    private volatile Object _state;
    private volatile ChildHandle parentHandle;

    private static final class AwaitContinuation<T> extends CancellableContinuationImpl<T> {
        private final JobSupport job;

        public AwaitContinuation(@NotNull Continuation<? super T> continuation, @NotNull JobSupport jobSupport) {
            Intrinsics.checkParameterIsNotNull(continuation, "delegate");
            Intrinsics.checkParameterIsNotNull(jobSupport, "job");
            super(continuation, 1);
            this.job = jobSupport;
        }

        @NotNull
        public Throwable getContinuationCancellationCause(@NotNull Job job2) {
            Intrinsics.checkParameterIsNotNull(job2, "parent");
            Object state$kotlinx_coroutines_core = this.job.getState$kotlinx_coroutines_core();
            if (state$kotlinx_coroutines_core instanceof Finishing) {
                Throwable th = ((Finishing) state$kotlinx_coroutines_core).rootCause;
                if (th != null) {
                    return th;
                }
            }
            if (state$kotlinx_coroutines_core instanceof CompletedExceptionally) {
                return ((CompletedExceptionally) state$kotlinx_coroutines_core).cause;
            }
            return job2.getCancellationException();
        }

        /* access modifiers changed from: protected */
        @NotNull
        public String nameString() {
            StringBuilder sb = new StringBuilder();
            sb.append("AwaitContinuation(");
            sb.append(DebugKt.toDebugString(getDelegate()));
            sb.append(')');
            return sb.toString();
        }
    }

    private static final class ChildCompletion extends JobNode<Job> {
        private final ChildHandleNode child;
        private final JobSupport parent;
        private final Object proposedUpdate;
        private final Finishing state;

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return Unit.INSTANCE;
        }

        public ChildCompletion(@NotNull JobSupport jobSupport, @NotNull Finishing finishing, @NotNull ChildHandleNode childHandleNode, @Nullable Object obj) {
            Intrinsics.checkParameterIsNotNull(jobSupport, "parent");
            Intrinsics.checkParameterIsNotNull(finishing, ServerProtocol.DIALOG_PARAM_STATE);
            Intrinsics.checkParameterIsNotNull(childHandleNode, "child");
            super(childHandleNode.childJob);
            this.parent = jobSupport;
            this.state = finishing;
            this.child = childHandleNode;
            this.proposedUpdate = obj;
        }

        public void invoke(@Nullable Throwable th) {
            this.parent.continueCompleting(this.state, this.child, this.proposedUpdate);
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("ChildCompletion[");
            sb.append(this.child);
            sb.append(", ");
            sb.append(this.proposedUpdate);
            sb.append(']');
            return sb.toString();
        }
    }

    private static final class Finishing implements Incomplete {
        private volatile Object _exceptionsHolder;
        public volatile boolean isCompleting;
        @NotNull
        private final NodeList list;
        @Nullable
        public volatile Throwable rootCause;

        @NotNull
        public NodeList getList() {
            return this.list;
        }

        public Finishing(@NotNull NodeList nodeList, boolean z, @Nullable Throwable th) {
            Intrinsics.checkParameterIsNotNull(nodeList, MessageTemplateProtocol.TYPE_LIST);
            this.list = nodeList;
            this.isCompleting = z;
            this.rootCause = th;
        }

        public final boolean isSealed() {
            return this._exceptionsHolder == JobSupportKt.SEALED;
        }

        public final boolean isCancelling() {
            return this.rootCause != null;
        }

        public boolean isActive() {
            return this.rootCause == null;
        }

        @NotNull
        public final List<Throwable> sealLocked(@Nullable Throwable th) {
            ArrayList arrayList;
            Object obj = this._exceptionsHolder;
            if (obj == null) {
                arrayList = allocateList();
            } else if (obj instanceof Throwable) {
                ArrayList allocateList = allocateList();
                allocateList.add(obj);
                arrayList = allocateList;
            } else if (!(obj instanceof ArrayList)) {
                StringBuilder sb = new StringBuilder();
                sb.append("State is ");
                sb.append(obj);
                throw new IllegalStateException(sb.toString().toString());
            } else if (obj != null) {
                arrayList = (ArrayList) obj;
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.ArrayList<kotlin.Throwable> /* = java.util.ArrayList<kotlin.Throwable> */");
            }
            Throwable th2 = this.rootCause;
            if (th2 != null) {
                arrayList.add(0, th2);
            }
            if (th != null && (!Intrinsics.areEqual((Object) th, (Object) th2))) {
                arrayList.add(th);
            }
            this._exceptionsHolder = JobSupportKt.SEALED;
            return arrayList;
        }

        public final void addExceptionLocked(@NotNull Throwable th) {
            Intrinsics.checkParameterIsNotNull(th, "exception");
            Throwable th2 = this.rootCause;
            if (th2 == null) {
                this.rootCause = th;
            } else if (th != th2) {
                Object obj = this._exceptionsHolder;
                if (obj == null) {
                    this._exceptionsHolder = th;
                } else if (obj instanceof Throwable) {
                    if (th != obj) {
                        ArrayList allocateList = allocateList();
                        allocateList.add(obj);
                        allocateList.add(th);
                        this._exceptionsHolder = allocateList;
                    }
                } else if (!(obj instanceof ArrayList)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("State is ");
                    sb.append(obj);
                    throw new IllegalStateException(sb.toString().toString());
                } else if (obj != null) {
                    ((ArrayList) obj).add(th);
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.ArrayList<kotlin.Throwable> /* = java.util.ArrayList<kotlin.Throwable> */");
                }
            }
        }

        private final ArrayList<Throwable> allocateList() {
            return new ArrayList<>(4);
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Finishing[cancelling=");
            sb.append(isCancelling());
            sb.append(", completing=");
            sb.append(this.isCompleting);
            sb.append(", rootCause=");
            sb.append(this.rootCause);
            sb.append(", exceptions=");
            sb.append(this._exceptionsHolder);
            sb.append(", list=");
            sb.append(getList());
            sb.append(']');
            return sb.toString();
        }
    }

    /* access modifiers changed from: protected */
    public boolean getCancelsParent() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean getHandlesException() {
        return true;
    }

    public boolean getOnCancelComplete$kotlinx_coroutines_core() {
        return false;
    }

    @NotNull
    public final SelectClause0 getOnJoin() {
        return this;
    }

    /* access modifiers changed from: protected */
    public void handleJobException(@NotNull Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "exception");
    }

    /* access modifiers changed from: protected */
    public void onCancellation(@Nullable Throwable th) {
    }

    public void onCompletionInternal$kotlinx_coroutines_core(@Nullable Object obj, int i, boolean z) {
    }

    public void onStartInternal$kotlinx_coroutines_core() {
    }

    public JobSupport(boolean z) {
        this._state = z ? JobSupportKt.EMPTY_ACTIVE : JobSupportKt.EMPTY_NEW;
    }

    public <R> R fold(R r, @NotNull Function2<? super R, ? super Element, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(function2, "operation");
        return DefaultImpls.fold(this, r, function2);
    }

    @Nullable
    public <E extends Element> E get(@NotNull Key<E> key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        return DefaultImpls.get(this, key);
    }

    @NotNull
    public CoroutineContext minusKey(@NotNull Key<?> key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        return DefaultImpls.minusKey(this, key);
    }

    @NotNull
    public CoroutineContext plus(@NotNull CoroutineContext coroutineContext) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        return DefaultImpls.plus((Job) this, coroutineContext);
    }

    @NotNull
    public Job plus(@NotNull Job job) {
        Intrinsics.checkParameterIsNotNull(job, FacebookRequestErrorClassification.KEY_OTHER);
        return DefaultImpls.plus((Job) this, job);
    }

    @NotNull
    public final Key<?> getKey() {
        return Job.Key;
    }

    public final void initParentJobInternal$kotlinx_coroutines_core(@Nullable Job job) {
        if (!(this.parentHandle == null)) {
            throw new IllegalStateException("Check failed.".toString());
        } else if (job == null) {
            this.parentHandle = NonDisposableHandle.INSTANCE;
        } else {
            job.start();
            ChildHandle attachChild = job.attachChild(this);
            this.parentHandle = attachChild;
            if (isCompleted()) {
                attachChild.dispose();
                this.parentHandle = NonDisposableHandle.INSTANCE;
            }
        }
    }

    public boolean isActive() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        return (state$kotlinx_coroutines_core instanceof Incomplete) && ((Incomplete) state$kotlinx_coroutines_core).isActive();
    }

    public final boolean isCompleted() {
        return !(getState$kotlinx_coroutines_core() instanceof Incomplete);
    }

    public final boolean isCancelled() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        return (state$kotlinx_coroutines_core instanceof CompletedExceptionally) || ((state$kotlinx_coroutines_core instanceof Finishing) && ((Finishing) state$kotlinx_coroutines_core).isCancelling());
    }

    private final boolean tryFinalizeFinishingState(Finishing finishing, Object obj, int i) {
        Throwable finalRootCause;
        if (!(obj instanceof Incomplete)) {
            boolean z = false;
            if (!(getState$kotlinx_coroutines_core() == finishing)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            } else if (!(!finishing.isSealed())) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            } else if (finishing.isCompleting) {
                Throwable th = null;
                CompletedExceptionally completedExceptionally = (CompletedExceptionally) (!(obj instanceof CompletedExceptionally) ? null : obj);
                if (completedExceptionally != null) {
                    th = completedExceptionally.cause;
                }
                synchronized (finishing) {
                    List sealLocked = finishing.sealLocked(th);
                    finalRootCause = getFinalRootCause(finishing, sealLocked);
                    if (finalRootCause != null && (suppressExceptions(finalRootCause, sealLocked) || finalRootCause != finishing.rootCause)) {
                        z = true;
                    }
                }
                if (!(finalRootCause == null || finalRootCause == th)) {
                    obj = new CompletedExceptionally(finalRootCause);
                }
                if (finalRootCause != null && !cancelParent(finalRootCause)) {
                    handleJobException(finalRootCause);
                }
                if (_state$FU.compareAndSet(this, finishing, obj)) {
                    completeStateFinalization(finishing, obj, i, z);
                    return true;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Unexpected state: ");
                sb.append(this._state);
                sb.append(", expected: ");
                sb.append(finishing);
                sb.append(", update: ");
                sb.append(obj);
                throw new IllegalArgumentException(sb.toString().toString());
            } else {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
        } else {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    private final Throwable getFinalRootCause(Finishing finishing, List<? extends Throwable> list) {
        Object obj;
        if (!list.isEmpty()) {
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (!(((Throwable) obj) instanceof CancellationException)) {
                    break;
                }
            }
            Throwable th = (Throwable) obj;
            if (th == null) {
                th = (Throwable) list.get(0);
            }
            return th;
        } else if (finishing.isCancelling()) {
            return createJobCancellationException();
        } else {
            return null;
        }
    }

    private final boolean suppressExceptions(Throwable th, List<? extends Throwable> list) {
        boolean z = false;
        if (list.size() <= 1) {
            return false;
        }
        Set identitySet = ConcurrentKt.identitySet(list.size());
        for (Throwable th2 : list) {
            if (th2 != th && !(th2 instanceof CancellationException) && identitySet.add(th2)) {
                ExceptionsKt__ExceptionsKt.addSuppressed(th, th2);
                z = true;
            }
        }
        return z;
    }

    private final boolean tryFinalizeSimpleState(Incomplete incomplete, Object obj, int i) {
        String str = "Check failed.";
        if (!((incomplete instanceof Empty) || (incomplete instanceof JobNode))) {
            throw new IllegalStateException(str.toString());
        } else if (!(!(obj instanceof CompletedExceptionally))) {
            throw new IllegalStateException(str.toString());
        } else if (!_state$FU.compareAndSet(this, incomplete, obj)) {
            return false;
        } else {
            completeStateFinalization(incomplete, obj, i, false);
            return true;
        }
    }

    private final void completeStateFinalization(Incomplete incomplete, Object obj, int i, boolean z) {
        ChildHandle childHandle = this.parentHandle;
        if (childHandle != null) {
            childHandle.dispose();
            this.parentHandle = NonDisposableHandle.INSTANCE;
        }
        Throwable th = null;
        CompletedExceptionally completedExceptionally = (CompletedExceptionally) (!(obj instanceof CompletedExceptionally) ? null : obj);
        if (completedExceptionally != null) {
            th = completedExceptionally.cause;
        }
        if (!isCancelling(incomplete)) {
            onCancellation(th);
        }
        if (incomplete instanceof JobNode) {
            try {
                ((JobNode) incomplete).invoke(th);
            } catch (Throwable th2) {
                StringBuilder sb = new StringBuilder();
                sb.append("Exception in completion handler ");
                sb.append(incomplete);
                sb.append(" for ");
                sb.append(this);
                handleOnCompletionException$kotlinx_coroutines_core(new CompletionHandlerException(sb.toString(), th2));
            }
        } else {
            NodeList list = incomplete.getList();
            if (list != null) {
                notifyCompletion(list, th);
            }
        }
        onCompletionInternal$kotlinx_coroutines_core(obj, i, z);
    }

    private final void notifyCancelling(NodeList nodeList, Throwable th) {
        onCancellation(th);
        Object next = nodeList.getNext();
        if (next != null) {
            CompletionHandlerException completionHandlerException = null;
            for (LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) next; !Intrinsics.areEqual((Object) lockFreeLinkedListNode, (Object) nodeList); lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode()) {
                if (lockFreeLinkedListNode instanceof JobCancellingNode) {
                    JobNode jobNode = (JobNode) lockFreeLinkedListNode;
                    try {
                        jobNode.invoke(th);
                    } catch (Throwable th2) {
                        if (completionHandlerException != null) {
                            ExceptionsKt__ExceptionsKt.addSuppressed(completionHandlerException, th2);
                            if (completionHandlerException != null) {
                            }
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append("Exception in completion handler ");
                        sb.append(jobNode);
                        sb.append(" for ");
                        sb.append(this);
                        completionHandlerException = new CompletionHandlerException(sb.toString(), th2);
                        Unit unit = Unit.INSTANCE;
                    }
                }
            }
            if (completionHandlerException != null) {
                handleOnCompletionException$kotlinx_coroutines_core(completionHandlerException);
            }
            cancelParent(th);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
    }

    private final int startInternal(Object obj) {
        if (obj instanceof Empty) {
            if (((Empty) obj).isActive()) {
                return 0;
            }
            if (!_state$FU.compareAndSet(this, obj, JobSupportKt.EMPTY_ACTIVE)) {
                return -1;
            }
            onStartInternal$kotlinx_coroutines_core();
            return 1;
        } else if (!(obj instanceof InactiveNodeList)) {
            return 0;
        } else {
            if (!_state$FU.compareAndSet(this, obj, ((InactiveNodeList) obj).getList())) {
                return -1;
            }
            onStartInternal$kotlinx_coroutines_core();
            return 1;
        }
    }

    @NotNull
    public final CancellationException getCancellationException() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        String str = "Job is still new or active: ";
        if (state$kotlinx_coroutines_core instanceof Finishing) {
            Throwable th = ((Finishing) state$kotlinx_coroutines_core).rootCause;
            if (th != null) {
                CancellationException cancellationException = toCancellationException(th, "Job is cancelling");
                if (cancellationException != null) {
                    return cancellationException;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(this);
            throw new IllegalStateException(sb.toString().toString());
        } else if (state$kotlinx_coroutines_core instanceof Incomplete) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(this);
            throw new IllegalStateException(sb2.toString().toString());
        } else if (state$kotlinx_coroutines_core instanceof CompletedExceptionally) {
            return toCancellationException(((CompletedExceptionally) state$kotlinx_coroutines_core).cause, "Job was cancelled");
        } else {
            return new JobCancellationException("Job has completed normally", null, this);
        }
    }

    private final CancellationException toCancellationException(@NotNull Throwable th, String str) {
        CancellationException cancellationException = (CancellationException) (!(th instanceof CancellationException) ? null : th);
        return cancellationException != null ? cancellationException : new JobCancellationException(str, th, this);
    }

    @NotNull
    public final DisposableHandle invokeOnCompletion(@NotNull Function1<? super Throwable, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "handler");
        return invokeOnCompletion(false, true, function1);
    }

    private final JobNode<?> makeNode(Function1<? super Throwable, Unit> function1, boolean z) {
        String str = "Failed requirement.";
        boolean z2 = true;
        JobCancellingNode jobCancellingNode = null;
        if (z) {
            if (function1 instanceof JobCancellingNode) {
                jobCancellingNode = function1;
            }
            JobCancellingNode jobCancellingNode2 = jobCancellingNode;
            if (jobCancellingNode2 != null) {
                if (jobCancellingNode2.job != this) {
                    z2 = false;
                }
                if (!z2) {
                    throw new IllegalArgumentException(str.toString());
                } else if (jobCancellingNode2 != null) {
                    return jobCancellingNode2;
                }
            }
            return new InvokeOnCancelling(this, function1);
        }
        if (function1 instanceof JobNode) {
            jobCancellingNode = function1;
        }
        JobNode<?> jobNode = jobCancellingNode;
        if (jobNode != null) {
            if (jobNode.job != this || (jobNode instanceof JobCancellingNode)) {
                z2 = false;
            }
            if (!z2) {
                throw new IllegalArgumentException(str.toString());
            } else if (jobNode != null) {
                return jobNode;
            }
        }
        return new InvokeOnCompletion(this, function1);
    }

    /* JADX WARNING: type inference failed for: r1v2, types: [kotlinx.coroutines.InactiveNodeList] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void promoteEmptyToNodeList(kotlinx.coroutines.Empty r3) {
        /*
            r2 = this;
            kotlinx.coroutines.NodeList r0 = new kotlinx.coroutines.NodeList
            r0.<init>()
            boolean r1 = r3.isActive()
            if (r1 == 0) goto L_0x000c
            goto L_0x0012
        L_0x000c:
            kotlinx.coroutines.InactiveNodeList r1 = new kotlinx.coroutines.InactiveNodeList
            r1.<init>(r0)
            r0 = r1
        L_0x0012:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = _state$FU
            r1.compareAndSet(r2, r3, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.JobSupport.promoteEmptyToNodeList(kotlinx.coroutines.Empty):void");
    }

    private final void promoteSingleToNodeList(JobNode<?> jobNode) {
        jobNode.addOneIfEmpty(new NodeList());
        _state$FU.compareAndSet(this, jobNode, jobNode.getNextNode());
    }

    @Nullable
    public final Object join(@NotNull Continuation<? super Unit> continuation) {
        if (joinInternal()) {
            return joinSuspend(continuation);
        }
        YieldKt.checkCompletion(continuation.getContext());
        return Unit.INSTANCE;
    }

    public void cancel() {
        cancel(null);
    }

    public boolean cancel(@Nullable Throwable th) {
        return cancelImpl(th) && getHandlesException();
    }

    public final void parentCancelled(@NotNull ParentJob parentJob) {
        Intrinsics.checkParameterIsNotNull(parentJob, "parentJob");
        cancelImpl(parentJob);
    }

    public boolean childCancelled(@NotNull Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "cause");
        return cancelImpl(th) && getHandlesException();
    }

    private final boolean cancelImpl(Object obj) {
        if (!getOnCancelComplete$kotlinx_coroutines_core() || !cancelMakeCompleting(obj)) {
            return makeCancelling(obj);
        }
        return true;
    }

    private final JobCancellationException createJobCancellationException() {
        return new JobCancellationException("Job was cancelled", null, this);
    }

    @NotNull
    public Throwable getChildJobCancellationCause() {
        Throwable th;
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (state$kotlinx_coroutines_core instanceof Finishing) {
            th = ((Finishing) state$kotlinx_coroutines_core).rootCause;
        } else if (!(state$kotlinx_coroutines_core instanceof Incomplete)) {
            th = state$kotlinx_coroutines_core instanceof CompletedExceptionally ? ((CompletedExceptionally) state$kotlinx_coroutines_core).cause : null;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot be cancelling child in this state: ");
            sb.append(state$kotlinx_coroutines_core);
            throw new IllegalStateException(sb.toString().toString());
        }
        if (th != null && (!getHandlesException() || (th instanceof CancellationException))) {
            return th;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Parent job is ");
        sb2.append(stateString(state$kotlinx_coroutines_core));
        return new JobCancellationException(sb2.toString(), th, this);
    }

    private final Throwable createCauseException(Object obj) {
        if (obj != null ? obj instanceof Throwable : true) {
            return obj != null ? (Throwable) obj : createJobCancellationException();
        }
        if (obj != null) {
            return ((ParentJob) obj).getChildJobCancellationCause();
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
    }

    private final NodeList getOrPromoteCancellingList(Incomplete incomplete) {
        NodeList list = incomplete.getList();
        if (list != null) {
            return list;
        }
        if (incomplete instanceof Empty) {
            return new NodeList();
        }
        if (incomplete instanceof JobNode) {
            promoteSingleToNodeList((JobNode) incomplete);
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("State should have list: ");
        sb.append(incomplete);
        throw new IllegalStateException(sb.toString().toString());
    }

    private final boolean tryMakeCancelling(Incomplete incomplete, Throwable th) {
        String str = "Check failed.";
        if (!(!(incomplete instanceof Finishing))) {
            throw new IllegalStateException(str.toString());
        } else if (incomplete.isActive()) {
            NodeList orPromoteCancellingList = getOrPromoteCancellingList(incomplete);
            if (orPromoteCancellingList == null) {
                return false;
            }
            if (!_state$FU.compareAndSet(this, incomplete, new Finishing(orPromoteCancellingList, false, th))) {
                return false;
            }
            notifyCancelling(orPromoteCancellingList, th);
            return true;
        } else {
            throw new IllegalStateException(str.toString());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0077, code lost:
        if (r1 == null) goto L_0x007c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0079, code lost:
        notifyCancelling(r4, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x007c, code lost:
        r9 = firstChild(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0080, code lost:
        if (r9 == null) goto L_0x008a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0086, code lost:
        if (tryWaitForChild(r5, r9, r10) == false) goto L_0x008a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0089, code lost:
        return 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x008e, code lost:
        if (tryFinalizeFinishingState(r5, r10, r11) == false) goto L_0x0091;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0090, code lost:
        return 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0091, code lost:
        return 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int tryMakeCompleting(java.lang.Object r9, java.lang.Object r10, int r11) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof kotlinx.coroutines.Incomplete
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            boolean r0 = r9 instanceof kotlinx.coroutines.Empty
            r2 = 3
            r3 = 1
            if (r0 != 0) goto L_0x0010
            boolean r0 = r9 instanceof kotlinx.coroutines.JobNode
            if (r0 == 0) goto L_0x0022
        L_0x0010:
            boolean r0 = r9 instanceof kotlinx.coroutines.ChildHandleNode
            if (r0 != 0) goto L_0x0022
            boolean r0 = r10 instanceof kotlinx.coroutines.CompletedExceptionally
            if (r0 != 0) goto L_0x0022
            kotlinx.coroutines.Incomplete r9 = (kotlinx.coroutines.Incomplete) r9
            boolean r9 = r8.tryFinalizeSimpleState(r9, r10, r11)
            if (r9 != 0) goto L_0x0021
            return r2
        L_0x0021:
            return r3
        L_0x0022:
            r0 = r9
            kotlinx.coroutines.Incomplete r0 = (kotlinx.coroutines.Incomplete) r0
            kotlinx.coroutines.NodeList r4 = r8.getOrPromoteCancellingList(r0)
            if (r4 == 0) goto L_0x00a1
            boolean r5 = r9 instanceof kotlinx.coroutines.JobSupport.Finishing
            r6 = 0
            if (r5 != 0) goto L_0x0032
            r5 = r6
            goto L_0x0033
        L_0x0032:
            r5 = r9
        L_0x0033:
            kotlinx.coroutines.JobSupport$Finishing r5 = (kotlinx.coroutines.JobSupport.Finishing) r5
            if (r5 == 0) goto L_0x0038
            goto L_0x003d
        L_0x0038:
            kotlinx.coroutines.JobSupport$Finishing r5 = new kotlinx.coroutines.JobSupport$Finishing
            r5.<init>(r4, r1, r6)
        L_0x003d:
            monitor-enter(r5)
            boolean r7 = r5.isCompleting     // Catch:{ all -> 0x009e }
            if (r7 == 0) goto L_0x0044
            monitor-exit(r5)
            return r1
        L_0x0044:
            r5.isCompleting = r3     // Catch:{ all -> 0x009e }
            if (r5 == r9) goto L_0x0052
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = _state$FU     // Catch:{ all -> 0x009e }
            boolean r9 = r1.compareAndSet(r8, r9, r5)     // Catch:{ all -> 0x009e }
            if (r9 != 0) goto L_0x0052
            monitor-exit(r5)
            return r2
        L_0x0052:
            boolean r9 = r5.isSealed()     // Catch:{ all -> 0x009e }
            r9 = r9 ^ r3
            if (r9 == 0) goto L_0x0092
            boolean r9 = r5.isCancelling()     // Catch:{ all -> 0x009e }
            boolean r1 = r10 instanceof kotlinx.coroutines.CompletedExceptionally     // Catch:{ all -> 0x009e }
            if (r1 != 0) goto L_0x0063
            r1 = r6
            goto L_0x0064
        L_0x0063:
            r1 = r10
        L_0x0064:
            kotlinx.coroutines.CompletedExceptionally r1 = (kotlinx.coroutines.CompletedExceptionally) r1     // Catch:{ all -> 0x009e }
            if (r1 == 0) goto L_0x006d
            java.lang.Throwable r1 = r1.cause     // Catch:{ all -> 0x009e }
            r5.addExceptionLocked(r1)     // Catch:{ all -> 0x009e }
        L_0x006d:
            java.lang.Throwable r1 = r5.rootCause     // Catch:{ all -> 0x009e }
            r9 = r9 ^ r3
            if (r9 == 0) goto L_0x0073
            goto L_0x0074
        L_0x0073:
            r1 = r6
        L_0x0074:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x009e }
            monitor-exit(r5)
            if (r1 == 0) goto L_0x007c
            r8.notifyCancelling(r4, r1)
        L_0x007c:
            kotlinx.coroutines.ChildHandleNode r9 = r8.firstChild(r0)
            if (r9 == 0) goto L_0x008a
            boolean r9 = r8.tryWaitForChild(r5, r9, r10)
            if (r9 == 0) goto L_0x008a
            r9 = 2
            return r9
        L_0x008a:
            boolean r9 = r8.tryFinalizeFinishingState(r5, r10, r11)
            if (r9 == 0) goto L_0x0091
            return r3
        L_0x0091:
            return r2
        L_0x0092:
            java.lang.String r9 = "Failed requirement."
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x009e }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x009e }
            r10.<init>(r9)     // Catch:{ all -> 0x009e }
            throw r10     // Catch:{ all -> 0x009e }
        L_0x009e:
            r9 = move-exception
            monitor-exit(r5)
            throw r9
        L_0x00a1:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.JobSupport.tryMakeCompleting(java.lang.Object, java.lang.Object, int):int");
    }

    private final Throwable getExceptionOrNull(@Nullable Object obj) {
        if (!(obj instanceof CompletedExceptionally)) {
            obj = null;
        }
        CompletedExceptionally completedExceptionally = (CompletedExceptionally) obj;
        if (completedExceptionally != null) {
            return completedExceptionally.cause;
        }
        return null;
    }

    private final ChildHandleNode firstChild(Incomplete incomplete) {
        ChildHandleNode childHandleNode = (ChildHandleNode) (!(incomplete instanceof ChildHandleNode) ? null : incomplete);
        if (childHandleNode != null) {
            return childHandleNode;
        }
        NodeList list = incomplete.getList();
        if (list != null) {
            return nextChild(list);
        }
        return null;
    }

    private final boolean tryWaitForChild(Finishing finishing, ChildHandleNode childHandleNode, Object obj) {
        while (DefaultImpls.invokeOnCompletion$default(childHandleNode.childJob, false, false, new ChildCompletion(this, finishing, childHandleNode, obj), 1, null) == NonDisposableHandle.INSTANCE) {
            childHandleNode = nextChild(childHandleNode);
            if (childHandleNode == null) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    public final void continueCompleting(Finishing finishing, ChildHandleNode childHandleNode, Object obj) {
        if (getState$kotlinx_coroutines_core() == finishing) {
            ChildHandleNode nextChild = nextChild(childHandleNode);
            if ((nextChild == null || !tryWaitForChild(finishing, nextChild, obj)) && tryFinalizeFinishingState(finishing, obj, 0)) {
            }
            return;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    private final ChildHandleNode nextChild(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode) {
        while (lockFreeLinkedListNode.isRemoved()) {
            lockFreeLinkedListNode = lockFreeLinkedListNode.getPrevNode();
        }
        while (true) {
            lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode();
            if (!lockFreeLinkedListNode.isRemoved()) {
                if (lockFreeLinkedListNode instanceof ChildHandleNode) {
                    return (ChildHandleNode) lockFreeLinkedListNode;
                }
                if (lockFreeLinkedListNode instanceof NodeList) {
                    return null;
                }
            }
        }
    }

    @NotNull
    public final Sequence<Job> getChildren() {
        return SequencesKt__SequenceBuilderKt.sequence(new JobSupport$children$1(this, null));
    }

    @NotNull
    public final ChildHandle attachChild(@NotNull ChildJob childJob) {
        Intrinsics.checkParameterIsNotNull(childJob, "child");
        DisposableHandle invokeOnCompletion$default = DefaultImpls.invokeOnCompletion$default(this, true, false, new ChildHandleNode(this, childJob), 2, null);
        if (invokeOnCompletion$default != null) {
            return (ChildHandle) invokeOnCompletion$default;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.ChildHandle");
    }

    public void handleOnCompletionException$kotlinx_coroutines_core(@NotNull Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "exception");
        throw th;
    }

    private final boolean cancelParent(Throwable th) {
        boolean z = true;
        if (th instanceof CancellationException) {
            return true;
        }
        if (!getCancelsParent()) {
            return false;
        }
        ChildHandle childHandle = this.parentHandle;
        if (childHandle == null || !childHandle.childCancelled(th)) {
            z = false;
        }
        return z;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(nameString$kotlinx_coroutines_core());
        sb.append('{');
        sb.append(stateString(getState$kotlinx_coroutines_core()));
        sb.append("}@");
        sb.append(DebugKt.getHexAddress(this));
        return sb.toString();
    }

    @NotNull
    public String nameString$kotlinx_coroutines_core() {
        return DebugKt.getClassSimpleName(this);
    }

    private final String stateString(Object obj) {
        String str = "Active";
        if (obj instanceof Finishing) {
            Finishing finishing = (Finishing) obj;
            if (finishing.isCancelling()) {
                return "Cancelling";
            }
            if (finishing.isCompleting) {
                return "Completing";
            }
            return str;
        } else if (!(obj instanceof Incomplete)) {
            return obj instanceof CompletedExceptionally ? "Cancelled" : "Completed";
        } else {
            if (((Incomplete) obj).isActive()) {
                return str;
            }
            return "New";
        }
    }

    private final boolean isCancelling(@NotNull Incomplete incomplete) {
        return (incomplete instanceof Finishing) && ((Finishing) incomplete).isCancelling();
    }

    public final boolean isCompletedExceptionally() {
        return getState$kotlinx_coroutines_core() instanceof CompletedExceptionally;
    }

    @Nullable
    public final Throwable getCompletionExceptionOrNull() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (!(state$kotlinx_coroutines_core instanceof Incomplete)) {
            return getExceptionOrNull(state$kotlinx_coroutines_core);
        }
        throw new IllegalStateException("This job has not completed yet".toString());
    }

    @Nullable
    public final Object getCompletedInternal$kotlinx_coroutines_core() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (!(!(state$kotlinx_coroutines_core instanceof Incomplete))) {
            throw new IllegalStateException("This job has not completed yet".toString());
        } else if (!(state$kotlinx_coroutines_core instanceof CompletedExceptionally)) {
            return state$kotlinx_coroutines_core;
        } else {
            throw ((CompletedExceptionally) state$kotlinx_coroutines_core).cause;
        }
    }

    @Nullable
    public final Object awaitInternal$kotlinx_coroutines_core(@NotNull Continuation<Object> continuation) {
        Object state$kotlinx_coroutines_core;
        do {
            state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (!(state$kotlinx_coroutines_core instanceof Incomplete)) {
                if (!(state$kotlinx_coroutines_core instanceof CompletedExceptionally)) {
                    return state$kotlinx_coroutines_core;
                }
                throw ((CompletedExceptionally) state$kotlinx_coroutines_core).cause;
            }
        } while (startInternal(state$kotlinx_coroutines_core) < 0);
        return awaitSuspend(continuation);
    }

    /* access modifiers changed from: 0000 */
    @Nullable
    public final /* synthetic */ Object awaitSuspend(@NotNull Continuation<Object> continuation) {
        AwaitContinuation awaitContinuation = new AwaitContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), this);
        awaitContinuation.initCancellability();
        invokeOnCompletion(new ResumeAwaitOnCompletion(this, awaitContinuation));
        Object result = awaitContinuation.getResult();
        if (result == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public final <T, R> void selectAwaitCompletion$kotlinx_coroutines_core(@NotNull SelectInstance<? super R> selectInstance, @NotNull Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2) {
        Intrinsics.checkParameterIsNotNull(selectInstance, "select");
        Intrinsics.checkParameterIsNotNull(function2, "block");
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (state$kotlinx_coroutines_core instanceof CompletedExceptionally) {
            selectInstance.resumeSelectCancellableWithException(((CompletedExceptionally) state$kotlinx_coroutines_core).cause);
        } else {
            CancellableKt.startCoroutineCancellable(function2, state$kotlinx_coroutines_core, selectInstance.getCompletion());
        }
    }

    @Nullable
    public final Object getState$kotlinx_coroutines_core() {
        while (true) {
            Object obj = this._state;
            if (!(obj instanceof OpDescriptor)) {
                return obj;
            }
            ((OpDescriptor) obj).perform(this);
        }
    }

    private final void notifyCompletion(@NotNull NodeList nodeList, Throwable th) {
        Object next = nodeList.getNext();
        if (next != null) {
            CompletionHandlerException completionHandlerException = null;
            for (LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) next; !Intrinsics.areEqual((Object) lockFreeLinkedListNode, (Object) nodeList); lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode()) {
                if (lockFreeLinkedListNode instanceof JobNode) {
                    JobNode jobNode = (JobNode) lockFreeLinkedListNode;
                    try {
                        jobNode.invoke(th);
                    } catch (Throwable th2) {
                        if (completionHandlerException != null) {
                            ExceptionsKt__ExceptionsKt.addSuppressed(completionHandlerException, th2);
                            if (completionHandlerException != null) {
                            }
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append("Exception in completion handler ");
                        sb.append(jobNode);
                        sb.append(" for ");
                        sb.append(this);
                        completionHandlerException = new CompletionHandlerException(sb.toString(), th2);
                        Unit unit = Unit.INSTANCE;
                    }
                }
            }
            if (completionHandlerException != null) {
                handleOnCompletionException$kotlinx_coroutines_core(completionHandlerException);
                return;
            }
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
    }

    public final boolean start() {
        int startInternal;
        do {
            startInternal = startInternal(getState$kotlinx_coroutines_core());
            if (startInternal == 0) {
                return false;
            }
        } while (startInternal != 1);
        return true;
    }

    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v1 */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r4v0, types: [kotlinx.coroutines.NonDisposableHandle] */
    /* JADX WARNING: type inference failed for: r4v1, types: [kotlinx.coroutines.DisposableHandle] */
    /* JADX WARNING: type inference failed for: r1v3 */
    /* JADX WARNING: type inference failed for: r1v4, types: [kotlinx.coroutines.DisposableHandle, kotlinx.coroutines.JobNode] */
    /* JADX WARNING: type inference failed for: r1v5, types: [kotlinx.coroutines.JobNode] */
    /* JADX WARNING: type inference failed for: r4v2 */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r1v7, types: [kotlinx.coroutines.DisposableHandle, kotlinx.coroutines.JobNode] */
    /* JADX WARNING: type inference failed for: r4v4 */
    /* JADX WARNING: type inference failed for: r1v8, types: [kotlinx.coroutines.JobNode] */
    /* JADX WARNING: type inference failed for: r1v9, types: [kotlinx.coroutines.DisposableHandle, java.lang.Object] */
    /* JADX WARNING: type inference failed for: r1v10, types: [kotlinx.coroutines.JobNode] */
    /* JADX WARNING: type inference failed for: r1v11 */
    /* JADX WARNING: type inference failed for: r1v12 */
    /* JADX WARNING: type inference failed for: r1v13 */
    /* JADX WARNING: type inference failed for: r4v6 */
    /* JADX WARNING: type inference failed for: r1v14 */
    /* JADX WARNING: type inference failed for: r1v15 */
    /* JADX WARNING: type inference failed for: r1v16 */
    /* JADX WARNING: type inference failed for: r1v17 */
    /* JADX WARNING: type inference failed for: r1v18 */
    /* JADX WARNING: type inference failed for: r1v19 */
    /* JADX WARNING: type inference failed for: r1v20 */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0007, code lost:
        r1 = r1;
     */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r1v2
  assigns: []
  uses: []
  mth insns count: 91
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1507)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1507)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1507)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
    	at jadx.core.ProcessClass.process(ProcessClass.java:35)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Unknown variable types count: 8 */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlinx.coroutines.DisposableHandle invokeOnCompletion(boolean r8, boolean r9, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Throwable, kotlin.Unit> r10) {
        /*
            r7 = this;
            java.lang.String r0 = "handler"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r10, r0)
            r0 = 0
            r1 = r0
        L_0x0007:
            java.lang.Object r2 = r7.getState$kotlinx_coroutines_core()
            boolean r3 = r2 instanceof kotlinx.coroutines.Empty
            if (r3 == 0) goto L_0x002c
            r3 = r2
            kotlinx.coroutines.Empty r3 = (kotlinx.coroutines.Empty) r3
            boolean r4 = r3.isActive()
            if (r4 == 0) goto L_0x0028
            if (r1 == 0) goto L_0x001b
            goto L_0x001f
        L_0x001b:
            kotlinx.coroutines.JobNode r1 = r7.makeNode(r10, r8)
        L_0x001f:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r3 = _state$FU
            boolean r2 = r3.compareAndSet(r7, r2, r1)
            if (r2 == 0) goto L_0x0007
            return r1
        L_0x0028:
            r7.promoteEmptyToNodeList(r3)
            goto L_0x0007
        L_0x002c:
            boolean r3 = r2 instanceof kotlinx.coroutines.Incomplete
            if (r3 == 0) goto L_0x0096
            r3 = r2
            kotlinx.coroutines.Incomplete r3 = (kotlinx.coroutines.Incomplete) r3
            kotlinx.coroutines.NodeList r3 = r3.getList()
            if (r3 != 0) goto L_0x0049
            if (r2 == 0) goto L_0x0041
            kotlinx.coroutines.JobNode r2 = (kotlinx.coroutines.JobNode) r2
            r7.promoteSingleToNodeList(r2)
            goto L_0x0007
        L_0x0041:
            kotlin.TypeCastException r8 = new kotlin.TypeCastException
            java.lang.String r9 = "null cannot be cast to non-null type kotlinx.coroutines.JobNode<*>"
            r8.<init>(r9)
            throw r8
        L_0x0049:
            kotlinx.coroutines.NonDisposableHandle r4 = kotlinx.coroutines.NonDisposableHandle.INSTANCE
            if (r8 == 0) goto L_0x007f
            boolean r5 = r2 instanceof kotlinx.coroutines.JobSupport.Finishing
            if (r5 == 0) goto L_0x007f
            monitor-enter(r2)
            r5 = r2
            kotlinx.coroutines.JobSupport$Finishing r5 = (kotlinx.coroutines.JobSupport.Finishing) r5     // Catch:{ all -> 0x007c }
            java.lang.Throwable r5 = r5.rootCause     // Catch:{ all -> 0x007c }
            if (r5 == 0) goto L_0x0064
            boolean r6 = r10 instanceof kotlinx.coroutines.ChildHandleNode     // Catch:{ all -> 0x007c }
            if (r6 == 0) goto L_0x0078
            r6 = r2
            kotlinx.coroutines.JobSupport$Finishing r6 = (kotlinx.coroutines.JobSupport.Finishing) r6     // Catch:{ all -> 0x007c }
            boolean r6 = r6.isCompleting     // Catch:{ all -> 0x007c }
            if (r6 != 0) goto L_0x0078
        L_0x0064:
            if (r1 == 0) goto L_0x0067
            goto L_0x006b
        L_0x0067:
            kotlinx.coroutines.JobNode r1 = r7.makeNode(r10, r8)     // Catch:{ all -> 0x007c }
        L_0x006b:
            boolean r4 = r7.addLastAtomic(r2, r3, r1)     // Catch:{ all -> 0x007c }
            if (r4 != 0) goto L_0x0073
            monitor-exit(r2)
            goto L_0x0007
        L_0x0073:
            if (r5 != 0) goto L_0x0077
            monitor-exit(r2)
            return r1
        L_0x0077:
            r4 = r1
        L_0x0078:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x007c }
            monitor-exit(r2)
            goto L_0x0080
        L_0x007c:
            r8 = move-exception
            monitor-exit(r2)
            throw r8
        L_0x007f:
            r5 = r0
        L_0x0080:
            if (r5 == 0) goto L_0x0088
            if (r9 == 0) goto L_0x0087
            r10.invoke(r5)
        L_0x0087:
            return r4
        L_0x0088:
            if (r1 == 0) goto L_0x008b
            goto L_0x008f
        L_0x008b:
            kotlinx.coroutines.JobNode r1 = r7.makeNode(r10, r8)
        L_0x008f:
            boolean r2 = r7.addLastAtomic(r2, r3, r1)
            if (r2 == 0) goto L_0x0007
            return r1
        L_0x0096:
            if (r9 == 0) goto L_0x00a6
            boolean r8 = r2 instanceof kotlinx.coroutines.CompletedExceptionally
            if (r8 != 0) goto L_0x009d
            r2 = r0
        L_0x009d:
            kotlinx.coroutines.CompletedExceptionally r2 = (kotlinx.coroutines.CompletedExceptionally) r2
            if (r2 == 0) goto L_0x00a3
            java.lang.Throwable r0 = r2.cause
        L_0x00a3:
            r10.invoke(r0)
        L_0x00a6:
            kotlinx.coroutines.NonDisposableHandle r8 = kotlinx.coroutines.NonDisposableHandle.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.JobSupport.invokeOnCompletion(boolean, boolean, kotlin.jvm.functions.Function1):kotlinx.coroutines.DisposableHandle");
    }

    private final boolean addLastAtomic(Object obj, NodeList nodeList, JobNode<?> jobNode) {
        int tryCondAddNext;
        JobSupport$addLastAtomic$$inlined$addLastIf$1 jobSupport$addLastAtomic$$inlined$addLastIf$1 = new JobSupport$addLastAtomic$$inlined$addLastIf$1(jobNode, jobNode, this, obj);
        do {
            Object prev = nodeList.getPrev();
            if (prev != null) {
                tryCondAddNext = ((LockFreeLinkedListNode) prev).tryCondAddNext(jobNode, nodeList, jobSupport$addLastAtomic$$inlined$addLastIf$1);
                if (tryCondAddNext == 1) {
                    return true;
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            }
        } while (tryCondAddNext != 2);
        return false;
    }

    private final boolean joinInternal() {
        Object state$kotlinx_coroutines_core;
        do {
            state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (!(state$kotlinx_coroutines_core instanceof Incomplete)) {
                return false;
            }
        } while (startInternal(state$kotlinx_coroutines_core) < 0);
        return true;
    }

    /* access modifiers changed from: 0000 */
    @Nullable
    public final /* synthetic */ Object joinSuspend(@NotNull Continuation<? super Unit> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuationKt.disposeOnCancellation(cancellableContinuationImpl, invokeOnCompletion(new ResumeOnCompletion(this, cancellableContinuationImpl)));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public final <R> void registerSelectClause0(@NotNull SelectInstance<? super R> selectInstance, @NotNull Function1<? super Continuation<? super R>, ? extends Object> function1) {
        Object state$kotlinx_coroutines_core;
        Intrinsics.checkParameterIsNotNull(selectInstance, "select");
        Intrinsics.checkParameterIsNotNull(function1, "block");
        do {
            state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (!selectInstance.isSelected()) {
                if (!(state$kotlinx_coroutines_core instanceof Incomplete)) {
                    if (selectInstance.trySelect(null)) {
                        YieldKt.checkCompletion(selectInstance.getCompletion().getContext());
                        UndispatchedKt.startCoroutineUnintercepted(function1, selectInstance.getCompletion());
                    }
                    return;
                }
            } else {
                return;
            }
        } while (startInternal(state$kotlinx_coroutines_core) != 0);
        selectInstance.disposeOnSelect(invokeOnCompletion(new SelectJoinOnCompletion(this, selectInstance, function1)));
    }

    public final void removeNode$kotlinx_coroutines_core(@NotNull JobNode<?> jobNode) {
        Object state$kotlinx_coroutines_core;
        Intrinsics.checkParameterIsNotNull(jobNode, "node");
        do {
            state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (!(state$kotlinx_coroutines_core instanceof JobNode)) {
                if ((state$kotlinx_coroutines_core instanceof Incomplete) && ((Incomplete) state$kotlinx_coroutines_core).getList() != null) {
                    jobNode.remove();
                }
                return;
            } else if (state$kotlinx_coroutines_core != jobNode) {
                return;
            }
        } while (!_state$FU.compareAndSet(this, state$kotlinx_coroutines_core, JobSupportKt.EMPTY_ACTIVE));
    }

    private final boolean cancelMakeCompleting(Object obj) {
        int tryMakeCompleting;
        do {
            Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if ((state$kotlinx_coroutines_core instanceof Incomplete) && (!(state$kotlinx_coroutines_core instanceof Finishing) || !((Finishing) state$kotlinx_coroutines_core).isCompleting)) {
                tryMakeCompleting = tryMakeCompleting(state$kotlinx_coroutines_core, new CompletedExceptionally(createCauseException(obj)), 0);
                if (tryMakeCompleting != 0) {
                    if (tryMakeCompleting == 1 || tryMakeCompleting == 2) {
                        return true;
                    }
                }
            }
            return false;
        } while (tryMakeCompleting == 3);
        throw new IllegalStateException("unexpected result".toString());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003c, code lost:
        if (r8 == null) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x003e, code lost:
        notifyCancelling(((kotlinx.coroutines.JobSupport.Finishing) r2).getList(), r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0047, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean makeCancelling(java.lang.Object r8) {
        /*
            r7 = this;
            r0 = 0
            r1 = r0
        L_0x0002:
            java.lang.Object r2 = r7.getState$kotlinx_coroutines_core()
            boolean r3 = r2 instanceof kotlinx.coroutines.JobSupport.Finishing
            r4 = 0
            r5 = 1
            if (r3 == 0) goto L_0x004b
            monitor-enter(r2)
            r3 = r2
            kotlinx.coroutines.JobSupport$Finishing r3 = (kotlinx.coroutines.JobSupport.Finishing) r3     // Catch:{ all -> 0x0048 }
            boolean r3 = r3.isSealed()     // Catch:{ all -> 0x0048 }
            if (r3 == 0) goto L_0x0018
            monitor-exit(r2)
            return r4
        L_0x0018:
            r3 = r2
            kotlinx.coroutines.JobSupport$Finishing r3 = (kotlinx.coroutines.JobSupport.Finishing) r3     // Catch:{ all -> 0x0048 }
            boolean r3 = r3.isCancelling()     // Catch:{ all -> 0x0048 }
            if (r8 != 0) goto L_0x0023
            if (r3 != 0) goto L_0x0030
        L_0x0023:
            if (r1 == 0) goto L_0x0026
            goto L_0x002a
        L_0x0026:
            java.lang.Throwable r1 = r7.createCauseException(r8)     // Catch:{ all -> 0x0048 }
        L_0x002a:
            r8 = r2
            kotlinx.coroutines.JobSupport$Finishing r8 = (kotlinx.coroutines.JobSupport.Finishing) r8     // Catch:{ all -> 0x0048 }
            r8.addExceptionLocked(r1)     // Catch:{ all -> 0x0048 }
        L_0x0030:
            r8 = r2
            kotlinx.coroutines.JobSupport$Finishing r8 = (kotlinx.coroutines.JobSupport.Finishing) r8     // Catch:{ all -> 0x0048 }
            java.lang.Throwable r8 = r8.rootCause     // Catch:{ all -> 0x0048 }
            r1 = r3 ^ 1
            if (r1 == 0) goto L_0x003a
            goto L_0x003b
        L_0x003a:
            r8 = r0
        L_0x003b:
            monitor-exit(r2)
            if (r8 == 0) goto L_0x0047
            kotlinx.coroutines.JobSupport$Finishing r2 = (kotlinx.coroutines.JobSupport.Finishing) r2
            kotlinx.coroutines.NodeList r0 = r2.getList()
            r7.notifyCancelling(r0, r8)
        L_0x0047:
            return r5
        L_0x0048:
            r8 = move-exception
            monitor-exit(r2)
            throw r8
        L_0x004b:
            boolean r3 = r2 instanceof kotlinx.coroutines.Incomplete
            if (r3 == 0) goto L_0x00a2
            if (r1 == 0) goto L_0x0052
            goto L_0x0056
        L_0x0052:
            java.lang.Throwable r1 = r7.createCauseException(r8)
        L_0x0056:
            r3 = r2
            kotlinx.coroutines.Incomplete r3 = (kotlinx.coroutines.Incomplete) r3
            boolean r6 = r3.isActive()
            if (r6 == 0) goto L_0x0066
            boolean r2 = r7.tryMakeCancelling(r3, r1)
            if (r2 == 0) goto L_0x0002
            return r5
        L_0x0066:
            kotlinx.coroutines.CompletedExceptionally r3 = new kotlinx.coroutines.CompletedExceptionally
            r3.<init>(r1)
            int r3 = r7.tryMakeCompleting(r2, r3, r4)
            if (r3 == 0) goto L_0x0087
            if (r3 == r5) goto L_0x0086
            r2 = 2
            if (r3 == r2) goto L_0x0086
            r2 = 3
            if (r3 != r2) goto L_0x007a
            goto L_0x0002
        L_0x007a:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "unexpected result"
            java.lang.String r0 = r0.toString()
            r8.<init>(r0)
            throw r8
        L_0x0086:
            return r5
        L_0x0087:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r0 = "Cannot happen in "
            r8.append(r0)
            r8.append(r2)
            java.lang.String r8 = r8.toString()
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r8 = r8.toString()
            r0.<init>(r8)
            throw r0
        L_0x00a2:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.JobSupport.makeCancelling(java.lang.Object):boolean");
    }

    public final boolean makeCompleting$kotlinx_coroutines_core(@Nullable Object obj) {
        int tryMakeCompleting;
        do {
            boolean z = false;
            tryMakeCompleting = tryMakeCompleting(getState$kotlinx_coroutines_core(), obj, 0);
            if (tryMakeCompleting != 0) {
                z = true;
                if (!(tryMakeCompleting == 1 || tryMakeCompleting == 2)) {
                }
            }
            return z;
        } while (tryMakeCompleting == 3);
        throw new IllegalStateException("unexpected result".toString());
    }

    public final boolean makeCompletingOnce$kotlinx_coroutines_core(@Nullable Object obj, int i) {
        int tryMakeCompleting;
        do {
            tryMakeCompleting = tryMakeCompleting(getState$kotlinx_coroutines_core(), obj, i);
            if (tryMakeCompleting == 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("Job ");
                sb.append(this);
                sb.append(" is already complete or completing, ");
                sb.append("but is being completed with ");
                sb.append(obj);
                throw new IllegalStateException(sb.toString(), getExceptionOrNull(obj));
            } else if (tryMakeCompleting == 1) {
                return true;
            } else {
                if (tryMakeCompleting == 2) {
                    return false;
                }
            }
        } while (tryMakeCompleting == 3);
        throw new IllegalStateException("unexpected result".toString());
    }

    public final <T, R> void registerSelectClause1Internal$kotlinx_coroutines_core(@NotNull SelectInstance<? super R> selectInstance, @NotNull Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2) {
        Object state$kotlinx_coroutines_core;
        Intrinsics.checkParameterIsNotNull(selectInstance, "select");
        Intrinsics.checkParameterIsNotNull(function2, "block");
        do {
            state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (!selectInstance.isSelected()) {
                if (!(state$kotlinx_coroutines_core instanceof Incomplete)) {
                    if (selectInstance.trySelect(null)) {
                        if (state$kotlinx_coroutines_core instanceof CompletedExceptionally) {
                            selectInstance.resumeSelectCancellableWithException(((CompletedExceptionally) state$kotlinx_coroutines_core).cause);
                        } else {
                            UndispatchedKt.startCoroutineUnintercepted(function2, state$kotlinx_coroutines_core, selectInstance.getCompletion());
                        }
                    }
                    return;
                }
            } else {
                return;
            }
        } while (startInternal(state$kotlinx_coroutines_core) != 0);
        selectInstance.disposeOnSelect(invokeOnCompletion(new SelectAwaitOnCompletion(this, selectInstance, function2)));
    }
}
