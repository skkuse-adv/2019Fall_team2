package kr.co.popone.fitts.feature.intro;

import com.orhanobut.logger.Logger;
import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.utils.Snackbar;

final class IntroActivity$onEmailCheck$2<T> implements Consumer<Throwable> {
    final /* synthetic */ IntroActivity this$0;

    IntroActivity$onEmailCheck$2(IntroActivity introActivity) {
        this.this$0 = introActivity;
    }

    public final void accept(Throwable th) {
        this.this$0.emailCheckRequest = null;
        Logger.d(th.toString(), new Object[0]);
        Snackbar.Companion.showMessage(this.this$0, "죄송합니다.\n서비스가 잠시 지연되고 있습니다.\n잠시 후 다시 이용해주세요.");
    }
}
