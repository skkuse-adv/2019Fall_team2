package kr.co.popone.fitts.feature.collection;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0006R$color;
import kr.co.popone.fitts.C0008R$drawable;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.C0016R$string;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.feature.search.LoadingListItemViewHolder;
import kr.co.popone.fitts.model.collection.CollectionAPI.CollectionDetailResponse;
import kr.co.popone.fitts.model.collection.CollectionAPI.CollectionDetailResponse.ButtonProperties;
import kr.co.popone.fitts.model.collection.CollectionAPI.CollectionEntry;
import kr.co.popone.fitts.model.datamodel.commerce.Product;
import kr.co.popone.fitts.model.datamodel.commerce.Shop;
import kr.co.popone.fitts.model.post.PostAPI.LinkInfo;
import kr.co.popone.fitts.model.post.PostAPI.Post;
import kr.co.popone.fitts.ui.ImageViewExtensionKt;
import kr.co.popone.fitts.ui.ViewExtensionsKt;
import kr.co.popone.fitts.utils.UIExtensions;
import org.jetbrains.anko.Sdk27ServicesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class PromotionCollectionAdapter extends Adapter<ViewHolder> {
    @NotNull
    private List<CollectionEntry> collectionItems;
    @Nullable
    private CollectionDetailResponse collectionResponse;
    private final Context context;
    /* access modifiers changed from: private */
    public final Delegate delegate;
    private final OnClickListener followButtonListener;
    private final OnClickListener likeButtonListener;
    private final OnClickListener onActionButtonClicked;
    private final SessionManager sessionManager;
    private final OnClickListener showPostClickListener;
    private final OnClickListener showShowroomClickListener;
    private boolean showsLoading;
    private final Point windowSize = new Point();

    public interface Delegate {
        @Nullable
        String getFittsID();

        void onActionButtonClicked();

        void onFollowButtonClicked(int i);

        void onLikeButtonClicked(int i);

        void showPost(int i);

        void showShowroom(int i);
    }

    public static final class HeaderViewHolder extends ViewHolder {
        @NotNull
        private final Button actionButton;
        @NotNull
        private final ImageView coverImageView;
        @NotNull
        private final TextView titleTextView;

        public HeaderViewHolder(@NotNull View view) {
            Intrinsics.checkParameterIsNotNull(view, "view");
            super(view);
            View findViewById = view.findViewById(C0010R$id.coverImageView);
            Intrinsics.checkExpressionValueIsNotNull(findViewById, "view.findViewById(R.id.coverImageView)");
            this.coverImageView = (ImageView) findViewById;
            View findViewById2 = view.findViewById(C0010R$id.actionButton);
            Intrinsics.checkExpressionValueIsNotNull(findViewById2, "view.findViewById(R.id.actionButton)");
            this.actionButton = (Button) findViewById2;
            View findViewById3 = view.findViewById(C0010R$id.titleTextView);
            Intrinsics.checkExpressionValueIsNotNull(findViewById3, "view.findViewById(R.id.titleTextView)");
            this.titleTextView = (TextView) findViewById3;
        }

        @NotNull
        public final ImageView getCoverImageView() {
            return this.coverImageView;
        }

        @NotNull
        public final Button getActionButton() {
            return this.actionButton;
        }

        @NotNull
        public final TextView getTitleTextView() {
            return this.titleTextView;
        }
    }

    public PromotionCollectionAdapter(@NotNull Context context2, @NotNull SessionManager sessionManager2, @NotNull Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(context2, "context");
        Intrinsics.checkParameterIsNotNull(sessionManager2, "sessionManager");
        Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
        this.context = context2;
        this.sessionManager = sessionManager2;
        this.delegate = delegate2;
        Sdk27ServicesKt.getWindowManager(this.context).getDefaultDisplay().getSize(this.windowSize);
        this.showShowroomClickListener = new PromotionCollectionAdapter$showShowroomClickListener$1(this);
        this.showPostClickListener = new PromotionCollectionAdapter$showPostClickListener$1(this);
        this.followButtonListener = new PromotionCollectionAdapter$followButtonListener$1(this);
        this.likeButtonListener = new PromotionCollectionAdapter$likeButtonListener$1(this);
        this.onActionButtonClicked = new PromotionCollectionAdapter$onActionButtonClicked$1(this);
        this.collectionItems = CollectionsKt__CollectionsKt.emptyList();
    }

    public final boolean getShowsLoading() {
        return this.showsLoading;
    }

    public final void setShowsLoading(boolean z) {
        if (this.showsLoading != z) {
            this.showsLoading = z;
            notifyDataSetChanged();
        }
    }

    @Nullable
    public final CollectionDetailResponse getCollectionResponse() {
        return this.collectionResponse;
    }

    public final void setCollectionResponse(@Nullable CollectionDetailResponse collectionDetailResponse) {
        this.collectionResponse = collectionDetailResponse;
        notifyDataSetChanged();
    }

    @NotNull
    public final List<CollectionEntry> getCollectionItems() {
        return this.collectionItems;
    }

    public final void setCollectionItems(@NotNull List<CollectionEntry> list) {
        Intrinsics.checkParameterIsNotNull(list, "value");
        this.collectionItems = list;
        notifyDataSetChanged();
    }

    public final void notifyCollectionItemChanged(int i) {
        notifyItemChanged(i + 1);
    }

    public void onBindViewHolder(@NotNull ViewHolder viewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
        CollectionDetailResponse collectionDetailResponse = this.collectionResponse;
        String str = null;
        if (viewHolder instanceof HeaderViewHolder) {
            if (collectionDetailResponse != null) {
                int i2 = this.windowSize.x;
                float f = (float) 0;
                int roundToInt = collectionDetailResponse.getMainImageRatio() > f ? MathKt__MathJVMKt.roundToInt(((float) i2) / collectionDetailResponse.getMainImageRatio()) : 0;
                if (roundToInt > UIExtensions.INSTANCE.getMaxTexturesSize()) {
                    roundToInt = UIExtensions.INSTANCE.getMaxTexturesSize();
                    i2 = MathKt__MathJVMKt.roundToInt(((float) roundToInt) * collectionDetailResponse.getMainImageRatio());
                }
                HeaderViewHolder headerViewHolder = (HeaderViewHolder) viewHolder;
                Glide.with(this.context).load(collectionDetailResponse.getMainImageUrl()).apply(new RequestOptions().override(i2, roundToInt)).into(headerViewHolder.getCoverImageView());
                headerViewHolder.getCoverImageView().getLayoutParams().height = collectionDetailResponse.getMainImageRatio() > f ? MathKt__MathJVMKt.roundToInt(((float) this.windowSize.x) / collectionDetailResponse.getMainImageRatio()) : 0;
                ButtonProperties buttonProperties = collectionDetailResponse.getButtonProperties();
                if (buttonProperties != null) {
                    headerViewHolder.getActionButton().setText(buttonProperties.getTitle());
                    headerViewHolder.getActionButton().setTextSize(2, (float) buttonProperties.getFontSize());
                    headerViewHolder.getActionButton().setTextColor(Color.parseColor(buttonProperties.getTextColor()));
                    Drawable background = headerViewHolder.getActionButton().getBackground();
                    if (background != null) {
                        ((GradientDrawable) background).setColor(Color.parseColor(buttonProperties.getBackgroundColor()));
                        headerViewHolder.getActionButton().setVisibility(0);
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
                    }
                } else {
                    headerViewHolder.getActionButton().setVisibility(4);
                }
                headerViewHolder.getTitleTextView().setText(collectionDetailResponse.getTitle());
                return;
            }
            HeaderViewHolder headerViewHolder2 = (HeaderViewHolder) viewHolder;
            headerViewHolder2.getCoverImageView().getLayoutParams().height = 0;
            headerViewHolder2.getCoverImageView().setImageDrawable(null);
            headerViewHolder2.getActionButton().setVisibility(4);
        } else if (viewHolder instanceof PromotionCollectionListItemViewHolder) {
            boolean z = true;
            int i3 = i - 1;
            Post post = ((CollectionEntry) this.collectionItems.get(i3)).getPost();
            if (post == null) {
                Intrinsics.throwNpe();
            }
            PromotionCollectionListItemViewHolder promotionCollectionListItemViewHolder = (PromotionCollectionListItemViewHolder) viewHolder;
            promotionCollectionListItemViewHolder.getPostContent().setTag(Integer.valueOf(i3));
            BaseRequestOptions error = ((RequestOptions) new RequestOptions().placeholder((int) C0008R$drawable.image_default_profile)).error((int) C0008R$drawable.image_default_profile);
            Intrinsics.checkExpressionValueIsNotNull(error, "RequestOptions().placeho…le.image_default_profile)");
            RequestOptions requestOptions = (RequestOptions) error;
            String str2 = "deactivated";
            if (Intrinsics.areEqual((Object) post.getUser().getStatus(), (Object) str2)) {
                Glide.with(this.context).load(Integer.valueOf(C0008R$drawable.image_default_profile)).apply((BaseRequestOptions<?>) requestOptions).into((ImageView) promotionCollectionListItemViewHolder.getProfileImage());
            } else {
                Glide.with(this.context).load(post.getUser().getProfileImageUrl()).apply((BaseRequestOptions<?>) requestOptions).into((ImageView) promotionCollectionListItemViewHolder.getProfileImage());
            }
            if (!Intrinsics.areEqual((Object) post.getUser().getStatus(), (Object) str2)) {
                promotionCollectionListItemViewHolder.getProfileImage().setBackgroundResource(C0008R$drawable.fitts_profile);
                promotionCollectionListItemViewHolder.getProfileImage().setEnabled(true);
            } else {
                promotionCollectionListItemViewHolder.getProfileImage().setBackgroundColor(Color.parseColor("#FFFFFF"));
                promotionCollectionListItemViewHolder.getProfileImage().setEnabled(false);
            }
            promotionCollectionListItemViewHolder.getProfileImage().setExtraData(Integer.valueOf(i3));
            promotionCollectionListItemViewHolder.getFittsId().setText(post.getUser().getFittsID());
            promotionCollectionListItemViewHolder.getBlueDotView().setVisibility(post.getUser().isSuitable() ? 0 : 8);
            promotionCollectionListItemViewHolder.getFollowButton().setTag(Integer.valueOf(i3));
            boolean isFollowing = post.getUser().isFollowing();
            if (isFollowing) {
                promotionCollectionListItemViewHolder.getFollowButton().setText(this.context.getResources().getString(C0016R$string.following));
                promotionCollectionListItemViewHolder.getFollowButton().setTextColor(ContextCompat.getColor(this.context, C0006R$color.gray1));
            } else if (!isFollowing) {
                promotionCollectionListItemViewHolder.getFollowButton().setText(this.context.getResources().getString(C0016R$string.follow));
                promotionCollectionListItemViewHolder.getFollowButton().setTextColor(ContextCompat.getColor(this.context, C0006R$color.point));
            }
            if (Intrinsics.areEqual((Object) this.delegate.getFittsID(), (Object) post.getUser().getFittsID())) {
                promotionCollectionListItemViewHolder.getFollowButton().setVisibility(8);
            } else {
                promotionCollectionListItemViewHolder.getFollowButton().setVisibility(0);
            }
            if (post.getCoverImage() != null) {
                ImageViewExtensionKt.loadImage(promotionCollectionListItemViewHolder.getCover(), post.getCoverImage().getUrl(), post.getCoverImage().getDominantColor());
            }
            promotionCollectionListItemViewHolder.getTitle().setText(post.getTitle());
            TextView viewCountTextView = promotionCollectionListItemViewHolder.getViewCountTextView();
            StringBuilder sb = new StringBuilder();
            sb.append("조회 ");
            sb.append(post.getViewCount());
            sb.append(47749);
            viewCountTextView.setText(sb.toString());
            if (post.getLinkInfo() != null) {
                LinkInfo linkInfo = post.getLinkInfo();
                if (linkInfo == null) {
                    Intrinsics.throwNpe();
                }
                if (linkInfo.getShop() != null) {
                    if (VERSION.SDK_INT >= 21) {
                        promotionCollectionListItemViewHolder.getProduct().setClipToOutline(true);
                    }
                    promotionCollectionListItemViewHolder.getProduct().setVisibility(0);
                    promotionCollectionListItemViewHolder.getShop().setVisibility(0);
                    ImageView product = promotionCollectionListItemViewHolder.getProduct();
                    LinkInfo linkInfo2 = post.getLinkInfo();
                    if (linkInfo2 != null) {
                        Product product2 = linkInfo2.getProduct();
                        if (product2 != null) {
                            str = product2.getImageUrl();
                        }
                    }
                    ImageViewExtensionKt.loadImage(product, str, (int) C0008R$drawable.shop_sample1);
                    LinkInfo linkInfo3 = post.getLinkInfo();
                    if (linkInfo3 == null) {
                        Intrinsics.throwNpe();
                    }
                    Shop shop = linkInfo3.getShop();
                    if (shop == null) {
                        Intrinsics.throwNpe();
                    }
                    if (shop.getName() != null) {
                        TextView shop2 = promotionCollectionListItemViewHolder.getShop();
                        LinkInfo linkInfo4 = post.getLinkInfo();
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
                        promotionCollectionListItemViewHolder.loadShop(shop2, name);
                    }
                } else {
                    promotionCollectionListItemViewHolder.getProduct().setVisibility(4);
                    promotionCollectionListItemViewHolder.getShop().setVisibility(8);
                }
            } else {
                promotionCollectionListItemViewHolder.getProduct().setVisibility(4);
                promotionCollectionListItemViewHolder.getShop().setVisibility(8);
            }
            promotionCollectionListItemViewHolder.loadDate(promotionCollectionListItemViewHolder.getCreateAt(), post.getCreatedAt());
            promotionCollectionListItemViewHolder.getLikeButton().setTag(Integer.valueOf(i3));
            boolean isLiked = post.isLiked();
            if (isLiked) {
                promotionCollectionListItemViewHolder.getLikeImage().setBackgroundResource(C0008R$drawable.button_home_like);
                promotionCollectionListItemViewHolder.getLikeCount().setTextColor(ContextCompat.getColor(this.context, C0006R$color.point));
                promotionCollectionListItemViewHolder.getLikeCount().setTypeface(promotionCollectionListItemViewHolder.getLikeCount().getTypeface(), 1);
            } else if (!isLiked) {
                promotionCollectionListItemViewHolder.getLikeImage().setBackgroundResource(C0008R$drawable.button_home_unlike);
                promotionCollectionListItemViewHolder.getLikeCount().setTextColor(ContextCompat.getColor(this.context, C0006R$color.gray6));
                promotionCollectionListItemViewHolder.getLikeCount().setTypeface(Typeface.create(promotionCollectionListItemViewHolder.getLikeCount().getTypeface(), 0));
            }
            TextView likeCount = promotionCollectionListItemViewHolder.getLikeCount();
            UIExtensions uIExtensions = UIExtensions.INSTANCE;
            if (post.getUser().getId() != this.sessionManager.getUserID()) {
                z = false;
            }
            likeCount.setText(uIExtensions.likeCountText(z, post.isLiked(), post.getLikesCount()));
        }
    }

    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        String str = "view";
        if (i == 0) {
            View inflate = LayoutInflater.from(this.context).inflate(C0013R$layout.item_promotion_collection_header, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, str);
            HeaderViewHolder headerViewHolder = new HeaderViewHolder(inflate);
            headerViewHolder.getActionButton().setOnClickListener(this.onActionButtonClicked);
            return headerViewHolder;
        } else if (i == 1) {
            View inflate2 = LayoutInflater.from(this.context).inflate(C0013R$layout.item_promotion_collection, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate2, str);
            PromotionCollectionListItemViewHolder promotionCollectionListItemViewHolder = new PromotionCollectionListItemViewHolder(inflate2);
            promotionCollectionListItemViewHolder.getPostContent().setOnClickListener(this.showPostClickListener);
            promotionCollectionListItemViewHolder.getProfileImage().setOnClickListener(this.showShowroomClickListener);
            promotionCollectionListItemViewHolder.getFollowButton().setOnClickListener(this.followButtonListener);
            promotionCollectionListItemViewHolder.getLikeButton().setOnClickListener(this.likeButtonListener);
            ViewExtensionsKt.getMarginLayoutParams(promotionCollectionListItemViewHolder.getCoverImageLayout()).setMargins(ViewExtensionsKt.dpToPx(inflate2, 24), 0, ViewExtensionsKt.dpToPx(inflate2, 24), 0);
            return promotionCollectionListItemViewHolder;
        } else if (i == 2) {
            View inflate3 = LayoutInflater.from(this.context).inflate(C0013R$layout.loading_list_item, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate3, str);
            return new LoadingListItemViewHolder(inflate3);
        } else {
            throw new IllegalAccessException();
        }
    }

    public int getItemCount() {
        return this.collectionItems.size() + (this.showsLoading ? 2 : 1);
    }

    public int getItemViewType(int i) {
        if (i == 0) {
            return 0;
        }
        return i <= this.collectionItems.size() ? 1 : 2;
    }
}
