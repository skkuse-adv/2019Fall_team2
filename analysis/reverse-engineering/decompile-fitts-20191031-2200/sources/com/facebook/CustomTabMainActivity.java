package com.facebook;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.facebook.internal.CustomTab;

public class CustomTabMainActivity extends Activity {
    public static final String EXTRA_CHROME_PACKAGE;
    public static final String EXTRA_PARAMS;
    public static final String EXTRA_URL;
    public static final String REFRESH_ACTION;
    private BroadcastReceiver redirectReceiver;
    private boolean shouldCloseCustomTab = true;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(CustomTabMainActivity.class.getSimpleName());
        sb.append(".extra_params");
        EXTRA_PARAMS = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(CustomTabMainActivity.class.getSimpleName());
        sb2.append(".extra_chromePackage");
        EXTRA_CHROME_PACKAGE = sb2.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(CustomTabMainActivity.class.getSimpleName());
        sb3.append(".extra_url");
        EXTRA_URL = sb3.toString();
        StringBuilder sb4 = new StringBuilder();
        sb4.append(CustomTabMainActivity.class.getSimpleName());
        sb4.append(".action_refresh");
        REFRESH_ACTION = sb4.toString();
    }

    public static final String getRedirectUrl() {
        StringBuilder sb = new StringBuilder();
        sb.append("fb");
        sb.append(FacebookSdk.getApplicationId());
        sb.append("://authorize");
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (CustomTabActivity.CUSTOM_TAB_REDIRECT_ACTION.equals(getIntent().getAction())) {
            setResult(0);
            finish();
            return;
        }
        if (bundle == null) {
            Bundle bundleExtra = getIntent().getBundleExtra(EXTRA_PARAMS);
            new CustomTab("oauth", bundleExtra).openCustomTab(this, getIntent().getStringExtra(EXTRA_CHROME_PACKAGE));
            this.shouldCloseCustomTab = false;
            this.redirectReceiver = new BroadcastReceiver() {
                public void onReceive(Context context, Intent intent) {
                    Intent intent2 = new Intent(CustomTabMainActivity.this, CustomTabMainActivity.class);
                    intent2.setAction(CustomTabMainActivity.REFRESH_ACTION);
                    String str = CustomTabMainActivity.EXTRA_URL;
                    intent2.putExtra(str, intent.getStringExtra(str));
                    intent2.addFlags(603979776);
                    CustomTabMainActivity.this.startActivity(intent2);
                }
            };
            LocalBroadcastManager.getInstance(this).registerReceiver(this.redirectReceiver, new IntentFilter(CustomTabActivity.CUSTOM_TAB_REDIRECT_ACTION));
        }
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (REFRESH_ACTION.equals(intent.getAction())) {
            LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent(CustomTabActivity.DESTROY_ACTION));
            sendResult(-1, intent);
        } else if (CustomTabActivity.CUSTOM_TAB_REDIRECT_ACTION.equals(intent.getAction())) {
            sendResult(-1, intent);
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (this.shouldCloseCustomTab) {
            sendResult(0, null);
        }
        this.shouldCloseCustomTab = true;
    }

    private void sendResult(int i, Intent intent) {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(this.redirectReceiver);
        if (intent != null) {
            setResult(i, intent);
        } else {
            setResult(i);
        }
        finish();
    }
}
