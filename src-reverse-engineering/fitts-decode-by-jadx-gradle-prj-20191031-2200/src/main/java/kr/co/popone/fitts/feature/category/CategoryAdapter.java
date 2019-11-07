package kr.co.popone.fitts.feature.category;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleObserver;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.ViewTarget;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0008R$drawable;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.feature.store.SubCategoryAdapter;
import kr.co.popone.fitts.model.category.CategoryViewData;
import kr.co.popone.fitts.ui.decorator.DrawerMenuItemDecoration;
import org.jetbrains.annotations.NotNull;

public final class CategoryAdapter extends Adapter<ViewHolder> implements LifecycleObserver {
    @NotNull
    private List<CategoryViewData> categories = new ArrayList();
    @NotNull
    private final Delegate delegate;

    public final class CategoryHolder extends ViewHolder {
        final /* synthetic */ CategoryAdapter this$0;

        public CategoryHolder(@NotNull CategoryAdapter categoryAdapter, View view) {
            Intrinsics.checkParameterIsNotNull(view, "itemView");
            this.this$0 = categoryAdapter;
            super(view);
        }

        @NotNull
        public final ViewTarget<ImageView, Drawable> bindTo(@NotNull CategoryViewData categoryViewData, int i) {
            Intrinsics.checkParameterIsNotNull(categoryViewData, "categoryViewData");
            View view = this.itemView;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(C0010R$id.subCategoryRecyclerView);
            View view2 = this.itemView;
            Intrinsics.checkExpressionValueIsNotNull(view2, "itemView");
            recyclerView.setLayoutManager(new LinearLayoutManager(view2.getContext()));
            recyclerView.setAdapter(new SubCategoryAdapter(new CategoryAdapter$CategoryHolder$bindTo$$inlined$with$lambda$1(this, i, categoryViewData)));
            if (recyclerView.getItemDecorationCount() < 1) {
                Context context = recyclerView.getContext();
                Intrinsics.checkExpressionValueIsNotNull(context, "context");
                recyclerView.addItemDecoration(new DrawerMenuItemDecoration(context, C0008R$drawable.divider_line_gray));
            }
            TextView textView = (TextView) view.findViewById(C0010R$id.textCategory);
            Intrinsics.checkExpressionValueIsNotNull(textView, "textCategory");
            textView.setText(categoryViewData.getCategory());
            ((ConstraintLayout) view.findViewById(C0010R$id.textCategoryTitle)).setOnClickListener(new CategoryAdapter$CategoryHolder$bindTo$1$2(view));
            ViewTarget<ImageView, Drawable> into = Glide.with(view.getContext()).load(categoryViewData.getCategoryIcon()).into((ImageView) view.findViewById(C0010R$id.imageCategoryIcon));
            Intrinsics.checkExpressionValueIsNotNull(into, "with(itemView) {\n       …eCategoryIcon)\n\n        }");
            return into;
        }
    }

    public interface Delegate {
        void onCategoryClicked(@NotNull List<CategoryViewData> list, int i, int i2);
    }

    public int getItemViewType(int i) {
        return i == 0 ? C0013R$layout.item_category_title : C0013R$layout.view_category;
    }

    public CategoryAdapter(@NotNull Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
        this.delegate = delegate2;
    }

    @NotNull
    public final Delegate getDelegate() {
        return this.delegate;
    }

    @NotNull
    public final List<CategoryViewData> getCategories() {
        return this.categories;
    }

    public final void setCategories(@NotNull List<CategoryViewData> list) {
        Intrinsics.checkParameterIsNotNull(list, "value");
        this.categories = list;
        notifyDataSetChanged();
    }

    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        if (i == 2131558624) {
            return CategoryTitleViewHolder.Companion.create(viewGroup);
        }
        if (i == 2131558782) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.view_category, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "view");
            return new CategoryHolder(this, inflate);
        }
        throw new IllegalAccessException();
    }

    public int getItemCount() {
        return this.categories.size() + 1;
    }

    public void onBindViewHolder(@NotNull ViewHolder viewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
        if (viewHolder instanceof CategoryHolder) {
            int i2 = i - 1;
            ((CategoryHolder) viewHolder).bindTo((CategoryViewData) this.categories.get(i2), i2);
        }
    }
}
