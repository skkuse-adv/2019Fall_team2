package kr.co.popone.fitts.feature.ncommerce;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.text.SimpleDateFormat;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.model.payment.PaymentAPI.PaymentUsage;
import kr.co.popone.fitts.model.payment.PaymentAPI.PaymentUsage.Status;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class PointUsageHistoryHolder extends ViewHolder {
    public static final Companion Companion = new Companion(null);
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final PointUsageHistoryHolder create(@NotNull ViewGroup viewGroup) {
            Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.item_used_reward_history, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "view");
            return new PointUsageHistoryHolder(inflate);
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = new int[Status.values().length];

        static {
            $EnumSwitchMapping$0[Status.REJECTED.ordinal()] = 1;
            $EnumSwitchMapping$0[Status.COMPLETED.ordinal()] = 2;
            $EnumSwitchMapping$0[Status.PENDING.ordinal()] = 3;
        }
    }

    public PointUsageHistoryHolder(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "itemView");
        super(view);
    }

    @Nullable
    public final Unit bindTo(@Nullable PaymentUsage paymentUsage) {
        String str;
        View view = this.itemView;
        if (paymentUsage == null) {
            return null;
        }
        TextView textView = (TextView) view.findViewById(C0010R$id.dateTextView);
        Intrinsics.checkExpressionValueIsNotNull(textView, "dateTextView");
        textView.setText(this.dateFormat.format(paymentUsage.getCreatedAt()));
        TextView textView2 = (TextView) view.findViewById(C0010R$id.descriptionTextView);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "descriptionTextView");
        int i = WhenMappings.$EnumSwitchMapping$0[paymentUsage.getStatus().ordinal()];
        if (i == 1) {
            str = "사용 신청 반려";
        } else if (i == 2) {
            str = "사용완료";
        } else if (i == 3) {
            str = "사용 신청 접수";
        } else {
            throw new NoWhenBranchMatchedException();
        }
        textView2.setText(str);
        return Unit.INSTANCE;
    }
}
