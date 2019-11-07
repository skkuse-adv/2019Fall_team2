package kr.co.popone.fitts.feature.store.list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import de.hdodenhof.circleimageview.CircleImageView;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.feature.feeds.BaseViewHolder;
import kr.co.popone.fitts.model.post.PostAPI.Style;
import kr.co.popone.fitts.model.store.StoreImageInfo;
import kr.co.popone.fitts.model.store.StoreInfo;
import kr.co.popone.fitts.ui.ImageViewExtensionKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class StoreListViewHolder extends BaseViewHolder {
    public static final Companion Companion = new Companion(null);
    private final TextView bodyFeatureTextView;
    /* access modifiers changed from: private */
    public final Delegate delegate;
    private final TextView productFeatureTextView;
    private final CircleImageView storeCoverImage;
    private final TextView storeNameTextView;
    private final TextView styleFirstKeywordTextView;
    private final TextView styleSecondKeywordTextView;
    private final TextView styleSingleKeywordTextView;

    public static final class Companion {
        public final int getId() {
            return C0013R$layout.item_store_list;
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final StoreListViewHolder create(@NotNull ViewGroup viewGroup, @NotNull Delegate delegate) {
            Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
            Intrinsics.checkParameterIsNotNull(delegate, "delegate");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.item_store_list, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "view");
            return new StoreListViewHolder(inflate, delegate);
        }
    }

    public interface Delegate {
        void onStoreClick(long j);
    }

    public StoreListViewHolder(@NotNull View view, @NotNull Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(view, "itemView");
        Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
        super(view);
        this.delegate = delegate2;
        this.storeCoverImage = (CircleImageView) view.findViewById(C0010R$id.iv_store_cover);
        this.storeNameTextView = (TextView) view.findViewById(C0010R$id.tv_store_name);
        this.styleSingleKeywordTextView = (TextView) view.findViewById(C0010R$id.tv_style_keyword_single);
        this.styleFirstKeywordTextView = (TextView) view.findViewById(C0010R$id.tv_style_keyword_first);
        this.styleSecondKeywordTextView = (TextView) view.findViewById(C0010R$id.tv_style_keyword_second);
        this.bodyFeatureTextView = (TextView) view.findViewById(C0010R$id.tv_body_feature);
        this.productFeatureTextView = (TextView) view.findViewById(C0010R$id.tv_product_feature);
    }

    public <T> void bind(@Nullable T t, @Nullable Integer num) {
        if (t instanceof StoreInfo) {
            updateStoreListUi((StoreInfo) t);
        }
    }

    public void clear() {
        Glide.with(this.itemView.getContext()).clear((View) this.storeCoverImage);
    }

    private final void updateStoreListUi(StoreInfo storeInfo) {
        this.itemView.setOnClickListener(new StoreListViewHolder$updateStoreListUi$$inlined$with$lambda$1(storeInfo, this));
        TextView textView = this.storeNameTextView;
        Intrinsics.checkExpressionValueIsNotNull(textView, "storeNameTextView");
        textView.setText(storeInfo.getStoreName());
        String str = "styleSecondKeywordTextView";
        String str2 = "styleFirstKeywordTextView";
        String str3 = "styleSingleKeywordTextView";
        boolean z = true;
        if (storeInfo.getStyles().size() == 2) {
            TextView textView2 = this.styleSingleKeywordTextView;
            Intrinsics.checkExpressionValueIsNotNull(textView2, str3);
            textView2.setVisibility(8);
            TextView textView3 = this.styleFirstKeywordTextView;
            Intrinsics.checkExpressionValueIsNotNull(textView3, str2);
            textView3.setVisibility(0);
            TextView textView4 = this.styleSecondKeywordTextView;
            Intrinsics.checkExpressionValueIsNotNull(textView4, str);
            textView4.setVisibility(0);
            TextView textView5 = this.styleFirstKeywordTextView;
            Intrinsics.checkExpressionValueIsNotNull(textView5, str2);
            textView5.setText(((Style) storeInfo.getStyles().get(0)).getName());
            TextView textView6 = this.styleSecondKeywordTextView;
            Intrinsics.checkExpressionValueIsNotNull(textView6, str);
            textView6.setText(((Style) storeInfo.getStyles().get(1)).getName());
        } else if (storeInfo.getStyles().size() == 1) {
            TextView textView7 = this.styleSingleKeywordTextView;
            Intrinsics.checkExpressionValueIsNotNull(textView7, str3);
            textView7.setVisibility(0);
            TextView textView8 = this.styleFirstKeywordTextView;
            Intrinsics.checkExpressionValueIsNotNull(textView8, str2);
            textView8.setVisibility(8);
            TextView textView9 = this.styleSecondKeywordTextView;
            Intrinsics.checkExpressionValueIsNotNull(textView9, str);
            textView9.setVisibility(8);
            TextView textView10 = this.styleSingleKeywordTextView;
            Intrinsics.checkExpressionValueIsNotNull(textView10, str3);
            textView10.setText(((Style) storeInfo.getStyles().get(0)).getName());
        } else {
            TextView textView11 = this.styleSingleKeywordTextView;
            Intrinsics.checkExpressionValueIsNotNull(textView11, str3);
            textView11.setVisibility(8);
            TextView textView12 = this.styleFirstKeywordTextView;
            Intrinsics.checkExpressionValueIsNotNull(textView12, str2);
            textView12.setVisibility(8);
            TextView textView13 = this.styleSecondKeywordTextView;
            Intrinsics.checkExpressionValueIsNotNull(textView13, str);
            textView13.setVisibility(8);
        }
        String bodyFeatrue = storeInfo.getBodyFeatrue();
        String str4 = "bodyFeatureTextView";
        if (bodyFeatrue == null || bodyFeatrue.length() == 0) {
            TextView textView14 = this.bodyFeatureTextView;
            Intrinsics.checkExpressionValueIsNotNull(textView14, str4);
            textView14.setVisibility(8);
        } else {
            TextView textView15 = this.bodyFeatureTextView;
            Intrinsics.checkExpressionValueIsNotNull(textView15, str4);
            textView15.setVisibility(0);
            TextView textView16 = this.bodyFeatureTextView;
            Intrinsics.checkExpressionValueIsNotNull(textView16, str4);
            textView16.setText(storeInfo.getBodyFeatrue());
        }
        String productFeature = storeInfo.getProductFeature();
        if (!(productFeature == null || productFeature.length() == 0)) {
            z = false;
        }
        String str5 = "productFeatureTextView";
        if (z) {
            TextView textView17 = this.productFeatureTextView;
            Intrinsics.checkExpressionValueIsNotNull(textView17, str5);
            textView17.setVisibility(8);
        } else {
            TextView textView18 = this.productFeatureTextView;
            Intrinsics.checkExpressionValueIsNotNull(textView18, str5);
            textView18.setVisibility(0);
            TextView textView19 = this.productFeatureTextView;
            Intrinsics.checkExpressionValueIsNotNull(textView19, str5);
            textView19.setText(storeInfo.getProductFeature());
        }
        CircleImageView circleImageView = this.storeCoverImage;
        Intrinsics.checkExpressionValueIsNotNull(circleImageView, "storeCoverImage");
        View view = this.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view, "itemView");
        Context context = view.getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "itemView.context");
        StoreImageInfo storeImageInfo = storeInfo.getStoreImageInfo();
        ImageViewExtensionKt.loadImageAsCircle(circleImageView, context, storeImageInfo != null ? storeImageInfo.getUrl() : null);
    }
}
