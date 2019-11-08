package kr.co.popone.fitts.feature.post.notification;

import android.widget.TextView;
import com.orhanobut.logger.Logger;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.model.post.PostAPI.PostInvoice;

final class PostDeleteNotificationDetailActivity$onCreate$2<T> implements Consumer<PostInvoice> {
    final /* synthetic */ PostDeleteNotificationDetailActivity this$0;

    PostDeleteNotificationDetailActivity$onCreate$2(PostDeleteNotificationDetailActivity postDeleteNotificationDetailActivity) {
        this.this$0 = postDeleteNotificationDetailActivity;
    }

    public final void accept(PostInvoice postInvoice) {
        StringBuilder sb = new StringBuilder();
        sb.append("postInvoice ");
        sb.append(postInvoice);
        Logger.d(sb.toString(), new Object[0]);
        String format = this.this$0.dateFormat.format(Intrinsics.areEqual((Object) postInvoice.getAction(), (Object) "inactive") ? postInvoice.getInactivatedAt() : postInvoice.getDeactivatedAt());
        TextView textView = (TextView) this.this$0._$_findCachedViewById(C0010R$id.mainDescriptionTextView);
        Intrinsics.checkExpressionValueIsNotNull(textView, "mainDescriptionTextView");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("회원님의 포스트가 수정요청일로부터\n3일 내 수정되지 않거나 수정사항이 미흡하여\n");
        sb2.append(format);
        sb2.append("에 자동 삭제처리 되었습니다.\n다음에 더 좋은 포스팅으로 만나요❤");
        textView.setText(sb2.toString());
        TextView textView2 = (TextView) this.this$0._$_findCachedViewById(C0010R$id.postTitleTextView);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "postTitleTextView");
        textView2.setText(postInvoice.getPost().getTitle());
        TextView textView3 = (TextView) this.this$0._$_findCachedViewById(C0010R$id.deletePostReasonTextView);
        Intrinsics.checkExpressionValueIsNotNull(textView3, "deletePostReasonTextView");
        textView3.setText(postInvoice.getDescription());
    }
}
