package kr.co.popone.fitts.feature.main;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class MainActivity$onBackPressed$$inlined$let$lambda$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ MainActivity this$0;

    MainActivity$onBackPressed$$inlined$let$lambda$1(MainActivity mainActivity) {
        this.this$0 = mainActivity;
        super(0);
    }

    public final void invoke() {
        this.this$0.moveTabHome();
    }
}
