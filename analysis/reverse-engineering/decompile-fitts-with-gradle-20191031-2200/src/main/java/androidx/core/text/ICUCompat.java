package androidx.core.text;

import android.os.Build.VERSION;
import androidx.annotation.Nullable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

public final class ICUCompat {
    private static final String TAG = "ICUCompat";
    private static Method sAddLikelySubtagsMethod;
    private static Method sGetScriptMethod;

    static {
        String str = "addLikelySubtags";
        String str2 = "libcore.icu.ICU";
        if (VERSION.SDK_INT >= 21) {
            try {
                sAddLikelySubtagsMethod = Class.forName(str2).getMethod(str, new Class[]{Locale.class});
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        } else {
            try {
                Class cls = Class.forName(str2);
                if (cls != null) {
                    sGetScriptMethod = cls.getMethod("getScript", new Class[]{String.class});
                    sAddLikelySubtagsMethod = cls.getMethod(str, new Class[]{String.class});
                }
            } catch (Exception unused) {
                sGetScriptMethod = null;
                sAddLikelySubtagsMethod = null;
            }
        }
    }

    @Nullable
    public static String maximizeAndGetScript(Locale locale) {
        if (VERSION.SDK_INT >= 21) {
            try {
                return ((Locale) sAddLikelySubtagsMethod.invoke(null, new Object[]{locale})).getScript();
            } catch (IllegalAccessException | InvocationTargetException unused) {
                return locale.getScript();
            }
        } else {
            String addLikelySubtags = addLikelySubtags(locale);
            if (addLikelySubtags != null) {
                return getScript(addLikelySubtags);
            }
            return null;
        }
    }

    private static String getScript(String str) {
        try {
            if (sGetScriptMethod != null) {
                return (String) sGetScriptMethod.invoke(null, new Object[]{str});
            }
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
        return null;
    }

    private static String addLikelySubtags(Locale locale) {
        String locale2 = locale.toString();
        try {
            if (sAddLikelySubtagsMethod != null) {
                return (String) sAddLikelySubtagsMethod.invoke(null, new Object[]{locale2});
            }
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
        return locale2;
    }

    private ICUCompat() {
    }
}
