package kr.co.popone.fitts.model.view.adjustment;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class AdjustmentViewData implements Parcelable {
    public static final android.os.Parcelable.Creator CREATOR = new Creator();
    private final int availablePercentage;
    private final int minHoldValue;
    private final int minOrderValue;
    private final int ownValue;
    private final int usableValue;
    private final int usageValueUnit;

    public static class Creator implements android.os.Parcelable.Creator {
        @NotNull
        public final Object createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "in");
            AdjustmentViewData adjustmentViewData = new AdjustmentViewData(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
            return adjustmentViewData;
        }

        @NotNull
        public final Object[] newArray(int i) {
            return new AdjustmentViewData[i];
        }
    }

    @NotNull
    public static /* synthetic */ AdjustmentViewData copy$default(AdjustmentViewData adjustmentViewData, int i, int i2, int i3, int i4, int i5, int i6, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            i = adjustmentViewData.minHoldValue;
        }
        if ((i7 & 2) != 0) {
            i2 = adjustmentViewData.minOrderValue;
        }
        int i8 = i2;
        if ((i7 & 4) != 0) {
            i3 = adjustmentViewData.availablePercentage;
        }
        int i9 = i3;
        if ((i7 & 8) != 0) {
            i4 = adjustmentViewData.usageValueUnit;
        }
        int i10 = i4;
        if ((i7 & 16) != 0) {
            i5 = adjustmentViewData.usableValue;
        }
        int i11 = i5;
        if ((i7 & 32) != 0) {
            i6 = adjustmentViewData.ownValue;
        }
        return adjustmentViewData.copy(i, i8, i9, i10, i11, i6);
    }

    public final int component1() {
        return this.minHoldValue;
    }

    public final int component2() {
        return this.minOrderValue;
    }

    public final int component3() {
        return this.availablePercentage;
    }

    public final int component4() {
        return this.usageValueUnit;
    }

    public final int component5() {
        return this.usableValue;
    }

    public final int component6() {
        return this.ownValue;
    }

    @NotNull
    public final AdjustmentViewData copy(int i, int i2, int i3, int i4, int i5, int i6) {
        AdjustmentViewData adjustmentViewData = new AdjustmentViewData(i, i2, i3, i4, i5, i6);
        return adjustmentViewData;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof AdjustmentViewData) {
                AdjustmentViewData adjustmentViewData = (AdjustmentViewData) obj;
                if (this.minHoldValue == adjustmentViewData.minHoldValue) {
                    if (this.minOrderValue == adjustmentViewData.minOrderValue) {
                        if (this.availablePercentage == adjustmentViewData.availablePercentage) {
                            if (this.usageValueUnit == adjustmentViewData.usageValueUnit) {
                                if (this.usableValue == adjustmentViewData.usableValue) {
                                    if (this.ownValue == adjustmentViewData.ownValue) {
                                        return true;
                                    }
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
        return (((((((((this.minHoldValue * 31) + this.minOrderValue) * 31) + this.availablePercentage) * 31) + this.usageValueUnit) * 31) + this.usableValue) * 31) + this.ownValue;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AdjustmentViewData(minHoldValue=");
        sb.append(this.minHoldValue);
        sb.append(", minOrderValue=");
        sb.append(this.minOrderValue);
        sb.append(", availablePercentage=");
        sb.append(this.availablePercentage);
        sb.append(", usageValueUnit=");
        sb.append(this.usageValueUnit);
        sb.append(", usableValue=");
        sb.append(this.usableValue);
        sb.append(", ownValue=");
        sb.append(this.ownValue);
        sb.append(")");
        return sb.toString();
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeInt(this.minHoldValue);
        parcel.writeInt(this.minOrderValue);
        parcel.writeInt(this.availablePercentage);
        parcel.writeInt(this.usageValueUnit);
        parcel.writeInt(this.usableValue);
        parcel.writeInt(this.ownValue);
    }

    public AdjustmentViewData(int i, int i2, int i3, int i4, int i5, int i6) {
        this.minHoldValue = i;
        this.minOrderValue = i2;
        this.availablePercentage = i3;
        this.usageValueUnit = i4;
        this.usableValue = i5;
        this.ownValue = i6;
    }

    public final int getMinHoldValue() {
        return this.minHoldValue;
    }

    public final int getMinOrderValue() {
        return this.minOrderValue;
    }

    public final int getAvailablePercentage() {
        return this.availablePercentage;
    }

    public final int getUsageValueUnit() {
        return this.usageValueUnit;
    }

    public final int getUsableValue() {
        return this.usableValue;
    }

    public final int getOwnValue() {
        return this.ownValue;
    }
}
