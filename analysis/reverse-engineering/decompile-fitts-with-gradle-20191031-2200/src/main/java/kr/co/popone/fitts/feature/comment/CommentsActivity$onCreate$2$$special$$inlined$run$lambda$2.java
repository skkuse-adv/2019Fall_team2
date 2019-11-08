package kr.co.popone.fitts.feature.comment;

import android.view.View;
import android.view.View.OnLayoutChangeListener;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

final class CommentsActivity$onCreate$2$$special$$inlined$run$lambda$2 implements OnLayoutChangeListener {
    final /* synthetic */ RecyclerView $this_run;
    final /* synthetic */ CommentsActivity$onCreate$2 this$0;

    CommentsActivity$onCreate$2$$special$$inlined$run$lambda$2(RecyclerView recyclerView, CommentsActivity$onCreate$2 commentsActivity$onCreate$2, ArrayList arrayList) {
        this.$this_run = recyclerView;
        this.this$0 = commentsActivity$onCreate$2;
    }

    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (i8 > i4) {
            this.$this_run.smoothScrollToPosition(this.this$0.this$0.commentItemList.size());
        }
    }
}
