package com.gun0912.tedpermission;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog.Builder;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import com.gun0912.tedpermission.util.ObjectUtils;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;

public class TedPermissionActivity extends AppCompatActivity {
    public static final String EXTRA_DENIED_DIALOG_CLOSE_TEXT = "denied_dialog_close_text";
    public static final String EXTRA_DENY_MESSAGE = "deny_message";
    public static final String EXTRA_DENY_TITLE = "deny_title";
    public static final String EXTRA_PACKAGE_NAME = "package_name";
    public static final String EXTRA_PERMISSIONS = "permissions";
    public static final String EXTRA_RATIONALE_CONFIRM_TEXT = "rationale_confirm_text";
    public static final String EXTRA_RATIONALE_MESSAGE = "rationale_message";
    public static final String EXTRA_RATIONALE_TITLE = "rationale_title";
    public static final String EXTRA_SCREEN_ORIENTATION = "screen_orientation";
    public static final String EXTRA_SETTING_BUTTON = "setting_button";
    public static final String EXTRA_SETTING_BUTTON_TEXT = "setting_button_text";
    public static final int REQ_CODE_PERMISSION_REQUEST = 10;
    public static final int REQ_CODE_SYSTEM_ALERT_WINDOW_PERMISSION_REQUEST = 30;
    public static final int REQ_CODE_SYSTEM_ALERT_WINDOW_PERMISSION_REQUEST_SETTING = 31;
    private static Deque<PermissionListener> permissionListenerStack;
    String deniedCloseButtonText;
    CharSequence denyMessage;
    CharSequence denyTitle;
    boolean hasSettingButton;
    boolean isShownRationaleDialog;
    String packageName;
    String[] permissions;
    String rationaleConfirmText;
    CharSequence rationaleTitle;
    CharSequence rationale_message;
    int requestedOrientation;
    String settingButtonText;

    public static void startActivity(Context context, Intent intent, PermissionListener permissionListener) {
        if (permissionListenerStack == null) {
            permissionListenerStack = new ArrayDeque();
        }
        permissionListenerStack.push(permissionListener);
        context.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        overridePendingTransition(0, 0);
        super.onCreate(bundle);
        getWindow().addFlags(16);
        setupFromSavedInstanceState(bundle);
        if (needWindowPermission()) {
            requestWindowPermission();
        } else {
            checkPermissions(false);
        }
        setRequestedOrientation(this.requestedOrientation);
    }

    private void setupFromSavedInstanceState(Bundle bundle) {
        String str = EXTRA_SCREEN_ORIENTATION;
        String str2 = EXTRA_SETTING_BUTTON_TEXT;
        String str3 = EXTRA_DENIED_DIALOG_CLOSE_TEXT;
        String str4 = EXTRA_RATIONALE_CONFIRM_TEXT;
        String str5 = EXTRA_SETTING_BUTTON;
        String str6 = EXTRA_PACKAGE_NAME;
        String str7 = EXTRA_DENY_MESSAGE;
        String str8 = EXTRA_DENY_TITLE;
        String str9 = EXTRA_RATIONALE_MESSAGE;
        String str10 = EXTRA_RATIONALE_TITLE;
        String str11 = "permissions";
        if (bundle != null) {
            this.permissions = bundle.getStringArray(str11);
            this.rationaleTitle = bundle.getCharSequence(str10);
            this.rationale_message = bundle.getCharSequence(str9);
            this.denyTitle = bundle.getCharSequence(str8);
            this.denyMessage = bundle.getCharSequence(str7);
            this.packageName = bundle.getString(str6);
            this.hasSettingButton = bundle.getBoolean(str5, true);
            this.rationaleConfirmText = bundle.getString(str4);
            this.deniedCloseButtonText = bundle.getString(str3);
            this.settingButtonText = bundle.getString(str2);
            this.requestedOrientation = bundle.getInt(str);
            return;
        }
        Intent intent = getIntent();
        this.permissions = intent.getStringArrayExtra(str11);
        this.rationaleTitle = intent.getCharSequenceExtra(str10);
        this.rationale_message = intent.getCharSequenceExtra(str9);
        this.denyTitle = intent.getCharSequenceExtra(str8);
        this.denyMessage = intent.getCharSequenceExtra(str7);
        this.packageName = intent.getStringExtra(str6);
        this.hasSettingButton = intent.getBooleanExtra(str5, true);
        this.rationaleConfirmText = intent.getStringExtra(str4);
        this.deniedCloseButtonText = intent.getStringExtra(str3);
        this.settingButtonText = intent.getStringExtra(str2);
        this.requestedOrientation = intent.getIntExtra(str, -1);
    }

    private boolean needWindowPermission() {
        for (String equals : this.permissions) {
            if (equals.equals("android.permission.SYSTEM_ALERT_WINDOW")) {
                return !hasWindowPermission();
            }
        }
        return false;
    }

    @TargetApi(23)
    private boolean hasWindowPermission() {
        return Settings.canDrawOverlays(getApplicationContext());
    }

    @TargetApi(23)
    private void requestWindowPermission() {
        String str = "android.settings.action.MANAGE_OVERLAY_PERMISSION";
        final Intent intent = new Intent(str, Uri.fromParts("package", this.packageName, null));
        if (!TextUtils.isEmpty(this.rationale_message)) {
            new Builder(this, R$style.Theme_AppCompat_Light_Dialog_Alert).setMessage(this.rationale_message).setCancelable(false).setNegativeButton((CharSequence) this.rationaleConfirmText, (OnClickListener) new OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    TedPermissionActivity.this.startActivityForResult(intent, 30);
                }
            }).show();
            this.isShownRationaleDialog = true;
            return;
        }
        startActivityForResult(intent, 30);
    }

    /* access modifiers changed from: private */
    public void checkPermissions(boolean z) {
        String str;
        ArrayList arrayList = new ArrayList();
        String[] strArr = this.permissions;
        int length = strArr.length;
        int i = 0;
        while (true) {
            str = "android.permission.SYSTEM_ALERT_WINDOW";
            if (i >= length) {
                break;
            }
            String str2 = strArr[i];
            if (str2.equals(str)) {
                if (!hasWindowPermission()) {
                    arrayList.add(str2);
                }
            } else if (TedPermissionBase.isDenied(this, str2)) {
                arrayList.add(str2);
            }
            i++;
        }
        if (arrayList.isEmpty()) {
            permissionResult(null);
        } else if (z) {
            permissionResult(arrayList);
        } else if (arrayList.size() == 1 && arrayList.contains(str)) {
            permissionResult(arrayList);
        } else if (this.isShownRationaleDialog || TextUtils.isEmpty(this.rationale_message)) {
            requestPermissions(arrayList);
        } else {
            showRationaleDialog(arrayList);
        }
    }

    /* access modifiers changed from: private */
    public void permissionResult(ArrayList<String> arrayList) {
        StringBuilder sb = new StringBuilder();
        sb.append("permissionResult(): ");
        sb.append(arrayList);
        sb.toString();
        Deque<PermissionListener> deque = permissionListenerStack;
        if (deque != null) {
            PermissionListener permissionListener = (PermissionListener) deque.pop();
            if (ObjectUtils.isEmpty(arrayList)) {
                permissionListener.onPermissionGranted();
            } else {
                permissionListener.onPermissionDenied(arrayList);
            }
            if (permissionListenerStack.size() == 0) {
                permissionListenerStack = null;
            }
        }
        finish();
        overridePendingTransition(0, 0);
    }

    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    private void showRationaleDialog(final ArrayList<String> arrayList) {
        new Builder(this, R$style.Theme_AppCompat_Light_Dialog_Alert).setTitle(this.rationaleTitle).setMessage(this.rationale_message).setCancelable(false).setNegativeButton((CharSequence) this.rationaleConfirmText, (OnClickListener) new OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                TedPermissionActivity.this.requestPermissions(arrayList);
            }
        }).show();
        this.isShownRationaleDialog = true;
    }

    public void requestPermissions(ArrayList<String> arrayList) {
        ActivityCompat.requestPermissions(this, (String[]) arrayList.toArray(new String[arrayList.size()]), 10);
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putStringArray("permissions", this.permissions);
        bundle.putCharSequence(EXTRA_RATIONALE_TITLE, this.rationaleTitle);
        bundle.putCharSequence(EXTRA_RATIONALE_MESSAGE, this.rationale_message);
        bundle.putCharSequence(EXTRA_DENY_TITLE, this.denyTitle);
        bundle.putCharSequence(EXTRA_DENY_MESSAGE, this.denyMessage);
        bundle.putString(EXTRA_PACKAGE_NAME, this.packageName);
        bundle.putBoolean(EXTRA_SETTING_BUTTON, this.hasSettingButton);
        bundle.putString(EXTRA_DENIED_DIALOG_CLOSE_TEXT, this.deniedCloseButtonText);
        bundle.putString(EXTRA_RATIONALE_CONFIRM_TEXT, this.rationaleConfirmText);
        bundle.putString(EXTRA_SETTING_BUTTON_TEXT, this.settingButtonText);
        super.onSaveInstanceState(bundle);
    }

    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        ArrayList deniedPermissions = TedPermissionBase.getDeniedPermissions(this, strArr);
        if (deniedPermissions.isEmpty()) {
            permissionResult(null);
        } else {
            showPermissionDenyDialog(deniedPermissions);
        }
    }

    public void showPermissionDenyDialog(final ArrayList<String> arrayList) {
        if (TextUtils.isEmpty(this.denyMessage)) {
            permissionResult(arrayList);
            return;
        }
        Builder builder = new Builder(this, R$style.Theme_AppCompat_Light_Dialog_Alert);
        builder.setTitle(this.denyTitle).setMessage(this.denyMessage).setCancelable(false).setNegativeButton((CharSequence) this.deniedCloseButtonText, (OnClickListener) new OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                TedPermissionActivity.this.permissionResult(arrayList);
            }
        });
        if (this.hasSettingButton) {
            if (TextUtils.isEmpty(this.settingButtonText)) {
                this.settingButtonText = getString(R$string.tedpermission_setting);
            }
            builder.setPositiveButton((CharSequence) this.settingButtonText, (OnClickListener) new OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    TedPermissionBase.startSettingActivityForResult((Activity) TedPermissionActivity.this);
                }
            });
        }
        builder.show();
    }

    public boolean shouldShowRequestPermissionRationale(ArrayList<String> arrayList) {
        if (arrayList == null) {
            return false;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (!ActivityCompat.shouldShowRequestPermissionRationale(this, (String) it.next())) {
                return false;
            }
        }
        return true;
    }

    public void showWindowPermissionDenyDialog() {
        Builder builder = new Builder(this, R$style.Theme_AppCompat_Light_Dialog_Alert);
        builder.setMessage(this.denyMessage).setCancelable(false).setNegativeButton((CharSequence) this.deniedCloseButtonText, (OnClickListener) new OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                TedPermissionActivity.this.checkPermissions(false);
            }
        });
        if (this.hasSettingButton) {
            if (TextUtils.isEmpty(this.settingButtonText)) {
                this.settingButtonText = getString(R$string.tedpermission_setting);
            }
            builder.setPositiveButton((CharSequence) this.settingButtonText, (OnClickListener) new OnClickListener() {
                @TargetApi(23)
                public void onClick(DialogInterface dialogInterface, int i) {
                    String str = "android.settings.action.MANAGE_OVERLAY_PERMISSION";
                    TedPermissionActivity.this.startActivityForResult(new Intent(str, Uri.fromParts("package", TedPermissionActivity.this.packageName, null)), 31);
                }
            });
        }
        builder.show();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i != 30) {
            if (i == 31) {
                checkPermissions(false);
            } else if (i != 2000) {
                super.onActivityResult(i, i2, intent);
            } else {
                checkPermissions(true);
            }
        } else if (hasWindowPermission() || TextUtils.isEmpty(this.denyMessage)) {
            checkPermissions(false);
        } else {
            showWindowPermissionDenyDialog();
        }
    }
}
