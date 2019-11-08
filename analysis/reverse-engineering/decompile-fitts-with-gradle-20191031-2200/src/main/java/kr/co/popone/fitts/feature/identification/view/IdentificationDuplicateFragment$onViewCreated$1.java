package kr.co.popone.fitts.feature.identification.view;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.event.RxBus;
import kr.co.popone.fitts.feature.identification.IdentificationEvent;

final class IdentificationDuplicateFragment$onViewCreated$1 implements OnClickListener {
    public static final IdentificationDuplicateFragment$onViewCreated$1 INSTANCE = new IdentificationDuplicateFragment$onViewCreated$1();

    IdentificationDuplicateFragment$onViewCreated$1() {
    }

    public final void onClick(View view) {
        RxBus.INSTANCE.post(IdentificationEvent.CLOSE_WINDOW);
    }
}
