package com.google.android.gms.internal.firebase_remote_config;

final class zzjt {
    static String zze(zzfx zzfx) {
        zzjw zzjw = new zzjw(zzfx);
        StringBuilder sb = new StringBuilder(zzjw.size());
        for (int i = 0; i < zzjw.size(); i++) {
            byte zzv = zzjw.zzv(i);
            if (zzv == 34) {
                sb.append("\\\"");
            } else if (zzv == 39) {
                sb.append("\\'");
            } else if (zzv != 92) {
                switch (zzv) {
                    case 7:
                        sb.append("\\a");
                        break;
                    case 8:
                        sb.append("\\b");
                        break;
                    case 9:
                        sb.append("\\t");
                        break;
                    case 10:
                        sb.append("\\n");
                        break;
                    case 11:
                        sb.append("\\v");
                        break;
                    case 12:
                        sb.append("\\f");
                        break;
                    case 13:
                        sb.append("\\r");
                        break;
                    default:
                        if (zzv >= 32 && zzv <= 126) {
                            sb.append((char) zzv);
                            break;
                        } else {
                            sb.append('\\');
                            sb.append((char) (((zzv >>> 6) & 3) + 48));
                            sb.append((char) (((zzv >>> 3) & 7) + 48));
                            sb.append((char) ((zzv & 7) + 48));
                            break;
                        }
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }
}
