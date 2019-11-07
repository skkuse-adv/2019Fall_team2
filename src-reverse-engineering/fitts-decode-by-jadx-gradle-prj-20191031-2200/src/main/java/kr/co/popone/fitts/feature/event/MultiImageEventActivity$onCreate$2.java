package kr.co.popone.fitts.feature.event;

import com.orhanobut.logger.Logger;
import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.model.event.EventAPI.RemotePushContent;

final class MultiImageEventActivity$onCreate$2<T> implements Consumer<RemotePushContent> {
    final /* synthetic */ MultiImageEventActivity this$0;

    MultiImageEventActivity$onCreate$2(MultiImageEventActivity multiImageEventActivity) {
        this.this$0 = multiImageEventActivity;
    }

    public final void accept(RemotePushContent remotePushContent) {
        StringBuilder sb = new StringBuilder();
        sb.append("remotePushContentSubject subscribe ");
        sb.append(remotePushContent);
        Logger.d(sb.toString(), new Object[0]);
        this.this$0.getImagesAdapter().setRemotePushContent(remotePushContent);
    }
}
