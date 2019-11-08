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
import kr.co.popone.fitts.feature.common.post.PostFeedAdapter;
import kr.co.popone.fitts.model.post.PostFeedViewData;
import kr.co.popone.fitts.ui.decorator.RecyclerDecorator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class IntergratedSearchResultPostViewHolder extends ViewHolder {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(IntergratedSearchResultPostViewHolder.class), "decorator", "getDecorator()Lkr/co/popone/fitts/ui/decorator/RecyclerDecorator;"))};
    public static final Companion Companion = new Companion(null);
    private final Lazy decorator$delegate = LazyKt__LazyJVMKt.lazy(IntergratedSearchResultPostViewHolder$decorator$2.INSTANCE);
    @NotNull
    private final Delegate delegate;
    private final PostFeedAdapter postFeedAdapter = new PostFeedAdapter(this.delegate);

    public interface Delegate extends kr.co.popone.fitts.feature.feeds.title.SimplePostHolder.Delegate {
        void switchPostTab();
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final IntergratedSearchResultPostViewHolder create(@NotNull ViewGroup viewGroup, @NotNull Delegate delegate) {
            Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
            Intrinsics.checkParameterIsNotNull(delegate, "delegate");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.item_result_search_total_post, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "view");
            return new IntergratedSearchResultPostViewHolder(inflate, delegate);
        }
    }

    private final RecyclerDecorator getDecorator() {
        Lazy lazy = this.decorator$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (RecyclerDecorator) lazy.getValue();
    }

    public IntergratedSearchResultPostViewHolder(@NotNull View view, @NotNull Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(view, "itemView");
        Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
        super(view);
        this.delegate = delegate2;
    }

    @NotNull
    public final Delegate getDelegate() {
        return this.delegate;
    }

    public final void bindTo(@NotNull List<PostFeedViewData> list, @Nullable Boolean bool) {
        Intrinsics.checkParameterIsNotNull(list, "posts");
        View view = this.itemView;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(C0010R$id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(), 3));
        recyclerView.setAdapter(this.postFeedAdapter);
        if (recyclerView.getItemDecorationCount() < 1) {
            recyclerView.addItemDecoration(getDecorator());
        }
        TextView textView = (TextView) view.findViewById(C0010R$id.textTitle);
        Intrinsics.checkExpressionValueIsNotNull(textView, "textTitle");
        textView.setText("포스트");
        TextView textView2 = (TextView) view.findViewById(C0010R$id.textMore);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "textMore");
        textView2.setVisibility(Intrinsics.areEqual((Object) bool, (Object) Boolean.valueOf(true)) ? 0 : 8);
        ((TextView) view.findViewById(C0010R$id.textMore)).setOnClickListener(new IntergratedSearchResultPostViewHolder$bindTo$$inlined$with$lambda$1(this, bool, list));
        this.postFeedAdapter.setItems(list);
    }
}
