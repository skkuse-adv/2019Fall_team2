package kr.co.popone.fitts.feature.me;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.core.app.ActivityOptionsCompat;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0001R$anim;
import kr.co.popone.fitts.feature.setting.ModifyUserInfoActivity;

final class ModifyProfileActivity$onCreate$4 implements OnClickListener {
    final /* synthetic */ ModifyProfileActivity this$0;

    ModifyProfileActivity$onCreate$4(ModifyProfileActivity modifyProfileActivity) {
        this.this$0 = modifyProfileActivity;
    }

    public final void onClick(View view) {
        Intent intent = new Intent(this.this$0, ModifyUserInfoActivity.class);
        ActivityOptionsCompat makeCustomAnimation = ActivityOptionsCompat.makeCustomAnimation(this.this$0, C0001R$anim.slide_right, C0001R$anim.fade_out);
        Intrinsics.checkExpressionValueIsNotNull(makeCustomAnimation, "ActivityOptionsCompat.ma…e_right, R.anim.fade_out)");
        this.this$0.startActivity(intent, makeCustomAnimation.toBundle());
    }
}
