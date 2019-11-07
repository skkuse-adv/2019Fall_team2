package kr.co.popone.fitts.feature.post.upload.create;

import com.orhanobut.logger.Logger;
import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.utils.Snackbar;

final class CreatePostActivity$onCreate$72<T> implements Consumer<Throwable> {
    final /* synthetic */ CreatePostActivity this$0;

    CreatePostActivity$onCreate$72(CreatePostActivity createPostActivity) {
        this.this$0 = createPostActivity;
    }

    public final void accept(Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append("error occured ");
        sb.append(th);
        Logger.d(sb.toString(), new Object[0]);
        Snackbar.Companion.showMessage(this.this$0, "죄송합니다.\n서비스가 잠시 지연되고 있습니다.\n잠시 후 다시 이용해주세요.");
    }
}
