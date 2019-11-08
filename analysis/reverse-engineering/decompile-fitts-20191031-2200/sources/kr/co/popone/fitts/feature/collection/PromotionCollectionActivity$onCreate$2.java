package kr.co.popone.fitts.feature.collection;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.OnScrollListener;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import org.jetbrains.annotations.NotNull;

public final class PromotionCollectionActivity$onCreate$2 extends OnScrollListener {
    final /* synthetic */ int $verticalPx;
    private int positionY;
    final /* synthetic */ PromotionCollectionActivity this$0;

    PromotionCollectionActivity$onCreate$2(PromotionCollectionActivity promotionCollectionActivity, int i) {
        this.this$0 = promotionCollectionActivity;
        this.$verticalPx = i;
    }

    public void onScrolled(@NotNull RecyclerView recyclerView, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(recyclerView, "recyclerView");
        this.positionY += i2;
        int i3 = this.positionY;
        int i4 = this.$verticalPx;
        String str = "toolbarTitle";
        String str2 = "backgroundColor";
        String str3 = "transparent";
        String str4 = "white";
        String str5 = "toolbar";
        Integer valueOf = Integer.valueOf(0);
        if (i3 > i4) {
            Toolbar toolbar = (Toolbar) this.this$0._$_findCachedViewById(C0010R$id.toolbar);
            Intrinsics.checkExpressionValueIsNotNull(toolbar, str5);
            if (Intrinsics.areEqual(toolbar.getTag(), (Object) str3)) {
                ObjectAnimator ofObject = ObjectAnimator.ofObject((Toolbar) this.this$0._$_findCachedViewById(C0010R$id.toolbar), str2, new ArgbEvaluator(), new Object[]{valueOf, Integer.valueOf((int) 4294967295L)});
                ofObject.setDuration(200);
                ((ImageButton) this.this$0._$_findCachedViewById(C0010R$id.backButton)).setColorFilter(Color.argb(150, 0, 0, 0));
                TextView textView = (TextView) this.this$0._$_findCachedViewById(C0010R$id.toolbarTitle);
                Intrinsics.checkExpressionValueIsNotNull(textView, str);
                textView.setVisibility(0);
                Toolbar toolbar2 = (Toolbar) this.this$0._$_findCachedViewById(C0010R$id.toolbar);
                Intrinsics.checkExpressionValueIsNotNull(toolbar2, str5);
                toolbar2.setTag(str4);
                ofObject.start();
                return;
            }
            return;
        }
        Toolbar toolbar3 = (Toolbar) this.this$0._$_findCachedViewById(C0010R$id.toolbar);
        Intrinsics.checkExpressionValueIsNotNull(toolbar3, str5);
        if (Intrinsics.areEqual(toolbar3.getTag(), (Object) str4)) {
            ObjectAnimator ofObject2 = ObjectAnimator.ofObject((Toolbar) this.this$0._$_findCachedViewById(C0010R$id.toolbar), str2, new ArgbEvaluator(), new Object[]{Integer.valueOf((int) 4294967295L), valueOf});
            ofObject2.setDuration(200);
            ((ImageButton) this.this$0._$_findCachedViewById(C0010R$id.backButton)).setColorFilter(Color.argb(255, 255, 255, 255));
            TextView textView2 = (TextView) this.this$0._$_findCachedViewById(C0010R$id.toolbarTitle);
            Intrinsics.checkExpressionValueIsNotNull(textView2, str);
            textView2.setVisibility(8);
            Toolbar toolbar4 = (Toolbar) this.this$0._$_findCachedViewById(C0010R$id.toolbar);
            Intrinsics.checkExpressionValueIsNotNull(toolbar4, str5);
            toolbar4.setTag(str3);
            ofObject2.start();
        }
    }
}
