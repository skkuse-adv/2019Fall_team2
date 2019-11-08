package kotlin.text;

import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.MatchResult.DefaultImpls;
import kotlin.text.MatchResult.Destructured;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class MatcherMatchResult implements MatchResult {
    private List<String> groupValues_;
    @NotNull
    private final MatchGroupCollection groups = new MatcherMatchResult$groups$1(this);
    private final CharSequence input;
    private final Matcher matcher;

    public MatcherMatchResult(@NotNull Matcher matcher2, @NotNull CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(matcher2, "matcher");
        Intrinsics.checkParameterIsNotNull(charSequence, "input");
        this.matcher = matcher2;
        this.input = charSequence;
    }

    @NotNull
    public Destructured getDestructured() {
        return DefaultImpls.getDestructured(this);
    }

    /* access modifiers changed from: private */
    public final MatchResult getMatchResult() {
        return this.matcher;
    }

    @NotNull
    public IntRange getRange() {
        return RegexKt.range(getMatchResult());
    }

    @NotNull
    public String getValue() {
        String group = getMatchResult().group();
        Intrinsics.checkExpressionValueIsNotNull(group, "matchResult.group()");
        return group;
    }

    @NotNull
    public MatchGroupCollection getGroups() {
        return this.groups;
    }

    @NotNull
    public List<String> getGroupValues() {
        if (this.groupValues_ == null) {
            this.groupValues_ = new MatcherMatchResult$groupValues$1(this);
        }
        List<String> list = this.groupValues_;
        if (list == null) {
            Intrinsics.throwNpe();
        }
        return list;
    }

    @Nullable
    public MatchResult next() {
        int end = getMatchResult().end() + (getMatchResult().end() == getMatchResult().start() ? 1 : 0);
        if (end > this.input.length()) {
            return null;
        }
        Matcher matcher2 = this.matcher.pattern().matcher(this.input);
        Intrinsics.checkExpressionValueIsNotNull(matcher2, "matcher.pattern().matcher(input)");
        return RegexKt.findNext(matcher2, end, this.input);
    }
}
