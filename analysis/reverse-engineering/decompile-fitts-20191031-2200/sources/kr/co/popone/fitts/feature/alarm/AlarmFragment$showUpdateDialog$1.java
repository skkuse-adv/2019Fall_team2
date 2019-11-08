package kr.co.popone.fitts.feature.alarm;

import android.content.Intent;
import android.net.Uri;
import androidx.fragment.app.FragmentActivity;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

final class AlarmFragment$showUpdateDialog$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ AlarmFragment this$0;

    AlarmFragment$showUpdateDialog$1(AlarmFragment alarmFragment) {
        this.this$0 = alarmFragment;
        super(0);
    }

    public final void invoke() {
        Intent intent = new Intent("android.intent.action.VIEW");
        StringBuilder sb = new StringBuilder();
        sb.append("market://details?id=");
        FragmentActivity activity = this.this$0.getActivity();
        if (activity == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity!!");
        sb.append(activity.getPackageName());
        intent.setData(Uri.parse(sb.toString()));
        this.this$0.startActivity(intent);
    }
}
