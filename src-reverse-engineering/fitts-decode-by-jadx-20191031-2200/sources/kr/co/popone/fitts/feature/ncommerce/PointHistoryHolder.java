package kr.co.popone.fitts.feature.ncommerce;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Space;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.model.payment.PaymentAPI.PaymentHistory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class PointHistoryHolder extends ViewHolder {
    public static final Companion Companion = new Companion(null);
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private final DecimalFormat decimalFormat = new DecimalFormat("+#,###,###;-#");

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final PointHistoryHolder create(@NotNull ViewGroup viewGroup) {
            Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.item_reward_history, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "view");
            return new PointHistoryHolder(inflate);
        }
    }

    public PointHistoryHolder(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "itemView");
        super(view);
    }

    @Nullable
    public final Unit bindTo(@Nullable PaymentHistory paymentHistory, boolean z, boolean z2) {
        View view = this.itemView;
        if (paymentHistory == null) {
            return null;
        }
        View findViewById = view.findViewById(C0010R$id.topSeparatorView);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "topSeparatorView");
        int i = 8;
        findViewById.setVisibility(z ? 8 : 0);
        TextView textView = (TextView) view.findViewById(C0010R$id.dateTextView);
        Intrinsics.checkExpressionValueIsNotNull(textView, "dateTextView");
        textView.setText(this.dateFormat.format(paymentHistory.getCreatedAt()));
        TextView textView2 = (TextView) view.findViewById(C0010R$id.descriptionTextView);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "descriptionTextView");
        textView2.setText(paymentHistory.getMessage());
        TextView textView3 = (TextView) view.findViewById(C0010R$id.amountTextView);
        Intrinsics.checkExpressionValueIsNotNull(textView3, "amountTextView");
        textView3.setText(this.decimalFormat.format(Integer.valueOf(paymentHistory.getValue())));
        Space space = (Space) view.findViewById(C0010R$id.bottomMargin);
        Intrinsics.checkExpressionValueIsNotNull(space, "bottomMargin");
        if (z2) {
            i = 0;
        }
        space.setVisibility(i);
        return Unit.INSTANCE;
    }
}
