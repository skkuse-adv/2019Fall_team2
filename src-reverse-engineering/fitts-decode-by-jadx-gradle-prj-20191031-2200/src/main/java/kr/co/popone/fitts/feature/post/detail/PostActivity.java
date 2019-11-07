package kr.co.popone.fitts.feature.post.detail;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.ablanco.zoomy.Zoomy;
import com.bumptech.glide.Glide;
import dagger.android.AndroidInjection;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.rxkotlin.DisposableKt;
import io.reactivex.rxkotlin.SubscribersKt;
import io.reactivex.schedulers.Schedulers;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.base.extension.ContextExtensionKt;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.feature.post.PostType;
import kr.co.popone.fitts.feature.post.detail.SameProductPostAdapter.Delegate;
import kr.co.popone.fitts.feature.post.upload.create.CreatePostActivityUtil;
import kr.co.popone.fitts.model.datamodel.service.log.ActionLog;
import kr.co.popone.fitts.model.datamodel.service.post.Image;
import kr.co.popone.fitts.model.datamodel.service.user.BodyType;
import kr.co.popone.fitts.model.datamodel.service.user.User;
import kr.co.popone.fitts.model.log.ActionLogAPI;
import kr.co.popone.fitts.model.post.PostAPI;
import kr.co.popone.fitts.model.post.PostAPI.Post;
import kr.co.popone.fitts.model.post.PostAPI.RelatedPost;
import kr.co.popone.fitts.model.repository.service.FittsServiceRepository;
import kr.co.popone.fitts.model.user.UserAPI;
import kr.co.popone.fitts.repository.StoreRepository;
import kr.co.popone.fitts.ui.ViewExtensionsKt;
import kr.co.popone.fitts.ui.decorator.RecyclerDecorator.Builder;
import kr.co.popone.fitts.ui.decorator.RecyclerDecorator.DecoratorType;
import kr.co.popone.fitts.ui.decorator.SameProductPostDecorator;
import kr.co.popone.fitts.utils.ActionLogUtil;
import kr.co.popone.fitts.utils.ActivityAnimationType;
import kr.co.popone.fitts.utils.Snackbar;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.simple.eventbus.EventBus;

public final class PostActivity extends AppCompatActivity implements Delegate, RelatedPostAdapter.Delegate {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(PostActivity.class), "defaultPostId", "getDefaultPostId()J"))};
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String PREF_SHOWED_SIMILAR_BODY_DIALOG = "similar_body_dialog";
    private HashMap _$_findViewCache;
    @NotNull
    public ActionLogAPI actionLogAPI;
    @NotNull
    public ActionLogUtil actionLogUtil;
    @NotNull
    public CreatePostActivityUtil createPostActivityUtil;
    private final Lazy defaultPostId$delegate = LazyKt__LazyJVMKt.lazy(new PostActivity$defaultPostId$2(this));
    /* access modifiers changed from: private */
    public Disposable deleteFollowRequest;
    /* access modifiers changed from: private */
    public Disposable deleteLikeRequest;
    /* access modifiers changed from: private */
    public Disposable deletePostRequest;
    private final CompositeDisposable disposables = new CompositeDisposable();
    @NotNull
    public EventTracker eventTracker;
    /* access modifiers changed from: private */
    public Disposable inactivePostTimeUpdate;
    /* access modifiers changed from: private */
    public Boolean isLiked;
    /* access modifiers changed from: private */
    public Integer likeCount;
    /* access modifiers changed from: private */
    public Post post;
    @NotNull
    public PostAPI postAPI;
    /* access modifiers changed from: private */
    public Long postID;
    /* access modifiers changed from: private */
    public List<Image> postImageList = new ArrayList();
    /* access modifiers changed from: private */
    public Disposable postRequest;
    /* access modifiers changed from: private */
    public User postUser;
    private Disposable putCommentRequest;
    /* access modifiers changed from: private */
    public Disposable putFollowRequest;
    /* access modifiers changed from: private */
    public Disposable putLikeRequest;
    @NotNull
    public FittsServiceRepository serviceRepository;
    @NotNull
    public SessionManager sessionManager;
    /* access modifiers changed from: private */
    public Function0<Unit> showDetailInfoView;
    @NotNull
    public StoreRepository storeRepository;
    private Adapter<ViewHolder> tempAdapter;
    @NotNull
    public UserAPI userAPI;
    /* access modifiers changed from: private */
    public Long userID;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void start$default(Companion companion, Context context, long j, String str, int i, Object obj) {
            if ((i & 4) != 0) {
                str = null;
            }
            companion.start(context, j, str);
        }

        public final void start(@Nullable Context context, long j, @Nullable String str) {
            if (context != null) {
                Intent intent = new Intent(context, PostActivity.class);
                intent.putExtra("post_id", j);
                intent.putExtra("post_cover", str);
                ContextExtensionKt.activityStart(context, intent, ActivityAnimationType.SLIDE_RTOL);
            }
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = new int[BodyType.values().length];
        public static final /* synthetic */ int[] $EnumSwitchMapping$1 = new int[PostType.values().length];
        public static final /* synthetic */ int[] $EnumSwitchMapping$2 = new int[PostType.values().length];
        public static final /* synthetic */ int[] $EnumSwitchMapping$3 = new int[PostType.values().length];
        public static final /* synthetic */ int[] $EnumSwitchMapping$4 = new int[BodyType.values().length];
        public static final /* synthetic */ int[] $EnumSwitchMapping$5 = new int[PostType.values().length];
        public static final /* synthetic */ int[] $EnumSwitchMapping$6 = new int[PostType.values().length];

        static {
            $EnumSwitchMapping$0[BodyType.TRIANGLE.ordinal()] = 1;
            $EnumSwitchMapping$0[BodyType.INVERTED_TRIANGLE.ordinal()] = 2;
            $EnumSwitchMapping$0[BodyType.RECTANGLE.ordinal()] = 3;
            $EnumSwitchMapping$0[BodyType.HOURGLASS.ordinal()] = 4;
            $EnumSwitchMapping$0[BodyType.NORMAL.ordinal()] = 5;
            $EnumSwitchMapping$1[PostType.CLOTHES.ordinal()] = 1;
            $EnumSwitchMapping$1[PostType.SHOES.ordinal()] = 2;
            $EnumSwitchMapping$1[PostType.BAG.ordinal()] = 3;
            $EnumSwitchMapping$2[PostType.SHOES.ordinal()] = 1;
            $EnumSwitchMapping$3[PostType.SHOES.ordinal()] = 1;
            $EnumSwitchMapping$3[PostType.BAG.ordinal()] = 2;
            $EnumSwitchMapping$3[PostType.CLOTHES.ordinal()] = 3;
            $EnumSwitchMapping$4[BodyType.TRIANGLE.ordinal()] = 1;
            $EnumSwitchMapping$4[BodyType.INVERTED_TRIANGLE.ordinal()] = 2;
            $EnumSwitchMapping$4[BodyType.RECTANGLE.ordinal()] = 3;
            $EnumSwitchMapping$4[BodyType.HOURGLASS.ordinal()] = 4;
            $EnumSwitchMapping$4[BodyType.NORMAL.ordinal()] = 5;
            $EnumSwitchMapping$5[PostType.CLOTHES.ordinal()] = 1;
            $EnumSwitchMapping$5[PostType.SHOES.ordinal()] = 2;
            $EnumSwitchMapping$5[PostType.BAG.ordinal()] = 3;
            $EnumSwitchMapping$6[PostType.SHOES.ordinal()] = 1;
            $EnumSwitchMapping$6[PostType.BAG.ordinal()] = 2;
            $EnumSwitchMapping$6[PostType.CLOTHES.ordinal()] = 3;
        }
    }

    private final long getDefaultPostId() {
        Lazy lazy = this.defaultPostId$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return ((Number) lazy.getValue()).longValue();
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    @NotNull
    public final EventTracker getEventTracker$app_productionFittsRelease() {
        EventTracker eventTracker2 = this.eventTracker;
        if (eventTracker2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eventTracker");
        }
        return eventTracker2;
    }

    public final void setEventTracker$app_productionFittsRelease(@NotNull EventTracker eventTracker2) {
        Intrinsics.checkParameterIsNotNull(eventTracker2, "<set-?>");
        this.eventTracker = eventTracker2;
    }

    @NotNull
    public final SessionManager getSessionManager$app_productionFittsRelease() {
        SessionManager sessionManager2 = this.sessionManager;
        if (sessionManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
        }
        return sessionManager2;
    }

    public final void setSessionManager$app_productionFittsRelease(@NotNull SessionManager sessionManager2) {
        Intrinsics.checkParameterIsNotNull(sessionManager2, "<set-?>");
        this.sessionManager = sessionManager2;
    }

    @NotNull
    public final CreatePostActivityUtil getCreatePostActivityUtil$app_productionFittsRelease() {
        CreatePostActivityUtil createPostActivityUtil2 = this.createPostActivityUtil;
        if (createPostActivityUtil2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("createPostActivityUtil");
        }
        return createPostActivityUtil2;
    }

    public final void setCreatePostActivityUtil$app_productionFittsRelease(@NotNull CreatePostActivityUtil createPostActivityUtil2) {
        Intrinsics.checkParameterIsNotNull(createPostActivityUtil2, "<set-?>");
        this.createPostActivityUtil = createPostActivityUtil2;
    }

    @NotNull
    public final ActionLogUtil getActionLogUtil$app_productionFittsRelease() {
        ActionLogUtil actionLogUtil2 = this.actionLogUtil;
        if (actionLogUtil2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionLogUtil");
        }
        return actionLogUtil2;
    }

    public final void setActionLogUtil$app_productionFittsRelease(@NotNull ActionLogUtil actionLogUtil2) {
        Intrinsics.checkParameterIsNotNull(actionLogUtil2, "<set-?>");
        this.actionLogUtil = actionLogUtil2;
    }

    @NotNull
    public final ActionLogAPI getActionLogAPI$app_productionFittsRelease() {
        ActionLogAPI actionLogAPI2 = this.actionLogAPI;
        if (actionLogAPI2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionLogAPI");
        }
        return actionLogAPI2;
    }

    public final void setActionLogAPI$app_productionFittsRelease(@NotNull ActionLogAPI actionLogAPI2) {
        Intrinsics.checkParameterIsNotNull(actionLogAPI2, "<set-?>");
        this.actionLogAPI = actionLogAPI2;
    }

    @NotNull
    public final StoreRepository getStoreRepository$app_productionFittsRelease() {
        StoreRepository storeRepository2 = this.storeRepository;
        if (storeRepository2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("storeRepository");
        }
        return storeRepository2;
    }

    public final void setStoreRepository$app_productionFittsRelease(@NotNull StoreRepository storeRepository2) {
        Intrinsics.checkParameterIsNotNull(storeRepository2, "<set-?>");
        this.storeRepository = storeRepository2;
    }

    @NotNull
    public final FittsServiceRepository getServiceRepository$app_productionFittsRelease() {
        FittsServiceRepository fittsServiceRepository = this.serviceRepository;
        if (fittsServiceRepository == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serviceRepository");
        }
        return fittsServiceRepository;
    }

    public final void setServiceRepository$app_productionFittsRelease(@NotNull FittsServiceRepository fittsServiceRepository) {
        Intrinsics.checkParameterIsNotNull(fittsServiceRepository, "<set-?>");
        this.serviceRepository = fittsServiceRepository;
    }

    @NotNull
    public final PostAPI getPostAPI() {
        PostAPI postAPI2 = this.postAPI;
        if (postAPI2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("postAPI");
        }
        return postAPI2;
    }

    public final void setPostAPI(@NotNull PostAPI postAPI2) {
        Intrinsics.checkParameterIsNotNull(postAPI2, "<set-?>");
        this.postAPI = postAPI2;
    }

    @NotNull
    public final UserAPI getUserAPI() {
        UserAPI userAPI2 = this.userAPI;
        if (userAPI2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userAPI");
        }
        return userAPI2;
    }

    public final void setUserAPI(@NotNull UserAPI userAPI2) {
        Intrinsics.checkParameterIsNotNull(userAPI2, "<set-?>");
        this.userAPI = userAPI2;
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"SetTextI18n"})
    public void onCreate(@Nullable Bundle bundle) {
        AndroidInjection.inject((Activity) this);
        super.onCreate(bundle);
        setContentView((int) C0013R$layout.activity_post);
        EventBus.getDefault().register(this);
        ActionLogUtil actionLogUtil2 = this.actionLogUtil;
        if (actionLogUtil2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionLogUtil");
        }
        ActionLogAPI actionLogAPI2 = this.actionLogAPI;
        if (actionLogAPI2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionLogAPI");
        }
        actionLogAPI2.collectActionLog("post", actionLogUtil2.getMainPath(), actionLogUtil2.getSubPath(), Long.valueOf(actionLogUtil2.getFromId()), Long.valueOf(getDefaultPostId())).subscribeOn(Schedulers.io()).subscribe(PostActivity$onCreate$1$1.INSTANCE, PostActivity$onCreate$1$2.INSTANCE);
        String str = "post_cover";
        if (getIntent().getStringExtra(str) != null) {
            Glide.with((FragmentActivity) this).load(getIntent().getStringExtra(str)).into((ImageView) _$_findCachedViewById(C0010R$id.cover_image));
        }
        ObjectAnimator ofObject = ObjectAnimator.ofObject((Toolbar) _$_findCachedViewById(C0010R$id.toolbar), "backgroundColor", new ArgbEvaluator(), new Object[]{Integer.valueOf((int) 4294967295L), Integer.valueOf(0)});
        ofObject.setDuration(200);
        ofObject.start();
        ((ImageButton) _$_findCachedViewById(C0010R$id.back)).setColorFilter(Color.argb(255, 255, 255, 255));
        ((ImageButton) _$_findCachedViewById(C0010R$id.home)).setColorFilter(Color.argb(255, 255, 255, 255));
        Toolbar toolbar = (Toolbar) _$_findCachedViewById(C0010R$id.toolbar);
        Intrinsics.checkExpressionValueIsNotNull(toolbar, "toolbar");
        toolbar.setTag("transparent");
        ((ImageButton) _$_findCachedViewById(C0010R$id.back)).setOnClickListener(new PostActivity$onCreate$3(this));
        ((ImageButton) _$_findCachedViewById(C0010R$id.home)).setOnClickListener(new PostActivity$onCreate$4(this));
        Disposable disposable = this.postRequest;
        if (disposable != null) {
            disposable.dispose();
        }
        PostAPI postAPI2 = this.postAPI;
        if (postAPI2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("postAPI");
        }
        this.postRequest = postAPI2.getPost(getDefaultPostId()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new PostActivity$onCreate$5<Object,Object>(this));
        ((NestedScrollView) _$_findCachedViewById(C0010R$id.scrollview)).setOnScrollChangeListener(new PostActivity$onCreate$6(this));
        getSameProductPosts();
        getRelatedPost();
        TextView textView = (TextView) _$_findCachedViewById(C0010R$id.textFittieId);
        Intrinsics.checkExpressionValueIsNotNull(textView, "textFittieId");
        SessionManager sessionManager2 = this.sessionManager;
        if (sessionManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
        }
        textView.setText(sessionManager2.getFittsID());
    }

    public final void checkPartnerStore(@Nullable String str) {
        if (str != null) {
            CompositeDisposable compositeDisposable = this.disposables;
            StoreRepository storeRepository2 = this.storeRepository;
            if (storeRepository2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("storeRepository");
            }
            Disposable subscribe = storeRepository2.postStoreInfo(str).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new PostActivity$checkPartnerStore$$inlined$let$lambda$1(this, str), new PostActivity$checkPartnerStore$$inlined$let$lambda$2(this, str));
            Intrinsics.checkExpressionValueIsNotNull(subscribe, "storeRepository.postStor… }\n                    })");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
        }
    }

    /* access modifiers changed from: private */
    public final void productFromPostActionLog() {
        ActionLog actionLog = new ActionLog("product", "PostDetail", null, this.postID, null, null, 32, null);
        FittsServiceRepository fittsServiceRepository = this.serviceRepository;
        if (fittsServiceRepository == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serviceRepository");
        }
        DisposableKt.addTo(SubscribersKt.subscribeBy(fittsServiceRepository.postFittsActionLog(actionLog), (Function1<? super Throwable, Unit>) PostActivity$productFromPostActionLog$1$1.INSTANCE, (Function0<Unit>) PostActivity$productFromPostActionLog$1$2.INSTANCE), this.disposables);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x001f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean hasProductInfo() {
        /*
            r2 = this;
            kr.co.popone.fitts.model.post.PostAPI$Post r0 = r2.post
            r1 = 0
            if (r0 == 0) goto L_0x000a
            kr.co.popone.fitts.model.post.PostAPI$LinkInfo r0 = r0.getLinkInfo()
            goto L_0x000b
        L_0x000a:
            r0 = r1
        L_0x000b:
            if (r0 == 0) goto L_0x0031
            kr.co.popone.fitts.model.post.PostAPI$Post r0 = r2.post
            if (r0 == 0) goto L_0x001c
            kr.co.popone.fitts.model.post.PostAPI$LinkInfo r0 = r0.getLinkInfo()
            if (r0 == 0) goto L_0x001c
            kr.co.popone.fitts.model.datamodel.commerce.Product r0 = r0.getProduct()
            goto L_0x001d
        L_0x001c:
            r0 = r1
        L_0x001d:
            if (r0 == 0) goto L_0x0031
            kr.co.popone.fitts.model.post.PostAPI$Post r0 = r2.post
            if (r0 == 0) goto L_0x002d
            kr.co.popone.fitts.model.post.PostAPI$LinkInfo r0 = r0.getLinkInfo()
            if (r0 == 0) goto L_0x002d
            kr.co.popone.fitts.model.datamodel.commerce.Shop r1 = r0.getShop()
        L_0x002d:
            if (r1 == 0) goto L_0x0031
            r0 = 1
            goto L_0x0032
        L_0x0031:
            r0 = 0
        L_0x0032:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.feature.post.detail.PostActivity.hasProductInfo():boolean");
    }

    public final void hideKeyboard() {
        View currentFocus = getCurrentFocus();
        if (currentFocus != null) {
            Object systemService = getSystemService("input_method");
            if (systemService != null) {
                ((InputMethodManager) systemService).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        }
    }

    private final void getSameProductPosts() {
        if (getDefaultPostId() != -1) {
            CompositeDisposable compositeDisposable = this.disposables;
            PostAPI postAPI2 = this.postAPI;
            if (postAPI2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("postAPI");
            }
            Disposable subscribe = postAPI2.getSameProductPosts(getDefaultPostId()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new PostActivity$getSameProductPosts$1(this), new PostActivity$getSameProductPosts$2(this));
            Intrinsics.checkExpressionValueIsNotNull(subscribe, "postAPI.getSameProductPo…()\n                    })");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
        }
    }

    /* access modifiers changed from: private */
    public final void updateSameProductPost(List<Post> list) {
        String str = "layoutSamePost";
        if (list.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(C0010R$id.layoutSamePost);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout, str);
            ViewExtensionsKt.gone(linearLayout);
            return;
        }
        SameProductPostAdapter sameProductPostAdapter = new SameProductPostAdapter(this);
        LinearLayout linearLayout2 = (LinearLayout) _$_findCachedViewById(C0010R$id.layoutSamePost);
        Intrinsics.checkExpressionValueIsNotNull(linearLayout2, str);
        ViewExtensionsKt.visible(linearLayout2);
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C0010R$id.recyclerSamePost);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, 0, false));
        recyclerView.setAdapter(sameProductPostAdapter);
        if (recyclerView.getItemDecorationCount() < 1) {
            recyclerView.addItemDecoration(new SameProductPostDecorator());
        }
        sameProductPostAdapter.submitList(list);
    }

    private final void getRelatedPost() {
        if (getDefaultPostId() != -1) {
            CompositeDisposable compositeDisposable = this.disposables;
            PostAPI postAPI2 = this.postAPI;
            if (postAPI2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("postAPI");
            }
            Disposable subscribe = postAPI2.getRelatedPosts(getDefaultPostId()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new PostActivity$getRelatedPost$1(this), new PostActivity$getRelatedPost$2(this));
            Intrinsics.checkExpressionValueIsNotNull(subscribe, "postAPI.getRelatedPosts(…()\n                    })");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
        }
    }

    /* access modifiers changed from: private */
    public final void updateRelatedPost(RelatedPost relatedPost) {
        String str = "layoutRelatedPost";
        if (relatedPost.getPosts().isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(C0010R$id.layoutRelatedPost);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout, str);
            ViewExtensionsKt.gone(linearLayout);
            return;
        }
        LinearLayout linearLayout2 = (LinearLayout) _$_findCachedViewById(C0010R$id.layoutRelatedPost);
        Intrinsics.checkExpressionValueIsNotNull(linearLayout2, str);
        ViewExtensionsKt.visible(linearLayout2);
        RelatedPostAdapter relatedPostAdapter = new RelatedPostAdapter(this);
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C0010R$id.recyclerRelatedPost);
        recyclerView.setAdapter(relatedPostAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        if (recyclerView.getItemDecorationCount() < 1) {
            recyclerView.addItemDecoration(new Builder().decoratorType(DecoratorType.DOUBLE).doubleLeftDecorator(0, 18, 8, 4).doubleRightDecorator(0, 18, 4, 8).build());
        }
        relatedPostAdapter.submitList(relatedPost.getPosts());
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        Adapter<ViewHolder> adapter = this.tempAdapter;
        if (adapter != null) {
            RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C0010R$id.post_image_list);
            Intrinsics.checkExpressionValueIsNotNull(recyclerView, "post_image_list");
            recyclerView.setAdapter(adapter);
        }
        new Zoomy.Builder((Activity) this).target((ImageView) _$_findCachedViewById(C0010R$id.cover_image)).register();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C0010R$id.post_image_list);
        String str = "post_image_list";
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, str);
        this.tempAdapter = recyclerView.getAdapter();
        RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(C0010R$id.post_image_list);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView2, str);
        recyclerView2.setAdapter(null);
        Zoomy.unregister((ImageView) _$_findCachedViewById(C0010R$id.cover_image));
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        if (i == 101) {
            if (i2 == -1) {
                Disposable disposable = this.postRequest;
                if (disposable != null) {
                    disposable.dispose();
                }
                PostAPI postAPI2 = this.postAPI;
                if (postAPI2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("postAPI");
                }
                this.postRequest = postAPI2.getPost(getDefaultPostId()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new PostActivity$onActivityResult$1<Object,Object>(this));
            }
            ((NestedScrollView) _$_findCachedViewById(C0010R$id.scrollview)).scrollTo(0, 0);
        } else if (i == 1) {
            if (i2 == -1) {
                Snackbar.Companion.showMessage(this, "정상적으로 신고되었습니다");
            }
            if (i2 == 0 && intent != null && intent.getBooleanExtra("retry", false)) {
                Snackbar.Companion.showMessage(this, "이미 신고한 포스트입니다");
            }
        }
    }

    /* access modifiers changed from: private */
    @SuppressLint({"SetTextI18n"})
    public final void loadDate(TextView textView, String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.getDefault());
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("M월 d일", Locale.getDefault());
        Date date = new Date(System.currentTimeMillis());
        Date parse = simpleDateFormat.parse(str);
        Intrinsics.checkExpressionValueIsNotNull(parse, "dateFormat.parse(text)");
        long time = date.getTime() - parse.getTime();
        if (time < 60000) {
            textView.setText("방금 전");
        } else if (time < 3600000) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf(time / 60000));
            sb.append("분 전");
            textView.setText(sb.toString());
        } else if (time < 86400000) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(String.valueOf(time / 3600000));
            sb2.append("시간 전");
            textView.setText(sb2.toString());
        } else if (time < 604800000) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(String.valueOf(time / 86400000));
            sb3.append("일 전");
            textView.setText(sb3.toString());
        } else {
            textView.setText(simpleDateFormat2.format(parse).toString());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0120, code lost:
        if (r7 == r2.getUserID()) goto L_0x0124;
     */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x009b  */
    @org.simple.eventbus.Subscriber(mode = org.simple.eventbus.ThreadMode.MAIN, tag = "post_message")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onReceive(@org.jetbrains.annotations.NotNull android.os.Message r12) {
        /*
            r11 = this;
            java.lang.String r0 = "message"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r12, r0)
            int r0 = r12.what
            r1 = 2
            r2 = 2131099817(0x7f0600a9, float:1.7811998E38)
            r3 = 0
            r4 = 1
            if (r0 == r1) goto L_0x016a
            r1 = 3
            if (r0 == r1) goto L_0x0014
            goto L_0x01f4
        L_0x0014:
            android.os.Bundle r0 = r12.getData()
            java.lang.String r1 = "postId"
            long r0 = r0.getLong(r1)
            java.lang.Long r5 = r11.postID
            if (r5 != 0) goto L_0x0024
            goto L_0x01f4
        L_0x0024:
            long r5 = r5.longValue()
            int r7 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x01f4
            android.os.Bundle r12 = r12.getData()
            java.lang.String r0 = "isLiked"
            boolean r12 = r12.getBoolean(r0)
            java.lang.Boolean r12 = java.lang.Boolean.valueOf(r12)
            r11.isLiked = r12
            java.lang.Boolean r12 = r11.isLiked
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r4)
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r12, r0)
            java.lang.String r1 = "sessionManager"
            r5 = 0
            java.lang.String r6 = "like_count"
            if (r0 == 0) goto L_0x00d1
            int r12 = kr.co.popone.fitts.C0010R$id.like_image
            android.view.View r12 = r11._$_findCachedViewById(r12)
            android.widget.ImageView r12 = (android.widget.ImageView) r12
            r0 = 2131230905(0x7f0800b9, float:1.8077876E38)
            r12.setBackgroundResource(r0)
            java.lang.Integer r12 = r11.likeCount
            if (r12 == 0) goto L_0x0068
            int r12 = r12.intValue()
            int r12 = r12 + r4
            java.lang.Integer r5 = java.lang.Integer.valueOf(r12)
        L_0x0068:
            r11.likeCount = r5
            int r12 = kr.co.popone.fitts.C0010R$id.like_count
            android.view.View r12 = r11._$_findCachedViewById(r12)
            android.widget.TextView r12 = (android.widget.TextView) r12
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r12, r6)
            kr.co.popone.fitts.utils.UIExtensions r0 = kr.co.popone.fitts.utils.UIExtensions.INSTANCE
            kr.co.popone.fitts.model.post.PostAPI$Post r5 = r11.post
            if (r5 == 0) goto L_0x0096
            kr.co.popone.fitts.model.datamodel.service.user.User r5 = r5.getUser()
            if (r5 == 0) goto L_0x0096
            long r7 = r5.getId()
            kr.co.popone.fitts.base.SessionManager r5 = r11.sessionManager
            if (r5 != 0) goto L_0x008c
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x008c:
            long r9 = r5.getUserID()
            int r1 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r1 != 0) goto L_0x0096
            r1 = 1
            goto L_0x0097
        L_0x0096:
            r1 = 0
        L_0x0097:
            java.lang.Integer r5 = r11.likeCount
            if (r5 == 0) goto L_0x009f
            int r3 = r5.intValue()
        L_0x009f:
            java.lang.String r0 = r0.likeCountText(r1, r4, r3)
            r12.setText(r0)
            int r12 = kr.co.popone.fitts.C0010R$id.like_count
            android.view.View r12 = r11._$_findCachedViewById(r12)
            android.widget.TextView r12 = (android.widget.TextView) r12
            int r0 = kr.co.popone.fitts.C0010R$id.like_count
            android.view.View r0 = r11._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r6)
            android.graphics.Typeface r0 = r0.getTypeface()
            r12.setTypeface(r0, r4)
            int r12 = kr.co.popone.fitts.C0010R$id.like_count
            android.view.View r12 = r11._$_findCachedViewById(r12)
            android.widget.TextView r12 = (android.widget.TextView) r12
            int r0 = androidx.core.content.ContextCompat.getColor(r11, r2)
            r12.setTextColor(r0)
            goto L_0x01f4
        L_0x00d1:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r3)
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual(r12, r0)
            if (r12 == 0) goto L_0x01f4
            int r12 = kr.co.popone.fitts.C0010R$id.like_image
            android.view.View r12 = r11._$_findCachedViewById(r12)
            android.widget.ImageView r12 = (android.widget.ImageView) r12
            r0 = 2131230907(0x7f0800bb, float:1.807788E38)
            r12.setBackgroundResource(r0)
            java.lang.Integer r12 = r11.likeCount
            if (r12 == 0) goto L_0x00f6
            int r12 = r12.intValue()
            int r12 = r12 - r4
            java.lang.Integer r5 = java.lang.Integer.valueOf(r12)
        L_0x00f6:
            r11.likeCount = r5
            int r12 = kr.co.popone.fitts.C0010R$id.like_count
            android.view.View r12 = r11._$_findCachedViewById(r12)
            android.widget.TextView r12 = (android.widget.TextView) r12
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r12, r6)
            kr.co.popone.fitts.utils.UIExtensions r0 = kr.co.popone.fitts.utils.UIExtensions.INSTANCE
            kr.co.popone.fitts.model.post.PostAPI$Post r2 = r11.post
            if (r2 == 0) goto L_0x0123
            kr.co.popone.fitts.model.datamodel.service.user.User r2 = r2.getUser()
            if (r2 == 0) goto L_0x0123
            long r7 = r2.getId()
            kr.co.popone.fitts.base.SessionManager r2 = r11.sessionManager
            if (r2 != 0) goto L_0x011a
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x011a:
            long r1 = r2.getUserID()
            int r5 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r5 != 0) goto L_0x0123
            goto L_0x0124
        L_0x0123:
            r4 = 0
        L_0x0124:
            java.lang.Integer r1 = r11.likeCount
            if (r1 == 0) goto L_0x012d
            int r1 = r1.intValue()
            goto L_0x012e
        L_0x012d:
            r1 = 0
        L_0x012e:
            java.lang.String r0 = r0.likeCountText(r4, r3, r1)
            r12.setText(r0)
            int r12 = kr.co.popone.fitts.C0010R$id.like_count
            android.view.View r12 = r11._$_findCachedViewById(r12)
            android.widget.TextView r12 = (android.widget.TextView) r12
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r12, r6)
            int r0 = kr.co.popone.fitts.C0010R$id.like_count
            android.view.View r0 = r11._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r6)
            android.graphics.Typeface r0 = r0.getTypeface()
            android.graphics.Typeface r0 = android.graphics.Typeface.create(r0, r3)
            r12.setTypeface(r0)
            int r12 = kr.co.popone.fitts.C0010R$id.like_count
            android.view.View r12 = r11._$_findCachedViewById(r12)
            android.widget.TextView r12 = (android.widget.TextView) r12
            r0 = 2131099765(0x7f060075, float:1.7811892E38)
            int r0 = androidx.core.content.ContextCompat.getColor(r11, r0)
            r12.setTextColor(r0)
            goto L_0x01f4
        L_0x016a:
            java.lang.Long r0 = r11.userID
            android.os.Bundle r1 = r12.getData()
            java.lang.String r5 = "userId"
            long r5 = r1.getLong(r5)
            if (r0 != 0) goto L_0x017a
            goto L_0x01f4
        L_0x017a:
            long r0 = r0.longValue()
            int r7 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x01f4
            android.os.Bundle r12 = r12.getData()
            java.lang.String r0 = "isFollowed"
            boolean r12 = r12.getBoolean(r0)
            java.lang.String r0 = "follow_button"
            if (r12 != r4) goto L_0x01c3
            kr.co.popone.fitts.model.datamodel.service.user.User r12 = r11.postUser
            if (r12 == 0) goto L_0x0197
            r12.setFollowing(r4)
        L_0x0197:
            int r12 = kr.co.popone.fitts.C0010R$id.follow_button
            android.view.View r12 = r11._$_findCachedViewById(r12)
            android.widget.TextView r12 = (android.widget.TextView) r12
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r12, r0)
            android.content.res.Resources r0 = r11.getResources()
            r1 = 2131755193(0x7f1000b9, float:1.9141258E38)
            java.lang.String r0 = r0.getString(r1)
            r12.setText(r0)
            int r12 = kr.co.popone.fitts.C0010R$id.follow_button
            android.view.View r12 = r11._$_findCachedViewById(r12)
            android.widget.TextView r12 = (android.widget.TextView) r12
            r0 = 2131099759(0x7f06006f, float:1.781188E38)
            int r0 = androidx.core.content.ContextCompat.getColor(r11, r0)
            r12.setTextColor(r0)
            goto L_0x01f4
        L_0x01c3:
            if (r12 != 0) goto L_0x01f4
            kr.co.popone.fitts.model.datamodel.service.user.User r12 = r11.postUser
            if (r12 == 0) goto L_0x01cc
            r12.setFollowing(r3)
        L_0x01cc:
            int r12 = kr.co.popone.fitts.C0010R$id.follow_button
            android.view.View r12 = r11._$_findCachedViewById(r12)
            android.widget.TextView r12 = (android.widget.TextView) r12
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r12, r0)
            android.content.res.Resources r0 = r11.getResources()
            r1 = 2131755192(0x7f1000b8, float:1.9141256E38)
            java.lang.String r0 = r0.getString(r1)
            r12.setText(r0)
            int r12 = kr.co.popone.fitts.C0010R$id.follow_button
            android.view.View r12 = r11._$_findCachedViewById(r12)
            android.widget.TextView r12 = (android.widget.TextView) r12
            int r0 = androidx.core.content.ContextCompat.getColor(r11, r2)
            r12.setTextColor(r0)
        L_0x01f4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.feature.post.detail.PostActivity.onReceive(android.os.Message):void");
    }

    public void onPostFeedClick(long j, @Nullable String str) {
        EventTracker eventTracker2 = this.eventTracker;
        if (eventTracker2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eventTracker");
        }
        eventTracker2.customLogViewPost("related");
        Companion.start(this, j, str);
    }

    public void onSimplePostClick(long j) {
        EventTracker eventTracker2 = this.eventTracker;
        if (eventTracker2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eventTracker");
        }
        eventTracker2.customLogViewPost("related_same");
        Intent intent = new Intent(this, PostActivity.class);
        intent.putExtra("post_id", j);
        ContextExtensionKt.activityStart(this, intent, ActivityAnimationType.SLIDE_RTOL);
    }

    public void finish() {
        super.finish();
        overridePendingTransition(ActivityAnimationType.SLIDE_LTOR.getEnter(), ActivityAnimationType.SLIDE_LTOR.getExit());
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        EventBus.getDefault().unregister(this);
        Disposable disposable = this.postRequest;
        if (disposable != null) {
            disposable.dispose();
        }
        Disposable disposable2 = this.deleteFollowRequest;
        if (disposable2 != null) {
            disposable2.dispose();
        }
        Disposable disposable3 = this.putFollowRequest;
        if (disposable3 != null) {
            disposable3.dispose();
        }
        Disposable disposable4 = this.putCommentRequest;
        if (disposable4 != null) {
            disposable4.dispose();
        }
        Disposable disposable5 = this.deleteLikeRequest;
        if (disposable5 != null) {
            disposable5.dispose();
        }
        Disposable disposable6 = this.putLikeRequest;
        if (disposable6 != null) {
            disposable6.dispose();
        }
        Disposable disposable7 = this.inactivePostTimeUpdate;
        if (disposable7 != null) {
            disposable7.dispose();
        }
        CreatePostActivityUtil createPostActivityUtil2 = this.createPostActivityUtil;
        if (createPostActivityUtil2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("createPostActivityUtil");
        }
        createPostActivityUtil2.clear();
        this.inactivePostTimeUpdate = null;
        this.postRequest = null;
        this.deleteFollowRequest = null;
        this.putFollowRequest = null;
        this.putCommentRequest = null;
        this.deleteLikeRequest = null;
        this.putLikeRequest = null;
        Disposable disposable8 = this.deletePostRequest;
        if (disposable8 != null) {
            disposable8.dispose();
        }
        this.disposables.dispose();
        this.postID = null;
        this.userID = null;
        this.isLiked = null;
        this.likeCount = null;
        super.onDestroy();
    }
}
