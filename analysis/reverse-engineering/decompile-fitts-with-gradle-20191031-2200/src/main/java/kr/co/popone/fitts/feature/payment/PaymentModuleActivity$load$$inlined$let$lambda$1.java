package kr.co.popone.fitts.feature.payment;

import android.content.Context;
import android.webkit.WebView;
import android.widget.ProgressBar;
import androidx.core.app.NotificationCompat;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.base.extension.ActivityExtensionKt;
import kr.co.popone.fitts.ui.ToastExtensionKt;
import kr.co.popone.fitts.ui.ViewExtensionsKt;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public final class PaymentModuleActivity$load$$inlined$let$lambda$1 implements Callback<String> {
    final /* synthetic */ PaymentModuleActivity this$0;

    PaymentModuleActivity$load$$inlined$let$lambda$1(PaymentModuleActivity paymentModuleActivity) {
        this.this$0 = paymentModuleActivity;
    }

    public void onFailure(@NotNull Call<String> call, @NotNull Throwable th) {
        Intrinsics.checkParameterIsNotNull(call, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkParameterIsNotNull(th, "t");
        ActivityExtensionKt.handleError(this.this$0, th);
        ProgressBar progressBar = (ProgressBar) this.this$0._$_findCachedViewById(C0010R$id.progressLoading);
        Intrinsics.checkExpressionValueIsNotNull(progressBar, "progressLoading");
        ViewExtensionsKt.gone(progressBar);
    }

    public void onResponse(@NotNull Call<String> call, @NotNull Response<String> response) {
        Intrinsics.checkParameterIsNotNull(call, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkParameterIsNotNull(response, "response");
        String url = response.raw().request().url().url().toString();
        Intrinsics.checkExpressionValueIsNotNull(url, "response.raw().request().url().url().toString()");
        String str = (String) response.body();
        if (str == null) {
            ToastExtensionKt.showToast((Context) this.this$0, "죄송합니다.\n서비스가 잠시 지연되고 있습니다.\n잠시 후 다시 이용해주세요.");
        } else {
            ((WebView) this.this$0._$_findCachedViewById(C0010R$id.paymentModuleWebView)).loadDataWithBaseURL(url, str, "text/html", "UTF-8", null);
        }
    }
}
