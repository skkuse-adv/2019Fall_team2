package kr.co.popone.fitts.feature.intro.join;

import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.model.user.UserAPI.Me;

final class JoinActivity$requestJoin$1<T> implements Consumer<Me> {
    final /* synthetic */ JoinActivity this$0;

    JoinActivity$requestJoin$1(JoinActivity joinActivity) {
        this.this$0 = joinActivity;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00f3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void accept(kr.co.popone.fitts.model.user.UserAPI.Me r8) {
        /*
            r7 = this;
            kr.co.popone.fitts.feature.intro.join.JoinActivity r0 = r7.this$0
            java.lang.String r0 = r0.getProvider()
            if (r0 != 0) goto L_0x0009
            goto L_0x002e
        L_0x0009:
            int r1 = r0.hashCode()
            r2 = 101812419(0x61188c3, float:2.7371946E-35)
            if (r1 == r2) goto L_0x0023
            r2 = 497130182(0x1da19ac6, float:4.2776377E-21)
            if (r1 == r2) goto L_0x0018
            goto L_0x002e
        L_0x0018:
            java.lang.String r1 = "facebook"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x002e
            kr.co.popone.fitts.eventtracker.EventTracker$SignUpMethod r0 = kr.co.popone.fitts.eventtracker.EventTracker.SignUpMethod.FACEBOOK
            goto L_0x0030
        L_0x0023:
            java.lang.String r1 = "kakao"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x002e
            kr.co.popone.fitts.eventtracker.EventTracker$SignUpMethod r0 = kr.co.popone.fitts.eventtracker.EventTracker.SignUpMethod.KAKAO
            goto L_0x0030
        L_0x002e:
            kr.co.popone.fitts.eventtracker.EventTracker$SignUpMethod r0 = kr.co.popone.fitts.eventtracker.EventTracker.SignUpMethod.EMAIL
        L_0x0030:
            r2 = r0
            kr.co.popone.fitts.feature.intro.join.JoinActivity r0 = r7.this$0
            kr.co.popone.fitts.eventtracker.EventTracker r1 = r0.getEventTracker$app_productionFittsRelease()
            kr.co.popone.fitts.feature.intro.join.JoinActivity r0 = r7.this$0
            int r3 = r0.age
            r4 = 0
            r5 = 4
            r6 = 0
            kr.co.popone.fitts.eventtracker.EventTracker.DefaultImpls.logSignUp$default(r1, r2, r3, r4, r5, r6)
            kr.co.popone.fitts.feature.intro.join.JoinActivity r0 = r7.this$0
            r1 = 0
            r0.createUserRequest = r1
            kr.co.popone.fitts.feature.intro.join.JoinActivity r0 = r7.this$0
            kr.co.popone.fitts.base.SessionManager r0 = r0.getSessionManager$app_productionFittsRelease()
            java.lang.String r1 = r8.getFittsid()
            java.lang.String r2 = r8.getAuth_token()
            long r3 = r8.getId()
            r0.successLogin(r1, r2, r3)
            kr.co.popone.fitts.feature.intro.join.JoinActivity r8 = r7.this$0
            kr.co.popone.fitts.base.SessionManager r8 = r8.getSessionManager$app_productionFittsRelease()
            r0 = 1
            r8.setFirstAppStart(r0)
            kr.co.popone.fitts.feature.intro.join.JoinActivity r8 = r7.this$0
            kr.co.popone.fitts.base.SessionManager r8 = r8.getSessionManager$app_productionFittsRelease()
            kr.co.popone.fitts.feature.intro.join.JoinActivity r1 = r7.this$0
            int r1 = r1.getHeight()
            r8.setHeight(r1)
            kr.co.popone.fitts.feature.intro.join.JoinActivity r8 = r7.this$0
            kr.co.popone.fitts.base.SessionManager r8 = r8.getSessionManager$app_productionFittsRelease()
            kr.co.popone.fitts.feature.intro.join.JoinActivity r1 = r7.this$0
            int r1 = r1.getWeight()
            r8.setWeight(r1)
            kr.co.popone.fitts.feature.intro.join.JoinActivity r8 = r7.this$0
            kr.co.popone.fitts.base.SessionManager r8 = r8.getSessionManager$app_productionFittsRelease()
            kr.co.popone.fitts.feature.intro.join.JoinActivity r1 = r7.this$0
            int r1 = r1.getHeight()
            int r1 = r1 + -2
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            kr.co.popone.fitts.feature.intro.join.JoinActivity r2 = r7.this$0
            int r2 = r2.getHeight()
            int r2 = r2 + 2
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            kr.co.popone.fitts.feature.intro.join.JoinActivity r3 = r7.this$0
            int r3 = r3.getWeight()
            int r3 = r3 + -2
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            kr.co.popone.fitts.feature.intro.join.JoinActivity r4 = r7.this$0
            int r4 = r4.getWeight()
            int r4 = r4 + 2
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r8.setSimilarityBodyFilter(r1, r2, r3, r4)
            kr.co.popone.fitts.feature.intro.join.JoinActivity r8 = r7.this$0
            java.lang.String r8 = r8.profileImage
            if (r8 == 0) goto L_0x00f3
            kr.co.popone.fitts.feature.intro.join.JoinActivity r8 = r7.this$0
            kr.co.popone.fitts.model.user.UserAPI r8 = r8.getUserAPI$app_productionFittsRelease()
            kr.co.popone.fitts.feature.intro.join.JoinActivity r0 = r7.this$0
            java.lang.String r0 = r0.profileImage
            if (r0 != 0) goto L_0x00d8
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x00d8:
            io.reactivex.Single r8 = r8.downloadSNSProfileImage(r0)
            io.reactivex.Scheduler r0 = io.reactivex.schedulers.Schedulers.io()
            io.reactivex.Single r8 = r8.subscribeOn(r0)
            kr.co.popone.fitts.feature.intro.join.JoinActivity$requestJoin$1$1 r0 = new kr.co.popone.fitts.feature.intro.join.JoinActivity$requestJoin$1$1
            r0.<init>(r7)
            io.reactivex.disposables.Disposable r8 = r8.subscribe(r0)
            java.lang.String r0 = "userAPI.downloadSNSProfi…                        }"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r8, r0)
            goto L_0x0132
        L_0x00f3:
            kr.co.popone.fitts.feature.intro.join.JoinActivity r8 = r7.this$0
            r1 = 2130771996(0x7f01001c, float:1.7147098E38)
            r2 = 2130771988(0x7f010014, float:1.7147082E38)
            androidx.core.app.ActivityOptionsCompat r8 = androidx.core.app.ActivityOptionsCompat.makeCustomAnimation(r8, r1, r2)
            java.lang.String r1 = "ActivityOptionsCompat.ma…e_right, R.anim.fade_out)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r8, r1)
            kr.co.popone.fitts.feature.intro.join.JoinActivity r1 = r7.this$0
            kotlin.Pair[] r2 = new kotlin.Pair[r0]
            r3 = 0
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            java.lang.String r4 = "new_user"
            kotlin.Pair r0 = kotlin.TuplesKt.to(r4, r0)
            r2[r3] = r0
            java.lang.Class<kr.co.popone.fitts.feature.main.MainActivity> r0 = kr.co.popone.fitts.feature.main.MainActivity.class
            android.content.Intent r0 = org.jetbrains.anko.internals.AnkoInternals.createIntent(r1, r0, r2)
            r2 = 32768(0x8000, float:4.5918E-41)
            r0.addFlags(r2)
            r2 = 268435456(0x10000000, float:2.5243549E-29)
            r0.addFlags(r2)
            r2 = 536870912(0x20000000, float:1.0842022E-19)
            r0.addFlags(r2)
            android.os.Bundle r8 = r8.toBundle()
            r1.startActivity(r0, r8)
        L_0x0132:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.feature.intro.join.JoinActivity$requestJoin$1.accept(kr.co.popone.fitts.model.user.UserAPI$Me):void");
    }
}
