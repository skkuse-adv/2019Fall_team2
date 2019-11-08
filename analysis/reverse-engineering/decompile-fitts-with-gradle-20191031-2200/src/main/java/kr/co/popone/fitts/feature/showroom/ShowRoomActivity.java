package kr.co.popone.fitts.feature.showroom;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Message;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ItemDecoration;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.State;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.facebook.internal.ServerProtocol;
import com.orhanobut.logger.Logger;
import com.paginate.Paginate;
import com.paginate.Paginate.Callbacks;
import com.paginate.recycler.LoadingListItemCreator;
import dagger.android.AndroidInjection;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;
import kr.co.popone.fitts.C0001R$anim;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.base.extension.ContextExtensionKt;
import kr.co.popone.fitts.event.RxBus;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.eventtracker.EventTracker.CustomAttributes;
import kr.co.popone.fitts.feature.post.upload.create.CreatePostActivityUtil;
import kr.co.popone.fitts.model.datamodel.service.post.CreateImage;
import kr.co.popone.fitts.model.datamodel.service.post.ImageFile;
import kr.co.popone.fitts.model.datamodel.service.user.ShowRoom;
import kr.co.popone.fitts.model.datamodel.service.user.User;
import kr.co.popone.fitts.model.log.ActionLogAPI;
import kr.co.popone.fitts.model.post.PostAPI;
import kr.co.popone.fitts.model.post.PostAPI.Post;
import kr.co.popone.fitts.model.user.UserAPI;
import kr.co.popone.fitts.ui.StringKeyGenerator;
import kr.co.popone.fitts.ui.ViewExtensionsKt;
import kr.co.popone.fitts.utils.ActionLogUtil;
import kr.co.popone.fitts.utils.ActivityAnimationType;
import okhttp3.MediaType;
import okhttp3.MultipartBody.Part;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.simple.eventbus.EventBus;
import org.simple.eventbus.Subscriber;
import org.simple.eventbus.ThreadMode;
import photopicker.view.ImageSelectorActivity;

public final class ShowRoomActivity extends AppCompatActivity {
    public static final Companion Companion = new Companion(null);
    /* access modifiers changed from: private */
    public static final String KEY_START_FROM = StringKeyGenerator.Companion.generate(ShowRoomActivity.class, "start_from");
    /* access modifiers changed from: private */
    public static final String KEY_USER_ID = KEY_USER_ID;
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public boolean _started;
    @NotNull
    public ActionLogAPI actionLogAPI;
    @NotNull
    public ActionLogUtil actionLogUtil;
    @NotNull
    public CreatePostActivityUtil createPostActivityUtil;
    /* access modifiers changed from: private */
    public Disposable deleteFollowRequest;
    /* access modifiers changed from: private */
    public Disposable deleteLikeRequest;
    /* access modifiers changed from: private */
    public final CompositeDisposable disposables = new CompositeDisposable();
    @NotNull
    public EventTracker eventTracker;
    /* access modifiers changed from: private */
    public GridLayoutManager gridLayoutManager;
    private boolean isLinear;
    private boolean isMine;
    private boolean isTotalItemLoaded;
    private int limit = 10;
    /* access modifiers changed from: private */
    public LinearLayoutManager linearLayoutManager;
    private Disposable myPostDeletedEventSubscription;
    private Paginate paginate;
    @NotNull
    public PostAPI postAPI;
    /* access modifiers changed from: private */
    public ArrayList<Post> postList = new ArrayList<>();
    /* access modifiers changed from: private */
    public Disposable putFollowRequest;
    /* access modifiers changed from: private */
    public Disposable putLikeRequest;
    private Parcelable recyclerViewState;
    @NotNull
    public SessionManager sessionManager;
    /* access modifiers changed from: private */
    public boolean shouldReloadMyPosts;
    /* access modifiers changed from: private */
    public ShowRoom showRoomInfo;
    /* access modifiers changed from: private */
    public Disposable showRoomRequest;
    private Adapter<ViewHolder> tempAdapter;
    /* access modifiers changed from: private */
    public Disposable uploadProfileImageRequest;
    /* access modifiers changed from: private */
    public Disposable uploadShowRoomImageRequest;
    @NotNull
    public UserAPI userAPI;
    private Disposable userCheckRequest;
    /* access modifiers changed from: private */
    public long userID = -1;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void start(@Nullable Context context, @Nullable Long l, @NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "from");
            if (context != null) {
                Intent intent = new Intent(context, ShowRoomActivity.class);
                intent.putExtra(ShowRoomActivity.KEY_USER_ID, l);
                intent.putExtra(ShowRoomActivity.KEY_START_FROM, str);
                ContextExtensionKt.activityStart(context, intent, ActivityAnimationType.SLIDE_RTOL);
            }
        }

        public final void startWithNewTask(@Nullable Context context, @Nullable Long l, @NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "from");
            if (context != null) {
                Intent intent = new Intent(context, ShowRoomActivity.class);
                intent.putExtra(ShowRoomActivity.KEY_USER_ID, l);
                intent.putExtra(ShowRoomActivity.KEY_START_FROM, str);
                intent.setFlags(268435456);
                ContextExtensionKt.activityStart(context, intent, ActivityAnimationType.SLIDE_RTOL);
            }
        }
    }

    private final class CustomLoadingListItemCreator implements LoadingListItemCreator {
        public CustomLoadingListItemCreator() {
        }

        @NotNull
        public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
            Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.loading_list_item, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "view");
            return new VH(inflate);
        }

        public void onBindViewHolder(@NotNull ViewHolder viewHolder, int i) {
            Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
            VH vh = (VH) viewHolder;
            if (ShowRoomActivity.this.isTotalItemLoaded()) {
                vh.getLoadMoreItem().setVisibility(8);
            }
        }
    }

    public final class SpacesItemDecoration extends ItemDecoration {
        private final int space;

        public SpacesItemDecoration(int i) {
            this.space = i;
        }

        public void getItemOffsets(@NotNull Rect rect, @NotNull View view, @NotNull RecyclerView recyclerView, @NotNull State state) {
            Intrinsics.checkParameterIsNotNull(rect, "outRect");
            Intrinsics.checkParameterIsNotNull(view, "view");
            Intrinsics.checkParameterIsNotNull(recyclerView, "parent");
            Intrinsics.checkParameterIsNotNull(state, ServerProtocol.DIALOG_PARAM_STATE);
            rect.top = 0;
            rect.left = 0;
            rect.right = 0;
            rect.bottom = 0;
            if (recyclerView.getChildLayoutPosition(view) == 0) {
                rect.top = 0;
                rect.left = 0;
                rect.right = 0;
                rect.bottom = 0;
            } else {
                String str = "this@ShowRoomActivity.resources";
                if (recyclerView.getChildLayoutPosition(view) % 2 == 0) {
                    rect.right = this.space;
                    Resources resources = ShowRoomActivity.this.getResources();
                    Intrinsics.checkExpressionValueIsNotNull(resources, str);
                    rect.left = ((int) (((float) resources.getDisplayMetrics().densityDpi) / 160.0f)) * 3;
                } else if (recyclerView.getChildLayoutPosition(view) % 2 == 1) {
                    Resources resources2 = ShowRoomActivity.this.getResources();
                    Intrinsics.checkExpressionValueIsNotNull(resources2, str);
                    rect.right = ((int) (((float) resources2.getDisplayMetrics().densityDpi) / 160.0f)) * 3;
                    rect.left = this.space;
                }
            }
            if (!ShowRoomActivity.this.isLinear()) {
                if (recyclerView.getChildLayoutPosition(view) == 1 || recyclerView.getChildLayoutPosition(view) == 2) {
                    rect.top = this.space - ViewExtensionsKt.dpToPx(view, 7);
                }
                if (ShowRoomActivity.this.postList.isEmpty()) {
                    rect.top = 0;
                    rect.left = 0;
                    rect.right = 0;
                    rect.bottom = 0;
                    return;
                }
                return;
            }
            rect.top = 0;
            rect.left = 0;
            rect.right = 0;
            rect.bottom = 0;
        }
    }

    public static final class VH extends ViewHolder {
        @NotNull
        private ProgressBar loadMoreItem;

        public VH(@NotNull View view) {
            Intrinsics.checkParameterIsNotNull(view, "itemView");
            super(view);
            View findViewById = view.findViewById(C0010R$id.loading_progress);
            Intrinsics.checkExpressionValueIsNotNull(findViewById, "itemView.findViewById(R.id.loading_progress)");
            this.loadMoreItem = (ProgressBar) findViewById;
        }

        @NotNull
        public final ProgressBar getLoadMoreItem() {
            return this.loadMoreItem;
        }

        public final void setLoadMoreItem(@NotNull ProgressBar progressBar) {
            Intrinsics.checkParameterIsNotNull(progressBar, "<set-?>");
            this.loadMoreItem = progressBar;
        }
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

    public static final /* synthetic */ GridLayoutManager access$getGridLayoutManager$p(ShowRoomActivity showRoomActivity) {
        GridLayoutManager gridLayoutManager2 = showRoomActivity.gridLayoutManager;
        if (gridLayoutManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gridLayoutManager");
        }
        return gridLayoutManager2;
    }

    public static final /* synthetic */ LinearLayoutManager access$getLinearLayoutManager$p(ShowRoomActivity showRoomActivity) {
        LinearLayoutManager linearLayoutManager2 = showRoomActivity.linearLayoutManager;
        if (linearLayoutManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("linearLayoutManager");
        }
        return linearLayoutManager2;
    }

    @NotNull
    public final UserAPI getUserAPI$app_productionFittsRelease() {
        UserAPI userAPI2 = this.userAPI;
        if (userAPI2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userAPI");
        }
        return userAPI2;
    }

    public final void setUserAPI$app_productionFittsRelease(@NotNull UserAPI userAPI2) {
        Intrinsics.checkParameterIsNotNull(userAPI2, "<set-?>");
        this.userAPI = userAPI2;
    }

    @NotNull
    public final PostAPI getPostAPI$app_productionFittsRelease() {
        PostAPI postAPI2 = this.postAPI;
        if (postAPI2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("postAPI");
        }
        return postAPI2;
    }

    public final void setPostAPI$app_productionFittsRelease(@NotNull PostAPI postAPI2) {
        Intrinsics.checkParameterIsNotNull(postAPI2, "<set-?>");
        this.postAPI = postAPI2;
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

    public final int getLimit() {
        return this.limit;
    }

    public final void setLimit(int i) {
        this.limit = i;
    }

    public final boolean isLinear() {
        return this.isLinear;
    }

    public final void setLinear(boolean z) {
        this.isLinear = z;
    }

    public final boolean isMine() {
        return this.isMine;
    }

    public final void setMine(boolean z) {
        this.isMine = z;
    }

    public final boolean isTotalItemLoaded() {
        return this.isTotalItemLoaded;
    }

    public final void setTotalItemLoaded(boolean z) {
        this.isTotalItemLoaded = z;
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        AndroidInjection.inject((Activity) this);
        super.onCreate(bundle);
        setContentView((int) C0013R$layout.activity_showroom);
        ObjectAnimator ofObject = ObjectAnimator.ofObject((Toolbar) _$_findCachedViewById(C0010R$id.toolbar), "backgroundColor", new ArgbEvaluator(), new Object[]{Integer.valueOf((int) 4294967295L), Integer.valueOf(0)});
        ofObject.setDuration(200);
        ofObject.start();
        ((ImageButton) _$_findCachedViewById(C0010R$id.back)).setColorFilter(Color.argb(255, 255, 255, 255));
        TextView textView = (TextView) _$_findCachedViewById(C0010R$id.showroom_title);
        Intrinsics.checkExpressionValueIsNotNull(textView, "showroom_title");
        textView.setVisibility(8);
        Toolbar toolbar = (Toolbar) _$_findCachedViewById(C0010R$id.toolbar);
        Intrinsics.checkExpressionValueIsNotNull(toolbar, "toolbar");
        toolbar.setTag("transparent");
        ((ImageButton) _$_findCachedViewById(C0010R$id.back)).setOnClickListener(new ShowRoomActivity$onCreate$2(this));
        this.linearLayoutManager = new LinearLayoutManager(this);
        this.gridLayoutManager = new GridLayoutManager(this, 2);
        GridLayoutManager gridLayoutManager2 = this.gridLayoutManager;
        if (gridLayoutManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gridLayoutManager");
        }
        gridLayoutManager2.setSpanSizeLookup(new ShowRoomActivity$onCreate$3());
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C0010R$id.post_list);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, "this");
        Resources resources = recyclerView.getResources();
        Intrinsics.checkExpressionValueIsNotNull(resources, "this.resources");
        recyclerView.addItemDecoration(new SpacesItemDecoration(((int) (((float) resources.getDisplayMetrics().densityDpi) / 160.0f)) * 24));
        LinearLayoutManager linearLayoutManager2 = this.linearLayoutManager;
        if (linearLayoutManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("linearLayoutManager");
        }
        recyclerView.setLayoutManager(linearLayoutManager2);
        Context context = recyclerView.getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        recyclerView.setAdapter(new ShowRoomAdapter(context, new ShowRoomActivity$onCreate$$inlined$run$lambda$1(recyclerView, this)));
        recyclerView.addOnScrollListener(new ShowRoomActivity$onCreate$$inlined$run$lambda$2(this));
        EventBus.getDefault().register(this);
        this.userID = getIntent().getLongExtra(KEY_USER_ID, -1);
        loadShowroomData();
        this.myPostDeletedEventSubscription = RxBus.INSTANCE.toObservable().subscribe((Consumer<? super T>) new ShowRoomActivity$onCreate$5<Object>(this));
        leaveEnterLog();
    }

    public final void leaveEnterLog() {
        String stringExtra = getIntent().getStringExtra(KEY_START_FROM);
        if (stringExtra != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("ShowRoomActivity::Enter From ");
            sb.append(stringExtra);
            Logger.d(sb.toString(), new Object[0]);
            EventTracker eventTracker2 = this.eventTracker;
            if (eventTracker2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("eventTracker");
            }
            eventTracker2.logCustom("View ShowRoom", new CustomAttributes().put("from", stringExtra));
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        this._started = true;
        if (this.shouldReloadMyPosts) {
            this.shouldReloadMyPosts = false;
            loadShowroomData();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        Adapter<ViewHolder> adapter = this.tempAdapter;
        if (adapter != null) {
            RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C0010R$id.post_list);
            String str = "post_list";
            Intrinsics.checkExpressionValueIsNotNull(recyclerView, str);
            recyclerView.setAdapter(adapter);
            RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(C0010R$id.post_list);
            Intrinsics.checkExpressionValueIsNotNull(recyclerView2, str);
            LayoutManager layoutManager = recyclerView2.getLayoutManager();
            if (layoutManager != null) {
                layoutManager.onRestoreInstanceState(this.recyclerViewState);
            }
        }
        super.onResume();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        this._started = false;
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C0010R$id.post_list);
        String str = "post_list";
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, str);
        LayoutManager layoutManager = recyclerView.getLayoutManager();
        this.recyclerViewState = layoutManager != null ? layoutManager.onSaveInstanceState() : null;
        RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(C0010R$id.post_list);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView2, str);
        this.tempAdapter = recyclerView2.getAdapter();
        RecyclerView recyclerView3 = (RecyclerView) _$_findCachedViewById(C0010R$id.post_list);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView3, str);
        recyclerView3.setAdapter(null);
        super.onStop();
    }

    public void onBackPressed() {
        finish();
        overridePendingTransition(C0001R$anim.fade_in, C0001R$anim.slide_left_out);
    }

    /* access modifiers changed from: private */
    public final void loadShowroomData() {
        Disposable disposable = this.showRoomRequest;
        if (disposable != null) {
            disposable.dispose();
        }
        UserAPI userAPI2 = this.userAPI;
        if (userAPI2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userAPI");
        }
        this.showRoomRequest = userAPI2.requestShowRoomInfo(Long.valueOf(this.userID)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).doOnSuccess(new ShowRoomActivity$loadShowroomData$1(this)).flatMap(new ShowRoomActivity$loadShowroomData$2(this)).subscribe((BiConsumer<? super T, ? super Throwable>) new ShowRoomActivity$loadShowroomData$3<Object,Object>(this));
    }

    /* access modifiers changed from: private */
    public final void initPaginate(RecyclerView recyclerView) {
        Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        ref$BooleanRef.element = false;
        Paginate paginate2 = this.paginate;
        if (paginate2 != null) {
            if (paginate2 == null) {
                Intrinsics.throwNpe();
            }
            paginate2.unbind();
        }
        ShowRoomActivity$initPaginate$callbacks$1 showRoomActivity$initPaginate$callbacks$1 = new ShowRoomActivity$initPaginate$callbacks$1(this, ref$BooleanRef, recyclerView);
        if (recyclerView.getAdapter() != null) {
            this.paginate = Paginate.with(recyclerView, (Callbacks) showRoomActivity$initPaginate$callbacks$1).setLoadingTriggerThreshold(0).setLoadingListItemCreator(new CustomLoadingListItemCreator()).build();
        }
    }

    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        if (i2 == -1) {
            ArrayList stringArrayListExtra = intent != null ? intent.getStringArrayListExtra(ImageSelectorActivity.Companion.getREQUEST_OUTPUT()) : null;
            if (stringArrayListExtra != null && stringArrayListExtra.size() >= 1) {
                String str = "userAPI";
                String str2 = "MultipartBody.Part.creat…age(image_uris[0]).file))";
                String str3 = "image_uris[0]";
                String str4 = "image/jpeg";
                if (i == ImageFile.Companion.getTYPE_SHOW_ROOM()) {
                    Disposable disposable = this.uploadShowRoomImageRequest;
                    if (disposable != null) {
                        disposable.dispose();
                    }
                    UserAPI userAPI2 = this.userAPI;
                    if (userAPI2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(str);
                    }
                    String str5 = (String) stringArrayListExtra.get(0);
                    MediaType parse = MediaType.parse(str4);
                    Object obj = stringArrayListExtra.get(0);
                    Intrinsics.checkExpressionValueIsNotNull(obj, str3);
                    Part createFormData = Part.createFormData("file", str5, RequestBody.create(parse, new CreateImage((String) obj).getFile()));
                    Intrinsics.checkExpressionValueIsNotNull(createFormData, str2);
                    this.uploadShowRoomImageRequest = userAPI2.uploadFile(createFormData).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).flatMap(new ShowRoomActivity$onActivityResult$1(this)).subscribe((BiConsumer<? super T, ? super Throwable>) new ShowRoomActivity$onActivityResult$2<Object,Object>(this));
                } else if (i == ImageFile.Companion.getTYPE_PROFILE()) {
                    Disposable disposable2 = this.uploadProfileImageRequest;
                    if (disposable2 != null) {
                        disposable2.dispose();
                    }
                    UserAPI userAPI3 = this.userAPI;
                    if (userAPI3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(str);
                    }
                    String str6 = (String) stringArrayListExtra.get(0);
                    MediaType parse2 = MediaType.parse(str4);
                    Object obj2 = stringArrayListExtra.get(0);
                    Intrinsics.checkExpressionValueIsNotNull(obj2, str3);
                    Part createFormData2 = Part.createFormData("profile_image", str6, RequestBody.create(parse2, new CreateImage((String) obj2).getFile()));
                    Intrinsics.checkExpressionValueIsNotNull(createFormData2, str2);
                    this.uploadProfileImageRequest = userAPI3.uploadProfile(createFormData2).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new ShowRoomActivity$onActivityResult$3<Object,Object>(this));
                }
            }
        }
    }

    @Subscriber(mode = ThreadMode.MAIN, tag = "showroom_message")
    public final void onReceive(@NotNull Message message) {
        Object obj;
        Object obj2;
        Intrinsics.checkParameterIsNotNull(message, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        ShowRoom showRoom = this.showRoomInfo;
        if (showRoom instanceof ShowRoom) {
            int i = message.what;
            String str = "postId";
            String str2 = "post_list";
            Integer num = null;
            if (i == 1) {
                ArrayList<Post> arrayList = this.postList;
                ArrayList<Post> arrayList2 = new ArrayList<>();
                for (Object next : arrayList) {
                    if (message.getData().getLong(str) == ((Post) next).getId()) {
                        arrayList2.add(next);
                    }
                }
                ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10));
                for (Post post : arrayList2) {
                    if (message.getData().getBoolean("isAddedComment")) {
                        post.setCommentsCount(post.getCommentsCount() + 1);
                    } else {
                        post.setCommentsCount(post.getCommentsCount() - 1);
                    }
                    RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C0010R$id.post_list);
                    Intrinsics.checkExpressionValueIsNotNull(recyclerView, str2);
                    Adapter adapter = recyclerView.getAdapter();
                    if (adapter != null) {
                        adapter.notifyItemChanged(this.postList.indexOf(post) + 1);
                        obj = Unit.INSTANCE;
                    } else {
                        obj = null;
                    }
                    arrayList3.add(obj);
                }
            } else if (i == 2) {
                String str3 = "isFollowed";
                if (this.isMine) {
                    if (message.getData().getBoolean(str3)) {
                        ShowRoom showRoom2 = this.showRoomInfo;
                        if (showRoom2 == null) {
                            Intrinsics.throwNpe();
                        }
                        User user = showRoom2.getUser();
                        ShowRoom showRoom3 = this.showRoomInfo;
                        if (showRoom3 == null) {
                            Intrinsics.throwNpe();
                        }
                        Integer followingsCount = showRoom3.getUser().getFollowingsCount();
                        if (followingsCount != null) {
                            num = Integer.valueOf(followingsCount.intValue() + 1);
                        }
                        user.setFollowingsCount(num);
                    } else {
                        ShowRoom showRoom4 = this.showRoomInfo;
                        if (showRoom4 == null) {
                            Intrinsics.throwNpe();
                        }
                        User user2 = showRoom4.getUser();
                        ShowRoom showRoom5 = this.showRoomInfo;
                        if (showRoom5 == null) {
                            Intrinsics.throwNpe();
                        }
                        Integer followingsCount2 = showRoom5.getUser().getFollowingsCount();
                        if (followingsCount2 != null) {
                            num = Integer.valueOf(followingsCount2.intValue() - 1);
                        }
                        user2.setFollowingsCount(num);
                    }
                } else if (this.userID == message.getData().getLong("userId")) {
                    if (message.getData().getBoolean(str3)) {
                        ShowRoom showRoom6 = this.showRoomInfo;
                        if (showRoom6 == null) {
                            Intrinsics.throwNpe();
                        }
                        User user3 = showRoom6.getUser();
                        ShowRoom showRoom7 = this.showRoomInfo;
                        if (showRoom7 == null) {
                            Intrinsics.throwNpe();
                        }
                        Integer followersCount = showRoom7.getUser().getFollowersCount();
                        if (followersCount != null) {
                            num = Integer.valueOf(followersCount.intValue() + 1);
                        }
                        user3.setFollowersCount(num);
                        ShowRoom showRoom8 = this.showRoomInfo;
                        if (showRoom8 == null) {
                            Intrinsics.throwNpe();
                        }
                        showRoom8.getUser().setFollowing(true);
                    } else {
                        ShowRoom showRoom9 = this.showRoomInfo;
                        if (showRoom9 == null) {
                            Intrinsics.throwNpe();
                        }
                        User user4 = showRoom9.getUser();
                        ShowRoom showRoom10 = this.showRoomInfo;
                        if (showRoom10 == null) {
                            Intrinsics.throwNpe();
                        }
                        Integer followersCount2 = showRoom10.getUser().getFollowersCount();
                        if (followersCount2 != null) {
                            num = Integer.valueOf(followersCount2.intValue() - 1);
                        }
                        user4.setFollowersCount(num);
                        ShowRoom showRoom11 = this.showRoomInfo;
                        if (showRoom11 == null) {
                            Intrinsics.throwNpe();
                        }
                        showRoom11.getUser().setFollowing(false);
                    }
                }
                RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(C0010R$id.post_list);
                Intrinsics.checkExpressionValueIsNotNull(recyclerView2, str2);
                Adapter adapter2 = recyclerView2.getAdapter();
                if (adapter2 != null) {
                    adapter2.notifyItemChanged(0);
                }
            } else if (i == 3) {
                ArrayList<Post> arrayList4 = this.postList;
                ArrayList<Post> arrayList5 = new ArrayList<>();
                for (Object next2 : arrayList4) {
                    if (message.getData().getLong(str) == ((Post) next2).getId()) {
                        arrayList5.add(next2);
                    }
                }
                ArrayList arrayList6 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList5, 10));
                for (Post post2 : arrayList5) {
                    if (message.getData().getBoolean("isLiked")) {
                        post2.setLiked(true);
                        post2.setLikesCount(post2.getLikesCount() + 1);
                    } else {
                        post2.setLiked(false);
                        post2.setLikesCount(post2.getLikesCount() - 1);
                    }
                    RecyclerView recyclerView3 = (RecyclerView) _$_findCachedViewById(C0010R$id.post_list);
                    Intrinsics.checkExpressionValueIsNotNull(recyclerView3, str2);
                    Adapter adapter3 = recyclerView3.getAdapter();
                    if (adapter3 != null) {
                        adapter3.notifyItemChanged(this.postList.indexOf(post2) + 1);
                        obj2 = Unit.INSTANCE;
                    } else {
                        obj2 = null;
                    }
                    arrayList6.add(obj2);
                }
            } else if (i != 4) {
                if (i == 5 && this.isMine) {
                    UserAPI userAPI2 = this.userAPI;
                    if (userAPI2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("userAPI");
                    }
                    this.showRoomRequest = userAPI2.requestShowRoomInfo(Long.valueOf(this.userID)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new ShowRoomActivity$onReceive$5<Object,Object>(this));
                }
            } else if (this.isMine) {
                if (showRoom == null) {
                    Intrinsics.throwNpe();
                }
                User user5 = showRoom.getUser();
                String string = message.getData().getString("profileImageUrl");
                Intrinsics.checkExpressionValueIsNotNull(string, "message.data.getString(\"profileImageUrl\")");
                user5.setProfileImageUrl(string);
                RecyclerView recyclerView4 = (RecyclerView) _$_findCachedViewById(C0010R$id.post_list);
                Intrinsics.checkExpressionValueIsNotNull(recyclerView4, str2);
                Adapter adapter4 = recyclerView4.getAdapter();
                if (adapter4 != null) {
                    adapter4.notifyItemChanged(0);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        Disposable disposable = this.showRoomRequest;
        if (disposable != null) {
            disposable.dispose();
        }
        Disposable disposable2 = this.uploadShowRoomImageRequest;
        if (disposable2 != null) {
            disposable2.dispose();
        }
        Disposable disposable3 = this.uploadProfileImageRequest;
        if (disposable3 != null) {
            disposable3.dispose();
        }
        Disposable disposable4 = this.deleteFollowRequest;
        if (disposable4 != null) {
            disposable4.dispose();
        }
        Disposable disposable5 = this.putFollowRequest;
        if (disposable5 != null) {
            disposable5.dispose();
        }
        Disposable disposable6 = this.putLikeRequest;
        if (disposable6 != null) {
            disposable6.dispose();
        }
        Disposable disposable7 = this.deleteLikeRequest;
        if (disposable7 != null) {
            disposable7.dispose();
        }
        Disposable disposable8 = this.userCheckRequest;
        if (disposable8 != null) {
            disposable8.dispose();
        }
        CreatePostActivityUtil createPostActivityUtil2 = this.createPostActivityUtil;
        if (createPostActivityUtil2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("createPostActivityUtil");
        }
        createPostActivityUtil2.clear();
        this.showRoomRequest = null;
        this.uploadShowRoomImageRequest = null;
        this.uploadProfileImageRequest = null;
        this.deleteFollowRequest = null;
        this.putFollowRequest = null;
        this.putLikeRequest = null;
        this.deleteLikeRequest = null;
        Disposable disposable9 = this.myPostDeletedEventSubscription;
        if (disposable9 != null) {
            disposable9.dispose();
        }
        this.disposables.dispose();
        this.userID = -1;
        this.postList = new ArrayList<>();
        this.isLinear = false;
        this.isMine = false;
        this.paginate = null;
        this.isTotalItemLoaded = false;
        super.onDestroy();
    }
}
