package com.google.firebase.iid;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.util.Log;
import androidx.collection.SimpleArrayMap;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.iid.zzd.zza;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class zzal {
    private static int zza;
    private static PendingIntent zzb;
    private final SimpleArrayMap<String, TaskCompletionSource<Bundle>> zzc = new SimpleArrayMap<>();
    private final Context zzd;
    private final zzaf zze;
    private Messenger zzf;
    private Messenger zzg;
    private zzd zzh;

    public zzal(Context context, zzaf zzaf) {
        this.zzd = context;
        this.zze = zzaf;
        this.zzf = new Messenger(new zzao(this, Looper.getMainLooper()));
    }

    /* access modifiers changed from: private */
    public final void zza(Message message) {
        if (message != null) {
            Object obj = message.obj;
            if (obj instanceof Intent) {
                Intent intent = (Intent) obj;
                intent.setExtrasClassLoader(new zza());
                if (intent.hasExtra("google.messenger")) {
                    Parcelable parcelableExtra = intent.getParcelableExtra("google.messenger");
                    if (parcelableExtra instanceof zzd) {
                        this.zzh = (zzd) parcelableExtra;
                    }
                    if (parcelableExtra instanceof Messenger) {
                        this.zzg = (Messenger) parcelableExtra;
                    }
                }
                Intent intent2 = (Intent) message.obj;
                String action = intent2.getAction();
                if (!"com.google.android.c2dm.intent.REGISTRATION".equals(action)) {
                    if (Log.isLoggable("FirebaseInstanceId", 3)) {
                        String str = "Unexpected response action: ";
                        String valueOf = String.valueOf(action);
                        if (valueOf.length() != 0) {
                            str.concat(valueOf);
                        } else {
                            new String(str);
                        }
                    }
                    return;
                }
                String stringExtra = intent2.getStringExtra("registration_id");
                if (stringExtra == null) {
                    stringExtra = intent2.getStringExtra("unregistered");
                }
                if (stringExtra == null) {
                    String stringExtra2 = intent2.getStringExtra("error");
                    if (stringExtra2 == null) {
                        String valueOf2 = String.valueOf(intent2.getExtras());
                        StringBuilder sb = new StringBuilder(String.valueOf(valueOf2).length() + 49);
                        sb.append("Unexpected response, no error or registration id ");
                        sb.append(valueOf2);
                        sb.toString();
                    } else {
                        if (Log.isLoggable("FirebaseInstanceId", 3)) {
                            String str2 = "Received InstanceID error ";
                            String valueOf3 = String.valueOf(stringExtra2);
                            if (valueOf3.length() != 0) {
                                str2.concat(valueOf3);
                            } else {
                                new String(str2);
                            }
                        }
                        if (stringExtra2.startsWith("|")) {
                            String[] split = stringExtra2.split("\\|");
                            if (split.length > 2) {
                                if ("ID".equals(split[1])) {
                                    String str3 = split[2];
                                    String str4 = split[3];
                                    if (str4.startsWith(":")) {
                                        str4 = str4.substring(1);
                                    }
                                    zza(str3, intent2.putExtra("error", str4).getExtras());
                                }
                            }
                            String str5 = "Unexpected structured response ";
                            String valueOf4 = String.valueOf(stringExtra2);
                            if (valueOf4.length() != 0) {
                                str5.concat(valueOf4);
                            } else {
                                new String(str5);
                            }
                        } else {
                            synchronized (this.zzc) {
                                for (int i = 0; i < this.zzc.size(); i++) {
                                    zza((String) this.zzc.keyAt(i), intent2.getExtras());
                                }
                            }
                        }
                    }
                } else {
                    Matcher matcher = Pattern.compile("\\|ID\\|([^|]+)\\|:?+(.*)").matcher(stringExtra);
                    if (!matcher.matches()) {
                        if (Log.isLoggable("FirebaseInstanceId", 3)) {
                            String str6 = "Unexpected response string: ";
                            String valueOf5 = String.valueOf(stringExtra);
                            if (valueOf5.length() != 0) {
                                str6.concat(valueOf5);
                            } else {
                                new String(str6);
                            }
                        }
                        return;
                    }
                    String group = matcher.group(1);
                    String group2 = matcher.group(2);
                    Bundle extras = intent2.getExtras();
                    extras.putString("registration_id", group2);
                    zza(group, extras);
                }
            }
        }
    }

    private static synchronized void zza(Context context, Intent intent) {
        synchronized (zzal.class) {
            if (zzb == null) {
                Intent intent2 = new Intent();
                intent2.setPackage("com.google.example.invalidpackage");
                zzb = PendingIntent.getBroadcast(context, 0, intent2, 0);
            }
            intent.putExtra(SettingsJsonConstants.APP_KEY, zzb);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0023, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zza(java.lang.String r3, android.os.Bundle r4) {
        /*
            r2 = this;
            androidx.collection.SimpleArrayMap<java.lang.String, com.google.android.gms.tasks.TaskCompletionSource<android.os.Bundle>> r0 = r2.zzc
            monitor-enter(r0)
            androidx.collection.SimpleArrayMap<java.lang.String, com.google.android.gms.tasks.TaskCompletionSource<android.os.Bundle>> r1 = r2.zzc     // Catch:{ all -> 0x0029 }
            java.lang.Object r1 = r1.remove(r3)     // Catch:{ all -> 0x0029 }
            com.google.android.gms.tasks.TaskCompletionSource r1 = (com.google.android.gms.tasks.TaskCompletionSource) r1     // Catch:{ all -> 0x0029 }
            if (r1 != 0) goto L_0x0024
            java.lang.String r4 = "Missing callback for "
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x0029 }
            int r1 = r3.length()     // Catch:{ all -> 0x0029 }
            if (r1 == 0) goto L_0x001d
            r4.concat(r3)     // Catch:{ all -> 0x0029 }
            goto L_0x0022
        L_0x001d:
            java.lang.String r3 = new java.lang.String     // Catch:{ all -> 0x0029 }
            r3.<init>(r4)     // Catch:{ all -> 0x0029 }
        L_0x0022:
            monitor-exit(r0)     // Catch:{ all -> 0x0029 }
            return
        L_0x0024:
            r1.setResult(r4)     // Catch:{ all -> 0x0029 }
            monitor-exit(r0)     // Catch:{ all -> 0x0029 }
            return
        L_0x0029:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0029 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.zzal.zza(java.lang.String, android.os.Bundle):void");
    }

    /* access modifiers changed from: 0000 */
    public final Bundle zza(Bundle bundle) throws IOException {
        if (this.zze.zzd() < 12000000) {
            return zzb(bundle);
        }
        try {
            return (Bundle) Tasks.await(zzu.zza(this.zzd).zzb(1, bundle));
        } catch (InterruptedException | ExecutionException e) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String valueOf = String.valueOf(e);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 22);
                sb.append("Error making request: ");
                sb.append(valueOf);
                sb.toString();
            }
            if (!(e.getCause() instanceof zzad) || ((zzad) e.getCause()).zza() != 4) {
                return null;
            }
            return zzb(bundle);
        }
    }

    private final Bundle zzb(Bundle bundle) throws IOException {
        Bundle zzc2 = zzc(bundle);
        if (zzc2 == null) {
            return zzc2;
        }
        String str = "google.messenger";
        if (!zzc2.containsKey(str)) {
            return zzc2;
        }
        Bundle zzc3 = zzc(bundle);
        if (zzc3 == null || !zzc3.containsKey(str)) {
            return zzc3;
        }
        return null;
    }

    private static synchronized String zza() {
        String num;
        synchronized (zzal.class) {
            int i = zza;
            zza = i + 1;
            num = Integer.toString(i);
        }
        return num;
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00e0 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final android.os.Bundle zzc(android.os.Bundle r8) throws java.io.IOException {
        /*
            r7 = this;
            java.lang.String r0 = zza()
            com.google.android.gms.tasks.TaskCompletionSource r1 = new com.google.android.gms.tasks.TaskCompletionSource
            r1.<init>()
            androidx.collection.SimpleArrayMap<java.lang.String, com.google.android.gms.tasks.TaskCompletionSource<android.os.Bundle>> r2 = r7.zzc
            monitor-enter(r2)
            androidx.collection.SimpleArrayMap<java.lang.String, com.google.android.gms.tasks.TaskCompletionSource<android.os.Bundle>> r3 = r7.zzc     // Catch:{ all -> 0x0110 }
            r3.put(r0, r1)     // Catch:{ all -> 0x0110 }
            monitor-exit(r2)     // Catch:{ all -> 0x0110 }
            com.google.firebase.iid.zzaf r2 = r7.zze
            int r2 = r2.zza()
            if (r2 == 0) goto L_0x0108
            android.content.Intent r2 = new android.content.Intent
            r2.<init>()
            java.lang.String r3 = "com.google.android.gms"
            r2.setPackage(r3)
            com.google.firebase.iid.zzaf r3 = r7.zze
            int r3 = r3.zza()
            r4 = 2
            if (r3 != r4) goto L_0x0033
            java.lang.String r3 = "com.google.iid.TOKEN_REQUEST"
            r2.setAction(r3)
            goto L_0x0038
        L_0x0033:
            java.lang.String r3 = "com.google.android.c2dm.intent.REGISTER"
            r2.setAction(r3)
        L_0x0038:
            r2.putExtras(r8)
            android.content.Context r8 = r7.zzd
            zza(r8, r2)
            java.lang.String r8 = java.lang.String.valueOf(r0)
            int r8 = r8.length()
            int r8 = r8 + 5
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r8)
            java.lang.String r8 = "|ID|"
            r3.append(r8)
            r3.append(r0)
            java.lang.String r8 = "|"
            r3.append(r8)
            java.lang.String r8 = r3.toString()
            java.lang.String r3 = "kid"
            r2.putExtra(r3, r8)
            r8 = 3
            java.lang.String r3 = "FirebaseInstanceId"
            boolean r3 = android.util.Log.isLoggable(r3, r8)
            if (r3 == 0) goto L_0x0090
            android.os.Bundle r3 = r2.getExtras()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r5 = java.lang.String.valueOf(r3)
            int r5 = r5.length()
            int r5 = r5 + 8
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r5)
            java.lang.String r5 = "Sending "
            r6.append(r5)
            r6.append(r3)
            r6.toString()
        L_0x0090:
            android.os.Messenger r3 = r7.zzf
            java.lang.String r5 = "google.messenger"
            r2.putExtra(r5, r3)
            android.os.Messenger r3 = r7.zzg
            if (r3 != 0) goto L_0x009f
            com.google.firebase.iid.zzd r3 = r7.zzh
            if (r3 == 0) goto L_0x00bc
        L_0x009f:
            android.os.Message r3 = android.os.Message.obtain()
            r3.obj = r2
            android.os.Messenger r5 = r7.zzg     // Catch:{ RemoteException -> 0x00b5 }
            if (r5 == 0) goto L_0x00af
            android.os.Messenger r5 = r7.zzg     // Catch:{ RemoteException -> 0x00b5 }
            r5.send(r3)     // Catch:{ RemoteException -> 0x00b5 }
            goto L_0x00cf
        L_0x00af:
            com.google.firebase.iid.zzd r5 = r7.zzh     // Catch:{ RemoteException -> 0x00b5 }
            r5.zza(r3)     // Catch:{ RemoteException -> 0x00b5 }
            goto L_0x00cf
        L_0x00b5:
            java.lang.String r3 = "FirebaseInstanceId"
            boolean r8 = android.util.Log.isLoggable(r3, r8)
        L_0x00bc:
            com.google.firebase.iid.zzaf r8 = r7.zze
            int r8 = r8.zza()
            if (r8 != r4) goto L_0x00ca
            android.content.Context r8 = r7.zzd
            r8.sendBroadcast(r2)
            goto L_0x00cf
        L_0x00ca:
            android.content.Context r8 = r7.zzd
            r8.startService(r2)
        L_0x00cf:
            com.google.android.gms.tasks.Task r8 = r1.getTask()     // Catch:{ InterruptedException | TimeoutException -> 0x00f3, ExecutionException -> 0x00ec }
            r1 = 30000(0x7530, double:1.4822E-319)
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ InterruptedException | TimeoutException -> 0x00f3, ExecutionException -> 0x00ec }
            java.lang.Object r8 = com.google.android.gms.tasks.Tasks.await(r8, r1, r3)     // Catch:{ InterruptedException | TimeoutException -> 0x00f3, ExecutionException -> 0x00ec }
            android.os.Bundle r8 = (android.os.Bundle) r8     // Catch:{ InterruptedException | TimeoutException -> 0x00f3, ExecutionException -> 0x00ec }
            androidx.collection.SimpleArrayMap<java.lang.String, com.google.android.gms.tasks.TaskCompletionSource<android.os.Bundle>> r1 = r7.zzc
            monitor-enter(r1)
            androidx.collection.SimpleArrayMap<java.lang.String, com.google.android.gms.tasks.TaskCompletionSource<android.os.Bundle>> r2 = r7.zzc     // Catch:{ all -> 0x00e7 }
            r2.remove(r0)     // Catch:{ all -> 0x00e7 }
            monitor-exit(r1)     // Catch:{ all -> 0x00e7 }
            return r8
        L_0x00e7:
            r8 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x00e7 }
            throw r8
        L_0x00ea:
            r8 = move-exception
            goto L_0x00fb
        L_0x00ec:
            r8 = move-exception
            java.io.IOException r1 = new java.io.IOException     // Catch:{ all -> 0x00ea }
            r1.<init>(r8)     // Catch:{ all -> 0x00ea }
            throw r1     // Catch:{ all -> 0x00ea }
        L_0x00f3:
            java.io.IOException r8 = new java.io.IOException     // Catch:{ all -> 0x00ea }
            java.lang.String r1 = "TIMEOUT"
            r8.<init>(r1)     // Catch:{ all -> 0x00ea }
            throw r8     // Catch:{ all -> 0x00ea }
        L_0x00fb:
            androidx.collection.SimpleArrayMap<java.lang.String, com.google.android.gms.tasks.TaskCompletionSource<android.os.Bundle>> r1 = r7.zzc
            monitor-enter(r1)
            androidx.collection.SimpleArrayMap<java.lang.String, com.google.android.gms.tasks.TaskCompletionSource<android.os.Bundle>> r2 = r7.zzc     // Catch:{ all -> 0x0105 }
            r2.remove(r0)     // Catch:{ all -> 0x0105 }
            monitor-exit(r1)     // Catch:{ all -> 0x0105 }
            throw r8
        L_0x0105:
            r8 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0105 }
            throw r8
        L_0x0108:
            java.io.IOException r8 = new java.io.IOException
            java.lang.String r0 = "MISSING_INSTANCEID_SERVICE"
            r8.<init>(r0)
            throw r8
        L_0x0110:
            r8 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0110 }
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.zzal.zzc(android.os.Bundle):android.os.Bundle");
    }
}
