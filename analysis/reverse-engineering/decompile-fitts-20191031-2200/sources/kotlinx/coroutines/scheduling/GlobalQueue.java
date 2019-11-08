package kotlinx.coroutines.scheduling;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.LockFreeMPMCQueue;
import kotlinx.coroutines.internal.LockFreeMPMCQueueNode;
import org.jetbrains.annotations.NotNull;

public class GlobalQueue extends LockFreeMPMCQueue<Task> {
    public final boolean add(@NotNull Task task) {
        Intrinsics.checkParameterIsNotNull(task, "task");
        while (true) {
            LockFreeMPMCQueueNode tailValue = getTailValue();
            LockFreeMPMCQueueNode lockFreeMPMCQueueNode = (LockFreeMPMCQueueNode) tailValue.getNextValue();
            if (lockFreeMPMCQueueNode != null) {
                tailCas(tailValue, lockFreeMPMCQueueNode);
            } else {
                if (!(tailValue != TasksKt.getCLOSED_TASK())) {
                    return false;
                }
                if (tailValue.nextCas(null, task)) {
                    tailCas(tailValue, task);
                    return true;
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START] */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlinx.coroutines.scheduling.Task removeFirstIfNotClosed() {
        /*
            r5 = this;
        L_0x0000:
            kotlinx.coroutines.internal.LockFreeMPMCQueueNode r0 = r5.getHeadValue()
            java.lang.Object r1 = r0.getNextValue()
            kotlinx.coroutines.internal.LockFreeMPMCQueueNode r1 = (kotlinx.coroutines.internal.LockFreeMPMCQueueNode) r1
            r2 = 0
            if (r1 == 0) goto L_0x0023
            r3 = r1
            kotlinx.coroutines.scheduling.Task r3 = (kotlinx.coroutines.scheduling.Task) r3
            kotlinx.coroutines.scheduling.Task r4 = kotlinx.coroutines.scheduling.TasksKt.getCLOSED_TASK()
            if (r3 == r4) goto L_0x0018
            r3 = 1
            goto L_0x0019
        L_0x0018:
            r3 = 0
        L_0x0019:
            if (r3 != 0) goto L_0x001c
            goto L_0x0023
        L_0x001c:
            boolean r0 = r5.headCas(r0, r1)
            if (r0 == 0) goto L_0x0000
            r2 = r1
        L_0x0023:
            kotlinx.coroutines.scheduling.Task r2 = (kotlinx.coroutines.scheduling.Task) r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.scheduling.GlobalQueue.removeFirstIfNotClosed():kotlinx.coroutines.scheduling.Task");
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START] */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public kotlinx.coroutines.scheduling.Task removeFirstBlockingModeOrNull() {
        /*
            r5 = this;
        L_0x0000:
            kotlinx.coroutines.internal.LockFreeMPMCQueueNode r0 = r5.getHeadValue()
            java.lang.Object r1 = r0.getNextValue()
            kotlinx.coroutines.internal.LockFreeMPMCQueueNode r1 = (kotlinx.coroutines.internal.LockFreeMPMCQueueNode) r1
            r2 = 0
            if (r1 == 0) goto L_0x0025
            r3 = r1
            kotlinx.coroutines.scheduling.Task r3 = (kotlinx.coroutines.scheduling.Task) r3
            kotlinx.coroutines.scheduling.TaskMode r3 = r3.getMode()
            kotlinx.coroutines.scheduling.TaskMode r4 = kotlinx.coroutines.scheduling.TaskMode.PROBABLY_BLOCKING
            if (r3 != r4) goto L_0x001a
            r3 = 1
            goto L_0x001b
        L_0x001a:
            r3 = 0
        L_0x001b:
            if (r3 != 0) goto L_0x001e
            goto L_0x0025
        L_0x001e:
            boolean r0 = r5.headCas(r0, r1)
            if (r0 == 0) goto L_0x0000
            r2 = r1
        L_0x0025:
            kotlinx.coroutines.scheduling.Task r2 = (kotlinx.coroutines.scheduling.Task) r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.scheduling.GlobalQueue.removeFirstBlockingModeOrNull():kotlinx.coroutines.scheduling.Task");
    }
}
