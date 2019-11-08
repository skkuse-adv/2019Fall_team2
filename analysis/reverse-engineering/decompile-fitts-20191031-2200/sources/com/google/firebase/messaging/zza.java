package com.google.firebase.messaging;

import android.annotation.TargetApi;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Color;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat.BigTextStyle;
import androidx.core.app.NotificationCompat.Builder;
import androidx.core.content.ContextCompat;
import com.google.android.gms.common.util.PlatformVersion;
import com.kakao.kakaolink.internal.KakaoTalkLinkProtocol;
import java.util.Arrays;
import java.util.Iterator;
import java.util.MissingFormatArgumentException;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;

public final class zza {
    private static final AtomicInteger zza = new AtomicInteger((int) SystemClock.elapsedRealtime());
    private final Context zzb;
    private final String zzc;
    private Bundle zzd;

    public zza(Context context, String str) {
        this.zzb = context;
        this.zzc = str;
    }

    public final zzc zza(Bundle bundle) {
        Uri uri;
        Intent intent;
        PendingIntent pendingIntent;
        Builder builder = new Builder(this.zzb, zzc(zza(bundle, "gcm.n.android_channel_id")));
        builder.setAutoCancel(true);
        builder.setContentTitle(zze(bundle));
        String zzd2 = zzd(bundle, "gcm.n.body");
        if (!TextUtils.isEmpty(zzd2)) {
            builder.setContentText(zzd2);
            builder.setStyle(new BigTextStyle().bigText(zzd2));
        }
        builder.setSmallIcon(zza(zza(bundle, "gcm.n.icon")));
        String zzc2 = zzc(bundle);
        PendingIntent pendingIntent2 = null;
        if (TextUtils.isEmpty(zzc2)) {
            uri = null;
        } else {
            if (!KakaoTalkLinkProtocol.VALIDATION_DEFAULT.equals(zzc2)) {
                if (this.zzb.getResources().getIdentifier(zzc2, "raw", this.zzc) != 0) {
                    String str = this.zzc;
                    StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 24 + String.valueOf(zzc2).length());
                    sb.append("android.resource://");
                    sb.append(str);
                    sb.append("/raw/");
                    sb.append(zzc2);
                    uri = Uri.parse(sb.toString());
                }
            }
            uri = RingtoneManager.getDefaultUri(2);
        }
        if (uri != null) {
            builder.setSound(uri);
        }
        String zza2 = zza(bundle, "gcm.n.click_action");
        if (!TextUtils.isEmpty(zza2)) {
            intent = new Intent(zza2);
            intent.setPackage(this.zzc);
            intent.setFlags(268435456);
        } else {
            Uri zzd3 = zzd(bundle);
            if (zzd3 != null) {
                intent = new Intent("android.intent.action.VIEW");
                intent.setPackage(this.zzc);
                intent.setData(zzd3);
            } else {
                intent = this.zzb.getPackageManager().getLaunchIntentForPackage(this.zzc);
            }
        }
        if (intent == null) {
            pendingIntent = null;
        } else {
            intent.addFlags(67108864);
            Bundle bundle2 = new Bundle(bundle);
            Iterator it = bundle2.keySet().iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                if (str2 != null && str2.startsWith("google.c.")) {
                    it.remove();
                }
            }
            intent.putExtras(bundle2);
            for (String str3 : bundle2.keySet()) {
                if (str3.startsWith("gcm.n.") || str3.startsWith("gcm.notification.")) {
                    intent.removeExtra(str3);
                }
            }
            pendingIntent = PendingIntent.getActivity(this.zzb, zza.incrementAndGet(), intent, 1073741824);
            if (zzf(bundle)) {
                Intent intent2 = new Intent("com.google.firebase.messaging.NOTIFICATION_OPEN");
                zza(intent2, bundle);
                intent2.putExtra("pending_intent", pendingIntent);
                pendingIntent = zza(zza.incrementAndGet(), intent2);
            }
        }
        builder.setContentIntent(pendingIntent);
        if (zzf(bundle)) {
            Intent intent3 = new Intent("com.google.firebase.messaging.NOTIFICATION_DISMISS");
            zza(intent3, bundle);
            pendingIntent2 = zza(zza.incrementAndGet(), intent3);
        }
        if (pendingIntent2 != null) {
            builder.setDeleteIntent(pendingIntent2);
        }
        Integer zzb2 = zzb(zza(bundle, "gcm.n.color"));
        if (zzb2 != null) {
            builder.setColor(zzb2.intValue());
        }
        String zza3 = zza(bundle, "gcm.n.tag");
        if (TextUtils.isEmpty(zza3)) {
            long uptimeMillis = SystemClock.uptimeMillis();
            StringBuilder sb2 = new StringBuilder(37);
            sb2.append("FCM-Notification:");
            sb2.append(uptimeMillis);
            zza3 = sb2.toString();
        }
        return new zzc(builder, zza3, 0);
    }

    @NonNull
    private final CharSequence zze(Bundle bundle) {
        String zzd2 = zzd(bundle, "gcm.n.title");
        if (!TextUtils.isEmpty(zzd2)) {
            return zzd2;
        }
        try {
            return zzb(0).loadLabel(this.zzb.getPackageManager());
        } catch (NameNotFoundException e) {
            String valueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 35);
            sb.append("Couldn't get own application info: ");
            sb.append(valueOf);
            sb.toString();
            return "";
        }
    }

    public static boolean zzb(Bundle bundle) {
        return "1".equals(zza(bundle, "gcm.n.e")) || zza(bundle, "gcm.n.icon") != null;
    }

    public static String zza(Bundle bundle, String str) {
        String string = bundle.getString(str);
        return string == null ? bundle.getString(str.replace("gcm.n.", "gcm.notification.")) : string;
    }

    public static Object[] zzb(Bundle bundle, String str) {
        String valueOf = String.valueOf(str);
        String str2 = "_loc_args";
        String zza2 = zza(bundle, str2.length() != 0 ? valueOf.concat(str2) : new String(valueOf));
        if (TextUtils.isEmpty(zza2)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(zza2);
            Object[] objArr = new String[jSONArray.length()];
            for (int i = 0; i < objArr.length; i++) {
                objArr[i] = jSONArray.opt(i);
            }
            return objArr;
        } catch (JSONException unused) {
            String valueOf2 = String.valueOf(str);
            String substring = (str2.length() != 0 ? valueOf2.concat(str2) : new String(valueOf2)).substring(6);
            StringBuilder sb = new StringBuilder(String.valueOf(substring).length() + 41 + String.valueOf(zza2).length());
            sb.append("Malformed ");
            sb.append(substring);
            sb.append(": ");
            sb.append(zza2);
            sb.append("  Default value will be used.");
            sb.toString();
            return null;
        }
    }

    private final String zzd(Bundle bundle, String str) {
        String zza2 = zza(bundle, str);
        if (!TextUtils.isEmpty(zza2)) {
            return zza2;
        }
        return zze(bundle, str);
    }

    public static String zzc(Bundle bundle, String str) {
        String valueOf = String.valueOf(str);
        String str2 = "_loc_key";
        return zza(bundle, str2.length() != 0 ? valueOf.concat(str2) : new String(valueOf));
    }

    private final String zze(Bundle bundle, String str) {
        String zzc2 = zzc(bundle, str);
        if (TextUtils.isEmpty(zzc2)) {
            return null;
        }
        Resources resources = this.zzb.getResources();
        int identifier = resources.getIdentifier(zzc2, "string", this.zzc);
        String str2 = " Default value will be used.";
        if (identifier == 0) {
            String valueOf = String.valueOf(str);
            String str3 = "_loc_key";
            String substring = (str3.length() != 0 ? valueOf.concat(str3) : new String(valueOf)).substring(6);
            StringBuilder sb = new StringBuilder(String.valueOf(substring).length() + 49 + String.valueOf(str).length());
            sb.append(substring);
            sb.append(" resource not found: ");
            sb.append(str);
            sb.append(str2);
            sb.toString();
            return null;
        }
        Object[] zzb2 = zzb(bundle, str);
        if (zzb2 == null) {
            return resources.getString(identifier);
        }
        try {
            return resources.getString(identifier, zzb2);
        } catch (MissingFormatArgumentException unused) {
            String arrays = Arrays.toString(zzb2);
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 58 + String.valueOf(arrays).length());
            sb2.append("Missing format argument for ");
            sb2.append(str);
            sb2.append(": ");
            sb2.append(arrays);
            sb2.append(str2);
            sb2.toString();
            return null;
        }
    }

    @TargetApi(26)
    private final boolean zza(int i) {
        if (VERSION.SDK_INT != 26) {
            return true;
        }
        try {
            if (!(this.zzb.getResources().getDrawable(i, null) instanceof AdaptiveIconDrawable)) {
                return true;
            }
            StringBuilder sb = new StringBuilder(77);
            sb.append("Adaptive icons cannot be used in notifications. Ignoring icon id: ");
            sb.append(i);
            sb.toString();
            return false;
        } catch (NotFoundException unused) {
            StringBuilder sb2 = new StringBuilder(66);
            sb2.append("Couldn't find resource ");
            sb2.append(i);
            sb2.append(", treating it as an invalid icon");
            sb2.toString();
            return false;
        }
    }

    private final int zza(String str) {
        if (!TextUtils.isEmpty(str)) {
            Resources resources = this.zzb.getResources();
            int identifier = resources.getIdentifier(str, "drawable", this.zzc);
            if (identifier != 0 && zza(identifier)) {
                return identifier;
            }
            int identifier2 = resources.getIdentifier(str, "mipmap", this.zzc);
            if (identifier2 != 0 && zza(identifier2)) {
                return identifier2;
            }
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 61);
            sb.append("Icon resource ");
            sb.append(str);
            sb.append(" not found. Notification will use default icon.");
            sb.toString();
        }
        int i = zza().getInt("com.google.firebase.messaging.default_notification_icon", 0);
        if (i == 0 || !zza(i)) {
            try {
                i = zzb(0).icon;
            } catch (NameNotFoundException e) {
                String valueOf = String.valueOf(e);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf).length() + 35);
                sb2.append("Couldn't get own application info: ");
                sb2.append(valueOf);
                sb2.toString();
            }
        }
        if (i == 0 || !zza(i)) {
            i = 17301651;
        }
        return i;
    }

    private final Integer zzb(String str) {
        if (VERSION.SDK_INT < 21) {
            return null;
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.valueOf(Color.parseColor(str));
            } catch (IllegalArgumentException unused) {
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 54);
                sb.append("Color ");
                sb.append(str);
                sb.append(" not valid. Notification will use default color.");
                sb.toString();
            }
        }
        int i = zza().getInt("com.google.firebase.messaging.default_notification_color", 0);
        if (i != 0) {
            try {
                return Integer.valueOf(ContextCompat.getColor(this.zzb, i));
            } catch (NotFoundException unused2) {
            }
        }
        return null;
    }

    public static String zzc(Bundle bundle) {
        String zza2 = zza(bundle, "gcm.n.sound2");
        return TextUtils.isEmpty(zza2) ? zza(bundle, "gcm.n.sound") : zza2;
    }

    @Nullable
    static Uri zzd(@NonNull Bundle bundle) {
        String zza2 = zza(bundle, "gcm.n.link_android");
        if (TextUtils.isEmpty(zza2)) {
            zza2 = zza(bundle, "gcm.n.link");
        }
        if (!TextUtils.isEmpty(zza2)) {
            return Uri.parse(zza2);
        }
        return null;
    }

    private final synchronized Bundle zza() {
        if (this.zzd != null) {
            return this.zzd;
        }
        try {
            ApplicationInfo zzb2 = zzb(128);
            if (!(zzb2 == null || zzb2.metaData == null)) {
                this.zzd = zzb2.metaData;
                return this.zzd;
            }
        } catch (NameNotFoundException e) {
            String valueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 35);
            sb.append("Couldn't get own application info: ");
            sb.append(valueOf);
            sb.toString();
        }
        return Bundle.EMPTY;
    }

    @TargetApi(26)
    private final String zzc(String str) {
        if (!PlatformVersion.isAtLeastO()) {
            return null;
        }
        int i = 0;
        try {
            i = zzb(i).targetSdkVersion;
        } catch (NameNotFoundException unused) {
        }
        if (i < 26) {
            return null;
        }
        NotificationManager notificationManager = (NotificationManager) this.zzb.getSystemService(NotificationManager.class);
        if (!TextUtils.isEmpty(str)) {
            if (notificationManager.getNotificationChannel(str) != null) {
                return str;
            }
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 122);
            sb.append("Notification Channel requested (");
            sb.append(str);
            sb.append(") has not been created by the app. Manifest configuration, or default, value will be used.");
            sb.toString();
        }
        String string = zza().getString("com.google.firebase.messaging.default_notification_channel_id");
        if (!TextUtils.isEmpty(string) && notificationManager.getNotificationChannel(string) != null) {
            return string;
        }
        String str2 = "fcm_fallback_notification_channel";
        if (notificationManager.getNotificationChannel(str2) == null) {
            notificationManager.createNotificationChannel(new NotificationChannel(str2, this.zzb.getString(this.zzb.getResources().getIdentifier("fcm_fallback_notification_channel_label", "string", this.zzc)), 3));
        }
        return str2;
    }

    private final ApplicationInfo zzb(int i) throws NameNotFoundException {
        return this.zzb.getPackageManager().getApplicationInfo(this.zzc, i);
    }

    private static void zza(Intent intent, Bundle bundle) {
        for (String str : bundle.keySet()) {
            if (str.startsWith("google.c.a.") || str.equals("from")) {
                intent.putExtra(str, bundle.getString(str));
            }
        }
    }

    private final PendingIntent zza(int i, Intent intent) {
        return PendingIntent.getBroadcast(this.zzb, i, new Intent("com.google.firebase.MESSAGING_EVENT").setComponent(new ComponentName(this.zzb, "com.google.firebase.iid.FirebaseInstanceIdReceiver")).putExtra("wrapped_intent", intent), 1073741824);
    }

    private static boolean zzf(Bundle bundle) {
        if (bundle != null) {
            if ("1".equals(bundle.getString("google.c.a.e"))) {
                return true;
            }
        }
        return false;
    }
}
