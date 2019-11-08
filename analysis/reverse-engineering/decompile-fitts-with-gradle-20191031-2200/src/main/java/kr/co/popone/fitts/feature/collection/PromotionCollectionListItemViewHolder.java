package kr.co.popone.fitts.feature.collection;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.ui.FittsCircleImageView;
import org.jetbrains.annotations.NotNull;

public final class PromotionCollectionListItemViewHolder extends ViewHolder {
    @NotNull
    private final View blueDotView;
    @NotNull
    private final View contentBottomLayout;
    @NotNull
    private final ImageView cover;
    @NotNull
    private final ViewGroup coverImageLayout;
    @NotNull
    private final TextView createAt;
    @NotNull
    private final TextView fittsId;
    @NotNull
    private final TextView followButton;
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
    private final FittsCircleImageView profileImage;
    @NotNull
    private final TextView shop;
    @NotNull
    private final TextView title;
    @NotNull
    private final TextView viewCountTextView;

    public PromotionCollectionListItemViewHolder(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "itemView");
        super(view);
        View findViewById = view.findViewById(C0010R$id.post_content);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "itemView.findViewById(R.id.post_content)");
        this.postContent = (LinearLayout) findViewById;
        View findViewById2 = view.findViewById(C0010R$id.profileImageView);
        Intrinsics.checkExpressionValueIsNotNull(findViewById2, "itemView.findViewById(R.id.profileImageView)");
        this.profileImage = (FittsCircleImageView) findViewById2;
        View findViewById3 = view.findViewById(C0010R$id.fitts_id);
        Intrinsics.checkExpressionValueIsNotNull(findViewById3, "itemView.findViewById(R.id.fitts_id)");
        this.fittsId = (TextView) findViewById3;
        View findViewById4 = view.findViewById(C0010R$id.follow_button);
        Intrinsics.checkExpressionValueIsNotNull(findViewById4, "itemView.findViewById(R.id.follow_button)");
        this.followButton = (TextView) findViewById4;
        View findViewById5 = view.findViewById(C0010R$id.coverImageLayout);
        Intrinsics.checkExpressionValueIsNotNull(findViewById5, "itemView.findViewById(R.id.coverImageLayout)");
        this.coverImageLayout = (ViewGroup) findViewById5;
        View findViewById6 = view.findViewById(C0010R$id.cover);
        Intrinsics.checkExpressionValueIsNotNull(findViewById6, "itemView.findViewById(R.id.cover)");
        this.cover = (ImageView) findViewById6;
        View findViewById7 = view.findViewById(2131363245);
        Intrinsics.checkExpressionValueIsNotNull(findViewById7, "itemView.findViewById(R.id.title)");
        this.title = (TextView) findViewById7;
        View findViewById8 = view.findViewById(C0010R$id.contentBottomLayout);
        Intrinsics.checkExpressionValueIsNotNull(findViewById8, "itemView.findViewById(R.id.contentBottomLayout)");
        this.contentBottomLayout = findViewById8;
        View findViewById9 = view.findViewById(C0010R$id.product);
        Intrinsics.checkExpressionValueIsNotNull(findViewById9, "itemView.findViewById(R.id.product)");
        this.product = (ImageView) findViewById9;
        View findViewById10 = view.findViewById(C0010R$id.create_at);
        Intrinsics.checkExpressionValueIsNotNull(findViewById10, "itemView.findViewById(R.id.create_at)");
        this.createAt = (TextView) findViewById10;
        View findViewById11 = view.findViewById(C0010R$id.shop);
        Intrinsics.checkExpressionValueIsNotNull(findViewById11, "itemView.findViewById(R.id.shop)");
        this.shop = (TextView) findViewById11;
        View findViewById12 = view.findViewById(C0010R$id.like_button);
        Intrinsics.checkExpressionValueIsNotNull(findViewById12, "itemView.findViewById(R.id.like_button)");
        this.likeButton = (LinearLayout) findViewById12;
        View findViewById13 = view.findViewById(C0010R$id.like_image);
        Intrinsics.checkExpressionValueIsNotNull(findViewById13, "itemView.findViewById(R.id.like_image)");
        this.likeImage = (ImageView) findViewById13;
        View findViewById14 = view.findViewById(C0010R$id.like_count);
        Intrinsics.checkExpressionValueIsNotNull(findViewById14, "itemView.findViewById(R.id.like_count)");
        this.likeCount = (TextView) findViewById14;
        View findViewById15 = view.findViewById(C0010R$id.viewCountTextView);
        Intrinsics.checkExpressionValueIsNotNull(findViewById15, "itemView.findViewById(R.id.viewCountTextView)");
        this.viewCountTextView = (TextView) findViewById15;
        View findViewById16 = view.findViewById(C0010R$id.fittieSuitBlue);
        Intrinsics.checkExpressionValueIsNotNull(findViewById16, "itemView.findViewById(R.id.fittieSuitBlue)");
        this.blueDotView = findViewById16;
    }

    @NotNull
    public final LinearLayout getPostContent() {
        return this.postContent;
    }

    @NotNull
    public final FittsCircleImageView getProfileImage() {
        return this.profileImage;
    }

    @NotNull
    public final TextView getFittsId() {
        return this.fittsId;
    }

    @NotNull
    public final TextView getFollowButton() {
        return this.followButton;
    }

    @NotNull
    public final ViewGroup getCoverImageLayout() {
        return this.coverImageLayout;
    }

    @NotNull
    public final ImageView getCover() {
        return this.cover;
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

    @NotNull
    public final View getBlueDotView() {
        return this.blueDotView;
    }

    @SuppressLint({"SetTextI18n"})
    public final void loadDate(@NotNull TextView textView, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(textView, "textView");
        Intrinsics.checkParameterIsNotNull(str, "text");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.getDefault());
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("M월 d일", Locale.getDefault());
        Date date = new Date(System.currentTimeMillis());
        Date parse = simpleDateFormat.parse(str);
        Intrinsics.checkExpressionValueIsNotNull(parse, "dateFormat.parse(text)");
        long time = date.getTime() - parse.getTime();
        if (time < 60000) {
            textView.setText("방금 전");
        } else if (time < 3600000) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf(time / 60000));
            sb.append("분 전");
            textView.setText(sb.toString());
        } else if (time < 86400000) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(String.valueOf(time / 3600000));
            sb2.append("시간 전");
            textView.setText(sb2.toString());
        } else if (time < 604800000) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(String.valueOf(time / 86400000));
            sb3.append("일 전");
            textView.setText(sb3.toString());
        } else {
            textView.setText(simpleDateFormat2.format(parse).toString());
        }
    }

    @SuppressLint({"SetTextI18n"})
    public final void loadShop(@NotNull TextView textView, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(textView, "textView");
        Intrinsics.checkParameterIsNotNull(str, "textshop");
        StringBuilder sb = new StringBuilder();
        sb.append('\'');
        sb.append(str);
        sb.append("'에서 구매");
        textView.setText(sb.toString());
    }
}
