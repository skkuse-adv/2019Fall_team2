package kr.co.popone.fitts.feature.event;

import com.orhanobut.logger.Logger;
import io.reactivex.functions.BiConsumer;
import kr.co.popone.fitts.model.event.EventAPI.Ticket;
import kr.co.popone.fitts.ui.DialogExtensions;

final class AppliableEventWinnerInputActivity$loadTicketInfo$1<T1, T2> implements BiConsumer<Ticket, Throwable> {
    final /* synthetic */ AppliableEventWinnerInputActivity this$0;

    AppliableEventWinnerInputActivity$loadTicketInfo$1(AppliableEventWinnerInputActivity appliableEventWinnerInputActivity) {
        this.this$0 = appliableEventWinnerInputActivity;
    }

    public final void accept(Ticket ticket, Throwable th) {
        this.this$0.ticketInfoRequest = null;
        StringBuilder sb = new StringBuilder();
        sb.append("ticketInfoResponse ");
        sb.append(ticket);
        sb.append(' ');
        sb.append(th);
        Logger.d(sb.toString(), new Object[0]);
        if (ticket != null) {
            this.this$0.ticketInfoResponse = ticket;
            this.this$0.isAppliableSubject.onNext(Boolean.valueOf(ticket.isAppliable()));
            this.this$0.updateUI();
            if (!ticket.isAppliable()) {
                DialogExtensions.showMessageDialog$default(DialogExtensions.INSTANCE, this.this$0, "이미 등록이 완료되었어요", "변경사항이 있으시다면 플러스친구를 통해 문의해주세요", null, "확인", 8, null);
            }
        }
    }
}
