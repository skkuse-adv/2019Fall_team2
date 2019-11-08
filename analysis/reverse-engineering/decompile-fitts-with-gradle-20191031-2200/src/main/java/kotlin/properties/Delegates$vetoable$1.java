package kotlin.properties;

import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;

public final class Delegates$vetoable$1 extends ObservableProperty<T> {
    final /* synthetic */ Function3 $onChange;

    public Delegates$vetoable$1(Function3 function3, Object obj, Object obj2) {
        this.$onChange = function3;
        super(obj2);
    }

    /* access modifiers changed from: protected */
    public boolean beforeChange(@NotNull KProperty<?> kProperty, T t, T t2) {
        Intrinsics.checkParameterIsNotNull(kProperty, "property");
        return ((Boolean) this.$onChange.invoke(kProperty, t, t2)).booleanValue();
    }
}
