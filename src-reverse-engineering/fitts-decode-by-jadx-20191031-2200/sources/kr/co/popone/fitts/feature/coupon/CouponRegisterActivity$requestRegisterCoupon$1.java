package kr.co.popone.fitts.feature.coupon;

import android.content.Intent;
import android.widget.TextView;
import com.orhanobut.logger.Logger;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import io.reactivex.functions.BiConsumer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.feature.intro.IntroActivity;
import kr.co.popone.fitts.model.coupon.CouponAPI.CouponRegisterResult;
import kr.co.popone.fitts.utils.Snackbar;
import okhttp3.ResponseBody;
import org.json.JSONObject;
import retrofit2.HttpException;

final class CouponRegisterActivity$requestRegisterCoupon$1<T1, T2> implements BiConsumer<CouponRegisterResult, Throwable> {
    final /* synthetic */ CouponRegisterActivity this$0;

    CouponRegisterActivity$requestRegisterCoupon$1(CouponRegisterActivity couponRegisterActivity) {
        this.this$0 = couponRegisterActivity;
    }

    public final void accept(CouponRegisterResult couponRegisterResult, Throwable th) {
        this.this$0.couponRegisterRequest = null;
        this.this$0.loadingSubject.onNext(Boolean.valueOf(false));
        if (couponRegisterResult != null) {
            this.this$0.showMessageDialog();
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("error occured ");
        sb.append(th);
        Logger.d(sb.toString(), new Object[0]);
        if (th instanceof HttpException) {
            HttpException httpException = (HttpException) th;
            if (httpException.code() == 401) {
                Intent intent = new Intent(this.this$0, IntroActivity.class);
                intent.addFlags(32768);
                intent.addFlags(268435456);
                this.this$0.startActivity(intent);
                return;
            }
            String str = "errorMessageTextView";
            if (httpException.code() == 404 || httpException.code() == 409) {
                ResponseBody errorBody = httpException.response().errorBody();
                if (errorBody == null) {
                    Intrinsics.throwNpe();
                }
                byte[] bytes = errorBody.bytes();
                Intrinsics.checkExpressionValueIsNotNull(bytes, "throwable.response().errorBody()!!.bytes()");
                JSONObject jSONObject = new JSONObject(new String(bytes, Charsets.UTF_8));
                TextView textView = (TextView) this.this$0._$_findCachedViewById(C0010R$id.errorMessageTextView);
                Intrinsics.checkExpressionValueIsNotNull(textView, str);
                textView.setText(jSONObject.getString(SettingsJsonConstants.PROMPT_MESSAGE_KEY));
                return;
            }
            TextView textView2 = (TextView) this.this$0._$_findCachedViewById(C0010R$id.errorMessageTextView);
            Intrinsics.checkExpressionValueIsNotNull(textView2, str);
            textView2.setText("유효하지 않은 쿠폰 번호에요.");
            return;
        }
        Snackbar.Companion.showMessage(this.this$0, "죄송합니다.\n서비스가 잠시 지연되고 있습니다.\n잠시 후 다시 이용해주세요.");
    }
}
