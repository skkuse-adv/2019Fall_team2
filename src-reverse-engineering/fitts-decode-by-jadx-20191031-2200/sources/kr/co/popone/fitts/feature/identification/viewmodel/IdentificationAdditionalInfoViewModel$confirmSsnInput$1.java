package kr.co.popone.fitts.feature.identification.viewmodel;

import io.reactivex.functions.Action;
import kotlin.Unit;
import kr.co.popone.fitts.event.RxBus;
import kr.co.popone.fitts.feature.identification.IdentificationEvent;

final class IdentificationAdditionalInfoViewModel$confirmSsnInput$1 implements Action {
    public static final IdentificationAdditionalInfoViewModel$confirmSsnInput$1 INSTANCE = new IdentificationAdditionalInfoViewModel$confirmSsnInput$1();

    IdentificationAdditionalInfoViewModel$confirmSsnInput$1() {
    }

    public final void run() {
        RxBus rxBus = RxBus.INSTANCE;
        rxBus.post(IdentificationEvent.RESULT_SUCCESS);
        rxBus.post(Unit.INSTANCE);
    }
}
