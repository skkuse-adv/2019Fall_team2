package kr.co.popone.fitts.feature.intro.join;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0006R$color;
import kr.co.popone.fitts.C0010R$id;

final class JoinActivity$onCreate$28 implements OnClickListener {
    final /* synthetic */ JoinActivity this$0;

    JoinActivity$onCreate$28(JoinActivity joinActivity) {
        this.this$0 = joinActivity;
    }

    public final void onClick(View view) {
        ImageButton imageButton = (ImageButton) this.this$0._$_findCachedViewById(C0010R$id.hourglassBodyTypeButton);
        Intrinsics.checkExpressionValueIsNotNull(imageButton, "hourglassBodyTypeButton");
        imageButton.setSelected(true);
        ImageButton imageButton2 = (ImageButton) this.this$0._$_findCachedViewById(C0010R$id.triangleBodyTypeButton);
        Intrinsics.checkExpressionValueIsNotNull(imageButton2, "triangleBodyTypeButton");
        imageButton2.setSelected(false);
        ImageButton imageButton3 = (ImageButton) this.this$0._$_findCachedViewById(C0010R$id.invertedTriangleBodyTypeButton);
        Intrinsics.checkExpressionValueIsNotNull(imageButton3, "invertedTriangleBodyTypeButton");
        imageButton3.setSelected(false);
        ImageButton imageButton4 = (ImageButton) this.this$0._$_findCachedViewById(C0010R$id.rectangleBodyTypeButton);
        Intrinsics.checkExpressionValueIsNotNull(imageButton4, "rectangleBodyTypeButton");
        imageButton4.setSelected(false);
        ImageButton imageButton5 = (ImageButton) this.this$0._$_findCachedViewById(C0010R$id.normalBodyTypeButton);
        Intrinsics.checkExpressionValueIsNotNull(imageButton5, "normalBodyTypeButton");
        imageButton5.setSelected(false);
        ((ImageButton) this.this$0._$_findCachedViewById(C0010R$id.hourglassBodyTypeButton)).setColorFilter(ContextCompat.getColor(this.this$0, C0006R$color.point));
        ((TextView) this.this$0._$_findCachedViewById(C0010R$id.hourglassBodyTypeDesc)).setTextColor(ContextCompat.getColor(this.this$0, C0006R$color.point));
        ((ImageButton) this.this$0._$_findCachedViewById(C0010R$id.triangleBodyTypeButton)).setColorFilter(ContextCompat.getColor(this.this$0, C0006R$color.gray3));
        ((TextView) this.this$0._$_findCachedViewById(C0010R$id.triangleBodyTypeDesc)).setTextColor(ContextCompat.getColor(this.this$0, C0006R$color.gray3));
        ((ImageButton) this.this$0._$_findCachedViewById(C0010R$id.invertedTriangleBodyTypeButton)).setColorFilter(ContextCompat.getColor(this.this$0, C0006R$color.gray3));
        ((TextView) this.this$0._$_findCachedViewById(C0010R$id.invertedTriangleBodyTypeDesc)).setTextColor(ContextCompat.getColor(this.this$0, C0006R$color.gray3));
        ((ImageButton) this.this$0._$_findCachedViewById(C0010R$id.rectangleBodyTypeButton)).setColorFilter(ContextCompat.getColor(this.this$0, C0006R$color.gray3));
        ((TextView) this.this$0._$_findCachedViewById(C0010R$id.rectangleBodyTypeDesc)).setTextColor(ContextCompat.getColor(this.this$0, C0006R$color.gray3));
        ((ImageButton) this.this$0._$_findCachedViewById(C0010R$id.normalBodyTypeButton)).setColorFilter(ContextCompat.getColor(this.this$0, C0006R$color.gray3));
        ((TextView) this.this$0._$_findCachedViewById(C0010R$id.normalBodyTypeDesc)).setTextColor(ContextCompat.getColor(this.this$0, C0006R$color.gray3));
        String str = "hourglass";
        this.this$0.setBodyType(str);
        this.this$0.bodyTypeObservable.onNext(str);
    }
}
