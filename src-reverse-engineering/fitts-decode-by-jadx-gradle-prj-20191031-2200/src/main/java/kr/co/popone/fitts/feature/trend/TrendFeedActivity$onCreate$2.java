package kr.co.popone.fitts.feature.trend;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import org.jetbrains.annotations.NotNull;

final class TrendFeedActivity$onCreate$2 extends FunctionReference implements Function1<String, Unit> {
    TrendFeedActivity$onCreate$2(TrendFeedActivity trendFeedActivity) {
        super(1, trendFeedActivity);
    }

    public final String getName() {
        return "updateToolbarTitle";
    }

    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(TrendFeedActivity.class);
    }

    public final String getSignature() {
        return "updateToolbarTitle(Ljava/lang/String;)V";
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "p1");
        ((TrendFeedActivity) this.receiver).updateToolbarTitle(str);
    }
}
