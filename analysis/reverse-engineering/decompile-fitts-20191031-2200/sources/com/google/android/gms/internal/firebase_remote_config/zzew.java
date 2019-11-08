package com.google.android.gms.internal.firebase_remote_config;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigValue;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Pattern;
import org.json.JSONException;

public final class zzew {
    @VisibleForTesting(otherwise = 3)
    public static final Charset zzln = Charset.forName("UTF-8");
    static final Pattern zzlo = Pattern.compile("^(1|true|t|yes|y|on)$", 2);
    static final Pattern zzlp = Pattern.compile("^(0|false|f|no|n|off|)$", 2);
    private final zzei zzje;
    private final zzei zzjf;

    public zzew(zzei zzei, zzei zzei2) {
        this.zzje = zzei;
        this.zzjf = zzei2;
    }

    public final String getString(String str) {
        String str2 = "String";
        String zza = zza(this.zzje, str, str2);
        if (zza != null) {
            return zza;
        }
        String zza2 = zza(this.zzjf, str, str2);
        return zza2 != null ? zza2 : "";
    }

    public final boolean getBoolean(String str) {
        String str2 = "Boolean";
        String zza = zza(this.zzje, str, str2);
        if (zza != null) {
            if (zzlo.matcher(zza).matches()) {
                return true;
            }
            if (zzlp.matcher(zza).matches()) {
                return false;
            }
        }
        String zza2 = zza(this.zzjf, str, str2);
        if (zza2 != null) {
            if (zzlo.matcher(zza2).matches()) {
                return true;
            }
            if (zzlp.matcher(zza2).matches()) {
            }
        }
        return false;
    }

    public final byte[] getByteArray(String str) {
        String str2 = "ByteArray";
        String zza = zza(this.zzje, str, str2);
        if (zza != null) {
            return zza.getBytes(zzln);
        }
        String zza2 = zza(this.zzjf, str, str2);
        if (zza2 != null) {
            return zza2.getBytes(zzln);
        }
        return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_BYTE_ARRAY;
    }

    public final double getDouble(String str) {
        Double zza = zza(this.zzje, str);
        if (zza != null) {
            return zza.doubleValue();
        }
        Double zza2 = zza(this.zzjf, str);
        return zza2 != null ? zza2.doubleValue() : FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
    }

    public final long getLong(String str) {
        Long zzb = zzb(this.zzje, str);
        if (zzb != null) {
            return zzb.longValue();
        }
        Long zzb2 = zzb(this.zzjf, str);
        if (zzb2 != null) {
            return zzb2.longValue();
        }
        return 0;
    }

    public final FirebaseRemoteConfigValue getValue(String str) {
        String str2 = "FirebaseRemoteConfigValue";
        String zza = zza(this.zzje, str, str2);
        if (zza != null) {
            return new zzfe(zza, 2);
        }
        String zza2 = zza(this.zzjf, str, str2);
        if (zza2 != null) {
            return new zzfe(zza2, 1);
        }
        return new zzfe("", 0);
    }

    public final Set<String> getKeysByPrefix(String str) {
        if (str == null) {
            str = "";
        }
        TreeSet treeSet = new TreeSet();
        zzen zzb = this.zzje.zzb(5);
        if (zzb != null) {
            treeSet.addAll(zza(str, zzb));
        }
        zzen zzb2 = this.zzjf.zzb(5);
        if (zzb2 != null) {
            treeSet.addAll(zza(str, zzb2));
        }
        return treeSet;
    }

    private static TreeSet<String> zza(String str, zzen zzen) {
        TreeSet<String> treeSet = new TreeSet<>();
        Iterator keys = zzen.zzcq().keys();
        while (keys.hasNext()) {
            String str2 = (String) keys.next();
            if (str2.startsWith(str)) {
                treeSet.add(str2);
            }
        }
        return treeSet;
    }

    public final Map<String, FirebaseRemoteConfigValue> getAll() {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.addAll(zza(this.zzje));
        hashSet.addAll(zza(this.zzjf));
        HashMap hashMap = new HashMap();
        for (String str : hashSet) {
            hashMap.put(str, getValue(str));
        }
        return hashMap;
    }

    @Nullable
    private static String zza(zzei zzei, String str, String str2) {
        zzen zzb = zzei.zzb(5);
        if (zzb == null) {
            return null;
        }
        try {
            return zzb.zzcq().getString(str);
        } catch (JSONException unused) {
            zze(str, str2);
            return null;
        }
    }

    @Nullable
    private static Double zza(zzei zzei, String str) {
        zzen zzb = zzei.zzb(5);
        if (zzb == null) {
            return null;
        }
        try {
            return Double.valueOf(zzb.zzcq().getDouble(str));
        } catch (JSONException unused) {
            zze(str, "Double");
            return null;
        }
    }

    @Nullable
    private static Long zzb(zzei zzei, String str) {
        zzen zzb = zzei.zzb(5);
        if (zzb == null) {
            return null;
        }
        try {
            return Long.valueOf(zzb.zzcq().getLong(str));
        } catch (JSONException unused) {
            zze(str, "Long");
            return null;
        }
    }

    private static Set<String> zza(zzei zzei) {
        HashSet hashSet = new HashSet();
        zzen zzb = zzei.zzb(5);
        if (zzb == null) {
            return hashSet;
        }
        Iterator keys = zzb.zzcq().keys();
        while (keys.hasNext()) {
            hashSet.add((String) keys.next());
        }
        return hashSet;
    }

    private static void zze(String str, String str2) {
        String.format("No value of type '%s' exists for parameter key '%s'.", new Object[]{str2, str});
    }
}
