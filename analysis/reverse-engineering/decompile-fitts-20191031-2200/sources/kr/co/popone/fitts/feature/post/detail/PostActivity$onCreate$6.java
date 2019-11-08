package kr.co.popone.fitts.feature.post.detail;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.widget.ImageButton;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.core.widget.NestedScrollView.OnScrollChangeListener;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import org.jetbrains.annotations.Nullable;

final class PostActivity$onCreate$6 implements OnScrollChangeListener {
    final /* synthetic */ PostActivity this$0;

    PostActivity$onCreate$6(PostActivity postActivity) {
        this.this$0 = postActivity;
    }

    public final void onScrollChange(@Nullable NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
        String str = "backgroundColor";
        String str2 = "transparent";
        String str3 = "white";
        String str4 = "toolbar";
        Integer valueOf = Integer.valueOf(0);
        if (i2 <= i4) {
            this.this$0.hideKeyboard();
            if (i2 < 1200) {
                Toolbar toolbar = (Toolbar) this.this$0._$_findCachedViewById(C0010R$id.toolbar);
                Intrinsics.checkExpressionValueIsNotNull(toolbar, str4);
                if (Intrinsics.areEqual(toolbar.getTag(), (Object) str3)) {
                    ObjectAnimator ofObject = ObjectAnimator.ofObject((Toolbar) this.this$0._$_findCachedViewById(C0010R$id.toolbar), str, new ArgbEvaluator(), new Object[]{Integer.valueOf((int) 4294967295L), valueOf});
                    ofObject.setDuration(200);
                    ofObject.start();
                    ((ImageButton) this.this$0._$_findCachedViewById(C0010R$id.back)).setColorFilter(Color.argb(255, 255, 255, 255));
                    ((ImageButton) this.this$0._$_findCachedViewById(C0010R$id.home)).setColorFilter(Color.argb(255, 255, 255, 255));
                    Toolbar toolbar2 = (Toolbar) this.this$0._$_findCachedViewById(C0010R$id.toolbar);
                    Intrinsics.checkExpressionValueIsNotNull(toolbar2, str4);
                    toolbar2.setTag(str2);
                }
            }
        } else if (i2 > 1200) {
            Toolbar toolbar3 = (Toolbar) this.this$0._$_findCachedViewById(C0010R$id.toolbar);
            Intrinsics.checkExpressionValueIsNotNull(toolbar3, str4);
            if (Intrinsics.areEqual(toolbar3.getTag(), (Object) str2)) {
                ObjectAnimator ofObject2 = ObjectAnimator.ofObject((Toolbar) this.this$0._$_findCachedViewById(C0010R$id.toolbar), str, new ArgbEvaluator(), new Object[]{valueOf, Integer.valueOf((int) 4294967295L)});
                ofObject2.setDuration(200);
                ofObject2.start();
                ((ImageButton) this.this$0._$_findCachedViewById(C0010R$id.back)).setColorFilter(Color.argb(150, 0, 0, 0));
                ((ImageButton) this.this$0._$_findCachedViewById(C0010R$id.home)).setColorFilter(Color.argb(150, 0, 0, 0));
                Toolbar toolbar4 = (Toolbar) this.this$0._$_findCachedViewById(C0010R$id.toolbar);
                Intrinsics.checkExpressionValueIsNotNull(toolbar4, str4);
                toolbar4.setTag(str3);
            }
        }
    }
}
