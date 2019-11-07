package kr.co.popone.fitts.feature.me;

import android.widget.ImageView;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.ui.ViewExtensionsKt;

final class MeFragment$requestMyBanner$2<T> implements Consumer<Throwable> {
    final /* synthetic */ MeFragment this$0;

    MeFragment$requestMyBanner$2(MeFragment meFragment) {
        this.this$0 = meFragment;
    }

    public final void accept(Throwable th) {
        ImageView imageView = (ImageView) this.this$0._$_findCachedViewById(C0010R$id.imageBanner);
        Intrinsics.checkExpressionValueIsNotNull(imageView, "imageBanner");
        ViewExtensionsKt.gone(imageView);
    }
}
