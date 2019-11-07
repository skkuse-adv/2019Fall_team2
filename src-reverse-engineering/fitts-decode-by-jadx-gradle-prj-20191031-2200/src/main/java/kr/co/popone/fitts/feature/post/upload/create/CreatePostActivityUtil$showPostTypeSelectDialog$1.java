package kr.co.popone.fitts.feature.post.upload.create;

import android.app.Activity;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.order.PostableOrderLineItemVariant;

final class CreatePostActivityUtil$showPostTypeSelectDialog$1<T> implements Consumer<PostableOrderLineItemVariant> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ Function0 $dismiss;
    final /* synthetic */ String $from;
    final /* synthetic */ CreatePostActivityUtil this$0;

    CreatePostActivityUtil$showPostTypeSelectDialog$1(CreatePostActivityUtil createPostActivityUtil, Activity activity, String str, Function0 function0) {
        this.this$0 = createPostActivityUtil;
        this.$activity = activity;
        this.$from = str;
        this.$dismiss = function0;
    }

    public final void accept(PostableOrderLineItemVariant postableOrderLineItemVariant) {
        if (!postableOrderLineItemVariant.getPostableOlivs().isEmpty()) {
            CreatePostActivityUtil createPostActivityUtil = this.this$0;
            Activity activity = this.$activity;
            Intrinsics.checkExpressionValueIsNotNull(postableOrderLineItemVariant, "it");
            createPostActivityUtil.getPostPoint(activity, postableOrderLineItemVariant, this.$from, this.$dismiss);
            return;
        }
        CreatePostActivityUtil.getBannerList$default(this.this$0, this.$activity, this.$from, null, 4, null);
    }
}
