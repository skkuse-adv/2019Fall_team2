package com.facebook.internal;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookSdk;
import com.facebook.login.DefaultAudience;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

public final class NativeProtocol {
    public static final String ACTION_APPINVITE_DIALOG = "com.facebook.platform.action.request.APPINVITES_DIALOG";
    public static final String ACTION_CAMERA_EFFECT = "com.facebook.platform.action.request.CAMERA_EFFECT";
    public static final String ACTION_FEED_DIALOG = "com.facebook.platform.action.request.FEED_DIALOG";
    public static final String ACTION_LIKE_DIALOG = "com.facebook.platform.action.request.LIKE_DIALOG";
    public static final String ACTION_MESSAGE_DIALOG = "com.facebook.platform.action.request.MESSAGE_DIALOG";
    public static final String ACTION_OGACTIONPUBLISH_DIALOG = "com.facebook.platform.action.request.OGACTIONPUBLISH_DIALOG";
    public static final String ACTION_OGMESSAGEPUBLISH_DIALOG = "com.facebook.platform.action.request.OGMESSAGEPUBLISH_DIALOG";
    public static final String ACTION_SHARE_STORY = "com.facebook.platform.action.request.SHARE_STORY";
    public static final String AUDIENCE_EVERYONE = "everyone";
    public static final String AUDIENCE_FRIENDS = "friends";
    public static final String AUDIENCE_ME = "only_me";
    public static final String BRIDGE_ARG_ACTION_ID_STRING = "action_id";
    public static final String BRIDGE_ARG_APP_NAME_STRING = "app_name";
    public static final String BRIDGE_ARG_ERROR_BUNDLE = "error";
    public static final String BRIDGE_ARG_ERROR_CODE = "error_code";
    public static final String BRIDGE_ARG_ERROR_DESCRIPTION = "error_description";
    public static final String BRIDGE_ARG_ERROR_JSON = "error_json";
    public static final String BRIDGE_ARG_ERROR_SUBCODE = "error_subcode";
    public static final String BRIDGE_ARG_ERROR_TYPE = "error_type";
    public static final String ERROR_APPLICATION_ERROR = "ApplicationError";
    public static final String ERROR_NETWORK_ERROR = "NetworkError";
    public static final String ERROR_PERMISSION_DENIED = "PermissionDenied";
    public static final String ERROR_PROTOCOL_ERROR = "ProtocolError";
    public static final String ERROR_SERVICE_DISABLED = "ServiceDisabled";
    public static final String ERROR_UNKNOWN_ERROR = "UnknownError";
    public static final String ERROR_USER_CANCELED = "UserCanceled";
    public static final String EXTRA_ACCESS_TOKEN = "com.facebook.platform.extra.ACCESS_TOKEN";
    public static final String EXTRA_APPLICATION_ID = "com.facebook.platform.extra.APPLICATION_ID";
    public static final String EXTRA_APPLICATION_NAME = "com.facebook.platform.extra.APPLICATION_NAME";
    public static final String EXTRA_ARGS_PROFILE = "com.facebook.platform.extra.PROFILE";
    public static final String EXTRA_ARGS_PROFILE_FIRST_NAME = "com.facebook.platform.extra.PROFILE_FIRST_NAME";
    public static final String EXTRA_ARGS_PROFILE_LAST_NAME = "com.facebook.platform.extra.PROFILE_LAST_NAME";
    public static final String EXTRA_ARGS_PROFILE_LINK = "com.facebook.platform.extra.PROFILE_LINK";
    public static final String EXTRA_ARGS_PROFILE_MIDDLE_NAME = "com.facebook.platform.extra.PROFILE_MIDDLE_NAME";
    public static final String EXTRA_ARGS_PROFILE_NAME = "com.facebook.platform.extra.PROFILE_NAME";
    public static final String EXTRA_ARGS_PROFILE_USER_ID = "com.facebook.platform.extra.PROFILE_USER_ID";
    public static final String EXTRA_DATA_ACCESS_EXPIRATION_TIME = "com.facebook.platform.extra.EXTRA_DATA_ACCESS_EXPIRATION_TIME";
    public static final String EXTRA_DIALOG_COMPLETE_KEY = "com.facebook.platform.extra.DID_COMPLETE";
    public static final String EXTRA_DIALOG_COMPLETION_GESTURE_KEY = "com.facebook.platform.extra.COMPLETION_GESTURE";
    public static final String EXTRA_EXPIRES_SECONDS_SINCE_EPOCH = "com.facebook.platform.extra.EXPIRES_SECONDS_SINCE_EPOCH";
    public static final String EXTRA_GET_INSTALL_DATA_PACKAGE = "com.facebook.platform.extra.INSTALLDATA_PACKAGE";
    public static final String EXTRA_GRAPH_API_VERSION = "com.facebook.platform.extra.GRAPH_API_VERSION";
    public static final String EXTRA_LOGGER_REF = "com.facebook.platform.extra.LOGGER_REF";
    public static final String EXTRA_PERMISSIONS = "com.facebook.platform.extra.PERMISSIONS";
    public static final String EXTRA_PROTOCOL_ACTION = "com.facebook.platform.protocol.PROTOCOL_ACTION";
    public static final String EXTRA_PROTOCOL_BRIDGE_ARGS = "com.facebook.platform.protocol.BRIDGE_ARGS";
    public static final String EXTRA_PROTOCOL_CALL_ID = "com.facebook.platform.protocol.CALL_ID";
    public static final String EXTRA_PROTOCOL_METHOD_ARGS = "com.facebook.platform.protocol.METHOD_ARGS";
    public static final String EXTRA_PROTOCOL_METHOD_RESULTS = "com.facebook.platform.protocol.RESULT_ARGS";
    public static final String EXTRA_PROTOCOL_VERSION = "com.facebook.platform.protocol.PROTOCOL_VERSION";
    public static final String EXTRA_TOAST_DURATION_MS = "com.facebook.platform.extra.EXTRA_TOAST_DURATION_MS";
    public static final String EXTRA_USER_ID = "com.facebook.platform.extra.USER_ID";
    public static final String FACEBOOK_PROXY_AUTH_APP_ID_KEY = "client_id";
    public static final String FACEBOOK_PROXY_AUTH_E2E_KEY = "e2e";
    public static final String FACEBOOK_PROXY_AUTH_PERMISSIONS_KEY = "scope";
    public static final String FACEBOOK_SDK_VERSION_KEY = "facebook_sdk_version";
    public static final String IMAGE_URL_KEY = "url";
    public static final String IMAGE_USER_GENERATED_KEY = "user_generated";
    private static final List<Integer> KNOWN_PROTOCOL_VERSIONS = Arrays.asList(new Integer[]{Integer.valueOf(PROTOCOL_VERSION_20170417), Integer.valueOf(PROTOCOL_VERSION_20160327), Integer.valueOf(PROTOCOL_VERSION_20141218), Integer.valueOf(PROTOCOL_VERSION_20141107), Integer.valueOf(PROTOCOL_VERSION_20141028), Integer.valueOf(PROTOCOL_VERSION_20141001), Integer.valueOf(PROTOCOL_VERSION_20140701), Integer.valueOf(PROTOCOL_VERSION_20140324), Integer.valueOf(PROTOCOL_VERSION_20140204), Integer.valueOf(PROTOCOL_VERSION_20131107), Integer.valueOf(PROTOCOL_VERSION_20130618), Integer.valueOf(PROTOCOL_VERSION_20130502), Integer.valueOf(PROTOCOL_VERSION_20121101)});
    public static final int MESSAGE_GET_ACCESS_TOKEN_REPLY = 65537;
    public static final int MESSAGE_GET_ACCESS_TOKEN_REQUEST = 65536;
    public static final int MESSAGE_GET_AK_SEAMLESS_TOKEN_REPLY = 65545;
    public static final int MESSAGE_GET_AK_SEAMLESS_TOKEN_REQUEST = 65544;
    public static final int MESSAGE_GET_INSTALL_DATA_REPLY = 65541;
    public static final int MESSAGE_GET_INSTALL_DATA_REQUEST = 65540;
    public static final int MESSAGE_GET_LIKE_STATUS_REPLY = 65543;
    public static final int MESSAGE_GET_LIKE_STATUS_REQUEST = 65542;
    public static final int MESSAGE_GET_LOGIN_STATUS_REPLY = 65547;
    public static final int MESSAGE_GET_LOGIN_STATUS_REQUEST = 65546;
    public static final int NO_PROTOCOL_AVAILABLE = -1;
    public static final String OPEN_GRAPH_CREATE_OBJECT_KEY = "fbsdk:create_object";
    public static final int PROTOCOL_VERSION_20121101 = 20121101;
    public static final int PROTOCOL_VERSION_20130502 = 20130502;
    public static final int PROTOCOL_VERSION_20130618 = 20130618;
    public static final int PROTOCOL_VERSION_20131107 = 20131107;
    public static final int PROTOCOL_VERSION_20140204 = 20140204;
    public static final int PROTOCOL_VERSION_20140324 = 20140324;
    public static final int PROTOCOL_VERSION_20140701 = 20140701;
    public static final int PROTOCOL_VERSION_20141001 = 20141001;
    public static final int PROTOCOL_VERSION_20141028 = 20141028;
    public static final int PROTOCOL_VERSION_20141107 = 20141107;
    public static final int PROTOCOL_VERSION_20141218 = 20141218;
    public static final int PROTOCOL_VERSION_20160327 = 20160327;
    public static final int PROTOCOL_VERSION_20170213 = 20170213;
    public static final int PROTOCOL_VERSION_20170411 = 20170411;
    public static final int PROTOCOL_VERSION_20170417 = 20170417;
    public static final int PROTOCOL_VERSION_20171115 = 20171115;
    public static final String RESULT_ARGS_ACCESS_TOKEN = "access_token";
    public static final String RESULT_ARGS_DIALOG_COMPLETE_KEY = "didComplete";
    public static final String RESULT_ARGS_DIALOG_COMPLETION_GESTURE_KEY = "completionGesture";
    public static final String RESULT_ARGS_EXPIRES_SECONDS_SINCE_EPOCH = "expires_seconds_since_epoch";
    public static final String RESULT_ARGS_PERMISSIONS = "permissions";
    public static final String RESULT_ARGS_SIGNED_REQUEST = "signed request";
    public static final String STATUS_ERROR_CODE = "com.facebook.platform.status.ERROR_CODE";
    public static final String STATUS_ERROR_DESCRIPTION = "com.facebook.platform.status.ERROR_DESCRIPTION";
    public static final String STATUS_ERROR_JSON = "com.facebook.platform.status.ERROR_JSON";
    public static final String STATUS_ERROR_SUBCODE = "com.facebook.platform.status.ERROR_SUBCODE";
    public static final String STATUS_ERROR_TYPE = "com.facebook.platform.status.ERROR_TYPE";
    public static final String WEB_DIALOG_ACTION = "action";
    public static final String WEB_DIALOG_IS_FALLBACK = "is_fallback";
    public static final String WEB_DIALOG_PARAMS = "params";
    public static final String WEB_DIALOG_URL = "url";
    private static final Map<String, List<NativeAppInfo>> actionToAppInfoMap = buildActionToAppInfoMap();
    private static final List<NativeAppInfo> effectCameraAppInfoList = buildEffectCameraAppInfoList();
    /* access modifiers changed from: private */
    public static final List<NativeAppInfo> facebookAppInfoList = buildFacebookAppList();
    /* access modifiers changed from: private */
    public static final AtomicBoolean protocolVersionsAsyncUpdating = new AtomicBoolean(false);

    private static class EffectTestAppInfo extends NativeAppInfo {
        /* access modifiers changed from: protected */
        public String getLoginActivity() {
            return null;
        }

        /* access modifiers changed from: protected */
        public String getPackage() {
            return "com.facebook.arstudio.player";
        }

        private EffectTestAppInfo() {
            super();
        }
    }

    private static class FBLiteAppInfo extends NativeAppInfo {
        /* access modifiers changed from: protected */
        public String getLoginActivity() {
            return "com.facebook.lite.platform.LoginGDPDialogActivity";
        }

        /* access modifiers changed from: protected */
        public String getPackage() {
            return "com.facebook.lite";
        }

        private FBLiteAppInfo() {
            super();
        }
    }

    private static class KatanaAppInfo extends NativeAppInfo {
        /* access modifiers changed from: protected */
        public String getLoginActivity() {
            return "com.facebook.katana.ProxyAuth";
        }

        /* access modifiers changed from: protected */
        public String getPackage() {
            return "com.facebook.katana";
        }

        private KatanaAppInfo() {
            super();
        }
    }

    private static class MessengerAppInfo extends NativeAppInfo {
        /* access modifiers changed from: protected */
        public String getLoginActivity() {
            return null;
        }

        /* access modifiers changed from: protected */
        public String getPackage() {
            return "com.facebook.orca";
        }

        private MessengerAppInfo() {
            super();
        }
    }

    private static abstract class NativeAppInfo {
        private TreeSet<Integer> availableVersions;

        /* access modifiers changed from: protected */
        public abstract String getLoginActivity();

        /* access modifiers changed from: protected */
        public abstract String getPackage();

        private NativeAppInfo() {
        }

        public TreeSet<Integer> getAvailableVersions() {
            TreeSet<Integer> treeSet = this.availableVersions;
            if (treeSet == null || treeSet.isEmpty()) {
                fetchAvailableVersions(false);
            }
            return this.availableVersions;
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Code restructure failed: missing block: B:6:0x000d, code lost:
            if (r0.availableVersions.isEmpty() == false) goto L_0x0015;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized void fetchAvailableVersions(boolean r1) {
            /*
                r0 = this;
                monitor-enter(r0)
                if (r1 != 0) goto L_0x000f
                java.util.TreeSet<java.lang.Integer> r1 = r0.availableVersions     // Catch:{ all -> 0x0017 }
                if (r1 == 0) goto L_0x000f
                java.util.TreeSet<java.lang.Integer> r1 = r0.availableVersions     // Catch:{ all -> 0x0017 }
                boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0017 }
                if (r1 == 0) goto L_0x0015
            L_0x000f:
                java.util.TreeSet r1 = com.facebook.internal.NativeProtocol.fetchAllAvailableProtocolVersionsForAppInfo(r0)     // Catch:{ all -> 0x0017 }
                r0.availableVersions = r1     // Catch:{ all -> 0x0017 }
            L_0x0015:
                monitor-exit(r0)
                return
            L_0x0017:
                r1 = move-exception
                monitor-exit(r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.NativeProtocol.NativeAppInfo.fetchAvailableVersions(boolean):void");
        }
    }

    public static class ProtocolVersionQueryResult {
        /* access modifiers changed from: private */
        public NativeAppInfo nativeAppInfo;
        /* access modifiers changed from: private */
        public int protocolVersion;

        public static ProtocolVersionQueryResult create(NativeAppInfo nativeAppInfo2, int i) {
            ProtocolVersionQueryResult protocolVersionQueryResult = new ProtocolVersionQueryResult();
            protocolVersionQueryResult.nativeAppInfo = nativeAppInfo2;
            protocolVersionQueryResult.protocolVersion = i;
            return protocolVersionQueryResult;
        }

        public static ProtocolVersionQueryResult createEmpty() {
            ProtocolVersionQueryResult protocolVersionQueryResult = new ProtocolVersionQueryResult();
            protocolVersionQueryResult.protocolVersion = -1;
            return protocolVersionQueryResult;
        }

        private ProtocolVersionQueryResult() {
        }

        @Nullable
        public NativeAppInfo getAppInfo() {
            return this.nativeAppInfo;
        }

        public int getProtocolVersion() {
            return this.protocolVersion;
        }
    }

    private static class WakizashiAppInfo extends NativeAppInfo {
        /* access modifiers changed from: protected */
        public String getLoginActivity() {
            return "com.facebook.katana.ProxyAuth";
        }

        /* access modifiers changed from: protected */
        public String getPackage() {
            return "com.facebook.wakizashi";
        }

        private WakizashiAppInfo() {
            super();
        }
    }

    private static List<NativeAppInfo> buildFacebookAppList() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KatanaAppInfo());
        arrayList.add(new WakizashiAppInfo());
        return arrayList;
    }

    private static List<NativeAppInfo> buildEffectCameraAppInfoList() {
        ArrayList arrayList = new ArrayList(buildFacebookAppList());
        arrayList.add(0, new EffectTestAppInfo());
        return arrayList;
    }

    private static Map<String, List<NativeAppInfo>> buildActionToAppInfoMap() {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new MessengerAppInfo());
        hashMap.put(ACTION_OGACTIONPUBLISH_DIALOG, facebookAppInfoList);
        hashMap.put(ACTION_FEED_DIALOG, facebookAppInfoList);
        hashMap.put(ACTION_LIKE_DIALOG, facebookAppInfoList);
        hashMap.put(ACTION_APPINVITE_DIALOG, facebookAppInfoList);
        hashMap.put(ACTION_MESSAGE_DIALOG, arrayList);
        hashMap.put(ACTION_OGMESSAGEPUBLISH_DIALOG, arrayList);
        hashMap.put(ACTION_CAMERA_EFFECT, effectCameraAppInfoList);
        hashMap.put(ACTION_SHARE_STORY, facebookAppInfoList);
        return hashMap;
    }

    static Intent validateActivityIntent(Context context, Intent intent, NativeAppInfo nativeAppInfo) {
        if (intent == null) {
            return null;
        }
        ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 0);
        if (resolveActivity != null && FacebookSignatureValidator.validateSignature(context, resolveActivity.activityInfo.packageName)) {
            return intent;
        }
        return null;
    }

    static Intent validateServiceIntent(Context context, Intent intent, NativeAppInfo nativeAppInfo) {
        if (intent == null) {
            return null;
        }
        ResolveInfo resolveService = context.getPackageManager().resolveService(intent, 0);
        if (resolveService != null && FacebookSignatureValidator.validateSignature(context, resolveService.serviceInfo.packageName)) {
            return intent;
        }
        return null;
    }

    public static Intent createFacebookLiteIntent(Context context, String str, Collection<String> collection, String str2, boolean z, boolean z2, DefaultAudience defaultAudience, String str3, String str4) {
        FBLiteAppInfo fBLiteAppInfo = new FBLiteAppInfo();
        Context context2 = context;
        return validateActivityIntent(context, createNativeAppIntent(fBLiteAppInfo, str, collection, str2, z, z2, defaultAudience, str3, str4), fBLiteAppInfo);
    }

    private static Intent createNativeAppIntent(NativeAppInfo nativeAppInfo, String str, Collection<String> collection, String str2, boolean z, boolean z2, DefaultAudience defaultAudience, String str3, String str4) {
        String loginActivity = nativeAppInfo.getLoginActivity();
        if (loginActivity == null) {
            return null;
        }
        Intent putExtra = new Intent().setClassName(nativeAppInfo.getPackage(), loginActivity).putExtra("client_id", str);
        putExtra.putExtra(FACEBOOK_SDK_VERSION_KEY, FacebookSdk.getSdkVersion());
        if (!Utility.isNullOrEmpty(collection)) {
            putExtra.putExtra("scope", TextUtils.join(",", collection));
        }
        if (!Utility.isNullOrEmpty(str2)) {
            putExtra.putExtra("e2e", str2);
        }
        putExtra.putExtra(ServerProtocol.DIALOG_PARAM_STATE, str3);
        putExtra.putExtra("response_type", ServerProtocol.DIALOG_RESPONSE_TYPE_TOKEN_AND_SIGNED_REQUEST);
        putExtra.putExtra(ServerProtocol.DIALOG_PARAM_RETURN_SCOPES, ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        if (z2) {
            putExtra.putExtra(ServerProtocol.DIALOG_PARAM_DEFAULT_AUDIENCE, defaultAudience.getNativeProtocolAudience());
        }
        putExtra.putExtra(ServerProtocol.DIALOG_PARAM_LEGACY_OVERRIDE, FacebookSdk.getGraphApiVersion());
        putExtra.putExtra(ServerProtocol.DIALOG_PARAM_AUTH_TYPE, str4);
        return putExtra;
    }

    public static Intent createProxyAuthIntent(Context context, String str, Collection<String> collection, String str2, boolean z, boolean z2, DefaultAudience defaultAudience, String str3, String str4) {
        for (NativeAppInfo nativeAppInfo : facebookAppInfoList) {
            Context context2 = context;
            Intent validateActivityIntent = validateActivityIntent(context, createNativeAppIntent(nativeAppInfo, str, collection, str2, z, z2, defaultAudience, str3, str4), nativeAppInfo);
            if (validateActivityIntent != null) {
                return validateActivityIntent;
            }
        }
        return null;
    }

    public static Intent createTokenRefreshIntent(Context context) {
        for (NativeAppInfo nativeAppInfo : facebookAppInfoList) {
            Intent validateServiceIntent = validateServiceIntent(context, new Intent().setClassName(nativeAppInfo.getPackage(), "com.facebook.katana.platform.TokenRefreshService"), nativeAppInfo);
            if (validateServiceIntent != null) {
                return validateServiceIntent;
            }
        }
        return null;
    }

    public static final int getLatestKnownVersion() {
        return ((Integer) KNOWN_PROTOCOL_VERSIONS.get(0)).intValue();
    }

    public static boolean isVersionCompatibleWithBucketedIntent(int i) {
        return KNOWN_PROTOCOL_VERSIONS.contains(Integer.valueOf(i)) && i >= 20140701;
    }

    public static Intent createPlatformActivityIntent(Context context, String str, String str2, ProtocolVersionQueryResult protocolVersionQueryResult, Bundle bundle) {
        if (protocolVersionQueryResult == null) {
            return null;
        }
        NativeAppInfo access$700 = protocolVersionQueryResult.nativeAppInfo;
        if (access$700 == null) {
            return null;
        }
        Intent validateActivityIntent = validateActivityIntent(context, new Intent().setAction("com.facebook.platform.PLATFORM_ACTIVITY").setPackage(access$700.getPackage()).addCategory("android.intent.category.DEFAULT"), access$700);
        if (validateActivityIntent == null) {
            return null;
        }
        setupProtocolRequestIntent(validateActivityIntent, str, str2, protocolVersionQueryResult.protocolVersion, bundle);
        return validateActivityIntent;
    }

    public static void setupProtocolRequestIntent(Intent intent, String str, String str2, int i, Bundle bundle) {
        String applicationId = FacebookSdk.getApplicationId();
        String applicationName = FacebookSdk.getApplicationName();
        intent.putExtra(EXTRA_PROTOCOL_VERSION, i).putExtra(EXTRA_PROTOCOL_ACTION, str2).putExtra(EXTRA_APPLICATION_ID, applicationId);
        if (isVersionCompatibleWithBucketedIntent(i)) {
            Bundle bundle2 = new Bundle();
            bundle2.putString(BRIDGE_ARG_ACTION_ID_STRING, str);
            Utility.putNonEmptyString(bundle2, BRIDGE_ARG_APP_NAME_STRING, applicationName);
            intent.putExtra(EXTRA_PROTOCOL_BRIDGE_ARGS, bundle2);
            if (bundle == null) {
                bundle = new Bundle();
            }
            intent.putExtra(EXTRA_PROTOCOL_METHOD_ARGS, bundle);
            return;
        }
        intent.putExtra(EXTRA_PROTOCOL_CALL_ID, str);
        if (!Utility.isNullOrEmpty(applicationName)) {
            intent.putExtra(EXTRA_APPLICATION_NAME, applicationName);
        }
        intent.putExtras(bundle);
    }

    public static Intent createProtocolResultIntent(Intent intent, Bundle bundle, FacebookException facebookException) {
        UUID callIdFromIntent = getCallIdFromIntent(intent);
        if (callIdFromIntent == null) {
            return null;
        }
        Intent intent2 = new Intent();
        intent2.putExtra(EXTRA_PROTOCOL_VERSION, getProtocolVersionFromIntent(intent));
        Bundle bundle2 = new Bundle();
        bundle2.putString(BRIDGE_ARG_ACTION_ID_STRING, callIdFromIntent.toString());
        if (facebookException != null) {
            bundle2.putBundle("error", createBundleForException(facebookException));
        }
        intent2.putExtra(EXTRA_PROTOCOL_BRIDGE_ARGS, bundle2);
        if (bundle != null) {
            intent2.putExtra(EXTRA_PROTOCOL_METHOD_RESULTS, bundle);
        }
        return intent2;
    }

    public static Intent createPlatformServiceIntent(Context context) {
        for (NativeAppInfo nativeAppInfo : facebookAppInfoList) {
            Intent validateServiceIntent = validateServiceIntent(context, new Intent("com.facebook.platform.PLATFORM_SERVICE").setPackage(nativeAppInfo.getPackage()).addCategory("android.intent.category.DEFAULT"), nativeAppInfo);
            if (validateServiceIntent != null) {
                return validateServiceIntent;
            }
        }
        return null;
    }

    public static int getProtocolVersionFromIntent(Intent intent) {
        return intent.getIntExtra(EXTRA_PROTOCOL_VERSION, 0);
    }

    public static UUID getCallIdFromIntent(Intent intent) {
        String str;
        UUID uuid = null;
        if (intent == null) {
            return null;
        }
        if (isVersionCompatibleWithBucketedIntent(getProtocolVersionFromIntent(intent))) {
            Bundle bundleExtra = intent.getBundleExtra(EXTRA_PROTOCOL_BRIDGE_ARGS);
            str = bundleExtra != null ? bundleExtra.getString(BRIDGE_ARG_ACTION_ID_STRING) : null;
        } else {
            str = intent.getStringExtra(EXTRA_PROTOCOL_CALL_ID);
        }
        if (str != null) {
            try {
                uuid = UUID.fromString(str);
            } catch (IllegalArgumentException unused) {
            }
        }
        return uuid;
    }

    public static Bundle getBridgeArgumentsFromIntent(Intent intent) {
        if (!isVersionCompatibleWithBucketedIntent(getProtocolVersionFromIntent(intent))) {
            return null;
        }
        return intent.getBundleExtra(EXTRA_PROTOCOL_BRIDGE_ARGS);
    }

    public static Bundle getMethodArgumentsFromIntent(Intent intent) {
        if (!isVersionCompatibleWithBucketedIntent(getProtocolVersionFromIntent(intent))) {
            return intent.getExtras();
        }
        return intent.getBundleExtra(EXTRA_PROTOCOL_METHOD_ARGS);
    }

    public static Bundle getSuccessResultsFromIntent(Intent intent) {
        int protocolVersionFromIntent = getProtocolVersionFromIntent(intent);
        Bundle extras = intent.getExtras();
        return (!isVersionCompatibleWithBucketedIntent(protocolVersionFromIntent) || extras == null) ? extras : extras.getBundle(EXTRA_PROTOCOL_METHOD_RESULTS);
    }

    public static boolean isErrorResult(Intent intent) {
        Bundle bridgeArgumentsFromIntent = getBridgeArgumentsFromIntent(intent);
        if (bridgeArgumentsFromIntent != null) {
            return bridgeArgumentsFromIntent.containsKey("error");
        }
        return intent.hasExtra(STATUS_ERROR_TYPE);
    }

    public static Bundle getErrorDataFromResultIntent(Intent intent) {
        if (!isErrorResult(intent)) {
            return null;
        }
        Bundle bridgeArgumentsFromIntent = getBridgeArgumentsFromIntent(intent);
        if (bridgeArgumentsFromIntent != null) {
            return bridgeArgumentsFromIntent.getBundle("error");
        }
        return intent.getExtras();
    }

    public static FacebookException getExceptionFromErrorData(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        String string = bundle.getString(BRIDGE_ARG_ERROR_TYPE);
        if (string == null) {
            string = bundle.getString(STATUS_ERROR_TYPE);
        }
        String string2 = bundle.getString("error_description");
        if (string2 == null) {
            string2 = bundle.getString(STATUS_ERROR_DESCRIPTION);
        }
        if (string == null || !string.equalsIgnoreCase(ERROR_USER_CANCELED)) {
            return new FacebookException(string2);
        }
        return new FacebookOperationCanceledException(string2);
    }

    public static Bundle createBundleForException(FacebookException facebookException) {
        if (facebookException == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("error_description", facebookException.toString());
        if (facebookException instanceof FacebookOperationCanceledException) {
            bundle.putString(BRIDGE_ARG_ERROR_TYPE, ERROR_USER_CANCELED);
        }
        return bundle;
    }

    public static int getLatestAvailableProtocolVersionForService(int i) {
        return getLatestAvailableProtocolVersionForAppInfoList(facebookAppInfoList, new int[]{i}).getProtocolVersion();
    }

    public static ProtocolVersionQueryResult getLatestAvailableProtocolVersionForAction(String str, int[] iArr) {
        return getLatestAvailableProtocolVersionForAppInfoList((List) actionToAppInfoMap.get(str), iArr);
    }

    private static ProtocolVersionQueryResult getLatestAvailableProtocolVersionForAppInfoList(List<NativeAppInfo> list, int[] iArr) {
        updateAllAvailableProtocolVersionsAsync();
        if (list == null) {
            return ProtocolVersionQueryResult.createEmpty();
        }
        for (NativeAppInfo nativeAppInfo : list) {
            int computeLatestAvailableVersionFromVersionSpec = computeLatestAvailableVersionFromVersionSpec(nativeAppInfo.getAvailableVersions(), getLatestKnownVersion(), iArr);
            if (computeLatestAvailableVersionFromVersionSpec != -1) {
                return ProtocolVersionQueryResult.create(nativeAppInfo, computeLatestAvailableVersionFromVersionSpec);
            }
        }
        return ProtocolVersionQueryResult.createEmpty();
    }

    public static void updateAllAvailableProtocolVersionsAsync() {
        if (protocolVersionsAsyncUpdating.compareAndSet(false, true)) {
            FacebookSdk.getExecutor().execute(new Runnable() {
                public void run() {
                    try {
                        for (NativeAppInfo access$1000 : NativeProtocol.facebookAppInfoList) {
                            access$1000.fetchAvailableVersions(true);
                        }
                    } finally {
                        NativeProtocol.protocolVersionsAsyncUpdating.set(false);
                    }
                }
            });
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private */
    public static TreeSet<Integer> fetchAllAvailableProtocolVersionsForAppInfo(NativeAppInfo nativeAppInfo) {
        ProviderInfo providerInfo;
        TreeSet<Integer> treeSet = new TreeSet<>();
        ContentResolver contentResolver = FacebookSdk.getApplicationContext().getContentResolver();
        String str = ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION;
        String[] strArr = {str};
        Uri buildPlatformProviderVersionURI = buildPlatformProviderVersionURI(nativeAppInfo);
        Cursor cursor = null;
        try {
            PackageManager packageManager = FacebookSdk.getApplicationContext().getPackageManager();
            StringBuilder sb = new StringBuilder();
            sb.append(nativeAppInfo.getPackage());
            sb.append(".provider.PlatformProvider");
            try {
                providerInfo = packageManager.resolveContentProvider(sb.toString(), 0);
            } catch (RuntimeException unused) {
                providerInfo = null;
            }
            if (providerInfo != null) {
                try {
                    cursor = contentResolver.query(buildPlatformProviderVersionURI, strArr, null, null, null);
                } catch (IllegalArgumentException | NullPointerException | SecurityException unused2) {
                }
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        treeSet.add(Integer.valueOf(cursor.getInt(cursor.getColumnIndex(str))));
                    }
                }
            }
            if (cursor != null) {
                cursor.close();
            }
            return treeSet;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public static int computeLatestAvailableVersionFromVersionSpec(TreeSet<Integer> treeSet, int i, int[] iArr) {
        int length = iArr.length - 1;
        Iterator descendingIterator = treeSet.descendingIterator();
        int i2 = -1;
        int i3 = length;
        int i4 = -1;
        while (true) {
            if (!descendingIterator.hasNext()) {
                break;
            }
            int intValue = ((Integer) descendingIterator.next()).intValue();
            i4 = Math.max(i4, intValue);
            while (i3 >= 0 && iArr[i3] > intValue) {
                i3--;
            }
            if (i3 < 0) {
                return -1;
            }
            if (iArr[i3] == intValue) {
                if (i3 % 2 == 0) {
                    i2 = Math.min(i4, i);
                }
            }
        }
        return i2;
    }

    private static Uri buildPlatformProviderVersionURI(NativeAppInfo nativeAppInfo) {
        StringBuilder sb = new StringBuilder();
        sb.append("content://");
        sb.append(nativeAppInfo.getPackage());
        sb.append(".provider.PlatformProvider/versions");
        return Uri.parse(sb.toString());
    }
}
