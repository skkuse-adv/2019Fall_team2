package kr.co.popone.fitts.feature.feeds;

import android.view.View;
import android.widget.TextView;
import de.hdodenhof.circleimageview.CircleImageView;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.model.datamodel.social.feed.PostFeedView;
import kr.co.popone.fitts.ui.custom.RoundImageView;
import org.jetbrains.annotations.NotNull;

final class PostFeedDoubleHolder$rightPost$2 extends Lambda implements Function0<PostFeedView> {
    final /* synthetic */ PostFeedDoubleHolder this$0;

    PostFeedDoubleHolder$rightPost$2(PostFeedDoubleHolder postFeedDoubleHolder) {
        this.this$0 = postFeedDoubleHolder;
        super(0);
    }

    @NotNull
    public final PostFeedView invoke() {
        View access$getRight$p = this.this$0.right;
        Intrinsics.checkExpressionValueIsNotNull(access$getRight$p, "this");
        RoundImageView roundImageView = (RoundImageView) access$getRight$p.findViewById(C0010R$id.ivBigPostCover);
        Intrinsics.checkExpressionValueIsNotNull(roundImageView, "ivBigPostCover");
        CircleImageView circleImageView = (CircleImageView) access$getRight$p.findViewById(C0010R$id.ivBigPostFittie);
        Intrinsics.checkExpressionValueIsNotNull(circleImageView, "ivBigPostFittie");
        TextView textView = (TextView) access$getRight$p.findViewById(C0010R$id.tvPostTitle);
        Intrinsics.checkExpressionValueIsNotNull(textView, "tvPostTitle");
        TextView textView2 = (TextView) access$getRight$p.findViewById(C0010R$id.tvBigPostFittie);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "tvBigPostFittie");
        View findViewById = access$getRight$p.findViewById(C0010R$id.viewFittieBlueDot);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "viewFittieBlueDot");
        PostFeedView postFeedView = new PostFeedView(access$getRight$p, roundImageView, circleImageView, textView, textView2, findViewById);
        return postFeedView;
    }
}
