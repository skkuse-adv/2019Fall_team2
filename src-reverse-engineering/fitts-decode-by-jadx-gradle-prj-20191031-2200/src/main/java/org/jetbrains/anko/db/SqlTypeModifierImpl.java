package org.jetbrains.anko.db;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

class SqlTypeModifierImpl implements SqlTypeModifier {
    @NotNull
    private final String modifier;

    public SqlTypeModifierImpl(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "modifier");
        this.modifier = str;
    }

    @NotNull
    public String getModifier() {
        return this.modifier;
    }
}
