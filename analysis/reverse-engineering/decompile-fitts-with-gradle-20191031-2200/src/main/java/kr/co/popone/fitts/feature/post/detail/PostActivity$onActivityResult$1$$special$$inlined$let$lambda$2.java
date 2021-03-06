package kr.co.popone.fitts.feature.post.detail;

import android.view.View;
import android.view.View.OnClickListener;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.showroom.ShowRoomActivity;
import kr.co.popone.fitts.model.datamodel.service.user.User;
import kr.co.popone.fitts.model.post.PostAPI.Post;
import kr.co.popone.fitts.utils.Snackbar;

final class PostActivity$onActivityResult$1$$special$$inlined$let$lambda$2 implements OnClickListener {
    final /* synthetic */ User $user;
    final /* synthetic */ PostActivity$onActivityResult$1 this$0;

    PostActivity$onActivityResult$1$$special$$inlined$let$lambda$2(User user, PostActivity$onActivityResult$1 postActivity$onActivityResult$1, Post post) {
        this.$user = user;
        this.this$0 = postActivity$onActivityResult$1;
    }

    public final void onClick(View view) {
        if (Intrinsics.areEqual((Object) this.$user.getStatus(), (Object) "deactivated")) {
            Snackbar.Companion.showMessage(this.this$0.this$0, "탈퇴한 사용자입니다");
            return;
        }
        this.this$0.this$0.hideKeyboard();
        ShowRoomActivity.Companion.start(this.this$0.this$0, Long.valueOf(this.$user.getId()), "post_detail");
    }
}
