package com.google.firebase.messaging;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.iid.FirebaseInstanceId;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import java.util.regex.Pattern;

public class FirebaseMessaging {
    public static final String INSTANCE_ID_SCOPE = "FCM";
    private static final Pattern zza = Pattern.compile("[a-zA-Z0-9-_.~%]{1,900}");
    private static FirebaseMessaging zzb;
    private final FirebaseInstanceId zzc;

    public static synchronized FirebaseMessaging getInstance() {
        FirebaseMessaging firebaseMessaging;
        synchronized (FirebaseMessaging.class) {
            if (zzb == null) {
                zzb = new FirebaseMessaging(FirebaseInstanceId.getInstance());
            }
            firebaseMessaging = zzb;
        }
        return firebaseMessaging;
    }

    private FirebaseMessaging(FirebaseInstanceId firebaseInstanceId) {
        this.zzc = firebaseInstanceId;
    }

    public boolean isAutoInitEnabled() {
        return this.zzc.zzh();
    }

    public void setAutoInitEnabled(boolean z) {
        this.zzc.zzb(z);
    }

    public Task<Void> subscribeToTopic(String str) {
        if (str != null && str.startsWith("/topics/")) {
            str = str.substring(8);
        }
        if (str == null || !zza.matcher(str).matches()) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 78);
            sb.append("Invalid topic name: ");
            sb.append(str);
            sb.append(" does not match the allowed format [a-zA-Z0-9-_.~%]{1,900}");
            throw new IllegalArgumentException(sb.toString());
        }
        FirebaseInstanceId firebaseInstanceId = this.zzc;
        String str2 = "S!";
        String valueOf = String.valueOf(str);
        return firebaseInstanceId.zza(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
    }

    public Task<Void> unsubscribeFromTopic(String str) {
        if (str != null && str.startsWith("/topics/")) {
            str = str.substring(8);
        }
        if (str == null || !zza.matcher(str).matches()) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 78);
            sb.append("Invalid topic name: ");
            sb.append(str);
            sb.append(" does not match the allowed format [a-zA-Z0-9-_.~%]{1,900}");
            throw new IllegalArgumentException(sb.toString());
        }
        FirebaseInstanceId firebaseInstanceId = this.zzc;
        String str2 = "U!";
        String valueOf = String.valueOf(str);
        return firebaseInstanceId.zza(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
    }

    public void send(RemoteMessage remoteMessage) {
        if (!TextUtils.isEmpty(remoteMessage.getTo())) {
            Context applicationContext = FirebaseApp.getInstance().getApplicationContext();
            Intent intent = new Intent("com.google.android.gcm.intent.SEND");
            Intent intent2 = new Intent();
            intent2.setPackage("com.google.example.invalidpackage");
            intent.putExtra(SettingsJsonConstants.APP_KEY, PendingIntent.getBroadcast(applicationContext, 0, intent2, 0));
            intent.setPackage("com.google.android.gms");
            intent.putExtras(remoteMessage.zza);
            applicationContext.sendOrderedBroadcast(intent, "com.google.android.gtalkservice.permission.GTALK_SERVICE");
            return;
        }
        throw new IllegalArgumentException("Missing 'to'");
    }
}
