package kr.co.popone.fitts.model.search;

import androidx.annotation.NonNull;
import com.google.gson.annotations.SerializedName;
import com.kakao.message.template.MessageTemplateProtocol;
import com.uber.rave.annotation.Validated;
import io.reactivex.Single;
import java.util.Date;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.datamodel.commerce.Product;
import kr.co.popone.fitts.model.datamodel.commerce.Shop;
import kr.co.popone.fitts.model.datamodel.service.user.User;
import kr.co.popone.fitts.model.post.PostAPI.Category;
import kr.co.popone.fitts.model.post.PostAPI.Post;
import kr.co.popone.fitts.model.remote.search.KeywordSearchFittieResult;
import kr.co.popone.fitts.model.remote.search.KeywordSearchPostResult;
import kr.co.popone.fitts.model.remote.search.KeywordSearchProductResult;
import kr.co.popone.fitts.model.store.StoreInfo;
import kr.co.popone.fitts.model.validation.ValidatorFactoryImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface SearchAPI {

    @Validated(factory = ValidatorFactoryImpl.class)
    public static final class BadgeResponse {
        private final int count;

        @NotNull
        public static /* synthetic */ BadgeResponse copy$default(BadgeResponse badgeResponse, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = badgeResponse.count;
            }
            return badgeResponse.copy(i);
        }

        public final int component1() {
            return this.count;
        }

        @NotNull
        public final BadgeResponse copy(int i) {
            return new BadgeResponse(i);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                if (obj instanceof BadgeResponse) {
                    if (this.count == ((BadgeResponse) obj).count) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            return this.count;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("BadgeResponse(count=");
            sb.append(this.count);
            sb.append(")");
            return sb.toString();
        }

        public BadgeResponse(int i) {
            this.count = i;
        }

        public final int getCount() {
            return this.count;
        }
    }

    @Validated(factory = ValidatorFactoryImpl.class)
    public static final class Comment {
        @NotNull
        private final String content;
        private final long id;
        @NotNull
        private final Map<String, MentioneeInfo> mentionees;
        @NotNull
        private final User user;

        @Validated(factory = ValidatorFactoryImpl.class)
        public static final class MentioneeInfo {
            private final long id;
            @SerializedName("fittie")
            private final boolean isFittie;

            @NotNull
            public static /* synthetic */ MentioneeInfo copy$default(MentioneeInfo mentioneeInfo, long j, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = mentioneeInfo.id;
                }
                if ((i & 2) != 0) {
                    z = mentioneeInfo.isFittie;
                }
                return mentioneeInfo.copy(j, z);
            }

            public final long component1() {
                return this.id;
            }

            public final boolean component2() {
                return this.isFittie;
            }

            @NotNull
            public final MentioneeInfo copy(long j, boolean z) {
                return new MentioneeInfo(j, z);
            }

            public boolean equals(@Nullable Object obj) {
                if (this != obj) {
                    if (obj instanceof MentioneeInfo) {
                        MentioneeInfo mentioneeInfo = (MentioneeInfo) obj;
                        if (this.id == mentioneeInfo.id) {
                            if (this.isFittie == mentioneeInfo.isFittie) {
                                return true;
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
                boolean z = this.isFittie;
                if (z) {
                    z = true;
                }
                return i + (z ? 1 : 0);
            }

            @NotNull
            public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append("MentioneeInfo(id=");
                sb.append(this.id);
                sb.append(", isFittie=");
                sb.append(this.isFittie);
                sb.append(")");
                return sb.toString();
            }

            public MentioneeInfo(long j, boolean z) {
                this.id = j;
                this.isFittie = z;
            }

            @NonNull
            public final long getId() {
                return this.id;
            }

            @NonNull
            public final boolean isFittie() {
                return this.isFittie;
            }
        }

        /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.Map, code=java.util.Map<java.lang.String, kr.co.popone.fitts.model.search.SearchAPI$Comment$MentioneeInfo>, for r11v0, types: [java.util.Map] */
        @org.jetbrains.annotations.NotNull
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static /* synthetic */ kr.co.popone.fitts.model.search.SearchAPI.Comment copy$default(kr.co.popone.fitts.model.search.SearchAPI.Comment r6, long r7, kr.co.popone.fitts.model.datamodel.service.user.User r9, java.lang.String r10, java.util.Map<java.lang.String, kr.co.popone.fitts.model.search.SearchAPI.Comment.MentioneeInfo> r11, int r12, java.lang.Object r13) {
            /*
                r13 = r12 & 1
                if (r13 == 0) goto L_0x0006
                long r7 = r6.id
            L_0x0006:
                r1 = r7
                r7 = r12 & 2
                if (r7 == 0) goto L_0x000d
                kr.co.popone.fitts.model.datamodel.service.user.User r9 = r6.user
            L_0x000d:
                r3 = r9
                r7 = r12 & 4
                if (r7 == 0) goto L_0x0014
                java.lang.String r10 = r6.content
            L_0x0014:
                r4 = r10
                r7 = r12 & 8
                if (r7 == 0) goto L_0x001b
                java.util.Map<java.lang.String, kr.co.popone.fitts.model.search.SearchAPI$Comment$MentioneeInfo> r11 = r6.mentionees
            L_0x001b:
                r5 = r11
                r0 = r6
                kr.co.popone.fitts.model.search.SearchAPI$Comment r6 = r0.copy(r1, r3, r4, r5)
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.search.SearchAPI.Comment.copy$default(kr.co.popone.fitts.model.search.SearchAPI$Comment, long, kr.co.popone.fitts.model.datamodel.service.user.User, java.lang.String, java.util.Map, int, java.lang.Object):kr.co.popone.fitts.model.search.SearchAPI$Comment");
        }

        public final long component1() {
            return this.id;
        }

        @NotNull
        public final User component2() {
            return this.user;
        }

        @NotNull
        public final String component3() {
            return this.content;
        }

        @NotNull
        public final Map<String, MentioneeInfo> component4() {
            return this.mentionees;
        }

        @NotNull
        public final Comment copy(long j, @NotNull User user2, @NotNull String str, @NotNull Map<String, MentioneeInfo> map) {
            Intrinsics.checkParameterIsNotNull(user2, "user");
            Intrinsics.checkParameterIsNotNull(str, MessageTemplateProtocol.CONTENT);
            Intrinsics.checkParameterIsNotNull(map, "mentionees");
            Comment comment = new Comment(j, user2, str, map);
            return comment;
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                if (obj instanceof Comment) {
                    Comment comment = (Comment) obj;
                    if (!(this.id == comment.id) || !Intrinsics.areEqual((Object) this.user, (Object) comment.user) || !Intrinsics.areEqual((Object) this.content, (Object) comment.content) || !Intrinsics.areEqual((Object) this.mentionees, (Object) comment.mentionees)) {
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
            User user2 = this.user;
            int i2 = 0;
            int hashCode = (i + (user2 != null ? user2.hashCode() : 0)) * 31;
            String str = this.content;
            int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
            Map<String, MentioneeInfo> map = this.mentionees;
            if (map != null) {
                i2 = map.hashCode();
            }
            return hashCode2 + i2;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Comment(id=");
            sb.append(this.id);
            sb.append(", user=");
            sb.append(this.user);
            sb.append(", content=");
            sb.append(this.content);
            sb.append(", mentionees=");
            sb.append(this.mentionees);
            sb.append(")");
            return sb.toString();
        }

        public Comment(long j, @NotNull User user2, @NotNull String str, @NotNull Map<String, MentioneeInfo> map) {
            Intrinsics.checkParameterIsNotNull(user2, "user");
            Intrinsics.checkParameterIsNotNull(str, MessageTemplateProtocol.CONTENT);
            Intrinsics.checkParameterIsNotNull(map, "mentionees");
            this.id = j;
            this.user = user2;
            this.content = str;
            this.mentionees = map;
        }

        @NonNull
        public final long getId() {
            return this.id;
        }

        @NotNull
        public final User getUser() {
            return this.user;
        }

        @NotNull
        public final String getContent() {
            return this.content;
        }

        @NotNull
        public final Map<String, MentioneeInfo> getMentionees() {
            return this.mentionees;
        }
    }

    @Validated(factory = ValidatorFactoryImpl.class)
    public static final class Image {
        @SerializedName("dominant_color")
        @NotNull
        private final String dominantColor;
        private final int height;
        private final long id;
        @SerializedName("thumbnail")
        @NotNull
        private final String thumbnailUrl;
        @NotNull
        private final String url;
        private final int width;

        @NotNull
        public static /* synthetic */ Image copy$default(Image image, long j, String str, String str2, String str3, int i, int i2, int i3, Object obj) {
            Image image2 = image;
            return image.copy((i3 & 1) != 0 ? image2.id : j, (i3 & 2) != 0 ? image2.url : str, (i3 & 4) != 0 ? image2.thumbnailUrl : str2, (i3 & 8) != 0 ? image2.dominantColor : str3, (i3 & 16) != 0 ? image2.width : i, (i3 & 32) != 0 ? image2.height : i2);
        }

        public final long component1() {
            return this.id;
        }

        @NotNull
        public final String component2() {
            return this.url;
        }

        @NotNull
        public final String component3() {
            return this.thumbnailUrl;
        }

        @NotNull
        public final String component4() {
            return this.dominantColor;
        }

        public final int component5() {
            return this.width;
        }

        public final int component6() {
            return this.height;
        }

        @NotNull
        public final Image copy(long j, @NotNull String str, @NotNull String str2, @NotNull String str3, int i, int i2) {
            String str4 = str;
            Intrinsics.checkParameterIsNotNull(str, "url");
            String str5 = str2;
            Intrinsics.checkParameterIsNotNull(str2, "thumbnailUrl");
            String str6 = str3;
            Intrinsics.checkParameterIsNotNull(str3, "dominantColor");
            Image image = new Image(j, str4, str5, str6, i, i2);
            return image;
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                if (obj instanceof Image) {
                    Image image = (Image) obj;
                    if ((this.id == image.id) && Intrinsics.areEqual((Object) this.url, (Object) image.url) && Intrinsics.areEqual((Object) this.thumbnailUrl, (Object) image.thumbnailUrl) && Intrinsics.areEqual((Object) this.dominantColor, (Object) image.dominantColor)) {
                        if (this.width == image.width) {
                            if (this.height == image.height) {
                                return true;
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
            String str = this.url;
            int i2 = 0;
            int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.thumbnailUrl;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.dominantColor;
            if (str3 != null) {
                i2 = str3.hashCode();
            }
            return ((((hashCode2 + i2) * 31) + this.width) * 31) + this.height;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Image(id=");
            sb.append(this.id);
            sb.append(", url=");
            sb.append(this.url);
            sb.append(", thumbnailUrl=");
            sb.append(this.thumbnailUrl);
            sb.append(", dominantColor=");
            sb.append(this.dominantColor);
            sb.append(", width=");
            sb.append(this.width);
            sb.append(", height=");
            sb.append(this.height);
            sb.append(")");
            return sb.toString();
        }

        public Image(long j, @NotNull String str, @NotNull String str2, @NotNull String str3, int i, int i2) {
            Intrinsics.checkParameterIsNotNull(str, "url");
            Intrinsics.checkParameterIsNotNull(str2, "thumbnailUrl");
            Intrinsics.checkParameterIsNotNull(str3, "dominantColor");
            this.id = j;
            this.url = str;
            this.thumbnailUrl = str2;
            this.dominantColor = str3;
            this.width = i;
            this.height = i2;
        }

        @NonNull
        public final long getId() {
            return this.id;
        }

        @NotNull
        @NonNull
        public final String getUrl() {
            return this.url;
        }

        @NotNull
        public final String getThumbnailUrl() {
            return this.thumbnailUrl;
        }

        @NotNull
        public final String getDominantColor() {
            return this.dominantColor;
        }

        public final int getWidth() {
            return this.width;
        }

        public final int getHeight() {
            return this.height;
        }
    }

    @Validated(factory = ValidatorFactoryImpl.class)
    public static final class LinkInfo {
        @SerializedName("link_url")
        @NotNull
        private final String linkUrl;
        @SerializedName("product")
        @Nullable
        private final Product product;
        @SerializedName("shop")
        @Nullable
        private final Shop shop;

        @NotNull
        public static /* synthetic */ LinkInfo copy$default(LinkInfo linkInfo, String str, Shop shop2, Product product2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = linkInfo.linkUrl;
            }
            if ((i & 2) != 0) {
                shop2 = linkInfo.shop;
            }
            if ((i & 4) != 0) {
                product2 = linkInfo.product;
            }
            return linkInfo.copy(str, shop2, product2);
        }

        @NotNull
        public final String component1() {
            return this.linkUrl;
        }

        @Nullable
        public final Shop component2() {
            return this.shop;
        }

        @Nullable
        public final Product component3() {
            return this.product;
        }

        @NotNull
        public final LinkInfo copy(@NotNull String str, @Nullable Shop shop2, @Nullable Product product2) {
            Intrinsics.checkParameterIsNotNull(str, "linkUrl");
            return new LinkInfo(str, shop2, product2);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0024, code lost:
            if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2.product, (java.lang.Object) r3.product) != false) goto L_0x0029;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r3) {
            /*
                r2 = this;
                if (r2 == r3) goto L_0x0029
                boolean r0 = r3 instanceof kr.co.popone.fitts.model.search.SearchAPI.LinkInfo
                if (r0 == 0) goto L_0x0027
                kr.co.popone.fitts.model.search.SearchAPI$LinkInfo r3 = (kr.co.popone.fitts.model.search.SearchAPI.LinkInfo) r3
                java.lang.String r0 = r2.linkUrl
                java.lang.String r1 = r3.linkUrl
                boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
                if (r0 == 0) goto L_0x0027
                kr.co.popone.fitts.model.datamodel.commerce.Shop r0 = r2.shop
                kr.co.popone.fitts.model.datamodel.commerce.Shop r1 = r3.shop
                boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
                if (r0 == 0) goto L_0x0027
                kr.co.popone.fitts.model.datamodel.commerce.Product r0 = r2.product
                kr.co.popone.fitts.model.datamodel.commerce.Product r3 = r3.product
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
            throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.search.SearchAPI.LinkInfo.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            String str = this.linkUrl;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            Shop shop2 = this.shop;
            int hashCode2 = (hashCode + (shop2 != null ? shop2.hashCode() : 0)) * 31;
            Product product2 = this.product;
            if (product2 != null) {
                i = product2.hashCode();
            }
            return hashCode2 + i;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("LinkInfo(linkUrl=");
            sb.append(this.linkUrl);
            sb.append(", shop=");
            sb.append(this.shop);
            sb.append(", product=");
            sb.append(this.product);
            sb.append(")");
            return sb.toString();
        }

        public LinkInfo(@NotNull String str, @Nullable Shop shop2, @Nullable Product product2) {
            Intrinsics.checkParameterIsNotNull(str, "linkUrl");
            this.linkUrl = str;
            this.shop = shop2;
            this.product = product2;
        }

        @NotNull
        @NonNull
        public final String getLinkUrl() {
            return this.linkUrl;
        }

        @Nullable
        public final Shop getShop() {
            return this.shop;
        }

        @Nullable
        public final Product getProduct() {
            return this.product;
        }
    }

    public static final class RecommendStyle {
        private final long id;
        @SerializedName("image_url")
        @NotNull
        private final String imageUrl;
        @SerializedName("name")
        @NotNull
        private final String style;

        @NotNull
        public static /* synthetic */ RecommendStyle copy$default(RecommendStyle recommendStyle, long j, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                j = recommendStyle.id;
            }
            if ((i & 2) != 0) {
                str = recommendStyle.style;
            }
            if ((i & 4) != 0) {
                str2 = recommendStyle.imageUrl;
            }
            return recommendStyle.copy(j, str, str2);
        }

        public final long component1() {
            return this.id;
        }

        @NotNull
        public final String component2() {
            return this.style;
        }

        @NotNull
        public final String component3() {
            return this.imageUrl;
        }

        @NotNull
        public final RecommendStyle copy(long j, @NotNull String str, @NotNull String str2) {
            Intrinsics.checkParameterIsNotNull(str, "style");
            Intrinsics.checkParameterIsNotNull(str2, "imageUrl");
            return new RecommendStyle(j, str, str2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                if (obj instanceof RecommendStyle) {
                    RecommendStyle recommendStyle = (RecommendStyle) obj;
                    if (!(this.id == recommendStyle.id) || !Intrinsics.areEqual((Object) this.style, (Object) recommendStyle.style) || !Intrinsics.areEqual((Object) this.imageUrl, (Object) recommendStyle.imageUrl)) {
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
            String str = this.style;
            int i2 = 0;
            int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.imageUrl;
            if (str2 != null) {
                i2 = str2.hashCode();
            }
            return hashCode + i2;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("RecommendStyle(id=");
            sb.append(this.id);
            sb.append(", style=");
            sb.append(this.style);
            sb.append(", imageUrl=");
            sb.append(this.imageUrl);
            sb.append(")");
            return sb.toString();
        }

        public RecommendStyle(long j, @NotNull String str, @NotNull String str2) {
            Intrinsics.checkParameterIsNotNull(str, "style");
            Intrinsics.checkParameterIsNotNull(str2, "imageUrl");
            this.id = j;
            this.style = str;
            this.imageUrl = str2;
        }

        public final long getId() {
            return this.id;
        }

        @NotNull
        public final String getStyle() {
            return this.style;
        }

        @NotNull
        public final String getImageUrl() {
            return this.imageUrl;
        }
    }

    @Validated(factory = ValidatorFactoryImpl.class)
    public static final class RecommendationSection {
        @SerializedName("id")
        private final long id;
        @SerializedName("ratio")
        private final double imageRatio;
        @SerializedName("items")
        @NotNull
        private final List<Item> items;
        @SerializedName("section_type")
        @NotNull
        private final String sectionType;
        @SerializedName("title")
        @NotNull
        private final String title;

        @Validated(factory = ValidatorFactoryImpl.class)
        public static final class Item {
            @SerializedName("id")
            private final long id;
            @SerializedName("image_url")
            @Nullable
            private final String imageUrl;
            @SerializedName("label_1")
            @Nullable
            private final String label1;
            @SerializedName("scheme")
            @Nullable
            private final String scheme;

            @NotNull
            public static /* synthetic */ Item copy$default(Item item, long j, String str, String str2, String str3, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = item.id;
                }
                long j2 = j;
                if ((i & 2) != 0) {
                    str = item.imageUrl;
                }
                String str4 = str;
                if ((i & 4) != 0) {
                    str2 = item.scheme;
                }
                String str5 = str2;
                if ((i & 8) != 0) {
                    str3 = item.label1;
                }
                return item.copy(j2, str4, str5, str3);
            }

            public final long component1() {
                return this.id;
            }

            @Nullable
            public final String component2() {
                return this.imageUrl;
            }

            @Nullable
            public final String component3() {
                return this.scheme;
            }

            @Nullable
            public final String component4() {
                return this.label1;
            }

            @NotNull
            public final Item copy(long j, @Nullable String str, @Nullable String str2, @Nullable String str3) {
                Item item = new Item(j, str, str2, str3);
                return item;
            }

            public boolean equals(@Nullable Object obj) {
                if (this != obj) {
                    if (obj instanceof Item) {
                        Item item = (Item) obj;
                        if (!(this.id == item.id) || !Intrinsics.areEqual((Object) this.imageUrl, (Object) item.imageUrl) || !Intrinsics.areEqual((Object) this.scheme, (Object) item.scheme) || !Intrinsics.areEqual((Object) this.label1, (Object) item.label1)) {
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
                String str = this.imageUrl;
                int i2 = 0;
                int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
                String str2 = this.scheme;
                int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
                String str3 = this.label1;
                if (str3 != null) {
                    i2 = str3.hashCode();
                }
                return hashCode2 + i2;
            }

            @NotNull
            public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append("Item(id=");
                sb.append(this.id);
                sb.append(", imageUrl=");
                sb.append(this.imageUrl);
                sb.append(", scheme=");
                sb.append(this.scheme);
                sb.append(", label1=");
                sb.append(this.label1);
                sb.append(")");
                return sb.toString();
            }

            public Item(long j, @Nullable String str, @Nullable String str2, @Nullable String str3) {
                this.id = j;
                this.imageUrl = str;
                this.scheme = str2;
                this.label1 = str3;
            }

            public final long getId() {
                return this.id;
            }

            @Nullable
            public final String getImageUrl() {
                return this.imageUrl;
            }

            @Nullable
            public final String getScheme() {
                return this.scheme;
            }

            public /* synthetic */ Item(long j, String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
                if ((i & 8) != 0) {
                    str3 = null;
                }
                this(j, str, str2, str3);
            }

            @Nullable
            public final String getLabel1() {
                return this.label1;
            }
        }

        @NotNull
        public static /* synthetic */ RecommendationSection copy$default(RecommendationSection recommendationSection, long j, String str, String str2, List list, double d, int i, Object obj) {
            RecommendationSection recommendationSection2 = recommendationSection;
            return recommendationSection.copy((i & 1) != 0 ? recommendationSection2.id : j, (i & 2) != 0 ? recommendationSection2.title : str, (i & 4) != 0 ? recommendationSection2.sectionType : str2, (i & 8) != 0 ? recommendationSection2.items : list, (i & 16) != 0 ? recommendationSection2.imageRatio : d);
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
            return this.sectionType;
        }

        @NotNull
        public final List<Item> component4() {
            return this.items;
        }

        public final double component5() {
            return this.imageRatio;
        }

        @NotNull
        public final RecommendationSection copy(long j, @NotNull String str, @NotNull String str2, @NotNull List<Item> list, double d) {
            String str3 = str;
            Intrinsics.checkParameterIsNotNull(str, "title");
            String str4 = str2;
            Intrinsics.checkParameterIsNotNull(str2, "sectionType");
            List<Item> list2 = list;
            Intrinsics.checkParameterIsNotNull(list, "items");
            RecommendationSection recommendationSection = new RecommendationSection(j, str3, str4, list2, d);
            return recommendationSection;
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                if (obj instanceof RecommendationSection) {
                    RecommendationSection recommendationSection = (RecommendationSection) obj;
                    if (!(this.id == recommendationSection.id) || !Intrinsics.areEqual((Object) this.title, (Object) recommendationSection.title) || !Intrinsics.areEqual((Object) this.sectionType, (Object) recommendationSection.sectionType) || !Intrinsics.areEqual((Object) this.items, (Object) recommendationSection.items) || Double.compare(this.imageRatio, recommendationSection.imageRatio) != 0) {
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
            String str = this.title;
            int i2 = 0;
            int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.sectionType;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            List<Item> list = this.items;
            if (list != null) {
                i2 = list.hashCode();
            }
            int i3 = (hashCode2 + i2) * 31;
            long doubleToLongBits = Double.doubleToLongBits(this.imageRatio);
            return i3 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("RecommendationSection(id=");
            sb.append(this.id);
            sb.append(", title=");
            sb.append(this.title);
            sb.append(", sectionType=");
            sb.append(this.sectionType);
            sb.append(", items=");
            sb.append(this.items);
            sb.append(", imageRatio=");
            sb.append(this.imageRatio);
            sb.append(")");
            return sb.toString();
        }

        public RecommendationSection(long j, @NotNull String str, @NotNull String str2, @NotNull List<Item> list, double d) {
            Intrinsics.checkParameterIsNotNull(str, "title");
            Intrinsics.checkParameterIsNotNull(str2, "sectionType");
            Intrinsics.checkParameterIsNotNull(list, "items");
            this.id = j;
            this.title = str;
            this.sectionType = str2;
            this.items = list;
            this.imageRatio = d;
        }

        public final long getId() {
            return this.id;
        }

        @NotNull
        @NonNull
        public final String getTitle() {
            return this.title;
        }

        @NotNull
        @NonNull
        public final String getSectionType() {
            return this.sectionType;
        }

        @NotNull
        @NonNull
        public final List<Item> getItems() {
            return this.items;
        }

        public /* synthetic */ RecommendationSection(long j, String str, String str2, List list, double d, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, str, str2, list, (i & 16) != 0 ? 0.0d : d);
        }

        public final double getImageRatio() {
            return this.imageRatio;
        }
    }

    @Validated(factory = ValidatorFactoryImpl.class)
    public static final class SearchFittieResult {
        @SerializedName("result")
        @NotNull
        private final List<User> results;
        @SerializedName("total_count")
        private final int totalCount;

        /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<kr.co.popone.fitts.model.datamodel.service.user.User>, for r1v0, types: [java.util.List] */
        @org.jetbrains.annotations.NotNull
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static /* synthetic */ kr.co.popone.fitts.model.search.SearchAPI.SearchFittieResult copy$default(kr.co.popone.fitts.model.search.SearchAPI.SearchFittieResult r0, java.util.List<kr.co.popone.fitts.model.datamodel.service.user.User> r1, int r2, int r3, java.lang.Object r4) {
            /*
                r4 = r3 & 1
                if (r4 == 0) goto L_0x0006
                java.util.List<kr.co.popone.fitts.model.datamodel.service.user.User> r1 = r0.results
            L_0x0006:
                r3 = r3 & 2
                if (r3 == 0) goto L_0x000c
                int r2 = r0.totalCount
            L_0x000c:
                kr.co.popone.fitts.model.search.SearchAPI$SearchFittieResult r0 = r0.copy(r1, r2)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.search.SearchAPI.SearchFittieResult.copy$default(kr.co.popone.fitts.model.search.SearchAPI$SearchFittieResult, java.util.List, int, int, java.lang.Object):kr.co.popone.fitts.model.search.SearchAPI$SearchFittieResult");
        }

        @NotNull
        public final List<User> component1() {
            return this.results;
        }

        public final int component2() {
            return this.totalCount;
        }

        @NotNull
        public final SearchFittieResult copy(@NotNull List<User> list, int i) {
            Intrinsics.checkParameterIsNotNull(list, "results");
            return new SearchFittieResult(list, i);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                if (obj instanceof SearchFittieResult) {
                    SearchFittieResult searchFittieResult = (SearchFittieResult) obj;
                    if (Intrinsics.areEqual((Object) this.results, (Object) searchFittieResult.results)) {
                        if (this.totalCount == searchFittieResult.totalCount) {
                            return true;
                        }
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            List<User> list = this.results;
            return ((list != null ? list.hashCode() : 0) * 31) + this.totalCount;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("SearchFittieResult(results=");
            sb.append(this.results);
            sb.append(", totalCount=");
            sb.append(this.totalCount);
            sb.append(")");
            return sb.toString();
        }

        public SearchFittieResult(@NotNull List<User> list, int i) {
            Intrinsics.checkParameterIsNotNull(list, "results");
            this.results = list;
            this.totalCount = i;
        }

        @NotNull
        @NonNull
        public final List<User> getResults() {
            return this.results;
        }

        @NonNull
        public final int getTotalCount() {
            return this.totalCount;
        }
    }

    @Validated(factory = ValidatorFactoryImpl.class)
    public static final class SearchHomeResult {
        @NotNull
        private final List<User> fitties;
        @NotNull
        private final List<Shop> shops;
        @NotNull
        private final List<Style> styles;

        @Validated(factory = ValidatorFactoryImpl.class)
        public static final class Shop {
            @NotNull
            private final List<String> domains;
            private final long id;
            @NotNull
            private final String name;
            @NotNull
            private final String url;

            /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<java.lang.String>, for r11v0, types: [java.util.List] */
            @org.jetbrains.annotations.NotNull
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public static /* synthetic */ kr.co.popone.fitts.model.search.SearchAPI.SearchHomeResult.Shop copy$default(kr.co.popone.fitts.model.search.SearchAPI.SearchHomeResult.Shop r6, long r7, java.lang.String r9, java.lang.String r10, java.util.List<java.lang.String> r11, int r12, java.lang.Object r13) {
                /*
                    r13 = r12 & 1
                    if (r13 == 0) goto L_0x0006
                    long r7 = r6.id
                L_0x0006:
                    r1 = r7
                    r7 = r12 & 2
                    if (r7 == 0) goto L_0x000d
                    java.lang.String r9 = r6.name
                L_0x000d:
                    r3 = r9
                    r7 = r12 & 4
                    if (r7 == 0) goto L_0x0014
                    java.lang.String r10 = r6.url
                L_0x0014:
                    r4 = r10
                    r7 = r12 & 8
                    if (r7 == 0) goto L_0x001b
                    java.util.List<java.lang.String> r11 = r6.domains
                L_0x001b:
                    r5 = r11
                    r0 = r6
                    kr.co.popone.fitts.model.search.SearchAPI$SearchHomeResult$Shop r6 = r0.copy(r1, r3, r4, r5)
                    return r6
                */
                throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.search.SearchAPI.SearchHomeResult.Shop.copy$default(kr.co.popone.fitts.model.search.SearchAPI$SearchHomeResult$Shop, long, java.lang.String, java.lang.String, java.util.List, int, java.lang.Object):kr.co.popone.fitts.model.search.SearchAPI$SearchHomeResult$Shop");
            }

            public final long component1() {
                return this.id;
            }

            @NotNull
            public final String component2() {
                return this.name;
            }

            @NotNull
            public final String component3() {
                return this.url;
            }

            @NotNull
            public final List<String> component4() {
                return this.domains;
            }

            @NotNull
            public final Shop copy(long j, @NotNull String str, @NotNull String str2, @NotNull List<String> list) {
                Intrinsics.checkParameterIsNotNull(str, "name");
                Intrinsics.checkParameterIsNotNull(str2, "url");
                Intrinsics.checkParameterIsNotNull(list, "domains");
                Shop shop = new Shop(j, str, str2, list);
                return shop;
            }

            public boolean equals(@Nullable Object obj) {
                if (this != obj) {
                    if (obj instanceof Shop) {
                        Shop shop = (Shop) obj;
                        if (!(this.id == shop.id) || !Intrinsics.areEqual((Object) this.name, (Object) shop.name) || !Intrinsics.areEqual((Object) this.url, (Object) shop.url) || !Intrinsics.areEqual((Object) this.domains, (Object) shop.domains)) {
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
                String str = this.name;
                int i2 = 0;
                int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
                String str2 = this.url;
                int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
                List<String> list = this.domains;
                if (list != null) {
                    i2 = list.hashCode();
                }
                return hashCode2 + i2;
            }

            @NotNull
            public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append("Shop(id=");
                sb.append(this.id);
                sb.append(", name=");
                sb.append(this.name);
                sb.append(", url=");
                sb.append(this.url);
                sb.append(", domains=");
                sb.append(this.domains);
                sb.append(")");
                return sb.toString();
            }

            public Shop(long j, @NotNull String str, @NotNull String str2, @NotNull List<String> list) {
                Intrinsics.checkParameterIsNotNull(str, "name");
                Intrinsics.checkParameterIsNotNull(str2, "url");
                Intrinsics.checkParameterIsNotNull(list, "domains");
                this.id = j;
                this.name = str;
                this.url = str2;
                this.domains = list;
            }

            @NonNull
            public final long getId() {
                return this.id;
            }

            @NotNull
            @NonNull
            public final String getName() {
                return this.name;
            }

            @NotNull
            @NonNull
            public final String getUrl() {
                return this.url;
            }

            @NotNull
            @NonNull
            public final List<String> getDomains() {
                return this.domains;
            }
        }

        @Validated(factory = ValidatorFactoryImpl.class)
        public static final class Style {
            private final long id;
            @SerializedName("image_url")
            @Nullable
            private final String imageUrl;
            @NotNull
            private final String name;

            @NotNull
            public static /* synthetic */ Style copy$default(Style style, long j, String str, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = style.id;
                }
                if ((i & 2) != 0) {
                    str = style.name;
                }
                if ((i & 4) != 0) {
                    str2 = style.imageUrl;
                }
                return style.copy(j, str, str2);
            }

            public final long component1() {
                return this.id;
            }

            @NotNull
            public final String component2() {
                return this.name;
            }

            @Nullable
            public final String component3() {
                return this.imageUrl;
            }

            @NotNull
            public final Style copy(long j, @NotNull String str, @Nullable String str2) {
                Intrinsics.checkParameterIsNotNull(str, "name");
                return new Style(j, str, str2);
            }

            public boolean equals(@Nullable Object obj) {
                if (this != obj) {
                    if (obj instanceof Style) {
                        Style style = (Style) obj;
                        if (!(this.id == style.id) || !Intrinsics.areEqual((Object) this.name, (Object) style.name) || !Intrinsics.areEqual((Object) this.imageUrl, (Object) style.imageUrl)) {
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
                String str = this.name;
                int i2 = 0;
                int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
                String str2 = this.imageUrl;
                if (str2 != null) {
                    i2 = str2.hashCode();
                }
                return hashCode + i2;
            }

            @NotNull
            public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append("Style(id=");
                sb.append(this.id);
                sb.append(", name=");
                sb.append(this.name);
                sb.append(", imageUrl=");
                sb.append(this.imageUrl);
                sb.append(")");
                return sb.toString();
            }

            public Style(long j, @NotNull String str, @Nullable String str2) {
                Intrinsics.checkParameterIsNotNull(str, "name");
                this.id = j;
                this.name = str;
                this.imageUrl = str2;
            }

            @NonNull
            public final long getId() {
                return this.id;
            }

            @NotNull
            @NonNull
            public final String getName() {
                return this.name;
            }

            @Nullable
            public final String getImageUrl() {
                return this.imageUrl;
            }
        }

        /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<kr.co.popone.fitts.model.datamodel.service.user.User>, for r1v0, types: [java.util.List] */
        /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<kr.co.popone.fitts.model.search.SearchAPI$SearchHomeResult$Shop>, for r3v0, types: [java.util.List] */
        /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<kr.co.popone.fitts.model.search.SearchAPI$SearchHomeResult$Style>, for r2v0, types: [java.util.List] */
        @org.jetbrains.annotations.NotNull
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static /* synthetic */ kr.co.popone.fitts.model.search.SearchAPI.SearchHomeResult copy$default(kr.co.popone.fitts.model.search.SearchAPI.SearchHomeResult r0, java.util.List<kr.co.popone.fitts.model.datamodel.service.user.User> r1, java.util.List<kr.co.popone.fitts.model.search.SearchAPI.SearchHomeResult.Style> r2, java.util.List<kr.co.popone.fitts.model.search.SearchAPI.SearchHomeResult.Shop> r3, int r4, java.lang.Object r5) {
            /*
                r5 = r4 & 1
                if (r5 == 0) goto L_0x0006
                java.util.List<kr.co.popone.fitts.model.datamodel.service.user.User> r1 = r0.fitties
            L_0x0006:
                r5 = r4 & 2
                if (r5 == 0) goto L_0x000c
                java.util.List<kr.co.popone.fitts.model.search.SearchAPI$SearchHomeResult$Style> r2 = r0.styles
            L_0x000c:
                r4 = r4 & 4
                if (r4 == 0) goto L_0x0012
                java.util.List<kr.co.popone.fitts.model.search.SearchAPI$SearchHomeResult$Shop> r3 = r0.shops
            L_0x0012:
                kr.co.popone.fitts.model.search.SearchAPI$SearchHomeResult r0 = r0.copy(r1, r2, r3)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.search.SearchAPI.SearchHomeResult.copy$default(kr.co.popone.fitts.model.search.SearchAPI$SearchHomeResult, java.util.List, java.util.List, java.util.List, int, java.lang.Object):kr.co.popone.fitts.model.search.SearchAPI$SearchHomeResult");
        }

        @NotNull
        public final List<User> component1() {
            return this.fitties;
        }

        @NotNull
        public final List<Style> component2() {
            return this.styles;
        }

        @NotNull
        public final List<Shop> component3() {
            return this.shops;
        }

        @NotNull
        public final SearchHomeResult copy(@NotNull List<User> list, @NotNull List<Style> list2, @NotNull List<Shop> list3) {
            Intrinsics.checkParameterIsNotNull(list, "fitties");
            Intrinsics.checkParameterIsNotNull(list2, "styles");
            Intrinsics.checkParameterIsNotNull(list3, "shops");
            return new SearchHomeResult(list, list2, list3);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0024, code lost:
            if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2.shops, (java.lang.Object) r3.shops) != false) goto L_0x0029;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r3) {
            /*
                r2 = this;
                if (r2 == r3) goto L_0x0029
                boolean r0 = r3 instanceof kr.co.popone.fitts.model.search.SearchAPI.SearchHomeResult
                if (r0 == 0) goto L_0x0027
                kr.co.popone.fitts.model.search.SearchAPI$SearchHomeResult r3 = (kr.co.popone.fitts.model.search.SearchAPI.SearchHomeResult) r3
                java.util.List<kr.co.popone.fitts.model.datamodel.service.user.User> r0 = r2.fitties
                java.util.List<kr.co.popone.fitts.model.datamodel.service.user.User> r1 = r3.fitties
                boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
                if (r0 == 0) goto L_0x0027
                java.util.List<kr.co.popone.fitts.model.search.SearchAPI$SearchHomeResult$Style> r0 = r2.styles
                java.util.List<kr.co.popone.fitts.model.search.SearchAPI$SearchHomeResult$Style> r1 = r3.styles
                boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
                if (r0 == 0) goto L_0x0027
                java.util.List<kr.co.popone.fitts.model.search.SearchAPI$SearchHomeResult$Shop> r0 = r2.shops
                java.util.List<kr.co.popone.fitts.model.search.SearchAPI$SearchHomeResult$Shop> r3 = r3.shops
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
            throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.search.SearchAPI.SearchHomeResult.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            List<User> list = this.fitties;
            int i = 0;
            int hashCode = (list != null ? list.hashCode() : 0) * 31;
            List<Style> list2 = this.styles;
            int hashCode2 = (hashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
            List<Shop> list3 = this.shops;
            if (list3 != null) {
                i = list3.hashCode();
            }
            return hashCode2 + i;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("SearchHomeResult(fitties=");
            sb.append(this.fitties);
            sb.append(", styles=");
            sb.append(this.styles);
            sb.append(", shops=");
            sb.append(this.shops);
            sb.append(")");
            return sb.toString();
        }

        public SearchHomeResult(@NotNull List<User> list, @NotNull List<Style> list2, @NotNull List<Shop> list3) {
            Intrinsics.checkParameterIsNotNull(list, "fitties");
            Intrinsics.checkParameterIsNotNull(list2, "styles");
            Intrinsics.checkParameterIsNotNull(list3, "shops");
            this.fitties = list;
            this.styles = list2;
            this.shops = list3;
        }

        @NotNull
        @NonNull
        public final List<User> getFitties() {
            return this.fitties;
        }

        @NotNull
        @NonNull
        public final List<Style> getStyles() {
            return this.styles;
        }

        @NotNull
        @NonNull
        public final List<Shop> getShops() {
            return this.shops;
        }
    }

    @Validated(factory = ValidatorFactoryImpl.class)
    public static final class SearchPostResult {
        @SerializedName("result")
        @NotNull
        private final List<PostEntry> results;
        @SerializedName("total_count")
        private final int totalCount;

        @Validated(factory = ValidatorFactoryImpl.class)
        public static final class PostEntry {
            @SerializedName("about_fit")
            @NotNull
            private final String aboutFit;
            @SerializedName("about_product")
            @NotNull
            private final String aboutProduct;
            @SerializedName("about_size")
            @NotNull
            private final String aboutSize;
            @SerializedName("categories")
            @NotNull
            private final List<Category> categories;
            @SerializedName("comments_count")
            private final int commentsCount;
            @SerializedName("cover_image")
            @NotNull
            private final Image coverImage;
            @SerializedName("created_at")
            @NotNull
            private final Date createdAt;
            private final long id;
            @SerializedName("is_detailer")
            private final boolean isDetailer;
            @SerializedName("is_editor_pick")
            private final boolean isEditorPick;
            @SerializedName("is_like")
            private final boolean isLike;
            @SerializedName("is_photogenic")
            private final boolean isPhotogenic;
            @SerializedName("is_post_best")
            private final boolean isPostBest;
            @SerializedName("is_stylelist")
            private final boolean isStyleList;
            @SerializedName("likes_count")
            private final int likesCount;
            @SerializedName("link_info")
            @NotNull
            private final LinkInfo linkInfo;
            @SerializedName("stars")
            private final float stars;
            @SerializedName("tags")
            @NotNull
            private final List<Tag> tags;
            @NotNull
            private final String title;
            @NotNull
            private final User user;
            @SerializedName("views")
            private final int viewCount;

            @NotNull
            public static /* synthetic */ PostEntry copy$default(PostEntry postEntry, long j, String str, User user2, String str2, String str3, String str4, Image image, float f, LinkInfo linkInfo2, Date date, int i, int i2, boolean z, int i3, List list, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, List list2, int i4, Object obj) {
                PostEntry postEntry2 = postEntry;
                int i5 = i4;
                return postEntry.copy((i5 & 1) != 0 ? postEntry2.id : j, (i5 & 2) != 0 ? postEntry2.title : str, (i5 & 4) != 0 ? postEntry2.user : user2, (i5 & 8) != 0 ? postEntry2.aboutFit : str2, (i5 & 16) != 0 ? postEntry2.aboutProduct : str3, (i5 & 32) != 0 ? postEntry2.aboutSize : str4, (i5 & 64) != 0 ? postEntry2.coverImage : image, (i5 & 128) != 0 ? postEntry2.stars : f, (i5 & 256) != 0 ? postEntry2.linkInfo : linkInfo2, (i5 & 512) != 0 ? postEntry2.createdAt : date, (i5 & 1024) != 0 ? postEntry2.likesCount : i, (i5 & 2048) != 0 ? postEntry2.viewCount : i2, (i5 & 4096) != 0 ? postEntry2.isLike : z, (i5 & 8192) != 0 ? postEntry2.commentsCount : i3, (i5 & 16384) != 0 ? postEntry2.tags : list, (i5 & 32768) != 0 ? postEntry2.isEditorPick : z2, (i5 & 65536) != 0 ? postEntry2.isPostBest : z3, (i5 & 131072) != 0 ? postEntry2.isStyleList : z4, (i5 & 262144) != 0 ? postEntry2.isDetailer : z5, (i5 & 524288) != 0 ? postEntry2.isPhotogenic : z6, (i5 & 1048576) != 0 ? postEntry2.categories : list2);
            }

            public final long component1() {
                return this.id;
            }

            @NotNull
            public final Date component10() {
                return this.createdAt;
            }

            public final int component11() {
                return this.likesCount;
            }

            public final int component12() {
                return this.viewCount;
            }

            public final boolean component13() {
                return this.isLike;
            }

            public final int component14() {
                return this.commentsCount;
            }

            @NotNull
            public final List<Tag> component15() {
                return this.tags;
            }

            public final boolean component16() {
                return this.isEditorPick;
            }

            public final boolean component17() {
                return this.isPostBest;
            }

            public final boolean component18() {
                return this.isStyleList;
            }

            public final boolean component19() {
                return this.isDetailer;
            }

            @NotNull
            public final String component2() {
                return this.title;
            }

            public final boolean component20() {
                return this.isPhotogenic;
            }

            @NotNull
            public final List<Category> component21() {
                return this.categories;
            }

            @NotNull
            public final User component3() {
                return this.user;
            }

            @NotNull
            public final String component4() {
                return this.aboutFit;
            }

            @NotNull
            public final String component5() {
                return this.aboutProduct;
            }

            @NotNull
            public final String component6() {
                return this.aboutSize;
            }

            @NotNull
            public final Image component7() {
                return this.coverImage;
            }

            public final float component8() {
                return this.stars;
            }

            @NotNull
            public final LinkInfo component9() {
                return this.linkInfo;
            }

            @NotNull
            public final PostEntry copy(long j, @NotNull String str, @NotNull User user2, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull Image image, float f, @NotNull LinkInfo linkInfo2, @NotNull Date date, int i, int i2, boolean z, int i3, @NotNull List<Tag> list, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, @NotNull List<Category> list2) {
                long j2 = j;
                String str5 = str;
                User user3 = user2;
                String str6 = str2;
                String str7 = str3;
                String str8 = str4;
                Image image2 = image;
                float f2 = f;
                LinkInfo linkInfo3 = linkInfo2;
                Date date2 = date;
                int i4 = i;
                int i5 = i2;
                boolean z7 = z;
                int i6 = i3;
                List<Tag> list3 = list;
                boolean z8 = z2;
                boolean z9 = z3;
                boolean z10 = z4;
                boolean z11 = z5;
                boolean z12 = z6;
                List<Category> list4 = list2;
                Intrinsics.checkParameterIsNotNull(str, "title");
                Intrinsics.checkParameterIsNotNull(user2, "user");
                Intrinsics.checkParameterIsNotNull(str2, "aboutFit");
                Intrinsics.checkParameterIsNotNull(str3, "aboutProduct");
                Intrinsics.checkParameterIsNotNull(str4, "aboutSize");
                Intrinsics.checkParameterIsNotNull(image, "coverImage");
                Intrinsics.checkParameterIsNotNull(linkInfo2, "linkInfo");
                Intrinsics.checkParameterIsNotNull(date, "createdAt");
                Intrinsics.checkParameterIsNotNull(list, "tags");
                Intrinsics.checkParameterIsNotNull(list2, "categories");
                PostEntry postEntry = new PostEntry(j, str5, user3, str6, str7, str8, image2, f2, linkInfo3, date2, i4, i5, z7, i6, list3, z8, z9, z10, z11, z12, list4);
                return postEntry;
            }

            public boolean equals(@Nullable Object obj) {
                if (this != obj) {
                    if (obj instanceof PostEntry) {
                        PostEntry postEntry = (PostEntry) obj;
                        if ((this.id == postEntry.id) && Intrinsics.areEqual((Object) this.title, (Object) postEntry.title) && Intrinsics.areEqual((Object) this.user, (Object) postEntry.user) && Intrinsics.areEqual((Object) this.aboutFit, (Object) postEntry.aboutFit) && Intrinsics.areEqual((Object) this.aboutProduct, (Object) postEntry.aboutProduct) && Intrinsics.areEqual((Object) this.aboutSize, (Object) postEntry.aboutSize) && Intrinsics.areEqual((Object) this.coverImage, (Object) postEntry.coverImage) && Float.compare(this.stars, postEntry.stars) == 0 && Intrinsics.areEqual((Object) this.linkInfo, (Object) postEntry.linkInfo) && Intrinsics.areEqual((Object) this.createdAt, (Object) postEntry.createdAt)) {
                            if (this.likesCount == postEntry.likesCount) {
                                if (this.viewCount == postEntry.viewCount) {
                                    if (this.isLike == postEntry.isLike) {
                                        if ((this.commentsCount == postEntry.commentsCount) && Intrinsics.areEqual((Object) this.tags, (Object) postEntry.tags)) {
                                            if (this.isEditorPick == postEntry.isEditorPick) {
                                                if (this.isPostBest == postEntry.isPostBest) {
                                                    if (this.isStyleList == postEntry.isStyleList) {
                                                        if (this.isDetailer == postEntry.isDetailer) {
                                                            if (!(this.isPhotogenic == postEntry.isPhotogenic) || !Intrinsics.areEqual((Object) this.categories, (Object) postEntry.categories)) {
                                                                return false;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
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
                User user2 = this.user;
                int hashCode2 = (hashCode + (user2 != null ? user2.hashCode() : 0)) * 31;
                String str2 = this.aboutFit;
                int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
                String str3 = this.aboutProduct;
                int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
                String str4 = this.aboutSize;
                int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
                Image image = this.coverImage;
                int hashCode6 = (((hashCode5 + (image != null ? image.hashCode() : 0)) * 31) + Float.floatToIntBits(this.stars)) * 31;
                LinkInfo linkInfo2 = this.linkInfo;
                int hashCode7 = (hashCode6 + (linkInfo2 != null ? linkInfo2.hashCode() : 0)) * 31;
                Date date = this.createdAt;
                int hashCode8 = (((((hashCode7 + (date != null ? date.hashCode() : 0)) * 31) + this.likesCount) * 31) + this.viewCount) * 31;
                boolean z = this.isLike;
                if (z) {
                    z = true;
                }
                int i3 = (((hashCode8 + (z ? 1 : 0)) * 31) + this.commentsCount) * 31;
                List<Tag> list = this.tags;
                int hashCode9 = (i3 + (list != null ? list.hashCode() : 0)) * 31;
                boolean z2 = this.isEditorPick;
                if (z2) {
                    z2 = true;
                }
                int i4 = (hashCode9 + (z2 ? 1 : 0)) * 31;
                boolean z3 = this.isPostBest;
                if (z3) {
                    z3 = true;
                }
                int i5 = (i4 + (z3 ? 1 : 0)) * 31;
                boolean z4 = this.isStyleList;
                if (z4) {
                    z4 = true;
                }
                int i6 = (i5 + (z4 ? 1 : 0)) * 31;
                boolean z5 = this.isDetailer;
                if (z5) {
                    z5 = true;
                }
                int i7 = (i6 + (z5 ? 1 : 0)) * 31;
                boolean z6 = this.isPhotogenic;
                if (z6) {
                    z6 = true;
                }
                int i8 = (i7 + (z6 ? 1 : 0)) * 31;
                List<Category> list2 = this.categories;
                if (list2 != null) {
                    i2 = list2.hashCode();
                }
                return i8 + i2;
            }

            @NotNull
            public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append("PostEntry(id=");
                sb.append(this.id);
                sb.append(", title=");
                sb.append(this.title);
                sb.append(", user=");
                sb.append(this.user);
                sb.append(", aboutFit=");
                sb.append(this.aboutFit);
                sb.append(", aboutProduct=");
                sb.append(this.aboutProduct);
                sb.append(", aboutSize=");
                sb.append(this.aboutSize);
                sb.append(", coverImage=");
                sb.append(this.coverImage);
                sb.append(", stars=");
                sb.append(this.stars);
                sb.append(", linkInfo=");
                sb.append(this.linkInfo);
                sb.append(", createdAt=");
                sb.append(this.createdAt);
                sb.append(", likesCount=");
                sb.append(this.likesCount);
                sb.append(", viewCount=");
                sb.append(this.viewCount);
                sb.append(", isLike=");
                sb.append(this.isLike);
                sb.append(", commentsCount=");
                sb.append(this.commentsCount);
                sb.append(", tags=");
                sb.append(this.tags);
                sb.append(", isEditorPick=");
                sb.append(this.isEditorPick);
                sb.append(", isPostBest=");
                sb.append(this.isPostBest);
                sb.append(", isStyleList=");
                sb.append(this.isStyleList);
                sb.append(", isDetailer=");
                sb.append(this.isDetailer);
                sb.append(", isPhotogenic=");
                sb.append(this.isPhotogenic);
                sb.append(", categories=");
                sb.append(this.categories);
                sb.append(")");
                return sb.toString();
            }

            public PostEntry(long j, @NotNull String str, @NotNull User user2, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull Image image, float f, @NotNull LinkInfo linkInfo2, @NotNull Date date, int i, int i2, boolean z, int i3, @NotNull List<Tag> list, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, @NotNull List<Category> list2) {
                String str5 = str;
                User user3 = user2;
                String str6 = str2;
                String str7 = str3;
                String str8 = str4;
                Image image2 = image;
                LinkInfo linkInfo3 = linkInfo2;
                Date date2 = date;
                List<Tag> list3 = list;
                List<Category> list4 = list2;
                Intrinsics.checkParameterIsNotNull(str5, "title");
                Intrinsics.checkParameterIsNotNull(user3, "user");
                Intrinsics.checkParameterIsNotNull(str6, "aboutFit");
                Intrinsics.checkParameterIsNotNull(str7, "aboutProduct");
                Intrinsics.checkParameterIsNotNull(str8, "aboutSize");
                Intrinsics.checkParameterIsNotNull(image2, "coverImage");
                Intrinsics.checkParameterIsNotNull(linkInfo3, "linkInfo");
                Intrinsics.checkParameterIsNotNull(date2, "createdAt");
                Intrinsics.checkParameterIsNotNull(list3, "tags");
                Intrinsics.checkParameterIsNotNull(list4, "categories");
                this.id = j;
                this.title = str5;
                this.user = user3;
                this.aboutFit = str6;
                this.aboutProduct = str7;
                this.aboutSize = str8;
                this.coverImage = image2;
                this.stars = f;
                this.linkInfo = linkInfo3;
                this.createdAt = date2;
                this.likesCount = i;
                this.viewCount = i2;
                this.isLike = z;
                this.commentsCount = i3;
                this.tags = list3;
                this.isEditorPick = z2;
                this.isPostBest = z3;
                this.isStyleList = z4;
                this.isDetailer = z5;
                this.isPhotogenic = z6;
                this.categories = list4;
            }

            @NonNull
            public final long getId() {
                return this.id;
            }

            @NotNull
            @NonNull
            public final String getTitle() {
                return this.title;
            }

            @NotNull
            @NonNull
            public final User getUser() {
                return this.user;
            }

            @NotNull
            public final String getAboutFit() {
                return this.aboutFit;
            }

            @NotNull
            public final String getAboutProduct() {
                return this.aboutProduct;
            }

            @NotNull
            public final String getAboutSize() {
                return this.aboutSize;
            }

            @NotNull
            public final Image getCoverImage() {
                return this.coverImage;
            }

            public final float getStars() {
                return this.stars;
            }

            @NotNull
            @NonNull
            public final LinkInfo getLinkInfo() {
                return this.linkInfo;
            }

            @NotNull
            public final Date getCreatedAt() {
                return this.createdAt;
            }

            public final int getLikesCount() {
                return this.likesCount;
            }

            public final int getViewCount() {
                return this.viewCount;
            }

            public final boolean isLike() {
                return this.isLike;
            }

            public final int getCommentsCount() {
                return this.commentsCount;
            }

            @NotNull
            public final List<Tag> getTags() {
                return this.tags;
            }

            public final boolean isEditorPick() {
                return this.isEditorPick;
            }

            public final boolean isPostBest() {
                return this.isPostBest;
            }

            public final boolean isStyleList() {
                return this.isStyleList;
            }

            public final boolean isDetailer() {
                return this.isDetailer;
            }

            public final boolean isPhotogenic() {
                return this.isPhotogenic;
            }

            @NotNull
            @NonNull
            public final List<Category> getCategories() {
                return this.categories;
            }

            @Nullable
            public final String categoryGroup() {
                Category category = (Category) CollectionsKt___CollectionsKt.firstOrNull(this.categories);
                if (category != null) {
                    return category.getGroup();
                }
                return null;
            }
        }

        /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<kr.co.popone.fitts.model.search.SearchAPI$SearchPostResult$PostEntry>, for r1v0, types: [java.util.List] */
        @org.jetbrains.annotations.NotNull
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static /* synthetic */ kr.co.popone.fitts.model.search.SearchAPI.SearchPostResult copy$default(kr.co.popone.fitts.model.search.SearchAPI.SearchPostResult r0, java.util.List<kr.co.popone.fitts.model.search.SearchAPI.SearchPostResult.PostEntry> r1, int r2, int r3, java.lang.Object r4) {
            /*
                r4 = r3 & 1
                if (r4 == 0) goto L_0x0006
                java.util.List<kr.co.popone.fitts.model.search.SearchAPI$SearchPostResult$PostEntry> r1 = r0.results
            L_0x0006:
                r3 = r3 & 2
                if (r3 == 0) goto L_0x000c
                int r2 = r0.totalCount
            L_0x000c:
                kr.co.popone.fitts.model.search.SearchAPI$SearchPostResult r0 = r0.copy(r1, r2)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.search.SearchAPI.SearchPostResult.copy$default(kr.co.popone.fitts.model.search.SearchAPI$SearchPostResult, java.util.List, int, int, java.lang.Object):kr.co.popone.fitts.model.search.SearchAPI$SearchPostResult");
        }

        @NotNull
        public final List<PostEntry> component1() {
            return this.results;
        }

        public final int component2() {
            return this.totalCount;
        }

        @NotNull
        public final SearchPostResult copy(@NotNull List<PostEntry> list, int i) {
            Intrinsics.checkParameterIsNotNull(list, "results");
            return new SearchPostResult(list, i);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                if (obj instanceof SearchPostResult) {
                    SearchPostResult searchPostResult = (SearchPostResult) obj;
                    if (Intrinsics.areEqual((Object) this.results, (Object) searchPostResult.results)) {
                        if (this.totalCount == searchPostResult.totalCount) {
                            return true;
                        }
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            List<PostEntry> list = this.results;
            return ((list != null ? list.hashCode() : 0) * 31) + this.totalCount;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("SearchPostResult(results=");
            sb.append(this.results);
            sb.append(", totalCount=");
            sb.append(this.totalCount);
            sb.append(")");
            return sb.toString();
        }

        public SearchPostResult(@NotNull List<PostEntry> list, int i) {
            Intrinsics.checkParameterIsNotNull(list, "results");
            this.results = list;
            this.totalCount = i;
        }

        @NotNull
        @NonNull
        public final List<PostEntry> getResults() {
            return this.results;
        }

        @NonNull
        public final int getTotalCount() {
            return this.totalCount;
        }
    }

    @Validated(factory = ValidatorFactoryImpl.class)
    public static final class SearchRecommend {
        @SerializedName("popular_styles")
        @NotNull
        private final List<RecommendStyle> recommendStyles;
        @SerializedName("popular_searches")
        @NotNull
        private final List<String> searchKeywords;

        /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<java.lang.String>, for r1v0, types: [java.util.List] */
        /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<kr.co.popone.fitts.model.search.SearchAPI$RecommendStyle>, for r2v0, types: [java.util.List] */
        @org.jetbrains.annotations.NotNull
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static /* synthetic */ kr.co.popone.fitts.model.search.SearchAPI.SearchRecommend copy$default(kr.co.popone.fitts.model.search.SearchAPI.SearchRecommend r0, java.util.List<java.lang.String> r1, java.util.List<kr.co.popone.fitts.model.search.SearchAPI.RecommendStyle> r2, int r3, java.lang.Object r4) {
            /*
                r4 = r3 & 1
                if (r4 == 0) goto L_0x0006
                java.util.List<java.lang.String> r1 = r0.searchKeywords
            L_0x0006:
                r3 = r3 & 2
                if (r3 == 0) goto L_0x000c
                java.util.List<kr.co.popone.fitts.model.search.SearchAPI$RecommendStyle> r2 = r0.recommendStyles
            L_0x000c:
                kr.co.popone.fitts.model.search.SearchAPI$SearchRecommend r0 = r0.copy(r1, r2)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.search.SearchAPI.SearchRecommend.copy$default(kr.co.popone.fitts.model.search.SearchAPI$SearchRecommend, java.util.List, java.util.List, int, java.lang.Object):kr.co.popone.fitts.model.search.SearchAPI$SearchRecommend");
        }

        @NotNull
        public final List<String> component1() {
            return this.searchKeywords;
        }

        @NotNull
        public final List<RecommendStyle> component2() {
            return this.recommendStyles;
        }

        @NotNull
        public final SearchRecommend copy(@NotNull List<String> list, @NotNull List<RecommendStyle> list2) {
            Intrinsics.checkParameterIsNotNull(list, "searchKeywords");
            Intrinsics.checkParameterIsNotNull(list2, "recommendStyles");
            return new SearchRecommend(list, list2);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x001a, code lost:
            if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2.recommendStyles, (java.lang.Object) r3.recommendStyles) != false) goto L_0x001f;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r3) {
            /*
                r2 = this;
                if (r2 == r3) goto L_0x001f
                boolean r0 = r3 instanceof kr.co.popone.fitts.model.search.SearchAPI.SearchRecommend
                if (r0 == 0) goto L_0x001d
                kr.co.popone.fitts.model.search.SearchAPI$SearchRecommend r3 = (kr.co.popone.fitts.model.search.SearchAPI.SearchRecommend) r3
                java.util.List<java.lang.String> r0 = r2.searchKeywords
                java.util.List<java.lang.String> r1 = r3.searchKeywords
                boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
                if (r0 == 0) goto L_0x001d
                java.util.List<kr.co.popone.fitts.model.search.SearchAPI$RecommendStyle> r0 = r2.recommendStyles
                java.util.List<kr.co.popone.fitts.model.search.SearchAPI$RecommendStyle> r3 = r3.recommendStyles
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
            throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.search.SearchAPI.SearchRecommend.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            List<String> list = this.searchKeywords;
            int i = 0;
            int hashCode = (list != null ? list.hashCode() : 0) * 31;
            List<RecommendStyle> list2 = this.recommendStyles;
            if (list2 != null) {
                i = list2.hashCode();
            }
            return hashCode + i;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("SearchRecommend(searchKeywords=");
            sb.append(this.searchKeywords);
            sb.append(", recommendStyles=");
            sb.append(this.recommendStyles);
            sb.append(")");
            return sb.toString();
        }

        public SearchRecommend(@NotNull List<String> list, @NotNull List<RecommendStyle> list2) {
            Intrinsics.checkParameterIsNotNull(list, "searchKeywords");
            Intrinsics.checkParameterIsNotNull(list2, "recommendStyles");
            this.searchKeywords = list;
            this.recommendStyles = list2;
        }

        @NotNull
        public final List<String> getSearchKeywords() {
            return this.searchKeywords;
        }

        @NotNull
        public final List<RecommendStyle> getRecommendStyles() {
            return this.recommendStyles;
        }
    }

    @Validated(factory = ValidatorFactoryImpl.class)
    public static final class SearchShopResult {
        @SerializedName("result")
        @NotNull
        private final List<ShopEntry> results;
        @SerializedName("total_count")
        private final int totalCount;

        @Validated(factory = ValidatorFactoryImpl.class)
        public static final class ShopEntry {
            @NotNull
            private final List<String> domains;
            private final long id;
            @NotNull
            private final String name;
            @NotNull
            private final String url;

            /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<java.lang.String>, for r11v0, types: [java.util.List] */
            @org.jetbrains.annotations.NotNull
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public static /* synthetic */ kr.co.popone.fitts.model.search.SearchAPI.SearchShopResult.ShopEntry copy$default(kr.co.popone.fitts.model.search.SearchAPI.SearchShopResult.ShopEntry r6, long r7, java.lang.String r9, java.lang.String r10, java.util.List<java.lang.String> r11, int r12, java.lang.Object r13) {
                /*
                    r13 = r12 & 1
                    if (r13 == 0) goto L_0x0006
                    long r7 = r6.id
                L_0x0006:
                    r1 = r7
                    r7 = r12 & 2
                    if (r7 == 0) goto L_0x000d
                    java.lang.String r9 = r6.name
                L_0x000d:
                    r3 = r9
                    r7 = r12 & 4
                    if (r7 == 0) goto L_0x0014
                    java.lang.String r10 = r6.url
                L_0x0014:
                    r4 = r10
                    r7 = r12 & 8
                    if (r7 == 0) goto L_0x001b
                    java.util.List<java.lang.String> r11 = r6.domains
                L_0x001b:
                    r5 = r11
                    r0 = r6
                    kr.co.popone.fitts.model.search.SearchAPI$SearchShopResult$ShopEntry r6 = r0.copy(r1, r3, r4, r5)
                    return r6
                */
                throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.search.SearchAPI.SearchShopResult.ShopEntry.copy$default(kr.co.popone.fitts.model.search.SearchAPI$SearchShopResult$ShopEntry, long, java.lang.String, java.lang.String, java.util.List, int, java.lang.Object):kr.co.popone.fitts.model.search.SearchAPI$SearchShopResult$ShopEntry");
            }

            public final long component1() {
                return this.id;
            }

            @NotNull
            public final String component2() {
                return this.name;
            }

            @NotNull
            public final String component3() {
                return this.url;
            }

            @NotNull
            public final List<String> component4() {
                return this.domains;
            }

            @NotNull
            public final ShopEntry copy(long j, @NotNull String str, @NotNull String str2, @NotNull List<String> list) {
                Intrinsics.checkParameterIsNotNull(str, "name");
                Intrinsics.checkParameterIsNotNull(str2, "url");
                Intrinsics.checkParameterIsNotNull(list, "domains");
                ShopEntry shopEntry = new ShopEntry(j, str, str2, list);
                return shopEntry;
            }

            public boolean equals(@Nullable Object obj) {
                if (this != obj) {
                    if (obj instanceof ShopEntry) {
                        ShopEntry shopEntry = (ShopEntry) obj;
                        if (!(this.id == shopEntry.id) || !Intrinsics.areEqual((Object) this.name, (Object) shopEntry.name) || !Intrinsics.areEqual((Object) this.url, (Object) shopEntry.url) || !Intrinsics.areEqual((Object) this.domains, (Object) shopEntry.domains)) {
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
                String str = this.name;
                int i2 = 0;
                int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
                String str2 = this.url;
                int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
                List<String> list = this.domains;
                if (list != null) {
                    i2 = list.hashCode();
                }
                return hashCode2 + i2;
            }

            @NotNull
            public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append("ShopEntry(id=");
                sb.append(this.id);
                sb.append(", name=");
                sb.append(this.name);
                sb.append(", url=");
                sb.append(this.url);
                sb.append(", domains=");
                sb.append(this.domains);
                sb.append(")");
                return sb.toString();
            }

            public ShopEntry(long j, @NotNull String str, @NotNull String str2, @NotNull List<String> list) {
                Intrinsics.checkParameterIsNotNull(str, "name");
                Intrinsics.checkParameterIsNotNull(str2, "url");
                Intrinsics.checkParameterIsNotNull(list, "domains");
                this.id = j;
                this.name = str;
                this.url = str2;
                this.domains = list;
            }

            @NonNull
            public final long getId() {
                return this.id;
            }

            @NotNull
            @NonNull
            public final String getName() {
                return this.name;
            }

            @NotNull
            @NonNull
            public final String getUrl() {
                return this.url;
            }

            @NotNull
            @NonNull
            public final List<String> getDomains() {
                return this.domains;
            }
        }

        /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<kr.co.popone.fitts.model.search.SearchAPI$SearchShopResult$ShopEntry>, for r1v0, types: [java.util.List] */
        @org.jetbrains.annotations.NotNull
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static /* synthetic */ kr.co.popone.fitts.model.search.SearchAPI.SearchShopResult copy$default(kr.co.popone.fitts.model.search.SearchAPI.SearchShopResult r0, java.util.List<kr.co.popone.fitts.model.search.SearchAPI.SearchShopResult.ShopEntry> r1, int r2, int r3, java.lang.Object r4) {
            /*
                r4 = r3 & 1
                if (r4 == 0) goto L_0x0006
                java.util.List<kr.co.popone.fitts.model.search.SearchAPI$SearchShopResult$ShopEntry> r1 = r0.results
            L_0x0006:
                r3 = r3 & 2
                if (r3 == 0) goto L_0x000c
                int r2 = r0.totalCount
            L_0x000c:
                kr.co.popone.fitts.model.search.SearchAPI$SearchShopResult r0 = r0.copy(r1, r2)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.search.SearchAPI.SearchShopResult.copy$default(kr.co.popone.fitts.model.search.SearchAPI$SearchShopResult, java.util.List, int, int, java.lang.Object):kr.co.popone.fitts.model.search.SearchAPI$SearchShopResult");
        }

        @NotNull
        public final List<ShopEntry> component1() {
            return this.results;
        }

        public final int component2() {
            return this.totalCount;
        }

        @NotNull
        public final SearchShopResult copy(@NotNull List<ShopEntry> list, int i) {
            Intrinsics.checkParameterIsNotNull(list, "results");
            return new SearchShopResult(list, i);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                if (obj instanceof SearchShopResult) {
                    SearchShopResult searchShopResult = (SearchShopResult) obj;
                    if (Intrinsics.areEqual((Object) this.results, (Object) searchShopResult.results)) {
                        if (this.totalCount == searchShopResult.totalCount) {
                            return true;
                        }
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            List<ShopEntry> list = this.results;
            return ((list != null ? list.hashCode() : 0) * 31) + this.totalCount;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("SearchShopResult(results=");
            sb.append(this.results);
            sb.append(", totalCount=");
            sb.append(this.totalCount);
            sb.append(")");
            return sb.toString();
        }

        public SearchShopResult(@NotNull List<ShopEntry> list, int i) {
            Intrinsics.checkParameterIsNotNull(list, "results");
            this.results = list;
            this.totalCount = i;
        }

        @NotNull
        @NonNull
        public final List<ShopEntry> getResults() {
            return this.results;
        }

        @NonNull
        public final int getTotalCount() {
            return this.totalCount;
        }
    }

    @Validated(factory = ValidatorFactoryImpl.class)
    public static final class Tag {
        private final long id;
        @SerializedName("title")
        @NotNull
        private final String name;

        @NotNull
        public static /* synthetic */ Tag copy$default(Tag tag, long j, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                j = tag.id;
            }
            if ((i & 2) != 0) {
                str = tag.name;
            }
            return tag.copy(j, str);
        }

        public final long component1() {
            return this.id;
        }

        @NotNull
        public final String component2() {
            return this.name;
        }

        @NotNull
        public final Tag copy(long j, @NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "name");
            return new Tag(j, str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                if (obj instanceof Tag) {
                    Tag tag = (Tag) obj;
                    if (!(this.id == tag.id) || !Intrinsics.areEqual((Object) this.name, (Object) tag.name)) {
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
            String str = this.name;
            return i + (str != null ? str.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Tag(id=");
            sb.append(this.id);
            sb.append(", name=");
            sb.append(this.name);
            sb.append(")");
            return sb.toString();
        }

        public Tag(long j, @NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "name");
            this.id = j;
            this.name = str;
        }

        public final long getId() {
            return this.id;
        }

        @NotNull
        public final String getName() {
            return this.name;
        }
    }

    @Validated(factory = ValidatorFactoryImpl.class)
    public static final class TimestampResponse {
        private final int timestamp;

        @NotNull
        public static /* synthetic */ TimestampResponse copy$default(TimestampResponse timestampResponse, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = timestampResponse.timestamp;
            }
            return timestampResponse.copy(i);
        }

        public final int component1() {
            return this.timestamp;
        }

        @NotNull
        public final TimestampResponse copy(int i) {
            return new TimestampResponse(i);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                if (obj instanceof TimestampResponse) {
                    if (this.timestamp == ((TimestampResponse) obj).timestamp) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            return this.timestamp;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("TimestampResponse(timestamp=");
            sb.append(this.timestamp);
            sb.append(")");
            return sb.toString();
        }

        public TimestampResponse(int i) {
            this.timestamp = i;
        }

        public final int getTimestamp() {
            return this.timestamp;
        }
    }

    public static final class UnifiedSearch {
        @SerializedName("has_more")
        @NotNull
        private final hasMoreSearch hasMore;
        @SerializedName("posts")
        @NotNull
        private final List<Post> posts;
        @SerializedName("products")
        @NotNull
        private final List<kr.co.popone.fitts.model.product.Product> products;
        @SerializedName("shops")
        @NotNull
        private final List<StoreInfo> store;
        @SerializedName("users")
        @NotNull
        private final List<User> users;

        /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<kr.co.popone.fitts.model.datamodel.service.user.User>, for r5v0, types: [java.util.List] */
        /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<kr.co.popone.fitts.model.post.PostAPI$Post>, for r4v0, types: [java.util.List] */
        /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<kr.co.popone.fitts.model.product.Product>, for r6v0, types: [java.util.List] */
        /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<kr.co.popone.fitts.model.store.StoreInfo>, for r7v0, types: [java.util.List] */
        @org.jetbrains.annotations.NotNull
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static /* synthetic */ kr.co.popone.fitts.model.search.SearchAPI.UnifiedSearch copy$default(kr.co.popone.fitts.model.search.SearchAPI.UnifiedSearch r3, java.util.List<kr.co.popone.fitts.model.post.PostAPI.Post> r4, java.util.List<kr.co.popone.fitts.model.datamodel.service.user.User> r5, java.util.List<kr.co.popone.fitts.model.product.Product> r6, java.util.List<kr.co.popone.fitts.model.store.StoreInfo> r7, kr.co.popone.fitts.model.search.SearchAPI.hasMoreSearch r8, int r9, java.lang.Object r10) {
            /*
                r10 = r9 & 1
                if (r10 == 0) goto L_0x0006
                java.util.List<kr.co.popone.fitts.model.post.PostAPI$Post> r4 = r3.posts
            L_0x0006:
                r10 = r9 & 2
                if (r10 == 0) goto L_0x000c
                java.util.List<kr.co.popone.fitts.model.datamodel.service.user.User> r5 = r3.users
            L_0x000c:
                r10 = r5
                r5 = r9 & 4
                if (r5 == 0) goto L_0x0013
                java.util.List<kr.co.popone.fitts.model.product.Product> r6 = r3.products
            L_0x0013:
                r0 = r6
                r5 = r9 & 8
                if (r5 == 0) goto L_0x001a
                java.util.List<kr.co.popone.fitts.model.store.StoreInfo> r7 = r3.store
            L_0x001a:
                r1 = r7
                r5 = r9 & 16
                if (r5 == 0) goto L_0x0021
                kr.co.popone.fitts.model.search.SearchAPI$hasMoreSearch r8 = r3.hasMore
            L_0x0021:
                r2 = r8
                r5 = r3
                r6 = r4
                r7 = r10
                r8 = r0
                r9 = r1
                r10 = r2
                kr.co.popone.fitts.model.search.SearchAPI$UnifiedSearch r3 = r5.copy(r6, r7, r8, r9, r10)
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.search.SearchAPI.UnifiedSearch.copy$default(kr.co.popone.fitts.model.search.SearchAPI$UnifiedSearch, java.util.List, java.util.List, java.util.List, java.util.List, kr.co.popone.fitts.model.search.SearchAPI$hasMoreSearch, int, java.lang.Object):kr.co.popone.fitts.model.search.SearchAPI$UnifiedSearch");
        }

        @NotNull
        public final List<Post> component1() {
            return this.posts;
        }

        @NotNull
        public final List<User> component2() {
            return this.users;
        }

        @NotNull
        public final List<kr.co.popone.fitts.model.product.Product> component3() {
            return this.products;
        }

        @NotNull
        public final List<StoreInfo> component4() {
            return this.store;
        }

        @NotNull
        public final hasMoreSearch component5() {
            return this.hasMore;
        }

        @NotNull
        public final UnifiedSearch copy(@NotNull List<Post> list, @NotNull List<User> list2, @NotNull List<kr.co.popone.fitts.model.product.Product> list3, @NotNull List<StoreInfo> list4, @NotNull hasMoreSearch hasmoresearch) {
            Intrinsics.checkParameterIsNotNull(list, "posts");
            Intrinsics.checkParameterIsNotNull(list2, "users");
            Intrinsics.checkParameterIsNotNull(list3, "products");
            Intrinsics.checkParameterIsNotNull(list4, "store");
            Intrinsics.checkParameterIsNotNull(hasmoresearch, "hasMore");
            UnifiedSearch unifiedSearch = new UnifiedSearch(list, list2, list3, list4, hasmoresearch);
            return unifiedSearch;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0038, code lost:
            if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2.hasMore, (java.lang.Object) r3.hasMore) != false) goto L_0x003d;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r3) {
            /*
                r2 = this;
                if (r2 == r3) goto L_0x003d
                boolean r0 = r3 instanceof kr.co.popone.fitts.model.search.SearchAPI.UnifiedSearch
                if (r0 == 0) goto L_0x003b
                kr.co.popone.fitts.model.search.SearchAPI$UnifiedSearch r3 = (kr.co.popone.fitts.model.search.SearchAPI.UnifiedSearch) r3
                java.util.List<kr.co.popone.fitts.model.post.PostAPI$Post> r0 = r2.posts
                java.util.List<kr.co.popone.fitts.model.post.PostAPI$Post> r1 = r3.posts
                boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
                if (r0 == 0) goto L_0x003b
                java.util.List<kr.co.popone.fitts.model.datamodel.service.user.User> r0 = r2.users
                java.util.List<kr.co.popone.fitts.model.datamodel.service.user.User> r1 = r3.users
                boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
                if (r0 == 0) goto L_0x003b
                java.util.List<kr.co.popone.fitts.model.product.Product> r0 = r2.products
                java.util.List<kr.co.popone.fitts.model.product.Product> r1 = r3.products
                boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
                if (r0 == 0) goto L_0x003b
                java.util.List<kr.co.popone.fitts.model.store.StoreInfo> r0 = r2.store
                java.util.List<kr.co.popone.fitts.model.store.StoreInfo> r1 = r3.store
                boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
                if (r0 == 0) goto L_0x003b
                kr.co.popone.fitts.model.search.SearchAPI$hasMoreSearch r0 = r2.hasMore
                kr.co.popone.fitts.model.search.SearchAPI$hasMoreSearch r3 = r3.hasMore
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
            throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.search.SearchAPI.UnifiedSearch.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            List<Post> list = this.posts;
            int i = 0;
            int hashCode = (list != null ? list.hashCode() : 0) * 31;
            List<User> list2 = this.users;
            int hashCode2 = (hashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
            List<kr.co.popone.fitts.model.product.Product> list3 = this.products;
            int hashCode3 = (hashCode2 + (list3 != null ? list3.hashCode() : 0)) * 31;
            List<StoreInfo> list4 = this.store;
            int hashCode4 = (hashCode3 + (list4 != null ? list4.hashCode() : 0)) * 31;
            hasMoreSearch hasmoresearch = this.hasMore;
            if (hasmoresearch != null) {
                i = hasmoresearch.hashCode();
            }
            return hashCode4 + i;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("UnifiedSearch(posts=");
            sb.append(this.posts);
            sb.append(", users=");
            sb.append(this.users);
            sb.append(", products=");
            sb.append(this.products);
            sb.append(", store=");
            sb.append(this.store);
            sb.append(", hasMore=");
            sb.append(this.hasMore);
            sb.append(")");
            return sb.toString();
        }

        public UnifiedSearch(@NotNull List<Post> list, @NotNull List<User> list2, @NotNull List<kr.co.popone.fitts.model.product.Product> list3, @NotNull List<StoreInfo> list4, @NotNull hasMoreSearch hasmoresearch) {
            Intrinsics.checkParameterIsNotNull(list, "posts");
            Intrinsics.checkParameterIsNotNull(list2, "users");
            Intrinsics.checkParameterIsNotNull(list3, "products");
            Intrinsics.checkParameterIsNotNull(list4, "store");
            Intrinsics.checkParameterIsNotNull(hasmoresearch, "hasMore");
            this.posts = list;
            this.users = list2;
            this.products = list3;
            this.store = list4;
            this.hasMore = hasmoresearch;
        }

        @NotNull
        public final List<Post> getPosts() {
            return this.posts;
        }

        @NotNull
        public final List<User> getUsers() {
            return this.users;
        }

        @NotNull
        public final List<kr.co.popone.fitts.model.product.Product> getProducts() {
            return this.products;
        }

        @NotNull
        public final List<StoreInfo> getStore() {
            return this.store;
        }

        @NotNull
        public final hasMoreSearch getHasMore() {
            return this.hasMore;
        }
    }

    public static final class hasMoreSearch {
        @SerializedName("post")
        private final boolean hasMorePost;
        @SerializedName("product")
        private final boolean hasMoreProduct;
        @SerializedName("user")
        private final boolean hasMoreUser;

        @NotNull
        public static /* synthetic */ hasMoreSearch copy$default(hasMoreSearch hasmoresearch, boolean z, boolean z2, boolean z3, int i, Object obj) {
            if ((i & 1) != 0) {
                z = hasmoresearch.hasMorePost;
            }
            if ((i & 2) != 0) {
                z2 = hasmoresearch.hasMoreUser;
            }
            if ((i & 4) != 0) {
                z3 = hasmoresearch.hasMoreProduct;
            }
            return hasmoresearch.copy(z, z2, z3);
        }

        public final boolean component1() {
            return this.hasMorePost;
        }

        public final boolean component2() {
            return this.hasMoreUser;
        }

        public final boolean component3() {
            return this.hasMoreProduct;
        }

        @NotNull
        public final hasMoreSearch copy(boolean z, boolean z2, boolean z3) {
            return new hasMoreSearch(z, z2, z3);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                if (obj instanceof hasMoreSearch) {
                    hasMoreSearch hasmoresearch = (hasMoreSearch) obj;
                    if (this.hasMorePost == hasmoresearch.hasMorePost) {
                        if (this.hasMoreUser == hasmoresearch.hasMoreUser) {
                            if (this.hasMoreProduct == hasmoresearch.hasMoreProduct) {
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            boolean z = this.hasMorePost;
            int i = 1;
            if (z) {
                z = true;
            }
            int i2 = (z ? 1 : 0) * true;
            boolean z2 = this.hasMoreUser;
            if (z2) {
                z2 = true;
            }
            int i3 = (i2 + (z2 ? 1 : 0)) * 31;
            boolean z3 = this.hasMoreProduct;
            if (!z3) {
                i = z3;
            }
            return i3 + i;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("hasMoreSearch(hasMorePost=");
            sb.append(this.hasMorePost);
            sb.append(", hasMoreUser=");
            sb.append(this.hasMoreUser);
            sb.append(", hasMoreProduct=");
            sb.append(this.hasMoreProduct);
            sb.append(")");
            return sb.toString();
        }

        public hasMoreSearch(boolean z, boolean z2, boolean z3) {
            this.hasMorePost = z;
            this.hasMoreUser = z2;
            this.hasMoreProduct = z3;
        }

        public final boolean getHasMorePost() {
            return this.hasMorePost;
        }

        public final boolean getHasMoreUser() {
            return this.hasMoreUser;
        }

        public final boolean getHasMoreProduct() {
            return this.hasMoreProduct;
        }
    }

    @PUT("/api/v9/users/{id}/follows")
    @NotNull
    @Headers({"Accept: application/json"})
    Single<String> follow(@Path("id") long j);

    @NotNull
    @GET("/api/v9/search")
    @Headers({"Accept: application/json"})
    Single<KeywordSearchFittieResult> getFittieSearchList(@NotNull @Query("query") String str, @NotNull @Query("type") String str2, @Nullable @Query("base") Long l, @Nullable @Query("limit") Integer num);

    @NotNull
    @GET("/api/v9/search")
    @Headers({"Accept: application/json"})
    Single<KeywordSearchPostResult> getPostSearchList(@NotNull @Query("query") String str, @NotNull @Query("type") String str2, @Nullable @Query("base") Long l, @Nullable @Query("limit") Integer num);

    @NotNull
    @GET("/api/v9/search")
    @Headers({"Accept: application/json"})
    Single<KeywordSearchProductResult> getProductSearchList(@NotNull @Query("query") String str, @NotNull @Query("type") String str2, @Nullable @Query("base") Long l, @Nullable @Query("limit") Integer num);

    @NotNull
    @GET("/api/v9/search/recommendation")
    @Headers({"Accept: application/json"})
    Single<SearchRecommend> getRecommendSearchList();

    @NotNull
    @GET("/api/v9/search/unified")
    @Headers({"Accept: application/json"})
    Single<UnifiedSearch> getUnifiedSearchList(@NotNull @Query("query") String str);

    @NotNull
    @GET("/api/v9/shops/search")
    @Headers({"Accept: application/json"})
    Single<SearchShopResult> searchShops(@NotNull @Query("query") String str, @Nullable @Query("base") Long l, @Nullable @Query("limit") Integer num);
}
