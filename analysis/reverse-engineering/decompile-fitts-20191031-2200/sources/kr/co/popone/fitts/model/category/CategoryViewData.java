package kr.co.popone.fitts.model.category;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CategoryViewData implements Parcelable {
    public static final android.os.Parcelable.Creator CREATOR = new Creator();
    @NotNull
    private final String category;
    @Nullable
    private final String categoryIcon;
    private final long categoryId;
    @NotNull
    private final List<SubCategoryViewData> subCategories;

    public static class Creator implements android.os.Parcelable.Creator {
        @NotNull
        public final Object createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "in");
            long readLong = parcel.readLong();
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add((SubCategoryViewData) SubCategoryViewData.CREATOR.createFromParcel(parcel));
                readInt--;
            }
            CategoryViewData categoryViewData = new CategoryViewData(readLong, readString, readString2, arrayList);
            return categoryViewData;
        }

        @NotNull
        public final Object[] newArray(int i) {
            return new CategoryViewData[i];
        }
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<kr.co.popone.fitts.model.category.SubCategoryViewData>, for r11v0, types: [java.util.List] */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ kr.co.popone.fitts.model.category.CategoryViewData copy$default(kr.co.popone.fitts.model.category.CategoryViewData r6, long r7, java.lang.String r9, java.lang.String r10, java.util.List<kr.co.popone.fitts.model.category.SubCategoryViewData> r11, int r12, java.lang.Object r13) {
        /*
            r13 = r12 & 1
            if (r13 == 0) goto L_0x0006
            long r7 = r6.categoryId
        L_0x0006:
            r1 = r7
            r7 = r12 & 2
            if (r7 == 0) goto L_0x000d
            java.lang.String r9 = r6.categoryIcon
        L_0x000d:
            r3 = r9
            r7 = r12 & 4
            if (r7 == 0) goto L_0x0014
            java.lang.String r10 = r6.category
        L_0x0014:
            r4 = r10
            r7 = r12 & 8
            if (r7 == 0) goto L_0x001b
            java.util.List<kr.co.popone.fitts.model.category.SubCategoryViewData> r11 = r6.subCategories
        L_0x001b:
            r5 = r11
            r0 = r6
            kr.co.popone.fitts.model.category.CategoryViewData r6 = r0.copy(r1, r3, r4, r5)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.category.CategoryViewData.copy$default(kr.co.popone.fitts.model.category.CategoryViewData, long, java.lang.String, java.lang.String, java.util.List, int, java.lang.Object):kr.co.popone.fitts.model.category.CategoryViewData");
    }

    public final long component1() {
        return this.categoryId;
    }

    @Nullable
    public final String component2() {
        return this.categoryIcon;
    }

    @NotNull
    public final String component3() {
        return this.category;
    }

    @NotNull
    public final List<SubCategoryViewData> component4() {
        return this.subCategories;
    }

    @NotNull
    public final CategoryViewData copy(long j, @Nullable String str, @NotNull String str2, @NotNull List<SubCategoryViewData> list) {
        Intrinsics.checkParameterIsNotNull(str2, "category");
        Intrinsics.checkParameterIsNotNull(list, "subCategories");
        CategoryViewData categoryViewData = new CategoryViewData(j, str, str2, list);
        return categoryViewData;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof CategoryViewData) {
                CategoryViewData categoryViewData = (CategoryViewData) obj;
                if (!(this.categoryId == categoryViewData.categoryId) || !Intrinsics.areEqual((Object) this.categoryIcon, (Object) categoryViewData.categoryIcon) || !Intrinsics.areEqual((Object) this.category, (Object) categoryViewData.category) || !Intrinsics.areEqual((Object) this.subCategories, (Object) categoryViewData.subCategories)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        long j = this.categoryId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.categoryIcon;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.category;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        List<SubCategoryViewData> list = this.subCategories;
        if (list != null) {
            i2 = list.hashCode();
        }
        return hashCode2 + i2;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CategoryViewData(categoryId=");
        sb.append(this.categoryId);
        sb.append(", categoryIcon=");
        sb.append(this.categoryIcon);
        sb.append(", category=");
        sb.append(this.category);
        sb.append(", subCategories=");
        sb.append(this.subCategories);
        sb.append(")");
        return sb.toString();
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeLong(this.categoryId);
        parcel.writeString(this.categoryIcon);
        parcel.writeString(this.category);
        List<SubCategoryViewData> list = this.subCategories;
        parcel.writeInt(list.size());
        for (SubCategoryViewData writeToParcel : list) {
            writeToParcel.writeToParcel(parcel, 0);
        }
    }

    public CategoryViewData(long j, @Nullable String str, @NotNull String str2, @NotNull List<SubCategoryViewData> list) {
        Intrinsics.checkParameterIsNotNull(str2, "category");
        Intrinsics.checkParameterIsNotNull(list, "subCategories");
        this.categoryId = j;
        this.categoryIcon = str;
        this.category = str2;
        this.subCategories = list;
    }

    public final long getCategoryId() {
        return this.categoryId;
    }

    @Nullable
    public final String getCategoryIcon() {
        return this.categoryIcon;
    }

    @NotNull
    public final String getCategory() {
        return this.category;
    }

    @NotNull
    public final List<SubCategoryViewData> getSubCategories() {
        return this.subCategories;
    }
}
