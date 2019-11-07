package kr.co.popone.fitts.feature.me.like;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.model.post.PostAPI.Post;
import org.jetbrains.annotations.NotNull;

public final class LikedPostAdapter extends Adapter<ViewHolder> {
    public static final Companion Companion = new Companion(null);
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;
    private final Delegate delegate;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public interface Delegate extends kr.co.popone.fitts.feature.me.like.LikedPostViewHolder.Delegate {
        int getLikesPostCount();

        @NotNull
        List<Post> getLikesPosts();
    }

    public static final class HeaderViewHolder extends ViewHolder {
        @NotNull
        private final TextView likePostCount;

        public HeaderViewHolder(@NotNull View view) {
            Intrinsics.checkParameterIsNotNull(view, "itemView");
            super(view);
            View findViewById = view.findViewById(C0010R$id.like_post_count);
            Intrinsics.checkExpressionValueIsNotNull(findViewById, "itemView.findViewById(R.id.like_post_count)");
            this.likePostCount = (TextView) findViewById;
        }

        @NotNull
        public final TextView getLikePostCount() {
            return this.likePostCount;
        }
    }

    public LikedPostAdapter(@NotNull Context context, @NotNull Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
        this.delegate = delegate2;
    }

    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        if (i != TYPE_HEADER) {
            return LikedPostViewHolder.Companion.create(viewGroup);
        }
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.item_liked_header, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "LayoutInflater.from(pare…ed_header, parent, false)");
        return new HeaderViewHolder(inflate);
    }

    public int getItemViewType(int i) {
        if (i == 0) {
            return TYPE_HEADER;
        }
        return TYPE_ITEM;
    }

    private final Post getItem(int i) {
        return (Post) this.delegate.getLikesPosts().get(i - 1);
    }

    public int getItemCount() {
        return this.delegate.getLikesPosts().size() + 1;
    }

    @SuppressLint({"SetTextI18n"})
    public void onBindViewHolder(@NotNull ViewHolder viewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
        if (viewHolder instanceof HeaderViewHolder) {
            TextView likePostCount = ((HeaderViewHolder) viewHolder).getLikePostCount();
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf(this.delegate.getLikesPostCount()));
            sb.append("개의 포스트");
            likePostCount.setText(sb.toString());
        } else if (viewHolder instanceof LikedPostViewHolder) {
            ((LikedPostViewHolder) viewHolder).bind(getItem(i), this.delegate);
        }
    }
}
