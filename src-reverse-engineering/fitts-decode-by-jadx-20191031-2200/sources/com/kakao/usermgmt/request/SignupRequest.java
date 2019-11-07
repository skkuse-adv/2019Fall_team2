package com.kakao.usermgmt.request;

import android.net.Uri.Builder;
import com.kakao.auth.network.AuthorizedApiRequest;
import com.kakao.network.ServerProtocol;
import com.kakao.usermgmt.StringSet;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class SignupRequest extends AuthorizedApiRequest {
    private final JSONObject properties;

    public String getMethod() {
        return HttpRequest.METHOD_POST;
    }

    public SignupRequest(Map<String, String> map) {
        this.properties = map != null ? new JSONObject(map) : null;
    }

    public Builder getUriBuilder() {
        return super.getUriBuilder().path(ServerProtocol.USER_SIGNUP_PATH);
    }

    public Map<String, String> getParams() {
        HashMap hashMap = new HashMap();
        JSONObject jSONObject = this.properties;
        if (jSONObject != null) {
            hashMap.put(StringSet.properties, jSONObject.toString());
        }
        return hashMap;
    }
}
