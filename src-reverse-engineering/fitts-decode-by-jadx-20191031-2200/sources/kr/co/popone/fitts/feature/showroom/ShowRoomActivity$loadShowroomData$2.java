package kr.co.popone.fitts.feature.showroom;

import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.datamodel.service.user.ShowRoom;
import kr.co.popone.fitts.model.post.PostAPI.Post;
import org.jetbrains.annotations.NotNull;

final class ShowRoomActivity$loadShowroomData$2<T, R> implements Function<T, SingleSource<? extends R>> {
    final /* synthetic */ ShowRoomActivity this$0;

    ShowRoomActivity$loadShowroomData$2(ShowRoomActivity showRoomActivity) {
        this.this$0 = showRoomActivity;
    }

    @NotNull
    public final Single<ArrayList<Post>> apply(@NotNull ShowRoom showRoom) {
        Intrinsics.checkParameterIsNotNull(showRoom, "it");
        return this.this$0.getUserAPI$app_productionFittsRelease().getShowRoomPosts(this.this$0.userID, "recent", null, this.this$0.getLimit()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}
