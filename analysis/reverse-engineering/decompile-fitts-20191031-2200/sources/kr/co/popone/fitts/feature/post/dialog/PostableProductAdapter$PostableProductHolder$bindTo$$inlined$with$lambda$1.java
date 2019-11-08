package kr.co.popone.fitts.feature.post.dialog;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.post.dialog.PostableProductAdapter.Delegate;
import kr.co.popone.fitts.feature.post.dialog.PostableProductAdapter.PostableProductHolder;
import kr.co.popone.fitts.model.order.OrderListLineItemVariant;
import kr.co.popone.fitts.model.post.PostAPI.Category;
import kr.co.popone.fitts.ui.DialogExtensions;

final class PostableProductAdapter$PostableProductHolder$bindTo$$inlined$with$lambda$1 implements OnClickListener {
    final /* synthetic */ OrderListLineItemVariant $item$inlined;
    final /* synthetic */ View $this_with;
    final /* synthetic */ PostableProductHolder this$0;

    PostableProductAdapter$PostableProductHolder$bindTo$$inlined$with$lambda$1(View view, PostableProductHolder postableProductHolder, OrderListLineItemVariant orderListLineItemVariant) {
        this.$this_with = view;
        this.this$0 = postableProductHolder;
        this.$item$inlined = orderListLineItemVariant;
    }

    public final void onClick(View view) {
        OrderListLineItemVariant orderListLineItemVariant = this.$item$inlined;
        List categories = orderListLineItemVariant.getCategories();
        String str = null;
        Category category = categories != null ? (Category) CollectionsKt___CollectionsKt.firstOrNull(categories) : null;
        if (!Intrinsics.areEqual(category != null ? category.getGroup() : null, (Object) "옷")) {
            if (!Intrinsics.areEqual(category != null ? category.getGroup() : null, (Object) "신발")) {
                if (category != null) {
                    str = category.getGroup();
                }
                if (!Intrinsics.areEqual((Object) str, (Object) "가방")) {
                    DialogExtensions dialogExtensions = DialogExtensions.INSTANCE;
                    Context context = this.$this_with.getContext();
                    Intrinsics.checkExpressionValueIsNotNull(context, "context");
                    DialogExtensions.showMessageDialog$default(dialogExtensions, context, "포스팅이 불가능해요 😢", "🚫'옷/가방/신발'이 아니면 포스팅할 수 없어요. 양해부탁드려요🙏", null, null, 24, null);
                    return;
                }
            }
        }
        Delegate access$getDelegate$p = this.this$0.this$0.delegate;
        long id = orderListLineItemVariant.getId();
        String mobileLinkUrl = orderListLineItemVariant.getVariant().getProduct().getMobileLinkUrl();
        if (mobileLinkUrl == null) {
            mobileLinkUrl = orderListLineItemVariant.getVariant().getProduct().getShopLinkUrl();
        }
        PostableProductAdapter postableProductAdapter = this.this$0.this$0;
        List categories2 = orderListLineItemVariant.getCategories();
        if (categories2 == null) {
            Intrinsics.throwNpe();
        }
        access$getDelegate$p.onPostableItemClicked(id, mobileLinkUrl, postableProductAdapter.mapToPostType(categories2));
    }
}
