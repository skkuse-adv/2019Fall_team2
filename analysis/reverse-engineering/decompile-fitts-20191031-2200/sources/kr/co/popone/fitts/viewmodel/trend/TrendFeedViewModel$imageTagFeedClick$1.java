package kr.co.popone.fitts.viewmodel.trend;

import android.app.Activity;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kr.co.popone.fitts.model.datamodel.social.feed.TrendType;
import kr.co.popone.fitts.services.FittsSchemeHandler;
import org.jetbrains.annotations.NotNull;

final class TrendFeedViewModel$imageTagFeedClick$1 extends Lambda implements Function1<Activity, Unit> {
    final /* synthetic */ long $id;
    final /* synthetic */ TrendFeedViewModel this$0;

    TrendFeedViewModel$imageTagFeedClick$1(TrendFeedViewModel trendFeedViewModel, long j) {
        this.this$0 = trendFeedViewModel;
        this.$id = j;
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Activity) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        FittsSchemeHandler access$getSchemeHandler$p = this.this$0.schemeHandler;
        StringBuilder sb = new StringBuilder();
        sb.append("fitts://trend/");
        sb.append(this.$id);
        sb.append("?type=");
        TrendType access$getType$p = this.this$0.type;
        sb.append(access$getType$p != null ? access$getType$p.getValue() : null);
        access$getSchemeHandler$p.handleScheme(activity, sb.toString());
    }
}
