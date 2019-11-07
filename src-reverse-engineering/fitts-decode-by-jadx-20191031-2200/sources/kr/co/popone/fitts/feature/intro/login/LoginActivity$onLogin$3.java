package kr.co.popone.fitts.feature.intro.login;

import com.orhanobut.logger.Logger;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okhttp3.ResponseBody;
import org.json.JSONObject;
import retrofit2.HttpException;

final class LoginActivity$onLogin$3<T> implements Consumer<Throwable> {
    final /* synthetic */ LoginActivity this$0;

    LoginActivity$onLogin$3(LoginActivity loginActivity) {
        this.this$0 = loginActivity;
    }

    public final void accept(Throwable th) {
        this.this$0.loginRequest = null;
        Logger.e(th.toString(), new Object[0]);
        if (!(th instanceof HttpException)) {
            th = null;
        }
        HttpException httpException = (HttpException) th;
        if (httpException != null) {
            ResponseBody errorBody = httpException.response().errorBody();
            if (errorBody == null) {
                Intrinsics.throwNpe();
            }
            byte[] bytes = errorBody.bytes();
            Intrinsics.checkExpressionValueIsNotNull(bytes, "error.response().errorBody()!!.bytes()");
            JSONObject jSONObject = new JSONObject(new String(bytes, Charsets.UTF_8));
            String string = jSONObject.getString(SettingsJsonConstants.PROMPT_MESSAGE_KEY);
            Logger.d(httpException.response().toString(), new Object[0]);
            Logger.d(jSONObject.toString(), new Object[0]);
            if (string != null) {
                this.this$0.showNoUserWarning(string);
            }
        }
    }
}
