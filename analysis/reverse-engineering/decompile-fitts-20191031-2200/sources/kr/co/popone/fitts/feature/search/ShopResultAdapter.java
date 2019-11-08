package kr.co.popone.fitts.feature.search;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.model.search.SearchAPI.SearchShopResult.ShopEntry;
import org.jetbrains.annotations.NotNull;

public final class ShopResultAdapter extends Adapter<ViewHolder> {
    private final Context context;
    /* access modifiers changed from: private */
    public final Delegate delegate;
    private final OnClickListener itemClickedListener = new ShopResultAdapter$itemClickedListener$1(this);
    private boolean showsLoadingMore;

    public interface Delegate {
        @NotNull
        String getResultText();

        @NotNull
        List<ShopEntry> getShops();

        void onItemClick(int i);
    }

    public static final class ShopResultItemViewHolder extends ViewHolder {
        @NotNull
        private final TextView nameTextView;
        @NotNull
        private final View separatorView;

        public ShopResultItemViewHolder(@NotNull View view) {
            Intrinsics.checkParameterIsNotNull(view, "view");
            super(view);
            View findViewById = view.findViewById(C0010R$id.nameTextView);
            if (findViewById == null) {
                Intrinsics.throwNpe();
            }
            this.nameTextView = (TextView) findViewById;
            View findViewById2 = view.findViewById(C0010R$id.separatorView);
            if (findViewById2 == null) {
                Intrinsics.throwNpe();
            }
            this.separatorView = findViewById2;
        }

        @NotNull
        public final TextView getNameTextView() {
            return this.nameTextView;
        }

        @NotNull
        public final View getSeparatorView() {
            return this.separatorView;
        }
    }

    public ShopResultAdapter(@NotNull Context context2, @NotNull Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(context2, "context");
        Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
        this.context = context2;
        this.delegate = delegate2;
    }

    public final boolean getShowsLoadingMore() {
        return this.showsLoadingMore;
    }

    public final void setShowsLoadingMore(boolean z) {
        if (z != this.showsLoadingMore) {
            this.showsLoadingMore = z;
            notifyDataSetChanged();
        }
    }

    public void onBindViewHolder(@NotNull ViewHolder viewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
        if (viewHolder instanceof SearchResultHeaderViewHolder) {
            ((SearchResultHeaderViewHolder) viewHolder).getResultTextView().setText(this.delegate.getResultText());
        } else if (viewHolder instanceof ShopResultItemViewHolder) {
            int i2 = 0;
            if (this.delegate.getResultText().length() > 0) {
                i--;
            }
            ShopEntry shopEntry = (ShopEntry) this.delegate.getShops().get(i);
            View view = viewHolder.itemView;
            Intrinsics.checkExpressionValueIsNotNull(view, "holder.itemView");
            view.setTag(Integer.valueOf(i));
            ShopResultItemViewHolder shopResultItemViewHolder = (ShopResultItemViewHolder) viewHolder;
            shopResultItemViewHolder.getNameTextView().setText(shopEntry.getName());
            View separatorView = shopResultItemViewHolder.getSeparatorView();
            if (i >= this.delegate.getShops().size() - 1) {
                i2 = 8;
            }
            separatorView.setVisibility(i2);
        }
    }

    public int getItemViewType(int i) {
        boolean z = false;
        if ((this.delegate.getResultText().length() > 0) && i == 0) {
            return 0;
        }
        if ((this.delegate.getResultText().length() > 0) && i == this.delegate.getShops().size() + 1) {
            return 2;
        }
        if (this.delegate.getResultText().length() == 0) {
            z = true;
        }
        if (!z || i != this.delegate.getShops().size()) {
            return 1;
        }
        return 2;
    }

    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        String str = "view";
        if (i == 0) {
            View inflate = LayoutInflater.from(this.context).inflate(C0013R$layout.view_search_result_header, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, str);
            return new SearchResultHeaderViewHolder(inflate);
        } else if (i == 1) {
            View inflate2 = LayoutInflater.from(this.context).inflate(C0013R$layout.view_search_result_item_shop, viewGroup, false);
            inflate2.setOnClickListener(this.itemClickedListener);
            Intrinsics.checkExpressionValueIsNotNull(inflate2, str);
            return new ShopResultItemViewHolder(inflate2);
        } else if (i == 2) {
            View inflate3 = LayoutInflater.from(this.context).inflate(C0013R$layout.loading_list_item, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate3, str);
            return new LoadingListItemViewHolder(inflate3);
        } else {
            throw new IllegalAccessException();
        }
    }

    public int getItemCount() {
        int size;
        boolean z = false;
        if ((this.delegate.getResultText().length() > 0) && this.showsLoadingMore) {
            return this.delegate.getShops().size() + 2;
        }
        if (!(this.delegate.getResultText().length() > 0) || this.showsLoadingMore) {
            if (this.delegate.getResultText().length() == 0) {
                z = true;
            }
            if (!z || !this.showsLoadingMore) {
                return this.delegate.getShops().size();
            }
            size = this.delegate.getShops().size();
        } else {
            size = this.delegate.getShops().size();
        }
        return size + 1;
    }
}
