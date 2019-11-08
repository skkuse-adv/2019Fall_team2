package kr.co.popone.fitts.eventtracker;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface EventTracker {

    public static final class CustomAttributes {
        @NotNull
        private final Map<String, Object> attributes = new LinkedHashMap();

        @NotNull
        public final Map<String, Object> getAttributes() {
            return this.attributes;
        }

        @NotNull
        public final CustomAttributes put(@NotNull String str, @NotNull String str2) {
            Intrinsics.checkParameterIsNotNull(str, "name");
            Intrinsics.checkParameterIsNotNull(str2, "value");
            this.attributes.put(str, str2);
            return this;
        }

        @NotNull
        public final CustomAttributes put(@NotNull String str, int i) {
            Intrinsics.checkParameterIsNotNull(str, "name");
            this.attributes.put(str, Integer.valueOf(i));
            return this;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("{attributes: ");
            sb.append(this.attributes);
            sb.append('}');
            return sb.toString();
        }
    }

    public static final class DefaultImpls {
        public static /* synthetic */ void logSignUp$default(EventTracker eventTracker, SignUpMethod signUpMethod, int i, boolean z, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 4) != 0) {
                    z = true;
                }
                eventTracker.logSignUp(signUpMethod, i, z);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: logSignUp");
        }

        public static /* synthetic */ void logCustom$default(EventTracker eventTracker, String str, CustomAttributes customAttributes, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    customAttributes = null;
                }
                eventTracker.logCustom(str, customAttributes);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: logCustom");
        }
    }

    public enum SignUpMethod {
        EMAIL("email"),
        KAKAO("kakao"),
        FACEBOOK("facebook");
        
        @NotNull
        private final String method;

        private SignUpMethod(String str) {
            this.method = str;
        }

        @NotNull
        public final String getMethod() {
            return this.method;
        }
    }

    void customLogAddShopBookmark(@NotNull String str);

    void customLogCollecitonScheme();

    void customLogEnterFittsPoint();

    void customLogEnterLikedPost();

    void customLogEnterOrderList();

    void customLogFitpleNumber(@NotNull String str);

    void customLogFollowingFeed();

    void customLogHomeFeedTrendTag();

    void customLogOrderDetail(long j, @NotNull String str, int i);

    void customLogRemoveShopBookmark(@NotNull String str);

    void customLogScrollDistanceHomeAndStore();

    void customLogTabStoreDetailTab(@NotNull String str, @NotNull String str2);

    void customLogTapBookmarkList();

    void customLogTapBridgeNotStore();

    void customLogTapEventList(@NotNull String str);

    void customLogTapFittieBenefit();

    void customLogTapFittsCard();

    void customLogTapFittsTab(@NotNull String str);

    void customLogTapHomeBanner(@NotNull String str);

    void customLogTapRecommendedContentsList();

    void customLogTapSearchTab(@NotNull String str);

    void customLogTapShopList(@NotNull String str);

    void customLogTapSlideMenu();

    void customLogTapStoreTab(@NotNull String str);

    void customLogTapToMainTab(@NotNull String str);

    void customLogTapToSwitchCategoryContent(@NotNull String str);

    void customLogViewPost(@NotNull String str);

    void customLogViewProductNotStore(@NotNull String str);

    void customLogViewWelcomNotice();

    void customLogWishlistAdd(@NotNull String str);

    void customLogWishlistRemove(@NotNull String str);

    void logCustom(@NotNull String str, @Nullable CustomAttributes customAttributes);

    void logSignUp(@NotNull SignUpMethod signUpMethod, int i, boolean z);

    void updateDistanceHomeAll(int i);

    void updateDistanceHomeMy(int i);

    void updateDistanceStoreBest(int i);

    void updateDistanceStoreHome(int i);

    void updateDistanceStoreList(int i);

    void updateDistanceStoreNew(int i);
}
