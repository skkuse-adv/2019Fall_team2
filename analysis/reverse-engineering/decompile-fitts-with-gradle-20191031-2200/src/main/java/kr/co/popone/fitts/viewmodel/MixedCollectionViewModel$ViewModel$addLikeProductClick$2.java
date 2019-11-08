package kr.co.popone.fitts.viewmodel;

import com.orhanobut.logger.Logger;
import io.reactivex.functions.Consumer;

final class MixedCollectionViewModel$ViewModel$addLikeProductClick$2<T> implements Consumer<Throwable> {
    public static final MixedCollectionViewModel$ViewModel$addLikeProductClick$2 INSTANCE = new MixedCollectionViewModel$ViewModel$addLikeProductClick$2();

    MixedCollectionViewModel$ViewModel$addLikeProductClick$2() {
    }

    public final void accept(Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append("addLikeProductClick::");
        sb.append(th);
        Logger.e(sb.toString(), new Object[0]);
    }
}
