package com.gun0912.tedpermission.util;

import java.util.List;
import java.util.Map;

public class ObjectUtils {
    public static boolean isEmpty(Object obj) {
        boolean z = true;
        if (obj == null) {
            return true;
        }
        if ((obj instanceof String) && ((String) obj).trim().length() == 0) {
            return true;
        }
        if (obj instanceof Map) {
            return ((Map) obj).isEmpty();
        }
        if (obj instanceof List) {
            return ((List) obj).isEmpty();
        }
        if (!(obj instanceof Object[])) {
            return false;
        }
        if (((Object[]) obj).length != 0) {
            z = false;
        }
        return z;
    }
}
