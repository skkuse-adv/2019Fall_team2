package kr.co.popone.fitts.feature.me;

import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.datamodel.service.banner.Banner;

final class MeFragment$requestMyBanner$1<T> implements Consumer<List<? extends Banner>> {
    final /* synthetic */ MeFragment this$0;

    MeFragment$requestMyBanner$1(MeFragment meFragment) {
        this.this$0 = meFragment;
    }

    public final void accept(List<Banner> list) {
        MeFragment meFragment = this.this$0;
        Intrinsics.checkExpressionValueIsNotNull(list, "it");
        meFragment.updateMeBannerUi((Banner) CollectionsKt___CollectionsKt.firstOrNull(list));
    }
}
