package kr.co.popone.fitts.feature.search.holder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.model.store.StoreInfo;
import org.jetbrains.annotations.NotNull;

public final class StoreSearchResultViewHolder extends ViewHolder {
    public static final Companion Companion = new Companion(null);

    public interface Delegate {
        void onStoreClicked(long j);
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final StoreSearchResultViewHolder create(@NotNull ViewGroup viewGroup) {
            Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.item_store_search_result, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "view");
            return new StoreSearchResultViewHolder(inflate);
        }
    }

    public StoreSearchResultViewHolder(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "itemView");
        super(view);
    }

    public final void bindTo(@NotNull StoreInfo storeInfo, @NotNull Delegate delegate) {
        Intrinsics.checkParameterIsNotNull(storeInfo, "storeInfo");
        Intrinsics.checkParameterIsNotNull(delegate, "delegate");
        View view = this.itemView;
        TextView textView = (TextView) view.findViewById(C0010R$id.textShopName);
        Intrinsics.checkExpressionValueIsNotNull(textView, "textShopName");
        textView.setText(storeInfo.getStoreName());
        view.setOnClickListener(new StoreSearchResultViewHolder$bindTo$$inlined$with$lambda$1(storeInfo, delegate));
    }
}
