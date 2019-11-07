package kr.co.popone.fitts.viewmodel.store.newest;

import com.orhanobut.logger.Logger;
import io.reactivex.functions.Consumer;

final class NewestProductViewModel$calculateRemainTime$3<T> implements Consumer<Throwable> {
    public static final NewestProductViewModel$calculateRemainTime$3 INSTANCE = new NewestProductViewModel$calculateRemainTime$3();

    NewestProductViewModel$calculateRemainTime$3() {
    }

    public final void accept(Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append("calculateRemainTime::FALED = ");
        sb.append(th);
        Logger.d(sb.toString(), new Object[0]);
    }
}
