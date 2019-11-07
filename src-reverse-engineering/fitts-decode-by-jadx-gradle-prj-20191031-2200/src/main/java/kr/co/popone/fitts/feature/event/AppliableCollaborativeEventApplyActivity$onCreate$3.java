package kr.co.popone.fitts.feature.event;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.orhanobut.logger.Logger;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.BiConsumer;
import io.reactivex.schedulers.Schedulers;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0006R$color;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.model.event.EventAPI.AppliableEventApplyResponse;
import kr.co.popone.fitts.ui.DialogExtensions;

final class AppliableCollaborativeEventApplyActivity$onCreate$3 implements OnClickListener {
    final /* synthetic */ AppliableCollaborativeEventApplyActivity this$0;

    AppliableCollaborativeEventApplyActivity$onCreate$3(AppliableCollaborativeEventApplyActivity appliableCollaborativeEventApplyActivity) {
        this.this$0 = appliableCollaborativeEventApplyActivity;
    }

    public final void onClick(View view) {
        EditText editText = (EditText) this.this$0._$_findCachedViewById(C0010R$id.productColorEditText);
        Intrinsics.checkExpressionValueIsNotNull(editText, "productColorEditText");
        String obj = editText.getText().toString();
        EditText editText2 = (EditText) this.this$0._$_findCachedViewById(C0010R$id.productSizeEditText);
        Intrinsics.checkExpressionValueIsNotNull(editText2, "productSizeEditText");
        String obj2 = editText2.getText().toString();
        if (StringsKt__StringsJVMKt.isBlank(obj) || StringsKt__StringsJVMKt.isBlank(obj2)) {
            ((TextView) this.this$0._$_findCachedViewById(C0010R$id.productOptionLabel)).setTextColor(ContextCompat.getColor(this.this$0, C0006R$color.neon_red));
            return;
        }
        ((TextView) this.this$0._$_findCachedViewById(C0010R$id.productOptionLabel)).setTextColor(ContextCompat.getColor(this.this$0, C0006R$color.gray6));
        AppliableCollaborativeEventApplyActivity appliableCollaborativeEventApplyActivity = this.this$0;
        appliableCollaborativeEventApplyActivity.applyRequest = appliableCollaborativeEventApplyActivity.getEventAPI$app_productionFittsRelease().requestAppliableEventApply(this.this$0.getParameters().getEventID(), null, obj2, obj, this.this$0.getParameters().getLinkUrl(), Long.valueOf(this.this$0.getParameters().getShop().getId())).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new BiConsumer<AppliableEventApplyResponse, Throwable>(this) {
            final /* synthetic */ AppliableCollaborativeEventApplyActivity$onCreate$3 this$0;

            {
                this.this$0 = r1;
            }

            public final void accept(AppliableEventApplyResponse appliableEventApplyResponse, Throwable th) {
                this.this$0.this$0.applyRequest = null;
                StringBuilder sb = new StringBuilder();
                sb.append("applyRequest ");
                sb.append(appliableEventApplyResponse);
                sb.append(' ');
                sb.append(th);
                Logger.d(sb.toString(), new Object[0]);
                if (appliableEventApplyResponse == null) {
                    return;
                }
                if (appliableEventApplyResponse.getCode() == 100) {
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
                    return;
                }
                DialogExtensions.INSTANCE.showMessageDialog(this.this$0.this$0, "오늘은 이미 응모했어요!", "하루에 한 쇼핑몰에서\n한 개의 상품만 응모 가능해요", new Function0<Unit>(this) {
                    final /* synthetic */ AnonymousClass1 this$0;

                    {
                        this.this$0 = r1;
                    }

                    public final void invoke() {
                        this.this$0.this$0.this$0.dismissActivity();
                    }
                }, "확인");
            }
        });
    }
}
