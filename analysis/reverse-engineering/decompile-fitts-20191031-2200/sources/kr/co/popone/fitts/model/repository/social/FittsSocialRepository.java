package kr.co.popone.fitts.model.repository.social;

import io.reactivex.Single;
import java.util.List;
import kotlin.Pair;
import kr.co.popone.fitts.model.datamodel.social.feed.Feed;
import kr.co.popone.fitts.model.datamodel.social.feed.FeedInfo;
import kr.co.popone.fitts.model.datamodel.social.membership.Membership;
import kr.co.popone.fitts.model.datamodel.social.recommend.PersonalRecommendation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface FittsSocialRepository {
    @NotNull
    Single<List<Membership>> getFittsMemberships();

    @NotNull
    Single<Pair<String, List<Feed>>> getHomeFeeds(@NotNull String str, @Nullable String str2, @Nullable Long l, int i);

    @NotNull
    Single<PersonalRecommendation> getPersonalRecommandations(int i);

    @NotNull
    Single<FeedInfo> getTrendDetail(long j, @NotNull String str);
}
