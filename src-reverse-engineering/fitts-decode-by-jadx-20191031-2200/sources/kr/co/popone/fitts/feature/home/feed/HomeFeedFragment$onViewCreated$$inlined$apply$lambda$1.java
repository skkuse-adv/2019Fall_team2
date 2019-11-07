package kr.co.popone.fitts.feature.home.feed;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.OnScrollListener;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class HomeFeedFragment$onViewCreated$$inlined$apply$lambda$1 extends OnScrollListener {
    final /* synthetic */ HomeFeedFragment this$0;

    HomeFeedFragment$onViewCreated$$inlined$apply$lambda$1(HomeFeedFragment homeFeedFragment) {
        this.this$0 = homeFeedFragment;
    }

    public void onScrolled(@NotNull RecyclerView recyclerView, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, i, i2);
        View findChildViewUnder = recyclerView.findChildViewUnder((float) i, (float) i2);
        if (findChildViewUnder != null) {
            this.this$0.getViewModel().recordCurrentPostion(recyclerView.getChildAdapterPosition(findChildViewUnder));
        }
    }
}
