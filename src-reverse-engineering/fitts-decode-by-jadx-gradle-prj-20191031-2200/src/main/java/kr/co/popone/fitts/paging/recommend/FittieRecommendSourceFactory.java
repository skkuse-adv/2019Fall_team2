package kr.co.popone.fitts.paging.recommend;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import androidx.paging.DataSource.Factory;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.datamodel.social.feed.RecommendFittieInfo;
import kr.co.popone.fitts.model.repository.service.FittsServiceRepository;
import org.jetbrains.annotations.NotNull;

public final class FittieRecommendSourceFactory extends Factory<Long, RecommendFittieInfo> {
    @NotNull
    private final MutableLiveData<FittieRecommendDataSource> fittieRecommendLiveData = new MutableLiveData<>();
    private final FittsServiceRepository serviceRepository;

    public FittieRecommendSourceFactory(@NotNull FittsServiceRepository fittsServiceRepository) {
        Intrinsics.checkParameterIsNotNull(fittsServiceRepository, "serviceRepository");
        this.serviceRepository = fittsServiceRepository;
    }

    @NotNull
    public final MutableLiveData<FittieRecommendDataSource> getFittieRecommendLiveData() {
        return this.fittieRecommendLiveData;
    }

    @NotNull
    public DataSource<Long, RecommendFittieInfo> create() {
        FittieRecommendDataSource fittieRecommendDataSource = new FittieRecommendDataSource(this.serviceRepository);
        this.fittieRecommendLiveData.postValue(fittieRecommendDataSource);
        return fittieRecommendDataSource;
    }
}
