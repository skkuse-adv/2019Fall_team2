package kr.co.popone.fitts.model.category;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class SubCategoryViewData implements Parcelable {
    public static final android.os.Parcelable.Creator CREATOR = new Creator();
    @NotNull
    private final String subCategory;
    @Nullable
    private final Long subCategoryId;

    public static class Creator implements android.os.Parcelable.Creator {
        @NotNull
        public final Object createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "in");
            return new SubCategoryViewData(parcel.readInt() != 0 ? Long.valueOf(parcel.readLong()) : null, parcel.readString());
        }

        @NotNull
        public final Object[] newArray(int i) {
            return new SubCategoryViewData[i];
        }
    }

    @NotNull
    public static /* synthetic */ SubCategoryViewData copy$default(SubCategoryViewData subCategoryViewData, Long l, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            l = subCategoryViewData.subCategoryId;
        }
        if ((i & 2) != 0) {
            str = subCategoryViewData.subCategory;
        }
        return subCategoryViewData.copy(l, str);
    }

    @Nullable
    public final Long component1() {
        return this.subCategoryId;
    }

    @NotNull
    public final String component2() {
        return this.subCategory;
    }

    @NotNull
    public final SubCategoryViewData copy(@Nullable Long l, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "subCategory");
        return new SubCategoryViewData(l, str);
    }

    public int describeContents() {
        return 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001a, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2.subCategory, (java.lang.Object) r3.subCategory) != false) goto L_0x001f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r3) {
        /*
            r2 = this;
            if (r2 == r3) goto L_0x001f
            boolean r0 = r3 instanceof kr.co.popone.fitts.model.category.SubCategoryViewData
            if (r0 == 0) goto L_0x001d
            kr.co.popone.fitts.model.category.SubCategoryViewData r3 = (kr.co.popone.fitts.model.category.SubCategoryViewData) r3
            java.lang.Long r0 = r2.subCategoryId
            java.lang.Long r1 = r3.subCategoryId
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x001d
            java.lang.String r0 = r2.subCategory
            java.lang.String r3 = r3.subCategory
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r3)
            if (r3 == 0) goto L_0x001d
            goto L_0x001f
        L_0x001d:
            r3 = 0
            return r3
        L_0x001f:
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.category.SubCategoryViewData.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        Long l = this.subCategoryId;
        int i = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 31;
        String str = this.subCategory;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SubCategoryViewData(subCategoryId=");
        sb.append(this.subCategoryId);
        sb.append(", subCategory=");
        sb.append(this.subCategory);
        sb.append(")");
        return sb.toString();
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        Long l = this.subCategoryId;
        if (l != null) {
            parcel.writeInt(1);
            parcel.writeLong(l.longValue());
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.subCategory);
    }

    public SubCategoryViewData(@Nullable Long l, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "subCategory");
        this.subCategoryId = l;
        this.subCategory = str;
    }

    @Nullable
    public final Long getSubCategoryId() {
        return this.subCategoryId;
    }

    @NotNull
    public final String getSubCategory() {
        return this.subCategory;
    }
}
