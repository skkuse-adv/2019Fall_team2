package kr.co.popone.fitts.feature.post.upload.crop;

import android.text.Editable;
import android.text.TextWatcher;
import com.kakao.message.template.MessageTemplateProtocol;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.post.upload.crop.PostImageDetailAdapter.ItemViewHolder;
import kr.co.popone.fitts.model.datamodel.service.post.CreatePostImage;
import org.jetbrains.annotations.NotNull;

public final class PostImageDetailAdapter$onCreateViewHolder$1 implements TextWatcher {
    final /* synthetic */ ItemViewHolder $viewHolder;
    final /* synthetic */ PostImageDetailAdapter this$0;

    public void afterTextChanged(@NotNull Editable editable) {
        Intrinsics.checkParameterIsNotNull(editable, "arg0");
    }

    public void beforeTextChanged(@NotNull CharSequence charSequence, int i, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(charSequence, "s");
    }

    PostImageDetailAdapter$onCreateViewHolder$1(PostImageDetailAdapter postImageDetailAdapter, ItemViewHolder itemViewHolder) {
        this.this$0 = postImageDetailAdapter;
        this.$viewHolder = itemViewHolder;
    }

    public void onTextChanged(@NotNull CharSequence charSequence, int i, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(charSequence, MessageTemplateProtocol.DESCRIPTION);
        Object obj = this.this$0.delegate.getPostImages().get(this.$viewHolder.getItemPosition());
        Intrinsics.checkExpressionValueIsNotNull(obj, "delegate.postImages[viewHolder.itemPosition]");
        ((CreatePostImage) obj).setDescription(charSequence.toString());
    }
}
