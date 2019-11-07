package kr.co.popone.fitts.ui.custom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SpinnerAdapter;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.ArrayList;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.feature.store.browser.StoreOptionSpinnerAdapter;
import kr.co.popone.fitts.model.store.ProductOptionViewData;
import kr.co.popone.fitts.model.store.ProductVariantViewData;
import kr.co.popone.fitts.ui.custom.StoreOptionAdapter.Delegate;
import org.jetbrains.anko.sdk27.coroutines.Sdk27CoroutinesListenersWithCoroutinesKt;
import org.jetbrains.annotations.NotNull;

public final class StoreOptionViewHolder extends ViewHolder {
    public static final Companion Companion = new Companion(null);

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final StoreOptionViewHolder create(@NotNull ViewGroup viewGroup) {
            Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.item_store_option, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "view");
            return new StoreOptionViewHolder(inflate);
        }
    }

    public StoreOptionViewHolder(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "itemView");
        super(view);
    }

    public final void bindTo(@NotNull Delegate delegate, int i, @NotNull ProductVariantViewData productVariantViewData) {
        Intrinsics.checkParameterIsNotNull(delegate, "delegate");
        Intrinsics.checkParameterIsNotNull(productVariantViewData, "item");
        View view = this.itemView;
        AppCompatSpinner appCompatSpinner = (AppCompatSpinner) view.findViewById(C0010R$id.spinner);
        Context context = appCompatSpinner.getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        appCompatSpinner.setAdapter((SpinnerAdapter) new StoreOptionSpinnerAdapter(context, parseOptions(productVariantViewData)));
        Sdk27CoroutinesListenersWithCoroutinesKt.onItemSelectedListener$default(appCompatSpinner, null, new StoreOptionViewHolder$bindTo$$inlined$with$lambda$1(this, productVariantViewData, delegate, i), 1, null);
        String str = "spinner";
        if (productVariantViewData.getOptions() == null) {
            AppCompatSpinner appCompatSpinner2 = (AppCompatSpinner) view.findViewById(C0010R$id.spinner);
            Intrinsics.checkExpressionValueIsNotNull(appCompatSpinner2, str);
            appCompatSpinner2.setEnabled(false);
        } else {
            AppCompatSpinner appCompatSpinner3 = (AppCompatSpinner) view.findViewById(C0010R$id.spinner);
            Intrinsics.checkExpressionValueIsNotNull(appCompatSpinner3, str);
            appCompatSpinner3.setEnabled(true);
        }
        ((AppCompatSpinner) view.findViewById(C0010R$id.spinner)).setSelection(0);
    }

    @NotNull
    public final String[] parseOptions(@NotNull ProductVariantViewData productVariantViewData) {
        Intrinsics.checkParameterIsNotNull(productVariantViewData, "item");
        ArrayList arrayList = new ArrayList();
        arrayList.add(productVariantViewData.getOptionsGroupName());
        List<ProductOptionViewData> options = productVariantViewData.getOptions();
        if (options != null) {
            for (ProductOptionViewData optionValue : options) {
                String optionValue2 = optionValue.getOptionValue();
                if (optionValue2 != null) {
                    arrayList.add(optionValue2);
                }
            }
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array != null) {
            return (String[]) array;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }
}
