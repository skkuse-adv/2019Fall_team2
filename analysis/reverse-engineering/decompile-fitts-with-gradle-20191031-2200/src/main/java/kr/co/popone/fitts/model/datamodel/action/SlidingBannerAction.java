package kr.co.popone.fitts.model.datamodel.action;

import kr.co.popone.fitts.model.datamodel.social.feed.SlidingBanner$Type;
import org.jetbrains.annotations.NotNull;

public interface SlidingBannerAction extends LifecycleInjector {
    @NotNull
    SlidingBanner$Type getSlidingBanner();

    void onSlidingBannerClick(@NotNull String str);
}
