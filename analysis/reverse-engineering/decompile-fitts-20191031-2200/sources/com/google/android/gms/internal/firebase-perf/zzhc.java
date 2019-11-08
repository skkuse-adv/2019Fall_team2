package com.google.android.gms.internal.firebase-perf;

final class zzhc {
    static String zzd(zzdl zzdl) {
        zzhb zzhb = new zzhb(zzdl);
        StringBuilder sb = new StringBuilder(zzhb.size());
        for (int i = 0; i < zzhb.size(); i++) {
            byte zzq = zzhb.zzq(i);
            if (zzq == 34) {
                sb.append("\\\"");
            } else if (zzq == 39) {
                sb.append("\\'");
            } else if (zzq != 92) {
                switch (zzq) {
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
                        if (zzq >= 32 && zzq <= 126) {
                            sb.append((char) zzq);
                            break;
                        } else {
                            sb.append('\\');
                            sb.append((char) (((zzq >>> 6) & 3) + 48));
                            sb.append((char) (((zzq >>> 3) & 7) + 48));
                            sb.append((char) ((zzq & 7) + 48));
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
