package kr.co.popone.fitts.feature.post.detail;

import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0001R$anim;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.feature.store.browser.StoreBrowserActivity;
import kr.co.popone.fitts.feature.store.browser.StoreBrowserActivity.Companion;
import kr.co.popone.fitts.model.store.StoreInfo;
import kr.co.popone.fitts.ui.ViewExtensionsKt;

final class PostActivity$checkPartnerStore$$inlined$let$lambda$1<T> implements Consumer<StoreInfo> {
    final /* synthetic */ String $url$inlined;
    final /* synthetic */ PostActivity this$0;

    PostActivity$checkPartnerStore$$inlined$let$lambda$1(PostActivity postActivity, String str) {
        this.this$0 = postActivity;
        this.$url$inlined = str;
    }

    public final void accept(StoreInfo storeInfo) {
        ((LinearLayout) this.this$0._$_findCachedViewById(C0010R$id.layoutFittsStoreMark)).startAnimation(AnimationUtils.loadAnimation(this.this$0, C0001R$anim.scale_up_pivot_x_70));
        ImageView imageView = (ImageView) this.this$0._$_findCachedViewById(C0010R$id.imageFittsStoreMark);
        Intrinsics.checkExpressionValueIsNotNull(imageView, "imageFittsStoreMark");
        ViewExtensionsKt.visible(imageView);
        this.this$0.showDetailInfoView = new Function0<Unit>(this) {
            final /* synthetic */ PostActivity$checkPartnerStore$$inlined$let$lambda$1 this$0;

            {
                this.this$0 = r1;
            }

            public final void invoke() {
                Companion companion = StoreBrowserActivity.Companion;
                PostActivity$checkPartnerStore$$inlined$let$lambda$1 postActivity$checkPartnerStore$$inlined$let$lambda$1 = this.this$0;
                PostActivity postActivity = postActivity$checkPartnerStore$$inlined$let$lambda$1.this$0;
                companion.start(postActivity, postActivity$checkPartnerStore$$inlined$let$lambda$1.$url$inlined, "post", null, postActivity.postID);
                this.this$0.this$0.productFromPostActionLog();
            }
        };
    }
}
