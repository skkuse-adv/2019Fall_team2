package kr.co.popone.fitts.feature.search.holder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.feature.feeds.BaseViewHolder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class SearchHistoryDeleteHolder extends BaseViewHolder {
    public static final Companion Companion = new Companion(null);
    @Nullable
    private final Delegate delegate;

    public static final class Companion {
        public final int getId() {
            return C0013R$layout.view_search_history_footer;
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final SearchHistoryDeleteHolder create(@NotNull ViewGroup viewGroup, @Nullable Delegate delegate) {
            Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.view_search_history_footer, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "view");
            return new SearchHistoryDeleteHolder(inflate, delegate);
        }
    }

    public interface Delegate {
        void onHistoryDelete();
    }

    public void clear() {
    }

    public SearchHistoryDeleteHolder(@NotNull View view, @Nullable Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(view, "itemView");
        super(view);
        this.delegate = delegate2;
    }

    @Nullable
    public final Delegate getDelegate() {
        return this.delegate;
    }

    public <T> void bind(@Nullable T t, @Nullable Integer num) {
        updateView();
    }

    public final void updateView() {
        this.itemView.setOnClickListener(new SearchHistoryDeleteHolder$updateView$$inlined$with$lambda$1(this));
    }
}
