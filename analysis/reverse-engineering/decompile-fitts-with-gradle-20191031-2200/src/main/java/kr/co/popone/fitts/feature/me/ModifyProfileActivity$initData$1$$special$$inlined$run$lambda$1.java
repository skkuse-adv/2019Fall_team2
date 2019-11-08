package kr.co.popone.fitts.feature.me;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import androidx.core.app.ActivityOptionsCompat;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0001R$anim;
import kr.co.popone.fitts.feature.showroom.ModifyShowRoomActivity;

final class ModifyProfileActivity$initData$1$$special$$inlined$run$lambda$1 implements OnClickListener {
    final /* synthetic */ LinearLayout $this_run;
    final /* synthetic */ ModifyProfileActivity$initData$1 this$0;

    ModifyProfileActivity$initData$1$$special$$inlined$run$lambda$1(LinearLayout linearLayout, ModifyProfileActivity$initData$1 modifyProfileActivity$initData$1) {
        this.$this_run = linearLayout;
        this.this$0 = modifyProfileActivity$initData$1;
    }

    public final void onClick(View view) {
        Intent intent = new Intent(this.$this_run.getContext(), ModifyShowRoomActivity.class);
        ActivityOptionsCompat makeCustomAnimation = ActivityOptionsCompat.makeCustomAnimation(this.this$0.this$0, C0001R$anim.slide_right, C0001R$anim.fade_out);
        Intrinsics.checkExpressionValueIsNotNull(makeCustomAnimation, "ActivityOptionsCompat.ma…e_right, R.anim.fade_out)");
        this.this$0.this$0.startActivity(intent, makeCustomAnimation.toBundle());
    }
}
