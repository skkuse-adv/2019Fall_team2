package kr.co.popone.fitts.feature.showroom;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import io.reactivex.functions.BiConsumer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.model.datamodel.service.user.ShowRoom;

final class ShowRoomActivity$onReceive$5<T1, T2> implements BiConsumer<ShowRoom, Throwable> {
    final /* synthetic */ ShowRoomActivity this$0;

    ShowRoomActivity$onReceive$5(ShowRoomActivity showRoomActivity) {
        this.this$0 = showRoomActivity;
    }

    public final void accept(ShowRoom showRoom, Throwable th) {
        this.this$0.showRoomRequest = null;
        if (showRoom != null) {
            this.this$0.showRoomInfo = showRoom;
            RecyclerView recyclerView = (RecyclerView) this.this$0._$_findCachedViewById(C0010R$id.post_list);
            Intrinsics.checkExpressionValueIsNotNull(recyclerView, "post_list");
            Adapter adapter = recyclerView.getAdapter();
            if (adapter != null) {
                adapter.notifyItemChanged(0);
            }
        }
    }
}
