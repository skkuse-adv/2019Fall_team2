package kr.co.popone.fitts.feature.showroom;

import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.event.MyPostDeletedEvent;
import kr.co.popone.fitts.event.MyPostModifiedEvent;

final class ShowRoomActivity$onCreate$5<T> implements Consumer<Object> {
    final /* synthetic */ ShowRoomActivity this$0;

    ShowRoomActivity$onCreate$5(ShowRoomActivity showRoomActivity) {
        this.this$0 = showRoomActivity;
    }

    public final void accept(Object obj) {
        if ((obj instanceof MyPostDeletedEvent) || (obj instanceof MyPostModifiedEvent)) {
            if (this.this$0._started) {
                this.this$0.loadShowroomData();
            } else {
                this.this$0.shouldReloadMyPosts = true;
            }
        }
    }
}
