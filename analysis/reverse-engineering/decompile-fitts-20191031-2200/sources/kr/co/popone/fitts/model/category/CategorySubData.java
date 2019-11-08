package kr.co.popone.fitts.model.category;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CategorySubData {
    private final long id;
    @SerializedName("name")
    @NotNull
    private final String name;

    @NotNull
    public static /* synthetic */ CategorySubData copy$default(CategorySubData categorySubData, long j, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            j = categorySubData.id;
        }
        if ((i & 2) != 0) {
            str = categorySubData.name;
        }
        return categorySubData.copy(j, str);
    }

    public final long component1() {
        return this.id;
    }

    @NotNull
    public final String component2() {
        return this.name;
    }

    @NotNull
    public final CategorySubData copy(long j, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "name");
        return new CategorySubData(j, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof CategorySubData) {
                CategorySubData categorySubData = (CategorySubData) obj;
                if (!(this.id == categorySubData.id) || !Intrinsics.areEqual((Object) this.name, (Object) categorySubData.name)) {
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
        String str = this.name;
        return i + (str != null ? str.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CategorySubData(id=");
        sb.append(this.id);
        sb.append(", name=");
        sb.append(this.name);
        sb.append(")");
        return sb.toString();
    }

    public CategorySubData(long j, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "name");
        this.id = j;
        this.name = str;
    }

    public final long getId() {
        return this.id;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }
}
