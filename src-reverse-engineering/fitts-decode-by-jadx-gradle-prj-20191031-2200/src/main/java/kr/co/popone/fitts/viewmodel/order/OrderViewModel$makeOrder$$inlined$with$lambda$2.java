package kr.co.popone.fitts.viewmodel.order;

import io.reactivex.functions.Consumer;

final class OrderViewModel$makeOrder$$inlined$with$lambda$2<T> implements Consumer<Throwable> {
    final /* synthetic */ OrderViewModel this$0;

    OrderViewModel$makeOrder$$inlined$with$lambda$2(OrderViewModel orderViewModel, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        this.this$0 = orderViewModel;
    }

    public final void accept(Throwable th) {
        this.this$0._orderErrorLiveData.setValue(th);
    }
}
