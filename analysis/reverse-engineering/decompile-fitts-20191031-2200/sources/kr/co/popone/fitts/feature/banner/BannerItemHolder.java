package kr.co.popone.fitts.feature.banner;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.model.datamodel.service.banner.Banner;
import kr.co.popone.fitts.ui.ImageViewExtensionKt;
import org.jetbrains.annotations.NotNull;

public final class BannerItemHolder extends ViewHolder {
    public static final Companion Companion = new Companion(null);
    /* access modifiers changed from: private */
    public final Delegate delegate;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final BannerItemHolder create(@NotNull ViewGroup viewGroup, @NotNull Delegate delegate) {
            Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
            Intrinsics.checkParameterIsNotNull(delegate, "delegate");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.item_banner, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "view");
            return new BannerItemHolder(inflate, delegate);
        }
    }

    public interface Delegate {
        void onBannerClicked(@NotNull String str);
    }

    public BannerItemHolder(@NotNull View view, @NotNull Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(view, "itemView");
        Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
        super(view);
        this.delegate = delegate2;
    }

    public final ImageView bindTo(@NotNull Banner banner) {
        Intrinsics.checkParameterIsNotNull(banner, "banner");
        ImageView imageView = (ImageView) this.itemView.findViewById(C0010R$id.imageBanner);
        ImageViewExtensionKt.loadImage$default(imageView, banner.getImage().getUrl(), null, 2, null);
        imageView.setOnClickListener(new BannerItemHolder$bindTo$$inlined$with$lambda$1(this, banner));
        return imageView;
    }
}
