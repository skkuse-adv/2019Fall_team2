package kr.co.popone.fitts.model.datamodel.service.view;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ToolTip {
    @SerializedName("location")
    @Nullable
    private final Location location;
    @SerializedName("message_1")
    @NotNull
    private final String messageFirst;
    @SerializedName("message_2")
    @NotNull
    private final String messageSecond;

    public enum Location {
        STORE_TAB
    }

    @NotNull
    public static /* synthetic */ ToolTip copy$default(ToolTip toolTip, String str, String str2, Location location2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = toolTip.messageFirst;
        }
        if ((i & 2) != 0) {
            str2 = toolTip.messageSecond;
        }
        if ((i & 4) != 0) {
            location2 = toolTip.location;
        }
        return toolTip.copy(str, str2, location2);
    }

    @NotNull
    public final String component1() {
        return this.messageFirst;
    }

    @NotNull
    public final String component2() {
        return this.messageSecond;
    }

    @Nullable
    public final Location component3() {
        return this.location;
    }

    @NotNull
    public final ToolTip copy(@NotNull String str, @NotNull String str2, @Nullable Location location2) {
        Intrinsics.checkParameterIsNotNull(str, "messageFirst");
        Intrinsics.checkParameterIsNotNull(str2, "messageSecond");
        return new ToolTip(str, str2, location2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0024, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2.location, (java.lang.Object) r3.location) != false) goto L_0x0029;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r3) {
        /*
            r2 = this;
            if (r2 == r3) goto L_0x0029
            boolean r0 = r3 instanceof kr.co.popone.fitts.model.datamodel.service.view.ToolTip
            if (r0 == 0) goto L_0x0027
            kr.co.popone.fitts.model.datamodel.service.view.ToolTip r3 = (kr.co.popone.fitts.model.datamodel.service.view.ToolTip) r3
            java.lang.String r0 = r2.messageFirst
            java.lang.String r1 = r3.messageFirst
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0027
            java.lang.String r0 = r2.messageSecond
            java.lang.String r1 = r3.messageSecond
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0027
            kr.co.popone.fitts.model.datamodel.service.view.ToolTip$Location r0 = r2.location
            kr.co.popone.fitts.model.datamodel.service.view.ToolTip$Location r3 = r3.location
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r3)
            if (r3 == 0) goto L_0x0027
            goto L_0x0029
        L_0x0027:
            r3 = 0
            return r3
        L_0x0029:
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.datamodel.service.view.ToolTip.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        String str = this.messageFirst;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.messageSecond;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Location location2 = this.location;
        if (location2 != null) {
            i = location2.hashCode();
        }
        return hashCode2 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ToolTip(messageFirst=");
        sb.append(this.messageFirst);
        sb.append(", messageSecond=");
        sb.append(this.messageSecond);
        sb.append(", location=");
        sb.append(this.location);
        sb.append(")");
        return sb.toString();
    }

    public ToolTip(@NotNull String str, @NotNull String str2, @Nullable Location location2) {
        Intrinsics.checkParameterIsNotNull(str, "messageFirst");
        Intrinsics.checkParameterIsNotNull(str2, "messageSecond");
        this.messageFirst = str;
        this.messageSecond = str2;
        this.location = location2;
    }

    @NotNull
    public final String getMessageFirst() {
        return this.messageFirst;
    }

    @NotNull
    public final String getMessageSecond() {
        return this.messageSecond;
    }

    @Nullable
    public final Location getLocation() {
        return this.location;
    }
}
