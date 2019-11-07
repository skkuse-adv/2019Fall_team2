package kotlin.properties;

import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;

public final class Delegates$observable$1 extends ObservableProperty<T> {
    final /* synthetic */ Function3 $onChange;

    public Delegates$observable$1(Function3 function3, Object obj, Object obj2) {
        this.$onChange = function3;
        super(obj2);
    }

    /* access modifiers changed from: protected */
    public void afterChange(@NotNull KProperty<?> kProperty, T t, T t2) {
        Intrinsics.checkParameterIsNotNull(kProperty, "property");
        this.$onChange.invoke(kProperty, t, t2);
    }
}
