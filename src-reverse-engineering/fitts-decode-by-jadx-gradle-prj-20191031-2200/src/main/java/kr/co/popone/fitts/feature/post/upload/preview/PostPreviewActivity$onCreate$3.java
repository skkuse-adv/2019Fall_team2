package kr.co.popone.fitts.feature.post.upload.preview;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import com.google.gson.Gson;
import com.orhanobut.logger.Logger;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0001R$anim;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.event.MyPostModifiedEvent;
import kr.co.popone.fitts.event.RxBus;
import kr.co.popone.fitts.eventtracker.EventTracker.CustomAttributes;
import kr.co.popone.fitts.feature.main.MainActivity;
import kr.co.popone.fitts.feature.post.PostFirstWriteNoticeActivity;
import kr.co.popone.fitts.feature.post.ProfileInputActivity;
import kr.co.popone.fitts.feature.post.UserSizeInputActivity;
import kr.co.popone.fitts.feature.post.upload.preview.PostPreviewActivity.PreviewType;
import kr.co.popone.fitts.feature.post.upload.preview.PostPreviewActivity.WhenMappings;
import kr.co.popone.fitts.model.datamodel.service.post.CreatePostImage;
import kr.co.popone.fitts.model.datamodel.service.user.MyInfo;
import kr.co.popone.fitts.model.post.PostAPI;
import kr.co.popone.fitts.model.post.PostAPI.CreatePost;
import kr.co.popone.fitts.model.post.PostAPI.PostContent;
import kr.co.popone.fitts.model.post.PostAPI.PostId;
import kr.co.popone.fitts.model.post.PostAPI.ResponseImageId;
import kr.co.popone.fitts.model.post.PostAPIKt;
import kr.co.popone.fitts.model.post.PostVariantViewData;
import kr.co.popone.fitts.utils.Snackbar;
import org.jetbrains.anko.internals.AnkoInternals;
import org.jetbrains.annotations.NotNull;

final class PostPreviewActivity$onCreate$3 implements OnClickListener {
    final /* synthetic */ CreatePost $createPost;
    final /* synthetic */ PostPreviewActivity this$0;

    PostPreviewActivity$onCreate$3(PostPreviewActivity postPreviewActivity, CreatePost createPost) {
        this.this$0 = postPreviewActivity;
        this.$createPost = createPost;
    }

    public final void onClick(View view) {
        final PostVariantViewData postVariantViewData = (PostVariantViewData) this.this$0.getIntent().getParcelableExtra(PostPreviewActivity.Companion.getKEY_VARIANT_INFO());
        if (this.this$0.uploadPostRequest == null) {
            if (this.this$0.getPreviewType() != PreviewType.CreatePost) {
                this.this$0.getSessionManager$app_productionFittsRelease().setModifyPostTemporary(this.$createPost.getPostID(), "");
            } else if (this.this$0.requiresAdditionalInfo) {
                PostVariantViewData postVariantViewData2 = (PostVariantViewData) this.this$0.getIntent().getParcelableExtra(PostPreviewActivity.Companion.getKEY_VARIANT_INFO());
                PostPreviewActivity postPreviewActivity = this.this$0;
                postPreviewActivity.startActivityForResult(AnkoInternals.createIntent(postPreviewActivity, ProfileInputActivity.class, new Pair[]{TuplesKt.to(ProfileInputActivity.POST_DATA_PARAM, this.$createPost), TuplesKt.to(ProfileInputActivity.Companion.getKEY_VARIANT_INFO(), postVariantViewData2)}), 100);
                this.this$0.overridePendingTransition(C0001R$anim.slide_right, C0001R$anim.fade_out);
                return;
            } else {
                this.this$0.getSessionManager$app_productionFittsRelease().setIsPostTemporary(postVariantViewData != null ? Long.valueOf(postVariantViewData.getVariantId()) : null, false);
            }
            Button button = (Button) this.this$0._$_findCachedViewById(C0010R$id.create_post_button);
            Intrinsics.checkExpressionValueIsNotNull(button, "create_post_button");
            button.setEnabled(false);
            ProgressBar progressBar = (ProgressBar) this.this$0._$_findCachedViewById(C0010R$id.loading_apply);
            Intrinsics.checkExpressionValueIsNotNull(progressBar, "loading_apply");
            progressBar.setVisibility(0);
            this.this$0.uploadPostRequest = Observable.fromCallable(AnonymousClass1.INSTANCE).flatMap(new Function<T, ObservableSource<? extends R>>(this) {
                final /* synthetic */ PostPreviewActivity$onCreate$3 this$0;

                {
                    this.this$0 = r1;
                }

                @NotNull
                public final Observable<ResponseImageId> apply(@NotNull Unit unit) {
                    Intrinsics.checkParameterIsNotNull(unit, "it");
                    if (this.this$0.$createPost.getCoverID() == 0) {
                        PostPreviewActivity$onCreate$3 postPreviewActivity$onCreate$3 = this.this$0;
                        PostPreviewActivity postPreviewActivity = postPreviewActivity$onCreate$3.this$0;
                        return postPreviewActivity.fileUpload(postPreviewActivity.createImageMultipart(postPreviewActivity$onCreate$3.$createPost.getCoverImagePath()));
                    }
                    Observable<ResponseImageId> just = Observable.just(new ResponseImageId(this.this$0.$createPost.getCoverID()));
                    Intrinsics.checkExpressionValueIsNotNull(just, "Observable.just(PostAPI.…geId(createPost.coverID))");
                    return just;
                }
            }).flatMap(new Function<T, ObservableSource<? extends R>>(this) {
                final /* synthetic */ PostPreviewActivity$onCreate$3 this$0;

                {
                    this.this$0 = r1;
                }

                public final Observable<ArrayList<Observable<PostContent>>> apply(@NotNull ResponseImageId responseImageId) {
                    Intrinsics.checkParameterIsNotNull(responseImageId, "coverID");
                    this.this$0.$createPost.setCoverID(responseImageId.getId());
                    return Observable.fromCallable(new Callable<T>(this) {
                        final /* synthetic */ AnonymousClass3 this$0;

                        {
                            this.this$0 = r1;
                        }

                        @NotNull
                        public final ArrayList<Observable<PostContent>> call() {
                            ArrayList<Observable<PostContent>> arrayList = new ArrayList<>();
                            for (CreatePostImage createPostImage : this.this$0.this$0.$createPost.getFreeformImagesPath()) {
                                StringBuilder sb = new StringBuilder();
                                sb.append("createPost.freeformImagesPath image : ");
                                sb.append(createPostImage);
                                Logger.d(sb.toString(), new Object[0]);
                                if (createPostImage.getId() == null) {
                                    PostPreviewActivity postPreviewActivity = this.this$0.this$0.this$0;
                                    arrayList.add(postPreviewActivity.fileUpload(postPreviewActivity.createImageMultipart(createPostImage.getPath())).map(new PostPreviewActivity$onCreate$3$3$1$1$1(createPostImage)));
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
            }).flatMap(AnonymousClass4.INSTANCE).flatMap(new Function<T, ObservableSource<? extends R>>(this) {
                final /* synthetic */ PostPreviewActivity$onCreate$3 this$0;

                {
                    this.this$0 = r1;
                }

                public final Observable<PostId> apply(@NotNull List<PostContent> list) {
                    List<PostContent> list2 = list;
                    Intrinsics.checkParameterIsNotNull(list2, "postImages");
                    Gson gson = new Gson();
                    int i = WhenMappings.$EnumSwitchMapping$1[this.this$0.this$0.getPreviewType().ordinal()];
                    String str = "gson.toJson(createPost.styleTags)";
                    String str2 = "gson.toJson(createPost.tags)";
                    String str3 = "gson.toJson(postImages)";
                    if (i == 1) {
                        List listOf = CollectionsKt__CollectionsJVMKt.listOf(MapsKt__MapsJVMKt.mapOf(TuplesKt.to("group", PostAPIKt.toAPIValue(this.this$0.$createPost.getPostType()))));
                        PostAPI postAPI = this.this$0.this$0.getPostAPI();
                        String title = this.this$0.$createPost.getTitle();
                        String aboutFit = this.this$0.$createPost.getAboutFit();
                        String aboutProduct = this.this$0.$createPost.getAboutProduct();
                        String aboutSize = this.this$0.$createPost.getAboutSize();
                        int coverID = this.this$0.$createPost.getCoverID();
                        String json = gson.toJson((Object) list2);
                        Intrinsics.checkExpressionValueIsNotNull(json, str3);
                        float star = this.this$0.$createPost.getStar();
                        String json2 = gson.toJson((Object) this.this$0.$createPost.getTags());
                        Intrinsics.checkExpressionValueIsNotNull(json2, str2);
                        String json3 = gson.toJson((Object) this.this$0.$createPost.getStyleTags());
                        Intrinsics.checkExpressionValueIsNotNull(json3, str);
                        String shop = this.this$0.$createPost.getShop();
                        String json4 = gson.toJson((Object) listOf);
                        Intrinsics.checkExpressionValueIsNotNull(json4, "gson.toJson(categories)");
                        PostVariantViewData postVariantViewData = postVariantViewData;
                        return postAPI.uploadPost(title, aboutFit, aboutProduct, aboutSize, coverID, json, star, json2, json3, shop, json4, postVariantViewData == null ? null : Long.valueOf(postVariantViewData.getVariantId())).subscribeOn(Schedulers.io());
                    } else if (i == 2) {
                        PostAPI postAPI2 = this.this$0.this$0.getPostAPI();
                        long postID = this.this$0.$createPost.getPostID();
                        String title2 = this.this$0.$createPost.getTitle();
                        String aboutFit2 = this.this$0.$createPost.getAboutFit();
                        String aboutProduct2 = this.this$0.$createPost.getAboutProduct();
                        String aboutSize2 = this.this$0.$createPost.getAboutSize();
                        int coverID2 = this.this$0.$createPost.getCoverID();
                        String json5 = gson.toJson((Object) list2);
                        Intrinsics.checkExpressionValueIsNotNull(json5, str3);
                        float star2 = this.this$0.$createPost.getStar();
                        String json6 = gson.toJson((Object) this.this$0.$createPost.getTags());
                        Intrinsics.checkExpressionValueIsNotNull(json6, str2);
                        String json7 = gson.toJson((Object) this.this$0.$createPost.getStyleTags());
                        Intrinsics.checkExpressionValueIsNotNull(json7, str);
                        return postAPI2.patchPost(postID, title2, aboutFit2, aboutProduct2, aboutSize2, coverID2, json5, star2, json6, json7, this.this$0.$createPost.getShop()).subscribeOn(Schedulers.io());
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                }
            }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<PostId>(this) {
                final /* synthetic */ PostPreviewActivity$onCreate$3 this$0;

                {
                    this.this$0 = r1;
                }

                public final void accept(PostId postId) {
                    int component1 = postId.component1();
                    StringBuilder sb = new StringBuilder();
                    sb.append("후기 등록 성공 : 후기 ID-> ");
                    sb.append(component1);
                    Logger.d(sb.toString(), new Object[0]);
                    String str = null;
                    this.this$0.this$0.uploadPostRequest = null;
                    ProgressBar progressBar = (ProgressBar) this.this$0.this$0._$_findCachedViewById(C0010R$id.loading_apply);
                    Intrinsics.checkExpressionValueIsNotNull(progressBar, "loading_apply");
                    progressBar.setVisibility(8);
                    Button button = (Button) this.this$0.this$0._$_findCachedViewById(C0010R$id.create_post_button);
                    Intrinsics.checkExpressionValueIsNotNull(button, "create_post_button");
                    Boolean valueOf = Boolean.valueOf(true);
                    button.setEnabled(true);
                    int i = WhenMappings.$EnumSwitchMapping$2[this.this$0.this$0.getPreviewType().ordinal()];
                    String str2 = "method";
                    String str3 = "Posting";
                    if (i == 1) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("sessionManager.userInfo.bodyInfo  ");
                        MyInfo userInfo = this.this$0.this$0.getSessionManager$app_productionFittsRelease().getUserInfo();
                        sb2.append(userInfo != null ? userInfo.getBodyInfo() : null);
                        Logger.d(sb2.toString(), new Object[0]);
                        MyInfo userInfo2 = this.this$0.this$0.getSessionManager$app_productionFittsRelease().getUserInfo();
                        if (userInfo2 != null) {
                            str = userInfo2.getVerifyState();
                        }
                        if (Intrinsics.areEqual((Object) str, (Object) "verified")) {
                            MyInfo userInfo3 = this.this$0.this$0.getSessionManager$app_productionFittsRelease().getUserInfo();
                            String str4 = "ActivityOptionsCompat.ma…lide_up, R.anim.fade_out)";
                            if (userInfo3 == null || !userInfo3.getRequiredClothesSize()) {
                                MyInfo userInfo4 = this.this$0.this$0.getSessionManager$app_productionFittsRelease().getUserInfo();
                                if (userInfo4 == null || !userInfo4.getRequiredShoeSize()) {
                                    ActivityOptionsCompat makeCustomAnimation = ActivityOptionsCompat.makeCustomAnimation(this.this$0.this$0, C0001R$anim.slide_up, C0001R$anim.fade_out);
                                    Intrinsics.checkExpressionValueIsNotNull(makeCustomAnimation, str4);
                                    PostPreviewActivity postPreviewActivity = this.this$0.this$0;
                                    Intent createIntent = AnkoInternals.createIntent(postPreviewActivity, MainActivity.class, new Pair[]{TuplesKt.to(MainActivity.PARAMETER_SHOW_REVIEW_DIALOG, valueOf), TuplesKt.to(MainActivity.PARAMETER_GOTO_MY_SHOWROOM, valueOf)});
                                    createIntent.addFlags(67108864);
                                    postPreviewActivity.startActivity(createIntent, makeCustomAnimation.toBundle());
                                    this.this$0.this$0.getEventTracker$app_productionFittsRelease().logCustom(str3, new CustomAttributes().put(str2, "create"));
                                    return;
                                }
                            }
                            ActivityOptionsCompat makeCustomAnimation2 = ActivityOptionsCompat.makeCustomAnimation(this.this$0.this$0, C0001R$anim.slide_up, C0001R$anim.fade_out);
                            Intrinsics.checkExpressionValueIsNotNull(makeCustomAnimation2, str4);
                            PostPreviewActivity postPreviewActivity2 = this.this$0.this$0;
                            ActivityCompat.startActivityForResult(postPreviewActivity2, AnkoInternals.createIntent(postPreviewActivity2, UserSizeInputActivity.class, new Pair[0]), 102, makeCustomAnimation2.toBundle());
                            return;
                        }
                        PostPreviewActivity postPreviewActivity3 = this.this$0.this$0;
                        postPreviewActivity3.startActivityForResult(AnkoInternals.createIntent(postPreviewActivity3, PostFirstWriteNoticeActivity.class, new Pair[0]), 101);
                    } else if (i == 2) {
                        this.this$0.this$0.setResult(-1, new Intent());
                        this.this$0.this$0.finish();
                        this.this$0.this$0.overridePendingTransition(C0001R$anim.fade_in, C0001R$anim.slide_down);
                        this.this$0.this$0.getEventTracker$app_productionFittsRelease().logCustom(str3, new CustomAttributes().put(str2, "edit"));
                        RxBus.INSTANCE.post(new MyPostModifiedEvent(this.this$0.$createPost.getPostID()));
                    }
                }
            }, new Consumer<Throwable>(this) {
                final /* synthetic */ PostPreviewActivity$onCreate$3 this$0;

                {
                    this.this$0 = r1;
                }

                public final void accept(Throwable th) {
                    if ((th instanceof SocketTimeoutException) && this.this$0.this$0.isNewPost) {
                        this.this$0.$createPost.setCoverID(0);
                    }
                    this.this$0.this$0.uploadPostRequest = null;
                    ProgressBar progressBar = (ProgressBar) this.this$0.this$0._$_findCachedViewById(C0010R$id.loading_apply);
                    Intrinsics.checkExpressionValueIsNotNull(progressBar, "loading_apply");
                    progressBar.setVisibility(8);
                    Button button = (Button) this.this$0.this$0._$_findCachedViewById(C0010R$id.create_post_button);
                    Intrinsics.checkExpressionValueIsNotNull(button, "create_post_button");
                    button.setEnabled(true);
                    Logger.e(th.toString(), new Object[0]);
                    Snackbar.Companion.showMessage(this.this$0.this$0, "죄송합니다.\n서비스가 잠시 지연되고 있습니다.\n잠시 후 다시 이용해주세요.");
                }
            });
        }
    }
}
