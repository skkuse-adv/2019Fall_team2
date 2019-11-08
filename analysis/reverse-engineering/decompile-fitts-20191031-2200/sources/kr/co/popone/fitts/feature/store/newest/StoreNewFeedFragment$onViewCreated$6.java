package kr.co.popone.fitts.feature.store.newest;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import org.jetbrains.annotations.Nullable;

final class StoreNewFeedFragment$onViewCreated$6 extends FunctionReference implements Function1<Integer, Unit> {
    StoreNewFeedFragment$onViewCreated$6(StoreNewFeedFragment storeNewFeedFragment) {
        super(1, storeNewFeedFragment);
    }

    public final String getName() {
        return "updateRemainPercentage";
    }

    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(StoreNewFeedFragment.class);
    }

    public final String getSignature() {
        return "updateRemainPercentage(Ljava/lang/Integer;)V";
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Integer) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Integer num) {
        ((StoreNewFeedFragment) this.receiver).updateRemainPercentage(num);
    }
}
