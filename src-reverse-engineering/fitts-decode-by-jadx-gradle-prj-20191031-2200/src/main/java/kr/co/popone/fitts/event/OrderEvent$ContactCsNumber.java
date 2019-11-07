package kr.co.popone.fitts.event;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class OrderEvent$ContactCsNumber {
    @NotNull
    private final String contact;

    @NotNull
    public static /* synthetic */ OrderEvent$ContactCsNumber copy$default(OrderEvent$ContactCsNumber orderEvent$ContactCsNumber, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = orderEvent$ContactCsNumber.contact;
        }
        return orderEvent$ContactCsNumber.copy(str);
    }

    @NotNull
    public final String component1() {
        return this.contact;
    }

    @NotNull
    public final OrderEvent$ContactCsNumber copy(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "contact");
        return new OrderEvent$ContactCsNumber(str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0010, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1.contact, (java.lang.Object) ((kr.co.popone.fitts.event.OrderEvent$ContactCsNumber) r2).contact) != false) goto L_0x0015;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r2) {
        /*
            r1 = this;
            if (r1 == r2) goto L_0x0015
            boolean r0 = r2 instanceof kr.co.popone.fitts.event.OrderEvent$ContactCsNumber
            if (r0 == 0) goto L_0x0013
            kr.co.popone.fitts.event.OrderEvent$ContactCsNumber r2 = (kr.co.popone.fitts.event.OrderEvent$ContactCsNumber) r2
            java.lang.String r0 = r1.contact
            java.lang.String r2 = r2.contact
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
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.event.OrderEvent$ContactCsNumber.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        String str = this.contact;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ContactCsNumber(contact=");
        sb.append(this.contact);
        sb.append(")");
        return sb.toString();
    }

    public OrderEvent$ContactCsNumber(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "contact");
        this.contact = str;
    }

    @NotNull
    public final String getContact() {
        return this.contact;
    }
}
