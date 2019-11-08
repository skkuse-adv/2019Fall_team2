package com.kakao.common;

import android.content.Context;
import com.kakao.util.exception.KakaoException;
import com.kakao.util.helper.CommonProtocol;
import com.kakao.util.helper.SystemInfo;
import com.kakao.util.helper.Utility;
import org.json.JSONException;
import org.json.JSONObject;

public interface IConfiguration {

    public static class Factory {
        static IConfiguration createConfiguration(Context context) throws KakaoException {
            SystemInfo.initialize(context);
            String keyHash = Utility.getKeyHash(context);
            String kAHeader = SystemInfo.getKAHeader();
            String valueOf = String.valueOf(Utility.getAppVersion(context));
            String packageName = context.getPackageName();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("appPkg", context.getPackageName());
                jSONObject.put(CommonProtocol.KA_HEADER_KEY, kAHeader);
                jSONObject.put("keyHash", keyHash);
                RequestConfiguration requestConfiguration = new RequestConfiguration(keyHash, kAHeader, valueOf, packageName, jSONObject);
                return requestConfiguration;
            } catch (JSONException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("JSON parsing error. Malformed parameters were provided. Detailed error message: ");
                sb.append(e.toString());
                throw new IllegalArgumentException(sb.toString());
            }
        }
    }

    String getAppVer();

    @Deprecated
    String getExtras();

    JSONObject getExtrasJson();

    String getKAHeader();

    String getKeyHash();

    String getPackageName();
}
