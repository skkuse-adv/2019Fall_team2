package kr.co.popone.fitts.model.post;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class PostVariantViewData implements Parcelable {
    public static final android.os.Parcelable.Creator CREATOR = new Creator();
    private final long variantId;
    @NotNull
    private final String variantUrl;

    public static class Creator implements android.os.Parcelable.Creator {
        @NotNull
        public final Object createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "in");
            return new PostVariantViewData(parcel.readLong(), parcel.readString());
        }

        @NotNull
        public final Object[] newArray(int i) {
            return new PostVariantViewData[i];
        }
    }

    @NotNull
    public static /* synthetic */ PostVariantViewData copy$default(PostVariantViewData postVariantViewData, long j, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            j = postVariantViewData.variantId;
        }
        if ((i & 2) != 0) {
            str = postVariantViewData.variantUrl;
        }
        return postVariantViewData.copy(j, str);
    }

    public final long component1() {
        return this.variantId;
    }

    @NotNull
    public final String component2() {
        return this.variantUrl;
    }

    @NotNull
    public final PostVariantViewData copy(long j, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "variantUrl");
        return new PostVariantViewData(j, str);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof PostVariantViewData) {
                PostVariantViewData postVariantViewData = (PostVariantViewData) obj;
                if (!(this.variantId == postVariantViewData.variantId) || !Intrinsics.areEqual((Object) this.variantUrl, (Object) postVariantViewData.variantUrl)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        long j = this.variantId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.variantUrl;
        return i + (str != null ? str.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PostVariantViewData(variantId=");
        sb.append(this.variantId);
        sb.append(", variantUrl=");
        sb.append(this.variantUrl);
        sb.append(")");
        return sb.toString();
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeLong(this.variantId);
        parcel.writeString(this.variantUrl);
    }

    public PostVariantViewData(long j, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "variantUrl");
        this.variantId = j;
        this.variantUrl = str;
    }

    public final long getVariantId() {
        return this.variantId;
    }

    @NotNull
    public final String getVariantUrl() {
        return this.variantUrl;
    }
}
