package com.kakao.usermgmt.api;

import com.kakao.auth.AuthService.AgeLimit;
import com.kakao.auth.network.AuthNetworkService;
import com.kakao.auth.network.AuthNetworkService.Factory;
import com.kakao.usermgmt.request.AgeAuthRequest;
import com.kakao.usermgmt.request.LogoutRequest;
import com.kakao.usermgmt.request.MeRequest;
import com.kakao.usermgmt.request.MeV2Request;
import com.kakao.usermgmt.request.ServiceTermsRequest;
import com.kakao.usermgmt.request.ShippingAddressesRequest;
import com.kakao.usermgmt.request.SignupRequest;
import com.kakao.usermgmt.request.UnlinkRequest;
import com.kakao.usermgmt.request.UpdateProfileRequest;
import com.kakao.usermgmt.response.AgeAuthResponse;
import com.kakao.usermgmt.response.MeResponse;
import com.kakao.usermgmt.response.MeV2Response;
import com.kakao.usermgmt.response.ServiceTermsResponse;
import com.kakao.usermgmt.response.ShippingAddressResponse;
import com.kakao.usermgmt.response.UserResponse;
import com.kakao.usermgmt.response.model.UserProfile;
import java.util.List;
import java.util.Map;

public class UserApi {
    private static UserApi instance = new UserApi(Factory.getInstance());
    private AuthNetworkService networkService;

    public Long requestSignup(Map<String, String> map) throws Exception {
        return (Long) this.networkService.request(new SignupRequest(map), UserResponse.CONVERTER);
    }

    public Long requestLogout() throws Exception {
        return (Long) this.networkService.request(new LogoutRequest(), UserResponse.CONVERTER);
    }

    public Long requestUnlink() throws Exception {
        return (Long) this.networkService.request(new UnlinkRequest(), UserResponse.CONVERTER);
    }

    public Long requestUpdateProfile(Map<String, String> map) throws Exception {
        return (Long) this.networkService.request(new UpdateProfileRequest(map), UserResponse.CONVERTER);
    }

    public UserProfile requestMe(List<String> list, Boolean bool) throws Exception {
        return (UserProfile) this.networkService.request(new MeRequest(list, bool.booleanValue()), MeResponse.CONVERTER);
    }

    public MeV2Response me(List<String> list, Boolean bool) throws Exception {
        return (MeV2Response) this.networkService.request(new MeV2Request(list, bool.booleanValue()), MeV2Response.CONVERTER);
    }

    public AgeAuthResponse requestAgeAuthInfo(AgeLimit ageLimit, List<String> list) throws Exception {
        return (AgeAuthResponse) this.networkService.request(new AgeAuthRequest(ageLimit != null ? ageLimit.getValue() : null, list), AgeAuthResponse.CONVERTER);
    }

    public ServiceTermsResponse serviceTerms() throws Exception {
        return (ServiceTermsResponse) this.networkService.request(new ServiceTermsRequest(), ServiceTermsResponse.CONVERTER);
    }

    public ShippingAddressResponse shippingAddresses(Long l, Integer num, Integer num2) throws Exception {
        return (ShippingAddressResponse) this.networkService.request(new ShippingAddressesRequest(l, num, num2), ShippingAddressResponse.CONVERTER);
    }

    public static UserApi getInstance() {
        return instance;
    }

    UserApi(AuthNetworkService authNetworkService) {
        this.networkService = authNetworkService;
    }
}
