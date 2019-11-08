package kotlin.jvm.internal;

import java.util.Arrays;
import java.util.List;
import kotlin.KotlinNullPointerException;
import kotlin.UninitializedPropertyAccessException;

public class Intrinsics {
    public static int compare(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i == i2 ? 0 : 1;
    }

    public static int compare(long j, long j2) {
        if (j < j2) {
            return -1;
        }
        return j == j2 ? 0 : 1;
    }

    private Intrinsics() {
    }

    public static String stringPlus(String str, Object obj) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(obj);
        return sb.toString();
    }

    public static void checkNotNull(Object obj) {
        if (obj == null) {
            throwNpe();
        }
    }

    public static void checkNotNull(Object obj, String str) {
        if (obj == null) {
            throwNpe(str);
        }
    }

    public static void throwNpe() {
        KotlinNullPointerException kotlinNullPointerException = new KotlinNullPointerException();
        sanitizeStackTrace(kotlinNullPointerException);
        throw kotlinNullPointerException;
    }

    public static void throwNpe(String str) {
        KotlinNullPointerException kotlinNullPointerException = new KotlinNullPointerException(str);
        sanitizeStackTrace(kotlinNullPointerException);
        throw kotlinNullPointerException;
    }

    public static void throwUninitializedProperty(String str) {
        UninitializedPropertyAccessException uninitializedPropertyAccessException = new UninitializedPropertyAccessException(str);
        sanitizeStackTrace(uninitializedPropertyAccessException);
        throw uninitializedPropertyAccessException;
    }

    public static void throwUninitializedPropertyAccessException(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("lateinit property ");
        sb.append(str);
        sb.append(" has not been initialized");
        throwUninitializedProperty(sb.toString());
    }

    public static void throwAssert() {
        AssertionError assertionError = new AssertionError();
        sanitizeStackTrace(assertionError);
        throw assertionError;
    }

    public static void throwAssert(String str) {
        AssertionError assertionError = new AssertionError(str);
        sanitizeStackTrace(assertionError);
        throw assertionError;
    }

    public static void throwIllegalArgument() {
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
        sanitizeStackTrace(illegalArgumentException);
        throw illegalArgumentException;
    }

    public static void throwIllegalArgument(String str) {
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(str);
        sanitizeStackTrace(illegalArgumentException);
        throw illegalArgumentException;
    }

    public static void throwIllegalState() {
        IllegalStateException illegalStateException = new IllegalStateException();
        sanitizeStackTrace(illegalStateException);
        throw illegalStateException;
    }

    public static void throwIllegalState(String str) {
        IllegalStateException illegalStateException = new IllegalStateException(str);
        sanitizeStackTrace(illegalStateException);
        throw illegalStateException;
    }

    public static void checkExpressionValueIsNotNull(Object obj, String str) {
        if (obj == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(" must not be null");
            IllegalStateException illegalStateException = new IllegalStateException(sb.toString());
            sanitizeStackTrace(illegalStateException);
            throw illegalStateException;
        }
    }

    public static void checkNotNullExpressionValue(Object obj, String str) {
        if (obj == null) {
            IllegalStateException illegalStateException = new IllegalStateException(str);
            sanitizeStackTrace(illegalStateException);
            throw illegalStateException;
        }
    }

    public static void checkReturnedValueIsNotNull(Object obj, String str, String str2) {
        if (obj == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Method specified as non-null returned null: ");
            sb.append(str);
            sb.append(".");
            sb.append(str2);
            IllegalStateException illegalStateException = new IllegalStateException(sb.toString());
            sanitizeStackTrace(illegalStateException);
            throw illegalStateException;
        }
    }

    public static void checkReturnedValueIsNotNull(Object obj, String str) {
        if (obj == null) {
            IllegalStateException illegalStateException = new IllegalStateException(str);
            sanitizeStackTrace(illegalStateException);
            throw illegalStateException;
        }
    }

    public static void checkFieldIsNotNull(Object obj, String str, String str2) {
        if (obj == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Field specified as non-null is null: ");
            sb.append(str);
            sb.append(".");
            sb.append(str2);
            IllegalStateException illegalStateException = new IllegalStateException(sb.toString());
            sanitizeStackTrace(illegalStateException);
            throw illegalStateException;
        }
    }

    public static void checkFieldIsNotNull(Object obj, String str) {
        if (obj == null) {
            IllegalStateException illegalStateException = new IllegalStateException(str);
            sanitizeStackTrace(illegalStateException);
            throw illegalStateException;
        }
    }

    public static void checkParameterIsNotNull(Object obj, String str) {
        if (obj == null) {
            throwParameterIsNullException(str);
            throw null;
        }
    }

    public static void checkNotNullParameter(Object obj, String str) {
        if (obj == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(str);
            sanitizeStackTrace(illegalArgumentException);
            throw illegalArgumentException;
        }
    }

    private static void throwParameterIsNullException(String str) {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
        String className = stackTraceElement.getClassName();
        String methodName = stackTraceElement.getMethodName();
        StringBuilder sb = new StringBuilder();
        sb.append("Parameter specified as non-null is null: method ");
        sb.append(className);
        sb.append(".");
        sb.append(methodName);
        sb.append(", parameter ");
        sb.append(str);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(sb.toString());
        sanitizeStackTrace(illegalArgumentException);
        throw illegalArgumentException;
    }

    public static boolean areEqual(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public static boolean areEqual(Double d, Double d2) {
        if (d == null) {
            if (d2 == null) {
                return true;
            }
        } else if (d2 != null && d.doubleValue() == d2.doubleValue()) {
            return true;
        }
        return false;
    }

    public static boolean areEqual(Double d, double d2) {
        return d != null && d.doubleValue() == d2;
    }

    public static boolean areEqual(double d, Double d2) {
        return d2 != null && d == d2.doubleValue();
    }

    public static boolean areEqual(Float f, Float f2) {
        if (f == null) {
            if (f2 == null) {
                return true;
            }
        } else if (f2 != null && f.floatValue() == f2.floatValue()) {
            return true;
        }
        return false;
    }

    public static boolean areEqual(Float f, float f2) {
        return f != null && f.floatValue() == f2;
    }

    public static boolean areEqual(float f, Float f2) {
        return f2 != null && f == f2.floatValue();
    }

    public static void throwUndefinedForReified() {
        throwUndefinedForReified("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
    }

    public static void throwUndefinedForReified(String str) {
        throw new UnsupportedOperationException(str);
    }

    public static void reifiedOperationMarker(int i, String str) {
        throwUndefinedForReified();
    }

    public static void reifiedOperationMarker(int i, String str, String str2) {
        throwUndefinedForReified(str2);
    }

    public static void needClassReification() {
        throwUndefinedForReified();
    }

    public static void needClassReification(String str) {
        throwUndefinedForReified(str);
    }

    public static void checkHasClass(String str) throws ClassNotFoundException {
        String replace = str.replace('/', '.');
        try {
            Class.forName(replace);
        } catch (ClassNotFoundException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Class ");
            sb.append(replace);
            sb.append(" is not found. Please update the Kotlin runtime to the latest version");
            ClassNotFoundException classNotFoundException = new ClassNotFoundException(sb.toString(), e);
            sanitizeStackTrace(classNotFoundException);
            throw classNotFoundException;
        }
    }

    public static void checkHasClass(String str, String str2) throws ClassNotFoundException {
        String replace = str.replace('/', '.');
        try {
            Class.forName(replace);
        } catch (ClassNotFoundException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Class ");
            sb.append(replace);
            sb.append(" is not found: this code requires the Kotlin runtime of version at least ");
            sb.append(str2);
            ClassNotFoundException classNotFoundException = new ClassNotFoundException(sb.toString(), e);
            sanitizeStackTrace(classNotFoundException);
            throw classNotFoundException;
        }
    }

    private static <T extends Throwable> T sanitizeStackTrace(T t) {
        sanitizeStackTrace(t, Intrinsics.class.getName());
        return t;
    }

    static <T extends Throwable> T sanitizeStackTrace(T t, String str) {
        StackTraceElement[] stackTrace = t.getStackTrace();
        int length = stackTrace.length;
        int i = -1;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.equals(stackTrace[i2].getClassName())) {
                i = i2;
            }
        }
        List subList = Arrays.asList(stackTrace).subList(i + 1, length);
        t.setStackTrace((StackTraceElement[]) subList.toArray(new StackTraceElement[subList.size()]));
        return t;
    }
}
