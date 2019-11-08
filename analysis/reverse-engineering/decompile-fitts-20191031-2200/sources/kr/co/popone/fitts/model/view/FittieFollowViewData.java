package kr.co.popone.fitts.model.view;

import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.search.IntergratedSearchInterface;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class FittieFollowViewData implements IntergratedSearchInterface {
    @NotNull
    private final String fittsId;
    private final long id;
    private boolean isFollowing;
    private final boolean isSuitable;
    @Nullable
    private final String profileCoverImage;

    @NotNull
    public static /* synthetic */ FittieFollowViewData copy$default(FittieFollowViewData fittieFollowViewData, long j, String str, String str2, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = fittieFollowViewData.id;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            str = fittieFollowViewData.fittsId;
        }
        String str3 = str;
        if ((i & 4) != 0) {
            str2 = fittieFollowViewData.profileCoverImage;
        }
        String str4 = str2;
        if ((i & 8) != 0) {
            z = fittieFollowViewData.isFollowing;
        }
        boolean z3 = z;
        if ((i & 16) != 0) {
            z2 = fittieFollowViewData.isSuitable;
        }
        return fittieFollowViewData.copy(j2, str3, str4, z3, z2);
    }

    public final long component1() {
        return this.id;
    }

    @NotNull
    public final String component2() {
        return this.fittsId;
    }

    @Nullable
    public final String component3() {
        return this.profileCoverImage;
    }

    public final boolean component4() {
        return this.isFollowing;
    }

    public final boolean component5() {
        return this.isSuitable;
    }

    @NotNull
    public final FittieFollowViewData copy(long j, @NotNull String str, @Nullable String str2, boolean z, boolean z2) {
        Intrinsics.checkParameterIsNotNull(str, "fittsId");
        FittieFollowViewData fittieFollowViewData = new FittieFollowViewData(j, str, str2, z, z2);
        return fittieFollowViewData;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof FittieFollowViewData) {
                FittieFollowViewData fittieFollowViewData = (FittieFollowViewData) obj;
                if ((this.id == fittieFollowViewData.id) && Intrinsics.areEqual((Object) this.fittsId, (Object) fittieFollowViewData.fittsId) && Intrinsics.areEqual((Object) this.profileCoverImage, (Object) fittieFollowViewData.profileCoverImage)) {
                    if (this.isFollowing == fittieFollowViewData.isFollowing) {
                        if (this.isSuitable == fittieFollowViewData.isSuitable) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.fittsId;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.profileCoverImage;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = (hashCode + i2) * 31;
        boolean z = this.isFollowing;
        if (z) {
            z = true;
        }
        int i4 = (i3 + (z ? 1 : 0)) * 31;
        boolean z2 = this.isSuitable;
        if (z2) {
            z2 = true;
        }
        return i4 + (z2 ? 1 : 0);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FittieFollowViewData(id=");
        sb.append(this.id);
        sb.append(", fittsId=");
        sb.append(this.fittsId);
        sb.append(", profileCoverImage=");
        sb.append(this.profileCoverImage);
        sb.append(", isFollowing=");
        sb.append(this.isFollowing);
        sb.append(", isSuitable=");
        sb.append(this.isSuitable);
        sb.append(")");
        return sb.toString();
    }

    public FittieFollowViewData(long j, @NotNull String str, @Nullable String str2, boolean z, boolean z2) {
        Intrinsics.checkParameterIsNotNull(str, "fittsId");
        this.id = j;
        this.fittsId = str;
        this.profileCoverImage = str2;
        this.isFollowing = z;
        this.isSuitable = z2;
    }

    public final long getId() {
        return this.id;
    }

    @NotNull
    public final String getFittsId() {
        return this.fittsId;
    }

    @Nullable
    public final String getProfileCoverImage() {
        return this.profileCoverImage;
    }

    public final boolean isFollowing() {
        return this.isFollowing;
    }

    public final void setFollowing(boolean z) {
        this.isFollowing = z;
    }

    public final boolean isSuitable() {
        return this.isSuitable;
    }
}
