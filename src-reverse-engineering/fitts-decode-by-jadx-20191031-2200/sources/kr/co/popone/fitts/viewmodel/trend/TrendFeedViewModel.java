package kr.co.popone.fitts.viewmodel.trend;

import android.app.Activity;
import androidx.lifecycle.MutableLiveData;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.base.BaseViewModel;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.eventtracker.EventTracker.CustomAttributes;
import kr.co.popone.fitts.model.datamodel.social.feed.Feed;
import kr.co.popone.fitts.model.datamodel.social.feed.TrendType;
import kr.co.popone.fitts.model.repository.social.FittsSocialRepository;
import kr.co.popone.fitts.services.FittsSchemeHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class TrendFeedViewModel extends BaseViewModel {
    private final MutableLiveData<Navigation> _navigationLiveData = new MutableLiveData<>();
    /* access modifiers changed from: private */
    public final MutableLiveData<NetworkState> _networkState = new MutableLiveData<>();
    private final MutableLiveData<Function1<Activity, Unit>> _schemeLiveData = new MutableLiveData<>();
    /* access modifiers changed from: private */
    public final MutableLiveData<String> _titleLiveData = new MutableLiveData<>();
    /* access modifiers changed from: private */
    public final MutableLiveData<List<Feed>> _trendFeedsLiveData = new MutableLiveData<>();
    private final CompositeDisposable disposables = new CompositeDisposable();
    private final EventTracker eventTracker;
    private final long id;
    /* access modifiers changed from: private */
    public final FittsSchemeHandler schemeHandler;
    private final SessionManager sessionManager;
    private final FittsSocialRepository socialRepository;
    /* access modifiers changed from: private */
    public final TrendType type;

    public static abstract class Navigation {

        public static final class PostActivity extends Navigation {
            private final long id;

            @NotNull
            public static /* synthetic */ PostActivity copy$default(PostActivity postActivity, long j, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = postActivity.id;
                }
                return postActivity.copy(j);
            }

            public final long component1() {
                return this.id;
            }

            @NotNull
            public final PostActivity copy(long j) {
                return new PostActivity(j);
            }

            public boolean equals(@Nullable Object obj) {
                if (this != obj) {
                    if (obj instanceof PostActivity) {
                        if (this.id == ((PostActivity) obj).id) {
                            return true;
                        }
                    }
                    return false;
                }
                return true;
            }

            public int hashCode() {
                long j = this.id;
                return (int) (j ^ (j >>> 32));
            }

            @NotNull
            public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append("PostActivity(id=");
                sb.append(this.id);
                sb.append(")");
                return sb.toString();
            }

            public PostActivity(long j) {
                super(null);
                this.id = j;
            }

            public final long getId() {
                return this.id;
            }
        }

        public static final class ProductActivity extends Navigation {
            @NotNull
            private final String from;
            @NotNull
            private final String url;

            @NotNull
            public static /* synthetic */ ProductActivity copy$default(ProductActivity productActivity, String str, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = productActivity.url;
                }
                if ((i & 2) != 0) {
                    str2 = productActivity.from;
                }
                return productActivity.copy(str, str2);
            }

            @NotNull
            public final String component1() {
                return this.url;
            }

            @NotNull
            public final String component2() {
                return this.from;
            }

            @NotNull
            public final ProductActivity copy(@NotNull String str, @NotNull String str2) {
                Intrinsics.checkParameterIsNotNull(str, "url");
                Intrinsics.checkParameterIsNotNull(str2, "from");
                return new ProductActivity(str, str2);
            }

            /* JADX WARNING: Code restructure failed: missing block: B:6:0x001a, code lost:
                if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2.from, (java.lang.Object) r3.from) != false) goto L_0x001f;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r3) {
                /*
                    r2 = this;
                    if (r2 == r3) goto L_0x001f
                    boolean r0 = r3 instanceof kr.co.popone.fitts.viewmodel.trend.TrendFeedViewModel.Navigation.ProductActivity
                    if (r0 == 0) goto L_0x001d
                    kr.co.popone.fitts.viewmodel.trend.TrendFeedViewModel$Navigation$ProductActivity r3 = (kr.co.popone.fitts.viewmodel.trend.TrendFeedViewModel.Navigation.ProductActivity) r3
                    java.lang.String r0 = r2.url
                    java.lang.String r1 = r3.url
                    boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
                    if (r0 == 0) goto L_0x001d
                    java.lang.String r0 = r2.from
                    java.lang.String r3 = r3.from
                    boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r3)
                    if (r3 == 0) goto L_0x001d
                    goto L_0x001f
                L_0x001d:
                    r3 = 0
                    return r3
                L_0x001f:
                    r3 = 1
                    return r3
                */
                throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.viewmodel.trend.TrendFeedViewModel.Navigation.ProductActivity.equals(java.lang.Object):boolean");
            }

            public int hashCode() {
                String str = this.url;
                int i = 0;
                int hashCode = (str != null ? str.hashCode() : 0) * 31;
                String str2 = this.from;
                if (str2 != null) {
                    i = str2.hashCode();
                }
                return hashCode + i;
            }

            @NotNull
            public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append("ProductActivity(url=");
                sb.append(this.url);
                sb.append(", from=");
                sb.append(this.from);
                sb.append(")");
                return sb.toString();
            }

            public ProductActivity(@NotNull String str, @NotNull String str2) {
                Intrinsics.checkParameterIsNotNull(str, "url");
                Intrinsics.checkParameterIsNotNull(str2, "from");
                super(null);
                this.url = str;
                this.from = str2;
            }

            @NotNull
            public final String getFrom() {
                return this.from;
            }

            @NotNull
            public final String getUrl() {
                return this.url;
            }
        }

        public static final class ShowRoom extends Navigation {
            private final long id;

            @NotNull
            public static /* synthetic */ ShowRoom copy$default(ShowRoom showRoom, long j, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = showRoom.id;
                }
                return showRoom.copy(j);
            }

            public final long component1() {
                return this.id;
            }

            @NotNull
            public final ShowRoom copy(long j) {
                return new ShowRoom(j);
            }

            public boolean equals(@Nullable Object obj) {
                if (this != obj) {
                    if (obj instanceof ShowRoom) {
                        if (this.id == ((ShowRoom) obj).id) {
                            return true;
                        }
                    }
                    return false;
                }
                return true;
            }

            public int hashCode() {
                long j = this.id;
                return (int) (j ^ (j >>> 32));
            }

            @NotNull
            public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append("ShowRoom(id=");
                sb.append(this.id);
                sb.append(")");
                return sb.toString();
            }

            public ShowRoom(long j) {
                super(null);
                this.id = j;
            }

            public final long getId() {
                return this.id;
            }
        }

        private Navigation() {
        }

        public /* synthetic */ Navigation(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public TrendFeedViewModel(long j, @Nullable TrendType trendType, @NotNull SessionManager sessionManager2, @NotNull FittsSchemeHandler fittsSchemeHandler, @NotNull EventTracker eventTracker2, @NotNull FittsSocialRepository fittsSocialRepository) {
        Intrinsics.checkParameterIsNotNull(sessionManager2, "sessionManager");
        Intrinsics.checkParameterIsNotNull(fittsSchemeHandler, "schemeHandler");
        Intrinsics.checkParameterIsNotNull(eventTracker2, "eventTracker");
        Intrinsics.checkParameterIsNotNull(fittsSocialRepository, "socialRepository");
        this.id = j;
        this.type = trendType;
        this.sessionManager = sessionManager2;
        this.schemeHandler = fittsSchemeHandler;
        this.eventTracker = eventTracker2;
        this.socialRepository = fittsSocialRepository;
        this._networkState.setValue(NetworkState.Companion.getLOADING());
        TrendType trendType2 = this.type;
        if (trendType2 != null) {
            String value = trendType2.getValue();
            if (value != null) {
                CompositeDisposable compositeDisposable = this.disposables;
                Disposable subscribe = this.socialRepository.getTrendDetail(this.id, value).subscribe(new TrendFeedViewModel$$special$$inlined$let$lambda$1(this), new TrendFeedViewModel$$special$$inlined$let$lambda$2(this));
                Intrinsics.checkExpressionValueIsNotNull(subscribe, "socialRepository.getTren…t)\n                    })");
                DisposableKt.plusAssign(compositeDisposable, subscribe);
            }
        }
    }

    @NotNull
    public final SessionManager getSessionManager() {
        return this.sessionManager;
    }

    @NotNull
    public final MutableLiveData<String> updateTrendTitle() {
        return this._titleLiveData;
    }

    @NotNull
    public final MutableLiveData<List<Feed>> updateTrendFeeds() {
        return this._trendFeedsLiveData;
    }

    @NotNull
    public final MutableLiveData<Function1<Activity, Unit>> updateScheme() {
        return this._schemeLiveData;
    }

    @NotNull
    public final MutableLiveData<Navigation> navigateActivity() {
        return this._navigationLiveData;
    }

    @NotNull
    public final MutableLiveData<NetworkState> updateNetworkState() {
        return this._networkState;
    }

    public final void schemeFeedClick(@Nullable String str) {
        this._schemeLiveData.setValue(new TrendFeedViewModel$schemeFeedClick$1(this, str));
    }

    public final void postFeedClick(long j) {
        this.eventTracker.logCustom("View Post", new CustomAttributes().put("from", "trend"));
        this._navigationLiveData.setValue(new PostActivity(j));
    }

    public final void productFeedClick(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "url");
        this._navigationLiveData.setValue(new ProductActivity(str, "trend"));
    }

    public final void fittieFeedClick(long j) {
        this._navigationLiveData.setValue(new ShowRoom(j));
    }

    public final void imageTagFeedClick(long j) {
        this._schemeLiveData.setValue(new TrendFeedViewModel$imageTagFeedClick$1(this, j));
    }

    /* access modifiers changed from: protected */
    public void onCleared() {
        this.disposables.dispose();
        super.onCleared();
    }
}
