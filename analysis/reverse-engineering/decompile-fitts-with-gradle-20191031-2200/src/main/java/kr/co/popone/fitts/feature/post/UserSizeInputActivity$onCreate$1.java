package kr.co.popone.fitts.feature.post;

import android.view.View;
import android.view.View.OnClickListener;
import kotlin.Pair;
import kr.co.popone.fitts.feature.me.SizeGuideActivity;
import org.jetbrains.anko.internals.AnkoInternals;

final class UserSizeInputActivity$onCreate$1 implements OnClickListener {
    final /* synthetic */ UserSizeInputActivity this$0;

    UserSizeInputActivity$onCreate$1(UserSizeInputActivity userSizeInputActivity) {
        this.this$0 = userSizeInputActivity;
    }

    public final void onClick(View view) {
        UserSizeInputActivity userSizeInputActivity = this.this$0;
        userSizeInputActivity.startActivity(AnkoInternals.createIntent(userSizeInputActivity, SizeGuideActivity.class, new Pair[0]));
    }
}
