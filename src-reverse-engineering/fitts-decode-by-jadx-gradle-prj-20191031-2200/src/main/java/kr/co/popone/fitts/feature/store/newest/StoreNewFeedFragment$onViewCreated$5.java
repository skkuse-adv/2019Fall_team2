package kr.co.popone.fitts.feature.store.newest;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import org.jetbrains.annotations.Nullable;

final class StoreNewFeedFragment$onViewCreated$5 extends FunctionReference implements Function1<String, Unit> {
    StoreNewFeedFragment$onViewCreated$5(StoreNewFeedFragment storeNewFeedFragment) {
        super(1, storeNewFeedFragment);
    }

    public final String getName() {
        return "updateSpecialDiscountText";
    }

    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(StoreNewFeedFragment.class);
    }

    public final String getSignature() {
        return "updateSpecialDiscountText(Ljava/lang/String;)V";
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable String str) {
        ((StoreNewFeedFragment) this.receiver).updateSpecialDiscountText(str);
    }
}
