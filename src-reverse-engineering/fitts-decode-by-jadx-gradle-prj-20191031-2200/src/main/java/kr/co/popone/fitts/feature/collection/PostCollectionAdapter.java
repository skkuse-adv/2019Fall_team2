package kr.co.popone.fitts.feature.collection;

import android.content.Context;
import android.graphics.Point;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.feature.search.LoadingListItemViewHolder;
import kr.co.popone.fitts.model.collection.CollectionAPI.CollectionDetailResponse;
import kr.co.popone.fitts.model.collection.CollectionAPI.CollectionEntry;
import org.jetbrains.anko.Sdk27ServicesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class PostCollectionAdapter extends Adapter<ViewHolder> {
    @NotNull
    private List<CollectionEntry> collectionItems;
    @Nullable
    private CollectionDetailResponse collectionResponse;
    private final Context context;
    /* access modifiers changed from: private */
    public final Delegate delegate;
    private final OnClickListener showPostClickListener;
    private final OnClickListener showProductInfoClickListener;
    private final OnClickListener showShowroomClickListener;
    private boolean showsLoading;
    private final Point windowSize = new Point();

    public interface Delegate {
        void showPost(int i);

        void showProductInfo(int i);

        void showShowroom(int i);
    }

    public static final class HeaderViewHolder extends ViewHolder {
        @NotNull
        private final ImageView coverImageView;

        public HeaderViewHolder(@NotNull View view) {
            Intrinsics.checkParameterIsNotNull(view, "view");
            super(view);
            View findViewById = view.findViewById(C0010R$id.coverImageView);
            Intrinsics.checkExpressionValueIsNotNull(findViewById, "view.findViewById(R.id.coverImageView)");
            this.coverImageView = (ImageView) findViewById;
        }

        @NotNull
        public final ImageView getCoverImageView() {
            return this.coverImageView;
        }
    }

    public PostCollectionAdapter(@NotNull Context context2, @NotNull Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(context2, "context");
        Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
        this.context = context2;
        this.delegate = delegate2;
        Sdk27ServicesKt.getWindowManager(this.context).getDefaultDisplay().getSize(this.windowSize);
        this.showShowroomClickListener = new PostCollectionAdapter$showShowroomClickListener$1(this);
        this.showProductInfoClickListener = new PostCollectionAdapter$showProductInfoClickListener$1(this);
        this.showPostClickListener = new PostCollectionAdapter$showPostClickListener$1(this);
        this.collectionItems = CollectionsKt__CollectionsKt.emptyList();
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

    public final boolean getShowsLoading() {
        return this.showsLoading;
    }

    public final void setShowsLoading(boolean z) {
        if (this.showsLoading != z) {
            this.showsLoading = z;
            notifyDataSetChanged();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x010c, code lost:
        if (r5 != null) goto L_0x0110;
     */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0172  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0177  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0185  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x01a4  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x01c3  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x01c8  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x01f1  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0218  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x027c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull androidx.recyclerview.widget.RecyclerView.ViewHolder r9, int r10) {
        /*
            r8 = this;
            java.lang.String r0 = "holder"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r9, r0)
            kr.co.popone.fitts.model.collection.CollectionAPI$CollectionDetailResponse r0 = r8.collectionResponse
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "onBindViewHolder  "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r1 = r1.toString()
            r2 = 0
            java.lang.Object[] r3 = new java.lang.Object[r2]
            com.orhanobut.logger.Logger.d(r1, r3)
            boolean r1 = r9 instanceof kr.co.popone.fitts.feature.collection.PostCollectionAdapter.HeaderViewHolder
            r3 = 0
            if (r1 == 0) goto L_0x00d5
            if (r0 == 0) goto L_0x00c0
            android.graphics.Point r10 = r8.windowSize
            int r10 = r10.x
            float r1 = r0.getMainImageRatio()
            float r3 = (float) r2
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 <= 0) goto L_0x003d
            float r1 = (float) r10
            float r4 = r0.getMainImageRatio()
            float r1 = r1 / r4
            int r1 = kotlin.math.MathKt__MathJVMKt.roundToInt(r1)
            goto L_0x003e
        L_0x003d:
            r1 = 0
        L_0x003e:
            kr.co.popone.fitts.utils.UIExtensions r4 = kr.co.popone.fitts.utils.UIExtensions.INSTANCE
            int r4 = r4.getMaxTexturesSize()
            if (r1 <= r4) goto L_0x0057
            kr.co.popone.fitts.utils.UIExtensions r10 = kr.co.popone.fitts.utils.UIExtensions.INSTANCE
            int r1 = r10.getMaxTexturesSize()
            float r10 = (float) r1
            float r4 = r0.getMainImageRatio()
            float r10 = r10 * r4
            int r10 = kotlin.math.MathKt__MathJVMKt.roundToInt(r10)
        L_0x0057:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "cover image size ("
            r4.append(r5)
            r4.append(r10)
            java.lang.String r5 = ", "
            r4.append(r5)
            r4.append(r1)
            r5 = 41
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            java.lang.Object[] r5 = new java.lang.Object[r2]
            com.orhanobut.logger.Logger.d(r4, r5)
            android.content.Context r4 = r8.context
            com.bumptech.glide.RequestManager r4 = com.bumptech.glide.Glide.with(r4)
            java.lang.String r5 = r0.getMainImageUrl()
            com.bumptech.glide.RequestBuilder r4 = r4.load(r5)
            com.bumptech.glide.request.RequestOptions r5 = new com.bumptech.glide.request.RequestOptions
            r5.<init>()
            com.bumptech.glide.request.BaseRequestOptions r10 = r5.override(r10, r1)
            com.bumptech.glide.RequestBuilder r10 = r4.apply(r10)
            kr.co.popone.fitts.feature.collection.PostCollectionAdapter$HeaderViewHolder r9 = (kr.co.popone.fitts.feature.collection.PostCollectionAdapter.HeaderViewHolder) r9
            android.widget.ImageView r1 = r9.getCoverImageView()
            r10.into(r1)
            android.widget.ImageView r9 = r9.getCoverImageView()
            android.view.ViewGroup$LayoutParams r9 = r9.getLayoutParams()
            float r10 = r0.getMainImageRatio()
            int r10 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
            if (r10 <= 0) goto L_0x00bc
            android.graphics.Point r10 = r8.windowSize
            int r10 = r10.x
            float r10 = (float) r10
            float r0 = r0.getMainImageRatio()
            float r10 = r10 / r0
            int r2 = kotlin.math.MathKt__MathJVMKt.roundToInt(r10)
        L_0x00bc:
            r9.height = r2
            goto L_0x028c
        L_0x00c0:
            kr.co.popone.fitts.feature.collection.PostCollectionAdapter$HeaderViewHolder r9 = (kr.co.popone.fitts.feature.collection.PostCollectionAdapter.HeaderViewHolder) r9
            android.widget.ImageView r10 = r9.getCoverImageView()
            android.view.ViewGroup$LayoutParams r10 = r10.getLayoutParams()
            r10.height = r2
            android.widget.ImageView r9 = r9.getCoverImageView()
            r9.setImageDrawable(r3)
            goto L_0x028c
        L_0x00d5:
            boolean r0 = r9 instanceof kr.co.popone.fitts.feature.collection.PostItemViewHolder
            if (r0 == 0) goto L_0x028c
            int r10 = r10 + -1
            java.util.List<kr.co.popone.fitts.model.collection.CollectionAPI$CollectionEntry> r0 = r8.collectionItems
            java.lang.Object r0 = r0.get(r10)
            kr.co.popone.fitts.model.collection.CollectionAPI$CollectionEntry r0 = (kr.co.popone.fitts.model.collection.CollectionAPI.CollectionEntry) r0
            kr.co.popone.fitts.feature.collection.PostItemViewHolder r9 = (kr.co.popone.fitts.feature.collection.PostItemViewHolder) r9
            androidx.recyclerview.widget.RecyclerView r1 = r9.getPostImagesRecyclerView()
            androidx.recyclerview.widget.RecyclerView$Adapter r1 = r1.getAdapter()
            if (r1 == 0) goto L_0x0284
            kr.co.popone.fitts.feature.collection.PostImagesAdapter r1 = (kr.co.popone.fitts.feature.collection.PostImagesAdapter) r1
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            kr.co.popone.fitts.model.post.PostAPI$Post r5 = r0.getPost()
            if (r5 == 0) goto L_0x0139
            kr.co.popone.fitts.model.post.PostAPI$Post r5 = r0.getPost()
            kr.co.popone.fitts.model.datamodel.service.post.Image r5 = r5.getCoverImage()
            java.lang.String r6 = ""
            if (r5 == 0) goto L_0x010f
            java.lang.String r5 = r5.getThumbnail()
            if (r5 == 0) goto L_0x010f
            goto L_0x0110
        L_0x010f:
            r5 = r6
        L_0x0110:
            r4.add(r5)
            kr.co.popone.fitts.model.post.PostAPI$Post r5 = r0.getPost()
            java.util.List r5 = r5.getFreeformImages()
            if (r5 == 0) goto L_0x0139
            java.util.Iterator r5 = r5.iterator()
        L_0x0121:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L_0x0139
            java.lang.Object r7 = r5.next()
            kr.co.popone.fitts.model.datamodel.service.post.Image r7 = (kr.co.popone.fitts.model.datamodel.service.post.Image) r7
            java.lang.String r7 = r7.getThumbnail()
            if (r7 == 0) goto L_0x0134
            goto L_0x0135
        L_0x0134:
            r7 = r6
        L_0x0135:
            r4.add(r7)
            goto L_0x0121
        L_0x0139:
            r1.setPostImages(r4)
            android.widget.TextView r4 = r9.getTitleTextView()
            kr.co.popone.fitts.model.post.PostAPI$Post r5 = r0.getPost()
            if (r5 == 0) goto L_0x014b
            java.lang.String r5 = r5.getTitle()
            goto L_0x014c
        L_0x014b:
            r5 = r3
        L_0x014c:
            r4.setText(r5)
            android.widget.TextView r4 = r9.getFittsIDTextView()
            kr.co.popone.fitts.model.post.PostAPI$Post r5 = r0.getPost()
            if (r5 == 0) goto L_0x0164
            kr.co.popone.fitts.model.datamodel.service.user.User r5 = r5.getUser()
            if (r5 == 0) goto L_0x0164
            java.lang.String r5 = r5.getFittsID()
            goto L_0x0165
        L_0x0164:
            r5 = r3
        L_0x0165:
            r4.setText(r5)
            android.widget.TextView r4 = r9.getDescriptionTextView()
            kr.co.popone.fitts.model.post.PostAPI$Post r5 = r0.getPost()
            if (r5 == 0) goto L_0x0177
            java.lang.String r5 = r5.getAboutFit()
            goto L_0x0178
        L_0x0177:
            r5 = r3
        L_0x0178:
            r4.setText(r5)
            android.widget.TextView r4 = r9.getShopNameTextView()
            kr.co.popone.fitts.model.post.PostAPI$Post r5 = r0.getPost()
            if (r5 == 0) goto L_0x0196
            kr.co.popone.fitts.model.post.PostAPI$LinkInfo r5 = r5.getLinkInfo()
            if (r5 == 0) goto L_0x0196
            kr.co.popone.fitts.model.datamodel.commerce.Shop r5 = r5.getShop()
            if (r5 == 0) goto L_0x0196
            java.lang.String r5 = r5.getName()
            goto L_0x0197
        L_0x0196:
            r5 = r3
        L_0x0197:
            r4.setText(r5)
            android.widget.TextView r4 = r9.getPriceTextView()
            kr.co.popone.fitts.model.post.PostAPI$Post r5 = r0.getPost()
            if (r5 == 0) goto L_0x01b5
            kr.co.popone.fitts.model.post.PostAPI$LinkInfo r5 = r5.getLinkInfo()
            if (r5 == 0) goto L_0x01b5
            kr.co.popone.fitts.model.datamodel.commerce.Product r5 = r5.getProduct()
            if (r5 == 0) goto L_0x01b5
            java.lang.String r5 = r5.getPrice()
            goto L_0x01b6
        L_0x01b5:
            r5 = r3
        L_0x01b6:
            r4.setText(r5)
            android.widget.TextView r4 = r9.getSizeTextView()
            kr.co.popone.fitts.model.post.PostAPI$Post r5 = r0.getPost()
            if (r5 == 0) goto L_0x01c8
            java.lang.String r5 = r5.getAboutSize()
            goto L_0x01c9
        L_0x01c8:
            r5 = r3
        L_0x01c9:
            r4.setText(r5)
            com.bumptech.glide.request.RequestOptions r4 = new com.bumptech.glide.request.RequestOptions
            r4.<init>()
            r5 = 2131231063(0x7f080157, float:1.8078196E38)
            com.bumptech.glide.request.BaseRequestOptions r4 = r4.placeholder(r5)
            com.bumptech.glide.request.RequestOptions r4 = (com.bumptech.glide.request.RequestOptions) r4
            com.bumptech.glide.request.BaseRequestOptions r4 = r4.error(r5)
            java.lang.String r5 = "RequestOptions().placeho…le.image_default_profile)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r4, r5)
            com.bumptech.glide.request.RequestOptions r4 = (com.bumptech.glide.request.RequestOptions) r4
            android.content.Context r5 = r8.context
            com.bumptech.glide.RequestManager r5 = com.bumptech.glide.Glide.with(r5)
            kr.co.popone.fitts.model.post.PostAPI$Post r6 = r0.getPost()
            if (r6 == 0) goto L_0x01fc
            kr.co.popone.fitts.model.datamodel.service.user.User r6 = r6.getUser()
            if (r6 == 0) goto L_0x01fc
            java.lang.String r6 = r6.getProfileImageUrl()
            goto L_0x01fd
        L_0x01fc:
            r6 = r3
        L_0x01fd:
            com.bumptech.glide.RequestBuilder r5 = r5.load(r6)
            com.bumptech.glide.RequestBuilder r4 = r5.apply(r4)
            android.widget.ImageView r5 = r9.getProfileImageView()
            r4.into(r5)
            android.content.Context r4 = r8.context
            com.bumptech.glide.RequestManager r4 = com.bumptech.glide.Glide.with(r4)
            kr.co.popone.fitts.model.post.PostAPI$Post r0 = r0.getPost()
            if (r0 == 0) goto L_0x0228
            kr.co.popone.fitts.model.post.PostAPI$LinkInfo r0 = r0.getLinkInfo()
            if (r0 == 0) goto L_0x0228
            kr.co.popone.fitts.model.datamodel.commerce.Product r0 = r0.getProduct()
            if (r0 == 0) goto L_0x0228
            java.lang.String r3 = r0.getImageUrl()
        L_0x0228:
            com.bumptech.glide.RequestBuilder r0 = r4.load(r3)
            android.widget.ImageView r3 = r9.getProductImageView()
            r0.into(r3)
            android.widget.TextView r0 = r9.getTitleTextView()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r10)
            r0.setTag(r3)
            android.view.ViewGroup r0 = r9.getPostDetailLayout()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r10)
            r0.setTag(r3)
            android.view.ViewGroup r0 = r9.getProductInfoLayout()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r10)
            r0.setTag(r3)
            android.widget.TextView r0 = r9.getByTextView()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r10)
            r0.setTag(r3)
            android.widget.TextView r0 = r9.getFittsIDTextView()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r10)
            r0.setTag(r3)
            android.view.View r0 = r9.getProfileImageClickEventView()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r10)
            r0.setTag(r3)
            android.view.View r9 = r9.getItemSeparatorLineView()
            if (r10 <= 0) goto L_0x027c
            goto L_0x027d
        L_0x027c:
            r2 = 4
        L_0x027d:
            r9.setVisibility(r2)
            r1.setPostPosition(r10)
            goto L_0x028c
        L_0x0284:
            kotlin.TypeCastException r9 = new kotlin.TypeCastException
            java.lang.String r10 = "null cannot be cast to non-null type kr.co.popone.fitts.feature.collection.PostImagesAdapter"
            r9.<init>(r10)
            throw r9
        L_0x028c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.feature.collection.PostCollectionAdapter.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder, int):void");
    }

    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        String str = "view";
        if (i == 0) {
            View inflate = LayoutInflater.from(this.context).inflate(C0013R$layout.item_post_collection_header, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, str);
            return new HeaderViewHolder(inflate);
        } else if (i == 1) {
            View inflate2 = LayoutInflater.from(this.context).inflate(C0013R$layout.item_post_collection_post, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate2, str);
            PostItemViewHolder postItemViewHolder = new PostItemViewHolder(inflate2);
            postItemViewHolder.getPostImagesRecyclerView().setAdapter(new PostImagesAdapter(this.context, new PostCollectionAdapter$onCreateViewHolder$1(this)));
            postItemViewHolder.getTitleTextView().setOnClickListener(this.showPostClickListener);
            postItemViewHolder.getPostDetailLayout().setOnClickListener(this.showPostClickListener);
            postItemViewHolder.getPostImagesRecyclerView().addItemDecoration(new MultiPostItemDecoration());
            postItemViewHolder.getProductInfoLayout().setOnClickListener(this.showProductInfoClickListener);
            postItemViewHolder.getByTextView().setOnClickListener(this.showShowroomClickListener);
            postItemViewHolder.getFittsIDTextView().setOnClickListener(this.showShowroomClickListener);
            postItemViewHolder.getProfileImageClickEventView().setOnClickListener(this.showShowroomClickListener);
            return postItemViewHolder;
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
