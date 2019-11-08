package kr.co.popone.fitts.base;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.iid.InstanceIdResult;
import com.orhanobut.logger.Logger;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.user.UserAPI;

final class FittsApplication$fcmTokenManager$1$updateFCMTokenIfNeeded$1<TResult> implements OnSuccessListener<InstanceIdResult> {
    final /* synthetic */ FittsApplication$fcmTokenManager$1 this$0;

    FittsApplication$fcmTokenManager$1$updateFCMTokenIfNeeded$1(FittsApplication$fcmTokenManager$1 fittsApplication$fcmTokenManager$1) {
        this.this$0 = fittsApplication$fcmTokenManager$1;
    }

    public final void onSuccess(InstanceIdResult instanceIdResult) {
        SessionManager sessionManager$app_productionFittsRelease = this.this$0.this$0.getSessionManager$app_productionFittsRelease();
        Intrinsics.checkExpressionValueIsNotNull(instanceIdResult, "it");
        sessionManager$app_productionFittsRelease.setFirebaseToken(instanceIdResult.getToken());
        if (this.this$0.this$0.getSessionManager$app_productionFittsRelease().isLoggedIn()) {
            Logger.d("fcmTokenManager fcmToken != null && sessionManager?.isLoggedIn!!", new Object[0]);
            UserAPI userAPI = this.this$0.this$0.getUserAPI();
            String token = instanceIdResult.getToken();
            Intrinsics.checkExpressionValueIsNotNull(token, "it.token");
            userAPI.updateFCMToken(token, "android").subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(AnonymousClass1.INSTANCE, AnonymousClass2.INSTANCE);
        }
    }
}
