package kr.co.popone.fitts.feature.showroom;

import android.view.View;
import android.view.View.OnClickListener;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.showroom.ShowRoomAdapter.Delegate;
import kr.co.popone.fitts.model.datamodel.service.user.ShowRoom;
import kr.co.popone.fitts.model.datamodel.service.user.User;

final class ShowRoomAdapter$onBindViewHolder$4 implements OnClickListener {
    final /* synthetic */ ShowRoomAdapter this$0;

    ShowRoomAdapter$onBindViewHolder$4(ShowRoomAdapter showRoomAdapter) {
        this.this$0 = showRoomAdapter;
    }

    public final void onClick(View view) {
        Delegate access$getDelegate$p = this.this$0.delegate;
        ShowRoom userInfo = this.this$0.delegate.getUserInfo();
        if (userInfo == null) {
            Intrinsics.throwNpe();
        }
        User user = userInfo.getUser();
        Intrinsics.checkExpressionValueIsNotNull(view, "it");
        access$getDelegate$p.onFollowClicked(user, view);
    }
}
