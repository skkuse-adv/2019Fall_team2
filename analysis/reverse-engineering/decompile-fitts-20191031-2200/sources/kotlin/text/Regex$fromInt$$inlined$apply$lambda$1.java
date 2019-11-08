package kotlin.text;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

public final class Regex$fromInt$$inlined$apply$lambda$1 extends Lambda implements Function1<T, Boolean> {
    final /* synthetic */ int $value$inlined;

    public Regex$fromInt$$inlined$apply$lambda$1(int i) {
        this.$value$inlined = i;
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return Boolean.valueOf(invoke((T) (Enum) obj));
    }

    public final boolean invoke(T t) {
        FlagEnum flagEnum = (FlagEnum) t;
        return (this.$value$inlined & flagEnum.getMask()) == flagEnum.getValue();
    }
}
