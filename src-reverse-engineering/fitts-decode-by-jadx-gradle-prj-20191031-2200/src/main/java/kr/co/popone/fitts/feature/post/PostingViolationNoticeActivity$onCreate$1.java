package kr.co.popone.fitts.feature.post;

import android.widget.TextView;
import com.orhanobut.logger.Logger;
import io.reactivex.functions.BiConsumer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.model.post.PostAPI.PostInvoice;

final class PostingViolationNoticeActivity$onCreate$1<T1, T2> implements BiConsumer<PostInvoice, Throwable> {
    final /* synthetic */ PostingViolationNoticeActivity this$0;

    PostingViolationNoticeActivity$onCreate$1(PostingViolationNoticeActivity postingViolationNoticeActivity) {
        this.this$0 = postingViolationNoticeActivity;
    }

    public final void accept(PostInvoice postInvoice, Throwable th) {
        this.this$0.postInvoiceRequest = null;
        StringBuilder sb = new StringBuilder();
        sb.append("response ");
        sb.append(postInvoice);
        sb.append(" error ");
        sb.append(th);
        Logger.d(sb.toString(), new Object[0]);
        if (postInvoice != null) {
            TextView textView = (TextView) this.this$0._$_findCachedViewById(C0010R$id.titleBodyTextView);
            Intrinsics.checkExpressionValueIsNotNull(textView, "titleBodyTextView");
            textView.setText(postInvoice.getPost().getTitle());
            TextView textView2 = (TextView) this.this$0._$_findCachedViewById(C0010R$id.descriptionTextView);
            Intrinsics.checkExpressionValueIsNotNull(textView2, "descriptionTextView");
            textView2.setText(postInvoice.getDescription());
        }
    }
}
