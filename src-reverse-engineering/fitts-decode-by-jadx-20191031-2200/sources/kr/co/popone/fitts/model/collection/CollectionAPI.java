package kr.co.popone.fitts.model.collection;

import androidx.annotation.NonNull;
import com.google.gson.annotations.SerializedName;
import com.uber.rave.annotation.Validated;
import io.reactivex.Single;
import java.util.Date;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.datamodel.service.user.User;
import kr.co.popone.fitts.model.post.PostAPI.Post;
import kr.co.popone.fitts.model.product.Product;
import kr.co.popone.fitts.model.validation.ValidatorFactoryImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CollectionAPI {

    @Validated(factory = ValidatorFactoryImpl.class)
    public static final class CollectionDetailResponse {
        @SerializedName("button")
        @Nullable
        private final ButtonProperties buttonProperties;
        @SerializedName("created_at")
        @NotNull
        private final Date createdAt;
        @SerializedName("description_1")
        @Nullable
        private final String description1;
        @SerializedName("description_2")
        @Nullable
        private final String description2;
        private final boolean display;
        private final long id;
        @SerializedName("main_image_ratio")
        private final float mainImageRatio;
        @SerializedName("main_image_url")
        @Nullable
        private final String mainImageUrl;
        @SerializedName("short_title")
        @Nullable
        private final String shortTitle;
        @NotNull
        private final String size;
        @NotNull
        private final String title;
        @NotNull
        private final CollectionType type;

        @Validated(factory = ValidatorFactoryImpl.class)
        public static final class ButtonProperties {
            @SerializedName("btn_scheme")
            @Nullable
            private final String actionScheme;
            @SerializedName("btn_bg_color")
            @Nullable
            private final String backgroundColor;
            @SerializedName("btn_font_size")
            private final int fontSize;
            @SerializedName("btn_text_color")
            @Nullable
            private final String textColor;
            @SerializedName("btn_text")
            @Nullable
            private final String title;

            @NotNull
            public static /* synthetic */ ButtonProperties copy$default(ButtonProperties buttonProperties, String str, String str2, String str3, int i, String str4, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    str = buttonProperties.backgroundColor;
                }
                if ((i2 & 2) != 0) {
                    str2 = buttonProperties.textColor;
                }
                String str5 = str2;
                if ((i2 & 4) != 0) {
                    str3 = buttonProperties.title;
                }
                String str6 = str3;
                if ((i2 & 8) != 0) {
                    i = buttonProperties.fontSize;
                }
                int i3 = i;
                if ((i2 & 16) != 0) {
                    str4 = buttonProperties.actionScheme;
                }
                return buttonProperties.copy(str, str5, str6, i3, str4);
            }

            @Nullable
            public final String component1() {
                return this.backgroundColor;
            }

            @Nullable
            public final String component2() {
                return this.textColor;
            }

            @Nullable
            public final String component3() {
                return this.title;
            }

            public final int component4() {
                return this.fontSize;
            }

            @Nullable
            public final String component5() {
                return this.actionScheme;
            }

            @NotNull
            public final ButtonProperties copy(@Nullable String str, @Nullable String str2, @Nullable String str3, int i, @Nullable String str4) {
                ButtonProperties buttonProperties = new ButtonProperties(str, str2, str3, i, str4);
                return buttonProperties;
            }

            public boolean equals(@Nullable Object obj) {
                if (this != obj) {
                    if (obj instanceof ButtonProperties) {
                        ButtonProperties buttonProperties = (ButtonProperties) obj;
                        if (Intrinsics.areEqual((Object) this.backgroundColor, (Object) buttonProperties.backgroundColor) && Intrinsics.areEqual((Object) this.textColor, (Object) buttonProperties.textColor) && Intrinsics.areEqual((Object) this.title, (Object) buttonProperties.title)) {
                            if (!(this.fontSize == buttonProperties.fontSize) || !Intrinsics.areEqual((Object) this.actionScheme, (Object) buttonProperties.actionScheme)) {
                                return false;
                            }
                        }
                    }
                    return false;
                }
                return true;
            }

            public int hashCode() {
                String str = this.backgroundColor;
                int i = 0;
                int hashCode = (str != null ? str.hashCode() : 0) * 31;
                String str2 = this.textColor;
                int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
                String str3 = this.title;
                int hashCode3 = (((hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.fontSize) * 31;
                String str4 = this.actionScheme;
                if (str4 != null) {
                    i = str4.hashCode();
                }
                return hashCode3 + i;
            }

            @NotNull
            public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append("ButtonProperties(backgroundColor=");
                sb.append(this.backgroundColor);
                sb.append(", textColor=");
                sb.append(this.textColor);
                sb.append(", title=");
                sb.append(this.title);
                sb.append(", fontSize=");
                sb.append(this.fontSize);
                sb.append(", actionScheme=");
                sb.append(this.actionScheme);
                sb.append(")");
                return sb.toString();
            }

            public ButtonProperties(@Nullable String str, @Nullable String str2, @Nullable String str3, int i, @Nullable String str4) {
                this.backgroundColor = str;
                this.textColor = str2;
                this.title = str3;
                this.fontSize = i;
                this.actionScheme = str4;
            }

            @Nullable
            public final String getBackgroundColor() {
                return this.backgroundColor;
            }

            @Nullable
            public final String getTextColor() {
                return this.textColor;
            }

            @Nullable
            public final String getTitle() {
                return this.title;
            }

            public final int getFontSize() {
                return this.fontSize;
            }

            @Nullable
            public final String getActionScheme() {
                return this.actionScheme;
            }
        }

        @NotNull
        public static /* synthetic */ CollectionDetailResponse copy$default(CollectionDetailResponse collectionDetailResponse, long j, CollectionType collectionType, boolean z, String str, String str2, String str3, String str4, String str5, String str6, float f, Date date, ButtonProperties buttonProperties2, int i, Object obj) {
            CollectionDetailResponse collectionDetailResponse2 = collectionDetailResponse;
            int i2 = i;
            return collectionDetailResponse.copy((i2 & 1) != 0 ? collectionDetailResponse2.id : j, (i2 & 2) != 0 ? collectionDetailResponse2.type : collectionType, (i2 & 4) != 0 ? collectionDetailResponse2.display : z, (i2 & 8) != 0 ? collectionDetailResponse2.title : str, (i2 & 16) != 0 ? collectionDetailResponse2.size : str2, (i2 & 32) != 0 ? collectionDetailResponse2.shortTitle : str3, (i2 & 64) != 0 ? collectionDetailResponse2.description1 : str4, (i2 & 128) != 0 ? collectionDetailResponse2.description2 : str5, (i2 & 256) != 0 ? collectionDetailResponse2.mainImageUrl : str6, (i2 & 512) != 0 ? collectionDetailResponse2.mainImageRatio : f, (i2 & 1024) != 0 ? collectionDetailResponse2.createdAt : date, (i2 & 2048) != 0 ? collectionDetailResponse2.buttonProperties : buttonProperties2);
        }

        public final long component1() {
            return this.id;
        }

        public final float component10() {
            return this.mainImageRatio;
        }

        @NotNull
        public final Date component11() {
            return this.createdAt;
        }

        @Nullable
        public final ButtonProperties component12() {
            return this.buttonProperties;
        }

        @NotNull
        public final CollectionType component2() {
            return this.type;
        }

        public final boolean component3() {
            return this.display;
        }

        @NotNull
        public final String component4() {
            return this.title;
        }

        @NotNull
        public final String component5() {
            return this.size;
        }

        @Nullable
        public final String component6() {
            return this.shortTitle;
        }

        @Nullable
        public final String component7() {
            return this.description1;
        }

        @Nullable
        public final String component8() {
            return this.description2;
        }

        @Nullable
        public final String component9() {
            return this.mainImageUrl;
        }

        @NotNull
        public final CollectionDetailResponse copy(long j, @NotNull CollectionType collectionType, boolean z, @NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, float f, @NotNull Date date, @Nullable ButtonProperties buttonProperties2) {
            CollectionType collectionType2 = collectionType;
            Intrinsics.checkParameterIsNotNull(collectionType2, "type");
            String str7 = str;
            Intrinsics.checkParameterIsNotNull(str7, "title");
            String str8 = str2;
            Intrinsics.checkParameterIsNotNull(str8, "size");
            Date date2 = date;
            Intrinsics.checkParameterIsNotNull(date2, "createdAt");
            CollectionDetailResponse collectionDetailResponse = new CollectionDetailResponse(j, collectionType2, z, str7, str8, str3, str4, str5, str6, f, date2, buttonProperties2);
            return collectionDetailResponse;
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                if (obj instanceof CollectionDetailResponse) {
                    CollectionDetailResponse collectionDetailResponse = (CollectionDetailResponse) obj;
                    if ((this.id == collectionDetailResponse.id) && Intrinsics.areEqual((Object) this.type, (Object) collectionDetailResponse.type)) {
                        if (!(this.display == collectionDetailResponse.display) || !Intrinsics.areEqual((Object) this.title, (Object) collectionDetailResponse.title) || !Intrinsics.areEqual((Object) this.size, (Object) collectionDetailResponse.size) || !Intrinsics.areEqual((Object) this.shortTitle, (Object) collectionDetailResponse.shortTitle) || !Intrinsics.areEqual((Object) this.description1, (Object) collectionDetailResponse.description1) || !Intrinsics.areEqual((Object) this.description2, (Object) collectionDetailResponse.description2) || !Intrinsics.areEqual((Object) this.mainImageUrl, (Object) collectionDetailResponse.mainImageUrl) || Float.compare(this.mainImageRatio, collectionDetailResponse.mainImageRatio) != 0 || !Intrinsics.areEqual((Object) this.createdAt, (Object) collectionDetailResponse.createdAt) || !Intrinsics.areEqual((Object) this.buttonProperties, (Object) collectionDetailResponse.buttonProperties)) {
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
            CollectionType collectionType = this.type;
            int i2 = 0;
            int hashCode = (i + (collectionType != null ? collectionType.hashCode() : 0)) * 31;
            boolean z = this.display;
            if (z) {
                z = true;
            }
            int i3 = (hashCode + (z ? 1 : 0)) * 31;
            String str = this.title;
            int hashCode2 = (i3 + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.size;
            int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.shortTitle;
            int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.description1;
            int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
            String str5 = this.description2;
            int hashCode6 = (hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31;
            String str6 = this.mainImageUrl;
            int hashCode7 = (((hashCode6 + (str6 != null ? str6.hashCode() : 0)) * 31) + Float.floatToIntBits(this.mainImageRatio)) * 31;
            Date date = this.createdAt;
            int hashCode8 = (hashCode7 + (date != null ? date.hashCode() : 0)) * 31;
            ButtonProperties buttonProperties2 = this.buttonProperties;
            if (buttonProperties2 != null) {
                i2 = buttonProperties2.hashCode();
            }
            return hashCode8 + i2;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("CollectionDetailResponse(id=");
            sb.append(this.id);
            sb.append(", type=");
            sb.append(this.type);
            sb.append(", display=");
            sb.append(this.display);
            sb.append(", title=");
            sb.append(this.title);
            sb.append(", size=");
            sb.append(this.size);
            sb.append(", shortTitle=");
            sb.append(this.shortTitle);
            sb.append(", description1=");
            sb.append(this.description1);
            sb.append(", description2=");
            sb.append(this.description2);
            sb.append(", mainImageUrl=");
            sb.append(this.mainImageUrl);
            sb.append(", mainImageRatio=");
            sb.append(this.mainImageRatio);
            sb.append(", createdAt=");
            sb.append(this.createdAt);
            sb.append(", buttonProperties=");
            sb.append(this.buttonProperties);
            sb.append(")");
            return sb.toString();
        }

        public CollectionDetailResponse(long j, @NotNull CollectionType collectionType, boolean z, @NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, float f, @NotNull Date date, @Nullable ButtonProperties buttonProperties2) {
            Intrinsics.checkParameterIsNotNull(collectionType, "type");
            Intrinsics.checkParameterIsNotNull(str, "title");
            Intrinsics.checkParameterIsNotNull(str2, "size");
            Intrinsics.checkParameterIsNotNull(date, "createdAt");
            this.id = j;
            this.type = collectionType;
            this.display = z;
            this.title = str;
            this.size = str2;
            this.shortTitle = str3;
            this.description1 = str4;
            this.description2 = str5;
            this.mainImageUrl = str6;
            this.mainImageRatio = f;
            this.createdAt = date;
            this.buttonProperties = buttonProperties2;
        }

        public final long getId() {
            return this.id;
        }

        @NotNull
        @NonNull
        public final CollectionType getType() {
            return this.type;
        }

        public final boolean getDisplay() {
            return this.display;
        }

        @NotNull
        @NonNull
        public final String getTitle() {
            return this.title;
        }

        @NotNull
        public final String getSize() {
            return this.size;
        }

        @Nullable
        public final String getShortTitle() {
            return this.shortTitle;
        }

        @Nullable
        public final String getDescription1() {
            return this.description1;
        }

        @Nullable
        public final String getDescription2() {
            return this.description2;
        }

        @Nullable
        public final String getMainImageUrl() {
            return this.mainImageUrl;
        }

        public final float getMainImageRatio() {
            return this.mainImageRatio;
        }

        @NotNull
        @NonNull
        public final Date getCreatedAt() {
            return this.createdAt;
        }

        @Nullable
        public final ButtonProperties getButtonProperties() {
            return this.buttonProperties;
        }
    }

    @Validated(factory = ValidatorFactoryImpl.class)
    public static final class CollectionEntry {
        @NotNull
        private final String background;
        private final int columns;
        private final long id;
        @Nullable
        private final CollectionImage image;
        @NotNull
        private final String link_url;
        @Nullable
        private final Post post;
        @Nullable
        private final List<Post> posts;
        @Nullable
        private final List<Product> products;
        @NotNull
        private final CollectionType type;
        @Nullable
        private final User user;

        @NotNull
        public static /* synthetic */ CollectionEntry copy$default(CollectionEntry collectionEntry, long j, int i, String str, String str2, CollectionType collectionType, User user2, Post post2, CollectionImage collectionImage, List list, List list2, int i2, Object obj) {
            CollectionEntry collectionEntry2 = collectionEntry;
            int i3 = i2;
            return collectionEntry.copy((i3 & 1) != 0 ? collectionEntry2.id : j, (i3 & 2) != 0 ? collectionEntry2.columns : i, (i3 & 4) != 0 ? collectionEntry2.link_url : str, (i3 & 8) != 0 ? collectionEntry2.background : str2, (i3 & 16) != 0 ? collectionEntry2.type : collectionType, (i3 & 32) != 0 ? collectionEntry2.user : user2, (i3 & 64) != 0 ? collectionEntry2.post : post2, (i3 & 128) != 0 ? collectionEntry2.image : collectionImage, (i3 & 256) != 0 ? collectionEntry2.posts : list, (i3 & 512) != 0 ? collectionEntry2.products : list2);
        }

        public final long component1() {
            return this.id;
        }

        @Nullable
        public final List<Product> component10() {
            return this.products;
        }

        public final int component2() {
            return this.columns;
        }

        @NotNull
        public final String component3() {
            return this.link_url;
        }

        @NotNull
        public final String component4() {
            return this.background;
        }

        @NotNull
        public final CollectionType component5() {
            return this.type;
        }

        @Nullable
        public final User component6() {
            return this.user;
        }

        @Nullable
        public final Post component7() {
            return this.post;
        }

        @Nullable
        public final CollectionImage component8() {
            return this.image;
        }

        @Nullable
        public final List<Post> component9() {
            return this.posts;
        }

        @NotNull
        public final CollectionEntry copy(long j, int i, @NotNull String str, @NotNull String str2, @NotNull CollectionType collectionType, @Nullable User user2, @Nullable Post post2, @Nullable CollectionImage collectionImage, @Nullable List<Post> list, @Nullable List<Product> list2) {
            String str3 = str;
            Intrinsics.checkParameterIsNotNull(str3, "link_url");
            String str4 = str2;
            Intrinsics.checkParameterIsNotNull(str4, "background");
            CollectionType collectionType2 = collectionType;
            Intrinsics.checkParameterIsNotNull(collectionType2, "type");
            CollectionEntry collectionEntry = new CollectionEntry(j, i, str3, str4, collectionType2, user2, post2, collectionImage, list, list2);
            return collectionEntry;
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                if (obj instanceof CollectionEntry) {
                    CollectionEntry collectionEntry = (CollectionEntry) obj;
                    if (this.id == collectionEntry.id) {
                        if (!(this.columns == collectionEntry.columns) || !Intrinsics.areEqual((Object) this.link_url, (Object) collectionEntry.link_url) || !Intrinsics.areEqual((Object) this.background, (Object) collectionEntry.background) || !Intrinsics.areEqual((Object) this.type, (Object) collectionEntry.type) || !Intrinsics.areEqual((Object) this.user, (Object) collectionEntry.user) || !Intrinsics.areEqual((Object) this.post, (Object) collectionEntry.post) || !Intrinsics.areEqual((Object) this.image, (Object) collectionEntry.image) || !Intrinsics.areEqual((Object) this.posts, (Object) collectionEntry.posts) || !Intrinsics.areEqual((Object) this.products, (Object) collectionEntry.products)) {
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
            int i = ((((int) (j ^ (j >>> 32))) * 31) + this.columns) * 31;
            String str = this.link_url;
            int i2 = 0;
            int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.background;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            CollectionType collectionType = this.type;
            int hashCode3 = (hashCode2 + (collectionType != null ? collectionType.hashCode() : 0)) * 31;
            User user2 = this.user;
            int hashCode4 = (hashCode3 + (user2 != null ? user2.hashCode() : 0)) * 31;
            Post post2 = this.post;
            int hashCode5 = (hashCode4 + (post2 != null ? post2.hashCode() : 0)) * 31;
            CollectionImage collectionImage = this.image;
            int hashCode6 = (hashCode5 + (collectionImage != null ? collectionImage.hashCode() : 0)) * 31;
            List<Post> list = this.posts;
            int hashCode7 = (hashCode6 + (list != null ? list.hashCode() : 0)) * 31;
            List<Product> list2 = this.products;
            if (list2 != null) {
                i2 = list2.hashCode();
            }
            return hashCode7 + i2;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("CollectionEntry(id=");
            sb.append(this.id);
            sb.append(", columns=");
            sb.append(this.columns);
            sb.append(", link_url=");
            sb.append(this.link_url);
            sb.append(", background=");
            sb.append(this.background);
            sb.append(", type=");
            sb.append(this.type);
            sb.append(", user=");
            sb.append(this.user);
            sb.append(", post=");
            sb.append(this.post);
            sb.append(", image=");
            sb.append(this.image);
            sb.append(", posts=");
            sb.append(this.posts);
            sb.append(", products=");
            sb.append(this.products);
            sb.append(")");
            return sb.toString();
        }

        public CollectionEntry(long j, int i, @NotNull String str, @NotNull String str2, @NotNull CollectionType collectionType, @Nullable User user2, @Nullable Post post2, @Nullable CollectionImage collectionImage, @Nullable List<Post> list, @Nullable List<Product> list2) {
            Intrinsics.checkParameterIsNotNull(str, "link_url");
            Intrinsics.checkParameterIsNotNull(str2, "background");
            Intrinsics.checkParameterIsNotNull(collectionType, "type");
            this.id = j;
            this.columns = i;
            this.link_url = str;
            this.background = str2;
            this.type = collectionType;
            this.user = user2;
            this.post = post2;
            this.image = collectionImage;
            this.posts = list;
            this.products = list2;
        }

        public final long getId() {
            return this.id;
        }

        public final int getColumns() {
            return this.columns;
        }

        @NotNull
        public final String getLink_url() {
            return this.link_url;
        }

        @NotNull
        public final String getBackground() {
            return this.background;
        }

        @NotNull
        @NonNull
        public final CollectionType getType() {
            return this.type;
        }

        @Nullable
        public final User getUser() {
            return this.user;
        }

        @Nullable
        public final Post getPost() {
            return this.post;
        }

        @Nullable
        public final CollectionImage getImage() {
            return this.image;
        }

        @Nullable
        public final List<Post> getPosts() {
            return this.posts;
        }

        @Nullable
        public final List<Product> getProducts() {
            return this.products;
        }
    }

    @Validated(factory = ValidatorFactoryImpl.class)
    public static final class CollectionImage {
        private final double ratio;
        @NotNull
        private final String url;

        @NotNull
        public static /* synthetic */ CollectionImage copy$default(CollectionImage collectionImage, String str, double d, int i, Object obj) {
            if ((i & 1) != 0) {
                str = collectionImage.url;
            }
            if ((i & 2) != 0) {
                d = collectionImage.ratio;
            }
            return collectionImage.copy(str, d);
        }

        @NotNull
        public final String component1() {
            return this.url;
        }

        public final double component2() {
            return this.ratio;
        }

        @NotNull
        public final CollectionImage copy(@NotNull String str, double d) {
            Intrinsics.checkParameterIsNotNull(str, "url");
            return new CollectionImage(str, d);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x001a, code lost:
            if (java.lang.Double.compare(r4.ratio, r5.ratio) == 0) goto L_0x001f;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r5) {
            /*
                r4 = this;
                if (r4 == r5) goto L_0x001f
                boolean r0 = r5 instanceof kr.co.popone.fitts.model.collection.CollectionAPI.CollectionImage
                if (r0 == 0) goto L_0x001d
                kr.co.popone.fitts.model.collection.CollectionAPI$CollectionImage r5 = (kr.co.popone.fitts.model.collection.CollectionAPI.CollectionImage) r5
                java.lang.String r0 = r4.url
                java.lang.String r1 = r5.url
                boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
                if (r0 == 0) goto L_0x001d
                double r0 = r4.ratio
                double r2 = r5.ratio
                int r5 = java.lang.Double.compare(r0, r2)
                if (r5 != 0) goto L_0x001d
                goto L_0x001f
            L_0x001d:
                r5 = 0
                return r5
            L_0x001f:
                r5 = 1
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.collection.CollectionAPI.CollectionImage.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            String str = this.url;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            long doubleToLongBits = Double.doubleToLongBits(this.ratio);
            return hashCode + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("CollectionImage(url=");
            sb.append(this.url);
            sb.append(", ratio=");
            sb.append(this.ratio);
            sb.append(")");
            return sb.toString();
        }

        public CollectionImage(@NotNull String str, double d) {
            Intrinsics.checkParameterIsNotNull(str, "url");
            this.url = str;
            this.ratio = d;
        }

        @NotNull
        public final String getUrl() {
            return this.url;
        }

        public final double getRatio() {
            return this.ratio;
        }
    }

    public enum CollectionType {
        FITTIE,
        POST,
        EDITOR_PICK,
        PROMOTION,
        IMAGE,
        POSTS,
        MIXED,
        PRODUCTS
    }

    @NotNull
    @GET("/api/v9/collections/{id}")
    @Headers({"Accept: application/json"})
    Single<CollectionDetailResponse> requestCollectionDetail(@Path("id") long j);

    @NotNull
    @GET("/api/v9/collections/{id}/contents")
    @Headers({"Accept: application/json"})
    Single<List<CollectionEntry>> requestCollectionList(@Path("id") long j, @Nullable @Query("base") Long l, @Nullable @Query("limit") Integer num);
}
