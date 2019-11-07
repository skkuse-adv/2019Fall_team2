package kr.co.popone.fitts.ui;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class StringKeyGenerator {
    public static final Companion Companion = new Companion(null);

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String generate(@NotNull Class<?> cls, @NotNull String str) {
            Intrinsics.checkParameterIsNotNull(cls, "cls");
            Intrinsics.checkParameterIsNotNull(str, "name");
            StringBuilder sb = new StringBuilder();
            sb.append(cls.getSimpleName());
            sb.append('_');
            sb.append(str);
            return sb.toString();
        }
    }
}
