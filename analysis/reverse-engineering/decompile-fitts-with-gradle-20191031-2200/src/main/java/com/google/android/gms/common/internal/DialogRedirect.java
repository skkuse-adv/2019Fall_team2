package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.google.android.gms.common.api.internal.LifecycleFragment;

public abstract class DialogRedirect implements OnClickListener {
    /* access modifiers changed from: protected */
    public abstract void redirect();

    public static DialogRedirect getInstance(Activity activity, Intent intent, int i) {
        return new zac(intent, activity, i);
    }

    public static DialogRedirect getInstance(@NonNull Fragment fragment, Intent intent, int i) {
        return new zad(intent, fragment, i);
    }

    public static DialogRedirect getInstance(@NonNull LifecycleFragment lifecycleFragment, Intent intent, int i) {
        return new zae(intent, lifecycleFragment, i);
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            redirect();
        } catch (ActivityNotFoundException unused) {
        } finally {
            dialogInterface.dismiss();
        }
    }
}
