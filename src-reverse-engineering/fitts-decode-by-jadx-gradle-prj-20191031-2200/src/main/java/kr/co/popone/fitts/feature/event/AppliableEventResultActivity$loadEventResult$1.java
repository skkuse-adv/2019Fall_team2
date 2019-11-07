package kr.co.popone.fitts.feature.event;

import com.orhanobut.logger.Logger;
import io.reactivex.functions.BiConsumer;
import kr.co.popone.fitts.model.event.EventAPI.AppliableEventResultResponse;

final class AppliableEventResultActivity$loadEventResult$1<T1, T2> implements BiConsumer<AppliableEventResultResponse, Throwable> {
    final /* synthetic */ AppliableEventResultActivity this$0;

    AppliableEventResultActivity$loadEventResult$1(AppliableEventResultActivity appliableEventResultActivity) {
        this.this$0 = appliableEventResultActivity;
    }

    public final void accept(AppliableEventResultResponse appliableEventResultResponse, Throwable th) {
        this.this$0.eventResultRequest = null;
        StringBuilder sb = new StringBuilder();
        sb.append("eventResultResponse ");
        sb.append(appliableEventResultResponse);
        sb.append("   error ");
        sb.append(th);
        Logger.d(sb.toString(), new Object[0]);
        if (appliableEventResultResponse != null) {
            this.this$0.eventResultResponse = appliableEventResultResponse;
            this.this$0.updateUI();
        }
    }
}
