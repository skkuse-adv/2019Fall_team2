package kr.co.popone.fitts.feature.post.upload.create;

import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Glide;
import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.C0010R$id;

final class CreatePostActivity$onCreate$57<T> implements Consumer<String> {
    final /* synthetic */ CreatePostActivity this$0;

    CreatePostActivity$onCreate$57(CreatePostActivity createPostActivity) {
        this.this$0 = createPostActivity;
    }

    public final void accept(String str) {
        Glide.with((FragmentActivity) this.this$0).load(str).into((ImageView) this.this$0._$_findCachedViewById(C0010R$id.post_cover_image));
        this.this$0.getViewModel().isCoverImageValidate();
    }
}
