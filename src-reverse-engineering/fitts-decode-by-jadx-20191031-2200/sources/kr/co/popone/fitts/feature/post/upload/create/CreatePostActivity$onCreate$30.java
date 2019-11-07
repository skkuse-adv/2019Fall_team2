package kr.co.popone.fitts.feature.post.upload.create;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.post.PostType;
import org.jetbrains.annotations.NotNull;

final class CreatePostActivity$onCreate$30<T, R> implements Function<T, R> {
    public static final CreatePostActivity$onCreate$30 INSTANCE = new CreatePostActivity$onCreate$30();

    CreatePostActivity$onCreate$30() {
    }

    @NotNull
    public final PostType apply(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "it");
        String upperCase = str.toUpperCase();
        Intrinsics.checkExpressionValueIsNotNull(upperCase, "(this as java.lang.String).toUpperCase()");
        return PostType.valueOf(upperCase);
    }
}
