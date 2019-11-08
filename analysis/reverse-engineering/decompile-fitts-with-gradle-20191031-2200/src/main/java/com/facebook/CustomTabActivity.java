package com.facebook;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

public class CustomTabActivity extends Activity {
    public static final String CUSTOM_TAB_REDIRECT_ACTION;
    public static final String DESTROY_ACTION;
    private BroadcastReceiver closeReceiver;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(CustomTabActivity.class.getSimpleName());
        sb.append(".action_customTabRedirect");
        CUSTOM_TAB_REDIRECT_ACTION = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(CustomTabActivity.class.getSimpleName());
        sb2.append(".action_destroy");
        DESTROY_ACTION = sb2.toString();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = new Intent(this, CustomTabMainActivity.class);
        intent.setAction(CUSTOM_TAB_REDIRECT_ACTION);
        intent.putExtra(CustomTabMainActivity.EXTRA_URL, getIntent().getDataString());
        intent.addFlags(603979776);
        startActivityForResult(intent, 2);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == 0) {
            Intent intent2 = new Intent(CUSTOM_TAB_REDIRECT_ACTION);
            intent2.putExtra(CustomTabMainActivity.EXTRA_URL, getIntent().getDataString());
            LocalBroadcastManager.getInstance(this).sendBroadcast(intent2);
            this.closeReceiver = new BroadcastReceiver() {
                public void onReceive(Context context, Intent intent) {
                    CustomTabActivity.this.finish();
                }
            };
            LocalBroadcastManager.getInstance(this).registerReceiver(this.closeReceiver, new IntentFilter(DESTROY_ACTION));
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(this.closeReceiver);
        super.onDestroy();
    }
}
