package kr.co.popone.fitts.base;

import com.orhanobut.logger.Logger;
import io.reactivex.functions.BiConsumer;
import kr.co.popone.fitts.model.datamodel.service.app.Version;

final class AppManager$activityLifeCycleCallBacks$1$onActivityStarted$1<T1, T2> implements BiConsumer<Version, Throwable> {
    final /* synthetic */ AppManager$activityLifeCycleCallBacks$1 this$0;

    AppManager$activityLifeCycleCallBacks$1$onActivityStarted$1(AppManager$activityLifeCycleCallBacks$1 appManager$activityLifeCycleCallBacks$1) {
        this.this$0 = appManager$activityLifeCycleCallBacks$1;
    }

    public final void accept(Version version, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append("versionCheck result(");
        sb.append(version);
        sb.append(") throwable(");
        sb.append(th);
        sb.append(')');
        Logger.d(sb.toString(), new Object[0]);
        this.this$0.this$0.versionCheckRequest = null;
        this.this$0.this$0.versionCheckResult = version;
        this.this$0.this$0.showUpdateDialogIfneeded();
    }
}
