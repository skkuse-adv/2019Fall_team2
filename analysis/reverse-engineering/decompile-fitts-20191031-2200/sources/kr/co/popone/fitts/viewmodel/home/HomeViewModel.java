package kr.co.popone.fitts.viewmodel.home;

import androidx.lifecycle.MutableLiveData;
import com.orhanobut.logger.Logger;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.base.BaseViewModel;
import kr.co.popone.fitts.event.FittieApplicationStateChangedEvent;
import kr.co.popone.fitts.event.RxBus;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.eventtracker.EventTracker.CustomAttributes;
import kr.co.popone.fitts.repository.home.HomeRepository;
import org.jetbrains.annotations.NotNull;

public final class HomeViewModel extends BaseViewModel {
    @NotNull
    private final MutableLiveData<Integer> cartVariantCountLiveData = new MutableLiveData<>();
    private final CompositeDisposable disposables = new CompositeDisposable();
    private final EventTracker eventTracker;
    /* access modifiers changed from: private */
    public final HomeRepository repository;

    public HomeViewModel(@NotNull HomeRepository homeRepository, @NotNull EventTracker eventTracker2) {
        Intrinsics.checkParameterIsNotNull(homeRepository, "repository");
        Intrinsics.checkParameterIsNotNull(eventTracker2, "eventTracker");
        this.repository = homeRepository;
        this.eventTracker = eventTracker2;
        CompositeDisposable compositeDisposable = this.disposables;
        Disposable subscribe = RxBus.INSTANCE.toObservable().subscribeOn(Schedulers.io()).ofType(FittieApplicationStateChangedEvent.class).observeOn(AndroidSchedulers.mainThread()).subscribe((Consumer<? super T>) new Consumer<FittieApplicationStateChangedEvent>(this) {
            final /* synthetic */ HomeViewModel this$0;

            {
                this.this$0 = r1;
            }

            public final void accept(FittieApplicationStateChangedEvent fittieApplicationStateChangedEvent) {
                this.this$0.initializeProfile();
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "RxBus.toObservable()\n   …ofile()\n                }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    @NotNull
    public final MutableLiveData<Integer> getCartVariantCountLiveData() {
        return this.cartVariantCountLiveData;
    }

    /* access modifiers changed from: private */
    public final void initializeProfile() {
        CompositeDisposable compositeDisposable = this.disposables;
        Disposable subscribe = this.repository.requestUserInfo().subscribe((BiConsumer<? super T, ? super Throwable>) new HomeViewModel$initializeProfile$1<Object,Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "repository.requestUserIn…      }\n                }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final void getBadgeCount() {
        CompositeDisposable compositeDisposable = this.disposables;
        Disposable subscribe = this.repository.requestBadgeCount().subscribe((BiConsumer<? super T, ? super Throwable>) new HomeViewModel$getBadgeCount$1<Object,Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "repository.requestBadgeC…      }\n                }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final void leaveHomeTabLog(int i) {
        String str = "tab";
        String str2 = "Tap To Home Tab";
        if (i == 0) {
            this.eventTracker.logCustom(str2, new CustomAttributes().put(str, "my"));
            Logger.d("FabricAnswer::Tap To Home Tab, tab = my", new Object[0]);
        } else if (i == 1) {
            this.eventTracker.logCustom(str2, new CustomAttributes().put(str, "ALL"));
            Logger.d("FabricAnswer::Tap To Home Tab, tab = all", new Object[0]);
        }
    }

    public final void logTapSlideMenu() {
        this.eventTracker.customLogTapSlideMenu();
    }

    /* access modifiers changed from: protected */
    public void onCleared() {
        this.disposables.dispose();
        super.onCleared();
    }
}
