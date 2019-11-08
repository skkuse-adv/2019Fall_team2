package kr.co.popone.fitts.viewmodel.trend;

import android.app.Activity;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kr.co.popone.fitts.services.FittsSchemeHandler;
import org.jetbrains.annotations.NotNull;

final class TrendFeedViewModel$schemeFeedClick$1 extends Lambda implements Function1<Activity, Unit> {
    final /* synthetic */ String $scheme;
    final /* synthetic */ TrendFeedViewModel this$0;

    TrendFeedViewModel$schemeFeedClick$1(TrendFeedViewModel trendFeedViewModel, String str) {
        this.this$0 = trendFeedViewModel;
        this.$scheme = str;
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Activity) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        FittsSchemeHandler access$getSchemeHandler$p = this.this$0.schemeHandler;
        String str = this.$scheme;
        if (str == null) {
            str = "";
        }
        access$getSchemeHandler$p.handleScheme(activity, str);
    }
}
