package kr.co.popone.fitts.feature.card;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import photopicker.utils.ScreenUtilsKt;

final class FittsCardRendingActivity$SCREEN_WIDTH$2 extends Lambda implements Function0<Integer> {
    final /* synthetic */ FittsCardRendingActivity this$0;

    FittsCardRendingActivity$SCREEN_WIDTH$2(FittsCardRendingActivity fittsCardRendingActivity) {
        this.this$0 = fittsCardRendingActivity;
        super(0);
    }

    public final int invoke() {
        return ScreenUtilsKt.screenWidth(this.this$0);
    }
}
