package kr.co.popone.fitts.feature.banner;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.banner.BannerItemHolder.Delegate;
import kr.co.popone.fitts.model.datamodel.service.banner.Banner;
import org.jetbrains.annotations.NotNull;

public final class BannerAdapter extends Adapter<BannerItemHolder> {
    private final Delegate delegate;
    @NotNull
    private List<Banner> items = new ArrayList();

    public BannerAdapter(@NotNull Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
        this.delegate = delegate2;
    }

    @NotNull
    public final List<Banner> getItems() {
        return this.items;
    }

    public final void setItems(@NotNull List<Banner> list) {
        Intrinsics.checkParameterIsNotNull(list, "<set-?>");
        this.items = list;
    }

    @NotNull
    public BannerItemHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        return BannerItemHolder.Companion.create(viewGroup, this.delegate);
    }

    public int getItemCount() {
        return this.items.size();
    }

    public void onBindViewHolder(@NotNull BannerItemHolder bannerItemHolder, int i) {
        Intrinsics.checkParameterIsNotNull(bannerItemHolder, "holder");
        bannerItemHolder.bindTo((Banner) this.items.get(i));
    }
}
