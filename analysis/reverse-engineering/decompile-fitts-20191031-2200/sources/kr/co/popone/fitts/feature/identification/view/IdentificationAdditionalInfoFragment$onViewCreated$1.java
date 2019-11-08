package kr.co.popone.fitts.feature.identification.view;

import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kr.co.popone.fitts.event.RxBus;
import kr.co.popone.fitts.feature.identification.IdentificationEvent;

final class IdentificationAdditionalInfoFragment$onViewCreated$1<T> implements Consumer<Unit> {
    public static final IdentificationAdditionalInfoFragment$onViewCreated$1 INSTANCE = new IdentificationAdditionalInfoFragment$onViewCreated$1();

    IdentificationAdditionalInfoFragment$onViewCreated$1() {
    }

    public final void accept(Unit unit) {
        RxBus.INSTANCE.post(IdentificationEvent.CLOSE_WINDOW);
    }
}
