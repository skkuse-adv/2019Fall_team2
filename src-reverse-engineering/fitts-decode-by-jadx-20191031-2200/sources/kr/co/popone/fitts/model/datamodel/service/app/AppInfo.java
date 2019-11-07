package kr.co.popone.fitts.model.datamodel.service.app;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.datamodel.service.view.ToolTip;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class AppInfo {
    @SerializedName("points_first_review")
    private final int firstReviewPoints;
    @SerializedName("points_per_review")
    private final int perReviewPoints;
    @SerializedName("show_now_post")
    private final boolean showPostingDialog;
    @SerializedName("tooltip")
    @Nullable
    private final ToolTip toolTip;

    @NotNull
    public static /* synthetic */ AppInfo copy$default(AppInfo appInfo, int i, int i2, boolean z, ToolTip toolTip2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = appInfo.firstReviewPoints;
        }
        if ((i3 & 2) != 0) {
            i2 = appInfo.perReviewPoints;
        }
        if ((i3 & 4) != 0) {
            z = appInfo.showPostingDialog;
        }
        if ((i3 & 8) != 0) {
            toolTip2 = appInfo.toolTip;
        }
        return appInfo.copy(i, i2, z, toolTip2);
    }

    public final int component1() {
        return this.firstReviewPoints;
    }

    public final int component2() {
        return this.perReviewPoints;
    }

    public final boolean component3() {
        return this.showPostingDialog;
    }

    @Nullable
    public final ToolTip component4() {
        return this.toolTip;
    }

    @NotNull
    public final AppInfo copy(int i, int i2, boolean z, @Nullable ToolTip toolTip2) {
        return new AppInfo(i, i2, z, toolTip2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof AppInfo) {
                AppInfo appInfo = (AppInfo) obj;
                if (this.firstReviewPoints == appInfo.firstReviewPoints) {
                    if (this.perReviewPoints == appInfo.perReviewPoints) {
                        if (!(this.showPostingDialog == appInfo.showPostingDialog) || !Intrinsics.areEqual((Object) this.toolTip, (Object) appInfo.toolTip)) {
                            return false;
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = ((this.firstReviewPoints * 31) + this.perReviewPoints) * 31;
        boolean z = this.showPostingDialog;
        if (z) {
            z = true;
        }
        int i2 = (i + (z ? 1 : 0)) * 31;
        ToolTip toolTip2 = this.toolTip;
        return i2 + (toolTip2 != null ? toolTip2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AppInfo(firstReviewPoints=");
        sb.append(this.firstReviewPoints);
        sb.append(", perReviewPoints=");
        sb.append(this.perReviewPoints);
        sb.append(", showPostingDialog=");
        sb.append(this.showPostingDialog);
        sb.append(", toolTip=");
        sb.append(this.toolTip);
        sb.append(")");
        return sb.toString();
    }

    public AppInfo(int i, int i2, boolean z, @Nullable ToolTip toolTip2) {
        this.firstReviewPoints = i;
        this.perReviewPoints = i2;
        this.showPostingDialog = z;
        this.toolTip = toolTip2;
    }

    public final int getFirstReviewPoints() {
        return this.firstReviewPoints;
    }

    public final int getPerReviewPoints() {
        return this.perReviewPoints;
    }

    public final boolean getShowPostingDialog() {
        return this.showPostingDialog;
    }

    @Nullable
    public final ToolTip getToolTip() {
        return this.toolTip;
    }
}
