package com.google.android.gms.internal.firebase_remote_config;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class zzal {
    static final Map<Character, zzak> zzcr = new HashMap();

    private static Map<String, Object> zzb(Object obj) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Entry entry : zzbt.zzf(obj).entrySet()) {
            Object value = entry.getValue();
            if (value != null && !zzbt.isNull(value)) {
                linkedHashMap.put((String) entry.getKey(), value);
            }
        }
        return linkedHashMap;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0201 A[EDGE_INSN: B:85:0x0201->B:83:0x0201 ?: BREAK  
EDGE_INSN: B:85:0x0201->B:83:0x0201 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String zza(java.lang.String r12, java.lang.String r13, java.lang.Object r14, boolean r15) {
        /*
            java.lang.String r15 = "/"
            boolean r15 = r13.startsWith(r15)
            if (r15 == 0) goto L_0x002f
            com.google.android.gms.internal.firebase_remote_config.zzt r15 = new com.google.android.gms.internal.firebase_remote_config.zzt
            r15.<init>(r12)
            r12 = 0
            r15.zzl(r12)
            java.lang.String r12 = r15.zzp()
            java.lang.String r12 = java.lang.String.valueOf(r12)
            java.lang.String r13 = java.lang.String.valueOf(r13)
            int r15 = r13.length()
            if (r15 == 0) goto L_0x0028
            java.lang.String r12 = r12.concat(r13)
            goto L_0x0059
        L_0x0028:
            java.lang.String r13 = new java.lang.String
            r13.<init>(r12)
        L_0x002d:
            r12 = r13
            goto L_0x0059
        L_0x002f:
            java.lang.String r15 = "http://"
            boolean r15 = r13.startsWith(r15)
            if (r15 != 0) goto L_0x002d
            java.lang.String r15 = "https://"
            boolean r15 = r13.startsWith(r15)
            if (r15 == 0) goto L_0x0040
            goto L_0x002d
        L_0x0040:
            java.lang.String r12 = java.lang.String.valueOf(r12)
            java.lang.String r13 = java.lang.String.valueOf(r13)
            int r15 = r13.length()
            if (r15 == 0) goto L_0x0053
            java.lang.String r13 = r12.concat(r13)
            goto L_0x002d
        L_0x0053:
            java.lang.String r13 = new java.lang.String
            r13.<init>(r12)
            goto L_0x002d
        L_0x0059:
            java.util.Map r13 = zzb(r14)
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            int r15 = r12.length()
            r0 = 0
            r1 = 0
        L_0x0068:
            if (r1 >= r15) goto L_0x0201
            r2 = 123(0x7b, float:1.72E-43)
            int r2 = r12.indexOf(r2, r1)
            r3 = -1
            if (r2 != r3) goto L_0x007c
            java.lang.String r12 = r12.substring(r1)
            r14.append(r12)
            goto L_0x0201
        L_0x007c:
            java.lang.String r1 = r12.substring(r1, r2)
            r14.append(r1)
            r1 = 125(0x7d, float:1.75E-43)
            int r3 = r2 + 2
            int r1 = r12.indexOf(r1, r3)
            int r3 = r1 + 1
            int r2 = r2 + 1
            java.lang.String r1 = r12.substring(r2, r1)
            java.util.Map<java.lang.Character, com.google.android.gms.internal.firebase_remote_config.zzak> r2 = zzcr
            char r4 = r1.charAt(r0)
            java.lang.Character r4 = java.lang.Character.valueOf(r4)
            java.lang.Object r2 = r2.get(r4)
            com.google.android.gms.internal.firebase_remote_config.zzak r2 = (com.google.android.gms.internal.firebase_remote_config.zzak) r2
            if (r2 != 0) goto L_0x00a7
            com.google.android.gms.internal.firebase_remote_config.zzak r2 = com.google.android.gms.internal.firebase_remote_config.zzak.SIMPLE
        L_0x00a7:
            r4 = 44
            com.google.android.gms.internal.firebase_remote_config.zzdj r4 = com.google.android.gms.internal.firebase_remote_config.zzdj.zza(r4)
            com.google.android.gms.internal.firebase_remote_config.zzds r4 = com.google.android.gms.internal.firebase_remote_config.zzds.zza(r4)
            java.util.List r1 = r4.zza(r1)
            java.util.ListIterator r1 = r1.listIterator()
            r4 = 1
            r5 = 1
        L_0x00bb:
            boolean r6 = r1.hasNext()
            if (r6 == 0) goto L_0x01fe
            java.lang.Object r6 = r1.next()
            java.lang.String r6 = (java.lang.String) r6
            java.lang.String r7 = "*"
            boolean r7 = r6.endsWith(r7)
            int r8 = r1.nextIndex()
            if (r8 != r4) goto L_0x00d8
            int r8 = r2.zzan()
            goto L_0x00d9
        L_0x00d8:
            r8 = 0
        L_0x00d9:
            int r9 = r6.length()
            if (r7 == 0) goto L_0x00e1
            int r9 = r9 + -1
        L_0x00e1:
            java.lang.String r6 = r6.substring(r8, r9)
            java.lang.Object r8 = r13.remove(r6)
            if (r8 == 0) goto L_0x00bb
            if (r5 != 0) goto L_0x00f5
            java.lang.String r9 = r2.zzal()
            r14.append(r9)
            goto L_0x00fd
        L_0x00f5:
            java.lang.String r5 = r2.zzak()
            r14.append(r5)
            r5 = 0
        L_0x00fd:
            boolean r9 = r8 instanceof java.util.Iterator
            if (r9 == 0) goto L_0x0109
            java.util.Iterator r8 = (java.util.Iterator) r8
            java.lang.String r6 = zza(r6, r8, r7, r2)
            goto L_0x01f9
        L_0x0109:
            boolean r9 = r8 instanceof java.lang.Iterable
            if (r9 != 0) goto L_0x01ed
            java.lang.Class r9 = r8.getClass()
            boolean r9 = r9.isArray()
            if (r9 == 0) goto L_0x0119
            goto L_0x01ed
        L_0x0119:
            java.lang.Class r9 = r8.getClass()
            boolean r9 = r9.isEnum()
            java.lang.String r10 = "%s=%s"
            r11 = 2
            if (r9 == 0) goto L_0x014e
            r7 = r8
            java.lang.Enum r7 = (java.lang.Enum) r7
            com.google.android.gms.internal.firebase_remote_config.zzbz r7 = com.google.android.gms.internal.firebase_remote_config.zzbz.zza(r7)
            java.lang.String r7 = r7.getName()
            if (r7 == 0) goto L_0x014b
            boolean r7 = r2.zzam()
            if (r7 == 0) goto L_0x0143
            java.lang.Object[] r7 = new java.lang.Object[r11]
            r7[r0] = r6
            r7[r4] = r8
            java.lang.String r8 = java.lang.String.format(r10, r7)
        L_0x0143:
            java.lang.String r6 = r8.toString()
            java.lang.String r8 = com.google.android.gms.internal.firebase_remote_config.zzcs.zzaj(r6)
        L_0x014b:
            r6 = r8
            goto L_0x01f9
        L_0x014e:
            boolean r9 = com.google.android.gms.internal.firebase_remote_config.zzbt.zzg(r8)
            if (r9 != 0) goto L_0x01c5
            java.util.Map r8 = zzb(r8)
            boolean r9 = r8.isEmpty()
            if (r9 == 0) goto L_0x0162
            java.lang.String r6 = ""
            goto L_0x01f9
        L_0x0162:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "="
            java.lang.String r11 = ","
            if (r7 == 0) goto L_0x0172
            java.lang.String r11 = r2.zzal()
            goto L_0x0183
        L_0x0172:
            boolean r7 = r2.zzam()
            if (r7 == 0) goto L_0x0182
            java.lang.String r6 = com.google.android.gms.internal.firebase_remote_config.zzcs.zzaj(r6)
            r9.append(r6)
            r9.append(r10)
        L_0x0182:
            r10 = r11
        L_0x0183:
            java.util.Set r6 = r8.entrySet()
            java.util.Iterator r6 = r6.iterator()
        L_0x018b:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x01c0
            java.lang.Object r7 = r6.next()
            java.util.Map$Entry r7 = (java.util.Map.Entry) r7
            java.lang.Object r8 = r7.getKey()
            java.lang.String r8 = (java.lang.String) r8
            java.lang.String r8 = r2.zzaa(r8)
            java.lang.Object r7 = r7.getValue()
            java.lang.String r7 = r7.toString()
            java.lang.String r7 = r2.zzaa(r7)
            r9.append(r8)
            r9.append(r10)
            r9.append(r7)
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x018b
            r9.append(r11)
            goto L_0x018b
        L_0x01c0:
            java.lang.String r6 = r9.toString()
            goto L_0x01f9
        L_0x01c5:
            boolean r7 = r2.zzam()
            if (r7 == 0) goto L_0x01d5
            java.lang.Object[] r7 = new java.lang.Object[r11]
            r7[r0] = r6
            r7[r4] = r8
            java.lang.String r8 = java.lang.String.format(r10, r7)
        L_0x01d5:
            boolean r6 = r2.zzao()
            if (r6 == 0) goto L_0x01e4
            java.lang.String r6 = r8.toString()
            java.lang.String r6 = com.google.android.gms.internal.firebase_remote_config.zzcs.zzak(r6)
            goto L_0x01f9
        L_0x01e4:
            java.lang.String r6 = r8.toString()
            java.lang.String r6 = com.google.android.gms.internal.firebase_remote_config.zzcs.zzaj(r6)
            goto L_0x01f9
        L_0x01ed:
            java.lang.Iterable r8 = com.google.android.gms.internal.firebase_remote_config.zzco.zzi(r8)
            java.util.Iterator r8 = r8.iterator()
            java.lang.String r6 = zza(r6, r8, r7, r2)
        L_0x01f9:
            r14.append(r6)
            goto L_0x00bb
        L_0x01fe:
            r1 = r3
            goto L_0x0068
        L_0x0201:
            java.util.Set r12 = r13.entrySet()
            com.google.android.gms.internal.firebase_remote_config.zzt.zza(r12, r14)
            java.lang.String r12 = r14.toString()
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_remote_config.zzal.zza(java.lang.String, java.lang.String, java.lang.Object, boolean):java.lang.String");
    }

    private static String zza(String str, Iterator<?> it, boolean z, zzak zzak) {
        String str2;
        if (!it.hasNext()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        String str3 = "=";
        if (z) {
            str2 = zzak.zzal();
        } else {
            if (zzak.zzam()) {
                sb.append(zzcs.zzaj(str));
                sb.append(str3);
            }
            str2 = ",";
        }
        while (it.hasNext()) {
            if (z && zzak.zzam()) {
                sb.append(zzcs.zzaj(str));
                sb.append(str3);
            }
            sb.append(zzak.zzaa(it.next().toString()));
            if (it.hasNext()) {
                sb.append(str2);
            }
        }
        return sb.toString();
    }

    static {
        zzak.values();
    }
}
