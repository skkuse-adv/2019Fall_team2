package kr.co.popone.fitts.feature.trend;

import com.kakao.common.ServerProtocol;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import kr.co.popone.fitts.viewmodel.trend.TrendFeedViewModel.Navigation;
import org.jetbrains.annotations.NotNull;

final class TrendFeedActivity$onCreate$5 extends FunctionReference implements Function1<Navigation, Unit> {
    TrendFeedActivity$onCreate$5(TrendFeedActivity trendFeedActivity) {
        super(1, trendFeedActivity);
    }

    public final String getName() {
        return ServerProtocol.NAVI_GUIDE_PATH;
    }

    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(TrendFeedActivity.class);
    }

    public final String getSignature() {
        return "navigate(Lkr/co/popone/fitts/viewmodel/trend/TrendFeedViewModel$Navigation;)V";
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Navigation) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Navigation navigation) {
        Intrinsics.checkParameterIsNotNull(navigation, "p1");
        ((TrendFeedActivity) this.receiver).navigate(navigation);
    }
}
