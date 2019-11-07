package kr.co.popone.fitts.feature.post.upload.viewmodel;

import android.content.Intent;
import androidx.annotation.ColorInt;
import com.google.gson.Gson;
import com.kakao.message.template.MessageTemplateProtocol;
import com.kakao.usermgmt.StringSet;
import io.fabric.sdk.android.services.settings.AppSettingsData;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0006R$color;
import kr.co.popone.fitts.C0008R$drawable;
import kr.co.popone.fitts.base.BaseViewModel;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.eventtracker.EventTracker.CustomAttributes;
import kr.co.popone.fitts.eventtracker.EventTracker.DefaultImpls;
import kr.co.popone.fitts.feature.post.upload.create.CreatePostActivity;
import kr.co.popone.fitts.feature.search.ShopSearchActivity.Result;
import kr.co.popone.fitts.model.datamodel.service.post.CreatePostImage;
import kr.co.popone.fitts.model.post.PostAPI;
import kr.co.popone.fitts.model.post.PostAPI.CreatePost;
import kr.co.popone.fitts.model.post.PostCoverImage;
import kr.co.popone.fitts.model.post.PostDetailImage;
import kr.co.popone.fitts.model.post.PostVariantViewData;
import kr.co.popone.fitts.model.post.PostViewData;
import kr.co.popone.fitts.model.post.PostViewData.PostMode;
import kr.co.popone.fitts.model.post.PostViewDataExtensionKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import photopicker.view.ImageSelectorActivity;

public final class CreatePostViewModel extends BaseViewModel {
    @NotNull
    private final BehaviorSubject<Integer> aboutFitErrorVisivility;
    @NotNull
    private final BehaviorSubject<ValidationTextColor> aboutFitValidate;
    @NotNull
    private final BehaviorSubject<ValidationTextColor> aboutSizeValidate;
    @NotNull
    private final PublishSubject<String> coverImageUpdated;
    @NotNull
    private final PublishSubject<Pair<Integer, Integer>> coverImageValidate;
    @NotNull
    private final PublishSubject<Integer> detailImageHintUpdated;
    @NotNull
    private final PublishSubject<ArrayList<PostDetailImage>> detailImageUpdated;
    @NotNull
    private final PublishSubject<Integer> detailImageValidate;
    @NotNull
    private final PublishSubject<Boolean> detailImageVisibility;
    @NotNull
    private final PublishSubject<Throwable> errorOccured;
    @NotNull
    private final EventTracker eventTracker;
    /* access modifiers changed from: private */
    public boolean isPostValidateMode;
    @NotNull
    private final PostAPI postAPI;
    @NotNull
    private final PublishSubject<PostViewData> postModelUpdated;
    @NotNull
    private final BehaviorSubject<ValidationEditDrawable> postTitleValidate;
    @NotNull
    private final PostViewData postViewData = new PostViewData();
    @NotNull
    private final SessionManager sessionManager;
    @NotNull
    private final BehaviorSubject<Integer> shopBlockValidate;
    @NotNull
    private final PublishSubject<String> shopLinkUpdated;
    @NotNull
    private final BehaviorSubject<ValidationTextColor> shopLinkValidate;
    @NotNull
    private final BehaviorSubject<ValidationTextColor> starScoreValidate;
    @NotNull
    private final PublishSubject<Pair<Integer, Boolean>> styleTagUpdated;
    @NotNull
    private final BehaviorSubject<ValidationTextColor> styleTagValidate;
    @NotNull
    private final PublishSubject<Integer> validateScroll;
    private final CompositeDisposable viewModelDisposable = new CompositeDisposable();

    public enum ValidationCoverRes {
        VALID(C0008R$drawable.button_insert_image, 17170443),
        INVALID(C0008R$drawable.button_insert_image_red, C0006R$color.neon_red);
        
        private final int captionColor;
        private final int drawable;

        private ValidationCoverRes(int i, @ColorInt int i2) {
            this.drawable = i;
            this.captionColor = i2;
        }

        public final int getCaptionColor() {
            return this.captionColor;
        }

        public final int getDrawable() {
            return this.drawable;
        }
    }

    public enum ValidationEditDrawable {
        VALID(C0008R$drawable.edit_text_post_title),
        INVALID(C0008R$drawable.edit_text_post_title_red);
        
        private final int drawable;

        private ValidationEditDrawable(int i) {
            this.drawable = i;
        }

        public final int getDrawable() {
            return this.drawable;
        }
    }

    public enum ValidationStyleTag {
        ADDED(Boolean.valueOf(true)),
        REMOVED(Boolean.valueOf(false)),
        NOTHING(null, 1, null);
        
        @Nullable
        private final Boolean isChecked;

        private ValidationStyleTag(Boolean bool) {
            this.isChecked = bool;
        }

        @Nullable
        public final Boolean isChecked() {
            return this.isChecked;
        }
    }

    public enum ValidationTextColor {
        VALID(C0006R$color.gray6),
        INVALID(C0006R$color.neon_red);
        
        private final int captionColor;

        private ValidationTextColor(@ColorInt int i) {
            this.captionColor = i;
        }

        public final int getCaptionColor() {
            return this.captionColor;
        }
    }

    @NotNull
    public final SessionManager getSessionManager() {
        return this.sessionManager;
    }

    @NotNull
    public final EventTracker getEventTracker() {
        return this.eventTracker;
    }

    public CreatePostViewModel(@NotNull SessionManager sessionManager2, @NotNull EventTracker eventTracker2, @NotNull PostAPI postAPI2) {
        Intrinsics.checkParameterIsNotNull(sessionManager2, "sessionManager");
        Intrinsics.checkParameterIsNotNull(eventTracker2, "eventTracker");
        Intrinsics.checkParameterIsNotNull(postAPI2, "postAPI");
        this.sessionManager = sessionManager2;
        this.eventTracker = eventTracker2;
        this.postAPI = postAPI2;
        PublishSubject<PostViewData> create = PublishSubject.create();
        Intrinsics.checkExpressionValueIsNotNull(create, "PublishSubject.create<PostViewData>()");
        this.postModelUpdated = create;
        PublishSubject<Throwable> create2 = PublishSubject.create();
        Intrinsics.checkExpressionValueIsNotNull(create2, "PublishSubject.create<Throwable>()");
        this.errorOccured = create2;
        BehaviorSubject<ValidationEditDrawable> createDefault = BehaviorSubject.createDefault(ValidationEditDrawable.VALID);
        Intrinsics.checkExpressionValueIsNotNull(createDefault, "BehaviorSubject.createDe…dationEditDrawable.VALID)");
        this.postTitleValidate = createDefault;
        BehaviorSubject<ValidationTextColor> createDefault2 = BehaviorSubject.createDefault(ValidationTextColor.VALID);
        String str = "BehaviorSubject.createDe…alidationTextColor.VALID)";
        Intrinsics.checkExpressionValueIsNotNull(createDefault2, str);
        this.starScoreValidate = createDefault2;
        BehaviorSubject<ValidationTextColor> createDefault3 = BehaviorSubject.createDefault(ValidationTextColor.VALID);
        Intrinsics.checkExpressionValueIsNotNull(createDefault3, str);
        this.aboutFitValidate = createDefault3;
        Integer valueOf = Integer.valueOf(8);
        BehaviorSubject<Integer> createDefault4 = BehaviorSubject.createDefault(valueOf);
        String str2 = "BehaviorSubject.createDefault(View.GONE)";
        Intrinsics.checkExpressionValueIsNotNull(createDefault4, str2);
        this.aboutFitErrorVisivility = createDefault4;
        BehaviorSubject<ValidationTextColor> createDefault5 = BehaviorSubject.createDefault(ValidationTextColor.VALID);
        Intrinsics.checkExpressionValueIsNotNull(createDefault5, str);
        this.aboutSizeValidate = createDefault5;
        BehaviorSubject<Integer> createDefault6 = BehaviorSubject.createDefault(valueOf);
        Intrinsics.checkExpressionValueIsNotNull(createDefault6, str2);
        this.shopBlockValidate = createDefault6;
        BehaviorSubject<ValidationTextColor> createDefault7 = BehaviorSubject.createDefault(ValidationTextColor.VALID);
        Intrinsics.checkExpressionValueIsNotNull(createDefault7, str);
        this.shopLinkValidate = createDefault7;
        PublishSubject<String> create3 = PublishSubject.create();
        String str3 = "PublishSubject.create<String>()";
        Intrinsics.checkExpressionValueIsNotNull(create3, str3);
        this.coverImageUpdated = create3;
        PublishSubject<Pair<Integer, Integer>> create4 = PublishSubject.create();
        Intrinsics.checkExpressionValueIsNotNull(create4, "PublishSubject.create<Pair<Int, Int>>()");
        this.coverImageValidate = create4;
        PublishSubject<ArrayList<PostDetailImage>> create5 = PublishSubject.create();
        Intrinsics.checkExpressionValueIsNotNull(create5, "PublishSubject.create<Ar…yList<PostDetailImage>>()");
        this.detailImageUpdated = create5;
        PublishSubject<Boolean> create6 = PublishSubject.create();
        Intrinsics.checkExpressionValueIsNotNull(create6, "PublishSubject.create<Boolean>()");
        this.detailImageVisibility = create6;
        PublishSubject<Integer> create7 = PublishSubject.create();
        String str4 = "PublishSubject.create<Int>()";
        Intrinsics.checkExpressionValueIsNotNull(create7, str4);
        this.detailImageHintUpdated = create7;
        PublishSubject<Integer> create8 = PublishSubject.create();
        Intrinsics.checkExpressionValueIsNotNull(create8, str4);
        this.detailImageValidate = create8;
        PublishSubject<Pair<Integer, Boolean>> create9 = PublishSubject.create();
        Intrinsics.checkExpressionValueIsNotNull(create9, "PublishSubject.create<Pair<Int, Boolean>>()");
        this.styleTagUpdated = create9;
        BehaviorSubject<ValidationTextColor> createDefault8 = BehaviorSubject.createDefault(ValidationTextColor.VALID);
        Intrinsics.checkExpressionValueIsNotNull(createDefault8, str);
        this.styleTagValidate = createDefault8;
        PublishSubject<String> create10 = PublishSubject.create();
        Intrinsics.checkExpressionValueIsNotNull(create10, str3);
        this.shopLinkUpdated = create10;
        PublishSubject<Integer> create11 = PublishSubject.create();
        Intrinsics.checkExpressionValueIsNotNull(create11, str4);
        this.validateScroll = create11;
    }

    @NotNull
    public final PostAPI getPostAPI() {
        return this.postAPI;
    }

    @NotNull
    public final PostViewData getPostViewData() {
        return this.postViewData;
    }

    public final void postDetailImageEditClicked(@NotNull Function1<? super ArrayList<CreatePostImage>, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "body");
        function1.invoke(PostViewDataExtensionKt.convertDetailImage(this.postViewData));
    }

    public final void postCoverImageInsertClicked(@NotNull Function1<? super String, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "body");
        function1.invoke(this.postViewData.getPostType());
    }

    public final void postDetailImageInsertClicked(@NotNull Function1<? super String, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "body");
        function1.invoke(this.postViewData.getPostType());
    }

    public final void searchShopButtonClicked(@NotNull Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "body");
        DefaultImpls.logCustom$default(this.eventTracker, "Search Product", null, 2, null);
        function0.invoke();
    }

    public final void helpButtonClicked(@NotNull Function1<? super String, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "body");
        function1.invoke(this.postViewData.getPostType());
    }

    public final void showShopWebViewClicked(@NotNull Function1<? super String, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "body");
        function1.invoke(this.postViewData.getShopUrl());
    }

    public final void closeButtonClicked(@NotNull Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "body");
        writeFabricLog("Cancel Posting", "from", "sheet");
        function1.invoke(Boolean.valueOf(PostViewDataExtensionKt.isNotPostEmpty(this.postViewData)));
    }

    @NotNull
    public final PublishSubject<PostViewData> getPostModelUpdated() {
        return this.postModelUpdated;
    }

    public final void loadCreatePostData(@NotNull Intent intent) {
        Intrinsics.checkParameterIsNotNull(intent, "intent");
        String stringExtra = intent.getStringExtra(CreatePostActivity.PARAMETER_POST_MODE);
        if (stringExtra != null) {
            int hashCode = stringExtra.hashCode();
            if (hashCode != -1068795718) {
                if (hashCode == 108960 && stringExtra.equals(AppSettingsData.STATUS_NEW)) {
                    CompositeDisposable compositeDisposable = this.viewModelDisposable;
                    Disposable subscribe = loadCreatePost(intent).subscribe((Consumer<? super T>) new CreatePostViewModel$loadCreatePostData$1<Object>(this));
                    Intrinsics.checkExpressionValueIsNotNull(subscribe, "loadCreatePost(intent)\n …st)\n                    }");
                    DisposableKt.plusAssign(compositeDisposable, subscribe);
                    return;
                }
            } else if (stringExtra.equals("modify")) {
                CompositeDisposable compositeDisposable2 = this.viewModelDisposable;
                Disposable subscribe2 = loadModifyPost(intent).doOnError(new CreatePostViewModel$loadCreatePostData$2(this)).subscribe((Consumer<? super T>) new CreatePostViewModel$loadCreatePostData$3<Object>(this));
                Intrinsics.checkExpressionValueIsNotNull(subscribe2, "loadModifyPost(intent)\n …st)\n                    }");
                DisposableKt.plusAssign(compositeDisposable2, subscribe2);
                return;
            }
        }
        throw new IllegalAccessException();
    }

    private final Single<PostViewData> loadCreatePost(Intent intent) {
        Single<PostViewData> create = Single.create(new CreatePostViewModel$loadCreatePost$1(this, intent));
        Intrinsics.checkExpressionValueIsNotNull(create, "Single.create{\n         …s(postViewData)\n        }");
        return create;
    }

    @NotNull
    public final PublishSubject<Throwable> getErrorOccured() {
        return this.errorOccured;
    }

    private final Single<PostViewData> loadModifyPost(Intent intent) {
        Single<PostViewData> create = Single.create(new CreatePostViewModel$loadModifyPost$1(this, intent));
        Intrinsics.checkExpressionValueIsNotNull(create, "Single.create { emitter …}\n            }\n        }");
        return create;
    }

    @NotNull
    public final BehaviorSubject<ValidationEditDrawable> getPostTitleValidate() {
        return this.postTitleValidate;
    }

    public final void postTitleChanged(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "title");
        this.postViewData.setTitle(str);
        CompositeDisposable compositeDisposable = this.viewModelDisposable;
        Disposable subscribe = PostViewDataExtensionKt.isPostTitleValidate(this.postViewData).filter(new CreatePostViewModel$postTitleChanged$1(this)).subscribe((Consumer<? super T>) new CreatePostViewModel$postTitleChanged$2<Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "postViewData.isPostTitle…(state)\n                }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    @NotNull
    public final BehaviorSubject<ValidationTextColor> getStarScoreValidate() {
        return this.starScoreValidate;
    }

    public final void ratingChanged(float f) {
        this.postViewData.setStarScore(f);
        CompositeDisposable compositeDisposable = this.viewModelDisposable;
        Disposable subscribe = PostViewDataExtensionKt.isStarScoreValidate(this.postViewData).filter(new CreatePostViewModel$ratingChanged$1(this)).subscribe((Consumer<? super T>) new CreatePostViewModel$ratingChanged$2<Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "postViewData.isStarScore…(state)\n                }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    @NotNull
    public final BehaviorSubject<ValidationTextColor> getAboutFitValidate() {
        return this.aboutFitValidate;
    }

    @NotNull
    public final BehaviorSubject<Integer> getAboutFitErrorVisivility() {
        return this.aboutFitErrorVisivility;
    }

    public final void aboutFitTextChanged(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "aboutFit");
        this.postViewData.setAboutFit(str);
        CompositeDisposable compositeDisposable = this.viewModelDisposable;
        Disposable subscribe = PostViewDataExtensionKt.isAboutFitValidate(this.postViewData).filter(new CreatePostViewModel$aboutFitTextChanged$1(this)).subscribe((Consumer<? super T>) new CreatePostViewModel$aboutFitTextChanged$2<Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "postViewData.isAboutFitV…ISIBLE)\n                }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    @NotNull
    public final BehaviorSubject<ValidationTextColor> getAboutSizeValidate() {
        return this.aboutSizeValidate;
    }

    public final void aboutSizeTextChanged(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "aboutSize");
        this.postViewData.setAboutSize(str);
        CompositeDisposable compositeDisposable = this.viewModelDisposable;
        Disposable subscribe = PostViewDataExtensionKt.isAboutSizeValidate(this.postViewData).filter(new CreatePostViewModel$aboutSizeTextChanged$1(this)).subscribe((Consumer<? super T>) new CreatePostViewModel$aboutSizeTextChanged$2<Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "postViewData.isAboutSize…(state)\n                }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    @NotNull
    public final BehaviorSubject<Integer> getShopBlockValidate() {
        return this.shopBlockValidate;
    }

    @NotNull
    public final BehaviorSubject<ValidationTextColor> getShopLinkValidate() {
        return this.shopLinkValidate;
    }

    public final void shopLinkTextChanged(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, MessageTemplateProtocol.LINK);
        this.postViewData.setShopUrl(str);
        CompositeDisposable compositeDisposable = this.viewModelDisposable;
        Disposable subscribe = PostViewDataExtensionKt.isBlockedShopLink(this.postViewData, this.postAPI).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new CreatePostViewModel$shopLinkTextChanged$1<Object,Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "postViewData.isBlockedSh…      }\n                }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    @NotNull
    public final PublishSubject<String> getCoverImageUpdated() {
        return this.coverImageUpdated;
    }

    public final void coverImageChanged(@NotNull Intent intent) {
        Intrinsics.checkParameterIsNotNull(intent, "intent");
        ArrayList stringArrayListExtra = intent.getStringArrayListExtra(ImageSelectorActivity.Companion.getREQUEST_OUTPUT());
        if (stringArrayListExtra != null && stringArrayListExtra.size() >= 1) {
            this.postViewData.getCoverImage().setCoverImageId(0);
            PostCoverImage coverImage = this.postViewData.getCoverImage();
            Object obj = stringArrayListExtra.get(0);
            Intrinsics.checkExpressionValueIsNotNull(obj, "images[0]");
            coverImage.setCoverImagePath((String) obj);
            this.coverImageUpdated.onNext(this.postViewData.getCoverImage().getCoverImagePath());
        }
    }

    public final void coverImageChanged(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "path");
        this.postViewData.getCoverImage().setCoverImagePath(str);
        this.coverImageUpdated.onNext(this.postViewData.getCoverImage().getCoverImagePath());
    }

    @NotNull
    public final PublishSubject<Pair<Integer, Integer>> getCoverImageValidate() {
        return this.coverImageValidate;
    }

    public final void isCoverImageValidate() {
        CompositeDisposable compositeDisposable = this.viewModelDisposable;
        Disposable subscribe = PostViewDataExtensionKt.isCoverImageValidate(this.postViewData).filter(new CreatePostViewModel$isCoverImageValidate$1(this)).subscribe((Consumer<? super T>) new CreatePostViewModel$isCoverImageValidate$2<Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "postViewData.isCoverImag…Color))\n                }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    @NotNull
    public final PublishSubject<ArrayList<PostDetailImage>> getDetailImageUpdated() {
        return this.detailImageUpdated;
    }

    @NotNull
    public final PublishSubject<Boolean> getDetailImageVisibility() {
        return this.detailImageVisibility;
    }

    @NotNull
    public final PublishSubject<Integer> getDetailImageHintUpdated() {
        return this.detailImageHintUpdated;
    }

    public final void detailImageChanged(@NotNull Intent intent) {
        Intrinsics.checkParameterIsNotNull(intent, "intent");
        ArrayList stringArrayListExtra = intent.getStringArrayListExtra(ImageSelectorActivity.Companion.getREQUEST_OUTPUT());
        if (stringArrayListExtra != null) {
            boolean z = true;
            if (stringArrayListExtra.size() >= 1) {
                PostViewDataExtensionKt.addDetailImages(this.postViewData, stringArrayListExtra);
                this.detailImageHintUpdated.onNext(Integer.valueOf(PostViewDataExtensionKt.detailImageString(this.postViewData)));
                PublishSubject<Boolean> publishSubject = this.detailImageVisibility;
                if (this.postViewData.getDetailImages().size() <= 0) {
                    z = false;
                }
                publishSubject.onNext(Boolean.valueOf(z));
                this.detailImageUpdated.onNext(this.postViewData.getDetailImages());
            }
        }
    }

    public final void detailImageEdited(@NotNull Intent intent) {
        Intrinsics.checkParameterIsNotNull(intent, "intent");
        Serializable serializableExtra = intent.getSerializableExtra("post_detail_data");
        if (serializableExtra != null) {
            PostViewDataExtensionKt.editDetailImages(this.postViewData, (ArrayList) serializableExtra);
            this.detailImageHintUpdated.onNext(Integer.valueOf(PostViewDataExtensionKt.detailImageString(this.postViewData)));
            this.detailImageVisibility.onNext(Boolean.valueOf(this.postViewData.getDetailImages().size() > 0));
            this.detailImageUpdated.onNext(this.postViewData.getDetailImages());
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.ArrayList<kr.co.popone.fitts.model.datamodel.service.post.CreatePostImage> /* = java.util.ArrayList<kr.co.popone.fitts.model.datamodel.service.post.CreatePostImage> */");
    }

    public final void detailImageReLoad() {
        this.detailImageHintUpdated.onNext(Integer.valueOf(PostViewDataExtensionKt.detailImageString(this.postViewData)));
        this.detailImageVisibility.onNext(Boolean.valueOf(this.postViewData.getDetailImages().size() > 0));
        this.detailImageUpdated.onNext(this.postViewData.getDetailImages());
    }

    @NotNull
    public final PublishSubject<Integer> getDetailImageValidate() {
        return this.detailImageValidate;
    }

    public final void isDetailImageValidate() {
        CompositeDisposable compositeDisposable = this.viewModelDisposable;
        Disposable subscribe = PostViewDataExtensionKt.isDetailImagesValidate(this.postViewData).filter(new CreatePostViewModel$isDetailImageValidate$1(this)).subscribe((Consumer<? super T>) new CreatePostViewModel$isDetailImageValidate$2<Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "postViewData.isDetailIma…nColor)\n                }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final void userTagAdded(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, StringSet.tag);
        PostViewDataExtensionKt.addUserTag(this.postViewData, str);
    }

    public final void userTagRemoved(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, StringSet.tag);
        PostViewDataExtensionKt.deleteUserTag(this.postViewData, str);
    }

    @NotNull
    public final PublishSubject<Pair<Integer, Boolean>> getStyleTagUpdated() {
        return this.styleTagUpdated;
    }

    public final void styleButtonClicked(int i, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "styleTag");
        CompositeDisposable compositeDisposable = this.viewModelDisposable;
        Disposable subscribe = PostViewDataExtensionKt.addFittsStyleTag(this.postViewData, str).subscribe((Consumer<? super T>) new CreatePostViewModel$styleButtonClicked$1<Object>(this, i));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "postViewData.addFittsSty…      }\n                }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    @NotNull
    public final BehaviorSubject<ValidationTextColor> getStyleTagValidate() {
        return this.styleTagValidate;
    }

    public final void isStyleButtonValidate() {
        CompositeDisposable compositeDisposable = this.viewModelDisposable;
        Disposable subscribe = PostViewDataExtensionKt.isStyleTagValidate(this.postViewData).filter(new CreatePostViewModel$isStyleButtonValidate$1(this)).subscribe((Consumer<? super T>) new CreatePostViewModel$isStyleButtonValidate$2<Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "postViewData.isStyleTagV…ext(it)\n                }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    @NotNull
    public final PublishSubject<String> getShopLinkUpdated() {
        return this.shopLinkUpdated;
    }

    public final void shopLinkChanged(@NotNull Intent intent) {
        Intrinsics.checkParameterIsNotNull(intent, "intent");
        this.postViewData.setShopUrl(((Result) intent.getParcelableExtra("result")).getUrl());
        this.shopLinkUpdated.onNext(this.postViewData.getShopUrl());
    }

    @NotNull
    public final PublishSubject<Integer> getValidateScroll() {
        return this.validateScroll;
    }

    public final void createPostButtonClicked(@NotNull Function3<? super PostMode, ? super CreatePost, ? super PostVariantViewData, Unit> function3) {
        Intrinsics.checkParameterIsNotNull(function3, "body");
        if (PostViewDataExtensionKt.isPostValidate(this.postViewData)) {
            this.isPostValidateMode = true;
            this.validateScroll.onNext(Integer.valueOf(PostViewDataExtensionKt.getScrolledPosition(this.postViewData)));
            postTitleChanged(this.postViewData.getTitle());
            ratingChanged(this.postViewData.getStarScore());
            aboutFitTextChanged(this.postViewData.getAboutFit());
            aboutSizeTextChanged(this.postViewData.getAboutSize());
            shopLinkTextChanged(this.postViewData.getShopUrl());
            isCoverImageValidate();
            isDetailImageValidate();
            isStyleButtonValidate();
            return;
        }
        function3.invoke(this.postViewData.getPostMode(), PostViewDataExtensionKt.convert(this.postViewData), this.postViewData.getPostVariantViewData());
    }

    public final void onPause() {
        if (PostViewDataExtensionKt.isNotPostEmpty(this.postViewData) && this.postViewData.getPostMode() == PostMode.CREATE) {
            String str = "Gson().toJson(postViewData.convert())";
            if (this.postViewData.getPostVariantViewData() == null) {
                SessionManager sessionManager2 = this.sessionManager;
                String json = new Gson().toJson((Object) PostViewDataExtensionKt.convert(this.postViewData));
                Intrinsics.checkExpressionValueIsNotNull(json, str);
                sessionManager2.setPostTemporary(json);
                return;
            }
            PostVariantViewData postVariantViewData = this.postViewData.getPostVariantViewData();
            if (postVariantViewData == null) {
                Intrinsics.throwNpe();
            }
            long variantId = postVariantViewData.getVariantId();
            SessionManager sessionManager3 = this.sessionManager;
            String json2 = new Gson().toJson((Object) PostViewDataExtensionKt.convert(this.postViewData));
            Intrinsics.checkExpressionValueIsNotNull(json2, str);
            sessionManager3.setPostableProductPostTemporary(variantId, json2);
        }
    }

    public final void onStop() {
        this.viewModelDisposable.clear();
    }

    public final void savePostTemporary(boolean z) {
        if (this.postViewData.getPostMode() == PostMode.CREATE) {
            SessionManager sessionManager2 = this.sessionManager;
            PostVariantViewData postVariantViewData = this.postViewData.getPostVariantViewData();
            sessionManager2.setIsPostTemporary(postVariantViewData != null ? Long.valueOf(postVariantViewData.getVariantId()) : null, z);
        } else if (z) {
            SessionManager sessionManager3 = this.sessionManager;
            long postId = this.postViewData.getPostId();
            String json = new Gson().toJson((Object) PostViewDataExtensionKt.convert(this.postViewData));
            Intrinsics.checkExpressionValueIsNotNull(json, "Gson().toJson(postViewData.convert())");
            sessionManager3.setModifyPostTemporary(postId, json);
        } else {
            this.sessionManager.setModifyPostTemporary(this.postViewData.getPostId(), "");
        }
    }

    private final void writeFabricLog(String str, String str2, String str3) {
        this.eventTracker.logCustom(str, new CustomAttributes().put(str2, str3));
    }
}
