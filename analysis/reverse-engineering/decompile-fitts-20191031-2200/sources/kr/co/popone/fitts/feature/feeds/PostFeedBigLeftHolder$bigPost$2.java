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

final class PostFeedBigLeftHolder$bigPost$2 extends Lambda implements Function0<PostFeedView> {
    final /* synthetic */ View $itemView;

    PostFeedBigLeftHolder$bigPost$2(View view) {
        this.$itemView = view;
        super(0);
    }

    @NotNull
    public final PostFeedView invoke() {
        View findViewById = this.$itemView.findViewById(C0010R$id.viewBigPostCover);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "this");
        RoundImageView roundImageView = (RoundImageView) findViewById.findViewById(C0010R$id.ivBigPostCover);
        Intrinsics.checkExpressionValueIsNotNull(roundImageView, "ivBigPostCover");
        CircleImageView circleImageView = (CircleImageView) findViewById.findViewById(C0010R$id.ivBigPostFittie);
        Intrinsics.checkExpressionValueIsNotNull(circleImageView, "ivBigPostFittie");
        TextView textView = (TextView) findViewById.findViewById(C0010R$id.tvPostTitle);
        Intrinsics.checkExpressionValueIsNotNull(textView, "tvPostTitle");
        TextView textView2 = (TextView) findViewById.findViewById(C0010R$id.tvBigPostFittie);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "tvBigPostFittie");
        View findViewById2 = findViewById.findViewById(C0010R$id.viewFittieBlueDot);
        Intrinsics.checkExpressionValueIsNotNull(findViewById2, "viewFittieBlueDot");
        PostFeedView postFeedView = new PostFeedView(findViewById, roundImageView, circleImageView, textView, textView2, findViewById2);
        return postFeedView;
    }
}
