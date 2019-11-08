package kotlin.coroutines;

import kotlin.Unit;
import kotlin.coroutines.CoroutineContext.Element;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$IntRef;
import org.jetbrains.annotations.NotNull;

final class CombinedContext$writeReplace$1 extends Lambda implements Function2<Unit, Element, Unit> {
    final /* synthetic */ CoroutineContext[] $elements;
    final /* synthetic */ Ref$IntRef $index;

    CombinedContext$writeReplace$1(CoroutineContext[] coroutineContextArr, Ref$IntRef ref$IntRef) {
        this.$elements = coroutineContextArr;
        this.$index = ref$IntRef;
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Unit) obj, (Element) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Unit unit, @NotNull Element element) {
        Intrinsics.checkParameterIsNotNull(unit, "<anonymous parameter 0>");
        Intrinsics.checkParameterIsNotNull(element, "element");
        CoroutineContext[] coroutineContextArr = this.$elements;
        Ref$IntRef ref$IntRef = this.$index;
        int i = ref$IntRef.element;
        ref$IntRef.element = i + 1;
        coroutineContextArr[i] = element;
    }
}
