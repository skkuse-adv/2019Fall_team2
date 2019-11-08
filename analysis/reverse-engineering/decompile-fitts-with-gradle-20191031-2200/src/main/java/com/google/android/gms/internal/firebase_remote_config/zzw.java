package com.google.android.gms.internal.firebase_remote_config;

import com.google.android.gms.internal.firebase_remote_config.zzby.zzc;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class zzw extends zzby {
    @zzcc("Accept")
    private List<String> accept;
    @zzcc("Accept-Encoding")
    private List<String> acceptEncoding = new ArrayList(Collections.singleton(HttpRequest.ENCODING_GZIP));
    @zzcc("Age")
    private List<Long> age;
    @zzcc("WWW-Authenticate")
    private List<String> authenticate;
    @zzcc("Authorization")
    private List<String> authorization;
    @zzcc("Cache-Control")
    private List<String> cacheControl;
    @zzcc("Content-Encoding")
    private List<String> contentEncoding;
    @zzcc("Content-Length")
    private List<Long> contentLength;
    @zzcc("Content-MD5")
    private List<String> contentMD5;
    @zzcc("Content-Range")
    private List<String> contentRange;
    @zzcc("Content-Type")
    private List<String> contentType;
    @zzcc("Cookie")
    private List<String> cookie;
    @zzcc("Date")
    private List<String> date;
    @zzcc("ETag")
    private List<String> etag;
    @zzcc("Expires")
    private List<String> expires;
    @zzcc("If-Match")
    private List<String> ifMatch;
    @zzcc("If-Modified-Since")
    private List<String> ifModifiedSince;
    @zzcc("If-None-Match")
    private List<String> ifNoneMatch;
    @zzcc("If-Range")
    private List<String> ifRange;
    @zzcc("If-Unmodified-Since")
    private List<String> ifUnmodifiedSince;
    @zzcc("Last-Modified")
    private List<String> lastModified;
    @zzcc("Location")
    private List<String> location;
    @zzcc("MIME-Version")
    private List<String> mimeVersion;
    @zzcc("Range")
    private List<String> range;
    @zzcc("Retry-After")
    private List<String> retryAfter;
    @zzcc("User-Agent")
    private List<String> userAgent;

    public zzw() {
        super(EnumSet.of(zzc.IGNORE_CASE));
    }

    public final zzw zzo(String str) {
        this.authorization = zza((T) null);
        return this;
    }

    public final String getContentType() {
        return (String) zza(this.contentType);
    }

    public final String zzq() {
        return (String) zza(this.etag);
    }

    public final zzw zzp(String str) {
        this.ifModifiedSince = zza((T) null);
        return this;
    }

    public final zzw zzq(String str) {
        this.ifMatch = zza((T) null);
        return this;
    }

    public final zzw zzr(String str) {
        this.ifNoneMatch = zza((T) str);
        return this;
    }

    public final zzw zzs(String str) {
        this.ifUnmodifiedSince = zza((T) null);
        return this;
    }

    public final zzw zzt(String str) {
        this.ifRange = zza((T) null);
        return this;
    }

    public final String getLocation() {
        return (String) zza(this.location);
    }

    public final String getUserAgent() {
        return (String) zza(this.userAgent);
    }

    public final zzw zzu(String str) {
        this.userAgent = zza((T) str);
        return this;
    }

    private static void zza(Logger logger, StringBuilder sb, StringBuilder sb2, zzaj zzaj, String str, Object obj, Writer writer) throws IOException {
        if (obj != null && !zzbt.isNull(obj)) {
            String name = obj instanceof Enum ? zzbz.zza((Enum) obj).getName() : obj.toString();
            String str2 = (("Authorization".equalsIgnoreCase(str) || "Cookie".equalsIgnoreCase(str)) && (logger == null || !logger.isLoggable(Level.ALL))) ? "<Not Logged>" : name;
            String str3 = ": ";
            if (sb != null) {
                sb.append(str);
                sb.append(str3);
                sb.append(str2);
                sb.append(zzcl.zzgg);
            }
            if (sb2 != null) {
                sb2.append(" -H '");
                sb2.append(str);
                sb2.append(str3);
                sb2.append(str2);
                sb2.append("'");
            }
            if (zzaj != null) {
                zzaj.addHeader(str, name);
            }
            if (writer != null) {
                writer.write(str);
                writer.write(str3);
                writer.write(name);
                writer.write("\r\n");
            }
        }
    }

    static void zza(zzw zzw, StringBuilder sb, StringBuilder sb2, Logger logger, zzaj zzaj) throws IOException {
        HashSet hashSet = new HashSet();
        for (Entry entry : zzw.entrySet()) {
            String str = (String) entry.getKey();
            Object[] objArr = {str};
            if (hashSet.add(str)) {
                Object value = entry.getValue();
                if (value != null) {
                    zzbz zzae = zzw.zzby().zzae(str);
                    if (zzae != null) {
                        str = zzae.getName();
                    }
                    Class cls = value.getClass();
                    if ((value instanceof Iterable) || cls.isArray()) {
                        for (Object zza : zzco.zzi(value)) {
                            zza(logger, sb, sb2, zzaj, str, zza, null);
                        }
                    } else {
                        zza(logger, sb, sb2, zzaj, str, value, null);
                    }
                }
            } else {
                throw new IllegalArgumentException(zzdy.zza("multiple headers of the same name (headers are case insensitive): %s", objArr));
            }
        }
    }

    public final void zza(zzai zzai, StringBuilder sb) throws IOException {
        clear();
        zzz zzz = new zzz(this, sb);
        int zzah = zzai.zzah();
        for (int i = 0; i < zzah; i++) {
            String zzc = zzai.zzc(i);
            String zzd = zzai.zzd(i);
            List<Type> list = zzz.zzaz;
            zzbr zzbr = zzz.zzay;
            zzbn zzbn = zzz.zzaw;
            StringBuilder sb2 = zzz.zzax;
            if (sb2 != null) {
                StringBuilder sb3 = new StringBuilder(String.valueOf(zzc).length() + 2 + String.valueOf(zzd).length());
                sb3.append(zzc);
                sb3.append(": ");
                sb3.append(zzd);
                sb2.append(sb3.toString());
                sb2.append(zzcl.zzgg);
            }
            zzbz zzae = zzbr.zzae(zzc);
            if (zzae != null) {
                Type zza = zzbt.zza(list, zzae.getGenericType());
                if (zzco.zzc(zza)) {
                    Class zzb = zzco.zzb(list, zzco.zzd(zza));
                    zzbn.zza(zzae.zzbz(), zzb, zza(zzb, list, zzd));
                } else if (zzco.zza(zzco.zzb(list, zza), Iterable.class)) {
                    Collection collection = (Collection) zzae.zzh(this);
                    if (collection == null) {
                        collection = zzbt.zzb(zza);
                        zzae.zzb(this, collection);
                    }
                    collection.add(zza(zza == Object.class ? null : zzco.zze(zza), list, zzd));
                } else {
                    zzae.zzb(this, zza(zza, list, zzd));
                }
            } else {
                ArrayList arrayList = (ArrayList) get(zzc);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    zzb(zzc, arrayList);
                }
                arrayList.add(zzd);
            }
        }
        zzz.zzaw.zzbu();
    }

    private static <T> T zza(List<T> list) {
        if (list == null) {
            return null;
        }
        return list.get(0);
    }

    private static <T> List<T> zza(T t) {
        if (t == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(t);
        return arrayList;
    }

    private static Object zza(Type type, List<Type> list, String str) {
        return zzbt.zza(zzbt.zza(list, type), str);
    }

    public final /* synthetic */ zzby zzb() {
        return (zzw) clone();
    }

    public final /* synthetic */ zzby zzb(String str, Object obj) {
        return (zzw) super.zzb(str, obj);
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        return (zzw) super.clone();
    }
}
