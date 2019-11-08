package kr.co.popone.fitts.feature.collection;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import org.jetbrains.annotations.NotNull;

public final class PostItemViewHolder extends ViewHolder {
    @NotNull
    private final TextView byTextView;
    @NotNull
    private final TextView descriptionTextView;
    @NotNull
    private final TextView fittsIDTextView;
    @NotNull
    private final View itemSeparatorLineView;
    @NotNull
    private final ViewGroup postDetailLayout;
    @NotNull
    private final RecyclerView postImagesRecyclerView;
    @NotNull
    private final TextView priceTextView;
    @NotNull
    private final ImageView productImageView;
    @NotNull
    private final ViewGroup productInfoLayout;
    @NotNull
    private final View profileImageClickEventView;
    @NotNull
    private final ImageView profileImageView;
    @NotNull
    private final TextView shopNameTextView;
    @NotNull
    private final TextView sizeTextView;
    @NotNull
    private final TextView titleTextView;

    public PostItemViewHolder(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        super(view);
        View findViewById = view.findViewById(C0010R$id.titleTextView);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "view.findViewById(R.id.titleTextView)");
        this.titleTextView = (TextView) findViewById;
        View findViewById2 = view.findViewById(C0010R$id.profileImageView);
        Intrinsics.checkExpressionValueIsNotNull(findViewById2, "view.findViewById(R.id.profileImageView)");
        this.profileImageView = (ImageView) findViewById2;
        View findViewById3 = view.findViewById(C0010R$id.profileImageClickEventView);
        Intrinsics.checkExpressionValueIsNotNull(findViewById3, "view.findViewById(R.id.profileImageClickEventView)");
        this.profileImageClickEventView = findViewById3;
        View findViewById4 = view.findViewById(C0010R$id.byTextView);
        Intrinsics.checkExpressionValueIsNotNull(findViewById4, "view.findViewById(R.id.byTextView)");
        this.byTextView = (TextView) findViewById4;
        View findViewById5 = view.findViewById(C0010R$id.fittsIDTextView);
        Intrinsics.checkExpressionValueIsNotNull(findViewById5, "view.findViewById(R.id.fittsIDTextView)");
        this.fittsIDTextView = (TextView) findViewById5;
        View findViewById6 = view.findViewById(C0010R$id.postDetailLayout);
        Intrinsics.checkExpressionValueIsNotNull(findViewById6, "view.findViewById(R.id.postDetailLayout)");
        this.postDetailLayout = (ViewGroup) findViewById6;
        View findViewById7 = view.findViewById(C0010R$id.postImagesRecyclerView);
        Intrinsics.checkExpressionValueIsNotNull(findViewById7, "view.findViewById(R.id.postImagesRecyclerView)");
        this.postImagesRecyclerView = (RecyclerView) findViewById7;
        View findViewById8 = view.findViewById(C0010R$id.descriptionTextView);
        Intrinsics.checkExpressionValueIsNotNull(findViewById8, "view.findViewById(R.id.descriptionTextView)");
        this.descriptionTextView = (TextView) findViewById8;
        View findViewById9 = view.findViewById(C0010R$id.shopNameTextView);
        Intrinsics.checkExpressionValueIsNotNull(findViewById9, "view.findViewById(R.id.shopNameTextView)");
        this.shopNameTextView = (TextView) findViewById9;
        View findViewById10 = view.findViewById(C0010R$id.priceTextView);
        Intrinsics.checkExpressionValueIsNotNull(findViewById10, "view.findViewById(R.id.priceTextView)");
        this.priceTextView = (TextView) findViewById10;
        View findViewById11 = view.findViewById(C0010R$id.sizeTextView);
        Intrinsics.checkExpressionValueIsNotNull(findViewById11, "view.findViewById(R.id.sizeTextView)");
        this.sizeTextView = (TextView) findViewById11;
        View findViewById12 = view.findViewById(C0010R$id.productInfoLayout);
        Intrinsics.checkExpressionValueIsNotNull(findViewById12, "view.findViewById(R.id.productInfoLayout)");
        this.productInfoLayout = (ViewGroup) findViewById12;
        View findViewById13 = view.findViewById(C0010R$id.productImageView);
        Intrinsics.checkExpressionValueIsNotNull(findViewById13, "view.findViewById(R.id.productImageView)");
        this.productImageView = (ImageView) findViewById13;
        View findViewById14 = view.findViewById(C0010R$id.itemSeparatorLine);
        Intrinsics.checkExpressionValueIsNotNull(findViewById14, "view.findViewById(R.id.itemSeparatorLine)");
        this.itemSeparatorLineView = findViewById14;
    }

    @NotNull
    public final TextView getTitleTextView() {
        return this.titleTextView;
    }

    @NotNull
    public final ImageView getProfileImageView() {
        return this.profileImageView;
    }

    @NotNull
    public final View getProfileImageClickEventView() {
        return this.profileImageClickEventView;
    }

    @NotNull
    public final TextView getByTextView() {
        return this.byTextView;
    }

    @NotNull
    public final TextView getFittsIDTextView() {
        return this.fittsIDTextView;
    }

    @NotNull
    public final ViewGroup getPostDetailLayout() {
        return this.postDetailLayout;
    }

    @NotNull
    public final RecyclerView getPostImagesRecyclerView() {
        return this.postImagesRecyclerView;
    }

    @NotNull
    public final TextView getDescriptionTextView() {
        return this.descriptionTextView;
    }

    @NotNull
    public final TextView getShopNameTextView() {
        return this.shopNameTextView;
    }

    @NotNull
    public final TextView getPriceTextView() {
        return this.priceTextView;
    }

    @NotNull
    public final TextView getSizeTextView() {
        return this.sizeTextView;
    }

    @NotNull
    public final ViewGroup getProductInfoLayout() {
        return this.productInfoLayout;
    }

    @NotNull
    public final ImageView getProductImageView() {
        return this.productImageView;
    }

    @NotNull
    public final View getItemSeparatorLineView() {
        return this.itemSeparatorLineView;
    }
}
