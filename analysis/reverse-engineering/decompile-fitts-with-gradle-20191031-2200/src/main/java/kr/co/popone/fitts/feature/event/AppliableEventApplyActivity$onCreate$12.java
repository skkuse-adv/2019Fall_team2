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

final class AppliableEventApplyActivity$onCreate$12 implements OnClickListener {
    final /* synthetic */ AppliableEventApplyActivity this$0;

    AppliableEventApplyActivity$onCreate$12(AppliableEventApplyActivity appliableEventApplyActivity) {
        this.this$0 = appliableEventApplyActivity;
    }

    public final void onClick(View view) {
        if (this.this$0.applyRequest == null) {
            String str = (String) this.this$0.selectedItemSubject.getValue();
            if (str == null) {
                str = "";
            }
            String str2 = str;
            Intrinsics.checkExpressionValueIsNotNull(str2, "selectedItemSubject.value ?: \"\"");
            EditText editText = (EditText) this.this$0._$_findCachedViewById(C0010R$id.productDetailPageLinkEditText);
            Intrinsics.checkExpressionValueIsNotNull(editText, "productDetailPageLinkEditText");
            String obj = editText.getText().toString();
            EditText editText2 = (EditText) this.this$0._$_findCachedViewById(C0010R$id.productColorEditText);
            Intrinsics.checkExpressionValueIsNotNull(editText2, "productColorEditText");
            String obj2 = editText2.getText().toString();
            EditText editText3 = (EditText) this.this$0._$_findCachedViewById(C0010R$id.productSizeEditText);
            Intrinsics.checkExpressionValueIsNotNull(editText3, "productSizeEditText");
            String obj3 = editText3.getText().toString();
            if ((!StringsKt__StringsJVMKt.isBlank(str2)) && (!StringsKt__StringsJVMKt.isBlank(obj)) && (!StringsKt__StringsJVMKt.isBlank(obj2)) && (!StringsKt__StringsJVMKt.isBlank(obj3))) {
                AppliableEventApplyActivity appliableEventApplyActivity = this.this$0;
                appliableEventApplyActivity.applyRequest = appliableEventApplyActivity.getEventAPI$app_productionFittsRelease().requestAppliableEventApply(AppliableEventApplyActivity.access$getParameters$p(this.this$0).getEventID(), str2, obj3, obj2, obj, null).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new BiConsumer<AppliableEventApplyResponse, Throwable>(this) {
                    final /* synthetic */ AppliableEventApplyActivity$onCreate$12 this$0;

                    {
                        this.this$0 = r1;
                    }

                    public final void accept(AppliableEventApplyResponse appliableEventApplyResponse, Throwable th) {
                        this.this$0.this$0.applyRequest = null;
                        StringBuilder sb = new StringBuilder();
                        sb.append("applyRequest ");
                        sb.append(appliableEventApplyResponse);
                        sb.append("   ");
                        sb.append(th);
                        Logger.d(sb.toString(), new Object[0]);
                        if (appliableEventApplyResponse != null && appliableEventApplyResponse.getCode() == 100) {
                            DialogExtensions.INSTANCE.showMessageDialog(this.this$0.this$0, "응모가 완료되었습니다", "당첨 결과를 푸시알림으로 알려드리니 푸시알림을 꼭 켜두세요", new Function0<Unit>(this) {
                                final /* synthetic */ AnonymousClass1 this$0;

                                {
                                    this.this$0 = r1;
                                }

                                public final void invoke() {
                                    this.this$0.this$0.this$0.setResult(-1);
                                    this.this$0.this$0.this$0.finish();
                                }
                            }, "확인");
                        }
                    }
                });
            }
        }
    }
}
