package kr.co.popone.fitts.feature.post;

import android.widget.TextView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.orhanobut.logger.Logger;
import io.reactivex.functions.BiConsumer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.model.user.UserAPI.UserInvoice;

final class PostVerificationRejectNoticeActivity$onCreate$2<T1, T2> implements BiConsumer<UserInvoice, Throwable> {
    final /* synthetic */ PostVerificationRejectNoticeActivity this$0;

    PostVerificationRejectNoticeActivity$onCreate$2(PostVerificationRejectNoticeActivity postVerificationRejectNoticeActivity) {
        this.this$0 = postVerificationRejectNoticeActivity;
    }

    public final void accept(UserInvoice userInvoice, Throwable th) {
        String str = null;
        this.this$0.userInvoiceRequest = null;
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) this.this$0._$_findCachedViewById(C0010R$id.swipeRefreshLayout);
        Intrinsics.checkExpressionValueIsNotNull(swipeRefreshLayout, "swipeRefreshLayout");
        swipeRefreshLayout.setRefreshing(false);
        StringBuilder sb = new StringBuilder();
        sb.append("{userInvoice: ");
        sb.append(userInvoice);
        sb.append(", error: ");
        sb.append(th);
        sb.append('}');
        Logger.d(sb.toString(), new Object[0]);
        if (userInvoice != null) {
            str = userInvoice.getRejectDescription();
        }
        if (str != null) {
            TextView textView = (TextView) this.this$0._$_findCachedViewById(C0010R$id.descriptionTextView1);
            Intrinsics.checkExpressionValueIsNotNull(textView, "descriptionTextView1");
            textView.setText(userInvoice.getRejectDescription());
        }
    }
}
