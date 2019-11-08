package kr.co.popone.fitts.feature.post.upload.create;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kr.co.popone.fitts.C0003R$array;
import org.jetbrains.annotations.NotNull;

final class CreatePostActivity$styles$2 extends Lambda implements Function0<List<? extends String>> {
    final /* synthetic */ CreatePostActivity this$0;

    CreatePostActivity$styles$2(CreatePostActivity createPostActivity) {
        this.this$0 = createPostActivity;
        super(0);
    }

    @NotNull
    public final List<String> invoke() {
        String[] stringArray = this.this$0.getResources().getStringArray(C0003R$array.fitts_styles);
        Intrinsics.checkExpressionValueIsNotNull(stringArray, "resources.getStringArray(R.array.fitts_styles)");
        return ArraysKt___ArraysKt.toList((T[]) stringArray);
    }
}
