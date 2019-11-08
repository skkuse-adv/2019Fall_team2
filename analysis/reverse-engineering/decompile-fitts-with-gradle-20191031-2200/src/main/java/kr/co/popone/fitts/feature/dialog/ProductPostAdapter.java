package kr.co.popone.fitts.feature.dialog;

import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil.ItemCallback;
import androidx.recyclerview.widget.ListAdapter;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.feeds.BaseViewHolder;
import kr.co.popone.fitts.model.post.PostAPI.Post;
import org.jetbrains.annotations.NotNull;

public final class ProductPostAdapter extends ListAdapter<Post, ProductPostViewHolder> {
    /* access modifiers changed from: private */
    @NotNull
    public static final ItemCallback<Post> COMPARATOR = new ProductPostAdapter$Companion$COMPARATOR$1();
    public static final Companion Companion = new Companion(null);
    private final Delegate delegate;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ItemCallback<Post> getCOMPARATOR() {
            return ProductPostAdapter.COMPARATOR;
        }
    }

    public interface Delegate extends kr.co.popone.fitts.feature.dialog.ProductPostViewHolder.Delegate {
    }

    public ProductPostAdapter(@NotNull Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
        super(COMPARATOR);
        this.delegate = delegate2;
    }

    @NotNull
    public ProductPostViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        return ProductPostViewHolder.Companion.create(viewGroup, this.delegate);
    }

    public void onBindViewHolder(@NotNull ProductPostViewHolder productPostViewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(productPostViewHolder, "holder");
        BaseViewHolder.bind$default(productPostViewHolder, getItem(i), null, 2, null);
    }

    public void onViewRecycled(@NotNull ProductPostViewHolder productPostViewHolder) {
        Intrinsics.checkParameterIsNotNull(productPostViewHolder, "holder");
        productPostViewHolder.recycle();
        super.onViewRecycled(productPostViewHolder);
    }
}
