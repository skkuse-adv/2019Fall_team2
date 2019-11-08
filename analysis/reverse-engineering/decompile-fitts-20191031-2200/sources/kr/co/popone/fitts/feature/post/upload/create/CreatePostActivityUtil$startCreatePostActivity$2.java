package kr.co.popone.fitts.feature.post.upload.create;

import com.orhanobut.logger.Logger;
import io.reactivex.functions.Consumer;

final class CreatePostActivityUtil$startCreatePostActivity$2<T> implements Consumer<Throwable> {
    public static final CreatePostActivityUtil$startCreatePostActivity$2 INSTANCE = new CreatePostActivityUtil$startCreatePostActivity$2();

    CreatePostActivityUtil$startCreatePostActivity$2() {
    }

    public final void accept(Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append("CreatePostActivityUtil::");
        sb.append(th);
        Logger.d(sb.toString(), new Object[0]);
    }
}
