package kr.co.popone.fitts.feature.showroom;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import org.jetbrains.annotations.NotNull;

public final class ShowroomPostListItemViewHolder extends ViewHolder {
    @NotNull
    private final View contentBottomLayout;
    @NotNull
    private final ImageView cover;
    @NotNull
    private final ImageView coverIconForInactivity;
    @NotNull
    private final ImageView coverImageViewForInactivity;
    @NotNull
    private final TextView createAt;
    @NotNull
    private final LinearLayout likeButton;
    @NotNull
    private final TextView likeCount;
    @NotNull
    private final ImageView likeImage;
    @NotNull
    private final LinearLayout postContent;
    @NotNull
    private final ImageView product;
    @NotNull
    private final TextView shop;
    @NotNull
    private final TextView title;
    @NotNull
    private final TextView viewCountTextView;

    public ShowroomPostListItemViewHolder(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "itemView");
        super(view);
        View findViewById = view.findViewById(C0010R$id.post_content);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "itemView.findViewById(R.id.post_content)");
        this.postContent = (LinearLayout) findViewById;
        View findViewById2 = view.findViewById(C0010R$id.cover);
        Intrinsics.checkExpressionValueIsNotNull(findViewById2, "itemView.findViewById(R.id.cover)");
        this.cover = (ImageView) findViewById2;
        View findViewById3 = view.findViewById(C0010R$id.inactive_post);
        Intrinsics.checkExpressionValueIsNotNull(findViewById3, "itemView.findViewById(R.id.inactive_post)");
        this.coverImageViewForInactivity = (ImageView) findViewById3;
        View findViewById4 = view.findViewById(C0010R$id.inactive_post_icon);
        Intrinsics.checkExpressionValueIsNotNull(findViewById4, "itemView.findViewById(R.id.inactive_post_icon)");
        this.coverIconForInactivity = (ImageView) findViewById4;
        View findViewById5 = view.findViewById(2131363245);
        Intrinsics.checkExpressionValueIsNotNull(findViewById5, "itemView.findViewById(R.id.title)");
        this.title = (TextView) findViewById5;
        View findViewById6 = view.findViewById(C0010R$id.contentBottomLayout);
        Intrinsics.checkExpressionValueIsNotNull(findViewById6, "itemView.findViewById(R.id.contentBottomLayout)");
        this.contentBottomLayout = findViewById6;
        View findViewById7 = view.findViewById(C0010R$id.product);
        Intrinsics.checkExpressionValueIsNotNull(findViewById7, "itemView.findViewById(R.id.product)");
        this.product = (ImageView) findViewById7;
        View findViewById8 = view.findViewById(C0010R$id.create_at);
        Intrinsics.checkExpressionValueIsNotNull(findViewById8, "itemView.findViewById(R.id.create_at)");
        this.createAt = (TextView) findViewById8;
        View findViewById9 = view.findViewById(C0010R$id.shop);
        Intrinsics.checkExpressionValueIsNotNull(findViewById9, "itemView.findViewById(R.id.shop)");
        this.shop = (TextView) findViewById9;
        View findViewById10 = view.findViewById(C0010R$id.like_button);
        Intrinsics.checkExpressionValueIsNotNull(findViewById10, "itemView.findViewById(R.id.like_button)");
        this.likeButton = (LinearLayout) findViewById10;
        View findViewById11 = view.findViewById(C0010R$id.like_image);
        Intrinsics.checkExpressionValueIsNotNull(findViewById11, "itemView.findViewById(R.id.like_image)");
        this.likeImage = (ImageView) findViewById11;
        View findViewById12 = view.findViewById(C0010R$id.like_count);
        Intrinsics.checkExpressionValueIsNotNull(findViewById12, "itemView.findViewById(R.id.like_count)");
        this.likeCount = (TextView) findViewById12;
        View findViewById13 = view.findViewById(C0010R$id.viewCountTextView);
        Intrinsics.checkExpressionValueIsNotNull(findViewById13, "itemView.findViewById(R.id.viewCountTextView)");
        this.viewCountTextView = (TextView) findViewById13;
    }

    @NotNull
    public final LinearLayout getPostContent() {
        return this.postContent;
    }

    @NotNull
    public final ImageView getCover() {
        return this.cover;
    }

    @NotNull
    public final ImageView getCoverImageViewForInactivity() {
        return this.coverImageViewForInactivity;
    }

    @NotNull
    public final ImageView getCoverIconForInactivity() {
        return this.coverIconForInactivity;
    }

    @NotNull
    public final TextView getTitle() {
        return this.title;
    }

    @NotNull
    public final View getContentBottomLayout() {
        return this.contentBottomLayout;
    }

    @NotNull
    public final ImageView getProduct() {
        return this.product;
    }

    @NotNull
    public final TextView getCreateAt() {
        return this.createAt;
    }

    @NotNull
    public final TextView getShop() {
        return this.shop;
    }

    @NotNull
    public final LinearLayout getLikeButton() {
        return this.likeButton;
    }

    @NotNull
    public final ImageView getLikeImage() {
        return this.likeImage;
    }

    @NotNull
    public final TextView getLikeCount() {
        return this.likeCount;
    }

    @NotNull
    public final TextView getViewCountTextView() {
        return this.viewCountTextView;
    }
}
