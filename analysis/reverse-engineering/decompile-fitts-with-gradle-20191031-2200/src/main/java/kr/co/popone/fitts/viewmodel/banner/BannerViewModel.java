package kr.co.popone.fitts.viewmodel.banner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.BiConsumer;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.base.BaseViewModel;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.model.datamodel.service.banner.Banner;
import kr.co.popone.fitts.model.datamodel.service.banner.BannerType;
import kr.co.popone.fitts.model.log.ActionLogAPI;
import kr.co.popone.fitts.model.log.ActionLogAPI.DefaultImpls;
import kr.co.popone.fitts.model.repository.service.FittsServiceRepository;
import kr.co.popone.fitts.services.FittsSchemeHandler;
import org.jetbrains.annotations.NotNull;

public final class BannerViewModel extends BaseViewModel {
    private final ActionLogAPI actionLogAPI;
    @NotNull
    private final MutableLiveData<List<Banner>> bannerListLiveData = new MutableLiveData<>();
    private final FittsServiceRepository fittsServiceRepository;
    @NotNull
    public Function0<? extends BannerType> getBannerType;
    @NotNull
    private final MutableLiveData<NetworkState> networkState = new MutableLiveData<>();
    private final FittsSchemeHandler schemeHandler;
    @NotNull
    private final MutableLiveData<String> titleLiveData = new MutableLiveData<>();

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = new int[BannerType.values().length];
        public static final /* synthetic */ int[] $EnumSwitchMapping$1 = new int[BannerType.values().length];

        static {
            $EnumSwitchMapping$0[BannerType.EVENT.ordinal()] = 1;
            $EnumSwitchMapping$0[BannerType.RECOMMEND.ordinal()] = 2;
            $EnumSwitchMapping$1[BannerType.EVENT.ordinal()] = 1;
            $EnumSwitchMapping$1[BannerType.RECOMMEND.ordinal()] = 2;
        }
    }

    public BannerViewModel(@NotNull FittsServiceRepository fittsServiceRepository2, @NotNull FittsSchemeHandler fittsSchemeHandler, @NotNull ActionLogAPI actionLogAPI2) {
        Intrinsics.checkParameterIsNotNull(fittsServiceRepository2, "fittsServiceRepository");
        Intrinsics.checkParameterIsNotNull(fittsSchemeHandler, "schemeHandler");
        Intrinsics.checkParameterIsNotNull(actionLogAPI2, "actionLogAPI");
        this.fittsServiceRepository = fittsServiceRepository2;
        this.schemeHandler = fittsSchemeHandler;
        this.actionLogAPI = actionLogAPI2;
    }

    @NotNull
    public final Function0<BannerType> getGetBannerType() {
        Function0<? extends BannerType> function0 = this.getBannerType;
        if (function0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("getBannerType");
        }
        return function0;
    }

    public final void setGetBannerType(@NotNull Function0<? extends BannerType> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "<set-?>");
        this.getBannerType = function0;
    }

    @NotNull
    public final MutableLiveData<List<Banner>> getBannerListLiveData() {
        return this.bannerListLiveData;
    }

    @NotNull
    public final MutableLiveData<String> getTitleLiveData() {
        return this.titleLiveData;
    }

    @NotNull
    public final MutableLiveData<NetworkState> getNetworkState() {
        return this.networkState;
    }

    public final void initBannerType(@NotNull Function0<? extends BannerType> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "body");
        this.getBannerType = function0;
        getBannerList();
        updateTitle();
    }

    public final void getBannerList() {
        this.networkState.setValue(NetworkState.Companion.getLOADING());
        Function0<? extends BannerType> function0 = this.getBannerType;
        if (function0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("getBannerType");
        }
        this.fittsServiceRepository.getBanners(((BannerType) function0.invoke()).getType()).subscribe((BiConsumer<? super T, ? super Throwable>) new BannerViewModel$getBannerList$$inlined$let$lambda$1<Object,Object>(this));
    }

    public final void handleBannerScheme(@NotNull AppCompatActivity appCompatActivity, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(appCompatActivity, "activity");
        Intrinsics.checkParameterIsNotNull(str, "scheme");
        this.schemeHandler.handleScheme(appCompatActivity, str);
        String actionLogType = getActionLogType();
        if (actionLogType != null) {
            DefaultImpls.collectActionLog$default(this.actionLogAPI, "collection", actionLogType, null, null, null, 28, null).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new BannerViewModel$handleBannerScheme$1$1(actionLogType), BannerViewModel$handleBannerScheme$1$2.INSTANCE);
        }
    }

    private final String getActionLogType() {
        Function0<? extends BannerType> function0 = this.getBannerType;
        if (function0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("getBannerType");
        }
        int i = WhenMappings.$EnumSwitchMapping$0[((BannerType) function0.invoke()).ordinal()];
        if (i == 1) {
            return "Event";
        }
        if (i != 2) {
            return null;
        }
        return "RecommendationContent";
    }

    private final void updateTitle() {
        Function0<? extends BannerType> function0 = this.getBannerType;
        if (function0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("getBannerType");
        }
        int i = WhenMappings.$EnumSwitchMapping$1[((BannerType) function0.invoke()).ordinal()];
        if (i == 1) {
            this.titleLiveData.setValue("이벤트");
        } else if (i != 2) {
            this.titleLiveData.setValue("");
        } else {
            this.titleLiveData.setValue("추천 콘텐츠");
        }
    }
}
