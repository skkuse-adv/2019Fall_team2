package com.kakao.usermgmt;

import com.kakao.auth.ApiResponseCallback;
import com.kakao.auth.AuthService.AgeLimit;
import com.kakao.auth.ISession;
import com.kakao.auth.Session;
import com.kakao.network.callback.ResponseCallback;
import com.kakao.network.tasks.ITaskQueue;
import com.kakao.network.tasks.KakaoResultTask;
import com.kakao.network.tasks.KakaoTaskQueue;
import com.kakao.usermgmt.api.UserApi;
import com.kakao.usermgmt.callback.LogoutResponseCallback;
import com.kakao.usermgmt.callback.MeResponseCallback;
import com.kakao.usermgmt.callback.MeV2ResponseCallback;
import com.kakao.usermgmt.callback.UnLinkResponseCallback;
import com.kakao.usermgmt.response.AgeAuthResponse;
import com.kakao.usermgmt.response.MeV2Response;
import com.kakao.usermgmt.response.ServiceTermsResponse;
import com.kakao.usermgmt.response.ShippingAddressResponse;
import com.kakao.usermgmt.response.model.UserProfile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

public class UserManagement {
    private static UserManagement instance = new UserManagement(UserApi.getInstance(), KakaoTaskQueue.getInstance(), Session.getCurrentSession());
    /* access modifiers changed from: private */
    public UserApi api;
    /* access modifiers changed from: private */
    public ISession session;
    private ITaskQueue taskQueue;

    public enum AgeAuthProperty {
        ACCOUNT_CI("account_ci");
        
        private final String value;

        private AgeAuthProperty(String str) {
            this.value = str;
        }

        public String getValue() {
            return this.value;
        }
    }

    UserManagement(UserApi userApi, ITaskQueue iTaskQueue, ISession iSession) {
        this.api = userApi;
        this.taskQueue = iTaskQueue;
        this.session = iSession;
    }

    public static UserManagement getInstance() {
        return instance;
    }

    public void requestSignup(ApiResponseCallback<Long> apiResponseCallback, final Map<String, String> map) {
        this.taskQueue.addTask(new KakaoResultTask<Long>(apiResponseCallback) {
            public Long call() throws Exception {
                return UserManagement.this.api.requestSignup(map);
            }
        });
    }

    public void requestLogout(LogoutResponseCallback logoutResponseCallback) {
        this.taskQueue.addTask(new KakaoResultTask<Long>(logoutResponseCallback) {
            public Long call() throws Exception {
                return UserManagement.this.api.requestLogout();
            }

            public void onDidEnd() {
                super.onDidEnd();
                UserManagement.this.session.close();
            }
        });
    }

    public void requestUnlink(UnLinkResponseCallback unLinkResponseCallback) {
        this.taskQueue.addTask(new KakaoResultTask<Long>(unLinkResponseCallback) {
            public Long call() throws Exception {
                return UserManagement.this.api.requestUnlink();
            }

            public void onDidEnd() {
                super.onDidEnd();
                UserManagement.this.session.close();
            }
        });
    }

    public void requestUpdateProfile(ApiResponseCallback<Long> apiResponseCallback, String str, String str2, String str3, Map<String, String> map) {
        Map<String, String> hashMap = map == null ? new HashMap<>() : map;
        map.put("nickname", str);
        map.put("thumbnail_image", str2);
        map.put("profile_image", str3);
        requestUpdateProfile(apiResponseCallback, hashMap);
    }

    public void requestUpdateProfile(ApiResponseCallback<Long> apiResponseCallback, final Map<String, String> map) {
        this.taskQueue.addTask(new KakaoResultTask<Long>(apiResponseCallback) {
            public Long call() throws Exception {
                return UserManagement.this.api.requestUpdateProfile(map);
            }
        });
    }

    @Deprecated
    public void requestMe(MeResponseCallback meResponseCallback) {
        requestMe(meResponseCallback, null, false);
    }

    @Deprecated
    public void requestMe(MeResponseCallback meResponseCallback, final List<String> list, final boolean z) {
        this.taskQueue.addTask(new KakaoResultTask<UserProfile>(meResponseCallback) {
            public UserProfile call() throws Exception {
                return UserManagement.this.api.requestMe(list, Boolean.valueOf(z));
            }
        });
    }

    public Future<MeV2Response> me(MeV2ResponseCallback meV2ResponseCallback) {
        return this.taskQueue.addTask(new KakaoResultTask<MeV2Response>(meV2ResponseCallback) {
            public MeV2Response call() throws Exception {
                return UserManagement.this.api.me(null, Boolean.valueOf(true));
            }
        });
    }

    public Future<MeV2Response> me(final List<String> list, MeV2ResponseCallback meV2ResponseCallback) {
        return this.taskQueue.addTask(new KakaoResultTask<MeV2Response>(meV2ResponseCallback) {
            public MeV2Response call() throws Exception {
                return UserManagement.this.api.me(list, Boolean.valueOf(true));
            }
        });
    }

    public void requestAgeAuthInfo(ResponseCallback<AgeAuthResponse> responseCallback, final AgeLimit ageLimit, List<AgeAuthProperty> list) {
        final ArrayList arrayList;
        if (list == null || list.size() <= 0) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            for (AgeAuthProperty value : list) {
                arrayList.add(value.getValue());
            }
        }
        this.taskQueue.addTask(new KakaoResultTask<AgeAuthResponse>(responseCallback) {
            public AgeAuthResponse call() throws Exception {
                return UserManagement.this.api.requestAgeAuthInfo(ageLimit, arrayList);
            }
        });
    }

    public Future<ServiceTermsResponse> serviceTerms(ApiResponseCallback<ServiceTermsResponse> apiResponseCallback) {
        return this.taskQueue.addTask(new KakaoResultTask<ServiceTermsResponse>(apiResponseCallback) {
            public ServiceTermsResponse call() throws Exception {
                return UserManagement.this.api.serviceTerms();
            }
        });
    }

    public Future<ShippingAddressResponse> shippingAddresses(ApiResponseCallback<ShippingAddressResponse> apiResponseCallback) {
        return this.taskQueue.addTask(new KakaoResultTask<ShippingAddressResponse>(apiResponseCallback) {
            public ShippingAddressResponse call() throws Exception {
                return UserManagement.this.api.shippingAddresses(null, null, null);
            }
        });
    }

    public Future<ShippingAddressResponse> shippingAddresses(final Long l, ApiResponseCallback<ShippingAddressResponse> apiResponseCallback) {
        return this.taskQueue.addTask(new KakaoResultTask<ShippingAddressResponse>(apiResponseCallback) {
            public ShippingAddressResponse call() throws Exception {
                return UserManagement.this.api.shippingAddresses(l, null, null);
            }
        });
    }

    public Future<ShippingAddressResponse> shippingAddresses(final Integer num, final Integer num2, ApiResponseCallback<ShippingAddressResponse> apiResponseCallback) {
        return this.taskQueue.addTask(new KakaoResultTask<ShippingAddressResponse>(apiResponseCallback) {
            public ShippingAddressResponse call() throws Exception {
                return UserManagement.this.api.shippingAddresses(null, num, num2);
            }
        });
    }
}
