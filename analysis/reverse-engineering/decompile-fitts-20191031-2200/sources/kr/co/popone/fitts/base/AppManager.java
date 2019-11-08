package kr.co.popone.fitts.base;

import android.app.Activity;
import android.app.Application;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.datamodel.service.app.Version;
import kr.co.popone.fitts.model.datamodel.service.app.Version.Type;
import kr.co.popone.fitts.model.repository.service.FittsServiceRepository;
import kr.co.popone.fitts.ui.DialogExtensions;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class AppManager {
    public static final int CHANGED_COMMENT = 1;
    public static final int CHANGED_FOLLOW = 2;
    public static final int CHANGED_LIKED = 3;
    public static final int CHANGED_PROFILE_IMAGE = 4;
    public static final int CHANGED_SHOWROOM = 5;
    public static final int CHANGED_USER_INFO = 6;
    @NotNull
    public static final String COMMENT_MESSAGE = "comment_message";
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String FOLLOW_MESSAGE = "follow_message";
    @NotNull
    public static final String HOME_MESSAGE = "home_message";
    @NotNull
    public static final String MY_MESSAGE = "my_message";
    @NotNull
    public static final String POST_MESSAGE = "post_message";
    @NotNull
    public static final String SHOWROOM_MESSAGE = "showroom_message";
    /* access modifiers changed from: private */
    public int activeActivityCount;
    private final AppManager$activityLifeCycleCallBacks$1 activityLifeCycleCallBacks = new AppManager$activityLifeCycleCallBacks$1(this);
    /* access modifiers changed from: private */
    @Nullable
    public Activity currentActivity;
    /* access modifiers changed from: private */
    public final FittsServiceRepository serviceRepository;
    /* access modifiers changed from: private */
    public Disposable versionCheckRequest;
    /* access modifiers changed from: private */
    public Version versionCheckResult;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public AppManager(@NotNull Application application, @NotNull FittsServiceRepository fittsServiceRepository) {
        Intrinsics.checkParameterIsNotNull(application, "application");
        Intrinsics.checkParameterIsNotNull(fittsServiceRepository, "serviceRepository");
        this.serviceRepository = fittsServiceRepository;
        application.registerActivityLifecycleCallbacks(this.activityLifeCycleCallBacks);
    }

    @Nullable
    public final Activity getCurrentActivity() {
        return this.currentActivity;
    }

    /* access modifiers changed from: private */
    public final void showUpdateDialogIfneeded() {
        Activity activity = this.currentActivity;
        if (activity != null) {
            Version version = this.versionCheckResult;
            if ((version != null ? version.getType() : null) != null) {
                String displayMessage = version.getDisplayMessage();
                if (displayMessage == null) {
                    displayMessage = "업데이트 하세요";
                }
                DialogExtensions.INSTANCE.showUpdateDialog(activity, new AppManager$showUpdateDialogIfneeded$1(activity), displayMessage, version.getType() == Type.OPTIONAL);
            }
            this.versionCheckResult = null;
        }
    }
}
