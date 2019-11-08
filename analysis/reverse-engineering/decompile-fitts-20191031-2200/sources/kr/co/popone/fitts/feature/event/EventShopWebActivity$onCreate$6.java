package kr.co.popone.fitts.feature.event;

import android.widget.Button;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.orhanobut.logger.Logger;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.model.event.EventAPI.AppliableEventAppliabilityCheckResponse;

final class EventShopWebActivity$onCreate$6<T1, T2> implements BiConsumer<AppliableEventAppliabilityCheckResponse, Throwable> {
    final /* synthetic */ EventShopWebActivity this$0;

    EventShopWebActivity$onCreate$6(EventShopWebActivity eventShopWebActivity) {
        this.this$0 = eventShopWebActivity;
    }

    public final void accept(AppliableEventAppliabilityCheckResponse appliableEventAppliabilityCheckResponse, Throwable th) {
        this.this$0.checkEventAppliability = null;
        StringBuilder sb = new StringBuilder();
        sb.append("event appliability ");
        sb.append(appliableEventAppliabilityCheckResponse);
        sb.append(' ');
        sb.append(th);
        Logger.d(sb.toString(), new Object[0]);
        if (appliableEventAppliabilityCheckResponse != null && appliableEventAppliabilityCheckResponse.isAvailable()) {
            Button button = (Button) this.this$0._$_findCachedViewById(C0010R$id.applyButton);
            Intrinsics.checkExpressionValueIsNotNull(button, "applyButton");
            button.setEnabled(true);
            ConstraintLayout constraintLayout = (ConstraintLayout) this.this$0._$_findCachedViewById(C0010R$id.applyGuideLayout);
            Intrinsics.checkExpressionValueIsNotNull(constraintLayout, "applyGuideLayout");
            constraintLayout.setVisibility(0);
            this.this$0.linkCopyGuideTimerRequest = Observable.timer(5, TimeUnit.SECONDS, Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Consumer<? super T>) new Consumer<Long>(this) {
                final /* synthetic */ EventShopWebActivity$onCreate$6 this$0;

                {
                    this.this$0 = r1;
                }

                public final void accept(Long l) {
                    this.this$0.this$0.linkCopyGuideTimerRequest = null;
                    StringBuilder sb = new StringBuilder();
                    sb.append("timer triggered on thread(");
                    sb.append(Thread.currentThread());
                    sb.append(')');
                    Logger.d(sb.toString(), new Object[0]);
                    ((ConstraintLayout) this.this$0.this$0._$_findCachedViewById(C0010R$id.applyGuideLayout)).animate().alpha(0.0f);
                }
            });
        }
    }
}
