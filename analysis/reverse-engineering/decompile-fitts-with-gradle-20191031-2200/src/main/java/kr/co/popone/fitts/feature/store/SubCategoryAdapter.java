package kr.co.popone.fitts.feature.store;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.model.category.SubCategoryViewData;
import org.jetbrains.annotations.NotNull;

public final class SubCategoryAdapter extends Adapter<SubCategoryHolder> {
    /* access modifiers changed from: private */
    public final Delegate delegate;

    public interface Delegate {
        @NotNull
        List<SubCategoryViewData> getItems();

        void onCategoryClicked(int i);
    }

    public final class SubCategoryHolder extends ViewHolder {
        final /* synthetic */ SubCategoryAdapter this$0;

        public SubCategoryHolder(@NotNull SubCategoryAdapter subCategoryAdapter, View view) {
            Intrinsics.checkParameterIsNotNull(view, "itemView");
            this.this$0 = subCategoryAdapter;
            super(view);
        }

        public final void bindTo(@NotNull SubCategoryViewData subCategoryViewData, int i) {
            Intrinsics.checkParameterIsNotNull(subCategoryViewData, "subCategoryViewData");
            View view = this.itemView;
            TextView textView = (TextView) view.findViewById(C0010R$id.textSubCategory);
            Intrinsics.checkExpressionValueIsNotNull(textView, "textSubCategory");
            textView.setText(subCategoryViewData.getSubCategory());
            view.setOnClickListener(new SubCategoryAdapter$SubCategoryHolder$bindTo$$inlined$with$lambda$1(this, subCategoryViewData, i));
        }
    }

    public SubCategoryAdapter(@NotNull Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
        this.delegate = delegate2;
    }

    @NotNull
    public SubCategoryHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.view_sub_category, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "view");
        return new SubCategoryHolder(this, inflate);
    }

    public int getItemCount() {
        return this.delegate.getItems().size() + 1;
    }

    public void onBindViewHolder(@NotNull SubCategoryHolder subCategoryHolder, int i) {
        Intrinsics.checkParameterIsNotNull(subCategoryHolder, "holder");
        if (i != 0) {
            subCategoryHolder.bindTo((SubCategoryViewData) this.delegate.getItems().get(i - 1), i);
        } else {
            subCategoryHolder.bindTo(new SubCategoryViewData(null, "전체"), i);
        }
    }
}
