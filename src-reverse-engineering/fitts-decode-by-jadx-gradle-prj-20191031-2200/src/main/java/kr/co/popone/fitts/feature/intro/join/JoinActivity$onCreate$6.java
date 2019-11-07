package kr.co.popone.fitts.feature.intro.join;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.core.app.ActivityOptionsCompat;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0001R$anim;
import kr.co.popone.fitts.feature.WebActivity;
import org.jetbrains.anko.internals.AnkoInternals;

final class JoinActivity$onCreate$6 implements OnClickListener {
    final /* synthetic */ JoinActivity this$0;

    JoinActivity$onCreate$6(JoinActivity joinActivity) {
        this.this$0 = joinActivity;
    }

    public final void onClick(View view) {
        ActivityOptionsCompat makeCustomAnimation = ActivityOptionsCompat.makeCustomAnimation(this.this$0, C0001R$anim.slide_up, C0001R$anim.fade_out);
        Intrinsics.checkExpressionValueIsNotNull(makeCustomAnimation, "ActivityOptionsCompat.ma…lide_up, R.anim.fade_out)");
        JoinActivity joinActivity = this.this$0;
        joinActivity.startActivity(AnkoInternals.createIntent(joinActivity, WebActivity.class, new Pair[]{TuplesKt.to("shop_url", "https://fitts.co.kr/terms"), TuplesKt.to("shop_name", "이용약관"), TuplesKt.to("join_use", Boolean.valueOf(true))}), makeCustomAnimation.toBundle());
    }
}
