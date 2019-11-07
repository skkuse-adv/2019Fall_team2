package kr.co.popone.fitts.feature.search.adapter;

import android.view.ViewGroup;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.feeds.BasePagedListAdapter;
import kr.co.popone.fitts.feature.feeds.BaseViewHolder;
import kr.co.popone.fitts.feature.feeds.title.SimplePostHolder;
import kr.co.popone.fitts.feature.search.holder.SearchHeaderHolder;
import kr.co.popone.fitts.model.search.SearchResult;
import kr.co.popone.fitts.model.search.SearchResult.PostSearchResult;
import kr.co.popone.fitts.model.search.SearchResult.SearchResultCount;
import org.jetbrains.annotations.NotNull;

public final class PostResultAdapter extends BasePagedListAdapter<SearchResult, BaseViewHolder> {
    private static final PostResultAdapter$Companion$COMPARATOR$1 COMPARATOR = new PostResultAdapter$Companion$COMPARATOR$1();
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final Delegate delegate;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public interface Delegate extends kr.co.popone.fitts.feature.feeds.title.SimplePostHolder.Delegate {
    }

    public PostResultAdapter(@NotNull Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
        super(COMPARATOR);
        this.delegate = delegate2;
    }

    @NotNull
    public final Delegate getDelegate() {
        return this.delegate;
    }

    @NotNull
    public BaseViewHolder onCreateViewHolderWithoutLoading(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        if (i == SimplePostHolder.Companion.getId()) {
            return SimplePostHolder.Companion.create(viewGroup, this.delegate);
        }
        if (i == SearchHeaderHolder.Companion.getId()) {
            return SearchHeaderHolder.Companion.create(viewGroup);
        }
        throw new IllegalAccessException("can't find viewType");
    }

    public void onBindViewHolderWithoutLoading(@NotNull BaseViewHolder baseViewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(baseViewHolder, "holder");
        if (baseViewHolder instanceof SimplePostHolder) {
            Object item = getItem(i);
            if (item != null) {
                BaseViewHolder.bind$default(baseViewHolder, (PostSearchResult) item, null, 2, null);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type kr.co.popone.fitts.model.search.SearchResult.PostSearchResult");
        } else if (baseViewHolder instanceof SearchHeaderHolder) {
            Object item2 = getItem(i);
            if (item2 != null) {
                BaseViewHolder.bind$default(baseViewHolder, (SearchResultCount) item2, null, 2, null);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type kr.co.popone.fitts.model.search.SearchResult.SearchResultCount");
        }
    }

    public int getItemViewTypeWithoutLoading(int i) {
        if (((SearchResult) getItem(i)) instanceof PostSearchResult) {
            return SimplePostHolder.Companion.getId();
        }
        return SearchHeaderHolder.Companion.getId();
    }

    public final int getSpanSize(int i) {
        return getItemViewType(i) == SimplePostHolder.Companion.getId() ? 1 : 3;
    }
}
