package kr.co.popone.fitts.model.product;

import org.jetbrains.annotations.NotNull;

public enum OrderableType {
    NORMAL("normal"),
    SPECIAL_DISCOUNT("special_discount");
    
    @NotNull
    private final String type;

    private OrderableType(String str) {
        this.type = str;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }
}
