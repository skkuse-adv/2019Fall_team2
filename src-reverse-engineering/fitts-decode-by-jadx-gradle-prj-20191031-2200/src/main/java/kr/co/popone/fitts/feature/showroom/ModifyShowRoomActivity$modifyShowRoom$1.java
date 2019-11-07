package kr.co.popone.fitts.feature.showroom;

import android.content.Intent;
import android.os.Message;
import android.widget.Button;
import com.orhanobut.logger.Logger;
import io.reactivex.functions.BiConsumer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0001R$anim;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.base.AppManager;
import kr.co.popone.fitts.feature.intro.IntroActivity;
import kr.co.popone.fitts.model.datamodel.service.user.MyInfo;
import kr.co.popone.fitts.utils.Snackbar;
import org.simple.eventbus.EventBus;
import retrofit2.HttpException;

final class ModifyShowRoomActivity$modifyShowRoom$1<T1, T2> implements BiConsumer<MyInfo, Throwable> {
    final /* synthetic */ ModifyShowRoomActivity this$0;

    ModifyShowRoomActivity$modifyShowRoom$1(ModifyShowRoomActivity modifyShowRoomActivity) {
        this.this$0 = modifyShowRoomActivity;
    }

    public final void accept(MyInfo myInfo, Throwable th) {
        this.this$0.setShowroomInfoRequest = null;
        Button button = (Button) this.this$0._$_findCachedViewById(C0010R$id.modify_profile_button);
        Intrinsics.checkExpressionValueIsNotNull(button, "modify_profile_button");
        button.setEnabled(true);
        if (myInfo != null) {
            Message message = new Message();
            message.what = 5;
            EventBus.getDefault().post(message, AppManager.SHOWROOM_MESSAGE);
            this.this$0.finish();
            this.this$0.overridePendingTransition(C0001R$anim.fade_in, C0001R$anim.slide_left_out);
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
