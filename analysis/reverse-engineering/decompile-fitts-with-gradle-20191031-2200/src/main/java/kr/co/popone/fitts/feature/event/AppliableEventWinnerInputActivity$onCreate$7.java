package kr.co.popone.fitts.feature.event;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.orhanobut.logger.Logger;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.BiConsumer;
import io.reactivex.schedulers.Schedulers;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.model.event.EventAPI.AppliableEventApplyResponse;
import kr.co.popone.fitts.ui.DialogExtensions;

final class AppliableEventWinnerInputActivity$onCreate$7 implements OnClickListener {
    final /* synthetic */ AppliableEventWinnerInputActivity this$0;

    AppliableEventWinnerInputActivity$onCreate$7(AppliableEventWinnerInputActivity appliableEventWinnerInputActivity) {
        this.this$0 = appliableEventWinnerInputActivity;
    }

    public final void onClick(View view) {
        EditText editText = (EditText) this.this$0._$_findCachedViewById(C0010R$id.shippingPersonEditText);
        Intrinsics.checkExpressionValueIsNotNull(editText, "shippingPersonEditText");
        String obj = editText.getText().toString();
        EditText editText2 = (EditText) this.this$0._$_findCachedViewById(C0010R$id.shippingContactEditText);
        Intrinsics.checkExpressionValueIsNotNull(editText2, "shippingContactEditText");
        String obj2 = editText2.getText().toString();
        String str = (String) this.this$0.shippingZipCodeSubject.getValue();
        if (str == null) {
            str = "";
        }
        String str2 = str;
        Intrinsics.checkExpressionValueIsNotNull(str2, "shippingZipCodeSubject.value ?: \"\"");
        EditText editText3 = (EditText) this.this$0._$_findCachedViewById(C0010R$id.address1EditText);
        Intrinsics.checkExpressionValueIsNotNull(editText3, "address1EditText");
        String obj3 = editText3.getText().toString();
        EditText editText4 = (EditText) this.this$0._$_findCachedViewById(C0010R$id.address2EditText);
        Intrinsics.checkExpressionValueIsNotNull(editText4, "address2EditText");
        String obj4 = editText4.getText().toString();
        EditText editText5 = (EditText) this.this$0._$_findCachedViewById(C0010R$id.shippingMemoEditText);
        Intrinsics.checkExpressionValueIsNotNull(editText5, "shippingMemoEditText");
        String obj5 = editText5.getText().toString();
        Boolean bool = (Boolean) this.this$0.isAppliableSubject.getValue();
        if (bool == null) {
            bool = Boolean.valueOf(false);
        }
        Intrinsics.checkExpressionValueIsNotNull(bool, "isAppliableSubject.value ?: false");
        if (this.this$0.checkAgreeable(obj, obj2, str2, obj3, bool.booleanValue()) && this.this$0.ticketEnrollRequest == null) {
            AppliableEventWinnerInputActivity appliableEventWinnerInputActivity = this.this$0;
            appliableEventWinnerInputActivity.ticketEnrollRequest = appliableEventWinnerInputActivity.getEventAPI$app_productionFittsRelease().requestEnrollTicket(this.this$0.ticketID, obj, obj2, str2, obj3, obj4, obj5, null).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new BiConsumer<AppliableEventApplyResponse, Throwable>(this) {
                final /* synthetic */ AppliableEventWinnerInputActivity$onCreate$7 this$0;

                {
                    this.this$0 = r1;
                }

                public final void accept(AppliableEventApplyResponse appliableEventApplyResponse, Throwable th) {
                    this.this$0.this$0.ticketEnrollRequest = null;
                    StringBuilder sb = new StringBuilder();
                    sb.append("ticketEnrollResponse ");
                    sb.append(appliableEventApplyResponse);
                    sb.append(' ');
                    sb.append(th);
                    Logger.d(sb.toString(), new Object[0]);
                    if (appliableEventApplyResponse == null) {
                        return;
                    }
                    if (appliableEventApplyResponse.getCode() == 100) {
                        DialogExtensions.INSTANCE.showMessageDialog(this.this$0.this$0, "곧 신상을 받아보실 수 있어요!", "상품의 배송이 시작되면\n푸시알림을 통해 알려드릴게요", new Function0<Unit>(this) {
                            final /* synthetic */ AnonymousClass1 this$0;

                            {
                                this.this$0 = r1;
                            }

                            public final void invoke() {
                                this.this$0.this$0.this$0.dismissActivity(-1);
                            }
                        }, "확인");
                    } else if (appliableEventApplyResponse.getCode() == 101) {
                        DialogExtensions.INSTANCE.showMessageDialog(this.this$0.this$0, "이미 등록이 완료되었어요", "변경사항이 있으시다면 플러스친구를 통해 문의해주세요", new Function0<Unit>(this) {
                            final /* synthetic */ AnonymousClass1 this$0;

                            {
                                this.this$0 = r1;
                            }

                            public final void invoke() {
                                this.this$0.this$0.this$0.dismissActivity(-1);
                            }
                        }, "확인");
                    }
                }
            });
        }
    }
}
