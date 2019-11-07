package kr.co.popone.fitts.feature.identification.view;

import io.reactivex.functions.Consumer;

final class IdentificationAdditionalInfoFragment$onViewCreated$5<T> implements Consumer<CharSequence> {
    final /* synthetic */ IdentificationAdditionalInfoFragment this$0;

    IdentificationAdditionalInfoFragment$onViewCreated$5(IdentificationAdditionalInfoFragment identificationAdditionalInfoFragment) {
        this.this$0 = identificationAdditionalInfoFragment;
    }

    public final void accept(CharSequence charSequence) {
        this.this$0.getViewModel().inputSsnInfo(charSequence.toString());
    }
}
