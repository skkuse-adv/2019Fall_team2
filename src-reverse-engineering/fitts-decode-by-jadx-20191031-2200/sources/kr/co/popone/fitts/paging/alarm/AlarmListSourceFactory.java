package kr.co.popone.fitts.paging.alarm;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import androidx.paging.DataSource.Factory;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.datamodel.service.alarm.Alarm;
import kr.co.popone.fitts.model.repository.service.FittsServiceRepository;
import org.jetbrains.annotations.NotNull;

public final class AlarmListSourceFactory extends Factory<Long, Alarm> {
    @NotNull
    private final MutableLiveData<AlarmListDataSource> alarmsDataSource = new MutableLiveData<>();
    private final FittsServiceRepository fittsServiceRepository;

    public AlarmListSourceFactory(@NotNull FittsServiceRepository fittsServiceRepository2) {
        Intrinsics.checkParameterIsNotNull(fittsServiceRepository2, "fittsServiceRepository");
        this.fittsServiceRepository = fittsServiceRepository2;
    }

    @NotNull
    public final MutableLiveData<AlarmListDataSource> getAlarmsDataSource() {
        return this.alarmsDataSource;
    }

    @NotNull
    public DataSource<Long, Alarm> create() {
        AlarmListDataSource alarmListDataSource = new AlarmListDataSource(this.fittsServiceRepository);
        this.alarmsDataSource.postValue(alarmListDataSource);
        return alarmListDataSource;
    }
}
