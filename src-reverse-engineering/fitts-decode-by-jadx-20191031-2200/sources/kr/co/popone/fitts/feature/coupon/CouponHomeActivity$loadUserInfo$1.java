package kr.co.popone.fitts.feature.coupon;

import android.content.Intent;
import com.orhanobut.logger.Logger;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
import kr.co.popone.fitts.feature.intro.IntroActivity;
import kr.co.popone.fitts.model.datamodel.service.user.MyInfo;
import kr.co.popone.fitts.utils.Snackbar;
import retrofit2.HttpException;

final class CouponHomeActivity$loadUserInfo$1<T1, T2> implements BiConsumer<MyInfo, Throwable> {
    final /* synthetic */ CouponHomeActivity this$0;

    CouponHomeActivity$loadUserInfo$1(CouponHomeActivity couponHomeActivity) {
        this.this$0 = couponHomeActivity;
    }

    public final void accept(MyInfo myInfo, Throwable th) {
        if (myInfo == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("error occured ");
            sb.append(th);
            Logger.d(sb.toString(), new Object[0]);
            if (!(th instanceof HttpException)) {
                Snackbar.Companion.showMessage(this.this$0, "죄송합니다.\n서비스가 잠시 지연되고 있습니다.\n잠시 후 다시 이용해주세요.");
            } else if (((HttpException) th).code() == 401) {
                Intent intent = new Intent(this.this$0, IntroActivity.class);
                intent.addFlags(32768);
                intent.addFlags(268435456);
                this.this$0.startActivity(intent);
            }
        } else if (myInfo.getRequiredIdentityVerify()) {
            Observable.timer(300, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Consumer<? super T>) new Consumer<Long>(this) {
                final /* synthetic */ CouponHomeActivity$loadUserInfo$1 this$0;

                {
                    this.this$0 = r1;
                }

                public final void accept(Long l) {
                    this.this$0.this$0.startIdentificationActivity();
                }
            });
        }
    }
}
