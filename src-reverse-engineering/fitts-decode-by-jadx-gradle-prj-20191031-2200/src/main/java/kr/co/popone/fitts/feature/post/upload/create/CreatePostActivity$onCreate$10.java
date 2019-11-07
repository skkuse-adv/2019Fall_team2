package kr.co.popone.fitts.feature.post.upload.create;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

final class CreatePostActivity$onCreate$10<T, R> implements Function<T, R> {
    public static final CreatePostActivity$onCreate$10 INSTANCE = new CreatePostActivity$onCreate$10();

    CreatePostActivity$onCreate$10() {
    }

    public /* bridge */ /* synthetic */ Object apply(Object obj) {
        return Boolean.valueOf(apply((CharSequence) obj));
    }

    public final boolean apply(@NotNull CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(charSequence, "it");
        return charSequence.length() == 0;
    }
}
