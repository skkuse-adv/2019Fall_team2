package kr.co.popone.fitts.feature.category;

import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil.ItemCallback;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.feeds.BasePagedListAdapter;
import kr.co.popone.fitts.feature.feeds.BaseViewHolder;
import kr.co.popone.fitts.feature.feeds.title.SimplePostHolder;
import kr.co.popone.fitts.model.post.PostAPI.CategoryPostItem;
import org.jetbrains.annotations.NotNull;

public final class CategoryPostAdapter extends BasePagedListAdapter<CategoryPostItem, BaseViewHolder> {
    /* access modifiers changed from: private */
    @NotNull
    public static final ItemCallback<CategoryPostItem> COMPARATOR = new CategoryPostAdapter$Companion$COMPARATOR$1();
    public static final Companion Companion = new Companion(null);
    private final Delegate delegate;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ItemCallback<CategoryPostItem> getCOMPARATOR() {
            return CategoryPostAdapter.COMPARATOR;
        }
    }

    public interface Delegate extends kr.co.popone.fitts.feature.feeds.title.SimplePostHolder.Delegate {
    }

    public CategoryPostAdapter(@NotNull Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
        super(COMPARATOR);
        this.delegate = delegate2;
    }

    @NotNull
    public BaseViewHolder onCreateViewHolderWithoutLoading(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        return SimplePostHolder.Companion.create(viewGroup, this.delegate);
    }

    public void onBindViewHolderWithoutLoading(@NotNull BaseViewHolder baseViewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(baseViewHolder, "holder");
        BaseViewHolder.bind$default(baseViewHolder, getItem(i), null, 2, null);
    }

    public int getItemViewTypeWithoutLoading(int i) {
        return SimplePostHolder.Companion.getId();
    }
}
