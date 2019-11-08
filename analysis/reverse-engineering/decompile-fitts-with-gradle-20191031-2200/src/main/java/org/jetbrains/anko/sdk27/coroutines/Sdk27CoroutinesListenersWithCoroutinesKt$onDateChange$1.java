package org.jetbrains.anko.sdk27.coroutines;

import android.widget.CalendarView;
import android.widget.CalendarView.OnDateChangeListener;
import kotlin.Result.Failure;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class Sdk27CoroutinesListenersWithCoroutinesKt$onDateChange$1 implements OnDateChangeListener {
    final /* synthetic */ CoroutineContext $context;
    final /* synthetic */ Function6 $handler;

    @DebugMetadata(c = "org/jetbrains/anko/sdk27/coroutines/Sdk27CoroutinesListenersWithCoroutinesKt$onDateChange$1$1", f = "ListenersWithCoroutines.kt", i = {}, l = {631, 633}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: org.jetbrains.anko.sdk27.coroutines.Sdk27CoroutinesListenersWithCoroutinesKt$onDateChange$1$1 reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        private CoroutineScope p$;
        final /* synthetic */ Sdk27CoroutinesListenersWithCoroutinesKt$onDateChange$1 this$0;

        {
            this.this$0 = r1;
        }

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            Intrinsics.checkParameterIsNotNull(continuation, "completion");
            AnonymousClass1 r1 = new AnonymousClass1(this.this$0, calendarView2, i4, i5, i6, continuation);
            r1.p$ = (CoroutineScope) obj;
            return r1;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else if (obj instanceof Failure) {
                    throw ((Failure) obj).exception;
                }
            } else if (!(obj instanceof Failure)) {
                CoroutineScope coroutineScope = this.p$;
                Function6 function6 = this.this$0.$handler;
                CalendarView calendarView = calendarView2;
                Integer boxInt = Boxing.boxInt(i4);
                Integer boxInt2 = Boxing.boxInt(i5);
                Integer boxInt3 = Boxing.boxInt(i6);
                this.label = 1;
                if (function6.invoke(coroutineScope, calendarView, boxInt, boxInt2, boxInt3, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                throw ((Failure) obj).exception;
            }
            return Unit.INSTANCE;
        }
    }

    Sdk27CoroutinesListenersWithCoroutinesKt$onDateChange$1(CoroutineContext coroutineContext, Function6 function6) {
        this.$context = coroutineContext;
        this.$handler = function6;
    }

    public final void onSelectedDayChange(CalendarView calendarView, int i, int i2, int i3) {
        GlobalScope globalScope = GlobalScope.INSTANCE;
        CoroutineContext coroutineContext = this.$context;
        CoroutineStart coroutineStart = CoroutineStart.DEFAULT;
        final CalendarView calendarView2 = calendarView;
        final int i4 = i;
        final int i5 = i2;
        final int i6 = i3;
        AnonymousClass1 r3 = new AnonymousClass1(this, null);
        BuildersKt.launch(globalScope, coroutineContext, coroutineStart, r3);
    }
}
