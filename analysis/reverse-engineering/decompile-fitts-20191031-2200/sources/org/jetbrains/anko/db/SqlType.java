package org.jetbrains.anko.db;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public interface SqlType {
    public static final Companion Companion = Companion.$$INSTANCE;

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        @NotNull
        public final SqlType create(@NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "name");
            return new SqlTypeImpl(str, null, 2, null);
        }
    }

    @NotNull
    String getName();

    @NotNull
    SqlType plus(@NotNull SqlTypeModifier sqlTypeModifier);

    @NotNull
    String render();
}
