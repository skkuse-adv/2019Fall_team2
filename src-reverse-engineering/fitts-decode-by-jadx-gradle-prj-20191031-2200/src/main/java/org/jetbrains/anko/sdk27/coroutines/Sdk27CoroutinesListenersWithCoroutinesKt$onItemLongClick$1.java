package org.jetbrains.anko.sdk27.coroutines;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
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

final class Sdk27CoroutinesListenersWithCoroutinesKt$onItemLongClick$1 implements OnItemLongClickListener {
    final /* synthetic */ CoroutineContext $context;
    final /* synthetic */ Function6 $handler;
    final /* synthetic */ boolean $returnValue;

    @DebugMetadata(c = "org/jetbrains/anko/sdk27/coroutines/Sdk27CoroutinesListenersWithCoroutinesKt$onItemLongClick$1$1", f = "ListenersWithCoroutines.kt", i = {}, l = {567, 569}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: org.jetbrains.anko.sdk27.coroutines.Sdk27CoroutinesListenersWithCoroutinesKt$onItemLongClick$1$1 reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        private CoroutineScope p$;
        final /* synthetic */ Sdk27CoroutinesListenersWithCoroutinesKt$onItemLongClick$1 this$0;

        {
            this.this$0 = r1;
        }

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            Intrinsics.checkParameterIsNotNull(continuation, "completion");
            AnonymousClass1 r1 = new AnonymousClass1(this.this$0, adapterView2, view2, i2, j2, continuation);
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
                AdapterView adapterView = adapterView2;
                View view = view2;
                Integer boxInt = Boxing.boxInt(i2);
                Long boxLong = Boxing.boxLong(j2);
                this.label = 1;
                if (function6.invoke(coroutineScope, adapterView, view, boxInt, boxLong, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                throw ((Failure) obj).exception;
            }
            return Unit.INSTANCE;
        }
    }

    Sdk27CoroutinesListenersWithCoroutinesKt$onItemLongClick$1(CoroutineContext coroutineContext, Function6 function6, boolean z) {
        this.$context = coroutineContext;
        this.$handler = function6;
        this.$returnValue = z;
    }

    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        GlobalScope globalScope = GlobalScope.INSTANCE;
        CoroutineContext coroutineContext = this.$context;
        CoroutineStart coroutineStart = CoroutineStart.DEFAULT;
        final AdapterView<?> adapterView2 = adapterView;
        final View view2 = view;
        final int i2 = i;
        final long j2 = j;
        AnonymousClass1 r0 = new AnonymousClass1(this, null);
        BuildersKt.launch(globalScope, coroutineContext, coroutineStart, r0);
        return this.$returnValue;
    }
}
