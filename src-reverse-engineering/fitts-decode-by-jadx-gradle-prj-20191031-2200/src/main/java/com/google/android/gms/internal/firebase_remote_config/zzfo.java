package com.google.android.gms.internal.firebase_remote_config;

import com.facebook.internal.ServerProtocol;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;

public final class zzfo implements Closeable, Flushable {
    private static final String[] zzoe = new String[128];
    private static final String[] zzof;
    private final Writer out;
    private String separator;
    private boolean zzng;
    private int[] zzno = new int[32];
    private int zznp = 0;
    private String zzog;
    private String zzoh;
    private boolean zzoi;

    public zzfo(Writer writer) {
        zzo(6);
        this.separator = ":";
        this.zzoi = true;
        this.out = writer;
    }

    public final void setIndent(String str) {
        if (str.length() == 0) {
            this.zzog = null;
            this.separator = ":";
            return;
        }
        this.zzog = str;
        this.separator = ": ";
    }

    public final void setLenient(boolean z) {
        this.zzng = true;
    }

    public final zzfo zzef() throws IOException {
        zzek();
        zza(1, "[");
        return this;
    }

    public final zzfo zzeg() throws IOException {
        zzb(1, 2, "]");
        return this;
    }

    public final zzfo zzeh() throws IOException {
        zzek();
        zza(3, "{");
        return this;
    }

    public final zzfo zzei() throws IOException {
        zzb(3, 5, "}");
        return this;
    }

    private final zzfo zza(int i, String str) throws IOException {
        zzen();
        zzo(i);
        this.out.write(str);
        return this;
    }

    private final zzfo zzb(int i, int i2, String str) throws IOException {
        int zzej = zzej();
        if (zzej != i2 && zzej != i) {
            throw new IllegalStateException("Nesting problem.");
        } else if (this.zzoh == null) {
            this.zznp--;
            if (zzej == i2) {
                zzem();
            }
            this.out.write(str);
            return this;
        } else {
            StringBuilder sb = new StringBuilder("Dangling name: ");
            sb.append(this.zzoh);
            throw new IllegalStateException(sb.toString());
        }
    }

    private final void zzo(int i) {
        int i2 = this.zznp;
        int[] iArr = this.zzno;
        if (i2 == iArr.length) {
            int[] iArr2 = new int[(i2 << 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            this.zzno = iArr2;
        }
        int[] iArr3 = this.zzno;
        int i3 = this.zznp;
        this.zznp = i3 + 1;
        iArr3[i3] = i;
    }

    private final int zzej() {
        int i = this.zznp;
        if (i != 0) {
            return this.zzno[i - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    private final void zzq(int i) {
        this.zzno[this.zznp - 1] = i;
    }

    public final zzfo zzbf(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        } else if (this.zzoh != null) {
            throw new IllegalStateException();
        } else if (this.zznp != 0) {
            this.zzoh = str;
            return this;
        } else {
            throw new IllegalStateException("JsonWriter is closed.");
        }
    }

    private final void zzek() throws IOException {
        if (this.zzoh != null) {
            int zzej = zzej();
            if (zzej == 5) {
                this.out.write(44);
            } else if (zzej != 3) {
                throw new IllegalStateException("Nesting problem.");
            }
            zzem();
            zzq(4);
            zzbh(this.zzoh);
            this.zzoh = null;
        }
    }

    public final zzfo zzbg(String str) throws IOException {
        if (str == null) {
            return zzel();
        }
        zzek();
        zzen();
        zzbh(str);
        return this;
    }

    public final zzfo zzel() throws IOException {
        if (this.zzoh != null) {
            if (this.zzoi) {
                zzek();
            } else {
                this.zzoh = null;
                return this;
            }
        }
        zzen();
        this.out.write("null");
        return this;
    }

    public final zzfo zzc(boolean z) throws IOException {
        zzek();
        zzen();
        this.out.write(z ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false");
        return this;
    }

    public final zzfo zzb(double d) throws IOException {
        zzek();
        if (this.zzng || (!Double.isNaN(d) && !Double.isInfinite(d))) {
            zzen();
            this.out.append(Double.toString(d));
            return this;
        }
        StringBuilder sb = new StringBuilder("Numeric values must be finite, but was ");
        sb.append(d);
        throw new IllegalArgumentException(sb.toString());
    }

    public final zzfo zzd(long j) throws IOException {
        zzek();
        zzen();
        this.out.write(Long.toString(j));
        return this;
    }

    public final zzfo zza(Number number) throws IOException {
        if (number == null) {
            return zzel();
        }
        zzek();
        String obj = number.toString();
        if (this.zzng || (!obj.equals("-Infinity") && !obj.equals("Infinity") && !obj.equals("NaN"))) {
            zzen();
            this.out.append(obj);
            return this;
        }
        StringBuilder sb = new StringBuilder("Numeric values must be finite, but was ");
        sb.append(number);
        throw new IllegalArgumentException(sb.toString());
    }

    public final void flush() throws IOException {
        if (this.zznp != 0) {
            this.out.flush();
            return;
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public final void close() throws IOException {
        this.out.close();
        int i = this.zznp;
        if (i > 1 || (i == 1 && this.zzno[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.zznp = 0;
    }

    private final void zzbh(String str) throws IOException {
        String str2;
        String[] strArr = zzoe;
        String str3 = "\"";
        this.out.write(str3);
        int length = str.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt < 128) {
                str2 = strArr[charAt];
                if (str2 == null) {
                }
            } else if (charAt == 8232) {
                str2 = "\\u2028";
            } else if (charAt == 8233) {
                str2 = "\\u2029";
            }
            if (i < i2) {
                this.out.write(str, i, i2 - i);
            }
            this.out.write(str2);
            i = i2 + 1;
        }
        if (i < length) {
            this.out.write(str, i, length - i);
        }
        this.out.write(str3);
    }

    private final void zzem() throws IOException {
        if (this.zzog != null) {
            this.out.write("\n");
            int i = this.zznp;
            for (int i2 = 1; i2 < i; i2++) {
                this.out.write(this.zzog);
            }
        }
    }

    private final void zzen() throws IOException {
        int zzej = zzej();
        if (zzej == 1) {
            zzq(2);
            zzem();
        } else if (zzej == 2) {
            this.out.append(',');
            zzem();
        } else if (zzej != 4) {
            if (zzej != 6) {
                if (zzej != 7) {
                    throw new IllegalStateException("Nesting problem.");
                } else if (!this.zzng) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
            }
            zzq(7);
        } else {
            this.out.append(this.separator);
            zzq(5);
        }
    }

    static {
        for (int i = 0; i <= 31; i++) {
            zzoe[i] = String.format("\\u%04x", new Object[]{Integer.valueOf(i)});
        }
        String[] strArr = zzoe;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        zzof = strArr2;
        strArr2[60] = "\\u003c";
        String[] strArr3 = zzof;
        strArr3[62] = "\\u003e";
        strArr3[38] = "\\u0026";
        strArr3[61] = "\\u003d";
        strArr3[39] = "\\u0027";
    }
}
