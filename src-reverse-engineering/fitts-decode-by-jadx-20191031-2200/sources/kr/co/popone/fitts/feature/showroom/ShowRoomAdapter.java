package kr.co.popone.fitts.feature.showroom;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import de.hdodenhof.circleimageview.CircleImageView;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0006R$color;
import kr.co.popone.fitts.C0008R$drawable;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.C0016R$string;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.feature.base.EmptyTypeHolder;
import kr.co.popone.fitts.feature.home.PostListTypeControl;
import kr.co.popone.fitts.feature.home.PostListTypeControl.Type;
import kr.co.popone.fitts.model.datamodel.commerce.Product;
import kr.co.popone.fitts.model.datamodel.commerce.Shop;
import kr.co.popone.fitts.model.datamodel.service.user.ShowRoom;
import kr.co.popone.fitts.model.datamodel.service.user.User;
import kr.co.popone.fitts.model.post.PostAPI.LinkInfo;
import kr.co.popone.fitts.model.post.PostAPI.Post;
import kr.co.popone.fitts.ui.ImageViewExtensionKt;
import kr.co.popone.fitts.ui.custom.RoundImageView;
import kr.co.popone.fitts.utils.UIExtensions;
import org.jetbrains.anko.Sdk27PropertiesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ShowRoomAdapter extends Adapter<ViewHolder> {
    public static final Companion Companion = new Companion(null);
    private static final int TYPE_EMPTY = 3;
    private static final int TYPE_GRID = 2;
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;
    private final Context context;
    /* access modifiers changed from: private */
    public final Delegate delegate;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public interface Delegate {
        @NotNull
        SessionManager getAdapterSessionManager();

        @NotNull
        List<Post> getShowRoomPostList();

        @Nullable
        ShowRoom getUserInfo();

        boolean isLinearView();

        void onCommentClicked(@NotNull Post post);

        void onCreatePostClicked();

        void onFollowClicked(@NotNull User user, @NotNull View view);

        void onFollowersCountClicked(@NotNull ShowRoom showRoom);

        void onFollowingCountClicked(@NotNull ShowRoom showRoom);

        void onGridClicked();

        void onLikedClicked(@NotNull Post post, @NotNull View view);

        void onLinearClicked();

        void onModifyProfileClicked();

        void onModifyProfileImageClicked();

        void onPostContentClicked(@NotNull Post post, @NotNull View view);
    }

    public static final class HeaderViewHolder extends ViewHolder {
        @NotNull
        private final Button followButton;
        @NotNull
        private final TextView followerCount;
        @NotNull
        private final LinearLayout followersLayout;
        @NotNull
        private final TextView followingCount;
        @NotNull
        private final LinearLayout followingLayout;
        @NotNull
        private final Button modifyProfileButton;
        @NotNull
        private final ImageButton modifyProfileImageButton;
        @NotNull
        private final TextView postCount;
        @NotNull
        private final PostListTypeControl postListTypeControl;
        @NotNull
        private final TextView profileID;
        @NotNull
        private final CircleImageView profileImage;
        @NotNull
        private final TextView profileStyle;
        @NotNull
        private final ImageView showroomCover;
        @NotNull
        private final TextView showroomIntro;

        public HeaderViewHolder(@NotNull View view) {
            Intrinsics.checkParameterIsNotNull(view, "itemView");
            super(view);
            ImageView imageView = (ImageView) view.findViewById(C0010R$id.showroom_cover);
            Intrinsics.checkExpressionValueIsNotNull(imageView, "itemView.showroom_cover");
            this.showroomCover = imageView;
            TextView textView = (TextView) view.findViewById(C0010R$id.profile_id);
            Intrinsics.checkExpressionValueIsNotNull(textView, "itemView.profile_id");
            this.profileID = textView;
            CircleImageView circleImageView = (CircleImageView) view.findViewById(C0010R$id.profile_image);
            Intrinsics.checkExpressionValueIsNotNull(circleImageView, "itemView.profile_image");
            this.profileImage = circleImageView;
            ImageButton imageButton = (ImageButton) view.findViewById(C0010R$id.modify_profile_image_button);
            Intrinsics.checkExpressionValueIsNotNull(imageButton, "itemView.modify_profile_image_button");
            this.modifyProfileImageButton = imageButton;
            Button button = (Button) view.findViewById(C0010R$id.modify_profile_button);
            Intrinsics.checkExpressionValueIsNotNull(button, "itemView.modify_profile_button");
            this.modifyProfileButton = button;
            Button button2 = (Button) view.findViewById(C0010R$id.follow_button);
            Intrinsics.checkExpressionValueIsNotNull(button2, "itemView.follow_button");
            this.followButton = button2;
            TextView textView2 = (TextView) view.findViewById(C0010R$id.profile_style);
            Intrinsics.checkExpressionValueIsNotNull(textView2, "itemView.profile_style");
            this.profileStyle = textView2;
            TextView textView3 = (TextView) view.findViewById(C0010R$id.showroom_intro);
            Intrinsics.checkExpressionValueIsNotNull(textView3, "itemView.showroom_intro");
            this.showroomIntro = textView3;
            TextView textView4 = (TextView) view.findViewById(C0010R$id.post_count);
            Intrinsics.checkExpressionValueIsNotNull(textView4, "itemView.post_count");
            this.postCount = textView4;
            TextView textView5 = (TextView) view.findViewById(C0010R$id.follower_count);
            Intrinsics.checkExpressionValueIsNotNull(textView5, "itemView.follower_count");
            this.followerCount = textView5;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(C0010R$id.followersLayout);
            if (linearLayout == null) {
                Intrinsics.throwNpe();
            }
            this.followersLayout = linearLayout;
            TextView textView6 = (TextView) view.findViewById(C0010R$id.following_count);
            Intrinsics.checkExpressionValueIsNotNull(textView6, "itemView.following_count");
            this.followingCount = textView6;
            LinearLayout linearLayout2 = (LinearLayout) view.findViewById(C0010R$id.following_layout);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout2, "itemView.following_layout");
            this.followingLayout = linearLayout2;
            View findViewById = view.findViewById(C0010R$id.postListTypeControl);
            Intrinsics.checkExpressionValueIsNotNull(findViewById, "itemView.findViewById(R.id.postListTypeControl)");
            this.postListTypeControl = (PostListTypeControl) findViewById;
        }

        @NotNull
        public final ImageView getShowroomCover() {
            return this.showroomCover;
        }

        @NotNull
        public final TextView getProfileID() {
            return this.profileID;
        }

        @NotNull
        public final CircleImageView getProfileImage() {
            return this.profileImage;
        }

        @NotNull
        public final ImageButton getModifyProfileImageButton() {
            return this.modifyProfileImageButton;
        }

        @NotNull
        public final Button getModifyProfileButton() {
            return this.modifyProfileButton;
        }

        @NotNull
        public final Button getFollowButton() {
            return this.followButton;
        }

        @NotNull
        public final TextView getProfileStyle() {
            return this.profileStyle;
        }

        @NotNull
        public final TextView getShowroomIntro() {
            return this.showroomIntro;
        }

        @NotNull
        public final TextView getPostCount() {
            return this.postCount;
        }

        @NotNull
        public final TextView getFollowerCount() {
            return this.followerCount;
        }

        @NotNull
        public final LinearLayout getFollowersLayout() {
            return this.followersLayout;
        }

        @NotNull
        public final TextView getFollowingCount() {
            return this.followingCount;
        }

        @NotNull
        public final LinearLayout getFollowingLayout() {
            return this.followingLayout;
        }

        @NotNull
        public final PostListTypeControl getPostListTypeControl() {
            return this.postListTypeControl;
        }
    }

    public static final class ItemEmptyViewHolder extends ViewHolder {
        @NotNull
        private final LinearLayout emptyContent;
        @NotNull
        private final Button emptyCreatePost;
        @NotNull
        private final ProgressBar loadingProgress;

        public ItemEmptyViewHolder(@NotNull View view) {
            Intrinsics.checkParameterIsNotNull(view, "itemView");
            super(view);
            LinearLayout linearLayout = (LinearLayout) view.findViewById(C0010R$id.empty_content);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout, "itemView.empty_content");
            this.emptyContent = linearLayout;
            Button button = (Button) view.findViewById(C0010R$id.empty_create_post);
            Intrinsics.checkExpressionValueIsNotNull(button, "itemView.empty_create_post");
            this.emptyCreatePost = button;
            ProgressBar progressBar = (ProgressBar) view.findViewById(C0010R$id.loading_progress);
            if (progressBar == null) {
                Intrinsics.throwNpe();
            }
            this.loadingProgress = progressBar;
        }

        @NotNull
        public final LinearLayout getEmptyContent() {
            return this.emptyContent;
        }

        @NotNull
        public final Button getEmptyCreatePost() {
            return this.emptyCreatePost;
        }

        @NotNull
        public final ProgressBar getLoadingProgress() {
            return this.loadingProgress;
        }
    }

    public static final class ItemGridViewHolder extends ViewHolder {
        @NotNull
        private final ImageView inactivePost;
        @NotNull
        private final ImageView inactivePostIcon;
        @NotNull
        private final ImageView postCoverImage;

        public ItemGridViewHolder(@NotNull View view) {
            Intrinsics.checkParameterIsNotNull(view, "itemView");
            super(view);
            RoundImageView roundImageView = (RoundImageView) view.findViewById(C0010R$id.post_cover_image);
            Intrinsics.checkExpressionValueIsNotNull(roundImageView, "itemView.post_cover_image");
            this.postCoverImage = roundImageView;
            ImageView imageView = (ImageView) view.findViewById(C0010R$id.inactive_post_icon_grid);
            Intrinsics.checkExpressionValueIsNotNull(imageView, "itemView.inactive_post_icon_grid");
            this.inactivePostIcon = imageView;
            ImageView imageView2 = (ImageView) view.findViewById(C0010R$id.inactive_post_grid);
            Intrinsics.checkExpressionValueIsNotNull(imageView2, "itemView.inactive_post_grid");
            this.inactivePost = imageView2;
        }

        @NotNull
        public final ImageView getPostCoverImage() {
            return this.postCoverImage;
        }

        @NotNull
        public final ImageView getInactivePostIcon() {
            return this.inactivePostIcon;
        }

        @NotNull
        public final ImageView getInactivePost() {
            return this.inactivePost;
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = new int[Type.values().length];

        static {
            $EnumSwitchMapping$0[Type.ListView.ordinal()] = 1;
            $EnumSwitchMapping$0[Type.ThumbnailView.ordinal()] = 2;
        }
    }

    public ShowRoomAdapter(@NotNull Context context2, @NotNull Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(context2, "context");
        Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
        this.context = context2;
        this.delegate = delegate2;
    }

    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        String str = "v";
        if (i == TYPE_HEADER) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.item_userpost_header, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, str);
            return new HeaderViewHolder(inflate);
        } else if (i == TYPE_ITEM) {
            View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.item_showroom_post_list, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate2, str);
            return new ShowroomPostListItemViewHolder(inflate2);
        } else if (i == TYPE_GRID) {
            View inflate3 = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.item_userpost_grid, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate3, str);
            return new ItemGridViewHolder(inflate3);
        } else if (i != TYPE_EMPTY) {
            return EmptyTypeHolder.Companion.create(viewGroup);
        } else {
            View inflate4 = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.item_userpost_empty, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate4, str);
            return new ItemEmptyViewHolder(inflate4);
        }
    }

    private final Post getItem(int i) {
        return (Post) this.delegate.getShowRoomPostList().get(i);
    }

    public int getItemViewType(int i) {
        if (i == 0) {
            return TYPE_HEADER;
        }
        if (this.delegate.getShowRoomPostList().isEmpty()) {
            return TYPE_EMPTY;
        }
        if (this.delegate.isLinearView()) {
            return TYPE_ITEM;
        }
        return TYPE_GRID;
    }

    public int getItemCount() {
        if (this.delegate.getShowRoomPostList().isEmpty()) {
            return this.delegate.getShowRoomPostList().size() + 2;
        }
        return this.delegate.getShowRoomPostList().size() + 1;
    }

    @SuppressLint({"SetTextI18n"})
    public void onBindViewHolder(@NotNull ViewHolder viewHolder, int i) {
        ViewHolder viewHolder2 = viewHolder;
        Intrinsics.checkParameterIsNotNull(viewHolder2, "holder");
        String str = null;
        boolean z = true;
        if (viewHolder2 instanceof HeaderViewHolder) {
            BaseRequestOptions error = ((RequestOptions) ((RequestOptions) new RequestOptions().centerCrop()).placeholder((Drawable) new ColorDrawable(ContextCompat.getColor(this.context, 17170443)))).error((Drawable) new ColorDrawable(ContextCompat.getColor(this.context, 17170443)));
            Intrinsics.checkExpressionValueIsNotNull(error, "RequestOptions()\n       … android.R.color.white)))");
            RequestOptions requestOptions = (RequestOptions) error;
            RequestManager with = Glide.with(this.context);
            ShowRoom userInfo = this.delegate.getUserInfo();
            HeaderViewHolder headerViewHolder = (HeaderViewHolder) viewHolder2;
            with.load(userInfo != null ? userInfo.getShowRoomCoverImageUrl() : null).apply((BaseRequestOptions<?>) requestOptions).into(headerViewHolder.getShowroomCover());
            BaseRequestOptions error2 = ((RequestOptions) new RequestOptions().placeholder((int) C0008R$drawable.image_default_profile)).error((int) C0008R$drawable.image_default_profile);
            Intrinsics.checkExpressionValueIsNotNull(error2, "RequestOptions().placeho…le.image_default_profile)");
            RequestOptions requestOptions2 = (RequestOptions) error2;
            RequestManager with2 = Glide.with(this.context);
            ShowRoom userInfo2 = this.delegate.getUserInfo();
            if (userInfo2 != null) {
                User user = userInfo2.getUser();
                if (user != null) {
                    str = user.getProfileImageUrl();
                }
            }
            with2.load(str).apply((BaseRequestOptions<?>) requestOptions2).into((ImageView) headerViewHolder.getProfileImage());
            if (this.delegate.isLinearView()) {
                headerViewHolder.getPostListTypeControl().setType(Type.ListView);
            } else {
                headerViewHolder.getPostListTypeControl().setType(Type.ThumbnailView);
            }
            headerViewHolder.getPostListTypeControl().setTypeChangeListener(new ShowRoomAdapter$onBindViewHolder$1(this));
            if (this.delegate.getUserInfo() instanceof ShowRoom) {
                TextView profileID = headerViewHolder.getProfileID();
                ShowRoom userInfo3 = this.delegate.getUserInfo();
                if (userInfo3 == null) {
                    Intrinsics.throwNpe();
                }
                profileID.setText(userInfo3.getUser().getFittsID());
                long userID = this.delegate.getAdapterSessionManager().getUserID();
                ShowRoom userInfo4 = this.delegate.getUserInfo();
                if (userInfo4 == null) {
                    Intrinsics.throwNpe();
                }
                if (userID == userInfo4.getUser().getId()) {
                    headerViewHolder.getModifyProfileImageButton().setVisibility(0);
                    headerViewHolder.getModifyProfileImageButton().setOnClickListener(new ShowRoomAdapter$onBindViewHolder$2(this));
                    headerViewHolder.getModifyProfileButton().setVisibility(0);
                    headerViewHolder.getModifyProfileButton().setOnClickListener(new ShowRoomAdapter$onBindViewHolder$3(this));
                    headerViewHolder.getFollowButton().setVisibility(8);
                } else {
                    headerViewHolder.getModifyProfileImageButton().setVisibility(8);
                    headerViewHolder.getModifyProfileButton().setVisibility(8);
                    ShowRoom userInfo5 = this.delegate.getUserInfo();
                    if (userInfo5 == null) {
                        Intrinsics.throwNpe();
                    }
                    boolean isFollowing = userInfo5.getUser().isFollowing();
                    if (isFollowing) {
                        headerViewHolder.getFollowButton().setText(this.context.getResources().getString(C0016R$string.following));
                        headerViewHolder.getFollowButton().setBackground(ContextCompat.getDrawable(this.context, C0008R$drawable.round_button_following));
                        headerViewHolder.getFollowButton().setTextColor(ContextCompat.getColor(this.context, C0006R$color.gray4));
                    } else if (!isFollowing) {
                        headerViewHolder.getFollowButton().setText(this.context.getResources().getString(C0016R$string.follow));
                        headerViewHolder.getFollowButton().setBackground(ContextCompat.getDrawable(this.context, C0008R$drawable.round_button_follow));
                        headerViewHolder.getFollowButton().setTextColor(ContextCompat.getColor(this.context, 17170443));
                    }
                    headerViewHolder.getFollowButton().setOnClickListener(new ShowRoomAdapter$onBindViewHolder$4(this));
                    headerViewHolder.getFollowButton().setVisibility(0);
                }
                ShowRoom userInfo6 = this.delegate.getUserInfo();
                if (userInfo6 == null) {
                    Intrinsics.throwNpe();
                }
                String str2 = "";
                if (!userInfo6.getUser().getStyles().isEmpty()) {
                    headerViewHolder.getProfileStyle().setText(CollectionsKt___CollectionsKt.joinToString$default(userInfo6.getUser().getStyles(), "    ", null, null, 0, null, null, 62, null));
                    Sdk27PropertiesKt.setTextColor(headerViewHolder.getProfileStyle(), ContextCompat.getColor(this.context, C0006R$color.gray6));
                    headerViewHolder.getProfileStyle().setTypeface(Typeface.DEFAULT_BOLD);
                } else {
                    TextView profileStyle = headerViewHolder.getProfileStyle();
                    String fittsID = this.delegate.getAdapterSessionManager().getFittsID();
                    ShowRoom userInfo7 = this.delegate.getUserInfo();
                    if (userInfo7 == null) {
                        Intrinsics.throwNpe();
                    }
                    profileStyle.setText(Intrinsics.areEqual((Object) fittsID, (Object) userInfo7.getUser().getFittsID()) ? "내 스타일을 골라주세요." : str2);
                    Sdk27PropertiesKt.setTextColor(headerViewHolder.getProfileStyle(), ContextCompat.getColor(this.context, C0006R$color.gray3));
                    headerViewHolder.getProfileStyle().setTypeface(Typeface.DEFAULT);
                }
                String showRoomIntro = userInfo6.getShowRoomIntro();
                if (showRoomIntro != null && !StringsKt__StringsJVMKt.isBlank(showRoomIntro)) {
                    z = false;
                }
                if (!z) {
                    headerViewHolder.getShowroomIntro().setText(userInfo6.getShowRoomIntro());
                    Sdk27PropertiesKt.setTextColor(headerViewHolder.getShowroomIntro(), ContextCompat.getColor(this.context, C0006R$color.gray6));
                } else {
                    TextView showroomIntro = headerViewHolder.getShowroomIntro();
                    String fittsID2 = this.delegate.getAdapterSessionManager().getFittsID();
                    ShowRoom userInfo8 = this.delegate.getUserInfo();
                    if (userInfo8 == null) {
                        Intrinsics.throwNpe();
                    }
                    if (Intrinsics.areEqual((Object) fittsID2, (Object) userInfo8.getUser().getFittsID())) {
                        str2 = "쇼룸의 소개 글을 입력해주세요.";
                    }
                    showroomIntro.setText(str2);
                    Sdk27PropertiesKt.setTextColor(headerViewHolder.getShowroomIntro(), ContextCompat.getColor(this.context, C0006R$color.gray3));
                }
                headerViewHolder.getPostCount().setText(String.valueOf(userInfo6.getUser().getPostsCount()));
                headerViewHolder.getFollowerCount().setText(String.valueOf(userInfo6.getUser().getFollowersCount()));
                headerViewHolder.getFollowingCount().setText(String.valueOf(userInfo6.getUser().getFollowingsCount()));
                headerViewHolder.getFollowingLayout().setOnClickListener(new ShowRoomAdapter$onBindViewHolder$5(this, userInfo6));
                headerViewHolder.getFollowersLayout().setOnClickListener(new ShowRoomAdapter$onBindViewHolder$6(this, userInfo6));
                return;
            }
            return;
        }
        String str3 = "inactive";
        if (viewHolder2 instanceof ShowroomPostListItemViewHolder) {
            Post item = getItem(i - 1);
            ShowroomPostListItemViewHolder showroomPostListItemViewHolder = (ShowroomPostListItemViewHolder) viewHolder2;
            showroomPostListItemViewHolder.getPostContent().setOnClickListener(new ShowRoomAdapter$onBindViewHolder$7(this, item));
            if (item.getCoverImage() != null) {
                ImageViewExtensionKt.loadImage(showroomPostListItemViewHolder.getCover(), item.getCoverImage().getUrl(), item.getCoverImage().getDominantColor());
            }
            if (StringsKt__StringsJVMKt.equals$default(item.getState(), str3, false, 2, null)) {
                showroomPostListItemViewHolder.getCoverImageViewForInactivity().setVisibility(0);
                showroomPostListItemViewHolder.getCoverIconForInactivity().setVisibility(0);
            } else {
                showroomPostListItemViewHolder.getCoverImageViewForInactivity().setVisibility(8);
                showroomPostListItemViewHolder.getCoverIconForInactivity().setVisibility(8);
            }
            showroomPostListItemViewHolder.getTitle().setText(item.getTitle());
            TextView viewCountTextView = showroomPostListItemViewHolder.getViewCountTextView();
            StringBuilder sb = new StringBuilder();
            sb.append("조회 ");
            sb.append(item.getViewCount());
            sb.append(47749);
            viewCountTextView.setText(sb.toString());
            if (item.getLinkInfo() != null) {
                LinkInfo linkInfo = item.getLinkInfo();
                if (linkInfo == null) {
                    Intrinsics.throwNpe();
                }
                if (linkInfo.getShop() != null) {
                    if (VERSION.SDK_INT >= 21) {
                        showroomPostListItemViewHolder.getProduct().setClipToOutline(true);
                    }
                    showroomPostListItemViewHolder.getProduct().setVisibility(0);
                    showroomPostListItemViewHolder.getShop().setVisibility(0);
                    ImageView product = showroomPostListItemViewHolder.getProduct();
                    LinkInfo linkInfo2 = item.getLinkInfo();
                    if (linkInfo2 != null) {
                        Product product2 = linkInfo2.getProduct();
                        if (product2 != null) {
                            str = product2.getImageUrl();
                        }
                    }
                    ImageViewExtensionKt.loadImage(product, str, (int) C0008R$drawable.shop_sample1);
                    LinkInfo linkInfo3 = item.getLinkInfo();
                    if (linkInfo3 == null) {
                        Intrinsics.throwNpe();
                    }
                    Shop shop = linkInfo3.getShop();
                    if (shop == null) {
                        Intrinsics.throwNpe();
                    }
                    if (shop.getName() != null) {
                        TextView shop2 = showroomPostListItemViewHolder.getShop();
                        LinkInfo linkInfo4 = item.getLinkInfo();
                        if (linkInfo4 == null) {
                            Intrinsics.throwNpe();
                        }
                        Shop shop3 = linkInfo4.getShop();
                        if (shop3 == null) {
                            Intrinsics.throwNpe();
                        }
                        String name = shop3.getName();
                        if (name == null) {
                            Intrinsics.throwNpe();
                        }
                        loadShop(shop2, name);
                    }
                } else {
                    showroomPostListItemViewHolder.getProduct().setVisibility(4);
                    showroomPostListItemViewHolder.getShop().setVisibility(8);
                }
            } else {
                showroomPostListItemViewHolder.getProduct().setVisibility(4);
                showroomPostListItemViewHolder.getShop().setVisibility(8);
            }
            loadDate(showroomPostListItemViewHolder.getCreateAt(), item.getCreatedAt());
            showroomPostListItemViewHolder.getLikeButton().setOnClickListener(new ShowRoomAdapter$onBindViewHolder$8(this, item));
            boolean isLiked = item.isLiked();
            if (isLiked) {
                showroomPostListItemViewHolder.getLikeImage().setBackgroundResource(C0008R$drawable.button_home_like);
                showroomPostListItemViewHolder.getLikeCount().setTextColor(ContextCompat.getColor(this.context, C0006R$color.point));
                showroomPostListItemViewHolder.getLikeCount().setTypeface(showroomPostListItemViewHolder.getLikeCount().getTypeface(), 1);
            } else if (!isLiked) {
                showroomPostListItemViewHolder.getLikeImage().setBackgroundResource(C0008R$drawable.button_home_unlike);
                showroomPostListItemViewHolder.getLikeCount().setTextColor(ContextCompat.getColor(this.context, C0006R$color.gray6));
                showroomPostListItemViewHolder.getLikeCount().setTypeface(Typeface.create(showroomPostListItemViewHolder.getLikeCount().getTypeface(), 0));
            }
            TextView likeCount = showroomPostListItemViewHolder.getLikeCount();
            UIExtensions uIExtensions = UIExtensions.INSTANCE;
            if (item.getUser().getId() != this.delegate.getAdapterSessionManager().getUserID()) {
                z = false;
            }
            likeCount.setText(uIExtensions.likeCountText(z, item.isLiked(), item.getLikesCount()));
        } else if (viewHolder2 instanceof ItemGridViewHolder) {
            Post item2 = getItem(i - 1);
            if (item2.getCoverImage() != null) {
                ImageViewExtensionKt.loadImageAsPost(((ItemGridViewHolder) viewHolder2).getPostCoverImage(), item2.getCoverImage().getUrl(), item2.getCoverImage().getDominantColor());
            }
            ItemGridViewHolder itemGridViewHolder = (ItemGridViewHolder) viewHolder2;
            itemGridViewHolder.getPostCoverImage().setOnClickListener(new ShowRoomAdapter$onBindViewHolder$9(this, item2));
            if (StringsKt__StringsJVMKt.equals$default(item2.getState(), str3, false, 2, null)) {
                itemGridViewHolder.getInactivePost().setVisibility(0);
                itemGridViewHolder.getInactivePostIcon().setVisibility(0);
                return;
            }
            itemGridViewHolder.getInactivePost().setVisibility(8);
            itemGridViewHolder.getInactivePostIcon().setVisibility(8);
        } else if (!(viewHolder2 instanceof ItemEmptyViewHolder)) {
        } else {
            if (this.delegate.getUserInfo() instanceof ShowRoom) {
                ItemEmptyViewHolder itemEmptyViewHolder = (ItemEmptyViewHolder) viewHolder2;
                itemEmptyViewHolder.getLoadingProgress().setVisibility(8);
                String fittsID3 = this.delegate.getAdapterSessionManager().getFittsID();
                ShowRoom userInfo9 = this.delegate.getUserInfo();
                if (userInfo9 == null) {
                    Intrinsics.throwNpe();
                }
                if (Intrinsics.areEqual((Object) fittsID3, (Object) userInfo9.getUser().getFittsID())) {
                    itemEmptyViewHolder.getEmptyContent().setVisibility(0);
                    itemEmptyViewHolder.getEmptyCreatePost().setOnClickListener(new ShowRoomAdapter$onBindViewHolder$10(this));
                    return;
                }
                itemEmptyViewHolder.getEmptyContent().setVisibility(8);
                return;
            }
            ((ItemEmptyViewHolder) viewHolder2).getLoadingProgress().setVisibility(0);
        }
    }

    @SuppressLint({"SetTextI18n"})
    private final void loadDate(TextView textView, String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.getDefault());
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("M월 d일", Locale.getDefault());
        Date date = new Date(System.currentTimeMillis());
        Date parse = simpleDateFormat.parse(str);
        Intrinsics.checkExpressionValueIsNotNull(parse, "dateFormat.parse(text)");
        long time = date.getTime() - parse.getTime();
        if (time < 60000) {
            textView.setText("방금 전");
        } else if (time < 3600000) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf(time / 60000));
            sb.append("분 전");
            textView.setText(sb.toString());
        } else if (time < 86400000) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(String.valueOf(time / 3600000));
            sb2.append("시간 전");
            textView.setText(sb2.toString());
        } else if (time < 604800000) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(String.valueOf(time / 86400000));
            sb3.append("일 전");
            textView.setText(sb3.toString());
        } else {
            textView.setText(simpleDateFormat2.format(parse).toString());
        }
    }

    @SuppressLint({"SetTextI18n"})
    private final void loadShop(TextView textView, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append('\'');
        sb.append(str);
        sb.append("'에서 구매");
        textView.setText(sb.toString());
    }
}
