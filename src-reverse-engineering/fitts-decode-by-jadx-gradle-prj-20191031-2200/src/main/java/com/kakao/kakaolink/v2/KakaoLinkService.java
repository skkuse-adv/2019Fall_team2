package com.kakao.kakaolink.v2;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.browser.customtabs.CustomTabsIntent.Builder;
import androidx.browser.customtabs.CustomTabsService;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import com.kakao.kakaolink.R;
import com.kakao.kakaolink.v2.network.KakaoLinkCore;
import com.kakao.kakaolink.v2.network.KakaoLinkCore.Factory;
import com.kakao.kakaolink.v2.network.KakaoLinkImageService;
import com.kakao.message.template.TemplateParams;
import com.kakao.network.ErrorResult;
import com.kakao.network.IRequest;
import com.kakao.network.NetworkService;
import com.kakao.network.callback.ResponseCallback;
import com.kakao.network.response.ResponseStringConverter;
import com.kakao.network.storage.ImageDeleteResponse;
import com.kakao.network.storage.ImageUploadResponse;
import com.kakao.util.exception.KakaoException;
import com.kakao.util.exception.KakaoException.ErrorType;
import com.kakao.util.helper.AbstractFuture;
import com.kakao.util.helper.log.Logger;
import java.io.File;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import org.json.JSONException;
import org.json.JSONObject;

public class KakaoLinkService {
    private static final ResponseStringConverter<JSONObject> JSON_OBJECT_CONVERTER = new ResponseStringConverter<JSONObject>() {
        public JSONObject convert(String str) {
            try {
                return new JSONObject(str);
            } catch (JSONException e) {
                Logger.e(e.toString());
                return null;
            }
        }
    };
    private static KakaoLinkService instance = new KakaoLinkService(Factory.getInstance(), KakaoLinkImageService.Factory.getInstance(), NetworkService.Factory.getInstance());
    private List<String> chromePackageNames = Arrays.asList(new String[]{"com.android.chrome", "com.chrome.beta", "com.chrome.dev"});
    /* access modifiers changed from: private */
    public KakaoLinkImageService imageService;
    /* access modifiers changed from: private */
    public KakaoLinkCore linkCore;
    private NetworkService networkService;

    KakaoLinkService(KakaoLinkCore kakaoLinkCore, KakaoLinkImageService kakaoLinkImageService, NetworkService networkService2) {
        this.linkCore = kakaoLinkCore;
        this.imageService = kakaoLinkImageService;
        this.networkService = networkService2;
    }

    public static KakaoLinkService getInstance() {
        return instance;
    }

    public boolean isKakaoLinkV2Available(Context context) {
        return this.linkCore.isAvailable(context);
    }

    public void sendCustom(final Context context, final String str, final Map<String, String> map, ResponseCallback<KakaoLinkResponse> responseCallback) {
        sendKakaoLinkRequest(context, new AbstractFuture<IRequest>() {
            public IRequest get() {
                return KakaoLinkService.this.linkCore.customTemplateRequest(context, null, str, map);
            }
        }, new AbstractFuture<Uri>() {
            public Uri get() {
                return KakaoLinkService.this.linkCore.sharerUri(context, str, map, null);
            }
        }, null, responseCallback);
    }

    public void sendCustom(final Context context, final String str, final Map<String, String> map, Map<String, String> map2, ResponseCallback<KakaoLinkResponse> responseCallback) {
        AnonymousClass3 r2 = new AbstractFuture<IRequest>() {
            public IRequest get() {
                return KakaoLinkService.this.linkCore.customTemplateRequest(context, null, str, map);
            }
        };
        final Context context2 = context;
        final String str2 = str;
        final Map<String, String> map3 = map;
        final Map<String, String> map4 = map2;
        AnonymousClass4 r3 = new AbstractFuture<Uri>() {
            public Uri get() {
                return KakaoLinkService.this.linkCore.sharerUri(context2, str2, map3, map4);
            }
        };
        sendKakaoLinkRequest(context, r2, r3, map2, responseCallback);
    }

    public void sendDefault(final Context context, final TemplateParams templateParams, ResponseCallback<KakaoLinkResponse> responseCallback) {
        sendKakaoLinkRequest(context, new AbstractFuture<IRequest>() {
            public IRequest get() {
                return KakaoLinkService.this.linkCore.defaultTemplateRequest(context, null, templateParams);
            }
        }, new AbstractFuture<Uri>() {
            public Uri get() {
                return KakaoLinkService.this.linkCore.sharerUri(context, templateParams, null);
            }
        }, null, responseCallback);
    }

    public void sendDefault(final Context context, final TemplateParams templateParams, final Map<String, String> map, ResponseCallback<KakaoLinkResponse> responseCallback) {
        sendKakaoLinkRequest(context, new AbstractFuture<IRequest>() {
            public IRequest get() {
                return KakaoLinkService.this.linkCore.defaultTemplateRequest(context, null, templateParams);
            }
        }, new AbstractFuture<Uri>() {
            public Uri get() {
                return KakaoLinkService.this.linkCore.sharerUri(context, templateParams, map);
            }
        }, map, responseCallback);
    }

    public void sendScrap(Context context, String str, String str2, Map<String, String> map, ResponseCallback<KakaoLinkResponse> responseCallback) {
        final Context context2 = context;
        final String str3 = str;
        final String str4 = str2;
        final Map<String, String> map2 = map;
        AnonymousClass9 r0 = new AbstractFuture<IRequest>() {
            public IRequest get() {
                return KakaoLinkService.this.linkCore.scrapTemplateRequest(context2, null, str3, str4, map2);
            }
        };
        AnonymousClass10 r02 = new AbstractFuture<Uri>() {
            public Uri get() {
                return KakaoLinkService.this.linkCore.sharerUri(context2, str3, str4, map2, null);
            }
        };
        sendKakaoLinkRequest(context, r0, r02, null, responseCallback);
    }

    public void sendScrap(Context context, String str, String str2, Map<String, String> map, Map<String, String> map2, ResponseCallback<KakaoLinkResponse> responseCallback) {
        final Context context2 = context;
        final String str3 = str;
        final String str4 = str2;
        final Map<String, String> map3 = map;
        AnonymousClass11 r0 = new AbstractFuture<IRequest>() {
            public IRequest get() {
                return KakaoLinkService.this.linkCore.scrapTemplateRequest(context2, null, str3, str4, map3);
            }
        };
        final Context context3 = context;
        final String str5 = str;
        final String str6 = str2;
        final Map<String, String> map4 = map;
        final Map<String, String> map5 = map2;
        AnonymousClass12 r7 = new AbstractFuture<Uri>() {
            public Uri get() {
                return KakaoLinkService.this.linkCore.sharerUri(context3, str5, str6, map4, map5);
            }
        };
        sendKakaoLinkRequest(context, r0, r7, map2, responseCallback);
    }

    public void sendScrap(Context context, String str, ResponseCallback<KakaoLinkResponse> responseCallback) {
        sendScrap(context, str, null, responseCallback);
    }

    public void sendScrap(Context context, String str, Map<String, String> map, ResponseCallback<KakaoLinkResponse> responseCallback) {
        sendScrap(context, str, null, null, map, responseCallback);
    }

    public void uploadImage(final Context context, final Boolean bool, final File file, ResponseCallback<ImageUploadResponse> responseCallback) {
        sendLinkImageRequest(new AbstractFuture<IRequest>() {
            public IRequest get() {
                return KakaoLinkService.this.imageService.imageUploadRequest(context, file, bool.booleanValue());
            }
        }, ImageUploadResponse.CONVERTER, responseCallback);
    }

    public void scrapImage(final Context context, final Boolean bool, final String str, ResponseCallback<ImageUploadResponse> responseCallback) {
        sendLinkImageRequest(new AbstractFuture<IRequest>() {
            public IRequest get() {
                return KakaoLinkService.this.imageService.imageScrapRequest(context, str, bool.booleanValue());
            }
        }, ImageUploadResponse.CONVERTER, responseCallback);
    }

    public void deleteImageWithUrl(final Context context, final String str, ResponseCallback<ImageDeleteResponse> responseCallback) {
        sendLinkImageRequest(new AbstractFuture<IRequest>() {
            public IRequest get() {
                return KakaoLinkService.this.imageService.imageDeleteRequestWithUrl(context, str);
            }
        }, ImageDeleteResponse.CONVERTER, responseCallback);
    }

    public void deleteImageWithToken(final Context context, final String str, ResponseCallback<ImageDeleteResponse> responseCallback) {
        sendLinkImageRequest(new AbstractFuture<IRequest>() {
            public IRequest get() {
                return KakaoLinkService.this.imageService.imageDeleteRequestWithToken(context, str);
            }
        }, ImageDeleteResponse.CONVERTER, responseCallback);
    }

    private void sendKakaoLinkRequest(Context context, Future<IRequest> future, Future<Uri> future2, Map<String, String> map, ResponseCallback<KakaoLinkResponse> responseCallback) {
        try {
            NetworkService networkService2 = this.networkService;
            IRequest iRequest = (IRequest) future.get();
            ResponseStringConverter<JSONObject> responseStringConverter = JSON_OBJECT_CONVERTER;
            final ResponseCallback<KakaoLinkResponse> responseCallback2 = responseCallback;
            final Context context2 = context;
            final Map<String, String> map2 = map;
            final Future<Uri> future3 = future2;
            AnonymousClass17 r2 = new ResponseCallback<JSONObject>() {
                public void onFailure(ErrorResult errorResult) {
                    responseCallback2.onFailure(errorResult);
                }

                public void onSuccess(JSONObject jSONObject) {
                    try {
                        if (KakaoLinkService.this.isKakaoLinkV2Available(context2)) {
                            context2.startActivity(KakaoLinkService.this.linkCore.kakaoLinkIntent(context2, null, jSONObject, map2));
                        } else {
                            KakaoLinkService.this.openUrlWithCustomTab(context2, (Uri) future3.get());
                        }
                        if (responseCallback2 != null) {
                            responseCallback2.onSuccess(new KakaoLinkResponse(jSONObject));
                        }
                    } catch (Exception e) {
                        ResponseCallback responseCallback = responseCallback2;
                        if (responseCallback != null) {
                            responseCallback.onFailure(new ErrorResult(e));
                        }
                    }
                }

                public void onDidStart() {
                    super.onDidStart();
                    responseCallback2.onDidStart();
                }

                public void onDidEnd() {
                    super.onDidEnd();
                    responseCallback2.onDidEnd();
                }
            };
            networkService2.request(iRequest, responseStringConverter, (ResponseCallback<T>) r2);
        } catch (Exception e) {
            if (responseCallback != null) {
                responseCallback.onFailure(new ErrorResult(e));
            }
        }
    }

    private <T> void sendLinkImageRequest(Future<IRequest> future, ResponseStringConverter<T> responseStringConverter, ResponseCallback<T> responseCallback) {
        try {
            this.networkService.request((IRequest) future.get(), responseStringConverter, responseCallback);
        } catch (Exception e) {
            if (responseCallback != null) {
                responseCallback.onFailure(new ErrorResult(e));
            }
        }
    }

    private ErrorResult getKakaoTalkNotInstalledErrorResult(Context context) {
        return new ErrorResult((Exception) new KakaoException(ErrorType.KAKAOTALK_NOT_INSTALLED, context.getString(R.string.com_kakao_alert_install_kakaotalk)));
    }

    public Intent getKakaoTalkInstallIntent(Context context) {
        return this.linkCore.kakaoTalkMarketIntent(context);
    }

    /* access modifiers changed from: 0000 */
    public void openUrlWithCustomTab(final Context context, final Uri uri) throws KakaoException {
        final String resolveCustomTabsPackageName = resolveCustomTabsPackageName(context, uri);
        if (resolveCustomTabsPackageName != null) {
            CustomTabsClient.bindCustomTabsService(context, resolveCustomTabsPackageName, new CustomTabsServiceConnection() {
                public void onServiceDisconnected(ComponentName componentName) {
                }

                public void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
                    Builder builder = new Builder();
                    builder.enableUrlBarHiding();
                    builder.setShowTitle(true);
                    CustomTabsIntent build = builder.build();
                    build.intent.setData(uri);
                    build.intent.setPackage(resolveCustomTabsPackageName);
                    context.startActivity(build.intent);
                }
            });
            return;
        }
        throw new KakaoException(ErrorType.KAKAOTALK_NOT_INSTALLED, context.getString(R.string.com_kakao_alert_install_kakaotalk));
    }

    /* access modifiers changed from: 0000 */
    public String resolveCustomTabsPackageName(Context context, Uri uri) {
        ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(new Intent("android.intent.action.VIEW", uri), 65536);
        Intent intent = new Intent();
        intent.setAction(CustomTabsService.ACTION_CUSTOM_TABS_CONNECTION);
        Iterator it = context.getPackageManager().queryIntentServices(intent, 0).iterator();
        String str = null;
        String str2 = null;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ResolveInfo resolveInfo = (ResolveInfo) it.next();
            if (str2 == null && isPackageNameChrome(resolveInfo.serviceInfo.packageName)) {
                str2 = resolveInfo.serviceInfo.packageName;
            }
            if (resolveInfo.serviceInfo.packageName.equals(resolveActivity.activityInfo.packageName)) {
                str = resolveActivity.activityInfo.packageName;
                break;
            }
        }
        if (str == null && str2 != null) {
            str = str2;
        }
        Logger.d("selected browser for kakaolink is %s", str);
        return str;
    }

    private boolean isPackageNameChrome(String str) {
        return this.chromePackageNames.contains(str);
    }
}
