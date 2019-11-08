package kr.co.popone.fitts.feature.intro;

import com.facebook.GraphRequest.GraphJSONObjectCallback;
import com.facebook.GraphResponse;
import com.orhanobut.logger.Logger;
import kotlin.jvm.internal.Ref$ObjectRef;
import org.json.JSONException;
import org.json.JSONObject;

final class IntroActivity$onCreate$1$onSuccess$request$1 implements GraphJSONObjectCallback {
    final /* synthetic */ Ref$ObjectRef $email;
    final /* synthetic */ Ref$ObjectRef $profileImageUrl;

    IntroActivity$onCreate$1$onSuccess$request$1(Ref$ObjectRef ref$ObjectRef, Ref$ObjectRef ref$ObjectRef2) {
        this.$email = ref$ObjectRef;
        this.$profileImageUrl = ref$ObjectRef2;
    }

    public final void onCompleted(JSONObject jSONObject, GraphResponse graphResponse) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("facebook me data   ");
            sb.append(jSONObject);
            Logger.d(sb.toString(), new Object[0]);
            this.$email.element = jSONObject.getString("email");
            this.$profileImageUrl.element = jSONObject.getJSONObject("picture").getJSONObject("data").getString("url");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
