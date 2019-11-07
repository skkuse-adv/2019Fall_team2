package kr.co.popone.fitts.feature.home.feed;

import androidx.paging.PagedList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import kr.co.popone.fitts.model.datamodel.social.feed.Feed;
import org.jetbrains.annotations.NotNull;

final class HomeFeedFragment$onViewCreated$3 extends FunctionReference implements Function1<PagedList<Feed>, Unit> {
    HomeFeedFragment$onViewCreated$3(HomeFeedFragment homeFeedFragment) {
        super(1, homeFeedFragment);
    }

    public final String getName() {
        return "handleHomeFeeds";
    }

    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(HomeFeedFragment.class);
    }

    public final String getSignature() {
        return "handleHomeFeeds(Landroidx/paging/PagedList;)V";
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((PagedList) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull PagedList<Feed> pagedList) {
        Intrinsics.checkParameterIsNotNull(pagedList, "p1");
        ((HomeFeedFragment) this.receiver).handleHomeFeeds(pagedList);
    }
}
