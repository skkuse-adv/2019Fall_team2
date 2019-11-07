package kr.co.popone.fitts.base.extension;

import android.content.Context;
import android.content.Intent;
import androidx.core.app.ActivityOptionsCompat;
import androidx.fragment.app.Fragment;
import com.orhanobut.logger.Logger;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.intro.IntroActivity;
import kr.co.popone.fitts.ui.ToastExtensionKt;
import kr.co.popone.fitts.utils.ActivityAnimationType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.HttpException;

public final class FragmentExtensionKt {
    public static final void handleError(@NotNull Fragment fragment, @Nullable Throwable th) {
        Intrinsics.checkParameterIsNotNull(fragment, "receiver$0");
        StringBuilder sb = new StringBuilder();
        sb.append("error occured ");
        sb.append(th);
        Logger.d(sb.toString(), new Object[0]);
        String str = "죄송합니다.\n서비스가 잠시 지연되고 있습니다.\n잠시 후 다시 이용해주세요.";
        if (!(th instanceof HttpException)) {
            ToastExtensionKt.showToast(fragment, str);
        } else if (((HttpException) th).code() == 401) {
            Intent intent = new Intent(fragment.getContext(), IntroActivity.class);
            intent.addFlags(32768);
            intent.addFlags(268435456);
            fragment.startActivity(intent);
        } else {
            ToastExtensionKt.showToast(fragment, str);
        }
    }

    public static final void activityStart(@NotNull Fragment fragment, @NotNull Intent intent, @NotNull ActivityAnimationType activityAnimationType) {
        Intrinsics.checkParameterIsNotNull(fragment, "receiver$0");
        Intrinsics.checkParameterIsNotNull(intent, "intent");
        Intrinsics.checkParameterIsNotNull(activityAnimationType, "type");
        Context context = fragment.getContext();
        if (context != null) {
            ActivityOptionsCompat makeCustomAnimation = ActivityOptionsCompat.makeCustomAnimation(context, activityAnimationType.getEnter(), activityAnimationType.getExit());
            Intrinsics.checkExpressionValueIsNotNull(makeCustomAnimation, "ActivityOptionsCompat.ma…t, type.enter, type.exit)");
            context.startActivity(intent, makeCustomAnimation.toBundle());
        }
    }
}
