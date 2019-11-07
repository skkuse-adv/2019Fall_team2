package kr.co.popone.fitts.feature.order.detail;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.event.OrderEvent$CreatePostOrderVariant;
import kr.co.popone.fitts.event.RxBus;
import kr.co.popone.fitts.feature.order.detail.OrderStateHolder.OrderStateType;
import kr.co.popone.fitts.model.order.OrderListDetailViewData;
import kr.co.popone.fitts.model.post.PostAPI.Category;
import kr.co.popone.fitts.model.post.PostVariantViewData;
import kr.co.popone.fitts.ui.DialogExtensions;

final class OrderStateHolder$bindTo$$inlined$with$lambda$2 implements OnClickListener {
    final /* synthetic */ OrderListDetailViewData $item$inlined;
    final /* synthetic */ View $this_with$inlined;
    final /* synthetic */ OrderStateHolder this$0;

    OrderStateHolder$bindTo$$inlined$with$lambda$2(View view, OrderStateHolder orderStateHolder, OrderStateType orderStateType, OrderListDetailViewData orderListDetailViewData) {
        this.$this_with$inlined = view;
        this.this$0 = orderStateHolder;
        this.$item$inlined = orderListDetailViewData;
    }

    public final void onClick(View view) {
        Object obj;
        List categories = this.$item$inlined.getCategories();
        String str = null;
        Category category = categories != null ? (Category) CollectionsKt___CollectionsKt.firstOrNull(categories) : null;
        if (category != null) {
            obj = category.getGroup();
        } else {
            obj = null;
        }
        if (!Intrinsics.areEqual(obj, (Object) "옷")) {
            if (!Intrinsics.areEqual(category != null ? category.getGroup() : null, (Object) "신발")) {
                if (category != null) {
                    str = category.getGroup();
                }
                if (!Intrinsics.areEqual((Object) str, (Object) "가방")) {
                    DialogExtensions dialogExtensions = DialogExtensions.INSTANCE;
                    Context context = this.$this_with$inlined.getContext();
                    Intrinsics.checkExpressionValueIsNotNull(context, "context");
                    DialogExtensions.showMessageDialog$default(dialogExtensions, context, "포스팅이 불가능해요 😢", "🚫'옷/가방/신발'이 아니면 포스팅할 수 없어요. 양해부탁드려요🙏", null, null, 24, null);
                    return;
                }
            }
        }
        RxBus.INSTANCE.post(new OrderEvent$CreatePostOrderVariant(this.$item$inlined.getProductState(), this.this$0.mapToPostType(this.$item$inlined.getCategories()), new PostVariantViewData(this.$item$inlined.getOrderLineItemVariantId(), this.$item$inlined.getProductLinkUrl())));
    }
}
