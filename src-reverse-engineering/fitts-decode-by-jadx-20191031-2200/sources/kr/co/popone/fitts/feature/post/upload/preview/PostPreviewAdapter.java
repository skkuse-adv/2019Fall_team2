package kr.co.popone.fitts.feature.post.upload.preview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import de.hdodenhof.circleimageview.CircleImageView;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.feature.post.PostType;
import kr.co.popone.fitts.model.datamodel.service.post.CreatePostImage;
import kr.co.popone.fitts.model.datamodel.service.user.BodyType;
import kr.co.popone.fitts.model.datamodel.service.user.MyInfo;
import kr.co.popone.fitts.model.post.PostAPI.CreatePost;
import kr.co.popone.fitts.model.post.PostAPI.LinkInfo;
import me.gujun.android.taggroup.TagGroup;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class PostPreviewAdapter extends Adapter<ViewHolder> {
    public static final Companion Companion = new Companion(null);
    private static final int TYPE_FOOTER = 2;
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;
    private final Context context;
    private final Delegate delegate;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public interface Delegate {
        @Nullable
        LinkInfo getLinkInfo();

        @NotNull
        CreatePost getPreviewPost();

        @NotNull
        MyInfo getUserInfo();
    }

    public static final class FooterViewHolder extends ViewHolder {
        @NotNull
        private final TextView aboutProduct;
        @NotNull
        private final TextView postProductAboutTitleTextView;
        @NotNull
        private final TagGroup postTags;

        public FooterViewHolder(@NotNull View view) {
            Intrinsics.checkParameterIsNotNull(view, "itemView");
            super(view);
            TextView textView = (TextView) view.findViewById(C0010R$id.about_product);
            Intrinsics.checkExpressionValueIsNotNull(textView, "itemView.about_product");
            this.aboutProduct = textView;
            TagGroup tagGroup = (TagGroup) view.findViewById(C0010R$id.post_tag);
            Intrinsics.checkExpressionValueIsNotNull(tagGroup, "itemView.post_tag");
            this.postTags = tagGroup;
            View findViewById = view.findViewById(C0010R$id.postProductAboutTitleTextView);
            Intrinsics.checkExpressionValueIsNotNull(findViewById, "itemView.findViewById(R.…roductAboutTitleTextView)");
            this.postProductAboutTitleTextView = (TextView) findViewById;
        }

        @NotNull
        public final TextView getAboutProduct() {
            return this.aboutProduct;
        }

        @NotNull
        public final TagGroup getPostTags() {
            return this.postTags;
        }

        @NotNull
        public final TextView getPostProductAboutTitleTextView() {
            return this.postProductAboutTitleTextView;
        }
    }

    public static final class HeaderViewHolder extends ViewHolder {
        @NotNull
        private final ImageView postCoverImage;
        @NotNull
        private final RatingBar postRating;
        @NotNull
        private final TextView postTitle;
        @NotNull
        private final ImageView productImage;
        @NotNull
        private final TextView productPrice;
        @NotNull
        private final TextView productSize;
        @NotNull
        private final TextView productSizeLabel;
        @NotNull
        private final TextView profileDescription;
        @NotNull
        private final TextView profileId;
        @NotNull
        private final CircleImageView profileImage;
        @NotNull
        private final TextView profileInfo;
        @NotNull
        private final ImageView profileType;
        @NotNull
        private final TextView shopName;

        public HeaderViewHolder(@NotNull View view) {
            Intrinsics.checkParameterIsNotNull(view, "itemView");
            super(view);
            ImageView imageView = (ImageView) view.findViewById(C0010R$id.post_cover_image);
            Intrinsics.checkExpressionValueIsNotNull(imageView, "itemView.post_cover_image");
            this.postCoverImage = imageView;
            RatingBar ratingBar = (RatingBar) view.findViewById(C0010R$id.post_rating);
            Intrinsics.checkExpressionValueIsNotNull(ratingBar, "itemView.post_rating");
            this.postRating = ratingBar;
            TextView textView = (TextView) view.findViewById(C0010R$id.post_title);
            Intrinsics.checkExpressionValueIsNotNull(textView, "itemView.post_title");
            this.postTitle = textView;
            CircleImageView circleImageView = (CircleImageView) view.findViewById(C0010R$id.profile_image);
            Intrinsics.checkExpressionValueIsNotNull(circleImageView, "itemView.profile_image");
            this.profileImage = circleImageView;
            TextView textView2 = (TextView) view.findViewById(C0010R$id.profile_id);
            Intrinsics.checkExpressionValueIsNotNull(textView2, "itemView.profile_id");
            this.profileId = textView2;
            ImageView imageView2 = (ImageView) view.findViewById(C0010R$id.profile_type);
            Intrinsics.checkExpressionValueIsNotNull(imageView2, "itemView.profile_type");
            this.profileType = imageView2;
            TextView textView3 = (TextView) view.findViewById(C0010R$id.profile_info);
            Intrinsics.checkExpressionValueIsNotNull(textView3, "itemView.profile_info");
            this.profileInfo = textView3;
            TextView textView4 = (TextView) view.findViewById(C0010R$id.profile_description);
            Intrinsics.checkExpressionValueIsNotNull(textView4, "itemView.profile_description");
            this.profileDescription = textView4;
            TextView textView5 = (TextView) view.findViewById(C0010R$id.shop_name);
            Intrinsics.checkExpressionValueIsNotNull(textView5, "itemView.shop_name");
            this.shopName = textView5;
            TextView textView6 = (TextView) view.findViewById(C0010R$id.product_price);
            Intrinsics.checkExpressionValueIsNotNull(textView6, "itemView.product_price");
            this.productPrice = textView6;
            View findViewById = view.findViewById(C0010R$id.postProductSizeLabel);
            Intrinsics.checkExpressionValueIsNotNull(findViewById, "itemView.findViewById(R.id.postProductSizeLabel)");
            this.productSizeLabel = (TextView) findViewById;
            TextView textView7 = (TextView) view.findViewById(C0010R$id.product_size);
            Intrinsics.checkExpressionValueIsNotNull(textView7, "itemView.product_size");
            this.productSize = textView7;
            ImageView imageView3 = (ImageView) view.findViewById(C0010R$id.product_image);
            Intrinsics.checkExpressionValueIsNotNull(imageView3, "itemView.product_image");
            this.productImage = imageView3;
        }

        @NotNull
        public final ImageView getPostCoverImage() {
            return this.postCoverImage;
        }

        @NotNull
        public final RatingBar getPostRating() {
            return this.postRating;
        }

        @NotNull
        public final TextView getPostTitle() {
            return this.postTitle;
        }

        @NotNull
        public final CircleImageView getProfileImage() {
            return this.profileImage;
        }

        @NotNull
        public final TextView getProfileId() {
            return this.profileId;
        }

        @NotNull
        public final ImageView getProfileType() {
            return this.profileType;
        }

        @NotNull
        public final TextView getProfileInfo() {
            return this.profileInfo;
        }

        @NotNull
        public final TextView getProfileDescription() {
            return this.profileDescription;
        }

        @NotNull
        public final TextView getShopName() {
            return this.shopName;
        }

        @NotNull
        public final TextView getProductPrice() {
            return this.productPrice;
        }

        @NotNull
        public final TextView getProductSizeLabel() {
            return this.productSizeLabel;
        }

        @NotNull
        public final TextView getProductSize() {
            return this.productSize;
        }

        @NotNull
        public final ImageView getProductImage() {
            return this.productImage;
        }
    }

    public static final class ItemViewHolder extends ViewHolder {
        @NotNull
        private final ImageView postImage;
        @NotNull
        private final TextView postImageDescription;
        @NotNull
        private final LinearLayout postImageDescriptionLayout;

        public ItemViewHolder(@NotNull View view) {
            Intrinsics.checkParameterIsNotNull(view, "itemView");
            super(view);
            ImageView imageView = (ImageView) view.findViewById(C0010R$id.post_image);
            Intrinsics.checkExpressionValueIsNotNull(imageView, "itemView.post_image");
            this.postImage = imageView;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(C0010R$id.post_image_description_layout);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout, "itemView.post_image_description_layout");
            this.postImageDescriptionLayout = linearLayout;
            TextView textView = (TextView) view.findViewById(C0010R$id.post_image_description);
            Intrinsics.checkExpressionValueIsNotNull(textView, "itemView.post_image_description");
            this.postImageDescription = textView;
        }

        @NotNull
        public final ImageView getPostImage() {
            return this.postImage;
        }

        @NotNull
        public final LinearLayout getPostImageDescriptionLayout() {
            return this.postImageDescriptionLayout;
        }

        @NotNull
        public final TextView getPostImageDescription() {
            return this.postImageDescription;
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = new int[BodyType.values().length];
        public static final /* synthetic */ int[] $EnumSwitchMapping$1 = new int[PostType.values().length];
        public static final /* synthetic */ int[] $EnumSwitchMapping$2 = new int[PostType.values().length];
        public static final /* synthetic */ int[] $EnumSwitchMapping$3 = new int[PostType.values().length];
        public static final /* synthetic */ int[] $EnumSwitchMapping$4 = new int[PostType.values().length];

        static {
            $EnumSwitchMapping$0[BodyType.TRIANGLE.ordinal()] = 1;
            $EnumSwitchMapping$0[BodyType.INVERTED_TRIANGLE.ordinal()] = 2;
            $EnumSwitchMapping$0[BodyType.RECTANGLE.ordinal()] = 3;
            $EnumSwitchMapping$0[BodyType.HOURGLASS.ordinal()] = 4;
            $EnumSwitchMapping$0[BodyType.NORMAL.ordinal()] = 5;
            $EnumSwitchMapping$1[PostType.CLOTHES.ordinal()] = 1;
            $EnumSwitchMapping$1[PostType.SHOES.ordinal()] = 2;
            $EnumSwitchMapping$1[PostType.BAG.ordinal()] = 3;
            $EnumSwitchMapping$2[PostType.SHOES.ordinal()] = 1;
            $EnumSwitchMapping$3[PostType.CLOTHES.ordinal()] = 1;
            $EnumSwitchMapping$3[PostType.BAG.ordinal()] = 2;
            $EnumSwitchMapping$3[PostType.SHOES.ordinal()] = 3;
            $EnumSwitchMapping$4[PostType.CLOTHES.ordinal()] = 1;
            $EnumSwitchMapping$4[PostType.BAG.ordinal()] = 2;
            $EnumSwitchMapping$4[PostType.SHOES.ordinal()] = 3;
        }
    }

    public PostPreviewAdapter(@NotNull Context context2, @NotNull Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(context2, "context");
        Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
        this.context = context2;
        this.delegate = delegate2;
    }

    public int getItemCount() {
        return this.delegate.getPreviewPost().getFreeformImagesPath().size() + 2;
    }

    public int getItemViewType(int i) {
        if (i == 0) {
            return TYPE_HEADER;
        }
        if (i == this.delegate.getPreviewPost().getFreeformImagesPath().size() + 1) {
            return TYPE_FOOTER;
        }
        return TYPE_ITEM;
    }

    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        if (i == TYPE_HEADER) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.item_post_preview_header, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "LayoutInflater.from(pare…ew_header, parent, false)");
            return new HeaderViewHolder(inflate);
        } else if (i == TYPE_ITEM) {
            View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.item_post_preview, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate2, "LayoutInflater.from(pare…t_preview, parent, false)");
            return new ItemViewHolder(inflate2);
        } else if (i == TYPE_FOOTER) {
            View inflate3 = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.item_post_preview_footer, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate3, "LayoutInflater.from(pare…ew_footer, parent, false)");
            return new FooterViewHolder(inflate3);
        } else {
            throw new IllegalAccessException();
        }
    }

    private final CreatePostImage getItem(int i) {
        Object obj = this.delegate.getPreviewPost().getFreeformImagesPath().get(i);
        Intrinsics.checkExpressionValueIsNotNull(obj, "delegate.previewPost.freeformImagesPath[position]");
        return (CreatePostImage) obj;
    }

    /* JADX WARNING: Removed duplicated region for block: B:56:0x0287  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x02bd  */
    @android.annotation.SuppressLint({"SetTextI18n"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull androidx.recyclerview.widget.RecyclerView.ViewHolder r9, int r10) {
        /*
            r8 = this;
            java.lang.String r0 = "holder"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r9, r0)
            boolean r0 = r9 instanceof kr.co.popone.fitts.feature.post.upload.preview.PostPreviewAdapter.HeaderViewHolder
            r1 = 8
            r2 = 3
            r3 = 2
            r4 = 0
            r5 = 1
            if (r0 == 0) goto L_0x0342
            android.content.Context r10 = r8.context
            com.bumptech.glide.RequestManager r10 = com.bumptech.glide.Glide.with(r10)
            kr.co.popone.fitts.feature.post.upload.preview.PostPreviewAdapter$Delegate r0 = r8.delegate
            kr.co.popone.fitts.model.post.PostAPI$CreatePost r0 = r0.getPreviewPost()
            java.lang.String r0 = r0.getCoverImagePath()
            com.bumptech.glide.RequestBuilder r10 = r10.load(r0)
            kr.co.popone.fitts.feature.post.upload.preview.PostPreviewAdapter$HeaderViewHolder r9 = (kr.co.popone.fitts.feature.post.upload.preview.PostPreviewAdapter.HeaderViewHolder) r9
            android.widget.ImageView r0 = r9.getPostCoverImage()
            r10.into(r0)
            android.widget.RatingBar r10 = r9.getPostRating()
            kr.co.popone.fitts.feature.post.upload.preview.PostPreviewAdapter$Delegate r0 = r8.delegate
            kr.co.popone.fitts.model.post.PostAPI$CreatePost r0 = r0.getPreviewPost()
            float r0 = r0.getStar()
            r10.setRating(r0)
            android.widget.TextView r10 = r9.getPostTitle()
            kr.co.popone.fitts.feature.post.upload.preview.PostPreviewAdapter$Delegate r0 = r8.delegate
            kr.co.popone.fitts.model.post.PostAPI$CreatePost r0 = r0.getPreviewPost()
            java.lang.String r0 = r0.getTitle()
            r10.setText(r0)
            com.bumptech.glide.request.RequestOptions r10 = new com.bumptech.glide.request.RequestOptions
            r10.<init>()
            r0 = 2131231064(0x7f080158, float:1.8078198E38)
            com.bumptech.glide.request.BaseRequestOptions r10 = r10.placeholder(r0)
            com.bumptech.glide.request.RequestOptions r10 = (com.bumptech.glide.request.RequestOptions) r10
            com.bumptech.glide.request.BaseRequestOptions r10 = r10.error(r0)
            java.lang.String r0 = "RequestOptions()\n       …ge_default_profile_large)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r10, r0)
            com.bumptech.glide.request.RequestOptions r10 = (com.bumptech.glide.request.RequestOptions) r10
            android.content.Context r0 = r8.context
            com.bumptech.glide.RequestManager r0 = com.bumptech.glide.Glide.with(r0)
            kr.co.popone.fitts.feature.post.upload.preview.PostPreviewAdapter$Delegate r6 = r8.delegate
            kr.co.popone.fitts.model.datamodel.service.user.MyInfo r6 = r6.getUserInfo()
            java.lang.String r6 = r6.getProfileImageUrl()
            com.bumptech.glide.RequestBuilder r0 = r0.load(r6)
            com.bumptech.glide.RequestBuilder r10 = r0.apply(r10)
            de.hdodenhof.circleimageview.CircleImageView r0 = r9.getProfileImage()
            r10.into(r0)
            android.widget.TextView r10 = r9.getProfileId()
            kr.co.popone.fitts.feature.post.upload.preview.PostPreviewAdapter$Delegate r0 = r8.delegate
            kr.co.popone.fitts.model.datamodel.service.user.MyInfo r0 = r0.getUserInfo()
            java.lang.String r0 = r0.getFittsID()
            r10.setText(r0)
            kr.co.popone.fitts.feature.post.upload.preview.PostPreviewAdapter$Delegate r10 = r8.delegate
            kr.co.popone.fitts.model.datamodel.service.user.MyInfo r10 = r10.getUserInfo()
            kr.co.popone.fitts.model.datamodel.service.user.BodyInfo r10 = r10.getBodyInfo()
            kr.co.popone.fitts.model.datamodel.service.user.BodyType r10 = r10.getBodyType()
            int[] r0 = kr.co.popone.fitts.feature.post.upload.preview.PostPreviewAdapter.WhenMappings.$EnumSwitchMapping$0
            int r10 = r10.ordinal()
            r10 = r0[r10]
            if (r10 == r5) goto L_0x00e6
            if (r10 == r3) goto L_0x00db
            if (r10 == r2) goto L_0x00d0
            r0 = 4
            if (r10 == r0) goto L_0x00c5
            r0 = 5
            if (r10 == r0) goto L_0x00ba
            goto L_0x00f0
        L_0x00ba:
            android.widget.ImageView r10 = r9.getProfileType()
            r0 = 2131231069(0x7f08015d, float:1.8078209E38)
            r10.setImageResource(r0)
            goto L_0x00f0
        L_0x00c5:
            android.widget.ImageView r10 = r9.getProfileType()
            r0 = 2131231066(0x7f08015a, float:1.8078203E38)
            r10.setImageResource(r0)
            goto L_0x00f0
        L_0x00d0:
            android.widget.ImageView r10 = r9.getProfileType()
            r0 = 2131231068(0x7f08015c, float:1.8078207E38)
            r10.setImageResource(r0)
            goto L_0x00f0
        L_0x00db:
            android.widget.ImageView r10 = r9.getProfileType()
            r0 = 2131231067(0x7f08015b, float:1.8078205E38)
            r10.setImageResource(r0)
            goto L_0x00f0
        L_0x00e6:
            android.widget.ImageView r10 = r9.getProfileType()
            r0 = 2131231070(0x7f08015e, float:1.807821E38)
            r10.setImageResource(r0)
        L_0x00f0:
            kr.co.popone.fitts.feature.post.upload.preview.PostPreviewAdapter$Delegate r10 = r8.delegate
            kr.co.popone.fitts.model.post.PostAPI$CreatePost r10 = r10.getPreviewPost()
            kr.co.popone.fitts.feature.post.PostType r10 = r10.getPostType()
            int[] r0 = kr.co.popone.fitts.feature.post.upload.preview.PostPreviewAdapter.WhenMappings.$EnumSwitchMapping$1
            int r10 = r10.ordinal()
            r10 = r0[r10]
            java.lang.String r0 = " . "
            if (r10 == r5) goto L_0x0186
            if (r10 == r3) goto L_0x0127
            if (r10 == r2) goto L_0x010c
            goto L_0x021f
        L_0x010c:
            android.widget.TextView r10 = r9.getProfileInfo()
            kr.co.popone.fitts.feature.post.upload.preview.PostPreviewAdapter$Delegate r0 = r8.delegate
            kr.co.popone.fitts.model.datamodel.service.user.MyInfo r0 = r0.getUserInfo()
            kr.co.popone.fitts.model.datamodel.service.user.BodyInfo r0 = r0.getBodyInfo()
            int r0 = r0.getHeight()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r10.setText(r0)
            goto L_0x021f
        L_0x0127:
            android.widget.TextView r10 = r9.getProfileInfo()
            kr.co.popone.fitts.feature.post.upload.preview.PostPreviewAdapter$Delegate r6 = r8.delegate
            kr.co.popone.fitts.model.datamodel.service.user.MyInfo r6 = r6.getUserInfo()
            kr.co.popone.fitts.model.datamodel.service.user.BodyInfo r6 = r6.getBodyInfo()
            int r6 = r6.getShoeSize()
            if (r6 <= 0) goto L_0x016f
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            kr.co.popone.fitts.feature.post.upload.preview.PostPreviewAdapter$Delegate r7 = r8.delegate
            kr.co.popone.fitts.model.datamodel.service.user.MyInfo r7 = r7.getUserInfo()
            kr.co.popone.fitts.model.datamodel.service.user.BodyInfo r7 = r7.getBodyInfo()
            int r7 = r7.getHeight()
            r6.append(r7)
            r6.append(r0)
            kr.co.popone.fitts.feature.post.upload.preview.PostPreviewAdapter$Delegate r0 = r8.delegate
            kr.co.popone.fitts.model.datamodel.service.user.MyInfo r0 = r0.getUserInfo()
            kr.co.popone.fitts.model.datamodel.service.user.BodyInfo r0 = r0.getBodyInfo()
            int r0 = r0.getShoeSize()
            r6.append(r0)
            java.lang.String r0 = "mm"
            r6.append(r0)
            java.lang.String r0 = r6.toString()
            goto L_0x0181
        L_0x016f:
            kr.co.popone.fitts.feature.post.upload.preview.PostPreviewAdapter$Delegate r0 = r8.delegate
            kr.co.popone.fitts.model.datamodel.service.user.MyInfo r0 = r0.getUserInfo()
            kr.co.popone.fitts.model.datamodel.service.user.BodyInfo r0 = r0.getBodyInfo()
            int r0 = r0.getHeight()
            java.lang.String r0 = java.lang.String.valueOf(r0)
        L_0x0181:
            r10.setText(r0)
            goto L_0x021f
        L_0x0186:
            android.widget.TextView r10 = r9.getProfileInfo()
            kr.co.popone.fitts.feature.post.upload.preview.PostPreviewAdapter$Delegate r6 = r8.delegate
            kr.co.popone.fitts.model.datamodel.service.user.MyInfo r6 = r6.getUserInfo()
            kr.co.popone.fitts.model.datamodel.service.user.BodyInfo r6 = r6.getBodyInfo()
            java.lang.String r6 = r6.getTop()
            if (r6 == 0) goto L_0x01a3
            boolean r6 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r6)
            if (r6 == 0) goto L_0x01a1
            goto L_0x01a3
        L_0x01a1:
            r6 = 0
            goto L_0x01a4
        L_0x01a3:
            r6 = 1
        L_0x01a4:
            if (r6 != 0) goto L_0x020a
            kr.co.popone.fitts.feature.post.upload.preview.PostPreviewAdapter$Delegate r6 = r8.delegate
            kr.co.popone.fitts.model.datamodel.service.user.MyInfo r6 = r6.getUserInfo()
            kr.co.popone.fitts.model.datamodel.service.user.BodyInfo r6 = r6.getBodyInfo()
            java.lang.String r6 = r6.getBottom()
            if (r6 == 0) goto L_0x01bf
            boolean r6 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r6)
            if (r6 == 0) goto L_0x01bd
            goto L_0x01bf
        L_0x01bd:
            r6 = 0
            goto L_0x01c0
        L_0x01bf:
            r6 = 1
        L_0x01c0:
            if (r6 != 0) goto L_0x020a
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            kr.co.popone.fitts.feature.post.upload.preview.PostPreviewAdapter$Delegate r7 = r8.delegate
            kr.co.popone.fitts.model.datamodel.service.user.MyInfo r7 = r7.getUserInfo()
            kr.co.popone.fitts.model.datamodel.service.user.BodyInfo r7 = r7.getBodyInfo()
            int r7 = r7.getHeight()
            r6.append(r7)
            r6.append(r0)
            kr.co.popone.fitts.feature.post.upload.preview.PostPreviewAdapter$Delegate r7 = r8.delegate
            kr.co.popone.fitts.model.datamodel.service.user.MyInfo r7 = r7.getUserInfo()
            kr.co.popone.fitts.model.datamodel.service.user.BodyInfo r7 = r7.getBodyInfo()
            java.lang.String r7 = r7.getTop()
            r6.append(r7)
            r6.append(r0)
            kr.co.popone.fitts.feature.post.upload.preview.PostPreviewAdapter$Delegate r0 = r8.delegate
            kr.co.popone.fitts.model.datamodel.service.user.MyInfo r0 = r0.getUserInfo()
            kr.co.popone.fitts.model.datamodel.service.user.BodyInfo r0 = r0.getBodyInfo()
            java.lang.String r0 = r0.getBottom()
            r6.append(r0)
            r0 = 32
            r6.append(r0)
            java.lang.String r0 = r6.toString()
            goto L_0x021c
        L_0x020a:
            kr.co.popone.fitts.feature.post.upload.preview.PostPreviewAdapter$Delegate r0 = r8.delegate
            kr.co.popone.fitts.model.datamodel.service.user.MyInfo r0 = r0.getUserInfo()
            kr.co.popone.fitts.model.datamodel.service.user.BodyInfo r0 = r0.getBodyInfo()
            int r0 = r0.getHeight()
            java.lang.String r0 = java.lang.String.valueOf(r0)
        L_0x021c:
            r10.setText(r0)
        L_0x021f:
            android.widget.TextView r10 = r9.getProfileDescription()
            kr.co.popone.fitts.feature.post.upload.preview.PostPreviewAdapter$Delegate r0 = r8.delegate
            kr.co.popone.fitts.model.post.PostAPI$CreatePost r0 = r0.getPreviewPost()
            kr.co.popone.fitts.feature.post.PostType r0 = r0.getPostType()
            int[] r6 = kr.co.popone.fitts.feature.post.upload.preview.PostPreviewAdapter.WhenMappings.$EnumSwitchMapping$2
            int r0 = r0.ordinal()
            r0 = r6[r0]
            if (r0 == r5) goto L_0x0246
            kr.co.popone.fitts.feature.post.upload.preview.PostPreviewAdapter$Delegate r0 = r8.delegate
            kr.co.popone.fitts.model.datamodel.service.user.MyInfo r0 = r0.getUserInfo()
            kr.co.popone.fitts.model.datamodel.service.user.BodyInfo r0 = r0.getBodyInfo()
            java.lang.String r0 = r0.getDescription()
            goto L_0x0254
        L_0x0246:
            kr.co.popone.fitts.feature.post.upload.preview.PostPreviewAdapter$Delegate r0 = r8.delegate
            kr.co.popone.fitts.model.datamodel.service.user.MyInfo r0 = r0.getUserInfo()
            kr.co.popone.fitts.model.datamodel.service.user.BodyInfo r0 = r0.getBodyInfo()
            java.lang.String r0 = r0.getFootDescription()
        L_0x0254:
            r10.setText(r0)
            kr.co.popone.fitts.feature.post.upload.preview.PostPreviewAdapter$Delegate r10 = r8.delegate
            kr.co.popone.fitts.model.post.PostAPI$LinkInfo r10 = r10.getLinkInfo()
            if (r10 == 0) goto L_0x02d6
            android.widget.TextView r10 = r9.getShopName()
            kr.co.popone.fitts.feature.post.upload.preview.PostPreviewAdapter$Delegate r0 = r8.delegate
            kr.co.popone.fitts.model.post.PostAPI$LinkInfo r0 = r0.getLinkInfo()
            r6 = 0
            if (r0 == 0) goto L_0x0277
            kr.co.popone.fitts.model.datamodel.commerce.Shop r0 = r0.getShop()
            if (r0 == 0) goto L_0x0277
            java.lang.String r0 = r0.getName()
            goto L_0x0278
        L_0x0277:
            r0 = r6
        L_0x0278:
            r10.setText(r0)
            android.widget.TextView r10 = r9.getProductPrice()
            kr.co.popone.fitts.feature.post.upload.preview.PostPreviewAdapter$Delegate r0 = r8.delegate
            kr.co.popone.fitts.model.post.PostAPI$LinkInfo r0 = r0.getLinkInfo()
            if (r0 == 0) goto L_0x0292
            kr.co.popone.fitts.model.datamodel.commerce.Product r0 = r0.getProduct()
            if (r0 == 0) goto L_0x0292
            java.lang.String r0 = r0.getPrice()
            goto L_0x0293
        L_0x0292:
            r0 = r6
        L_0x0293:
            r10.setText(r0)
            com.bumptech.glide.request.RequestOptions r10 = new com.bumptech.glide.request.RequestOptions
            r10.<init>()
            r0 = 2131231293(0x7f08023d, float:1.8078663E38)
            com.bumptech.glide.request.BaseRequestOptions r10 = r10.placeholder(r0)
            com.bumptech.glide.request.RequestOptions r10 = (com.bumptech.glide.request.RequestOptions) r10
            com.bumptech.glide.request.BaseRequestOptions r10 = r10.error(r0)
            java.lang.String r0 = "RequestOptions().placeho…(R.drawable.shop_sample1)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r10, r0)
            com.bumptech.glide.request.RequestOptions r10 = (com.bumptech.glide.request.RequestOptions) r10
            android.content.Context r0 = r8.context
            com.bumptech.glide.RequestManager r0 = com.bumptech.glide.Glide.with(r0)
            kr.co.popone.fitts.feature.post.upload.preview.PostPreviewAdapter$Delegate r7 = r8.delegate
            kr.co.popone.fitts.model.post.PostAPI$LinkInfo r7 = r7.getLinkInfo()
            if (r7 == 0) goto L_0x02c7
            kr.co.popone.fitts.model.datamodel.commerce.Product r7 = r7.getProduct()
            if (r7 == 0) goto L_0x02c7
            java.lang.String r6 = r7.getImageUrl()
        L_0x02c7:
            com.bumptech.glide.RequestBuilder r0 = r0.load(r6)
            com.bumptech.glide.RequestBuilder r10 = r0.apply(r10)
            android.widget.ImageView r0 = r9.getProductImage()
            r10.into(r0)
        L_0x02d6:
            kr.co.popone.fitts.feature.post.upload.preview.PostPreviewAdapter$Delegate r10 = r8.delegate
            kr.co.popone.fitts.model.post.PostAPI$CreatePost r10 = r10.getPreviewPost()
            kr.co.popone.fitts.feature.post.PostType r10 = r10.getPostType()
            int[] r0 = kr.co.popone.fitts.feature.post.upload.preview.PostPreviewAdapter.WhenMappings.$EnumSwitchMapping$3
            int r10 = r10.ordinal()
            r10 = r0[r10]
            if (r10 == r5) goto L_0x0321
            if (r10 == r3) goto L_0x0311
            if (r10 == r2) goto L_0x02f0
            goto L_0x03f8
        L_0x02f0:
            android.widget.TextView r10 = r9.getProductSizeLabel()
            r10.setVisibility(r4)
            android.widget.TextView r10 = r9.getProductSize()
            r10.setVisibility(r4)
            android.widget.TextView r9 = r9.getProductSize()
            kr.co.popone.fitts.feature.post.upload.preview.PostPreviewAdapter$Delegate r10 = r8.delegate
            kr.co.popone.fitts.model.post.PostAPI$CreatePost r10 = r10.getPreviewPost()
            java.lang.String r10 = r10.getAboutSize()
            r9.setText(r10)
            goto L_0x03f8
        L_0x0311:
            android.widget.TextView r10 = r9.getProductSizeLabel()
            r10.setVisibility(r1)
            android.widget.TextView r9 = r9.getProductSize()
            r9.setVisibility(r1)
            goto L_0x03f8
        L_0x0321:
            android.widget.TextView r10 = r9.getProductSizeLabel()
            r10.setVisibility(r4)
            android.widget.TextView r10 = r9.getProductSize()
            r10.setVisibility(r4)
            android.widget.TextView r9 = r9.getProductSize()
            kr.co.popone.fitts.feature.post.upload.preview.PostPreviewAdapter$Delegate r10 = r8.delegate
            kr.co.popone.fitts.model.post.PostAPI$CreatePost r10 = r10.getPreviewPost()
            java.lang.String r10 = r10.getAboutSize()
            r9.setText(r10)
            goto L_0x03f8
        L_0x0342:
            boolean r0 = r9 instanceof kr.co.popone.fitts.feature.post.upload.preview.PostPreviewAdapter.ItemViewHolder
            if (r0 == 0) goto L_0x038e
            int r10 = r10 - r5
            kr.co.popone.fitts.model.datamodel.service.post.CreatePostImage r10 = r8.getItem(r10)
            android.content.Context r0 = r8.context
            com.bumptech.glide.RequestManager r0 = com.bumptech.glide.Glide.with(r0)
            java.lang.String r2 = r10.getPath()
            com.bumptech.glide.RequestBuilder r0 = r0.load(r2)
            kr.co.popone.fitts.feature.post.upload.preview.PostPreviewAdapter$ItemViewHolder r9 = (kr.co.popone.fitts.feature.post.upload.preview.PostPreviewAdapter.ItemViewHolder) r9
            android.widget.ImageView r2 = r9.getPostImage()
            r0.into(r2)
            java.lang.String r0 = r10.getDescription()
            if (r0 == 0) goto L_0x0370
            int r0 = r0.length()
            if (r0 != 0) goto L_0x036f
            goto L_0x0370
        L_0x036f:
            r5 = 0
        L_0x0370:
            if (r5 == 0) goto L_0x037b
            android.widget.LinearLayout r9 = r9.getPostImageDescriptionLayout()
            r9.setVisibility(r1)
            goto L_0x03f8
        L_0x037b:
            android.widget.TextView r0 = r9.getPostImageDescription()
            java.lang.String r10 = r10.getDescription()
            r0.setText(r10)
            android.widget.LinearLayout r9 = r9.getPostImageDescriptionLayout()
            r9.setVisibility(r4)
            goto L_0x03f8
        L_0x038e:
            boolean r10 = r9 instanceof kr.co.popone.fitts.feature.post.upload.preview.PostPreviewAdapter.FooterViewHolder
            if (r10 == 0) goto L_0x03f8
            kr.co.popone.fitts.feature.post.upload.preview.PostPreviewAdapter$FooterViewHolder r9 = (kr.co.popone.fitts.feature.post.upload.preview.PostPreviewAdapter.FooterViewHolder) r9
            android.widget.TextView r10 = r9.getAboutProduct()
            kr.co.popone.fitts.feature.post.upload.preview.PostPreviewAdapter$Delegate r0 = r8.delegate
            kr.co.popone.fitts.model.post.PostAPI$CreatePost r0 = r0.getPreviewPost()
            java.lang.String r0 = r0.getAboutFit()
            r10.setText(r0)
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            kr.co.popone.fitts.feature.post.upload.preview.PostPreviewAdapter$Delegate r0 = r8.delegate
            kr.co.popone.fitts.model.post.PostAPI$CreatePost r0 = r0.getPreviewPost()
            java.util.ArrayList r0 = r0.getStyleTags()
            r10.addAll(r0)
            kr.co.popone.fitts.feature.post.upload.preview.PostPreviewAdapter$Delegate r0 = r8.delegate
            kr.co.popone.fitts.model.post.PostAPI$CreatePost r0 = r0.getPreviewPost()
            java.util.ArrayList r0 = r0.getTags()
            r10.addAll(r0)
            me.gujun.android.taggroup.TagGroup r0 = r9.getPostTags()
            r0.setTags(r10)
            android.widget.TextView r9 = r9.getPostProductAboutTitleTextView()
            kr.co.popone.fitts.feature.post.upload.preview.PostPreviewAdapter$Delegate r10 = r8.delegate
            kr.co.popone.fitts.model.post.PostAPI$CreatePost r10 = r10.getPreviewPost()
            kr.co.popone.fitts.feature.post.PostType r10 = r10.getPostType()
            int[] r0 = kr.co.popone.fitts.feature.post.upload.preview.PostPreviewAdapter.WhenMappings.$EnumSwitchMapping$4
            int r10 = r10.ordinal()
            r10 = r0[r10]
            if (r10 == r5) goto L_0x03f3
            if (r10 == r3) goto L_0x03f0
            if (r10 != r2) goto L_0x03ea
            java.lang.String r10 = "이 신발에 대해"
            goto L_0x03f5
        L_0x03ea:
            kotlin.NoWhenBranchMatchedException r9 = new kotlin.NoWhenBranchMatchedException
            r9.<init>()
            throw r9
        L_0x03f0:
            java.lang.String r10 = "이 가방에 대해"
            goto L_0x03f5
        L_0x03f3:
            java.lang.String r10 = "이 옷에 대해"
        L_0x03f5:
            r9.setText(r10)
        L_0x03f8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.feature.post.upload.preview.PostPreviewAdapter.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder, int):void");
    }
}
