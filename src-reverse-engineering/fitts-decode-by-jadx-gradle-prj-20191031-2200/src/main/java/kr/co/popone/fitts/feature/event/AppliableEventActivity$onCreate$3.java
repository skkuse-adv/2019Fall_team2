package kr.co.popone.fitts.feature.event;

import android.content.Intent;
import com.orhanobut.logger.Logger;
import kr.co.popone.fitts.C0001R$anim;
import kr.co.popone.fitts.feature.event.AppliableEventStatusAdapter.Delegate;
import kr.co.popone.fitts.feature.search.ShopWebViewActivity;
import kr.co.popone.fitts.feature.search.ShopWebViewActivity.Parameters;
import kr.co.popone.fitts.model.event.EventAPI.AppliableEventResponse;
import kr.co.popone.fitts.model.event.EventAPI.EventHistory;
import kr.co.popone.fitts.model.event.EventAPI.Ticket;

public final class AppliableEventActivity$onCreate$3 implements Delegate {
    final /* synthetic */ AppliableEventActivity this$0;

    AppliableEventActivity$onCreate$3(AppliableEventActivity appliableEventActivity) {
        this.this$0 = appliableEventActivity;
    }

    public void onOptionClicked(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("onOptionClicked ");
        sb.append(i);
        Logger.d(sb.toString(), new Object[0]);
        AppliableEventResponse access$getEventResponse$p = this.this$0.eventResponse;
        if (access$getEventResponse$p != null) {
            EventHistory eventHistory = (EventHistory) access$getEventResponse$p.getHistories().get(i);
            if (CollectionsKt___CollectionsKt.firstOrNull(eventHistory.getTickets()) != null) {
                Parameters parameters = new Parameters(((Ticket) CollectionsKt___CollectionsKt.first(eventHistory.getTickets())).getLinkUrl(), "", false, null, null, null, null, 124, null);
                Intent intent = new Intent(this.this$0, ShopWebViewActivity.class);
                intent.putExtra("parameters", parameters);
                this.this$0.startActivity(intent);
                this.this$0.overridePendingTransition(C0001R$anim.slide_up, C0001R$anim.fade_out);
            }
        }
    }
}
