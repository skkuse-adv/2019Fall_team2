package kr.co.popone.fitts.feature.intro.join;

import android.widget.ProgressBar;
import com.orhanobut.logger.Logger;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.utils.Snackbar;

final class JoinActivity$requestJoin$2<T> implements Consumer<Throwable> {
    final /* synthetic */ JoinActivity this$0;

    JoinActivity$requestJoin$2(JoinActivity joinActivity) {
        this.this$0 = joinActivity;
    }

    public final void accept(Throwable th) {
        ProgressBar progressBar = (ProgressBar) this.this$0._$_findCachedViewById(C0010R$id.loadingProgressBar);
        Intrinsics.checkExpressionValueIsNotNull(progressBar, "loadingProgressBar");
        progressBar.setVisibility(8);
        Logger.e(th.toString(), new Object[0]);
        Snackbar.Companion.showMessage(this.this$0, "죄송합니다.\n서비스가 잠시 지연되고 있습니다.\n잠시 후 다시 이용해주세요.");
        this.this$0.createUserRequest = null;
    }
}
