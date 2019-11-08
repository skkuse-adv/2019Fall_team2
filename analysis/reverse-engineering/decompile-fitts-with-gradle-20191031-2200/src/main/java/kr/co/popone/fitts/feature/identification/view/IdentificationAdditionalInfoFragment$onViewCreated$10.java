package kr.co.popone.fitts.feature.identification.view;

import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import io.reactivex.functions.Consumer;
import kotlin.TypeCastException;
import kr.co.popone.fitts.feature.intro.IntroActivity;
import kr.co.popone.fitts.utils.Snackbar;
import kr.co.popone.fitts.utils.Snackbar.Companion;
import retrofit2.HttpException;

final class IdentificationAdditionalInfoFragment$onViewCreated$10<T> implements Consumer<Throwable> {
    final /* synthetic */ IdentificationAdditionalInfoFragment this$0;

    IdentificationAdditionalInfoFragment$onViewCreated$10(IdentificationAdditionalInfoFragment identificationAdditionalInfoFragment) {
        this.this$0 = identificationAdditionalInfoFragment;
    }

    public final void accept(Throwable th) {
        if (!(th instanceof HttpException)) {
            Companion companion = Snackbar.Companion;
            FragmentActivity activity = this.this$0.getActivity();
            if (activity != null) {
                companion.showMessage((IdentificationActivity) activity, "죄송합니다.\n서비스가 잠시 지연되고 있습니다.\n잠시 후 다시 이용해주세요.");
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type kr.co.popone.fitts.feature.identification.view.IdentificationActivity");
        } else if (((HttpException) th).code() == 401) {
            Intent intent = new Intent(this.this$0.getContext(), IntroActivity.class);
            intent.addFlags(32768);
            intent.addFlags(268435456);
            this.this$0.startActivity(intent);
        }
    }
}
