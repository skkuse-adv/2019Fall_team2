package kr.co.popone.fitts.feature.store.bridge.product;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.widget.ImageButton;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.OnScrollListener;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import org.jetbrains.annotations.NotNull;

public final class ProductBridgeActivity$onCreate$$inlined$apply$lambda$2 extends OnScrollListener {
    private int overallYScroll;
    final /* synthetic */ ProductBridgeActivity this$0;

    ProductBridgeActivity$onCreate$$inlined$apply$lambda$2(ProductBridgeActivity productBridgeActivity) {
        this.this$0 = productBridgeActivity;
    }

    public void onScrolled(@NotNull RecyclerView recyclerView, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(recyclerView, "recyclerView");
        double d = (double) this.overallYScroll;
        double access$getHEADER_HEIGHT$p = this.this$0.getHEADER_HEIGHT();
        String str = "backgroundColor";
        String str2 = "transparent";
        String str3 = "white";
        String str4 = "toolbar";
        Integer valueOf = Integer.valueOf(0);
        if (d > access$getHEADER_HEIGHT$p) {
            Toolbar toolbar = (Toolbar) this.this$0._$_findCachedViewById(C0010R$id.toolbar);
            Intrinsics.checkExpressionValueIsNotNull(toolbar, str4);
            if (Intrinsics.areEqual(toolbar.getTag(), (Object) str2)) {
                ObjectAnimator ofObject = ObjectAnimator.ofObject((Toolbar) this.this$0._$_findCachedViewById(C0010R$id.toolbar), str, new ArgbEvaluator(), new Object[]{valueOf, Integer.valueOf((int) 4294967295L)});
                ((ImageButton) this.this$0._$_findCachedViewById(C0010R$id.buttonBack)).setColorFilter(Color.argb(150, 0, 0, 0));
                ofObject.setDuration(500);
                Toolbar toolbar2 = (Toolbar) this.this$0._$_findCachedViewById(C0010R$id.toolbar);
                Intrinsics.checkExpressionValueIsNotNull(toolbar2, str4);
                toolbar2.setTag(str3);
                ofObject.start();
            }
        } else {
            Toolbar toolbar3 = (Toolbar) this.this$0._$_findCachedViewById(C0010R$id.toolbar);
            Intrinsics.checkExpressionValueIsNotNull(toolbar3, str4);
            if (Intrinsics.areEqual(toolbar3.getTag(), (Object) str3)) {
                ObjectAnimator ofObject2 = ObjectAnimator.ofObject((Toolbar) this.this$0._$_findCachedViewById(C0010R$id.toolbar), str, new ArgbEvaluator(), new Object[]{Integer.valueOf((int) 4294967295L), valueOf});
                ((ImageButton) this.this$0._$_findCachedViewById(C0010R$id.buttonBack)).setColorFilter(Color.argb(255, 255, 255, 255));
                ofObject2.setDuration(500);
                Toolbar toolbar4 = (Toolbar) this.this$0._$_findCachedViewById(C0010R$id.toolbar);
                Intrinsics.checkExpressionValueIsNotNull(toolbar4, str4);
                toolbar4.setTag(str2);
                ofObject2.start();
            }
        }
        this.overallYScroll += i2;
    }
}
