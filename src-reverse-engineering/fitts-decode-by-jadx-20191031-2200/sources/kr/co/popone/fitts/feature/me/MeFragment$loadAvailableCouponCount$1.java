package kr.co.popone.fitts.feature.me;

import android.content.Intent;
import android.widget.TextView;
import com.orhanobut.logger.Logger;
import io.reactivex.functions.BiConsumer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.feature.intro.IntroActivity;
import kr.co.popone.fitts.model.coupon.CouponAPI.AvailableCouponCountResponse;
import retrofit2.HttpException;

final class MeFragment$loadAvailableCouponCount$1<T1, T2> implements BiConsumer<AvailableCouponCountResponse, Throwable> {
    final /* synthetic */ MeFragment this$0;

    MeFragment$loadAvailableCouponCount$1(MeFragment meFragment) {
        this.this$0 = meFragment;
    }

    public final void accept(AvailableCouponCountResponse availableCouponCountResponse, Throwable th) {
        this.this$0.availableCouponCountRequest = null;
        if (availableCouponCountResponse != null) {
            TextView textView = (TextView) this.this$0._$_findCachedViewById(C0010R$id.fittsCouponCountTextView);
            Intrinsics.checkExpressionValueIsNotNull(textView, "fittsCouponCountTextView");
            StringBuilder sb = new StringBuilder();
            sb.append(availableCouponCountResponse.getCount());
            sb.append(" 장");
            textView.setText(sb.toString());
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("error occured ");
        sb2.append(th);
        Logger.d(sb2.toString(), new Object[0]);
        if (!(th instanceof HttpException)) {
            this.this$0.showMessage("죄송합니다.\n서비스가 잠시 지연되고 있습니다.\n잠시 후 다시 이용해주세요.");
        } else if (((HttpException) th).code() == 401) {
            Intent intent = new Intent(this.this$0.getContext(), IntroActivity.class);
            intent.addFlags(32768);
            intent.addFlags(268435456);
            this.this$0.startActivity(intent);
        }
    }
}
