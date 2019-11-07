package kr.co.popone.fitts.feature.order.detail;

import android.content.Intent;
import android.net.Uri;
import androidx.core.app.ActivityOptionsCompat;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0001R$anim;
import kr.co.popone.fitts.event.OrderEvent$ContactCsNumber;
import kr.co.popone.fitts.event.OrderEvent$ContactKakaoUrl;
import kr.co.popone.fitts.event.OrderEvent$CreatePostOrderVariant;
import kr.co.popone.fitts.event.OrderEvent$OrderExchangeDetailEvent;
import kr.co.popone.fitts.event.OrderEvent$OrderExchangeEvent;
import kr.co.popone.fitts.event.OrderEvent$OrderRefundDetailEvent;
import kr.co.popone.fitts.event.OrderEvent$OrderRefundEvent;
import kr.co.popone.fitts.event.OrderEvent$OrderTrakingEvent;
import kr.co.popone.fitts.feature.exchange.ExchangeApplyActivity;
import kr.co.popone.fitts.feature.exchange.ExchangeCompleteActivity;
import kr.co.popone.fitts.feature.order.tracking.OrderTrackingActivity;
import kr.co.popone.fitts.feature.order.tracking.OrderTrackingActivity.Companion;
import kr.co.popone.fitts.feature.refund.RefundApplyActivity;
import kr.co.popone.fitts.feature.refund.RefundCompleteActivity;
import org.jetbrains.annotations.Nullable;

final class OrderDetailActivity$onCreate$7<T> implements Consumer<Object> {
    final /* synthetic */ OrderDetailActivity this$0;

    OrderDetailActivity$onCreate$7(OrderDetailActivity orderDetailActivity) {
        this.this$0 = orderDetailActivity;
    }

    public final void accept(final Object obj) {
        if (obj instanceof OrderEvent$CreatePostOrderVariant) {
            this.this$0.startCreatePostActivity((OrderEvent$CreatePostOrderVariant) obj);
        } else if (obj instanceof OrderEvent$ContactCsNumber) {
            StringBuilder sb = new StringBuilder();
            sb.append("tel:");
            sb.append(((OrderEvent$ContactCsNumber) obj).getContact());
            this.this$0.startActivity(new Intent("android.intent.action.DIAL", Uri.parse(sb.toString())));
        } else if (obj instanceof OrderEvent$ContactKakaoUrl) {
            ActivityOptionsCompat makeCustomAnimation = ActivityOptionsCompat.makeCustomAnimation(this.this$0, C0001R$anim.slide_right, C0001R$anim.fade_out);
            Intrinsics.checkExpressionValueIsNotNull(makeCustomAnimation, "ActivityOptionsCompat.ma…e_right, R.anim.fade_out)");
            this.this$0.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(((OrderEvent$ContactKakaoUrl) obj).getUrl())), makeCustomAnimation.toBundle());
        } else if (obj instanceof OrderEvent$OrderTrakingEvent) {
            Companion companion = OrderTrackingActivity.Companion;
            OrderDetailActivity orderDetailActivity = this.this$0;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("https://fitts.co.kr//tracking?variant_id=");
            sb2.append(((OrderEvent$OrderTrakingEvent) obj).getVariantId());
            companion.start(orderDetailActivity, sb2.toString());
        } else if (obj instanceof OrderEvent$OrderRefundEvent) {
            this.this$0.getViewModel().getPaymentMethod(new Function1<String, Unit>(this) {
                final /* synthetic */ OrderDetailActivity$onCreate$7 this$0;

                {
                    this.this$0 = r1;
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((String) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable String str) {
                    RefundApplyActivity.Companion.start(this.this$0.this$0, ((OrderEvent$OrderRefundEvent) obj).getVariantId(), str);
                }
            });
        } else if (obj instanceof OrderEvent$OrderExchangeEvent) {
            this.this$0.getViewModel().getPaymentMethod(new Function1<String, Unit>(this) {
                final /* synthetic */ OrderDetailActivity$onCreate$7 this$0;

                {
                    this.this$0 = r1;
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((String) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable String str) {
                    ExchangeApplyActivity.Companion.start(this.this$0.this$0, ((OrderEvent$OrderExchangeEvent) obj).getVariantId(), str);
                }
            });
        } else if (obj instanceof OrderEvent$OrderExchangeDetailEvent) {
            this.this$0.getViewModel().getPaymentMethod(new Function1<String, Unit>(this) {
                final /* synthetic */ OrderDetailActivity$onCreate$7 this$0;

                {
                    this.this$0 = r1;
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((String) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable String str) {
                    ExchangeCompleteActivity.Companion companion = ExchangeCompleteActivity.Companion;
                    OrderDetailActivity orderDetailActivity = this.this$0.this$0;
                    long variantId = ((OrderEvent$OrderExchangeDetailEvent) obj).getVariantId();
                    long exchangeId = ((OrderEvent$OrderExchangeDetailEvent) obj).getExchangeId();
                    if (str == null) {
                        str = "";
                    }
                    companion.startExchangeApplyComplete(orderDetailActivity, variantId, exchangeId, str);
                }
            });
        } else if (obj instanceof OrderEvent$OrderRefundDetailEvent) {
            this.this$0.getViewModel().getPaymentMethod(new Function1<String, Unit>(this) {
                final /* synthetic */ OrderDetailActivity$onCreate$7 this$0;

                {
                    this.this$0 = r1;
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((String) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable String str) {
                    RefundCompleteActivity.Companion companion = RefundCompleteActivity.Companion;
                    OrderDetailActivity orderDetailActivity = this.this$0.this$0;
                    long variantId = ((OrderEvent$OrderRefundDetailEvent) obj).getVariantId();
                    long refundId = ((OrderEvent$OrderRefundDetailEvent) obj).getRefundId();
                    if (str == null) {
                        str = "";
                    }
                    companion.startRefundApplyComplete(orderDetailActivity, variantId, refundId, str);
                }
            });
        }
    }
}
