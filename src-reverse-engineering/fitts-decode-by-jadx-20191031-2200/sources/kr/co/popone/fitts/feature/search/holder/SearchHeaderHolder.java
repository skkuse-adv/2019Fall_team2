package kr.co.popone.fitts.feature.search.holder;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.feature.feeds.BaseViewHolder;
import kr.co.popone.fitts.model.search.SearchResult.SearchResultCount;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class SearchHeaderHolder extends BaseViewHolder {
    public static final Companion Companion = new Companion(null);
    private final TextView textSearchResultCount;

    public static final class Companion {
        public final int getId() {
            return C0013R$layout.item_search_header;
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final SearchHeaderHolder create(@NotNull ViewGroup viewGroup) {
            Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.item_search_header, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "view");
            return new SearchHeaderHolder(inflate);
        }
    }

    public void clear() {
    }

    public SearchHeaderHolder(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "itemView");
        super(view);
        this.textSearchResultCount = (TextView) view.findViewById(C0010R$id.tv_search_result_count);
    }

    public final TextView getTextSearchResultCount() {
        return this.textSearchResultCount;
    }

    public <T> void bind(@Nullable T t, @Nullable Integer num) {
        if (t instanceof SearchResultCount) {
            update((SearchResultCount) t);
        }
    }

    @SuppressLint({"SetTextI18n"})
    private final void update(SearchResultCount searchResultCount) {
        TextView textView = this.textSearchResultCount;
        Intrinsics.checkExpressionValueIsNotNull(textView, "textSearchResultCount");
        StringBuilder sb = new StringBuilder();
        sb.append(searchResultCount.getCount());
        sb.append(searchResultCount.getText());
        textView.setText(sb.toString());
    }
}
