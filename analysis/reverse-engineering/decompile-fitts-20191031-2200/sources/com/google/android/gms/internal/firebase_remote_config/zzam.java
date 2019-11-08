package com.google.android.gms.internal.firebase_remote_config;

import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public final class zzam implements zzci {
    public static final String MEDIA_TYPE = new zzy(HttpRequest.CONTENT_TYPE_FORM).zza(zzbo.UTF_8).zzp();

    public static void zze(String str, Object obj) {
        String str2 = str;
        Object obj2 = obj;
        if (str2 != null) {
            try {
                StringReader stringReader = new StringReader(str2);
                Class cls = obj.getClass();
                zzbr zzc = zzbr.zzc(cls);
                List asList = Arrays.asList(new Type[]{cls});
                zzby zzby = zzby.class.isAssignableFrom(cls) ? (zzby) obj2 : null;
                Map map = Map.class.isAssignableFrom(cls) ? (Map) obj2 : null;
                zzbn zzbn = new zzbn(obj2);
                StringWriter stringWriter = new StringWriter();
                StringWriter stringWriter2 = new StringWriter();
                StringWriter stringWriter3 = stringWriter;
                boolean z = true;
                while (true) {
                    int read = stringReader.read();
                    if (read == -1 || read == 38) {
                        String zzai = zzcs.zzai(stringWriter3.toString());
                        if (zzai.length() != 0) {
                            String zzai2 = zzcs.zzai(stringWriter2.toString());
                            zzbz zzae = zzc.zzae(zzai);
                            if (zzae != null) {
                                Type zza = zzbt.zza(asList, zzae.getGenericType());
                                if (zzco.zzc(zza)) {
                                    Class zzb = zzco.zzb(asList, zzco.zzd(zza));
                                    zzbn.zza(zzae.zzbz(), zzb, zza((Type) zzb, asList, zzai2));
                                } else if (zzco.zza(zzco.zzb(asList, zza), Iterable.class)) {
                                    Collection collection = (Collection) zzae.zzh(obj2);
                                    if (collection == null) {
                                        collection = zzbt.zzb(zza);
                                        zzae.zzb(obj2, collection);
                                    }
                                    collection.add(zza(zza == Object.class ? null : zzco.zze(zza), asList, zzai2));
                                } else {
                                    zzae.zzb(obj2, zza(zza, asList, zzai2));
                                }
                            } else if (map != null) {
                                ArrayList arrayList = (ArrayList) map.get(zzai);
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                    if (zzby != null) {
                                        zzby.zzb(zzai, arrayList);
                                    } else {
                                        map.put(zzai, arrayList);
                                    }
                                }
                                arrayList.add(zzai2);
                            }
                        }
                        StringWriter stringWriter4 = new StringWriter();
                        StringWriter stringWriter5 = new StringWriter();
                        if (read == -1) {
                            zzbn.zzbu();
                            return;
                        }
                        stringWriter3 = stringWriter4;
                        stringWriter2 = stringWriter5;
                        z = true;
                    } else if (read != 61) {
                        if (z) {
                            stringWriter3.write(read);
                        } else {
                            stringWriter2.write(read);
                        }
                    } else if (z) {
                        z = false;
                    } else {
                        stringWriter2.write(read);
                    }
                }
            } catch (IOException e) {
                throw zzeb.zzb(e);
            }
        }
    }

    private static Object zza(Type type, List<Type> list, String str) {
        return zzbt.zza(zzbt.zza(list, type), str);
    }

    public final <T> T zza(InputStream inputStream, Charset charset, Class<T> cls) throws IOException {
        throw new NoSuchMethodError();
    }
}
