package kr.co.popone.fitts.feature.search.holder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0006R$color;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.feature.search.adapter.StoreSearchResultAdapter;
import kr.co.popone.fitts.model.store.StoreInfo;
import kr.co.popone.fitts.ui.decorator.StoreSearchResultDecorator;
import org.jetbrains.annotations.NotNull;

public final class IntergratedSearchResultStoreViewHolder extends ViewHolder {
    public static final Companion Companion = new Companion(null);
    private final StoreSearchResultAdapter storeSearchResultAdapter;

    public interface Delegate extends kr.co.popone.fitts.feature.search.holder.StoreSearchResultViewHolder.Delegate {
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final IntergratedSearchResultStoreViewHolder create(@NotNull ViewGroup viewGroup, @NotNull Delegate delegate) {
            Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
            Intrinsics.checkParameterIsNotNull(delegate, "delegate");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.item_result_search_total_post, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "view");
            return new IntergratedSearchResultStoreViewHolder(inflate, delegate);
        }
    }

    public IntergratedSearchResultStoreViewHolder(@NotNull View view, @NotNull Delegate delegate) {
        Intrinsics.checkParameterIsNotNull(view, "itemView");
        Intrinsics.checkParameterIsNotNull(delegate, "delegate");
        super(view);
        this.storeSearchResultAdapter = new StoreSearchResultAdapter(delegate);
    }

    public final void bindTo(@NotNull List<StoreInfo> list) {
        Intrinsics.checkParameterIsNotNull(list, "stores");
        View view = this.itemView;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(C0010R$id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(this.storeSearchResultAdapter);
        if (recyclerView.getItemDecorationCount() < 1) {
            Context context = recyclerView.getContext();
            Intrinsics.checkExpressionValueIsNotNull(context, "context");
            recyclerView.addItemDecoration(new StoreSearchResultDecorator(context, C0006R$color.gray1));
        }
        TextView textView = (TextView) view.findViewById(C0010R$id.textTitle);
        Intrinsics.checkExpressionValueIsNotNull(textView, "textTitle");
        textView.setText("스토어");
        TextView textView2 = (TextView) view.findViewById(C0010R$id.textMore);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "textMore");
        textView2.setVisibility(8);
        this.storeSearchResultAdapter.setItems(list);
    }
}
