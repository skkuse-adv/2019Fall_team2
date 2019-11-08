package kr.co.popone.fitts.feature.event;

import android.content.Intent;
import androidx.core.app.ActivityOptionsCompat;
import io.reactivex.functions.BiConsumer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.identification.view.IdentificationActivity;
import kr.co.popone.fitts.model.datamodel.service.user.MyInfo;
import kr.co.popone.fitts.utils.ActivityAnimationType;

final class AppliableEventWinnerInputActivity$loadUserInfo$1<T1, T2> implements BiConsumer<MyInfo, Throwable> {
    final /* synthetic */ AppliableEventWinnerInputActivity this$0;

    AppliableEventWinnerInputActivity$loadUserInfo$1(AppliableEventWinnerInputActivity appliableEventWinnerInputActivity) {
        this.this$0 = appliableEventWinnerInputActivity;
    }

    public final void accept(MyInfo myInfo, Throwable th) {
        if (myInfo != null && myInfo.getRequiredIdentityVerify()) {
            Intent intent = new Intent(this.this$0, IdentificationActivity.class);
            ActivityOptionsCompat makeCustomAnimation = ActivityOptionsCompat.makeCustomAnimation(this.this$0, ActivityAnimationType.SLIDE_UP.getEnter(), ActivityAnimationType.SLIDE_UP.getExit());
            Intrinsics.checkExpressionValueIsNotNull(makeCustomAnimation, "ActivityOptionsCompat.ma…mationType.SLIDE_UP.exit)");
            this.this$0.startActivityForResult(intent, 201, makeCustomAnimation.toBundle());
        }
    }
}
