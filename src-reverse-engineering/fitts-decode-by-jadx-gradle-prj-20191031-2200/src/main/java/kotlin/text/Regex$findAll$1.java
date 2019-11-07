package kotlin.text;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

final class Regex$findAll$1 extends Lambda implements Function0<MatchResult> {
    final /* synthetic */ CharSequence $input;
    final /* synthetic */ int $startIndex;
    final /* synthetic */ Regex this$0;

    Regex$findAll$1(Regex regex, CharSequence charSequence, int i) {
        this.this$0 = regex;
        this.$input = charSequence;
        this.$startIndex = i;
        super(0);
    }

    @Nullable
    public final MatchResult invoke() {
        return this.this$0.find(this.$input, this.$startIndex);
    }
}
