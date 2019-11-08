package kr.co.popone.fitts.feature.coupon;

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
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.model.payment.PaymentAPI.PaymentUsage;
import kr.co.popone.fitts.model.payment.PaymentAPI.PaymentUsage.Status;
import org.jetbrains.annotations.NotNull;

public final class UsedCouponHistoryAdapter extends Adapter<UsedCouponHistoryItemViewHolder> {
    private final Context context;
    @SuppressLint({"SimpleDateFormat"})
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    /* access modifiers changed from: private */
    public final Delegate delegate;
    private final OnClickListener onClickListener = new UsedCouponHistoryAdapter$onClickListener$1(this);

    public interface Delegate {
        @NotNull
        List<PaymentUsage> getItems();

        void onItemClicked(int i);
    }

    public static final class UsedCouponHistoryItemViewHolder extends ViewHolder {
        @NotNull
        private final TextView dateTextView;
        @NotNull
        private final TextView descriptionTextView;

        public UsedCouponHistoryItemViewHolder(@NotNull View view) {
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

    public UsedCouponHistoryAdapter(@NotNull Context context2, @NotNull Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(context2, "context");
        Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
        this.context = context2;
        this.delegate = delegate2;
    }

    public int getItemCount() {
        return this.delegate.getItems().size();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0066, code lost:
        if (r0 != null) goto L_0x006b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull kr.co.popone.fitts.feature.coupon.UsedCouponHistoryAdapter.UsedCouponHistoryItemViewHolder r4, int r5) {
        /*
            r3 = this;
            java.lang.String r0 = "holder"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r4, r0)
            kr.co.popone.fitts.feature.coupon.UsedCouponHistoryAdapter$Delegate r0 = r3.delegate
            java.util.List r0 = r0.getItems()
            java.lang.Object r0 = r0.get(r5)
            kr.co.popone.fitts.model.payment.PaymentAPI$PaymentUsage r0 = (kr.co.popone.fitts.model.payment.PaymentAPI.PaymentUsage) r0
            android.view.View r1 = r4.itemView
            java.lang.String r2 = "holder.itemView"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r1.setTag(r5)
            android.widget.TextView r5 = r4.getDateTextView()
            java.text.SimpleDateFormat r1 = r3.dateFormat
            java.util.Date r2 = r0.getCreatedAt()
            java.lang.String r1 = r1.format(r2)
            r5.setText(r1)
            kr.co.popone.fitts.model.payment.PaymentAPI$PaymentUsage$Status r5 = r0.getStatus()
            int[] r1 = kr.co.popone.fitts.feature.coupon.UsedCouponHistoryAdapter.WhenMappings.$EnumSwitchMapping$0
            int r5 = r5.ordinal()
            r5 = r1[r5]
            r1 = 1
            if (r5 == r1) goto L_0x0051
            r1 = 2
            if (r5 == r1) goto L_0x004e
            r1 = 3
            if (r5 != r1) goto L_0x0048
            java.lang.String r5 = "사용 신청 접수"
            goto L_0x0053
        L_0x0048:
            kotlin.NoWhenBranchMatchedException r4 = new kotlin.NoWhenBranchMatchedException
            r4.<init>()
            throw r4
        L_0x004e:
            java.lang.String r5 = "사용완료"
            goto L_0x0053
        L_0x0051:
            java.lang.String r5 = "사용 신청 반려"
        L_0x0053:
            android.widget.TextView r4 = r4.getDescriptionTextView()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            kr.co.popone.fitts.model.coupon.CouponAPI$CouponInfo r0 = r0.getCoupon()
            if (r0 == 0) goto L_0x0069
            java.lang.String r0 = r0.getDisplayMessage()
            if (r0 == 0) goto L_0x0069
            goto L_0x006b
        L_0x0069:
            java.lang.String r0 = ""
        L_0x006b:
            r1.append(r0)
            r0 = 32
            r1.append(r0)
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            r4.setText(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.feature.coupon.UsedCouponHistoryAdapter.onBindViewHolder(kr.co.popone.fitts.feature.coupon.UsedCouponHistoryAdapter$UsedCouponHistoryItemViewHolder, int):void");
    }

    @NotNull
    public UsedCouponHistoryItemViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.context).inflate(C0013R$layout.item_used_reward_history, viewGroup, false);
        inflate.setOnClickListener(this.onClickListener);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "view");
        return new UsedCouponHistoryItemViewHolder(inflate);
    }
}
