package kr.co.popone.fitts.feature.event;

import android.view.View;
import android.view.View.OnClickListener;
import kotlin.Pair;
import kotlin.TuplesKt;
import kr.co.popone.fitts.C0001R$anim;
import kr.co.popone.fitts.feature.search.ShopWebViewActivity;
import kr.co.popone.fitts.feature.search.ShopWebViewActivity.Parameters;
import kr.co.popone.fitts.model.event.EventAPI.Ticket;
import org.jetbrains.anko.internals.AnkoInternals;

final class AppliableEventWinnerInputActivity$onCreate$2 implements OnClickListener {
    final /* synthetic */ AppliableEventWinnerInputActivity this$0;

    AppliableEventWinnerInputActivity$onCreate$2(AppliableEventWinnerInputActivity appliableEventWinnerInputActivity) {
        this.this$0 = appliableEventWinnerInputActivity;
    }

    public final void onClick(View view) {
        Ticket access$getTicketInfoResponse$p = this.this$0.ticketInfoResponse;
        if (access$getTicketInfoResponse$p != null) {
            AppliableEventWinnerInputActivity appliableEventWinnerInputActivity = this.this$0;
            Parameters parameters = new Parameters(access$getTicketInfoResponse$p.getLinkUrl(), "", false, null, null, null, null, 124, null);
            appliableEventWinnerInputActivity.startActivity(AnkoInternals.createIntent(appliableEventWinnerInputActivity, ShopWebViewActivity.class, new Pair[]{TuplesKt.to("parameters", parameters)}));
            this.this$0.overridePendingTransition(C0001R$anim.slide_up, C0001R$anim.fade_out);
        }
    }
}
