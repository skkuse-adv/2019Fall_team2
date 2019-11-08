package kr.co.popone.fitts.feature.store.browser;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.model.store.OrderableOptionViewData;
import kr.co.popone.fitts.ui.DialogExtensions;
import org.jetbrains.annotations.NotNull;

public final class ProductOptionSelectorViewHolder extends ViewHolder {
    public static final Companion Companion = new Companion(null);

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ProductOptionSelectorViewHolder create(@NotNull ViewGroup viewGroup) {
            Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.view_selector_product_option, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "view");
            return new ProductOptionSelectorViewHolder(inflate);
        }
    }

    public interface Delegate {
        void onDeleteOptionClicked(@NotNull OrderableOptionViewData orderableOptionViewData);

        void onOptionCountChanged(@NotNull OrderableOptionViewData orderableOptionViewData, @NotNull OrderableOptionViewData orderableOptionViewData2);
    }

    public ProductOptionSelectorViewHolder(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "itemView");
        super(view);
    }

    public final void bindTo(@NotNull OrderableOptionViewData orderableOptionViewData, int i, @NotNull Delegate delegate) {
        Intrinsics.checkParameterIsNotNull(orderableOptionViewData, "option");
        Intrinsics.checkParameterIsNotNull(delegate, "delegate");
        View view = this.itemView;
        TextView textView = (TextView) view.findViewById(C0010R$id.textProductOptions);
        Intrinsics.checkExpressionValueIsNotNull(textView, "textProductOptions");
        textView.setText(orderableOptionViewData.getProductName());
        TextView textView2 = (TextView) view.findViewById(C0010R$id.textProductCount);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "textProductCount");
        textView2.setText(String.valueOf(orderableOptionViewData.getProductCount()));
        ((TextView) view.findViewById(C0010R$id.buttonMinusCount)).setOnClickListener(new ProductOptionSelectorViewHolder$bindTo$$inlined$with$lambda$1(view, this, orderableOptionViewData, delegate));
        ((TextView) view.findViewById(C0010R$id.buttonPlusCount)).setOnClickListener(new ProductOptionSelectorViewHolder$bindTo$$inlined$with$lambda$2(view, this, orderableOptionViewData, delegate));
        String str = "iconDelete";
        if (orderableOptionViewData.isSingleOption()) {
            ImageView imageView = (ImageView) view.findViewById(C0010R$id.iconDelete);
            Intrinsics.checkExpressionValueIsNotNull(imageView, str);
            imageView.setVisibility(8);
        } else {
            ImageView imageView2 = (ImageView) view.findViewById(C0010R$id.iconDelete);
            Intrinsics.checkExpressionValueIsNotNull(imageView2, str);
            imageView2.setVisibility(0);
        }
        ((ImageView) view.findViewById(C0010R$id.iconDelete)).setOnClickListener(new ProductOptionSelectorViewHolder$bindTo$$inlined$with$lambda$3(this, orderableOptionViewData, delegate));
    }

    /* access modifiers changed from: private */
    public final void showMessageDialog() {
        View view = this.itemView;
        DialogExtensions dialogExtensions = DialogExtensions.INSTANCE;
        Context context = view.getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        dialogExtensions.showMessageDialog(context, "", "하루에 1개의 상품만 구매 가능합니다.", ProductOptionSelectorViewHolder$showMessageDialog$1$1.INSTANCE, "확인");
    }
}
