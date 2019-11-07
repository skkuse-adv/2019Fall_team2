package kr.co.popone.fitts.base;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import com.orhanobut.logger.Logger;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.event.RxBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class AppManager$activityLifeCycleCallBacks$1 implements ActivityLifecycleCallbacks {
    final /* synthetic */ AppManager this$0;

    public void onActivityCreated(@NotNull Activity activity, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
    }

    public void onActivityDestroyed(@NotNull Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
    }

    public void onActivityPaused(@NotNull Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
    }

    public void onActivityResumed(@NotNull Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
    }

    public void onActivitySaveInstanceState(@NotNull Activity activity, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
    }

    AppManager$activityLifeCycleCallBacks$1(AppManager appManager) {
        this.this$0 = appManager;
    }

    public void onActivityStarted(@NotNull Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        StringBuilder sb = new StringBuilder();
        sb.append("onActivityStarted activeActivityCount(");
        sb.append(this.this$0.activeActivityCount);
        sb.append(") ");
        sb.append(activity);
        Logger.d(sb.toString(), new Object[0]);
        this.this$0.currentActivity = activity;
        if (this.this$0.activeActivityCount == 0) {
            RxBus.INSTANCE.post(new AppDidEnterForegroundEvent());
            if (this.this$0.versionCheckRequest == null) {
                AppManager appManager = this.this$0;
                appManager.versionCheckRequest = appManager.serviceRepository.checkAppVersion("2.11.2").subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new AppManager$activityLifeCycleCallBacks$1$onActivityStarted$1<Object,Object>(this));
            }
        }
        AppManager appManager2 = this.this$0;
        appManager2.activeActivityCount = appManager2.activeActivityCount + 1;
    }

    public void onActivityStopped(@NotNull Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        StringBuilder sb = new StringBuilder();
        sb.append("onActivityStopped ");
        sb.append(activity);
        Logger.d(sb.toString(), new Object[0]);
        if (Intrinsics.areEqual((Object) this.this$0.getCurrentActivity(), (Object) activity)) {
            this.this$0.currentActivity = null;
        }
        AppManager appManager = this.this$0;
        appManager.activeActivityCount = appManager.activeActivityCount - 1;
        if (this.this$0.activeActivityCount == 0) {
            RxBus.INSTANCE.post(new AppDidEnterBackgroundEvent());
            Disposable access$getVersionCheckRequest$p = this.this$0.versionCheckRequest;
            if (access$getVersionCheckRequest$p != null) {
                access$getVersionCheckRequest$p.dispose();
            }
            this.this$0.versionCheckRequest = null;
        }
    }
}
