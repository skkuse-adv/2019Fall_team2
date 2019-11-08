package com.kakao.auth.authorization.authcode;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.FileChooserParams;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import com.kakao.auth.KakaoSDK;
import com.kakao.auth.R;
import com.kakao.auth.StringSet;
import com.kakao.auth.exception.KakaoWebviewException;
import com.kakao.network.ServerProtocol;
import com.kakao.util.exception.KakaoException;
import com.kakao.util.exception.KakaoException.ErrorType;
import com.kakao.util.helper.CommonProtocol;
import com.kakao.util.helper.SystemInfo;
import com.kakao.util.helper.log.Logger;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class KakaoWebViewActivity extends Activity {
    private static final int IMAGE_REQUEST_CODE = 9999;
    public static final String KEY_EXCEPTION = "key.exception";
    public static final String KEY_EXTRA_HEADERS = "key.extra.headers";
    public static final String KEY_FULLSCREEN_OPTIONS = "key.fullscreen.options";
    public static final String KEY_LAYOUT_IN_DISPLAY_CUTOUT_MODE = "key.layout.in.display.cutout.mode";
    public static final String KEY_REDIRECT_URL = "key.redirect.url";
    public static final String KEY_RESULT_RECEIVER = "key.result.receiver";
    public static final String KEY_SYSTEM_UI_VISIBILITY = "key.system.ui.visibility";
    public static final String KEY_URL = "key.url";
    public static final String KEY_USE_WEBVIEW_TIMERS = "key.use.webview.timers";
    public static final String KEY_WINDOW_FLAGS = "key.window.flags";
    public static final int RESULT_ERROR = 1;
    public static final int RESULT_SUCCESS = 0;
    /* access modifiers changed from: private */
    public final Map<String, String> headers = new HashMap();
    /* access modifiers changed from: private */
    public ValueCallback<Uri> imageCallback;
    /* access modifiers changed from: private */
    public ValueCallback<Uri[]> lollipopImageCallback;
    private ProgressBar progressBar;
    private ResultReceiver resultReceiver;
    /* access modifiers changed from: private */
    public boolean shouldProceedWithSslError;
    private String url;
    private boolean useWebViewTimers;
    /* access modifiers changed from: private */
    public WebView webView;

    private class KakaoWebChromeClient extends WebChromeClient {
        private KakaoWebChromeClient() {
        }

        public boolean onJsAlert(WebView webView, String str, String str2, final JsResult jsResult) {
            new Builder(KakaoWebViewActivity.this).setMessage(str2).setPositiveButton(17039370, new OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    jsResult.confirm();
                }
            }).setCancelable(false).create().show();
            return true;
        }

        public void openFileChooser(ValueCallback<Uri> valueCallback, String str) {
            KakaoWebViewActivity.this.imageCallback = valueCallback;
            KakaoWebViewActivity.this.openImageChooserActivity();
        }

        public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
            KakaoWebViewActivity.this.imageCallback = valueCallback;
            KakaoWebViewActivity.this.openImageChooserActivity();
        }

        @RequiresApi(21)
        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, FileChooserParams fileChooserParams) {
            KakaoWebViewActivity.this.lollipopImageCallback = valueCallback;
            KakaoWebViewActivity.this.openImageChooserActivity();
            return true;
        }

        /* JADX WARNING: Removed duplicated region for block: B:33:0x0096  */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x009d  */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x00a9  */
        /* JADX WARNING: Removed duplicated region for block: B:46:0x00d3  */
        /* JADX WARNING: Removed duplicated region for block: B:49:0x00da  */
        /* JADX WARNING: Removed duplicated region for block: B:52:0x00e6  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onJsConfirm(android.webkit.WebView r8, java.lang.String r9, java.lang.String r10, final android.webkit.JsResult r11) {
            /*
                r7 = this;
                r8 = 0
                r9 = 17039360(0x1040000, float:2.424457E-38)
                r0 = 17039370(0x104000a, float:2.42446E-38)
                r1 = 0
                org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0074, all -> 0x0070 }
                r2.<init>(r10)     // Catch:{ JSONException -> 0x0074, all -> 0x0070 }
                java.lang.String r3 = "message"
                java.lang.String r3 = r2.optString(r3)     // Catch:{ JSONException -> 0x0074, all -> 0x0070 }
                java.lang.String r4 = "positive"
                java.lang.String r4 = r2.optString(r4)     // Catch:{ JSONException -> 0x006d, all -> 0x006a }
                java.lang.String r5 = "negative"
                java.lang.String r1 = r2.optString(r5)     // Catch:{ JSONException -> 0x0068 }
                boolean r2 = android.text.TextUtils.isEmpty(r3)
                if (r2 == 0) goto L_0x0025
                goto L_0x0026
            L_0x0025:
                r10 = r3
            L_0x0026:
                boolean r2 = android.text.TextUtils.isEmpty(r4)
                if (r2 == 0) goto L_0x0032
                com.kakao.auth.authorization.authcode.KakaoWebViewActivity r2 = com.kakao.auth.authorization.authcode.KakaoWebViewActivity.this
                java.lang.String r4 = r2.getString(r0)
            L_0x0032:
                boolean r0 = android.text.TextUtils.isEmpty(r1)
                if (r0 == 0) goto L_0x003e
                com.kakao.auth.authorization.authcode.KakaoWebViewActivity r0 = com.kakao.auth.authorization.authcode.KakaoWebViewActivity.this
                java.lang.String r1 = r0.getString(r9)
            L_0x003e:
                android.app.AlertDialog$Builder r9 = new android.app.AlertDialog$Builder
                com.kakao.auth.authorization.authcode.KakaoWebViewActivity r0 = com.kakao.auth.authorization.authcode.KakaoWebViewActivity.this
                r9.<init>(r0)
                android.app.AlertDialog$Builder r9 = r9.setMessage(r10)
                com.kakao.auth.authorization.authcode.KakaoWebViewActivity$KakaoWebChromeClient$3 r10 = new com.kakao.auth.authorization.authcode.KakaoWebViewActivity$KakaoWebChromeClient$3
                r10.<init>(r11)
                android.app.AlertDialog$Builder r9 = r9.setPositiveButton(r4, r10)
                com.kakao.auth.authorization.authcode.KakaoWebViewActivity$KakaoWebChromeClient$2 r10 = new com.kakao.auth.authorization.authcode.KakaoWebViewActivity$KakaoWebChromeClient$2
                r10.<init>(r11)
            L_0x0057:
                android.app.AlertDialog$Builder r9 = r9.setNegativeButton(r1, r10)
                android.app.AlertDialog$Builder r8 = r9.setCancelable(r8)
                android.app.AlertDialog r8 = r8.create()
                r8.show()
                goto L_0x00c9
            L_0x0068:
                r2 = move-exception
                goto L_0x0077
            L_0x006a:
                r2 = move-exception
                r4 = r1
                goto L_0x00cc
            L_0x006d:
                r2 = move-exception
                r4 = r1
                goto L_0x0077
            L_0x0070:
                r2 = move-exception
                r3 = r1
                r4 = r3
                goto L_0x00cc
            L_0x0074:
                r2 = move-exception
                r3 = r1
                r4 = r3
            L_0x0077:
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00cb }
                r5.<init>()     // Catch:{ all -> 0x00cb }
                java.lang.String r6 = "JSONException: "
                r5.append(r6)     // Catch:{ all -> 0x00cb }
                java.lang.String r2 = r2.getMessage()     // Catch:{ all -> 0x00cb }
                r5.append(r2)     // Catch:{ all -> 0x00cb }
                java.lang.String r2 = r5.toString()     // Catch:{ all -> 0x00cb }
                com.kakao.util.helper.log.Logger.e(r2)     // Catch:{ all -> 0x00cb }
                boolean r2 = android.text.TextUtils.isEmpty(r3)
                if (r2 == 0) goto L_0x0096
                goto L_0x0097
            L_0x0096:
                r10 = r3
            L_0x0097:
                boolean r2 = android.text.TextUtils.isEmpty(r4)
                if (r2 == 0) goto L_0x00a3
                com.kakao.auth.authorization.authcode.KakaoWebViewActivity r2 = com.kakao.auth.authorization.authcode.KakaoWebViewActivity.this
                java.lang.String r4 = r2.getString(r0)
            L_0x00a3:
                boolean r0 = android.text.TextUtils.isEmpty(r1)
                if (r0 == 0) goto L_0x00af
                com.kakao.auth.authorization.authcode.KakaoWebViewActivity r0 = com.kakao.auth.authorization.authcode.KakaoWebViewActivity.this
                java.lang.String r1 = r0.getString(r9)
            L_0x00af:
                android.app.AlertDialog$Builder r9 = new android.app.AlertDialog$Builder
                com.kakao.auth.authorization.authcode.KakaoWebViewActivity r0 = com.kakao.auth.authorization.authcode.KakaoWebViewActivity.this
                r9.<init>(r0)
                android.app.AlertDialog$Builder r9 = r9.setMessage(r10)
                com.kakao.auth.authorization.authcode.KakaoWebViewActivity$KakaoWebChromeClient$3 r10 = new com.kakao.auth.authorization.authcode.KakaoWebViewActivity$KakaoWebChromeClient$3
                r10.<init>(r11)
                android.app.AlertDialog$Builder r9 = r9.setPositiveButton(r4, r10)
                com.kakao.auth.authorization.authcode.KakaoWebViewActivity$KakaoWebChromeClient$2 r10 = new com.kakao.auth.authorization.authcode.KakaoWebViewActivity$KakaoWebChromeClient$2
                r10.<init>(r11)
                goto L_0x0057
            L_0x00c9:
                r8 = 1
                return r8
            L_0x00cb:
                r2 = move-exception
            L_0x00cc:
                boolean r5 = android.text.TextUtils.isEmpty(r3)
                if (r5 == 0) goto L_0x00d3
                goto L_0x00d4
            L_0x00d3:
                r10 = r3
            L_0x00d4:
                boolean r3 = android.text.TextUtils.isEmpty(r4)
                if (r3 == 0) goto L_0x00e0
                com.kakao.auth.authorization.authcode.KakaoWebViewActivity r3 = com.kakao.auth.authorization.authcode.KakaoWebViewActivity.this
                java.lang.String r4 = r3.getString(r0)
            L_0x00e0:
                boolean r0 = android.text.TextUtils.isEmpty(r1)
                if (r0 == 0) goto L_0x00ec
                com.kakao.auth.authorization.authcode.KakaoWebViewActivity r0 = com.kakao.auth.authorization.authcode.KakaoWebViewActivity.this
                java.lang.String r1 = r0.getString(r9)
            L_0x00ec:
                android.app.AlertDialog$Builder r9 = new android.app.AlertDialog$Builder
                com.kakao.auth.authorization.authcode.KakaoWebViewActivity r0 = com.kakao.auth.authorization.authcode.KakaoWebViewActivity.this
                r9.<init>(r0)
                android.app.AlertDialog$Builder r9 = r9.setMessage(r10)
                com.kakao.auth.authorization.authcode.KakaoWebViewActivity$KakaoWebChromeClient$3 r10 = new com.kakao.auth.authorization.authcode.KakaoWebViewActivity$KakaoWebChromeClient$3
                r10.<init>(r11)
                android.app.AlertDialog$Builder r9 = r9.setPositiveButton(r4, r10)
                com.kakao.auth.authorization.authcode.KakaoWebViewActivity$KakaoWebChromeClient$2 r10 = new com.kakao.auth.authorization.authcode.KakaoWebViewActivity$KakaoWebChromeClient$2
                r10.<init>(r11)
                android.app.AlertDialog$Builder r9 = r9.setNegativeButton(r1, r10)
                android.app.AlertDialog$Builder r8 = r9.setCancelable(r8)
                android.app.AlertDialog r8 = r8.create()
                r8.show()
                goto L_0x0116
            L_0x0115:
                throw r2
            L_0x0116:
                goto L_0x0115
            */
            throw new UnsupportedOperationException("Method not decompiled: com.kakao.auth.authorization.authcode.KakaoWebViewActivity.KakaoWebChromeClient.onJsConfirm(android.webkit.WebView, java.lang.String, java.lang.String, android.webkit.JsResult):boolean");
        }

        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            StringBuilder sb = new StringBuilder();
            sb.append("KakaoAccountWebView: ");
            sb.append(consoleMessage.message());
            sb.append(" -- (");
            sb.append(consoleMessage.lineNumber());
            sb.append("/");
            sb.append(consoleMessage.sourceId());
            sb.append(")");
            Logger.d(sb.toString());
            return true;
        }
    }

    private class KakaoWebViewClient extends WebViewClient {
        private KakaoWebViewClient() {
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            StringBuilder sb = new StringBuilder();
            sb.append("(Deprecated) Redirect URL: ");
            sb.append(str);
            Logger.d(sb.toString());
            return handleShouldOverrideUrlLoading(str);
        }

        @RequiresApi(24)
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            StringBuilder sb = new StringBuilder();
            sb.append("Redirect URL:");
            sb.append(webResourceRequest.getUrl());
            Logger.d(sb.toString());
            return handleShouldOverrideUrlLoading(webResourceRequest.getUrl().toString());
        }

        private boolean handleShouldOverrideUrlLoading(String str) {
            if (str.startsWith("kakao") && (str.contains(StringSet.REDIRECT_URL_POSTFIX) || str.contains(StringSet.AGEAUTH_REDIRECT_URL_POSTFIX))) {
                KakaoWebViewActivity.this.sendSuccessToListener(str);
                KakaoWebViewActivity.this.finish();
            } else if (str.contains(ServerProtocol.authAuthority()) || str.contains(ServerProtocol.apiAuthority()) || str.contains(ServerProtocol.accountAuthority())) {
                KakaoWebViewActivity.this.webView.loadUrl(str, KakaoWebViewActivity.this.headers);
            } else if (KakaoWebViewActivity.this.isCameraAccessibleScheme(str)) {
                KakaoWebViewActivity.this.processCameraAccessibleScript(KakaoWebViewActivity.this.createCameraAccessibleScript(Uri.parse(str)));
            } else {
                try {
                    KakaoWebViewActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                } catch (ActivityNotFoundException e) {
                    if (e.getLocalizedMessage() != null) {
                        Logger.d(e.getLocalizedMessage());
                    }
                }
            }
            return true;
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            if (VERSION.SDK_INT < 23) {
                super.onReceivedError(webView, i, str, str2);
                Logger.w("(deprecated) onReceivedError: %s, %s", str, str2);
            }
        }

        @TargetApi(23)
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            String str = null;
            if (!(webResourceError == null || webResourceError.getDescription() == null)) {
                str = webResourceError.getDescription().toString();
            }
            Logger.w("onReceivedError: %s, %s", str, webResourceRequest.getUrl().toString());
        }

        public void onReceivedSslError(WebView webView, final SslErrorHandler sslErrorHandler, final SslError sslError) {
            KakaoWebViewActivity.this.setProgressBarVisibility(8);
            Builder builder = new Builder(KakaoWebViewActivity.this);
            builder.setTitle(KakaoWebViewActivity.this.getString(R.string.title_for_ssl_warning));
            builder.setMessage(KakaoWebViewActivity.this.getString(R.string.message_for_ssl_warning));
            KakaoWebViewActivity.this.shouldProceedWithSslError = false;
            builder.setNegativeButton(KakaoWebViewActivity.this.getString(R.string.button_for_ssl_go_back), new OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            builder.setPositiveButton(KakaoWebViewActivity.this.getString(R.string.button_for_ssl_go_forward), new OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    KakaoWebViewActivity.this.shouldProceedWithSslError = true;
                    sslErrorHandler.proceed();
                }
            });
            AlertDialog create = builder.create();
            create.setOnDismissListener(new OnDismissListener() {
                public void onDismiss(DialogInterface dialogInterface) {
                    if (!KakaoWebViewActivity.this.shouldProceedWithSslError) {
                        sslErrorHandler.cancel();
                        KakaoWebViewActivity kakaoWebViewActivity = KakaoWebViewActivity.this;
                        SslError sslError = sslError;
                        kakaoWebViewActivity.sendErrorToListener(new KakaoWebviewException(-11, sslError == null ? null : sslError.toString(), null));
                        KakaoWebViewActivity.this.finish();
                    }
                }
            });
            if (!KakaoWebViewActivity.this.isFinishing()) {
                create.show();
            }
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            StringBuilder sb = new StringBuilder();
            sb.append("Webview loading URL: ");
            sb.append(str);
            Logger.d(sb.toString());
            super.onPageStarted(webView, str, bitmap);
            KakaoWebViewActivity.this.setProgressBarVisibility(0);
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            KakaoWebViewActivity.this.setProgressBarVisibility(8);
        }
    }

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, KakaoWebViewActivity.class);
        intent.addFlags(805371904);
        return intent;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        try {
            requestWindowFeature(1);
            super.onCreate(bundle);
            parseIntent(getIntent());
            setContentView(R.layout.activity_kakao_webview);
            initUi();
        } catch (Exception e) {
            sendErrorToListener(e);
            finish();
        }
    }

    private void parseIntent(Intent intent) {
        this.url = intent.getStringExtra(KEY_URL);
        this.useWebViewTimers = intent.getBooleanExtra(KEY_USE_WEBVIEW_TIMERS, false);
        this.resultReceiver = (ResultReceiver) intent.getParcelableExtra(KEY_RESULT_RECEIVER);
        Bundle bundle = (Bundle) intent.getParcelableExtra(KEY_EXTRA_HEADERS);
        this.headers.put(CommonProtocol.KA_HEADER_KEY, SystemInfo.getKAHeader());
        if (bundle != null && !bundle.isEmpty()) {
            for (String str : bundle.keySet()) {
                this.headers.put(str, bundle.getString(str));
            }
        }
        Bundle bundle2 = (Bundle) intent.getParcelableExtra(KEY_FULLSCREEN_OPTIONS);
        if (bundle2 != null) {
            applyFullscreenOptions(bundle2);
        }
    }

    private void applyFullscreenOptions(Bundle bundle) {
        if (VERSION.SDK_INT < 16) {
            getWindow().setFlags(1024, 1024);
            return;
        }
        getWindow().getDecorView().setSystemUiVisibility(bundle.getInt(KEY_SYSTEM_UI_VISIBILITY));
        getWindow().addFlags(bundle.getInt(KEY_WINDOW_FLAGS));
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        parseIntent(intent);
        setProgressBarVisibility(0);
        this.webView.loadUrl(this.url, this.headers);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (this.useWebViewTimers) {
            this.webView.resumeTimers();
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        if (this.useWebViewTimers) {
            this.webView.pauseTimers();
        }
        super.onPause();
    }

    public void onBackPressed() {
        if (this.webView.canGoBack()) {
            this.webView.goBack();
            return;
        }
        sendCancelToListener();
        super.onBackPressed();
    }

    public void finish() {
        overridePendingTransition(0, 0);
        super.finish();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
    }

    private void sendCancelToListener() {
        sendErrorToListener(new KakaoException(ErrorType.CANCELED_OPERATION, getString(R.string.auth_code_cancel)));
    }

    /* access modifiers changed from: private */
    public void sendSuccessToListener(String str) {
        if (this.resultReceiver != null) {
            Bundle bundle = new Bundle();
            bundle.putString(KEY_REDIRECT_URL, str);
            this.resultReceiver.send(0, bundle);
        }
    }

    /* access modifiers changed from: private */
    public void sendErrorToListener(Throwable th) {
        KakaoException kakaoException;
        if (this.resultReceiver != null) {
            Bundle bundle = new Bundle();
            if (th instanceof KakaoException) {
                kakaoException = (KakaoException) th;
            } else {
                kakaoException = new KakaoException(th.getMessage(), th);
            }
            bundle.putSerializable(KEY_EXCEPTION, kakaoException);
            this.resultReceiver.send(1, bundle);
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void initUi() {
        this.webView = (WebView) findViewById(R.id.webview);
        this.progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        this.webView.setBackgroundResource(17170443);
        this.webView.setVerticalScrollBarEnabled(false);
        this.webView.setHorizontalScrollBarEnabled(false);
        this.webView.setWebViewClient(new KakaoWebViewClient());
        this.webView.setWebChromeClient(new KakaoWebChromeClient());
        this.webView.getSettings().setJavaScriptEnabled(true);
        this.webView.getSettings().setSaveFormData(KakaoSDK.getAdapter().getSessionConfig().isSaveFormData());
        this.webView.getSettings().setSavePassword(false);
        setProgressBarVisibility(0);
        this.webView.loadUrl(this.url, this.headers);
    }

    /* access modifiers changed from: private */
    public void setProgressBarVisibility(int i) {
        if (!isFinishing()) {
            this.progressBar.setVisibility(i);
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean isCameraAccessibleScheme(String str) {
        boolean z = false;
        if (str == null) {
            return false;
        }
        Uri parse = Uri.parse(str);
        if ("kakao".equals(parse.getScheme())) {
            if (StringSet.WEBVIEW_CAMERA_HOST.equals(parse.getHost())) {
                z = true;
            }
        }
        return z;
    }

    /* access modifiers changed from: 0000 */
    public String createCameraAccessibleScript(Uri uri) {
        String queryParameter = uri.getQueryParameter(StringSet.PARAM_CALLBACK);
        if (queryParameter == null) {
            return null;
        }
        return String.format(Locale.US, "%s(%d)", new Object[]{queryParameter, Integer.valueOf(ContextCompat.checkSelfPermission(this, "android.permission.READ_EXTERNAL_STORAGE") == 0 ? 1 : 0)});
    }

    /* access modifiers changed from: 0000 */
    public void processCameraAccessibleScript(String str) {
        if (str == null) {
            Logger.w("Callback function was not provide. Ignoring custom scheme (%s)", this.url);
        } else if (VERSION.SDK_INT >= 19) {
            this.webView.evaluateJavascript(str, new ValueCallback<String>() {
                public void onReceiveValue(String str) {
                    Logger.d("received value from javascript: %s", str);
                }
            });
        } else {
            this.webView.loadUrl(String.format(Locale.US, "javascript:%s", new Object[]{str}));
        }
    }

    /* access modifiers changed from: 0000 */
    public void openImageChooserActivity() {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType(StringSet.IMAGE_MIME_TYPE);
        startActivityForResult(Intent.createChooser(intent, getString(R.string.image_upload_chooser_text)), IMAGE_REQUEST_CODE);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (VERSION.SDK_INT >= 21) {
            onActivityResultForLollipop(i, i2, intent);
            return;
        }
        if (i == IMAGE_REQUEST_CODE && this.imageCallback != null) {
            this.imageCallback.onReceiveValue((i2 != -1 || intent == null) ? null : intent.getData());
            this.imageCallback = null;
        }
    }

    /* access modifiers changed from: 0000 */
    @RequiresApi(21)
    public void onActivityResultForLollipop(int i, int i2, Intent intent) {
        Uri[] uriArr;
        Uri[] uriArr2;
        if (i == IMAGE_REQUEST_CODE && this.lollipopImageCallback != null) {
            if (i2 == -1) {
                String dataString = intent.getDataString();
                ClipData clipData = intent.getClipData();
                if (clipData != null) {
                    uriArr2 = new Uri[clipData.getItemCount()];
                    for (int i3 = 0; i3 < clipData.getItemCount(); i3++) {
                        uriArr2[i3] = clipData.getItemAt(i3).getUri();
                    }
                } else {
                    uriArr2 = null;
                }
                uriArr = dataString != null ? new Uri[]{Uri.parse(dataString)} : uriArr2;
            } else {
                uriArr = null;
            }
            this.lollipopImageCallback.onReceiveValue(uriArr);
            this.lollipopImageCallback = null;
        }
    }
}
