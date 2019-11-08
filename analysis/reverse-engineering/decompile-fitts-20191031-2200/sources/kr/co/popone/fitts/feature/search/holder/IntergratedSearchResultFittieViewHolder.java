package kr.co.popone.fitts.feature.search.holder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.feature.common.fittie.FittieHorizontalFeedAdapter;
import kr.co.popone.fitts.model.view.FittieFollowViewData;
import kr.co.popone.fitts.ui.decorator.BottomOffsetDecorator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class IntergratedSearchResultFittieViewHolder extends ViewHolder {
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final Delegate delegate;
    private final FittieHorizontalFeedAdapter fittieHorizontalFeedAdapter = new FittieHorizontalFeedAdapter(this.delegate);

    public interface Delegate extends kr.co.popone.fitts.feature.common.fittie.FittieHorizontalFeedAdapter.Delegate {
        void switchFittieTab();
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final IntergratedSearchResultFittieViewHolder create(@NotNull ViewGroup viewGroup, @NotNull Delegate delegate) {
            Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
            Intrinsics.checkParameterIsNotNull(delegate, "delegate");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.item_result_search_total_post, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "view");
            return new IntergratedSearchResultFittieViewHolder(inflate, delegate);
        }
    }

    public IntergratedSearchResultFittieViewHolder(@NotNull View view, @NotNull Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(view, "itemView");
        Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
        super(view);
        this.delegate = delegate2;
    }

    @NotNull
    public final Delegate getDelegate() {
        return this.delegate;
    }

    public static /* synthetic */ void bindTo$default(IntergratedSearchResultFittieViewHolder intergratedSearchResultFittieViewHolder, List list, Boolean bool, int i, Object obj) {
        if ((i & 2) != 0) {
            bool = Boolean.valueOf(false);
        }
        intergratedSearchResultFittieViewHolder.bindTo(list, bool);
    }

    public final void bindTo(@NotNull List<FittieFollowViewData> list, @Nullable Boolean bool) {
        Intrinsics.checkParameterIsNotNull(list, "fitties");
        View view = this.itemView;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(C0010R$id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(this.fittieHorizontalFeedAdapter);
        if (recyclerView.getItemDecorationCount() < 1) {
            BottomOffsetDecorator bottomOffsetDecorator = new BottomOffsetDecorator(0, 4, 4, 0, 16);
            recyclerView.addItemDecoration(bottomOffsetDecorator);
        }
        ((TextView) view.findViewById(C0010R$id.textMore)).setOnClickListener(new IntergratedSearchResultFittieViewHolder$bindTo$$inlined$with$lambda$1(this, bool, list));
        TextView textView = (TextView) view.findViewById(C0010R$id.textMore);
        Intrinsics.checkExpressionValueIsNotNull(textView, "textMore");
        if (bool == null) {
            Intrinsics.throwNpe();
        }
        textView.setVisibility(bool.booleanValue() ? 0 : 8);
        TextView textView2 = (TextView) view.findViewById(C0010R$id.textTitle);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "textTitle");
        textView2.setText("핏티");
        this.fittieHorizontalFeedAdapter.setItems(list);
    }
}
