package kr.co.popone.fitts.event;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class FeedEvent$FeedSchemeEvent {
    @NotNull
    private final String scheme;
    @Nullable
    private final String title;

    @NotNull
    public static /* synthetic */ FeedEvent$FeedSchemeEvent copy$default(FeedEvent$FeedSchemeEvent feedEvent$FeedSchemeEvent, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = feedEvent$FeedSchemeEvent.scheme;
        }
        if ((i & 2) != 0) {
            str2 = feedEvent$FeedSchemeEvent.title;
        }
        return feedEvent$FeedSchemeEvent.copy(str, str2);
    }

    @NotNull
    public final String component1() {
        return this.scheme;
    }

    @Nullable
    public final String component2() {
        return this.title;
    }

    @NotNull
    public final FeedEvent$FeedSchemeEvent copy(@NotNull String str, @Nullable String str2) {
        Intrinsics.checkParameterIsNotNull(str, "scheme");
        return new FeedEvent$FeedSchemeEvent(str, str2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001a, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2.title, (java.lang.Object) r3.title) != false) goto L_0x001f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r3) {
        /*
            r2 = this;
            if (r2 == r3) goto L_0x001f
            boolean r0 = r3 instanceof kr.co.popone.fitts.event.FeedEvent$FeedSchemeEvent
            if (r0 == 0) goto L_0x001d
            kr.co.popone.fitts.event.FeedEvent$FeedSchemeEvent r3 = (kr.co.popone.fitts.event.FeedEvent$FeedSchemeEvent) r3
            java.lang.String r0 = r2.scheme
            java.lang.String r1 = r3.scheme
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x001d
            java.lang.String r0 = r2.title
            java.lang.String r3 = r3.title
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
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.event.FeedEvent$FeedSchemeEvent.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        String str = this.scheme;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.title;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FeedSchemeEvent(scheme=");
        sb.append(this.scheme);
        sb.append(", title=");
        sb.append(this.title);
        sb.append(")");
        return sb.toString();
    }

    public FeedEvent$FeedSchemeEvent(@NotNull String str, @Nullable String str2) {
        Intrinsics.checkParameterIsNotNull(str, "scheme");
        this.scheme = str;
        this.title = str2;
    }

    @NotNull
    public final String getScheme() {
        return this.scheme;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }
}
