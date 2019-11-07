package kr.co.popone.fitts.feature.identification.view;

import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0016R$string;
import kr.co.popone.fitts.feature.identification.IdentificationEvent;
import kr.co.popone.fitts.ui.DialogExtensions;

final class IdentificationActivity$onCreate$1<T> implements Consumer<Object> {
    final /* synthetic */ IdentificationActivity this$0;

    IdentificationActivity$onCreate$1(IdentificationActivity identificationActivity) {
        this.this$0 = identificationActivity;
    }

    public final void accept(Object obj) {
        if (obj == IdentificationEvent.CLOSE_WINDOW) {
            this.this$0.onBackPressed();
        } else if (obj == IdentificationEvent.START_WEBVIEW) {
            this.this$0.changeFragmentWithAnim(IdentificationWebViewFragment.Companion.newInstance());
        } else if (obj == IdentificationEvent.START_ADDITIONAL_INFO) {
            this.this$0.changeFragmentWithAnim(IdentificationAdditionalInfoFragment.Companion.newInstance());
        } else if (obj == IdentificationEvent.RESULT_DUPLICATION) {
            this.this$0.changeFragmentWithAnim(IdentificationDuplicateFragment.Companion.newInstance());
        } else if (obj == IdentificationEvent.RESULT_SUCCESS) {
            DialogExtensions.INSTANCE.showMessageDialog(this.this$0, "", "인증이 완료되었습니다.", new Function0<Unit>(this) {
                final /* synthetic */ IdentificationActivity$onCreate$1 this$0;

                {
                    this.this$0 = r1;
                }

                public final void invoke() {
                    this.this$0.this$0.setResult(-1);
                    this.this$0.this$0.finish();
                }
            }, "확인");
        } else if (obj == IdentificationEvent.RESULT_NICE_ERROR) {
            this.this$0.getSupportFragmentManager().popBackStack();
            DialogExtensions dialogExtensions = DialogExtensions.INSTANCE;
            IdentificationActivity identificationActivity = this.this$0;
            String string = identificationActivity.getString(C0016R$string.auth_fail_msg);
            Intrinsics.checkExpressionValueIsNotNull(string, "getString(R.string.auth_fail_msg)");
            dialogExtensions.showMessageDialog(identificationActivity, "", string, AnonymousClass2.INSTANCE, "확인");
        }
    }
}
