package kr.co.popone.fitts.repository;

import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.domain.exchange.ExchangeRefundVariant;
import kr.co.popone.fitts.model.product.VariantInfoOption;
import kr.co.popone.fitts.model.remote.refund.PreRefundResponse;
import kr.co.popone.fitts.model.remote.refund.RefundApi;
import kr.co.popone.fitts.model.remote.refund.RefundApplyResponse;
import kr.co.popone.fitts.utils.IntExtensionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class RefundRepository {
    private final RefundApi refundApi;

    public RefundRepository(@NotNull RefundApi refundApi2) {
        Intrinsics.checkParameterIsNotNull(refundApi2, "refundApi");
        this.refundApi = refundApi2;
    }

    @NotNull
    public final Single<ExchangeRefundVariant> requestPreRefundInfo(long j) {
        Single<ExchangeRefundVariant> observeOn = this.refundApi.postPreRefundData(j).subscribeOn(Schedulers.io()).map(new RefundRepository$requestPreRefundInfo$1(this)).observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkExpressionValueIsNotNull(observeOn, "refundApi.postPreRefundD…dSchedulers.mainThread())");
        return observeOn;
    }

    @NotNull
    public final Single<Pair<Long, Long>> requestRefundApply(long j, int i, @Nullable String str, @Nullable String str2, @Nullable String str3, @NotNull String str4, @NotNull String str5) {
        String str6 = str4;
        Intrinsics.checkParameterIsNotNull(str6, "reason");
        String str7 = str5;
        Intrinsics.checkParameterIsNotNull(str7, "detailReason");
        long j2 = j;
        Single<Pair<Long, Long>> observeOn = this.refundApi.postRefund(j, i, str, str2, str3, str6, str7).subscribeOn(Schedulers.io()).map(new RefundRepository$requestRefundApply$1(j)).observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkExpressionValueIsNotNull(observeOn, "refundApi.postRefund(var…dSchedulers.mainThread())");
        return observeOn;
    }

    @NotNull
    public final Single<RefundApplyResponse> requestRefundDetailInfo(long j, long j2) {
        Single<RefundApplyResponse> observeOn = this.refundApi.getRefund(j, j2).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkExpressionValueIsNotNull(observeOn, "refundApi.getRefund(orde…dSchedulers.mainThread())");
        return observeOn;
    }

    @NotNull
    public final Completable requestRefundCancel(long j, long j2) {
        Completable observeOn = this.refundApi.deleteRefund(j, j2).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkExpressionValueIsNotNull(observeOn, "refundApi.deleteRefund(o…dSchedulers.mainThread())");
        return observeOn;
    }

    /* access modifiers changed from: private */
    public final ExchangeRefundVariant mapToDomain(@NotNull PreRefundResponse preRefundResponse) {
        StringBuilder sb = new StringBuilder();
        sb.append(preRefundResponse.getStoreInfo().getStoreName());
        String str = " / ";
        sb.append(str);
        sb.append(preRefundResponse.getOrderLineItemVariant().getVariant().getProduct().getTitle());
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(getOptionString(preRefundResponse));
        sb3.append(str);
        sb3.append(preRefundResponse.getOrderLineItemVariant().getQuantity());
        sb3.append("개 / ");
        sb3.append(IntExtensionsKt.commaString(preRefundResponse.getOrderLineItemVariant().getPrice()));
        sb3.append(50896);
        return new ExchangeRefundVariant(sb2, sb3.toString(), preRefundResponse.getRefundAccount(), preRefundResponse.getOrderLineItemVariant().getQuantity());
    }

    private final String getOptionString(@NotNull PreRefundResponse preRefundResponse) {
        String str = "";
        int i = 0;
        for (Object next : preRefundResponse.getOrderLineItemVariant().getVariant().getOption()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            VariantInfoOption variantInfoOption = (VariantInfoOption) next;
            if (i == 0) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(variantInfoOption.getOptionValue());
                str = sb.toString();
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(" / ");
                sb2.append(variantInfoOption.getOptionValue());
                str = sb2.toString();
            }
            i = i2;
        }
        return str;
    }
}
