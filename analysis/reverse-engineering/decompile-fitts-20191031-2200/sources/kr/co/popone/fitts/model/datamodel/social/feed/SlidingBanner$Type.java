package kr.co.popone.fitts.model.datamodel.social.feed;

import kr.co.popone.fitts.C0013R$layout;
import org.jetbrains.annotations.NotNull;

public enum SlidingBanner$Type {
    HOME(0.2083f, C0013R$layout.view_home_sliding_banner_image, new SlidingBanner$Param(2, 6, 16)),
    SHOP(0.725f, C0013R$layout.view_shop_sliding_banner_image, new SlidingBanner$Param(3, 8, 50)),
    SHOP_BRIDGE(0.5153f, C0013R$layout.view_shop_bridge_sliding_banner, new SlidingBanner$Param(3, 6, 25));
    
    private final int layout;
    @NotNull
    private final SlidingBanner$Param param;
    private final float ratio;

    private SlidingBanner$Type(float f, int i, SlidingBanner$Param slidingBanner$Param) {
        this.ratio = f;
        this.layout = i;
        this.param = slidingBanner$Param;
    }

    public final int getLayout() {
        return this.layout;
    }

    @NotNull
    public final SlidingBanner$Param getParam() {
        return this.param;
    }

    public final float getRatio() {
        return this.ratio;
    }
}
