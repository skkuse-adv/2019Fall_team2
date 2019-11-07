package kr.co.popone.fitts.feature.collection;

import com.orhanobut.logger.Logger;
import io.reactivex.functions.Consumer;

final class MixedCollectionActivity$onPostClicked$2<T> implements Consumer<Throwable> {
    public static final MixedCollectionActivity$onPostClicked$2 INSTANCE = new MixedCollectionActivity$onPostClicked$2();

    MixedCollectionActivity$onPostClicked$2() {
    }

    public final void accept(Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append("ActionLogFail::");
        sb.append(th);
        Logger.d(sb.toString(), new Object[0]);
    }
}
