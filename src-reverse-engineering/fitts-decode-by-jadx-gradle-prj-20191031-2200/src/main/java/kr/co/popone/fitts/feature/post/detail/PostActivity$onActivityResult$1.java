package kr.co.popone.fitts.feature.post.detail;

import io.reactivex.functions.BiConsumer;
import kr.co.popone.fitts.model.post.PostAPI.Post;

final class PostActivity$onActivityResult$1<T1, T2> implements BiConsumer<Post, Throwable> {
    final /* synthetic */ PostActivity this$0;

    PostActivity$onActivityResult$1(PostActivity postActivity) {
        this.this$0 = postActivity;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0063, code lost:
        if (r14 != null) goto L_0x0072;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void accept(final kr.co.popone.fitts.model.post.PostAPI.Post r13, java.lang.Throwable r14) {
        /*
            r12 = this;
            kr.co.popone.fitts.feature.post.detail.PostActivity r0 = r12.this$0
            r1 = 0
            r0.postRequest = r1
            java.lang.String r0 = "layout_post_bottombar"
            java.lang.String r2 = "scrollview"
            r3 = 8
            r4 = 0
            if (r13 == 0) goto L_0x0826
            kr.co.popone.fitts.feature.post.detail.PostActivity r14 = r12.this$0
            int r5 = kr.co.popone.fitts.C0010R$id.scrollview
            android.view.View r14 = r14._$_findCachedViewById(r5)
            androidx.core.widget.NestedScrollView r14 = (androidx.core.widget.NestedScrollView) r14
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r14, r2)
            r14.setVisibility(r4)
            kr.co.popone.fitts.feature.post.detail.PostActivity r14 = r12.this$0
            int r2 = kr.co.popone.fitts.C0010R$id.layout_post_bottombar
            android.view.View r14 = r14._$_findCachedViewById(r2)
            androidx.constraintlayout.widget.ConstraintLayout r14 = (androidx.constraintlayout.widget.ConstraintLayout) r14
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r14, r0)
            r14.setVisibility(r4)
            kr.co.popone.fitts.feature.post.detail.PostActivity r14 = r12.this$0
            long r5 = r13.getId()
            java.lang.Long r0 = java.lang.Long.valueOf(r5)
            r14.postID = r0
            kr.co.popone.fitts.feature.post.detail.PostActivity r14 = r12.this$0
            kr.co.popone.fitts.model.datamodel.service.user.User r0 = r13.getUser()
            long r5 = r0.getId()
            java.lang.Long r0 = java.lang.Long.valueOf(r5)
            r14.userID = r0
            kr.co.popone.fitts.model.order.OrderListLineItemVariant r14 = r13.getLineItemVariant()
            if (r14 == 0) goto L_0x0066
            kr.co.popone.fitts.model.cart.CartVariants r14 = r14.getVariant()
            if (r14 == 0) goto L_0x0066
            kr.co.popone.fitts.model.product.Product r14 = r14.getProduct()
            if (r14 == 0) goto L_0x0066
            java.lang.String r14 = r14.getMobileLinkUrl()
            if (r14 == 0) goto L_0x0066
            goto L_0x0072
        L_0x0066:
            kr.co.popone.fitts.model.post.PostAPI$LinkInfo r14 = r13.getLinkInfo()
            if (r14 == 0) goto L_0x0071
            java.lang.String r14 = r14.getLinkUrl()
            goto L_0x0072
        L_0x0071:
            r14 = r1
        L_0x0072:
            kr.co.popone.fitts.feature.post.detail.PostActivity r0 = r12.this$0
            r0.checkPartnerStore(r14)
            kr.co.popone.fitts.feature.post.detail.PostActivity r14 = r12.this$0
            com.bumptech.glide.RequestManager r14 = com.bumptech.glide.Glide.with(r14)
            kr.co.popone.fitts.model.datamodel.service.post.Image r0 = r13.getCoverImage()
            if (r0 != 0) goto L_0x0086
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0086:
            java.lang.String r0 = r0.getUrl()
            com.bumptech.glide.RequestBuilder r14 = r14.load(r0)
            kr.co.popone.fitts.feature.post.detail.PostActivity r0 = r12.this$0
            com.bumptech.glide.RequestManager r0 = com.bumptech.glide.Glide.with(r0)
            kr.co.popone.fitts.model.datamodel.service.post.Image r2 = r13.getCoverImage()
            java.lang.String r2 = r2.getLqip()
            com.bumptech.glide.RequestBuilder r0 = r0.load(r2)
            com.bumptech.glide.RequestBuilder r14 = r14.thumbnail(r0)
            kr.co.popone.fitts.feature.post.detail.PostActivity r0 = r12.this$0
            int r2 = kr.co.popone.fitts.C0010R$id.cover_image
            android.view.View r0 = r0._$_findCachedViewById(r2)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r14.into(r0)
            java.lang.String r14 = r13.getState()
            r0 = 2
            java.lang.String r2 = "inactive"
            boolean r14 = kotlin.text.StringsKt__StringsJVMKt.equals$default(r14, r2, r4, r0, r1)
            java.lang.String r2 = "inactivity_layout"
            if (r14 == 0) goto L_0x0143
            kr.co.popone.fitts.feature.post.detail.PostActivity r14 = r12.this$0
            kr.co.popone.fitts.model.post.PostAPI r5 = r14.getPostAPI()
            kr.co.popone.fitts.feature.post.detail.PostActivity r6 = r12.this$0
            android.content.Intent r6 = r6.getIntent()
            r7 = -1
            java.lang.String r9 = "post_id"
            long r6 = r6.getLongExtra(r9, r7)
            io.reactivex.Single r5 = r5.requestInactivePostUpdate(r6)
            io.reactivex.Scheduler r6 = io.reactivex.schedulers.Schedulers.io()
            io.reactivex.Single r5 = r5.subscribeOn(r6)
            io.reactivex.Scheduler r6 = io.reactivex.android.schedulers.AndroidSchedulers.mainThread()
            io.reactivex.Single r5 = r5.observeOn(r6)
            kr.co.popone.fitts.feature.post.detail.PostActivity$onActivityResult$1$1 r6 = new kr.co.popone.fitts.feature.post.detail.PostActivity$onActivityResult$1$1
            r6.<init>(r12)
            io.reactivex.disposables.Disposable r5 = r5.subscribe(r6)
            r14.inactivePostTimeUpdate = r5
            kr.co.popone.fitts.feature.post.detail.PostActivity r14 = r12.this$0
            int r5 = kr.co.popone.fitts.C0010R$id.inactivity_layout
            android.view.View r14 = r14._$_findCachedViewById(r5)
            android.widget.LinearLayout r14 = (android.widget.LinearLayout) r14
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r14, r2)
            r14.setVisibility(r4)
            kr.co.popone.fitts.feature.post.detail.PostActivity r14 = r12.this$0
            int r2 = kr.co.popone.fitts.C0010R$id.profile_fitts
            android.view.View r14 = r14._$_findCachedViewById(r2)
            android.widget.ImageView r14 = (android.widget.ImageView) r14
            kr.co.popone.fitts.feature.post.detail.PostActivity r2 = r12.this$0
            r5 = 2130771993(0x7f010019, float:1.7147092E38)
            android.view.animation.Animation r2 = android.view.animation.AnimationUtils.loadAnimation(r2, r5)
            r14.startAnimation(r2)
            kr.co.popone.fitts.feature.post.detail.PostActivity r14 = r12.this$0
            int r2 = kr.co.popone.fitts.C0010R$id.inactivity_reason
            android.view.View r14 = r14._$_findCachedViewById(r2)
            android.widget.TextView r14 = (android.widget.TextView) r14
            java.lang.String r2 = "inactivity_reason"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r14, r2)
            java.lang.String r2 = r13.getInactiveReason()
            r14.setText(r2)
            kr.co.popone.fitts.feature.post.detail.PostActivity r14 = r12.this$0
            int r2 = kr.co.popone.fitts.C0010R$id.kakao_opnion_button
            android.view.View r14 = r14._$_findCachedViewById(r2)
            android.widget.TextView r14 = (android.widget.TextView) r14
            kr.co.popone.fitts.feature.post.detail.PostActivity$onActivityResult$1$2 r2 = new kr.co.popone.fitts.feature.post.detail.PostActivity$onActivityResult$1$2
            r2.<init>(r12)
            r14.setOnClickListener(r2)
            goto L_0x0153
        L_0x0143:
            kr.co.popone.fitts.feature.post.detail.PostActivity r14 = r12.this$0
            int r5 = kr.co.popone.fitts.C0010R$id.inactivity_layout
            android.view.View r14 = r14._$_findCachedViewById(r5)
            android.widget.LinearLayout r14 = (android.widget.LinearLayout) r14
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r14, r2)
            r14.setVisibility(r3)
        L_0x0153:
            kr.co.popone.fitts.feature.post.detail.PostActivity r14 = r12.this$0
            int r2 = kr.co.popone.fitts.C0010R$id.post_rating
            android.view.View r14 = r14._$_findCachedViewById(r2)
            android.widget.RatingBar r14 = (android.widget.RatingBar) r14
            java.lang.String r2 = "post_rating"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r14, r2)
            float r2 = r13.getStars()
            r14.setRating(r2)
            kr.co.popone.fitts.feature.post.detail.PostActivity r14 = r12.this$0
            int r2 = kr.co.popone.fitts.C0010R$id.post_title
            android.view.View r14 = r14._$_findCachedViewById(r2)
            android.widget.TextView r14 = (android.widget.TextView) r14
            java.lang.String r2 = "post_title"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r14, r2)
            java.lang.String r2 = r13.getTitle()
            r14.setText(r2)
            kr.co.popone.fitts.feature.post.detail.PostActivity r14 = r12.this$0
            int r2 = kr.co.popone.fitts.C0010R$id.post_create_at
            android.view.View r2 = r14._$_findCachedViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            java.lang.String r5 = "post_create_at"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r5)
            java.lang.String r5 = r13.getCreatedAt()
            r14.loadDate(r2, r5)
            kr.co.popone.fitts.feature.post.detail.PostActivity r14 = r12.this$0
            int r2 = kr.co.popone.fitts.C0010R$id.viewCountTextView
            android.view.View r14 = r14._$_findCachedViewById(r2)
            android.widget.TextView r14 = (android.widget.TextView) r14
            java.lang.String r2 = "viewCountTextView"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r14, r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r5 = "조회 "
            r2.append(r5)
            int r5 = r13.getViewCount()
            r2.append(r5)
            r5 = 47749(0xba85, float:6.691E-41)
            r2.append(r5)
            java.lang.String r2 = r2.toString()
            r14.setText(r2)
            kr.co.popone.fitts.model.datamodel.service.user.User r14 = r13.getUser()
            kr.co.popone.fitts.feature.post.detail.PostActivity r2 = r12.this$0
            r2.postUser = r14
            kr.co.popone.fitts.feature.post.detail.PostActivity r2 = r12.this$0
            int r5 = kr.co.popone.fitts.C0010R$id.profile_id
            android.view.View r2 = r2._$_findCachedViewById(r5)
            android.widget.TextView r2 = (android.widget.TextView) r2
            java.lang.String r5 = "profile_id"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r5)
            java.lang.String r5 = r14.getFittsID()
            r2.setText(r5)
            kr.co.popone.fitts.feature.post.detail.PostActivity r2 = r12.this$0
            int r5 = kr.co.popone.fitts.C0010R$id.fittieSuitBlue
            android.view.View r2 = r2._$_findCachedViewById(r5)
            java.lang.String r5 = "fittieSuitBlue"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r5)
            boolean r5 = r14.isSuitable()
            if (r5 == 0) goto L_0x01f6
            r5 = 0
            goto L_0x01f8
        L_0x01f6:
            r5 = 8
        L_0x01f8:
            r2.setVisibility(r5)
            kr.co.popone.fitts.feature.post.detail.PostActivity r2 = r12.this$0
            int r5 = kr.co.popone.fitts.C0010R$id.profile_type
            android.view.View r2 = r2._$_findCachedViewById(r5)
            android.widget.ImageView r2 = (android.widget.ImageView) r2
            kr.co.popone.fitts.model.datamodel.service.user.BodyInfo r5 = r14.getBodyInfo()
            if (r5 != 0) goto L_0x020e
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x020e:
            kr.co.popone.fitts.model.datamodel.service.user.BodyType r5 = r5.getBodyType()
            int[] r6 = kr.co.popone.fitts.feature.post.detail.PostActivity.WhenMappings.$EnumSwitchMapping$4
            int r5 = r5.ordinal()
            r5 = r6[r5]
            r6 = 3
            r7 = 1
            if (r5 == r7) goto L_0x0245
            if (r5 == r0) goto L_0x023e
            if (r5 == r6) goto L_0x0237
            r8 = 4
            if (r5 == r8) goto L_0x0230
            r8 = 5
            if (r5 == r8) goto L_0x0229
            goto L_0x024b
        L_0x0229:
            r5 = 2131231069(0x7f08015d, float:1.8078209E38)
            r2.setImageResource(r5)
            goto L_0x024b
        L_0x0230:
            r5 = 2131231066(0x7f08015a, float:1.8078203E38)
            r2.setImageResource(r5)
            goto L_0x024b
        L_0x0237:
            r5 = 2131231068(0x7f08015c, float:1.8078207E38)
            r2.setImageResource(r5)
            goto L_0x024b
        L_0x023e:
            r5 = 2131231067(0x7f08015b, float:1.8078205E38)
            r2.setImageResource(r5)
            goto L_0x024b
        L_0x0245:
            r5 = 2131231070(0x7f08015e, float:1.807821E38)
            r2.setImageResource(r5)
        L_0x024b:
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
            kr.co.popone.fitts.feature.post.PostType r2 = r13.postType()
            int[] r5 = kr.co.popone.fitts.feature.post.detail.PostActivity.WhenMappings.$EnumSwitchMapping$5
            int r2 = r2.ordinal()
            r2 = r5[r2]
            java.lang.String r5 = " . "
            java.lang.String r8 = "profile_info"
            if (r2 == r7) goto L_0x02dd
            if (r2 == r0) goto L_0x0288
            if (r2 == r6) goto L_0x0265
            goto L_0x0360
        L_0x0265:
            kr.co.popone.fitts.feature.post.detail.PostActivity r2 = r12.this$0
            int r5 = kr.co.popone.fitts.C0010R$id.profile_info
            android.view.View r2 = r2._$_findCachedViewById(r5)
            android.widget.TextView r2 = (android.widget.TextView) r2
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r8)
            kr.co.popone.fitts.model.datamodel.service.user.BodyInfo r5 = r14.getBodyInfo()
            if (r5 != 0) goto L_0x027b
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x027b:
            int r5 = r5.getHeight()
            java.lang.String r5 = java.lang.String.valueOf(r5)
            r2.setText(r5)
            goto L_0x0360
        L_0x0288:
            kr.co.popone.fitts.feature.post.detail.PostActivity r2 = r12.this$0
            int r9 = kr.co.popone.fitts.C0010R$id.profile_info
            android.view.View r2 = r2._$_findCachedViewById(r9)
            android.widget.TextView r2 = (android.widget.TextView) r2
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r8)
            kr.co.popone.fitts.model.datamodel.service.user.BodyInfo r8 = r14.getBodyInfo()
            if (r8 != 0) goto L_0x029e
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x029e:
            int r8 = r8.getShoeSize()
            if (r8 <= 0) goto L_0x02cc
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            kr.co.popone.fitts.model.datamodel.service.user.BodyInfo r9 = r14.getBodyInfo()
            int r9 = r9.getHeight()
            r8.append(r9)
            r8.append(r5)
            kr.co.popone.fitts.model.datamodel.service.user.BodyInfo r5 = r14.getBodyInfo()
            int r5 = r5.getShoeSize()
            r8.append(r5)
            java.lang.String r5 = "mm"
            r8.append(r5)
            java.lang.String r5 = r8.toString()
            goto L_0x02d8
        L_0x02cc:
            kr.co.popone.fitts.model.datamodel.service.user.BodyInfo r5 = r14.getBodyInfo()
            int r5 = r5.getHeight()
            java.lang.String r5 = java.lang.String.valueOf(r5)
        L_0x02d8:
            r2.setText(r5)
            goto L_0x0360
        L_0x02dd:
            kr.co.popone.fitts.feature.post.detail.PostActivity r2 = r12.this$0
            int r9 = kr.co.popone.fitts.C0010R$id.profile_info
            android.view.View r2 = r2._$_findCachedViewById(r9)
            android.widget.TextView r2 = (android.widget.TextView) r2
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r8)
            kr.co.popone.fitts.model.datamodel.service.user.BodyInfo r8 = r14.getBodyInfo()
            if (r8 != 0) goto L_0x02f3
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x02f3:
            java.lang.String r8 = r8.getTop()
            if (r8 == 0) goto L_0x0302
            boolean r8 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r8)
            if (r8 == 0) goto L_0x0300
            goto L_0x0302
        L_0x0300:
            r8 = 0
            goto L_0x0303
        L_0x0302:
            r8 = 1
        L_0x0303:
            if (r8 != 0) goto L_0x0351
            kr.co.popone.fitts.model.datamodel.service.user.BodyInfo r8 = r14.getBodyInfo()
            java.lang.String r8 = r8.getBottom()
            if (r8 == 0) goto L_0x0318
            boolean r8 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r8)
            if (r8 == 0) goto L_0x0316
            goto L_0x0318
        L_0x0316:
            r8 = 0
            goto L_0x0319
        L_0x0318:
            r8 = 1
        L_0x0319:
            if (r8 != 0) goto L_0x0351
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            kr.co.popone.fitts.model.datamodel.service.user.BodyInfo r9 = r14.getBodyInfo()
            int r9 = r9.getHeight()
            r8.append(r9)
            r8.append(r5)
            kr.co.popone.fitts.model.datamodel.service.user.BodyInfo r9 = r14.getBodyInfo()
            java.lang.String r9 = r9.getTop()
            r8.append(r9)
            r8.append(r5)
            kr.co.popone.fitts.model.datamodel.service.user.BodyInfo r5 = r14.getBodyInfo()
            java.lang.String r5 = r5.getBottom()
            r8.append(r5)
            r5 = 32
            r8.append(r5)
            java.lang.String r5 = r8.toString()
            goto L_0x035d
        L_0x0351:
            kr.co.popone.fitts.model.datamodel.service.user.BodyInfo r5 = r14.getBodyInfo()
            int r5 = r5.getHeight()
            java.lang.String r5 = java.lang.String.valueOf(r5)
        L_0x035d:
            r2.setText(r5)
        L_0x0360:
            kr.co.popone.fitts.feature.post.detail.PostActivity r2 = r12.this$0
            int r5 = kr.co.popone.fitts.C0010R$id.profile_description
            android.view.View r2 = r2._$_findCachedViewById(r5)
            android.widget.TextView r2 = (android.widget.TextView) r2
            java.lang.String r5 = "profile_description"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r5)
            kr.co.popone.fitts.model.datamodel.service.user.BodyInfo r5 = r14.getBodyInfo()
            java.lang.String r5 = r5.getDescription()
            r2.setText(r5)
            kr.co.popone.fitts.feature.post.detail.PostActivity r2 = r12.this$0
            int r5 = kr.co.popone.fitts.C0010R$id.profile_image
            android.view.View r2 = r2._$_findCachedViewById(r5)
            de.hdodenhof.circleimageview.CircleImageView r2 = (de.hdodenhof.circleimageview.CircleImageView) r2
            com.bumptech.glide.request.RequestOptions r5 = new com.bumptech.glide.request.RequestOptions
            r5.<init>()
            r8 = 2131231063(0x7f080157, float:1.8078196E38)
            com.bumptech.glide.request.BaseRequestOptions r5 = r5.placeholder(r8)
            com.bumptech.glide.request.RequestOptions r5 = (com.bumptech.glide.request.RequestOptions) r5
            com.bumptech.glide.request.BaseRequestOptions r5 = r5.error(r8)
            java.lang.String r9 = "RequestOptions().placeho…le.image_default_profile)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r5, r9)
            com.bumptech.glide.request.RequestOptions r5 = (com.bumptech.glide.request.RequestOptions) r5
            java.lang.String r9 = r14.getStatus()
            java.lang.String r10 = "deactivated"
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual(r9, r10)
            if (r9 == 0) goto L_0x03bf
            kr.co.popone.fitts.feature.post.detail.PostActivity r9 = r12.this$0
            com.bumptech.glide.RequestManager r9 = com.bumptech.glide.Glide.with(r9)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            com.bumptech.glide.RequestBuilder r8 = r9.load(r8)
            com.bumptech.glide.RequestBuilder r5 = r8.apply(r5)
            r5.into(r2)
            goto L_0x03d4
        L_0x03bf:
            kr.co.popone.fitts.feature.post.detail.PostActivity r8 = r12.this$0
            com.bumptech.glide.RequestManager r8 = com.bumptech.glide.Glide.with(r8)
            java.lang.String r9 = r14.getProfileImageUrl()
            com.bumptech.glide.RequestBuilder r8 = r8.load(r9)
            com.bumptech.glide.RequestBuilder r5 = r8.apply(r5)
            r5.into(r2)
        L_0x03d4:
            kr.co.popone.fitts.feature.post.detail.PostActivity$onActivityResult$1$$special$$inlined$let$lambda$1 r5 = new kr.co.popone.fitts.feature.post.detail.PostActivity$onActivityResult$1$$special$$inlined$let$lambda$1
            r5.<init>(r14, r12, r13)
            r2.setOnClickListener(r5)
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
            kr.co.popone.fitts.feature.post.detail.PostActivity r2 = r12.this$0
            int r5 = kr.co.popone.fitts.C0010R$id.profile_layout
            android.view.View r2 = r2._$_findCachedViewById(r5)
            android.widget.RelativeLayout r2 = (android.widget.RelativeLayout) r2
            kr.co.popone.fitts.feature.post.detail.PostActivity$onActivityResult$1$$special$$inlined$let$lambda$2 r5 = new kr.co.popone.fitts.feature.post.detail.PostActivity$onActivityResult$1$$special$$inlined$let$lambda$2
            r5.<init>(r14, r12, r13)
            r2.setOnClickListener(r5)
            kr.co.popone.fitts.feature.post.detail.PostActivity r2 = r12.this$0
            int r5 = kr.co.popone.fitts.C0010R$id.follow_button
            android.view.View r2 = r2._$_findCachedViewById(r5)
            android.widget.TextView r2 = (android.widget.TextView) r2
            java.lang.String r5 = r14.getFittsID()
            kr.co.popone.fitts.feature.post.detail.PostActivity r8 = r12.this$0
            kr.co.popone.fitts.base.SessionManager r8 = r8.getSessionManager$app_productionFittsRelease()
            java.lang.String r8 = r8.getFittsID()
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r8)
            if (r5 == 0) goto L_0x0411
            r5 = 8
            goto L_0x0412
        L_0x0411:
            r5 = 0
        L_0x0412:
            r2.setVisibility(r5)
            boolean r5 = r14.isFollowing()
            r8 = 2131099817(0x7f0600a9, float:1.7811998E38)
            java.lang.String r9 = "context"
            if (r5 != r7) goto L_0x0444
            android.content.Context r5 = r2.getContext()
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r5, r9)
            android.content.res.Resources r5 = r5.getResources()
            r9 = 2131755193(0x7f1000b9, float:1.9141258E38)
            java.lang.String r5 = r5.getString(r9)
            r2.setText(r5)
            android.content.Context r5 = r2.getContext()
            r9 = 2131099759(0x7f06006f, float:1.781188E38)
            int r5 = androidx.core.content.ContextCompat.getColor(r5, r9)
            r2.setTextColor(r5)
            goto L_0x0466
        L_0x0444:
            if (r5 != 0) goto L_0x0466
            android.content.Context r5 = r2.getContext()
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r5, r9)
            android.content.res.Resources r5 = r5.getResources()
            r9 = 2131755192(0x7f1000b8, float:1.9141256E38)
            java.lang.String r5 = r5.getString(r9)
            r2.setText(r5)
            android.content.Context r5 = r2.getContext()
            int r5 = androidx.core.content.ContextCompat.getColor(r5, r8)
            r2.setTextColor(r5)
        L_0x0466:
            kr.co.popone.fitts.feature.post.detail.PostActivity$onActivityResult$1$$special$$inlined$let$lambda$3 r5 = new kr.co.popone.fitts.feature.post.detail.PostActivity$onActivityResult$1$$special$$inlined$let$lambda$3
            r5.<init>(r2, r14, r12, r13)
            r2.setOnClickListener(r5)
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            kr.co.popone.fitts.feature.post.detail.PostActivity r14 = r12.this$0
            int r2 = kr.co.popone.fitts.C0010R$id.postProductAboutLabel
            android.view.View r14 = r14._$_findCachedViewById(r2)
            android.widget.TextView r14 = (android.widget.TextView) r14
            java.lang.String r2 = "postProductAboutLabel"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r14, r2)
            kr.co.popone.fitts.feature.post.PostType r2 = r13.postType()
            int[] r5 = kr.co.popone.fitts.feature.post.detail.PostActivity.WhenMappings.$EnumSwitchMapping$6
            int r2 = r2.ordinal()
            r2 = r5[r2]
            if (r2 == r7) goto L_0x049d
            if (r2 == r0) goto L_0x049a
            if (r2 != r6) goto L_0x0494
            java.lang.String r0 = "이 옷에 대해"
            goto L_0x049f
        L_0x0494:
            kotlin.NoWhenBranchMatchedException r13 = new kotlin.NoWhenBranchMatchedException
            r13.<init>()
            throw r13
        L_0x049a:
            java.lang.String r0 = "이 가방에 대해"
            goto L_0x049f
        L_0x049d:
            java.lang.String r0 = "이 신발에 대해"
        L_0x049f:
            r14.setText(r0)
            java.lang.String r14 = r13.getAboutProduct()
            if (r14 == 0) goto L_0x04b1
            boolean r14 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r14)
            if (r14 == 0) goto L_0x04af
            goto L_0x04b1
        L_0x04af:
            r14 = 0
            goto L_0x04b2
        L_0x04b1:
            r14 = 1
        L_0x04b2:
            if (r14 == 0) goto L_0x04dd
            kr.co.popone.fitts.feature.post.detail.PostActivity r14 = r12.this$0
            int r0 = kr.co.popone.fitts.C0010R$id.postFitLayout
            android.view.View r14 = r14._$_findCachedViewById(r0)
            android.widget.LinearLayout r14 = (android.widget.LinearLayout) r14
            java.lang.String r0 = "postFitLayout"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r14, r0)
            r14.setVisibility(r3)
            kr.co.popone.fitts.feature.post.detail.PostActivity r14 = r12.this$0
            int r0 = kr.co.popone.fitts.C0010R$id.post_about_product
            android.view.View r14 = r14._$_findCachedViewById(r0)
            android.widget.TextView r14 = (android.widget.TextView) r14
            java.lang.String r0 = "post_about_product"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r14, r0)
            java.lang.String r0 = r13.getAboutFit()
            r14.setText(r0)
            goto L_0x051b
        L_0x04dd:
            kr.co.popone.fitts.feature.post.detail.PostActivity r14 = r12.this$0
            int r0 = kr.co.popone.fitts.C0010R$id.postFitLayout
            android.view.View r14 = r14._$_findCachedViewById(r0)
            android.widget.LinearLayout r14 = (android.widget.LinearLayout) r14
            java.lang.String r0 = "postFitLayout"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r14, r0)
            r14.setVisibility(r4)
            kr.co.popone.fitts.feature.post.detail.PostActivity r14 = r12.this$0
            int r0 = kr.co.popone.fitts.C0010R$id.post_about_fit
            android.view.View r14 = r14._$_findCachedViewById(r0)
            android.widget.TextView r14 = (android.widget.TextView) r14
            java.lang.String r0 = "post_about_fit"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r14, r0)
            java.lang.String r0 = r13.getAboutFit()
            r14.setText(r0)
            kr.co.popone.fitts.feature.post.detail.PostActivity r14 = r12.this$0
            int r0 = kr.co.popone.fitts.C0010R$id.post_about_product
            android.view.View r14 = r14._$_findCachedViewById(r0)
            android.widget.TextView r14 = (android.widget.TextView) r14
            java.lang.String r0 = "post_about_product"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r14, r0)
            java.lang.String r0 = r13.getAboutProduct()
            r14.setText(r0)
        L_0x051b:
            kr.co.popone.fitts.feature.post.detail.PostActivity r14 = r12.this$0
            java.util.List r14 = r14.postImageList
            r14.clear()
            kr.co.popone.fitts.feature.post.detail.PostActivity r14 = r12.this$0
            java.util.List r14 = r14.postImageList
            java.util.List r0 = r13.getFreeformImages()
            if (r0 == 0) goto L_0x0537
            java.util.List r0 = r13.getFreeformImages()
            r14.addAll(r0)
        L_0x0537:
            java.util.List r0 = r13.getCloseshotImages()
            if (r0 == 0) goto L_0x0544
            java.util.List r0 = r13.getCloseshotImages()
            r14.addAll(r0)
        L_0x0544:
            java.util.List r0 = r13.getFullshotImages()
            if (r0 == 0) goto L_0x0551
            java.util.List r0 = r13.getFullshotImages()
            r14.addAll(r0)
        L_0x0551:
            java.util.List r0 = r13.getDetailImages()
            if (r0 == 0) goto L_0x055e
            java.util.List r0 = r13.getDetailImages()
            r14.addAll(r0)
        L_0x055e:
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            kr.co.popone.fitts.feature.post.detail.PostActivity r14 = r12.this$0
            int r0 = kr.co.popone.fitts.C0010R$id.post_image_list
            android.view.View r14 = r14._$_findCachedViewById(r0)
            androidx.recyclerview.widget.RecyclerView r14 = (androidx.recyclerview.widget.RecyclerView) r14
            kr.co.popone.fitts.feature.post.detail.PostAdapter r0 = new kr.co.popone.fitts.feature.post.detail.PostAdapter
            kr.co.popone.fitts.feature.post.detail.PostActivity r2 = r12.this$0
            kr.co.popone.fitts.feature.post.detail.PostActivity$onActivityResult$1$$special$$inlined$run$lambda$3 r5 = new kr.co.popone.fitts.feature.post.detail.PostActivity$onActivityResult$1$$special$$inlined$run$lambda$3
            r5.<init>(r12)
            r0.<init>(r2, r5)
            r14.setAdapter(r0)
            androidx.recyclerview.widget.LinearLayoutManager r0 = new androidx.recyclerview.widget.LinearLayoutManager
            kr.co.popone.fitts.feature.post.detail.PostActivity r2 = r12.this$0
            r0.<init>(r2)
            r14.setLayoutManager(r0)
            r14.setNestedScrollingEnabled(r4)
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            kr.co.popone.fitts.model.post.PostAPI$LinkInfo r14 = r13.getLinkInfo()
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 21
            if (r0 < r2) goto L_0x05a4
            kr.co.popone.fitts.feature.post.detail.PostActivity r0 = r12.this$0
            int r2 = kr.co.popone.fitts.C0010R$id.post_product_image
            android.view.View r0 = r0._$_findCachedViewById(r2)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            java.lang.String r2 = "post_product_image"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r2)
            r0.setClipToOutline(r7)
        L_0x05a4:
            com.bumptech.glide.request.RequestOptions r0 = new com.bumptech.glide.request.RequestOptions
            r0.<init>()
            r2 = 2131231293(0x7f08023d, float:1.8078663E38)
            com.bumptech.glide.request.BaseRequestOptions r0 = r0.placeholder(r2)
            com.bumptech.glide.request.RequestOptions r0 = (com.bumptech.glide.request.RequestOptions) r0
            com.bumptech.glide.request.BaseRequestOptions r0 = r0.error(r2)
            java.lang.String r2 = "RequestOptions().placeho…(R.drawable.shop_sample1)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r2)
            com.bumptech.glide.request.RequestOptions r0 = (com.bumptech.glide.request.RequestOptions) r0
            kr.co.popone.fitts.feature.post.detail.PostActivity r2 = r12.this$0
            com.bumptech.glide.RequestManager r2 = com.bumptech.glide.Glide.with(r2)
            if (r14 == 0) goto L_0x05cf
            kr.co.popone.fitts.model.datamodel.commerce.Product r5 = r14.getProduct()
            if (r5 == 0) goto L_0x05cf
            java.lang.String r1 = r5.getImageUrl()
        L_0x05cf:
            com.bumptech.glide.RequestBuilder r1 = r2.load(r1)
            com.bumptech.glide.RequestBuilder r0 = r1.apply(r0)
            kr.co.popone.fitts.feature.post.detail.PostActivity r1 = r12.this$0
            int r2 = kr.co.popone.fitts.C0010R$id.post_product_image
            android.view.View r1 = r1._$_findCachedViewById(r2)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            r0.into(r1)
            if (r14 == 0) goto L_0x0654
            kr.co.popone.fitts.model.datamodel.commerce.Shop r0 = r14.getShop()
            if (r0 == 0) goto L_0x0606
            kr.co.popone.fitts.feature.post.detail.PostActivity r0 = r12.this$0
            int r1 = kr.co.popone.fitts.C0010R$id.post_product_shop
            android.view.View r0 = r0._$_findCachedViewById(r1)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r1 = "post_product_shop"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            kr.co.popone.fitts.model.datamodel.commerce.Shop r1 = r14.getShop()
            java.lang.String r1 = r1.getName()
            r0.setText(r1)
        L_0x0606:
            kr.co.popone.fitts.model.datamodel.commerce.Product r0 = r14.getProduct()
            if (r0 == 0) goto L_0x0630
            kr.co.popone.fitts.model.datamodel.commerce.Product r0 = r14.getProduct()
            java.lang.String r0 = r0.getPrice()
            if (r0 == 0) goto L_0x0630
            kr.co.popone.fitts.feature.post.detail.PostActivity r0 = r12.this$0
            int r1 = kr.co.popone.fitts.C0010R$id.post_product_price
            android.view.View r0 = r0._$_findCachedViewById(r1)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r1 = "post_product_price"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            kr.co.popone.fitts.model.datamodel.commerce.Product r14 = r14.getProduct()
            java.lang.String r14 = r14.getPrice()
            r0.setText(r14)
        L_0x0630:
            kr.co.popone.fitts.feature.post.detail.PostActivity r14 = r12.this$0
            int r0 = kr.co.popone.fitts.C0010R$id.post_product
            android.view.View r14 = r14._$_findCachedViewById(r0)
            androidx.constraintlayout.widget.ConstraintLayout r14 = (androidx.constraintlayout.widget.ConstraintLayout) r14
            kr.co.popone.fitts.feature.post.detail.PostActivity$onActivityResult$1$$special$$inlined$let$lambda$4 r0 = new kr.co.popone.fitts.feature.post.detail.PostActivity$onActivityResult$1$$special$$inlined$let$lambda$4
            r0.<init>(r12, r13)
            r14.setOnClickListener(r0)
            kr.co.popone.fitts.feature.post.detail.PostActivity r14 = r12.this$0
            int r0 = kr.co.popone.fitts.C0010R$id.post_product_button
            android.view.View r14 = r14._$_findCachedViewById(r0)
            android.widget.LinearLayout r14 = (android.widget.LinearLayout) r14
            kr.co.popone.fitts.feature.post.detail.PostActivity$onActivityResult$1$$special$$inlined$let$lambda$5 r0 = new kr.co.popone.fitts.feature.post.detail.PostActivity$onActivityResult$1$$special$$inlined$let$lambda$5
            r0.<init>(r12, r13)
            r14.setOnClickListener(r0)
        L_0x0654:
            java.lang.String r14 = r13.getAboutSize()
            if (r14 == 0) goto L_0x0663
            boolean r14 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r14)
            if (r14 == 0) goto L_0x0661
            goto L_0x0663
        L_0x0661:
            r14 = 0
            goto L_0x0664
        L_0x0663:
            r14 = 1
        L_0x0664:
            java.lang.String r0 = "post_product_size"
            if (r14 != 0) goto L_0x069f
            kr.co.popone.fitts.feature.post.detail.PostActivity r14 = r12.this$0
            int r1 = kr.co.popone.fitts.C0010R$id.postProductSizeLabel
            android.view.View r14 = r14._$_findCachedViewById(r1)
            android.widget.TextView r14 = (android.widget.TextView) r14
            java.lang.String r1 = "postProductSizeLabel"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r14, r1)
            r14.setVisibility(r4)
            kr.co.popone.fitts.feature.post.detail.PostActivity r14 = r12.this$0
            int r1 = kr.co.popone.fitts.C0010R$id.post_product_size
            android.view.View r14 = r14._$_findCachedViewById(r1)
            android.widget.TextView r14 = (android.widget.TextView) r14
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r14, r0)
            r14.setVisibility(r4)
            kr.co.popone.fitts.feature.post.detail.PostActivity r14 = r12.this$0
            int r1 = kr.co.popone.fitts.C0010R$id.post_product_size
            android.view.View r14 = r14._$_findCachedViewById(r1)
            android.widget.TextView r14 = (android.widget.TextView) r14
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r14, r0)
            java.lang.String r0 = r13.getAboutSize()
            r14.setText(r0)
            goto L_0x06c1
        L_0x069f:
            kr.co.popone.fitts.feature.post.detail.PostActivity r14 = r12.this$0
            int r1 = kr.co.popone.fitts.C0010R$id.postProductSizeLabel
            android.view.View r14 = r14._$_findCachedViewById(r1)
            android.widget.TextView r14 = (android.widget.TextView) r14
            java.lang.String r1 = "postProductSizeLabel"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r14, r1)
            r14.setVisibility(r3)
            kr.co.popone.fitts.feature.post.detail.PostActivity r14 = r12.this$0
            int r1 = kr.co.popone.fitts.C0010R$id.post_product_size
            android.view.View r14 = r14._$_findCachedViewById(r1)
            android.widget.TextView r14 = (android.widget.TextView) r14
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r14, r0)
            r14.setVisibility(r3)
        L_0x06c1:
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>()
            java.util.List r0 = r13.getStyles()
            if (r0 == 0) goto L_0x06f8
            java.util.List r0 = r13.getStyles()
            java.util.ArrayList r1 = new java.util.ArrayList
            r2 = 10
            int r2 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r0, r2)
            r1.<init>(r2)
            java.util.Iterator r0 = r0.iterator()
        L_0x06e1:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x06f5
            java.lang.Object r2 = r0.next()
            kr.co.popone.fitts.model.post.PostAPI$Style r2 = (kr.co.popone.fitts.model.post.PostAPI.Style) r2
            java.lang.String r2 = r2.getName()
            r1.add(r2)
            goto L_0x06e1
        L_0x06f5:
            r14.addAll(r1)
        L_0x06f8:
            java.util.List r0 = r13.getTags()
            if (r0 == 0) goto L_0x0728
            java.util.List r0 = r13.getTags()
            java.util.ArrayList r1 = new java.util.ArrayList
            r2 = 10
            int r2 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r0, r2)
            r1.<init>(r2)
            java.util.Iterator r0 = r0.iterator()
        L_0x0711:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0725
            java.lang.Object r2 = r0.next()
            kr.co.popone.fitts.model.post.PostAPI$Tag r2 = (kr.co.popone.fitts.model.post.PostAPI.Tag) r2
            java.lang.String r2 = r2.getTitle()
            r1.add(r2)
            goto L_0x0711
        L_0x0725:
            r14.addAll(r1)
        L_0x0728:
            kotlin.collections.CollectionsKt___CollectionsKt.distinct(r14)
            kr.co.popone.fitts.feature.post.detail.PostActivity r0 = r12.this$0
            int r1 = kr.co.popone.fitts.C0010R$id.post_tag
            android.view.View r0 = r0._$_findCachedViewById(r1)
            me.gujun.android.taggroup.TagGroup r0 = (me.gujun.android.taggroup.TagGroup) r0
            r0.setTags(r14)
            kr.co.popone.fitts.feature.post.detail.PostActivity r14 = r12.this$0
            int r0 = kr.co.popone.fitts.C0010R$id.post_tag
            android.view.View r14 = r14._$_findCachedViewById(r0)
            me.gujun.android.taggroup.TagGroup r14 = (me.gujun.android.taggroup.TagGroup) r14
            kr.co.popone.fitts.feature.post.detail.PostActivity$onActivityResult$1$9 r0 = new kr.co.popone.fitts.feature.post.detail.PostActivity$onActivityResult$1$9
            r0.<init>(r12)
            r14.setOnTagClickListener(r0)
            kr.co.popone.fitts.feature.post.detail.PostActivity r14 = r12.this$0
            int r0 = kr.co.popone.fitts.C0010R$id.comment_button
            android.view.View r14 = r14._$_findCachedViewById(r0)
            android.widget.LinearLayout r14 = (android.widget.LinearLayout) r14
            kr.co.popone.fitts.feature.post.detail.PostActivity$onActivityResult$1$10 r0 = new kr.co.popone.fitts.feature.post.detail.PostActivity$onActivityResult$1$10
            r0.<init>(r12, r13)
            r14.setOnClickListener(r0)
            kr.co.popone.fitts.feature.post.detail.PostActivity r14 = r12.this$0
            int r0 = kr.co.popone.fitts.C0010R$id.like_image
            android.view.View r14 = r14._$_findCachedViewById(r0)
            android.widget.ImageView r14 = (android.widget.ImageView) r14
            boolean r0 = r13.isLiked()
            if (r0 != r7) goto L_0x077c
            kr.co.popone.fitts.feature.post.detail.PostActivity r0 = r12.this$0
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r7)
            r0.isLiked = r1
            r0 = 2131230905(0x7f0800b9, float:1.8077876E38)
            r14.setBackgroundResource(r0)
            goto L_0x078d
        L_0x077c:
            if (r0 != 0) goto L_0x078d
            kr.co.popone.fitts.feature.post.detail.PostActivity r0 = r12.this$0
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r4)
            r0.isLiked = r1
            r0 = 2131230907(0x7f0800bb, float:1.807788E38)
            r14.setBackgroundResource(r0)
        L_0x078d:
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            kr.co.popone.fitts.feature.post.detail.PostActivity r14 = r12.this$0
            int r0 = kr.co.popone.fitts.C0010R$id.like_count
            android.view.View r14 = r14._$_findCachedViewById(r0)
            android.widget.TextView r14 = (android.widget.TextView) r14
            kr.co.popone.fitts.feature.post.detail.PostActivity r0 = r12.this$0
            int r1 = r13.getLikesCount()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.likeCount = r1
            boolean r0 = r13.isLiked()
            if (r0 != r7) goto L_0x07bd
            kr.co.popone.fitts.feature.post.detail.PostActivity r0 = r12.this$0
            int r0 = androidx.core.content.ContextCompat.getColor(r0, r8)
            r14.setTextColor(r0)
            android.graphics.Typeface r0 = r14.getTypeface()
            r14.setTypeface(r0, r7)
            goto L_0x07d6
        L_0x07bd:
            if (r0 != 0) goto L_0x07d6
            kr.co.popone.fitts.feature.post.detail.PostActivity r0 = r12.this$0
            r1 = 2131099765(0x7f060075, float:1.7811892E38)
            int r0 = androidx.core.content.ContextCompat.getColor(r0, r1)
            r14.setTextColor(r0)
            android.graphics.Typeface r0 = r14.getTypeface()
            android.graphics.Typeface r0 = android.graphics.Typeface.create(r0, r4)
            r14.setTypeface(r0)
        L_0x07d6:
            kr.co.popone.fitts.utils.UIExtensions r0 = kr.co.popone.fitts.utils.UIExtensions.INSTANCE
            kr.co.popone.fitts.model.datamodel.service.user.User r1 = r13.getUser()
            long r1 = r1.getId()
            kr.co.popone.fitts.feature.post.detail.PostActivity r3 = r12.this$0
            kr.co.popone.fitts.base.SessionManager r3 = r3.getSessionManager$app_productionFittsRelease()
            long r5 = r3.getUserID()
            int r3 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r3 != 0) goto L_0x07ef
            r4 = 1
        L_0x07ef:
            boolean r1 = r13.isLiked()
            int r2 = r13.getLikesCount()
            java.lang.String r0 = r0.likeCountText(r4, r1, r2)
            r14.setText(r0)
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            kr.co.popone.fitts.feature.post.detail.PostActivity r14 = r12.this$0
            int r0 = kr.co.popone.fitts.C0010R$id.like_button
            android.view.View r14 = r14._$_findCachedViewById(r0)
            android.widget.LinearLayout r14 = (android.widget.LinearLayout) r14
            kr.co.popone.fitts.feature.post.detail.PostActivity$onActivityResult$1$13 r0 = new kr.co.popone.fitts.feature.post.detail.PostActivity$onActivityResult$1$13
            r0.<init>(r12, r13)
            r14.setOnClickListener(r0)
            kr.co.popone.fitts.feature.post.detail.PostActivity r14 = r12.this$0
            int r0 = kr.co.popone.fitts.C0010R$id.post_setting_button
            android.view.View r14 = r14._$_findCachedViewById(r0)
            android.widget.ImageButton r14 = (android.widget.ImageButton) r14
            kr.co.popone.fitts.feature.post.detail.PostActivity$onActivityResult$1$14 r0 = new kr.co.popone.fitts.feature.post.detail.PostActivity$onActivityResult$1$14
            r0.<init>(r12, r13)
            r14.setOnClickListener(r0)
            goto L_0x08aa
        L_0x0826:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r1 = "error occured "
            r13.append(r1)
            r13.append(r14)
            java.lang.String r13 = r13.toString()
            java.lang.Object[] r1 = new java.lang.Object[r4]
            com.orhanobut.logger.Logger.d(r13, r1)
            boolean r13 = r14 instanceof retrofit2.HttpException
            if (r13 == 0) goto L_0x08a1
            retrofit2.HttpException r14 = (retrofit2.HttpException) r14
            int r13 = r14.code()
            r1 = 401(0x191, float:5.62E-43)
            if (r13 != r1) goto L_0x0864
            android.content.Intent r13 = new android.content.Intent
            kr.co.popone.fitts.feature.post.detail.PostActivity r14 = r12.this$0
            java.lang.Class<kr.co.popone.fitts.feature.intro.IntroActivity> r0 = kr.co.popone.fitts.feature.intro.IntroActivity.class
            r13.<init>(r14, r0)
            r14 = 32768(0x8000, float:4.5918E-41)
            r13.addFlags(r14)
            r14 = 268435456(0x10000000, float:2.5243549E-29)
            r13.addFlags(r14)
            kr.co.popone.fitts.feature.post.detail.PostActivity r14 = r12.this$0
            r14.startActivity(r13)
            goto L_0x08aa
        L_0x0864:
            int r13 = r14.code()
            r14 = 403(0x193, float:5.65E-43)
            if (r13 != r14) goto L_0x08aa
            kr.co.popone.fitts.feature.post.detail.PostActivity r13 = r12.this$0
            int r14 = kr.co.popone.fitts.C0010R$id.scrollview
            android.view.View r13 = r13._$_findCachedViewById(r14)
            androidx.core.widget.NestedScrollView r13 = (androidx.core.widget.NestedScrollView) r13
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r13, r2)
            r13.setVisibility(r3)
            kr.co.popone.fitts.feature.post.detail.PostActivity r13 = r12.this$0
            int r14 = kr.co.popone.fitts.C0010R$id.layout_post_bottombar
            android.view.View r13 = r13._$_findCachedViewById(r14)
            androidx.constraintlayout.widget.ConstraintLayout r13 = (androidx.constraintlayout.widget.ConstraintLayout) r13
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r13, r0)
            r13.setVisibility(r3)
            kr.co.popone.fitts.ui.DialogExtensions r4 = kr.co.popone.fitts.ui.DialogExtensions.INSTANCE
            kr.co.popone.fitts.feature.post.detail.PostActivity r5 = r12.this$0
            kr.co.popone.fitts.feature.post.detail.PostActivity$onActivityResult$1$15 r8 = new kr.co.popone.fitts.feature.post.detail.PostActivity$onActivityResult$1$15
            r8.<init>(r12)
            r9 = 0
            r10 = 16
            r11 = 0
            java.lang.String r6 = ""
            java.lang.String r7 = "죄송합니다.\n해당 포스트는 일시적으로 이용할 수 없는 상태입니다."
            kr.co.popone.fitts.ui.DialogExtensions.showMessageDialog$default(r4, r5, r6, r7, r8, r9, r10, r11)
            goto L_0x08aa
        L_0x08a1:
            kr.co.popone.fitts.utils.Snackbar$Companion r13 = kr.co.popone.fitts.utils.Snackbar.Companion
            kr.co.popone.fitts.feature.post.detail.PostActivity r14 = r12.this$0
            java.lang.String r0 = "죄송합니다.\n서비스가 잠시 지연되고 있습니다.\n잠시 후 다시 이용해주세요."
            r13.showMessage(r14, r0)
        L_0x08aa:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.feature.post.detail.PostActivity$onActivityResult$1.accept(kr.co.popone.fitts.model.post.PostAPI$Post, java.lang.Throwable):void");
    }
}
