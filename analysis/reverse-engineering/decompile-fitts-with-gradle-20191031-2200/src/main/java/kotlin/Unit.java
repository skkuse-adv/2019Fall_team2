package kotlin;

import org.jetbrains.annotations.NotNull;

public final class Unit {
    public static final Unit INSTANCE = new Unit();

    @NotNull
    public String toString() {
        return "kotlin.Unit";
    }

    private Unit() {
    }
}
