package kr.co.popone.fitts.feature.store.newest;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.OnScrollListener;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class StoreNewFeedFragment$onViewCreated$$inlined$apply$lambda$1 extends OnScrollListener {
    final /* synthetic */ StoreNewFeedFragment this$0;

    StoreNewFeedFragment$onViewCreated$$inlined$apply$lambda$1(StoreNewFeedFragment storeNewFeedFragment) {
        this.this$0 = storeNewFeedFragment;
    }

    public void onScrolled(@NotNull RecyclerView recyclerView, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, i, i2);
        View findChildViewUnder = recyclerView.findChildViewUnder((float) i, (float) i2);
        if (findChildViewUnder != null) {
            this.this$0.getVm().recordCurrentPostion(recyclerView.getChildAdapterPosition(findChildViewUnder));
        }
    }
}
