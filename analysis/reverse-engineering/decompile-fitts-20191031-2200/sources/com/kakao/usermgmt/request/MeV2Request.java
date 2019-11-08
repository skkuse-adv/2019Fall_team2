package com.kakao.usermgmt.request;

import android.net.Uri.Builder;
import com.kakao.auth.network.AuthorizedApiRequest;
import com.kakao.network.ServerProtocol;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.util.List;
import org.json.JSONArray;

public class MeV2Request extends AuthorizedApiRequest {
    private final List<String> propertyKeyList;
    private final boolean secureResource;

    public String getMethod() {
        return HttpRequest.METHOD_GET;
    }

    public MeV2Request(List<String> list, boolean z) {
        this.propertyKeyList = list;
        this.secureResource = z;
    }

    public Builder getUriBuilder() {
        Builder appendQueryParameter = super.getUriBuilder().path(ServerProtocol.USER_ME_V2_PATH).appendQueryParameter("secure_resource", String.valueOf(this.secureResource));
        List<String> list = this.propertyKeyList;
        if (list != null && list.size() > 0) {
            appendQueryParameter.appendQueryParameter("property_keys", new JSONArray(this.propertyKeyList).toString());
        }
        return appendQueryParameter;
    }
}
