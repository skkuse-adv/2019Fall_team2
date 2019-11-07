package kr.co.popone.fitts.feature.post.upload.create;

import android.content.Intent;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kr.co.popone.fitts.C0001R$anim;
import kr.co.popone.fitts.feature.post.upload.crop.PostImageDetailActivity;
import kr.co.popone.fitts.model.datamodel.service.post.CreatePostImage;
import org.jetbrains.annotations.NotNull;

final class CreatePostActivity$onImageClick$1 extends Lambda implements Function1<ArrayList<CreatePostImage>, Unit> {
    final /* synthetic */ CreatePostActivity this$0;

    CreatePostActivity$onImageClick$1(CreatePostActivity createPostActivity) {
        this.this$0 = createPostActivity;
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ArrayList) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull ArrayList<CreatePostImage> arrayList) {
        Intrinsics.checkParameterIsNotNull(arrayList, "it");
        Intent intent = new Intent(this.this$0, PostImageDetailActivity.class);
        intent.putExtra("post_detail_data", arrayList);
        intent.putExtra("is_modify_data", true);
        ActivityOptionsCompat makeCustomAnimation = ActivityOptionsCompat.makeCustomAnimation(this.this$0, C0001R$anim.slide_up, C0001R$anim.fade_out);
        Intrinsics.checkExpressionValueIsNotNull(makeCustomAnimation, "ActivityOptionsCompat.ma…lide_up, R.anim.fade_out)");
        ActivityCompat.startActivityForResult(this.this$0, intent, 99, makeCustomAnimation.toBundle());
    }
}
