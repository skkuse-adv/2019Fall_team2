package kr.co.popone.fitts.feature.post.detail;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.core.app.ActivityOptionsCompat;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0001R$anim;
import kr.co.popone.fitts.feature.showroom.ShowRoomActivity;
import kr.co.popone.fitts.model.datamodel.service.user.User;
import kr.co.popone.fitts.model.post.PostAPI.Post;
import kr.co.popone.fitts.utils.Snackbar;

final class PostActivity$onActivityResult$1$$special$$inlined$let$lambda$1 implements OnClickListener {
    final /* synthetic */ User $user$inlined;
    final /* synthetic */ PostActivity$onActivityResult$1 this$0;

    PostActivity$onActivityResult$1$$special$$inlined$let$lambda$1(User user, PostActivity$onActivityResult$1 postActivity$onActivityResult$1, Post post) {
        this.$user$inlined = user;
        this.this$0 = postActivity$onActivityResult$1;
    }

    public final void onClick(View view) {
        if (Intrinsics.areEqual((Object) this.$user$inlined.getStatus(), (Object) "deactivated")) {
            Snackbar.Companion.showMessage(this.this$0.this$0, "탈퇴한 사용자입니다");
            return;
        }
        Intent intent = new Intent(this.this$0.this$0, ShowRoomActivity.class);
        intent.putExtra("showroom_user_id", this.$user$inlined.getId());
        ActivityOptionsCompat makeCustomAnimation = ActivityOptionsCompat.makeCustomAnimation(this.this$0.this$0, C0001R$anim.slide_right, C0001R$anim.fade_out);
        Intrinsics.checkExpressionValueIsNotNull(makeCustomAnimation, "ActivityOptionsCompat.ma…e_right, R.anim.fade_out)");
        this.this$0.this$0.hideKeyboard();
        this.this$0.this$0.startActivity(intent, makeCustomAnimation.toBundle());
    }
}
