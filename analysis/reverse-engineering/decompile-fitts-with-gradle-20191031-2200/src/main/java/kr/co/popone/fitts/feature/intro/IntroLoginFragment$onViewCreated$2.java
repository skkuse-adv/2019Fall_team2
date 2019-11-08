package kr.co.popone.fitts.feature.intro;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.fragment.app.Fragment;
import com.kakao.auth.AuthType;
import com.kakao.auth.Session;

final class IntroLoginFragment$onViewCreated$2 implements OnClickListener {
    final /* synthetic */ IntroLoginFragment this$0;

    IntroLoginFragment$onViewCreated$2(IntroLoginFragment introLoginFragment) {
        this.this$0 = introLoginFragment;
    }

    public final void onClick(View view) {
        Session.getCurrentSession().open(AuthType.KAKAO_LOGIN_ALL, (Fragment) this.this$0);
    }
}
