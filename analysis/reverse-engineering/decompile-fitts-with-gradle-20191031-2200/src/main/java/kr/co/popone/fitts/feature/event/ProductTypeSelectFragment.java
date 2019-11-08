package kr.co.popone.fitts.feature.event;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import org.jetbrains.annotations.NotNull;

public final class ProductTypeSelectFragment extends BottomSheetDialogFragment {
    private HashMap _$_findViewCache;
    @NotNull
    public Delegate delegate;
    @NotNull
    public List<String> items;

    public interface Delegate {
        void onProductSelected(@NotNull String str);
    }

    public static final class ProductAdapter extends Adapter<ProductViewHolder> {
        private final Context context;
        /* access modifiers changed from: private */
        public final Delegate delegate;
        private final OnClickListener itemOnClickListener = new ProductTypeSelectFragment$ProductAdapter$itemOnClickListener$1(this);
        /* access modifiers changed from: private */
        public final List<String> items;

        public interface Delegate {
            void onProductSelected(@NotNull String str);
        }

        public ProductAdapter(@NotNull Context context2, @NotNull List<String> list, @NotNull Delegate delegate2) {
            Intrinsics.checkParameterIsNotNull(context2, "context");
            Intrinsics.checkParameterIsNotNull(list, "items");
            Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
            this.context = context2;
            this.items = list;
            this.delegate = delegate2;
        }

        @NotNull
        public ProductViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
            Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
            View inflate = LayoutInflater.from(this.context).inflate(C0013R$layout.item_product_type_select, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "view");
            ProductViewHolder productViewHolder = new ProductViewHolder(inflate);
            productViewHolder.itemView.setOnClickListener(this.itemOnClickListener);
            return productViewHolder;
        }

        public int getItemCount() {
            return this.items.size();
        }

        public void onBindViewHolder(@NotNull ProductViewHolder productViewHolder, int i) {
            Intrinsics.checkParameterIsNotNull(productViewHolder, "holder");
            productViewHolder.getNameTextView().setText((CharSequence) this.items.get(i));
            View view = productViewHolder.itemView;
            Intrinsics.checkExpressionValueIsNotNull(view, "holder.itemView");
            view.setTag(Integer.valueOf(i));
            productViewHolder.getBottomSeparatorView().setVisibility(i < this.items.size() + -1 ? 0 : 8);
        }
    }

    public static final class ProductViewHolder extends ViewHolder {
        @NotNull
        private final View bottomSeparatorView;
        @NotNull
        private final TextView nameTextView;

        public ProductViewHolder(@NotNull View view) {
            Intrinsics.checkParameterIsNotNull(view, "view");
            super(view);
            View findViewById = view.findViewById(C0010R$id.nameTextView);
            Intrinsics.checkExpressionValueIsNotNull(findViewById, "view.findViewById(R.id.nameTextView)");
            this.nameTextView = (TextView) findViewById;
            View findViewById2 = view.findViewById(C0010R$id.bottomSeparatorView);
            Intrinsics.checkExpressionValueIsNotNull(findViewById2, "view.findViewById(R.id.bottomSeparatorView)");
            this.bottomSeparatorView = findViewById2;
        }

        @NotNull
        public final TextView getNameTextView() {
            return this.nameTextView;
        }

        @NotNull
        public final View getBottomSeparatorView() {
            return this.bottomSeparatorView;
        }
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view == null) {
            View view2 = getView();
            if (view2 == null) {
                return null;
            }
            view = view2.findViewById(i);
            this._$_findViewCache.put(Integer.valueOf(i), view);
        }
        return view;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @NotNull
    public final List<String> getItems() {
        List<String> list = this.items;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("items");
        }
        return list;
    }

    public final void setItems(@NotNull List<String> list) {
        Intrinsics.checkParameterIsNotNull(list, "<set-?>");
        this.items = list;
    }

    @NotNull
    public final Delegate getDelegate() {
        Delegate delegate2 = this.delegate;
        if (delegate2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("delegate");
        }
        return delegate2;
    }

    public final void setDelegate(@NotNull Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(delegate2, "<set-?>");
        this.delegate = delegate2;
    }

    public void setupDialog(@NotNull Dialog dialog, int i) {
        Intrinsics.checkParameterIsNotNull(dialog, "dialog");
        View inflate = View.inflate(getContext(), C0013R$layout.fragment_product_type_select, null);
        dialog.setContentView(inflate);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(C0010R$id.recyclerView);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, "recyclerView");
        Context context = getContext();
        if (context == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(context, "context!!");
        List<String> list = this.items;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("items");
        }
        recyclerView.setAdapter(new ProductAdapter(context, list, new ProductTypeSelectFragment$setupDialog$1(this)));
    }
}
