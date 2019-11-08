package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzey.zzd;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import sun.misc.Unsafe;

final class zzgm<T> implements zzgx<T> {
    private static final int[] zzakh = new int[0];
    private static final Unsafe zzaki = zzhv.zzwv();
    private final int[] zzakj;
    private final Object[] zzakk;
    private final int zzakl;
    private final int zzakm;
    private final zzgi zzakn;
    private final boolean zzako;
    private final boolean zzakp;
    private final boolean zzakq;
    private final boolean zzakr;
    private final int[] zzaks;
    private final int zzakt;
    private final int zzaku;
    private final zzgq zzakv;
    private final zzfs zzakw;
    private final zzhp<?, ?> zzakx;
    private final zzen<?> zzaky;
    private final zzgb zzakz;

    private zzgm(int[] iArr, Object[] objArr, int i, int i2, zzgi zzgi, boolean z, boolean z2, int[] iArr2, int i3, int i4, zzgq zzgq, zzfs zzfs, zzhp<?, ?> zzhp, zzen<?> zzen, zzgb zzgb) {
        this.zzakj = iArr;
        this.zzakk = objArr;
        this.zzakl = i;
        this.zzakm = i2;
        this.zzakp = zzgi instanceof zzey;
        this.zzakq = z;
        this.zzako = zzen != null && zzen.zze(zzgi);
        this.zzakr = false;
        this.zzaks = iArr2;
        this.zzakt = i3;
        this.zzaku = i4;
        this.zzakv = zzgq;
        this.zzakw = zzfs;
        this.zzakx = zzhp;
        this.zzaky = zzen;
        this.zzakn = zzgi;
        this.zzakz = zzgb;
    }

    private static boolean zzcc(int i) {
        return (i & 536870912) != 0;
    }

    static <T> zzgm<T> zza(Class<T> cls, zzgg zzgg, zzgq zzgq, zzfs zzfs, zzhp<?, ?> zzhp, zzen<?> zzen, zzgb zzgb) {
        int i;
        int i2;
        int i3;
        int[] iArr;
        int i4;
        int i5;
        int i6;
        int i7;
        char c;
        int i8;
        int i9;
        String str;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        Class cls2;
        int i17;
        int i18;
        Field field;
        int i19;
        char charAt;
        int i20;
        char c2;
        Field field2;
        Field field3;
        int i21;
        char charAt2;
        int i22;
        char charAt3;
        int i23;
        char charAt4;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        int i29;
        char charAt5;
        int i30;
        char charAt6;
        int i31;
        char charAt7;
        int i32;
        char charAt8;
        char charAt9;
        char charAt10;
        char charAt11;
        char charAt12;
        char charAt13;
        char charAt14;
        zzgg zzgg2 = zzgg;
        if (zzgg2 instanceof zzgv) {
            zzgv zzgv = (zzgv) zzgg2;
            char c3 = 0;
            boolean z = zzgv.zzvr() == zzd.zzaim;
            String zzvz = zzgv.zzvz();
            int length = zzvz.length();
            char charAt15 = zzvz.charAt(0);
            if (charAt15 >= 55296) {
                char c4 = charAt15 & 8191;
                int i33 = 1;
                int i34 = 13;
                while (true) {
                    i = i33 + 1;
                    charAt14 = zzvz.charAt(i33);
                    if (charAt14 < 55296) {
                        break;
                    }
                    c4 |= (charAt14 & 8191) << i34;
                    i34 += 13;
                    i33 = i;
                }
                charAt15 = (charAt14 << i34) | c4;
            } else {
                i = 1;
            }
            int i35 = i + 1;
            char charAt16 = zzvz.charAt(i);
            if (charAt16 >= 55296) {
                char c5 = charAt16 & 8191;
                int i36 = 13;
                while (true) {
                    i2 = i35 + 1;
                    charAt13 = zzvz.charAt(i35);
                    if (charAt13 < 55296) {
                        break;
                    }
                    c5 |= (charAt13 & 8191) << i36;
                    i36 += 13;
                    i35 = i2;
                }
                charAt16 = c5 | (charAt13 << i36);
            } else {
                i2 = i35;
            }
            if (charAt16 == 0) {
                iArr = zzakh;
                c = 0;
                i7 = 0;
                i6 = 0;
                i5 = 0;
                i4 = 0;
                i3 = 0;
            } else {
                int i37 = i2 + 1;
                int charAt17 = zzvz.charAt(i2);
                if (charAt17 >= 55296) {
                    int i38 = charAt17 & 8191;
                    int i39 = 13;
                    while (true) {
                        i24 = i37 + 1;
                        charAt12 = zzvz.charAt(i37);
                        if (charAt12 < 55296) {
                            break;
                        }
                        i38 |= (charAt12 & 8191) << i39;
                        i39 += 13;
                        i37 = i24;
                    }
                    charAt17 = (charAt12 << i39) | i38;
                } else {
                    i24 = i37;
                }
                int i40 = i24 + 1;
                char charAt18 = zzvz.charAt(i24);
                if (charAt18 >= 55296) {
                    char c6 = charAt18 & 8191;
                    int i41 = 13;
                    while (true) {
                        i25 = i40 + 1;
                        charAt11 = zzvz.charAt(i40);
                        if (charAt11 < 55296) {
                            break;
                        }
                        c6 |= (charAt11 & 8191) << i41;
                        i41 += 13;
                        i40 = i25;
                    }
                    charAt18 = c6 | (charAt11 << i41);
                } else {
                    i25 = i40;
                }
                int i42 = i25 + 1;
                int charAt19 = zzvz.charAt(i25);
                if (charAt19 >= 55296) {
                    int i43 = charAt19 & 8191;
                    int i44 = 13;
                    while (true) {
                        i26 = i42 + 1;
                        charAt10 = zzvz.charAt(i42);
                        if (charAt10 < 55296) {
                            break;
                        }
                        i43 |= (charAt10 & 8191) << i44;
                        i44 += 13;
                        i42 = i26;
                    }
                    charAt19 = (charAt10 << i44) | i43;
                } else {
                    i26 = i42;
                }
                int i45 = i26 + 1;
                i5 = zzvz.charAt(i26);
                if (i5 >= 55296) {
                    int i46 = i5 & 8191;
                    int i47 = 13;
                    while (true) {
                        i27 = i45 + 1;
                        charAt9 = zzvz.charAt(i45);
                        if (charAt9 < 55296) {
                            break;
                        }
                        i46 |= (charAt9 & 8191) << i47;
                        i47 += 13;
                        i45 = i27;
                    }
                    i5 = (charAt9 << i47) | i46;
                } else {
                    i27 = i45;
                }
                int i48 = i27 + 1;
                i4 = zzvz.charAt(i27);
                if (i4 >= 55296) {
                    int i49 = i4 & 8191;
                    int i50 = 13;
                    while (true) {
                        i32 = i48 + 1;
                        charAt8 = zzvz.charAt(i48);
                        if (charAt8 < 55296) {
                            break;
                        }
                        i49 |= (charAt8 & 8191) << i50;
                        i50 += 13;
                        i48 = i32;
                    }
                    i4 = (charAt8 << i50) | i49;
                    i48 = i32;
                }
                int i51 = i48 + 1;
                c = zzvz.charAt(i48);
                if (c >= 55296) {
                    char c7 = c & 8191;
                    int i52 = 13;
                    while (true) {
                        i31 = i51 + 1;
                        charAt7 = zzvz.charAt(i51);
                        if (charAt7 < 55296) {
                            break;
                        }
                        c7 |= (charAt7 & 8191) << i52;
                        i52 += 13;
                        i51 = i31;
                    }
                    c = c7 | (charAt7 << i52);
                    i51 = i31;
                }
                int i53 = i51 + 1;
                char charAt20 = zzvz.charAt(i51);
                if (charAt20 >= 55296) {
                    int i54 = 13;
                    int i55 = i53;
                    int i56 = charAt20 & 8191;
                    int i57 = i55;
                    while (true) {
                        i30 = i57 + 1;
                        charAt6 = zzvz.charAt(i57);
                        if (charAt6 < 55296) {
                            break;
                        }
                        i56 |= (charAt6 & 8191) << i54;
                        i54 += 13;
                        i57 = i30;
                    }
                    charAt20 = i56 | (charAt6 << i54);
                    i28 = i30;
                } else {
                    i28 = i53;
                }
                int i58 = i28 + 1;
                c3 = zzvz.charAt(i28);
                if (c3 >= 55296) {
                    int i59 = 13;
                    int i60 = i58;
                    int i61 = c3 & 8191;
                    int i62 = i60;
                    while (true) {
                        i29 = i62 + 1;
                        charAt5 = zzvz.charAt(i62);
                        if (charAt5 < 55296) {
                            break;
                        }
                        i61 |= (charAt5 & 8191) << i59;
                        i59 += 13;
                        i62 = i29;
                    }
                    c3 = i61 | (charAt5 << i59);
                    i58 = i29;
                }
                iArr = new int[(c3 + c + charAt20)];
                i6 = (charAt17 << 1) + charAt18;
                int i63 = i58;
                i3 = charAt17;
                i7 = charAt19;
                i2 = i63;
            }
            Unsafe unsafe = zzaki;
            Object[] zzwa = zzgv.zzwa();
            Class cls3 = zzgv.zzvt().getClass();
            int i64 = i6;
            int[] iArr2 = new int[(i4 * 3)];
            Object[] objArr = new Object[(i4 << 1)];
            int i65 = c3 + c;
            int i66 = c3;
            int i67 = i65;
            int i68 = 0;
            int i69 = 0;
            while (i2 < length) {
                int i70 = i2 + 1;
                int charAt21 = zzvz.charAt(i2);
                char c8 = 55296;
                if (charAt21 >= 55296) {
                    int i71 = 13;
                    int i72 = i70;
                    int i73 = charAt21 & 8191;
                    int i74 = i72;
                    while (true) {
                        i23 = i74 + 1;
                        charAt4 = zzvz.charAt(i74);
                        if (charAt4 < c8) {
                            break;
                        }
                        i73 |= (charAt4 & 8191) << i71;
                        i71 += 13;
                        i74 = i23;
                        c8 = 55296;
                    }
                    charAt21 = i73 | (charAt4 << i71);
                    i8 = i23;
                } else {
                    i8 = i70;
                }
                int i75 = i8 + 1;
                char charAt22 = zzvz.charAt(i8);
                int i76 = length;
                char c9 = 55296;
                if (charAt22 >= 55296) {
                    int i77 = 13;
                    int i78 = i75;
                    int i79 = charAt22 & 8191;
                    int i80 = i78;
                    while (true) {
                        i22 = i80 + 1;
                        charAt3 = zzvz.charAt(i80);
                        if (charAt3 < c9) {
                            break;
                        }
                        i79 |= (charAt3 & 8191) << i77;
                        i77 += 13;
                        i80 = i22;
                        c9 = 55296;
                    }
                    charAt22 = i79 | (charAt3 << i77);
                    i9 = i22;
                } else {
                    i9 = i75;
                }
                int i81 = c3;
                char c10 = charAt22 & 255;
                boolean z2 = z;
                if ((charAt22 & 1024) != 0) {
                    int i82 = i68 + 1;
                    iArr[i68] = i69;
                    i68 = i82;
                }
                int i83 = i68;
                if (c10 >= '3') {
                    int i84 = i9 + 1;
                    char charAt23 = zzvz.charAt(i9);
                    char c11 = 55296;
                    if (charAt23 >= 55296) {
                        char c12 = charAt23 & 8191;
                        int i85 = 13;
                        while (true) {
                            i21 = i84 + 1;
                            charAt2 = zzvz.charAt(i84);
                            if (charAt2 < c11) {
                                break;
                            }
                            c12 |= (charAt2 & 8191) << i85;
                            i85 += 13;
                            i84 = i21;
                            c11 = 55296;
                        }
                        charAt23 = c12 | (charAt2 << i85);
                        i84 = i21;
                    }
                    int i86 = c10 - '3';
                    int i87 = i84;
                    if (i86 == 9 || i86 == 17) {
                        c2 = 1;
                        int i88 = i64 + 1;
                        objArr[((i69 / 3) << 1) + 1] = zzwa[i64];
                        i64 = i88;
                    } else {
                        if (i86 == 12 && (charAt15 & 1) == 1) {
                            int i89 = i64 + 1;
                            objArr[((i69 / 3) << 1) + 1] = zzwa[i64];
                            i64 = i89;
                        }
                        c2 = 1;
                    }
                    int i90 = charAt23 << c2;
                    Object obj = zzwa[i90];
                    if (obj instanceof Field) {
                        field2 = (Field) obj;
                    } else {
                        field2 = zza(cls3, (String) obj);
                        zzwa[i90] = field2;
                    }
                    int i91 = i7;
                    int objectFieldOffset = (int) unsafe.objectFieldOffset(field2);
                    int i92 = i90 + 1;
                    Object obj2 = zzwa[i92];
                    int i93 = objectFieldOffset;
                    if (obj2 instanceof Field) {
                        field3 = (Field) obj2;
                    } else {
                        field3 = zza(cls3, (String) obj2);
                        zzwa[i92] = field3;
                    }
                    str = zzvz;
                    i15 = (int) unsafe.objectFieldOffset(field3);
                    cls2 = cls3;
                    i11 = i64;
                    i14 = i93;
                    i16 = 0;
                    i10 = i91;
                    i12 = i5;
                    i13 = charAt21;
                    i18 = i87;
                } else {
                    int i94 = i7;
                    int i95 = i64 + 1;
                    Field zza = zza(cls3, (String) zzwa[i64]);
                    i12 = i5;
                    if (c10 == 9 || c10 == 17) {
                        i10 = i94;
                        objArr[((i69 / 3) << 1) + 1] = zza.getType();
                    } else {
                        if (c10 == 27 || c10 == '1') {
                            i10 = i94;
                            i20 = i95 + 1;
                            objArr[((i69 / 3) << 1) + 1] = zzwa[i95];
                        } else if (c10 == 12 || c10 == 30 || c10 == ',') {
                            i10 = i94;
                            if ((charAt15 & 1) == 1) {
                                i20 = i95 + 1;
                                objArr[((i69 / 3) << 1) + 1] = zzwa[i95];
                            }
                        } else if (c10 == '2') {
                            int i96 = i66 + 1;
                            iArr[i66] = i69;
                            int i97 = (i69 / 3) << 1;
                            int i98 = i95 + 1;
                            objArr[i97] = zzwa[i95];
                            if ((charAt22 & 2048) != 0) {
                                i95 = i98 + 1;
                                objArr[i97 + 1] = zzwa[i98];
                                i10 = i94;
                                i66 = i96;
                            } else {
                                i66 = i96;
                                i95 = i98;
                                i10 = i94;
                            }
                        } else {
                            i10 = i94;
                        }
                        i13 = charAt21;
                        i95 = i20;
                        i14 = (int) unsafe.objectFieldOffset(zza);
                        if ((charAt15 & 1) == 1 || c10 > 17) {
                            str = zzvz;
                            cls2 = cls3;
                            i11 = i95;
                            i17 = i9;
                            i16 = 0;
                            i15 = 0;
                        } else {
                            i17 = i9 + 1;
                            char charAt24 = zzvz.charAt(i9);
                            if (charAt24 >= 55296) {
                                char c13 = charAt24 & 8191;
                                int i99 = 13;
                                while (true) {
                                    i19 = i17 + 1;
                                    charAt = zzvz.charAt(i17);
                                    if (charAt < 55296) {
                                        break;
                                    }
                                    c13 |= (charAt & 8191) << i99;
                                    i99 += 13;
                                    i17 = i19;
                                }
                                charAt24 = c13 | (charAt << i99);
                                i17 = i19;
                            }
                            int i100 = (i3 << 1) + (charAt24 / ' ');
                            Object obj3 = zzwa[i100];
                            str = zzvz;
                            if (obj3 instanceof Field) {
                                field = (Field) obj3;
                            } else {
                                field = zza(cls3, (String) obj3);
                                zzwa[i100] = field;
                            }
                            cls2 = cls3;
                            i11 = i95;
                            i15 = (int) unsafe.objectFieldOffset(field);
                            i16 = charAt24 % ' ';
                        }
                        if (c10 >= 18 && c10 <= '1') {
                            int i101 = i67 + 1;
                            iArr[i67] = i14;
                            i67 = i101;
                        }
                        i18 = i17;
                    }
                    i13 = charAt21;
                    i14 = (int) unsafe.objectFieldOffset(zza);
                    if ((charAt15 & 1) == 1) {
                    }
                    str = zzvz;
                    cls2 = cls3;
                    i11 = i95;
                    i17 = i9;
                    i16 = 0;
                    i15 = 0;
                    int i1012 = i67 + 1;
                    iArr[i67] = i14;
                    i67 = i1012;
                    i18 = i17;
                }
                int i102 = i69 + 1;
                iArr2[i69] = i13;
                int i103 = i102 + 1;
                iArr2[i102] = (c10 << 20) | ((charAt22 & 256) != 0 ? 268435456 : 0) | ((charAt22 & 512) != 0 ? 536870912 : 0) | i14;
                i69 = i103 + 1;
                iArr2[i103] = (i16 << 20) | i15;
                cls3 = cls2;
                i5 = i12;
                c3 = i81;
                i64 = i11;
                length = i76;
                z = z2;
                i7 = i10;
                i68 = i83;
                zzvz = str;
            }
            boolean z3 = z;
            zzgm zzgm = new zzgm(iArr2, objArr, i7, i5, zzgv.zzvt(), z, false, iArr, c3, i65, zzgq, zzfs, zzhp, zzen, zzgb);
            return zzgm;
        }
        int zzvr = ((zzhm) zzgg2).zzvr();
        int i104 = zzd.zzaim;
        throw new NoSuchMethodError();
    }

    private static Field zza(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String arrays = Arrays.toString(declaredFields);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40 + String.valueOf(name).length() + String.valueOf(arrays).length());
            sb.append("Field ");
            sb.append(str);
            sb.append(" for ");
            sb.append(name);
            sb.append(" not found. Known fields are ");
            sb.append(arrays);
            throw new RuntimeException(sb.toString());
        }
    }

    public final T newInstance() {
        return this.zzakv.newInstance(this.zzakn);
    }

    /* JADX INFO: used method not loaded: com.google.android.gms.internal.measurement.zzgz.zzd(java.lang.Object, java.lang.Object):null, types can be incorrect */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x006a, code lost:
        if (com.google.android.gms.internal.measurement.zzgz.zzd(com.google.android.gms.internal.measurement.zzhv.zzp(r10, r6), com.google.android.gms.internal.measurement.zzhv.zzp(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x007e, code lost:
        if (com.google.android.gms.internal.measurement.zzhv.zzl(r10, r6) == com.google.android.gms.internal.measurement.zzhv.zzl(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0090, code lost:
        if (com.google.android.gms.internal.measurement.zzhv.zzk(r10, r6) == com.google.android.gms.internal.measurement.zzhv.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a4, code lost:
        if (com.google.android.gms.internal.measurement.zzhv.zzl(r10, r6) == com.google.android.gms.internal.measurement.zzhv.zzl(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00b6, code lost:
        if (com.google.android.gms.internal.measurement.zzhv.zzk(r10, r6) == com.google.android.gms.internal.measurement.zzhv.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00c8, code lost:
        if (com.google.android.gms.internal.measurement.zzhv.zzk(r10, r6) == com.google.android.gms.internal.measurement.zzhv.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00da, code lost:
        if (com.google.android.gms.internal.measurement.zzhv.zzk(r10, r6) == com.google.android.gms.internal.measurement.zzhv.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00f0, code lost:
        if (com.google.android.gms.internal.measurement.zzgz.zzd(com.google.android.gms.internal.measurement.zzhv.zzp(r10, r6), com.google.android.gms.internal.measurement.zzhv.zzp(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0106, code lost:
        if (com.google.android.gms.internal.measurement.zzgz.zzd(com.google.android.gms.internal.measurement.zzhv.zzp(r10, r6), com.google.android.gms.internal.measurement.zzhv.zzp(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x011c, code lost:
        if (com.google.android.gms.internal.measurement.zzgz.zzd(com.google.android.gms.internal.measurement.zzhv.zzp(r10, r6), com.google.android.gms.internal.measurement.zzhv.zzp(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x012e, code lost:
        if (com.google.android.gms.internal.measurement.zzhv.zzm(r10, r6) == com.google.android.gms.internal.measurement.zzhv.zzm(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0140, code lost:
        if (com.google.android.gms.internal.measurement.zzhv.zzk(r10, r6) == com.google.android.gms.internal.measurement.zzhv.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0154, code lost:
        if (com.google.android.gms.internal.measurement.zzhv.zzl(r10, r6) == com.google.android.gms.internal.measurement.zzhv.zzl(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0165, code lost:
        if (com.google.android.gms.internal.measurement.zzhv.zzk(r10, r6) == com.google.android.gms.internal.measurement.zzhv.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0178, code lost:
        if (com.google.android.gms.internal.measurement.zzhv.zzl(r10, r6) == com.google.android.gms.internal.measurement.zzhv.zzl(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x018b, code lost:
        if (com.google.android.gms.internal.measurement.zzhv.zzl(r10, r6) == com.google.android.gms.internal.measurement.zzhv.zzl(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01a4, code lost:
        if (java.lang.Float.floatToIntBits(com.google.android.gms.internal.measurement.zzhv.zzn(r10, r6)) == java.lang.Float.floatToIntBits(com.google.android.gms.internal.measurement.zzhv.zzn(r11, r6))) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01bf, code lost:
        if (java.lang.Double.doubleToLongBits(com.google.android.gms.internal.measurement.zzhv.zzo(r10, r6)) == java.lang.Double.doubleToLongBits(com.google.android.gms.internal.measurement.zzhv.zzo(r11, r6))) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01c1, code lost:
        r3 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0038, code lost:
        if (com.google.android.gms.internal.measurement.zzgz.zzd(com.google.android.gms.internal.measurement.zzhv.zzp(r10, r6), com.google.android.gms.internal.measurement.zzhv.zzp(r11, r6)) != false) goto L_0x01c2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(T r10, T r11) {
        /*
            r9 = this;
            int[] r0 = r9.zzakj
            int r0 = r0.length
            r1 = 0
            r2 = 0
        L_0x0005:
            r3 = 1
            if (r2 >= r0) goto L_0x01c9
            int r4 = r9.zzca(r2)
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r6 = r4 & r5
            long r6 = (long) r6
            r8 = 267386880(0xff00000, float:2.3665827E-29)
            r4 = r4 & r8
            int r4 = r4 >>> 20
            switch(r4) {
                case 0: goto L_0x01a7;
                case 1: goto L_0x018e;
                case 2: goto L_0x017b;
                case 3: goto L_0x0168;
                case 4: goto L_0x0157;
                case 5: goto L_0x0144;
                case 6: goto L_0x0132;
                case 7: goto L_0x0120;
                case 8: goto L_0x010a;
                case 9: goto L_0x00f4;
                case 10: goto L_0x00de;
                case 11: goto L_0x00cc;
                case 12: goto L_0x00ba;
                case 13: goto L_0x00a8;
                case 14: goto L_0x0094;
                case 15: goto L_0x0082;
                case 16: goto L_0x006e;
                case 17: goto L_0x0058;
                case 18: goto L_0x004a;
                case 19: goto L_0x004a;
                case 20: goto L_0x004a;
                case 21: goto L_0x004a;
                case 22: goto L_0x004a;
                case 23: goto L_0x004a;
                case 24: goto L_0x004a;
                case 25: goto L_0x004a;
                case 26: goto L_0x004a;
                case 27: goto L_0x004a;
                case 28: goto L_0x004a;
                case 29: goto L_0x004a;
                case 30: goto L_0x004a;
                case 31: goto L_0x004a;
                case 32: goto L_0x004a;
                case 33: goto L_0x004a;
                case 34: goto L_0x004a;
                case 35: goto L_0x004a;
                case 36: goto L_0x004a;
                case 37: goto L_0x004a;
                case 38: goto L_0x004a;
                case 39: goto L_0x004a;
                case 40: goto L_0x004a;
                case 41: goto L_0x004a;
                case 42: goto L_0x004a;
                case 43: goto L_0x004a;
                case 44: goto L_0x004a;
                case 45: goto L_0x004a;
                case 46: goto L_0x004a;
                case 47: goto L_0x004a;
                case 48: goto L_0x004a;
                case 49: goto L_0x004a;
                case 50: goto L_0x003c;
                case 51: goto L_0x001c;
                case 52: goto L_0x001c;
                case 53: goto L_0x001c;
                case 54: goto L_0x001c;
                case 55: goto L_0x001c;
                case 56: goto L_0x001c;
                case 57: goto L_0x001c;
                case 58: goto L_0x001c;
                case 59: goto L_0x001c;
                case 60: goto L_0x001c;
                case 61: goto L_0x001c;
                case 62: goto L_0x001c;
                case 63: goto L_0x001c;
                case 64: goto L_0x001c;
                case 65: goto L_0x001c;
                case 66: goto L_0x001c;
                case 67: goto L_0x001c;
                case 68: goto L_0x001c;
                default: goto L_0x001a;
            }
        L_0x001a:
            goto L_0x01c2
        L_0x001c:
            int r4 = r9.zzcb(r2)
            r4 = r4 & r5
            long r4 = (long) r4
            int r8 = com.google.android.gms.internal.measurement.zzhv.zzk(r10, r4)
            int r4 = com.google.android.gms.internal.measurement.zzhv.zzk(r11, r4)
            if (r8 != r4) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzhv.zzp(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzhv.zzp(r11, r6)
            boolean r4 = com.google.android.gms.internal.measurement.zzgz.zzd(r4, r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x003c:
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzhv.zzp(r10, r6)
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzhv.zzp(r11, r6)
            boolean r3 = com.google.android.gms.internal.measurement.zzgz.zzd(r3, r4)
            goto L_0x01c2
        L_0x004a:
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzhv.zzp(r10, r6)
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzhv.zzp(r11, r6)
            boolean r3 = com.google.android.gms.internal.measurement.zzgz.zzd(r3, r4)
            goto L_0x01c2
        L_0x0058:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzhv.zzp(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzhv.zzp(r11, r6)
            boolean r4 = com.google.android.gms.internal.measurement.zzgz.zzd(r4, r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x006e:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.measurement.zzhv.zzl(r10, r6)
            long r6 = com.google.android.gms.internal.measurement.zzhv.zzl(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x0082:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.measurement.zzhv.zzk(r10, r6)
            int r5 = com.google.android.gms.internal.measurement.zzhv.zzk(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0094:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.measurement.zzhv.zzl(r10, r6)
            long r6 = com.google.android.gms.internal.measurement.zzhv.zzl(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x00a8:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.measurement.zzhv.zzk(r10, r6)
            int r5 = com.google.android.gms.internal.measurement.zzhv.zzk(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x00ba:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.measurement.zzhv.zzk(r10, r6)
            int r5 = com.google.android.gms.internal.measurement.zzhv.zzk(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x00cc:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.measurement.zzhv.zzk(r10, r6)
            int r5 = com.google.android.gms.internal.measurement.zzhv.zzk(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x00de:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzhv.zzp(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzhv.zzp(r11, r6)
            boolean r4 = com.google.android.gms.internal.measurement.zzgz.zzd(r4, r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x00f4:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzhv.zzp(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzhv.zzp(r11, r6)
            boolean r4 = com.google.android.gms.internal.measurement.zzgz.zzd(r4, r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x010a:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzhv.zzp(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzhv.zzp(r11, r6)
            boolean r4 = com.google.android.gms.internal.measurement.zzgz.zzd(r4, r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x0120:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            boolean r4 = com.google.android.gms.internal.measurement.zzhv.zzm(r10, r6)
            boolean r5 = com.google.android.gms.internal.measurement.zzhv.zzm(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0132:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.measurement.zzhv.zzk(r10, r6)
            int r5 = com.google.android.gms.internal.measurement.zzhv.zzk(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0144:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.measurement.zzhv.zzl(r10, r6)
            long r6 = com.google.android.gms.internal.measurement.zzhv.zzl(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x0157:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.measurement.zzhv.zzk(r10, r6)
            int r5 = com.google.android.gms.internal.measurement.zzhv.zzk(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0168:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.measurement.zzhv.zzl(r10, r6)
            long r6 = com.google.android.gms.internal.measurement.zzhv.zzl(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x017b:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.measurement.zzhv.zzl(r10, r6)
            long r6 = com.google.android.gms.internal.measurement.zzhv.zzl(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x018e:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            float r4 = com.google.android.gms.internal.measurement.zzhv.zzn(r10, r6)
            int r4 = java.lang.Float.floatToIntBits(r4)
            float r5 = com.google.android.gms.internal.measurement.zzhv.zzn(r11, r6)
            int r5 = java.lang.Float.floatToIntBits(r5)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x01a7:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            double r4 = com.google.android.gms.internal.measurement.zzhv.zzo(r10, r6)
            long r4 = java.lang.Double.doubleToLongBits(r4)
            double r6 = com.google.android.gms.internal.measurement.zzhv.zzo(r11, r6)
            long r6 = java.lang.Double.doubleToLongBits(r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
        L_0x01c1:
            r3 = 0
        L_0x01c2:
            if (r3 != 0) goto L_0x01c5
            return r1
        L_0x01c5:
            int r2 = r2 + 3
            goto L_0x0005
        L_0x01c9:
            com.google.android.gms.internal.measurement.zzhp<?, ?> r0 = r9.zzakx
            java.lang.Object r0 = r0.zzx(r10)
            com.google.android.gms.internal.measurement.zzhp<?, ?> r2 = r9.zzakx
            java.lang.Object r2 = r2.zzx(r11)
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x01dc
            return r1
        L_0x01dc:
            boolean r0 = r9.zzako
            if (r0 == 0) goto L_0x01f1
            com.google.android.gms.internal.measurement.zzen<?> r0 = r9.zzaky
            com.google.android.gms.internal.measurement.zzeo r10 = r0.zzh(r10)
            com.google.android.gms.internal.measurement.zzen<?> r0 = r9.zzaky
            com.google.android.gms.internal.measurement.zzeo r11 = r0.zzh(r11)
            boolean r10 = r10.equals(r11)
            return r10
        L_0x01f1:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzgm.equals(java.lang.Object, java.lang.Object):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01c3, code lost:
        r2 = (r2 * 53) + r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0227, code lost:
        r2 = r2 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0228, code lost:
        r1 = r1 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int hashCode(T r9) {
        /*
            r8 = this;
            int[] r0 = r8.zzakj
            int r0 = r0.length
            r1 = 0
            r2 = 0
        L_0x0005:
            if (r1 >= r0) goto L_0x022c
            int r3 = r8.zzca(r1)
            int[] r4 = r8.zzakj
            r4 = r4[r1]
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r5 = r5 & r3
            long r5 = (long) r5
            r7 = 267386880(0xff00000, float:2.3665827E-29)
            r3 = r3 & r7
            int r3 = r3 >>> 20
            r7 = 37
            switch(r3) {
                case 0: goto L_0x0219;
                case 1: goto L_0x020e;
                case 2: goto L_0x0203;
                case 3: goto L_0x01f8;
                case 4: goto L_0x01f1;
                case 5: goto L_0x01e6;
                case 6: goto L_0x01df;
                case 7: goto L_0x01d4;
                case 8: goto L_0x01c7;
                case 9: goto L_0x01b9;
                case 10: goto L_0x01ad;
                case 11: goto L_0x01a5;
                case 12: goto L_0x019d;
                case 13: goto L_0x0195;
                case 14: goto L_0x0189;
                case 15: goto L_0x0181;
                case 16: goto L_0x0175;
                case 17: goto L_0x016a;
                case 18: goto L_0x015e;
                case 19: goto L_0x015e;
                case 20: goto L_0x015e;
                case 21: goto L_0x015e;
                case 22: goto L_0x015e;
                case 23: goto L_0x015e;
                case 24: goto L_0x015e;
                case 25: goto L_0x015e;
                case 26: goto L_0x015e;
                case 27: goto L_0x015e;
                case 28: goto L_0x015e;
                case 29: goto L_0x015e;
                case 30: goto L_0x015e;
                case 31: goto L_0x015e;
                case 32: goto L_0x015e;
                case 33: goto L_0x015e;
                case 34: goto L_0x015e;
                case 35: goto L_0x015e;
                case 36: goto L_0x015e;
                case 37: goto L_0x015e;
                case 38: goto L_0x015e;
                case 39: goto L_0x015e;
                case 40: goto L_0x015e;
                case 41: goto L_0x015e;
                case 42: goto L_0x015e;
                case 43: goto L_0x015e;
                case 44: goto L_0x015e;
                case 45: goto L_0x015e;
                case 46: goto L_0x015e;
                case 47: goto L_0x015e;
                case 48: goto L_0x015e;
                case 49: goto L_0x015e;
                case 50: goto L_0x0152;
                case 51: goto L_0x013c;
                case 52: goto L_0x012a;
                case 53: goto L_0x0118;
                case 54: goto L_0x0106;
                case 55: goto L_0x00f8;
                case 56: goto L_0x00e6;
                case 57: goto L_0x00d8;
                case 58: goto L_0x00c6;
                case 59: goto L_0x00b2;
                case 60: goto L_0x00a0;
                case 61: goto L_0x008e;
                case 62: goto L_0x0080;
                case 63: goto L_0x0072;
                case 64: goto L_0x0064;
                case 65: goto L_0x0052;
                case 66: goto L_0x0044;
                case 67: goto L_0x0032;
                case 68: goto L_0x0020;
                default: goto L_0x001e;
            }
        L_0x001e:
            goto L_0x0228
        L_0x0020:
            boolean r3 = r8.zza((T) r9, r4, r1)
            if (r3 == 0) goto L_0x0228
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzhv.zzp(r9, r5)
            int r2 = r2 * 53
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x0032:
            boolean r3 = r8.zza((T) r9, r4, r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            long r3 = zzi(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzez.zzbx(r3)
            goto L_0x0227
        L_0x0044:
            boolean r3 = r8.zza((T) r9, r4, r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = zzh(r9, r5)
            goto L_0x0227
        L_0x0052:
            boolean r3 = r8.zza((T) r9, r4, r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            long r3 = zzi(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzez.zzbx(r3)
            goto L_0x0227
        L_0x0064:
            boolean r3 = r8.zza((T) r9, r4, r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = zzh(r9, r5)
            goto L_0x0227
        L_0x0072:
            boolean r3 = r8.zza((T) r9, r4, r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = zzh(r9, r5)
            goto L_0x0227
        L_0x0080:
            boolean r3 = r8.zza((T) r9, r4, r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = zzh(r9, r5)
            goto L_0x0227
        L_0x008e:
            boolean r3 = r8.zza((T) r9, r4, r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzhv.zzp(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x00a0:
            boolean r3 = r8.zza((T) r9, r4, r1)
            if (r3 == 0) goto L_0x0228
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzhv.zzp(r9, r5)
            int r2 = r2 * 53
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x00b2:
            boolean r3 = r8.zza((T) r9, r4, r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzhv.zzp(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x00c6:
            boolean r3 = r8.zza((T) r9, r4, r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            boolean r3 = zzj(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzez.zzs(r3)
            goto L_0x0227
        L_0x00d8:
            boolean r3 = r8.zza((T) r9, r4, r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = zzh(r9, r5)
            goto L_0x0227
        L_0x00e6:
            boolean r3 = r8.zza((T) r9, r4, r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            long r3 = zzi(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzez.zzbx(r3)
            goto L_0x0227
        L_0x00f8:
            boolean r3 = r8.zza((T) r9, r4, r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = zzh(r9, r5)
            goto L_0x0227
        L_0x0106:
            boolean r3 = r8.zza((T) r9, r4, r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            long r3 = zzi(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzez.zzbx(r3)
            goto L_0x0227
        L_0x0118:
            boolean r3 = r8.zza((T) r9, r4, r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            long r3 = zzi(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzez.zzbx(r3)
            goto L_0x0227
        L_0x012a:
            boolean r3 = r8.zza((T) r9, r4, r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            float r3 = zzg(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0227
        L_0x013c:
            boolean r3 = r8.zza((T) r9, r4, r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            double r3 = zzf(r9, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.android.gms.internal.measurement.zzez.zzbx(r3)
            goto L_0x0227
        L_0x0152:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzhv.zzp(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x015e:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzhv.zzp(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x016a:
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzhv.zzp(r9, r5)
            if (r3 == 0) goto L_0x01c3
            int r7 = r3.hashCode()
            goto L_0x01c3
        L_0x0175:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.measurement.zzhv.zzl(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzez.zzbx(r3)
            goto L_0x0227
        L_0x0181:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.measurement.zzhv.zzk(r9, r5)
            goto L_0x0227
        L_0x0189:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.measurement.zzhv.zzl(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzez.zzbx(r3)
            goto L_0x0227
        L_0x0195:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.measurement.zzhv.zzk(r9, r5)
            goto L_0x0227
        L_0x019d:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.measurement.zzhv.zzk(r9, r5)
            goto L_0x0227
        L_0x01a5:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.measurement.zzhv.zzk(r9, r5)
            goto L_0x0227
        L_0x01ad:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzhv.zzp(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x01b9:
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzhv.zzp(r9, r5)
            if (r3 == 0) goto L_0x01c3
            int r7 = r3.hashCode()
        L_0x01c3:
            int r2 = r2 * 53
            int r2 = r2 + r7
            goto L_0x0228
        L_0x01c7:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzhv.zzp(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x01d4:
            int r2 = r2 * 53
            boolean r3 = com.google.android.gms.internal.measurement.zzhv.zzm(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzez.zzs(r3)
            goto L_0x0227
        L_0x01df:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.measurement.zzhv.zzk(r9, r5)
            goto L_0x0227
        L_0x01e6:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.measurement.zzhv.zzl(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzez.zzbx(r3)
            goto L_0x0227
        L_0x01f1:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.measurement.zzhv.zzk(r9, r5)
            goto L_0x0227
        L_0x01f8:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.measurement.zzhv.zzl(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzez.zzbx(r3)
            goto L_0x0227
        L_0x0203:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.measurement.zzhv.zzl(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzez.zzbx(r3)
            goto L_0x0227
        L_0x020e:
            int r2 = r2 * 53
            float r3 = com.google.android.gms.internal.measurement.zzhv.zzn(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0227
        L_0x0219:
            int r2 = r2 * 53
            double r3 = com.google.android.gms.internal.measurement.zzhv.zzo(r9, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.android.gms.internal.measurement.zzez.zzbx(r3)
        L_0x0227:
            int r2 = r2 + r3
        L_0x0228:
            int r1 = r1 + 3
            goto L_0x0005
        L_0x022c:
            int r2 = r2 * 53
            com.google.android.gms.internal.measurement.zzhp<?, ?> r0 = r8.zzakx
            java.lang.Object r0 = r0.zzx(r9)
            int r0 = r0.hashCode()
            int r2 = r2 + r0
            boolean r0 = r8.zzako
            if (r0 == 0) goto L_0x024a
            int r2 = r2 * 53
            com.google.android.gms.internal.measurement.zzen<?> r0 = r8.zzaky
            com.google.android.gms.internal.measurement.zzeo r9 = r0.zzh(r9)
            int r9 = r9.hashCode()
            int r2 = r2 + r9
        L_0x024a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzgm.hashCode(java.lang.Object):int");
    }

    public final void zzc(T t, T t2) {
        if (t2 != null) {
            for (int i = 0; i < this.zzakj.length; i += 3) {
                int zzca = zzca(i);
                long j = (long) (1048575 & zzca);
                int i2 = this.zzakj[i];
                switch ((zzca & 267386880) >>> 20) {
                    case 0:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzhv.zza((Object) t, j, zzhv.zzo(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 1:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzhv.zza((Object) t, j, zzhv.zzn(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 2:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzhv.zza((Object) t, j, zzhv.zzl(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 3:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzhv.zza((Object) t, j, zzhv.zzl(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 4:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzhv.zzb((Object) t, j, zzhv.zzk(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 5:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzhv.zza((Object) t, j, zzhv.zzl(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 6:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzhv.zzb((Object) t, j, zzhv.zzk(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 7:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzhv.zza((Object) t, j, zzhv.zzm(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 8:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzhv.zza((Object) t, j, zzhv.zzp(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 9:
                        zza(t, t2, i);
                        break;
                    case 10:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzhv.zza((Object) t, j, zzhv.zzp(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 11:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzhv.zzb((Object) t, j, zzhv.zzk(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 12:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzhv.zzb((Object) t, j, zzhv.zzk(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 13:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzhv.zzb((Object) t, j, zzhv.zzk(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 14:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzhv.zza((Object) t, j, zzhv.zzl(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 15:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzhv.zzb((Object) t, j, zzhv.zzk(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 16:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzhv.zza((Object) t, j, zzhv.zzl(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 17:
                        zza(t, t2, i);
                        break;
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case 48:
                    case 49:
                        this.zzakw.zza(t, t2, j);
                        break;
                    case 50:
                        zzgz.zza(this.zzakz, t, t2, j);
                        break;
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                        if (!zza(t2, i2, i)) {
                            break;
                        } else {
                            zzhv.zza((Object) t, j, zzhv.zzp(t2, j));
                            zzb(t, i2, i);
                            break;
                        }
                    case 60:
                        zzb(t, t2, i);
                        break;
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                        if (!zza(t2, i2, i)) {
                            break;
                        } else {
                            zzhv.zza((Object) t, j, zzhv.zzp(t2, j));
                            zzb(t, i2, i);
                            break;
                        }
                    case 68:
                        zzb(t, t2, i);
                        break;
                }
            }
            if (!this.zzakq) {
                zzgz.zza(this.zzakx, t, t2);
                if (this.zzako) {
                    zzgz.zza(this.zzaky, t, t2);
                    return;
                }
                return;
            }
            return;
        }
        throw new NullPointerException();
    }

    private final void zza(T t, T t2, int i) {
        long zzca = (long) (zzca(i) & 1048575);
        if (zza(t2, i)) {
            Object zzp = zzhv.zzp(t, zzca);
            Object zzp2 = zzhv.zzp(t2, zzca);
            if (zzp == null || zzp2 == null) {
                if (zzp2 != null) {
                    zzhv.zza((Object) t, zzca, zzp2);
                    zzb(t, i);
                }
                return;
            }
            zzhv.zza((Object) t, zzca, zzez.zza(zzp, zzp2));
            zzb(t, i);
        }
    }

    private final void zzb(T t, T t2, int i) {
        int zzca = zzca(i);
        int i2 = this.zzakj[i];
        long j = (long) (zzca & 1048575);
        if (zza(t2, i2, i)) {
            Object zzp = zzhv.zzp(t, j);
            Object zzp2 = zzhv.zzp(t2, j);
            if (zzp == null || zzp2 == null) {
                if (zzp2 != null) {
                    zzhv.zza((Object) t, j, zzp2);
                    zzb(t, i2, i);
                }
                return;
            }
            zzhv.zza((Object) t, j, zzez.zza(zzp, zzp2));
            zzb(t, i2, i);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:398:0x0834, code lost:
        r8 = (r8 + r9) + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:415:0x0900, code lost:
        r5 = r5 + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:421:0x0915, code lost:
        r13 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:437:0x095a, code lost:
        r5 = r5 + r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:474:0x0a0b, code lost:
        r5 = r5 + r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:482:0x0a2e, code lost:
        r3 = r3 + 3;
        r9 = r13;
        r7 = 1048575;
        r8 = 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzt(T r20) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            boolean r2 = r0.zzakq
            r3 = 267386880(0xff00000, float:2.3665827E-29)
            r4 = 0
            r7 = 1048575(0xfffff, float:1.469367E-39)
            r8 = 1
            r9 = 0
            r11 = 0
            if (r2 == 0) goto L_0x04f2
            sun.misc.Unsafe r2 = zzaki
            r12 = 0
            r13 = 0
        L_0x0016:
            int[] r14 = r0.zzakj
            int r14 = r14.length
            if (r12 >= r14) goto L_0x04ea
            int r14 = r0.zzca(r12)
            r15 = r14 & r3
            int r15 = r15 >>> 20
            int[] r3 = r0.zzakj
            r3 = r3[r12]
            r14 = r14 & r7
            long r5 = (long) r14
            com.google.android.gms.internal.measurement.zzet r14 = com.google.android.gms.internal.measurement.zzet.DOUBLE_LIST_PACKED
            int r14 = r14.id()
            if (r15 < r14) goto L_0x0041
            com.google.android.gms.internal.measurement.zzet r14 = com.google.android.gms.internal.measurement.zzet.SINT64_LIST_PACKED
            int r14 = r14.id()
            if (r15 > r14) goto L_0x0041
            int[] r14 = r0.zzakj
            int r17 = r12 + 2
            r14 = r14[r17]
            r14 = r14 & r7
            goto L_0x0042
        L_0x0041:
            r14 = 0
        L_0x0042:
            switch(r15) {
                case 0: goto L_0x04d6;
                case 1: goto L_0x04ca;
                case 2: goto L_0x04ba;
                case 3: goto L_0x04aa;
                case 4: goto L_0x049a;
                case 5: goto L_0x048e;
                case 6: goto L_0x0482;
                case 7: goto L_0x0476;
                case 8: goto L_0x0458;
                case 9: goto L_0x0444;
                case 10: goto L_0x0433;
                case 11: goto L_0x0424;
                case 12: goto L_0x0415;
                case 13: goto L_0x040a;
                case 14: goto L_0x03ff;
                case 15: goto L_0x03f0;
                case 16: goto L_0x03e1;
                case 17: goto L_0x03cc;
                case 18: goto L_0x03c1;
                case 19: goto L_0x03b8;
                case 20: goto L_0x03af;
                case 21: goto L_0x03a6;
                case 22: goto L_0x039d;
                case 23: goto L_0x0394;
                case 24: goto L_0x038b;
                case 25: goto L_0x0382;
                case 26: goto L_0x0379;
                case 27: goto L_0x036c;
                case 28: goto L_0x0363;
                case 29: goto L_0x035a;
                case 30: goto L_0x0350;
                case 31: goto L_0x0346;
                case 32: goto L_0x033c;
                case 33: goto L_0x0332;
                case 34: goto L_0x0328;
                case 35: goto L_0x0308;
                case 36: goto L_0x02eb;
                case 37: goto L_0x02ce;
                case 38: goto L_0x02b1;
                case 39: goto L_0x0293;
                case 40: goto L_0x0275;
                case 41: goto L_0x0257;
                case 42: goto L_0x0239;
                case 43: goto L_0x021b;
                case 44: goto L_0x01fd;
                case 45: goto L_0x01df;
                case 46: goto L_0x01c1;
                case 47: goto L_0x01a3;
                case 48: goto L_0x0185;
                case 49: goto L_0x0177;
                case 50: goto L_0x0167;
                case 51: goto L_0x0159;
                case 52: goto L_0x014d;
                case 53: goto L_0x013d;
                case 54: goto L_0x012d;
                case 55: goto L_0x011d;
                case 56: goto L_0x0111;
                case 57: goto L_0x0105;
                case 58: goto L_0x00f9;
                case 59: goto L_0x00db;
                case 60: goto L_0x00c7;
                case 61: goto L_0x00b5;
                case 62: goto L_0x00a5;
                case 63: goto L_0x0095;
                case 64: goto L_0x0089;
                case 65: goto L_0x007d;
                case 66: goto L_0x006d;
                case 67: goto L_0x005d;
                case 68: goto L_0x0047;
                default: goto L_0x0045;
            }
        L_0x0045:
            goto L_0x04e4
        L_0x0047:
            boolean r14 = r0.zza((T) r1, r3, r12)
            if (r14 == 0) goto L_0x04e4
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzhv.zzp(r1, r5)
            com.google.android.gms.internal.measurement.zzgi r5 = (com.google.android.gms.internal.measurement.zzgi) r5
            com.google.android.gms.internal.measurement.zzgx r6 = r0.zzbx(r12)
            int r3 = com.google.android.gms.internal.measurement.zzee.zzc(r3, r5, r6)
            goto L_0x03c9
        L_0x005d:
            boolean r14 = r0.zza((T) r1, r3, r12)
            if (r14 == 0) goto L_0x04e4
            long r5 = zzi(r1, r5)
            int r3 = com.google.android.gms.internal.measurement.zzee.zzf(r3, r5)
            goto L_0x03c9
        L_0x006d:
            boolean r14 = r0.zza((T) r1, r3, r12)
            if (r14 == 0) goto L_0x04e4
            int r5 = zzh(r1, r5)
            int r3 = com.google.android.gms.internal.measurement.zzee.zzi(r3, r5)
            goto L_0x03c9
        L_0x007d:
            boolean r5 = r0.zza((T) r1, r3, r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.measurement.zzee.zzh(r3, r9)
            goto L_0x03c9
        L_0x0089:
            boolean r5 = r0.zza((T) r1, r3, r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.measurement.zzee.zzk(r3, r11)
            goto L_0x03c9
        L_0x0095:
            boolean r14 = r0.zza((T) r1, r3, r12)
            if (r14 == 0) goto L_0x04e4
            int r5 = zzh(r1, r5)
            int r3 = com.google.android.gms.internal.measurement.zzee.zzl(r3, r5)
            goto L_0x03c9
        L_0x00a5:
            boolean r14 = r0.zza((T) r1, r3, r12)
            if (r14 == 0) goto L_0x04e4
            int r5 = zzh(r1, r5)
            int r3 = com.google.android.gms.internal.measurement.zzee.zzh(r3, r5)
            goto L_0x03c9
        L_0x00b5:
            boolean r14 = r0.zza((T) r1, r3, r12)
            if (r14 == 0) goto L_0x04e4
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzhv.zzp(r1, r5)
            com.google.android.gms.internal.measurement.zzdp r5 = (com.google.android.gms.internal.measurement.zzdp) r5
            int r3 = com.google.android.gms.internal.measurement.zzee.zzc(r3, r5)
            goto L_0x03c9
        L_0x00c7:
            boolean r14 = r0.zza((T) r1, r3, r12)
            if (r14 == 0) goto L_0x04e4
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzhv.zzp(r1, r5)
            com.google.android.gms.internal.measurement.zzgx r6 = r0.zzbx(r12)
            int r3 = com.google.android.gms.internal.measurement.zzgz.zzc(r3, r5, r6)
            goto L_0x03c9
        L_0x00db:
            boolean r14 = r0.zza((T) r1, r3, r12)
            if (r14 == 0) goto L_0x04e4
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzhv.zzp(r1, r5)
            boolean r6 = r5 instanceof com.google.android.gms.internal.measurement.zzdp
            if (r6 == 0) goto L_0x00f1
            com.google.android.gms.internal.measurement.zzdp r5 = (com.google.android.gms.internal.measurement.zzdp) r5
            int r3 = com.google.android.gms.internal.measurement.zzee.zzc(r3, r5)
            goto L_0x03c9
        L_0x00f1:
            java.lang.String r5 = (java.lang.String) r5
            int r3 = com.google.android.gms.internal.measurement.zzee.zzc(r3, r5)
            goto L_0x03c9
        L_0x00f9:
            boolean r5 = r0.zza((T) r1, r3, r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.measurement.zzee.zzc(r3, r8)
            goto L_0x03c9
        L_0x0105:
            boolean r5 = r0.zza((T) r1, r3, r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.measurement.zzee.zzj(r3, r11)
            goto L_0x03c9
        L_0x0111:
            boolean r5 = r0.zza((T) r1, r3, r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.measurement.zzee.zzg(r3, r9)
            goto L_0x03c9
        L_0x011d:
            boolean r14 = r0.zza((T) r1, r3, r12)
            if (r14 == 0) goto L_0x04e4
            int r5 = zzh(r1, r5)
            int r3 = com.google.android.gms.internal.measurement.zzee.zzg(r3, r5)
            goto L_0x03c9
        L_0x012d:
            boolean r14 = r0.zza((T) r1, r3, r12)
            if (r14 == 0) goto L_0x04e4
            long r5 = zzi(r1, r5)
            int r3 = com.google.android.gms.internal.measurement.zzee.zze(r3, r5)
            goto L_0x03c9
        L_0x013d:
            boolean r14 = r0.zza((T) r1, r3, r12)
            if (r14 == 0) goto L_0x04e4
            long r5 = zzi(r1, r5)
            int r3 = com.google.android.gms.internal.measurement.zzee.zzd(r3, r5)
            goto L_0x03c9
        L_0x014d:
            boolean r5 = r0.zza((T) r1, r3, r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.measurement.zzee.zzb(r3, r4)
            goto L_0x03c9
        L_0x0159:
            boolean r5 = r0.zza((T) r1, r3, r12)
            if (r5 == 0) goto L_0x04e4
            r5 = 0
            int r3 = com.google.android.gms.internal.measurement.zzee.zzb(r3, r5)
            goto L_0x03c9
        L_0x0167:
            com.google.android.gms.internal.measurement.zzgb r14 = r0.zzakz
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzhv.zzp(r1, r5)
            java.lang.Object r6 = r0.zzby(r12)
            int r3 = r14.zzb(r3, r5, r6)
            goto L_0x03c9
        L_0x0177:
            java.util.List r5 = zze(r1, r5)
            com.google.android.gms.internal.measurement.zzgx r6 = r0.zzbx(r12)
            int r3 = com.google.android.gms.internal.measurement.zzgz.zzd(r3, r5, r6)
            goto L_0x03c9
        L_0x0185:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.zzgz.zzw(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzakr
            if (r6 == 0) goto L_0x0199
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x0199:
            int r3 = com.google.android.gms.internal.measurement.zzee.zzbi(r3)
            int r6 = com.google.android.gms.internal.measurement.zzee.zzbk(r5)
            goto L_0x0324
        L_0x01a3:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.zzgz.zzaa(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzakr
            if (r6 == 0) goto L_0x01b7
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x01b7:
            int r3 = com.google.android.gms.internal.measurement.zzee.zzbi(r3)
            int r6 = com.google.android.gms.internal.measurement.zzee.zzbk(r5)
            goto L_0x0324
        L_0x01c1:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.zzgz.zzac(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzakr
            if (r6 == 0) goto L_0x01d5
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x01d5:
            int r3 = com.google.android.gms.internal.measurement.zzee.zzbi(r3)
            int r6 = com.google.android.gms.internal.measurement.zzee.zzbk(r5)
            goto L_0x0324
        L_0x01df:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.zzgz.zzab(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzakr
            if (r6 == 0) goto L_0x01f3
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x01f3:
            int r3 = com.google.android.gms.internal.measurement.zzee.zzbi(r3)
            int r6 = com.google.android.gms.internal.measurement.zzee.zzbk(r5)
            goto L_0x0324
        L_0x01fd:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.zzgz.zzx(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzakr
            if (r6 == 0) goto L_0x0211
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x0211:
            int r3 = com.google.android.gms.internal.measurement.zzee.zzbi(r3)
            int r6 = com.google.android.gms.internal.measurement.zzee.zzbk(r5)
            goto L_0x0324
        L_0x021b:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.zzgz.zzz(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzakr
            if (r6 == 0) goto L_0x022f
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x022f:
            int r3 = com.google.android.gms.internal.measurement.zzee.zzbi(r3)
            int r6 = com.google.android.gms.internal.measurement.zzee.zzbk(r5)
            goto L_0x0324
        L_0x0239:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.zzgz.zzad(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzakr
            if (r6 == 0) goto L_0x024d
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x024d:
            int r3 = com.google.android.gms.internal.measurement.zzee.zzbi(r3)
            int r6 = com.google.android.gms.internal.measurement.zzee.zzbk(r5)
            goto L_0x0324
        L_0x0257:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.zzgz.zzab(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzakr
            if (r6 == 0) goto L_0x026b
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x026b:
            int r3 = com.google.android.gms.internal.measurement.zzee.zzbi(r3)
            int r6 = com.google.android.gms.internal.measurement.zzee.zzbk(r5)
            goto L_0x0324
        L_0x0275:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.zzgz.zzac(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzakr
            if (r6 == 0) goto L_0x0289
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x0289:
            int r3 = com.google.android.gms.internal.measurement.zzee.zzbi(r3)
            int r6 = com.google.android.gms.internal.measurement.zzee.zzbk(r5)
            goto L_0x0324
        L_0x0293:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.zzgz.zzy(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzakr
            if (r6 == 0) goto L_0x02a7
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x02a7:
            int r3 = com.google.android.gms.internal.measurement.zzee.zzbi(r3)
            int r6 = com.google.android.gms.internal.measurement.zzee.zzbk(r5)
            goto L_0x0324
        L_0x02b1:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.zzgz.zzv(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzakr
            if (r6 == 0) goto L_0x02c5
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x02c5:
            int r3 = com.google.android.gms.internal.measurement.zzee.zzbi(r3)
            int r6 = com.google.android.gms.internal.measurement.zzee.zzbk(r5)
            goto L_0x0324
        L_0x02ce:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.zzgz.zzu(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzakr
            if (r6 == 0) goto L_0x02e2
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x02e2:
            int r3 = com.google.android.gms.internal.measurement.zzee.zzbi(r3)
            int r6 = com.google.android.gms.internal.measurement.zzee.zzbk(r5)
            goto L_0x0324
        L_0x02eb:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.zzgz.zzab(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzakr
            if (r6 == 0) goto L_0x02ff
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x02ff:
            int r3 = com.google.android.gms.internal.measurement.zzee.zzbi(r3)
            int r6 = com.google.android.gms.internal.measurement.zzee.zzbk(r5)
            goto L_0x0324
        L_0x0308:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.zzgz.zzac(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzakr
            if (r6 == 0) goto L_0x031c
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x031c:
            int r3 = com.google.android.gms.internal.measurement.zzee.zzbi(r3)
            int r6 = com.google.android.gms.internal.measurement.zzee.zzbk(r5)
        L_0x0324:
            int r3 = r3 + r6
            int r3 = r3 + r5
            goto L_0x03c9
        L_0x0328:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.measurement.zzgz.zzq(r3, r5, r11)
            goto L_0x03c9
        L_0x0332:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.measurement.zzgz.zzu(r3, r5, r11)
            goto L_0x03c9
        L_0x033c:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.measurement.zzgz.zzw(r3, r5, r11)
            goto L_0x03c9
        L_0x0346:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.measurement.zzgz.zzv(r3, r5, r11)
            goto L_0x03c9
        L_0x0350:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.measurement.zzgz.zzr(r3, r5, r11)
            goto L_0x03c9
        L_0x035a:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.measurement.zzgz.zzt(r3, r5, r11)
            goto L_0x03c9
        L_0x0363:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.measurement.zzgz.zzd(r3, r5)
            goto L_0x03c9
        L_0x036c:
            java.util.List r5 = zze(r1, r5)
            com.google.android.gms.internal.measurement.zzgx r6 = r0.zzbx(r12)
            int r3 = com.google.android.gms.internal.measurement.zzgz.zzc(r3, r5, r6)
            goto L_0x03c9
        L_0x0379:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.measurement.zzgz.zzc(r3, r5)
            goto L_0x03c9
        L_0x0382:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.measurement.zzgz.zzx(r3, r5, r11)
            goto L_0x03c9
        L_0x038b:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.measurement.zzgz.zzv(r3, r5, r11)
            goto L_0x03c9
        L_0x0394:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.measurement.zzgz.zzw(r3, r5, r11)
            goto L_0x03c9
        L_0x039d:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.measurement.zzgz.zzs(r3, r5, r11)
            goto L_0x03c9
        L_0x03a6:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.measurement.zzgz.zzp(r3, r5, r11)
            goto L_0x03c9
        L_0x03af:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.measurement.zzgz.zzo(r3, r5, r11)
            goto L_0x03c9
        L_0x03b8:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.measurement.zzgz.zzv(r3, r5, r11)
            goto L_0x03c9
        L_0x03c1:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.measurement.zzgz.zzw(r3, r5, r11)
        L_0x03c9:
            int r13 = r13 + r3
            goto L_0x04e4
        L_0x03cc:
            boolean r14 = r0.zza((T) r1, r12)
            if (r14 == 0) goto L_0x04e4
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzhv.zzp(r1, r5)
            com.google.android.gms.internal.measurement.zzgi r5 = (com.google.android.gms.internal.measurement.zzgi) r5
            com.google.android.gms.internal.measurement.zzgx r6 = r0.zzbx(r12)
            int r3 = com.google.android.gms.internal.measurement.zzee.zzc(r3, r5, r6)
            goto L_0x03c9
        L_0x03e1:
            boolean r14 = r0.zza((T) r1, r12)
            if (r14 == 0) goto L_0x04e4
            long r5 = com.google.android.gms.internal.measurement.zzhv.zzl(r1, r5)
            int r3 = com.google.android.gms.internal.measurement.zzee.zzf(r3, r5)
            goto L_0x03c9
        L_0x03f0:
            boolean r14 = r0.zza((T) r1, r12)
            if (r14 == 0) goto L_0x04e4
            int r5 = com.google.android.gms.internal.measurement.zzhv.zzk(r1, r5)
            int r3 = com.google.android.gms.internal.measurement.zzee.zzi(r3, r5)
            goto L_0x03c9
        L_0x03ff:
            boolean r5 = r0.zza((T) r1, r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.measurement.zzee.zzh(r3, r9)
            goto L_0x03c9
        L_0x040a:
            boolean r5 = r0.zza((T) r1, r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.measurement.zzee.zzk(r3, r11)
            goto L_0x03c9
        L_0x0415:
            boolean r14 = r0.zza((T) r1, r12)
            if (r14 == 0) goto L_0x04e4
            int r5 = com.google.android.gms.internal.measurement.zzhv.zzk(r1, r5)
            int r3 = com.google.android.gms.internal.measurement.zzee.zzl(r3, r5)
            goto L_0x03c9
        L_0x0424:
            boolean r14 = r0.zza((T) r1, r12)
            if (r14 == 0) goto L_0x04e4
            int r5 = com.google.android.gms.internal.measurement.zzhv.zzk(r1, r5)
            int r3 = com.google.android.gms.internal.measurement.zzee.zzh(r3, r5)
            goto L_0x03c9
        L_0x0433:
            boolean r14 = r0.zza((T) r1, r12)
            if (r14 == 0) goto L_0x04e4
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzhv.zzp(r1, r5)
            com.google.android.gms.internal.measurement.zzdp r5 = (com.google.android.gms.internal.measurement.zzdp) r5
            int r3 = com.google.android.gms.internal.measurement.zzee.zzc(r3, r5)
            goto L_0x03c9
        L_0x0444:
            boolean r14 = r0.zza((T) r1, r12)
            if (r14 == 0) goto L_0x04e4
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzhv.zzp(r1, r5)
            com.google.android.gms.internal.measurement.zzgx r6 = r0.zzbx(r12)
            int r3 = com.google.android.gms.internal.measurement.zzgz.zzc(r3, r5, r6)
            goto L_0x03c9
        L_0x0458:
            boolean r14 = r0.zza((T) r1, r12)
            if (r14 == 0) goto L_0x04e4
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzhv.zzp(r1, r5)
            boolean r6 = r5 instanceof com.google.android.gms.internal.measurement.zzdp
            if (r6 == 0) goto L_0x046e
            com.google.android.gms.internal.measurement.zzdp r5 = (com.google.android.gms.internal.measurement.zzdp) r5
            int r3 = com.google.android.gms.internal.measurement.zzee.zzc(r3, r5)
            goto L_0x03c9
        L_0x046e:
            java.lang.String r5 = (java.lang.String) r5
            int r3 = com.google.android.gms.internal.measurement.zzee.zzc(r3, r5)
            goto L_0x03c9
        L_0x0476:
            boolean r5 = r0.zza((T) r1, r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.measurement.zzee.zzc(r3, r8)
            goto L_0x03c9
        L_0x0482:
            boolean r5 = r0.zza((T) r1, r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.measurement.zzee.zzj(r3, r11)
            goto L_0x03c9
        L_0x048e:
            boolean r5 = r0.zza((T) r1, r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.measurement.zzee.zzg(r3, r9)
            goto L_0x03c9
        L_0x049a:
            boolean r14 = r0.zza((T) r1, r12)
            if (r14 == 0) goto L_0x04e4
            int r5 = com.google.android.gms.internal.measurement.zzhv.zzk(r1, r5)
            int r3 = com.google.android.gms.internal.measurement.zzee.zzg(r3, r5)
            goto L_0x03c9
        L_0x04aa:
            boolean r14 = r0.zza((T) r1, r12)
            if (r14 == 0) goto L_0x04e4
            long r5 = com.google.android.gms.internal.measurement.zzhv.zzl(r1, r5)
            int r3 = com.google.android.gms.internal.measurement.zzee.zze(r3, r5)
            goto L_0x03c9
        L_0x04ba:
            boolean r14 = r0.zza((T) r1, r12)
            if (r14 == 0) goto L_0x04e4
            long r5 = com.google.android.gms.internal.measurement.zzhv.zzl(r1, r5)
            int r3 = com.google.android.gms.internal.measurement.zzee.zzd(r3, r5)
            goto L_0x03c9
        L_0x04ca:
            boolean r5 = r0.zza((T) r1, r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.measurement.zzee.zzb(r3, r4)
            goto L_0x03c9
        L_0x04d6:
            boolean r5 = r0.zza((T) r1, r12)
            if (r5 == 0) goto L_0x04e4
            r5 = 0
            int r3 = com.google.android.gms.internal.measurement.zzee.zzb(r3, r5)
            goto L_0x03c9
        L_0x04e4:
            int r12 = r12 + 3
            r3 = 267386880(0xff00000, float:2.3665827E-29)
            goto L_0x0016
        L_0x04ea:
            com.google.android.gms.internal.measurement.zzhp<?, ?> r2 = r0.zzakx
            int r1 = zza(r2, (T) r1)
            int r13 = r13 + r1
            return r13
        L_0x04f2:
            sun.misc.Unsafe r2 = zzaki
            r3 = -1
            r3 = 0
            r5 = 0
            r6 = -1
            r12 = 0
        L_0x04f9:
            int[] r13 = r0.zzakj
            int r13 = r13.length
            if (r3 >= r13) goto L_0x0a39
            int r13 = r0.zzca(r3)
            int[] r14 = r0.zzakj
            r15 = r14[r3]
            r16 = 267386880(0xff00000, float:2.3665827E-29)
            r17 = r13 & r16
            int r4 = r17 >>> 20
            r11 = 17
            if (r4 > r11) goto L_0x0525
            int r11 = r3 + 2
            r11 = r14[r11]
            r14 = r11 & r7
            int r18 = r11 >>> 20
            int r18 = r8 << r18
            if (r14 == r6) goto L_0x0522
            long r8 = (long) r14
            int r12 = r2.getInt(r1, r8)
            goto L_0x0523
        L_0x0522:
            r14 = r6
        L_0x0523:
            r6 = r14
            goto L_0x0545
        L_0x0525:
            boolean r8 = r0.zzakr
            if (r8 == 0) goto L_0x0542
            com.google.android.gms.internal.measurement.zzet r8 = com.google.android.gms.internal.measurement.zzet.DOUBLE_LIST_PACKED
            int r8 = r8.id()
            if (r4 < r8) goto L_0x0542
            com.google.android.gms.internal.measurement.zzet r8 = com.google.android.gms.internal.measurement.zzet.SINT64_LIST_PACKED
            int r8 = r8.id()
            if (r4 > r8) goto L_0x0542
            int[] r8 = r0.zzakj
            int r9 = r3 + 2
            r8 = r8[r9]
            r11 = r8 & r7
            goto L_0x0543
        L_0x0542:
            r11 = 0
        L_0x0543:
            r18 = 0
        L_0x0545:
            r8 = r13 & r7
            long r8 = (long) r8
            switch(r4) {
                case 0: goto L_0x0a1e;
                case 1: goto L_0x0a0d;
                case 2: goto L_0x09fb;
                case 3: goto L_0x09ea;
                case 4: goto L_0x09d9;
                case 5: goto L_0x09cc;
                case 6: goto L_0x09bf;
                case 7: goto L_0x09b3;
                case 8: goto L_0x0997;
                case 9: goto L_0x0985;
                case 10: goto L_0x0976;
                case 11: goto L_0x0969;
                case 12: goto L_0x095c;
                case 13: goto L_0x0951;
                case 14: goto L_0x0946;
                case 15: goto L_0x0939;
                case 16: goto L_0x092c;
                case 17: goto L_0x0919;
                case 18: goto L_0x0905;
                case 19: goto L_0x08f5;
                case 20: goto L_0x08e9;
                case 21: goto L_0x08dd;
                case 22: goto L_0x08d1;
                case 23: goto L_0x08c5;
                case 24: goto L_0x08b9;
                case 25: goto L_0x08ad;
                case 26: goto L_0x08a2;
                case 27: goto L_0x0892;
                case 28: goto L_0x0886;
                case 29: goto L_0x0879;
                case 30: goto L_0x086c;
                case 31: goto L_0x085f;
                case 32: goto L_0x0852;
                case 33: goto L_0x0845;
                case 34: goto L_0x0838;
                case 35: goto L_0x0818;
                case 36: goto L_0x07fb;
                case 37: goto L_0x07de;
                case 38: goto L_0x07c1;
                case 39: goto L_0x07a3;
                case 40: goto L_0x0785;
                case 41: goto L_0x0767;
                case 42: goto L_0x0749;
                case 43: goto L_0x072b;
                case 44: goto L_0x070d;
                case 45: goto L_0x06ef;
                case 46: goto L_0x06d1;
                case 47: goto L_0x06b3;
                case 48: goto L_0x0695;
                case 49: goto L_0x0685;
                case 50: goto L_0x0675;
                case 51: goto L_0x0667;
                case 52: goto L_0x065a;
                case 53: goto L_0x064a;
                case 54: goto L_0x063a;
                case 55: goto L_0x062a;
                case 56: goto L_0x061c;
                case 57: goto L_0x060f;
                case 58: goto L_0x0602;
                case 59: goto L_0x05e4;
                case 60: goto L_0x05d0;
                case 61: goto L_0x05be;
                case 62: goto L_0x05ae;
                case 63: goto L_0x059e;
                case 64: goto L_0x0591;
                case 65: goto L_0x0583;
                case 66: goto L_0x0573;
                case 67: goto L_0x0563;
                case 68: goto L_0x054d;
                default: goto L_0x054b;
            }
        L_0x054b:
            goto L_0x0911
        L_0x054d:
            boolean r4 = r0.zza((T) r1, r15, r3)
            if (r4 == 0) goto L_0x0911
            java.lang.Object r4 = r2.getObject(r1, r8)
            com.google.android.gms.internal.measurement.zzgi r4 = (com.google.android.gms.internal.measurement.zzgi) r4
            com.google.android.gms.internal.measurement.zzgx r8 = r0.zzbx(r3)
            int r4 = com.google.android.gms.internal.measurement.zzee.zzc(r15, r4, r8)
            goto L_0x0910
        L_0x0563:
            boolean r4 = r0.zza((T) r1, r15, r3)
            if (r4 == 0) goto L_0x0911
            long r8 = zzi(r1, r8)
            int r4 = com.google.android.gms.internal.measurement.zzee.zzf(r15, r8)
            goto L_0x0910
        L_0x0573:
            boolean r4 = r0.zza((T) r1, r15, r3)
            if (r4 == 0) goto L_0x0911
            int r4 = zzh(r1, r8)
            int r4 = com.google.android.gms.internal.measurement.zzee.zzi(r15, r4)
            goto L_0x0910
        L_0x0583:
            boolean r4 = r0.zza((T) r1, r15, r3)
            if (r4 == 0) goto L_0x0911
            r8 = 0
            int r4 = com.google.android.gms.internal.measurement.zzee.zzh(r15, r8)
            goto L_0x0910
        L_0x0591:
            boolean r4 = r0.zza((T) r1, r15, r3)
            if (r4 == 0) goto L_0x0911
            r4 = 0
            int r8 = com.google.android.gms.internal.measurement.zzee.zzk(r15, r4)
            goto L_0x095a
        L_0x059e:
            boolean r4 = r0.zza((T) r1, r15, r3)
            if (r4 == 0) goto L_0x0911
            int r4 = zzh(r1, r8)
            int r4 = com.google.android.gms.internal.measurement.zzee.zzl(r15, r4)
            goto L_0x0910
        L_0x05ae:
            boolean r4 = r0.zza((T) r1, r15, r3)
            if (r4 == 0) goto L_0x0911
            int r4 = zzh(r1, r8)
            int r4 = com.google.android.gms.internal.measurement.zzee.zzh(r15, r4)
            goto L_0x0910
        L_0x05be:
            boolean r4 = r0.zza((T) r1, r15, r3)
            if (r4 == 0) goto L_0x0911
            java.lang.Object r4 = r2.getObject(r1, r8)
            com.google.android.gms.internal.measurement.zzdp r4 = (com.google.android.gms.internal.measurement.zzdp) r4
            int r4 = com.google.android.gms.internal.measurement.zzee.zzc(r15, r4)
            goto L_0x0910
        L_0x05d0:
            boolean r4 = r0.zza((T) r1, r15, r3)
            if (r4 == 0) goto L_0x0911
            java.lang.Object r4 = r2.getObject(r1, r8)
            com.google.android.gms.internal.measurement.zzgx r8 = r0.zzbx(r3)
            int r4 = com.google.android.gms.internal.measurement.zzgz.zzc(r15, r4, r8)
            goto L_0x0910
        L_0x05e4:
            boolean r4 = r0.zza((T) r1, r15, r3)
            if (r4 == 0) goto L_0x0911
            java.lang.Object r4 = r2.getObject(r1, r8)
            boolean r8 = r4 instanceof com.google.android.gms.internal.measurement.zzdp
            if (r8 == 0) goto L_0x05fa
            com.google.android.gms.internal.measurement.zzdp r4 = (com.google.android.gms.internal.measurement.zzdp) r4
            int r4 = com.google.android.gms.internal.measurement.zzee.zzc(r15, r4)
            goto L_0x0910
        L_0x05fa:
            java.lang.String r4 = (java.lang.String) r4
            int r4 = com.google.android.gms.internal.measurement.zzee.zzc(r15, r4)
            goto L_0x0910
        L_0x0602:
            boolean r4 = r0.zza((T) r1, r15, r3)
            if (r4 == 0) goto L_0x0911
            r4 = 1
            int r8 = com.google.android.gms.internal.measurement.zzee.zzc(r15, r4)
            goto L_0x095a
        L_0x060f:
            boolean r4 = r0.zza((T) r1, r15, r3)
            if (r4 == 0) goto L_0x0911
            r4 = 0
            int r8 = com.google.android.gms.internal.measurement.zzee.zzj(r15, r4)
            goto L_0x095a
        L_0x061c:
            boolean r4 = r0.zza((T) r1, r15, r3)
            if (r4 == 0) goto L_0x0911
            r8 = 0
            int r4 = com.google.android.gms.internal.measurement.zzee.zzg(r15, r8)
            goto L_0x0910
        L_0x062a:
            boolean r4 = r0.zza((T) r1, r15, r3)
            if (r4 == 0) goto L_0x0911
            int r4 = zzh(r1, r8)
            int r4 = com.google.android.gms.internal.measurement.zzee.zzg(r15, r4)
            goto L_0x0910
        L_0x063a:
            boolean r4 = r0.zza((T) r1, r15, r3)
            if (r4 == 0) goto L_0x0911
            long r8 = zzi(r1, r8)
            int r4 = com.google.android.gms.internal.measurement.zzee.zze(r15, r8)
            goto L_0x0910
        L_0x064a:
            boolean r4 = r0.zza((T) r1, r15, r3)
            if (r4 == 0) goto L_0x0911
            long r8 = zzi(r1, r8)
            int r4 = com.google.android.gms.internal.measurement.zzee.zzd(r15, r8)
            goto L_0x0910
        L_0x065a:
            boolean r4 = r0.zza((T) r1, r15, r3)
            if (r4 == 0) goto L_0x0911
            r4 = 0
            int r8 = com.google.android.gms.internal.measurement.zzee.zzb(r15, r4)
            goto L_0x095a
        L_0x0667:
            boolean r4 = r0.zza((T) r1, r15, r3)
            if (r4 == 0) goto L_0x0911
            r8 = 0
            int r4 = com.google.android.gms.internal.measurement.zzee.zzb(r15, r8)
            goto L_0x0910
        L_0x0675:
            com.google.android.gms.internal.measurement.zzgb r4 = r0.zzakz
            java.lang.Object r8 = r2.getObject(r1, r8)
            java.lang.Object r9 = r0.zzby(r3)
            int r4 = r4.zzb(r15, r8, r9)
            goto L_0x0910
        L_0x0685:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.measurement.zzgx r8 = r0.zzbx(r3)
            int r4 = com.google.android.gms.internal.measurement.zzgz.zzd(r15, r4, r8)
            goto L_0x0910
        L_0x0695:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzgz.zzw(r4)
            if (r4 <= 0) goto L_0x0911
            boolean r8 = r0.zzakr
            if (r8 == 0) goto L_0x06a9
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x06a9:
            int r8 = com.google.android.gms.internal.measurement.zzee.zzbi(r15)
            int r9 = com.google.android.gms.internal.measurement.zzee.zzbk(r4)
            goto L_0x0834
        L_0x06b3:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzgz.zzaa(r4)
            if (r4 <= 0) goto L_0x0911
            boolean r8 = r0.zzakr
            if (r8 == 0) goto L_0x06c7
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x06c7:
            int r8 = com.google.android.gms.internal.measurement.zzee.zzbi(r15)
            int r9 = com.google.android.gms.internal.measurement.zzee.zzbk(r4)
            goto L_0x0834
        L_0x06d1:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzgz.zzac(r4)
            if (r4 <= 0) goto L_0x0911
            boolean r8 = r0.zzakr
            if (r8 == 0) goto L_0x06e5
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x06e5:
            int r8 = com.google.android.gms.internal.measurement.zzee.zzbi(r15)
            int r9 = com.google.android.gms.internal.measurement.zzee.zzbk(r4)
            goto L_0x0834
        L_0x06ef:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzgz.zzab(r4)
            if (r4 <= 0) goto L_0x0911
            boolean r8 = r0.zzakr
            if (r8 == 0) goto L_0x0703
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x0703:
            int r8 = com.google.android.gms.internal.measurement.zzee.zzbi(r15)
            int r9 = com.google.android.gms.internal.measurement.zzee.zzbk(r4)
            goto L_0x0834
        L_0x070d:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzgz.zzx(r4)
            if (r4 <= 0) goto L_0x0911
            boolean r8 = r0.zzakr
            if (r8 == 0) goto L_0x0721
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x0721:
            int r8 = com.google.android.gms.internal.measurement.zzee.zzbi(r15)
            int r9 = com.google.android.gms.internal.measurement.zzee.zzbk(r4)
            goto L_0x0834
        L_0x072b:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzgz.zzz(r4)
            if (r4 <= 0) goto L_0x0911
            boolean r8 = r0.zzakr
            if (r8 == 0) goto L_0x073f
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x073f:
            int r8 = com.google.android.gms.internal.measurement.zzee.zzbi(r15)
            int r9 = com.google.android.gms.internal.measurement.zzee.zzbk(r4)
            goto L_0x0834
        L_0x0749:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzgz.zzad(r4)
            if (r4 <= 0) goto L_0x0911
            boolean r8 = r0.zzakr
            if (r8 == 0) goto L_0x075d
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x075d:
            int r8 = com.google.android.gms.internal.measurement.zzee.zzbi(r15)
            int r9 = com.google.android.gms.internal.measurement.zzee.zzbk(r4)
            goto L_0x0834
        L_0x0767:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzgz.zzab(r4)
            if (r4 <= 0) goto L_0x0911
            boolean r8 = r0.zzakr
            if (r8 == 0) goto L_0x077b
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x077b:
            int r8 = com.google.android.gms.internal.measurement.zzee.zzbi(r15)
            int r9 = com.google.android.gms.internal.measurement.zzee.zzbk(r4)
            goto L_0x0834
        L_0x0785:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzgz.zzac(r4)
            if (r4 <= 0) goto L_0x0911
            boolean r8 = r0.zzakr
            if (r8 == 0) goto L_0x0799
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x0799:
            int r8 = com.google.android.gms.internal.measurement.zzee.zzbi(r15)
            int r9 = com.google.android.gms.internal.measurement.zzee.zzbk(r4)
            goto L_0x0834
        L_0x07a3:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzgz.zzy(r4)
            if (r4 <= 0) goto L_0x0911
            boolean r8 = r0.zzakr
            if (r8 == 0) goto L_0x07b7
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x07b7:
            int r8 = com.google.android.gms.internal.measurement.zzee.zzbi(r15)
            int r9 = com.google.android.gms.internal.measurement.zzee.zzbk(r4)
            goto L_0x0834
        L_0x07c1:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzgz.zzv(r4)
            if (r4 <= 0) goto L_0x0911
            boolean r8 = r0.zzakr
            if (r8 == 0) goto L_0x07d5
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x07d5:
            int r8 = com.google.android.gms.internal.measurement.zzee.zzbi(r15)
            int r9 = com.google.android.gms.internal.measurement.zzee.zzbk(r4)
            goto L_0x0834
        L_0x07de:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzgz.zzu(r4)
            if (r4 <= 0) goto L_0x0911
            boolean r8 = r0.zzakr
            if (r8 == 0) goto L_0x07f2
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x07f2:
            int r8 = com.google.android.gms.internal.measurement.zzee.zzbi(r15)
            int r9 = com.google.android.gms.internal.measurement.zzee.zzbk(r4)
            goto L_0x0834
        L_0x07fb:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzgz.zzab(r4)
            if (r4 <= 0) goto L_0x0911
            boolean r8 = r0.zzakr
            if (r8 == 0) goto L_0x080f
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x080f:
            int r8 = com.google.android.gms.internal.measurement.zzee.zzbi(r15)
            int r9 = com.google.android.gms.internal.measurement.zzee.zzbk(r4)
            goto L_0x0834
        L_0x0818:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzgz.zzac(r4)
            if (r4 <= 0) goto L_0x0911
            boolean r8 = r0.zzakr
            if (r8 == 0) goto L_0x082c
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x082c:
            int r8 = com.google.android.gms.internal.measurement.zzee.zzbi(r15)
            int r9 = com.google.android.gms.internal.measurement.zzee.zzbk(r4)
        L_0x0834:
            int r8 = r8 + r9
            int r8 = r8 + r4
            goto L_0x095a
        L_0x0838:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            r10 = 0
            int r4 = com.google.android.gms.internal.measurement.zzgz.zzq(r15, r4, r10)
            goto L_0x0900
        L_0x0845:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzgz.zzu(r15, r4, r10)
            goto L_0x0900
        L_0x0852:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzgz.zzw(r15, r4, r10)
            goto L_0x0900
        L_0x085f:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzgz.zzv(r15, r4, r10)
            goto L_0x0900
        L_0x086c:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzgz.zzr(r15, r4, r10)
            goto L_0x0900
        L_0x0879:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzgz.zzt(r15, r4, r10)
            goto L_0x0910
        L_0x0886:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzgz.zzd(r15, r4)
            goto L_0x0910
        L_0x0892:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.measurement.zzgx r8 = r0.zzbx(r3)
            int r4 = com.google.android.gms.internal.measurement.zzgz.zzc(r15, r4, r8)
            goto L_0x0910
        L_0x08a2:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzgz.zzc(r15, r4)
            goto L_0x0910
        L_0x08ad:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            r10 = 0
            int r4 = com.google.android.gms.internal.measurement.zzgz.zzx(r15, r4, r10)
            goto L_0x0900
        L_0x08b9:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzgz.zzv(r15, r4, r10)
            goto L_0x0900
        L_0x08c5:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzgz.zzw(r15, r4, r10)
            goto L_0x0900
        L_0x08d1:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzgz.zzs(r15, r4, r10)
            goto L_0x0900
        L_0x08dd:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzgz.zzp(r15, r4, r10)
            goto L_0x0900
        L_0x08e9:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzgz.zzo(r15, r4, r10)
            goto L_0x0900
        L_0x08f5:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzgz.zzv(r15, r4, r10)
        L_0x0900:
            int r5 = r5 + r4
            r4 = 1
        L_0x0902:
            r7 = 0
            goto L_0x0915
        L_0x0905:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzgz.zzw(r15, r4, r10)
        L_0x0910:
            int r5 = r5 + r4
        L_0x0911:
            r4 = 1
        L_0x0912:
            r7 = 0
            r10 = 0
        L_0x0915:
            r13 = 0
            goto L_0x0a2e
        L_0x0919:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x0911
            java.lang.Object r4 = r2.getObject(r1, r8)
            com.google.android.gms.internal.measurement.zzgi r4 = (com.google.android.gms.internal.measurement.zzgi) r4
            com.google.android.gms.internal.measurement.zzgx r8 = r0.zzbx(r3)
            int r4 = com.google.android.gms.internal.measurement.zzee.zzc(r15, r4, r8)
            goto L_0x0910
        L_0x092c:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x0911
            long r8 = r2.getLong(r1, r8)
            int r4 = com.google.android.gms.internal.measurement.zzee.zzf(r15, r8)
            goto L_0x0910
        L_0x0939:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x0911
            int r4 = r2.getInt(r1, r8)
            int r4 = com.google.android.gms.internal.measurement.zzee.zzi(r15, r4)
            goto L_0x0910
        L_0x0946:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x0911
            r8 = 0
            int r4 = com.google.android.gms.internal.measurement.zzee.zzh(r15, r8)
            goto L_0x0910
        L_0x0951:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x0911
            r4 = 0
            int r8 = com.google.android.gms.internal.measurement.zzee.zzk(r15, r4)
        L_0x095a:
            int r5 = r5 + r8
            goto L_0x0911
        L_0x095c:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x0911
            int r4 = r2.getInt(r1, r8)
            int r4 = com.google.android.gms.internal.measurement.zzee.zzl(r15, r4)
            goto L_0x0910
        L_0x0969:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x0911
            int r4 = r2.getInt(r1, r8)
            int r4 = com.google.android.gms.internal.measurement.zzee.zzh(r15, r4)
            goto L_0x0910
        L_0x0976:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x0911
            java.lang.Object r4 = r2.getObject(r1, r8)
            com.google.android.gms.internal.measurement.zzdp r4 = (com.google.android.gms.internal.measurement.zzdp) r4
            int r4 = com.google.android.gms.internal.measurement.zzee.zzc(r15, r4)
            goto L_0x0910
        L_0x0985:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x0911
            java.lang.Object r4 = r2.getObject(r1, r8)
            com.google.android.gms.internal.measurement.zzgx r8 = r0.zzbx(r3)
            int r4 = com.google.android.gms.internal.measurement.zzgz.zzc(r15, r4, r8)
            goto L_0x0910
        L_0x0997:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x0911
            java.lang.Object r4 = r2.getObject(r1, r8)
            boolean r8 = r4 instanceof com.google.android.gms.internal.measurement.zzdp
            if (r8 == 0) goto L_0x09ab
            com.google.android.gms.internal.measurement.zzdp r4 = (com.google.android.gms.internal.measurement.zzdp) r4
            int r4 = com.google.android.gms.internal.measurement.zzee.zzc(r15, r4)
            goto L_0x0910
        L_0x09ab:
            java.lang.String r4 = (java.lang.String) r4
            int r4 = com.google.android.gms.internal.measurement.zzee.zzc(r15, r4)
            goto L_0x0910
        L_0x09b3:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x0911
            r4 = 1
            int r8 = com.google.android.gms.internal.measurement.zzee.zzc(r15, r4)
            int r5 = r5 + r8
            goto L_0x0912
        L_0x09bf:
            r4 = 1
            r8 = r12 & r18
            r10 = 0
            if (r8 == 0) goto L_0x0902
            int r8 = com.google.android.gms.internal.measurement.zzee.zzj(r15, r10)
            int r5 = r5 + r8
            goto L_0x0902
        L_0x09cc:
            r4 = 1
            r10 = 0
            r8 = r12 & r18
            r13 = 0
            if (r8 == 0) goto L_0x0a1b
            int r8 = com.google.android.gms.internal.measurement.zzee.zzg(r15, r13)
            goto L_0x0a0b
        L_0x09d9:
            r4 = 1
            r10 = 0
            r13 = 0
            r11 = r12 & r18
            if (r11 == 0) goto L_0x0a1b
            int r8 = r2.getInt(r1, r8)
            int r8 = com.google.android.gms.internal.measurement.zzee.zzg(r15, r8)
            goto L_0x0a0b
        L_0x09ea:
            r4 = 1
            r10 = 0
            r13 = 0
            r11 = r12 & r18
            if (r11 == 0) goto L_0x0a1b
            long r8 = r2.getLong(r1, r8)
            int r8 = com.google.android.gms.internal.measurement.zzee.zze(r15, r8)
            goto L_0x0a0b
        L_0x09fb:
            r4 = 1
            r10 = 0
            r13 = 0
            r11 = r12 & r18
            if (r11 == 0) goto L_0x0a1b
            long r8 = r2.getLong(r1, r8)
            int r8 = com.google.android.gms.internal.measurement.zzee.zzd(r15, r8)
        L_0x0a0b:
            int r5 = r5 + r8
            goto L_0x0a1b
        L_0x0a0d:
            r4 = 1
            r10 = 0
            r13 = 0
            r8 = r12 & r18
            if (r8 == 0) goto L_0x0a1b
            r8 = 0
            int r9 = com.google.android.gms.internal.measurement.zzee.zzb(r15, r8)
            int r5 = r5 + r9
        L_0x0a1b:
            r7 = 0
            goto L_0x0a2e
        L_0x0a1e:
            r4 = 1
            r8 = 0
            r10 = 0
            r13 = 0
            r9 = r12 & r18
            if (r9 == 0) goto L_0x0a1b
            r7 = 0
            int r11 = com.google.android.gms.internal.measurement.zzee.zzb(r15, r7)
            int r5 = r5 + r11
        L_0x0a2e:
            int r3 = r3 + 3
            r9 = r13
            r4 = 0
            r7 = 1048575(0xfffff, float:1.469367E-39)
            r8 = 1
            r11 = 0
            goto L_0x04f9
        L_0x0a39:
            r10 = 0
            com.google.android.gms.internal.measurement.zzhp<?, ?> r2 = r0.zzakx
            int r2 = zza(r2, (T) r1)
            int r5 = r5 + r2
            boolean r2 = r0.zzako
            if (r2 == 0) goto L_0x0a93
            com.google.android.gms.internal.measurement.zzen<?> r2 = r0.zzaky
            com.google.android.gms.internal.measurement.zzeo r1 = r2.zzh(r1)
            r2 = 0
        L_0x0a4c:
            com.google.android.gms.internal.measurement.zzhc<FieldDescriptorType, java.lang.Object> r3 = r1.zzaex
            int r3 = r3.zzwh()
            if (r10 >= r3) goto L_0x0a6c
            com.google.android.gms.internal.measurement.zzhc<FieldDescriptorType, java.lang.Object> r3 = r1.zzaex
            java.util.Map$Entry r3 = r3.zzcf(r10)
            java.lang.Object r4 = r3.getKey()
            com.google.android.gms.internal.measurement.zzeq r4 = (com.google.android.gms.internal.measurement.zzeq) r4
            java.lang.Object r3 = r3.getValue()
            int r3 = com.google.android.gms.internal.measurement.zzeo.zzb(r4, r3)
            int r2 = r2 + r3
            int r10 = r10 + 1
            goto L_0x0a4c
        L_0x0a6c:
            com.google.android.gms.internal.measurement.zzhc<FieldDescriptorType, java.lang.Object> r1 = r1.zzaex
            java.lang.Iterable r1 = r1.zzwi()
            java.util.Iterator r1 = r1.iterator()
        L_0x0a76:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x0a92
            java.lang.Object r3 = r1.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r3.getKey()
            com.google.android.gms.internal.measurement.zzeq r4 = (com.google.android.gms.internal.measurement.zzeq) r4
            java.lang.Object r3 = r3.getValue()
            int r3 = com.google.android.gms.internal.measurement.zzeo.zzb(r4, r3)
            int r2 = r2 + r3
            goto L_0x0a76
        L_0x0a92:
            int r5 = r5 + r2
        L_0x0a93:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzgm.zzt(java.lang.Object):int");
    }

    private static <UT, UB> int zza(zzhp<UT, UB> zzhp, T t) {
        return zzhp.zzt(zzhp.zzx(t));
    }

    private static List<?> zze(Object obj, long j) {
        return (List) zzhv.zzp(obj, j);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x04bc A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x04bd  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x04eb  */
    /* JADX WARNING: Removed duplicated region for block: B:321:0x096d  */
    /* JADX WARNING: Removed duplicated region for block: B:323:0x0973  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r13, com.google.android.gms.internal.measurement.zzim r14) throws java.io.IOException {
        /*
            r12 = this;
            int r0 = r14.zztk()
            int r1 = com.google.android.gms.internal.measurement.zzey.zzd.zzaip
            r2 = 267386880(0xff00000, float:2.3665827E-29)
            r3 = 0
            r4 = 1
            r5 = 0
            r6 = 1048575(0xfffff, float:1.469367E-39)
            if (r0 != r1) goto L_0x04c3
            com.google.android.gms.internal.measurement.zzhp<?, ?> r0 = r12.zzakx
            zza(r0, (T) r13, r14)
            boolean r0 = r12.zzako
            if (r0 == 0) goto L_0x0032
            com.google.android.gms.internal.measurement.zzen<?> r0 = r12.zzaky
            com.google.android.gms.internal.measurement.zzeo r0 = r0.zzh(r13)
            com.google.android.gms.internal.measurement.zzhc<FieldDescriptorType, java.lang.Object> r1 = r0.zzaex
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x0032
            java.util.Iterator r0 = r0.descendingIterator()
            java.lang.Object r0 = r0.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            goto L_0x0033
        L_0x0032:
            r0 = r3
        L_0x0033:
            int[] r1 = r12.zzakj
            int r1 = r1.length
            int r1 = r1 + -3
        L_0x0038:
            if (r1 < 0) goto L_0x04ba
            int r7 = r12.zzca(r1)
            int[] r8 = r12.zzakj
            r9 = r8[r1]
            if (r0 != 0) goto L_0x04b4
            r10 = r7 & r2
            int r10 = r10 >>> 20
            switch(r10) {
                case 0: goto L_0x04a1;
                case 1: goto L_0x0491;
                case 2: goto L_0x0481;
                case 3: goto L_0x0471;
                case 4: goto L_0x0461;
                case 5: goto L_0x0451;
                case 6: goto L_0x0441;
                case 7: goto L_0x0430;
                case 8: goto L_0x041f;
                case 9: goto L_0x040a;
                case 10: goto L_0x03f7;
                case 11: goto L_0x03e6;
                case 12: goto L_0x03d5;
                case 13: goto L_0x03c4;
                case 14: goto L_0x03b3;
                case 15: goto L_0x03a2;
                case 16: goto L_0x0391;
                case 17: goto L_0x037c;
                case 18: goto L_0x036d;
                case 19: goto L_0x035e;
                case 20: goto L_0x034f;
                case 21: goto L_0x0340;
                case 22: goto L_0x0331;
                case 23: goto L_0x0322;
                case 24: goto L_0x0313;
                case 25: goto L_0x0304;
                case 26: goto L_0x02f5;
                case 27: goto L_0x02e2;
                case 28: goto L_0x02d3;
                case 29: goto L_0x02c4;
                case 30: goto L_0x02b5;
                case 31: goto L_0x02a6;
                case 32: goto L_0x0297;
                case 33: goto L_0x0288;
                case 34: goto L_0x0279;
                case 35: goto L_0x026a;
                case 36: goto L_0x025b;
                case 37: goto L_0x024c;
                case 38: goto L_0x023d;
                case 39: goto L_0x022e;
                case 40: goto L_0x021f;
                case 41: goto L_0x0210;
                case 42: goto L_0x0201;
                case 43: goto L_0x01f2;
                case 44: goto L_0x01e3;
                case 45: goto L_0x01d4;
                case 46: goto L_0x01c5;
                case 47: goto L_0x01b6;
                case 48: goto L_0x01a7;
                case 49: goto L_0x0194;
                case 50: goto L_0x0189;
                case 51: goto L_0x0178;
                case 52: goto L_0x0167;
                case 53: goto L_0x0156;
                case 54: goto L_0x0145;
                case 55: goto L_0x0134;
                case 56: goto L_0x0123;
                case 57: goto L_0x0112;
                case 58: goto L_0x0101;
                case 59: goto L_0x00f0;
                case 60: goto L_0x00db;
                case 61: goto L_0x00c8;
                case 62: goto L_0x00b7;
                case 63: goto L_0x00a6;
                case 64: goto L_0x0095;
                case 65: goto L_0x0084;
                case 66: goto L_0x0073;
                case 67: goto L_0x0062;
                case 68: goto L_0x004d;
                default: goto L_0x004b;
            }
        L_0x004b:
            goto L_0x04b0
        L_0x004d:
            boolean r8 = r12.zza((T) r13, r9, r1)
            if (r8 == 0) goto L_0x04b0
            r7 = r7 & r6
            long r7 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.measurement.zzhv.zzp(r13, r7)
            com.google.android.gms.internal.measurement.zzgx r8 = r12.zzbx(r1)
            r14.zzb(r9, r7, r8)
            goto L_0x04b0
        L_0x0062:
            boolean r8 = r12.zza((T) r13, r9, r1)
            if (r8 == 0) goto L_0x04b0
            r7 = r7 & r6
            long r7 = (long) r7
            long r7 = zzi(r13, r7)
            r14.zzb(r9, r7)
            goto L_0x04b0
        L_0x0073:
            boolean r8 = r12.zza((T) r13, r9, r1)
            if (r8 == 0) goto L_0x04b0
            r7 = r7 & r6
            long r7 = (long) r7
            int r7 = zzh(r13, r7)
            r14.zze(r9, r7)
            goto L_0x04b0
        L_0x0084:
            boolean r8 = r12.zza((T) r13, r9, r1)
            if (r8 == 0) goto L_0x04b0
            r7 = r7 & r6
            long r7 = (long) r7
            long r7 = zzi(r13, r7)
            r14.zzj(r9, r7)
            goto L_0x04b0
        L_0x0095:
            boolean r8 = r12.zza((T) r13, r9, r1)
            if (r8 == 0) goto L_0x04b0
            r7 = r7 & r6
            long r7 = (long) r7
            int r7 = zzh(r13, r7)
            r14.zzm(r9, r7)
            goto L_0x04b0
        L_0x00a6:
            boolean r8 = r12.zza((T) r13, r9, r1)
            if (r8 == 0) goto L_0x04b0
            r7 = r7 & r6
            long r7 = (long) r7
            int r7 = zzh(r13, r7)
            r14.zzn(r9, r7)
            goto L_0x04b0
        L_0x00b7:
            boolean r8 = r12.zza((T) r13, r9, r1)
            if (r8 == 0) goto L_0x04b0
            r7 = r7 & r6
            long r7 = (long) r7
            int r7 = zzh(r13, r7)
            r14.zzd(r9, r7)
            goto L_0x04b0
        L_0x00c8:
            boolean r8 = r12.zza((T) r13, r9, r1)
            if (r8 == 0) goto L_0x04b0
            r7 = r7 & r6
            long r7 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.measurement.zzhv.zzp(r13, r7)
            com.google.android.gms.internal.measurement.zzdp r7 = (com.google.android.gms.internal.measurement.zzdp) r7
            r14.zza(r9, r7)
            goto L_0x04b0
        L_0x00db:
            boolean r8 = r12.zza((T) r13, r9, r1)
            if (r8 == 0) goto L_0x04b0
            r7 = r7 & r6
            long r7 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.measurement.zzhv.zzp(r13, r7)
            com.google.android.gms.internal.measurement.zzgx r8 = r12.zzbx(r1)
            r14.zza(r9, r7, r8)
            goto L_0x04b0
        L_0x00f0:
            boolean r8 = r12.zza((T) r13, r9, r1)
            if (r8 == 0) goto L_0x04b0
            r7 = r7 & r6
            long r7 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.measurement.zzhv.zzp(r13, r7)
            zza(r9, r7, r14)
            goto L_0x04b0
        L_0x0101:
            boolean r8 = r12.zza((T) r13, r9, r1)
            if (r8 == 0) goto L_0x04b0
            r7 = r7 & r6
            long r7 = (long) r7
            boolean r7 = zzj(r13, r7)
            r14.zzb(r9, r7)
            goto L_0x04b0
        L_0x0112:
            boolean r8 = r12.zza((T) r13, r9, r1)
            if (r8 == 0) goto L_0x04b0
            r7 = r7 & r6
            long r7 = (long) r7
            int r7 = zzh(r13, r7)
            r14.zzf(r9, r7)
            goto L_0x04b0
        L_0x0123:
            boolean r8 = r12.zza((T) r13, r9, r1)
            if (r8 == 0) goto L_0x04b0
            r7 = r7 & r6
            long r7 = (long) r7
            long r7 = zzi(r13, r7)
            r14.zzc(r9, r7)
            goto L_0x04b0
        L_0x0134:
            boolean r8 = r12.zza((T) r13, r9, r1)
            if (r8 == 0) goto L_0x04b0
            r7 = r7 & r6
            long r7 = (long) r7
            int r7 = zzh(r13, r7)
            r14.zzc(r9, r7)
            goto L_0x04b0
        L_0x0145:
            boolean r8 = r12.zza((T) r13, r9, r1)
            if (r8 == 0) goto L_0x04b0
            r7 = r7 & r6
            long r7 = (long) r7
            long r7 = zzi(r13, r7)
            r14.zza(r9, r7)
            goto L_0x04b0
        L_0x0156:
            boolean r8 = r12.zza((T) r13, r9, r1)
            if (r8 == 0) goto L_0x04b0
            r7 = r7 & r6
            long r7 = (long) r7
            long r7 = zzi(r13, r7)
            r14.zzi(r9, r7)
            goto L_0x04b0
        L_0x0167:
            boolean r8 = r12.zza((T) r13, r9, r1)
            if (r8 == 0) goto L_0x04b0
            r7 = r7 & r6
            long r7 = (long) r7
            float r7 = zzg(r13, r7)
            r14.zza(r9, r7)
            goto L_0x04b0
        L_0x0178:
            boolean r8 = r12.zza((T) r13, r9, r1)
            if (r8 == 0) goto L_0x04b0
            r7 = r7 & r6
            long r7 = (long) r7
            double r7 = zzf(r13, r7)
            r14.zza(r9, r7)
            goto L_0x04b0
        L_0x0189:
            r7 = r7 & r6
            long r7 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.measurement.zzhv.zzp(r13, r7)
            r12.zza(r14, r9, r7, r1)
            goto L_0x04b0
        L_0x0194:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.measurement.zzhv.zzp(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.measurement.zzgx r9 = r12.zzbx(r1)
            com.google.android.gms.internal.measurement.zzgz.zzb(r8, r7, r14, r9)
            goto L_0x04b0
        L_0x01a7:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.measurement.zzhv.zzp(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.measurement.zzgz.zze(r8, r7, r14, r4)
            goto L_0x04b0
        L_0x01b6:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.measurement.zzhv.zzp(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.measurement.zzgz.zzj(r8, r7, r14, r4)
            goto L_0x04b0
        L_0x01c5:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.measurement.zzhv.zzp(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.measurement.zzgz.zzg(r8, r7, r14, r4)
            goto L_0x04b0
        L_0x01d4:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.measurement.zzhv.zzp(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.measurement.zzgz.zzl(r8, r7, r14, r4)
            goto L_0x04b0
        L_0x01e3:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.measurement.zzhv.zzp(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.measurement.zzgz.zzm(r8, r7, r14, r4)
            goto L_0x04b0
        L_0x01f2:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.measurement.zzhv.zzp(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.measurement.zzgz.zzi(r8, r7, r14, r4)
            goto L_0x04b0
        L_0x0201:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.measurement.zzhv.zzp(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.measurement.zzgz.zzn(r8, r7, r14, r4)
            goto L_0x04b0
        L_0x0210:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.measurement.zzhv.zzp(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.measurement.zzgz.zzk(r8, r7, r14, r4)
            goto L_0x04b0
        L_0x021f:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.measurement.zzhv.zzp(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.measurement.zzgz.zzf(r8, r7, r14, r4)
            goto L_0x04b0
        L_0x022e:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.measurement.zzhv.zzp(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.measurement.zzgz.zzh(r8, r7, r14, r4)
            goto L_0x04b0
        L_0x023d:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.measurement.zzhv.zzp(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.measurement.zzgz.zzd(r8, r7, r14, r4)
            goto L_0x04b0
        L_0x024c:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.measurement.zzhv.zzp(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.measurement.zzgz.zzc(r8, r7, r14, r4)
            goto L_0x04b0
        L_0x025b:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.measurement.zzhv.zzp(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.measurement.zzgz.zzb(r8, r7, r14, r4)
            goto L_0x04b0
        L_0x026a:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.measurement.zzhv.zzp(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.measurement.zzgz.zza(r8, r7, r14, r4)
            goto L_0x04b0
        L_0x0279:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.measurement.zzhv.zzp(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.measurement.zzgz.zze(r8, r7, r14, r5)
            goto L_0x04b0
        L_0x0288:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.measurement.zzhv.zzp(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.measurement.zzgz.zzj(r8, r7, r14, r5)
            goto L_0x04b0
        L_0x0297:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.measurement.zzhv.zzp(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.measurement.zzgz.zzg(r8, r7, r14, r5)
            goto L_0x04b0
        L_0x02a6:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.measurement.zzhv.zzp(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.measurement.zzgz.zzl(r8, r7, r14, r5)
            goto L_0x04b0
        L_0x02b5:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.measurement.zzhv.zzp(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.measurement.zzgz.zzm(r8, r7, r14, r5)
            goto L_0x04b0
        L_0x02c4:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.measurement.zzhv.zzp(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.measurement.zzgz.zzi(r8, r7, r14, r5)
            goto L_0x04b0
        L_0x02d3:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.measurement.zzhv.zzp(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.measurement.zzgz.zzb(r8, r7, r14)
            goto L_0x04b0
        L_0x02e2:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.measurement.zzhv.zzp(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.measurement.zzgx r9 = r12.zzbx(r1)
            com.google.android.gms.internal.measurement.zzgz.zza(r8, r7, r14, r9)
            goto L_0x04b0
        L_0x02f5:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.measurement.zzhv.zzp(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.measurement.zzgz.zza(r8, r7, r14)
            goto L_0x04b0
        L_0x0304:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.measurement.zzhv.zzp(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.measurement.zzgz.zzn(r8, r7, r14, r5)
            goto L_0x04b0
        L_0x0313:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.measurement.zzhv.zzp(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.measurement.zzgz.zzk(r8, r7, r14, r5)
            goto L_0x04b0
        L_0x0322:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.measurement.zzhv.zzp(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.measurement.zzgz.zzf(r8, r7, r14, r5)
            goto L_0x04b0
        L_0x0331:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.measurement.zzhv.zzp(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.measurement.zzgz.zzh(r8, r7, r14, r5)
            goto L_0x04b0
        L_0x0340:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.measurement.zzhv.zzp(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.measurement.zzgz.zzd(r8, r7, r14, r5)
            goto L_0x04b0
        L_0x034f:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.measurement.zzhv.zzp(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.measurement.zzgz.zzc(r8, r7, r14, r5)
            goto L_0x04b0
        L_0x035e:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.measurement.zzhv.zzp(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.measurement.zzgz.zzb(r8, r7, r14, r5)
            goto L_0x04b0
        L_0x036d:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.measurement.zzhv.zzp(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.measurement.zzgz.zza(r8, r7, r14, r5)
            goto L_0x04b0
        L_0x037c:
            boolean r8 = r12.zza((T) r13, r1)
            if (r8 == 0) goto L_0x04b0
            r7 = r7 & r6
            long r7 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.measurement.zzhv.zzp(r13, r7)
            com.google.android.gms.internal.measurement.zzgx r8 = r12.zzbx(r1)
            r14.zzb(r9, r7, r8)
            goto L_0x04b0
        L_0x0391:
            boolean r8 = r12.zza((T) r13, r1)
            if (r8 == 0) goto L_0x04b0
            r7 = r7 & r6
            long r7 = (long) r7
            long r7 = com.google.android.gms.internal.measurement.zzhv.zzl(r13, r7)
            r14.zzb(r9, r7)
            goto L_0x04b0
        L_0x03a2:
            boolean r8 = r12.zza((T) r13, r1)
            if (r8 == 0) goto L_0x04b0
            r7 = r7 & r6
            long r7 = (long) r7
            int r7 = com.google.android.gms.internal.measurement.zzhv.zzk(r13, r7)
            r14.zze(r9, r7)
            goto L_0x04b0
        L_0x03b3:
            boolean r8 = r12.zza((T) r13, r1)
            if (r8 == 0) goto L_0x04b0
            r7 = r7 & r6
            long r7 = (long) r7
            long r7 = com.google.android.gms.internal.measurement.zzhv.zzl(r13, r7)
            r14.zzj(r9, r7)
            goto L_0x04b0
        L_0x03c4:
            boolean r8 = r12.zza((T) r13, r1)
            if (r8 == 0) goto L_0x04b0
            r7 = r7 & r6
            long r7 = (long) r7
            int r7 = com.google.android.gms.internal.measurement.zzhv.zzk(r13, r7)
            r14.zzm(r9, r7)
            goto L_0x04b0
        L_0x03d5:
            boolean r8 = r12.zza((T) r13, r1)
            if (r8 == 0) goto L_0x04b0
            r7 = r7 & r6
            long r7 = (long) r7
            int r7 = com.google.android.gms.internal.measurement.zzhv.zzk(r13, r7)
            r14.zzn(r9, r7)
            goto L_0x04b0
        L_0x03e6:
            boolean r8 = r12.zza((T) r13, r1)
            if (r8 == 0) goto L_0x04b0
            r7 = r7 & r6
            long r7 = (long) r7
            int r7 = com.google.android.gms.internal.measurement.zzhv.zzk(r13, r7)
            r14.zzd(r9, r7)
            goto L_0x04b0
        L_0x03f7:
            boolean r8 = r12.zza((T) r13, r1)
            if (r8 == 0) goto L_0x04b0
            r7 = r7 & r6
            long r7 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.measurement.zzhv.zzp(r13, r7)
            com.google.android.gms.internal.measurement.zzdp r7 = (com.google.android.gms.internal.measurement.zzdp) r7
            r14.zza(r9, r7)
            goto L_0x04b0
        L_0x040a:
            boolean r8 = r12.zza((T) r13, r1)
            if (r8 == 0) goto L_0x04b0
            r7 = r7 & r6
            long r7 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.measurement.zzhv.zzp(r13, r7)
            com.google.android.gms.internal.measurement.zzgx r8 = r12.zzbx(r1)
            r14.zza(r9, r7, r8)
            goto L_0x04b0
        L_0x041f:
            boolean r8 = r12.zza((T) r13, r1)
            if (r8 == 0) goto L_0x04b0
            r7 = r7 & r6
            long r7 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.measurement.zzhv.zzp(r13, r7)
            zza(r9, r7, r14)
            goto L_0x04b0
        L_0x0430:
            boolean r8 = r12.zza((T) r13, r1)
            if (r8 == 0) goto L_0x04b0
            r7 = r7 & r6
            long r7 = (long) r7
            boolean r7 = com.google.android.gms.internal.measurement.zzhv.zzm(r13, r7)
            r14.zzb(r9, r7)
            goto L_0x04b0
        L_0x0441:
            boolean r8 = r12.zza((T) r13, r1)
            if (r8 == 0) goto L_0x04b0
            r7 = r7 & r6
            long r7 = (long) r7
            int r7 = com.google.android.gms.internal.measurement.zzhv.zzk(r13, r7)
            r14.zzf(r9, r7)
            goto L_0x04b0
        L_0x0451:
            boolean r8 = r12.zza((T) r13, r1)
            if (r8 == 0) goto L_0x04b0
            r7 = r7 & r6
            long r7 = (long) r7
            long r7 = com.google.android.gms.internal.measurement.zzhv.zzl(r13, r7)
            r14.zzc(r9, r7)
            goto L_0x04b0
        L_0x0461:
            boolean r8 = r12.zza((T) r13, r1)
            if (r8 == 0) goto L_0x04b0
            r7 = r7 & r6
            long r7 = (long) r7
            int r7 = com.google.android.gms.internal.measurement.zzhv.zzk(r13, r7)
            r14.zzc(r9, r7)
            goto L_0x04b0
        L_0x0471:
            boolean r8 = r12.zza((T) r13, r1)
            if (r8 == 0) goto L_0x04b0
            r7 = r7 & r6
            long r7 = (long) r7
            long r7 = com.google.android.gms.internal.measurement.zzhv.zzl(r13, r7)
            r14.zza(r9, r7)
            goto L_0x04b0
        L_0x0481:
            boolean r8 = r12.zza((T) r13, r1)
            if (r8 == 0) goto L_0x04b0
            r7 = r7 & r6
            long r7 = (long) r7
            long r7 = com.google.android.gms.internal.measurement.zzhv.zzl(r13, r7)
            r14.zzi(r9, r7)
            goto L_0x04b0
        L_0x0491:
            boolean r8 = r12.zza((T) r13, r1)
            if (r8 == 0) goto L_0x04b0
            r7 = r7 & r6
            long r7 = (long) r7
            float r7 = com.google.android.gms.internal.measurement.zzhv.zzn(r13, r7)
            r14.zza(r9, r7)
            goto L_0x04b0
        L_0x04a1:
            boolean r8 = r12.zza((T) r13, r1)
            if (r8 == 0) goto L_0x04b0
            r7 = r7 & r6
            long r7 = (long) r7
            double r7 = com.google.android.gms.internal.measurement.zzhv.zzo(r13, r7)
            r14.zza(r9, r7)
        L_0x04b0:
            int r1 = r1 + -3
            goto L_0x0038
        L_0x04b4:
            com.google.android.gms.internal.measurement.zzen<?> r13 = r12.zzaky
            r13.zza(r0)
            throw r3
        L_0x04ba:
            if (r0 != 0) goto L_0x04bd
            return
        L_0x04bd:
            com.google.android.gms.internal.measurement.zzen<?> r13 = r12.zzaky
            r13.zza(r14, r0)
            throw r3
        L_0x04c3:
            boolean r0 = r12.zzakq
            if (r0 == 0) goto L_0x0979
            boolean r0 = r12.zzako
            if (r0 == 0) goto L_0x04e4
            com.google.android.gms.internal.measurement.zzen<?> r0 = r12.zzaky
            com.google.android.gms.internal.measurement.zzeo r0 = r0.zzh(r13)
            com.google.android.gms.internal.measurement.zzhc<FieldDescriptorType, java.lang.Object> r1 = r0.zzaex
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x04e4
            java.util.Iterator r0 = r0.iterator()
            java.lang.Object r0 = r0.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            goto L_0x04e5
        L_0x04e4:
            r0 = r3
        L_0x04e5:
            int[] r1 = r12.zzakj
            int r1 = r1.length
            r7 = 0
        L_0x04e9:
            if (r7 >= r1) goto L_0x096b
            int r8 = r12.zzca(r7)
            int[] r9 = r12.zzakj
            r10 = r9[r7]
            if (r0 != 0) goto L_0x0965
            r11 = r8 & r2
            int r11 = r11 >>> 20
            switch(r11) {
                case 0: goto L_0x0952;
                case 1: goto L_0x0942;
                case 2: goto L_0x0932;
                case 3: goto L_0x0922;
                case 4: goto L_0x0912;
                case 5: goto L_0x0902;
                case 6: goto L_0x08f2;
                case 7: goto L_0x08e1;
                case 8: goto L_0x08d0;
                case 9: goto L_0x08bb;
                case 10: goto L_0x08a8;
                case 11: goto L_0x0897;
                case 12: goto L_0x0886;
                case 13: goto L_0x0875;
                case 14: goto L_0x0864;
                case 15: goto L_0x0853;
                case 16: goto L_0x0842;
                case 17: goto L_0x082d;
                case 18: goto L_0x081e;
                case 19: goto L_0x080f;
                case 20: goto L_0x0800;
                case 21: goto L_0x07f1;
                case 22: goto L_0x07e2;
                case 23: goto L_0x07d3;
                case 24: goto L_0x07c4;
                case 25: goto L_0x07b5;
                case 26: goto L_0x07a6;
                case 27: goto L_0x0793;
                case 28: goto L_0x0784;
                case 29: goto L_0x0775;
                case 30: goto L_0x0766;
                case 31: goto L_0x0757;
                case 32: goto L_0x0748;
                case 33: goto L_0x0739;
                case 34: goto L_0x072a;
                case 35: goto L_0x071b;
                case 36: goto L_0x070c;
                case 37: goto L_0x06fd;
                case 38: goto L_0x06ee;
                case 39: goto L_0x06df;
                case 40: goto L_0x06d0;
                case 41: goto L_0x06c1;
                case 42: goto L_0x06b2;
                case 43: goto L_0x06a3;
                case 44: goto L_0x0694;
                case 45: goto L_0x0685;
                case 46: goto L_0x0676;
                case 47: goto L_0x0667;
                case 48: goto L_0x0658;
                case 49: goto L_0x0645;
                case 50: goto L_0x063a;
                case 51: goto L_0x0629;
                case 52: goto L_0x0618;
                case 53: goto L_0x0607;
                case 54: goto L_0x05f6;
                case 55: goto L_0x05e5;
                case 56: goto L_0x05d4;
                case 57: goto L_0x05c3;
                case 58: goto L_0x05b2;
                case 59: goto L_0x05a1;
                case 60: goto L_0x058c;
                case 61: goto L_0x0579;
                case 62: goto L_0x0568;
                case 63: goto L_0x0557;
                case 64: goto L_0x0546;
                case 65: goto L_0x0535;
                case 66: goto L_0x0524;
                case 67: goto L_0x0513;
                case 68: goto L_0x04fe;
                default: goto L_0x04fc;
            }
        L_0x04fc:
            goto L_0x0961
        L_0x04fe:
            boolean r9 = r12.zza((T) r13, r10, r7)
            if (r9 == 0) goto L_0x0961
            r8 = r8 & r6
            long r8 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzhv.zzp(r13, r8)
            com.google.android.gms.internal.measurement.zzgx r9 = r12.zzbx(r7)
            r14.zzb(r10, r8, r9)
            goto L_0x0961
        L_0x0513:
            boolean r9 = r12.zza((T) r13, r10, r7)
            if (r9 == 0) goto L_0x0961
            r8 = r8 & r6
            long r8 = (long) r8
            long r8 = zzi(r13, r8)
            r14.zzb(r10, r8)
            goto L_0x0961
        L_0x0524:
            boolean r9 = r12.zza((T) r13, r10, r7)
            if (r9 == 0) goto L_0x0961
            r8 = r8 & r6
            long r8 = (long) r8
            int r8 = zzh(r13, r8)
            r14.zze(r10, r8)
            goto L_0x0961
        L_0x0535:
            boolean r9 = r12.zza((T) r13, r10, r7)
            if (r9 == 0) goto L_0x0961
            r8 = r8 & r6
            long r8 = (long) r8
            long r8 = zzi(r13, r8)
            r14.zzj(r10, r8)
            goto L_0x0961
        L_0x0546:
            boolean r9 = r12.zza((T) r13, r10, r7)
            if (r9 == 0) goto L_0x0961
            r8 = r8 & r6
            long r8 = (long) r8
            int r8 = zzh(r13, r8)
            r14.zzm(r10, r8)
            goto L_0x0961
        L_0x0557:
            boolean r9 = r12.zza((T) r13, r10, r7)
            if (r9 == 0) goto L_0x0961
            r8 = r8 & r6
            long r8 = (long) r8
            int r8 = zzh(r13, r8)
            r14.zzn(r10, r8)
            goto L_0x0961
        L_0x0568:
            boolean r9 = r12.zza((T) r13, r10, r7)
            if (r9 == 0) goto L_0x0961
            r8 = r8 & r6
            long r8 = (long) r8
            int r8 = zzh(r13, r8)
            r14.zzd(r10, r8)
            goto L_0x0961
        L_0x0579:
            boolean r9 = r12.zza((T) r13, r10, r7)
            if (r9 == 0) goto L_0x0961
            r8 = r8 & r6
            long r8 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzhv.zzp(r13, r8)
            com.google.android.gms.internal.measurement.zzdp r8 = (com.google.android.gms.internal.measurement.zzdp) r8
            r14.zza(r10, r8)
            goto L_0x0961
        L_0x058c:
            boolean r9 = r12.zza((T) r13, r10, r7)
            if (r9 == 0) goto L_0x0961
            r8 = r8 & r6
            long r8 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzhv.zzp(r13, r8)
            com.google.android.gms.internal.measurement.zzgx r9 = r12.zzbx(r7)
            r14.zza(r10, r8, r9)
            goto L_0x0961
        L_0x05a1:
            boolean r9 = r12.zza((T) r13, r10, r7)
            if (r9 == 0) goto L_0x0961
            r8 = r8 & r6
            long r8 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzhv.zzp(r13, r8)
            zza(r10, r8, r14)
            goto L_0x0961
        L_0x05b2:
            boolean r9 = r12.zza((T) r13, r10, r7)
            if (r9 == 0) goto L_0x0961
            r8 = r8 & r6
            long r8 = (long) r8
            boolean r8 = zzj(r13, r8)
            r14.zzb(r10, r8)
            goto L_0x0961
        L_0x05c3:
            boolean r9 = r12.zza((T) r13, r10, r7)
            if (r9 == 0) goto L_0x0961
            r8 = r8 & r6
            long r8 = (long) r8
            int r8 = zzh(r13, r8)
            r14.zzf(r10, r8)
            goto L_0x0961
        L_0x05d4:
            boolean r9 = r12.zza((T) r13, r10, r7)
            if (r9 == 0) goto L_0x0961
            r8 = r8 & r6
            long r8 = (long) r8
            long r8 = zzi(r13, r8)
            r14.zzc(r10, r8)
            goto L_0x0961
        L_0x05e5:
            boolean r9 = r12.zza((T) r13, r10, r7)
            if (r9 == 0) goto L_0x0961
            r8 = r8 & r6
            long r8 = (long) r8
            int r8 = zzh(r13, r8)
            r14.zzc(r10, r8)
            goto L_0x0961
        L_0x05f6:
            boolean r9 = r12.zza((T) r13, r10, r7)
            if (r9 == 0) goto L_0x0961
            r8 = r8 & r6
            long r8 = (long) r8
            long r8 = zzi(r13, r8)
            r14.zza(r10, r8)
            goto L_0x0961
        L_0x0607:
            boolean r9 = r12.zza((T) r13, r10, r7)
            if (r9 == 0) goto L_0x0961
            r8 = r8 & r6
            long r8 = (long) r8
            long r8 = zzi(r13, r8)
            r14.zzi(r10, r8)
            goto L_0x0961
        L_0x0618:
            boolean r9 = r12.zza((T) r13, r10, r7)
            if (r9 == 0) goto L_0x0961
            r8 = r8 & r6
            long r8 = (long) r8
            float r8 = zzg(r13, r8)
            r14.zza(r10, r8)
            goto L_0x0961
        L_0x0629:
            boolean r9 = r12.zza((T) r13, r10, r7)
            if (r9 == 0) goto L_0x0961
            r8 = r8 & r6
            long r8 = (long) r8
            double r8 = zzf(r13, r8)
            r14.zza(r10, r8)
            goto L_0x0961
        L_0x063a:
            r8 = r8 & r6
            long r8 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzhv.zzp(r13, r8)
            r12.zza(r14, r10, r8, r7)
            goto L_0x0961
        L_0x0645:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzhv.zzp(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzgx r10 = r12.zzbx(r7)
            com.google.android.gms.internal.measurement.zzgz.zzb(r9, r8, r14, r10)
            goto L_0x0961
        L_0x0658:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzhv.zzp(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzgz.zze(r9, r8, r14, r4)
            goto L_0x0961
        L_0x0667:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzhv.zzp(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzgz.zzj(r9, r8, r14, r4)
            goto L_0x0961
        L_0x0676:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzhv.zzp(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzgz.zzg(r9, r8, r14, r4)
            goto L_0x0961
        L_0x0685:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzhv.zzp(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzgz.zzl(r9, r8, r14, r4)
            goto L_0x0961
        L_0x0694:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzhv.zzp(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzgz.zzm(r9, r8, r14, r4)
            goto L_0x0961
        L_0x06a3:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzhv.zzp(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzgz.zzi(r9, r8, r14, r4)
            goto L_0x0961
        L_0x06b2:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzhv.zzp(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzgz.zzn(r9, r8, r14, r4)
            goto L_0x0961
        L_0x06c1:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzhv.zzp(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzgz.zzk(r9, r8, r14, r4)
            goto L_0x0961
        L_0x06d0:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzhv.zzp(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzgz.zzf(r9, r8, r14, r4)
            goto L_0x0961
        L_0x06df:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzhv.zzp(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzgz.zzh(r9, r8, r14, r4)
            goto L_0x0961
        L_0x06ee:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzhv.zzp(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzgz.zzd(r9, r8, r14, r4)
            goto L_0x0961
        L_0x06fd:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzhv.zzp(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzgz.zzc(r9, r8, r14, r4)
            goto L_0x0961
        L_0x070c:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzhv.zzp(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzgz.zzb(r9, r8, r14, r4)
            goto L_0x0961
        L_0x071b:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzhv.zzp(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzgz.zza(r9, r8, r14, r4)
            goto L_0x0961
        L_0x072a:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzhv.zzp(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzgz.zze(r9, r8, r14, r5)
            goto L_0x0961
        L_0x0739:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzhv.zzp(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzgz.zzj(r9, r8, r14, r5)
            goto L_0x0961
        L_0x0748:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzhv.zzp(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzgz.zzg(r9, r8, r14, r5)
            goto L_0x0961
        L_0x0757:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzhv.zzp(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzgz.zzl(r9, r8, r14, r5)
            goto L_0x0961
        L_0x0766:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzhv.zzp(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzgz.zzm(r9, r8, r14, r5)
            goto L_0x0961
        L_0x0775:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzhv.zzp(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzgz.zzi(r9, r8, r14, r5)
            goto L_0x0961
        L_0x0784:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzhv.zzp(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzgz.zzb(r9, r8, r14)
            goto L_0x0961
        L_0x0793:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzhv.zzp(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzgx r10 = r12.zzbx(r7)
            com.google.android.gms.internal.measurement.zzgz.zza(r9, r8, r14, r10)
            goto L_0x0961
        L_0x07a6:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzhv.zzp(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzgz.zza(r9, r8, r14)
            goto L_0x0961
        L_0x07b5:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzhv.zzp(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzgz.zzn(r9, r8, r14, r5)
            goto L_0x0961
        L_0x07c4:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzhv.zzp(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzgz.zzk(r9, r8, r14, r5)
            goto L_0x0961
        L_0x07d3:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzhv.zzp(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzgz.zzf(r9, r8, r14, r5)
            goto L_0x0961
        L_0x07e2:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzhv.zzp(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzgz.zzh(r9, r8, r14, r5)
            goto L_0x0961
        L_0x07f1:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzhv.zzp(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzgz.zzd(r9, r8, r14, r5)
            goto L_0x0961
        L_0x0800:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzhv.zzp(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzgz.zzc(r9, r8, r14, r5)
            goto L_0x0961
        L_0x080f:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzhv.zzp(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzgz.zzb(r9, r8, r14, r5)
            goto L_0x0961
        L_0x081e:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzhv.zzp(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzgz.zza(r9, r8, r14, r5)
            goto L_0x0961
        L_0x082d:
            boolean r9 = r12.zza((T) r13, r7)
            if (r9 == 0) goto L_0x0961
            r8 = r8 & r6
            long r8 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzhv.zzp(r13, r8)
            com.google.android.gms.internal.measurement.zzgx r9 = r12.zzbx(r7)
            r14.zzb(r10, r8, r9)
            goto L_0x0961
        L_0x0842:
            boolean r9 = r12.zza((T) r13, r7)
            if (r9 == 0) goto L_0x0961
            r8 = r8 & r6
            long r8 = (long) r8
            long r8 = com.google.android.gms.internal.measurement.zzhv.zzl(r13, r8)
            r14.zzb(r10, r8)
            goto L_0x0961
        L_0x0853:
            boolean r9 = r12.zza((T) r13, r7)
            if (r9 == 0) goto L_0x0961
            r8 = r8 & r6
            long r8 = (long) r8
            int r8 = com.google.android.gms.internal.measurement.zzhv.zzk(r13, r8)
            r14.zze(r10, r8)
            goto L_0x0961
        L_0x0864:
            boolean r9 = r12.zza((T) r13, r7)
            if (r9 == 0) goto L_0x0961
            r8 = r8 & r6
            long r8 = (long) r8
            long r8 = com.google.android.gms.internal.measurement.zzhv.zzl(r13, r8)
            r14.zzj(r10, r8)
            goto L_0x0961
        L_0x0875:
            boolean r9 = r12.zza((T) r13, r7)
            if (r9 == 0) goto L_0x0961
            r8 = r8 & r6
            long r8 = (long) r8
            int r8 = com.google.android.gms.internal.measurement.zzhv.zzk(r13, r8)
            r14.zzm(r10, r8)
            goto L_0x0961
        L_0x0886:
            boolean r9 = r12.zza((T) r13, r7)
            if (r9 == 0) goto L_0x0961
            r8 = r8 & r6
            long r8 = (long) r8
            int r8 = com.google.android.gms.internal.measurement.zzhv.zzk(r13, r8)
            r14.zzn(r10, r8)
            goto L_0x0961
        L_0x0897:
            boolean r9 = r12.zza((T) r13, r7)
            if (r9 == 0) goto L_0x0961
            r8 = r8 & r6
            long r8 = (long) r8
            int r8 = com.google.android.gms.internal.measurement.zzhv.zzk(r13, r8)
            r14.zzd(r10, r8)
            goto L_0x0961
        L_0x08a8:
            boolean r9 = r12.zza((T) r13, r7)
            if (r9 == 0) goto L_0x0961
            r8 = r8 & r6
            long r8 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzhv.zzp(r13, r8)
            com.google.android.gms.internal.measurement.zzdp r8 = (com.google.android.gms.internal.measurement.zzdp) r8
            r14.zza(r10, r8)
            goto L_0x0961
        L_0x08bb:
            boolean r9 = r12.zza((T) r13, r7)
            if (r9 == 0) goto L_0x0961
            r8 = r8 & r6
            long r8 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzhv.zzp(r13, r8)
            com.google.android.gms.internal.measurement.zzgx r9 = r12.zzbx(r7)
            r14.zza(r10, r8, r9)
            goto L_0x0961
        L_0x08d0:
            boolean r9 = r12.zza((T) r13, r7)
            if (r9 == 0) goto L_0x0961
            r8 = r8 & r6
            long r8 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzhv.zzp(r13, r8)
            zza(r10, r8, r14)
            goto L_0x0961
        L_0x08e1:
            boolean r9 = r12.zza((T) r13, r7)
            if (r9 == 0) goto L_0x0961
            r8 = r8 & r6
            long r8 = (long) r8
            boolean r8 = com.google.android.gms.internal.measurement.zzhv.zzm(r13, r8)
            r14.zzb(r10, r8)
            goto L_0x0961
        L_0x08f2:
            boolean r9 = r12.zza((T) r13, r7)
            if (r9 == 0) goto L_0x0961
            r8 = r8 & r6
            long r8 = (long) r8
            int r8 = com.google.android.gms.internal.measurement.zzhv.zzk(r13, r8)
            r14.zzf(r10, r8)
            goto L_0x0961
        L_0x0902:
            boolean r9 = r12.zza((T) r13, r7)
            if (r9 == 0) goto L_0x0961
            r8 = r8 & r6
            long r8 = (long) r8
            long r8 = com.google.android.gms.internal.measurement.zzhv.zzl(r13, r8)
            r14.zzc(r10, r8)
            goto L_0x0961
        L_0x0912:
            boolean r9 = r12.zza((T) r13, r7)
            if (r9 == 0) goto L_0x0961
            r8 = r8 & r6
            long r8 = (long) r8
            int r8 = com.google.android.gms.internal.measurement.zzhv.zzk(r13, r8)
            r14.zzc(r10, r8)
            goto L_0x0961
        L_0x0922:
            boolean r9 = r12.zza((T) r13, r7)
            if (r9 == 0) goto L_0x0961
            r8 = r8 & r6
            long r8 = (long) r8
            long r8 = com.google.android.gms.internal.measurement.zzhv.zzl(r13, r8)
            r14.zza(r10, r8)
            goto L_0x0961
        L_0x0932:
            boolean r9 = r12.zza((T) r13, r7)
            if (r9 == 0) goto L_0x0961
            r8 = r8 & r6
            long r8 = (long) r8
            long r8 = com.google.android.gms.internal.measurement.zzhv.zzl(r13, r8)
            r14.zzi(r10, r8)
            goto L_0x0961
        L_0x0942:
            boolean r9 = r12.zza((T) r13, r7)
            if (r9 == 0) goto L_0x0961
            r8 = r8 & r6
            long r8 = (long) r8
            float r8 = com.google.android.gms.internal.measurement.zzhv.zzn(r13, r8)
            r14.zza(r10, r8)
            goto L_0x0961
        L_0x0952:
            boolean r9 = r12.zza((T) r13, r7)
            if (r9 == 0) goto L_0x0961
            r8 = r8 & r6
            long r8 = (long) r8
            double r8 = com.google.android.gms.internal.measurement.zzhv.zzo(r13, r8)
            r14.zza(r10, r8)
        L_0x0961:
            int r7 = r7 + 3
            goto L_0x04e9
        L_0x0965:
            com.google.android.gms.internal.measurement.zzen<?> r13 = r12.zzaky
            r13.zza(r0)
            throw r3
        L_0x096b:
            if (r0 != 0) goto L_0x0973
            com.google.android.gms.internal.measurement.zzhp<?, ?> r0 = r12.zzakx
            zza(r0, (T) r13, r14)
            return
        L_0x0973:
            com.google.android.gms.internal.measurement.zzen<?> r13 = r12.zzaky
            r13.zza(r14, r0)
            throw r3
        L_0x0979:
            r12.zzb((T) r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzgm.zza(java.lang.Object, com.google.android.gms.internal.measurement.zzim):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:167:0x046b  */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x0471  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0030  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzb(T r18, com.google.android.gms.internal.measurement.zzim r19) throws java.io.IOException {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            boolean r3 = r0.zzako
            if (r3 == 0) goto L_0x0023
            com.google.android.gms.internal.measurement.zzen<?> r3 = r0.zzaky
            com.google.android.gms.internal.measurement.zzeo r3 = r3.zzh(r1)
            com.google.android.gms.internal.measurement.zzhc<FieldDescriptorType, java.lang.Object> r5 = r3.zzaex
            boolean r5 = r5.isEmpty()
            if (r5 != 0) goto L_0x0023
            java.util.Iterator r3 = r3.iterator()
            java.lang.Object r3 = r3.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            goto L_0x0024
        L_0x0023:
            r3 = 0
        L_0x0024:
            r5 = -1
            int[] r6 = r0.zzakj
            int r6 = r6.length
            sun.misc.Unsafe r7 = zzaki
            r8 = 0
            r5 = 0
            r9 = -1
            r10 = 0
        L_0x002e:
            if (r5 >= r6) goto L_0x0468
            int r11 = r0.zzca(r5)
            int[] r12 = r0.zzakj
            r13 = r12[r5]
            r14 = 267386880(0xff00000, float:2.3665827E-29)
            r14 = r14 & r11
            int r14 = r14 >>> 20
            boolean r15 = r0.zzakq
            r16 = 1048575(0xfffff, float:1.469367E-39)
            r4 = 1
            if (r15 != 0) goto L_0x005d
            r15 = 17
            if (r14 > r15) goto L_0x005d
            int r15 = r5 + 2
            r12 = r12[r15]
            r15 = r12 & r16
            if (r15 == r9) goto L_0x0057
            long r9 = (long) r15
            int r10 = r7.getInt(r1, r9)
            goto L_0x0058
        L_0x0057:
            r15 = r9
        L_0x0058:
            int r9 = r12 >>> 20
            int r9 = r4 << r9
            goto L_0x005f
        L_0x005d:
            r15 = r9
            r9 = 0
        L_0x005f:
            if (r3 != 0) goto L_0x0461
            r11 = r11 & r16
            long r11 = (long) r11
            switch(r14) {
                case 0: goto L_0x0451;
                case 1: goto L_0x0445;
                case 2: goto L_0x0439;
                case 3: goto L_0x042d;
                case 4: goto L_0x0421;
                case 5: goto L_0x0415;
                case 6: goto L_0x0409;
                case 7: goto L_0x03fd;
                case 8: goto L_0x03f1;
                case 9: goto L_0x03e0;
                case 10: goto L_0x03d1;
                case 11: goto L_0x03c4;
                case 12: goto L_0x03b7;
                case 13: goto L_0x03aa;
                case 14: goto L_0x039d;
                case 15: goto L_0x0390;
                case 16: goto L_0x0383;
                case 17: goto L_0x0372;
                case 18: goto L_0x0363;
                case 19: goto L_0x0354;
                case 20: goto L_0x0345;
                case 21: goto L_0x0336;
                case 22: goto L_0x0327;
                case 23: goto L_0x0318;
                case 24: goto L_0x0309;
                case 25: goto L_0x02fa;
                case 26: goto L_0x02eb;
                case 27: goto L_0x02d8;
                case 28: goto L_0x02c9;
                case 29: goto L_0x02ba;
                case 30: goto L_0x02ab;
                case 31: goto L_0x029c;
                case 32: goto L_0x028d;
                case 33: goto L_0x027e;
                case 34: goto L_0x026f;
                case 35: goto L_0x0260;
                case 36: goto L_0x0251;
                case 37: goto L_0x0242;
                case 38: goto L_0x0233;
                case 39: goto L_0x0224;
                case 40: goto L_0x0215;
                case 41: goto L_0x0206;
                case 42: goto L_0x01f7;
                case 43: goto L_0x01e8;
                case 44: goto L_0x01d9;
                case 45: goto L_0x01ca;
                case 46: goto L_0x01bb;
                case 47: goto L_0x01ac;
                case 48: goto L_0x019d;
                case 49: goto L_0x018a;
                case 50: goto L_0x0181;
                case 51: goto L_0x0172;
                case 52: goto L_0x0163;
                case 53: goto L_0x0154;
                case 54: goto L_0x0145;
                case 55: goto L_0x0136;
                case 56: goto L_0x0127;
                case 57: goto L_0x0118;
                case 58: goto L_0x0109;
                case 59: goto L_0x00fa;
                case 60: goto L_0x00e7;
                case 61: goto L_0x00d6;
                case 62: goto L_0x00c7;
                case 63: goto L_0x00b8;
                case 64: goto L_0x00a9;
                case 65: goto L_0x009a;
                case 66: goto L_0x008b;
                case 67: goto L_0x007c;
                case 68: goto L_0x0069;
                default: goto L_0x0067;
            }
        L_0x0067:
            goto L_0x045c
        L_0x0069:
            boolean r4 = r0.zza((T) r1, r13, r5)
            if (r4 == 0) goto L_0x045c
            java.lang.Object r4 = r7.getObject(r1, r11)
            com.google.android.gms.internal.measurement.zzgx r9 = r0.zzbx(r5)
            r2.zzb(r13, r4, r9)
            goto L_0x045c
        L_0x007c:
            boolean r4 = r0.zza((T) r1, r13, r5)
            if (r4 == 0) goto L_0x045c
            long r11 = zzi(r1, r11)
            r2.zzb(r13, r11)
            goto L_0x045c
        L_0x008b:
            boolean r4 = r0.zza((T) r1, r13, r5)
            if (r4 == 0) goto L_0x045c
            int r4 = zzh(r1, r11)
            r2.zze(r13, r4)
            goto L_0x045c
        L_0x009a:
            boolean r4 = r0.zza((T) r1, r13, r5)
            if (r4 == 0) goto L_0x045c
            long r11 = zzi(r1, r11)
            r2.zzj(r13, r11)
            goto L_0x045c
        L_0x00a9:
            boolean r4 = r0.zza((T) r1, r13, r5)
            if (r4 == 0) goto L_0x045c
            int r4 = zzh(r1, r11)
            r2.zzm(r13, r4)
            goto L_0x045c
        L_0x00b8:
            boolean r4 = r0.zza((T) r1, r13, r5)
            if (r4 == 0) goto L_0x045c
            int r4 = zzh(r1, r11)
            r2.zzn(r13, r4)
            goto L_0x045c
        L_0x00c7:
            boolean r4 = r0.zza((T) r1, r13, r5)
            if (r4 == 0) goto L_0x045c
            int r4 = zzh(r1, r11)
            r2.zzd(r13, r4)
            goto L_0x045c
        L_0x00d6:
            boolean r4 = r0.zza((T) r1, r13, r5)
            if (r4 == 0) goto L_0x045c
            java.lang.Object r4 = r7.getObject(r1, r11)
            com.google.android.gms.internal.measurement.zzdp r4 = (com.google.android.gms.internal.measurement.zzdp) r4
            r2.zza(r13, r4)
            goto L_0x045c
        L_0x00e7:
            boolean r4 = r0.zza((T) r1, r13, r5)
            if (r4 == 0) goto L_0x045c
            java.lang.Object r4 = r7.getObject(r1, r11)
            com.google.android.gms.internal.measurement.zzgx r9 = r0.zzbx(r5)
            r2.zza(r13, r4, r9)
            goto L_0x045c
        L_0x00fa:
            boolean r4 = r0.zza((T) r1, r13, r5)
            if (r4 == 0) goto L_0x045c
            java.lang.Object r4 = r7.getObject(r1, r11)
            zza(r13, r4, r2)
            goto L_0x045c
        L_0x0109:
            boolean r4 = r0.zza((T) r1, r13, r5)
            if (r4 == 0) goto L_0x045c
            boolean r4 = zzj(r1, r11)
            r2.zzb(r13, r4)
            goto L_0x045c
        L_0x0118:
            boolean r4 = r0.zza((T) r1, r13, r5)
            if (r4 == 0) goto L_0x045c
            int r4 = zzh(r1, r11)
            r2.zzf(r13, r4)
            goto L_0x045c
        L_0x0127:
            boolean r4 = r0.zza((T) r1, r13, r5)
            if (r4 == 0) goto L_0x045c
            long r11 = zzi(r1, r11)
            r2.zzc(r13, r11)
            goto L_0x045c
        L_0x0136:
            boolean r4 = r0.zza((T) r1, r13, r5)
            if (r4 == 0) goto L_0x045c
            int r4 = zzh(r1, r11)
            r2.zzc(r13, r4)
            goto L_0x045c
        L_0x0145:
            boolean r4 = r0.zza((T) r1, r13, r5)
            if (r4 == 0) goto L_0x045c
            long r11 = zzi(r1, r11)
            r2.zza(r13, r11)
            goto L_0x045c
        L_0x0154:
            boolean r4 = r0.zza((T) r1, r13, r5)
            if (r4 == 0) goto L_0x045c
            long r11 = zzi(r1, r11)
            r2.zzi(r13, r11)
            goto L_0x045c
        L_0x0163:
            boolean r4 = r0.zza((T) r1, r13, r5)
            if (r4 == 0) goto L_0x045c
            float r4 = zzg(r1, r11)
            r2.zza(r13, r4)
            goto L_0x045c
        L_0x0172:
            boolean r4 = r0.zza((T) r1, r13, r5)
            if (r4 == 0) goto L_0x045c
            double r11 = zzf(r1, r11)
            r2.zza(r13, r11)
            goto L_0x045c
        L_0x0181:
            java.lang.Object r4 = r7.getObject(r1, r11)
            r0.zza(r2, r13, r4, r5)
            goto L_0x045c
        L_0x018a:
            int[] r4 = r0.zzakj
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzgx r11 = r0.zzbx(r5)
            com.google.android.gms.internal.measurement.zzgz.zzb(r4, r9, r2, r11)
            goto L_0x045c
        L_0x019d:
            int[] r9 = r0.zzakj
            r9 = r9[r5]
            java.lang.Object r11 = r7.getObject(r1, r11)
            java.util.List r11 = (java.util.List) r11
            com.google.android.gms.internal.measurement.zzgz.zze(r9, r11, r2, r4)
            goto L_0x045c
        L_0x01ac:
            int[] r9 = r0.zzakj
            r9 = r9[r5]
            java.lang.Object r11 = r7.getObject(r1, r11)
            java.util.List r11 = (java.util.List) r11
            com.google.android.gms.internal.measurement.zzgz.zzj(r9, r11, r2, r4)
            goto L_0x045c
        L_0x01bb:
            int[] r9 = r0.zzakj
            r9 = r9[r5]
            java.lang.Object r11 = r7.getObject(r1, r11)
            java.util.List r11 = (java.util.List) r11
            com.google.android.gms.internal.measurement.zzgz.zzg(r9, r11, r2, r4)
            goto L_0x045c
        L_0x01ca:
            int[] r9 = r0.zzakj
            r9 = r9[r5]
            java.lang.Object r11 = r7.getObject(r1, r11)
            java.util.List r11 = (java.util.List) r11
            com.google.android.gms.internal.measurement.zzgz.zzl(r9, r11, r2, r4)
            goto L_0x045c
        L_0x01d9:
            int[] r9 = r0.zzakj
            r9 = r9[r5]
            java.lang.Object r11 = r7.getObject(r1, r11)
            java.util.List r11 = (java.util.List) r11
            com.google.android.gms.internal.measurement.zzgz.zzm(r9, r11, r2, r4)
            goto L_0x045c
        L_0x01e8:
            int[] r9 = r0.zzakj
            r9 = r9[r5]
            java.lang.Object r11 = r7.getObject(r1, r11)
            java.util.List r11 = (java.util.List) r11
            com.google.android.gms.internal.measurement.zzgz.zzi(r9, r11, r2, r4)
            goto L_0x045c
        L_0x01f7:
            int[] r9 = r0.zzakj
            r9 = r9[r5]
            java.lang.Object r11 = r7.getObject(r1, r11)
            java.util.List r11 = (java.util.List) r11
            com.google.android.gms.internal.measurement.zzgz.zzn(r9, r11, r2, r4)
            goto L_0x045c
        L_0x0206:
            int[] r9 = r0.zzakj
            r9 = r9[r5]
            java.lang.Object r11 = r7.getObject(r1, r11)
            java.util.List r11 = (java.util.List) r11
            com.google.android.gms.internal.measurement.zzgz.zzk(r9, r11, r2, r4)
            goto L_0x045c
        L_0x0215:
            int[] r9 = r0.zzakj
            r9 = r9[r5]
            java.lang.Object r11 = r7.getObject(r1, r11)
            java.util.List r11 = (java.util.List) r11
            com.google.android.gms.internal.measurement.zzgz.zzf(r9, r11, r2, r4)
            goto L_0x045c
        L_0x0224:
            int[] r9 = r0.zzakj
            r9 = r9[r5]
            java.lang.Object r11 = r7.getObject(r1, r11)
            java.util.List r11 = (java.util.List) r11
            com.google.android.gms.internal.measurement.zzgz.zzh(r9, r11, r2, r4)
            goto L_0x045c
        L_0x0233:
            int[] r9 = r0.zzakj
            r9 = r9[r5]
            java.lang.Object r11 = r7.getObject(r1, r11)
            java.util.List r11 = (java.util.List) r11
            com.google.android.gms.internal.measurement.zzgz.zzd(r9, r11, r2, r4)
            goto L_0x045c
        L_0x0242:
            int[] r9 = r0.zzakj
            r9 = r9[r5]
            java.lang.Object r11 = r7.getObject(r1, r11)
            java.util.List r11 = (java.util.List) r11
            com.google.android.gms.internal.measurement.zzgz.zzc(r9, r11, r2, r4)
            goto L_0x045c
        L_0x0251:
            int[] r9 = r0.zzakj
            r9 = r9[r5]
            java.lang.Object r11 = r7.getObject(r1, r11)
            java.util.List r11 = (java.util.List) r11
            com.google.android.gms.internal.measurement.zzgz.zzb(r9, r11, r2, r4)
            goto L_0x045c
        L_0x0260:
            int[] r9 = r0.zzakj
            r9 = r9[r5]
            java.lang.Object r11 = r7.getObject(r1, r11)
            java.util.List r11 = (java.util.List) r11
            com.google.android.gms.internal.measurement.zzgz.zza(r9, r11, r2, r4)
            goto L_0x045c
        L_0x026f:
            int[] r4 = r0.zzakj
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzgz.zze(r4, r9, r2, r8)
            goto L_0x045c
        L_0x027e:
            int[] r4 = r0.zzakj
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzgz.zzj(r4, r9, r2, r8)
            goto L_0x045c
        L_0x028d:
            int[] r4 = r0.zzakj
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzgz.zzg(r4, r9, r2, r8)
            goto L_0x045c
        L_0x029c:
            int[] r4 = r0.zzakj
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzgz.zzl(r4, r9, r2, r8)
            goto L_0x045c
        L_0x02ab:
            int[] r4 = r0.zzakj
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzgz.zzm(r4, r9, r2, r8)
            goto L_0x045c
        L_0x02ba:
            int[] r4 = r0.zzakj
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzgz.zzi(r4, r9, r2, r8)
            goto L_0x045c
        L_0x02c9:
            int[] r4 = r0.zzakj
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzgz.zzb(r4, r9, r2)
            goto L_0x045c
        L_0x02d8:
            int[] r4 = r0.zzakj
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzgx r11 = r0.zzbx(r5)
            com.google.android.gms.internal.measurement.zzgz.zza(r4, r9, r2, r11)
            goto L_0x045c
        L_0x02eb:
            int[] r4 = r0.zzakj
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzgz.zza(r4, r9, r2)
            goto L_0x045c
        L_0x02fa:
            int[] r4 = r0.zzakj
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzgz.zzn(r4, r9, r2, r8)
            goto L_0x045c
        L_0x0309:
            int[] r4 = r0.zzakj
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzgz.zzk(r4, r9, r2, r8)
            goto L_0x045c
        L_0x0318:
            int[] r4 = r0.zzakj
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzgz.zzf(r4, r9, r2, r8)
            goto L_0x045c
        L_0x0327:
            int[] r4 = r0.zzakj
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzgz.zzh(r4, r9, r2, r8)
            goto L_0x045c
        L_0x0336:
            int[] r4 = r0.zzakj
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzgz.zzd(r4, r9, r2, r8)
            goto L_0x045c
        L_0x0345:
            int[] r4 = r0.zzakj
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzgz.zzc(r4, r9, r2, r8)
            goto L_0x045c
        L_0x0354:
            int[] r4 = r0.zzakj
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzgz.zzb(r4, r9, r2, r8)
            goto L_0x045c
        L_0x0363:
            int[] r4 = r0.zzakj
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzgz.zza(r4, r9, r2, r8)
            goto L_0x045c
        L_0x0372:
            r4 = r10 & r9
            if (r4 == 0) goto L_0x045c
            java.lang.Object r4 = r7.getObject(r1, r11)
            com.google.android.gms.internal.measurement.zzgx r9 = r0.zzbx(r5)
            r2.zzb(r13, r4, r9)
            goto L_0x045c
        L_0x0383:
            r4 = r10 & r9
            if (r4 == 0) goto L_0x045c
            long r11 = r7.getLong(r1, r11)
            r2.zzb(r13, r11)
            goto L_0x045c
        L_0x0390:
            r4 = r10 & r9
            if (r4 == 0) goto L_0x045c
            int r4 = r7.getInt(r1, r11)
            r2.zze(r13, r4)
            goto L_0x045c
        L_0x039d:
            r4 = r10 & r9
            if (r4 == 0) goto L_0x045c
            long r11 = r7.getLong(r1, r11)
            r2.zzj(r13, r11)
            goto L_0x045c
        L_0x03aa:
            r4 = r10 & r9
            if (r4 == 0) goto L_0x045c
            int r4 = r7.getInt(r1, r11)
            r2.zzm(r13, r4)
            goto L_0x045c
        L_0x03b7:
            r4 = r10 & r9
            if (r4 == 0) goto L_0x045c
            int r4 = r7.getInt(r1, r11)
            r2.zzn(r13, r4)
            goto L_0x045c
        L_0x03c4:
            r4 = r10 & r9
            if (r4 == 0) goto L_0x045c
            int r4 = r7.getInt(r1, r11)
            r2.zzd(r13, r4)
            goto L_0x045c
        L_0x03d1:
            r4 = r10 & r9
            if (r4 == 0) goto L_0x045c
            java.lang.Object r4 = r7.getObject(r1, r11)
            com.google.android.gms.internal.measurement.zzdp r4 = (com.google.android.gms.internal.measurement.zzdp) r4
            r2.zza(r13, r4)
            goto L_0x045c
        L_0x03e0:
            r4 = r10 & r9
            if (r4 == 0) goto L_0x045c
            java.lang.Object r4 = r7.getObject(r1, r11)
            com.google.android.gms.internal.measurement.zzgx r9 = r0.zzbx(r5)
            r2.zza(r13, r4, r9)
            goto L_0x045c
        L_0x03f1:
            r4 = r10 & r9
            if (r4 == 0) goto L_0x045c
            java.lang.Object r4 = r7.getObject(r1, r11)
            zza(r13, r4, r2)
            goto L_0x045c
        L_0x03fd:
            r4 = r10 & r9
            if (r4 == 0) goto L_0x045c
            boolean r4 = com.google.android.gms.internal.measurement.zzhv.zzm(r1, r11)
            r2.zzb(r13, r4)
            goto L_0x045c
        L_0x0409:
            r4 = r10 & r9
            if (r4 == 0) goto L_0x045c
            int r4 = r7.getInt(r1, r11)
            r2.zzf(r13, r4)
            goto L_0x045c
        L_0x0415:
            r4 = r10 & r9
            if (r4 == 0) goto L_0x045c
            long r11 = r7.getLong(r1, r11)
            r2.zzc(r13, r11)
            goto L_0x045c
        L_0x0421:
            r4 = r10 & r9
            if (r4 == 0) goto L_0x045c
            int r4 = r7.getInt(r1, r11)
            r2.zzc(r13, r4)
            goto L_0x045c
        L_0x042d:
            r4 = r10 & r9
            if (r4 == 0) goto L_0x045c
            long r11 = r7.getLong(r1, r11)
            r2.zza(r13, r11)
            goto L_0x045c
        L_0x0439:
            r4 = r10 & r9
            if (r4 == 0) goto L_0x045c
            long r11 = r7.getLong(r1, r11)
            r2.zzi(r13, r11)
            goto L_0x045c
        L_0x0445:
            r4 = r10 & r9
            if (r4 == 0) goto L_0x045c
            float r4 = com.google.android.gms.internal.measurement.zzhv.zzn(r1, r11)
            r2.zza(r13, r4)
            goto L_0x045c
        L_0x0451:
            r4 = r10 & r9
            if (r4 == 0) goto L_0x045c
            double r11 = com.google.android.gms.internal.measurement.zzhv.zzo(r1, r11)
            r2.zza(r13, r11)
        L_0x045c:
            int r5 = r5 + 3
            r9 = r15
            goto L_0x002e
        L_0x0461:
            com.google.android.gms.internal.measurement.zzen<?> r1 = r0.zzaky
            r1.zza(r3)
            r4 = 0
            throw r4
        L_0x0468:
            r4 = 0
            if (r3 != 0) goto L_0x0471
            com.google.android.gms.internal.measurement.zzhp<?, ?> r3 = r0.zzakx
            zza(r3, (T) r1, r2)
            return
        L_0x0471:
            com.google.android.gms.internal.measurement.zzen<?> r1 = r0.zzaky
            r1.zza(r2, r3)
            goto L_0x0478
        L_0x0477:
            throw r4
        L_0x0478:
            goto L_0x0477
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzgm.zzb(java.lang.Object, com.google.android.gms.internal.measurement.zzim):void");
    }

    private final <K, V> void zza(zzim zzim, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            zzim.zza(i, this.zzakz.zzr(zzby(i2)), this.zzakz.zzn(obj));
        }
    }

    private static <UT, UB> void zza(zzhp<UT, UB> zzhp, T t, zzim zzim) throws IOException {
        zzhp.zza(zzhp.zzx(t), zzim);
    }

    /* JADX INFO: used method not loaded: com.google.android.gms.internal.measurement.zzhp.zza(java.lang.Object, com.google.android.gms.internal.measurement.zzgy):null, types can be incorrect */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:151|152|(1:154)|155|(6:179|157|(2:160|158)|260|(1:162)|163)(1:256)) */
    /* JADX WARNING: Code restructure failed: missing block: B:152:?, code lost:
        r7.zza(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x0598, code lost:
        if (r9 == null) goto L_0x059a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x059a, code lost:
        r9 = r7.zzy(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x05a3, code lost:
        if (r7.zza(r9, r12) == false) goto L_0x05a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x05a5, code lost:
        r12 = r10.zzakt;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x05a9, code lost:
        if (r12 < r10.zzaku) goto L_0x05ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x05ab, code lost:
        r9 = zza((java.lang.Object) r11, r10.zzaks[r12], (UB) r9, r7);
        r12 = r12 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x05b6, code lost:
        if (r9 != null) goto L_0x05b8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x05b8, code lost:
        r7.zzf(r11, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x05bb, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:151:0x0595 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r11, com.google.android.gms.internal.measurement.zzgy r12, com.google.android.gms.internal.measurement.zzel r13) throws java.io.IOException {
        /*
            r10 = this;
            if (r13 == 0) goto L_0x05d4
            com.google.android.gms.internal.measurement.zzhp<?, ?> r7 = r10.zzakx
            com.google.android.gms.internal.measurement.zzen<?> r0 = r10.zzaky
            r8 = 0
            r9 = r8
        L_0x0008:
            int r1 = r12.zzsy()     // Catch:{ all -> 0x05bc }
            int r2 = r10.zzcd(r1)     // Catch:{ all -> 0x05bc }
            if (r2 >= 0) goto L_0x006f
            r2 = 2147483647(0x7fffffff, float:NaN)
            if (r1 != r2) goto L_0x002e
            int r12 = r10.zzakt
        L_0x0019:
            int r13 = r10.zzaku
            if (r12 >= r13) goto L_0x0028
            int[] r13 = r10.zzaks
            r13 = r13[r12]
            java.lang.Object r9 = r10.zza(r11, r13, (UB) r9, r7)
            int r12 = r12 + 1
            goto L_0x0019
        L_0x0028:
            if (r9 == 0) goto L_0x002d
            r7.zzf(r11, r9)
        L_0x002d:
            return
        L_0x002e:
            boolean r2 = r10.zzako     // Catch:{ all -> 0x05bc }
            if (r2 != 0) goto L_0x0034
            r2 = r8
            goto L_0x003b
        L_0x0034:
            com.google.android.gms.internal.measurement.zzgi r2 = r10.zzakn     // Catch:{ all -> 0x05bc }
            java.lang.Object r1 = r0.zza(r13, r2, r1)     // Catch:{ all -> 0x05bc }
            r2 = r1
        L_0x003b:
            if (r2 == 0) goto L_0x0049
            com.google.android.gms.internal.measurement.zzeo r4 = r0.zzi(r11)     // Catch:{ all -> 0x05bc }
            r1 = r12
            r3 = r13
            r5 = r9
            r6 = r7
            r0.zza(r1, r2, r3, r4, r5, r6)     // Catch:{ all -> 0x05bc }
            throw r8
        L_0x0049:
            r7.zza(r12)     // Catch:{ all -> 0x05bc }
            if (r9 != 0) goto L_0x0052
            java.lang.Object r9 = r7.zzy(r11)     // Catch:{ all -> 0x05bc }
        L_0x0052:
            boolean r1 = r7.zza(r9, r12)     // Catch:{ all -> 0x05bc }
            if (r1 != 0) goto L_0x0008
            int r12 = r10.zzakt
        L_0x005a:
            int r13 = r10.zzaku
            if (r12 >= r13) goto L_0x0069
            int[] r13 = r10.zzaks
            r13 = r13[r12]
            java.lang.Object r9 = r10.zza(r11, r13, (UB) r9, r7)
            int r12 = r12 + 1
            goto L_0x005a
        L_0x0069:
            if (r9 == 0) goto L_0x006e
            r7.zzf(r11, r9)
        L_0x006e:
            return
        L_0x006f:
            int r3 = r10.zzca(r2)     // Catch:{ all -> 0x05bc }
            r4 = 267386880(0xff00000, float:2.3665827E-29)
            r4 = r4 & r3
            int r4 = r4 >>> 20
            r5 = 1048575(0xfffff, float:1.469367E-39)
            switch(r4) {
                case 0: goto L_0x0569;
                case 1: goto L_0x055a;
                case 2: goto L_0x054b;
                case 3: goto L_0x053c;
                case 4: goto L_0x052d;
                case 5: goto L_0x051e;
                case 6: goto L_0x050f;
                case 7: goto L_0x0500;
                case 8: goto L_0x04f8;
                case 9: goto L_0x04c7;
                case 10: goto L_0x04b8;
                case 11: goto L_0x04a9;
                case 12: goto L_0x0487;
                case 13: goto L_0x0478;
                case 14: goto L_0x0469;
                case 15: goto L_0x045a;
                case 16: goto L_0x044b;
                case 17: goto L_0x041a;
                case 18: goto L_0x040c;
                case 19: goto L_0x03fe;
                case 20: goto L_0x03f0;
                case 21: goto L_0x03e2;
                case 22: goto L_0x03d4;
                case 23: goto L_0x03c6;
                case 24: goto L_0x03b8;
                case 25: goto L_0x03aa;
                case 26: goto L_0x0388;
                case 27: goto L_0x0376;
                case 28: goto L_0x0368;
                case 29: goto L_0x035a;
                case 30: goto L_0x0345;
                case 31: goto L_0x0337;
                case 32: goto L_0x0329;
                case 33: goto L_0x031b;
                case 34: goto L_0x030d;
                case 35: goto L_0x02ff;
                case 36: goto L_0x02f1;
                case 37: goto L_0x02e3;
                case 38: goto L_0x02d5;
                case 39: goto L_0x02c7;
                case 40: goto L_0x02b9;
                case 41: goto L_0x02ab;
                case 42: goto L_0x029d;
                case 43: goto L_0x028f;
                case 44: goto L_0x027a;
                case 45: goto L_0x026c;
                case 46: goto L_0x025e;
                case 47: goto L_0x0250;
                case 48: goto L_0x0242;
                case 49: goto L_0x0230;
                case 50: goto L_0x01ee;
                case 51: goto L_0x01dc;
                case 52: goto L_0x01ca;
                case 53: goto L_0x01b8;
                case 54: goto L_0x01a6;
                case 55: goto L_0x0194;
                case 56: goto L_0x0182;
                case 57: goto L_0x0170;
                case 58: goto L_0x015e;
                case 59: goto L_0x0156;
                case 60: goto L_0x0125;
                case 61: goto L_0x0117;
                case 62: goto L_0x0105;
                case 63: goto L_0x00e0;
                case 64: goto L_0x00ce;
                case 65: goto L_0x00bc;
                case 66: goto L_0x00aa;
                case 67: goto L_0x0098;
                case 68: goto L_0x0086;
                default: goto L_0x007e;
            }
        L_0x007e:
            if (r9 != 0) goto L_0x0578
            java.lang.Object r9 = r7.zzwp()     // Catch:{ zzfh -> 0x0595 }
            goto L_0x0578
        L_0x0086:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzfh -> 0x0595 }
            com.google.android.gms.internal.measurement.zzgx r5 = r10.zzbx(r2)     // Catch:{ zzfh -> 0x0595 }
            java.lang.Object r5 = r12.zzb(r5, r13)     // Catch:{ zzfh -> 0x0595 }
            com.google.android.gms.internal.measurement.zzhv.zza(r11, r3, r5)     // Catch:{ zzfh -> 0x0595 }
            r10.zzb((T) r11, r1, r2)     // Catch:{ zzfh -> 0x0595 }
            goto L_0x0008
        L_0x0098:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzfh -> 0x0595 }
            long r5 = r12.zzsu()     // Catch:{ zzfh -> 0x0595 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ zzfh -> 0x0595 }
            com.google.android.gms.internal.measurement.zzhv.zza(r11, r3, r5)     // Catch:{ zzfh -> 0x0595 }
            r10.zzb((T) r11, r1, r2)     // Catch:{ zzfh -> 0x0595 }
            goto L_0x0008
        L_0x00aa:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzfh -> 0x0595 }
            int r5 = r12.zzst()     // Catch:{ zzfh -> 0x0595 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ zzfh -> 0x0595 }
            com.google.android.gms.internal.measurement.zzhv.zza(r11, r3, r5)     // Catch:{ zzfh -> 0x0595 }
            r10.zzb((T) r11, r1, r2)     // Catch:{ zzfh -> 0x0595 }
            goto L_0x0008
        L_0x00bc:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzfh -> 0x0595 }
            long r5 = r12.zzss()     // Catch:{ zzfh -> 0x0595 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ zzfh -> 0x0595 }
            com.google.android.gms.internal.measurement.zzhv.zza(r11, r3, r5)     // Catch:{ zzfh -> 0x0595 }
            r10.zzb((T) r11, r1, r2)     // Catch:{ zzfh -> 0x0595 }
            goto L_0x0008
        L_0x00ce:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzfh -> 0x0595 }
            int r5 = r12.zzsr()     // Catch:{ zzfh -> 0x0595 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ zzfh -> 0x0595 }
            com.google.android.gms.internal.measurement.zzhv.zza(r11, r3, r5)     // Catch:{ zzfh -> 0x0595 }
            r10.zzb((T) r11, r1, r2)     // Catch:{ zzfh -> 0x0595 }
            goto L_0x0008
        L_0x00e0:
            int r4 = r12.zzsq()     // Catch:{ zzfh -> 0x0595 }
            com.google.android.gms.internal.measurement.zzfe r6 = r10.zzbz(r2)     // Catch:{ zzfh -> 0x0595 }
            if (r6 == 0) goto L_0x00f7
            boolean r6 = r6.zzg(r4)     // Catch:{ zzfh -> 0x0595 }
            if (r6 == 0) goto L_0x00f1
            goto L_0x00f7
        L_0x00f1:
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzgz.zza(r1, r4, r9, r7)     // Catch:{ zzfh -> 0x0595 }
            goto L_0x0008
        L_0x00f7:
            r3 = r3 & r5
            long r5 = (long) r3     // Catch:{ zzfh -> 0x0595 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r4)     // Catch:{ zzfh -> 0x0595 }
            com.google.android.gms.internal.measurement.zzhv.zza(r11, r5, r3)     // Catch:{ zzfh -> 0x0595 }
            r10.zzb((T) r11, r1, r2)     // Catch:{ zzfh -> 0x0595 }
            goto L_0x0008
        L_0x0105:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzfh -> 0x0595 }
            int r5 = r12.zzsp()     // Catch:{ zzfh -> 0x0595 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ zzfh -> 0x0595 }
            com.google.android.gms.internal.measurement.zzhv.zza(r11, r3, r5)     // Catch:{ zzfh -> 0x0595 }
            r10.zzb((T) r11, r1, r2)     // Catch:{ zzfh -> 0x0595 }
            goto L_0x0008
        L_0x0117:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzfh -> 0x0595 }
            com.google.android.gms.internal.measurement.zzdp r5 = r12.zzso()     // Catch:{ zzfh -> 0x0595 }
            com.google.android.gms.internal.measurement.zzhv.zza(r11, r3, r5)     // Catch:{ zzfh -> 0x0595 }
            r10.zzb((T) r11, r1, r2)     // Catch:{ zzfh -> 0x0595 }
            goto L_0x0008
        L_0x0125:
            boolean r4 = r10.zza((T) r11, r1, r2)     // Catch:{ zzfh -> 0x0595 }
            if (r4 == 0) goto L_0x0141
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzfh -> 0x0595 }
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzhv.zzp(r11, r3)     // Catch:{ zzfh -> 0x0595 }
            com.google.android.gms.internal.measurement.zzgx r6 = r10.zzbx(r2)     // Catch:{ zzfh -> 0x0595 }
            java.lang.Object r6 = r12.zza(r6, r13)     // Catch:{ zzfh -> 0x0595 }
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzez.zza(r5, r6)     // Catch:{ zzfh -> 0x0595 }
            com.google.android.gms.internal.measurement.zzhv.zza(r11, r3, r5)     // Catch:{ zzfh -> 0x0595 }
            goto L_0x0151
        L_0x0141:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzfh -> 0x0595 }
            com.google.android.gms.internal.measurement.zzgx r5 = r10.zzbx(r2)     // Catch:{ zzfh -> 0x0595 }
            java.lang.Object r5 = r12.zza(r5, r13)     // Catch:{ zzfh -> 0x0595 }
            com.google.android.gms.internal.measurement.zzhv.zza(r11, r3, r5)     // Catch:{ zzfh -> 0x0595 }
            r10.zzb((T) r11, r2)     // Catch:{ zzfh -> 0x0595 }
        L_0x0151:
            r10.zzb((T) r11, r1, r2)     // Catch:{ zzfh -> 0x0595 }
            goto L_0x0008
        L_0x0156:
            r10.zza(r11, r3, r12)     // Catch:{ zzfh -> 0x0595 }
            r10.zzb((T) r11, r1, r2)     // Catch:{ zzfh -> 0x0595 }
            goto L_0x0008
        L_0x015e:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzfh -> 0x0595 }
            boolean r5 = r12.zzsm()     // Catch:{ zzfh -> 0x0595 }
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)     // Catch:{ zzfh -> 0x0595 }
            com.google.android.gms.internal.measurement.zzhv.zza(r11, r3, r5)     // Catch:{ zzfh -> 0x0595 }
            r10.zzb((T) r11, r1, r2)     // Catch:{ zzfh -> 0x0595 }
            goto L_0x0008
        L_0x0170:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzfh -> 0x0595 }
            int r5 = r12.zzsl()     // Catch:{ zzfh -> 0x0595 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ zzfh -> 0x0595 }
            com.google.android.gms.internal.measurement.zzhv.zza(r11, r3, r5)     // Catch:{ zzfh -> 0x0595 }
            r10.zzb((T) r11, r1, r2)     // Catch:{ zzfh -> 0x0595 }
            goto L_0x0008
        L_0x0182:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzfh -> 0x0595 }
            long r5 = r12.zzsk()     // Catch:{ zzfh -> 0x0595 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ zzfh -> 0x0595 }
            com.google.android.gms.internal.measurement.zzhv.zza(r11, r3, r5)     // Catch:{ zzfh -> 0x0595 }
            r10.zzb((T) r11, r1, r2)     // Catch:{ zzfh -> 0x0595 }
            goto L_0x0008
        L_0x0194:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzfh -> 0x0595 }
            int r5 = r12.zzsj()     // Catch:{ zzfh -> 0x0595 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ zzfh -> 0x0595 }
            com.google.android.gms.internal.measurement.zzhv.zza(r11, r3, r5)     // Catch:{ zzfh -> 0x0595 }
            r10.zzb((T) r11, r1, r2)     // Catch:{ zzfh -> 0x0595 }
            goto L_0x0008
        L_0x01a6:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzfh -> 0x0595 }
            long r5 = r12.zzsh()     // Catch:{ zzfh -> 0x0595 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ zzfh -> 0x0595 }
            com.google.android.gms.internal.measurement.zzhv.zza(r11, r3, r5)     // Catch:{ zzfh -> 0x0595 }
            r10.zzb((T) r11, r1, r2)     // Catch:{ zzfh -> 0x0595 }
            goto L_0x0008
        L_0x01b8:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzfh -> 0x0595 }
            long r5 = r12.zzsi()     // Catch:{ zzfh -> 0x0595 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ zzfh -> 0x0595 }
            com.google.android.gms.internal.measurement.zzhv.zza(r11, r3, r5)     // Catch:{ zzfh -> 0x0595 }
            r10.zzb((T) r11, r1, r2)     // Catch:{ zzfh -> 0x0595 }
            goto L_0x0008
        L_0x01ca:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzfh -> 0x0595 }
            float r5 = r12.readFloat()     // Catch:{ zzfh -> 0x0595 }
            java.lang.Float r5 = java.lang.Float.valueOf(r5)     // Catch:{ zzfh -> 0x0595 }
            com.google.android.gms.internal.measurement.zzhv.zza(r11, r3, r5)     // Catch:{ zzfh -> 0x0595 }
            r10.zzb((T) r11, r1, r2)     // Catch:{ zzfh -> 0x0595 }
            goto L_0x0008
        L_0x01dc:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzfh -> 0x0595 }
            double r5 = r12.readDouble()     // Catch:{ zzfh -> 0x0595 }
            java.lang.Double r5 = java.lang.Double.valueOf(r5)     // Catch:{ zzfh -> 0x0595 }
            com.google.android.gms.internal.measurement.zzhv.zza(r11, r3, r5)     // Catch:{ zzfh -> 0x0595 }
            r10.zzb((T) r11, r1, r2)     // Catch:{ zzfh -> 0x0595 }
            goto L_0x0008
        L_0x01ee:
            java.lang.Object r1 = r10.zzby(r2)     // Catch:{ zzfh -> 0x0595 }
            int r2 = r10.zzca(r2)     // Catch:{ zzfh -> 0x0595 }
            r2 = r2 & r5
            long r2 = (long) r2     // Catch:{ zzfh -> 0x0595 }
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzhv.zzp(r11, r2)     // Catch:{ zzfh -> 0x0595 }
            if (r4 != 0) goto L_0x0208
            com.google.android.gms.internal.measurement.zzgb r4 = r10.zzakz     // Catch:{ zzfh -> 0x0595 }
            java.lang.Object r4 = r4.zzq(r1)     // Catch:{ zzfh -> 0x0595 }
            com.google.android.gms.internal.measurement.zzhv.zza(r11, r2, r4)     // Catch:{ zzfh -> 0x0595 }
            goto L_0x021f
        L_0x0208:
            com.google.android.gms.internal.measurement.zzgb r5 = r10.zzakz     // Catch:{ zzfh -> 0x0595 }
            boolean r5 = r5.zzo(r4)     // Catch:{ zzfh -> 0x0595 }
            if (r5 == 0) goto L_0x021f
            com.google.android.gms.internal.measurement.zzgb r5 = r10.zzakz     // Catch:{ zzfh -> 0x0595 }
            java.lang.Object r5 = r5.zzq(r1)     // Catch:{ zzfh -> 0x0595 }
            com.google.android.gms.internal.measurement.zzgb r6 = r10.zzakz     // Catch:{ zzfh -> 0x0595 }
            r6.zzb(r5, r4)     // Catch:{ zzfh -> 0x0595 }
            com.google.android.gms.internal.measurement.zzhv.zza(r11, r2, r5)     // Catch:{ zzfh -> 0x0595 }
            r4 = r5
        L_0x021f:
            com.google.android.gms.internal.measurement.zzgb r2 = r10.zzakz     // Catch:{ zzfh -> 0x0595 }
            java.util.Map r2 = r2.zzm(r4)     // Catch:{ zzfh -> 0x0595 }
            com.google.android.gms.internal.measurement.zzgb r3 = r10.zzakz     // Catch:{ zzfh -> 0x0595 }
            com.google.android.gms.internal.measurement.zzfz r1 = r3.zzr(r1)     // Catch:{ zzfh -> 0x0595 }
            r12.zza(r2, r1, r13)     // Catch:{ zzfh -> 0x0595 }
            goto L_0x0008
        L_0x0230:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzfh -> 0x0595 }
            com.google.android.gms.internal.measurement.zzgx r1 = r10.zzbx(r2)     // Catch:{ zzfh -> 0x0595 }
            com.google.android.gms.internal.measurement.zzfs r2 = r10.zzakw     // Catch:{ zzfh -> 0x0595 }
            java.util.List r2 = r2.zza(r11, r3)     // Catch:{ zzfh -> 0x0595 }
            r12.zzb(r2, r1, r13)     // Catch:{ zzfh -> 0x0595 }
            goto L_0x0008
        L_0x0242:
            com.google.android.gms.internal.measurement.zzfs r1 = r10.zzakw     // Catch:{ zzfh -> 0x0595 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzfh -> 0x0595 }
            java.util.List r1 = r1.zza(r11, r2)     // Catch:{ zzfh -> 0x0595 }
            r12.zzt(r1)     // Catch:{ zzfh -> 0x0595 }
            goto L_0x0008
        L_0x0250:
            com.google.android.gms.internal.measurement.zzfs r1 = r10.zzakw     // Catch:{ zzfh -> 0x0595 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzfh -> 0x0595 }
            java.util.List r1 = r1.zza(r11, r2)     // Catch:{ zzfh -> 0x0595 }
            r12.zzs(r1)     // Catch:{ zzfh -> 0x0595 }
            goto L_0x0008
        L_0x025e:
            com.google.android.gms.internal.measurement.zzfs r1 = r10.zzakw     // Catch:{ zzfh -> 0x0595 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzfh -> 0x0595 }
            java.util.List r1 = r1.zza(r11, r2)     // Catch:{ zzfh -> 0x0595 }
            r12.zzr(r1)     // Catch:{ zzfh -> 0x0595 }
            goto L_0x0008
        L_0x026c:
            com.google.android.gms.internal.measurement.zzfs r1 = r10.zzakw     // Catch:{ zzfh -> 0x0595 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzfh -> 0x0595 }
            java.util.List r1 = r1.zza(r11, r2)     // Catch:{ zzfh -> 0x0595 }
            r12.zzq(r1)     // Catch:{ zzfh -> 0x0595 }
            goto L_0x0008
        L_0x027a:
            com.google.android.gms.internal.measurement.zzfs r4 = r10.zzakw     // Catch:{ zzfh -> 0x0595 }
            r3 = r3 & r5
            long r5 = (long) r3     // Catch:{ zzfh -> 0x0595 }
            java.util.List r3 = r4.zza(r11, r5)     // Catch:{ zzfh -> 0x0595 }
            r12.zzp(r3)     // Catch:{ zzfh -> 0x0595 }
            com.google.android.gms.internal.measurement.zzfe r2 = r10.zzbz(r2)     // Catch:{ zzfh -> 0x0595 }
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzgz.zza(r1, r3, r2, r9, r7)     // Catch:{ zzfh -> 0x0595 }
            goto L_0x0008
        L_0x028f:
            com.google.android.gms.internal.measurement.zzfs r1 = r10.zzakw     // Catch:{ zzfh -> 0x0595 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzfh -> 0x0595 }
            java.util.List r1 = r1.zza(r11, r2)     // Catch:{ zzfh -> 0x0595 }
            r12.zzo(r1)     // Catch:{ zzfh -> 0x0595 }
            goto L_0x0008
        L_0x029d:
            com.google.android.gms.internal.measurement.zzfs r1 = r10.zzakw     // Catch:{ zzfh -> 0x0595 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzfh -> 0x0595 }
            java.util.List r1 = r1.zza(r11, r2)     // Catch:{ zzfh -> 0x0595 }
            r12.zzl(r1)     // Catch:{ zzfh -> 0x0595 }
            goto L_0x0008
        L_0x02ab:
            com.google.android.gms.internal.measurement.zzfs r1 = r10.zzakw     // Catch:{ zzfh -> 0x0595 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzfh -> 0x0595 }
            java.util.List r1 = r1.zza(r11, r2)     // Catch:{ zzfh -> 0x0595 }
            r12.zzk(r1)     // Catch:{ zzfh -> 0x0595 }
            goto L_0x0008
        L_0x02b9:
            com.google.android.gms.internal.measurement.zzfs r1 = r10.zzakw     // Catch:{ zzfh -> 0x0595 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzfh -> 0x0595 }
            java.util.List r1 = r1.zza(r11, r2)     // Catch:{ zzfh -> 0x0595 }
            r12.zzj(r1)     // Catch:{ zzfh -> 0x0595 }
            goto L_0x0008
        L_0x02c7:
            com.google.android.gms.internal.measurement.zzfs r1 = r10.zzakw     // Catch:{ zzfh -> 0x0595 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzfh -> 0x0595 }
            java.util.List r1 = r1.zza(r11, r2)     // Catch:{ zzfh -> 0x0595 }
            r12.zzi(r1)     // Catch:{ zzfh -> 0x0595 }
            goto L_0x0008
        L_0x02d5:
            com.google.android.gms.internal.measurement.zzfs r1 = r10.zzakw     // Catch:{ zzfh -> 0x0595 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzfh -> 0x0595 }
            java.util.List r1 = r1.zza(r11, r2)     // Catch:{ zzfh -> 0x0595 }
            r12.zzg(r1)     // Catch:{ zzfh -> 0x0595 }
            goto L_0x0008
        L_0x02e3:
            com.google.android.gms.internal.measurement.zzfs r1 = r10.zzakw     // Catch:{ zzfh -> 0x0595 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzfh -> 0x0595 }
            java.util.List r1 = r1.zza(r11, r2)     // Catch:{ zzfh -> 0x0595 }
            r12.zzh(r1)     // Catch:{ zzfh -> 0x0595 }
            goto L_0x0008
        L_0x02f1:
            com.google.android.gms.internal.measurement.zzfs r1 = r10.zzakw     // Catch:{ zzfh -> 0x0595 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzfh -> 0x0595 }
            java.util.List r1 = r1.zza(r11, r2)     // Catch:{ zzfh -> 0x0595 }
            r12.zzf(r1)     // Catch:{ zzfh -> 0x0595 }
            goto L_0x0008
        L_0x02ff:
            com.google.android.gms.internal.measurement.zzfs r1 = r10.zzakw     // Catch:{ zzfh -> 0x0595 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzfh -> 0x0595 }
            java.util.List r1 = r1.zza(r11, r2)     // Catch:{ zzfh -> 0x0595 }
            r12.zze(r1)     // Catch:{ zzfh -> 0x0595 }
            goto L_0x0008
        L_0x030d:
            com.google.android.gms.internal.measurement.zzfs r1 = r10.zzakw     // Catch:{ zzfh -> 0x0595 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzfh -> 0x0595 }
            java.util.List r1 = r1.zza(r11, r2)     // Catch:{ zzfh -> 0x0595 }
            r12.zzt(r1)     // Catch:{ zzfh -> 0x0595 }
            goto L_0x0008
        L_0x031b:
            com.google.android.gms.internal.measurement.zzfs r1 = r10.zzakw     // Catch:{ zzfh -> 0x0595 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzfh -> 0x0595 }
            java.util.List r1 = r1.zza(r11, r2)     // Catch:{ zzfh -> 0x0595 }
            r12.zzs(r1)     // Catch:{ zzfh -> 0x0595 }
            goto L_0x0008
        L_0x0329:
            com.google.android.gms.internal.measurement.zzfs r1 = r10.zzakw     // Catch:{ zzfh -> 0x0595 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzfh -> 0x0595 }
            java.util.List r1 = r1.zza(r11, r2)     // Catch:{ zzfh -> 0x0595 }
            r12.zzr(r1)     // Catch:{ zzfh -> 0x0595 }
            goto L_0x0008
        L_0x0337:
            com.google.android.gms.internal.measurement.zzfs r1 = r10.zzakw     // Catch:{ zzfh -> 0x0595 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzfh -> 0x0595 }
            java.util.List r1 = r1.zza(r11, r2)     // Catch:{ zzfh -> 0x0595 }
            r12.zzq(r1)     // Catch:{ zzfh -> 0x0595 }
            goto L_0x0008
        L_0x0345:
            com.google.android.gms.internal.measurement.zzfs r4 = r10.zzakw     // Catch:{ zzfh -> 0x0595 }
            r3 = r3 & r5
            long r5 = (long) r3     // Catch:{ zzfh -> 0x0595 }
            java.util.List r3 = r4.zza(r11, r5)     // Catch:{ zzfh -> 0x0595 }
            r12.zzp(r3)     // Catch:{ zzfh -> 0x0595 }
            com.google.android.gms.internal.measurement.zzfe r2 = r10.zzbz(r2)     // Catch:{ zzfh -> 0x0595 }
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzgz.zza(r1, r3, r2, r9, r7)     // Catch:{ zzfh -> 0x0595 }
            goto L_0x0008
        L_0x035a:
            com.google.android.gms.internal.measurement.zzfs r1 = r10.zzakw     // Catch:{ zzfh -> 0x0595 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzfh -> 0x0595 }
            java.util.List r1 = r1.zza(r11, r2)     // Catch:{ zzfh -> 0x0595 }
            r12.zzo(r1)     // Catch:{ zzfh -> 0x0595 }
            goto L_0x0008
        L_0x0368:
            com.google.android.gms.internal.measurement.zzfs r1 = r10.zzakw     // Catch:{ zzfh -> 0x0595 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzfh -> 0x0595 }
            java.util.List r1 = r1.zza(r11, r2)     // Catch:{ zzfh -> 0x0595 }
            r12.zzn(r1)     // Catch:{ zzfh -> 0x0595 }
            goto L_0x0008
        L_0x0376:
            com.google.android.gms.internal.measurement.zzgx r1 = r10.zzbx(r2)     // Catch:{ zzfh -> 0x0595 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzfh -> 0x0595 }
            com.google.android.gms.internal.measurement.zzfs r4 = r10.zzakw     // Catch:{ zzfh -> 0x0595 }
            java.util.List r2 = r4.zza(r11, r2)     // Catch:{ zzfh -> 0x0595 }
            r12.zza(r2, r1, r13)     // Catch:{ zzfh -> 0x0595 }
            goto L_0x0008
        L_0x0388:
            boolean r1 = zzcc(r3)     // Catch:{ zzfh -> 0x0595 }
            if (r1 == 0) goto L_0x039c
            com.google.android.gms.internal.measurement.zzfs r1 = r10.zzakw     // Catch:{ zzfh -> 0x0595 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzfh -> 0x0595 }
            java.util.List r1 = r1.zza(r11, r2)     // Catch:{ zzfh -> 0x0595 }
            r12.zzm(r1)     // Catch:{ zzfh -> 0x0595 }
            goto L_0x0008
        L_0x039c:
            com.google.android.gms.internal.measurement.zzfs r1 = r10.zzakw     // Catch:{ zzfh -> 0x0595 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzfh -> 0x0595 }
            java.util.List r1 = r1.zza(r11, r2)     // Catch:{ zzfh -> 0x0595 }
            r12.readStringList(r1)     // Catch:{ zzfh -> 0x0595 }
            goto L_0x0008
        L_0x03aa:
            com.google.android.gms.internal.measurement.zzfs r1 = r10.zzakw     // Catch:{ zzfh -> 0x0595 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzfh -> 0x0595 }
            java.util.List r1 = r1.zza(r11, r2)     // Catch:{ zzfh -> 0x0595 }
            r12.zzl(r1)     // Catch:{ zzfh -> 0x0595 }
            goto L_0x0008
        L_0x03b8:
            com.google.android.gms.internal.measurement.zzfs r1 = r10.zzakw     // Catch:{ zzfh -> 0x0595 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzfh -> 0x0595 }
            java.util.List r1 = r1.zza(r11, r2)     // Catch:{ zzfh -> 0x0595 }
            r12.zzk(r1)     // Catch:{ zzfh -> 0x0595 }
            goto L_0x0008
        L_0x03c6:
            com.google.android.gms.internal.measurement.zzfs r1 = r10.zzakw     // Catch:{ zzfh -> 0x0595 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzfh -> 0x0595 }
            java.util.List r1 = r1.zza(r11, r2)     // Catch:{ zzfh -> 0x0595 }
            r12.zzj(r1)     // Catch:{ zzfh -> 0x0595 }
            goto L_0x0008
        L_0x03d4:
            com.google.android.gms.internal.measurement.zzfs r1 = r10.zzakw     // Catch:{ zzfh -> 0x0595 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzfh -> 0x0595 }
            java.util.List r1 = r1.zza(r11, r2)     // Catch:{ zzfh -> 0x0595 }
            r12.zzi(r1)     // Catch:{ zzfh -> 0x0595 }
            goto L_0x0008
        L_0x03e2:
            com.google.android.gms.internal.measurement.zzfs r1 = r10.zzakw     // Catch:{ zzfh -> 0x0595 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzfh -> 0x0595 }
            java.util.List r1 = r1.zza(r11, r2)     // Catch:{ zzfh -> 0x0595 }
            r12.zzg(r1)     // Catch:{ zzfh -> 0x0595 }
            goto L_0x0008
        L_0x03f0:
            com.google.android.gms.internal.measurement.zzfs r1 = r10.zzakw     // Catch:{ zzfh -> 0x0595 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzfh -> 0x0595 }
            java.util.List r1 = r1.zza(r11, r2)     // Catch:{ zzfh -> 0x0595 }
            r12.zzh(r1)     // Catch:{ zzfh -> 0x0595 }
            goto L_0x0008
        L_0x03fe:
            com.google.android.gms.internal.measurement.zzfs r1 = r10.zzakw     // Catch:{ zzfh -> 0x0595 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzfh -> 0x0595 }
            java.util.List r1 = r1.zza(r11, r2)     // Catch:{ zzfh -> 0x0595 }
            r12.zzf(r1)     // Catch:{ zzfh -> 0x0595 }
            goto L_0x0008
        L_0x040c:
            com.google.android.gms.internal.measurement.zzfs r1 = r10.zzakw     // Catch:{ zzfh -> 0x0595 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzfh -> 0x0595 }
            java.util.List r1 = r1.zza(r11, r2)     // Catch:{ zzfh -> 0x0595 }
            r12.zze(r1)     // Catch:{ zzfh -> 0x0595 }
            goto L_0x0008
        L_0x041a:
            boolean r1 = r10.zza((T) r11, r2)     // Catch:{ zzfh -> 0x0595 }
            if (r1 == 0) goto L_0x0438
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzfh -> 0x0595 }
            java.lang.Object r1 = com.google.android.gms.internal.measurement.zzhv.zzp(r11, r3)     // Catch:{ zzfh -> 0x0595 }
            com.google.android.gms.internal.measurement.zzgx r2 = r10.zzbx(r2)     // Catch:{ zzfh -> 0x0595 }
            java.lang.Object r2 = r12.zzb(r2, r13)     // Catch:{ zzfh -> 0x0595 }
            java.lang.Object r1 = com.google.android.gms.internal.measurement.zzez.zza(r1, r2)     // Catch:{ zzfh -> 0x0595 }
            com.google.android.gms.internal.measurement.zzhv.zza(r11, r3, r1)     // Catch:{ zzfh -> 0x0595 }
            goto L_0x0008
        L_0x0438:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzfh -> 0x0595 }
            com.google.android.gms.internal.measurement.zzgx r1 = r10.zzbx(r2)     // Catch:{ zzfh -> 0x0595 }
            java.lang.Object r1 = r12.zzb(r1, r13)     // Catch:{ zzfh -> 0x0595 }
            com.google.android.gms.internal.measurement.zzhv.zza(r11, r3, r1)     // Catch:{ zzfh -> 0x0595 }
            r10.zzb((T) r11, r2)     // Catch:{ zzfh -> 0x0595 }
            goto L_0x0008
        L_0x044b:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzfh -> 0x0595 }
            long r5 = r12.zzsu()     // Catch:{ zzfh -> 0x0595 }
            com.google.android.gms.internal.measurement.zzhv.zza(r11, r3, r5)     // Catch:{ zzfh -> 0x0595 }
            r10.zzb((T) r11, r2)     // Catch:{ zzfh -> 0x0595 }
            goto L_0x0008
        L_0x045a:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzfh -> 0x0595 }
            int r1 = r12.zzst()     // Catch:{ zzfh -> 0x0595 }
            com.google.android.gms.internal.measurement.zzhv.zzb(r11, r3, r1)     // Catch:{ zzfh -> 0x0595 }
            r10.zzb((T) r11, r2)     // Catch:{ zzfh -> 0x0595 }
            goto L_0x0008
        L_0x0469:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzfh -> 0x0595 }
            long r5 = r12.zzss()     // Catch:{ zzfh -> 0x0595 }
            com.google.android.gms.internal.measurement.zzhv.zza(r11, r3, r5)     // Catch:{ zzfh -> 0x0595 }
            r10.zzb((T) r11, r2)     // Catch:{ zzfh -> 0x0595 }
            goto L_0x0008
        L_0x0478:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzfh -> 0x0595 }
            int r1 = r12.zzsr()     // Catch:{ zzfh -> 0x0595 }
            com.google.android.gms.internal.measurement.zzhv.zzb(r11, r3, r1)     // Catch:{ zzfh -> 0x0595 }
            r10.zzb((T) r11, r2)     // Catch:{ zzfh -> 0x0595 }
            goto L_0x0008
        L_0x0487:
            int r4 = r12.zzsq()     // Catch:{ zzfh -> 0x0595 }
            com.google.android.gms.internal.measurement.zzfe r6 = r10.zzbz(r2)     // Catch:{ zzfh -> 0x0595 }
            if (r6 == 0) goto L_0x049e
            boolean r6 = r6.zzg(r4)     // Catch:{ zzfh -> 0x0595 }
            if (r6 == 0) goto L_0x0498
            goto L_0x049e
        L_0x0498:
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzgz.zza(r1, r4, r9, r7)     // Catch:{ zzfh -> 0x0595 }
            goto L_0x0008
        L_0x049e:
            r1 = r3 & r5
            long r5 = (long) r1     // Catch:{ zzfh -> 0x0595 }
            com.google.android.gms.internal.measurement.zzhv.zzb(r11, r5, r4)     // Catch:{ zzfh -> 0x0595 }
            r10.zzb((T) r11, r2)     // Catch:{ zzfh -> 0x0595 }
            goto L_0x0008
        L_0x04a9:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzfh -> 0x0595 }
            int r1 = r12.zzsp()     // Catch:{ zzfh -> 0x0595 }
            com.google.android.gms.internal.measurement.zzhv.zzb(r11, r3, r1)     // Catch:{ zzfh -> 0x0595 }
            r10.zzb((T) r11, r2)     // Catch:{ zzfh -> 0x0595 }
            goto L_0x0008
        L_0x04b8:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzfh -> 0x0595 }
            com.google.android.gms.internal.measurement.zzdp r1 = r12.zzso()     // Catch:{ zzfh -> 0x0595 }
            com.google.android.gms.internal.measurement.zzhv.zza(r11, r3, r1)     // Catch:{ zzfh -> 0x0595 }
            r10.zzb((T) r11, r2)     // Catch:{ zzfh -> 0x0595 }
            goto L_0x0008
        L_0x04c7:
            boolean r1 = r10.zza((T) r11, r2)     // Catch:{ zzfh -> 0x0595 }
            if (r1 == 0) goto L_0x04e5
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzfh -> 0x0595 }
            java.lang.Object r1 = com.google.android.gms.internal.measurement.zzhv.zzp(r11, r3)     // Catch:{ zzfh -> 0x0595 }
            com.google.android.gms.internal.measurement.zzgx r2 = r10.zzbx(r2)     // Catch:{ zzfh -> 0x0595 }
            java.lang.Object r2 = r12.zza(r2, r13)     // Catch:{ zzfh -> 0x0595 }
            java.lang.Object r1 = com.google.android.gms.internal.measurement.zzez.zza(r1, r2)     // Catch:{ zzfh -> 0x0595 }
            com.google.android.gms.internal.measurement.zzhv.zza(r11, r3, r1)     // Catch:{ zzfh -> 0x0595 }
            goto L_0x0008
        L_0x04e5:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzfh -> 0x0595 }
            com.google.android.gms.internal.measurement.zzgx r1 = r10.zzbx(r2)     // Catch:{ zzfh -> 0x0595 }
            java.lang.Object r1 = r12.zza(r1, r13)     // Catch:{ zzfh -> 0x0595 }
            com.google.android.gms.internal.measurement.zzhv.zza(r11, r3, r1)     // Catch:{ zzfh -> 0x0595 }
            r10.zzb((T) r11, r2)     // Catch:{ zzfh -> 0x0595 }
            goto L_0x0008
        L_0x04f8:
            r10.zza(r11, r3, r12)     // Catch:{ zzfh -> 0x0595 }
            r10.zzb((T) r11, r2)     // Catch:{ zzfh -> 0x0595 }
            goto L_0x0008
        L_0x0500:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzfh -> 0x0595 }
            boolean r1 = r12.zzsm()     // Catch:{ zzfh -> 0x0595 }
            com.google.android.gms.internal.measurement.zzhv.zza(r11, r3, r1)     // Catch:{ zzfh -> 0x0595 }
            r10.zzb((T) r11, r2)     // Catch:{ zzfh -> 0x0595 }
            goto L_0x0008
        L_0x050f:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzfh -> 0x0595 }
            int r1 = r12.zzsl()     // Catch:{ zzfh -> 0x0595 }
            com.google.android.gms.internal.measurement.zzhv.zzb(r11, r3, r1)     // Catch:{ zzfh -> 0x0595 }
            r10.zzb((T) r11, r2)     // Catch:{ zzfh -> 0x0595 }
            goto L_0x0008
        L_0x051e:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzfh -> 0x0595 }
            long r5 = r12.zzsk()     // Catch:{ zzfh -> 0x0595 }
            com.google.android.gms.internal.measurement.zzhv.zza(r11, r3, r5)     // Catch:{ zzfh -> 0x0595 }
            r10.zzb((T) r11, r2)     // Catch:{ zzfh -> 0x0595 }
            goto L_0x0008
        L_0x052d:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzfh -> 0x0595 }
            int r1 = r12.zzsj()     // Catch:{ zzfh -> 0x0595 }
            com.google.android.gms.internal.measurement.zzhv.zzb(r11, r3, r1)     // Catch:{ zzfh -> 0x0595 }
            r10.zzb((T) r11, r2)     // Catch:{ zzfh -> 0x0595 }
            goto L_0x0008
        L_0x053c:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzfh -> 0x0595 }
            long r5 = r12.zzsh()     // Catch:{ zzfh -> 0x0595 }
            com.google.android.gms.internal.measurement.zzhv.zza(r11, r3, r5)     // Catch:{ zzfh -> 0x0595 }
            r10.zzb((T) r11, r2)     // Catch:{ zzfh -> 0x0595 }
            goto L_0x0008
        L_0x054b:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzfh -> 0x0595 }
            long r5 = r12.zzsi()     // Catch:{ zzfh -> 0x0595 }
            com.google.android.gms.internal.measurement.zzhv.zza(r11, r3, r5)     // Catch:{ zzfh -> 0x0595 }
            r10.zzb((T) r11, r2)     // Catch:{ zzfh -> 0x0595 }
            goto L_0x0008
        L_0x055a:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzfh -> 0x0595 }
            float r1 = r12.readFloat()     // Catch:{ zzfh -> 0x0595 }
            com.google.android.gms.internal.measurement.zzhv.zza(r11, r3, r1)     // Catch:{ zzfh -> 0x0595 }
            r10.zzb((T) r11, r2)     // Catch:{ zzfh -> 0x0595 }
            goto L_0x0008
        L_0x0569:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzfh -> 0x0595 }
            double r5 = r12.readDouble()     // Catch:{ zzfh -> 0x0595 }
            com.google.android.gms.internal.measurement.zzhv.zza(r11, r3, r5)     // Catch:{ zzfh -> 0x0595 }
            r10.zzb((T) r11, r2)     // Catch:{ zzfh -> 0x0595 }
            goto L_0x0008
        L_0x0578:
            boolean r1 = r7.zza(r9, r12)     // Catch:{ zzfh -> 0x0595 }
            if (r1 != 0) goto L_0x0008
            int r12 = r10.zzakt
        L_0x0580:
            int r13 = r10.zzaku
            if (r12 >= r13) goto L_0x058f
            int[] r13 = r10.zzaks
            r13 = r13[r12]
            java.lang.Object r9 = r10.zza(r11, r13, (UB) r9, r7)
            int r12 = r12 + 1
            goto L_0x0580
        L_0x058f:
            if (r9 == 0) goto L_0x0594
            r7.zzf(r11, r9)
        L_0x0594:
            return
        L_0x0595:
            r7.zza(r12)     // Catch:{ all -> 0x05bc }
            if (r9 != 0) goto L_0x059f
            java.lang.Object r1 = r7.zzy(r11)     // Catch:{ all -> 0x05bc }
            r9 = r1
        L_0x059f:
            boolean r1 = r7.zza(r9, r12)     // Catch:{ all -> 0x05bc }
            if (r1 != 0) goto L_0x0008
            int r12 = r10.zzakt
        L_0x05a7:
            int r13 = r10.zzaku
            if (r12 >= r13) goto L_0x05b6
            int[] r13 = r10.zzaks
            r13 = r13[r12]
            java.lang.Object r9 = r10.zza(r11, r13, (UB) r9, r7)
            int r12 = r12 + 1
            goto L_0x05a7
        L_0x05b6:
            if (r9 == 0) goto L_0x05bb
            r7.zzf(r11, r9)
        L_0x05bb:
            return
        L_0x05bc:
            r12 = move-exception
            int r13 = r10.zzakt
        L_0x05bf:
            int r0 = r10.zzaku
            if (r13 >= r0) goto L_0x05ce
            int[] r0 = r10.zzaks
            r0 = r0[r13]
            java.lang.Object r9 = r10.zza(r11, r0, (UB) r9, r7)
            int r13 = r13 + 1
            goto L_0x05bf
        L_0x05ce:
            if (r9 == 0) goto L_0x05d3
            r7.zzf(r11, r9)
        L_0x05d3:
            throw r12
        L_0x05d4:
            java.lang.NullPointerException r11 = new java.lang.NullPointerException
            r11.<init>()
            goto L_0x05db
        L_0x05da:
            throw r11
        L_0x05db:
            goto L_0x05da
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzgm.zza(java.lang.Object, com.google.android.gms.internal.measurement.zzgy, com.google.android.gms.internal.measurement.zzel):void");
    }

    private static zzhs zzu(Object obj) {
        zzey zzey = (zzey) obj;
        zzhs zzhs = zzey.zzahz;
        if (zzhs != zzhs.zzwq()) {
            return zzhs;
        }
        zzhs zzwr = zzhs.zzwr();
        zzey.zzahz = zzwr;
        return zzwr;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        return r2 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        return r2 + 8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int zza(byte[] r1, int r2, int r3, com.google.android.gms.internal.measurement.zzig r4, java.lang.Class<?> r5, com.google.android.gms.internal.measurement.zzdk r6) throws java.io.IOException {
        /*
            int[] r0 = com.google.android.gms.internal.measurement.zzgl.zzaee
            int r4 = r4.ordinal()
            r4 = r0[r4]
            switch(r4) {
                case 1: goto L_0x0099;
                case 2: goto L_0x0094;
                case 3: goto L_0x0087;
                case 4: goto L_0x007a;
                case 5: goto L_0x007a;
                case 6: goto L_0x006f;
                case 7: goto L_0x006f;
                case 8: goto L_0x0064;
                case 9: goto L_0x0057;
                case 10: goto L_0x0057;
                case 11: goto L_0x0057;
                case 12: goto L_0x004a;
                case 13: goto L_0x004a;
                case 14: goto L_0x003d;
                case 15: goto L_0x002b;
                case 16: goto L_0x0019;
                case 17: goto L_0x0013;
                default: goto L_0x000b;
            }
        L_0x000b:
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "unsupported field type."
            r1.<init>(r2)
            throw r1
        L_0x0013:
            int r1 = com.google.android.gms.internal.measurement.zzdl.zzd(r1, r2, r6)
            goto L_0x00ae
        L_0x0019:
            int r1 = com.google.android.gms.internal.measurement.zzdl.zzb(r1, r2, r6)
            long r2 = r6.zzadb
            long r2 = com.google.android.gms.internal.measurement.zzeb.zzbm(r2)
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r6.zzadc = r2
            goto L_0x00ae
        L_0x002b:
            int r1 = com.google.android.gms.internal.measurement.zzdl.zza(r1, r2, r6)
            int r2 = r6.zzada
            int r2 = com.google.android.gms.internal.measurement.zzeb.zzaz(r2)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r6.zzadc = r2
            goto L_0x00ae
        L_0x003d:
            com.google.android.gms.internal.measurement.zzgt r4 = com.google.android.gms.internal.measurement.zzgt.zzvy()
            com.google.android.gms.internal.measurement.zzgx r4 = r4.zzf(r5)
            int r1 = com.google.android.gms.internal.measurement.zzdl.zza(r4, r1, r2, r3, r6)
            goto L_0x00ae
        L_0x004a:
            int r1 = com.google.android.gms.internal.measurement.zzdl.zzb(r1, r2, r6)
            long r2 = r6.zzadb
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r6.zzadc = r2
            goto L_0x00ae
        L_0x0057:
            int r1 = com.google.android.gms.internal.measurement.zzdl.zza(r1, r2, r6)
            int r2 = r6.zzada
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r6.zzadc = r2
            goto L_0x00ae
        L_0x0064:
            float r1 = com.google.android.gms.internal.measurement.zzdl.zzd(r1, r2)
            java.lang.Float r1 = java.lang.Float.valueOf(r1)
            r6.zzadc = r1
            goto L_0x0084
        L_0x006f:
            long r3 = com.google.android.gms.internal.measurement.zzdl.zzb(r1, r2)
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
            r6.zzadc = r1
            goto L_0x0091
        L_0x007a:
            int r1 = com.google.android.gms.internal.measurement.zzdl.zza(r1, r2)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r6.zzadc = r1
        L_0x0084:
            int r1 = r2 + 4
            goto L_0x00ae
        L_0x0087:
            double r3 = com.google.android.gms.internal.measurement.zzdl.zzc(r1, r2)
            java.lang.Double r1 = java.lang.Double.valueOf(r3)
            r6.zzadc = r1
        L_0x0091:
            int r1 = r2 + 8
            goto L_0x00ae
        L_0x0094:
            int r1 = com.google.android.gms.internal.measurement.zzdl.zze(r1, r2, r6)
            goto L_0x00ae
        L_0x0099:
            int r1 = com.google.android.gms.internal.measurement.zzdl.zzb(r1, r2, r6)
            long r2 = r6.zzadb
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00a7
            r2 = 1
            goto L_0x00a8
        L_0x00a7:
            r2 = 0
        L_0x00a8:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            r6.zzadc = r2
        L_0x00ae:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzgm.zza(byte[], int, int, com.google.android.gms.internal.measurement.zzig, java.lang.Class, com.google.android.gms.internal.measurement.zzdk):int");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Regions count limit reached
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:690)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:690)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:690)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:869)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:128)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1507)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
        	at jadx.core.ProcessClass.process(ProcessClass.java:30)
        	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1507)
        	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
        	at jadx.core.ProcessClass.process(ProcessClass.java:35)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
        */
    /* JADX WARNING: Removed duplicated region for block: B:244:0x0422 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01eb  */
    private final int zza(T r17, byte[] r18, int r19, int r20, int r21, int r22, int r23, int r24, long r25, int r27, long r28, com.google.android.gms.internal.measurement.zzdk r30) throws java.io.IOException {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r3 = r18
            r4 = r19
            r5 = r20
            r2 = r21
            r6 = r23
            r8 = r24
            r9 = r28
            r7 = r30
            sun.misc.Unsafe r11 = zzaki
            java.lang.Object r11 = r11.getObject(r1, r9)
            com.google.android.gms.internal.measurement.zzff r11 = (com.google.android.gms.internal.measurement.zzff) r11
            boolean r12 = r11.zzrx()
            r13 = 1
            if (r12 != 0) goto L_0x0036
            int r12 = r11.size()
            if (r12 != 0) goto L_0x002c
            r12 = 10
            goto L_0x002d
        L_0x002c:
            int r12 = r12 << r13
        L_0x002d:
            com.google.android.gms.internal.measurement.zzff r11 = r11.zzap(r12)
            sun.misc.Unsafe r12 = zzaki
            r12.putObject(r1, r9, r11)
        L_0x0036:
            r9 = 5
            r14 = 0
            r10 = 2
            switch(r27) {
                case 18: goto L_0x03e4;
                case 19: goto L_0x03a6;
                case 20: goto L_0x0365;
                case 21: goto L_0x0365;
                case 22: goto L_0x034b;
                case 23: goto L_0x030c;
                case 24: goto L_0x02cd;
                case 25: goto L_0x0276;
                case 26: goto L_0x01c3;
                case 27: goto L_0x01a9;
                case 28: goto L_0x0151;
                case 29: goto L_0x034b;
                case 30: goto L_0x0119;
                case 31: goto L_0x02cd;
                case 32: goto L_0x030c;
                case 33: goto L_0x00cc;
                case 34: goto L_0x007f;
                case 35: goto L_0x03e4;
                case 36: goto L_0x03a6;
                case 37: goto L_0x0365;
                case 38: goto L_0x0365;
                case 39: goto L_0x034b;
                case 40: goto L_0x030c;
                case 41: goto L_0x02cd;
                case 42: goto L_0x0276;
                case 43: goto L_0x034b;
                case 44: goto L_0x0119;
                case 45: goto L_0x02cd;
                case 46: goto L_0x030c;
                case 47: goto L_0x00cc;
                case 48: goto L_0x007f;
                case 49: goto L_0x003f;
                default: goto L_0x003d;
            }
        L_0x003d:
            goto L_0x0422
        L_0x003f:
            r1 = 3
            if (r6 != r1) goto L_0x0422
            com.google.android.gms.internal.measurement.zzgx r1 = r0.zzbx(r8)
            r6 = r2 & -8
            r6 = r6 | 4
            r22 = r1
            r23 = r18
            r24 = r19
            r25 = r20
            r26 = r6
            r27 = r30
            int r4 = com.google.android.gms.internal.measurement.zzdl.zza(r22, r23, r24, r25, r26, r27)
            java.lang.Object r8 = r7.zzadc
            r11.add(r8)
        L_0x005f:
            if (r4 >= r5) goto L_0x0422
            int r8 = com.google.android.gms.internal.measurement.zzdl.zza(r3, r4, r7)
            int r9 = r7.zzada
            if (r2 != r9) goto L_0x0422
            r22 = r1
            r23 = r18
            r24 = r8
            r25 = r20
            r26 = r6
            r27 = r30
            int r4 = com.google.android.gms.internal.measurement.zzdl.zza(r22, r23, r24, r25, r26, r27)
            java.lang.Object r8 = r7.zzadc
            r11.add(r8)
            goto L_0x005f
        L_0x007f:
            if (r6 != r10) goto L_0x00a3
            com.google.android.gms.internal.measurement.zzfw r11 = (com.google.android.gms.internal.measurement.zzfw) r11
            int r1 = com.google.android.gms.internal.measurement.zzdl.zza(r3, r4, r7)
            int r2 = r7.zzada
            int r2 = r2 + r1
        L_0x008a:
            if (r1 >= r2) goto L_0x009a
            int r1 = com.google.android.gms.internal.measurement.zzdl.zzb(r3, r1, r7)
            long r4 = r7.zzadb
            long r4 = com.google.android.gms.internal.measurement.zzeb.zzbm(r4)
            r11.zzby(r4)
            goto L_0x008a
        L_0x009a:
            if (r1 != r2) goto L_0x009e
            goto L_0x0423
        L_0x009e:
            com.google.android.gms.internal.measurement.zzfi r1 = com.google.android.gms.internal.measurement.zzfi.zzut()
            throw r1
        L_0x00a3:
            if (r6 != 0) goto L_0x0422
            com.google.android.gms.internal.measurement.zzfw r11 = (com.google.android.gms.internal.measurement.zzfw) r11
            int r1 = com.google.android.gms.internal.measurement.zzdl.zzb(r3, r4, r7)
            long r8 = r7.zzadb
            long r8 = com.google.android.gms.internal.measurement.zzeb.zzbm(r8)
            r11.zzby(r8)
        L_0x00b4:
            if (r1 >= r5) goto L_0x0423
            int r4 = com.google.android.gms.internal.measurement.zzdl.zza(r3, r1, r7)
            int r6 = r7.zzada
            if (r2 != r6) goto L_0x0423
            int r1 = com.google.android.gms.internal.measurement.zzdl.zzb(r3, r4, r7)
            long r8 = r7.zzadb
            long r8 = com.google.android.gms.internal.measurement.zzeb.zzbm(r8)
            r11.zzby(r8)
            goto L_0x00b4
        L_0x00cc:
            if (r6 != r10) goto L_0x00f0
            com.google.android.gms.internal.measurement.zzfa r11 = (com.google.android.gms.internal.measurement.zzfa) r11
            int r1 = com.google.android.gms.internal.measurement.zzdl.zza(r3, r4, r7)
            int r2 = r7.zzada
            int r2 = r2 + r1
        L_0x00d7:
            if (r1 >= r2) goto L_0x00e7
            int r1 = com.google.android.gms.internal.measurement.zzdl.zza(r3, r1, r7)
            int r4 = r7.zzada
            int r4 = com.google.android.gms.internal.measurement.zzeb.zzaz(r4)
            r11.zzbu(r4)
            goto L_0x00d7
        L_0x00e7:
            if (r1 != r2) goto L_0x00eb
            goto L_0x0423
        L_0x00eb:
            com.google.android.gms.internal.measurement.zzfi r1 = com.google.android.gms.internal.measurement.zzfi.zzut()
            throw r1
        L_0x00f0:
            if (r6 != 0) goto L_0x0422
            com.google.android.gms.internal.measurement.zzfa r11 = (com.google.android.gms.internal.measurement.zzfa) r11
            int r1 = com.google.android.gms.internal.measurement.zzdl.zza(r3, r4, r7)
            int r4 = r7.zzada
            int r4 = com.google.android.gms.internal.measurement.zzeb.zzaz(r4)
            r11.zzbu(r4)
        L_0x0101:
            if (r1 >= r5) goto L_0x0423
            int r4 = com.google.android.gms.internal.measurement.zzdl.zza(r3, r1, r7)
            int r6 = r7.zzada
            if (r2 != r6) goto L_0x0423
            int r1 = com.google.android.gms.internal.measurement.zzdl.zza(r3, r4, r7)
            int r4 = r7.zzada
            int r4 = com.google.android.gms.internal.measurement.zzeb.zzaz(r4)
            r11.zzbu(r4)
            goto L_0x0101
        L_0x0119:
            if (r6 != r10) goto L_0x0120
            int r2 = com.google.android.gms.internal.measurement.zzdl.zza(r3, r4, r11, r7)
            goto L_0x0131
        L_0x0120:
            if (r6 != 0) goto L_0x0422
            r2 = r21
            r3 = r18
            r4 = r19
            r5 = r20
            r6 = r11
            r7 = r30
            int r2 = com.google.android.gms.internal.measurement.zzdl.zza(r2, r3, r4, r5, r6, r7)
        L_0x0131:
            com.google.android.gms.internal.measurement.zzey r1 = (com.google.android.gms.internal.measurement.zzey) r1
            com.google.android.gms.internal.measurement.zzhs r3 = r1.zzahz
            com.google.android.gms.internal.measurement.zzhs r4 = com.google.android.gms.internal.measurement.zzhs.zzwq()
            if (r3 != r4) goto L_0x013c
            r3 = 0
        L_0x013c:
            com.google.android.gms.internal.measurement.zzfe r4 = r0.zzbz(r8)
            com.google.android.gms.internal.measurement.zzhp<?, ?> r5 = r0.zzakx
            r6 = r22
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzgz.zza(r6, r11, r4, r3, r5)
            com.google.android.gms.internal.measurement.zzhs r3 = (com.google.android.gms.internal.measurement.zzhs) r3
            if (r3 == 0) goto L_0x014e
            r1.zzahz = r3
        L_0x014e:
            r1 = r2
            goto L_0x0423
        L_0x0151:
            if (r6 != r10) goto L_0x0422
            int r1 = com.google.android.gms.internal.measurement.zzdl.zza(r3, r4, r7)
            int r4 = r7.zzada
            if (r4 < 0) goto L_0x01a4
            int r6 = r3.length
            int r6 = r6 - r1
            if (r4 > r6) goto L_0x019f
            if (r4 != 0) goto L_0x0167
            com.google.android.gms.internal.measurement.zzdp r4 = com.google.android.gms.internal.measurement.zzdp.zzadh
            r11.add(r4)
            goto L_0x016f
        L_0x0167:
            com.google.android.gms.internal.measurement.zzdp r6 = com.google.android.gms.internal.measurement.zzdp.zzb(r3, r1, r4)
            r11.add(r6)
        L_0x016e:
            int r1 = r1 + r4
        L_0x016f:
            if (r1 >= r5) goto L_0x0423
            int r4 = com.google.android.gms.internal.measurement.zzdl.zza(r3, r1, r7)
            int r6 = r7.zzada
            if (r2 != r6) goto L_0x0423
            int r1 = com.google.android.gms.internal.measurement.zzdl.zza(r3, r4, r7)
            int r4 = r7.zzada
            if (r4 < 0) goto L_0x019a
            int r6 = r3.length
            int r6 = r6 - r1
            if (r4 > r6) goto L_0x0195
            if (r4 != 0) goto L_0x018d
            com.google.android.gms.internal.measurement.zzdp r4 = com.google.android.gms.internal.measurement.zzdp.zzadh
            r11.add(r4)
            goto L_0x016f
        L_0x018d:
            com.google.android.gms.internal.measurement.zzdp r6 = com.google.android.gms.internal.measurement.zzdp.zzb(r3, r1, r4)
            r11.add(r6)
            goto L_0x016e
        L_0x0195:
            com.google.android.gms.internal.measurement.zzfi r1 = com.google.android.gms.internal.measurement.zzfi.zzut()
            throw r1
        L_0x019a:
            com.google.android.gms.internal.measurement.zzfi r1 = com.google.android.gms.internal.measurement.zzfi.zzuu()
            throw r1
        L_0x019f:
            com.google.android.gms.internal.measurement.zzfi r1 = com.google.android.gms.internal.measurement.zzfi.zzut()
            throw r1
        L_0x01a4:
            com.google.android.gms.internal.measurement.zzfi r1 = com.google.android.gms.internal.measurement.zzfi.zzuu()
            throw r1
        L_0x01a9:
            if (r6 != r10) goto L_0x0422
            com.google.android.gms.internal.measurement.zzgx r1 = r0.zzbx(r8)
            r22 = r1
            r23 = r21
            r24 = r18
            r25 = r19
            r26 = r20
            r27 = r11
            r28 = r30
            int r1 = com.google.android.gms.internal.measurement.zzdl.zza(r22, r23, r24, r25, r26, r27, r28)
            goto L_0x0423
        L_0x01c3:
            if (r6 != r10) goto L_0x0422
            r8 = 536870912(0x20000000, double:2.652494739E-315)
            long r8 = r25 & r8
            java.lang.String r1 = ""
            int r6 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r6 != 0) goto L_0x0216
            int r4 = com.google.android.gms.internal.measurement.zzdl.zza(r3, r4, r7)
            int r6 = r7.zzada
            if (r6 < 0) goto L_0x0211
            if (r6 != 0) goto L_0x01de
            r11.add(r1)
            goto L_0x01e9
        L_0x01de:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.measurement.zzez.UTF_8
            r8.<init>(r3, r4, r6, r9)
            r11.add(r8)
        L_0x01e8:
            int r4 = r4 + r6
        L_0x01e9:
            if (r4 >= r5) goto L_0x0422
            int r6 = com.google.android.gms.internal.measurement.zzdl.zza(r3, r4, r7)
            int r8 = r7.zzada
            if (r2 != r8) goto L_0x0422
            int r4 = com.google.android.gms.internal.measurement.zzdl.zza(r3, r6, r7)
            int r6 = r7.zzada
            if (r6 < 0) goto L_0x020c
            if (r6 != 0) goto L_0x0201
            r11.add(r1)
            goto L_0x01e9
        L_0x0201:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.measurement.zzez.UTF_8
            r8.<init>(r3, r4, r6, r9)
            r11.add(r8)
            goto L_0x01e8
        L_0x020c:
            com.google.android.gms.internal.measurement.zzfi r1 = com.google.android.gms.internal.measurement.zzfi.zzuu()
            throw r1
        L_0x0211:
            com.google.android.gms.internal.measurement.zzfi r1 = com.google.android.gms.internal.measurement.zzfi.zzuu()
            throw r1
        L_0x0216:
            int r4 = com.google.android.gms.internal.measurement.zzdl.zza(r3, r4, r7)
            int r6 = r7.zzada
            if (r6 < 0) goto L_0x0271
            if (r6 != 0) goto L_0x0224
            r11.add(r1)
            goto L_0x0237
        L_0x0224:
            int r8 = r4 + r6
            boolean r9 = com.google.android.gms.internal.measurement.zzhy.zzf(r3, r4, r8)
            if (r9 == 0) goto L_0x026c
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.measurement.zzez.UTF_8
            r9.<init>(r3, r4, r6, r10)
            r11.add(r9)
        L_0x0236:
            r4 = r8
        L_0x0237:
            if (r4 >= r5) goto L_0x0422
            int r6 = com.google.android.gms.internal.measurement.zzdl.zza(r3, r4, r7)
            int r8 = r7.zzada
            if (r2 != r8) goto L_0x0422
            int r4 = com.google.android.gms.internal.measurement.zzdl.zza(r3, r6, r7)
            int r6 = r7.zzada
            if (r6 < 0) goto L_0x0267
            if (r6 != 0) goto L_0x024f
            r11.add(r1)
            goto L_0x0237
        L_0x024f:
            int r8 = r4 + r6
            boolean r9 = com.google.android.gms.internal.measurement.zzhy.zzf(r3, r4, r8)
            if (r9 == 0) goto L_0x0262
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.measurement.zzez.UTF_8
            r9.<init>(r3, r4, r6, r10)
            r11.add(r9)
            goto L_0x0236
        L_0x0262:
            com.google.android.gms.internal.measurement.zzfi r1 = com.google.android.gms.internal.measurement.zzfi.zzvb()
            throw r1
        L_0x0267:
            com.google.android.gms.internal.measurement.zzfi r1 = com.google.android.gms.internal.measurement.zzfi.zzuu()
            throw r1
        L_0x026c:
            com.google.android.gms.internal.measurement.zzfi r1 = com.google.android.gms.internal.measurement.zzfi.zzvb()
            throw r1
        L_0x0271:
            com.google.android.gms.internal.measurement.zzfi r1 = com.google.android.gms.internal.measurement.zzfi.zzuu()
            throw r1
        L_0x0276:
            r1 = 0
            if (r6 != r10) goto L_0x029e
            com.google.android.gms.internal.measurement.zzdn r11 = (com.google.android.gms.internal.measurement.zzdn) r11
            int r2 = com.google.android.gms.internal.measurement.zzdl.zza(r3, r4, r7)
            int r4 = r7.zzada
            int r4 = r4 + r2
        L_0x0282:
            if (r2 >= r4) goto L_0x0295
            int r2 = com.google.android.gms.internal.measurement.zzdl.zzb(r3, r2, r7)
            long r5 = r7.zzadb
            int r8 = (r5 > r14 ? 1 : (r5 == r14 ? 0 : -1))
            if (r8 == 0) goto L_0x0290
            r5 = 1
            goto L_0x0291
        L_0x0290:
            r5 = 0
        L_0x0291:
            r11.addBoolean(r5)
            goto L_0x0282
        L_0x0295:
            if (r2 != r4) goto L_0x0299
            goto L_0x014e
        L_0x0299:
            com.google.android.gms.internal.measurement.zzfi r1 = com.google.android.gms.internal.measurement.zzfi.zzut()
            throw r1
        L_0x029e:
            if (r6 != 0) goto L_0x0422
            com.google.android.gms.internal.measurement.zzdn r11 = (com.google.android.gms.internal.measurement.zzdn) r11
            int r4 = com.google.android.gms.internal.measurement.zzdl.zzb(r3, r4, r7)
            long r8 = r7.zzadb
            int r6 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r6 == 0) goto L_0x02ae
            r6 = 1
            goto L_0x02af
        L_0x02ae:
            r6 = 0
        L_0x02af:
            r11.addBoolean(r6)
        L_0x02b2:
            if (r4 >= r5) goto L_0x0422
            int r6 = com.google.android.gms.internal.measurement.zzdl.zza(r3, r4, r7)
            int r8 = r7.zzada
            if (r2 != r8) goto L_0x0422
            int r4 = com.google.android.gms.internal.measurement.zzdl.zzb(r3, r6, r7)
            long r8 = r7.zzadb
            int r6 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r6 == 0) goto L_0x02c8
            r6 = 1
            goto L_0x02c9
        L_0x02c8:
            r6 = 0
        L_0x02c9:
            r11.addBoolean(r6)
            goto L_0x02b2
        L_0x02cd:
            if (r6 != r10) goto L_0x02ed
            com.google.android.gms.internal.measurement.zzfa r11 = (com.google.android.gms.internal.measurement.zzfa) r11
            int r1 = com.google.android.gms.internal.measurement.zzdl.zza(r3, r4, r7)
            int r2 = r7.zzada
            int r2 = r2 + r1
        L_0x02d8:
            if (r1 >= r2) goto L_0x02e4
            int r4 = com.google.android.gms.internal.measurement.zzdl.zza(r3, r1)
            r11.zzbu(r4)
            int r1 = r1 + 4
            goto L_0x02d8
        L_0x02e4:
            if (r1 != r2) goto L_0x02e8
            goto L_0x0423
        L_0x02e8:
            com.google.android.gms.internal.measurement.zzfi r1 = com.google.android.gms.internal.measurement.zzfi.zzut()
            throw r1
        L_0x02ed:
            if (r6 != r9) goto L_0x0422
            com.google.android.gms.internal.measurement.zzfa r11 = (com.google.android.gms.internal.measurement.zzfa) r11
            int r1 = com.google.android.gms.internal.measurement.zzdl.zza(r18, r19)
            r11.zzbu(r1)
        L_0x02f8:
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x0423
            int r4 = com.google.android.gms.internal.measurement.zzdl.zza(r3, r1, r7)
            int r6 = r7.zzada
            if (r2 != r6) goto L_0x0423
            int r1 = com.google.android.gms.internal.measurement.zzdl.zza(r3, r4)
            r11.zzbu(r1)
            goto L_0x02f8
        L_0x030c:
            if (r6 != r10) goto L_0x032c
            com.google.android.gms.internal.measurement.zzfw r11 = (com.google.android.gms.internal.measurement.zzfw) r11
            int r1 = com.google.android.gms.internal.measurement.zzdl.zza(r3, r4, r7)
            int r2 = r7.zzada
            int r2 = r2 + r1
        L_0x0317:
            if (r1 >= r2) goto L_0x0323
            long r4 = com.google.android.gms.internal.measurement.zzdl.zzb(r3, r1)
            r11.zzby(r4)
            int r1 = r1 + 8
            goto L_0x0317
        L_0x0323:
            if (r1 != r2) goto L_0x0327
            goto L_0x0423
        L_0x0327:
            com.google.android.gms.internal.measurement.zzfi r1 = com.google.android.gms.internal.measurement.zzfi.zzut()
            throw r1
        L_0x032c:
            if (r6 != r13) goto L_0x0422
            com.google.android.gms.internal.measurement.zzfw r11 = (com.google.android.gms.internal.measurement.zzfw) r11
            long r8 = com.google.android.gms.internal.measurement.zzdl.zzb(r18, r19)
            r11.zzby(r8)
        L_0x0337:
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x0423
            int r4 = com.google.android.gms.internal.measurement.zzdl.zza(r3, r1, r7)
            int r6 = r7.zzada
            if (r2 != r6) goto L_0x0423
            long r8 = com.google.android.gms.internal.measurement.zzdl.zzb(r3, r4)
            r11.zzby(r8)
            goto L_0x0337
        L_0x034b:
            if (r6 != r10) goto L_0x0353
            int r1 = com.google.android.gms.internal.measurement.zzdl.zza(r3, r4, r11, r7)
            goto L_0x0423
        L_0x0353:
            if (r6 != 0) goto L_0x0422
            r22 = r18
            r23 = r19
            r24 = r20
            r25 = r11
            r26 = r30
            int r1 = com.google.android.gms.internal.measurement.zzdl.zza(r21, r22, r23, r24, r25, r26)
            goto L_0x0423
        L_0x0365:
            if (r6 != r10) goto L_0x0385
            com.google.android.gms.internal.measurement.zzfw r11 = (com.google.android.gms.internal.measurement.zzfw) r11
            int r1 = com.google.android.gms.internal.measurement.zzdl.zza(r3, r4, r7)
            int r2 = r7.zzada
            int r2 = r2 + r1
        L_0x0370:
            if (r1 >= r2) goto L_0x037c
            int r1 = com.google.android.gms.internal.measurement.zzdl.zzb(r3, r1, r7)
            long r4 = r7.zzadb
            r11.zzby(r4)
            goto L_0x0370
        L_0x037c:
            if (r1 != r2) goto L_0x0380
            goto L_0x0423
        L_0x0380:
            com.google.android.gms.internal.measurement.zzfi r1 = com.google.android.gms.internal.measurement.zzfi.zzut()
            throw r1
        L_0x0385:
            if (r6 != 0) goto L_0x0422
            com.google.android.gms.internal.measurement.zzfw r11 = (com.google.android.gms.internal.measurement.zzfw) r11
            int r1 = com.google.android.gms.internal.measurement.zzdl.zzb(r3, r4, r7)
            long r8 = r7.zzadb
            r11.zzby(r8)
        L_0x0392:
            if (r1 >= r5) goto L_0x0423
            int r4 = com.google.android.gms.internal.measurement.zzdl.zza(r3, r1, r7)
            int r6 = r7.zzada
            if (r2 != r6) goto L_0x0423
            int r1 = com.google.android.gms.internal.measurement.zzdl.zzb(r3, r4, r7)
            long r8 = r7.zzadb
            r11.zzby(r8)
            goto L_0x0392
        L_0x03a6:
            if (r6 != r10) goto L_0x03c5
            com.google.android.gms.internal.measurement.zzeu r11 = (com.google.android.gms.internal.measurement.zzeu) r11
            int r1 = com.google.android.gms.internal.measurement.zzdl.zza(r3, r4, r7)
            int r2 = r7.zzada
            int r2 = r2 + r1
        L_0x03b1:
            if (r1 >= r2) goto L_0x03bd
            float r4 = com.google.android.gms.internal.measurement.zzdl.zzd(r3, r1)
            r11.zzc(r4)
            int r1 = r1 + 4
            goto L_0x03b1
        L_0x03bd:
            if (r1 != r2) goto L_0x03c0
            goto L_0x0423
        L_0x03c0:
            com.google.android.gms.internal.measurement.zzfi r1 = com.google.android.gms.internal.measurement.zzfi.zzut()
            throw r1
        L_0x03c5:
            if (r6 != r9) goto L_0x0422
            com.google.android.gms.internal.measurement.zzeu r11 = (com.google.android.gms.internal.measurement.zzeu) r11
            float r1 = com.google.android.gms.internal.measurement.zzdl.zzd(r18, r19)
            r11.zzc(r1)
        L_0x03d0:
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x0423
            int r4 = com.google.android.gms.internal.measurement.zzdl.zza(r3, r1, r7)
            int r6 = r7.zzada
            if (r2 != r6) goto L_0x0423
            float r1 = com.google.android.gms.internal.measurement.zzdl.zzd(r3, r4)
            r11.zzc(r1)
            goto L_0x03d0
        L_0x03e4:
            if (r6 != r10) goto L_0x0403
            com.google.android.gms.internal.measurement.zzeh r11 = (com.google.android.gms.internal.measurement.zzeh) r11
            int r1 = com.google.android.gms.internal.measurement.zzdl.zza(r3, r4, r7)
            int r2 = r7.zzada
            int r2 = r2 + r1
        L_0x03ef:
            if (r1 >= r2) goto L_0x03fb
            double r4 = com.google.android.gms.internal.measurement.zzdl.zzc(r3, r1)
            r11.zzf(r4)
            int r1 = r1 + 8
            goto L_0x03ef
        L_0x03fb:
            if (r1 != r2) goto L_0x03fe
            goto L_0x0423
        L_0x03fe:
            com.google.android.gms.internal.measurement.zzfi r1 = com.google.android.gms.internal.measurement.zzfi.zzut()
            throw r1
        L_0x0403:
            if (r6 != r13) goto L_0x0422
            com.google.android.gms.internal.measurement.zzeh r11 = (com.google.android.gms.internal.measurement.zzeh) r11
            double r8 = com.google.android.gms.internal.measurement.zzdl.zzc(r18, r19)
            r11.zzf(r8)
        L_0x040e:
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x0423
            int r4 = com.google.android.gms.internal.measurement.zzdl.zza(r3, r1, r7)
            int r6 = r7.zzada
            if (r2 != r6) goto L_0x0423
            double r8 = com.google.android.gms.internal.measurement.zzdl.zzc(r3, r4)
            r11.zzf(r8)
            goto L_0x040e
        L_0x0422:
            r1 = r4
        L_0x0423:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzgm.zza(java.lang.Object, byte[], int, int, int, int, int, int, long, int, long, com.google.android.gms.internal.measurement.zzdk):int");
    }

    /* JADX WARNING: type inference failed for: r10v4, types: [int] */
    /* JADX WARNING: type inference failed for: r10v11 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final <K, V> int zza(T r8, byte[] r9, int r10, int r11, int r12, long r13, com.google.android.gms.internal.measurement.zzdk r15) throws java.io.IOException {
        /*
            r7 = this;
            sun.misc.Unsafe r0 = zzaki
            java.lang.Object r12 = r7.zzby(r12)
            java.lang.Object r1 = r0.getObject(r8, r13)
            com.google.android.gms.internal.measurement.zzgb r2 = r7.zzakz
            boolean r2 = r2.zzo(r1)
            if (r2 == 0) goto L_0x0021
            com.google.android.gms.internal.measurement.zzgb r2 = r7.zzakz
            java.lang.Object r2 = r2.zzq(r12)
            com.google.android.gms.internal.measurement.zzgb r3 = r7.zzakz
            r3.zzb(r2, r1)
            r0.putObject(r8, r13, r2)
            r1 = r2
        L_0x0021:
            com.google.android.gms.internal.measurement.zzgb r8 = r7.zzakz
            com.google.android.gms.internal.measurement.zzfz r8 = r8.zzr(r12)
            com.google.android.gms.internal.measurement.zzgb r12 = r7.zzakz
            java.util.Map r12 = r12.zzm(r1)
            int r10 = com.google.android.gms.internal.measurement.zzdl.zza(r9, r10, r15)
            int r13 = r15.zzada
            if (r13 < 0) goto L_0x0097
            int r14 = r11 - r10
            if (r13 > r14) goto L_0x0097
            int r13 = r13 + r10
            K r14 = r8.zzakc
            V r0 = r8.zzaba
        L_0x003e:
            if (r10 >= r13) goto L_0x008c
            int r1 = r10 + 1
            byte r10 = r9[r10]
            if (r10 >= 0) goto L_0x004c
            int r1 = com.google.android.gms.internal.measurement.zzdl.zza(r10, r9, r1, r15)
            int r10 = r15.zzada
        L_0x004c:
            r2 = r1
            int r1 = r10 >>> 3
            r3 = r10 & 7
            r4 = 1
            if (r1 == r4) goto L_0x0072
            r4 = 2
            if (r1 == r4) goto L_0x0058
            goto L_0x0087
        L_0x0058:
            com.google.android.gms.internal.measurement.zzig r1 = r8.zzakd
            int r1 = r1.zzxa()
            if (r3 != r1) goto L_0x0087
            com.google.android.gms.internal.measurement.zzig r4 = r8.zzakd
            V r10 = r8.zzaba
            java.lang.Class r5 = r10.getClass()
            r1 = r9
            r3 = r11
            r6 = r15
            int r10 = zza(r1, r2, r3, r4, r5, r6)
            java.lang.Object r0 = r15.zzadc
            goto L_0x003e
        L_0x0072:
            com.google.android.gms.internal.measurement.zzig r1 = r8.zzakb
            int r1 = r1.zzxa()
            if (r3 != r1) goto L_0x0087
            com.google.android.gms.internal.measurement.zzig r4 = r8.zzakb
            r5 = 0
            r1 = r9
            r3 = r11
            r6 = r15
            int r10 = zza(r1, r2, r3, r4, r5, r6)
            java.lang.Object r14 = r15.zzadc
            goto L_0x003e
        L_0x0087:
            int r10 = com.google.android.gms.internal.measurement.zzdl.zza(r10, r9, r2, r11, r15)
            goto L_0x003e
        L_0x008c:
            if (r10 != r13) goto L_0x0092
            r12.put(r14, r0)
            return r13
        L_0x0092:
            com.google.android.gms.internal.measurement.zzfi r8 = com.google.android.gms.internal.measurement.zzfi.zzva()
            throw r8
        L_0x0097:
            com.google.android.gms.internal.measurement.zzfi r8 = com.google.android.gms.internal.measurement.zzfi.zzut()
            goto L_0x009d
        L_0x009c:
            throw r8
        L_0x009d:
            goto L_0x009c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzgm.zza(java.lang.Object, byte[], int, int, int, long, com.google.android.gms.internal.measurement.zzdk):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:62:0x018a, code lost:
        r2 = r4 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x019b, code lost:
        r2 = r4 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x019d, code lost:
        r12.putInt(r1, r13, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:?, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:?, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zza(T r17, byte[] r18, int r19, int r20, int r21, int r22, int r23, int r24, int r25, long r26, int r28, com.google.android.gms.internal.measurement.zzdk r29) throws java.io.IOException {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r3 = r18
            r4 = r19
            r2 = r21
            r8 = r22
            r5 = r23
            r9 = r26
            r6 = r28
            r11 = r29
            sun.misc.Unsafe r12 = zzaki
            int[] r7 = r0.zzakj
            int r13 = r6 + 2
            r7 = r7[r13]
            r13 = 1048575(0xfffff, float:1.469367E-39)
            r7 = r7 & r13
            long r13 = (long) r7
            r7 = 5
            r15 = 2
            switch(r25) {
                case 51: goto L_0x018d;
                case 52: goto L_0x017d;
                case 53: goto L_0x016d;
                case 54: goto L_0x016d;
                case 55: goto L_0x015d;
                case 56: goto L_0x014e;
                case 57: goto L_0x0140;
                case 58: goto L_0x0127;
                case 59: goto L_0x00f3;
                case 60: goto L_0x00c5;
                case 61: goto L_0x00b8;
                case 62: goto L_0x015d;
                case 63: goto L_0x008a;
                case 64: goto L_0x0140;
                case 65: goto L_0x014e;
                case 66: goto L_0x0075;
                case 67: goto L_0x0060;
                case 68: goto L_0x0028;
                default: goto L_0x0026;
            }
        L_0x0026:
            goto L_0x01a1
        L_0x0028:
            r7 = 3
            if (r5 != r7) goto L_0x01a1
            r2 = r2 & -8
            r7 = r2 | 4
            com.google.android.gms.internal.measurement.zzgx r2 = r0.zzbx(r6)
            r3 = r18
            r4 = r19
            r5 = r20
            r6 = r7
            r7 = r29
            int r2 = com.google.android.gms.internal.measurement.zzdl.zza(r2, r3, r4, r5, r6, r7)
            int r3 = r12.getInt(r1, r13)
            if (r3 != r8) goto L_0x004b
            java.lang.Object r15 = r12.getObject(r1, r9)
            goto L_0x004c
        L_0x004b:
            r15 = 0
        L_0x004c:
            if (r15 != 0) goto L_0x0055
            java.lang.Object r3 = r11.zzadc
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x0055:
            java.lang.Object r3 = r11.zzadc
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzez.zza(r15, r3)
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x0060:
            if (r5 != 0) goto L_0x01a1
            int r2 = com.google.android.gms.internal.measurement.zzdl.zzb(r3, r4, r11)
            long r3 = r11.zzadb
            long r3 = com.google.android.gms.internal.measurement.zzeb.zzbm(r3)
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x0075:
            if (r5 != 0) goto L_0x01a1
            int r2 = com.google.android.gms.internal.measurement.zzdl.zza(r3, r4, r11)
            int r3 = r11.zzada
            int r3 = com.google.android.gms.internal.measurement.zzeb.zzaz(r3)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x008a:
            if (r5 != 0) goto L_0x01a1
            int r3 = com.google.android.gms.internal.measurement.zzdl.zza(r3, r4, r11)
            int r4 = r11.zzada
            com.google.android.gms.internal.measurement.zzfe r5 = r0.zzbz(r6)
            if (r5 == 0) goto L_0x00ae
            boolean r5 = r5.zzg(r4)
            if (r5 == 0) goto L_0x009f
            goto L_0x00ae
        L_0x009f:
            com.google.android.gms.internal.measurement.zzhs r1 = zzu(r17)
            long r4 = (long) r4
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            r1.zzb(r2, r4)
            r2 = r3
            goto L_0x01a2
        L_0x00ae:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)
            r12.putObject(r1, r9, r2)
            r2 = r3
            goto L_0x019d
        L_0x00b8:
            if (r5 != r15) goto L_0x01a1
            int r2 = com.google.android.gms.internal.measurement.zzdl.zze(r3, r4, r11)
            java.lang.Object r3 = r11.zzadc
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x00c5:
            if (r5 != r15) goto L_0x01a1
            com.google.android.gms.internal.measurement.zzgx r2 = r0.zzbx(r6)
            r5 = r20
            int r2 = com.google.android.gms.internal.measurement.zzdl.zza(r2, r3, r4, r5, r11)
            int r3 = r12.getInt(r1, r13)
            if (r3 != r8) goto L_0x00dc
            java.lang.Object r15 = r12.getObject(r1, r9)
            goto L_0x00dd
        L_0x00dc:
            r15 = 0
        L_0x00dd:
            if (r15 != 0) goto L_0x00e5
            java.lang.Object r3 = r11.zzadc
            r12.putObject(r1, r9, r3)
            goto L_0x00ee
        L_0x00e5:
            java.lang.Object r3 = r11.zzadc
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzez.zza(r15, r3)
            r12.putObject(r1, r9, r3)
        L_0x00ee:
            r12.putInt(r1, r13, r8)
            goto L_0x01a2
        L_0x00f3:
            if (r5 != r15) goto L_0x01a1
            int r2 = com.google.android.gms.internal.measurement.zzdl.zza(r3, r4, r11)
            int r4 = r11.zzada
            if (r4 != 0) goto L_0x0103
            java.lang.String r3 = ""
            r12.putObject(r1, r9, r3)
            goto L_0x0122
        L_0x0103:
            r5 = 536870912(0x20000000, float:1.0842022E-19)
            r5 = r24 & r5
            if (r5 == 0) goto L_0x0117
            int r5 = r2 + r4
            boolean r5 = com.google.android.gms.internal.measurement.zzhy.zzf(r3, r2, r5)
            if (r5 == 0) goto L_0x0112
            goto L_0x0117
        L_0x0112:
            com.google.android.gms.internal.measurement.zzfi r1 = com.google.android.gms.internal.measurement.zzfi.zzvb()
            throw r1
        L_0x0117:
            java.lang.String r5 = new java.lang.String
            java.nio.charset.Charset r6 = com.google.android.gms.internal.measurement.zzez.UTF_8
            r5.<init>(r3, r2, r4, r6)
            r12.putObject(r1, r9, r5)
            int r2 = r2 + r4
        L_0x0122:
            r12.putInt(r1, r13, r8)
            goto L_0x01a2
        L_0x0127:
            if (r5 != 0) goto L_0x01a1
            int r2 = com.google.android.gms.internal.measurement.zzdl.zzb(r3, r4, r11)
            long r3 = r11.zzadb
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x0137
            r15 = 1
            goto L_0x0138
        L_0x0137:
            r15 = 0
        L_0x0138:
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r15)
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x0140:
            if (r5 != r7) goto L_0x01a1
            int r2 = com.google.android.gms.internal.measurement.zzdl.zza(r18, r19)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r12.putObject(r1, r9, r2)
            goto L_0x018a
        L_0x014e:
            r2 = 1
            if (r5 != r2) goto L_0x01a1
            long r2 = com.google.android.gms.internal.measurement.zzdl.zzb(r18, r19)
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r12.putObject(r1, r9, r2)
            goto L_0x019b
        L_0x015d:
            if (r5 != 0) goto L_0x01a1
            int r2 = com.google.android.gms.internal.measurement.zzdl.zza(r3, r4, r11)
            int r3 = r11.zzada
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x016d:
            if (r5 != 0) goto L_0x01a1
            int r2 = com.google.android.gms.internal.measurement.zzdl.zzb(r3, r4, r11)
            long r3 = r11.zzadb
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x017d:
            if (r5 != r7) goto L_0x01a1
            float r2 = com.google.android.gms.internal.measurement.zzdl.zzd(r18, r19)
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            r12.putObject(r1, r9, r2)
        L_0x018a:
            int r2 = r4 + 4
            goto L_0x019d
        L_0x018d:
            r2 = 1
            if (r5 != r2) goto L_0x01a1
            double r2 = com.google.android.gms.internal.measurement.zzdl.zzc(r18, r19)
            java.lang.Double r2 = java.lang.Double.valueOf(r2)
            r12.putObject(r1, r9, r2)
        L_0x019b:
            int r2 = r4 + 8
        L_0x019d:
            r12.putInt(r1, r13, r8)
            goto L_0x01a2
        L_0x01a1:
            r2 = r4
        L_0x01a2:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzgm.zza(java.lang.Object, byte[], int, int, int, int, int, int, int, long, int, com.google.android.gms.internal.measurement.zzdk):int");
    }

    private final zzgx zzbx(int i) {
        int i2 = (i / 3) << 1;
        zzgx zzgx = (zzgx) this.zzakk[i2];
        if (zzgx != null) {
            return zzgx;
        }
        zzgx zzf = zzgt.zzvy().zzf((Class) this.zzakk[i2 + 1]);
        this.zzakk[i2] = zzf;
        return zzf;
    }

    private final Object zzby(int i) {
        return this.zzakk[(i / 3) << 1];
    }

    private final zzfe zzbz(int i) {
        return (zzfe) this.zzakk[((i / 3) << 1) + 1];
    }

    /* JADX WARNING: type inference failed for: r31v0, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r12v0 */
    /* JADX WARNING: type inference failed for: r12v1, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r0v13, types: [byte, int] */
    /* JADX WARNING: type inference failed for: r5v1, types: [int] */
    /* JADX WARNING: type inference failed for: r12v2 */
    /* JADX WARNING: type inference failed for: r3v5 */
    /* JADX WARNING: type inference failed for: r12v3 */
    /* JADX WARNING: type inference failed for: r3v6 */
    /* JADX WARNING: type inference failed for: r7v4 */
    /* JADX WARNING: type inference failed for: r0v18, types: [int] */
    /* JADX WARNING: type inference failed for: r1v12, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r12v4 */
    /* JADX WARNING: type inference failed for: r3v8 */
    /* JADX WARNING: type inference failed for: r0v27, types: [int] */
    /* JADX WARNING: type inference failed for: r1v16, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r12v5 */
    /* JADX WARNING: type inference failed for: r3v10 */
    /* JADX WARNING: type inference failed for: r3v11 */
    /* JADX WARNING: type inference failed for: r12v6 */
    /* JADX WARNING: type inference failed for: r3v12 */
    /* JADX WARNING: type inference failed for: r19v3 */
    /* JADX WARNING: type inference failed for: r8v6 */
    /* JADX WARNING: type inference failed for: r12v8 */
    /* JADX WARNING: type inference failed for: r25v0 */
    /* JADX WARNING: type inference failed for: r7v8 */
    /* JADX WARNING: type inference failed for: r25v1 */
    /* JADX WARNING: type inference failed for: r25v2 */
    /* JADX WARNING: type inference failed for: r25v3 */
    /* JADX WARNING: type inference failed for: r2v14, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r5v8, types: [int] */
    /* JADX WARNING: type inference failed for: r7v10 */
    /* JADX WARNING: type inference failed for: r12v10 */
    /* JADX WARNING: type inference failed for: r3v14 */
    /* JADX WARNING: type inference failed for: r2v15, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r25v4 */
    /* JADX WARNING: type inference failed for: r12v11 */
    /* JADX WARNING: type inference failed for: r3v16 */
    /* JADX WARNING: type inference failed for: r2v17, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r5v11, types: [int] */
    /* JADX WARNING: type inference failed for: r25v5 */
    /* JADX WARNING: type inference failed for: r25v6 */
    /* JADX WARNING: type inference failed for: r1v29, types: [int] */
    /* JADX WARNING: type inference failed for: r2v18, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r3v19 */
    /* JADX WARNING: type inference failed for: r8v11 */
    /* JADX WARNING: type inference failed for: r7v18 */
    /* JADX WARNING: type inference failed for: r12v13 */
    /* JADX WARNING: type inference failed for: r3v20 */
    /* JADX WARNING: type inference failed for: r12v14 */
    /* JADX WARNING: type inference failed for: r8v12 */
    /* JADX WARNING: type inference failed for: r3v21 */
    /* JADX WARNING: type inference failed for: r12v15 */
    /* JADX WARNING: type inference failed for: r8v13 */
    /* JADX WARNING: type inference failed for: r12v16 */
    /* JADX WARNING: type inference failed for: r8v14 */
    /* JADX WARNING: type inference failed for: r8v15 */
    /* JADX WARNING: type inference failed for: r12v17, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r8v16 */
    /* JADX WARNING: type inference failed for: r12v18, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r8v17 */
    /* JADX WARNING: type inference failed for: r12v19, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r3v22 */
    /* JADX WARNING: type inference failed for: r8v18 */
    /* JADX WARNING: type inference failed for: r12v20, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r8v19 */
    /* JADX WARNING: type inference failed for: r8v20 */
    /* JADX WARNING: type inference failed for: r12v21, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r12v22 */
    /* JADX WARNING: type inference failed for: r8v21 */
    /* JADX WARNING: type inference failed for: r3v23 */
    /* JADX WARNING: type inference failed for: r12v23 */
    /* JADX WARNING: type inference failed for: r8v22 */
    /* JADX WARNING: type inference failed for: r8v23 */
    /* JADX WARNING: type inference failed for: r12v24, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r8v24 */
    /* JADX WARNING: type inference failed for: r12v25, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r8v25 */
    /* JADX WARNING: type inference failed for: r12v26, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r8v26 */
    /* JADX WARNING: type inference failed for: r12v27, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r12v28 */
    /* JADX WARNING: type inference failed for: r8v27 */
    /* JADX WARNING: type inference failed for: r8v28 */
    /* JADX WARNING: type inference failed for: r12v29, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r8v29, types: [int] */
    /* JADX WARNING: type inference failed for: r12v30, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r8v30 */
    /* JADX WARNING: type inference failed for: r12v31, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r8v31 */
    /* JADX WARNING: type inference failed for: r12v32 */
    /* JADX WARNING: type inference failed for: r12v33, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r8v33 */
    /* JADX WARNING: type inference failed for: r12v34 */
    /* JADX WARNING: type inference failed for: r1v61, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r8v35 */
    /* JADX WARNING: type inference failed for: r12v35 */
    /* JADX WARNING: type inference failed for: r3v26 */
    /* JADX WARNING: type inference failed for: r8v36 */
    /* JADX WARNING: type inference failed for: r12v36 */
    /* JADX WARNING: type inference failed for: r8v37 */
    /* JADX WARNING: type inference failed for: r7v32 */
    /* JADX WARNING: type inference failed for: r5v29 */
    /* JADX WARNING: type inference failed for: r3v27, types: [int] */
    /* JADX WARNING: type inference failed for: r5v30 */
    /* JADX WARNING: type inference failed for: r12v37 */
    /* JADX WARNING: type inference failed for: r3v28 */
    /* JADX WARNING: type inference failed for: r12v38 */
    /* JADX WARNING: type inference failed for: r3v29 */
    /* JADX WARNING: type inference failed for: r12v39 */
    /* JADX WARNING: type inference failed for: r3v30 */
    /* JADX WARNING: type inference failed for: r25v7 */
    /* JADX WARNING: type inference failed for: r25v8 */
    /* JADX WARNING: type inference failed for: r12v40 */
    /* JADX WARNING: type inference failed for: r3v31 */
    /* JADX WARNING: type inference failed for: r12v41 */
    /* JADX WARNING: type inference failed for: r12v42 */
    /* JADX WARNING: type inference failed for: r8v39 */
    /* JADX WARNING: type inference failed for: r12v43 */
    /* JADX WARNING: type inference failed for: r8v40 */
    /* JADX WARNING: type inference failed for: r12v44 */
    /* JADX WARNING: type inference failed for: r12v45 */
    /* JADX WARNING: type inference failed for: r12v46 */
    /* JADX WARNING: type inference failed for: r12v47 */
    /* JADX WARNING: type inference failed for: r8v41 */
    /* JADX WARNING: type inference failed for: r12v48 */
    /* JADX WARNING: type inference failed for: r12v49 */
    /* JADX WARNING: type inference failed for: r12v50 */
    /* JADX WARNING: type inference failed for: r8v42 */
    /* JADX WARNING: type inference failed for: r12v51 */
    /* JADX WARNING: type inference failed for: r12v52 */
    /* JADX WARNING: type inference failed for: r12v53 */
    /* JADX WARNING: type inference failed for: r8v43 */
    /* JADX WARNING: type inference failed for: r8v44 */
    /* JADX WARNING: type inference failed for: r8v45 */
    /* JADX WARNING: type inference failed for: r12v54 */
    /* JADX WARNING: type inference failed for: r12v55 */
    /* JADX WARNING: type inference failed for: r12v56 */
    /* JADX WARNING: type inference failed for: r8v46 */
    /* JADX WARNING: type inference failed for: r12v57 */
    /* JADX WARNING: type inference failed for: r12v58 */
    /* JADX WARNING: type inference failed for: r12v59 */
    /* JADX WARNING: type inference failed for: r12v60 */
    /* JADX WARNING: type inference failed for: r8v47 */
    /* JADX WARNING: type inference failed for: r8v48 */
    /* JADX WARNING: type inference failed for: r12v61 */
    /* JADX WARNING: type inference failed for: r8v49 */
    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x0370, code lost:
        if (r0 == r15) goto L_0x03df;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x03b9, code lost:
        if (r0 == r15) goto L_0x03df;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x0017, code lost:
        r12 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x0017, code lost:
        r12 = r12;
        r3 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0092, code lost:
        r7 = r4;
        r8 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0178, code lost:
        r6 = r6 | r22;
        r12 = r12;
        r8 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0217, code lost:
        r6 = r6 | r22;
        r12 = r12;
        r8 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0219, code lost:
        r3 = r8;
        r2 = r9;
        r1 = r11;
        r9 = r13;
        r11 = r34;
        r13 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0243, code lost:
        r32 = r7;
        r8 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x02ba, code lost:
        r0 = r7 + 8;
        r12 = r12;
        r8 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x02bc, code lost:
        r6 = r6 | r22;
        r7 = r32;
        r12 = r12;
        r8 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x02c0, code lost:
        r3 = r8;
        r2 = r9;
        r1 = r11;
        r9 = r13;
        r12 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x02c4, code lost:
        r13 = r33;
        r11 = r34;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x02ca, code lost:
        r17 = r32;
        r19 = r6;
        r2 = r7;
        r7 = r8;
        r18 = r9;
        r26 = r10;
        r24 = r11;
        r6 = r34;
     */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=null, for r0v13, types: [byte, int] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte[], code=null, for r31v0, types: [byte[]] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r12v2
  assigns: []
  uses: []
  mth insns count: 602
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1507)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1507)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1507)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
    	at jadx.core.ProcessClass.process(ProcessClass.java:35)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x03e5 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x03fa  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x043c  */
    /* JADX WARNING: Unknown variable types count: 61 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(T r30, byte[] r31, int r32, int r33, int r34, com.google.android.gms.internal.measurement.zzdk r35) throws java.io.IOException {
        /*
            r29 = this;
            r15 = r29
            r14 = r30
            r12 = r31
            r13 = r33
            r11 = r34
            r9 = r35
            sun.misc.Unsafe r10 = zzaki
            r16 = 0
            r0 = r32
            r1 = -1
            r2 = 0
            r3 = 0
            r6 = 0
            r7 = -1
        L_0x0017:
            if (r0 >= r13) goto L_0x047e
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x0028
            int r0 = com.google.android.gms.internal.measurement.zzdl.zza(r0, r12, r3, r9)
            int r3 = r9.zzada
            r4 = r0
            r5 = r3
            goto L_0x002a
        L_0x0028:
            r5 = r0
            r4 = r3
        L_0x002a:
            int r3 = r5 >>> 3
            r0 = r5 & 7
            r8 = 3
            if (r3 <= r1) goto L_0x0037
            int r2 = r2 / r8
            int r1 = r15.zzp(r3, r2)
            goto L_0x003b
        L_0x0037:
            int r1 = r15.zzcd(r3)
        L_0x003b:
            r2 = r1
            r1 = -1
            if (r2 != r1) goto L_0x004e
            r24 = r3
            r2 = r4
            r19 = r6
            r17 = r7
            r26 = r10
            r6 = r11
            r18 = 0
            r7 = r5
            goto L_0x03e3
        L_0x004e:
            int[] r1 = r15.zzakj
            int r18 = r2 + 1
            r8 = r1[r18]
            r18 = 267386880(0xff00000, float:2.3665827E-29)
            r18 = r8 & r18
            int r11 = r18 >>> 20
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r19 = r5
            r5 = r8 & r18
            long r12 = (long) r5
            r5 = 17
            r20 = r8
            if (r11 > r5) goto L_0x02da
            int r5 = r2 + 2
            r1 = r1[r5]
            int r5 = r1 >>> 20
            r8 = 1
            int r22 = r8 << r5
            r1 = r1 & r18
            r5 = -1
            if (r1 == r7) goto L_0x0082
            if (r7 == r5) goto L_0x007c
            long r8 = (long) r7
            r10.putInt(r14, r8, r6)
        L_0x007c:
            long r6 = (long) r1
            int r6 = r10.getInt(r14, r6)
            r7 = r1
        L_0x0082:
            r1 = 5
            switch(r11) {
                case 0: goto L_0x02a2;
                case 1: goto L_0x0288;
                case 2: goto L_0x0262;
                case 3: goto L_0x0262;
                case 4: goto L_0x0247;
                case 5: goto L_0x0222;
                case 6: goto L_0x01ff;
                case 7: goto L_0x01d7;
                case 8: goto L_0x01b2;
                case 9: goto L_0x017c;
                case 10: goto L_0x0161;
                case 11: goto L_0x0247;
                case 12: goto L_0x012f;
                case 13: goto L_0x01ff;
                case 14: goto L_0x0222;
                case 15: goto L_0x0114;
                case 16: goto L_0x00e7;
                case 17: goto L_0x0095;
                default: goto L_0x0086;
            }
        L_0x0086:
            r12 = r31
            r13 = r35
            r9 = r2
            r11 = r3
            r32 = r7
            r8 = r19
            r18 = -1
        L_0x0092:
            r7 = r4
            goto L_0x02ca
        L_0x0095:
            r8 = 3
            if (r0 != r8) goto L_0x00db
            int r0 = r3 << 3
            r8 = r0 | 4
            com.google.android.gms.internal.measurement.zzgx r0 = r15.zzbx(r2)
            r1 = r31
            r9 = r2
            r2 = r4
            r11 = r3
            r3 = r33
            r4 = r8
            r8 = r19
            r18 = -1
            r5 = r35
            int r0 = com.google.android.gms.internal.measurement.zzdl.zza(r0, r1, r2, r3, r4, r5)
            r1 = r6 & r22
            if (r1 != 0) goto L_0x00be
            r5 = r35
            java.lang.Object r1 = r5.zzadc
            r10.putObject(r14, r12, r1)
            goto L_0x00cd
        L_0x00be:
            r5 = r35
            java.lang.Object r1 = r10.getObject(r14, r12)
            java.lang.Object r2 = r5.zzadc
            java.lang.Object r1 = com.google.android.gms.internal.measurement.zzez.zza(r1, r2)
            r10.putObject(r14, r12, r1)
        L_0x00cd:
            r6 = r6 | r22
            r12 = r31
            r13 = r33
            r3 = r8
            r2 = r9
            r1 = r11
            r11 = r34
            r9 = r5
            goto L_0x0017
        L_0x00db:
            r9 = r2
            r11 = r3
            r8 = r19
            r18 = -1
            r12 = r31
            r13 = r35
            goto L_0x0243
        L_0x00e7:
            r5 = r35
            r9 = r2
            r11 = r3
            r8 = r19
            r18 = -1
            if (r0 != 0) goto L_0x010f
            r2 = r12
            r12 = r31
            int r13 = com.google.android.gms.internal.measurement.zzdl.zzb(r12, r4, r5)
            long r0 = r5.zzadb
            long r19 = com.google.android.gms.internal.measurement.zzeb.zzbm(r0)
            r0 = r10
            r1 = r30
            r32 = r13
            r13 = r5
            r4 = r19
            r0.putLong(r1, r2, r4)
            r6 = r6 | r22
            r0 = r32
            goto L_0x02c0
        L_0x010f:
            r12 = r31
            r13 = r5
            goto L_0x0243
        L_0x0114:
            r9 = r2
            r11 = r3
            r2 = r12
            r8 = r19
            r18 = -1
            r12 = r31
            r13 = r35
            if (r0 != 0) goto L_0x0243
            int r0 = com.google.android.gms.internal.measurement.zzdl.zza(r12, r4, r13)
            int r1 = r13.zzada
            int r1 = com.google.android.gms.internal.measurement.zzeb.zzaz(r1)
            r10.putInt(r14, r2, r1)
            goto L_0x0178
        L_0x012f:
            r9 = r2
            r11 = r3
            r2 = r12
            r8 = r19
            r18 = -1
            r12 = r31
            r13 = r35
            if (r0 != 0) goto L_0x0243
            int r0 = com.google.android.gms.internal.measurement.zzdl.zza(r12, r4, r13)
            int r1 = r13.zzada
            com.google.android.gms.internal.measurement.zzfe r4 = r15.zzbz(r9)
            if (r4 == 0) goto L_0x015d
            boolean r4 = r4.zzg(r1)
            if (r4 == 0) goto L_0x014f
            goto L_0x015d
        L_0x014f:
            com.google.android.gms.internal.measurement.zzhs r2 = zzu(r30)
            long r3 = (long) r1
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
            r2.zzb(r8, r1)
            goto L_0x02c0
        L_0x015d:
            r10.putInt(r14, r2, r1)
            goto L_0x0178
        L_0x0161:
            r9 = r2
            r11 = r3
            r2 = r12
            r8 = r19
            r1 = 2
            r18 = -1
            r12 = r31
            r13 = r35
            if (r0 != r1) goto L_0x0243
            int r0 = com.google.android.gms.internal.measurement.zzdl.zze(r12, r4, r13)
            java.lang.Object r1 = r13.zzadc
            r10.putObject(r14, r2, r1)
        L_0x0178:
            r6 = r6 | r22
            goto L_0x02c0
        L_0x017c:
            r9 = r2
            r11 = r3
            r2 = r12
            r8 = r19
            r1 = 2
            r18 = -1
            r12 = r31
            r13 = r35
            if (r0 != r1) goto L_0x01ae
            com.google.android.gms.internal.measurement.zzgx r0 = r15.zzbx(r9)
            r5 = r33
            int r0 = com.google.android.gms.internal.measurement.zzdl.zza(r0, r12, r4, r5, r13)
            r1 = r6 & r22
            if (r1 != 0) goto L_0x019f
            java.lang.Object r1 = r13.zzadc
            r10.putObject(r14, r2, r1)
            goto L_0x0217
        L_0x019f:
            java.lang.Object r1 = r10.getObject(r14, r2)
            java.lang.Object r4 = r13.zzadc
            java.lang.Object r1 = com.google.android.gms.internal.measurement.zzez.zza(r1, r4)
            r10.putObject(r14, r2, r1)
            goto L_0x0217
        L_0x01ae:
            r5 = r33
            goto L_0x0243
        L_0x01b2:
            r5 = r33
            r9 = r2
            r11 = r3
            r2 = r12
            r8 = r19
            r1 = 2
            r18 = -1
            r12 = r31
            r13 = r35
            if (r0 != r1) goto L_0x0243
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r20 & r0
            if (r0 != 0) goto L_0x01cd
            int r0 = com.google.android.gms.internal.measurement.zzdl.zzc(r12, r4, r13)
            goto L_0x01d1
        L_0x01cd:
            int r0 = com.google.android.gms.internal.measurement.zzdl.zzd(r12, r4, r13)
        L_0x01d1:
            java.lang.Object r1 = r13.zzadc
            r10.putObject(r14, r2, r1)
            goto L_0x0217
        L_0x01d7:
            r5 = r33
            r9 = r2
            r11 = r3
            r2 = r12
            r8 = r19
            r18 = -1
            r12 = r31
            r13 = r35
            if (r0 != 0) goto L_0x0243
            int r0 = com.google.android.gms.internal.measurement.zzdl.zzb(r12, r4, r13)
            r32 = r0
            long r0 = r13.zzadb
            r19 = 0
            int r4 = (r0 > r19 ? 1 : (r0 == r19 ? 0 : -1))
            if (r4 == 0) goto L_0x01f6
            r0 = 1
            goto L_0x01f7
        L_0x01f6:
            r0 = 0
        L_0x01f7:
            com.google.android.gms.internal.measurement.zzhv.zza(r14, r2, r0)
            r6 = r6 | r22
            r0 = r32
            goto L_0x0219
        L_0x01ff:
            r5 = r33
            r9 = r2
            r11 = r3
            r2 = r12
            r8 = r19
            r18 = -1
            r12 = r31
            r13 = r35
            if (r0 != r1) goto L_0x0243
            int r0 = com.google.android.gms.internal.measurement.zzdl.zza(r12, r4)
            r10.putInt(r14, r2, r0)
            int r0 = r4 + 4
        L_0x0217:
            r6 = r6 | r22
        L_0x0219:
            r3 = r8
            r2 = r9
            r1 = r11
            r9 = r13
            r11 = r34
            r13 = r5
            goto L_0x0017
        L_0x0222:
            r5 = r33
            r9 = r2
            r11 = r3
            r2 = r12
            r8 = r19
            r1 = 1
            r18 = -1
            r12 = r31
            r13 = r35
            if (r0 != r1) goto L_0x0243
            long r19 = com.google.android.gms.internal.measurement.zzdl.zzb(r12, r4)
            r0 = r10
            r1 = r30
            r32 = r7
            r7 = r4
            r4 = r19
            r0.putLong(r1, r2, r4)
            goto L_0x02ba
        L_0x0243:
            r32 = r7
            goto L_0x0092
        L_0x0247:
            r9 = r2
            r11 = r3
            r32 = r7
            r2 = r12
            r8 = r19
            r18 = -1
            r12 = r31
            r13 = r35
            r7 = r4
            if (r0 != 0) goto L_0x02ca
            int r0 = com.google.android.gms.internal.measurement.zzdl.zza(r12, r7, r13)
            int r1 = r13.zzada
            r10.putInt(r14, r2, r1)
            goto L_0x02bc
        L_0x0262:
            r9 = r2
            r11 = r3
            r32 = r7
            r2 = r12
            r8 = r19
            r18 = -1
            r12 = r31
            r13 = r35
            r7 = r4
            if (r0 != 0) goto L_0x02ca
            int r7 = com.google.android.gms.internal.measurement.zzdl.zzb(r12, r7, r13)
            long r4 = r13.zzadb
            r0 = r10
            r1 = r30
            r0.putLong(r1, r2, r4)
            r6 = r6 | r22
            r0 = r7
            r3 = r8
            r2 = r9
            r1 = r11
            r9 = r13
            r7 = r32
            goto L_0x02c4
        L_0x0288:
            r9 = r2
            r11 = r3
            r32 = r7
            r2 = r12
            r8 = r19
            r18 = -1
            r12 = r31
            r13 = r35
            r7 = r4
            if (r0 != r1) goto L_0x02ca
            float r0 = com.google.android.gms.internal.measurement.zzdl.zzd(r12, r7)
            com.google.android.gms.internal.measurement.zzhv.zza(r14, r2, r0)
            int r0 = r7 + 4
            goto L_0x02bc
        L_0x02a2:
            r9 = r2
            r11 = r3
            r32 = r7
            r2 = r12
            r8 = r19
            r1 = 1
            r18 = -1
            r12 = r31
            r13 = r35
            r7 = r4
            if (r0 != r1) goto L_0x02ca
            double r0 = com.google.android.gms.internal.measurement.zzdl.zzc(r12, r7)
            com.google.android.gms.internal.measurement.zzhv.zza(r14, r2, r0)
        L_0x02ba:
            int r0 = r7 + 8
        L_0x02bc:
            r6 = r6 | r22
            r7 = r32
        L_0x02c0:
            r3 = r8
            r2 = r9
            r1 = r11
            r9 = r13
        L_0x02c4:
            r13 = r33
            r11 = r34
            goto L_0x0017
        L_0x02ca:
            r17 = r32
            r19 = r6
            r2 = r7
            r7 = r8
            r18 = r9
            r26 = r10
            r24 = r11
            r6 = r34
            goto L_0x03e3
        L_0x02da:
            r5 = r3
            r17 = r7
            r8 = r19
            r18 = -1
            r7 = r4
            r27 = r12
            r12 = r31
            r13 = r9
            r9 = r2
            r2 = r27
            r1 = 27
            if (r11 != r1) goto L_0x033f
            r1 = 2
            if (r0 != r1) goto L_0x0332
            java.lang.Object r0 = r10.getObject(r14, r2)
            com.google.android.gms.internal.measurement.zzff r0 = (com.google.android.gms.internal.measurement.zzff) r0
            boolean r1 = r0.zzrx()
            if (r1 != 0) goto L_0x030f
            int r1 = r0.size()
            if (r1 != 0) goto L_0x0306
            r1 = 10
            goto L_0x0308
        L_0x0306:
            int r1 = r1 << 1
        L_0x0308:
            com.google.android.gms.internal.measurement.zzff r0 = r0.zzap(r1)
            r10.putObject(r14, r2, r0)
        L_0x030f:
            r11 = r0
            com.google.android.gms.internal.measurement.zzgx r0 = r15.zzbx(r9)
            r1 = r8
            r2 = r31
            r3 = r7
            r4 = r33
            r7 = r5
            r5 = r11
            r19 = r6
            r6 = r35
            int r0 = com.google.android.gms.internal.measurement.zzdl.zza(r0, r1, r2, r3, r4, r5, r6)
            r11 = r34
            r1 = r7
            r3 = r8
            r2 = r9
            r9 = r13
            r7 = r17
            r6 = r19
            r13 = r33
            goto L_0x0017
        L_0x0332:
            r19 = r6
            r24 = r5
            r15 = r7
            r25 = r8
            r18 = r9
            r26 = r10
            goto L_0x03bc
        L_0x033f:
            r19 = r6
            r6 = r5
            r1 = 49
            if (r11 > r1) goto L_0x038e
            r5 = r20
            long r4 = (long) r5
            r1 = r0
            r0 = r29
            r32 = r1
            r1 = r30
            r22 = r2
            r2 = r31
            r3 = r7
            r20 = r4
            r4 = r33
            r5 = r8
            r24 = r6
            r15 = r7
            r7 = r32
            r25 = r8
            r8 = r9
            r18 = r9
            r26 = r10
            r9 = r20
            r12 = r22
            r14 = r35
            int r0 = r0.zza((T) r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r14)
            if (r0 != r15) goto L_0x0374
            goto L_0x03df
        L_0x0374:
            r15 = r29
            r14 = r30
            r12 = r31
            r13 = r33
            r11 = r34
            r9 = r35
            r7 = r17
            r2 = r18
            r6 = r19
            r1 = r24
            r3 = r25
        L_0x038a:
            r10 = r26
            goto L_0x0017
        L_0x038e:
            r32 = r0
            r22 = r2
            r24 = r6
            r15 = r7
            r25 = r8
            r18 = r9
            r26 = r10
            r5 = r20
            r0 = 50
            if (r11 != r0) goto L_0x03c2
            r7 = r32
            r0 = 2
            if (r7 != r0) goto L_0x03bc
            r0 = r29
            r1 = r30
            r2 = r31
            r3 = r15
            r4 = r33
            r5 = r18
            r6 = r22
            r8 = r35
            int r0 = r0.zza((T) r1, r2, r3, r4, r5, r6, r8)
            if (r0 != r15) goto L_0x0374
            goto L_0x03df
        L_0x03bc:
            r6 = r34
            r2 = r15
        L_0x03bf:
            r7 = r25
            goto L_0x03e3
        L_0x03c2:
            r7 = r32
            r0 = r29
            r1 = r30
            r2 = r31
            r3 = r15
            r4 = r33
            r8 = r5
            r5 = r25
            r6 = r24
            r9 = r11
            r10 = r22
            r12 = r18
            r13 = r35
            int r0 = r0.zza((T) r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13)
            if (r0 != r15) goto L_0x0464
        L_0x03df:
            r6 = r34
            r2 = r0
            goto L_0x03bf
        L_0x03e3:
            if (r7 != r6) goto L_0x03f4
            if (r6 != 0) goto L_0x03e8
            goto L_0x03f4
        L_0x03e8:
            r4 = -1
            r8 = r29
            r11 = r30
            r3 = r7
            r0 = r17
            r1 = r19
            goto L_0x048d
        L_0x03f4:
            r8 = r29
            boolean r0 = r8.zzako
            if (r0 == 0) goto L_0x043c
            r9 = r35
            com.google.android.gms.internal.measurement.zzel r0 = r9.zzadd
            com.google.android.gms.internal.measurement.zzel r1 = com.google.android.gms.internal.measurement.zzel.zztp()
            if (r0 == r1) goto L_0x0439
            com.google.android.gms.internal.measurement.zzgi r0 = r8.zzakn
            com.google.android.gms.internal.measurement.zzel r1 = r9.zzadd
            r10 = r24
            com.google.android.gms.internal.measurement.zzey$zze r0 = r1.zza(r0, r10)
            if (r0 != 0) goto L_0x0429
            com.google.android.gms.internal.measurement.zzhs r4 = zzu(r30)
            r0 = r7
            r1 = r31
            r3 = r33
            r5 = r35
            int r0 = com.google.android.gms.internal.measurement.zzdl.zza(r0, r1, r2, r3, r4, r5)
            r14 = r30
            r12 = r31
            r13 = r33
            r11 = r6
            r3 = r7
            r15 = r8
            goto L_0x0475
        L_0x0429:
            r11 = r30
            r0 = r11
            com.google.android.gms.internal.measurement.zzey$zzb r0 = (com.google.android.gms.internal.measurement.zzey.zzb) r0
            r0.zzuq()
            com.google.android.gms.internal.measurement.zzeo<java.lang.Object> r0 = r0.zzaic
            java.lang.NoSuchMethodError r0 = new java.lang.NoSuchMethodError
            r0.<init>()
            throw r0
        L_0x0439:
            r11 = r30
            goto L_0x0440
        L_0x043c:
            r11 = r30
            r9 = r35
        L_0x0440:
            r10 = r24
            com.google.android.gms.internal.measurement.zzhs r4 = zzu(r30)
            r0 = r7
            r1 = r31
            r3 = r33
            r5 = r35
            int r0 = com.google.android.gms.internal.measurement.zzdl.zza(r0, r1, r2, r3, r4, r5)
            r12 = r31
            r13 = r33
            r3 = r7
            r15 = r8
            r1 = r10
            r14 = r11
            r7 = r17
            r2 = r18
            r10 = r26
            r11 = r6
            r6 = r19
            goto L_0x0017
        L_0x0464:
            r10 = r24
            r7 = r25
            r15 = r29
            r14 = r30
            r12 = r31
            r13 = r33
            r11 = r34
            r9 = r35
            r3 = r7
        L_0x0475:
            r1 = r10
            r7 = r17
            r2 = r18
            r6 = r19
            goto L_0x038a
        L_0x047e:
            r19 = r6
            r17 = r7
            r26 = r10
            r6 = r11
            r11 = r14
            r8 = r15
            r2 = r0
            r0 = r17
            r1 = r19
            r4 = -1
        L_0x048d:
            if (r0 == r4) goto L_0x0495
            long r4 = (long) r0
            r0 = r26
            r0.putInt(r11, r4, r1)
        L_0x0495:
            r0 = 0
            int r1 = r8.zzakt
        L_0x0498:
            int r4 = r8.zzaku
            if (r1 >= r4) goto L_0x04ab
            int[] r4 = r8.zzaks
            r4 = r4[r1]
            com.google.android.gms.internal.measurement.zzhp<?, ?> r5 = r8.zzakx
            java.lang.Object r0 = r8.zza(r11, r4, (UB) r0, r5)
            com.google.android.gms.internal.measurement.zzhs r0 = (com.google.android.gms.internal.measurement.zzhs) r0
            int r1 = r1 + 1
            goto L_0x0498
        L_0x04ab:
            if (r0 == 0) goto L_0x04b2
            com.google.android.gms.internal.measurement.zzhp<?, ?> r1 = r8.zzakx
            r1.zzf(r11, r0)
        L_0x04b2:
            if (r6 != 0) goto L_0x04be
            r0 = r33
            if (r2 != r0) goto L_0x04b9
            goto L_0x04c4
        L_0x04b9:
            com.google.android.gms.internal.measurement.zzfi r0 = com.google.android.gms.internal.measurement.zzfi.zzva()
            throw r0
        L_0x04be:
            r0 = r33
            if (r2 > r0) goto L_0x04c5
            if (r3 != r6) goto L_0x04c5
        L_0x04c4:
            return r2
        L_0x04c5:
            com.google.android.gms.internal.measurement.zzfi r0 = com.google.android.gms.internal.measurement.zzfi.zzva()
            goto L_0x04cb
        L_0x04ca:
            throw r0
        L_0x04cb:
            goto L_0x04ca
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzgm.zza(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.measurement.zzdk):int");
    }

    /* JADX WARNING: type inference failed for: r29v0, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r12v0 */
    /* JADX WARNING: type inference failed for: r2v0, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r12v1, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r0v5, types: [byte, int] */
    /* JADX WARNING: type inference failed for: r17v0, types: [int] */
    /* JADX WARNING: type inference failed for: r12v2 */
    /* JADX WARNING: type inference failed for: r12v3 */
    /* JADX WARNING: type inference failed for: r0v9, types: [int] */
    /* JADX WARNING: type inference failed for: r1v5, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r2v8, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r5v3, types: [int] */
    /* JADX WARNING: type inference failed for: r2v9, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r2v10, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r5v5, types: [int] */
    /* JADX WARNING: type inference failed for: r1v11, types: [int] */
    /* JADX WARNING: type inference failed for: r2v11, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r17v1 */
    /* JADX WARNING: type inference failed for: r3v13, types: [int] */
    /* JADX WARNING: type inference failed for: r17v2 */
    /* JADX WARNING: type inference failed for: r12v6 */
    /* JADX WARNING: type inference failed for: r12v7 */
    /* JADX WARNING: type inference failed for: r12v8 */
    /* JADX WARNING: type inference failed for: r12v9 */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0251, code lost:
        r12 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0251, code lost:
        r12 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x010b, code lost:
        r2 = r4;
        r1 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x013d, code lost:
        r0 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0159, code lost:
        r0 = r8 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x015b, code lost:
        r1 = r7;
        r2 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x015f, code lost:
        r24 = r7;
        r15 = r8;
        r18 = r9;
        r19 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01e2, code lost:
        if (r0 == r15) goto L_0x0230;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x020f, code lost:
        if (r0 == r15) goto L_0x0230;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x022e, code lost:
        if (r0 == r15) goto L_0x0230;
     */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=null, for r0v5, types: [byte, int] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte[], code=null, for r29v0, types: [byte[]] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r12v2
  assigns: []
  uses: []
  mth insns count: 271
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1507)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1507)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1507)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
    	at jadx.core.ProcessClass.process(ProcessClass.java:35)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Unknown variable types count: 16 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r28, byte[] r29, int r30, int r31, com.google.android.gms.internal.measurement.zzdk r32) throws java.io.IOException {
        /*
            r27 = this;
            r15 = r27
            r14 = r28
            r12 = r29
            r13 = r31
            r11 = r32
            boolean r0 = r15.zzakq
            if (r0 == 0) goto L_0x025d
            sun.misc.Unsafe r9 = zzaki
            r10 = -1
            r16 = 0
            r0 = r30
            r1 = -1
            r2 = 0
        L_0x0017:
            if (r0 >= r13) goto L_0x0254
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x0029
            int r0 = com.google.android.gms.internal.measurement.zzdl.zza(r0, r12, r3, r11)
            int r3 = r11.zzada
            r8 = r0
            r17 = r3
            goto L_0x002c
        L_0x0029:
            r17 = r0
            r8 = r3
        L_0x002c:
            int r7 = r17 >>> 3
            r6 = r17 & 7
            if (r7 <= r1) goto L_0x0039
            int r2 = r2 / 3
            int r0 = r15.zzp(r7, r2)
            goto L_0x003d
        L_0x0039:
            int r0 = r15.zzcd(r7)
        L_0x003d:
            r4 = r0
            if (r4 != r10) goto L_0x004b
            r24 = r7
            r2 = r8
            r18 = r9
            r19 = 0
            r26 = -1
            goto L_0x0231
        L_0x004b:
            int[] r0 = r15.zzakj
            int r1 = r4 + 1
            r5 = r0[r1]
            r0 = 267386880(0xff00000, float:2.3665827E-29)
            r0 = r0 & r5
            int r3 = r0 >>> 20
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            long r1 = (long) r0
            r0 = 17
            r10 = 2
            if (r3 > r0) goto L_0x0167
            r0 = 1
            switch(r3) {
                case 0: goto L_0x014e;
                case 1: goto L_0x013f;
                case 2: goto L_0x012d;
                case 3: goto L_0x012d;
                case 4: goto L_0x011f;
                case 5: goto L_0x010f;
                case 6: goto L_0x00fe;
                case 7: goto L_0x00e8;
                case 8: goto L_0x00d1;
                case 9: goto L_0x00b0;
                case 10: goto L_0x00a3;
                case 11: goto L_0x011f;
                case 12: goto L_0x0094;
                case 13: goto L_0x00fe;
                case 14: goto L_0x010f;
                case 15: goto L_0x0081;
                case 16: goto L_0x0066;
                default: goto L_0x0064;
            }
        L_0x0064:
            goto L_0x01a4
        L_0x0066:
            if (r6 != 0) goto L_0x01a4
            int r6 = com.google.android.gms.internal.measurement.zzdl.zzb(r12, r8, r11)
            r19 = r1
            long r0 = r11.zzadb
            long r21 = com.google.android.gms.internal.measurement.zzeb.zzbm(r0)
            r0 = r9
            r2 = r19
            r1 = r28
            r10 = r4
            r4 = r21
            r0.putLong(r1, r2, r4)
            goto L_0x013d
        L_0x0081:
            r2 = r1
            r10 = r4
            if (r6 != 0) goto L_0x015f
            int r0 = com.google.android.gms.internal.measurement.zzdl.zza(r12, r8, r11)
            int r1 = r11.zzada
            int r1 = com.google.android.gms.internal.measurement.zzeb.zzaz(r1)
            r9.putInt(r14, r2, r1)
            goto L_0x015b
        L_0x0094:
            r2 = r1
            r10 = r4
            if (r6 != 0) goto L_0x015f
            int r0 = com.google.android.gms.internal.measurement.zzdl.zza(r12, r8, r11)
            int r1 = r11.zzada
            r9.putInt(r14, r2, r1)
            goto L_0x015b
        L_0x00a3:
            r2 = r1
            if (r6 != r10) goto L_0x01a4
            int r0 = com.google.android.gms.internal.measurement.zzdl.zze(r12, r8, r11)
            java.lang.Object r1 = r11.zzadc
            r9.putObject(r14, r2, r1)
            goto L_0x010b
        L_0x00b0:
            r2 = r1
            if (r6 != r10) goto L_0x01a4
            com.google.android.gms.internal.measurement.zzgx r0 = r15.zzbx(r4)
            int r0 = com.google.android.gms.internal.measurement.zzdl.zza(r0, r12, r8, r13, r11)
            java.lang.Object r1 = r9.getObject(r14, r2)
            if (r1 != 0) goto L_0x00c7
            java.lang.Object r1 = r11.zzadc
            r9.putObject(r14, r2, r1)
            goto L_0x010b
        L_0x00c7:
            java.lang.Object r5 = r11.zzadc
            java.lang.Object r1 = com.google.android.gms.internal.measurement.zzez.zza(r1, r5)
            r9.putObject(r14, r2, r1)
            goto L_0x010b
        L_0x00d1:
            r2 = r1
            if (r6 != r10) goto L_0x01a4
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r0 & r5
            if (r0 != 0) goto L_0x00de
            int r0 = com.google.android.gms.internal.measurement.zzdl.zzc(r12, r8, r11)
            goto L_0x00e2
        L_0x00de:
            int r0 = com.google.android.gms.internal.measurement.zzdl.zzd(r12, r8, r11)
        L_0x00e2:
            java.lang.Object r1 = r11.zzadc
            r9.putObject(r14, r2, r1)
            goto L_0x010b
        L_0x00e8:
            r2 = r1
            if (r6 != 0) goto L_0x01a4
            int r1 = com.google.android.gms.internal.measurement.zzdl.zzb(r12, r8, r11)
            long r5 = r11.zzadb
            r19 = 0
            int r8 = (r5 > r19 ? 1 : (r5 == r19 ? 0 : -1))
            if (r8 == 0) goto L_0x00f8
            goto L_0x00f9
        L_0x00f8:
            r0 = 0
        L_0x00f9:
            com.google.android.gms.internal.measurement.zzhv.zza(r14, r2, r0)
            r0 = r1
            goto L_0x010b
        L_0x00fe:
            r2 = r1
            r0 = 5
            if (r6 != r0) goto L_0x01a4
            int r0 = com.google.android.gms.internal.measurement.zzdl.zza(r12, r8)
            r9.putInt(r14, r2, r0)
            int r0 = r8 + 4
        L_0x010b:
            r2 = r4
            r1 = r7
            goto L_0x0251
        L_0x010f:
            r2 = r1
            if (r6 != r0) goto L_0x01a4
            long r5 = com.google.android.gms.internal.measurement.zzdl.zzb(r12, r8)
            r0 = r9
            r1 = r28
            r10 = r4
            r4 = r5
            r0.putLong(r1, r2, r4)
            goto L_0x0159
        L_0x011f:
            r2 = r1
            r10 = r4
            if (r6 != 0) goto L_0x015f
            int r0 = com.google.android.gms.internal.measurement.zzdl.zza(r12, r8, r11)
            int r1 = r11.zzada
            r9.putInt(r14, r2, r1)
            goto L_0x015b
        L_0x012d:
            r2 = r1
            r10 = r4
            if (r6 != 0) goto L_0x015f
            int r6 = com.google.android.gms.internal.measurement.zzdl.zzb(r12, r8, r11)
            long r4 = r11.zzadb
            r0 = r9
            r1 = r28
            r0.putLong(r1, r2, r4)
        L_0x013d:
            r0 = r6
            goto L_0x015b
        L_0x013f:
            r2 = r1
            r10 = r4
            r0 = 5
            if (r6 != r0) goto L_0x015f
            float r0 = com.google.android.gms.internal.measurement.zzdl.zzd(r12, r8)
            com.google.android.gms.internal.measurement.zzhv.zza(r14, r2, r0)
            int r0 = r8 + 4
            goto L_0x015b
        L_0x014e:
            r2 = r1
            r10 = r4
            if (r6 != r0) goto L_0x015f
            double r0 = com.google.android.gms.internal.measurement.zzdl.zzc(r12, r8)
            com.google.android.gms.internal.measurement.zzhv.zza(r14, r2, r0)
        L_0x0159:
            int r0 = r8 + 8
        L_0x015b:
            r1 = r7
            r2 = r10
            goto L_0x0251
        L_0x015f:
            r24 = r7
            r15 = r8
            r18 = r9
            r19 = r10
            goto L_0x01ab
        L_0x0167:
            r0 = 27
            if (r3 != r0) goto L_0x01af
            if (r6 != r10) goto L_0x01a4
            java.lang.Object r0 = r9.getObject(r14, r1)
            com.google.android.gms.internal.measurement.zzff r0 = (com.google.android.gms.internal.measurement.zzff) r0
            boolean r3 = r0.zzrx()
            if (r3 != 0) goto L_0x018b
            int r3 = r0.size()
            if (r3 != 0) goto L_0x0182
            r3 = 10
            goto L_0x0184
        L_0x0182:
            int r3 = r3 << 1
        L_0x0184:
            com.google.android.gms.internal.measurement.zzff r0 = r0.zzap(r3)
            r9.putObject(r14, r1, r0)
        L_0x018b:
            r5 = r0
            com.google.android.gms.internal.measurement.zzgx r0 = r15.zzbx(r4)
            r1 = r17
            r2 = r29
            r3 = r8
            r19 = r4
            r4 = r31
            r6 = r32
            int r0 = com.google.android.gms.internal.measurement.zzdl.zza(r0, r1, r2, r3, r4, r5, r6)
            r1 = r7
            r2 = r19
            goto L_0x0251
        L_0x01a4:
            r19 = r4
            r24 = r7
            r15 = r8
            r18 = r9
        L_0x01ab:
            r26 = -1
            goto L_0x0212
        L_0x01af:
            r19 = r4
            r0 = 49
            if (r3 > r0) goto L_0x01e5
            long r4 = (long) r5
            r0 = r27
            r20 = r1
            r1 = r28
            r2 = r29
            r10 = r3
            r3 = r8
            r22 = r4
            r4 = r31
            r5 = r17
            r30 = r6
            r6 = r7
            r24 = r7
            r7 = r30
            r15 = r8
            r8 = r19
            r18 = r9
            r25 = r10
            r26 = -1
            r9 = r22
            r11 = r25
            r12 = r20
            r14 = r32
            int r0 = r0.zza((T) r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r14)
            if (r0 != r15) goto L_0x0241
            goto L_0x0230
        L_0x01e5:
            r20 = r1
            r25 = r3
            r30 = r6
            r24 = r7
            r15 = r8
            r18 = r9
            r26 = -1
            r0 = 50
            r9 = r25
            if (r9 != r0) goto L_0x0214
            r7 = r30
            if (r7 != r10) goto L_0x0212
            r0 = r27
            r1 = r28
            r2 = r29
            r3 = r15
            r4 = r31
            r5 = r19
            r6 = r20
            r8 = r32
            int r0 = r0.zza((T) r1, r2, r3, r4, r5, r6, r8)
            if (r0 != r15) goto L_0x0241
            goto L_0x0230
        L_0x0212:
            r2 = r15
            goto L_0x0231
        L_0x0214:
            r7 = r30
            r0 = r27
            r1 = r28
            r2 = r29
            r3 = r15
            r4 = r31
            r8 = r5
            r5 = r17
            r6 = r24
            r10 = r20
            r12 = r19
            r13 = r32
            int r0 = r0.zza((T) r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13)
            if (r0 != r15) goto L_0x0241
        L_0x0230:
            r2 = r0
        L_0x0231:
            com.google.android.gms.internal.measurement.zzhs r4 = zzu(r28)
            r0 = r17
            r1 = r29
            r3 = r31
            r5 = r32
            int r0 = com.google.android.gms.internal.measurement.zzdl.zza(r0, r1, r2, r3, r4, r5)
        L_0x0241:
            r15 = r27
            r14 = r28
            r12 = r29
            r13 = r31
            r11 = r32
            r9 = r18
            r2 = r19
            r1 = r24
        L_0x0251:
            r10 = -1
            goto L_0x0017
        L_0x0254:
            r4 = r13
            if (r0 != r4) goto L_0x0258
            return
        L_0x0258:
            com.google.android.gms.internal.measurement.zzfi r0 = com.google.android.gms.internal.measurement.zzfi.zzva()
            throw r0
        L_0x025d:
            r4 = r13
            r5 = 0
            r0 = r27
            r1 = r28
            r2 = r29
            r3 = r30
            r4 = r31
            r6 = r32
            r0.zza((T) r1, r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzgm.zza(java.lang.Object, byte[], int, int, com.google.android.gms.internal.measurement.zzdk):void");
    }

    public final void zzj(T t) {
        int i;
        int i2 = this.zzakt;
        while (true) {
            i = this.zzaku;
            if (i2 >= i) {
                break;
            }
            long zzca = (long) (zzca(this.zzaks[i2]) & 1048575);
            Object zzp = zzhv.zzp(t, zzca);
            if (zzp != null) {
                zzhv.zza((Object) t, zzca, this.zzakz.zzp(zzp));
            }
            i2++;
        }
        int length = this.zzaks.length;
        while (i < length) {
            this.zzakw.zzb(t, (long) this.zzaks[i]);
            i++;
        }
        this.zzakx.zzj(t);
        if (this.zzako) {
            this.zzaky.zzj(t);
        }
    }

    private final <UT, UB> UB zza(Object obj, int i, UB ub, zzhp<UT, UB> zzhp) {
        int i2 = this.zzakj[i];
        Object zzp = zzhv.zzp(obj, (long) (zzca(i) & 1048575));
        if (zzp == null) {
            return ub;
        }
        zzfe zzbz = zzbz(i);
        if (zzbz == null) {
            return ub;
        }
        return zza(i, i2, this.zzakz.zzm(zzp), zzbz, ub, zzhp);
    }

    private final <K, V, UT, UB> UB zza(int i, int i2, Map<K, V> map, zzfe zzfe, UB ub, zzhp<UT, UB> zzhp) {
        zzfz zzr = this.zzakz.zzr(zzby(i));
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            if (!zzfe.zzg(((Integer) entry.getValue()).intValue())) {
                if (ub == null) {
                    ub = zzhp.zzwp();
                }
                zzdx zzas = zzdp.zzas(zzga.zza(zzr, entry.getKey(), entry.getValue()));
                try {
                    zzga.zza(zzas.zzsf(), zzr, entry.getKey(), entry.getValue());
                    zzhp.zza(ub, i2, zzas.zzse());
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return ub;
    }

    public final boolean zzv(T t) {
        int i;
        int i2 = 0;
        int i3 = -1;
        int i4 = 0;
        while (true) {
            boolean z = true;
            if (i2 >= this.zzakt) {
                return !this.zzako || this.zzaky.zzh(t).isInitialized();
            }
            int i5 = this.zzaks[i2];
            int i6 = this.zzakj[i5];
            int zzca = zzca(i5);
            if (!this.zzakq) {
                int i7 = this.zzakj[i5 + 2];
                int i8 = i7 & 1048575;
                i = 1 << (i7 >>> 20);
                if (i8 != i3) {
                    i4 = zzaki.getInt(t, (long) i8);
                    i3 = i8;
                }
            } else {
                i = 0;
            }
            if (((268435456 & zzca) != 0) && !zza(t, i5, i4, i)) {
                return false;
            }
            int i9 = (267386880 & zzca) >>> 20;
            if (i9 != 9 && i9 != 17) {
                if (i9 != 27) {
                    if (i9 == 60 || i9 == 68) {
                        if (zza(t, i6, i5) && !zza((Object) t, zzca, zzbx(i5))) {
                            return false;
                        }
                    } else if (i9 != 49) {
                        if (i9 != 50) {
                            continue;
                        } else {
                            Map zzn = this.zzakz.zzn(zzhv.zzp(t, (long) (zzca & 1048575)));
                            if (!zzn.isEmpty()) {
                                if (this.zzakz.zzr(zzby(i5)).zzakd.zzwz() == zzij.MESSAGE) {
                                    zzgx zzgx = null;
                                    Iterator it = zzn.values().iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        Object next = it.next();
                                        if (zzgx == null) {
                                            zzgx = zzgt.zzvy().zzf(next.getClass());
                                        }
                                        if (!zzgx.zzv(next)) {
                                            z = false;
                                            break;
                                        }
                                    }
                                }
                            }
                            if (!z) {
                                return false;
                            }
                        }
                    }
                }
                List list = (List) zzhv.zzp(t, (long) (zzca & 1048575));
                if (!list.isEmpty()) {
                    zzgx zzbx = zzbx(i5);
                    int i10 = 0;
                    while (true) {
                        if (i10 >= list.size()) {
                            break;
                        } else if (!zzbx.zzv(list.get(i10))) {
                            z = false;
                            break;
                        } else {
                            i10++;
                        }
                    }
                }
                if (!z) {
                    return false;
                }
            } else if (zza(t, i5, i4, i) && !zza((Object) t, zzca, zzbx(i5))) {
                return false;
            }
            i2++;
        }
    }

    private static boolean zza(Object obj, int i, zzgx zzgx) {
        return zzgx.zzv(zzhv.zzp(obj, (long) (i & 1048575)));
    }

    private static void zza(int i, Object obj, zzim zzim) throws IOException {
        if (obj instanceof String) {
            zzim.zzb(i, (String) obj);
        } else {
            zzim.zza(i, (zzdp) obj);
        }
    }

    private final void zza(Object obj, int i, zzgy zzgy) throws IOException {
        if (zzcc(i)) {
            zzhv.zza(obj, (long) (i & 1048575), (Object) zzgy.zzsn());
        } else if (this.zzakp) {
            zzhv.zza(obj, (long) (i & 1048575), (Object) zzgy.readString());
        } else {
            zzhv.zza(obj, (long) (i & 1048575), (Object) zzgy.zzso());
        }
    }

    private final int zzca(int i) {
        return this.zzakj[i + 1];
    }

    private final int zzcb(int i) {
        return this.zzakj[i + 2];
    }

    private static <T> double zzf(T t, long j) {
        return ((Double) zzhv.zzp(t, j)).doubleValue();
    }

    private static <T> float zzg(T t, long j) {
        return ((Float) zzhv.zzp(t, j)).floatValue();
    }

    private static <T> int zzh(T t, long j) {
        return ((Integer) zzhv.zzp(t, j)).intValue();
    }

    private static <T> long zzi(T t, long j) {
        return ((Long) zzhv.zzp(t, j)).longValue();
    }

    private static <T> boolean zzj(T t, long j) {
        return ((Boolean) zzhv.zzp(t, j)).booleanValue();
    }

    private final boolean zzc(T t, T t2, int i) {
        return zza(t, i) == zza(t2, i);
    }

    private final boolean zza(T t, int i, int i2, int i3) {
        if (this.zzakq) {
            return zza(t, i);
        }
        return (i2 & i3) != 0;
    }

    private final boolean zza(T t, int i) {
        if (this.zzakq) {
            int zzca = zzca(i);
            long j = (long) (zzca & 1048575);
            switch ((zzca & 267386880) >>> 20) {
                case 0:
                    return zzhv.zzo(t, j) != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                case 1:
                    return zzhv.zzn(t, j) != 0.0f;
                case 2:
                    return zzhv.zzl(t, j) != 0;
                case 3:
                    return zzhv.zzl(t, j) != 0;
                case 4:
                    return zzhv.zzk(t, j) != 0;
                case 5:
                    return zzhv.zzl(t, j) != 0;
                case 6:
                    return zzhv.zzk(t, j) != 0;
                case 7:
                    return zzhv.zzm(t, j);
                case 8:
                    Object zzp = zzhv.zzp(t, j);
                    if (zzp instanceof String) {
                        return !((String) zzp).isEmpty();
                    }
                    if (zzp instanceof zzdp) {
                        return !zzdp.zzadh.equals(zzp);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return zzhv.zzp(t, j) != null;
                case 10:
                    return !zzdp.zzadh.equals(zzhv.zzp(t, j));
                case 11:
                    return zzhv.zzk(t, j) != 0;
                case 12:
                    return zzhv.zzk(t, j) != 0;
                case 13:
                    return zzhv.zzk(t, j) != 0;
                case 14:
                    return zzhv.zzl(t, j) != 0;
                case 15:
                    return zzhv.zzk(t, j) != 0;
                case 16:
                    return zzhv.zzl(t, j) != 0;
                case 17:
                    return zzhv.zzp(t, j) != null;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            int zzcb = zzcb(i);
            return (zzhv.zzk(t, (long) (zzcb & 1048575)) & (1 << (zzcb >>> 20))) != 0;
        }
    }

    private final void zzb(T t, int i) {
        if (!this.zzakq) {
            int zzcb = zzcb(i);
            long j = (long) (zzcb & 1048575);
            zzhv.zzb((Object) t, j, zzhv.zzk(t, j) | (1 << (zzcb >>> 20)));
        }
    }

    private final boolean zza(T t, int i, int i2) {
        return zzhv.zzk(t, (long) (zzcb(i2) & 1048575)) == i;
    }

    private final void zzb(T t, int i, int i2) {
        zzhv.zzb((Object) t, (long) (zzcb(i2) & 1048575), i);
    }

    private final int zzcd(int i) {
        if (i < this.zzakl || i > this.zzakm) {
            return -1;
        }
        return zzq(i, 0);
    }

    private final int zzp(int i, int i2) {
        if (i < this.zzakl || i > this.zzakm) {
            return -1;
        }
        return zzq(i, i2);
    }

    private final int zzq(int i, int i2) {
        int length = (this.zzakj.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.zzakj[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }
}
