package kr.co.popone.fitts.model.datamodel.service.banner;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class NewBannerCount {
    @SerializedName("count")
    private final int badgeCount;
    @SerializedName("type")
    @NotNull
    private final String badgeType;

    @NotNull
    public static /* synthetic */ NewBannerCount copy$default(NewBannerCount newBannerCount, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = newBannerCount.badgeType;
        }
        if ((i2 & 2) != 0) {
            i = newBannerCount.badgeCount;
        }
        return newBannerCount.copy(str, i);
    }

    @NotNull
    public final String component1() {
        return this.badgeType;
    }

    public final int component2() {
        return this.badgeCount;
    }

    @NotNull
    public final NewBannerCount copy(@NotNull String str, int i) {
        Intrinsics.checkParameterIsNotNull(str, "badgeType");
        return new NewBannerCount(str, i);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof NewBannerCount) {
                NewBannerCount newBannerCount = (NewBannerCount) obj;
                if (Intrinsics.areEqual((Object) this.badgeType, (Object) newBannerCount.badgeType)) {
                    if (this.badgeCount == newBannerCount.badgeCount) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.badgeType;
        return ((str != null ? str.hashCode() : 0) * 31) + this.badgeCount;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("NewBannerCount(badgeType=");
        sb.append(this.badgeType);
        sb.append(", badgeCount=");
        sb.append(this.badgeCount);
        sb.append(")");
        return sb.toString();
    }

    public NewBannerCount(@NotNull String str, int i) {
        Intrinsics.checkParameterIsNotNull(str, "badgeType");
        this.badgeType = str;
        this.badgeCount = i;
    }

    @NotNull
    public final String getBadgeType() {
        return this.badgeType;
    }

    public final int getBadgeCount() {
        return this.badgeCount;
    }
}
