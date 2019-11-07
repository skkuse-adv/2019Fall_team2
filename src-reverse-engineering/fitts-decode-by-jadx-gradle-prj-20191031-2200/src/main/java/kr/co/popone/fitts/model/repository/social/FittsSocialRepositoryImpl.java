package kr.co.popone.fitts.model.repository.social;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.api.FittsSocialApi;
import kr.co.popone.fitts.model.datamodel.social.feed.Feed;
import kr.co.popone.fitts.model.datamodel.social.feed.FeedInfo;
import kr.co.popone.fitts.model.datamodel.social.membership.Membership;
import kr.co.popone.fitts.model.datamodel.social.recommend.PersonalRecommendation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class FittsSocialRepositoryImpl implements FittsSocialRepository {
    private final FittsSocialApi socialApi;

    public FittsSocialRepositoryImpl(@NotNull FittsSocialApi fittsSocialApi) {
        Intrinsics.checkParameterIsNotNull(fittsSocialApi, "socialApi");
        this.socialApi = fittsSocialApi;
    }

    @NotNull
    public Single<Pair<String, List<Feed>>> getHomeFeeds(@NotNull String str, @Nullable String str2, @Nullable Long l, int i) {
        Intrinsics.checkParameterIsNotNull(str, "type");
        Single<Pair<String, List<Feed>>> observeOn = this.socialApi.getHomeFeeds(str, str2, l, i).subscribeOn(Schedulers.io()).map(FittsSocialRepositoryImpl$getHomeFeeds$1.INSTANCE).observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkExpressionValueIsNotNull(observeOn, "socialApi.getHomeFeeds(t…dSchedulers.mainThread())");
        return observeOn;
    }

    @NotNull
    public Single<FeedInfo> getTrendDetail(long j, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "type");
        Single<FeedInfo> observeOn = this.socialApi.getTrendDetail(j, str).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkExpressionValueIsNotNull(observeOn, "socialApi.getTrendDetail…dSchedulers.mainThread())");
        return observeOn;
    }

    @NotNull
    public Single<PersonalRecommendation> getPersonalRecommandations(int i) {
        Single<PersonalRecommendation> observeOn = this.socialApi.getPersonalizedRecommends(i).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkExpressionValueIsNotNull(observeOn, "socialApi.getPersonalize…dSchedulers.mainThread())");
        return observeOn;
    }

    @NotNull
    public Single<List<Membership>> getFittsMemberships() {
        Single<List<Membership>> observeOn = this.socialApi.getMemberships().subscribeOn(Schedulers.io()).map(FittsSocialRepositoryImpl$getFittsMemberships$1.INSTANCE).observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkExpressionValueIsNotNull(observeOn, "socialApi.getMemberships…dSchedulers.mainThread())");
        return observeOn;
    }
}
