package kr.co.popone.fitts.feature.event;

import com.orhanobut.logger.Logger;
import io.reactivex.functions.BiConsumer;
import kr.co.popone.fitts.model.event.EventAPI.RemotePushContent;

final class MultiImageEventActivity$onCreate$1<T1, T2> implements BiConsumer<RemotePushContent, Throwable> {
    final /* synthetic */ MultiImageEventActivity this$0;

    MultiImageEventActivity$onCreate$1(MultiImageEventActivity multiImageEventActivity) {
        this.this$0 = multiImageEventActivity;
    }

    public final void accept(RemotePushContent remotePushContent, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append("remotePushContentRequest ");
        sb.append(remotePushContent);
        sb.append(' ');
        sb.append(th);
        Logger.d(sb.toString(), new Object[0]);
        this.this$0.remotePushContentRequest = null;
        if (remotePushContent != null) {
            this.this$0.remotePushContentSubject.onNext(remotePushContent);
        }
    }
}
