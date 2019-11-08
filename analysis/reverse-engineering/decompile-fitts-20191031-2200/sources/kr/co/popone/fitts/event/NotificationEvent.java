package kr.co.popone.fitts.event;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class NotificationEvent {
    private final int badge;
    @NotNull
    private final String scheme;

    @NotNull
    public static /* synthetic */ NotificationEvent copy$default(NotificationEvent notificationEvent, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = notificationEvent.scheme;
        }
        if ((i2 & 2) != 0) {
            i = notificationEvent.badge;
        }
        return notificationEvent.copy(str, i);
    }

    @NotNull
    public final String component1() {
        return this.scheme;
    }

    public final int component2() {
        return this.badge;
    }

    @NotNull
    public final NotificationEvent copy(@NotNull String str, int i) {
        Intrinsics.checkParameterIsNotNull(str, "scheme");
        return new NotificationEvent(str, i);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof NotificationEvent) {
                NotificationEvent notificationEvent = (NotificationEvent) obj;
                if (Intrinsics.areEqual((Object) this.scheme, (Object) notificationEvent.scheme)) {
                    if (this.badge == notificationEvent.badge) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.scheme;
        return ((str != null ? str.hashCode() : 0) * 31) + this.badge;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("NotificationEvent(scheme=");
        sb.append(this.scheme);
        sb.append(", badge=");
        sb.append(this.badge);
        sb.append(")");
        return sb.toString();
    }

    public NotificationEvent(@NotNull String str, int i) {
        Intrinsics.checkParameterIsNotNull(str, "scheme");
        this.scheme = str;
        this.badge = i;
    }

    public final int getBadge() {
        return this.badge;
    }

    @NotNull
    public final String getScheme() {
        return this.scheme;
    }
}
