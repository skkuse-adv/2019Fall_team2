package kr.co.popone.fitts.feature.search;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.model.search.StyleRecommendViewData;
import kr.co.popone.fitts.ui.ImageViewExtensionKt;
import kr.co.popone.fitts.ui.custom.RoundImageView;
import org.jetbrains.annotations.NotNull;

public final class HotStyleDetailViewHolder extends ViewHolder {
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final Delegate delegate;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final HotStyleDetailViewHolder create(@NotNull ViewGroup viewGroup, @NotNull Delegate delegate) {
            Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
            Intrinsics.checkParameterIsNotNull(delegate, "delegate");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.item_hot_style_detail, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "view");
            return new HotStyleDetailViewHolder(inflate, delegate);
        }
    }

    public interface Delegate {
        void onStyleClicked(@NotNull String str);
    }

    public HotStyleDetailViewHolder(@NotNull View view, @NotNull Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(view, "itemView");
        Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
        super(view);
        this.delegate = delegate2;
    }

    @NotNull
    public final Delegate getDelegate() {
        return this.delegate;
    }

    public final void bindTo(@NotNull StyleRecommendViewData styleRecommendViewData) {
        Intrinsics.checkParameterIsNotNull(styleRecommendViewData, "item");
        View view = this.itemView;
        TextView textView = (TextView) view.findViewById(C0010R$id.textStyle);
        Intrinsics.checkExpressionValueIsNotNull(textView, "textStyle");
        textView.setText(styleRecommendViewData.getStyleKeyword());
        RoundImageView roundImageView = (RoundImageView) view.findViewById(C0010R$id.imageView);
        Intrinsics.checkExpressionValueIsNotNull(roundImageView, "imageView");
        ImageViewExtensionKt.loadImage$default(roundImageView, styleRecommendViewData.getStyleCoverImage(), null, 2, null);
        view.setOnClickListener(new HotStyleDetailViewHolder$bindTo$$inlined$with$lambda$1(this, styleRecommendViewData));
    }
}
