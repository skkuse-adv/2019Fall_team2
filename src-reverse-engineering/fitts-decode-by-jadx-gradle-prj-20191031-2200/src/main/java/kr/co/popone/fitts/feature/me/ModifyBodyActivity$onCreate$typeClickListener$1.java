package kr.co.popone.fitts.feature.me;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0006R$color;
import kr.co.popone.fitts.C0010R$id;

final class ModifyBodyActivity$onCreate$typeClickListener$1 implements OnClickListener {
    final /* synthetic */ ModifyBodyActivity this$0;

    ModifyBodyActivity$onCreate$typeClickListener$1(ModifyBodyActivity modifyBodyActivity) {
        this.this$0 = modifyBodyActivity;
    }

    public final void onClick(View view) {
        ImageButton imageButton = (ImageButton) this.this$0._$_findCachedViewById(C0010R$id.triangleBodyTypeButton);
        String str = "triangleBodyTypeButton";
        Intrinsics.checkExpressionValueIsNotNull(imageButton, str);
        imageButton.setSelected(false);
        ImageButton imageButton2 = (ImageButton) this.this$0._$_findCachedViewById(C0010R$id.invertedTriangleBodyTypeButton);
        String str2 = "invertedTriangleBodyTypeButton";
        Intrinsics.checkExpressionValueIsNotNull(imageButton2, str2);
        imageButton2.setSelected(false);
        ImageButton imageButton3 = (ImageButton) this.this$0._$_findCachedViewById(C0010R$id.hourglassBodyTypeButton);
        String str3 = "hourglassBodyTypeButton";
        Intrinsics.checkExpressionValueIsNotNull(imageButton3, str3);
        imageButton3.setSelected(false);
        ImageButton imageButton4 = (ImageButton) this.this$0._$_findCachedViewById(C0010R$id.rectangleBodyTypeButton);
        String str4 = "rectangleBodyTypeButton";
        Intrinsics.checkExpressionValueIsNotNull(imageButton4, str4);
        imageButton4.setSelected(false);
        ImageButton imageButton5 = (ImageButton) this.this$0._$_findCachedViewById(C0010R$id.normalBodyTypeButton);
        String str5 = "normalBodyTypeButton";
        Intrinsics.checkExpressionValueIsNotNull(imageButton5, str5);
        imageButton5.setSelected(false);
        ((ImageButton) this.this$0._$_findCachedViewById(C0010R$id.triangleBodyTypeButton)).setColorFilter(ContextCompat.getColor(this.this$0, C0006R$color.gray3));
        ((ImageButton) this.this$0._$_findCachedViewById(C0010R$id.invertedTriangleBodyTypeButton)).setColorFilter(ContextCompat.getColor(this.this$0, C0006R$color.gray3));
        ((ImageButton) this.this$0._$_findCachedViewById(C0010R$id.hourglassBodyTypeButton)).setColorFilter(ContextCompat.getColor(this.this$0, C0006R$color.gray3));
        ((ImageButton) this.this$0._$_findCachedViewById(C0010R$id.rectangleBodyTypeButton)).setColorFilter(ContextCompat.getColor(this.this$0, C0006R$color.gray3));
        ((ImageButton) this.this$0._$_findCachedViewById(C0010R$id.normalBodyTypeButton)).setColorFilter(ContextCompat.getColor(this.this$0, C0006R$color.gray3));
        ((TextView) this.this$0._$_findCachedViewById(C0010R$id.triangleBodyTypeDesc)).setTextColor(ContextCompat.getColor(this.this$0, C0006R$color.gray3));
        ((TextView) this.this$0._$_findCachedViewById(C0010R$id.invertedTriangleBodyTypeDesc)).setTextColor(ContextCompat.getColor(this.this$0, C0006R$color.gray3));
        ((TextView) this.this$0._$_findCachedViewById(C0010R$id.hourglassBodyTypeDesc)).setTextColor(ContextCompat.getColor(this.this$0, C0006R$color.gray3));
        ((TextView) this.this$0._$_findCachedViewById(C0010R$id.rectangleBodyTypeDesc)).setTextColor(ContextCompat.getColor(this.this$0, C0006R$color.gray3));
        ((TextView) this.this$0._$_findCachedViewById(C0010R$id.normalBodyTypeDesc)).setTextColor(ContextCompat.getColor(this.this$0, C0006R$color.gray3));
        Intrinsics.checkExpressionValueIsNotNull(view, "view");
        Object tag = view.getTag();
        String str6 = "hourglass";
        if (Intrinsics.areEqual(tag, (Object) str6)) {
            ImageButton imageButton6 = (ImageButton) this.this$0._$_findCachedViewById(C0010R$id.hourglassBodyTypeButton);
            Intrinsics.checkExpressionValueIsNotNull(imageButton6, str3);
            imageButton6.setSelected(true);
            this.this$0.getBodyInfo().setType(str6);
            ((TextView) this.this$0._$_findCachedViewById(C0010R$id.hourglassBodyTypeDesc)).setTextColor(ContextCompat.getColor(this.this$0, C0006R$color.point));
        } else {
            String str7 = "inverted_triangle";
            if (Intrinsics.areEqual(tag, (Object) str7)) {
                ImageButton imageButton7 = (ImageButton) this.this$0._$_findCachedViewById(C0010R$id.invertedTriangleBodyTypeButton);
                Intrinsics.checkExpressionValueIsNotNull(imageButton7, str2);
                imageButton7.setSelected(true);
                this.this$0.getBodyInfo().setType(str7);
                ((TextView) this.this$0._$_findCachedViewById(C0010R$id.invertedTriangleBodyTypeDesc)).setTextColor(ContextCompat.getColor(this.this$0, C0006R$color.point));
            } else {
                String str8 = "rectangle";
                if (Intrinsics.areEqual(tag, (Object) str8)) {
                    ImageButton imageButton8 = (ImageButton) this.this$0._$_findCachedViewById(C0010R$id.rectangleBodyTypeButton);
                    Intrinsics.checkExpressionValueIsNotNull(imageButton8, str4);
                    imageButton8.setSelected(true);
                    this.this$0.getBodyInfo().setType(str8);
                    ((TextView) this.this$0._$_findCachedViewById(C0010R$id.rectangleBodyTypeDesc)).setTextColor(ContextCompat.getColor(this.this$0, C0006R$color.point));
                } else {
                    String str9 = "triangle";
                    if (Intrinsics.areEqual(tag, (Object) str9)) {
                        ImageButton imageButton9 = (ImageButton) this.this$0._$_findCachedViewById(C0010R$id.triangleBodyTypeButton);
                        Intrinsics.checkExpressionValueIsNotNull(imageButton9, str);
                        imageButton9.setSelected(true);
                        this.this$0.getBodyInfo().setType(str9);
                        ((TextView) this.this$0._$_findCachedViewById(C0010R$id.triangleBodyTypeDesc)).setTextColor(ContextCompat.getColor(this.this$0, C0006R$color.point));
                    } else {
                        String str10 = "normal";
                        if (Intrinsics.areEqual(tag, (Object) str10)) {
                            ImageButton imageButton10 = (ImageButton) this.this$0._$_findCachedViewById(C0010R$id.normalBodyTypeButton);
                            Intrinsics.checkExpressionValueIsNotNull(imageButton10, str5);
                            imageButton10.setSelected(true);
                            this.this$0.getBodyInfo().setType(str10);
                            ((TextView) this.this$0._$_findCachedViewById(C0010R$id.normalBodyTypeDesc)).setTextColor(ContextCompat.getColor(this.this$0, C0006R$color.point));
                        }
                    }
                }
            }
        }
        ImageButton imageButton11 = (ImageButton) view;
        if (imageButton11.isSelected()) {
            imageButton11.setColorFilter(ContextCompat.getColor(this.this$0, C0006R$color.point));
        }
    }
}
