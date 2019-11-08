package kr.co.popone.fitts.feature.home.feed;

import com.kakao.common.ServerProtocol;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import kr.co.popone.fitts.viewmodel.home.feed.HomeFeedViewModel.Navigation;
import org.jetbrains.annotations.NotNull;

final class HomeFeedFragment$onViewCreated$6 extends FunctionReference implements Function1<Navigation, Unit> {
    HomeFeedFragment$onViewCreated$6(HomeFeedFragment homeFeedFragment) {
        super(1, homeFeedFragment);
    }

    public final String getName() {
        return ServerProtocol.NAVI_GUIDE_PATH;
    }

    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(HomeFeedFragment.class);
    }

    public final String getSignature() {
        return "navigate(Lkr/co/popone/fitts/viewmodel/home/feed/HomeFeedViewModel$Navigation;)V";
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Navigation) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Navigation navigation) {
        Intrinsics.checkParameterIsNotNull(navigation, "p1");
        ((HomeFeedFragment) this.receiver).navigate(navigation);
    }
}
