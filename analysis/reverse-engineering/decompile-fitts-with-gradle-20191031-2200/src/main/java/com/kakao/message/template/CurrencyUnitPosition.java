package com.kakao.message.template;

public enum CurrencyUnitPosition {
    REAR(Integer.valueOf(0)),
    FRONT(Integer.valueOf(1));
    
    final Integer value;

    private CurrencyUnitPosition(Integer num) {
        this.value = num;
    }

    /* access modifiers changed from: 0000 */
    public Integer getValue() {
        return this.value;
    }
}
