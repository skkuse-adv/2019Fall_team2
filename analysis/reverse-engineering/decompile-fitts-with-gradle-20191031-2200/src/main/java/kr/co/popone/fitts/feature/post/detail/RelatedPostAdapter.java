package kr.co.popone.fitts.feature.post.detail;

import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil.ItemCallback;
import androidx.recyclerview.widget.ListAdapter;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.feeds.BaseViewHolder;
import kr.co.popone.fitts.feature.feeds.PostFeedHolder;
import kr.co.popone.fitts.model.post.PostAPI.Post;
import org.jetbrains.annotations.NotNull;

public final class RelatedPostAdapter extends ListAdapter<Post, BaseViewHolder> {
    private static final RelatedPostAdapter$Companion$COMPARATOR$1 COMPARATOR = new RelatedPostAdapter$Companion$COMPARATOR$1();
    public static final Companion Companion = new Companion(null);
    private final Delegate delegate;

    public interface Delegate extends kr.co.popone.fitts.feature.feeds.PostFeedHolder.Delegate {
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public RelatedPostAdapter(@NotNull Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
        super((ItemCallback<T>) COMPARATOR);
        this.delegate = delegate2;
    }

    @NotNull
    public BaseViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        return PostFeedHolder.Companion.create(viewGroup, this.delegate);
    }

    public void onBindViewHolder(@NotNull BaseViewHolder baseViewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(baseViewHolder, "holder");
        BaseViewHolder.bind$default(baseViewHolder, getItem(i), null, 2, null);
    }
}
