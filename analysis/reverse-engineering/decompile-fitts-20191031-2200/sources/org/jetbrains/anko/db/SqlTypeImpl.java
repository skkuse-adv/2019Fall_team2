package org.jetbrains.anko.db;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

class SqlTypeImpl implements SqlType {
    @Nullable
    private final String modifiers;
    @NotNull
    private final String name;

    public SqlTypeImpl(@NotNull String str, @Nullable String str2) {
        Intrinsics.checkParameterIsNotNull(str, "name");
        this.name = str;
        this.modifiers = str2;
    }

    public /* synthetic */ SqlTypeImpl(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        this(str, str2);
    }

    @Nullable
    public final String getModifiers() {
        return this.modifiers;
    }

    @NotNull
    public String getName() {
        return this.name;
    }

    @NotNull
    public String render() {
        if (this.modifiers == null) {
            return getName();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(getName());
        sb.append(' ');
        sb.append(this.modifiers);
        return sb.toString();
    }

    @NotNull
    public SqlType plus(@NotNull SqlTypeModifier sqlTypeModifier) {
        String str;
        Intrinsics.checkParameterIsNotNull(sqlTypeModifier, "m");
        String name2 = getName();
        if (this.modifiers == null) {
            str = sqlTypeModifier.getModifier();
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(this.modifiers);
            sb.append(' ');
            sb.append(sqlTypeModifier.getModifier());
            str = sb.toString();
        }
        return new SqlTypeImpl(name2, str);
    }
}
