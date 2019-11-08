package kr.co.popone.fitts.model.datamodel.service.log;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ActionLog {
    @Nullable
    private final Long from;
    @Nullable
    private final String path;
    @Nullable
    private final String scheme;
    @Nullable
    private final String subPath;
    @Nullable
    private final Long target;
    @Nullable
    private final String type;

    public static final class Builder {
        private Long from;
        private String path;
        private String scheme;
        private String subPath;
        private Long target;
        private String type;

        @NotNull
        public final Builder setType(@Nullable String str) {
            this.type = str;
            return this;
        }

        @NotNull
        public final Builder setPath(@Nullable String str) {
            this.path = str;
            return this;
        }

        @NotNull
        public final Builder setSubPath(@Nullable String str) {
            this.subPath = str;
            return this;
        }

        @NotNull
        public final Builder setFrom(@Nullable Long l) {
            this.from = l;
            return this;
        }

        @NotNull
        public final Builder setTarget(@Nullable Long l) {
            this.target = l;
            return this;
        }

        @NotNull
        public final Builder setScheme(@Nullable String str) {
            this.scheme = str;
            return this;
        }

        @NotNull
        public final ActionLog build() {
            ActionLog actionLog = new ActionLog(this.type, this.path, this.subPath, this.from, this.target, this.scheme);
            return actionLog;
        }
    }

    public ActionLog() {
        this(null, null, null, null, null, null, 63, null);
    }

    @NotNull
    public static /* synthetic */ ActionLog copy$default(ActionLog actionLog, String str, String str2, String str3, Long l, Long l2, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = actionLog.type;
        }
        if ((i & 2) != 0) {
            str2 = actionLog.path;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            str3 = actionLog.subPath;
        }
        String str6 = str3;
        if ((i & 8) != 0) {
            l = actionLog.from;
        }
        Long l3 = l;
        if ((i & 16) != 0) {
            l2 = actionLog.target;
        }
        Long l4 = l2;
        if ((i & 32) != 0) {
            str4 = actionLog.scheme;
        }
        return actionLog.copy(str, str5, str6, l3, l4, str4);
    }

    @Nullable
    public final String component1() {
        return this.type;
    }

    @Nullable
    public final String component2() {
        return this.path;
    }

    @Nullable
    public final String component3() {
        return this.subPath;
    }

    @Nullable
    public final Long component4() {
        return this.from;
    }

    @Nullable
    public final Long component5() {
        return this.target;
    }

    @Nullable
    public final String component6() {
        return this.scheme;
    }

    @NotNull
    public final ActionLog copy(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Long l, @Nullable Long l2, @Nullable String str4) {
        ActionLog actionLog = new ActionLog(str, str2, str3, l, l2, str4);
        return actionLog;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0042, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2.scheme, (java.lang.Object) r3.scheme) != false) goto L_0x0047;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r3) {
        /*
            r2 = this;
            if (r2 == r3) goto L_0x0047
            boolean r0 = r3 instanceof kr.co.popone.fitts.model.datamodel.service.log.ActionLog
            if (r0 == 0) goto L_0x0045
            kr.co.popone.fitts.model.datamodel.service.log.ActionLog r3 = (kr.co.popone.fitts.model.datamodel.service.log.ActionLog) r3
            java.lang.String r0 = r2.type
            java.lang.String r1 = r3.type
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0045
            java.lang.String r0 = r2.path
            java.lang.String r1 = r3.path
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0045
            java.lang.String r0 = r2.subPath
            java.lang.String r1 = r3.subPath
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0045
            java.lang.Long r0 = r2.from
            java.lang.Long r1 = r3.from
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0045
            java.lang.Long r0 = r2.target
            java.lang.Long r1 = r3.target
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0045
            java.lang.String r0 = r2.scheme
            java.lang.String r3 = r3.scheme
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r3)
            if (r3 == 0) goto L_0x0045
            goto L_0x0047
        L_0x0045:
            r3 = 0
            return r3
        L_0x0047:
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.datamodel.service.log.ActionLog.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        String str = this.type;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.path;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.subPath;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Long l = this.from;
        int hashCode4 = (hashCode3 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.target;
        int hashCode5 = (hashCode4 + (l2 != null ? l2.hashCode() : 0)) * 31;
        String str4 = this.scheme;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode5 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ActionLog(type=");
        sb.append(this.type);
        sb.append(", path=");
        sb.append(this.path);
        sb.append(", subPath=");
        sb.append(this.subPath);
        sb.append(", from=");
        sb.append(this.from);
        sb.append(", target=");
        sb.append(this.target);
        sb.append(", scheme=");
        sb.append(this.scheme);
        sb.append(")");
        return sb.toString();
    }

    public ActionLog(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Long l, @Nullable Long l2, @Nullable String str4) {
        this.type = str;
        this.path = str2;
        this.subPath = str3;
        this.from = l;
        this.target = l2;
        this.scheme = str4;
    }

    @Nullable
    public final String getType() {
        return this.type;
    }

    @Nullable
    public final String getPath() {
        return this.path;
    }

    @Nullable
    public final String getSubPath() {
        return this.subPath;
    }

    @Nullable
    public final Long getFrom() {
        return this.from;
    }

    @Nullable
    public final Long getTarget() {
        return this.target;
    }

    public /* synthetic */ ActionLog(String str, String str2, String str3, Long l, Long l2, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        String str5 = (i & 1) != 0 ? null : str;
        this(str5, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : l, (i & 16) != 0 ? null : l2, (i & 32) != 0 ? null : str4);
    }

    @Nullable
    public final String getScheme() {
        return this.scheme;
    }
}
