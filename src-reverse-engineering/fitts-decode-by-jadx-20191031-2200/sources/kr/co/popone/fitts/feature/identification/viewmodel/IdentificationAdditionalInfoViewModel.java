package kr.co.popone.fitts.feature.identification.viewmodel;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0006R$color;
import kr.co.popone.fitts.feature.identification.IdentificationEvent;
import kr.co.popone.fitts.feature.identification.model.IdentificationUseCaseKt;
import kr.co.popone.fitts.feature.identification.model.IdentificationViewData;
import kr.co.popone.fitts.model.user.UserAPI;
import org.jetbrains.annotations.NotNull;

public final class IdentificationAdditionalInfoViewModel {
    @NotNull
    private final PublishSubject<Throwable> errorOccurSubject;
    @NotNull
    private final PublishSubject<IdentificationEvent> identificationResult;
    private boolean isConfirmClicked;
    /* access modifiers changed from: private */
    public IdentificationViewData model;
    @NotNull
    private final BehaviorSubject<TextValdationColor> secondSsnNotInvalid;
    @NotNull
    private final UserAPI userApi;
    @NotNull
    private final PublishSubject<IdentificationViewData> userIdentificationSubject;

    public enum TextValdationColor {
        VALID(C0006R$color.gray6),
        INVALID(C0006R$color.neon_red);
        
        private final int color;

        private TextValdationColor(int i) {
            this.color = i;
        }

        public final int getColor() {
            return this.color;
        }
    }

    public IdentificationAdditionalInfoViewModel(@NotNull UserAPI userAPI) {
        Intrinsics.checkParameterIsNotNull(userAPI, "userApi");
        this.userApi = userAPI;
        PublishSubject<Throwable> create = PublishSubject.create();
        Intrinsics.checkExpressionValueIsNotNull(create, "PublishSubject.create<Throwable>()");
        this.errorOccurSubject = create;
        PublishSubject<IdentificationViewData> create2 = PublishSubject.create();
        Intrinsics.checkExpressionValueIsNotNull(create2, "PublishSubject.create<IdentificationViewData>()");
        this.userIdentificationSubject = create2;
        PublishSubject<IdentificationEvent> create3 = PublishSubject.create();
        Intrinsics.checkExpressionValueIsNotNull(create3, "PublishSubject.create<IdentificationEvent>()");
        this.identificationResult = create3;
        BehaviorSubject<TextValdationColor> createDefault = BehaviorSubject.createDefault(TextValdationColor.VALID);
        Intrinsics.checkExpressionValueIsNotNull(createDefault, "BehaviorSubject.createDe…TextValdationColor.VALID)");
        this.secondSsnNotInvalid = createDefault;
    }

    @NotNull
    public final UserAPI getUserApi() {
        return this.userApi;
    }

    @NotNull
    public final PublishSubject<Throwable> getErrorOccurSubject() {
        return this.errorOccurSubject;
    }

    @NotNull
    public final PublishSubject<IdentificationViewData> getUserIdentificationSubject() {
        return this.userIdentificationSubject;
    }

    @NotNull
    public final Disposable initModel() {
        Disposable subscribe = this.userApi.requestIvsInfo().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new IdentificationAdditionalInfoViewModel$initModel$1<Object,Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "userApi.requestIvsInfo()…      }\n                }");
        return subscribe;
    }

    public final void ssnStartString(@NotNull Function1<? super String, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "body");
        IdentificationViewData identificationViewData = this.model;
        if (identificationViewData != null && identificationViewData.getSsnSecond().length() > 0) {
            function1.invoke(String.valueOf(identificationViewData.getSsnSecond().charAt(0)));
        }
    }

    public final void inputSsnInfo(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "ssn");
        IdentificationViewData identificationViewData = this.model;
        if (identificationViewData != null) {
            if (str.length() != 0) {
                identificationViewData.setSsnSecond(str);
            }
            secondSsnValidationCheck();
        }
    }

    @NotNull
    public final PublishSubject<IdentificationEvent> getIdentificationResult() {
        return this.identificationResult;
    }

    public final void confirmSsnInput() {
        this.isConfirmClicked = true;
        IdentificationViewData identificationViewData = this.model;
        Boolean valueOf = identificationViewData != null ? Boolean.valueOf(IdentificationUseCaseKt.isValid(identificationViewData)) : null;
        if (valueOf == null) {
            Intrinsics.throwNpe();
        }
        if (valueOf.booleanValue()) {
            this.secondSsnNotInvalid.onNext(TextValdationColor.VALID);
            UserAPI userAPI = this.userApi;
            StringBuilder sb = new StringBuilder();
            IdentificationViewData identificationViewData2 = this.model;
            if (identificationViewData2 == null) {
                Intrinsics.throwNpe();
            }
            sb.append(identificationViewData2.getSsnFirst());
            sb.append('-');
            IdentificationViewData identificationViewData3 = this.model;
            if (identificationViewData3 == null) {
                Intrinsics.throwNpe();
            }
            sb.append(identificationViewData3.getSsnSecond());
            Intrinsics.checkExpressionValueIsNotNull(userAPI.updateIvsInfo(sb.toString()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(IdentificationAdditionalInfoViewModel$confirmSsnInput$1.INSTANCE, new IdentificationAdditionalInfoViewModel$confirmSsnInput$2(this)), "userApi.updateIvsInfo(\"$…t)\n                    })");
            return;
        }
        this.secondSsnNotInvalid.onNext(TextValdationColor.INVALID);
    }

    @NotNull
    public final BehaviorSubject<TextValdationColor> getSecondSsnNotInvalid() {
        return this.secondSsnNotInvalid;
    }

    private final void secondSsnValidationCheck() {
        if (this.isConfirmClicked) {
            IdentificationViewData identificationViewData = this.model;
            Boolean valueOf = identificationViewData != null ? Boolean.valueOf(IdentificationUseCaseKt.isValid(identificationViewData)) : null;
            if (valueOf == null) {
                Intrinsics.throwNpe();
            }
            if (valueOf.booleanValue()) {
                this.secondSsnNotInvalid.onNext(TextValdationColor.VALID);
            } else {
                this.secondSsnNotInvalid.onNext(TextValdationColor.INVALID);
            }
        }
    }
}
