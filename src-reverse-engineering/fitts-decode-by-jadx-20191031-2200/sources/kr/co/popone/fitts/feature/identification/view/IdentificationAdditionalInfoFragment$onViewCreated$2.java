package kr.co.popone.fitts.feature.identification.view;

import io.reactivex.functions.Consumer;
import kotlin.Unit;

final class IdentificationAdditionalInfoFragment$onViewCreated$2<T> implements Consumer<Unit> {
    final /* synthetic */ IdentificationAdditionalInfoFragment this$0;

    IdentificationAdditionalInfoFragment$onViewCreated$2(IdentificationAdditionalInfoFragment identificationAdditionalInfoFragment) {
        this.this$0 = identificationAdditionalInfoFragment;
    }

    public final void accept(Unit unit) {
        this.this$0.getViewModel().confirmSsnInput();
    }
}
