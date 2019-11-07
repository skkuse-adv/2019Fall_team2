package kr.co.popone.fitts.feature.me;

import android.content.Intent;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import androidx.core.content.ContextCompat;
import com.orhanobut.logger.Logger;
import io.reactivex.functions.BiConsumer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0006R$color;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.feature.intro.IntroActivity;
import kr.co.popone.fitts.feature.me.ModifyBodyActivity.WhenMappings;
import kr.co.popone.fitts.model.datamodel.service.user.BodyInfo;
import kr.co.popone.fitts.model.datamodel.service.user.MyInfo;
import kr.co.popone.fitts.utils.Snackbar;
import retrofit2.HttpException;

final class ModifyBodyActivity$getUserInfo$1<T1, T2> implements BiConsumer<MyInfo, Throwable> {
    final /* synthetic */ ModifyBodyActivity this$0;

    ModifyBodyActivity$getUserInfo$1(ModifyBodyActivity modifyBodyActivity) {
        this.this$0 = modifyBodyActivity;
    }

    public final void accept(MyInfo myInfo, Throwable th) {
        this.this$0.userInfoRequest = null;
        boolean z = false;
        if (myInfo != null) {
            this.this$0.getSessionManager$app_productionFittsRelease().setUserInfo(myInfo);
            ((EditText) this.this$0._$_findCachedViewById(C0010R$id.profile_height)).setText(String.valueOf(myInfo.getBodyInfo().getHeight()), BufferType.EDITABLE);
            ((EditText) this.this$0._$_findCachedViewById(C0010R$id.profile_weight)).setText(String.valueOf(myInfo.getBodyInfo().getWeight()), BufferType.EDITABLE);
            int i = WhenMappings.$EnumSwitchMapping$0[myInfo.getBodyInfo().getBodyType().ordinal()];
            if (i == 1) {
                ImageButton imageButton = (ImageButton) this.this$0._$_findCachedViewById(C0010R$id.triangleBodyTypeButton);
                Intrinsics.checkExpressionValueIsNotNull(imageButton, "triangleBodyTypeButton");
                imageButton.setSelected(true);
                ((ImageButton) this.this$0._$_findCachedViewById(C0010R$id.triangleBodyTypeButton)).setColorFilter(ContextCompat.getColor(this.this$0, C0006R$color.point));
                this.this$0.getBodyInfo().setType("triangle");
                ((TextView) this.this$0._$_findCachedViewById(C0010R$id.triangleBodyTypeDesc)).setTextColor(ContextCompat.getColor(this.this$0, C0006R$color.point));
            } else if (i == 2) {
                ImageButton imageButton2 = (ImageButton) this.this$0._$_findCachedViewById(C0010R$id.hourglassBodyTypeButton);
                Intrinsics.checkExpressionValueIsNotNull(imageButton2, "hourglassBodyTypeButton");
                imageButton2.setSelected(true);
                ((ImageButton) this.this$0._$_findCachedViewById(C0010R$id.hourglassBodyTypeButton)).setColorFilter(ContextCompat.getColor(this.this$0, C0006R$color.point));
                this.this$0.getBodyInfo().setType("hourglass");
                ((TextView) this.this$0._$_findCachedViewById(C0010R$id.hourglassBodyTypeDesc)).setTextColor(ContextCompat.getColor(this.this$0, C0006R$color.point));
            } else if (i == 3) {
                ImageButton imageButton3 = (ImageButton) this.this$0._$_findCachedViewById(C0010R$id.rectangleBodyTypeButton);
                Intrinsics.checkExpressionValueIsNotNull(imageButton3, "rectangleBodyTypeButton");
                imageButton3.setSelected(true);
                ((ImageButton) this.this$0._$_findCachedViewById(C0010R$id.rectangleBodyTypeButton)).setColorFilter(ContextCompat.getColor(this.this$0, C0006R$color.point));
                this.this$0.getBodyInfo().setType("rectangle");
                ((TextView) this.this$0._$_findCachedViewById(C0010R$id.rectangleBodyTypeDesc)).setTextColor(ContextCompat.getColor(this.this$0, C0006R$color.point));
            } else if (i == 4) {
                ImageButton imageButton4 = (ImageButton) this.this$0._$_findCachedViewById(C0010R$id.invertedTriangleBodyTypeButton);
                Intrinsics.checkExpressionValueIsNotNull(imageButton4, "invertedTriangleBodyTypeButton");
                imageButton4.setSelected(true);
                ((ImageButton) this.this$0._$_findCachedViewById(C0010R$id.invertedTriangleBodyTypeButton)).setColorFilter(ContextCompat.getColor(this.this$0, C0006R$color.point));
                this.this$0.getBodyInfo().setType("inverted_triangle");
                ((TextView) this.this$0._$_findCachedViewById(C0010R$id.invertedTriangleBodyTypeDesc)).setTextColor(ContextCompat.getColor(this.this$0, C0006R$color.point));
            } else if (i == 5) {
                ImageButton imageButton5 = (ImageButton) this.this$0._$_findCachedViewById(C0010R$id.normalBodyTypeButton);
                Intrinsics.checkExpressionValueIsNotNull(imageButton5, "normalBodyTypeButton");
                imageButton5.setSelected(true);
                ((ImageButton) this.this$0._$_findCachedViewById(C0010R$id.normalBodyTypeButton)).setColorFilter(ContextCompat.getColor(this.this$0, C0006R$color.point));
                this.this$0.getBodyInfo().setType("normal");
                ((TextView) this.this$0._$_findCachedViewById(C0010R$id.normalBodyTypeDesc)).setTextColor(ContextCompat.getColor(this.this$0, C0006R$color.point));
            }
            int indexOf = CollectionsKt___CollectionsKt.indexOf(BodyInfo.Companion.getSizeList(), myInfo.getBodyInfo().getTop());
            int indexOf2 = CollectionsKt___CollectionsKt.indexOf(BodyInfo.Companion.getSizeList(), myInfo.getBodyInfo().getBottom());
            SeekBar seekBar = (SeekBar) this.this$0._$_findCachedViewById(C0010R$id.topClothingSizeSeekBar);
            Intrinsics.checkExpressionValueIsNotNull(seekBar, "topClothingSizeSeekBar");
            if (indexOf < 0) {
                indexOf = 6;
            }
            seekBar.setProgress(indexOf);
            SeekBar seekBar2 = (SeekBar) this.this$0._$_findCachedViewById(C0010R$id.bottomClothingSizeSeekBar);
            Intrinsics.checkExpressionValueIsNotNull(seekBar2, "bottomClothingSizeSeekBar");
            if (indexOf2 < 0) {
                indexOf2 = 6;
            }
            seekBar2.setProgress(indexOf2);
            int shoeSize = myInfo.getBodyInfo().getShoeSize();
            if (shoeSize > 0) {
                ((EditText) this.this$0._$_findCachedViewById(C0010R$id.shoeSizeInputEditText)).setText(String.valueOf(shoeSize), BufferType.EDITABLE);
            }
            String footDescription = myInfo.getBodyInfo().getFootDescription();
            if (footDescription == null || StringsKt__StringsJVMKt.isBlank(footDescription)) {
                z = true;
            }
            if (!z) {
                ((EditText) this.this$0._$_findCachedViewById(C0010R$id.footDescriptionInputEditText)).setText(footDescription, BufferType.EDITABLE);
            }
            if (myInfo.getBodyFilter() != null) {
                ((EditText) this.this$0._$_findCachedViewById(C0010R$id.body_description)).setText(myInfo.getBodyInfo().getDescription(), BufferType.EDITABLE);
                return;
            }
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("error occured ");
        sb.append(th);
        Logger.d(sb.toString(), new Object[0]);
        if (!(th instanceof HttpException)) {
            Snackbar.Companion.showMessage(this.this$0, "죄송합니다.\n서비스가 잠시 지연되고 있습니다.\n잠시 후 다시 이용해주세요.");
        } else if (((HttpException) th).code() == 401) {
            Intent intent = new Intent(this.this$0, IntroActivity.class);
            intent.addFlags(32768);
            intent.addFlags(268435456);
            this.this$0.startActivity(intent);
        }
    }
}
