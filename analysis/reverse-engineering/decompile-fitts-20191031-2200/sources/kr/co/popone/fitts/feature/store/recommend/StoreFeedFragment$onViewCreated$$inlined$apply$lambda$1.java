package kr.co.popone.fitts.feature.store.recommend;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.OnScrollListener;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class StoreFeedFragment$onViewCreated$$inlined$apply$lambda$1 extends OnScrollListener {
    final /* synthetic */ StoreFeedFragment this$0;

    StoreFeedFragment$onViewCreated$$inlined$apply$lambda$1(StoreFeedFragment storeFeedFragment) {
        this.this$0 = storeFeedFragment;
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
