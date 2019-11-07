package kr.co.popone.fitts.feature.post;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.post.PostAPI.CreatePost;
import kr.co.popone.fitts.model.post.PostAPI.ResponseImageId;
import org.jetbrains.annotations.NotNull;

final class ProfileInputActivity$createPostAndUpdateAdditionalInfo$4<T, R> implements Function<T, ObservableSource<? extends R>> {
    final /* synthetic */ CreatePost $localPostData;
    final /* synthetic */ ProfileInputActivity this$0;

    ProfileInputActivity$createPostAndUpdateAdditionalInfo$4(ProfileInputActivity profileInputActivity, CreatePost createPost) {
        this.this$0 = profileInputActivity;
        this.$localPostData = createPost;
    }

    @NotNull
    public final Observable<ResponseImageId> apply(@NotNull Unit unit) {
        Intrinsics.checkParameterIsNotNull(unit, "it");
        if (this.$localPostData.getCoverID() == 0) {
            ProfileInputActivity profileInputActivity = this.this$0;
            return profileInputActivity.fileUpload(profileInputActivity.createImageMultipart(this.$localPostData.getCoverImagePath()));
        }
        Observable<ResponseImageId> just = Observable.just(new ResponseImageId(this.$localPostData.getCoverID()));
        Intrinsics.checkExpressionValueIsNotNull(just, "Observable.just(PostAPI.…d(localPostData.coverID))");
        return just;
    }
}
