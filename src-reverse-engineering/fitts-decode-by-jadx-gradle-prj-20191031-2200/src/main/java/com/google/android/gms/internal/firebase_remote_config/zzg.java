package com.google.android.gms.internal.firebase_remote_config;

import com.kakao.network.ServerProtocol;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class zzg {
    private static final zzg zzz = new zzg();
    private final String zzaa;

    zzg() {
        String str;
        String property = System.getProperty("java.version");
        if (property.startsWith("9")) {
            str = "9.0.0";
        } else {
            str = zzh(property);
        }
        this(str, zzdz.OS_NAME.value(), zzdz.OS_VERSION.value(), zzb.VERSION);
    }

    private zzg(String str, String str2, String str3, String str4) {
        StringBuilder sb = new StringBuilder("java/");
        sb.append(zzh(str));
        sb.append(" http-google-%s/");
        sb.append(zzh(str4));
        if (!(str2 == null || str3 == null)) {
            sb.append(ServerProtocol.AUTHORIZATION_HEADER_DELIMITER);
            sb.append(zzg(str2));
            sb.append("/");
            sb.append(zzh(str3));
        }
        this.zzaa = sb.toString();
    }

    /* access modifiers changed from: 0000 */
    public final String zzf(String str) {
        return String.format(this.zzaa, new Object[]{zzg(str)});
    }

    /* access modifiers changed from: private */
    public static zzg zzj() {
        return zzz;
    }

    private static String zzg(String str) {
        return str.toLowerCase().replaceAll("[^\\w\\d\\-]", "-");
    }

    private static String zzh(String str) {
        if (str == null) {
            return null;
        }
        Matcher matcher = Pattern.compile("(\\d+\\.\\d+\\.\\d+).*").matcher(str);
        if (matcher.find()) {
            str = matcher.group(1);
        }
        return str;
    }
}
