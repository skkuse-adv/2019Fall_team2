package kr.co.popone.fitts.ui.custom;

import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kr.co.popone.fitts.model.datamodel.commerce.discount.Discount.Type;
import kr.co.popone.fitts.model.datamodel.social.membership.Membership;

final class DiscountChoiceSelector$setMemberships$$inlined$apply$lambda$2 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ List $memberships$inlined;
    final /* synthetic */ DiscountChoiceSelector this$0;

    DiscountChoiceSelector$setMemberships$$inlined$apply$lambda$2(DiscountChoiceSelector discountChoiceSelector, List list) {
        this.this$0 = discountChoiceSelector;
        this.$memberships$inlined = list;
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i) {
        this.this$0.updateDiscount(Type.MEMBERSHIP, null, null, (Membership) this.$memberships$inlined.get(i - 1));
    }
}
