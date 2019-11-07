package kr.co.popone.fitts.feature.intro;

import android.content.Context;
import androidx.core.app.ActivityOptionsCompat;
import io.reactivex.functions.Consumer;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0001R$anim;
import kr.co.popone.fitts.eventtracker.EventTracker.DefaultImpls;
import kr.co.popone.fitts.feature.intro.join.JoinActivity;
import kr.co.popone.fitts.model.user.UserAPI.EmailAvailable;
import kr.co.popone.fitts.ui.ToastExtensionKt;
import org.jetbrains.anko.internals.AnkoInternals;

final class IntroActivity$onEmailCheck$1<T> implements Consumer<EmailAvailable> {
    final /* synthetic */ String $email;
    final /* synthetic */ String $profileImage;
    final /* synthetic */ String $provider;
    final /* synthetic */ String $token;
    final /* synthetic */ IntroActivity this$0;

    IntroActivity$onEmailCheck$1(IntroActivity introActivity, String str, String str2, String str3, String str4) {
        this.this$0 = introActivity;
        this.$provider = str;
        this.$token = str2;
        this.$email = str3;
        this.$profileImage = str4;
    }

    public final void accept(EmailAvailable emailAvailable) {
        this.this$0.emailCheckRequest = null;
        if (!emailAvailable.is_available()) {
            ToastExtensionKt.showToast((Context) this.this$0, "이메일이 이미 사용중");
            return;
        }
        ActivityOptionsCompat makeCustomAnimation = ActivityOptionsCompat.makeCustomAnimation(this.this$0, C0001R$anim.slide_up, C0001R$anim.fade_out);
        Intrinsics.checkExpressionValueIsNotNull(makeCustomAnimation, "ActivityOptionsCompat.ma…lide_up, R.anim.fade_out)");
        IntroActivity introActivity = this.this$0;
        introActivity.startActivity(AnkoInternals.createIntent(introActivity, JoinActivity.class, new Pair[]{TuplesKt.to("provider", this.$provider), TuplesKt.to("token", this.$token), TuplesKt.to("email", this.$email), TuplesKt.to("profile_image", this.$profileImage)}), makeCustomAnimation.toBundle());
        DefaultImpls.logCustom$default(this.this$0.getEventTracker$app_productionFittsRelease(), "Enter ID Page For Sign Up", null, 2, null);
    }
}
