package kr.co.popone.fitts.model.datamodel.service.app;

import androidx.annotation.NonNull;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class Version {
    @SerializedName("display_message")
    @Nullable
    private final String displayMessage;
    @SerializedName("latest_version")
    @NotNull
    private final String latestVersion;
    @SerializedName("type")
    @Nullable
    private final Type type;

    public enum Type {
        REQUIRED,
        OPTIONAL
    }

    @NotNull
    public static /* synthetic */ Version copy$default(Version version, String str, Type type2, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = version.latestVersion;
        }
        if ((i & 2) != 0) {
            type2 = version.type;
        }
        if ((i & 4) != 0) {
            str2 = version.displayMessage;
        }
        return version.copy(str, type2, str2);
    }

    @NotNull
    public final String component1() {
        return this.latestVersion;
    }

    @Nullable
    public final Type component2() {
        return this.type;
    }

    @Nullable
    public final String component3() {
        return this.displayMessage;
    }

    @NotNull
    public final Version copy(@NotNull String str, @Nullable Type type2, @Nullable String str2) {
        Intrinsics.checkParameterIsNotNull(str, "latestVersion");
        return new Version(str, type2, str2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0024, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2.displayMessage, (java.lang.Object) r3.displayMessage) != false) goto L_0x0029;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r3) {
        /*
            r2 = this;
            if (r2 == r3) goto L_0x0029
            boolean r0 = r3 instanceof kr.co.popone.fitts.model.datamodel.service.app.Version
            if (r0 == 0) goto L_0x0027
            kr.co.popone.fitts.model.datamodel.service.app.Version r3 = (kr.co.popone.fitts.model.datamodel.service.app.Version) r3
            java.lang.String r0 = r2.latestVersion
            java.lang.String r1 = r3.latestVersion
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0027
            kr.co.popone.fitts.model.datamodel.service.app.Version$Type r0 = r2.type
            kr.co.popone.fitts.model.datamodel.service.app.Version$Type r1 = r3.type
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0027
            java.lang.String r0 = r2.displayMessage
            java.lang.String r3 = r3.displayMessage
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
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.datamodel.service.app.Version.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        String str = this.latestVersion;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Type type2 = this.type;
        int hashCode2 = (hashCode + (type2 != null ? type2.hashCode() : 0)) * 31;
        String str2 = this.displayMessage;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode2 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Version(latestVersion=");
        sb.append(this.latestVersion);
        sb.append(", type=");
        sb.append(this.type);
        sb.append(", displayMessage=");
        sb.append(this.displayMessage);
        sb.append(")");
        return sb.toString();
    }

    public Version(@NotNull String str, @Nullable Type type2, @Nullable String str2) {
        Intrinsics.checkParameterIsNotNull(str, "latestVersion");
        this.latestVersion = str;
        this.type = type2;
        this.displayMessage = str2;
    }

    @NotNull
    @NonNull
    public final String getLatestVersion() {
        return this.latestVersion;
    }

    @Nullable
    public final Type getType() {
        return this.type;
    }

    @Nullable
    public final String getDisplayMessage() {
        return this.displayMessage;
    }
}
