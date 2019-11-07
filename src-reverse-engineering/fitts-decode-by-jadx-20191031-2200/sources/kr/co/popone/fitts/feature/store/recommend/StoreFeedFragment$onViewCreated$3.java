package kr.co.popone.fitts.feature.store.recommend;

import androidx.paging.PagedList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import kr.co.popone.fitts.model.datamodel.social.feed.Feed;
import org.jetbrains.annotations.NotNull;

final class StoreFeedFragment$onViewCreated$3 extends FunctionReference implements Function1<PagedList<Feed>, Unit> {
    StoreFeedFragment$onViewCreated$3(StoreFeedFragment storeFeedFragment) {
        super(1, storeFeedFragment);
    }

    public final String getName() {
        return "updateStoreFeeds";
    }

    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(StoreFeedFragment.class);
    }

    public final String getSignature() {
        return "updateStoreFeeds(Landroidx/paging/PagedList;)V";
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((PagedList) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull PagedList<Feed> pagedList) {
        Intrinsics.checkParameterIsNotNull(pagedList, "p1");
        ((StoreFeedFragment) this.receiver).updateStoreFeeds(pagedList);
    }
}
