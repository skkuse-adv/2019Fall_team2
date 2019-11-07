package kr.co.popone.fitts.model.repository.social;

import io.reactivex.functions.Function;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.datamodel.social.feed.Feed;
import kr.co.popone.fitts.model.datamodel.social.feed.FeedInfo;
import org.jetbrains.annotations.NotNull;

final class FittsSocialRepositoryImpl$getHomeFeeds$1<T, R> implements Function<T, R> {
    public static final FittsSocialRepositoryImpl$getHomeFeeds$1 INSTANCE = new FittsSocialRepositoryImpl$getHomeFeeds$1();

    FittsSocialRepositoryImpl$getHomeFeeds$1() {
    }

    @NotNull
    public final Pair<String, List<Feed>> apply(@NotNull FeedInfo feedInfo) {
        Intrinsics.checkParameterIsNotNull(feedInfo, "it");
        return new Pair<>(feedInfo.getVersion(), feedInfo.getItems());
    }
}
