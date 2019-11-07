package kr.co.popone.fitts.feature.reward;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.text.SimpleDateFormat;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.model.payment.PaymentAPI.PaymentUsage;
import kr.co.popone.fitts.model.payment.PaymentAPI.PaymentUsage.Status;
import org.jetbrains.annotations.NotNull;

public final class UsedRewardHistoryAdapter extends Adapter<UsedRewardHistoryItemViewHolder> {
    private final Context context;
    @SuppressLint({"SimpleDateFormat"})
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    /* access modifiers changed from: private */
    public final Delegate delegate;
    private final OnClickListener onClickListener = new UsedRewardHistoryAdapter$onClickListener$1(this);

    public interface Delegate {
        @NotNull
        List<PaymentUsage> getItems();

        void onItemClicked(int i);
    }

    public static final class UsedRewardHistoryItemViewHolder extends ViewHolder {
        @NotNull
        private final TextView dateTextView;
        @NotNull
        private final TextView descriptionTextView;

        public UsedRewardHistoryItemViewHolder(@NotNull View view) {
            Intrinsics.checkParameterIsNotNull(view, "view");
            super(view);
            View findViewById = view.findViewById(C0010R$id.dateTextView);
            if (findViewById == null) {
                Intrinsics.throwNpe();
            }
            this.dateTextView = (TextView) findViewById;
            View findViewById2 = view.findViewById(C0010R$id.descriptionTextView);
            if (findViewById2 == null) {
                Intrinsics.throwNpe();
            }
            this.descriptionTextView = (TextView) findViewById2;
        }

        @NotNull
        public final TextView getDateTextView() {
            return this.dateTextView;
        }

        @NotNull
        public final TextView getDescriptionTextView() {
            return this.descriptionTextView;
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

    public UsedRewardHistoryAdapter(@NotNull Context context2, @NotNull Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(context2, "context");
        Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
        this.context = context2;
        this.delegate = delegate2;
    }

    public int getItemCount() {
        return this.delegate.getItems().size();
    }

    public void onBindViewHolder(@NotNull UsedRewardHistoryItemViewHolder usedRewardHistoryItemViewHolder, int i) {
        String str;
        Intrinsics.checkParameterIsNotNull(usedRewardHistoryItemViewHolder, "holder");
        PaymentUsage paymentUsage = (PaymentUsage) this.delegate.getItems().get(i);
        View view = usedRewardHistoryItemViewHolder.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view, "holder.itemView");
        view.setTag(Integer.valueOf(i));
        usedRewardHistoryItemViewHolder.getDateTextView().setText(this.dateFormat.format(paymentUsage.getCreatedAt()));
        TextView descriptionTextView = usedRewardHistoryItemViewHolder.getDescriptionTextView();
        int i2 = WhenMappings.$EnumSwitchMapping$0[paymentUsage.getStatus().ordinal()];
        if (i2 == 1) {
            str = "사용 신청 반려";
        } else if (i2 == 2) {
            str = "사용완료";
        } else if (i2 == 3) {
            str = "사용 신청 접수";
        } else {
            throw new NoWhenBranchMatchedException();
        }
        descriptionTextView.setText(str);
    }

    @NotNull
    public UsedRewardHistoryItemViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.context).inflate(C0013R$layout.item_used_reward_history, viewGroup, false);
        inflate.setOnClickListener(this.onClickListener);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "view");
        return new UsedRewardHistoryItemViewHolder(inflate);
    }
}
