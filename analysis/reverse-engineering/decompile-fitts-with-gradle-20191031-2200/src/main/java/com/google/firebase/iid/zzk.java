package com.google.firebase.iid;

import android.os.Build.VERSION;
import android.os.Bundle;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.LibraryVersion;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.FirebaseApp;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.io.IOException;
import java.util.concurrent.Executor;

final class zzk {
    private final FirebaseApp zza;
    private final zzaf zzb;
    private final zzal zzc;
    private final Executor zzd;
    private final UserAgentPublisher zze;

    zzk(FirebaseApp firebaseApp, zzaf zzaf, Executor executor, UserAgentPublisher userAgentPublisher) {
        this(firebaseApp, zzaf, executor, new zzal(firebaseApp.getApplicationContext(), zzaf), userAgentPublisher);
    }

    @VisibleForTesting
    private zzk(FirebaseApp firebaseApp, zzaf zzaf, Executor executor, zzal zzal, UserAgentPublisher userAgentPublisher) {
        this.zza = firebaseApp;
        this.zzb = zzaf;
        this.zzc = zzal;
        this.zzd = executor;
        this.zze = userAgentPublisher;
    }

    public final Task<String> zza(String str, String str2, String str3) {
        return zzb(zza(str, str2, str3, new Bundle()));
    }

    public final Task<Void> zzb(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        bundle.putString("delete", "1");
        return zza(zzb(zza(str, str2, str3, bundle)));
    }

    public final Task<Void> zza(String str) {
        Bundle bundle = new Bundle();
        String str2 = "delete";
        bundle.putString("iid-operation", str2);
        bundle.putString(str2, "1");
        String str3 = "*";
        return zza(zzb(zza(str, str3, str3, bundle)));
    }

    public final Task<Void> zzc(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        String valueOf = String.valueOf(str3);
        String str4 = "/topics/";
        bundle.putString("gcm.topic", valueOf.length() != 0 ? str4.concat(valueOf) : new String(str4));
        String valueOf2 = String.valueOf(str3);
        return zza(zzb(zza(str, str2, valueOf2.length() != 0 ? str4.concat(valueOf2) : new String(str4), bundle)));
    }

    public final Task<Void> zzd(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        String valueOf = String.valueOf(str3);
        String str4 = "/topics/";
        bundle.putString("gcm.topic", valueOf.length() != 0 ? str4.concat(valueOf) : new String(str4));
        bundle.putString("delete", "1");
        String valueOf2 = String.valueOf(str3);
        return zza(zzb(zza(str, str2, valueOf2.length() != 0 ? str4.concat(valueOf2) : new String(str4), bundle)));
    }

    private final Task<Bundle> zza(String str, String str2, String str3, Bundle bundle) {
        bundle.putString("scope", str3);
        bundle.putString("sender", str2);
        bundle.putString("subtype", str2);
        bundle.putString("appid", str);
        bundle.putString("gmp_app_id", this.zza.getOptions().getApplicationId());
        bundle.putString("gmsv", Integer.toString(this.zzb.zzd()));
        bundle.putString("osv", Integer.toString(VERSION.SDK_INT));
        bundle.putString("app_ver", this.zzb.zzb());
        bundle.putString("app_ver_name", this.zzb.zzc());
        String valueOf = String.valueOf(LibraryVersion.getInstance().getVersion("firebase-iid"));
        String str4 = "fiid-";
        bundle.putString("cliv", valueOf.length() != 0 ? str4.concat(valueOf) : new String(str4));
        bundle.putString("Firebase-Client", this.zze.getUserAgent());
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.zzd.execute(new zzm(this, bundle, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    /* access modifiers changed from: private */
    public static String zza(Bundle bundle) throws IOException {
        String str = "SERVICE_NOT_AVAILABLE";
        if (bundle != null) {
            String string = bundle.getString("registration_id");
            if (string != null) {
                return string;
            }
            String string2 = bundle.getString("unregistered");
            if (string2 != null) {
                return string2;
            }
            String string3 = bundle.getString("error");
            if ("RST".equals(string3)) {
                throw new IOException("INSTANCE_ID_RESET");
            } else if (string3 != null) {
                throw new IOException(string3);
            } else {
                String valueOf = String.valueOf(bundle);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 21);
                sb.append("Unexpected response: ");
                sb.append(valueOf);
                sb.toString();
                new Throwable();
                throw new IOException(str);
            }
        } else {
            throw new IOException(str);
        }
    }

    private final <T> Task<Void> zza(Task<T> task) {
        return task.continueWith(zzc.zza(), new zzl(this));
    }

    private final Task<String> zzb(Task<Bundle> task) {
        return task.continueWith(this.zzd, new zzo(this));
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zza(Bundle bundle, TaskCompletionSource taskCompletionSource) {
        try {
            taskCompletionSource.setResult(this.zzc.zza(bundle));
        } catch (IOException e) {
            taskCompletionSource.setException(e);
        }
    }
}
