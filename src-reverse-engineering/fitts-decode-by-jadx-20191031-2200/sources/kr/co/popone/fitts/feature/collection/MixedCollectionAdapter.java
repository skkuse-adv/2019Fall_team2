package kr.co.popone.fitts.feature.collection;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Point;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0006R$color;
import kr.co.popone.fitts.C0008R$drawable;
import kr.co.popone.fitts.C0009R$font;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.C0016R$string;
import kr.co.popone.fitts.feature.base.EmptyTypeHolder;
import kr.co.popone.fitts.model.collection.CollectionAPI.CollectionDetailResponse;
import kr.co.popone.fitts.model.collection.CollectionAPI.CollectionEntry;
import kr.co.popone.fitts.model.collection.CollectionAPI.CollectionImage;
import kr.co.popone.fitts.model.collection.CollectionAPI.CollectionType;
import kr.co.popone.fitts.model.datamodel.service.user.BodyInfo;
import kr.co.popone.fitts.model.datamodel.service.user.BodyType;
import kr.co.popone.fitts.model.datamodel.service.user.User;
import kr.co.popone.fitts.model.post.PostAPI.Post;
import kr.co.popone.fitts.model.product.Product;
import kr.co.popone.fitts.ui.FittsCircleImageView;
import kr.co.popone.fitts.ui.ImageViewExtensionKt;
import kr.co.popone.fitts.ui.ViewExtensionsKt;
import kr.co.popone.fitts.ui.decorator.MixedProductThreeDecorator;
import kr.co.popone.fitts.ui.decorator.MixedProductTwoDecorator;
import kr.co.popone.fitts.ui.decorator.RecyclerDecorator;
import kr.co.popone.fitts.ui.decorator.RecyclerDecorator.Builder;
import kr.co.popone.fitts.ui.decorator.RecyclerDecorator.DecoratorType;
import kr.co.popone.fitts.utils.UIExtensions;
import org.jetbrains.anko.Sdk27ServicesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class MixedCollectionAdapter extends Adapter<ViewHolder> {
    public static final Companion Companion = new Companion(null);
    private CollectionDetailResponse collectionDetail;
    @NotNull
    private final Context context;
    @NotNull
    private final Delegate delegate;
    /* access modifiers changed from: private */
    public final ArrayList<CollectionEntry> items = new ArrayList<>();

    public interface Delegate extends kr.co.popone.fitts.feature.collection.PostsTypeAdapter.Delegate, kr.co.popone.fitts.feature.feeds.ProductRectangleFeedHolder.Delegate, kr.co.popone.fitts.feature.feeds.ProductSquareFeedHolder.Delegate {
        void bannerClicked(int i);

        void onFollowClicked(int i);

        void onProfileClicked(int i);

        void productClicked(@NotNull String str);

        void showSnackBar(@NotNull String str);
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final class CoverTypeHolder extends ViewHolder {
        final /* synthetic */ MixedCollectionAdapter this$0;

        public CoverTypeHolder(@NotNull MixedCollectionAdapter mixedCollectionAdapter, View view) {
            Intrinsics.checkParameterIsNotNull(view, "itemView");
            this.this$0 = mixedCollectionAdapter;
            super(view);
        }

        public final void init(@NotNull CollectionDetailResponse collectionDetailResponse) {
            Intrinsics.checkParameterIsNotNull(collectionDetailResponse, "cover");
            View view = this.itemView;
            Pair access$getImageHeight = this.this$0.getImageHeight((double) collectionDetailResponse.getMainImageRatio());
            Glide.with(this.this$0.getContext()).load(collectionDetailResponse.getMainImageUrl()).apply(((RequestOptions) new RequestOptions().override(((Number) access$getImageHeight.getFirst()).intValue(), ((Number) access$getImageHeight.getSecond()).intValue())).diskCacheStrategy(DiskCacheStrategy.RESOURCE)).into((ImageView) view.findViewById(C0010R$id.bannerImageView));
            ImageView imageView = (ImageView) view.findViewById(C0010R$id.bannerImageView);
            Intrinsics.checkExpressionValueIsNotNull(imageView, "bannerImageView");
            imageView.getLayoutParams().height = this.this$0.getResizeHeight((double) collectionDetailResponse.getMainImageRatio());
        }

        public final void clear() {
            View view = this.itemView;
            String str = "itemView";
            Intrinsics.checkExpressionValueIsNotNull(view, str);
            RequestManager with = Glide.with(view.getContext());
            View view2 = this.itemView;
            Intrinsics.checkExpressionValueIsNotNull(view2, str);
            with.clear((View) (ImageView) view2.findViewById(C0010R$id.bannerImageView));
        }
    }

    public final class FittieTypeHolder extends ViewHolder {
        final /* synthetic */ MixedCollectionAdapter this$0;

        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0 = new int[BodyType.values().length];

            static {
                $EnumSwitchMapping$0[BodyType.TRIANGLE.ordinal()] = 1;
                $EnumSwitchMapping$0[BodyType.INVERTED_TRIANGLE.ordinal()] = 2;
                $EnumSwitchMapping$0[BodyType.RECTANGLE.ordinal()] = 3;
                $EnumSwitchMapping$0[BodyType.HOURGLASS.ordinal()] = 4;
                $EnumSwitchMapping$0[BodyType.NORMAL.ordinal()] = 5;
            }
        }

        public FittieTypeHolder(@NotNull MixedCollectionAdapter mixedCollectionAdapter, View view) {
            Intrinsics.checkParameterIsNotNull(view, "itemView");
            this.this$0 = mixedCollectionAdapter;
            super(view);
        }

        @Nullable
        public final Unit init(int i) {
            String str;
            View view = this.itemView;
            User user = ((CollectionEntry) this.this$0.items.get(i)).getUser();
            if (user == null) {
                return null;
            }
            TextView textView = (TextView) view.findViewById(C0010R$id.userIdTextView);
            Intrinsics.checkExpressionValueIsNotNull(textView, "userIdTextView");
            textView.setText(user.getFittsID());
            ImageView imageView = (ImageView) view.findViewById(C0010R$id.bodyTypeImageView);
            BodyInfo bodyInfo = user.getBodyInfo();
            if (bodyInfo == null) {
                Intrinsics.throwNpe();
            }
            int i2 = WhenMappings.$EnumSwitchMapping$0[bodyInfo.getBodyType().ordinal()];
            if (i2 == 1) {
                imageView.setImageResource(C0008R$drawable.image_profile_triangle);
            } else if (i2 == 2) {
                imageView.setImageResource(C0008R$drawable.image_profile_invert);
            } else if (i2 == 3) {
                imageView.setImageResource(C0008R$drawable.image_profile_rectangle);
            } else if (i2 == 4) {
                imageView.setImageResource(C0008R$drawable.image_profile_hourglass);
            } else if (i2 == 5) {
                imageView.setImageResource(C0008R$drawable.image_profile_regular);
            }
            BodyInfo bodyInfo2 = user.getBodyInfo();
            if (bodyInfo2 != null) {
                TextView textView2 = (TextView) view.findViewById(C0010R$id.userFormTextView);
                Intrinsics.checkExpressionValueIsNotNull(textView2, "userFormTextView");
                String top = bodyInfo2.getTop();
                if (!(top == null || StringsKt__StringsJVMKt.isBlank(top))) {
                    String bottom = bodyInfo2.getBottom();
                    if (!(bottom == null || StringsKt__StringsJVMKt.isBlank(bottom))) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(bodyInfo2.getHeight());
                        String str2 = " . ";
                        sb.append(str2);
                        sb.append(bodyInfo2.getTop());
                        sb.append(str2);
                        sb.append(bodyInfo2.getBottom());
                        sb.append(' ');
                        str = sb.toString();
                        textView2.setText(str);
                    }
                }
                str = String.valueOf(bodyInfo2.getHeight());
                textView2.setText(str);
            }
            String str3 = "profileImageView";
            if (!Intrinsics.areEqual((Object) user.getStatus(), (Object) "deactivated")) {
                ((FittsCircleImageView) view.findViewById(C0010R$id.profileImageView)).setBackgroundResource(C0008R$drawable.fitts_profile);
                FittsCircleImageView fittsCircleImageView = (FittsCircleImageView) view.findViewById(C0010R$id.profileImageView);
                Intrinsics.checkExpressionValueIsNotNull(fittsCircleImageView, str3);
                fittsCircleImageView.setEnabled(true);
            } else {
                ((FittsCircleImageView) view.findViewById(C0010R$id.profileImageView)).setBackgroundColor(Color.parseColor("#FFFFFF"));
                FittsCircleImageView fittsCircleImageView2 = (FittsCircleImageView) view.findViewById(C0010R$id.profileImageView);
                Intrinsics.checkExpressionValueIsNotNull(fittsCircleImageView2, str3);
                fittsCircleImageView2.setEnabled(false);
            }
            if (user.isFollowing()) {
                updateFollowButton(C0016R$string.following, C0006R$color.gray4, C0008R$drawable.round_button_following, C0009R$font.kopubdotum_pro_medium);
            } else {
                updateFollowButton(C0016R$string.follow, 17170443, C0008R$drawable.round_button_follow, C0009R$font.kopubdotum_pro_bold);
            }
            BaseRequestOptions error = ((RequestOptions) new RequestOptions().placeholder((int) C0008R$drawable.image_default_profile)).error((int) C0008R$drawable.image_default_profile);
            Intrinsics.checkExpressionValueIsNotNull(error, "RequestOptions().placeho…le.image_default_profile)");
            Glide.with(this.this$0.getContext()).load(user.getProfileImageUrl()).apply((BaseRequestOptions<?>) (RequestOptions) error).into((ImageView) (FittsCircleImageView) view.findViewById(C0010R$id.profileImageView));
            ((FittsCircleImageView) view.findViewById(C0010R$id.profileImageView)).setOnClickListener(new MixedCollectionAdapter$FittieTypeHolder$init$$inlined$with$lambda$1(view, this, i));
            ((ConstraintLayout) view.findViewById(C0010R$id.profileLayout)).setOnClickListener(new MixedCollectionAdapter$FittieTypeHolder$init$$inlined$with$lambda$2(view, this, i));
            ((TextView) view.findViewById(C0010R$id.followButton)).setOnClickListener(new MixedCollectionAdapter$FittieTypeHolder$init$$inlined$with$lambda$3(view, this, i));
            return Unit.INSTANCE;
        }

        public final TextView updateFollowButton(int i, int i2, int i3, int i4) {
            TextView textView = (TextView) this.itemView.findViewById(C0010R$id.followButton);
            Context context = textView.getContext();
            Intrinsics.checkExpressionValueIsNotNull(context, "context");
            textView.setText(context.getResources().getString(i));
            textView.setTextColor(ContextCompat.getColor(textView.getContext(), i2));
            textView.setBackground(ContextCompat.getDrawable(textView.getContext(), i3));
            textView.setTypeface(ResourcesCompat.getFont(textView.getContext(), i4));
            return textView;
        }

        public final void enableFollowButton() {
            TextView textView = (TextView) this.itemView.findViewById(C0010R$id.followButton);
            Intrinsics.checkExpressionValueIsNotNull(textView, "followButton");
            textView.setEnabled(true);
        }
    }

    public final class ImageTypeHolder extends ViewHolder {
        final /* synthetic */ MixedCollectionAdapter this$0;

        public ImageTypeHolder(@NotNull MixedCollectionAdapter mixedCollectionAdapter, View view) {
            Intrinsics.checkParameterIsNotNull(view, "itemView");
            this.this$0 = mixedCollectionAdapter;
            super(view);
        }

        @Nullable
        public final ImageView init(int i) {
            View view = this.itemView;
            CollectionImage image = ((CollectionEntry) this.this$0.items.get(i)).getImage();
            if (image == null) {
                return null;
            }
            ImageView imageView = (ImageView) view.findViewById(C0010R$id.bannerImageView);
            ImageViewExtensionKt.loadImageWithRatio(imageView, image.getUrl(), (float) image.getRatio());
            imageView.getLayoutParams().height = this.this$0.getResizeHeight(image.getRatio());
            imageView.setOnClickListener(new MixedCollectionAdapter$ImageTypeHolder$init$$inlined$with$lambda$1(image, view, this, i));
            return imageView;
        }

        public final void clear() {
            View view = this.itemView;
            String str = "itemView";
            Intrinsics.checkExpressionValueIsNotNull(view, str);
            RequestManager with = Glide.with(view.getContext());
            View view2 = this.itemView;
            Intrinsics.checkExpressionValueIsNotNull(view2, str);
            with.clear((View) (ImageView) view2.findViewById(C0010R$id.bannerImageView));
        }
    }

    public final class PostsTypeHolder extends ViewHolder {
        @NotNull
        public GridLayoutManager layoutManager;
        private final RecyclerDecorator postDoubleDecorator = new Builder().decoratorType(DecoratorType.DOUBLE).doubleLeftDecorator(18, 0, 8, 4).doubleRightDecorator(18, 0, 4, 8).build();
        private final RecyclerDecorator postTripleDecorator = new Builder().decoratorType(DecoratorType.TRIPLE).tripleLeftDecorator(4, 0, 8, 0).tripleCenterDecorator(4, 0, 4, 4).tripleRightDecorator(4, 0, 0, 8).build();
        private PostsTypeAdapter postsTypeAdapter;
        final /* synthetic */ MixedCollectionAdapter this$0;

        public PostsTypeHolder(@NotNull MixedCollectionAdapter mixedCollectionAdapter, View view) {
            Intrinsics.checkParameterIsNotNull(view, "itemView");
            this.this$0 = mixedCollectionAdapter;
            super(view);
        }

        @NotNull
        public final GridLayoutManager getLayoutManager() {
            GridLayoutManager gridLayoutManager = this.layoutManager;
            if (gridLayoutManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
            }
            return gridLayoutManager;
        }

        public final void setLayoutManager(@NotNull GridLayoutManager gridLayoutManager) {
            Intrinsics.checkParameterIsNotNull(gridLayoutManager, "<set-?>");
            this.layoutManager = gridLayoutManager;
        }

        public final void init(int i, @NotNull ArrayList<Post> arrayList) {
            Intrinsics.checkParameterIsNotNull(arrayList, "posts");
            View view = this.itemView;
            this.postsTypeAdapter = new PostsTypeAdapter(i, this.this$0.getDelegate());
            RecyclerView recyclerView = (RecyclerView) view.findViewById(C0010R$id.postsRecyclerView);
            PostsTypeAdapter postsTypeAdapter2 = this.postsTypeAdapter;
            String str = "postsTypeAdapter";
            if (postsTypeAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(str);
            }
            recyclerView.setAdapter(postsTypeAdapter2);
            recyclerView.setLayoutManager(new GridLayoutManager(this.this$0.getContext(), i));
            if (recyclerView.getItemDecorationCount() < 1) {
                if (i != 3) {
                    recyclerView.addItemDecoration(this.postDoubleDecorator);
                } else {
                    recyclerView.addItemDecoration(this.postTripleDecorator);
                }
            }
            PostsTypeAdapter postsTypeAdapter3 = this.postsTypeAdapter;
            if (postsTypeAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(str);
            }
            postsTypeAdapter3.addAll(arrayList);
        }

        public final void clear() {
            RecyclerView recyclerView = (RecyclerView) this.itemView.findViewById(C0010R$id.postsRecyclerView);
            Intrinsics.checkExpressionValueIsNotNull(recyclerView, "postsRecyclerView");
            recyclerView.setAdapter(null);
        }
    }

    public final class ProductsTypeHolder extends ViewHolder {
        final /* synthetic */ MixedCollectionAdapter this$0;

        public ProductsTypeHolder(@NotNull MixedCollectionAdapter mixedCollectionAdapter, View view) {
            Intrinsics.checkParameterIsNotNull(view, "itemView");
            this.this$0 = mixedCollectionAdapter;
            super(view);
        }

        public final void bind(@NotNull List<Product> list, int i) {
            Intrinsics.checkParameterIsNotNull(list, "products");
            View view = this.itemView;
            String str = "this";
            if (i < 1) {
                Intrinsics.checkExpressionValueIsNotNull(view, str);
                ViewExtensionsKt.gone(view);
                return;
            }
            Intrinsics.checkExpressionValueIsNotNull(view, str);
            ViewExtensionsKt.visible(view);
            RecyclerView recyclerView = (RecyclerView) view.findViewById(C0010R$id.postsRecyclerView);
            recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(), i));
            recyclerView.setAdapter(new MixedCollectionProductAdapter(i, this.this$0.getDelegate()));
            Adapter adapter = recyclerView.getAdapter();
            if (adapter != null) {
                ((MixedCollectionProductAdapter) adapter).setItems(list);
                if (recyclerView.getItemDecorationCount() > 0) {
                    recyclerView.removeItemDecorationAt(0);
                }
                if (i == 2) {
                    recyclerView.addItemDecoration(new MixedProductTwoDecorator());
                } else if (i == 3) {
                    recyclerView.addItemDecoration(new MixedProductThreeDecorator());
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kr.co.popone.fitts.feature.collection.MixedCollectionProductAdapter");
            }
        }

        public final void clear() {
            RecyclerView recyclerView = (RecyclerView) this.itemView.findViewById(C0010R$id.postsRecyclerView);
            Intrinsics.checkExpressionValueIsNotNull(recyclerView, "postsRecyclerView");
            recyclerView.setAdapter(null);
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = new int[CollectionType.values().length];

        static {
            $EnumSwitchMapping$0[CollectionType.IMAGE.ordinal()] = 1;
            $EnumSwitchMapping$0[CollectionType.FITTIE.ordinal()] = 2;
            $EnumSwitchMapping$0[CollectionType.POSTS.ordinal()] = 3;
            $EnumSwitchMapping$0[CollectionType.PRODUCTS.ordinal()] = 4;
        }
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public MixedCollectionAdapter(@NotNull Context context2, @NotNull Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(context2, "context");
        Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
        this.context = context2;
        this.delegate = delegate2;
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    @NotNull
    public final Delegate getDelegate() {
        return this.delegate;
    }

    public final void addAllReload(@NotNull ArrayList<CollectionEntry> arrayList) {
        Intrinsics.checkParameterIsNotNull(arrayList, "items");
        this.items.clear();
        this.items.addAll(arrayList);
        notifyDataSetChanged();
    }

    public final void addCollectionDetail(@NotNull CollectionDetailResponse collectionDetailResponse) {
        Intrinsics.checkParameterIsNotNull(collectionDetailResponse, "collectionDetail");
        this.collectionDetail = collectionDetailResponse;
    }

    public final void addAll(@NotNull ArrayList<CollectionEntry> arrayList) {
        Intrinsics.checkParameterIsNotNull(arrayList, "items");
        this.items.addAll(arrayList);
        notifyDataSetChanged();
    }

    public final void updateFollow(long j, boolean z) {
        ArrayList<CollectionEntry> arrayList = this.items;
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (true) {
            boolean z2 = false;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((CollectionEntry) next).getType() == CollectionType.FITTIE) {
                z2 = true;
            }
            if (z2) {
                arrayList2.add(next);
            }
        }
        ArrayList<CollectionEntry> arrayList3 = new ArrayList<>();
        for (Object next2 : arrayList2) {
            User user = ((CollectionEntry) next2).getUser();
            if (user != null && j == user.getId()) {
                arrayList3.add(next2);
            }
        }
        ArrayList arrayList4 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList3, 10));
        for (CollectionEntry indexOf : arrayList3) {
            notifyItemChanged(this.items.indexOf(indexOf) + 1, Boolean.valueOf(z));
            arrayList4.add(Unit.INSTANCE);
        }
    }

    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        String str = "view";
        if (i == 0) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.view_mixed_image, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, str);
            return new CoverTypeHolder(this, inflate);
        } else if (i == 1) {
            View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.view_mixed_image, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate2, str);
            return new ImageTypeHolder(this, inflate2);
        } else if (i == 2) {
            View inflate3 = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.item_mixed_fittie, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate3, str);
            return new FittieTypeHolder(this, inflate3);
        } else if (i == 3) {
            View inflate4 = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.view_mixed_posts, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate4, str);
            return new PostsTypeHolder(this, inflate4);
        } else if (i != 4) {
            return EmptyTypeHolder.Companion.create(viewGroup);
        } else {
            View inflate5 = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.view_mixed_posts, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate5, str);
            return new ProductsTypeHolder(this, inflate5);
        }
    }

    public int getItemCount() {
        return this.items.size() + (this.collectionDetail != null ? 1 : 0);
    }

    public void onViewRecycled(@NotNull ViewHolder viewHolder) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
        if (viewHolder instanceof ProductsTypeHolder) {
            ((ProductsTypeHolder) viewHolder).clear();
        } else if (viewHolder instanceof PostsTypeHolder) {
            ((PostsTypeHolder) viewHolder).clear();
        } else if (viewHolder instanceof CoverTypeHolder) {
            ((CoverTypeHolder) viewHolder).clear();
        } else if (viewHolder instanceof ImageTypeHolder) {
            ((ImageTypeHolder) viewHolder).clear();
        } else {
            super.onViewRecycled(viewHolder);
        }
    }

    @SuppressLint({"SetTextI18n"})
    public void onBindViewHolder(@NotNull ViewHolder viewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
        if (viewHolder instanceof CoverTypeHolder) {
            CollectionDetailResponse collectionDetailResponse = this.collectionDetail;
            if (collectionDetailResponse != null) {
                ((CoverTypeHolder) viewHolder).init(collectionDetailResponse);
            }
        } else if (viewHolder instanceof ImageTypeHolder) {
            ((ImageTypeHolder) viewHolder).init(i - 1);
        } else if (viewHolder instanceof FittieTypeHolder) {
            ((FittieTypeHolder) viewHolder).init(i - 1);
        } else if (viewHolder instanceof PostsTypeHolder) {
            CollectionEntry collectionEntry = (CollectionEntry) this.items.get(i - 1);
            ((PostsTypeHolder) viewHolder).init(collectionEntry.getColumns(), new ArrayList(collectionEntry.getPosts()));
        } else if (viewHolder instanceof ProductsTypeHolder) {
            CollectionEntry collectionEntry2 = (CollectionEntry) this.items.get(i - 1);
            ProductsTypeHolder productsTypeHolder = (ProductsTypeHolder) viewHolder;
            List products = collectionEntry2.getProducts();
            if (products == null) {
                products = new ArrayList();
            }
            productsTypeHolder.bind(products, collectionEntry2.getColumns());
        }
    }

    public void onBindViewHolder(@NotNull ViewHolder viewHolder, int i, @NotNull List<Object> list) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
        Intrinsics.checkParameterIsNotNull(list, "payloads");
        if (list.isEmpty()) {
            super.onBindViewHolder(viewHolder, i, list);
        } else if ((viewHolder instanceof FittieTypeHolder) && (!list.isEmpty()) && (list.get(0) instanceof Boolean)) {
            Object obj = list.get(0);
            if (Intrinsics.areEqual(obj, (Object) Boolean.valueOf(true))) {
                FittieTypeHolder fittieTypeHolder = (FittieTypeHolder) viewHolder;
                fittieTypeHolder.enableFollowButton();
                fittieTypeHolder.updateFollowButton(C0016R$string.following, C0006R$color.gray4, C0008R$drawable.round_button_following, C0009R$font.kopubdotum_pro_medium);
            } else if (Intrinsics.areEqual(obj, (Object) Boolean.valueOf(false))) {
                FittieTypeHolder fittieTypeHolder2 = (FittieTypeHolder) viewHolder;
                fittieTypeHolder2.enableFollowButton();
                fittieTypeHolder2.updateFollowButton(C0016R$string.follow, 17170443, C0008R$drawable.round_button_follow, C0009R$font.kopubdotum_pro_bold);
            }
        }
    }

    public int getItemViewType(int i) {
        if (i == 0) {
            return 0;
        }
        if (i > this.items.size()) {
            return EmptyTypeHolder.Companion.getId();
        }
        int i2 = WhenMappings.$EnumSwitchMapping$0[((CollectionEntry) this.items.get(i - 1)).getType().ordinal()];
        if (i2 == 1) {
            return 1;
        }
        if (i2 == 2) {
            return 2;
        }
        if (i2 == 3) {
            return 3;
        }
        if (i2 != 4) {
            return EmptyTypeHolder.Companion.getId();
        }
        return 4;
    }

    /* access modifiers changed from: private */
    public final Pair<Integer, Integer> getImageHeight(double d) {
        Point point = new Point();
        Display defaultDisplay = Sdk27ServicesKt.getWindowManager(this.context).getDefaultDisplay();
        if (defaultDisplay != null) {
            defaultDisplay.getSize(point);
        }
        if (d <= ((double) 0)) {
            return new Pair<>(Integer.valueOf(point.x), Integer.valueOf(0));
        }
        int i = point.x;
        double d2 = (double) i;
        Double.isNaN(d2);
        int roundToInt = MathKt__MathJVMKt.roundToInt(d2 / d);
        UIExtensions uIExtensions = UIExtensions.INSTANCE;
        if (roundToInt > uIExtensions.getMaxTexturesSize()) {
            roundToInt = uIExtensions.getMaxTexturesSize();
            double d3 = (double) roundToInt;
            Double.isNaN(d3);
            i = MathKt__MathJVMKt.roundToInt(d3 * d);
        }
        return new Pair<>(Integer.valueOf(i), Integer.valueOf(roundToInt));
    }

    /* access modifiers changed from: private */
    public final int getResizeHeight(double d) {
        Point point = new Point();
        Display defaultDisplay = Sdk27ServicesKt.getWindowManager(this.context).getDefaultDisplay();
        if (defaultDisplay != null) {
            defaultDisplay.getSize(point);
        }
        if (d <= ((double) 0)) {
            return 0;
        }
        double d2 = (double) point.x;
        Double.isNaN(d2);
        return MathKt__MathJVMKt.roundToInt(d2 / d);
    }
}
