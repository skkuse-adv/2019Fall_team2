package kr.co.popone.fitts.viewmodel.store.newest;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import kr.co.popone.fitts.model.datamodel.commerce.discount.SpecialDiscountInfo;
import kr.co.popone.fitts.paging.store.newest.NewestProductDataSource;
import org.jetbrains.annotations.NotNull;

final class NewestProductViewModel$1$2<I, O> implements Function<X, LiveData<Y>> {
    public static final NewestProductViewModel$1$2 INSTANCE = new NewestProductViewModel$1$2();

    NewestProductViewModel$1$2() {
    }

    @NotNull
    public final MutableLiveData<SpecialDiscountInfo> apply(NewestProductDataSource newestProductDataSource) {
        return newestProductDataSource.getSpecialDiscount();
    }
}
