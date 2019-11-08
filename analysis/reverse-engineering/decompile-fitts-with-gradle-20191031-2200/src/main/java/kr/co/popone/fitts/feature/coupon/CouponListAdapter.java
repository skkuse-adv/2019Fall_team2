package kr.co.popone.fitts.feature.coupon;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.text.SimpleDateFormat;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0006R$color;
import kr.co.popone.fitts.C0008R$drawable;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.feature.base.EmptyTypeHolder;
import kr.co.popone.fitts.model.coupon.CouponAPI.CouponInfo;
import kr.co.popone.fitts.utils.IntExtensionsKt;
import org.jetbrains.annotations.NotNull;

public final class CouponListAdapter extends Adapter<ViewHolder> {
    private final DataSource dataSource;
    @SuppressLint({"SimpleDateFormat"})
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("MM.dd");
    /* access modifiers changed from: private */
    public final Delegate delegate;
    private boolean showsLoading;
    private final OnClickListener termsButtonListener = new CouponListAdapter$termsButtonListener$1(this);
    private final OnClickListener useButtonListener = new CouponListAdapter$useButtonListener$1(this);

    public interface DataSource {
        int getAvailableCouponCount();

        @NotNull
        List<CouponInfo> getItems();
    }

    public interface Delegate {
        void termsButtonClicked(int i);

        void useButtonClicked(int i);
    }

    public static final class HeaderViewHolder extends ViewHolder {
        @NotNull
        private final TextView countTextView;

        public HeaderViewHolder(@NotNull View view) {
            Intrinsics.checkParameterIsNotNull(view, "view");
            super(view);
            View findViewById = view.findViewById(C0010R$id.countTextView);
            Intrinsics.checkExpressionValueIsNotNull(findViewById, "view.findViewById(R.id.countTextView)");
            this.countTextView = (TextView) findViewById;
        }

        @NotNull
        public final TextView getCountTextView() {
            return this.countTextView;
        }
    }

    public static final class ItemViewHolder extends ViewHolder {
        @NotNull
        private final TextView couponDateTextView;
        @NotNull
        private final TextView couponPriceTextView;
        @NotNull
        private final TextView couponTypeTextView;
        @NotNull
        private final ImageView dashline;
        @NotNull
        private final Button termsButton;
        @NotNull
        private final ImageView termsImageView;
        @NotNull
        private final TextView textPriceLimit;
        @NotNull
        private final View useButton;

        public ItemViewHolder(@NotNull View view) {
            Intrinsics.checkParameterIsNotNull(view, "view");
            super(view);
            View findViewById = view.findViewById(C0010R$id.couponPriceTextView);
            Intrinsics.checkExpressionValueIsNotNull(findViewById, "view.findViewById(R.id.couponPriceTextView)");
            this.couponPriceTextView = (TextView) findViewById;
            View findViewById2 = view.findViewById(C0010R$id.couponTypeTextView);
            Intrinsics.checkExpressionValueIsNotNull(findViewById2, "view.findViewById(R.id.couponTypeTextView)");
            this.couponTypeTextView = (TextView) findViewById2;
            View findViewById3 = view.findViewById(C0010R$id.couponDateTextView);
            Intrinsics.checkExpressionValueIsNotNull(findViewById3, "view.findViewById(R.id.couponDateTextView)");
            this.couponDateTextView = (TextView) findViewById3;
            View findViewById4 = view.findViewById(C0010R$id.termsImageView);
            Intrinsics.checkExpressionValueIsNotNull(findViewById4, "view.findViewById(R.id.termsImageView)");
            this.termsImageView = (ImageView) findViewById4;
            View findViewById5 = view.findViewById(C0010R$id.termsButton);
            Intrinsics.checkExpressionValueIsNotNull(findViewById5, "view.findViewById(R.id.termsButton)");
            this.termsButton = (Button) findViewById5;
            View findViewById6 = view.findViewById(C0010R$id.useButtonLayout);
            Intrinsics.checkExpressionValueIsNotNull(findViewById6, "view.findViewById(R.id.useButtonLayout)");
            this.useButton = findViewById6;
            View findViewById7 = view.findViewById(C0010R$id.dashlineImageView);
            Intrinsics.checkExpressionValueIsNotNull(findViewById7, "view.findViewById(R.id.dashlineImageView)");
            this.dashline = (ImageView) findViewById7;
            View findViewById8 = view.findViewById(C0010R$id.textPriceLimit);
            Intrinsics.checkExpressionValueIsNotNull(findViewById8, "view.findViewById(R.id.textPriceLimit)");
            this.textPriceLimit = (TextView) findViewById8;
        }

        @NotNull
        public final TextView getCouponPriceTextView() {
            return this.couponPriceTextView;
        }

        @NotNull
        public final TextView getCouponTypeTextView() {
            return this.couponTypeTextView;
        }

        @NotNull
        public final TextView getCouponDateTextView() {
            return this.couponDateTextView;
        }

        @NotNull
        public final ImageView getTermsImageView() {
            return this.termsImageView;
        }

        @NotNull
        public final Button getTermsButton() {
            return this.termsButton;
        }

        @NotNull
        public final View getUseButton() {
            return this.useButton;
        }

        @NotNull
        public final ImageView getDashline() {
            return this.dashline;
        }

        @NotNull
        public final TextView getTextPriceLimit() {
            return this.textPriceLimit;
        }
    }

    public CouponListAdapter(@NotNull DataSource dataSource2, @NotNull Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(dataSource2, "dataSource");
        Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
        this.dataSource = dataSource2;
        this.delegate = delegate2;
    }

    public final boolean getShowsLoading() {
        return this.showsLoading;
    }

    public final void setShowsLoading(boolean z) {
        if (this.showsLoading != z) {
            this.showsLoading = z;
            notifyDataSetChanged();
        }
    }

    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        if (i == 0) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.item_coupon_list_header, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "LayoutInflater.from(pare…st_header, parent, false)");
            return new HeaderViewHolder(inflate);
        } else if (i != 1) {
            return EmptyTypeHolder.Companion.create(viewGroup);
        } else {
            View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.item_coupon_list_coupon, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate2, "LayoutInflater.from(pare…st_coupon, parent, false)");
            ItemViewHolder itemViewHolder = new ItemViewHolder(inflate2);
            itemViewHolder.getUseButton().setOnClickListener(this.useButtonListener);
            itemViewHolder.getTermsButton().setOnClickListener(this.termsButtonListener);
            return itemViewHolder;
        }
    }

    public int getItemCount() {
        return this.dataSource.getItems().size() + (this.showsLoading ? 2 : 1);
    }

    public void onBindViewHolder(@NotNull ViewHolder viewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
        if (viewHolder instanceof HeaderViewHolder) {
            TextView countTextView = ((HeaderViewHolder) viewHolder).getCountTextView();
            StringBuilder sb = new StringBuilder();
            sb.append('(');
            sb.append(this.dataSource.getAvailableCouponCount());
            sb.append(')');
            countTextView.setText(sb.toString());
        } else if (viewHolder instanceof ItemViewHolder) {
            int i2 = i - 1;
            CouponInfo couponInfo = (CouponInfo) this.dataSource.getItems().get(i2);
            ItemViewHolder itemViewHolder = (ItemViewHolder) viewHolder;
            itemViewHolder.getCouponPriceTextView().setText(IntExtensionsKt.commaString(couponInfo.getValue()));
            itemViewHolder.getCouponTypeTextView().setText(couponInfo.getDisplayMessage());
            TextView couponDateTextView = itemViewHolder.getCouponDateTextView();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.dateFormat.format(couponInfo.getStartDate()));
            sb2.append(" ~ ");
            sb2.append(this.dateFormat.format(couponInfo.getEndDate()));
            couponDateTextView.setText(sb2.toString());
            int i3 = 4;
            if (couponInfo.getAgreement() == null) {
                itemViewHolder.getTermsImageView().setVisibility(4);
                itemViewHolder.getTermsButton().setVisibility(4);
            } else {
                itemViewHolder.getTermsImageView().setVisibility(0);
                itemViewHolder.getTermsButton().setVisibility(0);
            }
            Button termsButton = itemViewHolder.getTermsButton();
            termsButton.setTag(Integer.valueOf(i2));
            termsButton.setOnClickListener(new CouponListAdapter$onBindViewHolder$$inlined$let$lambda$1(couponInfo, i2, this, viewHolder));
            View useButton = itemViewHolder.getUseButton();
            useButton.setTag(Integer.valueOf(i2));
            String str = "";
            String str2 = "used";
            String str3 = "rightArrowImageView";
            String str4 = "useTextView";
            if (couponInfo.getExpired()) {
                useButton.setEnabled(false);
                TextView textView = (TextView) useButton.findViewById(C0010R$id.useTextView);
                Intrinsics.checkExpressionValueIsNotNull(textView, str4);
                textView.setVisibility(0);
                ImageView imageView = (ImageView) useButton.findViewById(C0010R$id.rightArrowImageView);
                Intrinsics.checkExpressionValueIsNotNull(imageView, str3);
                imageView.setVisibility(0);
                TextView textView2 = (TextView) useButton.findViewById(C0010R$id.useTextView);
                Intrinsics.checkExpressionValueIsNotNull(textView2, str4);
                textView2.setText("기간만료");
                ((TextView) useButton.findViewById(C0010R$id.useTextView)).setTextColor(ContextCompat.getColor(useButton.getContext(), C0006R$color.neon_red_alpha));
                ((ImageView) useButton.findViewById(C0010R$id.rightArrowImageView)).setImageResource(C0008R$drawable.ic_time);
            } else if (Intrinsics.areEqual((Object) couponInfo.getState(), (Object) "assigned")) {
                useButton.setEnabled(false);
                TextView textView3 = (TextView) useButton.findViewById(C0010R$id.useTextView);
                Intrinsics.checkExpressionValueIsNotNull(textView3, str4);
                textView3.setText(str);
                TextView textView4 = (TextView) useButton.findViewById(C0010R$id.useTextView);
                Intrinsics.checkExpressionValueIsNotNull(textView4, str4);
                textView4.setVisibility(4);
                ImageView imageView2 = (ImageView) useButton.findViewById(C0010R$id.rightArrowImageView);
                Intrinsics.checkExpressionValueIsNotNull(imageView2, str3);
                imageView2.setVisibility(4);
            } else if (Intrinsics.areEqual((Object) couponInfo.getState(), (Object) str2)) {
                useButton.setEnabled(false);
                TextView textView5 = (TextView) useButton.findViewById(C0010R$id.useTextView);
                Intrinsics.checkExpressionValueIsNotNull(textView5, str4);
                textView5.setVisibility(0);
                ImageView imageView3 = (ImageView) useButton.findViewById(C0010R$id.rightArrowImageView);
                Intrinsics.checkExpressionValueIsNotNull(imageView3, str3);
                imageView3.setVisibility(0);
                TextView textView6 = (TextView) useButton.findViewById(C0010R$id.useTextView);
                Intrinsics.checkExpressionValueIsNotNull(textView6, str4);
                textView6.setText("사용완료");
                ((TextView) useButton.findViewById(C0010R$id.useTextView)).setTextColor(ContextCompat.getColor(useButton.getContext(), C0006R$color.gray4));
                ((ImageView) useButton.findViewById(C0010R$id.rightArrowImageView)).setImageResource(C0008R$drawable.ic_check);
            }
            useButton.setOnClickListener(new CouponListAdapter$onBindViewHolder$$inlined$let$lambda$2(couponInfo, i2, this, viewHolder));
            ImageView dashline = itemViewHolder.getDashline();
            if (couponInfo.getExpired() || Intrinsics.areEqual((Object) couponInfo.getState(), (Object) str2)) {
                dashline.setVisibility(0);
            } else {
                dashline.setVisibility(4);
            }
            TextView textPriceLimit = itemViewHolder.getTextPriceLimit();
            if (couponInfo.getMinOrderPrice() != null) {
                i3 = 0;
            }
            textPriceLimit.setVisibility(i3);
            TextView textPriceLimit2 = itemViewHolder.getTextPriceLimit();
            if (couponInfo.getMinOrderPrice() != null) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(IntExtensionsKt.commaString(couponInfo.getMinOrderPrice().intValue()));
                sb3.append("원 이상 구매 시");
                str = sb3.toString();
            }
            textPriceLimit2.setText(str);
        }
    }

    public int getItemViewType(int i) {
        if (i == 0) {
            return 0;
        }
        return i <= this.dataSource.getItems().size() ? 1 : 2;
    }
}
