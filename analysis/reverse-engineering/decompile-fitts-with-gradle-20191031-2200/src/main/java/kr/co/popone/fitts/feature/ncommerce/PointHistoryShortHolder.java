package kr.co.popone.fitts.feature.ncommerce;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Space;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.text.DecimalFormat;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.model.payment.PaymentAPI.PaymentHistory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class PointHistoryShortHolder extends ViewHolder {
    public static final Companion Companion = new Companion(null);
    private final DecimalFormat decimalFormat = new DecimalFormat("+#,###,###;-#");

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final PointHistoryShortHolder create(@NotNull ViewGroup viewGroup) {
            Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.item_reward_short_history, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "view");
            return new PointHistoryShortHolder(inflate);
        }
    }

    public PointHistoryShortHolder(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "itemView");
        super(view);
    }

    @Nullable
    public final Unit bindTo(@Nullable PaymentHistory paymentHistory, boolean z) {
        View view = this.itemView;
        if (paymentHistory == null) {
            return null;
        }
        TextView textView = (TextView) view.findViewById(C0010R$id.descriptionTextView);
        Intrinsics.checkExpressionValueIsNotNull(textView, "descriptionTextView");
        textView.setText(paymentHistory.getMessage());
        TextView textView2 = (TextView) view.findViewById(C0010R$id.amountTextView);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "amountTextView");
        textView2.setText(this.decimalFormat.format(Integer.valueOf(paymentHistory.getValue())));
        Space space = (Space) view.findViewById(C0010R$id.bottomMargin);
        Intrinsics.checkExpressionValueIsNotNull(space, "bottomMargin");
        space.setVisibility(z ? 0 : 8);
        return Unit.INSTANCE;
    }
}
