package com.google.android.gms.internal.firebase_remote_config;

import java.io.IOException;
import kotlin.UByte;

final class zzft {
    static int zza(byte[] bArr, int i, zzfw zzfw) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return zza((int) b, bArr, i2, zzfw);
        }
        zzfw.zzor = b;
        return i2;
    }

    static int zza(int i, byte[] bArr, int i2, zzfw zzfw) {
        int i3 = i & 127;
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            zzfw.zzor = i3 | (b << 7);
            return i4;
        }
        int i5 = i3 | ((b & Byte.MAX_VALUE) << 7);
        int i6 = i4 + 1;
        byte b2 = bArr[i4];
        if (b2 >= 0) {
            zzfw.zzor = i5 | (b2 << 14);
            return i6;
        }
        int i7 = i5 | ((b2 & Byte.MAX_VALUE) << 14);
        int i8 = i6 + 1;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzfw.zzor = i7 | (b3 << 21);
            return i8;
        }
        int i9 = i7 | ((b3 & Byte.MAX_VALUE) << 21);
        int i10 = i8 + 1;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzfw.zzor = i9 | (b4 << 28);
            return i10;
        }
        int i11 = i9 | ((b4 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                zzfw.zzor = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    static int zzb(byte[] bArr, int i, zzfw zzfw) {
        int i2 = i + 1;
        long j = (long) bArr[i];
        if (j >= 0) {
            zzfw.zzos = j;
            return i2;
        }
        long j2 = j & 127;
        int i3 = i2 + 1;
        byte b = bArr[i2];
        long j3 = j2 | (((long) (b & Byte.MAX_VALUE)) << 7);
        int i4 = 7;
        while (b < 0) {
            int i5 = i3 + 1;
            byte b2 = bArr[i3];
            i4 += 7;
            j3 |= ((long) (b2 & Byte.MAX_VALUE)) << i4;
            int i6 = i5;
            b = b2;
            i3 = i6;
        }
        zzfw.zzos = j3;
        return i3;
    }

    static int zza(byte[] bArr, int i) {
        return ((bArr[i + 3] & UByte.MAX_VALUE) << 24) | (bArr[i] & UByte.MAX_VALUE) | ((bArr[i + 1] & UByte.MAX_VALUE) << 8) | ((bArr[i + 2] & UByte.MAX_VALUE) << 16);
    }

    static long zzb(byte[] bArr, int i) {
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    static double zzc(byte[] bArr, int i) {
        return Double.longBitsToDouble(zzb(bArr, i));
    }

    static float zzd(byte[] bArr, int i) {
        return Float.intBitsToFloat(zza(bArr, i));
    }

    static int zzc(byte[] bArr, int i, zzfw zzfw) throws zzhq {
        int zza = zza(bArr, i, zzfw);
        int i2 = zzfw.zzor;
        if (i2 < 0) {
            throw zzhq.zzhf();
        } else if (i2 == 0) {
            zzfw.zzot = "";
            return zza;
        } else {
            zzfw.zzot = new String(bArr, zza, i2, zzhm.UTF_8);
            return zza + i2;
        }
    }

    static int zzd(byte[] bArr, int i, zzfw zzfw) throws zzhq {
        int zza = zza(bArr, i, zzfw);
        int i2 = zzfw.zzor;
        if (i2 < 0) {
            throw zzhq.zzhf();
        } else if (i2 == 0) {
            zzfw.zzot = "";
            return zza;
        } else {
            zzfw.zzot = zzkg.zzg(bArr, zza, i2);
            return zza + i2;
        }
    }

    static int zze(byte[] bArr, int i, zzfw zzfw) throws zzhq {
        int zza = zza(bArr, i, zzfw);
        int i2 = zzfw.zzor;
        if (i2 < 0) {
            throw zzhq.zzhf();
        } else if (i2 > bArr.length - zza) {
            throw zzhq.zzhe();
        } else if (i2 == 0) {
            zzfw.zzot = zzfx.zzov;
            return zza;
        } else {
            zzfw.zzot = zzfx.zza(bArr, zza, i2);
            return zza + i2;
        }
    }

    /* JADX WARNING: type inference failed for: r8v2, types: [int] */
    /* JADX WARNING: type inference failed for: r8v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int zza(com.google.android.gms.internal.firebase_remote_config.zzjf r6, byte[] r7, int r8, int r9, com.google.android.gms.internal.firebase_remote_config.zzfw r10) throws java.io.IOException {
        /*
            int r0 = r8 + 1
            byte r8 = r7[r8]
            if (r8 >= 0) goto L_0x000c
            int r0 = zza(r8, r7, r0, r10)
            int r8 = r10.zzor
        L_0x000c:
            r3 = r0
            if (r8 < 0) goto L_0x0025
            int r9 = r9 - r3
            if (r8 > r9) goto L_0x0025
            java.lang.Object r9 = r6.newInstance()
            int r8 = r8 + r3
            r0 = r6
            r1 = r9
            r2 = r7
            r4 = r8
            r5 = r10
            r0.zza(r1, r2, r3, r4, r5)
            r6.zzm(r9)
            r10.zzot = r9
            return r8
        L_0x0025:
            com.google.android.gms.internal.firebase_remote_config.zzhq r6 = com.google.android.gms.internal.firebase_remote_config.zzhq.zzhe()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_remote_config.zzft.zza(com.google.android.gms.internal.firebase_remote_config.zzjf, byte[], int, int, com.google.android.gms.internal.firebase_remote_config.zzfw):int");
    }

    static int zza(zzjf zzjf, byte[] bArr, int i, int i2, int i3, zzfw zzfw) throws IOException {
        zziu zziu = (zziu) zzjf;
        Object newInstance = zziu.newInstance();
        int zza = zziu.zza(newInstance, bArr, i, i2, i3, zzfw);
        zziu.zzm(newInstance);
        zzfw.zzot = newInstance;
        return zza;
    }

    static int zza(int i, byte[] bArr, int i2, int i3, zzhn<?> zzhn, zzfw zzfw) {
        zzhk zzhk = (zzhk) zzhn;
        int zza = zza(bArr, i2, zzfw);
        zzhk.zzbb(zzfw.zzor);
        while (zza < i3) {
            int zza2 = zza(bArr, zza, zzfw);
            if (i != zzfw.zzor) {
                break;
            }
            zza = zza(bArr, zza2, zzfw);
            zzhk.zzbb(zzfw.zzor);
        }
        return zza;
    }

    static int zza(byte[] bArr, int i, zzhn<?> zzhn, zzfw zzfw) throws IOException {
        zzhk zzhk = (zzhk) zzhn;
        int zza = zza(bArr, i, zzfw);
        int i2 = zzfw.zzor + zza;
        while (zza < i2) {
            zza = zza(bArr, zza, zzfw);
            zzhk.zzbb(zzfw.zzor);
        }
        if (zza == i2) {
            return zza;
        }
        throw zzhq.zzhe();
    }

    static int zza(zzjf<?> zzjf, int i, byte[] bArr, int i2, int i3, zzhn<?> zzhn, zzfw zzfw) throws IOException {
        int zza = zza((zzjf) zzjf, bArr, i2, i3, zzfw);
        zzhn.add(zzfw.zzot);
        while (zza < i3) {
            int zza2 = zza(bArr, zza, zzfw);
            if (i != zzfw.zzor) {
                break;
            }
            zza = zza((zzjf) zzjf, bArr, zza2, i3, zzfw);
            zzhn.add(zzfw.zzot);
        }
        return zza;
    }

    static int zza(int i, byte[] bArr, int i2, int i3, zzka zzka, zzfw zzfw) throws zzhq {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                int zzb = zzb(bArr, i2, zzfw);
                zzka.zzb(i, (Object) Long.valueOf(zzfw.zzos));
                return zzb;
            } else if (i4 == 1) {
                zzka.zzb(i, (Object) Long.valueOf(zzb(bArr, i2)));
                return i2 + 8;
            } else if (i4 == 2) {
                int zza = zza(bArr, i2, zzfw);
                int i5 = zzfw.zzor;
                if (i5 < 0) {
                    throw zzhq.zzhf();
                } else if (i5 <= bArr.length - zza) {
                    if (i5 == 0) {
                        zzka.zzb(i, (Object) zzfx.zzov);
                    } else {
                        zzka.zzb(i, (Object) zzfx.zza(bArr, zza, i5));
                    }
                    return zza + i5;
                } else {
                    throw zzhq.zzhe();
                }
            } else if (i4 == 3) {
                zzka zzjb = zzka.zzjb();
                int i6 = (i & -8) | 4;
                int i7 = 0;
                while (true) {
                    if (i2 >= i3) {
                        break;
                    }
                    int zza2 = zza(bArr, i2, zzfw);
                    int i8 = zzfw.zzor;
                    i7 = i8;
                    if (i8 == i6) {
                        i2 = zza2;
                        break;
                    }
                    int zza3 = zza(i7, bArr, zza2, i3, zzjb, zzfw);
                    i7 = i8;
                    i2 = zza3;
                }
                if (i2 > i3 || i7 != i6) {
                    throw zzhq.zzhl();
                }
                zzka.zzb(i, (Object) zzjb);
                return i2;
            } else if (i4 == 5) {
                zzka.zzb(i, (Object) Integer.valueOf(zza(bArr, i2)));
                return i2 + 4;
            } else {
                throw zzhq.zzhh();
            }
        } else {
            throw zzhq.zzhh();
        }
    }

    static int zza(int i, byte[] bArr, int i2, int i3, zzfw zzfw) throws zzhq {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                return zzb(bArr, i2, zzfw);
            }
            if (i4 == 1) {
                return i2 + 8;
            }
            if (i4 == 2) {
                return zza(bArr, i2, zzfw) + zzfw.zzor;
            }
            if (i4 == 3) {
                int i5 = (i & -8) | 4;
                int i6 = 0;
                while (i2 < i3) {
                    i2 = zza(bArr, i2, zzfw);
                    i6 = zzfw.zzor;
                    if (i6 == i5) {
                        break;
                    }
                    i2 = zza(i6, bArr, i2, i3, zzfw);
                }
                if (i2 <= i3 && i6 == i5) {
                    return i2;
                }
                throw zzhq.zzhl();
            } else if (i4 == 5) {
                return i2 + 4;
            } else {
                throw zzhq.zzhh();
            }
        } else {
            throw zzhq.zzhh();
        }
    }
}
