package kr.co.popone.fitts.feature.feeds;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.model.datamodel.action.SlidingBannerAction;
import kr.co.popone.fitts.model.datamodel.service.banner.BannerImage;
import kr.co.popone.fitts.model.datamodel.social.feed.FeedVariantInfo;
import kr.co.popone.fitts.model.datamodel.social.feed.SlidingBanner$Type;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class SlidingBannerItemHolder extends BaseViewHolder {
    public static final Companion Companion = new Companion(null);
    /* access modifiers changed from: private */
    public final Delegate delegate;
    private final ImageView homeBannerImageView;
    private final ImageView storeBannerImageView;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final SlidingBannerItemHolder create(@NotNull ViewGroup viewGroup, @NotNull Delegate delegate) {
            Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
            Intrinsics.checkParameterIsNotNull(delegate, "delegate");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(delegate.getSlidingBanner().getLayout(), viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "view");
            return new SlidingBannerItemHolder(inflate, delegate);
        }
    }

    public interface Delegate extends SlidingBannerAction {
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = new int[SlidingBanner$Type.values().length];

        static {
            $EnumSwitchMapping$0[SlidingBanner$Type.HOME.ordinal()] = 1;
            $EnumSwitchMapping$0[SlidingBanner$Type.SHOP.ordinal()] = 2;
        }
    }

    public SlidingBannerItemHolder(@NotNull View view, @NotNull Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(view, "itemView");
        Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
        super(view);
        this.delegate = delegate2;
        this.homeBannerImageView = (ImageView) view.findViewById(C0010R$id.iv_home_sliding_banner);
        this.storeBannerImageView = (ImageView) view.findViewById(C0010R$id.iv_store_sliding_banner);
    }

    public <T> void bind(@Nullable T t, @Nullable Integer num) {
        if (t instanceof FeedVariantInfo) {
            initView((FeedVariantInfo) t);
        }
    }

    private final void initView(FeedVariantInfo feedVariantInfo) {
        int i = WhenMappings.$EnumSwitchMapping$0[this.delegate.getSlidingBanner().ordinal()];
        if (i == 1) {
            ImageView imageView = this.homeBannerImageView;
            Intrinsics.checkExpressionValueIsNotNull(imageView, "homeBannerImageView");
            updateSlideBannerUi(imageView, feedVariantInfo);
        } else if (i == 2) {
            ImageView imageView2 = this.storeBannerImageView;
            Intrinsics.checkExpressionValueIsNotNull(imageView2, "storeBannerImageView");
            updateSlideBannerUi(imageView2, feedVariantInfo);
        }
    }

    private final void updateSlideBannerUi(ImageView imageView, FeedVariantInfo feedVariantInfo) {
        if (!feedVariantInfo.getFeed().isEmptyBanner()) {
            View view = this.itemView;
            Intrinsics.checkExpressionValueIsNotNull(view, "itemView");
            RequestManager with = Glide.with(view.getContext());
            BannerImage image = feedVariantInfo.getFeed().getImage();
            with.load(image != null ? image.getUrl() : null).apply(((RequestOptions) ((RequestOptions) new RequestOptions().dontAnimate()).dontTransform()).fitCenter()).into(imageView);
            this.itemView.setOnClickListener(new SlidingBannerItemHolder$updateSlideBannerUi$1(this, feedVariantInfo));
        }
    }

    public void clear() {
        View view = this.itemView;
        String str = "itemView";
        Intrinsics.checkExpressionValueIsNotNull(view, str);
        Glide.with(view.getContext()).clear((View) this.homeBannerImageView);
        View view2 = this.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view2, str);
        Glide.with(view2.getContext()).clear((View) this.storeBannerImageView);
    }
}
