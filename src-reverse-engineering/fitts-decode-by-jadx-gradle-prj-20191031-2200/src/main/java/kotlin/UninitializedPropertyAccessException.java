package kotlin;

import org.jetbrains.annotations.Nullable;

public final class UninitializedPropertyAccessException extends RuntimeException {
    public UninitializedPropertyAccessException() {
    }

    public UninitializedPropertyAccessException(@Nullable String str) {
        super(str);
    }

    public UninitializedPropertyAccessException(@Nullable String str, @Nullable Throwable th) {
        super(str, th);
    }

    public UninitializedPropertyAccessException(@Nullable Throwable th) {
        super(th);
    }
}
