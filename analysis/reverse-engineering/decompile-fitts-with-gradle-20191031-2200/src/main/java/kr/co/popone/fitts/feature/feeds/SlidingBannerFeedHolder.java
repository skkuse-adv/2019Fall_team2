package kr.co.popone.fitts.feature.feeds;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.model.datamodel.social.feed.Feed;
import kr.co.popone.fitts.ui.custom.banner.BannerSliderAdapter;
import kr.co.popone.fitts.ui.decorator.CirclePagerIndicatorDecoration;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class SlidingBannerFeedHolder extends BaseViewHolder implements LifecycleObserver {
    public static final Companion Companion = new Companion(null);
    /* access modifiers changed from: private */
    public final RecyclerView bannerSlider;
    @NotNull
    private final Delegate delegate;
    private Disposable slideDisposable;
    /* access modifiers changed from: private */
    public final PagerSnapHelper slideSanpHelper = new PagerSnapHelper();
    private final ConstraintLayout slidingRecyclerParent;

    public static final class Companion {
        public final int getId() {
            return C0013R$layout.item_store_home_banner;
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final SlidingBannerFeedHolder create(@NotNull ViewGroup viewGroup, @NotNull Delegate delegate) {
            Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
            Intrinsics.checkParameterIsNotNull(delegate, "delegate");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.item_store_home_banner, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "view");
            return new SlidingBannerFeedHolder(inflate, delegate);
        }
    }

    public interface Delegate extends kr.co.popone.fitts.feature.feeds.SlidingBannerItemHolder.Delegate {
    }

    public SlidingBannerFeedHolder(@NotNull View view, @NotNull Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(view, "itemView");
        Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
        super(view);
        this.delegate = delegate2;
        this.bannerSlider = (RecyclerView) view.findViewById(C0010R$id.recycler_sliding_banner);
        this.slidingRecyclerParent = (ConstraintLayout) view.findViewById(C0010R$id.slidingRecyclerParent);
    }

    @NotNull
    public final Delegate getDelegate() {
        return this.delegate;
    }

    public <T> void bind(@Nullable T t, @Nullable Integer num) {
        if (t instanceof Feed) {
            updatePostBannerFeedUi((Feed) t);
        }
    }

    public void clear() {
        Lifecycle providedLifecycle = this.delegate.getProvidedLifecycle();
        if (providedLifecycle != null) {
            providedLifecycle.removeObserver(this);
        }
        this.slideSanpHelper.attachToRecyclerView(null);
        RecyclerView recyclerView = this.bannerSlider;
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, "bannerSlider");
        recyclerView.setAdapter(null);
        pauseBannerPolling();
    }

    private final void updatePostBannerFeedUi(Feed feed) {
        BannerSliderAdapter bannerSliderAdapter = new BannerSliderAdapter(this.delegate);
        bannerSliderAdapter.updateBanners(feed.getFeeds());
        resizeRecyclerView();
        RecyclerView recyclerView = this.bannerSlider;
        recyclerView.setAdapter(bannerSliderAdapter);
        recyclerView.addOnItemTouchListener(new SlidingBannerFeedHolder$updatePostBannerFeedUi$$inlined$apply$lambda$1(this, bannerSliderAdapter));
        this.slideSanpHelper.attachToRecyclerView(this.bannerSlider);
        if (feed.getFeeds().size() > 1) {
            RecyclerView recyclerView2 = this.bannerSlider;
            Intrinsics.checkExpressionValueIsNotNull(recyclerView2, "bannerSlider");
            if (recyclerView2.getItemDecorationCount() < 1) {
                this.bannerSlider.addItemDecoration(new CirclePagerIndicatorDecoration(feed.getFeeds().size(), this.delegate.getSlidingBanner().getParam().getWidth(), this.delegate.getSlidingBanner().getParam().getMargin(), this.delegate.getSlidingBanner().getParam().getHeight()));
            }
            Lifecycle providedLifecycle = this.delegate.getProvidedLifecycle();
            if (providedLifecycle != null) {
                providedLifecycle.addObserver(this);
            }
            startBannerPolling();
        }
    }

    private final void resizeRecyclerView() {
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(this.slidingRecyclerParent);
        RecyclerView recyclerView = this.bannerSlider;
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, "bannerSlider");
        int id = recyclerView.getId();
        StringBuilder sb = new StringBuilder();
        sb.append("1:");
        sb.append(this.delegate.getSlidingBanner().getRatio());
        constraintSet.setDimensionRatio(id, sb.toString());
        constraintSet.applyTo(this.slidingRecyclerParent);
    }

    /* access modifiers changed from: private */
    public final void startBannerPolling() {
        Disposable disposable = this.slideDisposable;
        if (disposable == null || disposable.isDisposed()) {
            this.slideDisposable = Observable.interval(2800, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.io()).map(new SlidingBannerFeedHolder$startBannerPolling$1(this)).filter(SlidingBannerFeedHolder$startBannerPolling$2.INSTANCE).distinctUntilChanged().map(SlidingBannerFeedHolder$startBannerPolling$3.INSTANCE).subscribe(new SlidingBannerFeedHolder$startBannerPolling$4(this), SlidingBannerFeedHolder$startBannerPolling$5.INSTANCE);
        }
    }

    /* access modifiers changed from: private */
    public final void pauseBannerPolling() {
        Disposable disposable = this.slideDisposable;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    @OnLifecycleEvent(Event.ON_PAUSE)
    public final void pauseSlidingBanner() {
        pauseBannerPolling();
    }

    @OnLifecycleEvent(Event.ON_RESUME)
    public final void resumeSlidingBanner() {
        startBannerPolling();
    }
}
