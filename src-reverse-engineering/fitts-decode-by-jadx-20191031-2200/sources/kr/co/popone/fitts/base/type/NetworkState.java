package kr.co.popone.fitts.base.type;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class NetworkState {
    public static final Companion Companion = new Companion(null);
    /* access modifiers changed from: private */
    @NotNull
    public static final NetworkState INIT_LOADED = new NetworkState(Status.INIT_SUCCESS, null, 2, null);
    /* access modifiers changed from: private */
    @NotNull
    public static final NetworkState INIT_LOADING = new NetworkState(Status.INIT_RUNNING, null, 2, null);
    /* access modifiers changed from: private */
    @NotNull
    public static final NetworkState LOADED = new NetworkState(Status.SUCCESS, null, 2, null);
    /* access modifiers changed from: private */
    @NotNull
    public static final NetworkState LOADING = new NetworkState(Status.RUNNING, null, 2, null);
    @Nullable
    private final Throwable msg;
    @NotNull
    private final Status status;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final NetworkState getINIT_LOADED() {
            return NetworkState.INIT_LOADED;
        }

        @NotNull
        public final NetworkState getINIT_LOADING() {
            return NetworkState.INIT_LOADING;
        }

        @NotNull
        public final NetworkState getLOADED() {
            return NetworkState.LOADED;
        }

        @NotNull
        public final NetworkState getLOADING() {
            return NetworkState.LOADING;
        }

        @NotNull
        public final NetworkState error(@Nullable Throwable th) {
            return new NetworkState(Status.FAILED, th, null);
        }
    }

    @NotNull
    public static /* synthetic */ NetworkState copy$default(NetworkState networkState, Status status2, Throwable th, int i, Object obj) {
        if ((i & 1) != 0) {
            status2 = networkState.status;
        }
        if ((i & 2) != 0) {
            th = networkState.msg;
        }
        return networkState.copy(status2, th);
    }

    @NotNull
    public final Status component1() {
        return this.status;
    }

    @Nullable
    public final Throwable component2() {
        return this.msg;
    }

    @NotNull
    public final NetworkState copy(@NotNull Status status2, @Nullable Throwable th) {
        Intrinsics.checkParameterIsNotNull(status2, "status");
        return new NetworkState(status2, th);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001a, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2.msg, (java.lang.Object) r3.msg) != false) goto L_0x001f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r3) {
        /*
            r2 = this;
            if (r2 == r3) goto L_0x001f
            boolean r0 = r3 instanceof kr.co.popone.fitts.base.type.NetworkState
            if (r0 == 0) goto L_0x001d
            kr.co.popone.fitts.base.type.NetworkState r3 = (kr.co.popone.fitts.base.type.NetworkState) r3
            kr.co.popone.fitts.base.type.Status r0 = r2.status
            kr.co.popone.fitts.base.type.Status r1 = r3.status
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x001d
            java.lang.Throwable r0 = r2.msg
            java.lang.Throwable r3 = r3.msg
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
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.base.type.NetworkState.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        Status status2 = this.status;
        int i = 0;
        int hashCode = (status2 != null ? status2.hashCode() : 0) * 31;
        Throwable th = this.msg;
        if (th != null) {
            i = th.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("NetworkState(status=");
        sb.append(this.status);
        sb.append(", msg=");
        sb.append(this.msg);
        sb.append(")");
        return sb.toString();
    }

    private NetworkState(Status status2, Throwable th) {
        this.status = status2;
        this.msg = th;
    }

    public /* synthetic */ NetworkState(Status status2, Throwable th, DefaultConstructorMarker defaultConstructorMarker) {
        this(status2, th);
    }

    @NotNull
    public final Status getStatus() {
        return this.status;
    }

    /* synthetic */ NetworkState(Status status2, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 2) != 0) {
            th = null;
        }
        this(status2, th);
    }

    @Nullable
    public final Throwable getMsg() {
        return this.msg;
    }
}
