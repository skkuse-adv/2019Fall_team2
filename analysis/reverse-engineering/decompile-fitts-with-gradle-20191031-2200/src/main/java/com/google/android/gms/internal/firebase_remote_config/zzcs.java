package com.google.android.gms.internal.firebase_remote_config;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public final class zzcs {
    private static final zzcr zzgj = new zzcu("-_.*", true);
    private static final zzcr zzgk = new zzcu("-_.!~*'()@:$&,;=", false);
    private static final zzcr zzgl = new zzcu("-_.!~*'()@:$&,;=+/?", false);
    private static final zzcr zzgm = new zzcu("-_.!~*'():$&,;=", false);
    private static final zzcr zzgn = new zzcu("-_.!~*'()@:$,;/?:", false);

    public static String zzah(String str) {
        return zzgj.zzag(str);
    }

    public static String zzai(String str) {
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static String zzaj(String str) {
        return zzgk.zzag(str);
    }

    public static String zzak(String str) {
        return zzgl.zzag(str);
    }

    public static String zzal(String str) {
        return zzgm.zzag(str);
    }

    public static String zzam(String str) {
        return zzgn.zzag(str);
    }
}
