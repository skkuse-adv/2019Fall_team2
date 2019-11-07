package kr.co.popone.fitts.feature.post.upload.create;

import android.app.Activity;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxkotlin.DisposableKt;
import io.reactivex.schedulers.Schedulers;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0016R$string;
import kr.co.popone.fitts.C0017R$style;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.eventtracker.EventTracker.CustomAttributes;
import kr.co.popone.fitts.feature.post.PostType;
import kr.co.popone.fitts.feature.post.dialog.PostTypeSelectDialog;
import kr.co.popone.fitts.model.datamodel.service.user.MyInfo;
import kr.co.popone.fitts.model.order.PostableOrderLineItemVariant;
import kr.co.popone.fitts.model.post.PostVariantViewData;
import kr.co.popone.fitts.model.repository.service.FittsServiceRepository;
import kr.co.popone.fitts.model.user.UserAPI;
import kr.co.popone.fitts.model.user.UserAPI.PostableResponse;
import kr.co.popone.fitts.model.user.UserAPI.PostableResponse.UnpostableReason;
import kr.co.popone.fitts.model.user.UserAPI.PostableResponse.UnpostableReason.Type;
import kr.co.popone.fitts.services.FittsSchemeHandler;
import kr.co.popone.fitts.ui.DialogExtensions;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CreatePostActivityUtil {
    private final CompositeDisposable disposables = new CompositeDisposable();
    private final EventTracker eventTracker;
    private final FittsServiceRepository fittsServiceRepository;
    @Nullable
    private FittsSchemeHandler schemeHandler;
    private final SessionManager sessionManager;
    private final UserAPI userAPI;

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = new int[Type.values().length];

        static {
            $EnumSwitchMapping$0[Type.WATCHLIST.ordinal()] = 1;
            $EnumSwitchMapping$0[Type.POSTING_LIMIT.ordinal()] = 2;
            $EnumSwitchMapping$0[Type.BLACKLIST.ordinal()] = 3;
        }
    }

    public CreatePostActivityUtil(@NotNull SessionManager sessionManager2, @NotNull UserAPI userAPI2, @NotNull FittsServiceRepository fittsServiceRepository2, @NotNull EventTracker eventTracker2) {
        Intrinsics.checkParameterIsNotNull(sessionManager2, "sessionManager");
        Intrinsics.checkParameterIsNotNull(userAPI2, "userAPI");
        Intrinsics.checkParameterIsNotNull(fittsServiceRepository2, "fittsServiceRepository");
        Intrinsics.checkParameterIsNotNull(eventTracker2, "eventTracker");
        this.sessionManager = sessionManager2;
        this.userAPI = userAPI2;
        this.fittsServiceRepository = fittsServiceRepository2;
        this.eventTracker = eventTracker2;
    }

    @Nullable
    public final FittsSchemeHandler getSchemeHandler() {
        return this.schemeHandler;
    }

    public final void setSchemeHandler(@Nullable FittsSchemeHandler fittsSchemeHandler) {
        this.schemeHandler = fittsSchemeHandler;
    }

    public static /* synthetic */ void showCreatePostActivity$default(CreatePostActivityUtil createPostActivityUtil, Activity activity, String str, boolean z, Function0 function0, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        if ((i & 8) != 0) {
            function0 = null;
        }
        createPostActivityUtil.showCreatePostActivity(activity, str, z, function0);
    }

    public final void showCreatePostActivity(@NotNull Activity activity, @NotNull String str, boolean z, @Nullable Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        Intrinsics.checkParameterIsNotNull(str, "from");
        if (!isVerifyStatePending(activity)) {
            CompositeDisposable compositeDisposable = this.disposables;
            Single isPostableUser = isPostableUser();
            CreatePostActivityUtil$showCreatePostActivity$1 createPostActivityUtil$showCreatePostActivity$1 = new CreatePostActivityUtil$showCreatePostActivity$1(this, activity, z, str, function0);
            Disposable subscribe = isPostableUser.subscribe(createPostActivityUtil$showCreatePostActivity$1, CreatePostActivityUtil$showCreatePostActivity$2.INSTANCE);
            Intrinsics.checkExpressionValueIsNotNull(subscribe, "isPostableUser()\n       …:$it\")\n                })");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
        }
    }

    public final void startCreatePostActivity(@NotNull Activity activity, @NotNull PostType postType, @NotNull PostVariantViewData postVariantViewData, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        Intrinsics.checkParameterIsNotNull(postType, "postType");
        Intrinsics.checkParameterIsNotNull(postVariantViewData, "postVariantViewData");
        Intrinsics.checkParameterIsNotNull(str, "from");
        if (!isVerifyStatePending(activity)) {
            CompositeDisposable compositeDisposable = this.disposables;
            Disposable subscribe = isPostableUser().subscribe(new CreatePostActivityUtil$startCreatePostActivity$1(this, activity, postType, postVariantViewData), CreatePostActivityUtil$startCreatePostActivity$2.INSTANCE);
            Intrinsics.checkExpressionValueIsNotNull(subscribe, "isPostableUser()\n       …:$it\")\n                })");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
        }
    }

    public final boolean isVerifyStatePending(@NotNull Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        MyInfo userInfo = this.sessionManager.getUserInfo();
        if (!Intrinsics.areEqual((Object) userInfo != null ? userInfo.getVerifyState() : null, (Object) "pending")) {
            return false;
        }
        DialogExtensions dialogExtensions = DialogExtensions.INSTANCE;
        String string = activity.getResources().getString(C0016R$string.post_pending_dialog_message);
        Intrinsics.checkExpressionValueIsNotNull(string, "activity.resources.getSt…t_pending_dialog_message)");
        DialogExtensions.showMessageDialog$default(dialogExtensions, activity, "조금만 기다려주세요⏳", string, null, "확인", 8, null);
        return true;
    }

    public static /* synthetic */ void showModifyPostActivity$default(CreatePostActivityUtil createPostActivityUtil, Activity activity, int i, long j, String str, PostVariantViewData postVariantViewData, int i2, Object obj) {
        if ((i2 & 16) != 0) {
            postVariantViewData = null;
        }
        createPostActivityUtil.showModifyPostActivity(activity, i, j, str, postVariantViewData);
    }

    public final void showModifyPostActivity(@NotNull Activity activity, int i, long j, @NotNull String str, @Nullable PostVariantViewData postVariantViewData) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        Intrinsics.checkParameterIsNotNull(str, "type");
        CreatePostActivity.Companion.startModify(activity, i, str, "modify", j, postVariantViewData);
    }

    /* access modifiers changed from: private */
    public final void showPostTypeSelectDialog(Activity activity, String str, Function0<Unit> function0) {
        CompositeDisposable compositeDisposable = this.disposables;
        Disposable subscribe = this.userAPI.getPostableOlivsInfo().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new CreatePostActivityUtil$showPostTypeSelectDialog$1(this, activity, str, function0), CreatePostActivityUtil$showPostTypeSelectDialog$2.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "userAPI.getPostableOlivs…age}\")\n                })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    /* access modifiers changed from: private */
    public final void getPostPoint(Activity activity, PostableOrderLineItemVariant postableOrderLineItemVariant, String str, Function0<Unit> function0) {
        PostTypeSelectDialog createDialog = createDialog(activity, str, function0);
        createDialog.updatePostable(postableOrderLineItemVariant);
        createDialog.show();
    }

    static /* synthetic */ void getBannerList$default(CreatePostActivityUtil createPostActivityUtil, Activity activity, String str, Function0 function0, int i, Object obj) {
        if ((i & 4) != 0) {
            function0 = null;
        }
        createPostActivityUtil.getBannerList(activity, str, function0);
    }

    private final void getBannerList(Activity activity, String str, Function0<Unit> function0) {
        CompositeDisposable compositeDisposable = this.disposables;
        Disposable subscribe = this.fittsServiceRepository.getBanners("posting").subscribe(new CreatePostActivityUtil$getBannerList$1(this, activity, str, function0), CreatePostActivityUtil$getBannerList$2.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "fittsServiceRepository.g…age}\")\n                })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    /* access modifiers changed from: private */
    public final PostTypeSelectDialog createDialog(Activity activity, String str, Function0<Unit> function0) {
        return new PostTypeSelectDialog(activity, C0017R$style.AppBottomSheetDialogTheme, new CreatePostActivityUtil$createDialog$1(this, str, activity, function0));
    }

    private final Single<PostableResponse> isPostableUser() {
        Single<PostableResponse> observeOn = this.userAPI.requestPostable().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkExpressionValueIsNotNull(observeOn, "userAPI.requestPostable(…dSchedulers.mainThread())");
        return observeOn;
    }

    /* access modifiers changed from: private */
    public final void checkPostableUser(Activity activity, boolean z, PostableResponse postableResponse, Function0<Unit> function0) {
        if (postableResponse.isPostable()) {
            function0.invoke();
        } else {
            showUnPostableReasonDialog(activity, z, postableResponse, function0);
        }
    }

    /* access modifiers changed from: private */
    public final void createPost(Activity activity, boolean z, Function0<Unit> function0) {
        if (z) {
            function0.invoke();
            return;
        }
        if (this.sessionManager.getUserInfo() != null) {
            MyInfo userInfo = this.sessionManager.getUserInfo();
            if (!Intrinsics.areEqual((Object) userInfo != null ? userInfo.getVerifyState() : null, (Object) "unverified")) {
                function0.invoke();
            }
        }
        PostFirstWriteGuideDialogBuilder.INSTANCE.showDialog(activity, this.sessionManager.getFittsID(), new CreatePostActivityUtil$createPost$1(this, function0, activity));
    }

    private final void showUnPostableReasonDialog(Activity activity, boolean z, PostableResponse postableResponse, Function0<Unit> function0) {
        UnpostableReason unpostableReason = postableResponse.getUnpostableReason();
        Type type = unpostableReason != null ? unpostableReason.getType() : null;
        if (type != null) {
            int i = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
            if (i == 1 || i == 2) {
                if (!z) {
                    WatchListDialogBuilder watchListDialogBuilder = WatchListDialogBuilder.INSTANCE;
                    UnpostableReason unpostableReason2 = postableResponse.getUnpostableReason();
                    if (unpostableReason2 == null) {
                        Intrinsics.throwNpe();
                    }
                    watchListDialogBuilder.showDialog(activity, unpostableReason2.getRemainingHour());
                }
            } else if (i == 3) {
                if (z) {
                    function0.invoke();
                } else {
                    BlackListDialogBuilder.INSTANCE.showDialog(activity, new CreatePostActivityUtil$showUnPostableReasonDialog$$inlined$run$lambda$1(postableResponse, z, activity, function0));
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final void writeCustomLog(String str, String str2) {
        this.eventTracker.logCustom("Tap Posting", new CustomAttributes().put("from", str).put("category", str2));
    }

    public final void clear() {
        this.disposables.clear();
    }
}
