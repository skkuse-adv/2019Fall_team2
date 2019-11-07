package kr.co.popone.fitts.feature.card;

import android.content.Intent;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kr.co.popone.fitts.feature.main.MainActivity;

final class FittsCardRendingActivity$showResultDialog$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ FittsCardRendingActivity this$0;

    FittsCardRendingActivity$showResultDialog$1(FittsCardRendingActivity fittsCardRendingActivity) {
        this.this$0 = fittsCardRendingActivity;
        super(0);
    }

    public final void invoke() {
        FittsCardRendingActivity fittsCardRendingActivity = this.this$0;
        Intent intent = new Intent(fittsCardRendingActivity, MainActivity.class);
        intent.putExtra(MainActivity.PARAMETER_MOVE_TAB_STORE, "home");
        intent.addFlags(67108864);
        fittsCardRendingActivity.startActivity(intent);
    }
}
