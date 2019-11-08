package kr.co.popone.fitts.feature.order.detail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0006R$color;
import kr.co.popone.fitts.C0008R$drawable;
import kr.co.popone.fitts.C0009R$font;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.feature.post.PostType;
import kr.co.popone.fitts.feature.post.upload.posting.PostingActivityUiExtensionKt;
import kr.co.popone.fitts.model.order.OrderListDetailViewData;
import kr.co.popone.fitts.model.post.PostAPI.Category;
import org.jetbrains.annotations.NotNull;

public final class OrderStateHolder extends ViewHolder {
    public static final Companion Companion = new Companion(null);

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final OrderStateHolder create(@NotNull ViewGroup viewGroup) {
            Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.item_order_state, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "view");
            return new OrderStateHolder(inflate);
        }
    }

    public enum OrderStateType {
        DELIVERY_INQUIRY("배송조회", C0008R$drawable.background_round_edge_gray3, C0006R$color.gray6, C0009R$font.kopubdotum_pro_medium),
        CREATE_POST("포스트 작성", C0008R$drawable.background_round_edge_point, C0006R$color.point, C0009R$font.kopubdotum_pro_bold),
        EXCHANGE("교환 신청", C0008R$drawable.background_round_edge_gray3, C0006R$color.gray6, C0009R$font.kopubdotum_pro_medium),
        RETURN("반품 신청", C0008R$drawable.background_round_edge_gray3, C0006R$color.gray6, C0009R$font.kopubdotum_pro_medium),
        EXCHANGE_DETAIL("교환 상세정보", C0008R$drawable.background_round_edge_gray3, C0006R$color.gray6, C0009R$font.kopubdotum_pro_medium),
        RETURN_DETAIL("반품 상세정보", C0008R$drawable.background_round_edge_gray3, C0006R$color.gray6, C0009R$font.kopubdotum_pro_medium),
        REFUND_DETAIL("환불 상세정보", C0008R$drawable.background_round_edge_gray3, C0006R$color.gray6, C0009R$font.kopubdotum_pro_medium);
        
        private final int background;
        private final int font;
        @NotNull
        private final String text;
        private final int textColor;

        private OrderStateType(String str, int i, int i2, int i3) {
            this.text = str;
            this.background = i;
            this.textColor = i2;
            this.font = i3;
        }

        public final int getBackground() {
            return this.background;
        }

        public final int getFont() {
            return this.font;
        }

        @NotNull
        public final String getText() {
            return this.text;
        }

        public final int getTextColor() {
            return this.textColor;
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = new int[OrderStateType.values().length];

        static {
            $EnumSwitchMapping$0[OrderStateType.DELIVERY_INQUIRY.ordinal()] = 1;
            $EnumSwitchMapping$0[OrderStateType.CREATE_POST.ordinal()] = 2;
            $EnumSwitchMapping$0[OrderStateType.EXCHANGE.ordinal()] = 3;
            $EnumSwitchMapping$0[OrderStateType.RETURN.ordinal()] = 4;
            $EnumSwitchMapping$0[OrderStateType.EXCHANGE_DETAIL.ordinal()] = 5;
            $EnumSwitchMapping$0[OrderStateType.REFUND_DETAIL.ordinal()] = 6;
            $EnumSwitchMapping$0[OrderStateType.RETURN_DETAIL.ordinal()] = 7;
        }
    }

    public OrderStateHolder(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "itemView");
        super(view);
    }

    public final void bindTo(@NotNull OrderListDetailViewData orderListDetailViewData, @NotNull OrderStateType orderStateType) {
        Intrinsics.checkParameterIsNotNull(orderListDetailViewData, "item");
        Intrinsics.checkParameterIsNotNull(orderStateType, "orderStateType");
        View view = this.itemView;
        TextView textView = (TextView) view.findViewById(C0010R$id.textOrderState);
        String str = "textOrderState";
        Intrinsics.checkExpressionValueIsNotNull(textView, str);
        textView.setText(orderStateType.getText());
        ((TextView) view.findViewById(C0010R$id.textOrderState)).setBackgroundResource(orderStateType.getBackground());
        TextView textView2 = (TextView) view.findViewById(C0010R$id.textOrderState);
        Intrinsics.checkExpressionValueIsNotNull(textView2, str);
        Context context = view.getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        PostingActivityUiExtensionKt.setTextColor(textView2, context, orderStateType.getTextColor());
        TextView textView3 = (TextView) view.findViewById(C0010R$id.textOrderState);
        Intrinsics.checkExpressionValueIsNotNull(textView3, str);
        textView3.setTypeface(ResourcesCompat.getFont(view.getContext(), orderStateType.getFont()));
        switch (WhenMappings.$EnumSwitchMapping$0[orderStateType.ordinal()]) {
            case 1:
                ((TextView) view.findViewById(C0010R$id.textOrderState)).setOnClickListener(new OrderStateHolder$bindTo$$inlined$with$lambda$1(view, this, orderStateType, orderListDetailViewData));
                return;
            case 2:
                ((TextView) view.findViewById(C0010R$id.textOrderState)).setOnClickListener(new OrderStateHolder$bindTo$$inlined$with$lambda$2(view, this, orderStateType, orderListDetailViewData));
                return;
            case 3:
                ((TextView) view.findViewById(C0010R$id.textOrderState)).setOnClickListener(new OrderStateHolder$bindTo$$inlined$with$lambda$3(view, this, orderStateType, orderListDetailViewData));
                return;
            case 4:
                ((TextView) view.findViewById(C0010R$id.textOrderState)).setOnClickListener(new OrderStateHolder$bindTo$$inlined$with$lambda$4(view, this, orderStateType, orderListDetailViewData));
                return;
            case 5:
                ((TextView) view.findViewById(C0010R$id.textOrderState)).setOnClickListener(new OrderStateHolder$bindTo$$inlined$with$lambda$5(view, this, orderStateType, orderListDetailViewData));
                return;
            case 6:
            case 7:
                ((TextView) view.findViewById(C0010R$id.textOrderState)).setOnClickListener(new OrderStateHolder$bindTo$$inlined$with$lambda$6(view, this, orderStateType, orderListDetailViewData));
                return;
            default:
                return;
        }
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
