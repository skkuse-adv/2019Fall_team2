package kr.co.popone.fitts.feature.event;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.jakewharton.rxbinding2.InitialValueObservable;
import com.jakewharton.rxbinding2.widget.RxTextView;
import com.orhanobut.logger.Logger;
import dagger.android.AndroidInjection;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0001R$anim;
import kr.co.popone.fitts.C0008R$drawable;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.feature.reward.AddressWebViewActivity.Result;
import kr.co.popone.fitts.model.event.EventAPI;
import kr.co.popone.fitts.model.event.EventAPI.Ticket;
import kr.co.popone.fitts.model.user.UserAPI;
import kr.co.popone.fitts.ui.DialogExtensions;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class AppliableEventWinnerInputActivity extends AppCompatActivity {
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String PARAMETER_EVENT_ID = "eventID";
    @NotNull
    public static final String PARAMETER_TICKET_ID = "ticketID";
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public Disposable agreementImageRequest;
    @NotNull
    public EventAPI eventAPI;
    private long eventID;
    /* access modifiers changed from: private */
    public final BehaviorSubject<Boolean> isAppliableSubject;
    /* access modifiers changed from: private */
    public boolean isCancelling;
    /* access modifiers changed from: private */
    public Disposable shippingInfoRequest;
    /* access modifiers changed from: private */
    public BehaviorSubject<String> shippingZipCodeSubject;
    /* access modifiers changed from: private */
    public Disposable ticketEnrollRequest;
    /* access modifiers changed from: private */
    public long ticketID;
    /* access modifiers changed from: private */
    public Disposable ticketInfoRequest;
    /* access modifiers changed from: private */
    public Ticket ticketInfoResponse;
    @NotNull
    public UserAPI userAPI;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    public AppliableEventWinnerInputActivity() {
        BehaviorSubject<Boolean> createDefault = BehaviorSubject.createDefault(Boolean.valueOf(false));
        Intrinsics.checkExpressionValueIsNotNull(createDefault, "BehaviorSubject.createDefault(false)");
        this.isAppliableSubject = createDefault;
        BehaviorSubject<String> createDefault2 = BehaviorSubject.createDefault("");
        Intrinsics.checkExpressionValueIsNotNull(createDefault2, "BehaviorSubject.createDefault(\"\")");
        this.shippingZipCodeSubject = createDefault2;
    }

    @NotNull
    public final EventAPI getEventAPI$app_productionFittsRelease() {
        EventAPI eventAPI2 = this.eventAPI;
        if (eventAPI2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eventAPI");
        }
        return eventAPI2;
    }

    public final void setEventAPI$app_productionFittsRelease(@NotNull EventAPI eventAPI2) {
        Intrinsics.checkParameterIsNotNull(eventAPI2, "<set-?>");
        this.eventAPI = eventAPI2;
    }

    @NotNull
    public final UserAPI getUserAPI$app_productionFittsRelease() {
        UserAPI userAPI2 = this.userAPI;
        if (userAPI2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userAPI");
        }
        return userAPI2;
    }

    public final void setUserAPI$app_productionFittsRelease(@NotNull UserAPI userAPI2) {
        Intrinsics.checkParameterIsNotNull(userAPI2, "<set-?>");
        this.userAPI = userAPI2;
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        AndroidInjection.inject((Activity) this);
        super.onCreate(bundle);
        setContentView((int) C0013R$layout.activity_appliable_event_winner_input);
        ((ImageButton) _$_findCachedViewById(C0010R$id.backButton)).setImageResource(C0008R$drawable.button_cancel);
        ((ImageButton) _$_findCachedViewById(C0010R$id.backButton)).setColorFilter(Color.parseColor("#000000"));
        ((ImageButton) _$_findCachedViewById(C0010R$id.backButton)).setOnClickListener(new AppliableEventWinnerInputActivity$onCreate$1(this));
        this.ticketID = getIntent().getLongExtra(PARAMETER_TICKET_ID, 0);
        this.eventID = getIntent().getLongExtra(PARAMETER_EVENT_ID, 0);
        if (this.ticketID == 0 || this.eventID == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("eventID ");
            sb.append(this.eventID);
            sb.append(" ticketID ");
            sb.append(this.ticketID);
            throw new IllegalArgumentException(sb.toString());
        }
        ((Button) _$_findCachedViewById(C0010R$id.showProductLinkButton)).setOnClickListener(new AppliableEventWinnerInputActivity$onCreate$2(this));
        ((Button) _$_findCachedViewById(C0010R$id.searchAddressButton)).setOnClickListener(new AppliableEventWinnerInputActivity$onCreate$3(this));
        this.isAppliableSubject.subscribe((Consumer<? super T>) new AppliableEventWinnerInputActivity$onCreate$4<Object>(this));
        EditText editText = (EditText) _$_findCachedViewById(C0010R$id.shippingPersonEditText);
        Intrinsics.checkExpressionValueIsNotNull(editText, "shippingPersonEditText");
        InitialValueObservable textChanges = RxTextView.textChanges(editText);
        String str = "RxTextView.textChanges(this)";
        Intrinsics.checkExpressionValueIsNotNull(textChanges, str);
        EditText editText2 = (EditText) _$_findCachedViewById(C0010R$id.shippingContactEditText);
        Intrinsics.checkExpressionValueIsNotNull(editText2, "shippingContactEditText");
        InitialValueObservable textChanges2 = RxTextView.textChanges(editText2);
        Intrinsics.checkExpressionValueIsNotNull(textChanges2, str);
        BehaviorSubject<String> behaviorSubject = this.shippingZipCodeSubject;
        EditText editText3 = (EditText) _$_findCachedViewById(C0010R$id.address1EditText);
        Intrinsics.checkExpressionValueIsNotNull(editText3, "address1EditText");
        InitialValueObservable textChanges3 = RxTextView.textChanges(editText3);
        Intrinsics.checkExpressionValueIsNotNull(textChanges3, str);
        Observable.combineLatest(textChanges, textChanges2, behaviorSubject, textChanges3, this.isAppliableSubject, new AppliableEventWinnerInputActivity$onCreate$5(this)).subscribe((Consumer<? super T>) new AppliableEventWinnerInputActivity$onCreate$6<Object>(this));
        ((Button) _$_findCachedViewById(C0010R$id.termsAgreeButton)).setOnClickListener(new AppliableEventWinnerInputActivity$onCreate$7(this));
        loadUserInfo();
        loadAgreementImage();
        loadShippingInfo();
        loadTicketInfo();
    }

    @SuppressLint({"RestrictedApi"})
    private final void loadUserInfo() {
        UserAPI userAPI2 = this.userAPI;
        if (userAPI2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userAPI");
        }
        userAPI2.getUserInfo().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new AppliableEventWinnerInputActivity$loadUserInfo$1<Object,Object>(this));
    }

    /* access modifiers changed from: private */
    public final boolean checkAgreeable(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, boolean z) {
        if (!(!StringsKt__StringsJVMKt.isBlank(charSequence)) || !(!StringsKt__StringsJVMKt.isBlank(charSequence2)) || !(!StringsKt__StringsJVMKt.isBlank(charSequence3)) || !(!StringsKt__StringsJVMKt.isBlank(charSequence4)) || !z) {
            return false;
        }
        return true;
    }

    private final void loadAgreementImage() {
        if (this.agreementImageRequest == null) {
            EventAPI eventAPI2 = this.eventAPI;
            if (eventAPI2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("eventAPI");
            }
            this.agreementImageRequest = eventAPI2.requestAgreementImage(this.eventID).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new AppliableEventWinnerInputActivity$loadAgreementImage$1<Object,Object>(this));
        }
    }

    private final void loadTicketInfo() {
        if (this.ticketInfoRequest == null) {
            EventAPI eventAPI2 = this.eventAPI;
            if (eventAPI2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("eventAPI");
            }
            this.ticketInfoRequest = eventAPI2.requestTicketInfo(this.ticketID).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new AppliableEventWinnerInputActivity$loadTicketInfo$1<Object,Object>(this));
        }
    }

    /* access modifiers changed from: private */
    @SuppressLint({"SetTextI18n"})
    public final void updateUI() {
        Ticket ticket = this.ticketInfoResponse;
        if (ticket != null) {
            String str = "productInfoLayoutSpace";
            String str2 = "shopInfoLayout";
            if (ticket.getShop() != null) {
                TextView textView = (TextView) _$_findCachedViewById(C0010R$id.shopInfoTextView);
                Intrinsics.checkExpressionValueIsNotNull(textView, "shopInfoTextView");
                textView.setText(ticket.getShop().getName());
                LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(C0010R$id.shopInfoLayout);
                Intrinsics.checkExpressionValueIsNotNull(linearLayout, str2);
                linearLayout.setVisibility(0);
                Space space = (Space) _$_findCachedViewById(C0010R$id.productInfoLayoutSpace);
                Intrinsics.checkExpressionValueIsNotNull(space, str);
                space.setVisibility(0);
            } else {
                LinearLayout linearLayout2 = (LinearLayout) _$_findCachedViewById(C0010R$id.shopInfoLayout);
                Intrinsics.checkExpressionValueIsNotNull(linearLayout2, str2);
                linearLayout2.setVisibility(8);
                Space space2 = (Space) _$_findCachedViewById(C0010R$id.productInfoLayoutSpace);
                Intrinsics.checkExpressionValueIsNotNull(space2, str);
                space2.setVisibility(8);
            }
            TextView textView2 = (TextView) _$_findCachedViewById(C0010R$id.productInfoOptionTextView);
            Intrinsics.checkExpressionValueIsNotNull(textView2, "productInfoOptionTextView");
            StringBuilder sb = new StringBuilder();
            sb.append(ticket.getColor());
            sb.append(' ');
            sb.append(ticket.getSize());
            textView2.setText(sb.toString());
        }
    }

    private final void loadShippingInfo() {
        if (this.shippingInfoRequest == null) {
            UserAPI userAPI2 = this.userAPI;
            if (userAPI2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("userAPI");
            }
            this.shippingInfoRequest = userAPI2.requestShippingAddress().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new AppliableEventWinnerInputActivity$loadShippingInfo$1<Object,Object>(this));
        }
    }

    public void onBackPressed() {
        if (!Intrinsics.areEqual((Object) (Boolean) this.isAppliableSubject.getValue(), (Object) Boolean.valueOf(true))) {
            dismissActivity(0);
        } else if (!this.isCancelling) {
            this.isCancelling = true;
            DialogExtensions.showConfirmDialog$default(DialogExtensions.INSTANCE, this, "정말 작성을 취소하시겠어요?", "작성중인 정보가 사라집니다.", new AppliableEventWinnerInputActivity$onBackPressed$1(this), new AppliableEventWinnerInputActivity$onBackPressed$2(this), null, null, 0, 224, null);
        }
    }

    /* access modifiers changed from: private */
    public final void dismissActivity(int i) {
        setResult(i);
        finish();
        overridePendingTransition(C0001R$anim.fade_in, C0001R$anim.slide_down);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        Disposable disposable = this.agreementImageRequest;
        if (disposable != null) {
            disposable.dispose();
        }
        Disposable disposable2 = this.ticketInfoRequest;
        if (disposable2 != null) {
            disposable2.dispose();
        }
        Disposable disposable3 = this.shippingInfoRequest;
        if (disposable3 != null) {
            disposable3.dispose();
        }
        Disposable disposable4 = this.ticketEnrollRequest;
        if (disposable4 != null) {
            disposable4.dispose();
        }
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        if (i != 200) {
            if (i != 201) {
                super.onActivityResult(i, i2, intent);
            } else if (i2 == 0) {
                dismissActivity(i2);
            }
        } else if (intent != null) {
            Result result = (Result) intent.getParcelableExtra("result");
            StringBuilder sb = new StringBuilder();
            sb.append("address search result ");
            sb.append(result);
            Logger.d(sb.toString(), new Object[0]);
            ((EditText) _$_findCachedViewById(C0010R$id.address1EditText)).setText(result.getAddress());
            this.shippingZipCodeSubject.onNext(result.getZoneCode());
        } else {
            Logger.d("address search cancelled", new Object[0]);
        }
    }
}
