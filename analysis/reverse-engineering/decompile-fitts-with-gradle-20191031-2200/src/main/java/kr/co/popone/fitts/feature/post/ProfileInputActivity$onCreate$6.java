package kr.co.popone.fitts.feature.post;

import android.view.View;
import android.view.View.OnClickListener;
import kotlin.Pair;
import kr.co.popone.fitts.feature.me.SizeGuideActivity;
import org.jetbrains.anko.internals.AnkoInternals;

final class ProfileInputActivity$onCreate$6 implements OnClickListener {
    final /* synthetic */ ProfileInputActivity this$0;

    ProfileInputActivity$onCreate$6(ProfileInputActivity profileInputActivity) {
        this.this$0 = profileInputActivity;
    }

    public final void onClick(View view) {
        ProfileInputActivity profileInputActivity = this.this$0;
        profileInputActivity.startActivity(AnkoInternals.createIntent(profileInputActivity, SizeGuideActivity.class, new Pair[0]));
    }
}
