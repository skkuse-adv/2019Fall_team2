package kr.co.popone.fitts.feature.post.detail;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

final class PostActivity$productFromPostActionLog$1$1 extends Lambda implements Function1<Throwable, Unit> {
    public static final PostActivity$productFromPostActionLog$1$1 INSTANCE = new PostActivity$productFromPostActionLog$1$1();

    PostActivity$productFromPostActionLog$1$1() {
        super(1);
    }

    public final void invoke(@NotNull Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "it");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }
}
