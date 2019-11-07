package kr.co.popone.fitts.base;

import com.orhanobut.logger.Logger;
import io.reactivex.functions.BiConsumer;
import kotlin.jvm.functions.Function0;
import kr.co.popone.fitts.model.datamodel.service.user.MyInfo;

final class SessionManager$loadUserInfo$2<T1, T2> implements BiConsumer<MyInfo, Throwable> {
    final /* synthetic */ Function0 $body;
    final /* synthetic */ SessionManager this$0;

    SessionManager$loadUserInfo$2(SessionManager sessionManager, Function0 function0) {
        this.this$0 = sessionManager;
        this.$body = function0;
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
            this.$body.invoke();
        }
    }
}
