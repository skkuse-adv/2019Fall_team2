package kr.co.popone.fitts.feature.home.feed;

import android.app.Activity;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import org.jetbrains.annotations.NotNull;

final class HomeFeedFragment$onViewCreated$5 extends FunctionReference implements Function1<Function1<? super Activity, ? extends Unit>, Unit> {
    HomeFeedFragment$onViewCreated$5(HomeFeedFragment homeFeedFragment) {
        super(1, homeFeedFragment);
    }

    public final String getName() {
        return "handleScheme";
    }

    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(HomeFeedFragment.class);
    }

    public final String getSignature() {
        return "handleScheme(Lkotlin/jvm/functions/Function1;)V";
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Function1) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Function1<? super Activity, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "p1");
        ((HomeFeedFragment) this.receiver).handleScheme(function1);
    }
}
