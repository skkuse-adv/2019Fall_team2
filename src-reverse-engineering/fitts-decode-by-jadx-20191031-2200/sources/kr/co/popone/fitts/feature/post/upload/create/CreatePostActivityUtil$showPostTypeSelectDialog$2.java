package kr.co.popone.fitts.feature.post.upload.create;

import com.orhanobut.logger.Logger;
import io.reactivex.functions.Consumer;

final class CreatePostActivityUtil$showPostTypeSelectDialog$2<T> implements Consumer<Throwable> {
    public static final CreatePostActivityUtil$showPostTypeSelectDialog$2 INSTANCE = new CreatePostActivityUtil$showPostTypeSelectDialog$2();

    CreatePostActivityUtil$showPostTypeSelectDialog$2() {
    }

    public final void accept(Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append("CreatePostActivityUtil::");
        sb.append(th.getMessage());
        Logger.e(sb.toString(), new Object[0]);
    }
}
