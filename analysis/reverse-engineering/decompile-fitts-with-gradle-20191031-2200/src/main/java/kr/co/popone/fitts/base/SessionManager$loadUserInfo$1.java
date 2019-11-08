package kr.co.popone.fitts.base;

import com.orhanobut.logger.Logger;
import io.reactivex.functions.BiConsumer;
import kr.co.popone.fitts.model.datamodel.service.user.MyInfo;

final class SessionManager$loadUserInfo$1<T1, T2> implements BiConsumer<MyInfo, Throwable> {
    final /* synthetic */ SessionManager this$0;

    SessionManager$loadUserInfo$1(SessionManager sessionManager) {
        this.this$0 = sessionManager;
    }

    public final void accept(MyInfo myInfo, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append("{myInfo: ");
        sb.append(myInfo);
        sb.append(", error: ");
        sb.append(th);
        sb.append('}');
        Logger.d(sb.toString(), new Object[0]);
        this.this$0.userInfoRequest = null;
        if (myInfo != null) {
            this.this$0.setUserInfo(myInfo);
        }
    }
}
