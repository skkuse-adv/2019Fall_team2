package com.google.android.gms.internal.firebase_remote_config;

enum zzak {
    PLUS(Character.valueOf('+'), "", ",", false, true),
    HASH(Character.valueOf('#'), "#", ",", false, true),
    DOT(Character.valueOf('.'), ".", ".", false, false),
    FORWARD_SLASH(Character.valueOf('/'), "/", "/", false, false),
    SEMI_COLON(Character.valueOf(';'), ";", ";", true, false),
    QUERY(Character.valueOf('?'), "?", "&", true, false),
    AMP(Character.valueOf('&'), "&", "&", true, false),
    SIMPLE(null, "", ",", false, false);
    
    private final Character zzcl;
    private final String zzcm;
    private final String zzcn;
    private final boolean zzco;
    private final boolean zzcp;

    private zzak(Character ch, String str, String str2, boolean z, boolean z2) {
        this.zzcl = ch;
        this.zzcm = (String) zzdt.checkNotNull(str);
        this.zzcn = (String) zzdt.checkNotNull(str2);
        this.zzco = z;
        this.zzcp = z2;
        if (ch != null) {
            zzal.zzcr.put(ch, this);
        }
    }

    /* access modifiers changed from: 0000 */
    public final String zzak() {
        return this.zzcm;
    }

    /* access modifiers changed from: 0000 */
    public final String zzal() {
        return this.zzcn;
    }

    /* access modifiers changed from: 0000 */
    public final boolean zzam() {
        return this.zzco;
    }

    /* access modifiers changed from: 0000 */
    public final int zzan() {
        return this.zzcl == null ? 0 : 1;
    }

    /* access modifiers changed from: 0000 */
    public final String zzaa(String str) {
        if (this.zzcp) {
            return zzcs.zzaj(str);
        }
        return zzcs.zzah(str);
    }

    /* access modifiers changed from: 0000 */
    public final boolean zzao() {
        return this.zzcp;
    }
}
