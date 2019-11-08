package kr.co.popone.fitts.feature.search.holder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.List;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.feature.search.adapter.IntergratedProductResultAdapter;
import kr.co.popone.fitts.model.store.ProductFeedViewData;
import kr.co.popone.fitts.ui.decorator.RecyclerDecorator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class IntergratedSearchResultProductViewHolder extends ViewHolder {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(IntergratedSearchResultProductViewHolder.class), "decorator", "getDecorator()Lkr/co/popone/fitts/ui/decorator/RecyclerDecorator;"))};
    public static final Companion Companion = new Companion(null);
    private final Lazy decorator$delegate = LazyKt__LazyJVMKt.lazy(IntergratedSearchResultProductViewHolder$decorator$2.INSTANCE);
    @NotNull
    private final Delegate delegate;
    private final IntergratedProductResultAdapter intergratedProductResultAdapter = new IntergratedProductResultAdapter(this.delegate);

    public interface Delegate extends kr.co.popone.fitts.feature.home.feed.ProductFeedHolder.Delegate {
        void switchProductTab();
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final IntergratedSearchResultProductViewHolder create(@NotNull ViewGroup viewGroup, @NotNull Delegate delegate) {
            Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
            Intrinsics.checkParameterIsNotNull(delegate, "delegate");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.item_result_search_total_post, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "view");
            return new IntergratedSearchResultProductViewHolder(inflate, delegate);
        }
    }

    private final RecyclerDecorator getDecorator() {
        Lazy lazy = this.decorator$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (RecyclerDecorator) lazy.getValue();
    }

    public IntergratedSearchResultProductViewHolder(@NotNull View view, @NotNull Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(view, "itemView");
        Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
        super(view);
        this.delegate = delegate2;
    }

    @NotNull
    public final Delegate getDelegate() {
        return this.delegate;
    }

    public final void bindTo(@NotNull List<ProductFeedViewData> list, @Nullable Boolean bool) {
        Intrinsics.checkParameterIsNotNull(list, "products");
        View view = this.itemView;
        int i = 8;
        if (list.isEmpty()) {
            View view2 = this.itemView;
            Intrinsics.checkExpressionValueIsNotNull(view2, "itemView");
            view2.setVisibility(8);
        }
        RecyclerView recyclerView = (RecyclerView) view.findViewById(C0010R$id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(), 3));
        recyclerView.setAdapter(this.intergratedProductResultAdapter);
        if (recyclerView.getItemDecorationCount() < 1) {
            recyclerView.addItemDecoration(getDecorator());
        }
        TextView textView = (TextView) view.findViewById(C0010R$id.textMore);
        Intrinsics.checkExpressionValueIsNotNull(textView, "textMore");
        if (Intrinsics.areEqual((Object) bool, (Object) Boolean.valueOf(true))) {
            i = 0;
        }
        textView.setVisibility(i);
        ((TextView) view.findViewById(C0010R$id.textMore)).setOnClickListener(new IntergratedSearchResultProductViewHolder$bindTo$$inlined$with$lambda$1(this, list, bool));
        TextView textView2 = (TextView) view.findViewById(C0010R$id.textTitle);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "textTitle");
        textView2.setText("상품");
        this.intergratedProductResultAdapter.setItems(list);
    }
}
