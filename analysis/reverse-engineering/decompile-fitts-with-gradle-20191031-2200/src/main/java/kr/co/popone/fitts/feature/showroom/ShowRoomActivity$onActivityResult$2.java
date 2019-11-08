package kr.co.popone.fitts.feature.showroom;

import android.content.Intent;
import android.os.Message;
import com.orhanobut.logger.Logger;
import io.reactivex.functions.BiConsumer;
import kr.co.popone.fitts.base.AppManager;
import kr.co.popone.fitts.feature.intro.IntroActivity;
import kr.co.popone.fitts.utils.Snackbar;
import org.simple.eventbus.EventBus;
import retrofit2.HttpException;

final class ShowRoomActivity$onActivityResult$2<T1, T2> implements BiConsumer<String, Throwable> {
    final /* synthetic */ ShowRoomActivity this$0;

    ShowRoomActivity$onActivityResult$2(ShowRoomActivity showRoomActivity) {
        this.this$0 = showRoomActivity;
    }

    public final void accept(String str, Throwable th) {
        this.this$0.uploadShowRoomImageRequest = null;
        if (str != null) {
            Message message = new Message();
            message.what = 5;
            EventBus.getDefault().post(message, AppManager.SHOWROOM_MESSAGE);
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
