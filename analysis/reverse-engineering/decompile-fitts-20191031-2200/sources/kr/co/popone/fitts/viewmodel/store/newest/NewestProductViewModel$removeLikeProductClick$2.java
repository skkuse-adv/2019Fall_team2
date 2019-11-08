package kr.co.popone.fitts.viewmodel.store.newest;

import io.reactivex.functions.Consumer;

final class NewestProductViewModel$removeLikeProductClick$2<T> implements Consumer<Throwable> {
    final /* synthetic */ NewestProductViewModel this$0;

    NewestProductViewModel$removeLikeProductClick$2(NewestProductViewModel newestProductViewModel) {
        this.this$0 = newestProductViewModel;
    }

    public final void accept(Throwable th) {
        this.this$0.getErrorLiveData().setValue(th);
    }
}
