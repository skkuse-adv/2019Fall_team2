package kr.co.popone.fitts.base.extension;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.orhanobut.logger.Logger;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kr.co.popone.fitts.feature.intro.IntroActivity;
import kr.co.popone.fitts.ui.ToastExtensionKt;
import kr.co.popone.fitts.utils.ActivityAnimationType;
import kr.co.popone.fitts.utils.Snackbar;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import retrofit2.HttpException;

public final class ActivityExtensionKt {
    public static final void handleError(@NotNull Activity activity, @Nullable Throwable th) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        StringBuilder sb = new StringBuilder();
        sb.append("error occured ");
        sb.append(th);
        Logger.d(sb.toString(), new Object[0]);
        String str = "죄송합니다.\n서비스가 잠시 지연되고 있습니다.\n잠시 후 다시 이용해주세요.";
        if (!(th instanceof HttpException)) {
            ToastExtensionKt.showToast((Context) activity, str);
        } else if (((HttpException) th).code() == 401) {
            Intent intent = new Intent(activity, IntroActivity.class);
            intent.addFlags(32768);
            intent.addFlags(268435456);
            activity.startActivity(intent);
        } else {
            ToastExtensionKt.showToast((Context) activity, str);
        }
    }

    public static final void handleErrorCodeMessage(@NotNull Activity activity, @Nullable Throwable th) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        if (th instanceof HttpException) {
            HttpException httpException = (HttpException) th;
            if (httpException.code() == 401) {
                Intent intent = new Intent(activity, IntroActivity.class);
                intent.addFlags(32768);
                intent.addFlags(268435456);
                activity.startActivity(intent);
                return;
            }
            ResponseBody errorBody = httpException.response().errorBody();
            if (errorBody == null) {
                Intrinsics.throwNpe();
            }
            byte[] bytes = errorBody.bytes();
            Intrinsics.checkExpressionValueIsNotNull(bytes, "throwable.response().errorBody()!!.bytes()");
            ToastExtensionKt.showToast((Context) activity, new JSONObject(new String(bytes, Charsets.UTF_8)).getString(SettingsJsonConstants.PROMPT_MESSAGE_KEY));
            return;
        }
        Snackbar.Companion.showMessage(activity, "죄송합니다.\n서비스가 잠시 지연되고 있습니다.\n잠시 후 다시 이용해주세요.");
    }

    public static final void finishWithAnimation(@NotNull Activity activity, @NotNull ActivityAnimationType activityAnimationType) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(activityAnimationType, "type");
        activity.finish();
        activity.overridePendingTransition(activityAnimationType.getEnter(), activityAnimationType.getExit());
    }

    public static final void activityStartForResult(@NotNull Activity activity, @NotNull Intent intent, @NotNull ActivityAnimationType activityAnimationType, int i) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(intent, "intent");
        Intrinsics.checkParameterIsNotNull(activityAnimationType, "animation");
        activity.startActivityForResult(intent, i);
        activity.overridePendingTransition(activityAnimationType.getEnter(), activityAnimationType.getExit());
    }

    public static final void showSnackbarMessage(@NotNull Activity activity, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(str, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        Snackbar.Companion.showMessage(activity, str);
    }

    public static final void finishAnimation(@NotNull Activity activity, @NotNull ActivityAnimationType activityAnimationType) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(activityAnimationType, "animation");
        activity.overridePendingTransition(activityAnimationType.getEnter(), activityAnimationType.getExit());
    }
}
