package kr.co.popone.fitts.feature.intro;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.core.app.ActivityOptionsCompat;
import androidx.fragment.app.FragmentActivity;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0001R$anim;
import kr.co.popone.fitts.feature.main.MainActivity;
import org.jetbrains.anko.internals.AnkoInternals;

final class UserGuide3Fragment$onViewCreated$1 implements OnClickListener {
    final /* synthetic */ UserGuide3Fragment this$0;

    UserGuide3Fragment$onViewCreated$1(UserGuide3Fragment userGuide3Fragment) {
        this.this$0 = userGuide3Fragment;
    }

    public final void onClick(View view) {
        Context context = this.this$0.getContext();
        if (context == null) {
            Intrinsics.throwNpe();
        }
        ActivityOptionsCompat makeCustomAnimation = ActivityOptionsCompat.makeCustomAnimation(context, C0001R$anim.slide_right, C0001R$anim.fade_out);
        Intrinsics.checkExpressionValueIsNotNull(makeCustomAnimation, "ActivityOptionsCompat.ma…e_right, R.anim.fade_out)");
        UserGuide3Fragment userGuide3Fragment = this.this$0;
        Pair[] pairArr = new Pair[0];
        FragmentActivity requireActivity = userGuide3Fragment.requireActivity();
        Intrinsics.checkExpressionValueIsNotNull(requireActivity, "requireActivity()");
        Intent createIntent = AnkoInternals.createIntent(requireActivity, MainActivity.class, pairArr);
        createIntent.addFlags(32768);
        createIntent.addFlags(268435456);
        createIntent.addFlags(536870912);
        userGuide3Fragment.startActivity(createIntent, makeCustomAnimation.toBundle());
    }
}
