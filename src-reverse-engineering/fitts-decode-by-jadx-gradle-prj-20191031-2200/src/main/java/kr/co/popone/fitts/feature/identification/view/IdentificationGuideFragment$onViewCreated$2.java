package kr.co.popone.fitts.feature.identification.view;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.event.RxBus;
import kr.co.popone.fitts.feature.identification.IdentificationEvent;

final class IdentificationGuideFragment$onViewCreated$2 implements OnClickListener {
    public static final IdentificationGuideFragment$onViewCreated$2 INSTANCE = new IdentificationGuideFragment$onViewCreated$2();

    IdentificationGuideFragment$onViewCreated$2() {
    }

    public final void onClick(View view) {
        RxBus.INSTANCE.post(IdentificationEvent.START_WEBVIEW);
    }
}
