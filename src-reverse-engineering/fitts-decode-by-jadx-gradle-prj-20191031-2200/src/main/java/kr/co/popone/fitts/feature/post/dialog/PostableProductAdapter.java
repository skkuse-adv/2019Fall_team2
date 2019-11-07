package kr.co.popone.fitts.feature.post.dialog;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.feature.post.PostType;
import kr.co.popone.fitts.model.order.OrderListLineItemVariant;
import kr.co.popone.fitts.model.post.PostAPI.Category;
import kr.co.popone.fitts.model.product.VariantInfoOption;
import kr.co.popone.fitts.ui.ImageViewExtensionKt;
import kr.co.popone.fitts.ui.custom.RoundImageView;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class PostableProductAdapter extends Adapter<PostableProductHolder> {
    /* access modifiers changed from: private */
    public final Delegate delegate;
    @NotNull
    private List<OrderListLineItemVariant> items = new ArrayList();

    public interface Delegate {
        void onPostableItemClicked(long j, @NotNull String str, @Nullable PostType postType);
    }

    public final class PostableProductHolder extends ViewHolder {
        final /* synthetic */ PostableProductAdapter this$0;

        public PostableProductHolder(@NotNull PostableProductAdapter postableProductAdapter, View view) {
            Intrinsics.checkParameterIsNotNull(view, "itemView");
            this.this$0 = postableProductAdapter;
            super(view);
        }

        public final void bindTo(@NotNull OrderListLineItemVariant orderListLineItemVariant) {
            Intrinsics.checkParameterIsNotNull(orderListLineItemVariant, "item");
            View view = this.itemView;
            RoundImageView roundImageView = (RoundImageView) view.findViewById(C0010R$id.imageProduct);
            Intrinsics.checkExpressionValueIsNotNull(roundImageView, "imageProduct");
            ImageViewExtensionKt.loadImageAsProduct(roundImageView, orderListLineItemVariant.getVariant().getProduct().getShopImageUrl());
            view.setOnClickListener(new PostableProductAdapter$PostableProductHolder$bindTo$$inlined$with$lambda$1(view, this, orderListLineItemVariant));
            int i = 0;
            String str = "";
            int i2 = 0;
            for (Object next : orderListLineItemVariant.getVariant().getOption()) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                VariantInfoOption variantInfoOption = (VariantInfoOption) next;
                if (i2 == 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    sb.append(variantInfoOption.getOptionValue());
                    str = sb.toString();
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str);
                    sb2.append(" / ");
                    sb2.append(variantInfoOption.getOptionValue());
                    str = sb2.toString();
                }
                i2 = i3;
            }
            TextView textView = (TextView) view.findViewById(C0010R$id.textOptions);
            String str2 = "textOptions";
            Intrinsics.checkExpressionValueIsNotNull(textView, str2);
            textView.setText(str);
            TextView textView2 = (TextView) view.findViewById(C0010R$id.textOptions);
            Intrinsics.checkExpressionValueIsNotNull(textView2, str2);
            if (str.length() == 0) {
                i = 8;
            }
            textView2.setVisibility(i);
        }
    }

    public PostableProductAdapter(@NotNull Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
        this.delegate = delegate2;
    }

    @NotNull
    public final List<OrderListLineItemVariant> getItems() {
        return this.items;
    }

    public final void setItems(@NotNull List<OrderListLineItemVariant> list) {
        Intrinsics.checkParameterIsNotNull(list, "<set-?>");
        this.items = list;
    }

    @NotNull
    public PostableProductHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.item_postable_product, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "view");
        return new PostableProductHolder(this, inflate);
    }

    public int getItemCount() {
        return this.items.size();
    }

    public void onBindViewHolder(@NotNull PostableProductHolder postableProductHolder, int i) {
        Intrinsics.checkParameterIsNotNull(postableProductHolder, "holder");
        postableProductHolder.bindTo((OrderListLineItemVariant) this.items.get(i));
    }

    /* access modifiers changed from: private */
    public final PostType mapToPostType(@NotNull List<Category> list) {
        Category category = (Category) CollectionsKt___CollectionsKt.firstOrNull(list);
        String group = category != null ? category.getGroup() : null;
        if (group != null) {
            int hashCode = group.hashCode();
            if (hashCode != 50743) {
                if (hashCode != 1413161) {
                    if (hashCode == 1594684 && group.equals("신발")) {
                        return PostType.SHOES;
                    }
                } else if (group.equals("가방")) {
                    return PostType.BAG;
                }
            } else if (group.equals("옷")) {
                return PostType.CLOTHES;
            }
        }
        return null;
    }
}
