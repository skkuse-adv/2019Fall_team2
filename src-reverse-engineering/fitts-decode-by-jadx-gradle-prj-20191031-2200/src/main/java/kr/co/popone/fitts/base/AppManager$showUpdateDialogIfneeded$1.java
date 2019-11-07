package kr.co.popone.fitts.base;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.orhanobut.logger.Logger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class AppManager$showUpdateDialogIfneeded$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Activity $localCurrentActivity;

    AppManager$showUpdateDialogIfneeded$1(Activity activity) {
        this.$localCurrentActivity = activity;
        super(0);
    }

    public final void invoke() {
        Logger.d("업데이트 하러 감", new Object[0]);
        Intent intent = new Intent("android.intent.action.VIEW");
        StringBuilder sb = new StringBuilder();
        sb.append("market://details?id=");
        sb.append(this.$localCurrentActivity.getPackageName());
        intent.setData(Uri.parse(sb.toString()));
        this.$localCurrentActivity.startActivity(intent);
    }
}
