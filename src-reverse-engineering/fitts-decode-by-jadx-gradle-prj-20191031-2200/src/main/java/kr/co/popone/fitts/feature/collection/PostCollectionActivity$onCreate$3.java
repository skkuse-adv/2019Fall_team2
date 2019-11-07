package kr.co.popone.fitts.feature.collection;

import android.content.Intent;
import androidx.core.app.ActivityOptionsCompat;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0001R$anim;
import kr.co.popone.fitts.eventtracker.EventTracker.CustomAttributes;
import kr.co.popone.fitts.feature.collection.PostCollectionAdapter.Delegate;
import kr.co.popone.fitts.feature.post.detail.PostActivity;
import kr.co.popone.fitts.feature.search.ShopWebViewActivity;
import kr.co.popone.fitts.feature.search.ShopWebViewActivity.Parameters;
import kr.co.popone.fitts.model.collection.CollectionAPI.CollectionEntry;
import kr.co.popone.fitts.model.datamodel.commerce.Shop;
import kr.co.popone.fitts.model.datamodel.service.user.User;
import kr.co.popone.fitts.model.post.PostAPI.LinkInfo;
import kr.co.popone.fitts.model.post.PostAPI.Post;
import kr.co.popone.fitts.services.FittsSchemeHandler;
import org.jetbrains.anko.internals.AnkoInternals;

public final class PostCollectionActivity$onCreate$3 implements Delegate {
    final /* synthetic */ PostCollectionActivity this$0;

    PostCollectionActivity$onCreate$3(PostCollectionActivity postCollectionActivity) {
        this.this$0 = postCollectionActivity;
    }

    public void showProductInfo(int i) {
        Post post = ((CollectionEntry) PostCollectionActivity.access$getCollectionAdapter$p(this.this$0).getCollectionItems().get(i)).getPost();
        String str = null;
        LinkInfo linkInfo = post != null ? post.getLinkInfo() : null;
        if (linkInfo != null) {
            String linkUrl = linkInfo.getLinkUrl();
            if (!StringsKt__StringsJVMKt.startsWith$default(linkUrl, "http", false, 2, null)) {
                StringBuilder sb = new StringBuilder();
                sb.append("http://");
                sb.append(linkUrl);
                linkUrl = sb.toString();
            }
            String str2 = linkUrl;
            Intent intent = new Intent(this.this$0, ShopWebViewActivity.class);
            Shop shop = linkInfo.getShop();
            if (shop != null) {
                str = shop.getName();
            }
            Parameters parameters = new Parameters(str2, str, false, null, null, null, null, 124, null);
            intent.putExtra("parameters", parameters);
            ActivityOptionsCompat makeCustomAnimation = ActivityOptionsCompat.makeCustomAnimation(this.this$0, C0001R$anim.slide_up, C0001R$anim.fade_out);
            Intrinsics.checkExpressionValueIsNotNull(makeCustomAnimation, "ActivityOptionsCompat.ma…lide_up, R.anim.fade_out)");
            this.this$0.startActivity(intent, makeCustomAnimation.toBundle());
        }
    }

    public void showShowroom(int i) {
        Long l;
        FittsSchemeHandler schemeHandler$app_productionFittsRelease = this.this$0.getSchemeHandler$app_productionFittsRelease();
        PostCollectionActivity postCollectionActivity = this.this$0;
        StringBuilder sb = new StringBuilder();
        sb.append("fitts://showroom/");
        Post post = ((CollectionEntry) PostCollectionActivity.access$getCollectionAdapter$p(this.this$0).getCollectionItems().get(i)).getPost();
        if (post != null) {
            User user = post.getUser();
            if (user != null) {
                l = Long.valueOf(user.getId());
                sb.append(l);
                schemeHandler$app_productionFittsRelease.handleScheme(postCollectionActivity, sb.toString());
            }
        }
        l = null;
        sb.append(l);
        schemeHandler$app_productionFittsRelease.handleScheme(postCollectionActivity, sb.toString());
    }

    public void showPost(int i) {
        Post post = ((CollectionEntry) PostCollectionActivity.access$getCollectionAdapter$p(this.this$0).getCollectionItems().get(i)).getPost();
        Long valueOf = post != null ? Long.valueOf(post.getId()) : null;
        if (valueOf != null) {
            this.this$0.getEventTracker$app_productionFittsRelease().logCustom("View Post", new CustomAttributes().put("from", "collection"));
            this.this$0.getActionLogUtil$app_productionFittsRelease().defineCurrentWindow("Collection", "", this.this$0.getIntent().getLongExtra("id", -1));
            PostCollectionActivity postCollectionActivity = this.this$0;
            postCollectionActivity.startActivity(AnkoInternals.createIntent(postCollectionActivity, PostActivity.class, new Pair[]{TuplesKt.to("post_id", valueOf)}));
            this.this$0.overridePendingTransition(C0001R$anim.slide_right, C0001R$anim.fade_out);
        }
    }
}
