package kr.co.popone.fitts.feature.showroom;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.model.datamodel.service.user.ShowRoom;

final class ShowRoomAdapter$onBindViewHolder$5 implements OnClickListener {
    final /* synthetic */ ShowRoom $userInfo;
    final /* synthetic */ ShowRoomAdapter this$0;

    ShowRoomAdapter$onBindViewHolder$5(ShowRoomAdapter showRoomAdapter, ShowRoom showRoom) {
        this.this$0 = showRoomAdapter;
        this.$userInfo = showRoom;
    }

    public final void onClick(View view) {
        this.this$0.delegate.onFollowingCountClicked(this.$userInfo);
    }
}
