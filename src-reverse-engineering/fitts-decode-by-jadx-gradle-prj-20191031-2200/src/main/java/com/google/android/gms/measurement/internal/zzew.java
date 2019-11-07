package com.google.android.gms.measurement.internal;

import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.measurement.zzf;
import kotlinx.coroutines.DebugKt;

final class zzew implements Runnable {
    private final /* synthetic */ zzf zzmq;
    private final /* synthetic */ ServiceConnection zzmr;
    private final /* synthetic */ zzex zzms;

    zzew(zzex zzex, zzf zzf, ServiceConnection serviceConnection) {
        this.zzms = zzex;
        this.zzmq = zzf;
        this.zzmr = serviceConnection;
    }

    public final void run() {
        zzex zzex = this.zzms;
        zzeu zzeu = zzex.zzmt;
        String zza = zzex.packageName;
        zzf zzf = this.zzmq;
        ServiceConnection serviceConnection = this.zzmr;
        Bundle zza2 = zzeu.zza(zza, zzf);
        zzeu.zzj.zzaa().zzo();
        if (zza2 != null) {
            long j = zza2.getLong("install_begin_timestamp_seconds", 0) * 1000;
            if (j == 0) {
                zzeu.zzj.zzab().zzgk().zzao("Service response is missing Install Referrer install timestamp");
            } else {
                String string = zza2.getString("install_referrer");
                if (string == null || string.isEmpty()) {
                    zzeu.zzj.zzab().zzgk().zzao("No referrer defined in install referrer response");
                } else {
                    zzeu.zzj.zzab().zzgs().zza("InstallReferrer API result", string);
                    zzjs zzz = zzeu.zzj.zzz();
                    String str = "?";
                    String valueOf = String.valueOf(string);
                    Bundle zza3 = zzz.zza(Uri.parse(valueOf.length() != 0 ? str.concat(valueOf) : new String(str)));
                    if (zza3 == null) {
                        zzeu.zzj.zzab().zzgk().zzao("No campaign params defined in install referrer result");
                    } else {
                        String string2 = zza3.getString("medium");
                        if (string2 != null && !"(not set)".equalsIgnoreCase(string2) && !"organic".equalsIgnoreCase(string2)) {
                            long j2 = zza2.getLong("referrer_click_timestamp_seconds", 0) * 1000;
                            if (j2 == 0) {
                                zzeu.zzj.zzab().zzgk().zzao("Install Referrer is missing click timestamp for ad campaign");
                            } else {
                                zza3.putLong("click_timestamp", j2);
                            }
                        }
                        if (j == zzeu.zzj.zzac().zzlp.get()) {
                            zzeu.zzj.zzae();
                            zzeu.zzj.zzab().zzgs().zzao("Campaign has already been logged");
                        } else {
                            zzeu.zzj.zzac().zzlp.set(j);
                            zzeu.zzj.zzae();
                            String str2 = "referrer API";
                            zzeu.zzj.zzab().zzgs().zza("Logging Install Referrer campaign from sdk with ", str2);
                            zza3.putString("_cis", str2);
                            zzeu.zzj.zzq().logEvent(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_cmp", zza3);
                        }
                    }
                }
            }
        }
        if (serviceConnection != null) {
            ConnectionTracker.getInstance().unbindService(zzeu.zzj.getContext(), serviceConnection);
        }
    }
}
