package kr.co.popone.fitts.feature.me;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class ModifyBodyActivity$onCreate$6<T, R> implements Function<Throwable, Integer> {
    final /* synthetic */ ModifyBodyActivity this$0;

    ModifyBodyActivity$onCreate$6(ModifyBodyActivity modifyBodyActivity) {
        this.this$0 = modifyBodyActivity;
    }

    @Nullable
    public final Integer apply(@NotNull Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "it");
        return this.this$0.getBodyInfo().getHeight();
    }
}
