package kr.co.popone.fitts.feature.identification.viewmodel;

import io.reactivex.functions.BiConsumer;
import io.reactivex.subjects.PublishSubject;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.identification.model.IdentificationViewData;
import kr.co.popone.fitts.model.user.UserAPI.IvsInfo;

final class IdentificationAdditionalInfoViewModel$initModel$1<T1, T2> implements BiConsumer<IvsInfo, Throwable> {
    final /* synthetic */ IdentificationAdditionalInfoViewModel this$0;

    IdentificationAdditionalInfoViewModel$initModel$1(IdentificationAdditionalInfoViewModel identificationAdditionalInfoViewModel) {
        this.this$0 = identificationAdditionalInfoViewModel;
    }

    public final void accept(IvsInfo ivsInfo, Throwable th) {
        if (ivsInfo != null) {
            this.this$0.model = new IdentificationViewData(ivsInfo.getContactInfo().getName(), ivsInfo.getContactInfo().getContact(), ivsInfo.getDateOfBirth(), ivsInfo.getGenderNumber());
            PublishSubject userIdentificationSubject = this.this$0.getUserIdentificationSubject();
            IdentificationViewData access$getModel$p = this.this$0.model;
            if (access$getModel$p == null) {
                Intrinsics.throwNpe();
            }
            userIdentificationSubject.onNext(access$getModel$p);
            return;
        }
        this.this$0.getErrorOccurSubject().onNext(th);
    }
}
