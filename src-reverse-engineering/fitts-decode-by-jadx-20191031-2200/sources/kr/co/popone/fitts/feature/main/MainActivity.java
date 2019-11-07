package kr.co.popone.fitts.feature.main;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Glide;
import com.kakao.kakaolink.internal.KakaoTalkLinkProtocol;
import com.orhanobut.logger.Logger;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import io.reactivex.rxkotlin.SubscribersKt;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.base.AppManager;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.base.extension.ActivityExtensionKt;
import kr.co.popone.fitts.base.extension.ContextExtensionKt;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.eventtracker.EventTracker.CustomAttributes;
import kr.co.popone.fitts.feature.appreview.AppReview;
import kr.co.popone.fitts.feature.base.Scrollable;
import kr.co.popone.fitts.feature.category.CategoryAdapter;
import kr.co.popone.fitts.feature.category.CategoryAdapter.Delegate;
import kr.co.popone.fitts.feature.category.CategorySearchActivity;
import kr.co.popone.fitts.feature.main.MainTabBar.Tab;
import kr.co.popone.fitts.feature.openweb.OpenWebActivity;
import kr.co.popone.fitts.feature.openweb.OpenWebActivity.Parameters;
import kr.co.popone.fitts.feature.post.upload.create.CreatePostActivityUtil;
import kr.co.popone.fitts.feature.showroom.ShowRoomActivity;
import kr.co.popone.fitts.feature.store.StoreFragment;
import kr.co.popone.fitts.model.category.CategoryViewData;
import kr.co.popone.fitts.model.datamodel.commerce.PaymentInvoiceResult;
import kr.co.popone.fitts.model.datamodel.service.banner.Banner;
import kr.co.popone.fitts.model.datamodel.service.log.ActionLog;
import kr.co.popone.fitts.model.datamodel.service.promotion.Promotion;
import kr.co.popone.fitts.model.datamodel.service.promotion.Promotion.Type;
import kr.co.popone.fitts.model.datamodel.service.view.ToolTip;
import kr.co.popone.fitts.model.datamodel.service.view.ToolTip.Location;
import kr.co.popone.fitts.model.log.ActionLogAPI;
import kr.co.popone.fitts.model.repository.service.FittsServiceRepository;
import kr.co.popone.fitts.model.repository.service.FittsServiceRepository.DefaultImpls;
import kr.co.popone.fitts.model.search.SearchAPI;
import kr.co.popone.fitts.model.user.UserAPI;
import kr.co.popone.fitts.repository.CategoryRepository;
import kr.co.popone.fitts.services.FittsNotificationHandler;
import kr.co.popone.fitts.services.FittsSchemeHandler;
import kr.co.popone.fitts.ui.DialogExtensions;
import kr.co.popone.fitts.ui.ViewExtensionsKt;
import kr.co.popone.fitts.utils.ActionLogUtil;
import kr.co.popone.fitts.utils.ActivityAnimationType;
import kr.co.popone.fitts.utils.Snackbar;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.simple.eventbus.EventBus;

public final class MainActivity extends AppCompatActivity implements HasSupportFragmentInjector, DrawerMenuListner, Delegate {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(MainActivity.class), "mainTabAdapter", "getMainTabAdapter()Lkr/co/popone/fitts/feature/main/MainAdapter;")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(MainActivity.class), "shopTooltip", "getShopTooltip()Lkr/co/popone/fitts/feature/main/MainActivity$ShopTooltipState;"))};
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String PARAMETER_GOTO_MY_SHOWROOM = "goto_my_showroom";
    @NotNull
    public static final String PARAMETER_GOTO_TAB = "goto_tab";
    @NotNull
    public static final String PARAMETER_MOVE_TAB_STORE = "move_tab_store";
    @NotNull
    public static final String PARAMETER_NEW_USER = "new_user";
    @NotNull
    public static final String PARAMETER_RETAIN_FILTER = "retain_filter";
    @NotNull
    public static final String PARAMETER_SHOW_PROMOTION_DIALOG = "show_promotion_dialog";
    @NotNull
    public static final String PARAMETER_SHOW_RECENT_AT_START = "show_recent";
    @NotNull
    public static final String PARAMETER_SHOW_REVIEW_DIALOG = "review_dialog";
    @NotNull
    public static final String PREF_EVENT_BANNER_BADGE_TIMESTAMP = "event_banner_badge_timestamp";
    @NotNull
    public static final String PREF_RECOMMENDATION_BANNER_BADGE_TIMESTAMP = "recommendation_banner_badge_timestamp";
    /* access modifiers changed from: private */
    public final int REQUEST_FITTIE_RECOMMEND = 201;
    private final int REQUEST_PROMOTION_POPUP = 202;
    private HashMap _$_findViewCache;
    @NotNull
    public ActionLogAPI actionLogAPI;
    @NotNull
    public ActionLogUtil actionLogUtil;
    /* access modifiers changed from: private */
    public Disposable alarmCountRequest;
    @NotNull
    public AppManager appManager;
    private long backPressedTime;
    private Disposable badgeTimestampRequest;
    /* access modifiers changed from: private */
    public final CategoryAdapter categoryAdapter = new CategoryAdapter(this);
    @NotNull
    public CategoryRepository categoryRepository;
    @NotNull
    public CreatePostActivityUtil createPostActivityUtil;
    /* access modifiers changed from: private */
    public final CompositeDisposable disposables = new CompositeDisposable();
    @NotNull
    public EventTracker eventTracker;
    @NotNull
    public FittsNotificationHandler fittsNotificationHandler;
    @NotNull
    public FittsServiceRepository fittsServiceRepository;
    @NotNull
    public DispatchingAndroidInjector<Fragment> fragmentInjector;
    private boolean loginScheme;
    @NotNull
    private final Lazy mainTabAdapter$delegate = LazyKt__LazyJVMKt.lazy(new MainActivity$mainTabAdapter$2(this));
    private Disposable promotionRequest;
    private Disposable recommendationBadgeRequest;
    /* access modifiers changed from: private */
    public Disposable reviewTimerRequest;
    @NotNull
    public FittsSchemeHandler schemeHandler;
    @NotNull
    public SearchAPI searchAPI;
    @NotNull
    public SessionManager sessionManager;
    private final ReadWriteProperty shopTooltip$delegate;
    /* access modifiers changed from: private */
    public Disposable shopTooltipDissmissDisposable;
    @NotNull
    public UserAPI userApi;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public enum ShopTooltipState {
        SHOW,
        DISMISS,
        CANCEL
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = new int[ShopTooltipState.values().length];
        public static final /* synthetic */ int[] $EnumSwitchMapping$1 = new int[Tab.values().length];
        public static final /* synthetic */ int[] $EnumSwitchMapping$2 = new int[Type.values().length];

        static {
            $EnumSwitchMapping$0[ShopTooltipState.SHOW.ordinal()] = 1;
            $EnumSwitchMapping$0[ShopTooltipState.DISMISS.ordinal()] = 2;
            $EnumSwitchMapping$0[ShopTooltipState.CANCEL.ordinal()] = 3;
            $EnumSwitchMapping$1[Tab.Home.ordinal()] = 1;
            $EnumSwitchMapping$1[Tab.Store.ordinal()] = 2;
            $EnumSwitchMapping$1[Tab.Notification.ordinal()] = 3;
            $EnumSwitchMapping$1[Tab.My.ordinal()] = 4;
            $EnumSwitchMapping$2[Type.IMAGE.ordinal()] = 1;
            $EnumSwitchMapping$2[Type.WEB.ordinal()] = 2;
        }
    }

    /* access modifiers changed from: private */
    public final ShopTooltipState getShopTooltip() {
        return (ShopTooltipState) this.shopTooltip$delegate.getValue(this, $$delegatedProperties[1]);
    }

    /* access modifiers changed from: private */
    public final void setShopTooltip(ShopTooltipState shopTooltipState) {
        this.shopTooltip$delegate.setValue(this, $$delegatedProperties[1], shopTooltipState);
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
    public final MainAdapter getMainTabAdapter() {
        Lazy lazy = this.mainTabAdapter$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (MainAdapter) lazy.getValue();
    }

    public MainActivity() {
        Delegates delegates = Delegates.INSTANCE;
        ShopTooltipState shopTooltipState = ShopTooltipState.SHOW;
        this.shopTooltip$delegate = new MainActivity$$special$$inlined$observable$1(shopTooltipState, shopTooltipState, this);
    }

    @NotNull
    public AndroidInjector<Fragment> supportFragmentInjector() {
        DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector = this.fragmentInjector;
        if (dispatchingAndroidInjector == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragmentInjector");
        }
        return dispatchingAndroidInjector;
    }

    @NotNull
    public final DispatchingAndroidInjector<Fragment> getFragmentInjector$app_productionFittsRelease() {
        DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector = this.fragmentInjector;
        if (dispatchingAndroidInjector == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragmentInjector");
        }
        return dispatchingAndroidInjector;
    }

    public final void setFragmentInjector$app_productionFittsRelease(@NotNull DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector) {
        Intrinsics.checkParameterIsNotNull(dispatchingAndroidInjector, "<set-?>");
        this.fragmentInjector = dispatchingAndroidInjector;
    }

    @NotNull
    public final FittsNotificationHandler getFittsNotificationHandler$app_productionFittsRelease() {
        FittsNotificationHandler fittsNotificationHandler2 = this.fittsNotificationHandler;
        if (fittsNotificationHandler2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fittsNotificationHandler");
        }
        return fittsNotificationHandler2;
    }

    public final void setFittsNotificationHandler$app_productionFittsRelease(@NotNull FittsNotificationHandler fittsNotificationHandler2) {
        Intrinsics.checkParameterIsNotNull(fittsNotificationHandler2, "<set-?>");
        this.fittsNotificationHandler = fittsNotificationHandler2;
    }

    @NotNull
    public final FittsSchemeHandler getSchemeHandler$app_productionFittsRelease() {
        FittsSchemeHandler fittsSchemeHandler = this.schemeHandler;
        if (fittsSchemeHandler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("schemeHandler");
        }
        return fittsSchemeHandler;
    }

    public final void setSchemeHandler$app_productionFittsRelease(@NotNull FittsSchemeHandler fittsSchemeHandler) {
        Intrinsics.checkParameterIsNotNull(fittsSchemeHandler, "<set-?>");
        this.schemeHandler = fittsSchemeHandler;
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
    public final AppManager getAppManager$app_productionFittsRelease() {
        AppManager appManager2 = this.appManager;
        if (appManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appManager");
        }
        return appManager2;
    }

    public final void setAppManager$app_productionFittsRelease(@NotNull AppManager appManager2) {
        Intrinsics.checkParameterIsNotNull(appManager2, "<set-?>");
        this.appManager = appManager2;
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
    public final SearchAPI getSearchAPI$app_productionFittsRelease() {
        SearchAPI searchAPI2 = this.searchAPI;
        if (searchAPI2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchAPI");
        }
        return searchAPI2;
    }

    public final void setSearchAPI$app_productionFittsRelease(@NotNull SearchAPI searchAPI2) {
        Intrinsics.checkParameterIsNotNull(searchAPI2, "<set-?>");
        this.searchAPI = searchAPI2;
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
    public final CategoryRepository getCategoryRepository$app_productionFittsRelease() {
        CategoryRepository categoryRepository2 = this.categoryRepository;
        if (categoryRepository2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("categoryRepository");
        }
        return categoryRepository2;
    }

    public final void setCategoryRepository$app_productionFittsRelease(@NotNull CategoryRepository categoryRepository2) {
        Intrinsics.checkParameterIsNotNull(categoryRepository2, "<set-?>");
        this.categoryRepository = categoryRepository2;
    }

    @NotNull
    public final FittsServiceRepository getFittsServiceRepository$app_productionFittsRelease() {
        FittsServiceRepository fittsServiceRepository2 = this.fittsServiceRepository;
        if (fittsServiceRepository2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fittsServiceRepository");
        }
        return fittsServiceRepository2;
    }

    public final void setFittsServiceRepository$app_productionFittsRelease(@NotNull FittsServiceRepository fittsServiceRepository2) {
        Intrinsics.checkParameterIsNotNull(fittsServiceRepository2, "<set-?>");
        this.fittsServiceRepository = fittsServiceRepository2;
    }

    @NotNull
    public final UserAPI getUserApi$app_productionFittsRelease() {
        UserAPI userAPI = this.userApi;
        if (userAPI == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userApi");
        }
        return userAPI;
    }

    public final void setUserApi$app_productionFittsRelease(@NotNull UserAPI userAPI) {
        Intrinsics.checkParameterIsNotNull(userAPI, "<set-?>");
        this.userApi = userAPI;
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

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0190  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(@org.jetbrains.annotations.Nullable android.os.Bundle r7) {
        /*
            r6 = this;
            dagger.android.AndroidInjection.inject(r6)
            super.onCreate(r7)
            r7 = 2131558467(0x7f0d0043, float:1.874225E38)
            r6.setContentView(r7)
            android.content.Intent r7 = r6.getIntent()
            r0 = 0
            java.lang.String r1 = "retain_filter"
            boolean r7 = r7.getBooleanExtra(r1, r0)
            r1 = 1
            java.lang.String r2 = "sessionManager"
            if (r7 != 0) goto L_0x0026
            kr.co.popone.fitts.base.SessionManager r7 = r6.sessionManager
            if (r7 != 0) goto L_0x0023
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
        L_0x0023:
            r7.setBodyFilterAll(r1)
        L_0x0026:
            kr.co.popone.fitts.base.SessionManager r7 = r6.sessionManager
            if (r7 != 0) goto L_0x002d
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
        L_0x002d:
            boolean r7 = r7.isLoggedIn()
            if (r7 != 0) goto L_0x0064
            android.content.Intent r7 = new android.content.Intent
            java.lang.Class<kr.co.popone.fitts.feature.intro.IntroActivity> r3 = kr.co.popone.fitts.feature.intro.IntroActivity.class
            r7.<init>(r6, r3)
            r3 = 65536(0x10000, float:9.18355E-41)
            r7.addFlags(r3)
            r3 = 2130771987(0x7f010013, float:1.714708E38)
            r4 = 2130771988(0x7f010014, float:1.7147082E38)
            androidx.core.app.ActivityOptionsCompat r3 = androidx.core.app.ActivityOptionsCompat.makeCustomAnimation(r6, r3, r4)
            java.lang.String r4 = "ActivityOptionsCompat.ma…fade_in, R.anim.fade_out)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r4)
            android.os.Bundle r3 = r3.toBundle()
            r6.startActivity(r7, r3)
            boolean r7 = r6.loginScheme
            if (r7 == 0) goto L_0x00d6
            android.content.Intent r7 = new android.content.Intent
            java.lang.Class<kr.co.popone.fitts.feature.intro.login.LoginActivity> r3 = kr.co.popone.fitts.feature.intro.login.LoginActivity.class
            r7.<init>(r6, r3)
            r6.startActivity(r7)
            goto L_0x00d6
        L_0x0064:
            kr.co.popone.fitts.base.SessionManager r7 = r6.sessionManager
            if (r7 != 0) goto L_0x006b
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
        L_0x006b:
            kr.co.popone.fitts.feature.main.MainActivity$onCreate$1 r3 = new kr.co.popone.fitts.feature.main.MainActivity$onCreate$1
            r3.<init>(r6)
            r7.loadUserInfo(r3)
            int r7 = kr.co.popone.fitts.C0010R$id.mainTabBar
            android.view.View r7 = r6._$_findCachedViewById(r7)
            kr.co.popone.fitts.feature.main.MainTabBar r7 = (kr.co.popone.fitts.feature.main.MainTabBar) r7
            kr.co.popone.fitts.feature.main.MainActivity$onCreate$2 r3 = new kr.co.popone.fitts.feature.main.MainActivity$onCreate$2
            r3.<init>(r6)
            r7.setListener(r3)
            int r7 = kr.co.popone.fitts.C0010R$id.cateRecyclerView
            android.view.View r7 = r6._$_findCachedViewById(r7)
            androidx.recyclerview.widget.RecyclerView r7 = (androidx.recyclerview.widget.RecyclerView) r7
            kr.co.popone.fitts.feature.category.CategoryAdapter r3 = r6.categoryAdapter
            r7.setAdapter(r3)
            androidx.recyclerview.widget.LinearLayoutManager r3 = new androidx.recyclerview.widget.LinearLayoutManager
            android.content.Context r4 = r7.getContext()
            r3.<init>(r4)
            r7.setLayoutManager(r3)
            int r3 = r7.getItemDecorationCount()
            if (r3 >= r1) goto L_0x00b6
            kr.co.popone.fitts.ui.decorator.DrawerMenuItemDecoration r3 = new kr.co.popone.fitts.ui.decorator.DrawerMenuItemDecoration
            android.content.Context r4 = r7.getContext()
            java.lang.String r5 = "context"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r4, r5)
            r5 = 2131230998(0x7f080116, float:1.8078065E38)
            r3.<init>(r4, r5)
            r7.addItemDecoration(r3)
        L_0x00b6:
            io.reactivex.disposables.CompositeDisposable r7 = r6.disposables
            kr.co.popone.fitts.repository.CategoryRepository r3 = r6.categoryRepository
            if (r3 != 0) goto L_0x00c1
            java.lang.String r4 = "categoryRepository"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
        L_0x00c1:
            io.reactivex.Single r3 = r3.getCategoryList()
            kr.co.popone.fitts.feature.main.MainActivity$onCreate$4 r4 = new kr.co.popone.fitts.feature.main.MainActivity$onCreate$4
            r4.<init>(r6)
            io.reactivex.disposables.Disposable r3 = r3.subscribe(r4)
            java.lang.String r4 = "categoryRepository.getCa…  }\n                    }"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r4)
            io.reactivex.rxkotlin.DisposableKt.plusAssign(r7, r3)
        L_0x00d6:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r3 = "MainActivity onCreate "
            r7.append(r3)
            android.content.Intent r3 = r6.getIntent()
            java.lang.String r4 = "intent"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r4)
            android.os.Bundle r3 = r3.getExtras()
            r7.append(r3)
            java.lang.String r7 = r7.toString()
            java.lang.Object[] r0 = new java.lang.Object[r0]
            com.orhanobut.logger.Logger.d(r7, r0)
            kr.co.popone.fitts.feature.appreview.AppReview r7 = kr.co.popone.fitts.feature.appreview.AppReview.INSTANCE
            r7.addAppLaunchCount()
            java.util.Calendar r7 = java.util.Calendar.getInstance()
            java.lang.String r0 = "cal"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r7, r0)
            java.util.Date r0 = new java.util.Date
            r0.<init>()
            r7.setTime(r0)
            java.lang.String r7 = kr.co.popone.fitts.ui.CalendarExtensionsKt.dateString(r7)
            android.content.SharedPreferences r0 = android.preference.PreferenceManager.getDefaultSharedPreferences(r6)
            java.lang.String r3 = "PreferenceManager.getDef…ltSharedPreferences(this)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r3)
            java.lang.String r3 = "no_show_event"
            java.lang.String r4 = ""
            java.lang.String r0 = r0.getString(r3, r4)
            android.content.Intent r3 = r6.getIntent()
            java.lang.String r4 = "show_promotion_dialog"
            boolean r3 = r3.getBooleanExtra(r4, r1)
            java.lang.String r4 = "fittsServiceRepository"
            if (r3 == 0) goto L_0x0166
            kr.co.popone.fitts.base.SessionManager r3 = r6.sessionManager
            if (r3 != 0) goto L_0x0139
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
        L_0x0139:
            boolean r2 = r3.isLoggedIn()
            if (r2 == 0) goto L_0x0166
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual(r7, r0)
            r7 = r7 ^ r1
            if (r7 == 0) goto L_0x0166
            kr.co.popone.fitts.model.repository.service.FittsServiceRepository r7 = r6.fittsServiceRepository
            if (r7 != 0) goto L_0x014d
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
        L_0x014d:
            r0 = 2
            r1 = 0
            java.lang.String r2 = "home"
            io.reactivex.Single r7 = kr.co.popone.fitts.model.repository.service.FittsServiceRepository.DefaultImpls.getPromotions$default(r7, r2, r1, r0, r1)
            kr.co.popone.fitts.feature.main.MainActivity$onCreate$5 r0 = new kr.co.popone.fitts.feature.main.MainActivity$onCreate$5
            r0.<init>(r6)
            kr.co.popone.fitts.feature.main.MainActivity$onCreate$6 r1 = new kr.co.popone.fitts.feature.main.MainActivity$onCreate$6
            r1.<init>(r6)
            io.reactivex.disposables.Disposable r7 = r7.subscribe(r0, r1)
            r6.promotionRequest = r7
            goto L_0x0169
        L_0x0166:
            r6.showPostDialogOnInit()
        L_0x0169:
            io.reactivex.disposables.CompositeDisposable r7 = r6.disposables
            kr.co.popone.fitts.event.RxBus r0 = kr.co.popone.fitts.event.RxBus.INSTANCE
            io.reactivex.Observable r0 = r0.toObservable()
            io.reactivex.Scheduler r1 = io.reactivex.android.schedulers.AndroidSchedulers.mainThread()
            io.reactivex.Observable r0 = r0.observeOn(r1)
            kr.co.popone.fitts.feature.main.MainActivity$onCreate$7 r1 = new kr.co.popone.fitts.feature.main.MainActivity$onCreate$7
            r1.<init>(r6)
            io.reactivex.disposables.Disposable r0 = r0.subscribe(r1)
            java.lang.String r1 = "RxBus.toObservable()\n   …      }\n                }"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            io.reactivex.rxkotlin.DisposableKt.plusAssign(r7, r0)
            io.reactivex.disposables.CompositeDisposable r7 = r6.disposables
            kr.co.popone.fitts.model.repository.service.FittsServiceRepository r0 = r6.fittsServiceRepository
            if (r0 != 0) goto L_0x0193
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
        L_0x0193:
            kr.co.popone.fitts.model.datamodel.service.banner.BannerType r1 = kr.co.popone.fitts.model.datamodel.service.banner.BannerType.MENU
            java.lang.String r1 = r1.getType()
            io.reactivex.Single r0 = r0.getBanners(r1)
            kr.co.popone.fitts.feature.main.MainActivity$onCreate$8 r1 = new kr.co.popone.fitts.feature.main.MainActivity$onCreate$8
            r1.<init>(r6)
            io.reactivex.disposables.Disposable r0 = r0.subscribe(r1)
            java.lang.String r1 = "fittsServiceRepository.g…      }\n                }"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            io.reactivex.rxkotlin.DisposableKt.plusAssign(r7, r0)
            int r7 = kr.co.popone.fitts.C0010R$id.buttonRecommendContents
            android.view.View r7 = r6._$_findCachedViewById(r7)
            androidx.constraintlayout.widget.ConstraintLayout r7 = (androidx.constraintlayout.widget.ConstraintLayout) r7
            kr.co.popone.fitts.feature.main.MainActivity$onCreate$9 r0 = new kr.co.popone.fitts.feature.main.MainActivity$onCreate$9
            r0.<init>(r6)
            r7.setOnClickListener(r0)
            int r7 = kr.co.popone.fitts.C0010R$id.buttonEvent
            android.view.View r7 = r6._$_findCachedViewById(r7)
            androidx.constraintlayout.widget.ConstraintLayout r7 = (androidx.constraintlayout.widget.ConstraintLayout) r7
            kr.co.popone.fitts.feature.main.MainActivity$onCreate$10 r0 = new kr.co.popone.fitts.feature.main.MainActivity$onCreate$10
            r0.<init>(r6)
            r7.setOnClickListener(r0)
            r6.getAlarmCount()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.feature.main.MainActivity.onCreate(android.os.Bundle):void");
    }

    private final void getAlarmCount() {
        UserAPI userAPI = this.userApi;
        if (userAPI == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userApi");
        }
        this.alarmCountRequest = userAPI.getAlarmCount().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new MainActivity$getAlarmCount$1<Object,Object>(this));
    }

    /* access modifiers changed from: private */
    public final void showPostDialogOnInit() {
        CompositeDisposable compositeDisposable = this.disposables;
        FittsServiceRepository fittsServiceRepository2 = this.fittsServiceRepository;
        if (fittsServiceRepository2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fittsServiceRepository");
        }
        Disposable subscribe = fittsServiceRepository2.getAppInformation().subscribeOn(Schedulers.io()).retry(2).observeOn(AndroidSchedulers.mainThread()).subscribe(new MainActivity$showPostDialogOnInit$1(this), MainActivity$showPostDialogOnInit$2.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "fittsServiceRepository.g… }, {\n\n                })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    /* access modifiers changed from: private */
    public final void showStoreMarketingToolTip(ToolTip toolTip) {
        if (toolTip == null || toolTip.getLocation() != Location.STORE_TAB) {
            LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(C0010R$id.viewStoreToolTip);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout, "viewStoreToolTip");
            ViewExtensionsKt.gone(linearLayout);
            return;
        }
        TextView textView = (TextView) _$_findCachedViewById(C0010R$id.tvStoreToolTipFirst);
        Intrinsics.checkExpressionValueIsNotNull(textView, "tvStoreToolTipFirst");
        textView.setText(toolTip.getMessageFirst());
        TextView textView2 = (TextView) _$_findCachedViewById(C0010R$id.tvStoreToolTipSecond);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "tvStoreToolTipSecond");
        textView2.setText(toolTip.getMessageSecond());
        setShopTooltip(ShopTooltipState.SHOW);
        this.shopTooltipDissmissDisposable = Single.timer(4000, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new MainActivity$showStoreMarketingToolTip$1<Object,Object>(this));
    }

    /* access modifiers changed from: private */
    public final void handlePromotion(Promotion promotion) {
        Type type = promotion.getType();
        if (type != null) {
            int i = WhenMappings.$EnumSwitchMapping$2[type.ordinal()];
            if (i == 1) {
                showPromotionDialog(promotion, new MainActivity$handlePromotion$1(this));
            } else if (i == 2) {
                String webUrl = promotion.getWebUrl();
                if (webUrl != null) {
                    Intent intent = new Intent(this, OpenWebActivity.class);
                    Parameters parameters = new Parameters(webUrl, false, false, null, true);
                    intent.putExtra("parameters", parameters);
                    ActivityExtensionKt.activityStartForResult(this, intent, ActivityAnimationType.SLIDE_UP, this.REQUEST_PROMOTION_POPUP);
                }
            }
        }
    }

    private final void showPromotionDialog(Promotion promotion, Function0<Unit> function0) {
        Dialog buildDialog = DialogExtensions.INSTANCE.buildDialog(this, C0013R$layout.dialog_event);
        ImageView imageView = (ImageView) buildDialog.findViewById(C0010R$id.imageView);
        Glide.with((FragmentActivity) this).load(promotion.getImageUrl()).into(imageView);
        imageView.setOnClickListener(new MainActivity$showPromotionDialog$1(this, promotion, buildDialog));
        ((TextView) buildDialog.findViewById(C0010R$id.noShowTodayTextView)).setOnClickListener(new MainActivity$showPromotionDialog$2(this, function0, buildDialog));
        ((Button) buildDialog.findViewById(C0010R$id.closeButton)).setOnClickListener(new MainActivity$showPromotionDialog$3(this, function0, buildDialog));
        buildDialog.show();
    }

    /* access modifiers changed from: private */
    public final void onStoreTabClicked() {
        ActionLog actionLog = new ActionLog(null, "StoreHomeFeed", null, null, null, null, 32, null);
        FittsServiceRepository fittsServiceRepository2 = this.fittsServiceRepository;
        if (fittsServiceRepository2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fittsServiceRepository");
        }
        DisposableKt.addTo(SubscribersKt.subscribeBy(fittsServiceRepository2.postFittsActionLog(actionLog), (Function1<? super Throwable, Unit>) MainActivity$onStoreTabClicked$1$1.INSTANCE, (Function0<Unit>) MainActivity$onStoreTabClicked$1$2.INSTANCE), this.disposables);
        EventTracker eventTracker2 = this.eventTracker;
        String str = "eventTracker";
        if (eventTracker2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        String str2 = "store";
        String str3 = "tab";
        eventTracker2.logCustom("Tap To Main Tab", new CustomAttributes().put(str3, str2));
        EventTracker eventTracker3 = this.eventTracker;
        if (eventTracker3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        eventTracker3.logCustom("Tap To Main Tab Except Home", new CustomAttributes().put(str3, str2));
    }

    /* access modifiers changed from: private */
    public final void updateDrawerBanner(List<Banner> list) {
        Banner banner = (Banner) CollectionsKt___CollectionsKt.firstOrNull(list);
        if (banner != null) {
            Glide.with((FragmentActivity) this).load(banner.getImage().getUrl()).into((ImageView) _$_findCachedViewById(C0010R$id.imageDrawerBanner));
            ((ImageView) _$_findCachedViewById(C0010R$id.imageDrawerBanner)).setOnClickListener(new MainActivity$updateDrawerBanner$$inlined$let$lambda$1(banner, this));
        }
    }

    public void onMenuClicked() {
        ((DrawerLayout) _$_findCachedViewById(C0010R$id.drawerMenu)).openDrawer(_$_findCachedViewById(C0010R$id.menuContainer));
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        SessionManager sessionManager2 = this.sessionManager;
        if (sessionManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
        }
        sessionManager2.isLoggedIn();
        checkBannerBadges();
        getBadgeCount();
    }

    /* access modifiers changed from: private */
    public final void initMainUi() {
        EventBus.getDefault().register(this);
        SwipeViewPager swipeViewPager = (SwipeViewPager) _$_findCachedViewById(C0010R$id.viewpager_main);
        String str = "viewpager_main";
        Intrinsics.checkExpressionValueIsNotNull(swipeViewPager, str);
        swipeViewPager.setAdapter(getMainTabAdapter());
        ((SwipeViewPager) _$_findCachedViewById(C0010R$id.viewpager_main)).setPagingEnabled(false);
        SwipeViewPager swipeViewPager2 = (SwipeViewPager) _$_findCachedViewById(C0010R$id.viewpager_main);
        Intrinsics.checkExpressionValueIsNotNull(swipeViewPager2, str);
        swipeViewPager2.setOffscreenPageLimit(3);
        Intent intent = getIntent();
        Intrinsics.checkExpressionValueIsNotNull(intent, "intent");
        processNotificationData(intent);
        if (getIntent().getBooleanExtra(PARAMETER_NEW_USER, false)) {
            FittsServiceRepository fittsServiceRepository2 = this.fittsServiceRepository;
            if (fittsServiceRepository2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fittsServiceRepository");
            }
            this.promotionRequest = DefaultImpls.getPromotions$default(fittsServiceRepository2, "join", null, 2, null).subscribe(new MainActivity$initMainUi$$inlined$let$lambda$1(this), MainActivity$initMainUi$1$2.INSTANCE);
        }
    }

    private final void getBadgeCount() {
        CompositeDisposable compositeDisposable = this.disposables;
        UserAPI userAPI = this.userApi;
        if (userAPI == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userApi");
        }
        Disposable subscribe = userAPI.getBadgeCount().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new MainActivity$getBadgeCount$1<Object,Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "userApi.getBadgeCount()\n…      }\n                }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    private final void checkBannerBadges() {
        StringBuilder sb = new StringBuilder();
        sb.append("MainActivity::recommendation timestamp = ");
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String str = "PreferenceManager.getDef…ltSharedPreferences(this)";
        Intrinsics.checkExpressionValueIsNotNull(defaultSharedPreferences, str);
        String str2 = PREF_RECOMMENDATION_BANNER_BADGE_TIMESTAMP;
        sb.append(defaultSharedPreferences.getInt(str2, 0));
        Logger.d(sb.toString(), new Object[0]);
        CompositeDisposable compositeDisposable = this.disposables;
        FittsServiceRepository fittsServiceRepository2 = this.fittsServiceRepository;
        String str3 = "fittsServiceRepository";
        if (fittsServiceRepository2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str3);
        }
        SharedPreferences defaultSharedPreferences2 = PreferenceManager.getDefaultSharedPreferences(this);
        Intrinsics.checkExpressionValueIsNotNull(defaultSharedPreferences2, str);
        Disposable subscribe = fittsServiceRepository2.getBannerBadgeCount("recommendation_content", defaultSharedPreferences2.getInt(str2, 0)).subscribe((BiConsumer<? super T, ? super Throwable>) new MainActivity$checkBannerBadges$1<Object,Object>(this));
        String str4 = "fittsServiceRepository.g…      }\n                }";
        Intrinsics.checkExpressionValueIsNotNull(subscribe, str4);
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("MainActivity::event timestamp = ");
        SharedPreferences defaultSharedPreferences3 = PreferenceManager.getDefaultSharedPreferences(this);
        Intrinsics.checkExpressionValueIsNotNull(defaultSharedPreferences3, str);
        String str5 = PREF_EVENT_BANNER_BADGE_TIMESTAMP;
        sb2.append(defaultSharedPreferences3.getInt(str5, 0));
        Logger.d(sb2.toString(), new Object[0]);
        CompositeDisposable compositeDisposable2 = this.disposables;
        FittsServiceRepository fittsServiceRepository3 = this.fittsServiceRepository;
        if (fittsServiceRepository3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str3);
        }
        SharedPreferences defaultSharedPreferences4 = PreferenceManager.getDefaultSharedPreferences(this);
        Intrinsics.checkExpressionValueIsNotNull(defaultSharedPreferences4, str);
        Disposable subscribe2 = fittsServiceRepository3.getBannerBadgeCount(NotificationCompat.CATEGORY_EVENT, defaultSharedPreferences4.getInt(str5, 0)).subscribe((BiConsumer<? super T, ? super Throwable>) new MainActivity$checkBannerBadges$2<Object,Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe2, str4);
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
    }

    private final void moveStoreSpecificTab(Intent intent) {
        ((DrawerLayout) _$_findCachedViewById(C0010R$id.drawerMenu)).closeDrawer(3);
        String stringExtra = intent.getStringExtra(PARAMETER_MOVE_TAB_STORE);
        if (stringExtra != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("MainActivity::onNewIntent, tabName = ");
            sb.append(stringExtra);
            Logger.d(sb.toString(), new Object[0]);
            Fragment item = getMainTabAdapter().getItem(1);
            if (item instanceof StoreFragment) {
                ((StoreFragment) item).switchStoreFragment(stringExtra);
            }
            SwipeViewPager swipeViewPager = (SwipeViewPager) _$_findCachedViewById(C0010R$id.viewpager_main);
            Intrinsics.checkExpressionValueIsNotNull(swipeViewPager, "viewpager_main");
            swipeViewPager.setCurrentItem(1);
            ((MainTabBar) _$_findCachedViewById(C0010R$id.mainTabBar)).setSelectedTab(Tab.Store);
        }
    }

    private final void showReviewDialog(Intent intent) {
        if (intent.getBooleanExtra(PARAMETER_SHOW_REVIEW_DIALOG, false)) {
            this.reviewTimerRequest = Observable.timer(2, TimeUnit.SECONDS, Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Consumer<? super T>) new MainActivity$showReviewDialog$$inlined$let$lambda$1<Object>(this));
        }
    }

    private final void updateRetainFilter(Intent intent) {
        if (!intent.getBooleanExtra(PARAMETER_RETAIN_FILTER, false)) {
            SessionManager sessionManager2 = this.sessionManager;
            if (sessionManager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
            }
            sessionManager2.setBodyFilterAll(true);
        }
    }

    private final void moveMainTab(Intent intent) {
        int intExtra = intent.getIntExtra(PARAMETER_GOTO_TAB, -1);
        if (intExtra >= 0 && 3 >= intExtra) {
            updateTabSelectedWithDelay(intExtra);
        }
    }

    private final void moveShowRoomActivity(Intent intent) {
        if (intent.getBooleanExtra(PARAMETER_GOTO_MY_SHOWROOM, false)) {
            Intent intent2 = new Intent(this, ShowRoomActivity.class);
            SessionManager sessionManager2 = this.sessionManager;
            if (sessionManager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
            }
            intent2.putExtra("showroom_user_id", sessionManager2.getUserID());
            ContextExtensionKt.activityStart(this, intent2, ActivityAnimationType.SLIDE_RTOL);
        }
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(@Nullable Intent intent) {
        super.onNewIntent(intent);
        StringBuilder sb = new StringBuilder();
        sb.append("MainActivity::onNewIntent, isNullIntent = ");
        sb.append(intent == null);
        Logger.d(sb.toString(), new Object[0]);
        if (intent != null) {
            processNotificationData(intent);
            moveStoreSpecificTab(intent);
            moveShowRoomActivity(intent);
            showReviewDialog(intent);
            updateRetainFilter(intent);
            moveMainTab(intent);
        }
    }

    public void onBackPressed() {
        if (((DrawerLayout) _$_findCachedViewById(C0010R$id.drawerMenu)).isDrawerOpen((int) GravityCompat.START)) {
            ((DrawerLayout) _$_findCachedViewById(C0010R$id.drawerMenu)).closeDrawer(3);
            return;
        }
        SwipeViewPager swipeViewPager = (SwipeViewPager) _$_findCachedViewById(C0010R$id.viewpager_main);
        Intrinsics.checkExpressionValueIsNotNull(swipeViewPager, "viewpager_main");
        int currentItem = swipeViewPager.getCurrentItem();
        if (currentItem == 0) {
            long currentTimeMillis = System.currentTimeMillis();
            long j = this.backPressedTime;
            if (currentTimeMillis > j + 2000) {
                this.backPressedTime = currentTimeMillis;
            } else if (currentTimeMillis <= j + 2000) {
                finish();
            }
        } else if (currentItem != 1) {
            moveTabHome();
        } else {
            Fragment item = getMainTabAdapter().getItem(1);
            if (!(item instanceof StoreFragment)) {
                item = null;
            }
            StoreFragment storeFragment = (StoreFragment) item;
            if (storeFragment != null) {
                storeFragment.onBackkeyPressed(new MainActivity$onBackPressed$$inlined$let$lambda$1(this));
            }
        }
    }

    /* access modifiers changed from: private */
    public final void moveTabHome() {
        this.backPressedTime = 0;
        ((MainTabBar) _$_findCachedViewById(C0010R$id.mainTabBar)).setSelectedTab(Tab.Home);
    }

    /* access modifiers changed from: private */
    public final void updateTabSelected(int i) {
        SwipeViewPager swipeViewPager = (SwipeViewPager) _$_findCachedViewById(C0010R$id.viewpager_main);
        Intrinsics.checkExpressionValueIsNotNull(swipeViewPager, "viewpager_main");
        swipeViewPager.setCurrentItem(i);
    }

    private final void updateTabSelectedWithDelay(int i) {
        CompositeDisposable compositeDisposable = this.disposables;
        Disposable subscribe = Observable.timer(200, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Consumer<? super T>) new MainActivity$updateTabSelectedWithDelay$1<Object>(this, i));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "Observable.timer(200, Ti…      }\n                }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final void showMessage(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        Snackbar.Companion.showMessage(this, str);
    }

    private final void processNotificationData(Intent intent) {
        StringBuilder sb = new StringBuilder();
        sb.append("intent.data ");
        sb.append(intent.getData());
        Logger.d(sb.toString(), new Object[0]);
        String str = "schemeHandler";
        String str2 = null;
        if (Intrinsics.areEqual((Object) "android.intent.action.VIEW", (Object) intent.getAction())) {
            Uri data = intent.getData();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("processNotificationData::host = ");
            sb2.append(data != null ? data.getHost() : null);
            Logger.d(sb2.toString(), new Object[0]);
            if (Intrinsics.areEqual(data != null ? data.getHost() : null, (Object) "login")) {
                Logger.d("start LoginActivity", new Object[0]);
                this.loginScheme = true;
                return;
            }
            if (data != null) {
                str2 = data.getHost();
            }
            if (!Intrinsics.areEqual((Object) str2, (Object) KakaoTalkLinkProtocol.LINK_SCHEME) || data.getQuery() == null) {
                FittsSchemeHandler fittsSchemeHandler = this.schemeHandler;
                if (fittsSchemeHandler == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(str);
                }
                String uri = data.toString();
                Intrinsics.checkExpressionValueIsNotNull(uri, "uri.toString()");
                fittsSchemeHandler.handleScheme(this, uri);
                return;
            }
            FittsSchemeHandler fittsSchemeHandler2 = this.schemeHandler;
            if (fittsSchemeHandler2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(str);
            }
            String uri2 = Uri.parse(data.getQuery()).toString();
            Intrinsics.checkExpressionValueIsNotNull(uri2, "Uri.parse(uri.query).toString()");
            fittsSchemeHandler2.handleScheme(this, uri2);
        } else if (intent.getExtras() != null) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("else intent.extras ");
            sb3.append(intent.getExtras());
            Logger.d(sb3.toString(), new Object[0]);
            Bundle extras = intent.getExtras();
            String string = extras != null ? extras.getString("url") : null;
            Bundle extras2 = intent.getExtras();
            String string2 = extras2 != null ? extras2.getString("badge") : null;
            Bundle extras3 = intent.getExtras();
            if (extras3 != null) {
                str2 = extras3.getString("callback_id");
            }
            StringBuilder sb4 = new StringBuilder();
            sb4.append("callbackId  ");
            sb4.append(str2);
            Logger.d(sb4.toString(), new Object[0]);
            if (str2 != null) {
                try {
                    CompositeDisposable compositeDisposable = this.disposables;
                    FittsServiceRepository fittsServiceRepository2 = this.fittsServiceRepository;
                    if (fittsServiceRepository2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("fittsServiceRepository");
                    }
                    Disposable subscribe = fittsServiceRepository2.updateNotificationFeedback(Long.parseLong(str2)).subscribe(MainActivity$processNotificationData$1.INSTANCE, MainActivity$processNotificationData$2.INSTANCE);
                    Intrinsics.checkExpressionValueIsNotNull(subscribe, "fittsServiceRepository.u…       .subscribe({}, {})");
                    DisposableKt.plusAssign(compositeDisposable, subscribe);
                } catch (NumberFormatException e) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("callbackId exception ");
                    sb5.append(e);
                    Logger.d(sb5.toString(), new Object[0]);
                }
            }
            if (string != null && string2 != null) {
                StringBuilder sb6 = new StringBuilder();
                sb6.append("processNotificationData urlString(");
                sb6.append(string);
                sb6.append(")   badgeString(");
                sb6.append(string2);
                sb6.append(')');
                Logger.d(sb6.toString(), new Object[0]);
                try {
                    ActionLogUtil actionLogUtil2 = this.actionLogUtil;
                    if (actionLogUtil2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("actionLogUtil");
                    }
                    ActionLogUtil.defineCurrentWindow$default(actionLogUtil2, "Push", "", 0, 4, null);
                    FittsNotificationHandler fittsNotificationHandler2 = this.fittsNotificationHandler;
                    if (fittsNotificationHandler2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("fittsNotificationHandler");
                    }
                    fittsNotificationHandler2.handleNotification(string, Integer.parseInt(string2));
                    FittsSchemeHandler fittsSchemeHandler3 = this.schemeHandler;
                    if (fittsSchemeHandler3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(str);
                    }
                    if (fittsSchemeHandler3.handleScheme(this, string)) {
                        Uri parse = Uri.parse(string);
                        Intrinsics.checkExpressionValueIsNotNull(parse, "uri");
                        if (Intrinsics.areEqual((Object) parse.getHost(), (Object) "post")) {
                            EventTracker eventTracker2 = this.eventTracker;
                            if (eventTracker2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("eventTracker");
                            }
                            eventTracker2.logCustom("View Post", new CustomAttributes().put("from", "push"));
                        }
                    }
                } catch (NumberFormatException e2) {
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append("processNotificationData exception(");
                    sb7.append(e2);
                    sb7.append(')');
                    Logger.d(sb7.toString(), new Object[0]);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final void scrollCurrentTop(Fragment fragment) {
        if (fragment instanceof Scrollable) {
            ((Scrollable) fragment).scrollTop();
        }
    }

    public void onCategoryClicked(@NotNull List<CategoryViewData> list, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(list, "categories");
        if (((MainTabBar) _$_findCachedViewById(C0010R$id.mainTabBar)).getSelectedTab() == Tab.Store) {
            CategorySearchActivity.Companion.start(this, list, i, i2, "product");
            return;
        }
        CategorySearchActivity.Companion.start(this, list, i, i2, "post");
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        if (i == 101) {
            if (i2 == -1 && intent != null && ((PaymentInvoiceResult) intent.getParcelableExtra("result")).getCompletedInvoice()) {
                AppReview.INSTANCE.showFirstReviewDialog(this);
            }
        } else if (i == this.REQUEST_FITTIE_RECOMMEND) {
            if (i2 == -1) {
                initMainUi();
            } else {
                finish();
            }
        } else if (i == this.REQUEST_PROMOTION_POPUP) {
            showPostDialogOnInit();
        } else {
            super.onActivityResult(i, i2, intent);
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        EventTracker eventTracker2 = this.eventTracker;
        if (eventTracker2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eventTracker");
        }
        eventTracker2.customLogScrollDistanceHomeAndStore();
        Disposable disposable = this.promotionRequest;
        if (disposable != null) {
            disposable.dispose();
        }
        Disposable disposable2 = this.alarmCountRequest;
        if (disposable2 != null) {
            disposable2.dispose();
        }
        Disposable disposable3 = this.reviewTimerRequest;
        if (disposable3 != null) {
            disposable3.dispose();
        }
        Disposable disposable4 = this.badgeTimestampRequest;
        if (disposable4 != null) {
            disposable4.dispose();
        }
        Disposable disposable5 = this.recommendationBadgeRequest;
        if (disposable5 != null) {
            disposable5.dispose();
        }
        Disposable disposable6 = this.shopTooltipDissmissDisposable;
        if (disposable6 != null) {
            disposable6.dispose();
        }
        EventBus.getDefault().unregister(this);
        CreatePostActivityUtil createPostActivityUtil2 = this.createPostActivityUtil;
        if (createPostActivityUtil2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("createPostActivityUtil");
        }
        createPostActivityUtil2.clear();
        this.disposables.dispose();
        super.onDestroy();
    }
}
