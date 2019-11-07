package kr.co.popone.fitts.feature.store.newest;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import kr.co.popone.fitts.model.datamodel.commerce.discount.SpecialDiscountInfo;
import org.jetbrains.annotations.Nullable;

final class StoreNewFeedFragment$onViewCreated$8 extends FunctionReference implements Function1<SpecialDiscountInfo, Unit> {
    StoreNewFeedFragment$onViewCreated$8(StoreNewFeedFragment storeNewFeedFragment) {
        super(1, storeNewFeedFragment);
    }

    public final String getName() {
        return "updateSpecialDiscountEvent";
    }

    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(StoreNewFeedFragment.class);
    }

    public final String getSignature() {
        return "updateSpecialDiscountEvent(Lkr/co/popone/fitts/model/datamodel/commerce/discount/SpecialDiscountInfo;)V";
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SpecialDiscountInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable SpecialDiscountInfo specialDiscountInfo) {
        ((StoreNewFeedFragment) this.receiver).updateSpecialDiscountEvent(specialDiscountInfo);
    }
}
