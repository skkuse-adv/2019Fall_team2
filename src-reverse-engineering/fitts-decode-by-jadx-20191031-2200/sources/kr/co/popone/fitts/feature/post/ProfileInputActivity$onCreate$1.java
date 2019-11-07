package kr.co.popone.fitts.feature.post;

import android.widget.EditText;
import android.widget.SeekBar;
import com.orhanobut.logger.Logger;
import io.reactivex.functions.BiConsumer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.model.datamodel.service.user.BodyInfo;
import kr.co.popone.fitts.model.datamodel.service.user.MyInfo;

final class ProfileInputActivity$onCreate$1<T1, T2> implements BiConsumer<MyInfo, Throwable> {
    final /* synthetic */ ProfileInputActivity this$0;

    ProfileInputActivity$onCreate$1(ProfileInputActivity profileInputActivity) {
        this.this$0 = profileInputActivity;
    }

    public final void accept(MyInfo myInfo, Throwable th) {
        this.this$0.userInfoRequest = null;
        StringBuilder sb = new StringBuilder();
        sb.append("{userInfo: ");
        sb.append(myInfo);
        sb.append(", error: ");
        sb.append(th);
        sb.append('}');
        Logger.d(sb.toString(), new Object[0]);
        if (myInfo != null) {
            this.this$0.getSessionManager$app_productionFittsRelease().setUserInfo(myInfo);
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
                ((EditText) this.this$0._$_findCachedViewById(C0010R$id.shoeSizeInputEditText)).setText(String.valueOf(shoeSize));
            }
        }
    }
}
