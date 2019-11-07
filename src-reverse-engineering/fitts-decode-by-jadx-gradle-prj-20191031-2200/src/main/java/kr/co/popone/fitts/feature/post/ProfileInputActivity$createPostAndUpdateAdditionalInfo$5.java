package kr.co.popone.fitts.feature.post;

import com.orhanobut.logger.Logger;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.datamodel.service.post.CreatePostImage;
import kr.co.popone.fitts.model.post.PostAPI.CreatePost;
import kr.co.popone.fitts.model.post.PostAPI.PostContent;
import kr.co.popone.fitts.model.post.PostAPI.ResponseImageId;
import org.jetbrains.annotations.NotNull;

final class ProfileInputActivity$createPostAndUpdateAdditionalInfo$5<T, R> implements Function<T, ObservableSource<? extends R>> {
    final /* synthetic */ CreatePost $localPostData;
    final /* synthetic */ ProfileInputActivity this$0;

    ProfileInputActivity$createPostAndUpdateAdditionalInfo$5(ProfileInputActivity profileInputActivity, CreatePost createPost) {
        this.this$0 = profileInputActivity;
        this.$localPostData = createPost;
    }

    public final Observable<ArrayList<Observable<PostContent>>> apply(@NotNull ResponseImageId responseImageId) {
        Intrinsics.checkParameterIsNotNull(responseImageId, "coverID");
        this.$localPostData.setCoverID(responseImageId.getId());
        return Observable.fromCallable(new Callable<T>(this) {
            final /* synthetic */ ProfileInputActivity$createPostAndUpdateAdditionalInfo$5 this$0;

            {
                this.this$0 = r1;
            }

            @NotNull
            public final ArrayList<Observable<PostContent>> call() {
                ArrayList<Observable<PostContent>> arrayList = new ArrayList<>();
                for (CreatePostImage createPostImage : this.this$0.$localPostData.getFreeformImagesPath()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("createPost.freeformImagesPath image : ");
                    sb.append(createPostImage);
                    Logger.d(sb.toString(), new Object[0]);
                    if (createPostImage.getId() == null) {
                        ProfileInputActivity profileInputActivity = this.this$0.this$0;
                        arrayList.add(profileInputActivity.fileUpload(profileInputActivity.createImageMultipart(createPostImage.getPath())).map(new ProfileInputActivity$createPostAndUpdateAdditionalInfo$5$1$1$1(createPostImage)));
                    } else {
                        Integer id = createPostImage.getId();
                        if (id == null) {
                            Intrinsics.throwNpe();
                        }
                        arrayList.add(Observable.just(new PostContent(id.intValue(), createPostImage.getDescription())));
                    }
                }
                return arrayList;
            }
        }).subscribeOn(Schedulers.io());
    }
}
