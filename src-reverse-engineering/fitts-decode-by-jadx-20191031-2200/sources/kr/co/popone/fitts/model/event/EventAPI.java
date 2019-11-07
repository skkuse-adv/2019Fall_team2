package kr.co.popone.fitts.model.event;

import androidx.annotation.NonNull;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.gson.annotations.SerializedName;
import com.uber.rave.annotation.Validated;
import io.reactivex.Single;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.ImageUrlWithRatio;
import kr.co.popone.fitts.model.collection.CollectionAPI.CollectionDetailResponse.ButtonProperties;
import kr.co.popone.fitts.model.datamodel.commerce.Shop;
import kr.co.popone.fitts.model.validation.ValidatorFactoryImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface EventAPI {

    @Validated(factory = ValidatorFactoryImpl.class)
    public static final class AppliableEventAppliabilityCheckResponse {
        @SerializedName("code")
        private final int code;
        @SerializedName("is_available")
        private final boolean isAvailable;
        @SerializedName("message")
        @Nullable
        private final String message;

        @NotNull
        public static /* synthetic */ AppliableEventAppliabilityCheckResponse copy$default(AppliableEventAppliabilityCheckResponse appliableEventAppliabilityCheckResponse, boolean z, String str, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                z = appliableEventAppliabilityCheckResponse.isAvailable;
            }
            if ((i2 & 2) != 0) {
                str = appliableEventAppliabilityCheckResponse.message;
            }
            if ((i2 & 4) != 0) {
                i = appliableEventAppliabilityCheckResponse.code;
            }
            return appliableEventAppliabilityCheckResponse.copy(z, str, i);
        }

        public final boolean component1() {
            return this.isAvailable;
        }

        @Nullable
        public final String component2() {
            return this.message;
        }

        public final int component3() {
            return this.code;
        }

        @NotNull
        public final AppliableEventAppliabilityCheckResponse copy(boolean z, @Nullable String str, int i) {
            return new AppliableEventAppliabilityCheckResponse(z, str, i);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                if (obj instanceof AppliableEventAppliabilityCheckResponse) {
                    AppliableEventAppliabilityCheckResponse appliableEventAppliabilityCheckResponse = (AppliableEventAppliabilityCheckResponse) obj;
                    if ((this.isAvailable == appliableEventAppliabilityCheckResponse.isAvailable) && Intrinsics.areEqual((Object) this.message, (Object) appliableEventAppliabilityCheckResponse.message)) {
                        if (this.code == appliableEventAppliabilityCheckResponse.code) {
                            return true;
                        }
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            boolean z = this.isAvailable;
            if (z) {
                z = true;
            }
            int i = (z ? 1 : 0) * true;
            String str = this.message;
            return ((i + (str != null ? str.hashCode() : 0)) * 31) + this.code;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("AppliableEventAppliabilityCheckResponse(isAvailable=");
            sb.append(this.isAvailable);
            sb.append(", message=");
            sb.append(this.message);
            sb.append(", code=");
            sb.append(this.code);
            sb.append(")");
            return sb.toString();
        }

        public AppliableEventAppliabilityCheckResponse(boolean z, @Nullable String str, int i) {
            this.isAvailable = z;
            this.message = str;
            this.code = i;
        }

        public final boolean isAvailable() {
            return this.isAvailable;
        }

        @Nullable
        public final String getMessage() {
            return this.message;
        }

        public final int getCode() {
            return this.code;
        }
    }

    @Validated(factory = ValidatorFactoryImpl.class)
    public static final class AppliableEventApplyResponse {
        @SerializedName("code")
        private final int code;

        @NotNull
        public static /* synthetic */ AppliableEventApplyResponse copy$default(AppliableEventApplyResponse appliableEventApplyResponse, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = appliableEventApplyResponse.code;
            }
            return appliableEventApplyResponse.copy(i);
        }

        public final int component1() {
            return this.code;
        }

        @NotNull
        public final AppliableEventApplyResponse copy(int i) {
            return new AppliableEventApplyResponse(i);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                if (obj instanceof AppliableEventApplyResponse) {
                    if (this.code == ((AppliableEventApplyResponse) obj).code) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            return this.code;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("AppliableEventApplyResponse(code=");
            sb.append(this.code);
            sb.append(")");
            return sb.toString();
        }

        public AppliableEventApplyResponse(int i) {
            this.code = i;
        }

        public final int getCode() {
            return this.code;
        }
    }

    @Validated(factory = ValidatorFactoryImpl.class)
    public static final class AppliableEventResponse {
        @SerializedName("bottom_image")
        @Nullable
        private final ImageUrlWithRatio bottomImageUrl;
        @SerializedName("histories")
        @NotNull
        private final List<EventHistory> histories;
        private final long id;
        @SerializedName("application_items")
        @NotNull
        private final List<String> items;
        @SerializedName("shared_link")
        @Nullable
        private final String sharedLink;
        @SerializedName("status")
        @NotNull
        private final String status;
        @SerializedName("top_items")
        @NotNull
        private final List<Item> topItems;
        @SerializedName("type")
        @NotNull
        private final Type type;

        @Validated(factory = ValidatorFactoryImpl.class)
        public static final class Item {
            @NotNull
            private final List<TopImageItem> items;
            @NotNull
            private final String type;

            /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<kr.co.popone.fitts.model.event.EventAPI$TopImageItem>, for r2v0, types: [java.util.List] */
            @org.jetbrains.annotations.NotNull
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public static /* synthetic */ kr.co.popone.fitts.model.event.EventAPI.AppliableEventResponse.Item copy$default(kr.co.popone.fitts.model.event.EventAPI.AppliableEventResponse.Item r0, java.lang.String r1, java.util.List<kr.co.popone.fitts.model.event.EventAPI.TopImageItem> r2, int r3, java.lang.Object r4) {
                /*
                    r4 = r3 & 1
                    if (r4 == 0) goto L_0x0006
                    java.lang.String r1 = r0.type
                L_0x0006:
                    r3 = r3 & 2
                    if (r3 == 0) goto L_0x000c
                    java.util.List<kr.co.popone.fitts.model.event.EventAPI$TopImageItem> r2 = r0.items
                L_0x000c:
                    kr.co.popone.fitts.model.event.EventAPI$AppliableEventResponse$Item r0 = r0.copy(r1, r2)
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.event.EventAPI.AppliableEventResponse.Item.copy$default(kr.co.popone.fitts.model.event.EventAPI$AppliableEventResponse$Item, java.lang.String, java.util.List, int, java.lang.Object):kr.co.popone.fitts.model.event.EventAPI$AppliableEventResponse$Item");
            }

            @NotNull
            public final String component1() {
                return this.type;
            }

            @NotNull
            public final List<TopImageItem> component2() {
                return this.items;
            }

            @NotNull
            public final Item copy(@NotNull String str, @NotNull List<TopImageItem> list) {
                Intrinsics.checkParameterIsNotNull(str, "type");
                Intrinsics.checkParameterIsNotNull(list, "items");
                return new Item(str, list);
            }

            /* JADX WARNING: Code restructure failed: missing block: B:6:0x001a, code lost:
                if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2.items, (java.lang.Object) r3.items) != false) goto L_0x001f;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r3) {
                /*
                    r2 = this;
                    if (r2 == r3) goto L_0x001f
                    boolean r0 = r3 instanceof kr.co.popone.fitts.model.event.EventAPI.AppliableEventResponse.Item
                    if (r0 == 0) goto L_0x001d
                    kr.co.popone.fitts.model.event.EventAPI$AppliableEventResponse$Item r3 = (kr.co.popone.fitts.model.event.EventAPI.AppliableEventResponse.Item) r3
                    java.lang.String r0 = r2.type
                    java.lang.String r1 = r3.type
                    boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
                    if (r0 == 0) goto L_0x001d
                    java.util.List<kr.co.popone.fitts.model.event.EventAPI$TopImageItem> r0 = r2.items
                    java.util.List<kr.co.popone.fitts.model.event.EventAPI$TopImageItem> r3 = r3.items
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
                throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.event.EventAPI.AppliableEventResponse.Item.equals(java.lang.Object):boolean");
            }

            public int hashCode() {
                String str = this.type;
                int i = 0;
                int hashCode = (str != null ? str.hashCode() : 0) * 31;
                List<TopImageItem> list = this.items;
                if (list != null) {
                    i = list.hashCode();
                }
                return hashCode + i;
            }

            @NotNull
            public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append("Item(type=");
                sb.append(this.type);
                sb.append(", items=");
                sb.append(this.items);
                sb.append(")");
                return sb.toString();
            }

            public Item(@NotNull String str, @NotNull List<TopImageItem> list) {
                Intrinsics.checkParameterIsNotNull(str, "type");
                Intrinsics.checkParameterIsNotNull(list, "items");
                this.type = str;
                this.items = list;
            }

            @NotNull
            @NonNull
            public final String getType() {
                return this.type;
            }

            @NotNull
            @NonNull
            public final List<TopImageItem> getItems() {
                return this.items;
            }
        }

        public enum Type {
            ALL,
            COLLABORATION
        }

        @NotNull
        public static /* synthetic */ AppliableEventResponse copy$default(AppliableEventResponse appliableEventResponse, long j, Type type2, String str, List list, ImageUrlWithRatio imageUrlWithRatio, List list2, List list3, String str2, int i, Object obj) {
            AppliableEventResponse appliableEventResponse2 = appliableEventResponse;
            int i2 = i;
            return appliableEventResponse.copy((i2 & 1) != 0 ? appliableEventResponse2.id : j, (i2 & 2) != 0 ? appliableEventResponse2.type : type2, (i2 & 4) != 0 ? appliableEventResponse2.sharedLink : str, (i2 & 8) != 0 ? appliableEventResponse2.topItems : list, (i2 & 16) != 0 ? appliableEventResponse2.bottomImageUrl : imageUrlWithRatio, (i2 & 32) != 0 ? appliableEventResponse2.histories : list2, (i2 & 64) != 0 ? appliableEventResponse2.items : list3, (i2 & 128) != 0 ? appliableEventResponse2.status : str2);
        }

        public final long component1() {
            return this.id;
        }

        @NotNull
        public final Type component2() {
            return this.type;
        }

        @Nullable
        public final String component3() {
            return this.sharedLink;
        }

        @NotNull
        public final List<Item> component4() {
            return this.topItems;
        }

        @Nullable
        public final ImageUrlWithRatio component5() {
            return this.bottomImageUrl;
        }

        @NotNull
        public final List<EventHistory> component6() {
            return this.histories;
        }

        @NotNull
        public final List<String> component7() {
            return this.items;
        }

        @NotNull
        public final String component8() {
            return this.status;
        }

        @NotNull
        public final AppliableEventResponse copy(long j, @NotNull Type type2, @Nullable String str, @NotNull List<Item> list, @Nullable ImageUrlWithRatio imageUrlWithRatio, @NotNull List<EventHistory> list2, @NotNull List<String> list3, @NotNull String str2) {
            Type type3 = type2;
            Intrinsics.checkParameterIsNotNull(type2, "type");
            List<Item> list4 = list;
            Intrinsics.checkParameterIsNotNull(list4, "topItems");
            List<EventHistory> list5 = list2;
            Intrinsics.checkParameterIsNotNull(list5, "histories");
            List<String> list6 = list3;
            Intrinsics.checkParameterIsNotNull(list6, "items");
            String str3 = str2;
            Intrinsics.checkParameterIsNotNull(str3, "status");
            AppliableEventResponse appliableEventResponse = new AppliableEventResponse(j, type3, str, list4, imageUrlWithRatio, list5, list6, str3);
            return appliableEventResponse;
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                if (obj instanceof AppliableEventResponse) {
                    AppliableEventResponse appliableEventResponse = (AppliableEventResponse) obj;
                    if (!(this.id == appliableEventResponse.id) || !Intrinsics.areEqual((Object) this.type, (Object) appliableEventResponse.type) || !Intrinsics.areEqual((Object) this.sharedLink, (Object) appliableEventResponse.sharedLink) || !Intrinsics.areEqual((Object) this.topItems, (Object) appliableEventResponse.topItems) || !Intrinsics.areEqual((Object) this.bottomImageUrl, (Object) appliableEventResponse.bottomImageUrl) || !Intrinsics.areEqual((Object) this.histories, (Object) appliableEventResponse.histories) || !Intrinsics.areEqual((Object) this.items, (Object) appliableEventResponse.items) || !Intrinsics.areEqual((Object) this.status, (Object) appliableEventResponse.status)) {
                        return false;
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            long j = this.id;
            int i = ((int) (j ^ (j >>> 32))) * 31;
            Type type2 = this.type;
            int i2 = 0;
            int hashCode = (i + (type2 != null ? type2.hashCode() : 0)) * 31;
            String str = this.sharedLink;
            int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
            List<Item> list = this.topItems;
            int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 0)) * 31;
            ImageUrlWithRatio imageUrlWithRatio = this.bottomImageUrl;
            int hashCode4 = (hashCode3 + (imageUrlWithRatio != null ? imageUrlWithRatio.hashCode() : 0)) * 31;
            List<EventHistory> list2 = this.histories;
            int hashCode5 = (hashCode4 + (list2 != null ? list2.hashCode() : 0)) * 31;
            List<String> list3 = this.items;
            int hashCode6 = (hashCode5 + (list3 != null ? list3.hashCode() : 0)) * 31;
            String str2 = this.status;
            if (str2 != null) {
                i2 = str2.hashCode();
            }
            return hashCode6 + i2;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("AppliableEventResponse(id=");
            sb.append(this.id);
            sb.append(", type=");
            sb.append(this.type);
            sb.append(", sharedLink=");
            sb.append(this.sharedLink);
            sb.append(", topItems=");
            sb.append(this.topItems);
            sb.append(", bottomImageUrl=");
            sb.append(this.bottomImageUrl);
            sb.append(", histories=");
            sb.append(this.histories);
            sb.append(", items=");
            sb.append(this.items);
            sb.append(", status=");
            sb.append(this.status);
            sb.append(")");
            return sb.toString();
        }

        public AppliableEventResponse(long j, @NotNull Type type2, @Nullable String str, @NotNull List<Item> list, @Nullable ImageUrlWithRatio imageUrlWithRatio, @NotNull List<EventHistory> list2, @NotNull List<String> list3, @NotNull String str2) {
            Intrinsics.checkParameterIsNotNull(type2, "type");
            Intrinsics.checkParameterIsNotNull(list, "topItems");
            Intrinsics.checkParameterIsNotNull(list2, "histories");
            Intrinsics.checkParameterIsNotNull(list3, "items");
            Intrinsics.checkParameterIsNotNull(str2, "status");
            this.id = j;
            this.type = type2;
            this.sharedLink = str;
            this.topItems = list;
            this.bottomImageUrl = imageUrlWithRatio;
            this.histories = list2;
            this.items = list3;
            this.status = str2;
        }

        public final long getId() {
            return this.id;
        }

        @NotNull
        public final Type getType() {
            return this.type;
        }

        @Nullable
        public final String getSharedLink() {
            return this.sharedLink;
        }

        @NotNull
        @NonNull
        public final List<Item> getTopItems() {
            return this.topItems;
        }

        public /* synthetic */ AppliableEventResponse(long j, Type type2, String str, List list, ImageUrlWithRatio imageUrlWithRatio, List list2, List list3, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, type2, (i & 4) != 0 ? null : str, list, (i & 16) != 0 ? null : imageUrlWithRatio, list2, list3, str2);
        }

        @Nullable
        public final ImageUrlWithRatio getBottomImageUrl() {
            return this.bottomImageUrl;
        }

        @NotNull
        @NonNull
        public final List<EventHistory> getHistories() {
            return this.histories;
        }

        @NotNull
        @NonNull
        public final List<String> getItems() {
            return this.items;
        }

        @NotNull
        @NonNull
        public final String getStatus() {
            return this.status;
        }
    }

    @Validated(factory = ValidatorFactoryImpl.class)
    public static final class AppliableEventResultResponse {
        @SerializedName("result_image")
        @NotNull
        private final ImageUrlWithRatio topImage;
        @SerializedName("winners")
        @NotNull
        private final List<WinnerInfo> winners;

        @Validated(factory = ValidatorFactoryImpl.class)
        public static final class WinnerInfo {
            @SerializedName("fitts_id")
            @NotNull
            private final String fittsID;
            @SerializedName("link_url")
            @NotNull
            private final String linkUrl;

            @NotNull
            public static /* synthetic */ WinnerInfo copy$default(WinnerInfo winnerInfo, String str, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = winnerInfo.fittsID;
                }
                if ((i & 2) != 0) {
                    str2 = winnerInfo.linkUrl;
                }
                return winnerInfo.copy(str, str2);
            }

            @NotNull
            public final String component1() {
                return this.fittsID;
            }

            @NotNull
            public final String component2() {
                return this.linkUrl;
            }

            @NotNull
            public final WinnerInfo copy(@NotNull String str, @NotNull String str2) {
                Intrinsics.checkParameterIsNotNull(str, "fittsID");
                Intrinsics.checkParameterIsNotNull(str2, "linkUrl");
                return new WinnerInfo(str, str2);
            }

            /* JADX WARNING: Code restructure failed: missing block: B:6:0x001a, code lost:
                if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2.linkUrl, (java.lang.Object) r3.linkUrl) != false) goto L_0x001f;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r3) {
                /*
                    r2 = this;
                    if (r2 == r3) goto L_0x001f
                    boolean r0 = r3 instanceof kr.co.popone.fitts.model.event.EventAPI.AppliableEventResultResponse.WinnerInfo
                    if (r0 == 0) goto L_0x001d
                    kr.co.popone.fitts.model.event.EventAPI$AppliableEventResultResponse$WinnerInfo r3 = (kr.co.popone.fitts.model.event.EventAPI.AppliableEventResultResponse.WinnerInfo) r3
                    java.lang.String r0 = r2.fittsID
                    java.lang.String r1 = r3.fittsID
                    boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
                    if (r0 == 0) goto L_0x001d
                    java.lang.String r0 = r2.linkUrl
                    java.lang.String r3 = r3.linkUrl
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
                throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.event.EventAPI.AppliableEventResultResponse.WinnerInfo.equals(java.lang.Object):boolean");
            }

            public int hashCode() {
                String str = this.fittsID;
                int i = 0;
                int hashCode = (str != null ? str.hashCode() : 0) * 31;
                String str2 = this.linkUrl;
                if (str2 != null) {
                    i = str2.hashCode();
                }
                return hashCode + i;
            }

            @NotNull
            public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append("WinnerInfo(fittsID=");
                sb.append(this.fittsID);
                sb.append(", linkUrl=");
                sb.append(this.linkUrl);
                sb.append(")");
                return sb.toString();
            }

            public WinnerInfo(@NotNull String str, @NotNull String str2) {
                Intrinsics.checkParameterIsNotNull(str, "fittsID");
                Intrinsics.checkParameterIsNotNull(str2, "linkUrl");
                this.fittsID = str;
                this.linkUrl = str2;
            }

            @NotNull
            @NonNull
            public final String getFittsID() {
                return this.fittsID;
            }

            @NotNull
            @NonNull
            public final String getLinkUrl() {
                return this.linkUrl;
            }
        }

        /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<kr.co.popone.fitts.model.event.EventAPI$AppliableEventResultResponse$WinnerInfo>, for r2v0, types: [java.util.List] */
        @org.jetbrains.annotations.NotNull
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static /* synthetic */ kr.co.popone.fitts.model.event.EventAPI.AppliableEventResultResponse copy$default(kr.co.popone.fitts.model.event.EventAPI.AppliableEventResultResponse r0, kr.co.popone.fitts.model.ImageUrlWithRatio r1, java.util.List<kr.co.popone.fitts.model.event.EventAPI.AppliableEventResultResponse.WinnerInfo> r2, int r3, java.lang.Object r4) {
            /*
                r4 = r3 & 1
                if (r4 == 0) goto L_0x0006
                kr.co.popone.fitts.model.ImageUrlWithRatio r1 = r0.topImage
            L_0x0006:
                r3 = r3 & 2
                if (r3 == 0) goto L_0x000c
                java.util.List<kr.co.popone.fitts.model.event.EventAPI$AppliableEventResultResponse$WinnerInfo> r2 = r0.winners
            L_0x000c:
                kr.co.popone.fitts.model.event.EventAPI$AppliableEventResultResponse r0 = r0.copy(r1, r2)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.event.EventAPI.AppliableEventResultResponse.copy$default(kr.co.popone.fitts.model.event.EventAPI$AppliableEventResultResponse, kr.co.popone.fitts.model.ImageUrlWithRatio, java.util.List, int, java.lang.Object):kr.co.popone.fitts.model.event.EventAPI$AppliableEventResultResponse");
        }

        @NotNull
        public final ImageUrlWithRatio component1() {
            return this.topImage;
        }

        @NotNull
        public final List<WinnerInfo> component2() {
            return this.winners;
        }

        @NotNull
        public final AppliableEventResultResponse copy(@NotNull ImageUrlWithRatio imageUrlWithRatio, @NotNull List<WinnerInfo> list) {
            Intrinsics.checkParameterIsNotNull(imageUrlWithRatio, "topImage");
            Intrinsics.checkParameterIsNotNull(list, "winners");
            return new AppliableEventResultResponse(imageUrlWithRatio, list);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x001a, code lost:
            if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2.winners, (java.lang.Object) r3.winners) != false) goto L_0x001f;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r3) {
            /*
                r2 = this;
                if (r2 == r3) goto L_0x001f
                boolean r0 = r3 instanceof kr.co.popone.fitts.model.event.EventAPI.AppliableEventResultResponse
                if (r0 == 0) goto L_0x001d
                kr.co.popone.fitts.model.event.EventAPI$AppliableEventResultResponse r3 = (kr.co.popone.fitts.model.event.EventAPI.AppliableEventResultResponse) r3
                kr.co.popone.fitts.model.ImageUrlWithRatio r0 = r2.topImage
                kr.co.popone.fitts.model.ImageUrlWithRatio r1 = r3.topImage
                boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
                if (r0 == 0) goto L_0x001d
                java.util.List<kr.co.popone.fitts.model.event.EventAPI$AppliableEventResultResponse$WinnerInfo> r0 = r2.winners
                java.util.List<kr.co.popone.fitts.model.event.EventAPI$AppliableEventResultResponse$WinnerInfo> r3 = r3.winners
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
            throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.event.EventAPI.AppliableEventResultResponse.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            ImageUrlWithRatio imageUrlWithRatio = this.topImage;
            int i = 0;
            int hashCode = (imageUrlWithRatio != null ? imageUrlWithRatio.hashCode() : 0) * 31;
            List<WinnerInfo> list = this.winners;
            if (list != null) {
                i = list.hashCode();
            }
            return hashCode + i;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("AppliableEventResultResponse(topImage=");
            sb.append(this.topImage);
            sb.append(", winners=");
            sb.append(this.winners);
            sb.append(")");
            return sb.toString();
        }

        public AppliableEventResultResponse(@NotNull ImageUrlWithRatio imageUrlWithRatio, @NotNull List<WinnerInfo> list) {
            Intrinsics.checkParameterIsNotNull(imageUrlWithRatio, "topImage");
            Intrinsics.checkParameterIsNotNull(list, "winners");
            this.topImage = imageUrlWithRatio;
            this.winners = list;
        }

        @NotNull
        @NonNull
        public final ImageUrlWithRatio getTopImage() {
            return this.topImage;
        }

        @NotNull
        @NonNull
        public final List<WinnerInfo> getWinners() {
            return this.winners;
        }
    }

    @Validated(factory = ValidatorFactoryImpl.class)
    public static final class EventHistory {
        private final int day;
        @SerializedName("tickets")
        @NotNull
        private final List<Ticket> tickets;

        /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<kr.co.popone.fitts.model.event.EventAPI$Ticket>, for r2v0, types: [java.util.List] */
        @org.jetbrains.annotations.NotNull
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static /* synthetic */ kr.co.popone.fitts.model.event.EventAPI.EventHistory copy$default(kr.co.popone.fitts.model.event.EventAPI.EventHistory r0, int r1, java.util.List<kr.co.popone.fitts.model.event.EventAPI.Ticket> r2, int r3, java.lang.Object r4) {
            /*
                r4 = r3 & 1
                if (r4 == 0) goto L_0x0006
                int r1 = r0.day
            L_0x0006:
                r3 = r3 & 2
                if (r3 == 0) goto L_0x000c
                java.util.List<kr.co.popone.fitts.model.event.EventAPI$Ticket> r2 = r0.tickets
            L_0x000c:
                kr.co.popone.fitts.model.event.EventAPI$EventHistory r0 = r0.copy(r1, r2)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.event.EventAPI.EventHistory.copy$default(kr.co.popone.fitts.model.event.EventAPI$EventHistory, int, java.util.List, int, java.lang.Object):kr.co.popone.fitts.model.event.EventAPI$EventHistory");
        }

        public final int component1() {
            return this.day;
        }

        @NotNull
        public final List<Ticket> component2() {
            return this.tickets;
        }

        @NotNull
        public final EventHistory copy(int i, @NotNull List<Ticket> list) {
            Intrinsics.checkParameterIsNotNull(list, "tickets");
            return new EventHistory(i, list);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                if (obj instanceof EventHistory) {
                    EventHistory eventHistory = (EventHistory) obj;
                    if (!(this.day == eventHistory.day) || !Intrinsics.areEqual((Object) this.tickets, (Object) eventHistory.tickets)) {
                        return false;
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i = this.day * 31;
            List<Ticket> list = this.tickets;
            return i + (list != null ? list.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("EventHistory(day=");
            sb.append(this.day);
            sb.append(", tickets=");
            sb.append(this.tickets);
            sb.append(")");
            return sb.toString();
        }

        public EventHistory(int i, @NotNull List<Ticket> list) {
            Intrinsics.checkParameterIsNotNull(list, "tickets");
            this.day = i;
            this.tickets = list;
        }

        public final int getDay() {
            return this.day;
        }

        @NotNull
        public final List<Ticket> getTickets() {
            return this.tickets;
        }
    }

    @Validated(factory = ValidatorFactoryImpl.class)
    public static final class RemotePushContent {
        @Nullable
        private final ButtonProperties button;
        @SerializedName("images")
        @NotNull
        private final List<ImageUrlWithRatio> images;

        /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<kr.co.popone.fitts.model.ImageUrlWithRatio>, for r1v0, types: [java.util.List] */
        @org.jetbrains.annotations.NotNull
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static /* synthetic */ kr.co.popone.fitts.model.event.EventAPI.RemotePushContent copy$default(kr.co.popone.fitts.model.event.EventAPI.RemotePushContent r0, java.util.List<kr.co.popone.fitts.model.ImageUrlWithRatio> r1, kr.co.popone.fitts.model.collection.CollectionAPI.CollectionDetailResponse.ButtonProperties r2, int r3, java.lang.Object r4) {
            /*
                r4 = r3 & 1
                if (r4 == 0) goto L_0x0006
                java.util.List<kr.co.popone.fitts.model.ImageUrlWithRatio> r1 = r0.images
            L_0x0006:
                r3 = r3 & 2
                if (r3 == 0) goto L_0x000c
                kr.co.popone.fitts.model.collection.CollectionAPI$CollectionDetailResponse$ButtonProperties r2 = r0.button
            L_0x000c:
                kr.co.popone.fitts.model.event.EventAPI$RemotePushContent r0 = r0.copy(r1, r2)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.event.EventAPI.RemotePushContent.copy$default(kr.co.popone.fitts.model.event.EventAPI$RemotePushContent, java.util.List, kr.co.popone.fitts.model.collection.CollectionAPI$CollectionDetailResponse$ButtonProperties, int, java.lang.Object):kr.co.popone.fitts.model.event.EventAPI$RemotePushContent");
        }

        @NotNull
        public final List<ImageUrlWithRatio> component1() {
            return this.images;
        }

        @Nullable
        public final ButtonProperties component2() {
            return this.button;
        }

        @NotNull
        public final RemotePushContent copy(@NotNull List<ImageUrlWithRatio> list, @Nullable ButtonProperties buttonProperties) {
            Intrinsics.checkParameterIsNotNull(list, "images");
            return new RemotePushContent(list, buttonProperties);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x001a, code lost:
            if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2.button, (java.lang.Object) r3.button) != false) goto L_0x001f;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r3) {
            /*
                r2 = this;
                if (r2 == r3) goto L_0x001f
                boolean r0 = r3 instanceof kr.co.popone.fitts.model.event.EventAPI.RemotePushContent
                if (r0 == 0) goto L_0x001d
                kr.co.popone.fitts.model.event.EventAPI$RemotePushContent r3 = (kr.co.popone.fitts.model.event.EventAPI.RemotePushContent) r3
                java.util.List<kr.co.popone.fitts.model.ImageUrlWithRatio> r0 = r2.images
                java.util.List<kr.co.popone.fitts.model.ImageUrlWithRatio> r1 = r3.images
                boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
                if (r0 == 0) goto L_0x001d
                kr.co.popone.fitts.model.collection.CollectionAPI$CollectionDetailResponse$ButtonProperties r0 = r2.button
                kr.co.popone.fitts.model.collection.CollectionAPI$CollectionDetailResponse$ButtonProperties r3 = r3.button
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
            throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.event.EventAPI.RemotePushContent.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            List<ImageUrlWithRatio> list = this.images;
            int i = 0;
            int hashCode = (list != null ? list.hashCode() : 0) * 31;
            ButtonProperties buttonProperties = this.button;
            if (buttonProperties != null) {
                i = buttonProperties.hashCode();
            }
            return hashCode + i;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("RemotePushContent(images=");
            sb.append(this.images);
            sb.append(", button=");
            sb.append(this.button);
            sb.append(")");
            return sb.toString();
        }

        public RemotePushContent(@NotNull List<ImageUrlWithRatio> list, @Nullable ButtonProperties buttonProperties) {
            Intrinsics.checkParameterIsNotNull(list, "images");
            this.images = list;
            this.button = buttonProperties;
        }

        @NotNull
        @NonNull
        public final List<ImageUrlWithRatio> getImages() {
            return this.images;
        }

        @Nullable
        public final ButtonProperties getButton() {
            return this.button;
        }
    }

    @Validated(factory = ValidatorFactoryImpl.class)
    public static final class Ticket {
        @NotNull
        private final String color;
        private final long id;
        @SerializedName("is_applicable")
        private final boolean isAppliable;
        @Nullable
        private final String item;
        @SerializedName("link_url")
        @NotNull
        private final String linkUrl;
        @Nullable
        private final Shop shop;
        @NotNull
        private final String size;

        @NotNull
        public static /* synthetic */ Ticket copy$default(Ticket ticket, long j, String str, String str2, String str3, String str4, boolean z, Shop shop2, int i, Object obj) {
            Ticket ticket2 = ticket;
            return ticket.copy((i & 1) != 0 ? ticket2.id : j, (i & 2) != 0 ? ticket2.item : str, (i & 4) != 0 ? ticket2.color : str2, (i & 8) != 0 ? ticket2.size : str3, (i & 16) != 0 ? ticket2.linkUrl : str4, (i & 32) != 0 ? ticket2.isAppliable : z, (i & 64) != 0 ? ticket2.shop : shop2);
        }

        public final long component1() {
            return this.id;
        }

        @Nullable
        public final String component2() {
            return this.item;
        }

        @NotNull
        public final String component3() {
            return this.color;
        }

        @NotNull
        public final String component4() {
            return this.size;
        }

        @NotNull
        public final String component5() {
            return this.linkUrl;
        }

        public final boolean component6() {
            return this.isAppliable;
        }

        @Nullable
        public final Shop component7() {
            return this.shop;
        }

        @NotNull
        public final Ticket copy(long j, @Nullable String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, boolean z, @Nullable Shop shop2) {
            String str5 = str2;
            Intrinsics.checkParameterIsNotNull(str2, "color");
            String str6 = str3;
            Intrinsics.checkParameterIsNotNull(str3, "size");
            String str7 = str4;
            Intrinsics.checkParameterIsNotNull(str7, "linkUrl");
            Ticket ticket = new Ticket(j, str, str5, str6, str7, z, shop2);
            return ticket;
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                if (obj instanceof Ticket) {
                    Ticket ticket = (Ticket) obj;
                    if ((this.id == ticket.id) && Intrinsics.areEqual((Object) this.item, (Object) ticket.item) && Intrinsics.areEqual((Object) this.color, (Object) ticket.color) && Intrinsics.areEqual((Object) this.size, (Object) ticket.size) && Intrinsics.areEqual((Object) this.linkUrl, (Object) ticket.linkUrl)) {
                        if (!(this.isAppliable == ticket.isAppliable) || !Intrinsics.areEqual((Object) this.shop, (Object) ticket.shop)) {
                            return false;
                        }
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            long j = this.id;
            int i = ((int) (j ^ (j >>> 32))) * 31;
            String str = this.item;
            int i2 = 0;
            int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.color;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.size;
            int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.linkUrl;
            int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
            boolean z = this.isAppliable;
            if (z) {
                z = true;
            }
            int i3 = (hashCode4 + (z ? 1 : 0)) * 31;
            Shop shop2 = this.shop;
            if (shop2 != null) {
                i2 = shop2.hashCode();
            }
            return i3 + i2;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Ticket(id=");
            sb.append(this.id);
            sb.append(", item=");
            sb.append(this.item);
            sb.append(", color=");
            sb.append(this.color);
            sb.append(", size=");
            sb.append(this.size);
            sb.append(", linkUrl=");
            sb.append(this.linkUrl);
            sb.append(", isAppliable=");
            sb.append(this.isAppliable);
            sb.append(", shop=");
            sb.append(this.shop);
            sb.append(")");
            return sb.toString();
        }

        public Ticket(long j, @Nullable String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, boolean z, @Nullable Shop shop2) {
            Intrinsics.checkParameterIsNotNull(str2, "color");
            Intrinsics.checkParameterIsNotNull(str3, "size");
            Intrinsics.checkParameterIsNotNull(str4, "linkUrl");
            this.id = j;
            this.item = str;
            this.color = str2;
            this.size = str3;
            this.linkUrl = str4;
            this.isAppliable = z;
            this.shop = shop2;
        }

        public final long getId() {
            return this.id;
        }

        @Nullable
        public final String getItem() {
            return this.item;
        }

        @NotNull
        @NonNull
        public final String getColor() {
            return this.color;
        }

        @NotNull
        @NonNull
        public final String getSize() {
            return this.size;
        }

        @NotNull
        @NonNull
        public final String getLinkUrl() {
            return this.linkUrl;
        }

        public final boolean isAppliable() {
            return this.isAppliable;
        }

        @Nullable
        public final Shop getShop() {
            return this.shop;
        }
    }

    @Validated(factory = ValidatorFactoryImpl.class)
    public static final class TopImageItem {
        @NotNull
        private final ImageUrlWithRatio image;
        @SerializedName("link_url")
        @Nullable
        private final String linkUrl;
        @SerializedName("shop")
        @Nullable
        private final Shop shop;

        @NotNull
        public static /* synthetic */ TopImageItem copy$default(TopImageItem topImageItem, ImageUrlWithRatio imageUrlWithRatio, String str, Shop shop2, int i, Object obj) {
            if ((i & 1) != 0) {
                imageUrlWithRatio = topImageItem.image;
            }
            if ((i & 2) != 0) {
                str = topImageItem.linkUrl;
            }
            if ((i & 4) != 0) {
                shop2 = topImageItem.shop;
            }
            return topImageItem.copy(imageUrlWithRatio, str, shop2);
        }

        @NotNull
        public final ImageUrlWithRatio component1() {
            return this.image;
        }

        @Nullable
        public final String component2() {
            return this.linkUrl;
        }

        @Nullable
        public final Shop component3() {
            return this.shop;
        }

        @NotNull
        public final TopImageItem copy(@NotNull ImageUrlWithRatio imageUrlWithRatio, @Nullable String str, @Nullable Shop shop2) {
            Intrinsics.checkParameterIsNotNull(imageUrlWithRatio, MessengerShareContentUtility.MEDIA_IMAGE);
            return new TopImageItem(imageUrlWithRatio, str, shop2);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0024, code lost:
            if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2.shop, (java.lang.Object) r3.shop) != false) goto L_0x0029;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r3) {
            /*
                r2 = this;
                if (r2 == r3) goto L_0x0029
                boolean r0 = r3 instanceof kr.co.popone.fitts.model.event.EventAPI.TopImageItem
                if (r0 == 0) goto L_0x0027
                kr.co.popone.fitts.model.event.EventAPI$TopImageItem r3 = (kr.co.popone.fitts.model.event.EventAPI.TopImageItem) r3
                kr.co.popone.fitts.model.ImageUrlWithRatio r0 = r2.image
                kr.co.popone.fitts.model.ImageUrlWithRatio r1 = r3.image
                boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
                if (r0 == 0) goto L_0x0027
                java.lang.String r0 = r2.linkUrl
                java.lang.String r1 = r3.linkUrl
                boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
                if (r0 == 0) goto L_0x0027
                kr.co.popone.fitts.model.datamodel.commerce.Shop r0 = r2.shop
                kr.co.popone.fitts.model.datamodel.commerce.Shop r3 = r3.shop
                boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r3)
                if (r3 == 0) goto L_0x0027
                goto L_0x0029
            L_0x0027:
                r3 = 0
                return r3
            L_0x0029:
                r3 = 1
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.event.EventAPI.TopImageItem.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            ImageUrlWithRatio imageUrlWithRatio = this.image;
            int i = 0;
            int hashCode = (imageUrlWithRatio != null ? imageUrlWithRatio.hashCode() : 0) * 31;
            String str = this.linkUrl;
            int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
            Shop shop2 = this.shop;
            if (shop2 != null) {
                i = shop2.hashCode();
            }
            return hashCode2 + i;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("TopImageItem(image=");
            sb.append(this.image);
            sb.append(", linkUrl=");
            sb.append(this.linkUrl);
            sb.append(", shop=");
            sb.append(this.shop);
            sb.append(")");
            return sb.toString();
        }

        public TopImageItem(@NotNull ImageUrlWithRatio imageUrlWithRatio, @Nullable String str, @Nullable Shop shop2) {
            Intrinsics.checkParameterIsNotNull(imageUrlWithRatio, MessengerShareContentUtility.MEDIA_IMAGE);
            this.image = imageUrlWithRatio;
            this.linkUrl = str;
            this.shop = shop2;
        }

        @NotNull
        @NonNull
        public final ImageUrlWithRatio getImage() {
            return this.image;
        }

        @Nullable
        public final String getLinkUrl() {
            return this.linkUrl;
        }

        @Nullable
        public final Shop getShop() {
            return this.shop;
        }
    }

    @NotNull
    @GET("/api/v9/application_events/{id}/agreement")
    @Headers({"Accept: application/json"})
    Single<ImageUrlWithRatio> requestAgreementImage(@Path("id") long j);

    @NotNull
    @GET("/api/v9/application_events/{id}")
    @Headers({"Accept: application/json"})
    Single<AppliableEventResponse> requestAppliableEvent(@Path("id") long j);

    @NotNull
    @GET("/api/v9/application_events/{id}/apply_available")
    @Headers({"Accept: application/json"})
    Single<AppliableEventAppliabilityCheckResponse> requestAppliableEventAppliable(@Path("id") long j, @Nullable @Query("shop_id") Long l);

    @FormUrlEncoded
    @NotNull
    @POST("/api/v9/application_events/{id}/apply")
    @Headers({"Accept: application/json"})
    Single<AppliableEventApplyResponse> requestAppliableEventApply(@Path("id") long j, @Field("item") @Nullable String str, @NotNull @Field("size") String str2, @NotNull @Field("color") String str3, @NotNull @Field("link_url") String str4, @Field("shop_id") @Nullable Long l);

    @NotNull
    @GET("/api/v9/application_events/{id}/result")
    @Headers({"Accept: application/json"})
    Single<AppliableEventResultResponse> requestAppliableEventResult(@Path("id") long j);

    @FormUrlEncoded
    @NotNull
    @POST("/api/v9/application_tickets/{id}/enroll")
    @Headers({"Accept: application/json"})
    Single<AppliableEventApplyResponse> requestEnrollTicket(@Path("id") long j, @NotNull @Field("shipping_name") String str, @NotNull @Field("shipping_contact") String str2, @NotNull @Field("shipping_zipcode") String str3, @NotNull @Field("shipping_address") String str4, @Field("shipping_address2") @Nullable String str5, @Field("shipping_message") @Nullable String str6, @Field("ssn") @Nullable String str7);

    @NotNull
    @GET("/api/v9/remote_push_contents/{id}")
    @Headers({"Accept: application/json"})
    Single<RemotePushContent> requestRemotePushContent(@Path("id") long j);

    @NotNull
    @GET("/api/v9/application_tickets/{id}")
    @Headers({"Accept: application/json"})
    Single<Ticket> requestTicketInfo(@Path("id") long j);
}
