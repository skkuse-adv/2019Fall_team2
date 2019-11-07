package kr.co.popone.fitts.feature.feeds;

import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.OnItemTouchListener;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.ui.custom.banner.BannerSliderAdapter;
import org.jetbrains.annotations.NotNull;

public final class SlidingBannerFeedHolder$updatePostBannerFeedUi$$inlined$apply$lambda$1 implements OnItemTouchListener {
    final /* synthetic */ SlidingBannerFeedHolder this$0;

    public void onRequestDisallowInterceptTouchEvent(boolean z) {
    }

    public void onTouchEvent(@NotNull RecyclerView recyclerView, @NotNull MotionEvent motionEvent) {
        Intrinsics.checkParameterIsNotNull(recyclerView, "rv");
        Intrinsics.checkParameterIsNotNull(motionEvent, "e");
    }

    SlidingBannerFeedHolder$updatePostBannerFeedUi$$inlined$apply$lambda$1(SlidingBannerFeedHolder slidingBannerFeedHolder, BannerSliderAdapter bannerSliderAdapter) {
        this.this$0 = slidingBannerFeedHolder;
    }

    public boolean onInterceptTouchEvent(@NotNull RecyclerView recyclerView, @NotNull MotionEvent motionEvent) {
        Intrinsics.checkParameterIsNotNull(recyclerView, "rv");
        Intrinsics.checkParameterIsNotNull(motionEvent, "e");
        int action = motionEvent.getAction();
        if (action == 0 || action == 2) {
            this.this$0.pauseBannerPolling();
        } else {
            this.this$0.startBannerPolling();
        }
        return false;
    }
}
