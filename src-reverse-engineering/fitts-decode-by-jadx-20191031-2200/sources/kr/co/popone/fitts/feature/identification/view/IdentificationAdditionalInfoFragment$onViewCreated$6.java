package kr.co.popone.fitts.feature.identification.view;

import com.orhanobut.logger.Logger;
import io.reactivex.functions.Consumer;

final class IdentificationAdditionalInfoFragment$onViewCreated$6<T> implements Consumer<Throwable> {
    public static final IdentificationAdditionalInfoFragment$onViewCreated$6 INSTANCE = new IdentificationAdditionalInfoFragment$onViewCreated$6();

    IdentificationAdditionalInfoFragment$onViewCreated$6() {
    }

    public final void accept(Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append("WTF ");
        sb.append(th.getMessage());
        Logger.d(sb.toString(), new Object[0]);
    }
}
