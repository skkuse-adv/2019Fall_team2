package kr.co.popone.fitts.feature.identification.viewmodel;

import io.reactivex.functions.Consumer;

final class IdentificationAdditionalInfoViewModel$confirmSsnInput$2<T> implements Consumer<Throwable> {
    final /* synthetic */ IdentificationAdditionalInfoViewModel this$0;

    IdentificationAdditionalInfoViewModel$confirmSsnInput$2(IdentificationAdditionalInfoViewModel identificationAdditionalInfoViewModel) {
        this.this$0 = identificationAdditionalInfoViewModel;
    }

    public final void accept(Throwable th) {
        this.this$0.getErrorOccurSubject().onNext(th);
    }
}
