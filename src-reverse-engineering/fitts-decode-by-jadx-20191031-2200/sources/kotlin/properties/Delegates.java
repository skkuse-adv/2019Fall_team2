package kotlin.properties;

import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;

public final class Delegates {
    public static final Delegates INSTANCE = new Delegates();

    private Delegates() {
    }

    @NotNull
    public final <T> ReadWriteProperty<Object, T> notNull() {
        return new NotNullVar();
    }

    @NotNull
    public final <T> ReadWriteProperty<Object, T> observable(T t, @NotNull Function3<? super KProperty<?>, ? super T, ? super T, Unit> function3) {
        Intrinsics.checkParameterIsNotNull(function3, "onChange");
        return new Delegates$observable$1(function3, t, t);
    }

    @NotNull
    public final <T> ReadWriteProperty<Object, T> vetoable(T t, @NotNull Function3<? super KProperty<?>, ? super T, ? super T, Boolean> function3) {
        Intrinsics.checkParameterIsNotNull(function3, "onChange");
        return new Delegates$vetoable$1(function3, t, t);
    }
}
