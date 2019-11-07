package kr.co.popone.fitts.feature.intro;

import com.orhanobut.logger.Logger;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kr.co.popone.fitts.utils.Snackbar;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.HttpException;

final class IntroActivity$requestSNSLogin$3<T> implements Consumer<Throwable> {
    final /* synthetic */ String $email;
    final /* synthetic */ String $profileImage;
    final /* synthetic */ String $provider;
    final /* synthetic */ String $token;
    final /* synthetic */ IntroActivity this$0;

    IntroActivity$requestSNSLogin$3(IntroActivity introActivity, String str, String str2, String str3, String str4) {
        this.this$0 = introActivity;
        this.$provider = str;
        this.$token = str2;
        this.$email = str3;
        this.$profileImage = str4;
    }

    public final void accept(Throwable th) {
        JSONObject jSONObject;
        Integer num = null;
        this.this$0.snsLoginRequest = null;
        String str = "죄송합니다.\n서비스가 잠시 지연되고 있습니다.\n잠시 후 다시 이용해주세요.";
        if (th instanceof HttpException) {
            try {
                ResponseBody errorBody = ((HttpException) th).response().errorBody();
                if (errorBody == null) {
                    Intrinsics.throwNpe();
                }
                byte[] bytes = errorBody.bytes();
                Intrinsics.checkExpressionValueIsNotNull(bytes, "error.response().errorBody()!!.bytes()");
                jSONObject = new JSONObject(new String(bytes, Charsets.UTF_8));
            } catch (JSONException unused) {
                jSONObject = null;
            }
            if (jSONObject != null) {
                try {
                    num = Integer.valueOf(jSONObject.getInt("code"));
                } catch (JSONException unused2) {
                }
                Logger.d(((HttpException) th).response().toString(), new Object[0]);
                Logger.d(jSONObject.toString(), new Object[0]);
                if (num != null && num.intValue() == 101) {
                    this.this$0.onEmailCheck(this.$provider, this.$token, this.$email, this.$profileImage);
                } else {
                    Snackbar.Companion.showMessage(this.this$0, str);
                }
            } else {
                Snackbar.Companion.showMessage(this.this$0, str);
            }
        } else {
            Snackbar.Companion.showMessage(this.this$0, str);
        }
    }
}
