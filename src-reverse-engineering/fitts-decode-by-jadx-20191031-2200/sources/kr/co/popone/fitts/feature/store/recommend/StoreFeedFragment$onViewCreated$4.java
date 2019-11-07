package kr.co.popone.fitts.feature.store.recommend;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

final class StoreFeedFragment$onViewCreated$4 extends FunctionReference implements Function1<Long, Unit> {
    StoreFeedFragment$onViewCreated$4(StoreFeedFragment storeFeedFragment) {
        super(1, storeFeedFragment);
    }

    public final String getName() {
        return "startStoreBridgeActivity";
    }

    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(StoreFeedFragment.class);
    }

    public final String getSignature() {
        return "startStoreBridgeActivity(J)V";
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).longValue());
        return Unit.INSTANCE;
    }

    public final void invoke(long j) {
        ((StoreFeedFragment) this.receiver).startStoreBridgeActivity(j);
    }
}
