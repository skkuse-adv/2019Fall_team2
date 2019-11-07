package kr.co.popone.fitts.feature.event;

import com.orhanobut.logger.Logger;
import io.reactivex.functions.BiConsumer;
import kr.co.popone.fitts.model.event.EventAPI.AppliableEventResponse;

final class AppliableEventActivity$loadEventDetail$1<T1, T2> implements BiConsumer<AppliableEventResponse, Throwable> {
    final /* synthetic */ AppliableEventActivity this$0;

    AppliableEventActivity$loadEventDetail$1(AppliableEventActivity appliableEventActivity) {
        this.this$0 = appliableEventActivity;
    }

    public final void accept(AppliableEventResponse appliableEventResponse, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append("eventDetail response ");
        sb.append(appliableEventResponse);
        sb.append("   error ");
        sb.append(th);
        Logger.d(sb.toString(), new Object[0]);
        this.this$0.eventResponse = appliableEventResponse;
        if (appliableEventResponse != null) {
            this.this$0.updateEventUI(appliableEventResponse);
        }
    }
}
