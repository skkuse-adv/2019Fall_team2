package kr.co.popone.fitts.feature.post.detail;

import android.widget.ImageView;
import android.widget.LinearLayout;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.feature.store.bridge.product.ProductBridgeActivity;
import kr.co.popone.fitts.feature.store.bridge.product.ProductBridgeActivity.Companion;
import kr.co.popone.fitts.ui.ViewExtensionsKt;

final class PostActivity$checkPartnerStore$$inlined$let$lambda$2<T> implements Consumer<Throwable> {
    final /* synthetic */ PostActivity this$0;

    PostActivity$checkPartnerStore$$inlined$let$lambda$2(PostActivity postActivity, String str) {
        this.this$0 = postActivity;
    }

    public final void accept(Throwable th) {
        LinearLayout linearLayout = (LinearLayout) this.this$0._$_findCachedViewById(C0010R$id.layoutFittsStoreMark);
        Intrinsics.checkExpressionValueIsNotNull(linearLayout, "layoutFittsStoreMark");
        ViewExtensionsKt.gone(linearLayout);
        ImageView imageView = (ImageView) this.this$0._$_findCachedViewById(C0010R$id.imageFittsStoreMark);
        Intrinsics.checkExpressionValueIsNotNull(imageView, "imageFittsStoreMark");
        ViewExtensionsKt.gone(imageView);
        this.this$0.showDetailInfoView = new Function0<Unit>(this) {
            final /* synthetic */ PostActivity$checkPartnerStore$$inlined$let$lambda$2 this$0;

            {
                this.this$0 = r1;
            }

            public final void invoke() {
                Long access$getPostID$p = this.this$0.this$0.postID;
                if (access$getPostID$p != null) {
                    long longValue = access$getPostID$p.longValue();
                    Companion companion = ProductBridgeActivity.Companion;
                    PostActivity postActivity = this.this$0.this$0;
                    companion.start(postActivity, longValue, postActivity.hasProductInfo(), true);
                }
            }
        };
    }
}
