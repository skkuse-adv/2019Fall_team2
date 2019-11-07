package kr.co.popone.fitts.feature.feeds;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kr.co.popone.fitts.model.datamodel.social.feed.FeedVariantInfo;
import kr.co.popone.fitts.model.datamodel.social.feed.PostFeedView;
import org.jetbrains.annotations.NotNull;

final class PostFeedBigRightHolder$initView$$inlined$with$lambda$1 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ FeedVariantInfo $item$inlined;
    final /* synthetic */ PostFeedBigRightHolder this$0;

    PostFeedBigRightHolder$initView$$inlined$with$lambda$1(PostFeedBigRightHolder postFeedBigRightHolder, FeedVariantInfo feedVariantInfo, PostFeedView postFeedView) {
        this.this$0 = postFeedBigRightHolder;
        this.$item$inlined = feedVariantInfo;
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((View) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "it");
        this.this$0.getDelegate().onPostClick(this.$item$inlined.getFeed().getId());
    }
}
