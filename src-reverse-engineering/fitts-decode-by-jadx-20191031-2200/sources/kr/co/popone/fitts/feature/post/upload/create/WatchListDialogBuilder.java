package kr.co.popone.fitts.feature.post.upload.create;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.ui.DialogExtensions;
import org.jetbrains.annotations.NotNull;

public final class WatchListDialogBuilder {
    public static final WatchListDialogBuilder INSTANCE = new WatchListDialogBuilder();

    private WatchListDialogBuilder() {
    }

    public final void showDialog(@NotNull Context context, int i) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        DialogExtensions dialogExtensions = DialogExtensions.INSTANCE;
        StringBuilder sb = new StringBuilder();
        sb.append("잠시 쉬었다 포스팅해 주세요.\n(");
        sb.append(i);
        sb.append("시간 뒤에 시도해주세요)");
        Context context2 = context;
        DialogExtensions.showMessageDialog$default(dialogExtensions, context2, "도배는 아니 되어요😭", sb.toString(), null, "확인", 8, null);
    }
}
