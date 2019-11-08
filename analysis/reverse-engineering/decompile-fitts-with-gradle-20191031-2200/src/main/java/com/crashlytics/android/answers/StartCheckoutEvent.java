package com.crashlytics.android.answers;

import java.math.BigDecimal;
import java.util.Currency;

public class StartCheckoutEvent extends PredefinedEvent<StartCheckoutEvent> {
    static final String CURRENCY_ATTRIBUTE = "currency";
    static final String ITEM_COUNT_ATTRIBUTE = "itemCount";
    static final BigDecimal MICRO_CONSTANT = BigDecimal.valueOf(1000000);
    static final String TOTAL_PRICE_ATTRIBUTE = "totalPrice";
    static final String TYPE = "startCheckout";

    /* access modifiers changed from: 0000 */
    public String getPredefinedType() {
        return TYPE;
    }

    public StartCheckoutEvent putItemCount(int i) {
        this.predefinedAttributes.put(ITEM_COUNT_ATTRIBUTE, (Number) Integer.valueOf(i));
        return this;
    }

    public StartCheckoutEvent putTotalPrice(BigDecimal bigDecimal) {
        AnswersEventValidator answersEventValidator = this.validator;
        String str = TOTAL_PRICE_ATTRIBUTE;
        if (!answersEventValidator.isNull(bigDecimal, str)) {
            this.predefinedAttributes.put(str, (Number) Long.valueOf(priceToMicros(bigDecimal)));
        }
        return this;
    }

    public StartCheckoutEvent putCurrency(Currency currency) {
        AnswersEventValidator answersEventValidator = this.validator;
        String str = CURRENCY_ATTRIBUTE;
        if (!answersEventValidator.isNull(currency, str)) {
            this.predefinedAttributes.put(str, currency.getCurrencyCode());
        }
        return this;
    }

    /* access modifiers changed from: 0000 */
    public long priceToMicros(BigDecimal bigDecimal) {
        return MICRO_CONSTANT.multiply(bigDecimal).longValue();
    }
}
