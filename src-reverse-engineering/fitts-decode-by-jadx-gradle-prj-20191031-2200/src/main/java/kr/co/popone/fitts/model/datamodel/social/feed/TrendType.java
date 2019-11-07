package kr.co.popone.fitts.model.datamodel.social.feed;

import org.jetbrains.annotations.NotNull;

public enum TrendType {
    TREND("trend"),
    POPULAR("shop_popular");
    
    @NotNull
    private final String value;

    private TrendType(String str) {
        this.value = str;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }
}
