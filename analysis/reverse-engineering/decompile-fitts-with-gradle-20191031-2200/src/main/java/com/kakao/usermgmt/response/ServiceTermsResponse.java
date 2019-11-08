package com.kakao.usermgmt.response;

import com.kakao.network.response.JSONObjectResponse;
import com.kakao.network.response.ResponseBody;
import com.kakao.network.response.ResponseBody.ResponseBodyException;
import com.kakao.network.response.ResponseStringConverter;
import com.kakao.usermgmt.StringSet;
import com.kakao.usermgmt.response.model.ServiceTerms;
import java.util.List;

public class ServiceTermsResponse extends JSONObjectResponse {
    public static final ResponseStringConverter<ServiceTermsResponse> CONVERTER = new ResponseStringConverter<ServiceTermsResponse>() {
        public ServiceTermsResponse convert(String str) throws ResponseBodyException {
            return new ServiceTermsResponse(str);
        }
    };
    private final List<ServiceTerms> allowedTerms;
    private final Long userId;

    private ServiceTermsResponse(String str) {
        super(str);
        String str2 = "user_id";
        List<ServiceTerms> list = null;
        this.userId = getBody().has(str2) ? Long.valueOf(getBody().getLong(str2)) : null;
        ResponseBody body = getBody();
        String str3 = StringSet.allowed_service_terms;
        if (body.has(str3)) {
            list = ServiceTerms.CONVERTER.convertList(getBody().getJSONArray(str3));
        }
        this.allowedTerms = list;
    }

    public Long getUserId() {
        return this.userId;
    }

    public List<ServiceTerms> getAllowedTerms() {
        return this.allowedTerms;
    }
}
