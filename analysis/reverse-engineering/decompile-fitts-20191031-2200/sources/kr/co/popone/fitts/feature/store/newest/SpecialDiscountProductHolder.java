package kr.co.popone.fitts.feature.store.newest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import com.bumptech.glide.Glide;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.feature.feeds.BaseViewHolder;
import kr.co.popone.fitts.model.datamodel.action.SpecialDiscountAction;
import kr.co.popone.fitts.model.datamodel.commerce.discount.SpecialDiscount;
import kr.co.popone.fitts.model.datamodel.commerce.discount.SpecialDiscountFeed;
import kr.co.popone.fitts.ui.ViewExtensionsKt;
import kr.co.popone.fitts.ui.custom.RoundImageView;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class SpecialDiscountProductHolder extends BaseViewHolder {
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final Delegate delegate;
    private final Group specialDiscountBannerGroup;
    private final ImageView specialPriceBannerImageView;
    private final RoundImageView specialProductCoverImageView;
    private final TextView specialProductDcPrrcentageTextView;
    private final TextView specialProductNameTextView;
    private final TextView specialProductOriginalTextView;
    private final TextView specialProductPriceTextView;

    public static final class Companion {
        public final int getId() {
            return C0013R$layout.item_special_discount_single;
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final SpecialDiscountProductHolder create(@NotNull ViewGroup viewGroup, @NotNull Delegate delegate) {
            Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
            Intrinsics.checkParameterIsNotNull(delegate, "delegate");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.item_special_discount_single, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "view");
            return new SpecialDiscountProductHolder(inflate, delegate);
        }
    }

    public interface Delegate extends SpecialDiscountAction {
    }

    public SpecialDiscountProductHolder(@NotNull View view, @NotNull Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(view, "itemView");
        Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
        super(view);
        this.delegate = delegate2;
        this.specialPriceBannerImageView = (ImageView) view.findViewById(C0010R$id.iv_spc_price_banner);
        this.specialProductCoverImageView = (RoundImageView) view.findViewById(C0010R$id.iv_sp_product_cover);
        this.specialProductNameTextView = (TextView) view.findViewById(C0010R$id.tv_sp_product_name);
        this.specialProductPriceTextView = (TextView) view.findViewById(C0010R$id.tv_sp_product_price);
        this.specialProductOriginalTextView = (TextView) view.findViewById(C0010R$id.tv_sp_original_price);
        this.specialProductDcPrrcentageTextView = (TextView) view.findViewById(C0010R$id.tv_sp_discount_percentage);
        this.specialDiscountBannerGroup = (Group) view.findViewById(C0010R$id.groupSpecialPriceBanner);
    }

    @NotNull
    public final Delegate getDelegate() {
        return this.delegate;
    }

    public <T> void bind(@Nullable T t, @Nullable Integer num) {
        if (t instanceof SpecialDiscountFeed) {
            initView((SpecialDiscountFeed) t);
        }
    }

    private final void initView(SpecialDiscountFeed specialDiscountFeed) {
        initProductView(specialDiscountFeed.getEventId(), (SpecialDiscount) CollectionsKt___CollectionsKt.firstOrNull(specialDiscountFeed.getFeeds()));
        initBannerView(specialDiscountFeed.getBanner());
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0022  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void initProductView(long r5, kr.co.popone.fitts.model.datamodel.commerce.discount.SpecialDiscount r7) {
        /*
            r4 = this;
            kr.co.popone.fitts.ui.custom.RoundImageView r0 = r4.specialProductCoverImageView
            java.lang.String r1 = "specialProductCoverImageView"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            r1 = 0
            if (r7 == 0) goto L_0x0015
            kr.co.popone.fitts.model.product.Product r2 = r7.getProduct()
            if (r2 == 0) goto L_0x0015
            java.lang.String r2 = r2.getShopImageUrl()
            goto L_0x0016
        L_0x0015:
            r2 = r1
        L_0x0016:
            kr.co.popone.fitts.ui.ImageViewExtensionKt.loadImageAsProduct(r0, r2)
            android.widget.TextView r0 = r4.specialProductNameTextView
            java.lang.String r2 = "specialProductNameTextView"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r2)
            if (r7 == 0) goto L_0x002d
            kr.co.popone.fitts.model.product.Product r2 = r7.getProduct()
            if (r2 == 0) goto L_0x002d
            java.lang.String r2 = r2.getTitle()
            goto L_0x002e
        L_0x002d:
            r2 = r1
        L_0x002e:
            r0.setText(r2)
            android.widget.TextView r0 = r4.specialProductPriceTextView
            java.lang.String r2 = "specialProductPriceTextView"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r2)
            if (r7 == 0) goto L_0x0043
            long r2 = r7.getSpecialPrice()
            java.lang.String r2 = kr.co.popone.fitts.utils.IntExtensionsKt.commaString(r2)
            goto L_0x0044
        L_0x0043:
            r2 = r1
        L_0x0044:
            r0.setText(r2)
            android.widget.TextView r0 = r4.specialProductOriginalTextView
            java.lang.String r2 = "specialProductOriginalTextView"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r2)
            if (r7 == 0) goto L_0x005f
            kr.co.popone.fitts.model.product.Product r2 = r7.getProduct()
            if (r2 == 0) goto L_0x005f
            long r2 = r2.getOriginPrice()
            java.lang.String r2 = kr.co.popone.fitts.utils.IntExtensionsKt.commaString(r2)
            goto L_0x0060
        L_0x005f:
            r2 = r1
        L_0x0060:
            r0.setText(r2)
            android.widget.TextView r0 = r4.specialProductDcPrrcentageTextView
            java.lang.String r2 = "specialProductDcPrrcentageTextView"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r2)
            if (r7 == 0) goto L_0x0070
            java.lang.String r1 = r7.getDiscountPercentage()
        L_0x0070:
            r0.setText(r1)
            android.view.View r0 = r4.itemView
            kr.co.popone.fitts.feature.store.newest.SpecialDiscountProductHolder$initProductView$1 r1 = new kr.co.popone.fitts.feature.store.newest.SpecialDiscountProductHolder$initProductView$1
            r1.<init>(r4, r7, r5)
            r0.setOnClickListener(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.feature.store.newest.SpecialDiscountProductHolder.initProductView(long, kr.co.popone.fitts.model.datamodel.commerce.discount.SpecialDiscount):void");
    }

    private final void initBannerView(String str) {
        String str2 = "specialDiscountBannerGroup";
        if (str == null) {
            Group group = this.specialDiscountBannerGroup;
            Intrinsics.checkExpressionValueIsNotNull(group, str2);
            ViewExtensionsKt.gone(group);
            return;
        }
        Group group2 = this.specialDiscountBannerGroup;
        Intrinsics.checkExpressionValueIsNotNull(group2, str2);
        ViewExtensionsKt.visible(group2);
        View view = this.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view, "itemView");
        Intrinsics.checkExpressionValueIsNotNull(Glide.with(view.getContext()).load(str).into(this.specialPriceBannerImageView), "Glide.with(itemView.cont…cialPriceBannerImageView)");
    }

    public void clear() {
        View view = this.itemView;
        String str = "itemView";
        Intrinsics.checkExpressionValueIsNotNull(view, str);
        Glide.with(view.getContext()).clear((View) this.specialProductCoverImageView);
        View view2 = this.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view2, str);
        Glide.with(view2.getContext()).clear((View) this.specialPriceBannerImageView);
    }
}
