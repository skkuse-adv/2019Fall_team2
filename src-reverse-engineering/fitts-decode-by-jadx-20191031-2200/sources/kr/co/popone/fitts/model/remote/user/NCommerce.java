package kr.co.popone.fitts.model.remote.user;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class NCommerce {
    @SerializedName("month")
    @NotNull
    private final String month;
    @SerializedName("point")
    private final int point;
    @SerializedName("shared_point")
    private final int sharedPoint;
    @SerializedName("total_point")
    private final int totalPoint;

    @NotNull
    public static /* synthetic */ NCommerce copy$default(NCommerce nCommerce, String str, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = nCommerce.month;
        }
        if ((i4 & 2) != 0) {
            i = nCommerce.point;
        }
        if ((i4 & 4) != 0) {
            i2 = nCommerce.sharedPoint;
        }
        if ((i4 & 8) != 0) {
            i3 = nCommerce.totalPoint;
        }
        return nCommerce.copy(str, i, i2, i3);
    }

    @NotNull
    public final String component1() {
        return this.month;
    }

    public final int component2() {
        return this.point;
    }

    public final int component3() {
        return this.sharedPoint;
    }

    public final int component4() {
        return this.totalPoint;
    }

    @NotNull
    public final NCommerce copy(@NotNull String str, int i, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(str, "month");
        return new NCommerce(str, i, i2, i3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof NCommerce) {
                NCommerce nCommerce = (NCommerce) obj;
                if (Intrinsics.areEqual((Object) this.month, (Object) nCommerce.month)) {
                    if (this.point == nCommerce.point) {
                        if (this.sharedPoint == nCommerce.sharedPoint) {
                            if (this.totalPoint == nCommerce.totalPoint) {
                                return true;
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
        String str = this.month;
        return ((((((str != null ? str.hashCode() : 0) * 31) + this.point) * 31) + this.sharedPoint) * 31) + this.totalPoint;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("NCommerce(month=");
        sb.append(this.month);
        sb.append(", point=");
        sb.append(this.point);
        sb.append(", sharedPoint=");
        sb.append(this.sharedPoint);
        sb.append(", totalPoint=");
        sb.append(this.totalPoint);
        sb.append(")");
        return sb.toString();
    }

    public NCommerce(@NotNull String str, int i, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(str, "month");
        this.month = str;
        this.point = i;
        this.sharedPoint = i2;
        this.totalPoint = i3;
    }

    @NotNull
    public final String getMonth() {
        return this.month;
    }

    public final int getPoint() {
        return this.point;
    }

    public final int getSharedPoint() {
        return this.sharedPoint;
    }

    public final int getTotalPoint() {
        return this.totalPoint;
    }
}
