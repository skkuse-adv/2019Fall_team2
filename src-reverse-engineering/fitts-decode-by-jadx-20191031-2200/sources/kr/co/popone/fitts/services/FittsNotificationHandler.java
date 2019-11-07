package kr.co.popone.fitts.services;

import android.net.Uri;
import com.orhanobut.logger.Logger;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.event.FittieApplicationStateChangedEvent;
import kr.co.popone.fitts.event.NotificationEvent;
import kr.co.popone.fitts.event.RxBus;
import org.jetbrains.annotations.NotNull;

public final class FittsNotificationHandler {
    public final void handleNotification(@NotNull String str, int i) {
        Intrinsics.checkParameterIsNotNull(str, "urlString");
        StringBuilder sb = new StringBuilder();
        sb.append("FittsNotificationHandler handleNotification urlString(");
        sb.append(str);
        sb.append(") badge(");
        sb.append(i);
        sb.append(')');
        Logger.d(sb.toString(), new Object[0]);
        RxBus.INSTANCE.post(new NotificationEvent(str, i));
        Uri parse = Uri.parse(str);
        Intrinsics.checkExpressionValueIsNotNull(parse, "uri");
        if (Intrinsics.areEqual((Object) parse.getHost(), (Object) "apply")) {
            RxBus.INSTANCE.post(new FittieApplicationStateChangedEvent());
        }
    }
}
