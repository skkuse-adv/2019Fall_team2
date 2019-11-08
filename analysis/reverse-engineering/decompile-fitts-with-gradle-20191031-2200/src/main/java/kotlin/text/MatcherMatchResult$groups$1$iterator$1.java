package kotlin.text;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

final class MatcherMatchResult$groups$1$iterator$1 extends Lambda implements Function1<Integer, MatchGroup> {
    final /* synthetic */ MatcherMatchResult$groups$1 this$0;

    MatcherMatchResult$groups$1$iterator$1(MatcherMatchResult$groups$1 matcherMatchResult$groups$1) {
        this.this$0 = matcherMatchResult$groups$1;
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).intValue());
    }

    @Nullable
    public final MatchGroup invoke(int i) {
        return this.this$0.get(i);
    }
}
