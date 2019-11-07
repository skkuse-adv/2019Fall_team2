package kr.co.popone.fitts.feature.feeds;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.model.datamodel.action.SpecialDiscountAction;
import kr.co.popone.fitts.model.datamodel.commerce.discount.SpecialDiscount;
import kr.co.popone.fitts.model.datamodel.commerce.discount.SpecialDiscountFeed;
import kr.co.popone.fitts.model.datamodel.commerce.discount.SpecialDiscountView;
import kr.co.popone.fitts.model.product.Product;
import kr.co.popone.fitts.ui.ImageViewExtensionKt;
import kr.co.popone.fitts.ui.custom.RoundImageView;
import kr.co.popone.fitts.utils.IntExtensionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class SpecialDiscountDoubleFeedHolder extends BaseViewHolder {
    public static final Companion Companion = new Companion(null);
    /* access modifiers changed from: private */
    public final Delegate delegate;
    private final SpecialDiscountView productLeft;
    private final SpecialDiscountView productRight;

    public static final class Companion {
        public final int getId() {
            return C0013R$layout.item_special_discount_double;
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final SpecialDiscountDoubleFeedHolder create(@NotNull ViewGroup viewGroup, @NotNull Delegate delegate) {
            Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
            Intrinsics.checkParameterIsNotNull(delegate, "delegate");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.item_special_discount_double, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "view");
            return new SpecialDiscountDoubleFeedHolder(inflate, delegate);
        }
    }

    public interface Delegate extends SpecialDiscountAction {
    }

    public void clear() {
    }

    public SpecialDiscountDoubleFeedHolder(@NotNull View view, @NotNull Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(view, "itemView");
        Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
        super(view);
        this.delegate = delegate2;
        View findViewById = view.findViewById(C0010R$id.productLeft);
        String str = "this";
        Intrinsics.checkExpressionValueIsNotNull(findViewById, str);
        RoundImageView roundImageView = (RoundImageView) findViewById.findViewById(C0010R$id.iv_product_feed_cover);
        String str2 = "iv_product_feed_cover";
        Intrinsics.checkExpressionValueIsNotNull(roundImageView, str2);
        TextView textView = (TextView) findViewById.findViewById(C0010R$id.tv_product_feed_title);
        String str3 = "tv_product_feed_title";
        Intrinsics.checkExpressionValueIsNotNull(textView, str3);
        TextView textView2 = (TextView) findViewById.findViewById(C0010R$id.tv_product_feed_discount_percentage);
        String str4 = "tv_product_feed_discount_percentage";
        Intrinsics.checkExpressionValueIsNotNull(textView2, str4);
        TextView textView3 = (TextView) findViewById.findViewById(C0010R$id.tv_product_feed_sale_price);
        String str5 = "tv_product_feed_sale_price";
        Intrinsics.checkExpressionValueIsNotNull(textView3, str5);
        TextView textView4 = (TextView) findViewById.findViewById(C0010R$id.tv_product_feed_origin_price);
        String str6 = "tv_product_feed_origin_price";
        Intrinsics.checkExpressionValueIsNotNull(textView4, str6);
        SpecialDiscountView specialDiscountView = new SpecialDiscountView(findViewById, roundImageView, textView, textView2, textView3, textView4);
        this.productLeft = specialDiscountView;
        View findViewById2 = view.findViewById(C0010R$id.productRight);
        Intrinsics.checkExpressionValueIsNotNull(findViewById2, str);
        RoundImageView roundImageView2 = (RoundImageView) findViewById2.findViewById(C0010R$id.iv_product_feed_cover);
        Intrinsics.checkExpressionValueIsNotNull(roundImageView2, str2);
        TextView textView5 = (TextView) findViewById2.findViewById(C0010R$id.tv_product_feed_title);
        Intrinsics.checkExpressionValueIsNotNull(textView5, str3);
        TextView textView6 = (TextView) findViewById2.findViewById(C0010R$id.tv_product_feed_discount_percentage);
        Intrinsics.checkExpressionValueIsNotNull(textView6, str4);
        TextView textView7 = (TextView) findViewById2.findViewById(C0010R$id.tv_product_feed_sale_price);
        Intrinsics.checkExpressionValueIsNotNull(textView7, str5);
        TextView textView8 = (TextView) findViewById2.findViewById(C0010R$id.tv_product_feed_origin_price);
        Intrinsics.checkExpressionValueIsNotNull(textView8, str6);
        SpecialDiscountView specialDiscountView2 = new SpecialDiscountView(findViewById2, roundImageView2, textView5, textView6, textView7, textView8);
        this.productRight = specialDiscountView2;
    }

    public <T> void bind(@Nullable T t, @Nullable Integer num) {
        if (t instanceof SpecialDiscountFeed) {
            initView((SpecialDiscountFeed) t);
        }
    }

    private final void initView(SpecialDiscountFeed specialDiscountFeed) {
        initProductView(this.productLeft, specialDiscountFeed.getEventId(), (SpecialDiscount) CollectionsKt___CollectionsKt.getOrNull(specialDiscountFeed.getFeeds(), 0));
        initProductView(this.productRight, specialDiscountFeed.getEventId(), (SpecialDiscount) CollectionsKt___CollectionsKt.getOrNull(specialDiscountFeed.getFeeds(), 1));
    }

    private final void initProductView(SpecialDiscountView specialDiscountView, long j, SpecialDiscount specialDiscount) {
        if (specialDiscount == null) {
            specialDiscountView.invisible();
            return;
        }
        ImageView coverImageView = specialDiscountView.getCoverImageView();
        Product product = specialDiscount.getProduct();
        String str = null;
        ImageViewExtensionKt.loadImageAsProduct(coverImageView, product != null ? product.getShopImageUrl() : null);
        TextView titleTextView = specialDiscountView.getTitleTextView();
        Product product2 = specialDiscount.getProduct();
        titleTextView.setText(product2 != null ? product2.getTitle() : null);
        specialDiscountView.getSalesPriceTextView().setText(IntExtensionsKt.commaString(specialDiscount.getSpecialPrice()));
        TextView originPriceTextView = specialDiscountView.getOriginPriceTextView();
        Product product3 = specialDiscount.getProduct();
        if (product3 != null) {
            str = IntExtensionsKt.commaString(product3.getOriginPrice());
        }
        originPriceTextView.setText(str);
        specialDiscountView.getDiscountTextView().setText(specialDiscount.getDiscountPercentage());
        specialDiscountView.getParent().setOnClickListener(new SpecialDiscountDoubleFeedHolder$initProductView$1(this, specialDiscount, j));
        specialDiscountView.visible();
    }
}
