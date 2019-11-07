package kr.co.popone.fitts.feature.event;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.recyclerview.widget.ItemTouchHelper.Callback;
import kotlin.Pair;
import kr.co.popone.fitts.feature.reward.AddressWebViewActivity;
import org.jetbrains.anko.internals.AnkoInternals;

final class AppliableEventWinnerInputActivity$onCreate$3 implements OnClickListener {
    final /* synthetic */ AppliableEventWinnerInputActivity this$0;

    AppliableEventWinnerInputActivity$onCreate$3(AppliableEventWinnerInputActivity appliableEventWinnerInputActivity) {
        this.this$0 = appliableEventWinnerInputActivity;
    }

    public final void onClick(View view) {
        AppliableEventWinnerInputActivity appliableEventWinnerInputActivity = this.this$0;
        appliableEventWinnerInputActivity.startActivityForResult(AnkoInternals.createIntent(appliableEventWinnerInputActivity, AddressWebViewActivity.class, new Pair[0]), Callback.DEFAULT_DRAG_ANIMATION_DURATION);
    }
}
