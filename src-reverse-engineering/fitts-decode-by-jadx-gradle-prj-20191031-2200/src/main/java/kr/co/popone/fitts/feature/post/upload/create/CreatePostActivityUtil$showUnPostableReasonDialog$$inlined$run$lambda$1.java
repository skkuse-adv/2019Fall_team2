package kr.co.popone.fitts.feature.post.upload.create;

import android.app.Activity;
import kotlin.jvm.functions.Function0;
import kr.co.popone.fitts.feature.post.upload.create.BlackListDialogBuilder.Listener;
import kr.co.popone.fitts.model.user.UserAPI.PostableResponse;

public final class CreatePostActivityUtil$showUnPostableReasonDialog$$inlined$run$lambda$1 implements Listener {
    final /* synthetic */ Function0 $body$inlined;

    public void onCancel() {
    }

    CreatePostActivityUtil$showUnPostableReasonDialog$$inlined$run$lambda$1(PostableResponse postableResponse, boolean z, Activity activity, Function0 function0) {
        this.$body$inlined = function0;
    }

    public void onConfirm() {
        this.$body$inlined.invoke();
    }
}
