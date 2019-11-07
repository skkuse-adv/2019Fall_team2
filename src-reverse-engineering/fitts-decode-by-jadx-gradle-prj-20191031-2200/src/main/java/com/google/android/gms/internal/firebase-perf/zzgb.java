package com.google.android.gms.internal.firebase-perf;

import com.google.android.gms.internal.firebase-perf.zzep.zzd;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

final class zzgb<T> implements zzgo<T> {
    private static final int[] zzsz = new int[0];
    private static final Unsafe zzta = zzhm.zzjj();
    private final int[] zztb;
    private final Object[] zztc;
    private final boolean zztg;
    private final boolean zzti;
    private final boolean zztj;
    private final int[] zztk;
    private final int zztl;
    private final int zztm;
    private final zzfh zzto;
    private final zzhg<?, ?> zztp;
    private final zzeg<?> zztq;
    private final zzfu zztr;

    private zzgb(int[] iArr, Object[] objArr, int i, int i2, zzfx zzfx, boolean z, boolean z2, int[] iArr2, int i3, int i4, zzgg zzgg, zzfh zzfh, zzhg<?, ?> zzhg, zzeg<?> zzeg, zzfu zzfu) {
        this.zztb = iArr;
        this.zztc = objArr;
        boolean z3 = zzfx instanceof zzep;
        this.zzti = z;
        this.zztg = zzeg != null && zzeg.zze(zzfx);
        this.zztj = false;
        this.zztk = iArr2;
        this.zztl = i3;
        this.zztm = i4;
        this.zzto = zzfh;
        this.zztp = zzhg;
        this.zztq = zzeg;
        this.zztr = zzfu;
    }

    static <T> zzgb<T> zza(Class<T> cls, zzfv zzfv, zzgg zzgg, zzfh zzfh, zzhg<?, ?> zzhg, zzeg<?> zzeg, zzfu zzfu) {
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
        zzfv zzfv2 = zzfv;
        if (zzfv2 instanceof zzgl) {
            zzgl zzgl = (zzgl) zzfv2;
            char c3 = 0;
            boolean z = zzgl.zzie() == zzd.zzre;
            String zzip = zzgl.zzip();
            int length = zzip.length();
            char charAt15 = zzip.charAt(0);
            if (charAt15 >= 55296) {
                char c4 = charAt15 & 8191;
                int i33 = 1;
                int i34 = 13;
                while (true) {
                    i = i33 + 1;
                    charAt14 = zzip.charAt(i33);
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
            char charAt16 = zzip.charAt(i);
            if (charAt16 >= 55296) {
                char c5 = charAt16 & 8191;
                int i36 = 13;
                while (true) {
                    i2 = i35 + 1;
                    charAt13 = zzip.charAt(i35);
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
                iArr = zzsz;
                c = 0;
                i7 = 0;
                i6 = 0;
                i5 = 0;
                i4 = 0;
                i3 = 0;
            } else {
                int i37 = i2 + 1;
                int charAt17 = zzip.charAt(i2);
                if (charAt17 >= 55296) {
                    int i38 = charAt17 & 8191;
                    int i39 = 13;
                    while (true) {
                        i24 = i37 + 1;
                        charAt12 = zzip.charAt(i37);
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
                char charAt18 = zzip.charAt(i24);
                if (charAt18 >= 55296) {
                    char c6 = charAt18 & 8191;
                    int i41 = 13;
                    while (true) {
                        i25 = i40 + 1;
                        charAt11 = zzip.charAt(i40);
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
                int charAt19 = zzip.charAt(i25);
                if (charAt19 >= 55296) {
                    int i43 = charAt19 & 8191;
                    int i44 = 13;
                    while (true) {
                        i26 = i42 + 1;
                        charAt10 = zzip.charAt(i42);
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
                i5 = zzip.charAt(i26);
                if (i5 >= 55296) {
                    int i46 = i5 & 8191;
                    int i47 = 13;
                    while (true) {
                        i27 = i45 + 1;
                        charAt9 = zzip.charAt(i45);
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
                i4 = zzip.charAt(i27);
                if (i4 >= 55296) {
                    int i49 = i4 & 8191;
                    int i50 = 13;
                    while (true) {
                        i32 = i48 + 1;
                        charAt8 = zzip.charAt(i48);
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
                c = zzip.charAt(i48);
                if (c >= 55296) {
                    char c7 = c & 8191;
                    int i52 = 13;
                    while (true) {
                        i31 = i51 + 1;
                        charAt7 = zzip.charAt(i51);
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
                char charAt20 = zzip.charAt(i51);
                if (charAt20 >= 55296) {
                    int i54 = 13;
                    int i55 = i53;
                    int i56 = charAt20 & 8191;
                    int i57 = i55;
                    while (true) {
                        i30 = i57 + 1;
                        charAt6 = zzip.charAt(i57);
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
                c3 = zzip.charAt(i28);
                if (c3 >= 55296) {
                    int i59 = 13;
                    int i60 = i58;
                    int i61 = c3 & 8191;
                    int i62 = i60;
                    while (true) {
                        i29 = i62 + 1;
                        charAt5 = zzip.charAt(i62);
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
            Unsafe unsafe = zzta;
            Object[] zziq = zzgl.zziq();
            Class cls3 = zzgl.zzig().getClass();
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
                int charAt21 = zzip.charAt(i2);
                char c8 = 55296;
                if (charAt21 >= 55296) {
                    int i71 = 13;
                    int i72 = i70;
                    int i73 = charAt21 & 8191;
                    int i74 = i72;
                    while (true) {
                        i23 = i74 + 1;
                        charAt4 = zzip.charAt(i74);
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
                char charAt22 = zzip.charAt(i8);
                int i76 = length;
                char c9 = 55296;
                if (charAt22 >= 55296) {
                    int i77 = 13;
                    int i78 = i75;
                    int i79 = charAt22 & 8191;
                    int i80 = i78;
                    while (true) {
                        i22 = i80 + 1;
                        charAt3 = zzip.charAt(i80);
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
                    char charAt23 = zzip.charAt(i9);
                    char c11 = 55296;
                    if (charAt23 >= 55296) {
                        char c12 = charAt23 & 8191;
                        int i85 = 13;
                        while (true) {
                            i21 = i84 + 1;
                            charAt2 = zzip.charAt(i84);
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
                        objArr[((i69 / 3) << 1) + 1] = zziq[i64];
                        i64 = i88;
                    } else {
                        if (i86 == 12 && (charAt15 & 1) == 1) {
                            int i89 = i64 + 1;
                            objArr[((i69 / 3) << 1) + 1] = zziq[i64];
                            i64 = i89;
                        }
                        c2 = 1;
                    }
                    int i90 = charAt23 << c2;
                    Object obj = zziq[i90];
                    if (obj instanceof Field) {
                        field2 = (Field) obj;
                    } else {
                        field2 = zza(cls3, (String) obj);
                        zziq[i90] = field2;
                    }
                    int i91 = i7;
                    int objectFieldOffset = (int) unsafe.objectFieldOffset(field2);
                    int i92 = i90 + 1;
                    Object obj2 = zziq[i92];
                    int i93 = objectFieldOffset;
                    if (obj2 instanceof Field) {
                        field3 = (Field) obj2;
                    } else {
                        field3 = zza(cls3, (String) obj2);
                        zziq[i92] = field3;
                    }
                    str = zzip;
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
                    Field zza = zza(cls3, (String) zziq[i64]);
                    i12 = i5;
                    if (c10 == 9 || c10 == 17) {
                        i10 = i94;
                        objArr[((i69 / 3) << 1) + 1] = zza.getType();
                    } else {
                        if (c10 == 27 || c10 == '1') {
                            i10 = i94;
                            i20 = i95 + 1;
                            objArr[((i69 / 3) << 1) + 1] = zziq[i95];
                        } else if (c10 == 12 || c10 == 30 || c10 == ',') {
                            i10 = i94;
                            if ((charAt15 & 1) == 1) {
                                i20 = i95 + 1;
                                objArr[((i69 / 3) << 1) + 1] = zziq[i95];
                            }
                        } else if (c10 == '2') {
                            int i96 = i66 + 1;
                            iArr[i66] = i69;
                            int i97 = (i69 / 3) << 1;
                            int i98 = i95 + 1;
                            objArr[i97] = zziq[i95];
                            if ((charAt22 & 2048) != 0) {
                                i95 = i98 + 1;
                                objArr[i97 + 1] = zziq[i98];
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
                            str = zzip;
                            cls2 = cls3;
                            i11 = i95;
                            i17 = i9;
                            i16 = 0;
                            i15 = 0;
                        } else {
                            i17 = i9 + 1;
                            char charAt24 = zzip.charAt(i9);
                            if (charAt24 >= 55296) {
                                char c13 = charAt24 & 8191;
                                int i99 = 13;
                                while (true) {
                                    i19 = i17 + 1;
                                    charAt = zzip.charAt(i17);
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
                            Object obj3 = zziq[i100];
                            str = zzip;
                            if (obj3 instanceof Field) {
                                field = (Field) obj3;
                            } else {
                                field = zza(cls3, (String) obj3);
                                zziq[i100] = field;
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
                    str = zzip;
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
                zzip = str;
            }
            boolean z3 = z;
            zzgb zzgb = new zzgb(iArr2, objArr, i7, i5, zzgl.zzig(), z, false, iArr, c3, i65, zzgg, zzfh, zzhg, zzeg, zzfu);
            return zzgb;
        }
        int zzie = ((zzgz) zzfv2).zzie();
        int i104 = zzd.zzre;
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

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x006a, code lost:
        if (com.google.android.gms.internal.firebase-perf.zzgq.zzf(com.google.android.gms.internal.firebase-perf.zzhm.zzo(r10, r6), com.google.android.gms.internal.firebase-perf.zzhm.zzo(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x007e, code lost:
        if (com.google.android.gms.internal.firebase-perf.zzhm.zzk(r10, r6) == com.google.android.gms.internal.firebase-perf.zzhm.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0090, code lost:
        if (com.google.android.gms.internal.firebase-perf.zzhm.zzj(r10, r6) == com.google.android.gms.internal.firebase-perf.zzhm.zzj(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a4, code lost:
        if (com.google.android.gms.internal.firebase-perf.zzhm.zzk(r10, r6) == com.google.android.gms.internal.firebase-perf.zzhm.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00b6, code lost:
        if (com.google.android.gms.internal.firebase-perf.zzhm.zzj(r10, r6) == com.google.android.gms.internal.firebase-perf.zzhm.zzj(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00c8, code lost:
        if (com.google.android.gms.internal.firebase-perf.zzhm.zzj(r10, r6) == com.google.android.gms.internal.firebase-perf.zzhm.zzj(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00da, code lost:
        if (com.google.android.gms.internal.firebase-perf.zzhm.zzj(r10, r6) == com.google.android.gms.internal.firebase-perf.zzhm.zzj(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00f0, code lost:
        if (com.google.android.gms.internal.firebase-perf.zzgq.zzf(com.google.android.gms.internal.firebase-perf.zzhm.zzo(r10, r6), com.google.android.gms.internal.firebase-perf.zzhm.zzo(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0106, code lost:
        if (com.google.android.gms.internal.firebase-perf.zzgq.zzf(com.google.android.gms.internal.firebase-perf.zzhm.zzo(r10, r6), com.google.android.gms.internal.firebase-perf.zzhm.zzo(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x011c, code lost:
        if (com.google.android.gms.internal.firebase-perf.zzgq.zzf(com.google.android.gms.internal.firebase-perf.zzhm.zzo(r10, r6), com.google.android.gms.internal.firebase-perf.zzhm.zzo(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x012e, code lost:
        if (com.google.android.gms.internal.firebase-perf.zzhm.zzl(r10, r6) == com.google.android.gms.internal.firebase-perf.zzhm.zzl(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0140, code lost:
        if (com.google.android.gms.internal.firebase-perf.zzhm.zzj(r10, r6) == com.google.android.gms.internal.firebase-perf.zzhm.zzj(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0154, code lost:
        if (com.google.android.gms.internal.firebase-perf.zzhm.zzk(r10, r6) == com.google.android.gms.internal.firebase-perf.zzhm.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0165, code lost:
        if (com.google.android.gms.internal.firebase-perf.zzhm.zzj(r10, r6) == com.google.android.gms.internal.firebase-perf.zzhm.zzj(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0178, code lost:
        if (com.google.android.gms.internal.firebase-perf.zzhm.zzk(r10, r6) == com.google.android.gms.internal.firebase-perf.zzhm.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x018b, code lost:
        if (com.google.android.gms.internal.firebase-perf.zzhm.zzk(r10, r6) == com.google.android.gms.internal.firebase-perf.zzhm.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01a4, code lost:
        if (java.lang.Float.floatToIntBits(com.google.android.gms.internal.firebase-perf.zzhm.zzm(r10, r6)) == java.lang.Float.floatToIntBits(com.google.android.gms.internal.firebase-perf.zzhm.zzm(r11, r6))) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01bf, code lost:
        if (java.lang.Double.doubleToLongBits(com.google.android.gms.internal.firebase-perf.zzhm.zzn(r10, r6)) == java.lang.Double.doubleToLongBits(com.google.android.gms.internal.firebase-perf.zzhm.zzn(r11, r6))) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01c1, code lost:
        r3 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0038, code lost:
        if (com.google.android.gms.internal.firebase-perf.zzgq.zzf(com.google.android.gms.internal.firebase-perf.zzhm.zzo(r10, r6), com.google.android.gms.internal.firebase-perf.zzhm.zzo(r11, r6)) != false) goto L_0x01c2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(T r10, T r11) {
        /*
            r9 = this;
            int[] r0 = r9.zztb
            int r0 = r0.length
            r1 = 0
            r2 = 0
        L_0x0005:
            r3 = 1
            if (r2 >= r0) goto L_0x01c9
            int r4 = r9.zzar(r2)
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
            int r4 = r9.zzas(r2)
            r4 = r4 & r5
            long r4 = (long) r4
            int r8 = com.google.android.gms.internal.firebase-perf.zzhm.zzj(r10, r4)
            int r4 = com.google.android.gms.internal.firebase-perf.zzhm.zzj(r11, r4)
            if (r8 != r4) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r11, r6)
            boolean r4 = com.google.android.gms.internal.firebase-perf.zzgq.zzf(r4, r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x003c:
            java.lang.Object r3 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r10, r6)
            java.lang.Object r4 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r11, r6)
            boolean r3 = com.google.android.gms.internal.firebase-perf.zzgq.zzf(r3, r4)
            goto L_0x01c2
        L_0x004a:
            java.lang.Object r3 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r10, r6)
            java.lang.Object r4 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r11, r6)
            boolean r3 = com.google.android.gms.internal.firebase-perf.zzgq.zzf(r3, r4)
            goto L_0x01c2
        L_0x0058:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r11, r6)
            boolean r4 = com.google.android.gms.internal.firebase-perf.zzgq.zzf(r4, r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x006e:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.firebase-perf.zzhm.zzk(r10, r6)
            long r6 = com.google.android.gms.internal.firebase-perf.zzhm.zzk(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x0082:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.firebase-perf.zzhm.zzj(r10, r6)
            int r5 = com.google.android.gms.internal.firebase-perf.zzhm.zzj(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0094:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.firebase-perf.zzhm.zzk(r10, r6)
            long r6 = com.google.android.gms.internal.firebase-perf.zzhm.zzk(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x00a8:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.firebase-perf.zzhm.zzj(r10, r6)
            int r5 = com.google.android.gms.internal.firebase-perf.zzhm.zzj(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x00ba:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.firebase-perf.zzhm.zzj(r10, r6)
            int r5 = com.google.android.gms.internal.firebase-perf.zzhm.zzj(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x00cc:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.firebase-perf.zzhm.zzj(r10, r6)
            int r5 = com.google.android.gms.internal.firebase-perf.zzhm.zzj(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x00de:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r11, r6)
            boolean r4 = com.google.android.gms.internal.firebase-perf.zzgq.zzf(r4, r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x00f4:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r11, r6)
            boolean r4 = com.google.android.gms.internal.firebase-perf.zzgq.zzf(r4, r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x010a:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r11, r6)
            boolean r4 = com.google.android.gms.internal.firebase-perf.zzgq.zzf(r4, r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x0120:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            boolean r4 = com.google.android.gms.internal.firebase-perf.zzhm.zzl(r10, r6)
            boolean r5 = com.google.android.gms.internal.firebase-perf.zzhm.zzl(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0132:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.firebase-perf.zzhm.zzj(r10, r6)
            int r5 = com.google.android.gms.internal.firebase-perf.zzhm.zzj(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0144:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.firebase-perf.zzhm.zzk(r10, r6)
            long r6 = com.google.android.gms.internal.firebase-perf.zzhm.zzk(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x0157:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.firebase-perf.zzhm.zzj(r10, r6)
            int r5 = com.google.android.gms.internal.firebase-perf.zzhm.zzj(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0168:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.firebase-perf.zzhm.zzk(r10, r6)
            long r6 = com.google.android.gms.internal.firebase-perf.zzhm.zzk(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x017b:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.firebase-perf.zzhm.zzk(r10, r6)
            long r6 = com.google.android.gms.internal.firebase-perf.zzhm.zzk(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x018e:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            float r4 = com.google.android.gms.internal.firebase-perf.zzhm.zzm(r10, r6)
            int r4 = java.lang.Float.floatToIntBits(r4)
            float r5 = com.google.android.gms.internal.firebase-perf.zzhm.zzm(r11, r6)
            int r5 = java.lang.Float.floatToIntBits(r5)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x01a7:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            double r4 = com.google.android.gms.internal.firebase-perf.zzhm.zzn(r10, r6)
            long r4 = java.lang.Double.doubleToLongBits(r4)
            double r6 = com.google.android.gms.internal.firebase-perf.zzhm.zzn(r11, r6)
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
            com.google.android.gms.internal.firebase-perf.zzhg<?, ?> r0 = r9.zztp
            java.lang.Object r0 = r0.zzo(r10)
            com.google.android.gms.internal.firebase-perf.zzhg<?, ?> r2 = r9.zztp
            java.lang.Object r2 = r2.zzo(r11)
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x01dc
            return r1
        L_0x01dc:
            boolean r0 = r9.zztg
            if (r0 == 0) goto L_0x01f1
            com.google.android.gms.internal.firebase-perf.zzeg<?> r0 = r9.zztq
            com.google.android.gms.internal.firebase-perf.zzeh r10 = r0.zzc(r10)
            com.google.android.gms.internal.firebase-perf.zzeg<?> r0 = r9.zztq
            com.google.android.gms.internal.firebase-perf.zzeh r11 = r0.zzc(r11)
            boolean r10 = r10.equals(r11)
            return r10
        L_0x01f1:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase-perf.zzgb.equals(java.lang.Object, java.lang.Object):boolean");
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
            int[] r0 = r8.zztb
            int r0 = r0.length
            r1 = 0
            r2 = 0
        L_0x0005:
            if (r1 >= r0) goto L_0x022c
            int r3 = r8.zzar(r1)
            int[] r4 = r8.zztb
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
            java.lang.Object r3 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r9, r5)
            int r2 = r2 * 53
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x0032:
            boolean r3 = r8.zza((T) r9, r4, r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            long r3 = zzh(r9, r5)
            int r3 = com.google.android.gms.internal.firebase-perf.zzes.zzav(r3)
            goto L_0x0227
        L_0x0044:
            boolean r3 = r8.zza((T) r9, r4, r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = zzg(r9, r5)
            goto L_0x0227
        L_0x0052:
            boolean r3 = r8.zza((T) r9, r4, r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            long r3 = zzh(r9, r5)
            int r3 = com.google.android.gms.internal.firebase-perf.zzes.zzav(r3)
            goto L_0x0227
        L_0x0064:
            boolean r3 = r8.zza((T) r9, r4, r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = zzg(r9, r5)
            goto L_0x0227
        L_0x0072:
            boolean r3 = r8.zza((T) r9, r4, r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = zzg(r9, r5)
            goto L_0x0227
        L_0x0080:
            boolean r3 = r8.zza((T) r9, r4, r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = zzg(r9, r5)
            goto L_0x0227
        L_0x008e:
            boolean r3 = r8.zza((T) r9, r4, r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x00a0:
            boolean r3 = r8.zza((T) r9, r4, r1)
            if (r3 == 0) goto L_0x0228
            java.lang.Object r3 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r9, r5)
            int r2 = r2 * 53
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x00b2:
            boolean r3 = r8.zza((T) r9, r4, r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x00c6:
            boolean r3 = r8.zza((T) r9, r4, r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            boolean r3 = zzi(r9, r5)
            int r3 = com.google.android.gms.internal.firebase-perf.zzes.zzf(r3)
            goto L_0x0227
        L_0x00d8:
            boolean r3 = r8.zza((T) r9, r4, r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = zzg(r9, r5)
            goto L_0x0227
        L_0x00e6:
            boolean r3 = r8.zza((T) r9, r4, r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            long r3 = zzh(r9, r5)
            int r3 = com.google.android.gms.internal.firebase-perf.zzes.zzav(r3)
            goto L_0x0227
        L_0x00f8:
            boolean r3 = r8.zza((T) r9, r4, r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = zzg(r9, r5)
            goto L_0x0227
        L_0x0106:
            boolean r3 = r8.zza((T) r9, r4, r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            long r3 = zzh(r9, r5)
            int r3 = com.google.android.gms.internal.firebase-perf.zzes.zzav(r3)
            goto L_0x0227
        L_0x0118:
            boolean r3 = r8.zza((T) r9, r4, r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            long r3 = zzh(r9, r5)
            int r3 = com.google.android.gms.internal.firebase-perf.zzes.zzav(r3)
            goto L_0x0227
        L_0x012a:
            boolean r3 = r8.zza((T) r9, r4, r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            float r3 = zzf(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0227
        L_0x013c:
            boolean r3 = r8.zza((T) r9, r4, r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            double r3 = zze((T) r9, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.android.gms.internal.firebase-perf.zzes.zzav(r3)
            goto L_0x0227
        L_0x0152:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x015e:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x016a:
            java.lang.Object r3 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r9, r5)
            if (r3 == 0) goto L_0x01c3
            int r7 = r3.hashCode()
            goto L_0x01c3
        L_0x0175:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.firebase-perf.zzhm.zzk(r9, r5)
            int r3 = com.google.android.gms.internal.firebase-perf.zzes.zzav(r3)
            goto L_0x0227
        L_0x0181:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.firebase-perf.zzhm.zzj(r9, r5)
            goto L_0x0227
        L_0x0189:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.firebase-perf.zzhm.zzk(r9, r5)
            int r3 = com.google.android.gms.internal.firebase-perf.zzes.zzav(r3)
            goto L_0x0227
        L_0x0195:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.firebase-perf.zzhm.zzj(r9, r5)
            goto L_0x0227
        L_0x019d:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.firebase-perf.zzhm.zzj(r9, r5)
            goto L_0x0227
        L_0x01a5:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.firebase-perf.zzhm.zzj(r9, r5)
            goto L_0x0227
        L_0x01ad:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x01b9:
            java.lang.Object r3 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r9, r5)
            if (r3 == 0) goto L_0x01c3
            int r7 = r3.hashCode()
        L_0x01c3:
            int r2 = r2 * 53
            int r2 = r2 + r7
            goto L_0x0228
        L_0x01c7:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x01d4:
            int r2 = r2 * 53
            boolean r3 = com.google.android.gms.internal.firebase-perf.zzhm.zzl(r9, r5)
            int r3 = com.google.android.gms.internal.firebase-perf.zzes.zzf(r3)
            goto L_0x0227
        L_0x01df:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.firebase-perf.zzhm.zzj(r9, r5)
            goto L_0x0227
        L_0x01e6:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.firebase-perf.zzhm.zzk(r9, r5)
            int r3 = com.google.android.gms.internal.firebase-perf.zzes.zzav(r3)
            goto L_0x0227
        L_0x01f1:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.firebase-perf.zzhm.zzj(r9, r5)
            goto L_0x0227
        L_0x01f8:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.firebase-perf.zzhm.zzk(r9, r5)
            int r3 = com.google.android.gms.internal.firebase-perf.zzes.zzav(r3)
            goto L_0x0227
        L_0x0203:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.firebase-perf.zzhm.zzk(r9, r5)
            int r3 = com.google.android.gms.internal.firebase-perf.zzes.zzav(r3)
            goto L_0x0227
        L_0x020e:
            int r2 = r2 * 53
            float r3 = com.google.android.gms.internal.firebase-perf.zzhm.zzm(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0227
        L_0x0219:
            int r2 = r2 * 53
            double r3 = com.google.android.gms.internal.firebase-perf.zzhm.zzn(r9, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.android.gms.internal.firebase-perf.zzes.zzav(r3)
        L_0x0227:
            int r2 = r2 + r3
        L_0x0228:
            int r1 = r1 + 3
            goto L_0x0005
        L_0x022c:
            int r2 = r2 * 53
            com.google.android.gms.internal.firebase-perf.zzhg<?, ?> r0 = r8.zztp
            java.lang.Object r0 = r0.zzo(r9)
            int r0 = r0.hashCode()
            int r2 = r2 + r0
            boolean r0 = r8.zztg
            if (r0 == 0) goto L_0x024a
            int r2 = r2 * 53
            com.google.android.gms.internal.firebase-perf.zzeg<?> r0 = r8.zztq
            com.google.android.gms.internal.firebase-perf.zzeh r9 = r0.zzc(r9)
            int r9 = r9.hashCode()
            int r2 = r2 + r9
        L_0x024a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase-perf.zzgb.hashCode(java.lang.Object):int");
    }

    public final void zze(T t, T t2) {
        if (t2 != null) {
            for (int i = 0; i < this.zztb.length; i += 3) {
                int zzar = zzar(i);
                long j = (long) (1048575 & zzar);
                int i2 = this.zztb[i];
                switch ((zzar & 267386880) >>> 20) {
                    case 0:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzhm.zza((Object) t, j, zzhm.zzn(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 1:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzhm.zza((Object) t, j, zzhm.zzm(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 2:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzhm.zza((Object) t, j, zzhm.zzk(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 3:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzhm.zza((Object) t, j, zzhm.zzk(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 4:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzhm.zza((Object) t, j, zzhm.zzj(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 5:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzhm.zza((Object) t, j, zzhm.zzk(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 6:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzhm.zza((Object) t, j, zzhm.zzj(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 7:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzhm.zza((Object) t, j, zzhm.zzl(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 8:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzhm.zza((Object) t, j, zzhm.zzo(t2, j));
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
                            zzhm.zza((Object) t, j, zzhm.zzo(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 11:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzhm.zza((Object) t, j, zzhm.zzj(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 12:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzhm.zza((Object) t, j, zzhm.zzj(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 13:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzhm.zza((Object) t, j, zzhm.zzj(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 14:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzhm.zza((Object) t, j, zzhm.zzk(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 15:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzhm.zza((Object) t, j, zzhm.zzj(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 16:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzhm.zza((Object) t, j, zzhm.zzk(t2, j));
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
                        this.zzto.zza(t, t2, j);
                        break;
                    case 50:
                        zzgq.zza(this.zztr, t, t2, j);
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
                            zzhm.zza((Object) t, j, zzhm.zzo(t2, j));
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
                            zzhm.zza((Object) t, j, zzhm.zzo(t2, j));
                            zzb(t, i2, i);
                            break;
                        }
                    case 68:
                        zzb(t, t2, i);
                        break;
                }
            }
            if (!this.zzti) {
                zzgq.zza(this.zztp, t, t2);
                if (this.zztg) {
                    zzgq.zza(this.zztq, t, t2);
                    return;
                }
                return;
            }
            return;
        }
        throw new NullPointerException();
    }

    private final void zza(T t, T t2, int i) {
        long zzar = (long) (zzar(i) & 1048575);
        if (zza(t2, i)) {
            Object zzo = zzhm.zzo(t, zzar);
            Object zzo2 = zzhm.zzo(t2, zzar);
            if (zzo == null || zzo2 == null) {
                if (zzo2 != null) {
                    zzhm.zza((Object) t, zzar, zzo2);
                    zzb(t, i);
                }
                return;
            }
            zzhm.zza((Object) t, zzar, zzes.zzc(zzo, zzo2));
            zzb(t, i);
        }
    }

    private final void zzb(T t, T t2, int i) {
        int zzar = zzar(i);
        int i2 = this.zztb[i];
        long j = (long) (zzar & 1048575);
        if (zza(t2, i2, i)) {
            Object zzo = zzhm.zzo(t, j);
            Object zzo2 = zzhm.zzo(t2, j);
            if (zzo == null || zzo2 == null) {
                if (zzo2 != null) {
                    zzhm.zza((Object) t, j, zzo2);
                    zzb(t, i2, i);
                }
                return;
            }
            zzhm.zza((Object) t, j, zzes.zzc(zzo, zzo2));
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
    public final int zzl(T r20) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            boolean r2 = r0.zzti
            r3 = 267386880(0xff00000, float:2.3665827E-29)
            r4 = 0
            r7 = 1048575(0xfffff, float:1.469367E-39)
            r8 = 1
            r9 = 0
            r11 = 0
            if (r2 == 0) goto L_0x04f2
            sun.misc.Unsafe r2 = zzta
            r12 = 0
            r13 = 0
        L_0x0016:
            int[] r14 = r0.zztb
            int r14 = r14.length
            if (r12 >= r14) goto L_0x04ea
            int r14 = r0.zzar(r12)
            r15 = r14 & r3
            int r15 = r15 >>> 20
            int[] r3 = r0.zztb
            r3 = r3[r12]
            r14 = r14 & r7
            long r5 = (long) r14
            com.google.android.gms.internal.firebase-perf.zzem r14 = com.google.android.gms.internal.firebase-perf.zzem.DOUBLE_LIST_PACKED
            int r14 = r14.id()
            if (r15 < r14) goto L_0x0041
            com.google.android.gms.internal.firebase-perf.zzem r14 = com.google.android.gms.internal.firebase-perf.zzem.SINT64_LIST_PACKED
            int r14 = r14.id()
            if (r15 > r14) goto L_0x0041
            int[] r14 = r0.zztb
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
            java.lang.Object r5 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r1, r5)
            com.google.android.gms.internal.firebase-perf.zzfx r5 = (com.google.android.gms.internal.firebase-perf.zzfx) r5
            com.google.android.gms.internal.firebase-perf.zzgo r6 = r0.zzap(r12)
            int r3 = com.google.android.gms.internal.firebase-perf.zzec.zzc(r3, r5, r6)
            goto L_0x03c9
        L_0x005d:
            boolean r14 = r0.zza((T) r1, r3, r12)
            if (r14 == 0) goto L_0x04e4
            long r5 = zzh(r1, r5)
            int r3 = com.google.android.gms.internal.firebase-perf.zzec.zzf(r3, r5)
            goto L_0x03c9
        L_0x006d:
            boolean r14 = r0.zza((T) r1, r3, r12)
            if (r14 == 0) goto L_0x04e4
            int r5 = zzg(r1, r5)
            int r3 = com.google.android.gms.internal.firebase-perf.zzec.zzm(r3, r5)
            goto L_0x03c9
        L_0x007d:
            boolean r5 = r0.zza((T) r1, r3, r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.firebase-perf.zzec.zzh(r3, r9)
            goto L_0x03c9
        L_0x0089:
            boolean r5 = r0.zza((T) r1, r3, r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.firebase-perf.zzec.zzo(r3, r11)
            goto L_0x03c9
        L_0x0095:
            boolean r14 = r0.zza((T) r1, r3, r12)
            if (r14 == 0) goto L_0x04e4
            int r5 = zzg(r1, r5)
            int r3 = com.google.android.gms.internal.firebase-perf.zzec.zzp(r3, r5)
            goto L_0x03c9
        L_0x00a5:
            boolean r14 = r0.zza((T) r1, r3, r12)
            if (r14 == 0) goto L_0x04e4
            int r5 = zzg(r1, r5)
            int r3 = com.google.android.gms.internal.firebase-perf.zzec.zzl(r3, r5)
            goto L_0x03c9
        L_0x00b5:
            boolean r14 = r0.zza((T) r1, r3, r12)
            if (r14 == 0) goto L_0x04e4
            java.lang.Object r5 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r1, r5)
            com.google.android.gms.internal.firebase-perf.zzdl r5 = (com.google.android.gms.internal.firebase-perf.zzdl) r5
            int r3 = com.google.android.gms.internal.firebase-perf.zzec.zzc(r3, r5)
            goto L_0x03c9
        L_0x00c7:
            boolean r14 = r0.zza((T) r1, r3, r12)
            if (r14 == 0) goto L_0x04e4
            java.lang.Object r5 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r1, r5)
            com.google.android.gms.internal.firebase-perf.zzgo r6 = r0.zzap(r12)
            int r3 = com.google.android.gms.internal.firebase-perf.zzgq.zzc(r3, r5, r6)
            goto L_0x03c9
        L_0x00db:
            boolean r14 = r0.zza((T) r1, r3, r12)
            if (r14 == 0) goto L_0x04e4
            java.lang.Object r5 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r1, r5)
            boolean r6 = r5 instanceof com.google.android.gms.internal.firebase-perf.zzdl
            if (r6 == 0) goto L_0x00f1
            com.google.android.gms.internal.firebase-perf.zzdl r5 = (com.google.android.gms.internal.firebase-perf.zzdl) r5
            int r3 = com.google.android.gms.internal.firebase-perf.zzec.zzc(r3, r5)
            goto L_0x03c9
        L_0x00f1:
            java.lang.String r5 = (java.lang.String) r5
            int r3 = com.google.android.gms.internal.firebase-perf.zzec.zzc(r3, r5)
            goto L_0x03c9
        L_0x00f9:
            boolean r5 = r0.zza((T) r1, r3, r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.firebase-perf.zzec.zzb(r3, r8)
            goto L_0x03c9
        L_0x0105:
            boolean r5 = r0.zza((T) r1, r3, r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.firebase-perf.zzec.zzn(r3, r11)
            goto L_0x03c9
        L_0x0111:
            boolean r5 = r0.zza((T) r1, r3, r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.firebase-perf.zzec.zzg(r3, r9)
            goto L_0x03c9
        L_0x011d:
            boolean r14 = r0.zza((T) r1, r3, r12)
            if (r14 == 0) goto L_0x04e4
            int r5 = zzg(r1, r5)
            int r3 = com.google.android.gms.internal.firebase-perf.zzec.zzk(r3, r5)
            goto L_0x03c9
        L_0x012d:
            boolean r14 = r0.zza((T) r1, r3, r12)
            if (r14 == 0) goto L_0x04e4
            long r5 = zzh(r1, r5)
            int r3 = com.google.android.gms.internal.firebase-perf.zzec.zze(r3, r5)
            goto L_0x03c9
        L_0x013d:
            boolean r14 = r0.zza((T) r1, r3, r12)
            if (r14 == 0) goto L_0x04e4
            long r5 = zzh(r1, r5)
            int r3 = com.google.android.gms.internal.firebase-perf.zzec.zzd(r3, r5)
            goto L_0x03c9
        L_0x014d:
            boolean r5 = r0.zza((T) r1, r3, r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.firebase-perf.zzec.zzb(r3, r4)
            goto L_0x03c9
        L_0x0159:
            boolean r5 = r0.zza((T) r1, r3, r12)
            if (r5 == 0) goto L_0x04e4
            r5 = 0
            int r3 = com.google.android.gms.internal.firebase-perf.zzec.zzb(r3, r5)
            goto L_0x03c9
        L_0x0167:
            com.google.android.gms.internal.firebase-perf.zzfu r14 = r0.zztr
            java.lang.Object r5 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r1, r5)
            java.lang.Object r6 = r0.zzaq(r12)
            int r3 = r14.zzc(r3, r5, r6)
            goto L_0x03c9
        L_0x0177:
            java.util.List r5 = zzd(r1, r5)
            com.google.android.gms.internal.firebase-perf.zzgo r6 = r0.zzap(r12)
            int r3 = com.google.android.gms.internal.firebase-perf.zzgq.zzd(r3, r5, r6)
            goto L_0x03c9
        L_0x0185:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.firebase-perf.zzgq.zzf(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zztj
            if (r6 == 0) goto L_0x0199
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x0199:
            int r3 = com.google.android.gms.internal.firebase-perf.zzec.zzy(r3)
            int r6 = com.google.android.gms.internal.firebase-perf.zzec.zzaa(r5)
            goto L_0x0324
        L_0x01a3:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.firebase-perf.zzgq.zzj(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zztj
            if (r6 == 0) goto L_0x01b7
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x01b7:
            int r3 = com.google.android.gms.internal.firebase-perf.zzec.zzy(r3)
            int r6 = com.google.android.gms.internal.firebase-perf.zzec.zzaa(r5)
            goto L_0x0324
        L_0x01c1:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.firebase-perf.zzgq.zzl(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zztj
            if (r6 == 0) goto L_0x01d5
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x01d5:
            int r3 = com.google.android.gms.internal.firebase-perf.zzec.zzy(r3)
            int r6 = com.google.android.gms.internal.firebase-perf.zzec.zzaa(r5)
            goto L_0x0324
        L_0x01df:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.firebase-perf.zzgq.zzk(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zztj
            if (r6 == 0) goto L_0x01f3
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x01f3:
            int r3 = com.google.android.gms.internal.firebase-perf.zzec.zzy(r3)
            int r6 = com.google.android.gms.internal.firebase-perf.zzec.zzaa(r5)
            goto L_0x0324
        L_0x01fd:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.firebase-perf.zzgq.zzg(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zztj
            if (r6 == 0) goto L_0x0211
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x0211:
            int r3 = com.google.android.gms.internal.firebase-perf.zzec.zzy(r3)
            int r6 = com.google.android.gms.internal.firebase-perf.zzec.zzaa(r5)
            goto L_0x0324
        L_0x021b:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.firebase-perf.zzgq.zzi(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zztj
            if (r6 == 0) goto L_0x022f
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x022f:
            int r3 = com.google.android.gms.internal.firebase-perf.zzec.zzy(r3)
            int r6 = com.google.android.gms.internal.firebase-perf.zzec.zzaa(r5)
            goto L_0x0324
        L_0x0239:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.firebase-perf.zzgq.zzm(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zztj
            if (r6 == 0) goto L_0x024d
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x024d:
            int r3 = com.google.android.gms.internal.firebase-perf.zzec.zzy(r3)
            int r6 = com.google.android.gms.internal.firebase-perf.zzec.zzaa(r5)
            goto L_0x0324
        L_0x0257:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.firebase-perf.zzgq.zzk(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zztj
            if (r6 == 0) goto L_0x026b
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x026b:
            int r3 = com.google.android.gms.internal.firebase-perf.zzec.zzy(r3)
            int r6 = com.google.android.gms.internal.firebase-perf.zzec.zzaa(r5)
            goto L_0x0324
        L_0x0275:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.firebase-perf.zzgq.zzl(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zztj
            if (r6 == 0) goto L_0x0289
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x0289:
            int r3 = com.google.android.gms.internal.firebase-perf.zzec.zzy(r3)
            int r6 = com.google.android.gms.internal.firebase-perf.zzec.zzaa(r5)
            goto L_0x0324
        L_0x0293:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.firebase-perf.zzgq.zzh(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zztj
            if (r6 == 0) goto L_0x02a7
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x02a7:
            int r3 = com.google.android.gms.internal.firebase-perf.zzec.zzy(r3)
            int r6 = com.google.android.gms.internal.firebase-perf.zzec.zzaa(r5)
            goto L_0x0324
        L_0x02b1:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.firebase-perf.zzgq.zze(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zztj
            if (r6 == 0) goto L_0x02c5
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x02c5:
            int r3 = com.google.android.gms.internal.firebase-perf.zzec.zzy(r3)
            int r6 = com.google.android.gms.internal.firebase-perf.zzec.zzaa(r5)
            goto L_0x0324
        L_0x02ce:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.firebase-perf.zzgq.zzd(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zztj
            if (r6 == 0) goto L_0x02e2
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x02e2:
            int r3 = com.google.android.gms.internal.firebase-perf.zzec.zzy(r3)
            int r6 = com.google.android.gms.internal.firebase-perf.zzec.zzaa(r5)
            goto L_0x0324
        L_0x02eb:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.firebase-perf.zzgq.zzk(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zztj
            if (r6 == 0) goto L_0x02ff
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x02ff:
            int r3 = com.google.android.gms.internal.firebase-perf.zzec.zzy(r3)
            int r6 = com.google.android.gms.internal.firebase-perf.zzec.zzaa(r5)
            goto L_0x0324
        L_0x0308:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.firebase-perf.zzgq.zzl(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zztj
            if (r6 == 0) goto L_0x031c
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x031c:
            int r3 = com.google.android.gms.internal.firebase-perf.zzec.zzy(r3)
            int r6 = com.google.android.gms.internal.firebase-perf.zzec.zzaa(r5)
        L_0x0324:
            int r3 = r3 + r6
            int r3 = r3 + r5
            goto L_0x03c9
        L_0x0328:
            java.util.List r5 = zzd(r1, r5)
            int r3 = com.google.android.gms.internal.firebase-perf.zzgq.zzq(r3, r5, r11)
            goto L_0x03c9
        L_0x0332:
            java.util.List r5 = zzd(r1, r5)
            int r3 = com.google.android.gms.internal.firebase-perf.zzgq.zzu(r3, r5, r11)
            goto L_0x03c9
        L_0x033c:
            java.util.List r5 = zzd(r1, r5)
            int r3 = com.google.android.gms.internal.firebase-perf.zzgq.zzw(r3, r5, r11)
            goto L_0x03c9
        L_0x0346:
            java.util.List r5 = zzd(r1, r5)
            int r3 = com.google.android.gms.internal.firebase-perf.zzgq.zzv(r3, r5, r11)
            goto L_0x03c9
        L_0x0350:
            java.util.List r5 = zzd(r1, r5)
            int r3 = com.google.android.gms.internal.firebase-perf.zzgq.zzr(r3, r5, r11)
            goto L_0x03c9
        L_0x035a:
            java.util.List r5 = zzd(r1, r5)
            int r3 = com.google.android.gms.internal.firebase-perf.zzgq.zzt(r3, r5, r11)
            goto L_0x03c9
        L_0x0363:
            java.util.List r5 = zzd(r1, r5)
            int r3 = com.google.android.gms.internal.firebase-perf.zzgq.zzd(r3, r5)
            goto L_0x03c9
        L_0x036c:
            java.util.List r5 = zzd(r1, r5)
            com.google.android.gms.internal.firebase-perf.zzgo r6 = r0.zzap(r12)
            int r3 = com.google.android.gms.internal.firebase-perf.zzgq.zzc(r3, r5, r6)
            goto L_0x03c9
        L_0x0379:
            java.util.List r5 = zzd(r1, r5)
            int r3 = com.google.android.gms.internal.firebase-perf.zzgq.zzc(r3, r5)
            goto L_0x03c9
        L_0x0382:
            java.util.List r5 = zzd(r1, r5)
            int r3 = com.google.android.gms.internal.firebase-perf.zzgq.zzx(r3, r5, r11)
            goto L_0x03c9
        L_0x038b:
            java.util.List r5 = zzd(r1, r5)
            int r3 = com.google.android.gms.internal.firebase-perf.zzgq.zzv(r3, r5, r11)
            goto L_0x03c9
        L_0x0394:
            java.util.List r5 = zzd(r1, r5)
            int r3 = com.google.android.gms.internal.firebase-perf.zzgq.zzw(r3, r5, r11)
            goto L_0x03c9
        L_0x039d:
            java.util.List r5 = zzd(r1, r5)
            int r3 = com.google.android.gms.internal.firebase-perf.zzgq.zzs(r3, r5, r11)
            goto L_0x03c9
        L_0x03a6:
            java.util.List r5 = zzd(r1, r5)
            int r3 = com.google.android.gms.internal.firebase-perf.zzgq.zzp(r3, r5, r11)
            goto L_0x03c9
        L_0x03af:
            java.util.List r5 = zzd(r1, r5)
            int r3 = com.google.android.gms.internal.firebase-perf.zzgq.zzo(r3, r5, r11)
            goto L_0x03c9
        L_0x03b8:
            java.util.List r5 = zzd(r1, r5)
            int r3 = com.google.android.gms.internal.firebase-perf.zzgq.zzv(r3, r5, r11)
            goto L_0x03c9
        L_0x03c1:
            java.util.List r5 = zzd(r1, r5)
            int r3 = com.google.android.gms.internal.firebase-perf.zzgq.zzw(r3, r5, r11)
        L_0x03c9:
            int r13 = r13 + r3
            goto L_0x04e4
        L_0x03cc:
            boolean r14 = r0.zza((T) r1, r12)
            if (r14 == 0) goto L_0x04e4
            java.lang.Object r5 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r1, r5)
            com.google.android.gms.internal.firebase-perf.zzfx r5 = (com.google.android.gms.internal.firebase-perf.zzfx) r5
            com.google.android.gms.internal.firebase-perf.zzgo r6 = r0.zzap(r12)
            int r3 = com.google.android.gms.internal.firebase-perf.zzec.zzc(r3, r5, r6)
            goto L_0x03c9
        L_0x03e1:
            boolean r14 = r0.zza((T) r1, r12)
            if (r14 == 0) goto L_0x04e4
            long r5 = com.google.android.gms.internal.firebase-perf.zzhm.zzk(r1, r5)
            int r3 = com.google.android.gms.internal.firebase-perf.zzec.zzf(r3, r5)
            goto L_0x03c9
        L_0x03f0:
            boolean r14 = r0.zza((T) r1, r12)
            if (r14 == 0) goto L_0x04e4
            int r5 = com.google.android.gms.internal.firebase-perf.zzhm.zzj(r1, r5)
            int r3 = com.google.android.gms.internal.firebase-perf.zzec.zzm(r3, r5)
            goto L_0x03c9
        L_0x03ff:
            boolean r5 = r0.zza((T) r1, r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.firebase-perf.zzec.zzh(r3, r9)
            goto L_0x03c9
        L_0x040a:
            boolean r5 = r0.zza((T) r1, r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.firebase-perf.zzec.zzo(r3, r11)
            goto L_0x03c9
        L_0x0415:
            boolean r14 = r0.zza((T) r1, r12)
            if (r14 == 0) goto L_0x04e4
            int r5 = com.google.android.gms.internal.firebase-perf.zzhm.zzj(r1, r5)
            int r3 = com.google.android.gms.internal.firebase-perf.zzec.zzp(r3, r5)
            goto L_0x03c9
        L_0x0424:
            boolean r14 = r0.zza((T) r1, r12)
            if (r14 == 0) goto L_0x04e4
            int r5 = com.google.android.gms.internal.firebase-perf.zzhm.zzj(r1, r5)
            int r3 = com.google.android.gms.internal.firebase-perf.zzec.zzl(r3, r5)
            goto L_0x03c9
        L_0x0433:
            boolean r14 = r0.zza((T) r1, r12)
            if (r14 == 0) goto L_0x04e4
            java.lang.Object r5 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r1, r5)
            com.google.android.gms.internal.firebase-perf.zzdl r5 = (com.google.android.gms.internal.firebase-perf.zzdl) r5
            int r3 = com.google.android.gms.internal.firebase-perf.zzec.zzc(r3, r5)
            goto L_0x03c9
        L_0x0444:
            boolean r14 = r0.zza((T) r1, r12)
            if (r14 == 0) goto L_0x04e4
            java.lang.Object r5 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r1, r5)
            com.google.android.gms.internal.firebase-perf.zzgo r6 = r0.zzap(r12)
            int r3 = com.google.android.gms.internal.firebase-perf.zzgq.zzc(r3, r5, r6)
            goto L_0x03c9
        L_0x0458:
            boolean r14 = r0.zza((T) r1, r12)
            if (r14 == 0) goto L_0x04e4
            java.lang.Object r5 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r1, r5)
            boolean r6 = r5 instanceof com.google.android.gms.internal.firebase-perf.zzdl
            if (r6 == 0) goto L_0x046e
            com.google.android.gms.internal.firebase-perf.zzdl r5 = (com.google.android.gms.internal.firebase-perf.zzdl) r5
            int r3 = com.google.android.gms.internal.firebase-perf.zzec.zzc(r3, r5)
            goto L_0x03c9
        L_0x046e:
            java.lang.String r5 = (java.lang.String) r5
            int r3 = com.google.android.gms.internal.firebase-perf.zzec.zzc(r3, r5)
            goto L_0x03c9
        L_0x0476:
            boolean r5 = r0.zza((T) r1, r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.firebase-perf.zzec.zzb(r3, r8)
            goto L_0x03c9
        L_0x0482:
            boolean r5 = r0.zza((T) r1, r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.firebase-perf.zzec.zzn(r3, r11)
            goto L_0x03c9
        L_0x048e:
            boolean r5 = r0.zza((T) r1, r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.firebase-perf.zzec.zzg(r3, r9)
            goto L_0x03c9
        L_0x049a:
            boolean r14 = r0.zza((T) r1, r12)
            if (r14 == 0) goto L_0x04e4
            int r5 = com.google.android.gms.internal.firebase-perf.zzhm.zzj(r1, r5)
            int r3 = com.google.android.gms.internal.firebase-perf.zzec.zzk(r3, r5)
            goto L_0x03c9
        L_0x04aa:
            boolean r14 = r0.zza((T) r1, r12)
            if (r14 == 0) goto L_0x04e4
            long r5 = com.google.android.gms.internal.firebase-perf.zzhm.zzk(r1, r5)
            int r3 = com.google.android.gms.internal.firebase-perf.zzec.zze(r3, r5)
            goto L_0x03c9
        L_0x04ba:
            boolean r14 = r0.zza((T) r1, r12)
            if (r14 == 0) goto L_0x04e4
            long r5 = com.google.android.gms.internal.firebase-perf.zzhm.zzk(r1, r5)
            int r3 = com.google.android.gms.internal.firebase-perf.zzec.zzd(r3, r5)
            goto L_0x03c9
        L_0x04ca:
            boolean r5 = r0.zza((T) r1, r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.firebase-perf.zzec.zzb(r3, r4)
            goto L_0x03c9
        L_0x04d6:
            boolean r5 = r0.zza((T) r1, r12)
            if (r5 == 0) goto L_0x04e4
            r5 = 0
            int r3 = com.google.android.gms.internal.firebase-perf.zzec.zzb(r3, r5)
            goto L_0x03c9
        L_0x04e4:
            int r12 = r12 + 3
            r3 = 267386880(0xff00000, float:2.3665827E-29)
            goto L_0x0016
        L_0x04ea:
            com.google.android.gms.internal.firebase-perf.zzhg<?, ?> r2 = r0.zztp
            int r1 = zza(r2, (T) r1)
            int r13 = r13 + r1
            return r13
        L_0x04f2:
            sun.misc.Unsafe r2 = zzta
            r3 = -1
            r3 = 0
            r5 = 0
            r6 = -1
            r12 = 0
        L_0x04f9:
            int[] r13 = r0.zztb
            int r13 = r13.length
            if (r3 >= r13) goto L_0x0a39
            int r13 = r0.zzar(r3)
            int[] r14 = r0.zztb
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
            boolean r8 = r0.zztj
            if (r8 == 0) goto L_0x0542
            com.google.android.gms.internal.firebase-perf.zzem r8 = com.google.android.gms.internal.firebase-perf.zzem.DOUBLE_LIST_PACKED
            int r8 = r8.id()
            if (r4 < r8) goto L_0x0542
            com.google.android.gms.internal.firebase-perf.zzem r8 = com.google.android.gms.internal.firebase-perf.zzem.SINT64_LIST_PACKED
            int r8 = r8.id()
            if (r4 > r8) goto L_0x0542
            int[] r8 = r0.zztb
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
            com.google.android.gms.internal.firebase-perf.zzfx r4 = (com.google.android.gms.internal.firebase-perf.zzfx) r4
            com.google.android.gms.internal.firebase-perf.zzgo r8 = r0.zzap(r3)
            int r4 = com.google.android.gms.internal.firebase-perf.zzec.zzc(r15, r4, r8)
            goto L_0x0910
        L_0x0563:
            boolean r4 = r0.zza((T) r1, r15, r3)
            if (r4 == 0) goto L_0x0911
            long r8 = zzh(r1, r8)
            int r4 = com.google.android.gms.internal.firebase-perf.zzec.zzf(r15, r8)
            goto L_0x0910
        L_0x0573:
            boolean r4 = r0.zza((T) r1, r15, r3)
            if (r4 == 0) goto L_0x0911
            int r4 = zzg(r1, r8)
            int r4 = com.google.android.gms.internal.firebase-perf.zzec.zzm(r15, r4)
            goto L_0x0910
        L_0x0583:
            boolean r4 = r0.zza((T) r1, r15, r3)
            if (r4 == 0) goto L_0x0911
            r8 = 0
            int r4 = com.google.android.gms.internal.firebase-perf.zzec.zzh(r15, r8)
            goto L_0x0910
        L_0x0591:
            boolean r4 = r0.zza((T) r1, r15, r3)
            if (r4 == 0) goto L_0x0911
            r4 = 0
            int r8 = com.google.android.gms.internal.firebase-perf.zzec.zzo(r15, r4)
            goto L_0x095a
        L_0x059e:
            boolean r4 = r0.zza((T) r1, r15, r3)
            if (r4 == 0) goto L_0x0911
            int r4 = zzg(r1, r8)
            int r4 = com.google.android.gms.internal.firebase-perf.zzec.zzp(r15, r4)
            goto L_0x0910
        L_0x05ae:
            boolean r4 = r0.zza((T) r1, r15, r3)
            if (r4 == 0) goto L_0x0911
            int r4 = zzg(r1, r8)
            int r4 = com.google.android.gms.internal.firebase-perf.zzec.zzl(r15, r4)
            goto L_0x0910
        L_0x05be:
            boolean r4 = r0.zza((T) r1, r15, r3)
            if (r4 == 0) goto L_0x0911
            java.lang.Object r4 = r2.getObject(r1, r8)
            com.google.android.gms.internal.firebase-perf.zzdl r4 = (com.google.android.gms.internal.firebase-perf.zzdl) r4
            int r4 = com.google.android.gms.internal.firebase-perf.zzec.zzc(r15, r4)
            goto L_0x0910
        L_0x05d0:
            boolean r4 = r0.zza((T) r1, r15, r3)
            if (r4 == 0) goto L_0x0911
            java.lang.Object r4 = r2.getObject(r1, r8)
            com.google.android.gms.internal.firebase-perf.zzgo r8 = r0.zzap(r3)
            int r4 = com.google.android.gms.internal.firebase-perf.zzgq.zzc(r15, r4, r8)
            goto L_0x0910
        L_0x05e4:
            boolean r4 = r0.zza((T) r1, r15, r3)
            if (r4 == 0) goto L_0x0911
            java.lang.Object r4 = r2.getObject(r1, r8)
            boolean r8 = r4 instanceof com.google.android.gms.internal.firebase-perf.zzdl
            if (r8 == 0) goto L_0x05fa
            com.google.android.gms.internal.firebase-perf.zzdl r4 = (com.google.android.gms.internal.firebase-perf.zzdl) r4
            int r4 = com.google.android.gms.internal.firebase-perf.zzec.zzc(r15, r4)
            goto L_0x0910
        L_0x05fa:
            java.lang.String r4 = (java.lang.String) r4
            int r4 = com.google.android.gms.internal.firebase-perf.zzec.zzc(r15, r4)
            goto L_0x0910
        L_0x0602:
            boolean r4 = r0.zza((T) r1, r15, r3)
            if (r4 == 0) goto L_0x0911
            r4 = 1
            int r8 = com.google.android.gms.internal.firebase-perf.zzec.zzb(r15, r4)
            goto L_0x095a
        L_0x060f:
            boolean r4 = r0.zza((T) r1, r15, r3)
            if (r4 == 0) goto L_0x0911
            r4 = 0
            int r8 = com.google.android.gms.internal.firebase-perf.zzec.zzn(r15, r4)
            goto L_0x095a
        L_0x061c:
            boolean r4 = r0.zza((T) r1, r15, r3)
            if (r4 == 0) goto L_0x0911
            r8 = 0
            int r4 = com.google.android.gms.internal.firebase-perf.zzec.zzg(r15, r8)
            goto L_0x0910
        L_0x062a:
            boolean r4 = r0.zza((T) r1, r15, r3)
            if (r4 == 0) goto L_0x0911
            int r4 = zzg(r1, r8)
            int r4 = com.google.android.gms.internal.firebase-perf.zzec.zzk(r15, r4)
            goto L_0x0910
        L_0x063a:
            boolean r4 = r0.zza((T) r1, r15, r3)
            if (r4 == 0) goto L_0x0911
            long r8 = zzh(r1, r8)
            int r4 = com.google.android.gms.internal.firebase-perf.zzec.zze(r15, r8)
            goto L_0x0910
        L_0x064a:
            boolean r4 = r0.zza((T) r1, r15, r3)
            if (r4 == 0) goto L_0x0911
            long r8 = zzh(r1, r8)
            int r4 = com.google.android.gms.internal.firebase-perf.zzec.zzd(r15, r8)
            goto L_0x0910
        L_0x065a:
            boolean r4 = r0.zza((T) r1, r15, r3)
            if (r4 == 0) goto L_0x0911
            r4 = 0
            int r8 = com.google.android.gms.internal.firebase-perf.zzec.zzb(r15, r4)
            goto L_0x095a
        L_0x0667:
            boolean r4 = r0.zza((T) r1, r15, r3)
            if (r4 == 0) goto L_0x0911
            r8 = 0
            int r4 = com.google.android.gms.internal.firebase-perf.zzec.zzb(r15, r8)
            goto L_0x0910
        L_0x0675:
            com.google.android.gms.internal.firebase-perf.zzfu r4 = r0.zztr
            java.lang.Object r8 = r2.getObject(r1, r8)
            java.lang.Object r9 = r0.zzaq(r3)
            int r4 = r4.zzc(r15, r8, r9)
            goto L_0x0910
        L_0x0685:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.firebase-perf.zzgo r8 = r0.zzap(r3)
            int r4 = com.google.android.gms.internal.firebase-perf.zzgq.zzd(r15, r4, r8)
            goto L_0x0910
        L_0x0695:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.firebase-perf.zzgq.zzf(r4)
            if (r4 <= 0) goto L_0x0911
            boolean r8 = r0.zztj
            if (r8 == 0) goto L_0x06a9
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x06a9:
            int r8 = com.google.android.gms.internal.firebase-perf.zzec.zzy(r15)
            int r9 = com.google.android.gms.internal.firebase-perf.zzec.zzaa(r4)
            goto L_0x0834
        L_0x06b3:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.firebase-perf.zzgq.zzj(r4)
            if (r4 <= 0) goto L_0x0911
            boolean r8 = r0.zztj
            if (r8 == 0) goto L_0x06c7
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x06c7:
            int r8 = com.google.android.gms.internal.firebase-perf.zzec.zzy(r15)
            int r9 = com.google.android.gms.internal.firebase-perf.zzec.zzaa(r4)
            goto L_0x0834
        L_0x06d1:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.firebase-perf.zzgq.zzl(r4)
            if (r4 <= 0) goto L_0x0911
            boolean r8 = r0.zztj
            if (r8 == 0) goto L_0x06e5
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x06e5:
            int r8 = com.google.android.gms.internal.firebase-perf.zzec.zzy(r15)
            int r9 = com.google.android.gms.internal.firebase-perf.zzec.zzaa(r4)
            goto L_0x0834
        L_0x06ef:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.firebase-perf.zzgq.zzk(r4)
            if (r4 <= 0) goto L_0x0911
            boolean r8 = r0.zztj
            if (r8 == 0) goto L_0x0703
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x0703:
            int r8 = com.google.android.gms.internal.firebase-perf.zzec.zzy(r15)
            int r9 = com.google.android.gms.internal.firebase-perf.zzec.zzaa(r4)
            goto L_0x0834
        L_0x070d:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.firebase-perf.zzgq.zzg(r4)
            if (r4 <= 0) goto L_0x0911
            boolean r8 = r0.zztj
            if (r8 == 0) goto L_0x0721
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x0721:
            int r8 = com.google.android.gms.internal.firebase-perf.zzec.zzy(r15)
            int r9 = com.google.android.gms.internal.firebase-perf.zzec.zzaa(r4)
            goto L_0x0834
        L_0x072b:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.firebase-perf.zzgq.zzi(r4)
            if (r4 <= 0) goto L_0x0911
            boolean r8 = r0.zztj
            if (r8 == 0) goto L_0x073f
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x073f:
            int r8 = com.google.android.gms.internal.firebase-perf.zzec.zzy(r15)
            int r9 = com.google.android.gms.internal.firebase-perf.zzec.zzaa(r4)
            goto L_0x0834
        L_0x0749:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.firebase-perf.zzgq.zzm(r4)
            if (r4 <= 0) goto L_0x0911
            boolean r8 = r0.zztj
            if (r8 == 0) goto L_0x075d
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x075d:
            int r8 = com.google.android.gms.internal.firebase-perf.zzec.zzy(r15)
            int r9 = com.google.android.gms.internal.firebase-perf.zzec.zzaa(r4)
            goto L_0x0834
        L_0x0767:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.firebase-perf.zzgq.zzk(r4)
            if (r4 <= 0) goto L_0x0911
            boolean r8 = r0.zztj
            if (r8 == 0) goto L_0x077b
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x077b:
            int r8 = com.google.android.gms.internal.firebase-perf.zzec.zzy(r15)
            int r9 = com.google.android.gms.internal.firebase-perf.zzec.zzaa(r4)
            goto L_0x0834
        L_0x0785:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.firebase-perf.zzgq.zzl(r4)
            if (r4 <= 0) goto L_0x0911
            boolean r8 = r0.zztj
            if (r8 == 0) goto L_0x0799
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x0799:
            int r8 = com.google.android.gms.internal.firebase-perf.zzec.zzy(r15)
            int r9 = com.google.android.gms.internal.firebase-perf.zzec.zzaa(r4)
            goto L_0x0834
        L_0x07a3:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.firebase-perf.zzgq.zzh(r4)
            if (r4 <= 0) goto L_0x0911
            boolean r8 = r0.zztj
            if (r8 == 0) goto L_0x07b7
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x07b7:
            int r8 = com.google.android.gms.internal.firebase-perf.zzec.zzy(r15)
            int r9 = com.google.android.gms.internal.firebase-perf.zzec.zzaa(r4)
            goto L_0x0834
        L_0x07c1:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.firebase-perf.zzgq.zze(r4)
            if (r4 <= 0) goto L_0x0911
            boolean r8 = r0.zztj
            if (r8 == 0) goto L_0x07d5
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x07d5:
            int r8 = com.google.android.gms.internal.firebase-perf.zzec.zzy(r15)
            int r9 = com.google.android.gms.internal.firebase-perf.zzec.zzaa(r4)
            goto L_0x0834
        L_0x07de:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.firebase-perf.zzgq.zzd(r4)
            if (r4 <= 0) goto L_0x0911
            boolean r8 = r0.zztj
            if (r8 == 0) goto L_0x07f2
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x07f2:
            int r8 = com.google.android.gms.internal.firebase-perf.zzec.zzy(r15)
            int r9 = com.google.android.gms.internal.firebase-perf.zzec.zzaa(r4)
            goto L_0x0834
        L_0x07fb:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.firebase-perf.zzgq.zzk(r4)
            if (r4 <= 0) goto L_0x0911
            boolean r8 = r0.zztj
            if (r8 == 0) goto L_0x080f
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x080f:
            int r8 = com.google.android.gms.internal.firebase-perf.zzec.zzy(r15)
            int r9 = com.google.android.gms.internal.firebase-perf.zzec.zzaa(r4)
            goto L_0x0834
        L_0x0818:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.firebase-perf.zzgq.zzl(r4)
            if (r4 <= 0) goto L_0x0911
            boolean r8 = r0.zztj
            if (r8 == 0) goto L_0x082c
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x082c:
            int r8 = com.google.android.gms.internal.firebase-perf.zzec.zzy(r15)
            int r9 = com.google.android.gms.internal.firebase-perf.zzec.zzaa(r4)
        L_0x0834:
            int r8 = r8 + r9
            int r8 = r8 + r4
            goto L_0x095a
        L_0x0838:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            r10 = 0
            int r4 = com.google.android.gms.internal.firebase-perf.zzgq.zzq(r15, r4, r10)
            goto L_0x0900
        L_0x0845:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.firebase-perf.zzgq.zzu(r15, r4, r10)
            goto L_0x0900
        L_0x0852:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.firebase-perf.zzgq.zzw(r15, r4, r10)
            goto L_0x0900
        L_0x085f:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.firebase-perf.zzgq.zzv(r15, r4, r10)
            goto L_0x0900
        L_0x086c:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.firebase-perf.zzgq.zzr(r15, r4, r10)
            goto L_0x0900
        L_0x0879:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.firebase-perf.zzgq.zzt(r15, r4, r10)
            goto L_0x0910
        L_0x0886:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.firebase-perf.zzgq.zzd(r15, r4)
            goto L_0x0910
        L_0x0892:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.firebase-perf.zzgo r8 = r0.zzap(r3)
            int r4 = com.google.android.gms.internal.firebase-perf.zzgq.zzc(r15, r4, r8)
            goto L_0x0910
        L_0x08a2:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.firebase-perf.zzgq.zzc(r15, r4)
            goto L_0x0910
        L_0x08ad:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            r10 = 0
            int r4 = com.google.android.gms.internal.firebase-perf.zzgq.zzx(r15, r4, r10)
            goto L_0x0900
        L_0x08b9:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.firebase-perf.zzgq.zzv(r15, r4, r10)
            goto L_0x0900
        L_0x08c5:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.firebase-perf.zzgq.zzw(r15, r4, r10)
            goto L_0x0900
        L_0x08d1:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.firebase-perf.zzgq.zzs(r15, r4, r10)
            goto L_0x0900
        L_0x08dd:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.firebase-perf.zzgq.zzp(r15, r4, r10)
            goto L_0x0900
        L_0x08e9:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.firebase-perf.zzgq.zzo(r15, r4, r10)
            goto L_0x0900
        L_0x08f5:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.firebase-perf.zzgq.zzv(r15, r4, r10)
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
            int r4 = com.google.android.gms.internal.firebase-perf.zzgq.zzw(r15, r4, r10)
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
            com.google.android.gms.internal.firebase-perf.zzfx r4 = (com.google.android.gms.internal.firebase-perf.zzfx) r4
            com.google.android.gms.internal.firebase-perf.zzgo r8 = r0.zzap(r3)
            int r4 = com.google.android.gms.internal.firebase-perf.zzec.zzc(r15, r4, r8)
            goto L_0x0910
        L_0x092c:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x0911
            long r8 = r2.getLong(r1, r8)
            int r4 = com.google.android.gms.internal.firebase-perf.zzec.zzf(r15, r8)
            goto L_0x0910
        L_0x0939:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x0911
            int r4 = r2.getInt(r1, r8)
            int r4 = com.google.android.gms.internal.firebase-perf.zzec.zzm(r15, r4)
            goto L_0x0910
        L_0x0946:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x0911
            r8 = 0
            int r4 = com.google.android.gms.internal.firebase-perf.zzec.zzh(r15, r8)
            goto L_0x0910
        L_0x0951:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x0911
            r4 = 0
            int r8 = com.google.android.gms.internal.firebase-perf.zzec.zzo(r15, r4)
        L_0x095a:
            int r5 = r5 + r8
            goto L_0x0911
        L_0x095c:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x0911
            int r4 = r2.getInt(r1, r8)
            int r4 = com.google.android.gms.internal.firebase-perf.zzec.zzp(r15, r4)
            goto L_0x0910
        L_0x0969:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x0911
            int r4 = r2.getInt(r1, r8)
            int r4 = com.google.android.gms.internal.firebase-perf.zzec.zzl(r15, r4)
            goto L_0x0910
        L_0x0976:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x0911
            java.lang.Object r4 = r2.getObject(r1, r8)
            com.google.android.gms.internal.firebase-perf.zzdl r4 = (com.google.android.gms.internal.firebase-perf.zzdl) r4
            int r4 = com.google.android.gms.internal.firebase-perf.zzec.zzc(r15, r4)
            goto L_0x0910
        L_0x0985:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x0911
            java.lang.Object r4 = r2.getObject(r1, r8)
            com.google.android.gms.internal.firebase-perf.zzgo r8 = r0.zzap(r3)
            int r4 = com.google.android.gms.internal.firebase-perf.zzgq.zzc(r15, r4, r8)
            goto L_0x0910
        L_0x0997:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x0911
            java.lang.Object r4 = r2.getObject(r1, r8)
            boolean r8 = r4 instanceof com.google.android.gms.internal.firebase-perf.zzdl
            if (r8 == 0) goto L_0x09ab
            com.google.android.gms.internal.firebase-perf.zzdl r4 = (com.google.android.gms.internal.firebase-perf.zzdl) r4
            int r4 = com.google.android.gms.internal.firebase-perf.zzec.zzc(r15, r4)
            goto L_0x0910
        L_0x09ab:
            java.lang.String r4 = (java.lang.String) r4
            int r4 = com.google.android.gms.internal.firebase-perf.zzec.zzc(r15, r4)
            goto L_0x0910
        L_0x09b3:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x0911
            r4 = 1
            int r8 = com.google.android.gms.internal.firebase-perf.zzec.zzb(r15, r4)
            int r5 = r5 + r8
            goto L_0x0912
        L_0x09bf:
            r4 = 1
            r8 = r12 & r18
            r10 = 0
            if (r8 == 0) goto L_0x0902
            int r8 = com.google.android.gms.internal.firebase-perf.zzec.zzn(r15, r10)
            int r5 = r5 + r8
            goto L_0x0902
        L_0x09cc:
            r4 = 1
            r10 = 0
            r8 = r12 & r18
            r13 = 0
            if (r8 == 0) goto L_0x0a1b
            int r8 = com.google.android.gms.internal.firebase-perf.zzec.zzg(r15, r13)
            goto L_0x0a0b
        L_0x09d9:
            r4 = 1
            r10 = 0
            r13 = 0
            r11 = r12 & r18
            if (r11 == 0) goto L_0x0a1b
            int r8 = r2.getInt(r1, r8)
            int r8 = com.google.android.gms.internal.firebase-perf.zzec.zzk(r15, r8)
            goto L_0x0a0b
        L_0x09ea:
            r4 = 1
            r10 = 0
            r13 = 0
            r11 = r12 & r18
            if (r11 == 0) goto L_0x0a1b
            long r8 = r2.getLong(r1, r8)
            int r8 = com.google.android.gms.internal.firebase-perf.zzec.zze(r15, r8)
            goto L_0x0a0b
        L_0x09fb:
            r4 = 1
            r10 = 0
            r13 = 0
            r11 = r12 & r18
            if (r11 == 0) goto L_0x0a1b
            long r8 = r2.getLong(r1, r8)
            int r8 = com.google.android.gms.internal.firebase-perf.zzec.zzd(r15, r8)
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
            int r9 = com.google.android.gms.internal.firebase-perf.zzec.zzb(r15, r8)
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
            int r11 = com.google.android.gms.internal.firebase-perf.zzec.zzb(r15, r7)
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
            com.google.android.gms.internal.firebase-perf.zzhg<?, ?> r2 = r0.zztp
            int r2 = zza(r2, (T) r1)
            int r5 = r5 + r2
            boolean r2 = r0.zztg
            if (r2 == 0) goto L_0x0a93
            com.google.android.gms.internal.firebase-perf.zzeg<?> r2 = r0.zztq
            com.google.android.gms.internal.firebase-perf.zzeh r1 = r2.zzc(r1)
            r2 = 0
        L_0x0a4c:
            com.google.android.gms.internal.firebase-perf.zzgp<FieldDescriptorType, java.lang.Object> r3 = r1.zznp
            int r3 = r3.zzis()
            if (r10 >= r3) goto L_0x0a6c
            com.google.android.gms.internal.firebase-perf.zzgp<FieldDescriptorType, java.lang.Object> r3 = r1.zznp
            java.util.Map$Entry r3 = r3.zzau(r10)
            java.lang.Object r4 = r3.getKey()
            com.google.android.gms.internal.firebase-perf.zzej r4 = (com.google.android.gms.internal.firebase-perf.zzej) r4
            java.lang.Object r3 = r3.getValue()
            int r3 = com.google.android.gms.internal.firebase-perf.zzeh.zzb(r4, r3)
            int r2 = r2 + r3
            int r10 = r10 + 1
            goto L_0x0a4c
        L_0x0a6c:
            com.google.android.gms.internal.firebase-perf.zzgp<FieldDescriptorType, java.lang.Object> r1 = r1.zznp
            java.lang.Iterable r1 = r1.zzit()
            java.util.Iterator r1 = r1.iterator()
        L_0x0a76:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x0a92
            java.lang.Object r3 = r1.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r3.getKey()
            com.google.android.gms.internal.firebase-perf.zzej r4 = (com.google.android.gms.internal.firebase-perf.zzej) r4
            java.lang.Object r3 = r3.getValue()
            int r3 = com.google.android.gms.internal.firebase-perf.zzeh.zzb(r4, r3)
            int r2 = r2 + r3
            goto L_0x0a76
        L_0x0a92:
            int r5 = r5 + r2
        L_0x0a93:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase-perf.zzgb.zzl(java.lang.Object):int");
    }

    private static <UT, UB> int zza(zzhg<UT, UB> zzhg, T t) {
        return zzhg.zzl(zzhg.zzo(t));
    }

    private static List<?> zzd(Object obj, long j) {
        return (List) zzhm.zzo(obj, j);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x04bc A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x04bd  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x04eb  */
    /* JADX WARNING: Removed duplicated region for block: B:321:0x096d  */
    /* JADX WARNING: Removed duplicated region for block: B:323:0x0973  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r13, com.google.android.gms.internal.firebase-perf.zzia r14) throws java.io.IOException {
        /*
            r12 = this;
            int r0 = r14.zzgt()
            int r1 = com.google.android.gms.internal.firebase-perf.zzep.zzd.zzrh
            r2 = 267386880(0xff00000, float:2.3665827E-29)
            r3 = 0
            r4 = 1
            r5 = 0
            r6 = 1048575(0xfffff, float:1.469367E-39)
            if (r0 != r1) goto L_0x04c3
            com.google.android.gms.internal.firebase-perf.zzhg<?, ?> r0 = r12.zztp
            zza(r0, (T) r13, r14)
            boolean r0 = r12.zztg
            if (r0 == 0) goto L_0x0032
            com.google.android.gms.internal.firebase-perf.zzeg<?> r0 = r12.zztq
            com.google.android.gms.internal.firebase-perf.zzeh r0 = r0.zzc(r13)
            com.google.android.gms.internal.firebase-perf.zzgp<FieldDescriptorType, java.lang.Object> r1 = r0.zznp
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x0032
            java.util.Iterator r0 = r0.descendingIterator()
            java.lang.Object r0 = r0.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            goto L_0x0033
        L_0x0032:
            r0 = r3
        L_0x0033:
            int[] r1 = r12.zztb
            int r1 = r1.length
            int r1 = r1 + -3
        L_0x0038:
            if (r1 < 0) goto L_0x04ba
            int r7 = r12.zzar(r1)
            int[] r8 = r12.zztb
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
            java.lang.Object r7 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r13, r7)
            com.google.android.gms.internal.firebase-perf.zzgo r8 = r12.zzap(r1)
            r14.zzb(r9, r7, r8)
            goto L_0x04b0
        L_0x0062:
            boolean r8 = r12.zza((T) r13, r9, r1)
            if (r8 == 0) goto L_0x04b0
            r7 = r7 & r6
            long r7 = (long) r7
            long r7 = zzh(r13, r7)
            r14.zzb(r9, r7)
            goto L_0x04b0
        L_0x0073:
            boolean r8 = r12.zza((T) r13, r9, r1)
            if (r8 == 0) goto L_0x04b0
            r7 = r7 & r6
            long r7 = (long) r7
            int r7 = zzg(r13, r7)
            r14.zzi(r9, r7)
            goto L_0x04b0
        L_0x0084:
            boolean r8 = r12.zza((T) r13, r9, r1)
            if (r8 == 0) goto L_0x04b0
            r7 = r7 & r6
            long r7 = (long) r7
            long r7 = zzh(r13, r7)
            r14.zzj(r9, r7)
            goto L_0x04b0
        L_0x0095:
            boolean r8 = r12.zza((T) r13, r9, r1)
            if (r8 == 0) goto L_0x04b0
            r7 = r7 & r6
            long r7 = (long) r7
            int r7 = zzg(r13, r7)
            r14.zzq(r9, r7)
            goto L_0x04b0
        L_0x00a6:
            boolean r8 = r12.zza((T) r13, r9, r1)
            if (r8 == 0) goto L_0x04b0
            r7 = r7 & r6
            long r7 = (long) r7
            int r7 = zzg(r13, r7)
            r14.zzr(r9, r7)
            goto L_0x04b0
        L_0x00b7:
            boolean r8 = r12.zza((T) r13, r9, r1)
            if (r8 == 0) goto L_0x04b0
            r7 = r7 & r6
            long r7 = (long) r7
            int r7 = zzg(r13, r7)
            r14.zzh(r9, r7)
            goto L_0x04b0
        L_0x00c8:
            boolean r8 = r12.zza((T) r13, r9, r1)
            if (r8 == 0) goto L_0x04b0
            r7 = r7 & r6
            long r7 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r13, r7)
            com.google.android.gms.internal.firebase-perf.zzdl r7 = (com.google.android.gms.internal.firebase-perf.zzdl) r7
            r14.zza(r9, r7)
            goto L_0x04b0
        L_0x00db:
            boolean r8 = r12.zza((T) r13, r9, r1)
            if (r8 == 0) goto L_0x04b0
            r7 = r7 & r6
            long r7 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r13, r7)
            com.google.android.gms.internal.firebase-perf.zzgo r8 = r12.zzap(r1)
            r14.zza(r9, r7, r8)
            goto L_0x04b0
        L_0x00f0:
            boolean r8 = r12.zza((T) r13, r9, r1)
            if (r8 == 0) goto L_0x04b0
            r7 = r7 & r6
            long r7 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r13, r7)
            zza(r9, r7, r14)
            goto L_0x04b0
        L_0x0101:
            boolean r8 = r12.zza((T) r13, r9, r1)
            if (r8 == 0) goto L_0x04b0
            r7 = r7 & r6
            long r7 = (long) r7
            boolean r7 = zzi(r13, r7)
            r14.zza(r9, r7)
            goto L_0x04b0
        L_0x0112:
            boolean r8 = r12.zza((T) r13, r9, r1)
            if (r8 == 0) goto L_0x04b0
            r7 = r7 & r6
            long r7 = (long) r7
            int r7 = zzg(r13, r7)
            r14.zzj(r9, r7)
            goto L_0x04b0
        L_0x0123:
            boolean r8 = r12.zza((T) r13, r9, r1)
            if (r8 == 0) goto L_0x04b0
            r7 = r7 & r6
            long r7 = (long) r7
            long r7 = zzh(r13, r7)
            r14.zzc(r9, r7)
            goto L_0x04b0
        L_0x0134:
            boolean r8 = r12.zza((T) r13, r9, r1)
            if (r8 == 0) goto L_0x04b0
            r7 = r7 & r6
            long r7 = (long) r7
            int r7 = zzg(r13, r7)
            r14.zzg(r9, r7)
            goto L_0x04b0
        L_0x0145:
            boolean r8 = r12.zza((T) r13, r9, r1)
            if (r8 == 0) goto L_0x04b0
            r7 = r7 & r6
            long r7 = (long) r7
            long r7 = zzh(r13, r7)
            r14.zza(r9, r7)
            goto L_0x04b0
        L_0x0156:
            boolean r8 = r12.zza((T) r13, r9, r1)
            if (r8 == 0) goto L_0x04b0
            r7 = r7 & r6
            long r7 = (long) r7
            long r7 = zzh(r13, r7)
            r14.zzi(r9, r7)
            goto L_0x04b0
        L_0x0167:
            boolean r8 = r12.zza((T) r13, r9, r1)
            if (r8 == 0) goto L_0x04b0
            r7 = r7 & r6
            long r7 = (long) r7
            float r7 = zzf(r13, r7)
            r14.zza(r9, r7)
            goto L_0x04b0
        L_0x0178:
            boolean r8 = r12.zza((T) r13, r9, r1)
            if (r8 == 0) goto L_0x04b0
            r7 = r7 & r6
            long r7 = (long) r7
            double r7 = zze((T) r13, r7)
            r14.zza(r9, r7)
            goto L_0x04b0
        L_0x0189:
            r7 = r7 & r6
            long r7 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r13, r7)
            r12.zza(r14, r9, r7, r1)
            goto L_0x04b0
        L_0x0194:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.firebase-perf.zzgo r9 = r12.zzap(r1)
            com.google.android.gms.internal.firebase-perf.zzgq.zzb(r8, r7, r14, r9)
            goto L_0x04b0
        L_0x01a7:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.firebase-perf.zzgq.zze(r8, r7, r14, r4)
            goto L_0x04b0
        L_0x01b6:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.firebase-perf.zzgq.zzj(r8, r7, r14, r4)
            goto L_0x04b0
        L_0x01c5:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.firebase-perf.zzgq.zzg(r8, r7, r14, r4)
            goto L_0x04b0
        L_0x01d4:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.firebase-perf.zzgq.zzl(r8, r7, r14, r4)
            goto L_0x04b0
        L_0x01e3:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.firebase-perf.zzgq.zzm(r8, r7, r14, r4)
            goto L_0x04b0
        L_0x01f2:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.firebase-perf.zzgq.zzi(r8, r7, r14, r4)
            goto L_0x04b0
        L_0x0201:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.firebase-perf.zzgq.zzn(r8, r7, r14, r4)
            goto L_0x04b0
        L_0x0210:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.firebase-perf.zzgq.zzk(r8, r7, r14, r4)
            goto L_0x04b0
        L_0x021f:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.firebase-perf.zzgq.zzf(r8, r7, r14, r4)
            goto L_0x04b0
        L_0x022e:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.firebase-perf.zzgq.zzh(r8, r7, r14, r4)
            goto L_0x04b0
        L_0x023d:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.firebase-perf.zzgq.zzd(r8, r7, r14, r4)
            goto L_0x04b0
        L_0x024c:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.firebase-perf.zzgq.zzc(r8, r7, r14, r4)
            goto L_0x04b0
        L_0x025b:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.firebase-perf.zzgq.zzb(r8, r7, r14, r4)
            goto L_0x04b0
        L_0x026a:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.firebase-perf.zzgq.zza(r8, r7, r14, r4)
            goto L_0x04b0
        L_0x0279:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.firebase-perf.zzgq.zze(r8, r7, r14, r5)
            goto L_0x04b0
        L_0x0288:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.firebase-perf.zzgq.zzj(r8, r7, r14, r5)
            goto L_0x04b0
        L_0x0297:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.firebase-perf.zzgq.zzg(r8, r7, r14, r5)
            goto L_0x04b0
        L_0x02a6:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.firebase-perf.zzgq.zzl(r8, r7, r14, r5)
            goto L_0x04b0
        L_0x02b5:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.firebase-perf.zzgq.zzm(r8, r7, r14, r5)
            goto L_0x04b0
        L_0x02c4:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.firebase-perf.zzgq.zzi(r8, r7, r14, r5)
            goto L_0x04b0
        L_0x02d3:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.firebase-perf.zzgq.zzb(r8, r7, r14)
            goto L_0x04b0
        L_0x02e2:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.firebase-perf.zzgo r9 = r12.zzap(r1)
            com.google.android.gms.internal.firebase-perf.zzgq.zza(r8, r7, r14, r9)
            goto L_0x04b0
        L_0x02f5:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.firebase-perf.zzgq.zza(r8, r7, r14)
            goto L_0x04b0
        L_0x0304:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.firebase-perf.zzgq.zzn(r8, r7, r14, r5)
            goto L_0x04b0
        L_0x0313:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.firebase-perf.zzgq.zzk(r8, r7, r14, r5)
            goto L_0x04b0
        L_0x0322:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.firebase-perf.zzgq.zzf(r8, r7, r14, r5)
            goto L_0x04b0
        L_0x0331:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.firebase-perf.zzgq.zzh(r8, r7, r14, r5)
            goto L_0x04b0
        L_0x0340:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.firebase-perf.zzgq.zzd(r8, r7, r14, r5)
            goto L_0x04b0
        L_0x034f:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.firebase-perf.zzgq.zzc(r8, r7, r14, r5)
            goto L_0x04b0
        L_0x035e:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.firebase-perf.zzgq.zzb(r8, r7, r14, r5)
            goto L_0x04b0
        L_0x036d:
            r8 = r8[r1]
            r7 = r7 & r6
            long r9 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r13, r9)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.firebase-perf.zzgq.zza(r8, r7, r14, r5)
            goto L_0x04b0
        L_0x037c:
            boolean r8 = r12.zza((T) r13, r1)
            if (r8 == 0) goto L_0x04b0
            r7 = r7 & r6
            long r7 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r13, r7)
            com.google.android.gms.internal.firebase-perf.zzgo r8 = r12.zzap(r1)
            r14.zzb(r9, r7, r8)
            goto L_0x04b0
        L_0x0391:
            boolean r8 = r12.zza((T) r13, r1)
            if (r8 == 0) goto L_0x04b0
            r7 = r7 & r6
            long r7 = (long) r7
            long r7 = com.google.android.gms.internal.firebase-perf.zzhm.zzk(r13, r7)
            r14.zzb(r9, r7)
            goto L_0x04b0
        L_0x03a2:
            boolean r8 = r12.zza((T) r13, r1)
            if (r8 == 0) goto L_0x04b0
            r7 = r7 & r6
            long r7 = (long) r7
            int r7 = com.google.android.gms.internal.firebase-perf.zzhm.zzj(r13, r7)
            r14.zzi(r9, r7)
            goto L_0x04b0
        L_0x03b3:
            boolean r8 = r12.zza((T) r13, r1)
            if (r8 == 0) goto L_0x04b0
            r7 = r7 & r6
            long r7 = (long) r7
            long r7 = com.google.android.gms.internal.firebase-perf.zzhm.zzk(r13, r7)
            r14.zzj(r9, r7)
            goto L_0x04b0
        L_0x03c4:
            boolean r8 = r12.zza((T) r13, r1)
            if (r8 == 0) goto L_0x04b0
            r7 = r7 & r6
            long r7 = (long) r7
            int r7 = com.google.android.gms.internal.firebase-perf.zzhm.zzj(r13, r7)
            r14.zzq(r9, r7)
            goto L_0x04b0
        L_0x03d5:
            boolean r8 = r12.zza((T) r13, r1)
            if (r8 == 0) goto L_0x04b0
            r7 = r7 & r6
            long r7 = (long) r7
            int r7 = com.google.android.gms.internal.firebase-perf.zzhm.zzj(r13, r7)
            r14.zzr(r9, r7)
            goto L_0x04b0
        L_0x03e6:
            boolean r8 = r12.zza((T) r13, r1)
            if (r8 == 0) goto L_0x04b0
            r7 = r7 & r6
            long r7 = (long) r7
            int r7 = com.google.android.gms.internal.firebase-perf.zzhm.zzj(r13, r7)
            r14.zzh(r9, r7)
            goto L_0x04b0
        L_0x03f7:
            boolean r8 = r12.zza((T) r13, r1)
            if (r8 == 0) goto L_0x04b0
            r7 = r7 & r6
            long r7 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r13, r7)
            com.google.android.gms.internal.firebase-perf.zzdl r7 = (com.google.android.gms.internal.firebase-perf.zzdl) r7
            r14.zza(r9, r7)
            goto L_0x04b0
        L_0x040a:
            boolean r8 = r12.zza((T) r13, r1)
            if (r8 == 0) goto L_0x04b0
            r7 = r7 & r6
            long r7 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r13, r7)
            com.google.android.gms.internal.firebase-perf.zzgo r8 = r12.zzap(r1)
            r14.zza(r9, r7, r8)
            goto L_0x04b0
        L_0x041f:
            boolean r8 = r12.zza((T) r13, r1)
            if (r8 == 0) goto L_0x04b0
            r7 = r7 & r6
            long r7 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r13, r7)
            zza(r9, r7, r14)
            goto L_0x04b0
        L_0x0430:
            boolean r8 = r12.zza((T) r13, r1)
            if (r8 == 0) goto L_0x04b0
            r7 = r7 & r6
            long r7 = (long) r7
            boolean r7 = com.google.android.gms.internal.firebase-perf.zzhm.zzl(r13, r7)
            r14.zza(r9, r7)
            goto L_0x04b0
        L_0x0441:
            boolean r8 = r12.zza((T) r13, r1)
            if (r8 == 0) goto L_0x04b0
            r7 = r7 & r6
            long r7 = (long) r7
            int r7 = com.google.android.gms.internal.firebase-perf.zzhm.zzj(r13, r7)
            r14.zzj(r9, r7)
            goto L_0x04b0
        L_0x0451:
            boolean r8 = r12.zza((T) r13, r1)
            if (r8 == 0) goto L_0x04b0
            r7 = r7 & r6
            long r7 = (long) r7
            long r7 = com.google.android.gms.internal.firebase-perf.zzhm.zzk(r13, r7)
            r14.zzc(r9, r7)
            goto L_0x04b0
        L_0x0461:
            boolean r8 = r12.zza((T) r13, r1)
            if (r8 == 0) goto L_0x04b0
            r7 = r7 & r6
            long r7 = (long) r7
            int r7 = com.google.android.gms.internal.firebase-perf.zzhm.zzj(r13, r7)
            r14.zzg(r9, r7)
            goto L_0x04b0
        L_0x0471:
            boolean r8 = r12.zza((T) r13, r1)
            if (r8 == 0) goto L_0x04b0
            r7 = r7 & r6
            long r7 = (long) r7
            long r7 = com.google.android.gms.internal.firebase-perf.zzhm.zzk(r13, r7)
            r14.zza(r9, r7)
            goto L_0x04b0
        L_0x0481:
            boolean r8 = r12.zza((T) r13, r1)
            if (r8 == 0) goto L_0x04b0
            r7 = r7 & r6
            long r7 = (long) r7
            long r7 = com.google.android.gms.internal.firebase-perf.zzhm.zzk(r13, r7)
            r14.zzi(r9, r7)
            goto L_0x04b0
        L_0x0491:
            boolean r8 = r12.zza((T) r13, r1)
            if (r8 == 0) goto L_0x04b0
            r7 = r7 & r6
            long r7 = (long) r7
            float r7 = com.google.android.gms.internal.firebase-perf.zzhm.zzm(r13, r7)
            r14.zza(r9, r7)
            goto L_0x04b0
        L_0x04a1:
            boolean r8 = r12.zza((T) r13, r1)
            if (r8 == 0) goto L_0x04b0
            r7 = r7 & r6
            long r7 = (long) r7
            double r7 = com.google.android.gms.internal.firebase-perf.zzhm.zzn(r13, r7)
            r14.zza(r9, r7)
        L_0x04b0:
            int r1 = r1 + -3
            goto L_0x0038
        L_0x04b4:
            com.google.android.gms.internal.firebase-perf.zzeg<?> r13 = r12.zztq
            r13.zzb(r0)
            throw r3
        L_0x04ba:
            if (r0 != 0) goto L_0x04bd
            return
        L_0x04bd:
            com.google.android.gms.internal.firebase-perf.zzeg<?> r13 = r12.zztq
            r13.zza(r14, r0)
            throw r3
        L_0x04c3:
            boolean r0 = r12.zzti
            if (r0 == 0) goto L_0x0979
            boolean r0 = r12.zztg
            if (r0 == 0) goto L_0x04e4
            com.google.android.gms.internal.firebase-perf.zzeg<?> r0 = r12.zztq
            com.google.android.gms.internal.firebase-perf.zzeh r0 = r0.zzc(r13)
            com.google.android.gms.internal.firebase-perf.zzgp<FieldDescriptorType, java.lang.Object> r1 = r0.zznp
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x04e4
            java.util.Iterator r0 = r0.iterator()
            java.lang.Object r0 = r0.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            goto L_0x04e5
        L_0x04e4:
            r0 = r3
        L_0x04e5:
            int[] r1 = r12.zztb
            int r1 = r1.length
            r7 = 0
        L_0x04e9:
            if (r7 >= r1) goto L_0x096b
            int r8 = r12.zzar(r7)
            int[] r9 = r12.zztb
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
            java.lang.Object r8 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r13, r8)
            com.google.android.gms.internal.firebase-perf.zzgo r9 = r12.zzap(r7)
            r14.zzb(r10, r8, r9)
            goto L_0x0961
        L_0x0513:
            boolean r9 = r12.zza((T) r13, r10, r7)
            if (r9 == 0) goto L_0x0961
            r8 = r8 & r6
            long r8 = (long) r8
            long r8 = zzh(r13, r8)
            r14.zzb(r10, r8)
            goto L_0x0961
        L_0x0524:
            boolean r9 = r12.zza((T) r13, r10, r7)
            if (r9 == 0) goto L_0x0961
            r8 = r8 & r6
            long r8 = (long) r8
            int r8 = zzg(r13, r8)
            r14.zzi(r10, r8)
            goto L_0x0961
        L_0x0535:
            boolean r9 = r12.zza((T) r13, r10, r7)
            if (r9 == 0) goto L_0x0961
            r8 = r8 & r6
            long r8 = (long) r8
            long r8 = zzh(r13, r8)
            r14.zzj(r10, r8)
            goto L_0x0961
        L_0x0546:
            boolean r9 = r12.zza((T) r13, r10, r7)
            if (r9 == 0) goto L_0x0961
            r8 = r8 & r6
            long r8 = (long) r8
            int r8 = zzg(r13, r8)
            r14.zzq(r10, r8)
            goto L_0x0961
        L_0x0557:
            boolean r9 = r12.zza((T) r13, r10, r7)
            if (r9 == 0) goto L_0x0961
            r8 = r8 & r6
            long r8 = (long) r8
            int r8 = zzg(r13, r8)
            r14.zzr(r10, r8)
            goto L_0x0961
        L_0x0568:
            boolean r9 = r12.zza((T) r13, r10, r7)
            if (r9 == 0) goto L_0x0961
            r8 = r8 & r6
            long r8 = (long) r8
            int r8 = zzg(r13, r8)
            r14.zzh(r10, r8)
            goto L_0x0961
        L_0x0579:
            boolean r9 = r12.zza((T) r13, r10, r7)
            if (r9 == 0) goto L_0x0961
            r8 = r8 & r6
            long r8 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r13, r8)
            com.google.android.gms.internal.firebase-perf.zzdl r8 = (com.google.android.gms.internal.firebase-perf.zzdl) r8
            r14.zza(r10, r8)
            goto L_0x0961
        L_0x058c:
            boolean r9 = r12.zza((T) r13, r10, r7)
            if (r9 == 0) goto L_0x0961
            r8 = r8 & r6
            long r8 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r13, r8)
            com.google.android.gms.internal.firebase-perf.zzgo r9 = r12.zzap(r7)
            r14.zza(r10, r8, r9)
            goto L_0x0961
        L_0x05a1:
            boolean r9 = r12.zza((T) r13, r10, r7)
            if (r9 == 0) goto L_0x0961
            r8 = r8 & r6
            long r8 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r13, r8)
            zza(r10, r8, r14)
            goto L_0x0961
        L_0x05b2:
            boolean r9 = r12.zza((T) r13, r10, r7)
            if (r9 == 0) goto L_0x0961
            r8 = r8 & r6
            long r8 = (long) r8
            boolean r8 = zzi(r13, r8)
            r14.zza(r10, r8)
            goto L_0x0961
        L_0x05c3:
            boolean r9 = r12.zza((T) r13, r10, r7)
            if (r9 == 0) goto L_0x0961
            r8 = r8 & r6
            long r8 = (long) r8
            int r8 = zzg(r13, r8)
            r14.zzj(r10, r8)
            goto L_0x0961
        L_0x05d4:
            boolean r9 = r12.zza((T) r13, r10, r7)
            if (r9 == 0) goto L_0x0961
            r8 = r8 & r6
            long r8 = (long) r8
            long r8 = zzh(r13, r8)
            r14.zzc(r10, r8)
            goto L_0x0961
        L_0x05e5:
            boolean r9 = r12.zza((T) r13, r10, r7)
            if (r9 == 0) goto L_0x0961
            r8 = r8 & r6
            long r8 = (long) r8
            int r8 = zzg(r13, r8)
            r14.zzg(r10, r8)
            goto L_0x0961
        L_0x05f6:
            boolean r9 = r12.zza((T) r13, r10, r7)
            if (r9 == 0) goto L_0x0961
            r8 = r8 & r6
            long r8 = (long) r8
            long r8 = zzh(r13, r8)
            r14.zza(r10, r8)
            goto L_0x0961
        L_0x0607:
            boolean r9 = r12.zza((T) r13, r10, r7)
            if (r9 == 0) goto L_0x0961
            r8 = r8 & r6
            long r8 = (long) r8
            long r8 = zzh(r13, r8)
            r14.zzi(r10, r8)
            goto L_0x0961
        L_0x0618:
            boolean r9 = r12.zza((T) r13, r10, r7)
            if (r9 == 0) goto L_0x0961
            r8 = r8 & r6
            long r8 = (long) r8
            float r8 = zzf(r13, r8)
            r14.zza(r10, r8)
            goto L_0x0961
        L_0x0629:
            boolean r9 = r12.zza((T) r13, r10, r7)
            if (r9 == 0) goto L_0x0961
            r8 = r8 & r6
            long r8 = (long) r8
            double r8 = zze((T) r13, r8)
            r14.zza(r10, r8)
            goto L_0x0961
        L_0x063a:
            r8 = r8 & r6
            long r8 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r13, r8)
            r12.zza(r14, r10, r8, r7)
            goto L_0x0961
        L_0x0645:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase-perf.zzgo r10 = r12.zzap(r7)
            com.google.android.gms.internal.firebase-perf.zzgq.zzb(r9, r8, r14, r10)
            goto L_0x0961
        L_0x0658:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase-perf.zzgq.zze(r9, r8, r14, r4)
            goto L_0x0961
        L_0x0667:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase-perf.zzgq.zzj(r9, r8, r14, r4)
            goto L_0x0961
        L_0x0676:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase-perf.zzgq.zzg(r9, r8, r14, r4)
            goto L_0x0961
        L_0x0685:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase-perf.zzgq.zzl(r9, r8, r14, r4)
            goto L_0x0961
        L_0x0694:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase-perf.zzgq.zzm(r9, r8, r14, r4)
            goto L_0x0961
        L_0x06a3:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase-perf.zzgq.zzi(r9, r8, r14, r4)
            goto L_0x0961
        L_0x06b2:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase-perf.zzgq.zzn(r9, r8, r14, r4)
            goto L_0x0961
        L_0x06c1:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase-perf.zzgq.zzk(r9, r8, r14, r4)
            goto L_0x0961
        L_0x06d0:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase-perf.zzgq.zzf(r9, r8, r14, r4)
            goto L_0x0961
        L_0x06df:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase-perf.zzgq.zzh(r9, r8, r14, r4)
            goto L_0x0961
        L_0x06ee:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase-perf.zzgq.zzd(r9, r8, r14, r4)
            goto L_0x0961
        L_0x06fd:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase-perf.zzgq.zzc(r9, r8, r14, r4)
            goto L_0x0961
        L_0x070c:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase-perf.zzgq.zzb(r9, r8, r14, r4)
            goto L_0x0961
        L_0x071b:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase-perf.zzgq.zza(r9, r8, r14, r4)
            goto L_0x0961
        L_0x072a:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase-perf.zzgq.zze(r9, r8, r14, r5)
            goto L_0x0961
        L_0x0739:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase-perf.zzgq.zzj(r9, r8, r14, r5)
            goto L_0x0961
        L_0x0748:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase-perf.zzgq.zzg(r9, r8, r14, r5)
            goto L_0x0961
        L_0x0757:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase-perf.zzgq.zzl(r9, r8, r14, r5)
            goto L_0x0961
        L_0x0766:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase-perf.zzgq.zzm(r9, r8, r14, r5)
            goto L_0x0961
        L_0x0775:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase-perf.zzgq.zzi(r9, r8, r14, r5)
            goto L_0x0961
        L_0x0784:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase-perf.zzgq.zzb(r9, r8, r14)
            goto L_0x0961
        L_0x0793:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase-perf.zzgo r10 = r12.zzap(r7)
            com.google.android.gms.internal.firebase-perf.zzgq.zza(r9, r8, r14, r10)
            goto L_0x0961
        L_0x07a6:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase-perf.zzgq.zza(r9, r8, r14)
            goto L_0x0961
        L_0x07b5:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase-perf.zzgq.zzn(r9, r8, r14, r5)
            goto L_0x0961
        L_0x07c4:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase-perf.zzgq.zzk(r9, r8, r14, r5)
            goto L_0x0961
        L_0x07d3:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase-perf.zzgq.zzf(r9, r8, r14, r5)
            goto L_0x0961
        L_0x07e2:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase-perf.zzgq.zzh(r9, r8, r14, r5)
            goto L_0x0961
        L_0x07f1:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase-perf.zzgq.zzd(r9, r8, r14, r5)
            goto L_0x0961
        L_0x0800:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase-perf.zzgq.zzc(r9, r8, r14, r5)
            goto L_0x0961
        L_0x080f:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase-perf.zzgq.zzb(r9, r8, r14, r5)
            goto L_0x0961
        L_0x081e:
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r13, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase-perf.zzgq.zza(r9, r8, r14, r5)
            goto L_0x0961
        L_0x082d:
            boolean r9 = r12.zza((T) r13, r7)
            if (r9 == 0) goto L_0x0961
            r8 = r8 & r6
            long r8 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r13, r8)
            com.google.android.gms.internal.firebase-perf.zzgo r9 = r12.zzap(r7)
            r14.zzb(r10, r8, r9)
            goto L_0x0961
        L_0x0842:
            boolean r9 = r12.zza((T) r13, r7)
            if (r9 == 0) goto L_0x0961
            r8 = r8 & r6
            long r8 = (long) r8
            long r8 = com.google.android.gms.internal.firebase-perf.zzhm.zzk(r13, r8)
            r14.zzb(r10, r8)
            goto L_0x0961
        L_0x0853:
            boolean r9 = r12.zza((T) r13, r7)
            if (r9 == 0) goto L_0x0961
            r8 = r8 & r6
            long r8 = (long) r8
            int r8 = com.google.android.gms.internal.firebase-perf.zzhm.zzj(r13, r8)
            r14.zzi(r10, r8)
            goto L_0x0961
        L_0x0864:
            boolean r9 = r12.zza((T) r13, r7)
            if (r9 == 0) goto L_0x0961
            r8 = r8 & r6
            long r8 = (long) r8
            long r8 = com.google.android.gms.internal.firebase-perf.zzhm.zzk(r13, r8)
            r14.zzj(r10, r8)
            goto L_0x0961
        L_0x0875:
            boolean r9 = r12.zza((T) r13, r7)
            if (r9 == 0) goto L_0x0961
            r8 = r8 & r6
            long r8 = (long) r8
            int r8 = com.google.android.gms.internal.firebase-perf.zzhm.zzj(r13, r8)
            r14.zzq(r10, r8)
            goto L_0x0961
        L_0x0886:
            boolean r9 = r12.zza((T) r13, r7)
            if (r9 == 0) goto L_0x0961
            r8 = r8 & r6
            long r8 = (long) r8
            int r8 = com.google.android.gms.internal.firebase-perf.zzhm.zzj(r13, r8)
            r14.zzr(r10, r8)
            goto L_0x0961
        L_0x0897:
            boolean r9 = r12.zza((T) r13, r7)
            if (r9 == 0) goto L_0x0961
            r8 = r8 & r6
            long r8 = (long) r8
            int r8 = com.google.android.gms.internal.firebase-perf.zzhm.zzj(r13, r8)
            r14.zzh(r10, r8)
            goto L_0x0961
        L_0x08a8:
            boolean r9 = r12.zza((T) r13, r7)
            if (r9 == 0) goto L_0x0961
            r8 = r8 & r6
            long r8 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r13, r8)
            com.google.android.gms.internal.firebase-perf.zzdl r8 = (com.google.android.gms.internal.firebase-perf.zzdl) r8
            r14.zza(r10, r8)
            goto L_0x0961
        L_0x08bb:
            boolean r9 = r12.zza((T) r13, r7)
            if (r9 == 0) goto L_0x0961
            r8 = r8 & r6
            long r8 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r13, r8)
            com.google.android.gms.internal.firebase-perf.zzgo r9 = r12.zzap(r7)
            r14.zza(r10, r8, r9)
            goto L_0x0961
        L_0x08d0:
            boolean r9 = r12.zza((T) r13, r7)
            if (r9 == 0) goto L_0x0961
            r8 = r8 & r6
            long r8 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase-perf.zzhm.zzo(r13, r8)
            zza(r10, r8, r14)
            goto L_0x0961
        L_0x08e1:
            boolean r9 = r12.zza((T) r13, r7)
            if (r9 == 0) goto L_0x0961
            r8 = r8 & r6
            long r8 = (long) r8
            boolean r8 = com.google.android.gms.internal.firebase-perf.zzhm.zzl(r13, r8)
            r14.zza(r10, r8)
            goto L_0x0961
        L_0x08f2:
            boolean r9 = r12.zza((T) r13, r7)
            if (r9 == 0) goto L_0x0961
            r8 = r8 & r6
            long r8 = (long) r8
            int r8 = com.google.android.gms.internal.firebase-perf.zzhm.zzj(r13, r8)
            r14.zzj(r10, r8)
            goto L_0x0961
        L_0x0902:
            boolean r9 = r12.zza((T) r13, r7)
            if (r9 == 0) goto L_0x0961
            r8 = r8 & r6
            long r8 = (long) r8
            long r8 = com.google.android.gms.internal.firebase-perf.zzhm.zzk(r13, r8)
            r14.zzc(r10, r8)
            goto L_0x0961
        L_0x0912:
            boolean r9 = r12.zza((T) r13, r7)
            if (r9 == 0) goto L_0x0961
            r8 = r8 & r6
            long r8 = (long) r8
            int r8 = com.google.android.gms.internal.firebase-perf.zzhm.zzj(r13, r8)
            r14.zzg(r10, r8)
            goto L_0x0961
        L_0x0922:
            boolean r9 = r12.zza((T) r13, r7)
            if (r9 == 0) goto L_0x0961
            r8 = r8 & r6
            long r8 = (long) r8
            long r8 = com.google.android.gms.internal.firebase-perf.zzhm.zzk(r13, r8)
            r14.zza(r10, r8)
            goto L_0x0961
        L_0x0932:
            boolean r9 = r12.zza((T) r13, r7)
            if (r9 == 0) goto L_0x0961
            r8 = r8 & r6
            long r8 = (long) r8
            long r8 = com.google.android.gms.internal.firebase-perf.zzhm.zzk(r13, r8)
            r14.zzi(r10, r8)
            goto L_0x0961
        L_0x0942:
            boolean r9 = r12.zza((T) r13, r7)
            if (r9 == 0) goto L_0x0961
            r8 = r8 & r6
            long r8 = (long) r8
            float r8 = com.google.android.gms.internal.firebase-perf.zzhm.zzm(r13, r8)
            r14.zza(r10, r8)
            goto L_0x0961
        L_0x0952:
            boolean r9 = r12.zza((T) r13, r7)
            if (r9 == 0) goto L_0x0961
            r8 = r8 & r6
            long r8 = (long) r8
            double r8 = com.google.android.gms.internal.firebase-perf.zzhm.zzn(r13, r8)
            r14.zza(r10, r8)
        L_0x0961:
            int r7 = r7 + 3
            goto L_0x04e9
        L_0x0965:
            com.google.android.gms.internal.firebase-perf.zzeg<?> r13 = r12.zztq
            r13.zzb(r0)
            throw r3
        L_0x096b:
            if (r0 != 0) goto L_0x0973
            com.google.android.gms.internal.firebase-perf.zzhg<?, ?> r0 = r12.zztp
            zza(r0, (T) r13, r14)
            return
        L_0x0973:
            com.google.android.gms.internal.firebase-perf.zzeg<?> r13 = r12.zztq
            r13.zza(r14, r0)
            throw r3
        L_0x0979:
            r12.zzb((T) r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase-perf.zzgb.zza(java.lang.Object, com.google.android.gms.internal.firebase-perf.zzia):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:167:0x046b  */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x0471  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0030  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzb(T r18, com.google.android.gms.internal.firebase-perf.zzia r19) throws java.io.IOException {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            boolean r3 = r0.zztg
            if (r3 == 0) goto L_0x0023
            com.google.android.gms.internal.firebase-perf.zzeg<?> r3 = r0.zztq
            com.google.android.gms.internal.firebase-perf.zzeh r3 = r3.zzc(r1)
            com.google.android.gms.internal.firebase-perf.zzgp<FieldDescriptorType, java.lang.Object> r5 = r3.zznp
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
            int[] r6 = r0.zztb
            int r6 = r6.length
            sun.misc.Unsafe r7 = zzta
            r8 = 0
            r5 = 0
            r9 = -1
            r10 = 0
        L_0x002e:
            if (r5 >= r6) goto L_0x0468
            int r11 = r0.zzar(r5)
            int[] r12 = r0.zztb
            r13 = r12[r5]
            r14 = 267386880(0xff00000, float:2.3665827E-29)
            r14 = r14 & r11
            int r14 = r14 >>> 20
            boolean r15 = r0.zzti
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
            com.google.android.gms.internal.firebase-perf.zzgo r9 = r0.zzap(r5)
            r2.zzb(r13, r4, r9)
            goto L_0x045c
        L_0x007c:
            boolean r4 = r0.zza((T) r1, r13, r5)
            if (r4 == 0) goto L_0x045c
            long r11 = zzh(r1, r11)
            r2.zzb(r13, r11)
            goto L_0x045c
        L_0x008b:
            boolean r4 = r0.zza((T) r1, r13, r5)
            if (r4 == 0) goto L_0x045c
            int r4 = zzg(r1, r11)
            r2.zzi(r13, r4)
            goto L_0x045c
        L_0x009a:
            boolean r4 = r0.zza((T) r1, r13, r5)
            if (r4 == 0) goto L_0x045c
            long r11 = zzh(r1, r11)
            r2.zzj(r13, r11)
            goto L_0x045c
        L_0x00a9:
            boolean r4 = r0.zza((T) r1, r13, r5)
            if (r4 == 0) goto L_0x045c
            int r4 = zzg(r1, r11)
            r2.zzq(r13, r4)
            goto L_0x045c
        L_0x00b8:
            boolean r4 = r0.zza((T) r1, r13, r5)
            if (r4 == 0) goto L_0x045c
            int r4 = zzg(r1, r11)
            r2.zzr(r13, r4)
            goto L_0x045c
        L_0x00c7:
            boolean r4 = r0.zza((T) r1, r13, r5)
            if (r4 == 0) goto L_0x045c
            int r4 = zzg(r1, r11)
            r2.zzh(r13, r4)
            goto L_0x045c
        L_0x00d6:
            boolean r4 = r0.zza((T) r1, r13, r5)
            if (r4 == 0) goto L_0x045c
            java.lang.Object r4 = r7.getObject(r1, r11)
            com.google.android.gms.internal.firebase-perf.zzdl r4 = (com.google.android.gms.internal.firebase-perf.zzdl) r4
            r2.zza(r13, r4)
            goto L_0x045c
        L_0x00e7:
            boolean r4 = r0.zza((T) r1, r13, r5)
            if (r4 == 0) goto L_0x045c
            java.lang.Object r4 = r7.getObject(r1, r11)
            com.google.android.gms.internal.firebase-perf.zzgo r9 = r0.zzap(r5)
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
            boolean r4 = zzi(r1, r11)
            r2.zza(r13, r4)
            goto L_0x045c
        L_0x0118:
            boolean r4 = r0.zza((T) r1, r13, r5)
            if (r4 == 0) goto L_0x045c
            int r4 = zzg(r1, r11)
            r2.zzj(r13, r4)
            goto L_0x045c
        L_0x0127:
            boolean r4 = r0.zza((T) r1, r13, r5)
            if (r4 == 0) goto L_0x045c
            long r11 = zzh(r1, r11)
            r2.zzc(r13, r11)
            goto L_0x045c
        L_0x0136:
            boolean r4 = r0.zza((T) r1, r13, r5)
            if (r4 == 0) goto L_0x045c
            int r4 = zzg(r1, r11)
            r2.zzg(r13, r4)
            goto L_0x045c
        L_0x0145:
            boolean r4 = r0.zza((T) r1, r13, r5)
            if (r4 == 0) goto L_0x045c
            long r11 = zzh(r1, r11)
            r2.zza(r13, r11)
            goto L_0x045c
        L_0x0154:
            boolean r4 = r0.zza((T) r1, r13, r5)
            if (r4 == 0) goto L_0x045c
            long r11 = zzh(r1, r11)
            r2.zzi(r13, r11)
            goto L_0x045c
        L_0x0163:
            boolean r4 = r0.zza((T) r1, r13, r5)
            if (r4 == 0) goto L_0x045c
            float r4 = zzf(r1, r11)
            r2.zza(r13, r4)
            goto L_0x045c
        L_0x0172:
            boolean r4 = r0.zza((T) r1, r13, r5)
            if (r4 == 0) goto L_0x045c
            double r11 = zze((T) r1, r11)
            r2.zza(r13, r11)
            goto L_0x045c
        L_0x0181:
            java.lang.Object r4 = r7.getObject(r1, r11)
            r0.zza(r2, r13, r4, r5)
            goto L_0x045c
        L_0x018a:
            int[] r4 = r0.zztb
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase-perf.zzgo r11 = r0.zzap(r5)
            com.google.android.gms.internal.firebase-perf.zzgq.zzb(r4, r9, r2, r11)
            goto L_0x045c
        L_0x019d:
            int[] r9 = r0.zztb
            r9 = r9[r5]
            java.lang.Object r11 = r7.getObject(r1, r11)
            java.util.List r11 = (java.util.List) r11
            com.google.android.gms.internal.firebase-perf.zzgq.zze(r9, r11, r2, r4)
            goto L_0x045c
        L_0x01ac:
            int[] r9 = r0.zztb
            r9 = r9[r5]
            java.lang.Object r11 = r7.getObject(r1, r11)
            java.util.List r11 = (java.util.List) r11
            com.google.android.gms.internal.firebase-perf.zzgq.zzj(r9, r11, r2, r4)
            goto L_0x045c
        L_0x01bb:
            int[] r9 = r0.zztb
            r9 = r9[r5]
            java.lang.Object r11 = r7.getObject(r1, r11)
            java.util.List r11 = (java.util.List) r11
            com.google.android.gms.internal.firebase-perf.zzgq.zzg(r9, r11, r2, r4)
            goto L_0x045c
        L_0x01ca:
            int[] r9 = r0.zztb
            r9 = r9[r5]
            java.lang.Object r11 = r7.getObject(r1, r11)
            java.util.List r11 = (java.util.List) r11
            com.google.android.gms.internal.firebase-perf.zzgq.zzl(r9, r11, r2, r4)
            goto L_0x045c
        L_0x01d9:
            int[] r9 = r0.zztb
            r9 = r9[r5]
            java.lang.Object r11 = r7.getObject(r1, r11)
            java.util.List r11 = (java.util.List) r11
            com.google.android.gms.internal.firebase-perf.zzgq.zzm(r9, r11, r2, r4)
            goto L_0x045c
        L_0x01e8:
            int[] r9 = r0.zztb
            r9 = r9[r5]
            java.lang.Object r11 = r7.getObject(r1, r11)
            java.util.List r11 = (java.util.List) r11
            com.google.android.gms.internal.firebase-perf.zzgq.zzi(r9, r11, r2, r4)
            goto L_0x045c
        L_0x01f7:
            int[] r9 = r0.zztb
            r9 = r9[r5]
            java.lang.Object r11 = r7.getObject(r1, r11)
            java.util.List r11 = (java.util.List) r11
            com.google.android.gms.internal.firebase-perf.zzgq.zzn(r9, r11, r2, r4)
            goto L_0x045c
        L_0x0206:
            int[] r9 = r0.zztb
            r9 = r9[r5]
            java.lang.Object r11 = r7.getObject(r1, r11)
            java.util.List r11 = (java.util.List) r11
            com.google.android.gms.internal.firebase-perf.zzgq.zzk(r9, r11, r2, r4)
            goto L_0x045c
        L_0x0215:
            int[] r9 = r0.zztb
            r9 = r9[r5]
            java.lang.Object r11 = r7.getObject(r1, r11)
            java.util.List r11 = (java.util.List) r11
            com.google.android.gms.internal.firebase-perf.zzgq.zzf(r9, r11, r2, r4)
            goto L_0x045c
        L_0x0224:
            int[] r9 = r0.zztb
            r9 = r9[r5]
            java.lang.Object r11 = r7.getObject(r1, r11)
            java.util.List r11 = (java.util.List) r11
            com.google.android.gms.internal.firebase-perf.zzgq.zzh(r9, r11, r2, r4)
            goto L_0x045c
        L_0x0233:
            int[] r9 = r0.zztb
            r9 = r9[r5]
            java.lang.Object r11 = r7.getObject(r1, r11)
            java.util.List r11 = (java.util.List) r11
            com.google.android.gms.internal.firebase-perf.zzgq.zzd(r9, r11, r2, r4)
            goto L_0x045c
        L_0x0242:
            int[] r9 = r0.zztb
            r9 = r9[r5]
            java.lang.Object r11 = r7.getObject(r1, r11)
            java.util.List r11 = (java.util.List) r11
            com.google.android.gms.internal.firebase-perf.zzgq.zzc(r9, r11, r2, r4)
            goto L_0x045c
        L_0x0251:
            int[] r9 = r0.zztb
            r9 = r9[r5]
            java.lang.Object r11 = r7.getObject(r1, r11)
            java.util.List r11 = (java.util.List) r11
            com.google.android.gms.internal.firebase-perf.zzgq.zzb(r9, r11, r2, r4)
            goto L_0x045c
        L_0x0260:
            int[] r9 = r0.zztb
            r9 = r9[r5]
            java.lang.Object r11 = r7.getObject(r1, r11)
            java.util.List r11 = (java.util.List) r11
            com.google.android.gms.internal.firebase-perf.zzgq.zza(r9, r11, r2, r4)
            goto L_0x045c
        L_0x026f:
            int[] r4 = r0.zztb
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase-perf.zzgq.zze(r4, r9, r2, r8)
            goto L_0x045c
        L_0x027e:
            int[] r4 = r0.zztb
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase-perf.zzgq.zzj(r4, r9, r2, r8)
            goto L_0x045c
        L_0x028d:
            int[] r4 = r0.zztb
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase-perf.zzgq.zzg(r4, r9, r2, r8)
            goto L_0x045c
        L_0x029c:
            int[] r4 = r0.zztb
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase-perf.zzgq.zzl(r4, r9, r2, r8)
            goto L_0x045c
        L_0x02ab:
            int[] r4 = r0.zztb
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase-perf.zzgq.zzm(r4, r9, r2, r8)
            goto L_0x045c
        L_0x02ba:
            int[] r4 = r0.zztb
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase-perf.zzgq.zzi(r4, r9, r2, r8)
            goto L_0x045c
        L_0x02c9:
            int[] r4 = r0.zztb
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase-perf.zzgq.zzb(r4, r9, r2)
            goto L_0x045c
        L_0x02d8:
            int[] r4 = r0.zztb
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase-perf.zzgo r11 = r0.zzap(r5)
            com.google.android.gms.internal.firebase-perf.zzgq.zza(r4, r9, r2, r11)
            goto L_0x045c
        L_0x02eb:
            int[] r4 = r0.zztb
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase-perf.zzgq.zza(r4, r9, r2)
            goto L_0x045c
        L_0x02fa:
            int[] r4 = r0.zztb
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase-perf.zzgq.zzn(r4, r9, r2, r8)
            goto L_0x045c
        L_0x0309:
            int[] r4 = r0.zztb
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase-perf.zzgq.zzk(r4, r9, r2, r8)
            goto L_0x045c
        L_0x0318:
            int[] r4 = r0.zztb
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase-perf.zzgq.zzf(r4, r9, r2, r8)
            goto L_0x045c
        L_0x0327:
            int[] r4 = r0.zztb
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase-perf.zzgq.zzh(r4, r9, r2, r8)
            goto L_0x045c
        L_0x0336:
            int[] r4 = r0.zztb
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase-perf.zzgq.zzd(r4, r9, r2, r8)
            goto L_0x045c
        L_0x0345:
            int[] r4 = r0.zztb
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase-perf.zzgq.zzc(r4, r9, r2, r8)
            goto L_0x045c
        L_0x0354:
            int[] r4 = r0.zztb
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase-perf.zzgq.zzb(r4, r9, r2, r8)
            goto L_0x045c
        L_0x0363:
            int[] r4 = r0.zztb
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase-perf.zzgq.zza(r4, r9, r2, r8)
            goto L_0x045c
        L_0x0372:
            r4 = r10 & r9
            if (r4 == 0) goto L_0x045c
            java.lang.Object r4 = r7.getObject(r1, r11)
            com.google.android.gms.internal.firebase-perf.zzgo r9 = r0.zzap(r5)
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
            r2.zzi(r13, r4)
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
            r2.zzq(r13, r4)
            goto L_0x045c
        L_0x03b7:
            r4 = r10 & r9
            if (r4 == 0) goto L_0x045c
            int r4 = r7.getInt(r1, r11)
            r2.zzr(r13, r4)
            goto L_0x045c
        L_0x03c4:
            r4 = r10 & r9
            if (r4 == 0) goto L_0x045c
            int r4 = r7.getInt(r1, r11)
            r2.zzh(r13, r4)
            goto L_0x045c
        L_0x03d1:
            r4 = r10 & r9
            if (r4 == 0) goto L_0x045c
            java.lang.Object r4 = r7.getObject(r1, r11)
            com.google.android.gms.internal.firebase-perf.zzdl r4 = (com.google.android.gms.internal.firebase-perf.zzdl) r4
            r2.zza(r13, r4)
            goto L_0x045c
        L_0x03e0:
            r4 = r10 & r9
            if (r4 == 0) goto L_0x045c
            java.lang.Object r4 = r7.getObject(r1, r11)
            com.google.android.gms.internal.firebase-perf.zzgo r9 = r0.zzap(r5)
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
            boolean r4 = com.google.android.gms.internal.firebase-perf.zzhm.zzl(r1, r11)
            r2.zza(r13, r4)
            goto L_0x045c
        L_0x0409:
            r4 = r10 & r9
            if (r4 == 0) goto L_0x045c
            int r4 = r7.getInt(r1, r11)
            r2.zzj(r13, r4)
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
            r2.zzg(r13, r4)
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
            float r4 = com.google.android.gms.internal.firebase-perf.zzhm.zzm(r1, r11)
            r2.zza(r13, r4)
            goto L_0x045c
        L_0x0451:
            r4 = r10 & r9
            if (r4 == 0) goto L_0x045c
            double r11 = com.google.android.gms.internal.firebase-perf.zzhm.zzn(r1, r11)
            r2.zza(r13, r11)
        L_0x045c:
            int r5 = r5 + 3
            r9 = r15
            goto L_0x002e
        L_0x0461:
            com.google.android.gms.internal.firebase-perf.zzeg<?> r1 = r0.zztq
            r1.zzb(r3)
            r4 = 0
            throw r4
        L_0x0468:
            r4 = 0
            if (r3 != 0) goto L_0x0471
            com.google.android.gms.internal.firebase-perf.zzhg<?, ?> r3 = r0.zztp
            zza(r3, (T) r1, r2)
            return
        L_0x0471:
            com.google.android.gms.internal.firebase-perf.zzeg<?> r1 = r0.zztq
            r1.zza(r2, r3)
            goto L_0x0478
        L_0x0477:
            throw r4
        L_0x0478:
            goto L_0x0477
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase-perf.zzgb.zzb(java.lang.Object, com.google.android.gms.internal.firebase-perf.zzia):void");
    }

    private final <K, V> void zza(zzia zzia, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            zzia.zza(i, this.zztr.zzi(zzaq(i2)), this.zztr.zzj(obj));
        }
    }

    private static <UT, UB> void zza(zzhg<UT, UB> zzhg, T t, zzia zzia) throws IOException {
        zzhg.zza(zzhg.zzo(t), zzia);
    }

    private final zzgo zzap(int i) {
        int i2 = (i / 3) << 1;
        zzgo zzgo = (zzgo) this.zztc[i2];
        if (zzgo != null) {
            return zzgo;
        }
        zzgo zze = zzgj.zzio().zze((Class) this.zztc[i2 + 1]);
        this.zztc[i2] = zze;
        return zze;
    }

    private final Object zzaq(int i) {
        return this.zztc[(i / 3) << 1];
    }

    public final void zze(T t) {
        int i;
        int i2 = this.zztl;
        while (true) {
            i = this.zztm;
            if (i2 >= i) {
                break;
            }
            long zzar = (long) (zzar(this.zztk[i2]) & 1048575);
            Object zzo = zzhm.zzo(t, zzar);
            if (zzo != null) {
                zzhm.zza((Object) t, zzar, this.zztr.zzk(zzo));
            }
            i2++;
        }
        int length = this.zztk.length;
        while (i < length) {
            this.zzto.zza(t, (long) this.zztk[i]);
            i++;
        }
        this.zztp.zze(t);
        if (this.zztg) {
            this.zztq.zze((Object) t);
        }
    }

    public final boolean zzm(T t) {
        int i;
        int i2 = 0;
        int i3 = -1;
        int i4 = 0;
        while (true) {
            boolean z = true;
            if (i2 >= this.zztl) {
                return !this.zztg || this.zztq.zzc(t).isInitialized();
            }
            int i5 = this.zztk[i2];
            int i6 = this.zztb[i5];
            int zzar = zzar(i5);
            if (!this.zzti) {
                int i7 = this.zztb[i5 + 2];
                int i8 = i7 & 1048575;
                i = 1 << (i7 >>> 20);
                if (i8 != i3) {
                    i4 = zzta.getInt(t, (long) i8);
                    i3 = i8;
                }
            } else {
                i = 0;
            }
            if (((268435456 & zzar) != 0) && !zza(t, i5, i4, i)) {
                return false;
            }
            int i9 = (267386880 & zzar) >>> 20;
            if (i9 != 9 && i9 != 17) {
                if (i9 != 27) {
                    if (i9 == 60 || i9 == 68) {
                        if (zza(t, i6, i5) && !zza((Object) t, zzar, zzap(i5))) {
                            return false;
                        }
                    } else if (i9 != 49) {
                        if (i9 != 50) {
                            continue;
                        } else {
                            Map zzj = this.zztr.zzj(zzhm.zzo(t, (long) (zzar & 1048575)));
                            if (!zzj.isEmpty()) {
                                if (this.zztr.zzi(zzaq(i5)).zzsv.zzjn() == zzhx.MESSAGE) {
                                    zzgo zzgo = null;
                                    Iterator it = zzj.values().iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        Object next = it.next();
                                        if (zzgo == null) {
                                            zzgo = zzgj.zzio().zze(next.getClass());
                                        }
                                        if (!zzgo.zzm(next)) {
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
                List list = (List) zzhm.zzo(t, (long) (zzar & 1048575));
                if (!list.isEmpty()) {
                    zzgo zzap = zzap(i5);
                    int i10 = 0;
                    while (true) {
                        if (i10 >= list.size()) {
                            break;
                        } else if (!zzap.zzm(list.get(i10))) {
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
            } else if (zza(t, i5, i4, i) && !zza((Object) t, zzar, zzap(i5))) {
                return false;
            }
            i2++;
        }
    }

    private static boolean zza(Object obj, int i, zzgo zzgo) {
        return zzgo.zzm(zzhm.zzo(obj, (long) (i & 1048575)));
    }

    private static void zza(int i, Object obj, zzia zzia) throws IOException {
        if (obj instanceof String) {
            zzia.zzb(i, (String) obj);
        } else {
            zzia.zza(i, (zzdl) obj);
        }
    }

    private final int zzar(int i) {
        return this.zztb[i + 1];
    }

    private final int zzas(int i) {
        return this.zztb[i + 2];
    }

    private static <T> double zze(T t, long j) {
        return ((Double) zzhm.zzo(t, j)).doubleValue();
    }

    private static <T> float zzf(T t, long j) {
        return ((Float) zzhm.zzo(t, j)).floatValue();
    }

    private static <T> int zzg(T t, long j) {
        return ((Integer) zzhm.zzo(t, j)).intValue();
    }

    private static <T> long zzh(T t, long j) {
        return ((Long) zzhm.zzo(t, j)).longValue();
    }

    private static <T> boolean zzi(T t, long j) {
        return ((Boolean) zzhm.zzo(t, j)).booleanValue();
    }

    private final boolean zzc(T t, T t2, int i) {
        return zza(t, i) == zza(t2, i);
    }

    private final boolean zza(T t, int i, int i2, int i3) {
        if (this.zzti) {
            return zza(t, i);
        }
        return (i2 & i3) != 0;
    }

    private final boolean zza(T t, int i) {
        if (this.zzti) {
            int zzar = zzar(i);
            long j = (long) (zzar & 1048575);
            switch ((zzar & 267386880) >>> 20) {
                case 0:
                    return zzhm.zzn(t, j) != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                case 1:
                    return zzhm.zzm(t, j) != 0.0f;
                case 2:
                    return zzhm.zzk(t, j) != 0;
                case 3:
                    return zzhm.zzk(t, j) != 0;
                case 4:
                    return zzhm.zzj(t, j) != 0;
                case 5:
                    return zzhm.zzk(t, j) != 0;
                case 6:
                    return zzhm.zzj(t, j) != 0;
                case 7:
                    return zzhm.zzl(t, j);
                case 8:
                    Object zzo = zzhm.zzo(t, j);
                    if (zzo instanceof String) {
                        return !((String) zzo).isEmpty();
                    }
                    if (zzo instanceof zzdl) {
                        return !zzdl.zzmt.equals(zzo);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return zzhm.zzo(t, j) != null;
                case 10:
                    return !zzdl.zzmt.equals(zzhm.zzo(t, j));
                case 11:
                    return zzhm.zzj(t, j) != 0;
                case 12:
                    return zzhm.zzj(t, j) != 0;
                case 13:
                    return zzhm.zzj(t, j) != 0;
                case 14:
                    return zzhm.zzk(t, j) != 0;
                case 15:
                    return zzhm.zzj(t, j) != 0;
                case 16:
                    return zzhm.zzk(t, j) != 0;
                case 17:
                    return zzhm.zzo(t, j) != null;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            int zzas = zzas(i);
            return (zzhm.zzj(t, (long) (zzas & 1048575)) & (1 << (zzas >>> 20))) != 0;
        }
    }

    private final void zzb(T t, int i) {
        if (!this.zzti) {
            int zzas = zzas(i);
            long j = (long) (zzas & 1048575);
            zzhm.zza((Object) t, j, zzhm.zzj(t, j) | (1 << (zzas >>> 20)));
        }
    }

    private final boolean zza(T t, int i, int i2) {
        return zzhm.zzj(t, (long) (zzas(i2) & 1048575)) == i;
    }

    private final void zzb(T t, int i, int i2) {
        zzhm.zza((Object) t, (long) (zzas(i2) & 1048575), i);
    }
}
