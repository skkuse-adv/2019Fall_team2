package kr.co.popone.fitts.feature.post.upload.create;

import android.app.Activity;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.post.upload.create.PostFirstWriteGuideDialogBuilder.Listener;
import kr.co.popone.fitts.services.FittsSchemeHandler;
import org.jetbrains.annotations.NotNull;

public final class CreatePostActivityUtil$createPost$1 implements Listener {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ Function0 $body;
    final /* synthetic */ CreatePostActivityUtil this$0;

    public void onCancel() {
    }

    CreatePostActivityUtil$createPost$1(CreatePostActivityUtil createPostActivityUtil, Function0 function0, Activity activity) {
        this.this$0 = createPostActivityUtil;
        this.$body = function0;
        this.$activity = activity;
    }

    public void onConfirm() {
        this.$body.invoke();
    }

    public boolean onScheme(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "scheme");
        FittsSchemeHandler schemeHandler = this.this$0.getSchemeHandler();
        if (schemeHandler != null) {
            return schemeHandler.handleScheme(this.$activity, str);
        }
        return false;
    }
}
