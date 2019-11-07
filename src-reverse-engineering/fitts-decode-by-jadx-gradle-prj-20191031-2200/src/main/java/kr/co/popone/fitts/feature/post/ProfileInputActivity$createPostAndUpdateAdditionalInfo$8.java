package kr.co.popone.fitts.feature.post;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.orhanobut.logger.Logger;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.eventtracker.EventTracker.CustomAttributes;
import kr.co.popone.fitts.model.post.PostAPI.PostId;

final class ProfileInputActivity$createPostAndUpdateAdditionalInfo$8<T> implements Consumer<PostId> {
    final /* synthetic */ ProfileInputActivity this$0;

    ProfileInputActivity$createPostAndUpdateAdditionalInfo$8(ProfileInputActivity profileInputActivity) {
        this.this$0 = profileInputActivity;
    }

    public final void accept(PostId postId) {
        int component1 = postId.component1();
        StringBuilder sb = new StringBuilder();
        sb.append("후기 등록 성공 : 후기 ID-> ");
        sb.append(component1);
        Logger.d(sb.toString(), new Object[0]);
        this.this$0.createPostRequest = null;
        this.this$0.setInputFieldsEnabled(true);
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) this.this$0._$_findCachedViewById(C0010R$id.swipeRefreshLayout);
        Intrinsics.checkExpressionValueIsNotNull(swipeRefreshLayout, "swipeRefreshLayout");
        swipeRefreshLayout.setRefreshing(false);
        this.this$0.showPostFirstWriteNotice();
        this.this$0.getEventTracker$app_productionFittsRelease().logCustom("Posting", new CustomAttributes().put("method", "create"));
    }
}
