package org.jetbrains.anko;

import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import androidx.core.app.NotificationCompat;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

final class AlertDialogBuilder$onKey$1 implements OnKeyListener {
    final /* synthetic */ Function2 $callback;

    AlertDialogBuilder$onKey$1(Function2 function2) {
        this.$callback = function2;
    }

    public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        Function2 function2 = this.$callback;
        Integer valueOf = Integer.valueOf(i);
        Intrinsics.checkExpressionValueIsNotNull(keyEvent, NotificationCompat.CATEGORY_EVENT);
        return ((Boolean) function2.invoke(valueOf, keyEvent)).booleanValue();
    }
}
