package kr.co.popone.fitts.viewmodel.alarm;

import android.app.Activity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.paging.DataSource.Factory;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import androidx.paging.PagedList.Config;
import androidx.paging.PagedList.Config.Builder;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import io.reactivex.schedulers.Schedulers;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.base.BaseViewModel;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.event.NotificationEvent;
import kr.co.popone.fitts.event.RxBus;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.eventtracker.EventTracker.CustomAttributes;
import kr.co.popone.fitts.model.datamodel.service.alarm.Alarm;
import kr.co.popone.fitts.model.datamodel.service.alarm.Alarm.Type;
import kr.co.popone.fitts.model.repository.service.FittsServiceRepository;
import kr.co.popone.fitts.paging.alarm.AlarmListDataSource;
import kr.co.popone.fitts.paging.alarm.AlarmListSourceFactory;
import kr.co.popone.fitts.services.FittsSchemeHandler;
import kr.co.popone.fitts.utils.ActionLogUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class AlarmViewModel extends BaseViewModel {
    private final MutableLiveData<AlarmListDataSource> _alarmDataSource;
    private final LiveData<PagedList<Alarm>> _alarmsLiveData;
    private final LiveData<NetworkState> _networkState;
    private final MutableLiveData<Unit> _updateDialogLiveData = new MutableLiveData<>();
    private final ActionLogUtil actionLogUtil;
    private final CompositeDisposable disposable = new CompositeDisposable();
    private final EventTracker eventTracker;
    private final FittsSchemeHandler fittsSchemeHandler;
    private final FittsServiceRepository fittsServiceRepository;

    public AlarmViewModel(@NotNull FittsServiceRepository fittsServiceRepository2, @NotNull FittsSchemeHandler fittsSchemeHandler2, @NotNull EventTracker eventTracker2, @NotNull ActionLogUtil actionLogUtil2) {
        Intrinsics.checkParameterIsNotNull(fittsServiceRepository2, "fittsServiceRepository");
        Intrinsics.checkParameterIsNotNull(fittsSchemeHandler2, "fittsSchemeHandler");
        Intrinsics.checkParameterIsNotNull(eventTracker2, "eventTracker");
        Intrinsics.checkParameterIsNotNull(actionLogUtil2, "actionLogUtil");
        this.fittsServiceRepository = fittsServiceRepository2;
        this.fittsSchemeHandler = fittsSchemeHandler2;
        this.eventTracker = eventTracker2;
        this.actionLogUtil = actionLogUtil2;
        AlarmListSourceFactory alarmListSourceFactory = new AlarmListSourceFactory(this.fittsServiceRepository);
        this._alarmDataSource = alarmListSourceFactory.getAlarmsDataSource();
        LiveData<NetworkState> switchMap = Transformations.switchMap(alarmListSourceFactory.getAlarmsDataSource(), AlarmViewModel$1$1.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(switchMap, "Transformations.switchMa…etworkState\n            }");
        this._networkState = switchMap;
        LiveData<PagedList<Alarm>> build = new LivePagedListBuilder((Factory<Key, Value>) alarmListSourceFactory, getPageConfig()).build();
        Intrinsics.checkExpressionValueIsNotNull(build, "LivePagedListBuilder(fac… getPageConfig()).build()");
        this._alarmsLiveData = build;
        CompositeDisposable compositeDisposable = this.disposable;
        Disposable subscribe = RxBus.INSTANCE.toObservable().subscribeOn(Schedulers.io()).ofType(NotificationEvent.class).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<NotificationEvent>(this) {
            final /* synthetic */ AlarmViewModel this$0;

            {
                this.this$0 = r1;
            }

            public final void accept(NotificationEvent notificationEvent) {
                this.this$0.refreshAlarmList();
            }
        }, new Consumer<Throwable>(this) {
            final /* synthetic */ AlarmViewModel this$0;

            {
                this.this$0 = r1;
            }

            public final void accept(Throwable th) {
                this.this$0.getErrorLiveData().setValue(th);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "RxBus.toObservable()\n   …e = it\n                })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        updateAlarmTime();
    }

    @NotNull
    public final LiveData<PagedList<Alarm>> updateAlarmList() {
        return this._alarmsLiveData;
    }

    @NotNull
    public final LiveData<NetworkState> updateNetworkState() {
        return this._networkState;
    }

    @NotNull
    public final MutableLiveData<Unit> showUpdateDialog() {
        return this._updateDialogLiveData;
    }

    public final void refreshAlarmList() {
        AlarmListDataSource alarmListDataSource = (AlarmListDataSource) this._alarmDataSource.getValue();
        if (alarmListDataSource != null) {
            alarmListDataSource.invalidate();
        }
        updateAlarmTime();
    }

    public final void alarmContentClick(@NotNull Activity activity, @NotNull String str, @Nullable Type type) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        Intrinsics.checkParameterIsNotNull(str, "scheme");
        if (!this.fittsSchemeHandler.handleScheme(activity, str)) {
            this._updateDialogLiveData.setValue(Unit.INSTANCE);
        } else if (type == Type.POST) {
            this.eventTracker.logCustom("View Post", new CustomAttributes().put("from", "notification"));
        }
        ActionLogUtil.defineCurrentWindow$default(this.actionLogUtil, "Activity", "", 0, 4, null);
    }

    private final void updateAlarmTime() {
        CompositeDisposable compositeDisposable = this.disposable;
        Disposable subscribe = this.fittsServiceRepository.updateActivitiesTouch().subscribe(AlarmViewModel$updateAlarmTime$1.INSTANCE, AlarmViewModel$updateAlarmTime$2.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "fittsServiceRepository.u…iled\")\n                })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    private final Config getPageConfig() {
        return new Builder().setEnablePlaceholders(true).setInitialLoadSizeHint(15).setPrefetchDistance(3).setPageSize(12).build();
    }

    /* access modifiers changed from: protected */
    public void onCleared() {
        this.disposable.dispose();
        super.onCleared();
    }
}
