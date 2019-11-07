package kr.co.popone.fitts.eventtracker;

import android.os.Bundle;
import com.crashlytics.android.answers.Answers;
import com.crashlytics.android.answers.CustomEvent;
import com.crashlytics.android.answers.PurchaseEvent;
import com.crashlytics.android.answers.SignUpEvent;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.orhanobut.logger.Logger;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.Map.Entry;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.eventtracker.EventTracker.CustomAttributes;
import kr.co.popone.fitts.eventtracker.EventTracker.DefaultImpls;
import kr.co.popone.fitts.eventtracker.EventTracker.SignUpMethod;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class EventTrackerImpl implements EventTracker {
    private final FirebaseAnalytics firebaseAnalytics;
    private Integer homeAllDistance;
    private Integer homeMyDistance;
    private Integer storeBestDistance;
    private Integer storeHomeDistance;
    private Integer storeListDistance;
    private Integer storeNewDistance;

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = new int[SignUpMethod.values().length];

        static {
            $EnumSwitchMapping$0[SignUpMethod.EMAIL.ordinal()] = 1;
            $EnumSwitchMapping$0[SignUpMethod.KAKAO.ordinal()] = 2;
            $EnumSwitchMapping$0[SignUpMethod.FACEBOOK.ordinal()] = 3;
        }
    }

    public EventTrackerImpl(@NotNull FirebaseAnalytics firebaseAnalytics2) {
        Intrinsics.checkParameterIsNotNull(firebaseAnalytics2, "firebaseAnalytics");
        this.firebaseAnalytics = firebaseAnalytics2;
    }

    public void logSignUp(@NotNull SignUpMethod signUpMethod, int i, boolean z) {
        String str;
        String str2 = "method";
        Intrinsics.checkParameterIsNotNull(signUpMethod, str2);
        StringBuilder sb = new StringBuilder();
        sb.append("logSignUp method(");
        sb.append(signUpMethod);
        sb.append(") age(");
        sb.append(i);
        sb.append(") success(");
        sb.append(z);
        sb.append(')');
        Logger.d(sb.toString(), new Object[0]);
        String str3 = "age";
        Answers.getInstance().logSignUp((SignUpEvent) new SignUpEvent().putMethod(signUpMethod.getMethod()).putSuccess(z).putCustomAttribute(str3, (Number) Integer.valueOf(i)));
        Bundle bundle = new Bundle();
        bundle.putString(str2, signUpMethod.getMethod());
        this.firebaseAnalytics.logEvent("sign_up", bundle);
        int i2 = WhenMappings.$EnumSwitchMapping$0[signUpMethod.ordinal()];
        if (i2 == 1) {
            str = "Sign Up By Email";
        } else if (i2 == 2) {
            str = "Sign Up By Kakao";
        } else if (i2 == 3) {
            str = "Sign Up By Facebook";
        } else {
            throw new NoWhenBranchMatchedException();
        }
        Answers.getInstance().logCustom((CustomEvent) new CustomEvent(str).putCustomAttribute(str3, (Number) Integer.valueOf(i)));
        Bundle bundle2 = new Bundle();
        bundle2.putInt(str3, i);
        this.firebaseAnalytics.logEvent(firebaseEventName(str), bundle2);
    }

    public void logCustom(@NotNull String str, @Nullable CustomAttributes customAttributes) {
        Intrinsics.checkParameterIsNotNull(str, "name");
        CustomEvent customEvent = new CustomEvent(str);
        Bundle bundle = new Bundle();
        if (customAttributes != null) {
            for (Entry entry : customAttributes.getAttributes().entrySet()) {
                String str2 = (String) entry.getKey();
                Object value = entry.getValue();
                if (value instanceof String) {
                    String str3 = (String) value;
                    customEvent.putCustomAttribute(str2, str3);
                    bundle.putString(str2, str3);
                } else if (value instanceof Number) {
                    Number number = (Number) value;
                    customEvent.putCustomAttribute(str2, number);
                    bundle.putInt(str2, number.intValue());
                }
            }
        }
        Answers.getInstance().logCustom(customEvent);
        this.firebaseAnalytics.logEvent(firebaseEventName(str), bundle);
    }

    public void updateDistanceHomeMy(int i) {
        Integer num = this.homeMyDistance;
        if (i > (num != null ? num.intValue() : 0)) {
            this.homeMyDistance = Integer.valueOf(i);
        }
    }

    private final void customLogAverageScrollDistanceHomeMy() {
        Integer num = this.homeMyDistance;
        if (num != null) {
            int intValue = num.intValue();
            log("Average Scroll Distance At Home My", "Distance", intValue);
            StringBuilder sb = new StringBuilder();
            sb.append("Average Scroll Distance::Home-My Distance = ");
            sb.append(intValue);
            Logger.d(sb.toString(), new Object[0]);
        }
    }

    public void updateDistanceHomeAll(int i) {
        Integer num = this.homeAllDistance;
        if (i > (num != null ? num.intValue() : 0)) {
            this.homeAllDistance = Integer.valueOf(i);
        }
    }

    private final void customLogAverageScrollDistanceHomeAll() {
        Integer num = this.homeAllDistance;
        if (num != null) {
            int intValue = num.intValue();
            log("Average Scroll Distance At Home All", "Distance", intValue);
            StringBuilder sb = new StringBuilder();
            sb.append("Average Scroll Distance::Home-All Distance = ");
            sb.append(intValue);
            Logger.d(sb.toString(), new Object[0]);
        }
    }

    public void updateDistanceStoreHome(int i) {
        Integer num = this.storeHomeDistance;
        if (i > (num != null ? num.intValue() : 0)) {
            this.storeHomeDistance = Integer.valueOf(i);
        }
    }

    private final void customLogAverageScrollDistanceStoreHome() {
        Integer num = this.storeHomeDistance;
        if (num != null) {
            int intValue = num.intValue();
            log("Average Scroll Distance At Store Home", "Distance", intValue);
            StringBuilder sb = new StringBuilder();
            sb.append("Average Scroll Distance::Store-Home Distance = ");
            sb.append(intValue);
            Logger.d(sb.toString(), new Object[0]);
        }
    }

    public void updateDistanceStoreBest(int i) {
        Integer num = this.storeBestDistance;
        if (i > (num != null ? num.intValue() : 0)) {
            this.storeBestDistance = Integer.valueOf(i);
        }
    }

    private final void customLogAverageScrollDistanceStoreBest() {
        Integer num = this.storeBestDistance;
        if (num != null) {
            int intValue = num.intValue();
            log("Average Scroll Distance At Store Best", "Distance", intValue);
            StringBuilder sb = new StringBuilder();
            sb.append("Average Scroll Distance::Store-Best Distance = ");
            sb.append(intValue);
            Logger.d(sb.toString(), new Object[0]);
        }
    }

    public void updateDistanceStoreNew(int i) {
        Integer num = this.storeNewDistance;
        if (i > (num != null ? num.intValue() : 0)) {
            this.storeNewDistance = Integer.valueOf(i);
        }
    }

    private final void customLogAverageScrollDistanceStoreNew() {
        Integer num = this.storeNewDistance;
        if (num != null) {
            int intValue = num.intValue();
            log("Average Scroll Distance At Store Sale", "Distance", intValue);
            StringBuilder sb = new StringBuilder();
            sb.append("Average Scroll Distance::Store-Sale Distance = ");
            sb.append(intValue);
            Logger.d(sb.toString(), new Object[0]);
        }
    }

    public void updateDistanceStoreList(int i) {
        Integer num = this.storeListDistance;
        if (i > (num != null ? num.intValue() : 0)) {
            this.storeListDistance = Integer.valueOf(i);
        }
    }

    private final void customLogAverageScrollDistanceStoreList() {
        Integer num = this.storeListDistance;
        if (num != null) {
            int intValue = num.intValue();
            log("Average Scroll Distance At Store Shop", "Distance", intValue);
            StringBuilder sb = new StringBuilder();
            sb.append("Average Scroll Distance::Store-List Distance = ");
            sb.append(intValue);
            Logger.d(sb.toString(), new Object[0]);
        }
    }

    public void customLogScrollDistanceHomeAndStore() {
        customLogAverageScrollDistanceHomeMy();
        customLogAverageScrollDistanceHomeAll();
        customLogAverageScrollDistanceStoreHome();
        customLogAverageScrollDistanceStoreBest();
        customLogAverageScrollDistanceStoreList();
        customLogAverageScrollDistanceStoreNew();
    }

    public void customLogOrderDetail(long j, @NotNull String str, int i) {
        Intrinsics.checkParameterIsNotNull(str, "name");
        Answers.getInstance().logPurchase(new PurchaseEvent().putItemId(String.valueOf(j)).putCurrency(Currency.getInstance("KRW")).putItemPrice(BigDecimal.valueOf((long) i)).putItemName(str).putSuccess(true));
    }

    public void customLogWishlistAdd(@NotNull String str) {
        String str2 = "from";
        Intrinsics.checkParameterIsNotNull(str, str2);
        log("Add Wishlist", str2, str);
    }

    public void customLogWishlistRemove(@NotNull String str) {
        String str2 = "from";
        Intrinsics.checkParameterIsNotNull(str, str2);
        log("Remove Wishlist", str2, str);
    }

    public void customLogViewProductNotStore(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "recognition");
        log("View Product Not In Store", "Recognition", str);
    }

    public void customLogViewWelcomNotice() {
        DefaultImpls.logCustom$default(this, "View Welcome Notice", null, 2, null);
    }

    public void customLogTapStoreTab(@NotNull String str) {
        String str2 = "tab";
        Intrinsics.checkParameterIsNotNull(str, str2);
        log("Tap Store Tab", str2, str);
    }

    public void customLogTabStoreDetailTab(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, "name");
        String str3 = "from";
        Intrinsics.checkParameterIsNotNull(str2, str3);
        log(str, str3, str2);
    }

    public void customLogTapShopList(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "from");
        log("Tap Shop", "From", str);
    }

    public void customLogTapBridgeNotStore() {
        log("Tap Bridge Not Store");
    }

    public void customLogTapSearchTab(@NotNull String str) {
        String str2 = "tab";
        Intrinsics.checkParameterIsNotNull(str, str2);
        log("Tap Search Tab", str2, str);
    }

    public void customLogTapToSwitchCategoryContent(@NotNull String str) {
        String str2 = "type";
        Intrinsics.checkParameterIsNotNull(str, str2);
        log("Tap To Switch Category Content", str2, str);
    }

    public void customLogTapSlideMenu() {
        log("Tap Slide Menu");
    }

    public void customLogTapFittieBenefit() {
        log("Tap Fittie Benfit");
    }

    public void customLogTapEventList(@NotNull String str) {
        String str2 = "from";
        Intrinsics.checkParameterIsNotNull(str, str2);
        log("Tap Event List", str2, str);
    }

    public void customLogTapRecommendedContentsList() {
        log("Tap Recommended Contents List");
    }

    public void customLogTapToMainTab(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "tab");
        log("Tap To Main Tab", "Tab", str);
    }

    public void customLogTapFittsCard() {
        log("Tap Fittscard");
    }

    public void customLogViewPost(@NotNull String str) {
        String str2 = "from";
        Intrinsics.checkParameterIsNotNull(str, str2);
        log("View Post", str2, str);
    }

    public void customLogFitpleNumber(@NotNull String str) {
        String str2 = "from";
        Intrinsics.checkParameterIsNotNull(str, str2);
        log("Open Web", str2, str);
    }

    public void customLogTapBookmarkList() {
        log("Tap Bookmark List");
    }

    public void customLogAddShopBookmark(@NotNull String str) {
        String str2 = "from";
        Intrinsics.checkParameterIsNotNull(str, str2);
        log("Add Bookmark", str2, str);
    }

    public void customLogRemoveShopBookmark(@NotNull String str) {
        String str2 = "from";
        Intrinsics.checkParameterIsNotNull(str, str2);
        log("Remove Bookmark", str2, str);
    }

    public void customLogFollowingFeed() {
        log("Tap Following Feed");
    }

    public void customLogTapHomeBanner(@NotNull String str) {
        String str2 = "from";
        Intrinsics.checkParameterIsNotNull(str, str2);
        log("Tap Home Banner", str2, str);
    }

    public void customLogEnterFittsPoint() {
        log("Tap Fitts Point");
    }

    public void customLogTapFittsTab(@NotNull String str) {
        String str2 = "from";
        Intrinsics.checkParameterIsNotNull(str, str2);
        log("Tap Fitts Point Tab", str2, str);
    }

    public void customLogEnterOrderList() {
        log("Tap Order List");
    }

    public void customLogEnterLikedPost() {
        log("Tap Liked Post");
    }

    public void customLogHomeFeedTrendTag() {
        log("Tap Trend Tag");
    }

    public void customLogCollecitonScheme() {
        log("Tap Feed Collection");
    }

    private final void log(String str) {
        Answers.getInstance().logCustom(new CustomEvent(str));
    }

    private final void log(String str, String str2, int i) {
        Answers.getInstance().logCustom((CustomEvent) new CustomEvent(str).putCustomAttribute(str2, (Number) Integer.valueOf(i)));
    }

    private final void log(String str, String str2, String str3) {
        Answers.getInstance().logCustom((CustomEvent) new CustomEvent(str).putCustomAttribute(str2, str3));
    }

    private final String firebaseEventName(String str) {
        return StringsKt__StringsJVMKt.replace$default(str, ' ', '_', false, 4, (Object) null);
    }
}
