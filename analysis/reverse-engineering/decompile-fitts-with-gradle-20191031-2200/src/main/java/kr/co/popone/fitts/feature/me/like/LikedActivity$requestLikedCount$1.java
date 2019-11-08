package kr.co.popone.fitts.feature.me.like;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import com.orhanobut.logger.Logger;
import io.reactivex.functions.BiConsumer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.model.datamodel.service.user.MyInfo;

final class LikedActivity$requestLikedCount$1<T1, T2> implements BiConsumer<MyInfo, Throwable> {
    final /* synthetic */ LikedActivity this$0;

    LikedActivity$requestLikedCount$1(LikedActivity likedActivity) {
        this.this$0 = likedActivity;
    }

    public final void accept(MyInfo myInfo, Throwable th) {
        this.this$0.likeCountRequest = null;
        if (myInfo == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("error occured ");
            sb.append(th);
            Logger.d(sb.toString(), new Object[0]);
        } else if (myInfo.getLikesCount() != null) {
            LikedActivity likedActivity = this.this$0;
            Integer likesCount = myInfo.getLikesCount();
            if (likesCount == null) {
                Intrinsics.throwNpe();
            }
            likedActivity.setLikeCount(likesCount.intValue());
            RecyclerView recyclerView = (RecyclerView) this.this$0._$_findCachedViewById(C0010R$id.liked_list);
            Intrinsics.checkExpressionValueIsNotNull(recyclerView, "liked_list");
            Adapter adapter = recyclerView.getAdapter();
            if (adapter != null) {
                adapter.notifyItemChanged(0);
            }
        }
    }
}
