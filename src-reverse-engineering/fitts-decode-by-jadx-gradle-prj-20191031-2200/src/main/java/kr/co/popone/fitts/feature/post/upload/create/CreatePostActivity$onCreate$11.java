package kr.co.popone.fitts.feature.post.upload.create;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0009R$font;
import org.jetbrains.annotations.NotNull;

final class CreatePostActivity$onCreate$11<T, R> implements Function<T, R> {
    public static final CreatePostActivity$onCreate$11 INSTANCE = new CreatePostActivity$onCreate$11();

    CreatePostActivity$onCreate$11() {
    }

    public /* bridge */ /* synthetic */ Object apply(Object obj) {
        return Integer.valueOf(apply((Boolean) obj));
    }

    public final int apply(@NotNull Boolean bool) {
        Intrinsics.checkParameterIsNotNull(bool, "it");
        return bool.booleanValue() ? C0009R$font.kopubdotum_pro : C0009R$font.kopubdotum_pro_bold;
    }
}
