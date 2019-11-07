package com.crashlytics.android.answers;

import java.math.BigDecimal;
import java.util.Currency;

public class AddToCartEvent extends PredefinedEvent<AddToCartEvent> {
    static final String CURRENCY_ATTRIBUTE = "currency";
    static final String ITEM_ID_ATTRIBUTE = "itemId";
    static final String ITEM_NAME_ATTRIBUTE = "itemName";
    static final String ITEM_PRICE_ATTRIBUTE = "itemPrice";
    static final String ITEM_TYPE_ATTRIBUTE = "itemType";
    static final BigDecimal MICRO_CONSTANT = BigDecimal.valueOf(1000000);
    static final String TYPE = "addToCart";

    /* access modifiers changed from: 0000 */
    public String getPredefinedType() {
        return TYPE;
    }

    public AddToCartEvent putItemId(String str) {
        this.predefinedAttributes.put(ITEM_ID_ATTRIBUTE, str);
        return this;
    }

    public AddToCartEvent putItemName(String str) {
        this.predefinedAttributes.put(ITEM_NAME_ATTRIBUTE, str);
        return this;
    }

    public AddToCartEvent putItemType(String str) {
        this.predefinedAttributes.put(ITEM_TYPE_ATTRIBUTE, str);
        return this;
    }

    public AddToCartEvent putItemPrice(BigDecimal bigDecimal) {
        AnswersEventValidator answersEventValidator = this.validator;
        String str = ITEM_PRICE_ATTRIBUTE;
        if (!answersEventValidator.isNull(bigDecimal, str)) {
            this.predefinedAttributes.put(str, (Number) Long.valueOf(priceToMicros(bigDecimal)));
        }
        return this;
    }

    public AddToCartEvent putCurrency(Currency currency) {
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
