package kr.co.popone.fitts.feature.feeds;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import androidx.core.content.ContextCompat;
import com.bumptech.glide.Glide;
import de.hdodenhof.circleimageview.CircleImageView;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.model.datamodel.action.ShopAction;
import kr.co.popone.fitts.model.datamodel.social.feed.FeedVariant;
import kr.co.popone.fitts.model.datamodel.social.feed.FeedVariantInfo;
import kr.co.popone.fitts.ui.ImageViewExtensionKt;
import kr.co.popone.fitts.ui.ViewExtensionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ShopCircleFeedHolder extends BaseViewHolder {
    public static final Companion Companion = new Companion(null);
    /* access modifiers changed from: private */
    public final Delegate delegate;
    private final ImageView shopCoverImageView;
    private final TextView shopTitleTextView;
    private final Group tobeOpendShopGroup;

    public static final class Companion {
        public final int getId() {
            return C0013R$layout.item_circle_shop_feed;
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ShopCircleFeedHolder create(@NotNull ViewGroup viewGroup, @NotNull Delegate delegate) {
            Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
            Intrinsics.checkParameterIsNotNull(delegate, "delegate");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.item_circle_shop_feed, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "view");
            return new ShopCircleFeedHolder(inflate, delegate);
        }
    }

    public interface Delegate extends ShopAction {
    }

    public ShopCircleFeedHolder(@NotNull View view, @NotNull Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(view, "itemView");
        Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
        super(view);
        this.delegate = delegate2;
        CircleImageView circleImageView = (CircleImageView) view.findViewById(C0010R$id.imageShopCover);
        Intrinsics.checkExpressionValueIsNotNull(circleImageView, "itemView.imageShopCover");
        this.shopCoverImageView = circleImageView;
        TextView textView = (TextView) view.findViewById(C0010R$id.textTitleName);
        Intrinsics.checkExpressionValueIsNotNull(textView, "itemView.textTitleName");
        this.shopTitleTextView = textView;
        Group group = (Group) view.findViewById(C0010R$id.groupTobeOpenedShop);
        Intrinsics.checkExpressionValueIsNotNull(group, "itemView.groupTobeOpenedShop");
        this.tobeOpendShopGroup = group;
    }

    public <T> void bind(@Nullable T t, @Nullable Integer num) {
        if (t instanceof FeedVariantInfo) {
            initView(((FeedVariantInfo) t).getFeed());
        }
    }

    private final void initView(FeedVariant feedVariant) {
        ImageView imageView = this.shopCoverImageView;
        View view = this.itemView;
        String str = "itemView";
        Intrinsics.checkExpressionValueIsNotNull(view, str);
        Context context = view.getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "itemView.context");
        ImageViewExtensionKt.loadImageAsCircle(imageView, context, feedVariant.getShopImageInfo().getUrl());
        this.shopTitleTextView.setText(feedVariant.getShopName());
        TextView textView = this.shopTitleTextView;
        View view2 = this.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view2, str);
        textView.setTextColor(ContextCompat.getColor(view2.getContext(), feedVariant.shopParallelTitleColor()));
        if (feedVariant.isComingSoonShop()) {
            ViewExtensionsKt.visible(this.tobeOpendShopGroup);
            return;
        }
        ViewExtensionsKt.gone(this.tobeOpendShopGroup);
        this.itemView.setOnClickListener(new ShopCircleFeedHolder$initView$1(this, feedVariant));
    }

    public void clear() {
        View view = this.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view, "itemView");
        Glide.with(view.getContext()).clear((View) this.shopCoverImageView);
    }
}
