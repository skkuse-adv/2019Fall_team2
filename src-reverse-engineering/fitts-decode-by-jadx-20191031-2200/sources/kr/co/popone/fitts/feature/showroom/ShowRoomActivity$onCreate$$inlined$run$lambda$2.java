package kr.co.popone.fitts.feature.showroom;

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

public final class ShowRoomActivity$onCreate$$inlined$run$lambda$2 extends OnScrollListener {
    private int overallYScroll;
    final /* synthetic */ ShowRoomActivity this$0;

    ShowRoomActivity$onCreate$$inlined$run$lambda$2(ShowRoomActivity showRoomActivity) {
        this.this$0 = showRoomActivity;
    }

    public void onScrolled(@NotNull RecyclerView recyclerView, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(recyclerView, "recyclerView");
        int i3 = this.overallYScroll;
        String str = "showroom_title";
        String str2 = "backgroundColor";
        String str3 = "transparent";
        String str4 = "white";
        String str5 = "modify_showroom_cover_button";
        String str6 = "toolbar";
        Integer valueOf = Integer.valueOf(0);
        if (i3 > 400) {
            Toolbar toolbar = (Toolbar) this.this$0._$_findCachedViewById(C0010R$id.toolbar);
            Intrinsics.checkExpressionValueIsNotNull(toolbar, str6);
            if (Intrinsics.areEqual(toolbar.getTag(), (Object) str3)) {
                ObjectAnimator ofObject = ObjectAnimator.ofObject((Toolbar) this.this$0._$_findCachedViewById(C0010R$id.toolbar), str2, new ArgbEvaluator(), new Object[]{valueOf, Integer.valueOf((int) 4294967295L)});
                ofObject.setDuration(200);
                ((ImageButton) this.this$0._$_findCachedViewById(C0010R$id.back)).setColorFilter(Color.argb(150, 0, 0, 0));
                TextView textView = (TextView) this.this$0._$_findCachedViewById(C0010R$id.showroom_title);
                Intrinsics.checkExpressionValueIsNotNull(textView, str);
                textView.setVisibility(0);
                Toolbar toolbar2 = (Toolbar) this.this$0._$_findCachedViewById(C0010R$id.toolbar);
                Intrinsics.checkExpressionValueIsNotNull(toolbar2, str6);
                toolbar2.setTag(str4);
                ofObject.start();
            }
            ImageButton imageButton = (ImageButton) this.this$0._$_findCachedViewById(C0010R$id.modify_showroom_cover_button);
            Intrinsics.checkExpressionValueIsNotNull(imageButton, str5);
            imageButton.setVisibility(8);
        } else {
            Toolbar toolbar3 = (Toolbar) this.this$0._$_findCachedViewById(C0010R$id.toolbar);
            Intrinsics.checkExpressionValueIsNotNull(toolbar3, str6);
            if (Intrinsics.areEqual(toolbar3.getTag(), (Object) str4)) {
                ObjectAnimator ofObject2 = ObjectAnimator.ofObject((Toolbar) this.this$0._$_findCachedViewById(C0010R$id.toolbar), str2, new ArgbEvaluator(), new Object[]{Integer.valueOf((int) 4294967295L), valueOf});
                ofObject2.setDuration(200);
                ((ImageButton) this.this$0._$_findCachedViewById(C0010R$id.back)).setColorFilter(Color.argb(255, 255, 255, 255));
                TextView textView2 = (TextView) this.this$0._$_findCachedViewById(C0010R$id.showroom_title);
                Intrinsics.checkExpressionValueIsNotNull(textView2, str);
                textView2.setVisibility(8);
                Toolbar toolbar4 = (Toolbar) this.this$0._$_findCachedViewById(C0010R$id.toolbar);
                Intrinsics.checkExpressionValueIsNotNull(toolbar4, str6);
                toolbar4.setTag(str3);
                ofObject2.start();
            }
            if (this.overallYScroll >= 100) {
                ImageButton imageButton2 = (ImageButton) this.this$0._$_findCachedViewById(C0010R$id.modify_showroom_cover_button);
                Intrinsics.checkExpressionValueIsNotNull(imageButton2, str5);
                imageButton2.setVisibility(8);
            } else if (this.this$0.isMine()) {
                ImageButton imageButton3 = (ImageButton) this.this$0._$_findCachedViewById(C0010R$id.modify_showroom_cover_button);
                Intrinsics.checkExpressionValueIsNotNull(imageButton3, str5);
                imageButton3.setVisibility(0);
            }
        }
        this.overallYScroll += i2;
    }
}
