package kr.co.popone.fitts.feature.post.notification;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.orhanobut.logger.Logger;
import io.reactivex.functions.BiConsumer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.model.post.PostAPI.PostInvoice;

final class PostDeleteNotificationDetailActivity$loadDataIfNeeded$1<T1, T2> implements BiConsumer<PostInvoice, Throwable> {
    final /* synthetic */ PostDeleteNotificationDetailActivity this$0;

    PostDeleteNotificationDetailActivity$loadDataIfNeeded$1(PostDeleteNotificationDetailActivity postDeleteNotificationDetailActivity) {
        this.this$0 = postDeleteNotificationDetailActivity;
    }

    public final void accept(PostInvoice postInvoice, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append("{postInvoice: ");
        sb.append(postInvoice);
        sb.append(", error: ");
        sb.append(th);
        sb.append('}');
        Logger.d(sb.toString(), new Object[0]);
        this.this$0.postInvoiceRequest = null;
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) this.this$0._$_findCachedViewById(C0010R$id.swipeRefreshLayout);
        Intrinsics.checkExpressionValueIsNotNull(swipeRefreshLayout, "swipeRefreshLayout");
        swipeRefreshLayout.setRefreshing(false);
        if (postInvoice != null) {
            this.this$0.postInvoiceSubject.onNext(postInvoice);
        }
    }
}
