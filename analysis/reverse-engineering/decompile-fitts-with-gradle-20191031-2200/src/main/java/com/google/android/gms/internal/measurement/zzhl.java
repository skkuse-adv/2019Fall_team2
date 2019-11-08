package com.google.android.gms.internal.measurement;

final class zzhl {
    static String zzd(zzdp zzdp) {
        zzho zzho = new zzho(zzdp);
        StringBuilder sb = new StringBuilder(zzho.size());
        for (int i = 0; i < zzho.size(); i++) {
            byte zzaq = zzho.zzaq(i);
            if (zzaq == 34) {
                sb.append("\\\"");
            } else if (zzaq == 39) {
                sb.append("\\'");
            } else if (zzaq != 92) {
                switch (zzaq) {
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
                        if (zzaq >= 32 && zzaq <= 126) {
                            sb.append((char) zzaq);
                            break;
                        } else {
                            sb.append('\\');
                            sb.append((char) (((zzaq >>> 6) & 3) + 48));
                            sb.append((char) (((zzaq >>> 3) & 7) + 48));
                            sb.append((char) ((zzaq & 7) + 48));
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
