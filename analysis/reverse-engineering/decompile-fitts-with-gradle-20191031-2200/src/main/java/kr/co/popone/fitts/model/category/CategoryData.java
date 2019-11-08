package kr.co.popone.fitts.model.category;

import com.google.gson.annotations.SerializedName;
import com.uber.rave.annotation.Validated;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.validation.ValidatorFactoryImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Validated(factory = ValidatorFactoryImpl.class)
public final class CategoryData {
    @SerializedName("icon_url")
    @NotNull
    private final String icon;
    private final long id;
    @SerializedName("name")
    @NotNull
    private final String section;
    @SerializedName("subsections")
    @NotNull
    private final List<CategorySubData> subSections;

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<kr.co.popone.fitts.model.category.CategorySubData>, for r11v0, types: [java.util.List] */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ kr.co.popone.fitts.model.category.CategoryData copy$default(kr.co.popone.fitts.model.category.CategoryData r6, long r7, java.lang.String r9, java.lang.String r10, java.util.List<kr.co.popone.fitts.model.category.CategorySubData> r11, int r12, java.lang.Object r13) {
        /*
            r13 = r12 & 1
            if (r13 == 0) goto L_0x0006
            long r7 = r6.id
        L_0x0006:
            r1 = r7
            r7 = r12 & 2
            if (r7 == 0) goto L_0x000d
            java.lang.String r9 = r6.section
        L_0x000d:
            r3 = r9
            r7 = r12 & 4
            if (r7 == 0) goto L_0x0014
            java.lang.String r10 = r6.icon
        L_0x0014:
            r4 = r10
            r7 = r12 & 8
            if (r7 == 0) goto L_0x001b
            java.util.List<kr.co.popone.fitts.model.category.CategorySubData> r11 = r6.subSections
        L_0x001b:
            r5 = r11
            r0 = r6
            kr.co.popone.fitts.model.category.CategoryData r6 = r0.copy(r1, r3, r4, r5)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.category.CategoryData.copy$default(kr.co.popone.fitts.model.category.CategoryData, long, java.lang.String, java.lang.String, java.util.List, int, java.lang.Object):kr.co.popone.fitts.model.category.CategoryData");
    }

    public final long component1() {
        return this.id;
    }

    @NotNull
    public final String component2() {
        return this.section;
    }

    @NotNull
    public final String component3() {
        return this.icon;
    }

    @NotNull
    public final List<CategorySubData> component4() {
        return this.subSections;
    }

    @NotNull
    public final CategoryData copy(long j, @NotNull String str, @NotNull String str2, @NotNull List<CategorySubData> list) {
        Intrinsics.checkParameterIsNotNull(str, "section");
        Intrinsics.checkParameterIsNotNull(str2, SettingsJsonConstants.APP_ICON_KEY);
        Intrinsics.checkParameterIsNotNull(list, "subSections");
        CategoryData categoryData = new CategoryData(j, str, str2, list);
        return categoryData;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof CategoryData) {
                CategoryData categoryData = (CategoryData) obj;
                if (!(this.id == categoryData.id) || !Intrinsics.areEqual((Object) this.section, (Object) categoryData.section) || !Intrinsics.areEqual((Object) this.icon, (Object) categoryData.icon) || !Intrinsics.areEqual((Object) this.subSections, (Object) categoryData.subSections)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.section;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.icon;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        List<CategorySubData> list = this.subSections;
        if (list != null) {
            i2 = list.hashCode();
        }
        return hashCode2 + i2;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CategoryData(id=");
        sb.append(this.id);
        sb.append(", section=");
        sb.append(this.section);
        sb.append(", icon=");
        sb.append(this.icon);
        sb.append(", subSections=");
        sb.append(this.subSections);
        sb.append(")");
        return sb.toString();
    }

    public CategoryData(long j, @NotNull String str, @NotNull String str2, @NotNull List<CategorySubData> list) {
        Intrinsics.checkParameterIsNotNull(str, "section");
        Intrinsics.checkParameterIsNotNull(str2, SettingsJsonConstants.APP_ICON_KEY);
        Intrinsics.checkParameterIsNotNull(list, "subSections");
        this.id = j;
        this.section = str;
        this.icon = str2;
        this.subSections = list;
    }

    public final long getId() {
        return this.id;
    }

    @NotNull
    public final String getSection() {
        return this.section;
    }

    @NotNull
    public final String getIcon() {
        return this.icon;
    }

    @NotNull
    public final List<CategorySubData> getSubSections() {
        return this.subSections;
    }
}
