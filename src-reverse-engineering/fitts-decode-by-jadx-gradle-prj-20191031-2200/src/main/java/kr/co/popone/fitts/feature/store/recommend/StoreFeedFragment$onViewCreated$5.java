package kr.co.popone.fitts.feature.store.recommend;

import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import org.jetbrains.annotations.NotNull;

final class StoreFeedFragment$onViewCreated$5 extends FunctionReference implements Function1<Pair<? extends String, ? extends String>, Unit> {
    StoreFeedFragment$onViewCreated$5(StoreFeedFragment storeFeedFragment) {
        super(1, storeFeedFragment);
    }

    public final String getName() {
        return "startStoreBrowserActivity";
    }

    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(StoreFeedFragment.class);
    }

    public final String getSignature() {
        return "startStoreBrowserActivity(Lkotlin/Pair;)V";
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Pair) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Pair<String, String> pair) {
        Intrinsics.checkParameterIsNotNull(pair, "p1");
        ((StoreFeedFragment) this.receiver).startStoreBrowserActivity(pair);
    }
}
