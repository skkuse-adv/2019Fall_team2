package kr.co.popone.fitts.viewmodel.store.newest;

import io.reactivex.functions.Consumer;
import kotlin.Pair;

final class NewestProductViewModel$calculateRemainTime$2<T> implements Consumer<Pair<? extends String, ? extends Integer>> {
    final /* synthetic */ NewestProductViewModel this$0;

    NewestProductViewModel$calculateRemainTime$2(NewestProductViewModel newestProductViewModel) {
        this.this$0 = newestProductViewModel;
    }

    public final void accept(Pair<String, Integer> pair) {
        if (((Number) pair.getSecond()).intValue() <= 0) {
            this.this$0.specialDisountNow.setValue(Boolean.valueOf(false));
            this.this$0.refreshStoreNewFeeds();
            return;
        }
        this.this$0.specialDiscountRemainTime.setValue(pair.getFirst());
        this.this$0.specialDiscountRemainTimePercentage.setValue(pair.getSecond());
    }
}
