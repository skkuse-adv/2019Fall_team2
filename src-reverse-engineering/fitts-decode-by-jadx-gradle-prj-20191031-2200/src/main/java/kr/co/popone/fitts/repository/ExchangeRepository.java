package kr.co.popone.fitts.repository;

import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.domain.exchange.ExchangeRefundVariant;
import kr.co.popone.fitts.model.product.VariantInfoOption;
import kr.co.popone.fitts.model.remote.exchange.ExchangeApi;
import kr.co.popone.fitts.model.remote.exchange.ExchangeApplyResponse;
import kr.co.popone.fitts.model.remote.exchange.PreExchageResponse;
import kr.co.popone.fitts.utils.IntExtensionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ExchangeRepository {
    private final ExchangeApi exchangeApi;

    public ExchangeRepository(@NotNull ExchangeApi exchangeApi2) {
        Intrinsics.checkParameterIsNotNull(exchangeApi2, "exchangeApi");
        this.exchangeApi = exchangeApi2;
    }

    @NotNull
    public final Single<ExchangeRefundVariant> requestPreExchangeInfo(long j) {
        Single<ExchangeRefundVariant> observeOn = this.exchangeApi.postPreExchangeData(j).subscribeOn(Schedulers.io()).map(new ExchangeRepository$requestPreExchangeInfo$1(this)).observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkExpressionValueIsNotNull(observeOn, "exchangeApi.postPreExcha…dSchedulers.mainThread())");
        return observeOn;
    }

    @NotNull
    public final Single<Pair<Long, Long>> requestExchangeApply(long j, int i, @NotNull String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @NotNull String str5, @NotNull String str6) {
        String str7 = str;
        Intrinsics.checkParameterIsNotNull(str, "option");
        String str8 = str5;
        Intrinsics.checkParameterIsNotNull(str8, "reason");
        String str9 = str6;
        Intrinsics.checkParameterIsNotNull(str9, "detailReason");
        long j2 = j;
        Single<Pair<Long, Long>> observeOn = this.exchangeApi.postExchange(j, i, str7, str2, str3, str4, str8, str9).subscribeOn(Schedulers.io()).map(new ExchangeRepository$requestExchangeApply$1(j)).observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkExpressionValueIsNotNull(observeOn, "exchangeApi.postExchange…dSchedulers.mainThread())");
        return observeOn;
    }

    @NotNull
    public final Single<ExchangeApplyResponse> requestExchangeDetailInfo(long j, long j2) {
        Single<ExchangeApplyResponse> observeOn = this.exchangeApi.getExchange(j, j2).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkExpressionValueIsNotNull(observeOn, "exchangeApi.getExchange(…dSchedulers.mainThread())");
        return observeOn;
    }

    @NotNull
    public final Completable requestExchangeCancel(long j, long j2) {
        Completable observeOn = this.exchangeApi.deleteExchange(j, j2).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkExpressionValueIsNotNull(observeOn, "exchangeApi.deleteExchan…dSchedulers.mainThread())");
        return observeOn;
    }

    /* access modifiers changed from: private */
    public final ExchangeRefundVariant mapToDomain(@NotNull PreExchageResponse preExchageResponse) {
        StringBuilder sb = new StringBuilder();
        sb.append(preExchageResponse.getStoreInfo().getStoreName());
        String str = " / ";
        sb.append(str);
        sb.append(preExchageResponse.getOrderLineItemVariant().getVariant().getProduct().getTitle());
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(getOptionString(preExchageResponse));
        sb3.append(str);
        sb3.append(preExchageResponse.getOrderLineItemVariant().getQuantity());
        sb3.append("개 / ");
        sb3.append(IntExtensionsKt.commaString(preExchageResponse.getOrderLineItemVariant().getPrice()));
        sb3.append(50896);
        return new ExchangeRefundVariant(sb2, sb3.toString(), preExchageResponse.getRefundAccount(), preExchageResponse.getOrderLineItemVariant().getQuantity());
    }

    private final String getOptionString(@NotNull PreExchageResponse preExchageResponse) {
        String str = "";
        int i = 0;
        for (Object next : preExchageResponse.getOrderLineItemVariant().getVariant().getOption()) {
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
