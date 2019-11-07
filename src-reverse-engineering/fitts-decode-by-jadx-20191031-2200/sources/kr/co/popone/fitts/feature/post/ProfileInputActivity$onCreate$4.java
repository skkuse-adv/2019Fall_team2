package kr.co.popone.fitts.feature.post;

import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.model.datamodel.service.user.BodyInfo;
import org.jetbrains.annotations.NotNull;

public final class ProfileInputActivity$onCreate$4 implements OnSeekBarChangeListener {
    final /* synthetic */ ProfileInputActivity this$0;

    public void onStartTrackingTouch(@NotNull SeekBar seekBar) {
        Intrinsics.checkParameterIsNotNull(seekBar, "p0");
    }

    public void onStopTrackingTouch(@NotNull SeekBar seekBar) {
        Intrinsics.checkParameterIsNotNull(seekBar, "p0");
    }

    ProfileInputActivity$onCreate$4(ProfileInputActivity profileInputActivity) {
        this.this$0 = profileInputActivity;
    }

    public void onProgressChanged(@NotNull SeekBar seekBar, int i, boolean z) {
        Intrinsics.checkParameterIsNotNull(seekBar, "p0");
        TextView textView = (TextView) this.this$0._$_findCachedViewById(C0010R$id.topClothingSizeTextView);
        Intrinsics.checkExpressionValueIsNotNull(textView, "topClothingSizeTextView");
        textView.setText((CharSequence) BodyInfo.Companion.getSizeList().get(i));
    }
}
