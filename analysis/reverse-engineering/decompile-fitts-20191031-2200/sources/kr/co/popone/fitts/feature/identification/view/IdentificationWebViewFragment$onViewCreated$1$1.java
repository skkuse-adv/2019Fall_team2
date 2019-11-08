package kr.co.popone.fitts.feature.identification.view;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.event.RxBus;
import kr.co.popone.fitts.feature.identification.IdentificationEvent;

final class IdentificationWebViewFragment$onViewCreated$1$1 implements OnClickListener {
    public static final IdentificationWebViewFragment$onViewCreated$1$1 INSTANCE = new IdentificationWebViewFragment$onViewCreated$1$1();

    IdentificationWebViewFragment$onViewCreated$1$1() {
    }

    public final void onClick(View view) {
        RxBus.INSTANCE.post(IdentificationEvent.CLOSE_WINDOW);
    }
}
