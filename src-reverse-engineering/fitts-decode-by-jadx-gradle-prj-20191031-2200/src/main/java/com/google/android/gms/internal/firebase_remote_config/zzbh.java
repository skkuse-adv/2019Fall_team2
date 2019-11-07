package com.google.android.gms.internal.firebase_remote_config;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

final class zzbh extends zzaz {
    private final zzfo zzdu;

    zzbh(zzbf zzbf, zzfo zzfo) {
        this.zzdu = zzfo;
        zzfo.setLenient(true);
    }

    public final void flush() throws IOException {
        this.zzdu.flush();
    }

    public final void writeBoolean(boolean z) throws IOException {
        this.zzdu.zzc(z);
    }

    public final void zzat() throws IOException {
        this.zzdu.zzeg();
    }

    public final void zzav() throws IOException {
        this.zzdu.zzei();
    }

    public final void zzad(String str) throws IOException {
        this.zzdu.zzbf(str);
    }

    public final void zzaw() throws IOException {
        this.zzdu.zzel();
    }

    public final void zze(int i) throws IOException {
        this.zzdu.zzd((long) i);
    }

    public final void zza(long j) throws IOException {
        this.zzdu.zzd(j);
    }

    public final void zza(BigInteger bigInteger) throws IOException {
        this.zzdu.zza(bigInteger);
    }

    public final void zza(double d) throws IOException {
        this.zzdu.zzb(d);
    }

    public final void zza(float f) throws IOException {
        this.zzdu.zzb((double) f);
    }

    public final void zza(BigDecimal bigDecimal) throws IOException {
        this.zzdu.zza(bigDecimal);
    }

    public final void zzas() throws IOException {
        this.zzdu.zzef();
    }

    public final void zzau() throws IOException {
        this.zzdu.zzeh();
    }

    public final void writeString(String str) throws IOException {
        this.zzdu.zzbg(str);
    }

    public final void zzax() throws IOException {
        this.zzdu.setIndent("  ");
    }
}
