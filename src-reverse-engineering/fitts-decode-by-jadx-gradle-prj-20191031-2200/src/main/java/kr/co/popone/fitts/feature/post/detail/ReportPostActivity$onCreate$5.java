package kr.co.popone.fitts.feature.post.detail;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import androidx.core.content.ContextCompat;
import kr.co.popone.fitts.C0006R$color;
import kr.co.popone.fitts.C0010R$id;

final class ReportPostActivity$onCreate$5 implements OnClickListener {
    final /* synthetic */ ReportPostActivity this$0;

    ReportPostActivity$onCreate$5(ReportPostActivity reportPostActivity) {
        this.this$0 = reportPostActivity;
    }

    public final void onClick(View view) {
        this.this$0.reportReason = "unsuitable";
        Button button = (Button) this.this$0._$_findCachedViewById(C0010R$id.report_done_button);
        button.setClickable(true);
        button.setBackgroundColor(ContextCompat.getColor(button.getContext(), C0006R$color.point));
    }
}
