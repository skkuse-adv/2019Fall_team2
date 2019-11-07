package kr.co.popone.fitts.feature.event;

import com.orhanobut.logger.Logger;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kr.co.popone.fitts.C0001R$anim;
import kr.co.popone.fitts.feature.search.ShopWebViewActivity;
import kr.co.popone.fitts.feature.search.ShopWebViewActivity.Parameters;
import kr.co.popone.fitts.model.event.EventAPI.AppliableEventResponse;
import kr.co.popone.fitts.model.event.EventAPI.EventHistory;
import kr.co.popone.fitts.model.event.EventAPI.Ticket;
import org.jetbrains.anko.internals.AnkoInternals;

final class AppliableCollaborativeEventActivity$onCreate$4 extends Lambda implements Function2<Integer, Integer, Unit> {
    final /* synthetic */ AppliableCollaborativeEventActivity this$0;

    AppliableCollaborativeEventActivity$onCreate$4(AppliableCollaborativeEventActivity appliableCollaborativeEventActivity) {
        this.this$0 = appliableCollaborativeEventActivity;
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke(((Number) obj).intValue(), ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i, int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append("event clicked(");
        sb.append(i);
        sb.append(", ");
        sb.append(i2);
        sb.append(')');
        Logger.d(sb.toString(), new Object[0]);
        AppliableEventResponse access$getEventResponse$p = this.this$0.eventResponse;
        if (access$getEventResponse$p != null) {
            List histories = access$getEventResponse$p.getHistories();
            if (histories != null) {
                EventHistory eventHistory = (EventHistory) CollectionsKt___CollectionsKt.getOrNull(histories, i);
                if (eventHistory != null) {
                    List tickets = eventHistory.getTickets();
                    if (tickets != null) {
                        Ticket ticket = (Ticket) CollectionsKt___CollectionsKt.getOrNull(tickets, i2);
                        if (ticket != null) {
                            AppliableCollaborativeEventActivity appliableCollaborativeEventActivity = this.this$0;
                            Parameters parameters = new Parameters(ticket.getLinkUrl(), "", false, null, null, null, null, 124, null);
                            appliableCollaborativeEventActivity.startActivity(AnkoInternals.createIntent(appliableCollaborativeEventActivity, ShopWebViewActivity.class, new Pair[]{TuplesKt.to("parameters", parameters)}));
                            this.this$0.overridePendingTransition(C0001R$anim.slide_up, C0001R$anim.fade_out);
                        }
                    }
                }
            }
        }
    }
}
