package kr.co.popone.fitts.services;

import android.app.Activity;
import com.orhanobut.logger.Logger;
import io.reactivex.functions.BiConsumer;
import kotlin.Pair;
import kotlin.TuplesKt;
import kr.co.popone.fitts.C0001R$anim;
import kr.co.popone.fitts.feature.openweb.OpenWebActivity;
import kr.co.popone.fitts.feature.openweb.OpenWebActivity.Parameters;
import kr.co.popone.fitts.model.datamodel.service.web.OpenWeb;
import org.jetbrains.anko.internals.AnkoInternals;

final class FittsSchemeHandlerImpl$handleScheme$1<T1, T2> implements BiConsumer<OpenWeb, Throwable> {
    final /* synthetic */ Activity $activity;

    FittsSchemeHandlerImpl$handleScheme$1(Activity activity) {
        this.$activity = activity;
    }

    public final void accept(OpenWeb openWeb, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append("{webInfoResponse: ");
        sb.append(openWeb);
        sb.append(", error: ");
        sb.append(th);
        sb.append('}');
        Logger.d(sb.toString(), new Object[0]);
        if (openWeb != null) {
            Activity activity = this.$activity;
            Parameters parameters = new Parameters(openWeb.getTargetUrl(), openWeb.getHasNavigation(), openWeb.getHasToolbar(), openWeb.getTitle(), true);
            activity.startActivity(AnkoInternals.createIntent(activity, OpenWebActivity.class, new Pair[]{TuplesKt.to("parameters", parameters)}));
            this.$activity.overridePendingTransition(C0001R$anim.slide_up, C0001R$anim.fade_out);
        }
    }
}
