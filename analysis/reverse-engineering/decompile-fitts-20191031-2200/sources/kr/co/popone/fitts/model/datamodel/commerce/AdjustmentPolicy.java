package kr.co.popone.fitts.model.datamodel.commerce;

import com.google.gson.annotations.SerializedName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class AdjustmentPolicy {
    @SerializedName("available_percentage_of_holding")
    private final int availableHoldingPercentage;
    @SerializedName("available_percentage_of_payment")
    private final int availablePaymentPercentage;
    @SerializedName("min_holding_value")
    private final int minHoldingValue;
    @SerializedName("min_order_price")
    private final int minOrderPrice;
    @SerializedName("usage_unit")
    private final int usageUnit;

    @NotNull
    public static /* synthetic */ AdjustmentPolicy copy$default(AdjustmentPolicy adjustmentPolicy, int i, int i2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = adjustmentPolicy.minHoldingValue;
        }
        if ((i6 & 2) != 0) {
            i2 = adjustmentPolicy.minOrderPrice;
        }
        int i7 = i2;
        if ((i6 & 4) != 0) {
            i3 = adjustmentPolicy.availablePaymentPercentage;
        }
        int i8 = i3;
        if ((i6 & 8) != 0) {
            i4 = adjustmentPolicy.availableHoldingPercentage;
        }
        int i9 = i4;
        if ((i6 & 16) != 0) {
            i5 = adjustmentPolicy.usageUnit;
        }
        return adjustmentPolicy.copy(i, i7, i8, i9, i5);
    }

    public final int component1() {
        return this.minHoldingValue;
    }

    public final int component2() {
        return this.minOrderPrice;
    }

    public final int component3() {
        return this.availablePaymentPercentage;
    }

    public final int component4() {
        return this.availableHoldingPercentage;
    }

    public final int component5() {
        return this.usageUnit;
    }

    @NotNull
    public final AdjustmentPolicy copy(int i, int i2, int i3, int i4, int i5) {
        AdjustmentPolicy adjustmentPolicy = new AdjustmentPolicy(i, i2, i3, i4, i5);
        return adjustmentPolicy;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof AdjustmentPolicy) {
                AdjustmentPolicy adjustmentPolicy = (AdjustmentPolicy) obj;
                if (this.minHoldingValue == adjustmentPolicy.minHoldingValue) {
                    if (this.minOrderPrice == adjustmentPolicy.minOrderPrice) {
                        if (this.availablePaymentPercentage == adjustmentPolicy.availablePaymentPercentage) {
                            if (this.availableHoldingPercentage == adjustmentPolicy.availableHoldingPercentage) {
                                if (this.usageUnit == adjustmentPolicy.usageUnit) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((((((this.minHoldingValue * 31) + this.minOrderPrice) * 31) + this.availablePaymentPercentage) * 31) + this.availableHoldingPercentage) * 31) + this.usageUnit;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AdjustmentPolicy(minHoldingValue=");
        sb.append(this.minHoldingValue);
        sb.append(", minOrderPrice=");
        sb.append(this.minOrderPrice);
        sb.append(", availablePaymentPercentage=");
        sb.append(this.availablePaymentPercentage);
        sb.append(", availableHoldingPercentage=");
        sb.append(this.availableHoldingPercentage);
        sb.append(", usageUnit=");
        sb.append(this.usageUnit);
        sb.append(")");
        return sb.toString();
    }

    public AdjustmentPolicy(int i, int i2, int i3, int i4, int i5) {
        this.minHoldingValue = i;
        this.minOrderPrice = i2;
        this.availablePaymentPercentage = i3;
        this.availableHoldingPercentage = i4;
        this.usageUnit = i5;
    }

    public final int getMinHoldingValue() {
        return this.minHoldingValue;
    }

    public final int getMinOrderPrice() {
        return this.minOrderPrice;
    }

    public final int getAvailablePaymentPercentage() {
        return this.availablePaymentPercentage;
    }

    public final int getAvailableHoldingPercentage() {
        return this.availableHoldingPercentage;
    }

    public final int getUsageUnit() {
        return this.usageUnit;
    }
}
