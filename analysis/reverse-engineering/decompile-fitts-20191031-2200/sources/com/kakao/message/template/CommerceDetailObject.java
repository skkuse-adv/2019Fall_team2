package com.kakao.message.template;

import org.json.JSONException;
import org.json.JSONObject;

public class CommerceDetailObject {
    private final Integer discountPrice;
    private final Integer discountRate;
    private final Integer fixedDiscountPrice;
    private final Integer regularPrice;

    public static class Builder {
        /* access modifiers changed from: private */
        public Integer discountPrice;
        /* access modifiers changed from: private */
        public Integer discountRate;
        /* access modifiers changed from: private */
        public Integer fixedDiscountPrice;
        /* access modifiers changed from: private */
        public Integer regularPrice;

        Builder(Integer num) {
            this.regularPrice = num;
        }

        public Builder setDiscountPrice(Integer num) {
            this.discountPrice = num;
            return this;
        }

        public Builder setDiscountRate(Integer num) {
            this.discountRate = num;
            return this;
        }

        public Builder setFixedDiscountPrice(Integer num) {
            this.fixedDiscountPrice = num;
            return this;
        }

        public CommerceDetailObject build() {
            return new CommerceDetailObject(this);
        }
    }

    public CommerceDetailObject(Builder builder) {
        this.regularPrice = builder.regularPrice;
        this.discountPrice = builder.discountPrice;
        this.discountRate = builder.discountRate;
        this.fixedDiscountPrice = builder.fixedDiscountPrice;
    }

    public static Builder newBuilder(Integer num) {
        return new Builder(num);
    }

    public JSONObject toJSONObject() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(MessageTemplateProtocol.REGULAR_PRICE, this.regularPrice);
            jSONObject.put(MessageTemplateProtocol.DISCOUNT_PRICE, this.discountPrice);
            jSONObject.put(MessageTemplateProtocol.DISCOUNT_RATE, this.discountRate);
            jSONObject.put(MessageTemplateProtocol.FIXED_DISCOUNT_PRICE, this.fixedDiscountPrice);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }
}
