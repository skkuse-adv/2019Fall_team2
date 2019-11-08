package kr.co.popone.fitts.model.store;

import com.facebook.internal.ServerProtocol;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class ProductBridgeViewData {

    public static final class FeedType extends ProductBridgeViewData {
        @Nullable
        private final Integer discountPercentage;
        private final long id;
        @NotNull
        private final String imageUrl;
        @NotNull
        private final String linkUrl;
        @Nullable
        private final String mobileLinkUrl;
        private final long originPrice;
        private final long salsePrice;
        @NotNull
        private final String state;
        @NotNull
        private final String title;

        @NotNull
        public static /* synthetic */ FeedType copy$default(FeedType feedType, long j, String str, String str2, String str3, String str4, long j2, long j3, Integer num, String str5, int i, Object obj) {
            FeedType feedType2 = feedType;
            int i2 = i;
            return feedType.copy((i2 & 1) != 0 ? feedType2.id : j, (i2 & 2) != 0 ? feedType2.title : str, (i2 & 4) != 0 ? feedType2.imageUrl : str2, (i2 & 8) != 0 ? feedType2.linkUrl : str3, (i2 & 16) != 0 ? feedType2.mobileLinkUrl : str4, (i2 & 32) != 0 ? feedType2.originPrice : j2, (i2 & 64) != 0 ? feedType2.salsePrice : j3, (i2 & 128) != 0 ? feedType2.discountPercentage : num, (i2 & 256) != 0 ? feedType2.state : str5);
        }

        public final long component1() {
            return this.id;
        }

        @NotNull
        public final String component2() {
            return this.title;
        }

        @NotNull
        public final String component3() {
            return this.imageUrl;
        }

        @NotNull
        public final String component4() {
            return this.linkUrl;
        }

        @Nullable
        public final String component5() {
            return this.mobileLinkUrl;
        }

        public final long component6() {
            return this.originPrice;
        }

        public final long component7() {
            return this.salsePrice;
        }

        @Nullable
        public final Integer component8() {
            return this.discountPercentage;
        }

        @NotNull
        public final String component9() {
            return this.state;
        }

        @NotNull
        public final FeedType copy(long j, @NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable String str4, long j2, long j3, @Nullable Integer num, @NotNull String str5) {
            String str6 = str;
            Intrinsics.checkParameterIsNotNull(str6, "title");
            String str7 = str2;
            Intrinsics.checkParameterIsNotNull(str7, "imageUrl");
            String str8 = str3;
            Intrinsics.checkParameterIsNotNull(str8, "linkUrl");
            String str9 = str5;
            Intrinsics.checkParameterIsNotNull(str9, ServerProtocol.DIALOG_PARAM_STATE);
            FeedType feedType = new FeedType(j, str6, str7, str8, str4, j2, j3, num, str9);
            return feedType;
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                if (obj instanceof FeedType) {
                    FeedType feedType = (FeedType) obj;
                    if ((this.id == feedType.id) && Intrinsics.areEqual((Object) this.title, (Object) feedType.title) && Intrinsics.areEqual((Object) this.imageUrl, (Object) feedType.imageUrl) && Intrinsics.areEqual((Object) this.linkUrl, (Object) feedType.linkUrl) && Intrinsics.areEqual((Object) this.mobileLinkUrl, (Object) feedType.mobileLinkUrl)) {
                        if (this.originPrice == feedType.originPrice) {
                            if (!(this.salsePrice == feedType.salsePrice) || !Intrinsics.areEqual((Object) this.discountPercentage, (Object) feedType.discountPercentage) || !Intrinsics.areEqual((Object) this.state, (Object) feedType.state)) {
                                return false;
                            }
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
            String str = this.title;
            int i2 = 0;
            int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.imageUrl;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.linkUrl;
            int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.mobileLinkUrl;
            int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
            long j2 = this.originPrice;
            int i3 = (hashCode4 + ((int) (j2 ^ (j2 >>> 32)))) * 31;
            long j3 = this.salsePrice;
            int i4 = (i3 + ((int) (j3 ^ (j3 >>> 32)))) * 31;
            Integer num = this.discountPercentage;
            int hashCode5 = (i4 + (num != null ? num.hashCode() : 0)) * 31;
            String str5 = this.state;
            if (str5 != null) {
                i2 = str5.hashCode();
            }
            return hashCode5 + i2;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("FeedType(id=");
            sb.append(this.id);
            sb.append(", title=");
            sb.append(this.title);
            sb.append(", imageUrl=");
            sb.append(this.imageUrl);
            sb.append(", linkUrl=");
            sb.append(this.linkUrl);
            sb.append(", mobileLinkUrl=");
            sb.append(this.mobileLinkUrl);
            sb.append(", originPrice=");
            sb.append(this.originPrice);
            sb.append(", salsePrice=");
            sb.append(this.salsePrice);
            sb.append(", discountPercentage=");
            sb.append(this.discountPercentage);
            sb.append(", state=");
            sb.append(this.state);
            sb.append(")");
            return sb.toString();
        }

        public final long getId() {
            return this.id;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        @NotNull
        public final String getImageUrl() {
            return this.imageUrl;
        }

        @NotNull
        public final String getLinkUrl() {
            return this.linkUrl;
        }

        @Nullable
        public final String getMobileLinkUrl() {
            return this.mobileLinkUrl;
        }

        public final long getOriginPrice() {
            return this.originPrice;
        }

        public final long getSalsePrice() {
            return this.salsePrice;
        }

        @Nullable
        public final Integer getDiscountPercentage() {
            return this.discountPercentage;
        }

        public FeedType(long j, @NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable String str4, long j2, long j3, @Nullable Integer num, @NotNull String str5) {
            Intrinsics.checkParameterIsNotNull(str, "title");
            Intrinsics.checkParameterIsNotNull(str2, "imageUrl");
            Intrinsics.checkParameterIsNotNull(str3, "linkUrl");
            Intrinsics.checkParameterIsNotNull(str5, ServerProtocol.DIALOG_PARAM_STATE);
            super(null);
            this.id = j;
            this.title = str;
            this.imageUrl = str2;
            this.linkUrl = str3;
            this.mobileLinkUrl = str4;
            this.originPrice = j2;
            this.salsePrice = j3;
            this.discountPercentage = num;
            this.state = str5;
        }

        @NotNull
        public final String getState() {
            return this.state;
        }
    }

    public static final class HeaderType extends ProductBridgeViewData {
        @Nullable
        private final String headerImage;
        @NotNull
        private final String linkUrl;
        @Nullable
        private final String productName;
        @Nullable
        private final String productPrice;
        @Nullable
        private final String shopName;

        @NotNull
        public static /* synthetic */ HeaderType copy$default(HeaderType headerType, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
            if ((i & 1) != 0) {
                str = headerType.headerImage;
            }
            if ((i & 2) != 0) {
                str2 = headerType.linkUrl;
            }
            String str6 = str2;
            if ((i & 4) != 0) {
                str3 = headerType.shopName;
            }
            String str7 = str3;
            if ((i & 8) != 0) {
                str4 = headerType.productName;
            }
            String str8 = str4;
            if ((i & 16) != 0) {
                str5 = headerType.productPrice;
            }
            return headerType.copy(str, str6, str7, str8, str5);
        }

        @Nullable
        public final String component1() {
            return this.headerImage;
        }

        @NotNull
        public final String component2() {
            return this.linkUrl;
        }

        @Nullable
        public final String component3() {
            return this.shopName;
        }

        @Nullable
        public final String component4() {
            return this.productName;
        }

        @Nullable
        public final String component5() {
            return this.productPrice;
        }

        @NotNull
        public final HeaderType copy(@Nullable String str, @NotNull String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
            Intrinsics.checkParameterIsNotNull(str2, "linkUrl");
            HeaderType headerType = new HeaderType(str, str2, str3, str4, str5);
            return headerType;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0038, code lost:
            if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2.productPrice, (java.lang.Object) r3.productPrice) != false) goto L_0x003d;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r3) {
            /*
                r2 = this;
                if (r2 == r3) goto L_0x003d
                boolean r0 = r3 instanceof kr.co.popone.fitts.model.store.ProductBridgeViewData.HeaderType
                if (r0 == 0) goto L_0x003b
                kr.co.popone.fitts.model.store.ProductBridgeViewData$HeaderType r3 = (kr.co.popone.fitts.model.store.ProductBridgeViewData.HeaderType) r3
                java.lang.String r0 = r2.headerImage
                java.lang.String r1 = r3.headerImage
                boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
                if (r0 == 0) goto L_0x003b
                java.lang.String r0 = r2.linkUrl
                java.lang.String r1 = r3.linkUrl
                boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
                if (r0 == 0) goto L_0x003b
                java.lang.String r0 = r2.shopName
                java.lang.String r1 = r3.shopName
                boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
                if (r0 == 0) goto L_0x003b
                java.lang.String r0 = r2.productName
                java.lang.String r1 = r3.productName
                boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
                if (r0 == 0) goto L_0x003b
                java.lang.String r0 = r2.productPrice
                java.lang.String r3 = r3.productPrice
                boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r3)
                if (r3 == 0) goto L_0x003b
                goto L_0x003d
            L_0x003b:
                r3 = 0
                return r3
            L_0x003d:
                r3 = 1
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.store.ProductBridgeViewData.HeaderType.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            String str = this.headerImage;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.linkUrl;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.shopName;
            int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.productName;
            int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
            String str5 = this.productPrice;
            if (str5 != null) {
                i = str5.hashCode();
            }
            return hashCode4 + i;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("HeaderType(headerImage=");
            sb.append(this.headerImage);
            sb.append(", linkUrl=");
            sb.append(this.linkUrl);
            sb.append(", shopName=");
            sb.append(this.shopName);
            sb.append(", productName=");
            sb.append(this.productName);
            sb.append(", productPrice=");
            sb.append(this.productPrice);
            sb.append(")");
            return sb.toString();
        }

        @Nullable
        public final String getHeaderImage() {
            return this.headerImage;
        }

        @NotNull
        public final String getLinkUrl() {
            return this.linkUrl;
        }

        @Nullable
        public final String getShopName() {
            return this.shopName;
        }

        @Nullable
        public final String getProductName() {
            return this.productName;
        }

        public HeaderType(@Nullable String str, @NotNull String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
            Intrinsics.checkParameterIsNotNull(str2, "linkUrl");
            super(null);
            this.headerImage = str;
            this.linkUrl = str2;
            this.shopName = str3;
            this.productName = str4;
            this.productPrice = str5;
        }

        @Nullable
        public final String getProductPrice() {
            return this.productPrice;
        }
    }

    public static final class ImageType extends ProductBridgeViewData {
        private final double imageRatio;
        @Nullable
        private final String imageUrl;
        @Nullable
        private final String scheme;

        @NotNull
        public static /* synthetic */ ImageType copy$default(ImageType imageType, String str, double d, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = imageType.imageUrl;
            }
            if ((i & 2) != 0) {
                d = imageType.imageRatio;
            }
            if ((i & 4) != 0) {
                str2 = imageType.scheme;
            }
            return imageType.copy(str, d, str2);
        }

        @Nullable
        public final String component1() {
            return this.imageUrl;
        }

        public final double component2() {
            return this.imageRatio;
        }

        @Nullable
        public final String component3() {
            return this.scheme;
        }

        @NotNull
        public final ImageType copy(@Nullable String str, double d, @Nullable String str2) {
            return new ImageType(str, d, str2);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0024, code lost:
            if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4.scheme, (java.lang.Object) r5.scheme) != false) goto L_0x0029;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r5) {
            /*
                r4 = this;
                if (r4 == r5) goto L_0x0029
                boolean r0 = r5 instanceof kr.co.popone.fitts.model.store.ProductBridgeViewData.ImageType
                if (r0 == 0) goto L_0x0027
                kr.co.popone.fitts.model.store.ProductBridgeViewData$ImageType r5 = (kr.co.popone.fitts.model.store.ProductBridgeViewData.ImageType) r5
                java.lang.String r0 = r4.imageUrl
                java.lang.String r1 = r5.imageUrl
                boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
                if (r0 == 0) goto L_0x0027
                double r0 = r4.imageRatio
                double r2 = r5.imageRatio
                int r0 = java.lang.Double.compare(r0, r2)
                if (r0 != 0) goto L_0x0027
                java.lang.String r0 = r4.scheme
                java.lang.String r5 = r5.scheme
                boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r5)
                if (r5 == 0) goto L_0x0027
                goto L_0x0029
            L_0x0027:
                r5 = 0
                return r5
            L_0x0029:
                r5 = 1
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.store.ProductBridgeViewData.ImageType.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            String str = this.imageUrl;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            long doubleToLongBits = Double.doubleToLongBits(this.imageRatio);
            int i2 = (hashCode + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31;
            String str2 = this.scheme;
            if (str2 != null) {
                i = str2.hashCode();
            }
            return i2 + i;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("ImageType(imageUrl=");
            sb.append(this.imageUrl);
            sb.append(", imageRatio=");
            sb.append(this.imageRatio);
            sb.append(", scheme=");
            sb.append(this.scheme);
            sb.append(")");
            return sb.toString();
        }

        @Nullable
        public final String getImageUrl() {
            return this.imageUrl;
        }

        public final double getImageRatio() {
            return this.imageRatio;
        }

        public ImageType(@Nullable String str, double d, @Nullable String str2) {
            super(null);
            this.imageUrl = str;
            this.imageRatio = d;
            this.scheme = str2;
        }

        @Nullable
        public final String getScheme() {
            return this.scheme;
        }
    }

    private ProductBridgeViewData() {
    }

    public /* synthetic */ ProductBridgeViewData(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
