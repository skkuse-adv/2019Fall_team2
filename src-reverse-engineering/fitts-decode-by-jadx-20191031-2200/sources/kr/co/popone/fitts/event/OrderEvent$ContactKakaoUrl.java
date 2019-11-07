package kr.co.popone.fitts.event;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class OrderEvent$ContactKakaoUrl {
    @NotNull
    private final String url;

    @NotNull
    public static /* synthetic */ OrderEvent$ContactKakaoUrl copy$default(OrderEvent$ContactKakaoUrl orderEvent$ContactKakaoUrl, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = orderEvent$ContactKakaoUrl.url;
        }
        return orderEvent$ContactKakaoUrl.copy(str);
    }

    @NotNull
    public final String component1() {
        return this.url;
    }

    @NotNull
    public final OrderEvent$ContactKakaoUrl copy(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "url");
        return new OrderEvent$ContactKakaoUrl(str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0010, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1.url, (java.lang.Object) ((kr.co.popone.fitts.event.OrderEvent$ContactKakaoUrl) r2).url) != false) goto L_0x0015;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r2) {
        /*
            r1 = this;
            if (r1 == r2) goto L_0x0015
            boolean r0 = r2 instanceof kr.co.popone.fitts.event.OrderEvent$ContactKakaoUrl
            if (r0 == 0) goto L_0x0013
            kr.co.popone.fitts.event.OrderEvent$ContactKakaoUrl r2 = (kr.co.popone.fitts.event.OrderEvent$ContactKakaoUrl) r2
            java.lang.String r0 = r1.url
            java.lang.String r2 = r2.url
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r2)
            if (r2 == 0) goto L_0x0013
            goto L_0x0015
        L_0x0013:
            r2 = 0
            return r2
        L_0x0015:
            r2 = 1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.event.OrderEvent$ContactKakaoUrl.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        String str = this.url;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ContactKakaoUrl(url=");
        sb.append(this.url);
        sb.append(")");
        return sb.toString();
    }

    public OrderEvent$ContactKakaoUrl(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "url");
        this.url = str;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }
}
