package kr.co.popone.fitts.feature.post.detail;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.core.app.ActivityOptionsCompat;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0001R$anim;
import kr.co.popone.fitts.eventtracker.EventTracker.DefaultImpls;
import kr.co.popone.fitts.feature.main.MainActivity;

final class PostActivity$onCreate$4 implements OnClickListener {
    final /* synthetic */ PostActivity this$0;

    PostActivity$onCreate$4(PostActivity postActivity) {
        this.this$0 = postActivity;
    }

    public final void onClick(View view) {
        DefaultImpls.logCustom$default(this.this$0.getEventTracker$app_productionFittsRelease(), "Tap Go Home At Post", null, 2, null);
        Intent intent = new Intent(this.this$0, MainActivity.class);
        intent.setFlags(131072);
        ActivityOptionsCompat makeCustomAnimation = ActivityOptionsCompat.makeCustomAnimation(this.this$0, C0001R$anim.fade_in, C0001R$anim.fade_out);
        Intrinsics.checkExpressionValueIsNotNull(makeCustomAnimation, "ActivityOptionsCompat.ma…fade_in, R.anim.fade_out)");
        this.this$0.hideKeyboard();
        this.this$0.startActivity(intent, makeCustomAnimation.toBundle());
    }
}
