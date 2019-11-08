package kr.co.popone.fitts.feature.search.holder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.feature.feeds.BaseViewHolder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class SearchHistoryHolder extends BaseViewHolder {
    public static final Companion Companion = new Companion(null);
    @Nullable
    private final Delegate delegate;

    public static final class Companion {
        public final int getId() {
            return C0013R$layout.item_search_history;
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final SearchHistoryHolder create(@NotNull ViewGroup viewGroup, @Nullable Delegate delegate) {
            Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.item_search_history, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "view");
            return new SearchHistoryHolder(inflate, delegate);
        }
    }

    public interface Delegate {
        void onHistoryClick(@NotNull String str);
    }

    public void clear() {
    }

    public SearchHistoryHolder(@NotNull View view, @Nullable Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(view, "itemView");
        super(view);
        this.delegate = delegate2;
    }

    @Nullable
    public final Delegate getDelegate() {
        return this.delegate;
    }

    public <T> void bind(@Nullable T t, @Nullable Integer num) {
        if (t instanceof String) {
            updateView((String) t);
        }
    }

    private final void updateView(String str) {
        View view = this.itemView;
        TextView textView = (TextView) view.findViewById(C0010R$id.textView);
        Intrinsics.checkExpressionValueIsNotNull(textView, "textView");
        textView.setText(str);
        view.setOnClickListener(new SearchHistoryHolder$updateView$$inlined$with$lambda$1(this, str));
    }
}
