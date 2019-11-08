package com.google.android.gms.internal.firebase_remote_config;

import java.util.Comparator;

final class zzbq implements Comparator<String> {
    zzbq(zzbr zzbr) {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        String str = (String) obj;
        String str2 = (String) obj2;
        if (str == str2 || (str != null && str.equals(str2))) {
            return 0;
        }
        if (str == null) {
            return -1;
        }
        if (str2 == null) {
            return 1;
        }
        return str.compareTo(str2);
    }
}
