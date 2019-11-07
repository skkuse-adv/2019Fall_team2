package kotlin.text;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface MatchResult {

    public static final class DefaultImpls {
        @NotNull
        public static Destructured getDestructured(MatchResult matchResult) {
            return new Destructured(matchResult);
        }
    }

    public static final class Destructured {
        @NotNull
        private final MatchResult match;

        public Destructured(@NotNull MatchResult matchResult) {
            Intrinsics.checkParameterIsNotNull(matchResult, "match");
            this.match = matchResult;
        }

        @NotNull
        public final MatchResult getMatch() {
            return this.match;
        }

        @NotNull
        public final List<String> toList() {
            return this.match.getGroupValues().subList(1, this.match.getGroupValues().size());
        }
    }

    @NotNull
    Destructured getDestructured();

    @NotNull
    List<String> getGroupValues();

    @NotNull
    MatchGroupCollection getGroups();

    @NotNull
    IntRange getRange();

    @NotNull
    String getValue();

    @Nullable
    MatchResult next();
}
