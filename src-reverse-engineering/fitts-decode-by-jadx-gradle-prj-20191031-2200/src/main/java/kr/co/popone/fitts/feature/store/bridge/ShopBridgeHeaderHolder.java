package kr.co.popone.fitts.feature.store.bridge;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bumptech.glide.Glide;
import de.hdodenhof.circleimageview.CircleImageView;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0008R$drawable;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.feature.feeds.BaseViewHolder;
import kr.co.popone.fitts.model.datamodel.action.BookmarkAction;
import kr.co.popone.fitts.model.post.PostAPI.Style;
import kr.co.popone.fitts.model.store.StoreInfo;
import kr.co.popone.fitts.ui.ViewExtensionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ShopBridgeHeaderHolder extends BaseViewHolder {
    public static final Companion Companion = new Companion(null);
    /* access modifiers changed from: private */
    public final Delegate delegate;
    private final TextView shopBodyFeatureTextView;
    private final ImageView shopBookmarkImageView;
    private final CircleImageView shopCoverImageView;
    private final TextView shopProductFeatureTextView;
    private final TextView storeNameTextView;
    private final TextView textStyleKeywordFirst;
    private final TextView textStyleKeywordSecond;
    private final TextView textStyleKeywordSingle;

    public static final class Companion {
        public final int getId() {
            return C0013R$layout.item_store_bridge_header;
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ShopBridgeHeaderHolder create(@NotNull ViewGroup viewGroup, @NotNull Delegate delegate) {
            Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
            Intrinsics.checkParameterIsNotNull(delegate, "delegate");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.item_store_bridge_header, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "view");
            return new ShopBridgeHeaderHolder(inflate, delegate);
        }
    }

    public interface Delegate extends BookmarkAction {
    }

    public ShopBridgeHeaderHolder(@NotNull View view, @NotNull Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(view, "itemView");
        Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
        super(view);
        this.delegate = delegate2;
        this.storeNameTextView = (TextView) view.findViewById(C0010R$id.tv_store_name);
        this.textStyleKeywordSingle = (TextView) view.findViewById(C0010R$id.tv_style_keyword_single);
        this.textStyleKeywordFirst = (TextView) view.findViewById(C0010R$id.tv_style_keyword_first);
        this.textStyleKeywordSecond = (TextView) view.findViewById(C0010R$id.tv_style_keyword_second);
        TextView textView = (TextView) view.findViewById(C0010R$id.tv_shop_body_feature);
        Intrinsics.checkExpressionValueIsNotNull(textView, "itemView.tv_shop_body_feature");
        this.shopBodyFeatureTextView = textView;
        TextView textView2 = (TextView) view.findViewById(C0010R$id.tv_shop_product_feature);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "itemView.tv_shop_product_feature");
        this.shopProductFeatureTextView = textView2;
        CircleImageView circleImageView = (CircleImageView) view.findViewById(C0010R$id.iv_shop_cover);
        Intrinsics.checkExpressionValueIsNotNull(circleImageView, "itemView.iv_shop_cover");
        this.shopCoverImageView = circleImageView;
        ImageView imageView = (ImageView) view.findViewById(C0010R$id.iv_shop_bookmark);
        Intrinsics.checkExpressionValueIsNotNull(imageView, "itemView.iv_shop_bookmark");
        this.shopBookmarkImageView = imageView;
    }

    public <T> void bind(@Nullable T t, @Nullable Integer num) {
        if (t instanceof StoreInfo) {
            initView((StoreInfo) t);
        }
    }

    public void clear() {
        Glide.with(this.itemView.getContext()).clear((View) this.shopCoverImageView);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0019, code lost:
        if (r1 != null) goto L_0x001e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void initView(kr.co.popone.fitts.model.store.StoreInfo r6) {
        /*
            r5 = this;
            android.view.View r0 = r5.itemView
            java.lang.String r1 = "itemView"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            android.content.Context r0 = r0.getContext()
            com.bumptech.glide.RequestManager r0 = com.bumptech.glide.Glide.with(r0)
            kr.co.popone.fitts.model.store.StoreImageInfo r1 = r6.getStoreImageInfo()
            if (r1 == 0) goto L_0x001c
            java.lang.String r1 = r1.getUrl()
            if (r1 == 0) goto L_0x001c
            goto L_0x001e
        L_0x001c:
            java.lang.String r1 = ""
        L_0x001e:
            com.bumptech.glide.RequestBuilder r0 = r0.load(r1)
            com.bumptech.glide.request.RequestOptions r1 = new com.bumptech.glide.request.RequestOptions
            r1.<init>()
            r2 = 1
            com.bumptech.glide.load.Transformation[] r2 = new com.bumptech.glide.load.Transformation[r2]
            r3 = 0
            com.bumptech.glide.load.resource.bitmap.CenterCrop r4 = new com.bumptech.glide.load.resource.bitmap.CenterCrop
            r4.<init>()
            r2[r3] = r4
            com.bumptech.glide.request.BaseRequestOptions r1 = r1.transforms(r2)
            com.bumptech.glide.RequestBuilder r0 = r0.apply(r1)
            de.hdodenhof.circleimageview.CircleImageView r1 = r5.shopCoverImageView
            r0.into(r1)
            android.widget.TextView r0 = r5.shopBodyFeatureTextView
            java.lang.String r1 = r6.getBodyFeatrue()
            if (r1 != 0) goto L_0x004b
            kr.co.popone.fitts.ui.ViewExtensionsKt.gone(r0)
            goto L_0x0052
        L_0x004b:
            java.lang.String r1 = r6.getBodyFeatrue()
            r0.setText(r1)
        L_0x0052:
            android.widget.TextView r0 = r5.shopProductFeatureTextView
            java.lang.String r1 = r6.getProductFeature()
            if (r1 != 0) goto L_0x005e
            kr.co.popone.fitts.ui.ViewExtensionsKt.gone(r0)
            goto L_0x0065
        L_0x005e:
            java.lang.String r1 = r6.getProductFeature()
            r0.setText(r1)
        L_0x0065:
            android.widget.TextView r0 = r5.storeNameTextView
            java.lang.String r1 = "storeNameTextView"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            java.lang.String r1 = r6.getStoreName()
            r0.setText(r1)
            android.widget.ImageView r0 = r5.shopBookmarkImageView
            kr.co.popone.fitts.feature.store.bridge.ShopBridgeHeaderHolder$initView$$inlined$with$lambda$1 r1 = new kr.co.popone.fitts.feature.store.bridge.ShopBridgeHeaderHolder$initView$$inlined$with$lambda$1
            r1.<init>(r6, r5)
            r0.setOnClickListener(r1)
            java.util.List r0 = r6.getStyles()
            r5.updateShopStyle(r0)
            boolean r6 = r6.isBookmark()
            r5.updateShopFavorite(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.feature.store.bridge.ShopBridgeHeaderHolder.initView(kr.co.popone.fitts.model.store.StoreInfo):void");
    }

    private final void updateShopFavorite(boolean z) {
        String str = "itemView";
        if (z) {
            ImageView imageView = this.shopBookmarkImageView;
            View view = this.itemView;
            Intrinsics.checkExpressionValueIsNotNull(view, str);
            imageView.setImageDrawable(ContextCompat.getDrawable(view.getContext(), C0008R$drawable.img_icon_circle_bookmark_on));
        } else if (!z) {
            ImageView imageView2 = this.shopBookmarkImageView;
            View view2 = this.itemView;
            Intrinsics.checkExpressionValueIsNotNull(view2, str);
            imageView2.setImageDrawable(ContextCompat.getDrawable(view2.getContext(), C0008R$drawable.img_icon_circle_bookmark_off));
        }
    }

    public final void updateShopInfo(@NotNull StoreInfo storeInfo) {
        Intrinsics.checkParameterIsNotNull(storeInfo, "shopInfo");
        updateShopFavorite(storeInfo.isBookmark());
    }

    private final void updateShopStyle(List<Style> list) {
        int size = list.size();
        String str = "textStyleKeywordSingle";
        String str2 = "textStyleKeywordSecond";
        String str3 = "textStyleKeywordFirst";
        if (size == 1) {
            TextView textView = this.textStyleKeywordFirst;
            Intrinsics.checkExpressionValueIsNotNull(textView, str3);
            ViewExtensionsKt.gone(textView);
            TextView textView2 = this.textStyleKeywordSecond;
            Intrinsics.checkExpressionValueIsNotNull(textView2, str2);
            ViewExtensionsKt.gone(textView2);
            TextView textView3 = this.textStyleKeywordSingle;
            Intrinsics.checkExpressionValueIsNotNull(textView3, str);
            textView3.setText(((Style) list.get(0)).getName());
        } else if (size != 2) {
            TextView textView4 = this.textStyleKeywordFirst;
            Intrinsics.checkExpressionValueIsNotNull(textView4, str3);
            ViewExtensionsKt.gone(textView4);
            TextView textView5 = this.textStyleKeywordSecond;
            Intrinsics.checkExpressionValueIsNotNull(textView5, str2);
            ViewExtensionsKt.gone(textView5);
            TextView textView6 = this.textStyleKeywordSingle;
            Intrinsics.checkExpressionValueIsNotNull(textView6, str);
            ViewExtensionsKt.gone(textView6);
        } else {
            TextView textView7 = this.textStyleKeywordSingle;
            Intrinsics.checkExpressionValueIsNotNull(textView7, str);
            ViewExtensionsKt.gone(textView7);
            TextView textView8 = this.textStyleKeywordFirst;
            Intrinsics.checkExpressionValueIsNotNull(textView8, str3);
            textView8.setText(((Style) list.get(0)).getName());
            TextView textView9 = this.textStyleKeywordSecond;
            Intrinsics.checkExpressionValueIsNotNull(textView9, str2);
            textView9.setText(((Style) list.get(1)).getName());
        }
    }
}
