package kr.co.popone.fitts.feature.showroom;

import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView.BufferType;
import com.orhanobut.logger.Logger;
import io.reactivex.functions.BiConsumer;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.feature.intro.IntroActivity;
import kr.co.popone.fitts.model.datamodel.service.user.ShowRoom;
import kr.co.popone.fitts.utils.ButtonExtensionsKt;
import kr.co.popone.fitts.utils.Snackbar;
import retrofit2.HttpException;

final class ModifyShowRoomActivity$getUserInfo$1<T1, T2> implements BiConsumer<ShowRoom, Throwable> {
    final /* synthetic */ ModifyShowRoomActivity this$0;

    ModifyShowRoomActivity$getUserInfo$1(ModifyShowRoomActivity modifyShowRoomActivity) {
        this.this$0 = modifyShowRoomActivity;
    }

    public final void accept(ShowRoom showRoom, Throwable th) {
        this.this$0.showroomInfoRequest = null;
        if (showRoom != null) {
            for (String str : showRoom.getUser().getStyles()) {
                int indexOf = this.this$0.getStyles().indexOf(str);
                if (indexOf >= 0) {
                    Button button = (Button) this.this$0.getStyleButtons().get(indexOf);
                    button.setSelected(true);
                    ButtonExtensionsKt.updateStyleButton(button);
                    this.this$0.selectedStyles.add(str);
                }
            }
            ((EditText) this.this$0._$_findCachedViewById(C0010R$id.showroom_intro)).setText(showRoom.getShowRoomIntro(), BufferType.EDITABLE);
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
