package kotlin.text;

import java.util.Iterator;
import kotlin.collections.AbstractCollection;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class MatcherMatchResult$groups$1 extends AbstractCollection<MatchGroup> implements MatchNamedGroupCollection {
    final /* synthetic */ MatcherMatchResult this$0;

    public boolean isEmpty() {
        return false;
    }

    MatcherMatchResult$groups$1(MatcherMatchResult matcherMatchResult) {
        this.this$0 = matcherMatchResult;
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (obj != null ? obj instanceof MatchGroup : true) {
            return contains((MatchGroup) obj);
        }
        return false;
    }

    public /* bridge */ boolean contains(MatchGroup matchGroup) {
        return super.contains(matchGroup);
    }

    public int getSize() {
        return this.this$0.getMatchResult().groupCount() + 1;
    }

    @NotNull
    public Iterator<MatchGroup> iterator() {
        return SequencesKt___SequencesKt.map(CollectionsKt___CollectionsKt.asSequence(CollectionsKt__CollectionsKt.getIndices(this)), new MatcherMatchResult$groups$1$iterator$1(this)).iterator();
    }

    @Nullable
    public MatchGroup get(int i) {
        IntRange access$range = RegexKt.range(this.this$0.getMatchResult(), i);
        if (access$range.getStart().intValue() < 0) {
            return null;
        }
        String group = this.this$0.getMatchResult().group(i);
        Intrinsics.checkExpressionValueIsNotNull(group, "matchResult.group(index)");
        return new MatchGroup(group, access$range);
    }

    @Nullable
    public MatchGroup get(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "name");
        return PlatformImplementationsKt.IMPLEMENTATIONS.getMatchResultNamedGroup(this.this$0.getMatchResult(), str);
    }
}
