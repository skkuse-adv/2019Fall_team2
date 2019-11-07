package kr.co.popone.fitts.feature.banner;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kr.co.popone.fitts.model.datamodel.service.banner.BannerType;
import org.jetbrains.annotations.NotNull;

final class BannerActivity$onCreate$4 extends Lambda implements Function0<BannerType> {
    final /* synthetic */ BannerActivity this$0;

    BannerActivity$onCreate$4(BannerActivity bannerActivity) {
        this.this$0 = bannerActivity;
        super(0);
    }

    @NotNull
    public final BannerType invoke() {
        String stringExtra = this.this$0.getIntent().getStringExtra(BannerActivity.KEY_BANNER_TYPE);
        Intrinsics.checkExpressionValueIsNotNull(stringExtra, "intent.getStringExtra(KEY_BANNER_TYPE)");
        return BannerType.valueOf(stringExtra);
    }
}
