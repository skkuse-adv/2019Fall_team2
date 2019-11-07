package com.kakao.usermgmt.request;

import android.net.Uri.Builder;
import com.kakao.auth.StringSet;
import com.kakao.auth.network.AuthorizedApiRequest;
import com.kakao.network.ServerProtocol;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.util.List;
import org.json.JSONArray;

public class AgeAuthRequest extends AuthorizedApiRequest {
    private final String ageLimit;
    private final List<String> propertyKeyList;

    public String getMethod() {
        return HttpRequest.METHOD_GET;
    }

    public AgeAuthRequest(String str, List<String> list) {
        this.ageLimit = str;
        this.propertyKeyList = list;
    }

    public Builder getUriBuilder() {
        Builder uriBuilder = super.getUriBuilder();
        uriBuilder.path(ServerProtocol.USER_AGE_AUTH);
        String str = this.ageLimit;
        if (str != null && str.length() > 0) {
            uriBuilder.appendQueryParameter(StringSet.age_limit, this.ageLimit);
        }
        List<String> list = this.propertyKeyList;
        if (list != null && list.size() > 0) {
            uriBuilder.appendQueryParameter("property_keys", new JSONArray(this.propertyKeyList).toString());
        }
        return uriBuilder;
    }
}
