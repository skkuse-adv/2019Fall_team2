package kr.co.popone.fitts.feature.post.upload.create;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

final class CreatePostActivity$onCreate$33<T> implements Predicate<String> {
    public static final CreatePostActivity$onCreate$33 INSTANCE = new CreatePostActivity$onCreate$33();

    CreatePostActivity$onCreate$33() {
    }

    public final boolean test(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "it");
        return str.length() > 0;
    }
}
