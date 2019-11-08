package com.google.android.gms.internal.firebase_remote_config;

import com.facebook.internal.ServerProtocol;
import java.io.EOFException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

final class zzbk extends zzba {
    private final zzbf zzdv;
    private final zzfj zzdy;
    private List<String> zzdz = new ArrayList();
    private zzbg zzea;
    private String zzeb;

    zzbk(zzbf zzbf, zzfj zzfj) {
        this.zzdv = zzbf;
        this.zzdy = zzfj;
        zzfj.setLenient(true);
    }

    public final void close() throws IOException {
        this.zzdy.close();
    }

    public final String zzbb() {
        if (this.zzdz.isEmpty()) {
            return null;
        }
        List<String> list = this.zzdz;
        return (String) list.get(list.size() - 1);
    }

    public final zzbg zzba() {
        return this.zzea;
    }

    public final zzaw zzay() {
        return this.zzdv;
    }

    public final byte zzbd() {
        zzbr();
        return Byte.parseByte(this.zzeb);
    }

    public final short zzbe() {
        zzbr();
        return Short.parseShort(this.zzeb);
    }

    public final int getIntValue() {
        zzbr();
        return Integer.parseInt(this.zzeb);
    }

    public final float zzbf() {
        zzbr();
        return Float.parseFloat(this.zzeb);
    }

    public final BigInteger zzbi() {
        zzbr();
        return new BigInteger(this.zzeb);
    }

    public final BigDecimal zzbj() {
        zzbr();
        return new BigDecimal(this.zzeb);
    }

    public final double zzbh() {
        zzbr();
        return Double.parseDouble(this.zzeb);
    }

    public final long zzbg() {
        zzbr();
        return Long.parseLong(this.zzeb);
    }

    private final void zzbr() {
        zzbg zzbg = this.zzea;
        if (!(zzbg == zzbg.VALUE_NUMBER_INT || zzbg == zzbg.VALUE_NUMBER_FLOAT)) {
            throw new IllegalArgumentException();
        }
    }

    public final String getText() {
        return this.zzeb;
    }

    public final zzbg zzaz() throws IOException {
        zzfl zzfl;
        zzbg zzbg;
        zzbg zzbg2 = this.zzea;
        if (zzbg2 != null) {
            int i = zzbj.zzdg[zzbg2.ordinal()];
            if (i == 1) {
                this.zzdy.beginArray();
                this.zzdz.add(null);
            } else if (i == 2) {
                this.zzdy.beginObject();
                this.zzdz.add(null);
            }
        }
        try {
            zzfl = this.zzdy.zzdy();
        } catch (EOFException unused) {
            zzfl = zzfl.END_DOCUMENT;
        }
        switch (zzbj.zzdx[zzfl.ordinal()]) {
            case 1:
                this.zzeb = "[";
                this.zzea = zzbg.START_ARRAY;
                break;
            case 2:
                this.zzeb = "]";
                this.zzea = zzbg.END_ARRAY;
                List<String> list = this.zzdz;
                list.remove(list.size() - 1);
                this.zzdy.endArray();
                break;
            case 3:
                this.zzeb = "{";
                this.zzea = zzbg.START_OBJECT;
                break;
            case 4:
                this.zzeb = "}";
                this.zzea = zzbg.END_OBJECT;
                List<String> list2 = this.zzdz;
                list2.remove(list2.size() - 1);
                this.zzdy.endObject();
                break;
            case 5:
                if (!this.zzdy.nextBoolean()) {
                    this.zzeb = "false";
                    this.zzea = zzbg.VALUE_FALSE;
                    break;
                } else {
                    this.zzeb = ServerProtocol.DIALOG_RETURN_SCOPES_TRUE;
                    this.zzea = zzbg.VALUE_TRUE;
                    break;
                }
            case 6:
                this.zzeb = "null";
                this.zzea = zzbg.VALUE_NULL;
                this.zzdy.nextNull();
                break;
            case 7:
                this.zzeb = this.zzdy.nextString();
                this.zzea = zzbg.VALUE_STRING;
                break;
            case 8:
                this.zzeb = this.zzdy.nextString();
                if (this.zzeb.indexOf(46) == -1) {
                    zzbg = zzbg.VALUE_NUMBER_INT;
                } else {
                    zzbg = zzbg.VALUE_NUMBER_FLOAT;
                }
                this.zzea = zzbg;
                break;
            case 9:
                this.zzeb = this.zzdy.nextName();
                this.zzea = zzbg.FIELD_NAME;
                List<String> list3 = this.zzdz;
                list3.set(list3.size() - 1, this.zzeb);
                break;
            default:
                this.zzeb = null;
                this.zzea = null;
                break;
        }
        return this.zzea;
    }

    public final zzba zzbc() throws IOException {
        zzbg zzbg = this.zzea;
        if (zzbg != null) {
            int i = zzbj.zzdg[zzbg.ordinal()];
            if (i == 1) {
                this.zzdy.skipValue();
                this.zzeb = "]";
                this.zzea = zzbg.END_ARRAY;
            } else if (i == 2) {
                this.zzdy.skipValue();
                this.zzeb = "}";
                this.zzea = zzbg.END_OBJECT;
            }
        }
        return this;
    }
}
