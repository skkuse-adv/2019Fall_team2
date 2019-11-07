package com.google.firebase.perf.internal;

enum zzv {
    NETWORK("network", 10, 700, 10, 70),
    TRACE("trace", 10, 300, 10, 30);
    
    private final String zzeu;
    private final int zzev;
    private final int zzew;
    private final int zzex;
    private final int zzey;

    private zzv(String str, int i, int i2, int i3, int i4) {
        this.zzeu = str;
        this.zzev = 10;
        this.zzew = i2;
        this.zzex = 10;
        this.zzey = i4;
    }

    public final int zzbr() {
        return this.zzev;
    }

    public final int zzbs() {
        return this.zzew;
    }

    public final int zzbt() {
        return this.zzex;
    }

    public final int zzbu() {
        return this.zzey;
    }

    public final String zzbv() {
        return String.valueOf(this.zzeu).concat("_flimit_time");
    }

    public final String zzbw() {
        return String.valueOf(this.zzeu).concat("_flimit_events");
    }

    public final String zzbx() {
        return String.valueOf(this.zzeu).concat("_blimit_time");
    }

    public final String zzby() {
        return String.valueOf(this.zzeu).concat("_blimit_events");
    }

    public final String toString() {
        return name();
    }
}
