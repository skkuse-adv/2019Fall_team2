package kr.co.popone.fitts.model.post;

import androidx.annotation.NonNull;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.gson.annotations.SerializedName;
import com.uber.rave.annotation.Validated;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.post.PostType;
import kr.co.popone.fitts.model.datamodel.commerce.Product;
import kr.co.popone.fitts.model.datamodel.commerce.Shop;
import kr.co.popone.fitts.model.datamodel.service.banner.Banner;
import kr.co.popone.fitts.model.datamodel.service.post.Comment;
import kr.co.popone.fitts.model.datamodel.service.post.CreatePostImage;
import kr.co.popone.fitts.model.datamodel.service.post.Image;
import kr.co.popone.fitts.model.datamodel.service.post.LikeResult;
import kr.co.popone.fitts.model.datamodel.service.user.User;
import kr.co.popone.fitts.model.order.OrderListLineItemVariant;
import kr.co.popone.fitts.model.search.SearchAPI.SearchPostResult;
import kr.co.popone.fitts.model.store.ProductImageInfo;
import kr.co.popone.fitts.model.validation.ValidatorFactoryImpl;
import okhttp3.MultipartBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PostAPI {

    @Validated(factory = ValidatorFactoryImpl.class)
    public static final class Category {
        @SerializedName("group")
        @NotNull
        private final String group;
        private final long id;
        @SerializedName("section")
        @Nullable
        private final String section;
        @SerializedName("subsection")
        @Nullable
        private final String subsection;

        @NotNull
        public static /* synthetic */ Category copy$default(Category category, long j, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                j = category.id;
            }
            long j2 = j;
            if ((i & 2) != 0) {
                str = category.group;
            }
            String str4 = str;
            if ((i & 4) != 0) {
                str2 = category.section;
            }
            String str5 = str2;
            if ((i & 8) != 0) {
                str3 = category.subsection;
            }
            return category.copy(j2, str4, str5, str3);
        }

        public final long component1() {
            return this.id;
        }

        @NotNull
        public final String component2() {
            return this.group;
        }

        @Nullable
        public final String component3() {
            return this.section;
        }

        @Nullable
        public final String component4() {
            return this.subsection;
        }

        @NotNull
        public final Category copy(long j, @NotNull String str, @Nullable String str2, @Nullable String str3) {
            Intrinsics.checkParameterIsNotNull(str, "group");
            Category category = new Category(j, str, str2, str3);
            return category;
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                if (obj instanceof Category) {
                    Category category = (Category) obj;
                    if (!(this.id == category.id) || !Intrinsics.areEqual((Object) this.group, (Object) category.group) || !Intrinsics.areEqual((Object) this.section, (Object) category.section) || !Intrinsics.areEqual((Object) this.subsection, (Object) category.subsection)) {
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
            String str = this.group;
            int i2 = 0;
            int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.section;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.subsection;
            if (str3 != null) {
                i2 = str3.hashCode();
            }
            return hashCode2 + i2;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Category(id=");
            sb.append(this.id);
            sb.append(", group=");
            sb.append(this.group);
            sb.append(", section=");
            sb.append(this.section);
            sb.append(", subsection=");
            sb.append(this.subsection);
            sb.append(")");
            return sb.toString();
        }

        public Category(long j, @NotNull String str, @Nullable String str2, @Nullable String str3) {
            Intrinsics.checkParameterIsNotNull(str, "group");
            this.id = j;
            this.group = str;
            this.section = str2;
            this.subsection = str3;
        }

        public final long getId() {
            return this.id;
        }

        @NotNull
        @NonNull
        public final String getGroup() {
            return this.group;
        }

        @Nullable
        public final String getSection() {
            return this.section;
        }

        public /* synthetic */ Category(long j, String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3);
        }

        @Nullable
        public final String getSubsection() {
            return this.subsection;
        }
    }

    public static final class CategoryPostItem {
        @SerializedName("id")
        private final long feedId;
        @SerializedName("item")
        @NotNull
        private final Post post;
        @SerializedName("type")
        @NotNull
        private final String type;

        @NotNull
        public static /* synthetic */ CategoryPostItem copy$default(CategoryPostItem categoryPostItem, long j, String str, Post post2, int i, Object obj) {
            if ((i & 1) != 0) {
                j = categoryPostItem.feedId;
            }
            if ((i & 2) != 0) {
                str = categoryPostItem.type;
            }
            if ((i & 4) != 0) {
                post2 = categoryPostItem.post;
            }
            return categoryPostItem.copy(j, str, post2);
        }

        public final long component1() {
            return this.feedId;
        }

        @NotNull
        public final String component2() {
            return this.type;
        }

        @NotNull
        public final Post component3() {
            return this.post;
        }

        @NotNull
        public final CategoryPostItem copy(long j, @NotNull String str, @NotNull Post post2) {
            Intrinsics.checkParameterIsNotNull(str, "type");
            Intrinsics.checkParameterIsNotNull(post2, "post");
            return new CategoryPostItem(j, str, post2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                if (obj instanceof CategoryPostItem) {
                    CategoryPostItem categoryPostItem = (CategoryPostItem) obj;
                    if (!(this.feedId == categoryPostItem.feedId) || !Intrinsics.areEqual((Object) this.type, (Object) categoryPostItem.type) || !Intrinsics.areEqual((Object) this.post, (Object) categoryPostItem.post)) {
                        return false;
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            long j = this.feedId;
            int i = ((int) (j ^ (j >>> 32))) * 31;
            String str = this.type;
            int i2 = 0;
            int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
            Post post2 = this.post;
            if (post2 != null) {
                i2 = post2.hashCode();
            }
            return hashCode + i2;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("CategoryPostItem(feedId=");
            sb.append(this.feedId);
            sb.append(", type=");
            sb.append(this.type);
            sb.append(", post=");
            sb.append(this.post);
            sb.append(")");
            return sb.toString();
        }

        public CategoryPostItem(long j, @NotNull String str, @NotNull Post post2) {
            Intrinsics.checkParameterIsNotNull(str, "type");
            Intrinsics.checkParameterIsNotNull(post2, "post");
            this.feedId = j;
            this.type = str;
            this.post = post2;
        }

        public final long getFeedId() {
            return this.feedId;
        }

        @NotNull
        public final String getType() {
            return this.type;
        }

        @NotNull
        public final Post getPost() {
            return this.post;
        }
    }

    public static final class CategoryPostListResponse {
        @SerializedName("items")
        @NotNull
        private final List<CategoryPostItem> items;
        @SerializedName("version")
        @NotNull
        private final String version;

        /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<kr.co.popone.fitts.model.post.PostAPI$CategoryPostItem>, for r2v0, types: [java.util.List] */
        @org.jetbrains.annotations.NotNull
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static /* synthetic */ kr.co.popone.fitts.model.post.PostAPI.CategoryPostListResponse copy$default(kr.co.popone.fitts.model.post.PostAPI.CategoryPostListResponse r0, java.lang.String r1, java.util.List<kr.co.popone.fitts.model.post.PostAPI.CategoryPostItem> r2, int r3, java.lang.Object r4) {
            /*
                r4 = r3 & 1
                if (r4 == 0) goto L_0x0006
                java.lang.String r1 = r0.version
            L_0x0006:
                r3 = r3 & 2
                if (r3 == 0) goto L_0x000c
                java.util.List<kr.co.popone.fitts.model.post.PostAPI$CategoryPostItem> r2 = r0.items
            L_0x000c:
                kr.co.popone.fitts.model.post.PostAPI$CategoryPostListResponse r0 = r0.copy(r1, r2)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.post.PostAPI.CategoryPostListResponse.copy$default(kr.co.popone.fitts.model.post.PostAPI$CategoryPostListResponse, java.lang.String, java.util.List, int, java.lang.Object):kr.co.popone.fitts.model.post.PostAPI$CategoryPostListResponse");
        }

        @NotNull
        public final String component1() {
            return this.version;
        }

        @NotNull
        public final List<CategoryPostItem> component2() {
            return this.items;
        }

        @NotNull
        public final CategoryPostListResponse copy(@NotNull String str, @NotNull List<CategoryPostItem> list) {
            Intrinsics.checkParameterIsNotNull(str, ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION);
            Intrinsics.checkParameterIsNotNull(list, "items");
            return new CategoryPostListResponse(str, list);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x001a, code lost:
            if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2.items, (java.lang.Object) r3.items) != false) goto L_0x001f;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r3) {
            /*
                r2 = this;
                if (r2 == r3) goto L_0x001f
                boolean r0 = r3 instanceof kr.co.popone.fitts.model.post.PostAPI.CategoryPostListResponse
                if (r0 == 0) goto L_0x001d
                kr.co.popone.fitts.model.post.PostAPI$CategoryPostListResponse r3 = (kr.co.popone.fitts.model.post.PostAPI.CategoryPostListResponse) r3
                java.lang.String r0 = r2.version
                java.lang.String r1 = r3.version
                boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
                if (r0 == 0) goto L_0x001d
                java.util.List<kr.co.popone.fitts.model.post.PostAPI$CategoryPostItem> r0 = r2.items
                java.util.List<kr.co.popone.fitts.model.post.PostAPI$CategoryPostItem> r3 = r3.items
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
            throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.post.PostAPI.CategoryPostListResponse.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            String str = this.version;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            List<CategoryPostItem> list = this.items;
            if (list != null) {
                i = list.hashCode();
            }
            return hashCode + i;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("CategoryPostListResponse(version=");
            sb.append(this.version);
            sb.append(", items=");
            sb.append(this.items);
            sb.append(")");
            return sb.toString();
        }

        public CategoryPostListResponse(@NotNull String str, @NotNull List<CategoryPostItem> list) {
            Intrinsics.checkParameterIsNotNull(str, ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION);
            Intrinsics.checkParameterIsNotNull(list, "items");
            this.version = str;
            this.items = list;
        }

        @NotNull
        public final String getVersion() {
            return this.version;
        }

        @NotNull
        public final List<CategoryPostItem> getItems() {
            return this.items;
        }
    }

    @Validated(factory = ValidatorFactoryImpl.class)
    public static final class CreatePost implements Serializable {
        @NotNull
        private String aboutFit;
        @NotNull
        private String aboutProduct;
        @NotNull
        private String aboutSize;
        private int coverID;
        @NotNull
        private String coverImagePath;
        @NotNull
        private ArrayList<PostContent> freeformImageIDs = new ArrayList<>();
        @NotNull
        private ArrayList<CreatePostImage> freeformImagesPath = new ArrayList<>();
        private long postID;
        @NotNull
        private PostType postType;
        @NotNull
        private String price;
        @NotNull
        private String shop;
        @NotNull
        private String shopImage;
        @NotNull
        private String shopName;
        private float star;
        @NotNull
        private ArrayList<String> styleTags = new ArrayList<>();
        @NotNull
        private ArrayList<String> tags = new ArrayList<>();
        @NotNull
        private String title;

        @NotNull
        public static /* synthetic */ CreatePost copy$default(CreatePost createPost, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                j = createPost.postID;
            }
            return createPost.copy(j);
        }

        public final long component1() {
            return this.postID;
        }

        @NotNull
        public final CreatePost copy(long j) {
            return new CreatePost(j);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                if (obj instanceof CreatePost) {
                    if (this.postID == ((CreatePost) obj).postID) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            long j = this.postID;
            return (int) (j ^ (j >>> 32));
        }

        public CreatePost(long j) {
            this.postID = j;
            String str = "";
            this.title = str;
            this.aboutFit = str;
            this.aboutProduct = str;
            this.coverImagePath = str;
            this.aboutSize = str;
            this.shop = str;
            this.shopName = str;
            this.price = str;
            this.shopImage = str;
            this.postType = PostType.CLOTHES;
        }

        public final long getPostID() {
            return this.postID;
        }

        public final void setPostID(long j) {
            this.postID = j;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        public final void setTitle(@NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "<set-?>");
            this.title = str;
        }

        @NotNull
        public final String getAboutFit() {
            return this.aboutFit;
        }

        public final void setAboutFit(@NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "<set-?>");
            this.aboutFit = str;
        }

        @NotNull
        public final String getAboutProduct() {
            return this.aboutProduct;
        }

        public final void setAboutProduct(@NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "<set-?>");
            this.aboutProduct = str;
        }

        public final int getCoverID() {
            return this.coverID;
        }

        public final void setCoverID(int i) {
            this.coverID = i;
        }

        @NotNull
        public final String getCoverImagePath() {
            return this.coverImagePath;
        }

        public final void setCoverImagePath(@NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "<set-?>");
            this.coverImagePath = str;
        }

        @NotNull
        public final ArrayList<CreatePostImage> getFreeformImagesPath() {
            return this.freeformImagesPath;
        }

        public final void setFreeformImagesPath(@NotNull ArrayList<CreatePostImage> arrayList) {
            Intrinsics.checkParameterIsNotNull(arrayList, "<set-?>");
            this.freeformImagesPath = arrayList;
        }

        @NotNull
        public final ArrayList<PostContent> getFreeformImageIDs() {
            return this.freeformImageIDs;
        }

        public final void setFreeformImageIDs(@NotNull ArrayList<PostContent> arrayList) {
            Intrinsics.checkParameterIsNotNull(arrayList, "<set-?>");
            this.freeformImageIDs = arrayList;
        }

        public final float getStar() {
            return this.star;
        }

        public final void setStar(float f) {
            this.star = f;
        }

        @NotNull
        public final ArrayList<String> getTags() {
            return this.tags;
        }

        public final void setTags(@NotNull ArrayList<String> arrayList) {
            Intrinsics.checkParameterIsNotNull(arrayList, "<set-?>");
            this.tags = arrayList;
        }

        @NotNull
        public final ArrayList<String> getStyleTags() {
            return this.styleTags;
        }

        public final void setStyleTags(@NotNull ArrayList<String> arrayList) {
            Intrinsics.checkParameterIsNotNull(arrayList, "<set-?>");
            this.styleTags = arrayList;
        }

        @NotNull
        public final String getAboutSize() {
            return this.aboutSize;
        }

        public final void setAboutSize(@NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "<set-?>");
            this.aboutSize = str;
        }

        @NotNull
        public final String getShop() {
            return this.shop;
        }

        public final void setShop(@NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "<set-?>");
            this.shop = str;
        }

        @NotNull
        public final String getShopName() {
            return this.shopName;
        }

        public final void setShopName(@NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "<set-?>");
            this.shopName = str;
        }

        @NotNull
        public final String getPrice() {
            return this.price;
        }

        public final void setPrice(@NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "<set-?>");
            this.price = str;
        }

        @NotNull
        public final String getShopImage() {
            return this.shopImage;
        }

        public final void setShopImage(@NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "<set-?>");
            this.shopImage = str;
        }

        @NotNull
        public final PostType getPostType() {
            return this.postType;
        }

        public final void setPostType(@NotNull PostType postType2) {
            Intrinsics.checkParameterIsNotNull(postType2, "<set-?>");
            this.postType = postType2;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("{title: ");
            sb.append(this.title);
            sb.append(", aboutFit: ");
            sb.append(this.aboutFit);
            sb.append(", aboutProduct: ");
            sb.append(this.aboutProduct);
            sb.append(", coverID: ");
            sb.append(this.coverID);
            sb.append(", coverImagePath: ");
            sb.append(this.coverImagePath);
            sb.append(", freeformImagesPath: ");
            sb.append(this.freeformImagesPath);
            sb.append(", freeformImageIDs: ");
            sb.append(this.freeformImageIDs);
            sb.append(", ...}");
            return sb.toString();
        }
    }

    @Validated(factory = ValidatorFactoryImpl.class)
    public static final class FeedInfoResponse {
        @SerializedName("popular_feed_version")
        @NotNull
        private final String popularFeedVersion;

        @NotNull
        public static /* synthetic */ FeedInfoResponse copy$default(FeedInfoResponse feedInfoResponse, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = feedInfoResponse.popularFeedVersion;
            }
            return feedInfoResponse.copy(str);
        }

        @NotNull
        public final String component1() {
            return this.popularFeedVersion;
        }

        @NotNull
        public final FeedInfoResponse copy(@NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "popularFeedVersion");
            return new FeedInfoResponse(str);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x0010, code lost:
            if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1.popularFeedVersion, (java.lang.Object) ((kr.co.popone.fitts.model.post.PostAPI.FeedInfoResponse) r2).popularFeedVersion) != false) goto L_0x0015;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r2) {
            /*
                r1 = this;
                if (r1 == r2) goto L_0x0015
                boolean r0 = r2 instanceof kr.co.popone.fitts.model.post.PostAPI.FeedInfoResponse
                if (r0 == 0) goto L_0x0013
                kr.co.popone.fitts.model.post.PostAPI$FeedInfoResponse r2 = (kr.co.popone.fitts.model.post.PostAPI.FeedInfoResponse) r2
                java.lang.String r0 = r1.popularFeedVersion
                java.lang.String r2 = r2.popularFeedVersion
                boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r2)
                if (r2 == 0) goto L_0x0013
                goto L_0x0015
            L_0x0013:
                r2 = 0
                return r2
            L_0x0015:
                r2 = 1
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.post.PostAPI.FeedInfoResponse.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            String str = this.popularFeedVersion;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("FeedInfoResponse(popularFeedVersion=");
            sb.append(this.popularFeedVersion);
            sb.append(")");
            return sb.toString();
        }

        public FeedInfoResponse(@NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "popularFeedVersion");
            this.popularFeedVersion = str;
        }

        @NotNull
        @NonNull
        public final String getPopularFeedVersion() {
            return this.popularFeedVersion;
        }
    }

    @Validated(factory = ValidatorFactoryImpl.class)
    public static final class LinkInfo {
        @SerializedName("link_url")
        @NotNull
        private final String linkUrl;
        @Nullable
        private final Product product;
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
                boolean r0 = r3 instanceof kr.co.popone.fitts.model.post.PostAPI.LinkInfo
                if (r0 == 0) goto L_0x0027
                kr.co.popone.fitts.model.post.PostAPI$LinkInfo r3 = (kr.co.popone.fitts.model.post.PostAPI.LinkInfo) r3
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
            throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.post.PostAPI.LinkInfo.equals(java.lang.Object):boolean");
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

    @Validated(factory = ValidatorFactoryImpl.class)
    public static final class Post {
        @SerializedName("about_fit")
        @NotNull
        private final String aboutFit;
        @SerializedName("about_product")
        @Nullable
        private final String aboutProduct;
        @SerializedName("about_size")
        @Nullable
        private final String aboutSize;
        @Nullable
        private Banner banner;
        @SerializedName("categories")
        @NotNull
        private final List<Category> categories;
        @SerializedName("closeshot_images")
        @Nullable
        private final List<Image> closeshotImages;
        @SerializedName("comments_count")
        private int commentsCount;
        @SerializedName("cover_image")
        @Nullable
        private final Image coverImage;
        @SerializedName("created_at")
        @NotNull
        private final String createdAt;
        @SerializedName("detail_images")
        @Nullable
        private final List<Image> detailImages;
        @SerializedName("freeform_images")
        @Nullable
        private final List<Image> freeformImages;
        @SerializedName("fullshot_images")
        @Nullable
        private final List<Image> fullshotImages;
        private final long id;
        @SerializedName("inactive_reason")
        @Nullable
        private final String inactiveReason;
        @SerializedName("is_liked")
        private boolean isLiked;
        @SerializedName("likes_count")
        private int likesCount;
        @SerializedName("order_line_item_variant")
        @Nullable
        private final OrderListLineItemVariant lineItemVariant;
        @SerializedName("link_info")
        @Nullable
        private LinkInfo linkInfo;
        @SerializedName("quoted_comments")
        @Nullable
        private final List<Comment> quotedComments;
        private final float stars;
        @Nullable
        private final String state;
        @Nullable
        private final List<Style> styles;
        @Nullable
        private final List<Tag> tags;
        @NotNull
        private final String title;
        @NotNull
        private final User user;
        @SerializedName("views")
        private final int viewCount;

        @NotNull
        public static /* synthetic */ Post copy$default(Post post, long j, String str, String str2, String str3, User user2, String str4, String str5, String str6, Image image, List list, List list2, List list3, List list4, float f, LinkInfo linkInfo2, String str7, int i, boolean z, int i2, List list5, List list6, List list7, int i3, OrderListLineItemVariant orderListLineItemVariant, List list8, int i4, Object obj) {
            Post post2 = post;
            int i5 = i4;
            return post.copy((i5 & 1) != 0 ? post2.id : j, (i5 & 2) != 0 ? post2.state : str, (i5 & 4) != 0 ? post2.inactiveReason : str2, (i5 & 8) != 0 ? post2.title : str3, (i5 & 16) != 0 ? post2.user : user2, (i5 & 32) != 0 ? post2.aboutFit : str4, (i5 & 64) != 0 ? post2.aboutProduct : str5, (i5 & 128) != 0 ? post2.aboutSize : str6, (i5 & 256) != 0 ? post2.coverImage : image, (i5 & 512) != 0 ? post2.freeformImages : list, (i5 & 1024) != 0 ? post2.closeshotImages : list2, (i5 & 2048) != 0 ? post2.fullshotImages : list3, (i5 & 4096) != 0 ? post2.detailImages : list4, (i5 & 8192) != 0 ? post2.stars : f, (i5 & 16384) != 0 ? post2.linkInfo : linkInfo2, (i5 & 32768) != 0 ? post2.createdAt : str7, (i5 & 65536) != 0 ? post2.likesCount : i, (i5 & 131072) != 0 ? post2.isLiked : z, (i5 & 262144) != 0 ? post2.commentsCount : i2, (i5 & 524288) != 0 ? post2.quotedComments : list5, (i5 & 1048576) != 0 ? post2.tags : list6, (i5 & 2097152) != 0 ? post2.styles : list7, (i5 & 4194304) != 0 ? post2.viewCount : i3, (i5 & 8388608) != 0 ? post2.lineItemVariant : orderListLineItemVariant, (i5 & 16777216) != 0 ? post2.categories : list8);
        }

        public final long component1() {
            return this.id;
        }

        @Nullable
        public final List<Image> component10() {
            return this.freeformImages;
        }

        @Nullable
        public final List<Image> component11() {
            return this.closeshotImages;
        }

        @Nullable
        public final List<Image> component12() {
            return this.fullshotImages;
        }

        @Nullable
        public final List<Image> component13() {
            return this.detailImages;
        }

        public final float component14() {
            return this.stars;
        }

        @Nullable
        public final LinkInfo component15() {
            return this.linkInfo;
        }

        @NotNull
        public final String component16() {
            return this.createdAt;
        }

        public final int component17() {
            return this.likesCount;
        }

        public final boolean component18() {
            return this.isLiked;
        }

        public final int component19() {
            return this.commentsCount;
        }

        @Nullable
        public final String component2() {
            return this.state;
        }

        @Nullable
        public final List<Comment> component20() {
            return this.quotedComments;
        }

        @Nullable
        public final List<Tag> component21() {
            return this.tags;
        }

        @Nullable
        public final List<Style> component22() {
            return this.styles;
        }

        public final int component23() {
            return this.viewCount;
        }

        @Nullable
        public final OrderListLineItemVariant component24() {
            return this.lineItemVariant;
        }

        @NotNull
        public final List<Category> component25() {
            return this.categories;
        }

        @Nullable
        public final String component3() {
            return this.inactiveReason;
        }

        @NotNull
        public final String component4() {
            return this.title;
        }

        @NotNull
        public final User component5() {
            return this.user;
        }

        @NotNull
        public final String component6() {
            return this.aboutFit;
        }

        @Nullable
        public final String component7() {
            return this.aboutProduct;
        }

        @Nullable
        public final String component8() {
            return this.aboutSize;
        }

        @Nullable
        public final Image component9() {
            return this.coverImage;
        }

        @NotNull
        public final Post copy(long j, @Nullable String str, @Nullable String str2, @NotNull String str3, @NotNull User user2, @NotNull String str4, @Nullable String str5, @Nullable String str6, @Nullable Image image, @Nullable List<Image> list, @Nullable List<Image> list2, @Nullable List<Image> list3, @Nullable List<Image> list4, float f, @Nullable LinkInfo linkInfo2, @NotNull String str7, int i, boolean z, int i2, @Nullable List<Comment> list5, @Nullable List<Tag> list6, @Nullable List<Style> list7, int i3, @Nullable OrderListLineItemVariant orderListLineItemVariant, @NotNull List<Category> list8) {
            long j2 = j;
            String str8 = str;
            String str9 = str2;
            String str10 = str3;
            User user3 = user2;
            String str11 = str4;
            String str12 = str5;
            String str13 = str6;
            Image image2 = image;
            List<Image> list9 = list;
            List<Image> list10 = list2;
            List<Image> list11 = list3;
            List<Image> list12 = list4;
            float f2 = f;
            LinkInfo linkInfo3 = linkInfo2;
            String str14 = str7;
            int i4 = i;
            boolean z2 = z;
            int i5 = i2;
            List<Comment> list13 = list5;
            List<Tag> list14 = list6;
            List<Style> list15 = list7;
            int i6 = i3;
            OrderListLineItemVariant orderListLineItemVariant2 = orderListLineItemVariant;
            List<Category> list16 = list8;
            Intrinsics.checkParameterIsNotNull(str3, "title");
            Intrinsics.checkParameterIsNotNull(user2, "user");
            Intrinsics.checkParameterIsNotNull(str4, "aboutFit");
            Intrinsics.checkParameterIsNotNull(str7, "createdAt");
            Intrinsics.checkParameterIsNotNull(list8, "categories");
            Post post = new Post(j, str8, str9, str10, user3, str11, str12, str13, image2, list9, list10, list11, list12, f2, linkInfo3, str14, i4, z2, i5, list13, list14, list15, i6, orderListLineItemVariant2, list16);
            return post;
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                if (obj instanceof Post) {
                    Post post = (Post) obj;
                    if ((this.id == post.id) && Intrinsics.areEqual((Object) this.state, (Object) post.state) && Intrinsics.areEqual((Object) this.inactiveReason, (Object) post.inactiveReason) && Intrinsics.areEqual((Object) this.title, (Object) post.title) && Intrinsics.areEqual((Object) this.user, (Object) post.user) && Intrinsics.areEqual((Object) this.aboutFit, (Object) post.aboutFit) && Intrinsics.areEqual((Object) this.aboutProduct, (Object) post.aboutProduct) && Intrinsics.areEqual((Object) this.aboutSize, (Object) post.aboutSize) && Intrinsics.areEqual((Object) this.coverImage, (Object) post.coverImage) && Intrinsics.areEqual((Object) this.freeformImages, (Object) post.freeformImages) && Intrinsics.areEqual((Object) this.closeshotImages, (Object) post.closeshotImages) && Intrinsics.areEqual((Object) this.fullshotImages, (Object) post.fullshotImages) && Intrinsics.areEqual((Object) this.detailImages, (Object) post.detailImages) && Float.compare(this.stars, post.stars) == 0 && Intrinsics.areEqual((Object) this.linkInfo, (Object) post.linkInfo) && Intrinsics.areEqual((Object) this.createdAt, (Object) post.createdAt)) {
                        if (this.likesCount == post.likesCount) {
                            if (this.isLiked == post.isLiked) {
                                if ((this.commentsCount == post.commentsCount) && Intrinsics.areEqual((Object) this.quotedComments, (Object) post.quotedComments) && Intrinsics.areEqual((Object) this.tags, (Object) post.tags) && Intrinsics.areEqual((Object) this.styles, (Object) post.styles)) {
                                    if (!(this.viewCount == post.viewCount) || !Intrinsics.areEqual((Object) this.lineItemVariant, (Object) post.lineItemVariant) || !Intrinsics.areEqual((Object) this.categories, (Object) post.categories)) {
                                        return false;
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
            String str = this.state;
            int i2 = 0;
            int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.inactiveReason;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.title;
            int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            User user2 = this.user;
            int hashCode4 = (hashCode3 + (user2 != null ? user2.hashCode() : 0)) * 31;
            String str4 = this.aboutFit;
            int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
            String str5 = this.aboutProduct;
            int hashCode6 = (hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31;
            String str6 = this.aboutSize;
            int hashCode7 = (hashCode6 + (str6 != null ? str6.hashCode() : 0)) * 31;
            Image image = this.coverImage;
            int hashCode8 = (hashCode7 + (image != null ? image.hashCode() : 0)) * 31;
            List<Image> list = this.freeformImages;
            int hashCode9 = (hashCode8 + (list != null ? list.hashCode() : 0)) * 31;
            List<Image> list2 = this.closeshotImages;
            int hashCode10 = (hashCode9 + (list2 != null ? list2.hashCode() : 0)) * 31;
            List<Image> list3 = this.fullshotImages;
            int hashCode11 = (hashCode10 + (list3 != null ? list3.hashCode() : 0)) * 31;
            List<Image> list4 = this.detailImages;
            int hashCode12 = (((hashCode11 + (list4 != null ? list4.hashCode() : 0)) * 31) + Float.floatToIntBits(this.stars)) * 31;
            LinkInfo linkInfo2 = this.linkInfo;
            int hashCode13 = (hashCode12 + (linkInfo2 != null ? linkInfo2.hashCode() : 0)) * 31;
            String str7 = this.createdAt;
            int hashCode14 = (((hashCode13 + (str7 != null ? str7.hashCode() : 0)) * 31) + this.likesCount) * 31;
            boolean z = this.isLiked;
            if (z) {
                z = true;
            }
            int i3 = (((hashCode14 + (z ? 1 : 0)) * 31) + this.commentsCount) * 31;
            List<Comment> list5 = this.quotedComments;
            int hashCode15 = (i3 + (list5 != null ? list5.hashCode() : 0)) * 31;
            List<Tag> list6 = this.tags;
            int hashCode16 = (hashCode15 + (list6 != null ? list6.hashCode() : 0)) * 31;
            List<Style> list7 = this.styles;
            int hashCode17 = (((hashCode16 + (list7 != null ? list7.hashCode() : 0)) * 31) + this.viewCount) * 31;
            OrderListLineItemVariant orderListLineItemVariant = this.lineItemVariant;
            int hashCode18 = (hashCode17 + (orderListLineItemVariant != null ? orderListLineItemVariant.hashCode() : 0)) * 31;
            List<Category> list8 = this.categories;
            if (list8 != null) {
                i2 = list8.hashCode();
            }
            return hashCode18 + i2;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Post(id=");
            sb.append(this.id);
            sb.append(", state=");
            sb.append(this.state);
            sb.append(", inactiveReason=");
            sb.append(this.inactiveReason);
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
            sb.append(", freeformImages=");
            sb.append(this.freeformImages);
            sb.append(", closeshotImages=");
            sb.append(this.closeshotImages);
            sb.append(", fullshotImages=");
            sb.append(this.fullshotImages);
            sb.append(", detailImages=");
            sb.append(this.detailImages);
            sb.append(", stars=");
            sb.append(this.stars);
            sb.append(", linkInfo=");
            sb.append(this.linkInfo);
            sb.append(", createdAt=");
            sb.append(this.createdAt);
            sb.append(", likesCount=");
            sb.append(this.likesCount);
            sb.append(", isLiked=");
            sb.append(this.isLiked);
            sb.append(", commentsCount=");
            sb.append(this.commentsCount);
            sb.append(", quotedComments=");
            sb.append(this.quotedComments);
            sb.append(", tags=");
            sb.append(this.tags);
            sb.append(", styles=");
            sb.append(this.styles);
            sb.append(", viewCount=");
            sb.append(this.viewCount);
            sb.append(", lineItemVariant=");
            sb.append(this.lineItemVariant);
            sb.append(", categories=");
            sb.append(this.categories);
            sb.append(")");
            return sb.toString();
        }

        public Post(long j, @Nullable String str, @Nullable String str2, @NotNull String str3, @NotNull User user2, @NotNull String str4, @Nullable String str5, @Nullable String str6, @Nullable Image image, @Nullable List<Image> list, @Nullable List<Image> list2, @Nullable List<Image> list3, @Nullable List<Image> list4, float f, @Nullable LinkInfo linkInfo2, @NotNull String str7, int i, boolean z, int i2, @Nullable List<Comment> list5, @Nullable List<Tag> list6, @Nullable List<Style> list7, int i3, @Nullable OrderListLineItemVariant orderListLineItemVariant, @NotNull List<Category> list8) {
            String str8 = str3;
            User user3 = user2;
            String str9 = str4;
            String str10 = str7;
            List<Category> list9 = list8;
            Intrinsics.checkParameterIsNotNull(str3, "title");
            Intrinsics.checkParameterIsNotNull(user2, "user");
            Intrinsics.checkParameterIsNotNull(str4, "aboutFit");
            Intrinsics.checkParameterIsNotNull(str10, "createdAt");
            Intrinsics.checkParameterIsNotNull(list9, "categories");
            this.id = j;
            this.state = str;
            this.inactiveReason = str2;
            this.title = str8;
            this.user = user3;
            this.aboutFit = str9;
            this.aboutProduct = str5;
            this.aboutSize = str6;
            this.coverImage = image;
            this.freeformImages = list;
            this.closeshotImages = list2;
            this.fullshotImages = list3;
            this.detailImages = list4;
            this.stars = f;
            this.linkInfo = linkInfo2;
            this.createdAt = str10;
            this.likesCount = i;
            this.isLiked = z;
            this.commentsCount = i2;
            this.quotedComments = list5;
            this.tags = list6;
            this.styles = list7;
            this.viewCount = i3;
            this.lineItemVariant = orderListLineItemVariant;
            this.categories = list9;
        }

        @NonNull
        public final long getId() {
            return this.id;
        }

        @Nullable
        public final String getState() {
            return this.state;
        }

        @Nullable
        public final String getInactiveReason() {
            return this.inactiveReason;
        }

        @NotNull
        @NonNull
        public final String getTitle() {
            return this.title;
        }

        @NotNull
        public final User getUser() {
            return this.user;
        }

        @NotNull
        @NonNull
        public final String getAboutFit() {
            return this.aboutFit;
        }

        @Nullable
        public final String getAboutProduct() {
            return this.aboutProduct;
        }

        @Nullable
        public final String getAboutSize() {
            return this.aboutSize;
        }

        @Nullable
        public final Image getCoverImage() {
            return this.coverImage;
        }

        @Nullable
        public final List<Image> getFreeformImages() {
            return this.freeformImages;
        }

        @Nullable
        public final List<Image> getCloseshotImages() {
            return this.closeshotImages;
        }

        @Nullable
        public final List<Image> getFullshotImages() {
            return this.fullshotImages;
        }

        @Nullable
        public final List<Image> getDetailImages() {
            return this.detailImages;
        }

        @NonNull
        public final float getStars() {
            return this.stars;
        }

        @Nullable
        public final LinkInfo getLinkInfo() {
            return this.linkInfo;
        }

        public final void setLinkInfo(@Nullable LinkInfo linkInfo2) {
            this.linkInfo = linkInfo2;
        }

        @NotNull
        @NonNull
        public final String getCreatedAt() {
            return this.createdAt;
        }

        public final int getLikesCount() {
            return this.likesCount;
        }

        public final void setLikesCount(int i) {
            this.likesCount = i;
        }

        public final boolean isLiked() {
            return this.isLiked;
        }

        public final void setLiked(boolean z) {
            this.isLiked = z;
        }

        public final int getCommentsCount() {
            return this.commentsCount;
        }

        public final void setCommentsCount(int i) {
            this.commentsCount = i;
        }

        @Nullable
        public final List<Comment> getQuotedComments() {
            return this.quotedComments;
        }

        @Nullable
        public final List<Tag> getTags() {
            return this.tags;
        }

        public /* synthetic */ Post(long j, String str, String str2, String str3, User user2, String str4, String str5, String str6, Image image, List list, List list2, List list3, List list4, float f, LinkInfo linkInfo2, String str7, int i, boolean z, int i2, List list5, List list6, List list7, int i3, OrderListLineItemVariant orderListLineItemVariant, List list8, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, str, str2, str3, user2, str4, str5, str6, image, list, list2, list3, list4, f, linkInfo2, str7, i, z, i2, list5, list6, (i4 & 2097152) != 0 ? null : list7, i3, orderListLineItemVariant, list8);
        }

        @Nullable
        public final List<Style> getStyles() {
            return this.styles;
        }

        public final int getViewCount() {
            return this.viewCount;
        }

        @Nullable
        public final OrderListLineItemVariant getLineItemVariant() {
            return this.lineItemVariant;
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

        @NotNull
        public final PostType postType() {
            String categoryGroup = categoryGroup();
            if (categoryGroup != null) {
                int hashCode = categoryGroup.hashCode();
                if (hashCode != 1413161) {
                    if (hashCode == 1594684 && categoryGroup.equals("신발")) {
                        return PostType.SHOES;
                    }
                } else if (categoryGroup.equals("가방")) {
                    return PostType.BAG;
                }
            }
            return PostType.CLOTHES;
        }

        @Nullable
        public final Banner getBanner() {
            return this.banner;
        }

        public final void setBanner(@Nullable Banner banner2) {
            this.banner = banner2;
        }
    }

    @Validated(factory = ValidatorFactoryImpl.class)
    public static final class PostContent {
        @Nullable
        private String description;
        private int id;

        @NotNull
        public static /* synthetic */ PostContent copy$default(PostContent postContent, int i, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = postContent.id;
            }
            if ((i2 & 2) != 0) {
                str = postContent.description;
            }
            return postContent.copy(i, str);
        }

        public final int component1() {
            return this.id;
        }

        @Nullable
        public final String component2() {
            return this.description;
        }

        @NotNull
        public final PostContent copy(int i, @Nullable String str) {
            return new PostContent(i, str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                if (obj instanceof PostContent) {
                    PostContent postContent = (PostContent) obj;
                    if (!(this.id == postContent.id) || !Intrinsics.areEqual((Object) this.description, (Object) postContent.description)) {
                        return false;
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i = this.id * 31;
            String str = this.description;
            return i + (str != null ? str.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("PostContent(id=");
            sb.append(this.id);
            sb.append(", description=");
            sb.append(this.description);
            sb.append(")");
            return sb.toString();
        }

        public PostContent(int i, @Nullable String str) {
            this.id = i;
            this.description = str;
        }

        @Nullable
        public final String getDescription() {
            return this.description;
        }

        public final int getId() {
            return this.id;
        }

        public final void setDescription(@Nullable String str) {
            this.description = str;
        }

        public final void setId(int i) {
            this.id = i;
        }
    }

    @Validated(factory = ValidatorFactoryImpl.class)
    public static final class PostId {
        private final int id;

        @NotNull
        public static /* synthetic */ PostId copy$default(PostId postId, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = postId.id;
            }
            return postId.copy(i);
        }

        public final int component1() {
            return this.id;
        }

        @NotNull
        public final PostId copy(int i) {
            return new PostId(i);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                if (obj instanceof PostId) {
                    if (this.id == ((PostId) obj).id) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            return this.id;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("PostId(id=");
            sb.append(this.id);
            sb.append(")");
            return sb.toString();
        }

        public PostId(int i) {
            this.id = i;
        }

        public final int getId() {
            return this.id;
        }
    }

    @Validated(factory = ValidatorFactoryImpl.class)
    public static final class PostInvoice {
        @NotNull
        private final String action;
        @SerializedName("deactivated_at")
        @NotNull
        private final Date deactivatedAt;
        @Nullable
        private final String description;
        private final long id;
        @SerializedName("inactived_at")
        @NotNull
        private final Date inactivatedAt;
        @NotNull
        private final Post post;
        @NotNull
        private final User user;

        @NotNull
        public static /* synthetic */ PostInvoice copy$default(PostInvoice postInvoice, long j, User user2, Post post2, String str, String str2, Date date, Date date2, int i, Object obj) {
            PostInvoice postInvoice2 = postInvoice;
            return postInvoice.copy((i & 1) != 0 ? postInvoice2.id : j, (i & 2) != 0 ? postInvoice2.user : user2, (i & 4) != 0 ? postInvoice2.post : post2, (i & 8) != 0 ? postInvoice2.description : str, (i & 16) != 0 ? postInvoice2.action : str2, (i & 32) != 0 ? postInvoice2.inactivatedAt : date, (i & 64) != 0 ? postInvoice2.deactivatedAt : date2);
        }

        public final long component1() {
            return this.id;
        }

        @NotNull
        public final User component2() {
            return this.user;
        }

        @NotNull
        public final Post component3() {
            return this.post;
        }

        @Nullable
        public final String component4() {
            return this.description;
        }

        @NotNull
        public final String component5() {
            return this.action;
        }

        @NotNull
        public final Date component6() {
            return this.inactivatedAt;
        }

        @NotNull
        public final Date component7() {
            return this.deactivatedAt;
        }

        @NotNull
        public final PostInvoice copy(long j, @NotNull User user2, @NotNull Post post2, @Nullable String str, @NotNull String str2, @NotNull Date date, @NotNull Date date2) {
            User user3 = user2;
            Intrinsics.checkParameterIsNotNull(user2, "user");
            Post post3 = post2;
            Intrinsics.checkParameterIsNotNull(post2, "post");
            String str3 = str2;
            Intrinsics.checkParameterIsNotNull(str3, NativeProtocol.WEB_DIALOG_ACTION);
            Date date3 = date;
            Intrinsics.checkParameterIsNotNull(date3, "inactivatedAt");
            Date date4 = date2;
            Intrinsics.checkParameterIsNotNull(date4, "deactivatedAt");
            PostInvoice postInvoice = new PostInvoice(j, user3, post3, str, str3, date3, date4);
            return postInvoice;
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                if (obj instanceof PostInvoice) {
                    PostInvoice postInvoice = (PostInvoice) obj;
                    if (!(this.id == postInvoice.id) || !Intrinsics.areEqual((Object) this.user, (Object) postInvoice.user) || !Intrinsics.areEqual((Object) this.post, (Object) postInvoice.post) || !Intrinsics.areEqual((Object) this.description, (Object) postInvoice.description) || !Intrinsics.areEqual((Object) this.action, (Object) postInvoice.action) || !Intrinsics.areEqual((Object) this.inactivatedAt, (Object) postInvoice.inactivatedAt) || !Intrinsics.areEqual((Object) this.deactivatedAt, (Object) postInvoice.deactivatedAt)) {
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
            Post post2 = this.post;
            int hashCode2 = (hashCode + (post2 != null ? post2.hashCode() : 0)) * 31;
            String str = this.description;
            int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.action;
            int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
            Date date = this.inactivatedAt;
            int hashCode5 = (hashCode4 + (date != null ? date.hashCode() : 0)) * 31;
            Date date2 = this.deactivatedAt;
            if (date2 != null) {
                i2 = date2.hashCode();
            }
            return hashCode5 + i2;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("PostInvoice(id=");
            sb.append(this.id);
            sb.append(", user=");
            sb.append(this.user);
            sb.append(", post=");
            sb.append(this.post);
            sb.append(", description=");
            sb.append(this.description);
            sb.append(", action=");
            sb.append(this.action);
            sb.append(", inactivatedAt=");
            sb.append(this.inactivatedAt);
            sb.append(", deactivatedAt=");
            sb.append(this.deactivatedAt);
            sb.append(")");
            return sb.toString();
        }

        public PostInvoice(long j, @NotNull User user2, @NotNull Post post2, @Nullable String str, @NotNull String str2, @NotNull Date date, @NotNull Date date2) {
            Intrinsics.checkParameterIsNotNull(user2, "user");
            Intrinsics.checkParameterIsNotNull(post2, "post");
            Intrinsics.checkParameterIsNotNull(str2, NativeProtocol.WEB_DIALOG_ACTION);
            Intrinsics.checkParameterIsNotNull(date, "inactivatedAt");
            Intrinsics.checkParameterIsNotNull(date2, "deactivatedAt");
            this.id = j;
            this.user = user2;
            this.post = post2;
            this.description = str;
            this.action = str2;
            this.inactivatedAt = date;
            this.deactivatedAt = date2;
        }

        public final long getId() {
            return this.id;
        }

        @NotNull
        @NonNull
        public final User getUser() {
            return this.user;
        }

        @NotNull
        @NonNull
        public final Post getPost() {
            return this.post;
        }

        @Nullable
        public final String getDescription() {
            return this.description;
        }

        @NotNull
        @NonNull
        public final String getAction() {
            return this.action;
        }

        @NotNull
        public final Date getInactivatedAt() {
            return this.inactivatedAt;
        }

        @NotNull
        public final Date getDeactivatedAt() {
            return this.deactivatedAt;
        }
    }

    public static final class PostProductInfoResponse {
        @SerializedName("title_image")
        @NotNull
        private final ProductImageInfo image;
        @SerializedName("title_scheme")
        @Nullable
        private final String imageScheme;
        @SerializedName("link_info")
        @NotNull
        private final LinkInfo linkInfo;

        @NotNull
        public static /* synthetic */ PostProductInfoResponse copy$default(PostProductInfoResponse postProductInfoResponse, ProductImageInfo productImageInfo, String str, LinkInfo linkInfo2, int i, Object obj) {
            if ((i & 1) != 0) {
                productImageInfo = postProductInfoResponse.image;
            }
            if ((i & 2) != 0) {
                str = postProductInfoResponse.imageScheme;
            }
            if ((i & 4) != 0) {
                linkInfo2 = postProductInfoResponse.linkInfo;
            }
            return postProductInfoResponse.copy(productImageInfo, str, linkInfo2);
        }

        @NotNull
        public final ProductImageInfo component1() {
            return this.image;
        }

        @Nullable
        public final String component2() {
            return this.imageScheme;
        }

        @NotNull
        public final LinkInfo component3() {
            return this.linkInfo;
        }

        @NotNull
        public final PostProductInfoResponse copy(@NotNull ProductImageInfo productImageInfo, @Nullable String str, @NotNull LinkInfo linkInfo2) {
            Intrinsics.checkParameterIsNotNull(productImageInfo, MessengerShareContentUtility.MEDIA_IMAGE);
            Intrinsics.checkParameterIsNotNull(linkInfo2, "linkInfo");
            return new PostProductInfoResponse(productImageInfo, str, linkInfo2);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0024, code lost:
            if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2.linkInfo, (java.lang.Object) r3.linkInfo) != false) goto L_0x0029;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r3) {
            /*
                r2 = this;
                if (r2 == r3) goto L_0x0029
                boolean r0 = r3 instanceof kr.co.popone.fitts.model.post.PostAPI.PostProductInfoResponse
                if (r0 == 0) goto L_0x0027
                kr.co.popone.fitts.model.post.PostAPI$PostProductInfoResponse r3 = (kr.co.popone.fitts.model.post.PostAPI.PostProductInfoResponse) r3
                kr.co.popone.fitts.model.store.ProductImageInfo r0 = r2.image
                kr.co.popone.fitts.model.store.ProductImageInfo r1 = r3.image
                boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
                if (r0 == 0) goto L_0x0027
                java.lang.String r0 = r2.imageScheme
                java.lang.String r1 = r3.imageScheme
                boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
                if (r0 == 0) goto L_0x0027
                kr.co.popone.fitts.model.post.PostAPI$LinkInfo r0 = r2.linkInfo
                kr.co.popone.fitts.model.post.PostAPI$LinkInfo r3 = r3.linkInfo
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
            throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.post.PostAPI.PostProductInfoResponse.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            ProductImageInfo productImageInfo = this.image;
            int i = 0;
            int hashCode = (productImageInfo != null ? productImageInfo.hashCode() : 0) * 31;
            String str = this.imageScheme;
            int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
            LinkInfo linkInfo2 = this.linkInfo;
            if (linkInfo2 != null) {
                i = linkInfo2.hashCode();
            }
            return hashCode2 + i;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("PostProductInfoResponse(image=");
            sb.append(this.image);
            sb.append(", imageScheme=");
            sb.append(this.imageScheme);
            sb.append(", linkInfo=");
            sb.append(this.linkInfo);
            sb.append(")");
            return sb.toString();
        }

        public PostProductInfoResponse(@NotNull ProductImageInfo productImageInfo, @Nullable String str, @NotNull LinkInfo linkInfo2) {
            Intrinsics.checkParameterIsNotNull(productImageInfo, MessengerShareContentUtility.MEDIA_IMAGE);
            Intrinsics.checkParameterIsNotNull(linkInfo2, "linkInfo");
            this.image = productImageInfo;
            this.imageScheme = str;
            this.linkInfo = linkInfo2;
        }

        @NotNull
        public final ProductImageInfo getImage() {
            return this.image;
        }

        @Nullable
        public final String getImageScheme() {
            return this.imageScheme;
        }

        @NotNull
        public final LinkInfo getLinkInfo() {
            return this.linkInfo;
        }
    }

    @Validated(factory = ValidatorFactoryImpl.class)
    public static final class RelatedPost {
        @SerializedName("test_flag")
        @Nullable
        private final String followersNewPost;
        @SerializedName("posts")
        @NotNull
        private final List<Post> posts;

        /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<kr.co.popone.fitts.model.post.PostAPI$Post>, for r2v0, types: [java.util.List] */
        @org.jetbrains.annotations.NotNull
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static /* synthetic */ kr.co.popone.fitts.model.post.PostAPI.RelatedPost copy$default(kr.co.popone.fitts.model.post.PostAPI.RelatedPost r0, java.lang.String r1, java.util.List<kr.co.popone.fitts.model.post.PostAPI.Post> r2, int r3, java.lang.Object r4) {
            /*
                r4 = r3 & 1
                if (r4 == 0) goto L_0x0006
                java.lang.String r1 = r0.followersNewPost
            L_0x0006:
                r3 = r3 & 2
                if (r3 == 0) goto L_0x000c
                java.util.List<kr.co.popone.fitts.model.post.PostAPI$Post> r2 = r0.posts
            L_0x000c:
                kr.co.popone.fitts.model.post.PostAPI$RelatedPost r0 = r0.copy(r1, r2)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.post.PostAPI.RelatedPost.copy$default(kr.co.popone.fitts.model.post.PostAPI$RelatedPost, java.lang.String, java.util.List, int, java.lang.Object):kr.co.popone.fitts.model.post.PostAPI$RelatedPost");
        }

        @Nullable
        public final String component1() {
            return this.followersNewPost;
        }

        @NotNull
        public final List<Post> component2() {
            return this.posts;
        }

        @NotNull
        public final RelatedPost copy(@Nullable String str, @NotNull List<Post> list) {
            Intrinsics.checkParameterIsNotNull(list, "posts");
            return new RelatedPost(str, list);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x001a, code lost:
            if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2.posts, (java.lang.Object) r3.posts) != false) goto L_0x001f;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r3) {
            /*
                r2 = this;
                if (r2 == r3) goto L_0x001f
                boolean r0 = r3 instanceof kr.co.popone.fitts.model.post.PostAPI.RelatedPost
                if (r0 == 0) goto L_0x001d
                kr.co.popone.fitts.model.post.PostAPI$RelatedPost r3 = (kr.co.popone.fitts.model.post.PostAPI.RelatedPost) r3
                java.lang.String r0 = r2.followersNewPost
                java.lang.String r1 = r3.followersNewPost
                boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
                if (r0 == 0) goto L_0x001d
                java.util.List<kr.co.popone.fitts.model.post.PostAPI$Post> r0 = r2.posts
                java.util.List<kr.co.popone.fitts.model.post.PostAPI$Post> r3 = r3.posts
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
            throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.post.PostAPI.RelatedPost.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            String str = this.followersNewPost;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            List<Post> list = this.posts;
            if (list != null) {
                i = list.hashCode();
            }
            return hashCode + i;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("RelatedPost(followersNewPost=");
            sb.append(this.followersNewPost);
            sb.append(", posts=");
            sb.append(this.posts);
            sb.append(")");
            return sb.toString();
        }

        public RelatedPost(@Nullable String str, @NotNull List<Post> list) {
            Intrinsics.checkParameterIsNotNull(list, "posts");
            this.followersNewPost = str;
            this.posts = list;
        }

        @Nullable
        public final String getFollowersNewPost() {
            return this.followersNewPost;
        }

        @NotNull
        public final List<Post> getPosts() {
            return this.posts;
        }
    }

    @Validated(factory = ValidatorFactoryImpl.class)
    public static final class ResponseImageId {
        private int id;

        @NotNull
        public static /* synthetic */ ResponseImageId copy$default(ResponseImageId responseImageId, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = responseImageId.id;
            }
            return responseImageId.copy(i);
        }

        public final int component1() {
            return this.id;
        }

        @NotNull
        public final ResponseImageId copy(int i) {
            return new ResponseImageId(i);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                if (obj instanceof ResponseImageId) {
                    if (this.id == ((ResponseImageId) obj).id) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            return this.id;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("ResponseImageId(id=");
            sb.append(this.id);
            sb.append(")");
            return sb.toString();
        }

        public ResponseImageId(int i) {
            this.id = i;
        }

        public final int getId() {
            return this.id;
        }

        public final void setId(int i) {
            this.id = i;
        }
    }

    @Validated(factory = ValidatorFactoryImpl.class)
    public static final class Style {
        private final long id;
        @NotNull
        private final String name;

        @NotNull
        public static /* synthetic */ Style copy$default(Style style, long j, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                j = style.id;
            }
            if ((i & 2) != 0) {
                str = style.name;
            }
            return style.copy(j, str);
        }

        public final long component1() {
            return this.id;
        }

        @NotNull
        public final String component2() {
            return this.name;
        }

        @NotNull
        public final Style copy(long j, @NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "name");
            return new Style(j, str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                if (obj instanceof Style) {
                    Style style = (Style) obj;
                    if (!(this.id == style.id) || !Intrinsics.areEqual((Object) this.name, (Object) style.name)) {
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
            sb.append("Style(id=");
            sb.append(this.id);
            sb.append(", name=");
            sb.append(this.name);
            sb.append(")");
            return sb.toString();
        }

        public Style(long j, @NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "name");
            this.id = j;
            this.name = str;
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
    }

    @Validated(factory = ValidatorFactoryImpl.class)
    public static final class Tag {
        private final long id;
        @NotNull
        private final String title;

        @NotNull
        public static /* synthetic */ Tag copy$default(Tag tag, long j, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                j = tag.id;
            }
            if ((i & 2) != 0) {
                str = tag.title;
            }
            return tag.copy(j, str);
        }

        public final long component1() {
            return this.id;
        }

        @NotNull
        public final String component2() {
            return this.title;
        }

        @NotNull
        public final Tag copy(long j, @NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "title");
            return new Tag(j, str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                if (obj instanceof Tag) {
                    Tag tag = (Tag) obj;
                    if (!(this.id == tag.id) || !Intrinsics.areEqual((Object) this.title, (Object) tag.title)) {
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
            return i + (str != null ? str.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Tag(id=");
            sb.append(this.id);
            sb.append(", title=");
            sb.append(this.title);
            sb.append(")");
            return sb.toString();
        }

        public Tag(long j, @NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "title");
            this.id = j;
            this.title = str;
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
    }

    @NotNull
    @DELETE("/api/v9/comments/{comment_id}")
    @Headers({"Accept: application/json"})
    Single<String> deleteComment(@Path("comment_id") long j);

    @NotNull
    @DELETE("/api/v9/posts/{id}/likes")
    @Headers({"Accept: application/json"})
    Single<LikeResult> deleteLikes(@Path("id") long j);

    @Multipart
    @NotNull
    @POST("/api/v9/uploads")
    Observable<ResponseImageId> fileUpload(@NotNull @Part MultipartBody.Part part);

    @NotNull
    @GET("/api/v9/posts/{post_id}/comments")
    @Headers({"Accept: application/json"})
    Single<ArrayList<Comment>> getComments(@Path("post_id") long j, @Nullable @Query("base") Long l, @Query("limit") int i);

    @NotNull
    @GET("/api/v9/posts/{id}")
    @Headers({"Accept: application/json"})
    Single<Post> getPost(@Path("id") long j);

    @NotNull
    @GET("/api/v9/posts")
    @Headers({"Accept: application/json"})
    Single<ArrayList<Post>> getPostList(@NotNull @Query("type") String str, @Nullable @Query("filter") String str2, @Nullable @Query("base") Long l, @Query("limit") int i);

    @NotNull
    @GET("/api/v9/posts/{post_id}/product_bridge")
    @Headers({"Accept: application/json"})
    Single<PostProductInfoResponse> getProductBridgeHeader(@Path("post_id") long j);

    @NotNull
    @GET("/api/v9/posts/{post_id}/recommend_products")
    @Headers({"Accept: application/json"})
    Single<ArrayList<kr.co.popone.fitts.model.product.Product>> getRecommendProducts(@Path("post_id") long j, @Nullable @Query("base") Long l, @Nullable @Query("limit") Integer num);

    @NotNull
    @GET("/api/v9/posts/{post_id}/related_posts")
    @Headers({"Accept: application/json"})
    Single<RelatedPost> getRelatedPosts(@Path("post_id") long j);

    @NotNull
    @GET("/api/v9/posts/{post_id}/same_product_posts")
    @Headers({"Accept: application/json"})
    Single<List<Post>> getSameProductPosts(@Path("post_id") long j);

    @NotNull
    @GET("/api/v9/tags/{tag_name}/posts")
    @Headers({"Accept: application/json"})
    Single<ArrayList<Post>> getTagPosts(@NotNull @Path("tag_name") String str, @Nullable @Query("base") Long l, @Query("limit") int i);

    @FormUrlEncoded
    @NotNull
    @PATCH("/api/v9/posts/{id}")
    @Headers({"Accept: application/json"})
    Observable<PostId> patchPost(@Path("id") long j, @NotNull @Field("title") String str, @NotNull @Field("about_fit") String str2, @NotNull @Field("about_product") String str3, @NotNull @Field("about_size") String str4, @Field("cover") int i, @NotNull @Field("freeform") String str5, @Field("stars") float f, @NotNull @Field("tag") String str6, @NotNull @Field("style") String str7, @NotNull @Field("link_url") String str8);

    @NotNull
    @POST("/api/v9/posts/{post_id}/comments")
    @Headers({"Accept: application/json"})
    Single<Comment> postComment(@Path("post_id") long j, @NotNull @Query("content") String str);

    @PUT("/api/v9/posts/{id}/likes")
    @NotNull
    @Headers({"Accept: application/json"})
    Single<LikeResult> putLikes(@Path("id") long j);

    @PUT("/api/v9/comments/{comment_id}/report")
    @NotNull
    @Headers({"Accept: application/json"})
    Single<String> reportComment(@Path("comment_id") long j, @NotNull @Query("type") String str);

    @PUT("/api/v9/posts/{id}/report")
    @NotNull
    @Headers({"Accept: application/json"})
    Single<String> reportPost(@Path("id") long j, @NotNull @Query("type") String str);

    @NotNull
    @DELETE("/api/v9/posts/{id}")
    @Headers({"Accept: application/json"})
    Completable requestDeletePost(@Path("id") long j);

    @PUT("/api/v9/posts/{id}/touch")
    @NotNull
    @Headers({"Accept: application/json"})
    Single<String> requestInactivePostUpdate(@Path("id") long j);

    @NotNull
    @GET("/api/v9/posts/link_info")
    @Headers({"Accept: application/json"})
    Single<LinkInfo> requestLinkInfo(@NotNull @Query("url") String str);

    @NotNull
    @GET("/api/v9/posts/{id}/invoice")
    @Headers({"Accept: application/json"})
    Single<PostInvoice> requestPostInvoice(@Path("id") long j);

    @NotNull
    @GET("/api/v9/posts/search")
    @Headers({"Accept: application/json"})
    Single<SearchPostResult> searchPost(@NotNull @Query("query") String str, @Nullable @Query("base") Long l, @Nullable @Query("limit") Integer num);

    @FormUrlEncoded
    @NotNull
    @POST("/api/v9/posts")
    @Headers({"Accept: application/json"})
    Observable<PostId> uploadPost(@NotNull @Field("title") String str, @NotNull @Field("about_fit") String str2, @NotNull @Field("about_product") String str3, @NotNull @Field("about_size") String str4, @Field("cover") int i, @NotNull @Field("freeform") String str5, @Field("stars") float f, @NotNull @Field("tag") String str6, @NotNull @Field("style") String str7, @NotNull @Field("link_url") String str8, @NotNull @Field("categories") String str9, @Field("order_line_item_variant_id") @Nullable Long l);
}
