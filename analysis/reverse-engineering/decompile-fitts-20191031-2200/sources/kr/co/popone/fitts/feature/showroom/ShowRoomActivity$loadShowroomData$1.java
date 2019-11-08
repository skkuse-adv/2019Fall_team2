package kr.co.popone.fitts.feature.showroom;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.eventtracker.EventTracker.DefaultImpls;
import kr.co.popone.fitts.feature.post.PostType;
import kr.co.popone.fitts.model.datamodel.service.post.ImageFile;
import kr.co.popone.fitts.model.datamodel.service.user.ShowRoom;
import photopicker.view.ImageSelectorActivity;
import photopicker.view.ImageSelectorActivity.Companion;

final class ShowRoomActivity$loadShowroomData$1<T> implements Consumer<ShowRoom> {
    final /* synthetic */ ShowRoomActivity this$0;

    ShowRoomActivity$loadShowroomData$1(ShowRoomActivity showRoomActivity) {
        this.this$0 = showRoomActivity;
    }

    public final void accept(ShowRoom showRoom) {
        this.this$0.showRoomInfo = showRoom;
        TextView textView = (TextView) this.this$0._$_findCachedViewById(C0010R$id.showroom_title);
        Intrinsics.checkExpressionValueIsNotNull(textView, "showroom_title");
        textView.setText(showRoom.getUser().getFittsID());
        String str = "modify_showroom_cover_button";
        if (this.this$0.userID == this.this$0.getSessionManager$app_productionFittsRelease().getUserID()) {
            DefaultImpls.logCustom$default(this.this$0.getEventTracker$app_productionFittsRelease(), "View My ShowRoom", null, 2, null);
            this.this$0.setMine(true);
            ImageButton imageButton = (ImageButton) this.this$0._$_findCachedViewById(C0010R$id.modify_showroom_cover_button);
            Intrinsics.checkExpressionValueIsNotNull(imageButton, str);
            imageButton.setVisibility(0);
            ((ImageButton) this.this$0._$_findCachedViewById(C0010R$id.modify_showroom_cover_button)).setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ ShowRoomActivity$loadShowroomData$1 this$0;

                {
                    this.this$0 = r1;
                }

                public final void onClick(View view) {
                    Companion companion = ImageSelectorActivity.Companion;
                    Companion.start$default(companion, (Activity) this.this$0.this$0, companion.getMODE_SHOWROOM(), true, ImageFile.Companion.getTYPE_SHOW_ROOM(), 0, (PostType) null, 48, (Object) null);
                }
            });
        } else {
            DefaultImpls.logCustom$default(this.this$0.getEventTracker$app_productionFittsRelease(), "View ShowRoom", null, 2, null);
            ImageButton imageButton2 = (ImageButton) this.this$0._$_findCachedViewById(C0010R$id.modify_showroom_cover_button);
            Intrinsics.checkExpressionValueIsNotNull(imageButton2, str);
            imageButton2.setVisibility(8);
        }
        RecyclerView recyclerView = (RecyclerView) this.this$0._$_findCachedViewById(C0010R$id.post_list);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, "post_list");
        Adapter adapter = recyclerView.getAdapter();
        if (adapter != null) {
            adapter.notifyItemChanged(0);
        }
    }
}
