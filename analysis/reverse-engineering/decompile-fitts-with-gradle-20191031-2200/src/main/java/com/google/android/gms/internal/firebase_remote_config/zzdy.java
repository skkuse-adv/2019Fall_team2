package com.google.android.gms.internal.firebase_remote_config;

import java.util.logging.Level;
import java.util.logging.Logger;

public final class zzdy {
    public static boolean zzbc(String str) {
        return zzdp.zzbb(str);
    }

    public static String zza(String str, Object... objArr) {
        String valueOf = String.valueOf(str);
        int i = 0;
        if (objArr == null) {
            objArr = new Object[]{"(Object[])null"};
        } else {
            for (int i2 = 0; i2 < objArr.length; i2++) {
                objArr[i2] = zzj(objArr[i2]);
            }
        }
        StringBuilder sb = new StringBuilder(valueOf.length() + (objArr.length * 16));
        int i3 = 0;
        while (i < objArr.length) {
            int indexOf = valueOf.indexOf("%s", i3);
            if (indexOf == -1) {
                break;
            }
            sb.append(valueOf, i3, indexOf);
            int i4 = i + 1;
            sb.append(objArr[i]);
            int i5 = i4;
            i3 = indexOf + 2;
            i = i5;
        }
        sb.append(valueOf, i3, valueOf.length());
        if (i < objArr.length) {
            sb.append(" [");
            int i6 = i + 1;
            sb.append(objArr[i]);
            while (i6 < objArr.length) {
                sb.append(", ");
                int i7 = i6 + 1;
                sb.append(objArr[i6]);
                i6 = i7;
            }
            sb.append(']');
        }
        return sb.toString();
    }

    private static String zzj(Object obj) {
        try {
            return String.valueOf(obj);
        } catch (Exception e) {
            String name = obj.getClass().getName();
            String hexString = Integer.toHexString(System.identityHashCode(obj));
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 1 + String.valueOf(hexString).length());
            sb.append(name);
            sb.append('@');
            sb.append(hexString);
            String sb2 = sb.toString();
            Logger logger = Logger.getLogger("com.google.common.base.Strings");
            Level level = Level.WARNING;
            String str = "Exception during lenientFormat for ";
            String valueOf = String.valueOf(sb2);
            logger.logp(level, "com.google.common.base.Strings", "lenientToString", valueOf.length() != 0 ? str.concat(valueOf) : new String(str), e);
            String name2 = e.getClass().getName();
            StringBuilder sb3 = new StringBuilder(String.valueOf(sb2).length() + 9 + String.valueOf(name2).length());
            sb3.append("<");
            sb3.append(sb2);
            sb3.append(" threw ");
            sb3.append(name2);
            sb3.append(">");
            return sb3.toString();
        }
    }
}
