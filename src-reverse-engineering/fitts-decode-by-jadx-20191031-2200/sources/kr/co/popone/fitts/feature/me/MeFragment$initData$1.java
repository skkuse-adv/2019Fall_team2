package kr.co.popone.fitts.feature.me;

import android.content.Intent;
import com.orhanobut.logger.Logger;
import io.reactivex.functions.BiConsumer;
import kr.co.popone.fitts.feature.intro.IntroActivity;
import kr.co.popone.fitts.model.datamodel.service.user.MyInfo;
import retrofit2.HttpException;

final class MeFragment$initData$1<T1, T2> implements BiConsumer<MyInfo, Throwable> {
    final /* synthetic */ MeFragment this$0;

    MeFragment$initData$1(MeFragment meFragment) {
        this.this$0 = meFragment;
    }

    public final void accept(MyInfo myInfo, Throwable th) {
        this.this$0.userInfoRequest = null;
        this.this$0.userInfo = null;
        this.this$0.userInfo = myInfo;
        if (myInfo != null) {
            MeFragment meFragment = this.this$0;
            meFragment.initViewByData(meFragment.userInfo);
            this.this$0.getSessionManager$app_productionFittsRelease().setUserInfo(myInfo);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("error occured ");
        sb.append(th);
        Logger.d(sb.toString(), new Object[0]);
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
