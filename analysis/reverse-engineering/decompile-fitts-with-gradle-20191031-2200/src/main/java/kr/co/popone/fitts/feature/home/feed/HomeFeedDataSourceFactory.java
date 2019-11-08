package kr.co.popone.fitts.feature.home.feed;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import androidx.paging.DataSource.Factory;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.datamodel.social.feed.Feed;
import kr.co.popone.fitts.model.repository.social.FittsSocialRepository;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class HomeFeedDataSourceFactory extends Factory<Long, Feed> {
    private final String feedRequestType;
    @NotNull
    private final MutableLiveData<HomeFeedDataSource> homeFeedLiveData = new MutableLiveData<>();
    private final FittsSocialRepository socialRepository;

    public HomeFeedDataSourceFactory(@Nullable String str, @NotNull FittsSocialRepository fittsSocialRepository) {
        Intrinsics.checkParameterIsNotNull(fittsSocialRepository, "socialRepository");
        this.feedRequestType = str;
        this.socialRepository = fittsSocialRepository;
    }

    @NotNull
    public final MutableLiveData<HomeFeedDataSource> getHomeFeedLiveData() {
        return this.homeFeedLiveData;
    }

    @NotNull
    public DataSource<Long, Feed> create() {
        HomeFeedDataSource homeFeedDataSource = new HomeFeedDataSource(this.feedRequestType, this.socialRepository);
        this.homeFeedLiveData.postValue(homeFeedDataSource);
        return homeFeedDataSource;
    }
}
