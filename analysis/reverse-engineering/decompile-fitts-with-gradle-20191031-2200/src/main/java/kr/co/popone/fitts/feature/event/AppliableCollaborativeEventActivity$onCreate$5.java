package kr.co.popone.fitts.feature.event;

import android.view.View;
import android.view.View.OnClickListener;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.BiConsumer;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.event.AppliableEventApplyActivity.Parameters;
import kr.co.popone.fitts.model.event.EventAPI.AppliableEventAppliabilityCheckResponse;
import kr.co.popone.fitts.model.event.EventAPI.AppliableEventResponse;
import kr.co.popone.fitts.model.event.EventAPI.AppliableEventResponse.Type;
import kr.co.popone.fitts.ui.DialogExtensions;
import org.jetbrains.anko.internals.AnkoInternals;

final class AppliableCollaborativeEventActivity$onCreate$5 implements OnClickListener {
    final /* synthetic */ AppliableCollaborativeEventActivity this$0;

    AppliableCollaborativeEventActivity$onCreate$5(AppliableCollaborativeEventActivity appliableCollaborativeEventActivity) {
        this.this$0 = appliableCollaborativeEventActivity;
    }

    public final void onClick(View view) {
        AppliableEventResponse access$getEventResponse$p = this.this$0.eventResponse;
        if ((access$getEventResponse$p != null ? access$getEventResponse$p.getType() : null) == Type.ALL && this.this$0.eventAppliabilityCheckRequest == null && this.this$0.eventResponse != null) {
            AppliableEventResponse access$getEventResponse$p2 = this.this$0.eventResponse;
            if (access$getEventResponse$p2 != null) {
                List items = access$getEventResponse$p2.getItems();
                if (items != null && (!items.isEmpty())) {
                    AppliableCollaborativeEventActivity appliableCollaborativeEventActivity = this.this$0;
                    appliableCollaborativeEventActivity.eventAppliabilityCheckRequest = appliableCollaborativeEventActivity.getEventAPI$app_productionFittsRelease().requestAppliableEventAppliable(this.this$0.getEventID(), null).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new BiConsumer<AppliableEventAppliabilityCheckResponse, Throwable>(this) {
                        final /* synthetic */ AppliableCollaborativeEventActivity$onCreate$5 this$0;

                        {
                            this.this$0 = r1;
                        }

                        public final void accept(AppliableEventAppliabilityCheckResponse appliableEventAppliabilityCheckResponse, Throwable th) {
                            this.this$0.this$0.eventAppliabilityCheckRequest = null;
                            if (appliableEventAppliabilityCheckResponse == null) {
                                return;
                            }
                            if (appliableEventAppliabilityCheckResponse.isAvailable()) {
                                AppliableCollaborativeEventActivity appliableCollaborativeEventActivity = this.this$0.this$0;
                                Pair[] pairArr = new Pair[1];
                                long access$getEventID$p = appliableCollaborativeEventActivity.getEventID();
                                AppliableEventResponse access$getEventResponse$p = this.this$0.this$0.eventResponse;
                                if (access$getEventResponse$p == null) {
                                    Intrinsics.throwNpe();
                                }
                                pairArr[0] = TuplesKt.to("parameters", new Parameters(access$getEventID$p, access$getEventResponse$p.getItems()));
                                appliableCollaborativeEventActivity.startActivityForResult(AnkoInternals.createIntent(appliableCollaborativeEventActivity, AppliableEventApplyActivity.class, pairArr), 100);
                                return;
                            }
                            DialogExtensions.showMessageDialog$default(DialogExtensions.INSTANCE, this.this$0.this$0, "하루에 한 번 응모할 수 있어요", "내일 다시 응모해주세요", null, "확인", 8, null);
                        }
                    });
                }
            }
        }
    }
}
