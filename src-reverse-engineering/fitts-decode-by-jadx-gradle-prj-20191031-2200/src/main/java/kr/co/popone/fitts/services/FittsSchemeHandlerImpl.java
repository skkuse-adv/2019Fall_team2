package kr.co.popone.fitts.services;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import androidx.core.app.ActivityOptionsCompat;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0001R$anim;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.feature.post.upload.create.CreatePostActivityUtil;
import kr.co.popone.fitts.feature.push.order.OrderRendingActivity;
import kr.co.popone.fitts.model.domain.push.PushRendingElement;
import kr.co.popone.fitts.model.domain.push.PushRendingState;
import kr.co.popone.fitts.model.repository.service.FittsServiceRepository;
import org.jetbrains.annotations.NotNull;

public final class FittsSchemeHandlerImpl implements FittsSchemeHandler {
    private final CreatePostActivityUtil createPostActivityUtil;
    private final EventTracker eventTracker;
    private final FittsServiceRepository serviceRepository;

    public FittsSchemeHandlerImpl(@NotNull EventTracker eventTracker2, @NotNull FittsServiceRepository fittsServiceRepository, @NotNull CreatePostActivityUtil createPostActivityUtil2) {
        Intrinsics.checkParameterIsNotNull(eventTracker2, "eventTracker");
        Intrinsics.checkParameterIsNotNull(fittsServiceRepository, "serviceRepository");
        Intrinsics.checkParameterIsNotNull(createPostActivityUtil2, "createPostActivityUtil");
        this.eventTracker = eventTracker2;
        this.serviceRepository = fittsServiceRepository;
        this.createPostActivityUtil = createPostActivityUtil2;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:19|20|21|22|23) */
    /* JADX WARNING: Code restructure failed: missing block: B:212:0x059d, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) kr.co.popone.fitts.model.domain.push.PushRendingState.ADMIN_CANCEL_PARTIAL_SELLER_FAULT.getType()) != false) goto L_0x059f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:228:0x05f7, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) kr.co.popone.fitts.model.domain.push.PushRendingState.ADMIN_CANCEL_ALL_SELLER_FAULT.getSubType()) != false) goto L_0x05f9;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0100 */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x0378 A[Catch:{ NumberFormatException -> 0x0a72 }] */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x037a A[Catch:{ NumberFormatException -> 0x0a72 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean handleScheme(@org.jetbrains.annotations.NotNull android.app.Activity r18, @org.jetbrains.annotations.NotNull java.lang.String r19) {
        /*
            r17 = this;
            r1 = r17
            r3 = r18
            r2 = r19
            java.lang.String r4 = "ActivityOptionsCompat.ma…e_right, R.anim.fade_out)"
            java.lang.String r5 = "paymentMethod"
            java.lang.String r6 = "activity"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r3, r6)
            java.lang.String r6 = "urlString"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r2, r6)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "handleScheme urlString("
            r6.append(r7)
            r6.append(r2)
            r7 = 41
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            r10 = 0
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r10)
            java.lang.Object[] r8 = new java.lang.Object[r10]
            com.orhanobut.logger.Logger.d(r6, r8)
            android.net.Uri r2 = android.net.Uri.parse(r19)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r8 = "uri urlString "
            r6.append(r8)
            java.lang.String r8 = "uri"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r8)
            java.lang.String r8 = r2.getScheme()
            r6.append(r8)
            java.lang.String r6 = r6.toString()
            java.lang.Object[] r8 = new java.lang.Object[r10]
            com.orhanobut.logger.Logger.d(r6, r8)
            java.lang.String r6 = r2.getScheme()
            java.lang.String r8 = "fitts"
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r8)
            r11 = 1
            r6 = r6 ^ r11
            if (r6 == 0) goto L_0x006d
            java.lang.Object[] r2 = new java.lang.Object[r10]
            java.lang.String r3 = "urlString is not 'fitts'"
            com.orhanobut.logger.Logger.d(r3, r2)
            return r10
        L_0x006d:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r8 = "handleScheme with uri("
            r6.append(r8)
            r6.append(r2)
            java.lang.String r8 = ")  host("
            r6.append(r8)
            java.lang.String r8 = r2.getHost()
            r6.append(r8)
            java.lang.String r8 = ")  path("
            r6.append(r8)
            java.lang.String r8 = r2.getPath()
            r6.append(r8)
            java.lang.String r8 = ") query ("
            r6.append(r8)
            java.lang.String r8 = r2.getQuery()
            r6.append(r8)
            java.lang.String r6 = r6.toString()
            java.lang.Object[] r8 = new java.lang.Object[r10]
            com.orhanobut.logger.Logger.d(r6, r8)
            boolean r6 = r18.isDestroyed()
            if (r6 == 0) goto L_0x00ae
            return r11
        L_0x00ae:
            r6 = 2130771996(0x7f01001c, float:1.7147098E38)
            r8 = 2130771988(0x7f010014, float:1.7147082E38)
            androidx.core.app.ActivityOptionsCompat r9 = androidx.core.app.ActivityOptionsCompat.makeCustomAnimation(r3, r6, r8)     // Catch:{ NumberFormatException -> 0x0a72 }
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r9, r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.String r12 = r2.getHost()     // Catch:{ NumberFormatException -> 0x0a72 }
            if (r12 != 0) goto L_0x00c3
            goto L_0x0a57
        L_0x00c3:
            int r13 = r12.hashCode()     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.String r14 = "android.intent.action.VIEW"
            java.lang.String r15 = "parameters"
            java.lang.String r10 = "id"
            java.lang.String r11 = "type"
            java.lang.String r6 = "uri.lastPathSegment"
            switch(r13) {
                case -1799664019: goto L_0x09ee;
                case -1741312354: goto L_0x08fb;
                case -1263202134: goto L_0x08cc;
                case -1153083511: goto L_0x08b1;
                case -1142309957: goto L_0x089f;
                case -814894119: goto L_0x086e;
                case -391201982: goto L_0x0855;
                case -337930920: goto L_0x081f;
                case -23179478: goto L_0x075e;
                case 114586: goto L_0x0731;
                case 3446944: goto L_0x06e5;
                case 31063705: goto L_0x06d2;
                case 109770977: goto L_0x0459;
                case 110625181: goto L_0x0420;
                case 609271333: goto L_0x040a;
                case 723966415: goto L_0x03e7;
                case 765915793: goto L_0x03b8;
                case 831011612: goto L_0x0329;
                case 964523591: goto L_0x0313;
                case 1233099618: goto L_0x02f7;
                case 1626301132: goto L_0x02b8;
                case 1658332386: goto L_0x0238;
                case 1690863790: goto L_0x0223;
                case 1691617632: goto L_0x01f5;
                case 1936174432: goto L_0x01e6;
                case 1960198957: goto L_0x0161;
                case 1976669278: goto L_0x0125;
                case 2036204036: goto L_0x00d6;
                default: goto L_0x00d4;
            }
        L_0x00d4:
            goto L_0x0a57
        L_0x00d6:
            java.lang.String r4 = "openPlatformStore"
            boolean r4 = r12.equals(r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            if (r4 == 0) goto L_0x0a57
            android.content.Intent r2 = new android.content.Intent     // Catch:{ ActivityNotFoundException -> 0x0100 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ ActivityNotFoundException -> 0x0100 }
            r4.<init>()     // Catch:{ ActivityNotFoundException -> 0x0100 }
            java.lang.String r5 = "market://details?id="
            r4.append(r5)     // Catch:{ ActivityNotFoundException -> 0x0100 }
            java.lang.String r5 = r18.getPackageName()     // Catch:{ ActivityNotFoundException -> 0x0100 }
            r4.append(r5)     // Catch:{ ActivityNotFoundException -> 0x0100 }
            java.lang.String r4 = r4.toString()     // Catch:{ ActivityNotFoundException -> 0x0100 }
            android.net.Uri r4 = android.net.Uri.parse(r4)     // Catch:{ ActivityNotFoundException -> 0x0100 }
            r2.<init>(r14, r4)     // Catch:{ ActivityNotFoundException -> 0x0100 }
            r3.startActivity(r2)     // Catch:{ ActivityNotFoundException -> 0x0100 }
            goto L_0x0121
        L_0x0100:
            android.content.Intent r2 = new android.content.Intent     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x0a72 }
            r4.<init>()     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.String r5 = "https://play.google.com/store/apps/details?id="
            r4.append(r5)     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.String r5 = r18.getPackageName()     // Catch:{ NumberFormatException -> 0x0a72 }
            r4.append(r5)     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.String r4 = r4.toString()     // Catch:{ NumberFormatException -> 0x0a72 }
            android.net.Uri r4 = android.net.Uri.parse(r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            r2.<init>(r14, r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            r3.startActivity(r2)     // Catch:{ NumberFormatException -> 0x0a72 }
        L_0x0121:
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ NumberFormatException -> 0x0a72 }
            goto L_0x086b
        L_0x0125:
            java.lang.String r4 = "openSocialService"
            boolean r4 = r12.equals(r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            if (r4 == 0) goto L_0x0a57
            java.lang.String r4 = "name"
            java.lang.String r2 = r2.getQueryParameter(r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            if (r2 != 0) goto L_0x0137
            goto L_0x086b
        L_0x0137:
            int r4 = r2.hashCode()     // Catch:{ NumberFormatException -> 0x0a72 }
            r5 = 28903346(0x1b907b2, float:6.796931E-38)
            if (r4 == r5) goto L_0x0154
            r5 = 497130182(0x1da19ac6, float:4.2776377E-21)
            if (r4 == r5) goto L_0x0147
            goto L_0x086b
        L_0x0147:
            java.lang.String r4 = "facebook"
            boolean r2 = r2.equals(r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            if (r2 == 0) goto L_0x086b
            r17.startFittsFacebook(r18)     // Catch:{ NumberFormatException -> 0x0a72 }
            goto L_0x086b
        L_0x0154:
            java.lang.String r4 = "instagram"
            boolean r2 = r2.equals(r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            if (r2 == 0) goto L_0x086b
            r17.startFittsInstagram(r18)     // Catch:{ NumberFormatException -> 0x0a72 }
            goto L_0x086b
        L_0x0161:
            java.lang.String r5 = "invoice"
            boolean r5 = r12.equals(r5)     // Catch:{ NumberFormatException -> 0x0a72 }
            if (r5 == 0) goto L_0x0a57
            java.lang.String r5 = r2.getLastPathSegment()     // Catch:{ NumberFormatException -> 0x0a72 }
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r5, r6)     // Catch:{ NumberFormatException -> 0x0a72 }
            long r5 = java.lang.Long.parseLong(r5)     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.String r7 = "payment_type"
            java.lang.String r2 = r2.getQueryParameter(r7)     // Catch:{ NumberFormatException -> 0x0a72 }
            if (r2 == 0) goto L_0x0407
            java.lang.String r7 = "reward"
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r7)     // Catch:{ NumberFormatException -> 0x0a72 }
            if (r7 == 0) goto L_0x01b3
            kr.co.popone.fitts.utils.ActivityAnimationType r2 = kr.co.popone.fitts.utils.ActivityAnimationType.SLIDE_UP     // Catch:{ NumberFormatException -> 0x0a72 }
            int r2 = r2.getEnter()     // Catch:{ NumberFormatException -> 0x0a72 }
            kr.co.popone.fitts.utils.ActivityAnimationType r4 = kr.co.popone.fitts.utils.ActivityAnimationType.SLIDE_UP     // Catch:{ NumberFormatException -> 0x0a72 }
            int r4 = r4.getExit()     // Catch:{ NumberFormatException -> 0x0a72 }
            androidx.core.app.ActivityOptionsCompat r2 = androidx.core.app.ActivityOptionsCompat.makeCustomAnimation(r3, r2, r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.String r4 = "ActivityOptionsCompat.ma…mationType.SLIDE_UP.exit)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            android.content.Intent r4 = new android.content.Intent     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.Class<kr.co.popone.fitts.feature.reward.RewardUsageDetailActivity> r7 = kr.co.popone.fitts.feature.reward.RewardUsageDetailActivity.class
            r4.<init>(r3, r7)     // Catch:{ NumberFormatException -> 0x0a72 }
            kr.co.popone.fitts.feature.reward.RewardUsageDetailActivity$Parameters r7 = new kr.co.popone.fitts.feature.reward.RewardUsageDetailActivity$Parameters     // Catch:{ NumberFormatException -> 0x0a72 }
            r7.<init>(r5)     // Catch:{ NumberFormatException -> 0x0a72 }
            r4.putExtra(r15, r7)     // Catch:{ NumberFormatException -> 0x0a72 }
            r5 = 101(0x65, float:1.42E-43)
            android.os.Bundle r2 = r2.toBundle()     // Catch:{ NumberFormatException -> 0x0a72 }
            r3.startActivityForResult(r4, r5, r2)     // Catch:{ NumberFormatException -> 0x0a72 }
            goto L_0x086b
        L_0x01b3:
            java.lang.String r7 = "coupon"
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r7)     // Catch:{ NumberFormatException -> 0x0a72 }
            if (r2 == 0) goto L_0x01e0
            r2 = 2130771996(0x7f01001c, float:1.7147098E38)
            androidx.core.app.ActivityOptionsCompat r2 = androidx.core.app.ActivityOptionsCompat.makeCustomAnimation(r3, r2, r8)     // Catch:{ NumberFormatException -> 0x0a72 }
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            android.content.Intent r4 = new android.content.Intent     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.Class<kr.co.popone.fitts.feature.coupon.CouponUsageDetailActivity> r7 = kr.co.popone.fitts.feature.coupon.CouponUsageDetailActivity.class
            r4.<init>(r3, r7)     // Catch:{ NumberFormatException -> 0x0a72 }
            kr.co.popone.fitts.feature.coupon.CouponUsageDetailActivity$Parameters r7 = new kr.co.popone.fitts.feature.coupon.CouponUsageDetailActivity$Parameters     // Catch:{ NumberFormatException -> 0x0a72 }
            r7.<init>(r5)     // Catch:{ NumberFormatException -> 0x0a72 }
            r4.putExtra(r15, r7)     // Catch:{ NumberFormatException -> 0x0a72 }
            r5 = 101(0x65, float:1.42E-43)
            android.os.Bundle r2 = r2.toBundle()     // Catch:{ NumberFormatException -> 0x0a72 }
            r3.startActivityForResult(r4, r5, r2)     // Catch:{ NumberFormatException -> 0x0a72 }
            r16 = 1
            goto L_0x01e2
        L_0x01e0:
            r16 = 0
        L_0x01e2:
            r10 = r16
            goto L_0x0a70
        L_0x01e6:
            java.lang.String r4 = "fittscard"
            boolean r4 = r12.equals(r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            if (r4 == 0) goto L_0x0a57
            kr.co.popone.fitts.feature.card.FittsCardRendingActivity$Companion r2 = kr.co.popone.fitts.feature.card.FittsCardRendingActivity.Companion     // Catch:{ NumberFormatException -> 0x0a72 }
            r2.start(r3)     // Catch:{ NumberFormatException -> 0x0a72 }
            goto L_0x086b
        L_0x01f5:
            java.lang.String r4 = "storeHome"
            boolean r4 = r12.equals(r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            if (r4 == 0) goto L_0x0a57
            java.lang.String r4 = "tabName"
            java.lang.String r2 = r2.getQueryParameter(r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            r4 = 1
            kotlin.Pair[] r5 = new kotlin.Pair[r4]     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.String r4 = "move_tab_store"
            if (r2 != 0) goto L_0x020c
            java.lang.String r2 = "home"
        L_0x020c:
            kotlin.Pair r2 = kotlin.TuplesKt.to(r4, r2)     // Catch:{ NumberFormatException -> 0x0a72 }
            r4 = 0
            r5[r4] = r2     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.Class<kr.co.popone.fitts.feature.main.MainActivity> r2 = kr.co.popone.fitts.feature.main.MainActivity.class
            android.content.Intent r2 = org.jetbrains.anko.internals.AnkoInternals.createIntent(r3, r2, r5)     // Catch:{ NumberFormatException -> 0x0a72 }
            r4 = 67108864(0x4000000, float:1.5046328E-36)
            r2.addFlags(r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            r3.startActivity(r2)     // Catch:{ NumberFormatException -> 0x0a72 }
            goto L_0x086b
        L_0x0223:
            java.lang.String r4 = "rewardHome"
            boolean r4 = r12.equals(r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            if (r4 == 0) goto L_0x0a57
            java.lang.String r4 = "tabName"
            java.lang.String r2 = r2.getQueryParameter(r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            kr.co.popone.fitts.feature.ncommerce.NCommerceActivity$Companion r4 = kr.co.popone.fitts.feature.ncommerce.NCommerceActivity.Companion     // Catch:{ NumberFormatException -> 0x0a72 }
            r4.start(r3, r2)     // Catch:{ NumberFormatException -> 0x0a72 }
            goto L_0x086b
        L_0x0238:
            java.lang.String r4 = "userInvoice"
            boolean r4 = r12.equals(r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            if (r4 == 0) goto L_0x0a57
            java.lang.String r4 = r2.getLastPathSegment()     // Catch:{ NumberFormatException -> 0x0a72 }
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r4, r6)     // Catch:{ NumberFormatException -> 0x0a72 }
            long r4 = java.lang.Long.parseLong(r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.String r6 = "action"
            java.lang.String r6 = r2.getQueryParameter(r6)     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.String r2 = r2.getQueryParameter(r11)     // Catch:{ NumberFormatException -> 0x0a72 }
            if (r6 != 0) goto L_0x0259
            goto L_0x0407
        L_0x0259:
            int r7 = r6.hashCode()     // Catch:{ NumberFormatException -> 0x0a72 }
            r8 = -551058253(0xffffffffdf2784b3, float:-1.207097E19)
            if (r7 == r8) goto L_0x0264
            goto L_0x0407
        L_0x0264:
            java.lang.String r7 = "first_posting"
            boolean r6 = r6.equals(r7)     // Catch:{ NumberFormatException -> 0x0a72 }
            if (r6 == 0) goto L_0x0407
            if (r2 != 0) goto L_0x0270
            goto L_0x0407
        L_0x0270:
            int r6 = r2.hashCode()     // Catch:{ NumberFormatException -> 0x0a72 }
            r7 = -1994383672(0xffffffff89201ec8, float:-1.9273773E-33)
            if (r6 == r7) goto L_0x02a2
            r7 = -608496514(0xffffffffdbbb147e, float:-1.05316704E17)
            if (r6 == r7) goto L_0x0280
            goto L_0x0407
        L_0x0280:
            java.lang.String r6 = "rejected"
            boolean r2 = r2.equals(r6)     // Catch:{ NumberFormatException -> 0x0a72 }
            if (r2 == 0) goto L_0x0407
            r2 = 1
            kotlin.Pair[] r6 = new kotlin.Pair[r2]     // Catch:{ NumberFormatException -> 0x0a72 }
            kr.co.popone.fitts.feature.post.PostVerificationRejectNoticeActivity$Parameters r2 = new kr.co.popone.fitts.feature.post.PostVerificationRejectNoticeActivity$Parameters     // Catch:{ NumberFormatException -> 0x0a72 }
            r2.<init>(r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            kotlin.Pair r2 = kotlin.TuplesKt.to(r15, r2)     // Catch:{ NumberFormatException -> 0x0a72 }
            r4 = 0
            r6[r4] = r2     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.Class<kr.co.popone.fitts.feature.post.PostVerificationRejectNoticeActivity> r2 = kr.co.popone.fitts.feature.post.PostVerificationRejectNoticeActivity.class
            android.content.Intent r2 = org.jetbrains.anko.internals.AnkoInternals.createIntent(r3, r2, r6)     // Catch:{ NumberFormatException -> 0x0a72 }
            r3.startActivity(r2)     // Catch:{ NumberFormatException -> 0x0a72 }
            goto L_0x086b
        L_0x02a2:
            java.lang.String r4 = "verified"
            boolean r2 = r2.equals(r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            if (r2 == 0) goto L_0x0407
            r2 = 0
            kotlin.Pair[] r4 = new kotlin.Pair[r2]     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.Class<kr.co.popone.fitts.feature.post.PostVerificationFinishNoticeActivity> r2 = kr.co.popone.fitts.feature.post.PostVerificationFinishNoticeActivity.class
            android.content.Intent r2 = org.jetbrains.anko.internals.AnkoInternals.createIntent(r3, r2, r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            r3.startActivity(r2)     // Catch:{ NumberFormatException -> 0x0a72 }
            goto L_0x086b
        L_0x02b8:
            java.lang.String r4 = "personalizedRecommend"
            boolean r4 = r12.equals(r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            if (r4 == 0) goto L_0x0a57
            java.lang.String r4 = "handle personalizedRecommend urlString"
            r5 = 0
            java.lang.Object[] r7 = new java.lang.Object[r5]     // Catch:{ NumberFormatException -> 0x0a72 }
            com.orhanobut.logger.Logger.d(r4, r7)     // Catch:{ NumberFormatException -> 0x0a72 }
            r4 = 2130771997(0x7f01001d, float:1.71471E38)
            androidx.core.app.ActivityOptionsCompat r4 = androidx.core.app.ActivityOptionsCompat.makeCustomAnimation(r3, r4, r8)     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.String r5 = "ActivityOptionsCompat.ma…lide_up, R.anim.fade_out)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r4, r5)     // Catch:{ NumberFormatException -> 0x0a72 }
            android.content.Intent r5 = new android.content.Intent     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.Class<kr.co.popone.fitts.feature.recommend.personalization.PersonalizedRecommendActivity> r7 = kr.co.popone.fitts.feature.recommend.personalization.PersonalizedRecommendActivity.class
            r5.<init>(r3, r7)     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.String r2 = r2.getLastPathSegment()     // Catch:{ NumberFormatException -> 0x0a72 }
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r6)     // Catch:{ NumberFormatException -> 0x0a72 }
            int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ NumberFormatException -> 0x0a72 }
            kr.co.popone.fitts.feature.recommend.personalization.PersonalizedRecommendActivity$Parameters r6 = new kr.co.popone.fitts.feature.recommend.personalization.PersonalizedRecommendActivity$Parameters     // Catch:{ NumberFormatException -> 0x0a72 }
            r6.<init>(r2)     // Catch:{ NumberFormatException -> 0x0a72 }
            r5.putExtra(r15, r6)     // Catch:{ NumberFormatException -> 0x0a72 }
            android.os.Bundle r2 = r4.toBundle()     // Catch:{ NumberFormatException -> 0x0a72 }
            r3.startActivity(r5, r2)     // Catch:{ NumberFormatException -> 0x0a72 }
            goto L_0x086b
        L_0x02f7:
            java.lang.String r4 = "welcome"
            boolean r4 = r12.equals(r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            if (r4 == 0) goto L_0x0a57
            r2 = 0
            kotlin.Pair[] r4 = new kotlin.Pair[r2]     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.Class<kr.co.popone.fitts.feature.home.WelcomeActivity> r2 = kr.co.popone.fitts.feature.home.WelcomeActivity.class
            android.content.Intent r2 = org.jetbrains.anko.internals.AnkoInternals.createIntent(r3, r2, r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            r3.startActivity(r2)     // Catch:{ NumberFormatException -> 0x0a72 }
            r2 = 2130771997(0x7f01001d, float:1.71471E38)
            r3.overridePendingTransition(r2, r8)     // Catch:{ NumberFormatException -> 0x0a72 }
            goto L_0x086b
        L_0x0313:
            java.lang.String r4 = "paymentInvoice"
            boolean r4 = r12.equals(r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            if (r4 == 0) goto L_0x0a57
            android.content.Intent r2 = new android.content.Intent     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.Class<kr.co.popone.fitts.feature.reward.RewardPointUseActivity> r4 = kr.co.popone.fitts.feature.reward.RewardPointUseActivity.class
            r2.<init>(r3, r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            kr.co.popone.fitts.utils.ActivityAnimationType r4 = kr.co.popone.fitts.utils.ActivityAnimationType.SLIDE_UP     // Catch:{ NumberFormatException -> 0x0a72 }
            kr.co.popone.fitts.base.extension.ContextExtensionKt.activityStart(r3, r2, r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            goto L_0x086b
        L_0x0329:
            java.lang.String r4 = "mainTab"
            boolean r4 = r12.equals(r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            if (r4 == 0) goto L_0x0a57
            java.lang.String r2 = r2.getLastPathSegment()     // Catch:{ NumberFormatException -> 0x0a72 }
            if (r2 != 0) goto L_0x0338
            goto L_0x0375
        L_0x0338:
            int r4 = r2.hashCode()     // Catch:{ NumberFormatException -> 0x0a72 }
            r5 = -1039690024(0xffffffffc20796d8, float:-33.89731)
            if (r4 == r5) goto L_0x036b
            r5 = 3500(0xdac, float:4.905E-42)
            if (r4 == r5) goto L_0x0361
            r5 = 3138974(0x2fe59e, float:4.39864E-39)
            if (r4 == r5) goto L_0x035a
            r5 = 109770977(0x68af8e1, float:5.2275525E-35)
            if (r4 == r5) goto L_0x0350
            goto L_0x0375
        L_0x0350:
            java.lang.String r4 = "store"
            boolean r2 = r2.equals(r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            if (r2 == 0) goto L_0x0375
            r2 = 1
            goto L_0x0376
        L_0x035a:
            java.lang.String r4 = "feed"
            boolean r2 = r2.equals(r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            goto L_0x0375
        L_0x0361:
            java.lang.String r4 = "my"
            boolean r2 = r2.equals(r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            if (r2 == 0) goto L_0x0375
            r2 = 3
            goto L_0x0376
        L_0x036b:
            java.lang.String r4 = "notice"
            boolean r2 = r2.equals(r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            if (r2 == 0) goto L_0x0375
            r2 = 2
            goto L_0x0376
        L_0x0375:
            r2 = 0
        L_0x0376:
            if (r2 >= 0) goto L_0x037a
            goto L_0x0407
        L_0x037a:
            r4 = 3
            if (r4 < r2) goto L_0x0407
            r4 = 4
            kotlin.Pair[] r4 = new kotlin.Pair[r4]     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.String r5 = "review_dialog"
            kotlin.Pair r5 = kotlin.TuplesKt.to(r5, r7)     // Catch:{ NumberFormatException -> 0x0a72 }
            r6 = 0
            r4[r6] = r5     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.String r5 = "show_recent"
            kotlin.Pair r5 = kotlin.TuplesKt.to(r5, r7)     // Catch:{ NumberFormatException -> 0x0a72 }
            r6 = 1
            r4[r6] = r5     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.String r5 = "show_promotion_dialog"
            kotlin.Pair r5 = kotlin.TuplesKt.to(r5, r7)     // Catch:{ NumberFormatException -> 0x0a72 }
            r6 = 2
            r4[r6] = r5     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.String r5 = "goto_tab"
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ NumberFormatException -> 0x0a72 }
            kotlin.Pair r2 = kotlin.TuplesKt.to(r5, r2)     // Catch:{ NumberFormatException -> 0x0a72 }
            r5 = 3
            r4[r5] = r2     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.Class<kr.co.popone.fitts.feature.main.MainActivity> r2 = kr.co.popone.fitts.feature.main.MainActivity.class
            android.content.Intent r2 = org.jetbrains.anko.internals.AnkoInternals.createIntent(r3, r2, r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            r4 = 67108864(0x4000000, float:1.5046328E-36)
            r2.addFlags(r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            r3.startActivity(r2)     // Catch:{ NumberFormatException -> 0x0a72 }
            goto L_0x086b
        L_0x03b8:
            java.lang.String r4 = "following"
            boolean r4 = r12.equals(r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            if (r4 == 0) goto L_0x0a57
            java.lang.String r2 = r2.getLastPathSegment()     // Catch:{ NumberFormatException -> 0x0a72 }
            if (r2 != 0) goto L_0x03c7
            goto L_0x0407
        L_0x03c7:
            int r4 = r2.hashCode()     // Catch:{ NumberFormatException -> 0x0a72 }
            r5 = 106855379(0x65e7bd3, float:4.184453E-35)
            if (r4 == r5) goto L_0x03d1
            goto L_0x0407
        L_0x03d1:
            java.lang.String r4 = "posts"
            boolean r2 = r2.equals(r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            if (r2 == 0) goto L_0x0407
            android.content.Intent r2 = new android.content.Intent     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.Class<kr.co.popone.fitts.feature.post.follow.FollowingPostActivity> r4 = kr.co.popone.fitts.feature.post.follow.FollowingPostActivity.class
            r2.<init>(r3, r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            kr.co.popone.fitts.utils.ActivityAnimationType r4 = kr.co.popone.fitts.utils.ActivityAnimationType.SLIDE_RTOL     // Catch:{ NumberFormatException -> 0x0a72 }
            kr.co.popone.fitts.base.extension.ContextExtensionKt.activityStart(r3, r2, r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            goto L_0x086b
        L_0x03e7:
            java.lang.String r4 = "openProductWeb"
            boolean r4 = r12.equals(r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            if (r4 == 0) goto L_0x0a57
            java.lang.String r4 = "url"
            java.lang.String r4 = r2.getQueryParameter(r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            if (r4 == 0) goto L_0x0407
            kr.co.popone.fitts.feature.store.browser.StoreBrowserActivity$Companion r2 = kr.co.popone.fitts.feature.store.browser.StoreBrowserActivity.Companion     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.String r5 = "scheme"
            r6 = 0
            r7 = 0
            r8 = 24
            r9 = 0
            r3 = r18
            kr.co.popone.fitts.feature.store.browser.StoreBrowserActivity.Companion.start$default(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ NumberFormatException -> 0x0a72 }
            goto L_0x086b
        L_0x0407:
            r10 = 0
            goto L_0x0a70
        L_0x040a:
            java.lang.String r4 = "couponHome"
            boolean r4 = r12.equals(r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            if (r4 == 0) goto L_0x0a57
            android.content.Intent r2 = new android.content.Intent     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.Class<kr.co.popone.fitts.feature.coupon.CouponHomeActivity> r4 = kr.co.popone.fitts.feature.coupon.CouponHomeActivity.class
            r2.<init>(r3, r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            kr.co.popone.fitts.utils.ActivityAnimationType r4 = kr.co.popone.fitts.utils.ActivityAnimationType.SLIDE_RTOL     // Catch:{ NumberFormatException -> 0x0a72 }
            kr.co.popone.fitts.base.extension.ContextExtensionKt.activityStart(r3, r2, r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            goto L_0x086b
        L_0x0420:
            java.lang.String r4 = "trend"
            boolean r4 = r12.equals(r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            if (r4 == 0) goto L_0x0a57
            kr.co.popone.fitts.feature.trend.TrendFeedActivity$Companion r4 = kr.co.popone.fitts.feature.trend.TrendFeedActivity.Companion     // Catch:{ Exception -> 0x043e }
            java.lang.String r5 = r2.getLastPathSegment()     // Catch:{ Exception -> 0x043e }
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r5, r6)     // Catch:{ Exception -> 0x043e }
            long r5 = java.lang.Long.parseLong(r5)     // Catch:{ Exception -> 0x043e }
            java.lang.String r2 = r2.getQueryParameter(r11)     // Catch:{ Exception -> 0x043e }
            r4.start(r3, r5, r2)     // Catch:{ Exception -> 0x043e }
            goto L_0x086b
        L_0x043e:
            r0 = move-exception
            r2 = r0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x0a72 }
            r3.<init>()     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.String r4 = "TrendScheme::"
            r3.append(r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            r3.append(r2)     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.String r2 = r3.toString()     // Catch:{ NumberFormatException -> 0x0a72 }
            r3 = 0
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ NumberFormatException -> 0x0a72 }
            com.orhanobut.logger.Logger.d(r2, r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            goto L_0x086b
        L_0x0459:
            java.lang.String r4 = "store"
            boolean r4 = r12.equals(r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            if (r4 == 0) goto L_0x0a57
            java.util.List r4 = r2.getPathSegments()     // Catch:{ NumberFormatException -> 0x0a72 }
            r6 = 0
            java.lang.Object r7 = r4.get(r6)     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ NumberFormatException -> 0x0a72 }
            if (r7 != 0) goto L_0x0470
            goto L_0x086b
        L_0x0470:
            int r6 = r7.hashCode()     // Catch:{ NumberFormatException -> 0x0a72 }
            switch(r6) {
                case -1623270881: goto L_0x06b3;
                case 3046176: goto L_0x06a2;
                case 1009992752: goto L_0x063a;
                case 1187338559: goto L_0x0617;
                case 1482872774: goto L_0x0479;
                default: goto L_0x0477;
            }     // Catch:{ NumberFormatException -> 0x0a72 }
        L_0x0477:
            goto L_0x086b
        L_0x0479:
            java.lang.String r4 = "orderNotice"
            boolean r4 = r7.equals(r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            if (r4 == 0) goto L_0x086b
            java.lang.String r4 = r2.getQueryParameter(r11)     // Catch:{ NumberFormatException -> 0x0a72 }
            kr.co.popone.fitts.model.domain.push.PushRendingState r5 = kr.co.popone.fitts.model.domain.push.PushRendingState.RESERVATION_COMPLETE     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.String r5 = r5.getType()     // Catch:{ NumberFormatException -> 0x0a72 }
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r5)     // Catch:{ NumberFormatException -> 0x0a72 }
            if (r5 == 0) goto L_0x0498
            kr.co.popone.fitts.model.domain.push.PushRendingState r4 = kr.co.popone.fitts.model.domain.push.PushRendingState.RESERVATION_COMPLETE     // Catch:{ NumberFormatException -> 0x0a72 }
            r1.startOrderRendingActivity(r3, r2, r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            goto L_0x086b
        L_0x0498:
            kr.co.popone.fitts.model.domain.push.PushRendingState r5 = kr.co.popone.fitts.model.domain.push.PushRendingState.PAYMENT_PRESS     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.String r5 = r5.getType()     // Catch:{ NumberFormatException -> 0x0a72 }
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r5)     // Catch:{ NumberFormatException -> 0x0a72 }
            if (r5 == 0) goto L_0x04ab
            kr.co.popone.fitts.model.domain.push.PushRendingState r4 = kr.co.popone.fitts.model.domain.push.PushRendingState.PAYMENT_PRESS     // Catch:{ NumberFormatException -> 0x0a72 }
            r1.startOrderRendingActivity(r3, r2, r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            goto L_0x086b
        L_0x04ab:
            kr.co.popone.fitts.model.domain.push.PushRendingState r5 = kr.co.popone.fitts.model.domain.push.PushRendingState.RESERVATION_CANCEL_MISPRICE     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.String r5 = r5.getType()     // Catch:{ NumberFormatException -> 0x0a72 }
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r5)     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.String r6 = "subtype"
            if (r5 == 0) goto L_0x04ba
            goto L_0x04c6
        L_0x04ba:
            kr.co.popone.fitts.model.domain.push.PushRendingState r5 = kr.co.popone.fitts.model.domain.push.PushRendingState.RESERVATION_CANCEL_SOLD_OUT     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.String r5 = r5.getType()     // Catch:{ NumberFormatException -> 0x0a72 }
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r5)     // Catch:{ NumberFormatException -> 0x0a72 }
            if (r5 == 0) goto L_0x04f0
        L_0x04c6:
            java.lang.String r4 = r2.getQueryParameter(r6)     // Catch:{ NumberFormatException -> 0x0a72 }
            kr.co.popone.fitts.model.domain.push.PushRendingState r5 = kr.co.popone.fitts.model.domain.push.PushRendingState.RESERVATION_CANCEL_MISPRICE     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.String r5 = r5.getSubType()     // Catch:{ NumberFormatException -> 0x0a72 }
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r5)     // Catch:{ NumberFormatException -> 0x0a72 }
            if (r5 == 0) goto L_0x04dd
            kr.co.popone.fitts.model.domain.push.PushRendingState r4 = kr.co.popone.fitts.model.domain.push.PushRendingState.RESERVATION_CANCEL_MISPRICE     // Catch:{ NumberFormatException -> 0x0a72 }
            r1.startOrderRendingActivity(r3, r2, r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            goto L_0x086b
        L_0x04dd:
            kr.co.popone.fitts.model.domain.push.PushRendingState r5 = kr.co.popone.fitts.model.domain.push.PushRendingState.RESERVATION_CANCEL_SOLD_OUT     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.String r5 = r5.getSubType()     // Catch:{ NumberFormatException -> 0x0a72 }
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r5)     // Catch:{ NumberFormatException -> 0x0a72 }
            if (r4 == 0) goto L_0x086b
            kr.co.popone.fitts.model.domain.push.PushRendingState r4 = kr.co.popone.fitts.model.domain.push.PushRendingState.RESERVATION_CANCEL_SOLD_OUT     // Catch:{ NumberFormatException -> 0x0a72 }
            r1.startOrderRendingActivity(r3, r2, r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            goto L_0x086b
        L_0x04f0:
            kr.co.popone.fitts.model.domain.push.PushRendingState r5 = kr.co.popone.fitts.model.domain.push.PushRendingState.PAYMENT_COMPLETE     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.String r5 = r5.getType()     // Catch:{ NumberFormatException -> 0x0a72 }
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r5)     // Catch:{ NumberFormatException -> 0x0a72 }
            if (r5 == 0) goto L_0x0503
            kr.co.popone.fitts.model.domain.push.PushRendingState r4 = kr.co.popone.fitts.model.domain.push.PushRendingState.PAYMENT_COMPLETE     // Catch:{ NumberFormatException -> 0x0a72 }
            r1.startOrderRendingActivity(r3, r2, r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            goto L_0x086b
        L_0x0503:
            kr.co.popone.fitts.model.domain.push.PushRendingState r5 = kr.co.popone.fitts.model.domain.push.PushRendingState.PAYMENT_CANCEL_MISPRICE     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.String r5 = r5.getType()     // Catch:{ NumberFormatException -> 0x0a72 }
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r5)     // Catch:{ NumberFormatException -> 0x0a72 }
            if (r5 == 0) goto L_0x0510
            goto L_0x051c
        L_0x0510:
            kr.co.popone.fitts.model.domain.push.PushRendingState r5 = kr.co.popone.fitts.model.domain.push.PushRendingState.PAYMENT_CANCEL_SOLD_OUT     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.String r5 = r5.getType()     // Catch:{ NumberFormatException -> 0x0a72 }
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r5)     // Catch:{ NumberFormatException -> 0x0a72 }
            if (r5 == 0) goto L_0x0546
        L_0x051c:
            java.lang.String r4 = r2.getQueryParameter(r6)     // Catch:{ NumberFormatException -> 0x0a72 }
            kr.co.popone.fitts.model.domain.push.PushRendingState r5 = kr.co.popone.fitts.model.domain.push.PushRendingState.PAYMENT_CANCEL_MISPRICE     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.String r5 = r5.getSubType()     // Catch:{ NumberFormatException -> 0x0a72 }
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r5)     // Catch:{ NumberFormatException -> 0x0a72 }
            if (r5 == 0) goto L_0x0533
            kr.co.popone.fitts.model.domain.push.PushRendingState r4 = kr.co.popone.fitts.model.domain.push.PushRendingState.PAYMENT_CANCEL_MISPRICE     // Catch:{ NumberFormatException -> 0x0a72 }
            r1.startOrderRendingActivity(r3, r2, r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            goto L_0x086b
        L_0x0533:
            kr.co.popone.fitts.model.domain.push.PushRendingState r5 = kr.co.popone.fitts.model.domain.push.PushRendingState.PAYMENT_CANCEL_SOLD_OUT     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.String r5 = r5.getSubType()     // Catch:{ NumberFormatException -> 0x0a72 }
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r5)     // Catch:{ NumberFormatException -> 0x0a72 }
            if (r4 == 0) goto L_0x086b
            kr.co.popone.fitts.model.domain.push.PushRendingState r4 = kr.co.popone.fitts.model.domain.push.PushRendingState.PAYMENT_CANCEL_SOLD_OUT     // Catch:{ NumberFormatException -> 0x0a72 }
            r1.startOrderRendingActivity(r3, r2, r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            goto L_0x086b
        L_0x0546:
            kr.co.popone.fitts.model.domain.push.PushRendingState r5 = kr.co.popone.fitts.model.domain.push.PushRendingState.SHIPPING_DONE     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.String r5 = r5.getType()     // Catch:{ NumberFormatException -> 0x0a72 }
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r5)     // Catch:{ NumberFormatException -> 0x0a72 }
            if (r5 == 0) goto L_0x0559
            kr.co.popone.fitts.model.domain.push.PushRendingState r4 = kr.co.popone.fitts.model.domain.push.PushRendingState.SHIPPING_DONE     // Catch:{ NumberFormatException -> 0x0a72 }
            r1.startOrderRendingActivityWithVariantId(r3, r2, r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            goto L_0x086b
        L_0x0559:
            kr.co.popone.fitts.model.domain.push.PushRendingState r5 = kr.co.popone.fitts.model.domain.push.PushRendingState.DONE     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.String r5 = r5.getType()     // Catch:{ NumberFormatException -> 0x0a72 }
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r5)     // Catch:{ NumberFormatException -> 0x0a72 }
            if (r5 == 0) goto L_0x056c
            kr.co.popone.fitts.model.domain.push.PushRendingState r4 = kr.co.popone.fitts.model.domain.push.PushRendingState.DONE     // Catch:{ NumberFormatException -> 0x0a72 }
            r1.startOrderRendingActivityWithVariantId(r3, r2, r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            goto L_0x086b
        L_0x056c:
            kr.co.popone.fitts.model.domain.push.PushRendingState r5 = kr.co.popone.fitts.model.domain.push.PushRendingState.ADMIN_CANCEL_ALL_CUSTOMER_FAULT     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.String r5 = r5.getType()     // Catch:{ NumberFormatException -> 0x0a72 }
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r5)     // Catch:{ NumberFormatException -> 0x0a72 }
            if (r5 == 0) goto L_0x0579
            goto L_0x059f
        L_0x0579:
            kr.co.popone.fitts.model.domain.push.PushRendingState r5 = kr.co.popone.fitts.model.domain.push.PushRendingState.ADMIN_CANCEL_ALL_SELLER_FAULT     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.String r5 = r5.getType()     // Catch:{ NumberFormatException -> 0x0a72 }
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r5)     // Catch:{ NumberFormatException -> 0x0a72 }
            if (r5 == 0) goto L_0x0586
            goto L_0x059f
        L_0x0586:
            kr.co.popone.fitts.model.domain.push.PushRendingState r5 = kr.co.popone.fitts.model.domain.push.PushRendingState.ADMIN_CANCEL_PARTIAL_CUSTOMER_FAULT     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.String r5 = r5.getType()     // Catch:{ NumberFormatException -> 0x0a72 }
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r5)     // Catch:{ NumberFormatException -> 0x0a72 }
            if (r5 == 0) goto L_0x0593
            goto L_0x059f
        L_0x0593:
            kr.co.popone.fitts.model.domain.push.PushRendingState r5 = kr.co.popone.fitts.model.domain.push.PushRendingState.ADMIN_CANCEL_PARTIAL_SELLER_FAULT     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.String r5 = r5.getType()     // Catch:{ NumberFormatException -> 0x0a72 }
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r5)     // Catch:{ NumberFormatException -> 0x0a72 }
            if (r4 == 0) goto L_0x086b
        L_0x059f:
            java.lang.String r4 = r2.getQueryParameter(r6)     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.String r5 = "refundedWithFaultBy"
            java.lang.String r5 = r2.getQueryParameter(r5)     // Catch:{ NumberFormatException -> 0x0a72 }
            kr.co.popone.fitts.model.domain.push.PushRendingState r6 = kr.co.popone.fitts.model.domain.push.PushRendingState.ADMIN_CANCEL_PARTIAL_CUSTOMER_FAULT     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.String r6 = r6.getSubType()     // Catch:{ NumberFormatException -> 0x0a72 }
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r6)     // Catch:{ NumberFormatException -> 0x0a72 }
            if (r6 == 0) goto L_0x05b6
            goto L_0x05c2
        L_0x05b6:
            kr.co.popone.fitts.model.domain.push.PushRendingState r6 = kr.co.popone.fitts.model.domain.push.PushRendingState.ADMIN_CANCEL_PARTIAL_SELLER_FAULT     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.String r6 = r6.getSubType()     // Catch:{ NumberFormatException -> 0x0a72 }
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r6)     // Catch:{ NumberFormatException -> 0x0a72 }
            if (r6 == 0) goto L_0x05e0
        L_0x05c2:
            java.lang.String r4 = "seller"
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            if (r4 == 0) goto L_0x05d1
            kr.co.popone.fitts.model.domain.push.PushRendingState r4 = kr.co.popone.fitts.model.domain.push.PushRendingState.ADMIN_CANCEL_PARTIAL_SELLER_FAULT     // Catch:{ NumberFormatException -> 0x0a72 }
            r1.startOrderRendingActivityWithVariantId(r3, r2, r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            goto L_0x086b
        L_0x05d1:
            java.lang.String r4 = "customer"
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            if (r4 == 0) goto L_0x086b
            kr.co.popone.fitts.model.domain.push.PushRendingState r4 = kr.co.popone.fitts.model.domain.push.PushRendingState.ADMIN_CANCEL_PARTIAL_CUSTOMER_FAULT     // Catch:{ NumberFormatException -> 0x0a72 }
            r1.startOrderRendingActivityWithVariantId(r3, r2, r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            goto L_0x086b
        L_0x05e0:
            kr.co.popone.fitts.model.domain.push.PushRendingState r6 = kr.co.popone.fitts.model.domain.push.PushRendingState.ADMIN_CANCEL_ALL_CUSTOMER_FAULT     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.String r6 = r6.getSubType()     // Catch:{ NumberFormatException -> 0x0a72 }
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r6)     // Catch:{ NumberFormatException -> 0x0a72 }
            if (r6 == 0) goto L_0x05ed
            goto L_0x05f9
        L_0x05ed:
            kr.co.popone.fitts.model.domain.push.PushRendingState r6 = kr.co.popone.fitts.model.domain.push.PushRendingState.ADMIN_CANCEL_ALL_SELLER_FAULT     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.String r6 = r6.getSubType()     // Catch:{ NumberFormatException -> 0x0a72 }
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r6)     // Catch:{ NumberFormatException -> 0x0a72 }
            if (r4 == 0) goto L_0x086b
        L_0x05f9:
            java.lang.String r4 = "seller"
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            if (r4 == 0) goto L_0x0608
            kr.co.popone.fitts.model.domain.push.PushRendingState r4 = kr.co.popone.fitts.model.domain.push.PushRendingState.ADMIN_CANCEL_ALL_SELLER_FAULT     // Catch:{ NumberFormatException -> 0x0a72 }
            r1.startOrderRendingActivity(r3, r2, r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            goto L_0x086b
        L_0x0608:
            java.lang.String r4 = "customer"
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            if (r4 == 0) goto L_0x086b
            kr.co.popone.fitts.model.domain.push.PushRendingState r4 = kr.co.popone.fitts.model.domain.push.PushRendingState.ADMIN_CANCEL_ALL_CUSTOMER_FAULT     // Catch:{ NumberFormatException -> 0x0a72 }
            r1.startOrderRendingActivity(r3, r2, r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            goto L_0x086b
        L_0x0617:
            java.lang.String r2 = "orderDetail"
            boolean r2 = r7.equals(r2)     // Catch:{ NumberFormatException -> 0x0a72 }
            if (r2 == 0) goto L_0x086b
            kr.co.popone.fitts.feature.order.detail.OrderDetailActivity$Companion r2 = kr.co.popone.fitts.feature.order.detail.OrderDetailActivity.Companion     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.String r5 = "segments"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r4, r5)     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.Object r4 = kotlin.collections.CollectionsKt___CollectionsKt.last(r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.String r5 = "segments.last()"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r4, r5)     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ NumberFormatException -> 0x0a72 }
            long r4 = java.lang.Long.parseLong(r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            r2.start(r3, r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            goto L_0x086b
        L_0x063a:
            java.lang.String r6 = "orderLineItemVariant"
            boolean r6 = r7.equals(r6)     // Catch:{ NumberFormatException -> 0x0a72 }
            if (r6 == 0) goto L_0x086b
            r6 = 1
            java.lang.Object r7 = r4.get(r6)     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.String r6 = "segments.get(1)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r7, r6)     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ NumberFormatException -> 0x0a72 }
            long r6 = java.lang.Long.parseLong(r7)     // Catch:{ NumberFormatException -> 0x0a72 }
            r8 = 3
            java.lang.Object r8 = r4.get(r8)     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.String r9 = "segments.get(3)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r8, r9)     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ NumberFormatException -> 0x0a72 }
            long r8 = java.lang.Long.parseLong(r8)     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.String r10 = r2.getQueryParameter(r5)     // Catch:{ NumberFormatException -> 0x0a72 }
            r2 = 2
            java.lang.Object r11 = r4.get(r2)     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.String r2 = "exchange"
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r11, r2)     // Catch:{ NumberFormatException -> 0x0a72 }
            if (r2 == 0) goto L_0x0684
            kr.co.popone.fitts.feature.exchange.ExchangeCompleteActivity$Companion r2 = kr.co.popone.fitts.feature.exchange.ExchangeCompleteActivity.Companion     // Catch:{ NumberFormatException -> 0x0a72 }
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r10, r5)     // Catch:{ NumberFormatException -> 0x0a72 }
            r3 = r18
            r4 = r6
            r6 = r8
            r8 = r10
            r2.startExchangeApplyComplete(r3, r4, r6, r8)     // Catch:{ NumberFormatException -> 0x0a72 }
            goto L_0x086b
        L_0x0684:
            r2 = 2
            java.lang.Object r2 = r4.get(r2)     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.String r4 = "refund"
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            if (r2 == 0) goto L_0x086b
            kr.co.popone.fitts.feature.refund.RefundCompleteActivity$Companion r2 = kr.co.popone.fitts.feature.refund.RefundCompleteActivity.Companion     // Catch:{ NumberFormatException -> 0x0a72 }
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r10, r5)     // Catch:{ NumberFormatException -> 0x0a72 }
            r3 = r18
            r4 = r6
            r6 = r8
            r8 = r10
            r2.startRefundApplyComplete(r3, r4, r6, r8)     // Catch:{ NumberFormatException -> 0x0a72 }
            goto L_0x086b
        L_0x06a2:
            java.lang.String r2 = "cart"
            boolean r2 = r7.equals(r2)     // Catch:{ NumberFormatException -> 0x0a72 }
            if (r2 == 0) goto L_0x086b
            kr.co.popone.fitts.feature.cart.CartActivity$Companion r2 = kr.co.popone.fitts.feature.cart.CartActivity.Companion     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.String r4 = "scheme"
            r2.start(r3, r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            goto L_0x086b
        L_0x06b3:
            java.lang.String r2 = "shopBridge"
            boolean r2 = r7.equals(r2)     // Catch:{ NumberFormatException -> 0x0a72 }
            if (r2 == 0) goto L_0x086b
            r2 = 1
            java.lang.Object r4 = r4.get(r2)     // Catch:{ Exception -> 0x086b }
            java.lang.String r2 = "segments.get(1)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r4, r2)     // Catch:{ Exception -> 0x086b }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x086b }
            long r4 = java.lang.Long.parseLong(r4)     // Catch:{ Exception -> 0x086b }
            kr.co.popone.fitts.feature.store.bridge.ShopBridgeActivity$Companion r2 = kr.co.popone.fitts.feature.store.bridge.ShopBridgeActivity.Companion     // Catch:{ Exception -> 0x086b }
            r2.start(r3, r4)     // Catch:{ Exception -> 0x086b }
            goto L_0x086b
        L_0x06d2:
            java.lang.String r4 = "eventHome"
            boolean r4 = r12.equals(r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            if (r4 == 0) goto L_0x0a57
            kr.co.popone.fitts.feature.banner.BannerActivity$Companion r2 = kr.co.popone.fitts.feature.banner.BannerActivity.Companion     // Catch:{ NumberFormatException -> 0x0a72 }
            kr.co.popone.fitts.model.datamodel.service.banner.BannerType r4 = kr.co.popone.fitts.model.datamodel.service.banner.BannerType.EVENT     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.String r5 = "event_banner_badge_timestamp"
            r2.start(r3, r4, r5)     // Catch:{ NumberFormatException -> 0x0a72 }
            goto L_0x086b
        L_0x06e5:
            java.lang.String r4 = "post"
            boolean r4 = r12.equals(r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            if (r4 == 0) goto L_0x0a57
            java.lang.String r4 = "handle post urlString"
            r5 = 0
            java.lang.Object[] r7 = new java.lang.Object[r5]     // Catch:{ NumberFormatException -> 0x0a72 }
            com.orhanobut.logger.Logger.d(r4, r7)     // Catch:{ NumberFormatException -> 0x0a72 }
            android.content.Intent r4 = new android.content.Intent     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.Class<kr.co.popone.fitts.feature.post.detail.PostActivity> r5 = kr.co.popone.fitts.feature.post.detail.PostActivity.class
            r4.<init>(r3, r5)     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.String r5 = "post_id"
            java.lang.String r7 = r2.getLastPathSegment()     // Catch:{ NumberFormatException -> 0x0a72 }
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r7, r6)     // Catch:{ NumberFormatException -> 0x0a72 }
            long r6 = java.lang.Long.parseLong(r7)     // Catch:{ NumberFormatException -> 0x0a72 }
            r4.putExtra(r5, r6)     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.String r5 = "focus"
            java.lang.String r2 = r2.getQueryParameter(r5)     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.String r5 = "comment"
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r5)     // Catch:{ NumberFormatException -> 0x0a72 }
            if (r2 == 0) goto L_0x0728
            java.lang.String r2 = "focus comment"
            r5 = 0
            java.lang.Object[] r6 = new java.lang.Object[r5]     // Catch:{ NumberFormatException -> 0x0a72 }
            com.orhanobut.logger.Logger.d(r2, r6)     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.String r2 = "focus_comment"
            r5 = 1
            r4.putExtra(r2, r5)     // Catch:{ NumberFormatException -> 0x0a72 }
        L_0x0728:
            android.os.Bundle r2 = r9.toBundle()     // Catch:{ NumberFormatException -> 0x0a72 }
            r3.startActivity(r4, r2)     // Catch:{ NumberFormatException -> 0x0a72 }
            goto L_0x086b
        L_0x0731:
            java.lang.String r4 = "tag"
            boolean r4 = r12.equals(r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            if (r4 == 0) goto L_0x0a57
            java.lang.String r4 = "handle tag urlString"
            r5 = 0
            java.lang.Object[] r6 = new java.lang.Object[r5]     // Catch:{ NumberFormatException -> 0x0a72 }
            com.orhanobut.logger.Logger.d(r4, r6)     // Catch:{ NumberFormatException -> 0x0a72 }
            android.content.Intent r4 = new android.content.Intent     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.Class<kr.co.popone.fitts.feature.tag.TagSearchActivity> r5 = kr.co.popone.fitts.feature.tag.TagSearchActivity.class
            r4.<init>(r3, r5)     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.String r5 = "tag"
            java.lang.String r2 = r2.getLastPathSegment()     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.String r2 = r2.toString()     // Catch:{ NumberFormatException -> 0x0a72 }
            r4.putExtra(r5, r2)     // Catch:{ NumberFormatException -> 0x0a72 }
            android.os.Bundle r2 = r9.toBundle()     // Catch:{ NumberFormatException -> 0x0a72 }
            r3.startActivity(r4, r2)     // Catch:{ NumberFormatException -> 0x0a72 }
            goto L_0x086b
        L_0x075e:
            java.lang.String r4 = "applicationEvent"
            boolean r4 = r12.equals(r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            if (r4 == 0) goto L_0x0a57
            java.lang.String r4 = r2.getLastPathSegment()     // Catch:{ NumberFormatException -> 0x0a72 }
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r4, r6)     // Catch:{ NumberFormatException -> 0x0a72 }
            long r4 = java.lang.Long.parseLong(r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.String r6 = r2.getQueryParameter(r11)     // Catch:{ NumberFormatException -> 0x0a72 }
            if (r6 != 0) goto L_0x0779
            goto L_0x0407
        L_0x0779:
            int r7 = r6.hashCode()     // Catch:{ NumberFormatException -> 0x0a72 }
            r9 = -1039690024(0xffffffffc20796d8, float:-33.89731)
            if (r7 == r9) goto L_0x07f9
            r9 = -934426595(0xffffffffc84dc81d, float:-210720.45)
            if (r7 == r9) goto L_0x07d3
            r9 = -787742657(0xffffffffd10c003f, float:-3.7581222E10)
            if (r7 == r9) goto L_0x078e
            goto L_0x0407
        L_0x078e:
            java.lang.String r7 = "winner"
            boolean r6 = r6.equals(r7)     // Catch:{ NumberFormatException -> 0x0a72 }
            if (r6 == 0) goto L_0x0407
            java.lang.String r6 = "ticket_id"
            java.lang.String r2 = r2.getQueryParameter(r6)     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.String r6 = "uri.getQueryParameter(\"ticket_id\")"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r6)     // Catch:{ NumberFormatException -> 0x0a72 }
            long r6 = java.lang.Long.parseLong(r2)     // Catch:{ NumberFormatException -> 0x0a72 }
            r2 = 2
            kotlin.Pair[] r2 = new kotlin.Pair[r2]     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.String r9 = "ticketID"
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ NumberFormatException -> 0x0a72 }
            kotlin.Pair r6 = kotlin.TuplesKt.to(r9, r6)     // Catch:{ NumberFormatException -> 0x0a72 }
            r7 = 0
            r2[r7] = r6     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.String r6 = "eventID"
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            kotlin.Pair r4 = kotlin.TuplesKt.to(r6, r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            r5 = 1
            r2[r5] = r4     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.Class<kr.co.popone.fitts.feature.event.AppliableEventWinnerInputActivity> r4 = kr.co.popone.fitts.feature.event.AppliableEventWinnerInputActivity.class
            android.content.Intent r2 = org.jetbrains.anko.internals.AnkoInternals.createIntent(r3, r4, r2)     // Catch:{ NumberFormatException -> 0x0a72 }
            r3.startActivity(r2)     // Catch:{ NumberFormatException -> 0x0a72 }
            r2 = 2130771997(0x7f01001d, float:1.71471E38)
            r3.overridePendingTransition(r2, r8)     // Catch:{ NumberFormatException -> 0x0a72 }
            goto L_0x086b
        L_0x07d3:
            java.lang.String r2 = "result"
            boolean r2 = r6.equals(r2)     // Catch:{ NumberFormatException -> 0x0a72 }
            if (r2 == 0) goto L_0x0407
            r2 = 1
            kotlin.Pair[] r6 = new kotlin.Pair[r2]     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.Long r2 = java.lang.Long.valueOf(r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            kotlin.Pair r2 = kotlin.TuplesKt.to(r10, r2)     // Catch:{ NumberFormatException -> 0x0a72 }
            r4 = 0
            r6[r4] = r2     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.Class<kr.co.popone.fitts.feature.event.AppliableEventResultActivity> r2 = kr.co.popone.fitts.feature.event.AppliableEventResultActivity.class
            android.content.Intent r2 = org.jetbrains.anko.internals.AnkoInternals.createIntent(r3, r2, r6)     // Catch:{ NumberFormatException -> 0x0a72 }
            r3.startActivity(r2)     // Catch:{ NumberFormatException -> 0x0a72 }
            r2 = 2130771997(0x7f01001d, float:1.71471E38)
            r3.overridePendingTransition(r2, r8)     // Catch:{ NumberFormatException -> 0x0a72 }
            goto L_0x086b
        L_0x07f9:
            java.lang.String r2 = "notice"
            boolean r2 = r6.equals(r2)     // Catch:{ NumberFormatException -> 0x0a72 }
            if (r2 == 0) goto L_0x0407
            r2 = 1
            kotlin.Pair[] r6 = new kotlin.Pair[r2]     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.Long r2 = java.lang.Long.valueOf(r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            kotlin.Pair r2 = kotlin.TuplesKt.to(r10, r2)     // Catch:{ NumberFormatException -> 0x0a72 }
            r4 = 0
            r6[r4] = r2     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.Class<kr.co.popone.fitts.feature.event.AppliableCollaborativeEventActivity> r2 = kr.co.popone.fitts.feature.event.AppliableCollaborativeEventActivity.class
            android.content.Intent r2 = org.jetbrains.anko.internals.AnkoInternals.createIntent(r3, r2, r6)     // Catch:{ NumberFormatException -> 0x0a72 }
            r3.startActivity(r2)     // Catch:{ NumberFormatException -> 0x0a72 }
            r2 = 2130771997(0x7f01001d, float:1.71471E38)
            r3.overridePendingTransition(r2, r8)     // Catch:{ NumberFormatException -> 0x0a72 }
            goto L_0x086b
        L_0x081f:
            java.lang.String r4 = "showroom"
            boolean r4 = r12.equals(r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            if (r4 == 0) goto L_0x0a57
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x0a72 }
            r4.<init>()     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.String r5 = "handle showroom urlString "
            r4.append(r5)     // Catch:{ NumberFormatException -> 0x0a72 }
            r4.append(r2)     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.String r4 = r4.toString()     // Catch:{ NumberFormatException -> 0x0a72 }
            r5 = 0
            java.lang.Object[] r7 = new java.lang.Object[r5]     // Catch:{ NumberFormatException -> 0x0a72 }
            com.orhanobut.logger.Logger.d(r4, r7)     // Catch:{ NumberFormatException -> 0x0a72 }
            kr.co.popone.fitts.feature.showroom.ShowRoomActivity$Companion r4 = kr.co.popone.fitts.feature.showroom.ShowRoomActivity.Companion     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.String r2 = r2.getLastPathSegment()     // Catch:{ NumberFormatException -> 0x0a72 }
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r6)     // Catch:{ NumberFormatException -> 0x0a72 }
            long r5 = java.lang.Long.parseLong(r2)     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.Long r2 = java.lang.Long.valueOf(r5)     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.String r5 = "push"
            r4.start(r3, r2, r5)     // Catch:{ NumberFormatException -> 0x0a72 }
            goto L_0x086b
        L_0x0855:
            java.lang.String r4 = "posting"
            boolean r4 = r12.equals(r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            if (r4 == 0) goto L_0x0a57
            kr.co.popone.fitts.feature.post.upload.create.CreatePostActivityUtil r2 = r1.createPostActivityUtil     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.String r4 = "unknown"
            r5 = 0
            r6 = 0
            r7 = 12
            r8 = 0
            r3 = r18
            kr.co.popone.fitts.feature.post.upload.create.CreatePostActivityUtil.showCreatePostActivity$default(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ NumberFormatException -> 0x0a72 }
        L_0x086b:
            r10 = 1
            goto L_0x0a70
        L_0x086e:
            java.lang.String r4 = "remotePushContent"
            boolean r4 = r12.equals(r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            if (r4 == 0) goto L_0x0a57
            java.lang.String r2 = r2.getLastPathSegment()     // Catch:{ NumberFormatException -> 0x0a72 }
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r6)     // Catch:{ NumberFormatException -> 0x0a72 }
            long r4 = java.lang.Long.parseLong(r2)     // Catch:{ NumberFormatException -> 0x0a72 }
            r2 = 1
            kotlin.Pair[] r6 = new kotlin.Pair[r2]     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.Long r2 = java.lang.Long.valueOf(r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            kotlin.Pair r2 = kotlin.TuplesKt.to(r10, r2)     // Catch:{ NumberFormatException -> 0x0a72 }
            r4 = 0
            r6[r4] = r2     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.Class<kr.co.popone.fitts.feature.event.MultiImageEventActivity> r2 = kr.co.popone.fitts.feature.event.MultiImageEventActivity.class
            android.content.Intent r2 = org.jetbrains.anko.internals.AnkoInternals.createIntent(r3, r2, r6)     // Catch:{ NumberFormatException -> 0x0a72 }
            r3.startActivity(r2)     // Catch:{ NumberFormatException -> 0x0a72 }
            r2 = 2130771997(0x7f01001d, float:1.71471E38)
            r3.overridePendingTransition(r2, r8)     // Catch:{ NumberFormatException -> 0x0a72 }
            goto L_0x086b
        L_0x089f:
            java.lang.String r4 = "recommendHome"
            boolean r4 = r12.equals(r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            if (r4 == 0) goto L_0x0a57
            kr.co.popone.fitts.feature.banner.BannerActivity$Companion r2 = kr.co.popone.fitts.feature.banner.BannerActivity.Companion     // Catch:{ NumberFormatException -> 0x0a72 }
            kr.co.popone.fitts.model.datamodel.service.banner.BannerType r4 = kr.co.popone.fitts.model.datamodel.service.banner.BannerType.RECOMMEND     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.String r5 = "event_banner_badge_timestamp"
            r2.start(r3, r4, r5)     // Catch:{ NumberFormatException -> 0x0a72 }
            goto L_0x086b
        L_0x08b1:
            java.lang.String r4 = "externalWeb"
            boolean r4 = r12.equals(r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            if (r4 == 0) goto L_0x0a57
            java.lang.String r4 = "url"
            java.lang.String r2 = r2.getQueryParameter(r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            android.content.Intent r4 = new android.content.Intent     // Catch:{ NumberFormatException -> 0x0a72 }
            android.net.Uri r2 = android.net.Uri.parse(r2)     // Catch:{ NumberFormatException -> 0x0a72 }
            r4.<init>(r14, r2)     // Catch:{ NumberFormatException -> 0x0a72 }
            r3.startActivity(r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            goto L_0x086b
        L_0x08cc:
            java.lang.String r4 = "openWeb"
            boolean r4 = r12.equals(r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            if (r4 == 0) goto L_0x0a57
            kr.co.popone.fitts.eventtracker.EventTracker r4 = r1.eventTracker     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.String r5 = r2.getLastPathSegment()     // Catch:{ NumberFormatException -> 0x0a72 }
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r5, r6)     // Catch:{ NumberFormatException -> 0x0a72 }
            r4.customLogFitpleNumber(r5)     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.String r2 = r2.getLastPathSegment()     // Catch:{ NumberFormatException -> 0x0a72 }
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r6)     // Catch:{ NumberFormatException -> 0x0a72 }
            long r4 = java.lang.Long.parseLong(r2)     // Catch:{ NumberFormatException -> 0x0a72 }
            kr.co.popone.fitts.model.repository.service.FittsServiceRepository r2 = r1.serviceRepository     // Catch:{ NumberFormatException -> 0x0a72 }
            io.reactivex.Single r2 = r2.getFittsWebInfo(r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            kr.co.popone.fitts.services.FittsSchemeHandlerImpl$handleScheme$1 r4 = new kr.co.popone.fitts.services.FittsSchemeHandlerImpl$handleScheme$1     // Catch:{ NumberFormatException -> 0x0a72 }
            r4.<init>(r3)     // Catch:{ NumberFormatException -> 0x0a72 }
            r2.subscribe(r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            goto L_0x086b
        L_0x08fb:
            java.lang.String r4 = "collection"
            boolean r4 = r12.equals(r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            if (r4 == 0) goto L_0x0a57
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x0a72 }
            r4.<init>()     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.String r5 = "handle collection "
            r4.append(r5)     // Catch:{ NumberFormatException -> 0x0a72 }
            r4.append(r2)     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.String r4 = r4.toString()     // Catch:{ NumberFormatException -> 0x0a72 }
            r5 = 0
            java.lang.Object[] r7 = new java.lang.Object[r5]     // Catch:{ NumberFormatException -> 0x0a72 }
            com.orhanobut.logger.Logger.d(r4, r7)     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.String r4 = r2.getLastPathSegment()     // Catch:{ NumberFormatException -> 0x0a72 }
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r4, r6)     // Catch:{ NumberFormatException -> 0x0a72 }
            long r4 = java.lang.Long.parseLong(r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            r6 = 2130771997(0x7f01001d, float:1.71471E38)
            androidx.core.app.ActivityOptionsCompat r6 = androidx.core.app.ActivityOptionsCompat.makeCustomAnimation(r3, r6, r8)     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.String r7 = "ActivityOptionsCompat.ma…lide_up, R.anim.fade_out)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r7)     // Catch:{ NumberFormatException -> 0x0a72 }
            kr.co.popone.fitts.eventtracker.EventTracker r7 = r1.eventTracker     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.String r8 = "View Collection"
            kr.co.popone.fitts.eventtracker.EventTracker$CustomAttributes r9 = new kr.co.popone.fitts.eventtracker.EventTracker$CustomAttributes     // Catch:{ NumberFormatException -> 0x0a72 }
            r9.<init>()     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.String r12 = r2.getQueryParameter(r11)     // Catch:{ NumberFormatException -> 0x0a72 }
            if (r12 == 0) goto L_0x0941
            goto L_0x0943
        L_0x0941:
            java.lang.String r12 = ""
        L_0x0943:
            kr.co.popone.fitts.eventtracker.EventTracker$CustomAttributes r9 = r9.put(r11, r12)     // Catch:{ NumberFormatException -> 0x0a72 }
            r7.logCustom(r8, r9)     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.String r2 = r2.getQueryParameter(r11)     // Catch:{ NumberFormatException -> 0x0a72 }
            if (r2 != 0) goto L_0x0952
            goto L_0x0407
        L_0x0952:
            int r7 = r2.hashCode()     // Catch:{ NumberFormatException -> 0x0a72 }
            r8 = -799212381(0xffffffffd05cfca3, float:-1.48301773E10)
            if (r7 == r8) goto L_0x09c1
            r8 = 3446944(0x3498a0, float:4.830197E-39)
            if (r7 == r8) goto L_0x0994
            r8 = 103910395(0x6318bfb, float:3.339284E-35)
            if (r7 == r8) goto L_0x0967
            goto L_0x0407
        L_0x0967:
            java.lang.String r7 = "mixed"
            boolean r2 = r2.equals(r7)     // Catch:{ NumberFormatException -> 0x0a72 }
            if (r2 == 0) goto L_0x0407
            java.lang.String r2 = "mixed collection type"
            r7 = 0
            java.lang.Object[] r8 = new java.lang.Object[r7]     // Catch:{ NumberFormatException -> 0x0a72 }
            com.orhanobut.logger.Logger.d(r2, r8)     // Catch:{ NumberFormatException -> 0x0a72 }
            r2 = 1
            kotlin.Pair[] r7 = new kotlin.Pair[r2]     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.Long r2 = java.lang.Long.valueOf(r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            kotlin.Pair r2 = kotlin.TuplesKt.to(r10, r2)     // Catch:{ NumberFormatException -> 0x0a72 }
            r4 = 0
            r7[r4] = r2     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.Class<kr.co.popone.fitts.feature.collection.MixedCollectionActivity> r2 = kr.co.popone.fitts.feature.collection.MixedCollectionActivity.class
            android.content.Intent r2 = org.jetbrains.anko.internals.AnkoInternals.createIntent(r3, r2, r7)     // Catch:{ NumberFormatException -> 0x0a72 }
            android.os.Bundle r4 = r6.toBundle()     // Catch:{ NumberFormatException -> 0x0a72 }
            r3.startActivity(r2, r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            r2 = 1
            return r2
        L_0x0994:
            java.lang.String r7 = "post"
            boolean r2 = r2.equals(r7)     // Catch:{ NumberFormatException -> 0x0a72 }
            if (r2 == 0) goto L_0x0407
            java.lang.String r2 = "post collection type"
            r7 = 0
            java.lang.Object[] r8 = new java.lang.Object[r7]     // Catch:{ NumberFormatException -> 0x0a72 }
            com.orhanobut.logger.Logger.d(r2, r8)     // Catch:{ NumberFormatException -> 0x0a72 }
            r2 = 1
            kotlin.Pair[] r7 = new kotlin.Pair[r2]     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.Long r2 = java.lang.Long.valueOf(r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            kotlin.Pair r2 = kotlin.TuplesKt.to(r10, r2)     // Catch:{ NumberFormatException -> 0x0a72 }
            r4 = 0
            r7[r4] = r2     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.Class<kr.co.popone.fitts.feature.collection.PostCollectionActivity> r2 = kr.co.popone.fitts.feature.collection.PostCollectionActivity.class
            android.content.Intent r2 = org.jetbrains.anko.internals.AnkoInternals.createIntent(r3, r2, r7)     // Catch:{ NumberFormatException -> 0x0a72 }
            android.os.Bundle r4 = r6.toBundle()     // Catch:{ NumberFormatException -> 0x0a72 }
            r3.startActivity(r2, r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            goto L_0x086b
        L_0x09c1:
            java.lang.String r7 = "promotion"
            boolean r2 = r2.equals(r7)     // Catch:{ NumberFormatException -> 0x0a72 }
            if (r2 == 0) goto L_0x0407
            java.lang.String r2 = "promotion collection type"
            r7 = 0
            java.lang.Object[] r8 = new java.lang.Object[r7]     // Catch:{ NumberFormatException -> 0x0a72 }
            com.orhanobut.logger.Logger.d(r2, r8)     // Catch:{ NumberFormatException -> 0x0a72 }
            r7 = 1
            kotlin.Pair[] r2 = new kotlin.Pair[r7]     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            kotlin.Pair r4 = kotlin.TuplesKt.to(r10, r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            r5 = 0
            r2[r5] = r4     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.Class<kr.co.popone.fitts.feature.collection.PromotionCollectionActivity> r4 = kr.co.popone.fitts.feature.collection.PromotionCollectionActivity.class
            android.content.Intent r2 = org.jetbrains.anko.internals.AnkoInternals.createIntent(r3, r4, r2)     // Catch:{ NumberFormatException -> 0x0a72 }
            android.os.Bundle r4 = r6.toBundle()     // Catch:{ NumberFormatException -> 0x0a72 }
            r3.startActivity(r2, r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            goto L_0x086b
        L_0x09ee:
            r7 = 1
            java.lang.String r4 = "postInvoice"
            boolean r4 = r12.equals(r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            if (r4 == 0) goto L_0x0a57
            java.lang.String r4 = r2.getLastPathSegment()     // Catch:{ NumberFormatException -> 0x0a72 }
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r4, r6)     // Catch:{ NumberFormatException -> 0x0a72 }
            long r4 = java.lang.Long.parseLong(r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.String r6 = "action"
            java.lang.String r2 = r2.getQueryParameter(r6)     // Catch:{ NumberFormatException -> 0x0a72 }
            if (r2 != 0) goto L_0x0a0c
            goto L_0x0407
        L_0x0a0c:
            int r6 = r2.hashCode()     // Catch:{ NumberFormatException -> 0x0a72 }
            r8 = -1770111376(0xffffffff967e3e70, float:-2.0537658E-25)
            if (r6 == r8) goto L_0x0a37
            r8 = -21437972(0xfffffffffeb8e1ec, float:-1.228755E38)
            if (r6 == r8) goto L_0x0a1c
            goto L_0x0407
        L_0x0a1c:
            java.lang.String r6 = "blocked"
            boolean r2 = r2.equals(r6)     // Catch:{ NumberFormatException -> 0x0a72 }
            if (r2 == 0) goto L_0x0407
            android.content.Intent r2 = new android.content.Intent     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.Class<kr.co.popone.fitts.feature.post.PostingViolationNoticeActivity> r6 = kr.co.popone.fitts.feature.post.PostingViolationNoticeActivity.class
            r2.<init>(r3, r6)     // Catch:{ NumberFormatException -> 0x0a72 }
            r2.putExtra(r10, r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            android.os.Bundle r4 = r9.toBundle()     // Catch:{ NumberFormatException -> 0x0a72 }
            r3.startActivity(r2, r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            goto L_0x086b
        L_0x0a37:
            java.lang.String r6 = "deactivated"
            boolean r2 = r2.equals(r6)     // Catch:{ NumberFormatException -> 0x0a72 }
            if (r2 == 0) goto L_0x0407
            android.content.Intent r2 = new android.content.Intent     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.Class<kr.co.popone.fitts.feature.post.notification.PostDeleteNotificationDetailActivity> r6 = kr.co.popone.fitts.feature.post.notification.PostDeleteNotificationDetailActivity.class
            r2.<init>(r3, r6)     // Catch:{ NumberFormatException -> 0x0a72 }
            kr.co.popone.fitts.feature.post.notification.PostDeleteNotificationDetailActivity$Parameters r6 = new kr.co.popone.fitts.feature.post.notification.PostDeleteNotificationDetailActivity$Parameters     // Catch:{ NumberFormatException -> 0x0a72 }
            r6.<init>(r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            r2.putExtra(r15, r6)     // Catch:{ NumberFormatException -> 0x0a72 }
            android.os.Bundle r4 = r9.toBundle()     // Catch:{ NumberFormatException -> 0x0a72 }
            r3.startActivity(r2, r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            goto L_0x086b
        L_0x0a57:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x0a72 }
            r3.<init>()     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.String r4 = "there's no matching urlString for "
            r3.append(r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            r3.append(r2)     // Catch:{ NumberFormatException -> 0x0a72 }
            java.lang.String r2 = r3.toString()     // Catch:{ NumberFormatException -> 0x0a72 }
            r3 = 0
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ NumberFormatException -> 0x0a72 }
            com.orhanobut.logger.Logger.d(r2, r4)     // Catch:{ NumberFormatException -> 0x0a72 }
            goto L_0x0407
        L_0x0a70:
            r4 = r10
            goto L_0x0a8b
        L_0x0a72:
            r0 = move-exception
            r2 = r0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "urlString is not valid "
            r3.append(r4)
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            r4 = 0
            java.lang.Object[] r3 = new java.lang.Object[r4]
            com.orhanobut.logger.Logger.d(r2, r3)
        L_0x0a8b:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.services.FittsSchemeHandlerImpl.handleScheme(android.app.Activity, java.lang.String):boolean");
    }

    private final void startFittsInstagram(Activity activity) {
        ActivityOptionsCompat makeCustomAnimation = ActivityOptionsCompat.makeCustomAnimation(activity, C0001R$anim.slide_right, C0001R$anim.fade_out);
        Intrinsics.checkExpressionValueIsNotNull(makeCustomAnimation, "ActivityOptionsCompat.ma…e_right, R.anim.fade_out)");
        String str = "https://www.instagram.com/fitts_official";
        String str2 = "android.intent.action.VIEW";
        Intent intent = new Intent(str2, Uri.parse(str));
        intent.setPackage("com.instagram.android");
        try {
            activity.startActivity(intent, makeCustomAnimation.toBundle());
        } catch (ActivityNotFoundException unused) {
            activity.startActivity(new Intent(str2, Uri.parse(str)), makeCustomAnimation.toBundle());
        }
    }

    private final void startFittsFacebook(Activity activity) {
        String str = "android.intent.action.VIEW";
        ActivityOptionsCompat makeCustomAnimation = ActivityOptionsCompat.makeCustomAnimation(activity, C0001R$anim.slide_right, C0001R$anim.fade_out);
        Intrinsics.checkExpressionValueIsNotNull(makeCustomAnimation, "ActivityOptionsCompat.ma…e_right, R.anim.fade_out)");
        try {
            activity.getPackageManager().getPackageInfo("com.facebook.katana", 0);
            activity.startActivity(new Intent(str, Uri.parse("fb://page/109304279597125")), makeCustomAnimation.toBundle());
        } catch (Exception unused) {
            activity.startActivity(new Intent(str, Uri.parse("https://www.facebook.com/fitts.official")), makeCustomAnimation.toBundle());
        }
    }

    private final void startOrderRendingActivity(Activity activity, Uri uri, PushRendingState pushRendingState) {
        String queryParameter = uri.getQueryParameter("order_id");
        Intrinsics.checkExpressionValueIsNotNull(queryParameter, "uri.getQueryParameter(\"order_id\")");
        OrderRendingActivity.Companion.start(activity, new PushRendingElement(Long.valueOf(Long.parseLong(queryParameter)), null, pushRendingState));
    }

    private final void startOrderRendingActivityWithVariantId(Activity activity, Uri uri, PushRendingState pushRendingState) {
        String queryParameter = uri.getQueryParameter("order_id");
        Intrinsics.checkExpressionValueIsNotNull(queryParameter, "uri.getQueryParameter(\"order_id\")");
        Long valueOf = Long.valueOf(Long.parseLong(queryParameter));
        String queryParameter2 = uri.getQueryParameter("line_item_variant_id");
        Intrinsics.checkExpressionValueIsNotNull(queryParameter2, "uri.getQueryParameter(\"line_item_variant_id\")");
        OrderRendingActivity.Companion.start(activity, new PushRendingElement(valueOf, Long.valueOf(Long.parseLong(queryParameter2)), pushRendingState));
    }
}
