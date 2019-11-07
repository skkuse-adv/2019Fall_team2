package kr.co.popone.fitts.feature.me;

import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.model.datamodel.service.user.BodyInfo;
import org.jetbrains.annotations.NotNull;

public final class ModifyBodyActivity$onCreate$16 implements OnSeekBarChangeListener {
    final /* synthetic */ ModifyBodyActivity this$0;

    public void onStartTrackingTouch(@NotNull SeekBar seekBar) {
        Intrinsics.checkParameterIsNotNull(seekBar, "p0");
    }

    public void onStopTrackingTouch(@NotNull SeekBar seekBar) {
        Intrinsics.checkParameterIsNotNull(seekBar, "p0");
    }

    ModifyBodyActivity$onCreate$16(ModifyBodyActivity modifyBodyActivity) {
        this.this$0 = modifyBodyActivity;
    }

    public void onProgressChanged(@NotNull SeekBar seekBar, int i, boolean z) {
        Intrinsics.checkParameterIsNotNull(seekBar, "p0");
        TextView textView = (TextView) this.this$0._$_findCachedViewById(C0010R$id.bottomClothingSizeTextView);
        Intrinsics.checkExpressionValueIsNotNull(textView, "bottomClothingSizeTextView");
        textView.setText((CharSequence) BodyInfo.Companion.getSizeList().get(i));
    }
}
