package kr.co.popone.fitts.feature.collection;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.schedulers.Schedulers;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0001R$anim;
import kr.co.popone.fitts.eventtracker.EventTracker.CustomAttributes;
import kr.co.popone.fitts.feature.collection.PromotionCollectionAdapter.Delegate;
import kr.co.popone.fitts.feature.post.detail.PostActivity;
import kr.co.popone.fitts.model.collection.CollectionAPI.CollectionEntry;
import kr.co.popone.fitts.model.datamodel.service.user.User;
import kr.co.popone.fitts.model.post.PostAPI.Post;
import kr.co.popone.fitts.services.FittsSchemeHandler;
import org.jetbrains.anko.internals.AnkoInternals;
import org.jetbrains.annotations.Nullable;

public final class PromotionCollectionActivity$onCreate$3 implements Delegate {
    final /* synthetic */ PromotionCollectionActivity this$0;

    PromotionCollectionActivity$onCreate$3(PromotionCollectionActivity promotionCollectionActivity) {
        this.this$0 = promotionCollectionActivity;
    }

    public void onFollowButtonClicked(int i) {
        Disposable disposable;
        Post post = ((CollectionEntry) PromotionCollectionActivity.access$getCollectionAdapter$p(this.this$0).getCollectionItems().get(i)).getPost();
        if (post == null) {
            Intrinsics.throwNpe();
        }
        long id = post.getUser().getId();
        if (!this.this$0.fittieFollowRequests.containsKey(Long.valueOf(id))) {
            Map access$getFittieFollowRequests$p = this.this$0.fittieFollowRequests;
            Long valueOf = Long.valueOf(id);
            if (post.getUser().isFollowing()) {
                disposable = this.this$0.getUserAPI().deleteFollow(id).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new PromotionCollectionActivity$onCreate$3$onFollowButtonClicked$1<Object,Object>(this, id));
            } else {
                this.this$0.getEventTracker$app_productionFittsRelease().logCustom("Like", new CustomAttributes().put("from", "collection"));
                disposable = this.this$0.getUserAPI().putFollow(id).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new PromotionCollectionActivity$onCreate$3$onFollowButtonClicked$2<Object,Object>(this, id));
            }
            Intrinsics.checkExpressionValueIsNotNull(disposable, "if (post.user.isFollowin…      }\n                }");
            access$getFittieFollowRequests$p.put(valueOf, disposable);
        }
    }

    public void onLikeButtonClicked(int i) {
        Disposable disposable;
        Post post = ((CollectionEntry) PromotionCollectionActivity.access$getCollectionAdapter$p(this.this$0).getCollectionItems().get(i)).getPost();
        if (post == null) {
            Intrinsics.throwNpe();
        }
        long id = post.getId();
        boolean isLiked = post.isLiked();
        if (!this.this$0.postLikeRequests.containsKey(Long.valueOf(id))) {
            Map access$getPostLikeRequests$p = this.this$0.postLikeRequests;
            Long valueOf = Long.valueOf(id);
            if (isLiked) {
                disposable = this.this$0.getPostAPI$app_productionFittsRelease().deleteLikes(id).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new PromotionCollectionActivity$onCreate$3$onLikeButtonClicked$1<Object,Object>(this, id));
            } else {
                disposable = this.this$0.getPostAPI$app_productionFittsRelease().putLikes(id).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new PromotionCollectionActivity$onCreate$3$onLikeButtonClicked$2<Object,Object>(this, id));
            }
            Intrinsics.checkExpressionValueIsNotNull(disposable, "if (isLiked) {\n         …      }\n                }");
            access$getPostLikeRequests$p.put(valueOf, disposable);
        }
    }

    @Nullable
    public String getFittsID() {
        return this.this$0.getSessionManager$app_productionFittsRelease().getFittsID();
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0016  */
    /* JADX WARNING: Removed duplicated region for block: B:9:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActionButtonClicked() {
        /*
            r3 = this;
            kr.co.popone.fitts.feature.collection.PromotionCollectionActivity r0 = r3.this$0
            kr.co.popone.fitts.model.collection.CollectionAPI$CollectionDetailResponse r0 = r0.collectionDetailResponse
            if (r0 == 0) goto L_0x0013
            kr.co.popone.fitts.model.collection.CollectionAPI$CollectionDetailResponse$ButtonProperties r0 = r0.getButtonProperties()
            if (r0 == 0) goto L_0x0013
            java.lang.String r0 = r0.getActionScheme()
            goto L_0x0014
        L_0x0013:
            r0 = 0
        L_0x0014:
            if (r0 == 0) goto L_0x0021
            kr.co.popone.fitts.feature.collection.PromotionCollectionActivity r1 = r3.this$0
            kr.co.popone.fitts.services.FittsSchemeHandler r1 = r1.getSchemeHandler$app_productionFittsRelease()
            kr.co.popone.fitts.feature.collection.PromotionCollectionActivity r2 = r3.this$0
            r1.handleScheme(r2, r0)
        L_0x0021:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.feature.collection.PromotionCollectionActivity$onCreate$3.onActionButtonClicked():void");
    }

    public void showShowroom(int i) {
        Long l;
        FittsSchemeHandler schemeHandler$app_productionFittsRelease = this.this$0.getSchemeHandler$app_productionFittsRelease();
        PromotionCollectionActivity promotionCollectionActivity = this.this$0;
        StringBuilder sb = new StringBuilder();
        sb.append("fitts://showroom/");
        Post post = ((CollectionEntry) PromotionCollectionActivity.access$getCollectionAdapter$p(this.this$0).getCollectionItems().get(i)).getPost();
        if (post != null) {
            User user = post.getUser();
            if (user != null) {
                l = Long.valueOf(user.getId());
                sb.append(l);
                schemeHandler$app_productionFittsRelease.handleScheme(promotionCollectionActivity, sb.toString());
            }
        }
        l = null;
        sb.append(l);
        schemeHandler$app_productionFittsRelease.handleScheme(promotionCollectionActivity, sb.toString());
    }

    public void showPost(int i) {
        Post post = ((CollectionEntry) PromotionCollectionActivity.access$getCollectionAdapter$p(this.this$0).getCollectionItems().get(i)).getPost();
        Long valueOf = post != null ? Long.valueOf(post.getId()) : null;
        if (valueOf != null) {
            this.this$0.getEventTracker$app_productionFittsRelease().logCustom("View Post", new CustomAttributes().put("from", "collection"));
            this.this$0.getActionLogUtil$app_productionFittsRelease().defineCurrentWindow("Collection", "", this.this$0.getIntent().getLongExtra("id", -1));
            PromotionCollectionActivity promotionCollectionActivity = this.this$0;
            promotionCollectionActivity.startActivity(AnkoInternals.createIntent(promotionCollectionActivity, PostActivity.class, new Pair[]{TuplesKt.to("post_id", valueOf)}));
            this.this$0.overridePendingTransition(C0001R$anim.slide_right, C0001R$anim.fade_out);
        }
    }
}
