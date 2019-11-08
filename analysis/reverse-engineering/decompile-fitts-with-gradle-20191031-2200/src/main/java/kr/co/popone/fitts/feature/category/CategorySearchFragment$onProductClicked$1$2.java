package kr.co.popone.fitts.feature.category;

import com.orhanobut.logger.Logger;
import io.reactivex.functions.Consumer;

final class CategorySearchFragment$onProductClicked$1$2<T> implements Consumer<Throwable> {
    public static final CategorySearchFragment$onProductClicked$1$2 INSTANCE = new CategorySearchFragment$onProductClicked$1$2();

    CategorySearchFragment$onProductClicked$1$2() {
    }

    public final void accept(Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append("ActionLogFail:: Type = Product, MainPath = Category, SubId = ");
        sb.append(th);
        Logger.d(sb.toString(), new Object[0]);
    }
}
