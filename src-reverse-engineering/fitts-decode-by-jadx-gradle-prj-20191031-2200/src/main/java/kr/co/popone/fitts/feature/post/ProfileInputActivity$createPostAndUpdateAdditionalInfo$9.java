package kr.co.popone.fitts.feature.post;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.orhanobut.logger.Logger;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.utils.Snackbar;

final class ProfileInputActivity$createPostAndUpdateAdditionalInfo$9<T> implements Consumer<Throwable> {
    final /* synthetic */ ProfileInputActivity this$0;

    ProfileInputActivity$createPostAndUpdateAdditionalInfo$9(ProfileInputActivity profileInputActivity) {
        this.this$0 = profileInputActivity;
    }

    public final void accept(Throwable th) {
        this.this$0.createPostRequest = null;
        Logger.e(th.toString(), new Object[0]);
        this.this$0.setInputFieldsEnabled(true);
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) this.this$0._$_findCachedViewById(C0010R$id.swipeRefreshLayout);
        Intrinsics.checkExpressionValueIsNotNull(swipeRefreshLayout, "swipeRefreshLayout");
        swipeRefreshLayout.setRefreshing(false);
        Snackbar.Companion.showMessage(this.this$0, "죄송합니다.\n서비스가 잠시 지연되고 있습니다.\n잠시 후 다시 이용해주세요.");
    }
}
