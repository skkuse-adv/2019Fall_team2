package com.google.android.gms.internal.firebase_remote_config;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class zzby extends AbstractMap<String, Object> implements Cloneable {
    final zzbr zzay;
    Map<String, Object> zzfr;

    final class zza extends AbstractSet<Entry<String, Object>> {
        private final zzbx zzfu;

        zza() {
            this.zzfu = (zzbx) new zzbs(zzby.this, zzby.this.zzay.zzbv()).entrySet();
        }

        public final Iterator<Entry<String, Object>> iterator() {
            return new zzb(zzby.this, this.zzfu);
        }

        public final int size() {
            return zzby.this.zzfr.size() + this.zzfu.size();
        }

        public final void clear() {
            zzby.this.zzfr.clear();
            this.zzfu.clear();
        }
    }

    final class zzb implements Iterator<Entry<String, Object>> {
        private boolean zzfw;
        private final Iterator<Entry<String, Object>> zzfx;
        private final Iterator<Entry<String, Object>> zzfy;

        zzb(zzby zzby, zzbx zzbx) {
            this.zzfx = (zzbu) zzbx.iterator();
            this.zzfy = zzby.zzfr.entrySet().iterator();
        }

        public final boolean hasNext() {
            return this.zzfx.hasNext() || this.zzfy.hasNext();
        }

        public final void remove() {
            if (this.zzfw) {
                this.zzfy.remove();
            }
            this.zzfx.remove();
        }

        public final /* synthetic */ Object next() {
            if (!this.zzfw) {
                if (this.zzfx.hasNext()) {
                    return (Entry) this.zzfx.next();
                }
                this.zzfw = true;
            }
            return (Entry) this.zzfy.next();
        }
    }

    public enum zzc {
        IGNORE_CASE
    }

    public zzby() {
        this(EnumSet.noneOf(zzc.class));
    }

    public zzby(EnumSet<zzc> enumSet) {
        this.zzfr = new zzbl();
        this.zzay = zzbr.zza(getClass(), enumSet.contains(zzc.IGNORE_CASE));
    }

    public final Object get(Object obj) {
        if (!(obj instanceof String)) {
            return null;
        }
        String str = (String) obj;
        zzbz zzae = this.zzay.zzae(str);
        if (zzae != null) {
            return zzae.zzh(this);
        }
        if (this.zzay.zzbv()) {
            str = str.toLowerCase(Locale.US);
        }
        return this.zzfr.get(str);
    }

    /* renamed from: zzf */
    public final Object put(String str, Object obj) {
        zzbz zzae = this.zzay.zzae(str);
        if (zzae != null) {
            Object zzh = zzae.zzh(this);
            zzae.zzb(this, obj);
            return zzh;
        }
        if (this.zzay.zzbv()) {
            str = str.toLowerCase(Locale.US);
        }
        return this.zzfr.put(str, obj);
    }

    public zzby zzb(String str, Object obj) {
        zzbz zzae = this.zzay.zzae(str);
        if (zzae != null) {
            zzae.zzb(this, obj);
        } else {
            if (this.zzay.zzbv()) {
                str = str.toLowerCase(Locale.US);
            }
            this.zzfr.put(str, obj);
        }
        return this;
    }

    public final void putAll(Map<? extends String, ?> map) {
        for (Entry entry : map.entrySet()) {
            zzb((String) entry.getKey(), entry.getValue());
        }
    }

    public final Object remove(Object obj) {
        if (!(obj instanceof String)) {
            return null;
        }
        String str = (String) obj;
        if (this.zzay.zzae(str) == null) {
            if (this.zzay.zzbv()) {
                str = str.toLowerCase(Locale.US);
            }
            return this.zzfr.remove(str);
        }
        throw new UnsupportedOperationException();
    }

    public Set<Entry<String, Object>> entrySet() {
        return new zza();
    }

    /* renamed from: zzb */
    public zzby clone() {
        try {
            zzby zzby = (zzby) super.clone();
            zzbt.zza((Object) this, (Object) zzby);
            zzby.zzfr = (Map) zzbt.clone(this.zzfr);
            return zzby;
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException(e);
        }
    }

    public final zzbr zzby() {
        return this.zzay;
    }
}
