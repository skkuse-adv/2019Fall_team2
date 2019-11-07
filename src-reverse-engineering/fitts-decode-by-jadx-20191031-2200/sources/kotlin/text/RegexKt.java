package kotlin.text;

import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;

public final class RegexKt {
    /* access modifiers changed from: private */
    public static final MatchResult findNext(@NotNull Matcher matcher, int i, CharSequence charSequence) {
        if (!matcher.find(i)) {
            return null;
        }
        return new MatcherMatchResult(matcher, charSequence);
    }

    /* access modifiers changed from: private */
    public static final MatchResult matchEntire(@NotNull Matcher matcher, CharSequence charSequence) {
        if (!matcher.matches()) {
            return null;
        }
        return new MatcherMatchResult(matcher, charSequence);
    }

    /* access modifiers changed from: private */
    public static final IntRange range(@NotNull MatchResult matchResult) {
        return RangesKt___RangesKt.until(matchResult.start(), matchResult.end());
    }

    /* access modifiers changed from: private */
    public static final IntRange range(@NotNull MatchResult matchResult, int i) {
        return RangesKt___RangesKt.until(matchResult.start(i), matchResult.end(i));
    }

    /* access modifiers changed from: private */
    public static final int toInt(@NotNull Iterable<? extends FlagEnum> iterable) {
        int i = 0;
        for (FlagEnum value : iterable) {
            i |= value.getValue();
        }
        return i;
    }
}
