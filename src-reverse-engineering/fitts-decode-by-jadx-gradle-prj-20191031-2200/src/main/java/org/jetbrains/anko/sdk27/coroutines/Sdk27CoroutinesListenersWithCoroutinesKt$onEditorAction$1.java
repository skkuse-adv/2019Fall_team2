package org.jetbrains.anko.sdk27.coroutines;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import kotlin.Result.Failure;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class Sdk27CoroutinesListenersWithCoroutinesKt$onEditorAction$1 implements OnEditorActionListener {
    final /* synthetic */ CoroutineContext $context;
    final /* synthetic */ Function5 $handler;
    final /* synthetic */ boolean $returnValue;

    @DebugMetadata(c = "org/jetbrains/anko/sdk27/coroutines/Sdk27CoroutinesListenersWithCoroutinesKt$onEditorAction$1$1", f = "ListenersWithCoroutines.kt", i = {}, l = {1030, 1032}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: org.jetbrains.anko.sdk27.coroutines.Sdk27CoroutinesListenersWithCoroutinesKt$onEditorAction$1$1 reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        private CoroutineScope p$;
        final /* synthetic */ Sdk27CoroutinesListenersWithCoroutinesKt$onEditorAction$1 this$0;

        {
            this.this$0 = r1;
        }

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            Intrinsics.checkParameterIsNotNull(continuation, "completion");
            AnonymousClass1 r1 = new AnonymousClass1(this.this$0, textView2, i2, keyEvent2, continuation);
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
                Function5 function5 = this.this$0.$handler;
                TextView textView = textView2;
                Integer boxInt = Boxing.boxInt(i2);
                KeyEvent keyEvent = keyEvent2;
                this.label = 1;
                if (function5.invoke(coroutineScope, textView, boxInt, keyEvent, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                throw ((Failure) obj).exception;
            }
            return Unit.INSTANCE;
        }
    }

    Sdk27CoroutinesListenersWithCoroutinesKt$onEditorAction$1(CoroutineContext coroutineContext, Function5 function5, boolean z) {
        this.$context = coroutineContext;
        this.$handler = function5;
        this.$returnValue = z;
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        GlobalScope globalScope = GlobalScope.INSTANCE;
        CoroutineContext coroutineContext = this.$context;
        CoroutineStart coroutineStart = CoroutineStart.DEFAULT;
        final TextView textView2 = textView;
        final int i2 = i;
        final KeyEvent keyEvent2 = keyEvent;
        AnonymousClass1 r3 = new AnonymousClass1(this, null);
        BuildersKt.launch(globalScope, coroutineContext, coroutineStart, r3);
        return this.$returnValue;
    }
}
