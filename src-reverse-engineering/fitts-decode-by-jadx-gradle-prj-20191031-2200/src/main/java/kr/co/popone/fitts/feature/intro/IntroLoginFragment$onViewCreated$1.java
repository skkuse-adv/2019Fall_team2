package kr.co.popone.fitts.feature.intro;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.login.LoginManager;
import java.util.Collection;

final class IntroLoginFragment$onViewCreated$1 implements OnClickListener {
    final /* synthetic */ IntroLoginFragment this$0;

    IntroLoginFragment$onViewCreated$1(IntroLoginFragment introLoginFragment) {
        this.this$0 = introLoginFragment;
    }

    public final void onClick(View view) {
        LoginManager.getInstance().logInWithReadPermissions((Activity) this.this$0.getActivity(), (Collection<String>) CollectionsKt__CollectionsKt.listOf("public_profile", "email"));
    }
}
