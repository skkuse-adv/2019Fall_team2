package androidx.transition;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@RequiresApi(18)
class ViewGroupUtilsApi18 {
    private static final String TAG = "ViewUtilsApi18";
    private static Method sSuppressLayoutMethod;
    private static boolean sSuppressLayoutMethodFetched;

    static void suppressLayout(@NonNull ViewGroup viewGroup, boolean z) {
        fetchSuppressLayoutMethod();
        Method method = sSuppressLayoutMethod;
        if (method != null) {
            try {
                method.invoke(viewGroup, new Object[]{Boolean.valueOf(z)});
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
    }

    private static void fetchSuppressLayoutMethod() {
        if (!sSuppressLayoutMethodFetched) {
            try {
                sSuppressLayoutMethod = ViewGroup.class.getDeclaredMethod("suppressLayout", new Class[]{Boolean.TYPE});
                sSuppressLayoutMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            sSuppressLayoutMethodFetched = true;
        }
    }

    private ViewGroupUtilsApi18() {
    }
}
