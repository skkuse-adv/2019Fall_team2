package kr.co.popone.fitts.feature.recommend.personalization;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.orhanobut.logger.Logger;
import dagger.android.AndroidInjection;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0001R$anim;
import kr.co.popone.fitts.C0006R$color;
import kr.co.popone.fitts.C0008R$drawable;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.C0016R$string;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.eventtracker.EventTracker.CustomAttributes;
import kr.co.popone.fitts.feature.intro.IntroActivity;
import kr.co.popone.fitts.feature.post.detail.PostActivity;
import kr.co.popone.fitts.feature.recommend.personalization.PersonalizedRecommendPostAdpater.Decoration;
import kr.co.popone.fitts.feature.showroom.ShowRoomActivity;
import kr.co.popone.fitts.model.datamodel.service.post.Image;
import kr.co.popone.fitts.model.datamodel.service.user.User;
import kr.co.popone.fitts.model.datamodel.social.recommend.PersonalRecommendation;
import kr.co.popone.fitts.model.post.PostAPI.Post;
import kr.co.popone.fitts.model.repository.social.FittsSocialRepository;
import kr.co.popone.fitts.model.user.UserAPI;
import kr.co.popone.fitts.utils.ActionLogUtil;
import kr.co.popone.fitts.utils.Snackbar;
import org.jetbrains.anko.Sdk27PropertiesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.simple.eventbus.EventBus;
import org.simple.eventbus.Subscriber;
import org.simple.eventbus.ThreadMode;
import retrofit2.HttpException;

public final class PersonalizedRecommendActivity extends AppCompatActivity {
    private HashMap _$_findViewCache;
    @NotNull
    public ActionLogUtil actionLogUtil;
    @NotNull
    public EventTracker eventTracker;
    /* access modifiers changed from: private */
    public Disposable followingDisposable;
    private Disposable loadingDisposable;
    private final BehaviorSubject<Boolean> loadingSubject;
    private Parameters parameters;
    private Disposable personalizedRecommendDisposable;
    @NotNull
    public FittsSocialRepository socialRepository;
    /* access modifiers changed from: private */
    public Disposable unfollowingDisposable;
    @NotNull
    public UserAPI userAPI;
    /* access modifiers changed from: private */
    public List<User> users;

    public static final class Parameters implements Parcelable {
        public static final android.os.Parcelable.Creator CREATOR = new Creator();
        public static final Companion Companion = new Companion(null);
        @NotNull
        public static final String PARAMETER_NAME = "parameters";
        private final int contentsId;

        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public static class Creator implements android.os.Parcelable.Creator {
            @NotNull
            public final Object createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkParameterIsNotNull(parcel, "in");
                return new Parameters(parcel.readInt());
            }

            @NotNull
            public final Object[] newArray(int i) {
                return new Parameters[i];
            }
        }

        @NotNull
        public static /* synthetic */ Parameters copy$default(Parameters parameters, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = parameters.contentsId;
            }
            return parameters.copy(i);
        }

        public final int component1() {
            return this.contentsId;
        }

        @NotNull
        public final Parameters copy(int i) {
            return new Parameters(i);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                if (obj instanceof Parameters) {
                    if (this.contentsId == ((Parameters) obj).contentsId) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            return this.contentsId;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Parameters(contentsId=");
            sb.append(this.contentsId);
            sb.append(")");
            return sb.toString();
        }

        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkParameterIsNotNull(parcel, "parcel");
            parcel.writeInt(this.contentsId);
        }

        public Parameters(int i) {
            this.contentsId = i;
        }

        public final int getContentsId() {
            return this.contentsId;
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

    public PersonalizedRecommendActivity() {
        BehaviorSubject<Boolean> createDefault = BehaviorSubject.createDefault(Boolean.valueOf(false));
        Intrinsics.checkExpressionValueIsNotNull(createDefault, "BehaviorSubject.createDefault(false)");
        this.loadingSubject = createDefault;
    }

    public static final /* synthetic */ List access$getUsers$p(PersonalizedRecommendActivity personalizedRecommendActivity) {
        List<User> list = personalizedRecommendActivity.users;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("users");
        }
        return list;
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
    public final FittsSocialRepository getSocialRepository$app_productionFittsRelease() {
        FittsSocialRepository fittsSocialRepository = this.socialRepository;
        if (fittsSocialRepository == null) {
            Intrinsics.throwUninitializedPropertyAccessException("socialRepository");
        }
        return fittsSocialRepository;
    }

    public final void setSocialRepository$app_productionFittsRelease(@NotNull FittsSocialRepository fittsSocialRepository) {
        Intrinsics.checkParameterIsNotNull(fittsSocialRepository, "<set-?>");
        this.socialRepository = fittsSocialRepository;
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

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        AndroidInjection.inject((Activity) this);
        super.onCreate(bundle);
        setContentView((int) C0013R$layout.activity_personalized_recommend);
        initializeView();
        registerEventSubscriber();
        Parcelable parcelableExtra = getIntent().getParcelableExtra("parameters");
        Intrinsics.checkExpressionValueIsNotNull(parcelableExtra, "intent.getParcelableExtr…arameters.PARAMETER_NAME)");
        this.parameters = (Parameters) parcelableExtra;
        getPersonalizedrecommendListRequest();
        EventBus.getDefault().register(this);
    }

    private final void initializeView() {
        ImageButton imageButton = (ImageButton) _$_findCachedViewById(C0010R$id.backButton);
        imageButton.setImageResource(C0008R$drawable.button_cancel);
        imageButton.setOnClickListener(new PersonalizedRecommendActivity$initializeView$$inlined$apply$lambda$1(this));
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) _$_findCachedViewById(C0010R$id.swipeRefreshLayout);
        Intrinsics.checkExpressionValueIsNotNull(swipeRefreshLayout, "swipeRefreshLayout");
        swipeRefreshLayout.setEnabled(false);
    }

    private final void registerEventSubscriber() {
        this.loadingDisposable = this.loadingSubject.subscribe((Consumer<? super T>) new PersonalizedRecommendActivity$registerEventSubscriber$1<Object>(this));
    }

    @Subscriber(mode = ThreadMode.MAIN, tag = "follow_message")
    private final void onReceive(Message message) {
        Unit unit;
        if (message.what == 2) {
            List<User> list = this.users;
            String str = "users";
            if (list == null) {
                Intrinsics.throwUninitializedPropertyAccessException(str);
            }
            ArrayList<User> arrayList = new ArrayList<>();
            for (Object next : list) {
                if (message.getData().getLong("userId") == ((User) next).getId()) {
                    arrayList.add(next);
                }
            }
            ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
            for (User user : arrayList) {
                String str2 = "isFollowed";
                user.setFollowing(message.getData().getBoolean(str2));
                RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C0010R$id.recomendedUserRecyclerView);
                Intrinsics.checkExpressionValueIsNotNull(recyclerView, "recomendedUserRecyclerView");
                Adapter adapter = recyclerView.getAdapter();
                if (adapter != null) {
                    List<User> list2 = this.users;
                    if (list2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(str);
                    }
                    adapter.notifyItemChanged(list2.indexOf(user), Boolean.valueOf(message.getData().getBoolean(str2)));
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                arrayList2.add(unit);
            }
        }
    }

    private final void getPersonalizedrecommendListRequest() {
        if (this.personalizedRecommendDisposable == null) {
            this.loadingSubject.onNext(Boolean.valueOf(true));
            FittsSocialRepository fittsSocialRepository = this.socialRepository;
            if (fittsSocialRepository == null) {
                Intrinsics.throwUninitializedPropertyAccessException("socialRepository");
            }
            Parameters parameters2 = this.parameters;
            if (parameters2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("parameters");
            }
            this.personalizedRecommendDisposable = fittsSocialRepository.getPersonalRecommandations(parameters2.getContentsId()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new PersonalizedRecommendActivity$getPersonalizedrecommendListRequest$1<Object,Object>(this));
        }
    }

    /* access modifiers changed from: private */
    public final void getShowRoomPostsRequest(long j, RecyclerView recyclerView) {
        UserAPI userAPI2 = this.userAPI;
        if (userAPI2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userAPI");
        }
        userAPI2.getShowRoomPosts(j, "recent", null, 3).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new PersonalizedRecommendActivity$getShowRoomPostsRequest$1<Object,Object>(this, recyclerView));
    }

    /* access modifiers changed from: private */
    public final void updatePersonalizedRecommendUi(PersonalRecommendation personalRecommendation, Throwable th) {
        if (personalRecommendation != null) {
            TextView textView = (TextView) _$_findCachedViewById(C0010R$id.toolbarTitle);
            Intrinsics.checkExpressionValueIsNotNull(textView, "toolbarTitle");
            textView.setText(personalRecommendation.getShortTitle());
            updatePostUi(personalRecommendation.getPosts());
            updateUserUi(personalRecommendation.getUsers());
            this.personalizedRecommendDisposable = null;
        } else {
            handleError(th);
        }
        this.loadingSubject.onNext(Boolean.valueOf(false));
    }

    private final void updatePostUi(List<Post> list) {
        if (list != null) {
            GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
            gridLayoutManager.setSpanSizeLookup(new PersonalizedRecommendActivity$updatePostUi$manager$1$1());
            RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C0010R$id.recommendPostRecyclerView);
            recyclerView.setLayoutManager(gridLayoutManager);
            recyclerView.setAdapter(new PersonalizedRecommendPostAdpater(this, new PersonalizedRecommendActivity$updatePostUi$$inlined$apply$lambda$1(this, gridLayoutManager, list)));
            recyclerView.addItemDecoration(new Decoration());
        }
    }

    private final void updateUserUi(List<User> list) {
        if (list != null) {
            this.users = list;
            RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C0010R$id.recomendedUserRecyclerView);
            Intrinsics.checkExpressionValueIsNotNull(recyclerView, "recomendedUserRecyclerView");
            recyclerView.setAdapter(new PersonalizedRecommendUserAdapter(this, new PersonalizedRecommendActivity$updateUserUi$1(this)));
        }
    }

    /* access modifiers changed from: private */
    public final void updateUserPostUi(RecyclerView recyclerView, List<Post> list, Throwable th) {
        if (list != null) {
            recyclerView.setAdapter(new PersonalizedRecommendUserPostAdapter(this, new PersonalizedRecommendActivity$updateUserPostUi$1(this, list)));
        } else {
            handleError(th);
        }
    }

    /* access modifiers changed from: private */
    public final void handleError(Throwable th) {
        if (!(th instanceof HttpException)) {
            Snackbar.Companion.showMessage(this, "죄송합니다.\n서비스가 잠시 지연되고 있습니다.\n잠시 후 다시 이용해주세요.");
        } else if (((HttpException) th).code() == 401) {
            Intent intent = new Intent(this, IntroActivity.class);
            intent.addFlags(32768);
            intent.addFlags(268435456);
            startActivity(intent);
        }
    }

    /* access modifiers changed from: private */
    public final void updateFollowButtonStateUi(TextView textView, int i, int i2, int i3) {
        textView.setBackground(ContextCompat.getDrawable(this, i));
        textView.setText(getString(i2));
        Sdk27PropertiesKt.setTextColor(textView, ContextCompat.getColor(this, i3));
    }

    /* access modifiers changed from: private */
    public final void followButtonClicked(User user, TextView textView) {
        textView.setClickable(false);
        boolean isFollowing = user.isFollowing();
        String str = "userAPI";
        if (!isFollowing) {
            user.setFollowing(true);
            updateFollowButtonStateUi(textView, C0008R$drawable.round_button_following, C0016R$string.following, C0006R$color.gray4);
            if (Intrinsics.areEqual((Object) user.getStatus(), (Object) "deactivated")) {
                textView.setClickable(true);
                user.setFollowing(false);
                updateFollowButtonStateUi(textView, C0008R$drawable.round_button_follow, C0016R$string.follow, 17170443);
                Logger.d("user follow_deactivated", new Object[0]);
                Snackbar.Companion.showMessage(this, "탈퇴한 사용자입니다");
                return;
            }
            Disposable disposable = this.followingDisposable;
            if (disposable != null) {
                disposable.dispose();
            }
            UserAPI userAPI2 = this.userAPI;
            if (userAPI2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(str);
            }
            this.followingDisposable = userAPI2.putFollow(user.getId()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new PersonalizedRecommendActivity$followButtonClicked$1<Object,Object>(this, textView, user));
        } else if (isFollowing) {
            user.setFollowing(false);
            updateFollowButtonStateUi(textView, C0008R$drawable.round_button_follow, C0016R$string.follow, 17170443);
            Disposable disposable2 = this.unfollowingDisposable;
            if (disposable2 != null) {
                disposable2.dispose();
            }
            UserAPI userAPI3 = this.userAPI;
            if (userAPI3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(str);
            }
            this.unfollowingDisposable = userAPI3.deleteFollow(user.getId()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new PersonalizedRecommendActivity$followButtonClicked$2<Object,Object>(this, textView, user));
        }
    }

    /* access modifiers changed from: private */
    public final void startPostActivity(Post post) {
        EventTracker eventTracker2 = this.eventTracker;
        if (eventTracker2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eventTracker");
        }
        eventTracker2.logCustom("View Post", new CustomAttributes().put("from", "recommend"));
        ActionLogUtil actionLogUtil2 = this.actionLogUtil;
        if (actionLogUtil2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionLogUtil");
        }
        ActionLogUtil.defineCurrentWindow$default(actionLogUtil2, "Personalized_Recommend", "", 0, 4, null);
        Intent intent = new Intent(this, PostActivity.class);
        intent.putExtra("post_id", post.getId());
        Image coverImage = post.getCoverImage();
        intent.putExtra("post_cover", coverImage != null ? coverImage.getUrl() : null);
        ActivityOptionsCompat makeCustomAnimation = ActivityOptionsCompat.makeCustomAnimation(this, C0001R$anim.slide_right, C0001R$anim.fade_out);
        Intrinsics.checkExpressionValueIsNotNull(makeCustomAnimation, "ActivityOptionsCompat.ma…e_right, R.anim.fade_out)");
        startActivity(intent, makeCustomAnimation.toBundle());
    }

    /* access modifiers changed from: private */
    public final void startShowRoomActivity(User user) {
        ShowRoomActivity.Companion.start(this, Long.valueOf(user.getId()), "collection");
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        Disposable disposable = this.followingDisposable;
        if (disposable != null) {
            disposable.dispose();
        }
        Disposable disposable2 = this.unfollowingDisposable;
        if (disposable2 != null) {
            disposable2.dispose();
        }
        Disposable disposable3 = this.loadingDisposable;
        if (disposable3 != null) {
            disposable3.dispose();
        }
        Disposable disposable4 = this.personalizedRecommendDisposable;
        if (disposable4 != null) {
            disposable4.dispose();
        }
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    public void onBackPressed() {
        finish();
        overridePendingTransition(C0001R$anim.fade_in, C0001R$anim.slide_down);
    }
}
