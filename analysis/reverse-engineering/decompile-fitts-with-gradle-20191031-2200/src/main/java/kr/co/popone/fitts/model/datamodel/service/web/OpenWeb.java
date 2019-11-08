package kr.co.popone.fitts.model.datamodel.service.web;

import androidx.annotation.NonNull;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class OpenWeb {
    @SerializedName("navigation")
    private final boolean hasNavigation;
    @SerializedName("head")
    private final boolean hasToolbar;
    private final long id;
    @SerializedName("target_url")
    @NotNull
    private final String targetUrl;
    @SerializedName("head_title")
    @Nullable
    private final String title;

    @NotNull
    public static /* synthetic */ OpenWeb copy$default(OpenWeb openWeb, long j, String str, boolean z, String str2, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = openWeb.id;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            str = openWeb.targetUrl;
        }
        String str3 = str;
        if ((i & 4) != 0) {
            z = openWeb.hasToolbar;
        }
        boolean z3 = z;
        if ((i & 8) != 0) {
            str2 = openWeb.title;
        }
        String str4 = str2;
        if ((i & 16) != 0) {
            z2 = openWeb.hasNavigation;
        }
        return openWeb.copy(j2, str3, z3, str4, z2);
    }

    public final long component1() {
        return this.id;
    }

    @NotNull
    public final String component2() {
        return this.targetUrl;
    }

    public final boolean component3() {
        return this.hasToolbar;
    }

    @Nullable
    public final String component4() {
        return this.title;
    }

    public final boolean component5() {
        return this.hasNavigation;
    }

    @NotNull
    public final OpenWeb copy(long j, @NotNull String str, boolean z, @Nullable String str2, boolean z2) {
        Intrinsics.checkParameterIsNotNull(str, "targetUrl");
        OpenWeb openWeb = new OpenWeb(j, str, z, str2, z2);
        return openWeb;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof OpenWeb) {
                OpenWeb openWeb = (OpenWeb) obj;
                if ((this.id == openWeb.id) && Intrinsics.areEqual((Object) this.targetUrl, (Object) openWeb.targetUrl)) {
                    if ((this.hasToolbar == openWeb.hasToolbar) && Intrinsics.areEqual((Object) this.title, (Object) openWeb.title)) {
                        if (this.hasNavigation == openWeb.hasNavigation) {
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
        String str = this.targetUrl;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        boolean z = this.hasToolbar;
        if (z) {
            z = true;
        }
        int i3 = (hashCode + (z ? 1 : 0)) * 31;
        String str2 = this.title;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i4 = (i3 + i2) * 31;
        boolean z2 = this.hasNavigation;
        if (z2) {
            z2 = true;
        }
        return i4 + (z2 ? 1 : 0);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("OpenWeb(id=");
        sb.append(this.id);
        sb.append(", targetUrl=");
        sb.append(this.targetUrl);
        sb.append(", hasToolbar=");
        sb.append(this.hasToolbar);
        sb.append(", title=");
        sb.append(this.title);
        sb.append(", hasNavigation=");
        sb.append(this.hasNavigation);
        sb.append(")");
        return sb.toString();
    }

    public OpenWeb(long j, @NotNull String str, boolean z, @Nullable String str2, boolean z2) {
        Intrinsics.checkParameterIsNotNull(str, "targetUrl");
        this.id = j;
        this.targetUrl = str;
        this.hasToolbar = z;
        this.title = str2;
        this.hasNavigation = z2;
    }

    public final long getId() {
        return this.id;
    }

    @NotNull
    @NonNull
    public final String getTargetUrl() {
        return this.targetUrl;
    }

    public final boolean getHasToolbar() {
        return this.hasToolbar;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    public final boolean getHasNavigation() {
        return this.hasNavigation;
    }
}
