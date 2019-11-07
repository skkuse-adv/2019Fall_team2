package kr.co.popone.fitts.ui.custom.banner;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.feeds.BaseViewHolder;
import kr.co.popone.fitts.feature.feeds.SlidingBannerItemHolder;
import kr.co.popone.fitts.feature.feeds.SlidingBannerItemHolder.Delegate;
import org.jetbrains.annotations.NotNull;

public final class BannerSliderAdapter<T> extends Adapter<SlidingBannerItemHolder> {
    private List<? extends T> banners = new ArrayList();
    private final Delegate delegate;

    public BannerSliderAdapter(@NotNull Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
        this.delegate = delegate2;
    }

    public final void updateBanners(@NotNull List<? extends T> list) {
        Intrinsics.checkParameterIsNotNull(list, "items");
        this.banners = list;
        notifyDataSetChanged();
    }

    @NotNull
    public SlidingBannerItemHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        return SlidingBannerItemHolder.Companion.create(viewGroup, this.delegate);
    }

    public void onBindViewHolder(@NotNull SlidingBannerItemHolder slidingBannerItemHolder, int i) {
        Intrinsics.checkParameterIsNotNull(slidingBannerItemHolder, "holder");
        List<? extends T> list = this.banners;
        BaseViewHolder.bind$default(slidingBannerItemHolder, list.get(i % list.size()), null, 2, null);
    }

    public int getItemCount() {
        return this.banners.size() == 1 ? 1 : 100000;
    }
}
