package kr.co.popone.fitts.feature.follow;

import android.app.Activity;
import android.os.Bundle;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.paginate.Paginate;
import com.paginate.Paginate.Callbacks;
import com.paginate.recycler.LoadingListItemCreator;
import dagger.android.AndroidInjection;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0001R$anim;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.model.datamodel.service.user.User;
import kr.co.popone.fitts.model.user.UserAPI;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.simple.eventbus.EventBus;
import org.simple.eventbus.Subscriber;
import org.simple.eventbus.ThreadMode;

public final class FollowActivity extends AppCompatActivity {
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String PARAMETER_KEY = "parameters";
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public Long base;
    /* access modifiers changed from: private */
    public Disposable deleteFollowRequest;
    @NotNull
    public EventTracker eventTracker;
    /* access modifiers changed from: private */
    public int followCount;
    /* access modifiers changed from: private */
    public Disposable followListRequest;
    /* access modifiers changed from: private */
    public boolean isLoadingData;
    /* access modifiers changed from: private */
    public boolean isTotalItemLoaded;
    /* access modifiers changed from: private */
    public int limit = 10;
    /* access modifiers changed from: private */
    public Paginate paginate;
    /* access modifiers changed from: private */
    public Parameters parameters;
    /* access modifiers changed from: private */
    public Disposable putFollowRequest;
    @NotNull
    public SessionManager sessionManager;
    @NotNull
    public UserAPI userAPI;
    /* access modifiers changed from: private */
    public List<User> userList = CollectionsKt__CollectionsKt.emptyList();

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
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
            if (FollowActivity.this.isTotalItemLoaded) {
                vh.getLoadMoreItem().setVisibility(8);
            }
        }
    }

    public static final class Parameters implements Parcelable {
        public static final android.os.Parcelable.Creator CREATOR = new Creator();
        private final int followCount;
        private final boolean isFollowing;
        @Nullable
        private final Long userId;

        public static class Creator implements android.os.Parcelable.Creator {
            @NotNull
            public final Object createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkParameterIsNotNull(parcel, "in");
                return new Parameters(parcel.readInt() != 0, parcel.readInt(), parcel.readInt() != 0 ? Long.valueOf(parcel.readLong()) : null);
            }

            @NotNull
            public final Object[] newArray(int i) {
                return new Parameters[i];
            }
        }

        @NotNull
        public static /* synthetic */ Parameters copy$default(Parameters parameters, boolean z, int i, Long l, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                z = parameters.isFollowing;
            }
            if ((i2 & 2) != 0) {
                i = parameters.followCount;
            }
            if ((i2 & 4) != 0) {
                l = parameters.userId;
            }
            return parameters.copy(z, i, l);
        }

        public final boolean component1() {
            return this.isFollowing;
        }

        public final int component2() {
            return this.followCount;
        }

        @Nullable
        public final Long component3() {
            return this.userId;
        }

        @NotNull
        public final Parameters copy(boolean z, int i, @Nullable Long l) {
            return new Parameters(z, i, l);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                if (obj instanceof Parameters) {
                    Parameters parameters = (Parameters) obj;
                    if (this.isFollowing == parameters.isFollowing) {
                        if (!(this.followCount == parameters.followCount) || !Intrinsics.areEqual((Object) this.userId, (Object) parameters.userId)) {
                            return false;
                        }
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            boolean z = this.isFollowing;
            if (z) {
                z = true;
            }
            int i = (((z ? 1 : 0) * true) + this.followCount) * 31;
            Long l = this.userId;
            return i + (l != null ? l.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Parameters(isFollowing=");
            sb.append(this.isFollowing);
            sb.append(", followCount=");
            sb.append(this.followCount);
            sb.append(", userId=");
            sb.append(this.userId);
            sb.append(")");
            return sb.toString();
        }

        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkParameterIsNotNull(parcel, "parcel");
            parcel.writeInt(this.isFollowing ? 1 : 0);
            parcel.writeInt(this.followCount);
            Long l = this.userId;
            if (l != null) {
                parcel.writeInt(1);
                parcel.writeLong(l.longValue());
                return;
            }
            parcel.writeInt(0);
        }

        public Parameters(boolean z, int i, @Nullable Long l) {
            this.isFollowing = z;
            this.followCount = i;
            this.userId = l;
        }

        public /* synthetic */ Parameters(boolean z, int i, Long l, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            if ((i2 & 4) != 0) {
                l = null;
            }
            this(z, i, l);
        }

        public final int getFollowCount() {
            return this.followCount;
        }

        @Nullable
        public final Long getUserId() {
            return this.userId;
        }

        public final boolean isFollowing() {
            return this.isFollowing;
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

    public static final /* synthetic */ Parameters access$getParameters$p(FollowActivity followActivity) {
        Parameters parameters2 = followActivity.parameters;
        if (parameters2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("parameters");
        }
        return parameters2;
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

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        String str;
        AndroidInjection.inject((Activity) this);
        super.onCreate(bundle);
        setContentView((int) C0013R$layout.activity_following);
        String str2 = "parameters";
        Parcelable parcelableExtra = getIntent().getParcelableExtra(str2);
        Intrinsics.checkExpressionValueIsNotNull(parcelableExtra, "intent.getParcelableExtra(PARAMETER_KEY)");
        this.parameters = (Parameters) parcelableExtra;
        Parameters parameters2 = this.parameters;
        if (parameters2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str2);
        }
        this.followCount = parameters2.getFollowCount();
        TextView textView = (TextView) _$_findCachedViewById(C0010R$id.barTitle);
        Intrinsics.checkExpressionValueIsNotNull(textView, "barTitle");
        Parameters parameters3 = this.parameters;
        if (parameters3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str2);
        }
        boolean isFollowing = parameters3.isFollowing();
        if (isFollowing) {
            str = "팔로잉";
        } else if (!isFollowing) {
            str = "팔로워";
        } else {
            throw new NoWhenBranchMatchedException();
        }
        textView.setText(str);
        ((ImageButton) _$_findCachedViewById(C0010R$id.closeButton)).setOnClickListener(new FollowActivity$onCreate$1(this));
        requestFollowList();
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C0010R$id.followListRecyclerView);
        recyclerView.setAdapter(new FollowAdapter(this, new FollowActivity$onCreate$$inlined$run$lambda$1(this)));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, "this");
        initPaginate(recyclerView);
        EventBus.getDefault().register(this);
    }

    public void onBackPressed() {
        finish();
        overridePendingTransition(C0001R$anim.fade_in, C0001R$anim.slide_left_out);
    }

    public final void requestFollowList() {
        Single single;
        this.isLoadingData = true;
        Disposable disposable = this.followListRequest;
        if (disposable != null) {
            disposable.dispose();
        }
        Parameters parameters2 = this.parameters;
        String str = "parameters";
        if (parameters2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        String str2 = "sessionManager";
        String str3 = "userAPI";
        if (parameters2.getUserId() == null) {
            Parameters parameters3 = this.parameters;
            if (parameters3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(str);
            }
            if (parameters3.isFollowing()) {
                UserAPI userAPI2 = this.userAPI;
                if (userAPI2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(str3);
                }
                SessionManager sessionManager2 = this.sessionManager;
                if (sessionManager2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(str2);
                }
                single = userAPI2.requestFollowings(sessionManager2.getUserID(), this.base, Integer.valueOf(this.limit));
                this.followListRequest = single.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new FollowActivity$requestFollowList$1<Object,Object>(this));
                return;
            }
        }
        Parameters parameters4 = this.parameters;
        if (parameters4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        if (parameters4.getUserId() == null) {
            Parameters parameters5 = this.parameters;
            if (parameters5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(str);
            }
            if (!parameters5.isFollowing()) {
                UserAPI userAPI3 = this.userAPI;
                if (userAPI3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(str3);
                }
                SessionManager sessionManager3 = this.sessionManager;
                if (sessionManager3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(str2);
                }
                single = userAPI3.requestFollowers(sessionManager3.getUserID(), this.base, Integer.valueOf(this.limit));
                this.followListRequest = single.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new FollowActivity$requestFollowList$1<Object,Object>(this));
                return;
            }
        }
        Parameters parameters6 = this.parameters;
        if (parameters6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        if (parameters6.getUserId() != null) {
            Parameters parameters7 = this.parameters;
            if (parameters7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(str);
            }
            if (parameters7.isFollowing()) {
                UserAPI userAPI4 = this.userAPI;
                if (userAPI4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(str3);
                }
                Parameters parameters8 = this.parameters;
                if (parameters8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(str);
                }
                Long userId = parameters8.getUserId();
                if (userId == null) {
                    Intrinsics.throwNpe();
                }
                single = userAPI4.requestFollowings(userId.longValue(), this.base, Integer.valueOf(this.limit));
                this.followListRequest = single.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new FollowActivity$requestFollowList$1<Object,Object>(this));
                return;
            }
        }
        Parameters parameters9 = this.parameters;
        if (parameters9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        if (parameters9.getUserId() != null) {
            Parameters parameters10 = this.parameters;
            if (parameters10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(str);
            }
            if (!parameters10.isFollowing()) {
                UserAPI userAPI5 = this.userAPI;
                if (userAPI5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(str3);
                }
                Parameters parameters11 = this.parameters;
                if (parameters11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(str);
                }
                Long userId2 = parameters11.getUserId();
                if (userId2 == null) {
                    Intrinsics.throwNpe();
                }
                single = userAPI5.requestFollowers(userId2.longValue(), this.base, Integer.valueOf(this.limit));
                this.followListRequest = single.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new FollowActivity$requestFollowList$1<Object,Object>(this));
                return;
            }
        }
        throw new IllegalAccessException();
    }

    private final void initPaginate(RecyclerView recyclerView) {
        Paginate paginate2 = this.paginate;
        if (paginate2 != null) {
            if (paginate2 == null) {
                Intrinsics.throwNpe();
            }
            paginate2.unbind();
        }
        this.paginate = Paginate.with(recyclerView, (Callbacks) new FollowActivity$initPaginate$callbacks$1(this)).setLoadingTriggerThreshold(0).setLoadingListItemCreator(new CustomLoadingListItemCreator()).build();
    }

    @Subscriber(mode = ThreadMode.MAIN, tag = "my_message")
    public final void onReceive(@NotNull Message message) {
        String str;
        String str2;
        Unit unit;
        Intrinsics.checkParameterIsNotNull(message, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        if (message.what == 2) {
            List<User> list = this.userList;
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (true) {
                boolean z = false;
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (message.getData().getLong("userId") == ((User) next).getId()) {
                    z = true;
                }
                if (z) {
                    arrayList.add(next);
                }
            }
            ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
            Iterator it2 = arrayList.iterator();
            while (true) {
                str = "followListRecyclerView";
                str2 = "isFollowed";
                if (!it2.hasNext()) {
                    break;
                }
                User user = (User) it2.next();
                user.setFollowing(message.getData().getBoolean(str2));
                RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C0010R$id.followListRecyclerView);
                Intrinsics.checkExpressionValueIsNotNull(recyclerView, str);
                Adapter adapter = recyclerView.getAdapter();
                if (adapter != null) {
                    adapter.notifyItemChanged(this.userList.indexOf(user) + 1, Boolean.valueOf(message.getData().getBoolean(str2)));
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                arrayList2.add(unit);
            }
            Parameters parameters2 = this.parameters;
            if (parameters2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("parameters");
            }
            if (parameters2.getUserId() == null) {
                if (message.getData().getBoolean(str2)) {
                    this.followCount++;
                } else {
                    this.followCount--;
                }
                RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(C0010R$id.followListRecyclerView);
                Intrinsics.checkExpressionValueIsNotNull(recyclerView2, str);
                Adapter adapter2 = recyclerView2.getAdapter();
                if (adapter2 != null) {
                    adapter2.notifyItemChanged(0);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        EventBus.getDefault().unregister(this);
        Disposable disposable = this.followListRequest;
        if (disposable != null) {
            disposable.dispose();
        }
        Disposable disposable2 = this.putFollowRequest;
        if (disposable2 != null) {
            disposable2.dispose();
        }
        Disposable disposable3 = this.deleteFollowRequest;
        if (disposable3 != null) {
            disposable3.dispose();
        }
        this.followListRequest = null;
        this.putFollowRequest = null;
        this.deleteFollowRequest = null;
        super.onDestroy();
    }
}
