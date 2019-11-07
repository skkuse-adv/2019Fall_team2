package com.kakao.auth;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import com.kakao.common.KakaoContextService;
import com.kakao.common.PhaseInfo;
import com.kakao.util.exception.KakaoException;
import com.kakao.util.exception.KakaoException.ErrorType;

public class KakaoSDK {
    @SuppressLint({"StaticFieldLeak"})
    private static volatile KakaoAdapter adapter;
    /* access modifiers changed from: private */
    @SuppressLint({"StaticFieldLeak"})
    public static volatile Activity currentActivity;

    public static class AlreadyInitializedException extends RuntimeException {
        private static final long serialVersionUID = 1;
    }

    public static synchronized void init(KakaoAdapter kakaoAdapter) {
        synchronized (KakaoSDK.class) {
            if (adapter != null) {
                throw new AlreadyInitializedException();
            } else if (kakaoAdapter != null) {
                adapter = kakaoAdapter;
                Context applicationContext = kakaoAdapter.getApplicationConfig().getApplicationContext();
                Application application = (Application) applicationContext;
                application.registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
                    private int numActivities = 0;

                    public void onActivityCreated(Activity activity, Bundle bundle) {
                    }

                    public void onActivityDestroyed(Activity activity) {
                    }

                    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                    }

                    public void onActivityStarted(Activity activity) {
                    }

                    public void onActivityResumed(Activity activity) {
                        KakaoSDK.currentActivity = activity;
                        if (this.numActivities == 0 && KakaoSDK.needsToResetSession(activity, Session.getCurrentSession())) {
                            Session.getCurrentSession().internalClose(new KakaoException(ErrorType.CANCELED_OPERATION, "App restarted during Kakao login procedure. Restarting from the start."));
                        }
                        this.numActivities++;
                    }

                    public void onActivityPaused(Activity activity) {
                        if (activity != null && activity.equals(KakaoSDK.currentActivity)) {
                            KakaoSDK.currentActivity = null;
                        }
                    }

                    public void onActivityStopped(Activity activity) {
                        this.numActivities--;
                    }
                });
                ApprovalType approvalType = kakaoAdapter.getSessionConfig().getApprovalType();
                if (approvalType == null) {
                    approvalType = ApprovalType.INDIVIDUAL;
                }
                KakaoContextService.getInstance().initialize(applicationContext);
                Session.initialize(application, approvalType);
            } else {
                throw new KakaoException(ErrorType.MISS_CONFIGURATION, "adapter is null");
            }
        }
    }

    public static synchronized void init(KakaoAdapter kakaoAdapter, PhaseInfo phaseInfo) {
        synchronized (KakaoSDK.class) {
            KakaoContextService.getInstance().setPhaseInfo(phaseInfo);
            init(kakaoAdapter);
        }
    }

    public static KakaoAdapter getAdapter() {
        return adapter;
    }

    public static Activity getCurrentActivity() {
        return currentActivity;
    }

    /* access modifiers changed from: private */
    public static boolean needsToResetSession(Activity activity, Session session) {
        if (activity.getIntent() != null) {
            if (!"android.intent.action.MAIN".equals(activity.getIntent().getAction())) {
                return false;
            }
        }
        if (session.isClosed() && session.getRequestType() != null) {
            return true;
        }
        return false;
    }
}
