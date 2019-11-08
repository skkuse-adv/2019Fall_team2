package kr.co.popone.fitts.viewmodel.home.feed;

import android.app.Activity;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class HomeFeedViewModel$schemeFeedClick$1 extends Lambda implements Function1<Activity, Unit> {
    final /* synthetic */ String $scheme;
    final /* synthetic */ HomeFeedViewModel this$0;

    HomeFeedViewModel$schemeFeedClick$1(HomeFeedViewModel homeFeedViewModel, String str) {
        this.this$0 = homeFeedViewModel;
        this.$scheme = str;
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Activity) obj);
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0027, code lost:
        if (r0 != null) goto L_0x002c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(@org.jetbrains.annotations.NotNull android.app.Activity r3) {
        /*
            r2 = this;
            java.lang.String r0 = "activity"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r3, r0)
            kr.co.popone.fitts.viewmodel.home.feed.HomeFeedViewModel r0 = r2.this$0
            kr.co.popone.fitts.services.FittsSchemeHandler r0 = r0.schemeHandler
            java.lang.String r1 = r2.$scheme
            if (r1 == 0) goto L_0x0010
            goto L_0x0012
        L_0x0010:
            java.lang.String r1 = ""
        L_0x0012:
            r0.handleScheme(r3, r1)
            kr.co.popone.fitts.viewmodel.home.feed.HomeFeedViewModel r3 = r2.this$0
            kr.co.popone.fitts.eventtracker.EventTracker r3 = r3.eventTracker
            kr.co.popone.fitts.viewmodel.home.feed.HomeFeedViewModel r0 = r2.this$0
            kr.co.popone.fitts.viewmodel.home.feed.HomeFeedViewModel$FeedType r0 = r0.homeFeedType
            if (r0 == 0) goto L_0x002a
            java.lang.String r0 = r0.getType()
            if (r0 == 0) goto L_0x002a
            goto L_0x002c
        L_0x002a:
            java.lang.String r0 = "unknown"
        L_0x002c:
            r3.customLogTapHomeBanner(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.viewmodel.home.feed.HomeFeedViewModel$schemeFeedClick$1.invoke(android.app.Activity):void");
    }
}
