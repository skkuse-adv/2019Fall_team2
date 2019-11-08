package kr.co.popone.fitts.feature.setting;

import android.content.Intent;
import com.orhanobut.logger.Logger;
import io.reactivex.functions.BiConsumer;
import kr.co.popone.fitts.feature.intro.IntroActivity;
import kr.co.popone.fitts.model.datamodel.service.user.MyInfo;
import kr.co.popone.fitts.utils.Snackbar;
import retrofit2.HttpException;

final class ModifyUserInfoActivity$requestUserInfo$1<T1, T2> implements BiConsumer<MyInfo, Throwable> {
    final /* synthetic */ ModifyUserInfoActivity this$0;

    ModifyUserInfoActivity$requestUserInfo$1(ModifyUserInfoActivity modifyUserInfoActivity) {
        this.this$0 = modifyUserInfoActivity;
    }

    public final void accept(MyInfo myInfo, Throwable th) {
        this.this$0.userInfoDisposable = null;
        if (myInfo != null) {
            this.this$0.initializeUserInfoUI(myInfo);
            return;
        }
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
    }
}
