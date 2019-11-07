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

final class PostFeedDoubleHolder$leftPost$2 extends Lambda implements Function0<PostFeedView> {
    final /* synthetic */ PostFeedDoubleHolder this$0;

    PostFeedDoubleHolder$leftPost$2(PostFeedDoubleHolder postFeedDoubleHolder) {
        this.this$0 = postFeedDoubleHolder;
        super(0);
    }

    @NotNull
    public final PostFeedView invoke() {
        View access$getLeft$p = this.this$0.left;
        Intrinsics.checkExpressionValueIsNotNull(access$getLeft$p, "this");
        RoundImageView roundImageView = (RoundImageView) access$getLeft$p.findViewById(C0010R$id.ivBigPostCover);
        Intrinsics.checkExpressionValueIsNotNull(roundImageView, "ivBigPostCover");
        CircleImageView circleImageView = (CircleImageView) access$getLeft$p.findViewById(C0010R$id.ivBigPostFittie);
        Intrinsics.checkExpressionValueIsNotNull(circleImageView, "ivBigPostFittie");
        TextView textView = (TextView) access$getLeft$p.findViewById(C0010R$id.tvPostTitle);
        Intrinsics.checkExpressionValueIsNotNull(textView, "tvPostTitle");
        TextView textView2 = (TextView) access$getLeft$p.findViewById(C0010R$id.tvBigPostFittie);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "tvBigPostFittie");
        View findViewById = access$getLeft$p.findViewById(C0010R$id.viewFittieBlueDot);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "viewFittieBlueDot");
        PostFeedView postFeedView = new PostFeedView(access$getLeft$p, roundImageView, circleImageView, textView, textView2, findViewById);
        return postFeedView;
    }
}
