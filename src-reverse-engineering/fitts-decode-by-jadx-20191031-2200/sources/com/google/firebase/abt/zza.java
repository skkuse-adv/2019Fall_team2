package com.google.firebase.abt;

import androidx.annotation.VisibleForTesting;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

public final class zza {
    private static final String[] zza = {"experimentId", "experimentStartTime", "timeToLiveMillis", "triggerTimeoutMillis", "variantId"};
    @VisibleForTesting
    private static final DateFormat zzb = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);
    private final String triggerEventName;
    private final String zzc;
    private final String zzd;
    private final Date zze;
    private final long zzf;
    private final long zzg;

    @VisibleForTesting
    private zza(String str, String str2, String str3, Date date, long j, long j2) {
        this.zzc = str;
        this.zzd = str2;
        this.triggerEventName = str3;
        this.zze = date;
        this.zzf = j;
        this.zzg = j2;
    }

    static zza zza(Map<String, String> map) throws AbtException {
        String[] strArr;
        String str = "triggerEvent";
        ArrayList arrayList = new ArrayList();
        for (String str2 : zza) {
            if (!map.containsKey(str2)) {
                arrayList.add(str2);
            }
        }
        if (arrayList.isEmpty()) {
            try {
                zza zza2 = new zza((String) map.get("experimentId"), (String) map.get("variantId"), map.containsKey(str) ? (String) map.get(str) : "", zzb.parse((String) map.get("experimentStartTime")), Long.parseLong((String) map.get("triggerTimeoutMillis")), Long.parseLong((String) map.get("timeToLiveMillis")));
                return zza2;
            } catch (ParseException e) {
                throw new AbtException("Could not process experiment: parsing experiment start time failed.", e);
            } catch (NumberFormatException e2) {
                throw new AbtException("Could not process experiment: one of the durations could not be converted into a long.", e2);
            }
        } else {
            throw new AbtException(String.format("The following keys are missing from the experiment info map: %s", new Object[]{arrayList}));
        }
    }

    /* access modifiers changed from: 0000 */
    public final String zza() {
        return this.zzc;
    }

    /* access modifiers changed from: 0000 */
    public final String zzb() {
        return this.zzd;
    }

    /* access modifiers changed from: 0000 */
    public final String zzc() {
        return this.triggerEventName;
    }

    /* access modifiers changed from: 0000 */
    public final long zzd() {
        return this.zze.getTime();
    }

    /* access modifiers changed from: 0000 */
    public final long zze() {
        return this.zzf;
    }

    /* access modifiers changed from: 0000 */
    public final long zzf() {
        return this.zzg;
    }
}
