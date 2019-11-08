package kr.co.popone.fitts.feature.event;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

final class AppliableCollaborativeEventActivity$onCreate$3 extends Lambda implements Function2<Integer, Boolean, Unit> {
    final /* synthetic */ AppliableCollaborativeEventActivity this$0;

    AppliableCollaborativeEventActivity$onCreate$3(AppliableCollaborativeEventActivity appliableCollaborativeEventActivity) {
        this.this$0 = appliableCollaborativeEventActivity;
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke(((Number) obj).intValue(), ((Boolean) obj2).booleanValue());
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0029  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:21:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0019  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(int r7, boolean r8) {
        /*
            r6 = this;
            kr.co.popone.fitts.feature.event.AppliableCollaborativeEventActivity r0 = r6.this$0
            kr.co.popone.fitts.model.event.EventAPI$AppliableEventResponse r0 = r0.eventResponse
            r1 = 0
            if (r0 == 0) goto L_0x0016
            java.util.List r0 = r0.getTopItems()
            if (r0 == 0) goto L_0x0016
            java.lang.Object r7 = kotlin.collections.CollectionsKt___CollectionsKt.getOrNull(r0, r7)
            kr.co.popone.fitts.model.event.EventAPI$AppliableEventResponse$Item r7 = (kr.co.popone.fitts.model.event.EventAPI.AppliableEventResponse.Item) r7
            goto L_0x0017
        L_0x0016:
            r7 = r1
        L_0x0017:
            if (r7 == 0) goto L_0x0026
            java.util.List r7 = r7.getItems()
            if (r7 == 0) goto L_0x0026
            java.lang.Object r7 = kotlin.collections.CollectionsKt___CollectionsKt.getOrNull(r7, r8)
            kr.co.popone.fitts.model.event.EventAPI$TopImageItem r7 = (kr.co.popone.fitts.model.event.EventAPI.TopImageItem) r7
            goto L_0x0027
        L_0x0026:
            r7 = r1
        L_0x0027:
            if (r7 == 0) goto L_0x002d
            java.lang.String r1 = r7.getLinkUrl()
        L_0x002d:
            if (r1 == 0) goto L_0x0073
            kr.co.popone.fitts.model.datamodel.commerce.Shop r8 = r7.getShop()
            if (r8 == 0) goto L_0x0073
            kr.co.popone.fitts.feature.event.AppliableCollaborativeEventActivity r8 = r6.this$0
            r0 = 1
            kotlin.Pair[] r0 = new kotlin.Pair[r0]
            r1 = 0
            kr.co.popone.fitts.feature.event.EventShopWebActivity$Parameters r2 = new kr.co.popone.fitts.feature.event.EventShopWebActivity$Parameters
            kr.co.popone.fitts.model.event.EventAPI$AppliableEventResponse r3 = r8.eventResponse
            if (r3 != 0) goto L_0x0046
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0046:
            long r3 = r3.getId()
            java.lang.String r5 = r7.getLinkUrl()
            kr.co.popone.fitts.model.datamodel.commerce.Shop r7 = r7.getShop()
            r2.<init>(r3, r5, r7)
            java.lang.String r7 = "parameters"
            kotlin.Pair r7 = kotlin.TuplesKt.to(r7, r2)
            r0[r1] = r7
            java.lang.Class<kr.co.popone.fitts.feature.event.EventShopWebActivity> r7 = kr.co.popone.fitts.feature.event.EventShopWebActivity.class
            android.content.Intent r7 = org.jetbrains.anko.internals.AnkoInternals.createIntent(r8, r7, r0)
            r0 = 100
            r8.startActivityForResult(r7, r0)
            kr.co.popone.fitts.feature.event.AppliableCollaborativeEventActivity r7 = r6.this$0
            r8 = 2130771997(0x7f01001d, float:1.71471E38)
            r0 = 2130771988(0x7f010014, float:1.7147082E38)
            r7.overridePendingTransition(r8, r0)
        L_0x0073:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.feature.event.AppliableCollaborativeEventActivity$onCreate$3.invoke(int, boolean):void");
    }
}
