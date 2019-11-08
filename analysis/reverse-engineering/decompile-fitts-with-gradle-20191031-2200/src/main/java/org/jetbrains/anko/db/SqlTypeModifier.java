package org.jetbrains.anko.db;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public interface SqlTypeModifier {
    public static final Companion Companion = Companion.$$INSTANCE;

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        @NotNull
        public final SqlTypeModifier create(@NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "modifier");
            return new SqlTypeModifierImpl(str);
        }
    }

    @NotNull
    String getModifier();
}
