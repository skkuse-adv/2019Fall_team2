package kr.co.popone.fitts.feature.me;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import dagger.android.support.AndroidSupportInjection;
import de.hdodenhof.circleimageview.CircleImageView;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.rxkotlin.DisposableKt;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0008R$drawable;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.feature.showroom.ShowRoomActivity;
import kr.co.popone.fitts.model.coupon.CouponAPI;
import kr.co.popone.fitts.model.datamodel.service.banner.Banner;
import kr.co.popone.fitts.model.datamodel.service.user.MyInfo;
import kr.co.popone.fitts.model.repository.service.FittsServiceRepository;
import kr.co.popone.fitts.model.user.UserAPI;
import kr.co.popone.fitts.services.FittsSchemeHandler;
import kr.co.popone.fitts.ui.ImageViewExtensionKt;
import kr.co.popone.fitts.ui.ViewExtensionsKt;
import kr.co.popone.fitts.utils.IntExtensionsKt;
import kr.co.popone.fitts.utils.Snackbar;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.simple.eventbus.EventBus;
import org.simple.eventbus.Subscriber;
import org.simple.eventbus.ThreadMode;

public final class MeFragment extends Fragment {
    public static final Companion Companion = new Companion(null);
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public Disposable availableCouponCountRequest;
    @NotNull
    public CouponAPI couponAPI;
    private final CompositeDisposable disposables = new CompositeDisposable();
    @NotNull
    public EventTracker eventTracker;
    @NotNull
    public FittsServiceRepository fittsServiceRepository;
    @NotNull
    public FittsSchemeHandler schemeHandler;
    @NotNull
    public SessionManager sessionManager;
    @NotNull
    public UserAPI userAPI;
    /* access modifiers changed from: private */
    public MyInfo userInfo;
    /* access modifiers changed from: private */
    public Disposable userInfoRequest;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
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
        if (view == null) {
            View view2 = getView();
            if (view2 == null) {
                return null;
            }
            view = view2.findViewById(i);
            this._$_findViewCache.put(Integer.valueOf(i), view);
        }
        return view;
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
    public final CouponAPI getCouponAPI$app_productionFittsRelease() {
        CouponAPI couponAPI2 = this.couponAPI;
        if (couponAPI2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("couponAPI");
        }
        return couponAPI2;
    }

    public final void setCouponAPI$app_productionFittsRelease(@NotNull CouponAPI couponAPI2) {
        Intrinsics.checkParameterIsNotNull(couponAPI2, "<set-?>");
        this.couponAPI = couponAPI2;
    }

    @NotNull
    public final FittsServiceRepository getFittsServiceRepository() {
        FittsServiceRepository fittsServiceRepository2 = this.fittsServiceRepository;
        if (fittsServiceRepository2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fittsServiceRepository");
        }
        return fittsServiceRepository2;
    }

    public final void setFittsServiceRepository(@NotNull FittsServiceRepository fittsServiceRepository2) {
        Intrinsics.checkParameterIsNotNull(fittsServiceRepository2, "<set-?>");
        this.fittsServiceRepository = fittsServiceRepository2;
    }

    public void onAttach(@Nullable Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        return layoutInflater.inflate(C0013R$layout.fragment_me, viewGroup, false);
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        super.onViewCreated(view, bundle);
        EventBus.getDefault().register(this);
        initClickListener();
    }

    @SuppressLint({"SetTextI18n"})
    public final void initData() {
        if (getActivity() != null && this.userInfoRequest == null) {
            UserAPI userAPI2 = this.userAPI;
            if (userAPI2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("userAPI");
            }
            this.userInfoRequest = userAPI2.getUserInfo().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new MeFragment$initData$1<Object,Object>(this));
            requestMyBanner();
        }
    }

    public void onResume() {
        super.onResume();
        loadAvailableCouponCount();
        getBadgeCount();
        initData();
    }

    private final void requestMyBanner() {
        CompositeDisposable compositeDisposable = this.disposables;
        FittsServiceRepository fittsServiceRepository2 = this.fittsServiceRepository;
        if (fittsServiceRepository2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fittsServiceRepository");
        }
        Disposable subscribe = fittsServiceRepository2.getBanners("my").subscribe(new MeFragment$requestMyBanner$1(this), new MeFragment$requestMyBanner$2(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "fittsServiceRepository.g…gone()\n                })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    /* access modifiers changed from: private */
    public final void updateMeBannerUi(Banner banner) {
        ImageView imageView = (ImageView) _$_findCachedViewById(C0010R$id.imageBanner);
        if (banner != null) {
            ImageViewExtensionKt.loadImageWithRatio(imageView, banner.getImage().getUrl(), banner.getImage().getRatio());
            imageView.setOnClickListener(new MeFragment$updateMeBannerUi$$inlined$apply$lambda$1(banner, imageView, this, banner));
            return;
        }
        Intrinsics.checkExpressionValueIsNotNull(imageView, "this");
        ViewExtensionsKt.gone(imageView);
    }

    private final void loadAvailableCouponCount() {
        if (this.availableCouponCountRequest == null) {
            CouponAPI couponAPI2 = this.couponAPI;
            if (couponAPI2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("couponAPI");
            }
            this.availableCouponCountRequest = couponAPI2.requestAvailableCouponCount().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new MeFragment$loadAvailableCouponCount$1<Object,Object>(this));
        }
    }

    /* access modifiers changed from: private */
    @SuppressLint({"SetTextI18n"})
    public final void initViewByData(MyInfo myInfo) {
        if (myInfo != null) {
            Button button = (Button) _$_findCachedViewById(C0010R$id.showShowroomButton);
            Intrinsics.checkExpressionValueIsNotNull(button, "showShowroomButton");
            button.setVisibility(0);
            LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(C0010R$id.fittie_list);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout, "fittie_list");
            linearLayout.setVisibility(0);
            TextView textView = (TextView) _$_findCachedViewById(C0010R$id.textFittsPoint);
            Intrinsics.checkExpressionValueIsNotNull(textView, "textFittsPoint");
            StringBuilder sb = new StringBuilder();
            sb.append(IntExtensionsKt.commaString(myInfo.getRewardPoints()));
            sb.append(50896);
            textView.setText(sb.toString());
            BaseRequestOptions error = ((RequestOptions) new RequestOptions().placeholder((int) C0008R$drawable.image_default_profile_large)).error((int) C0008R$drawable.image_default_profile_large);
            Intrinsics.checkExpressionValueIsNotNull(error, "RequestOptions()\n       …ge_default_profile_large)");
            Glide.with((Fragment) this).load(myInfo.getProfileImageUrl()).apply((BaseRequestOptions<?>) (RequestOptions) error).into((ImageView) (CircleImageView) _$_findCachedViewById(C0010R$id.profile_image));
            TextView textView2 = (TextView) _$_findCachedViewById(C0010R$id.fittsIDTextView);
            Intrinsics.checkExpressionValueIsNotNull(textView2, "fittsIDTextView");
            textView2.setText(myInfo.getFittsID());
        }
    }

    private final void initClickListener() {
        ((ImageButton) _$_findCachedViewById(C0010R$id.button_me_setting)).setOnClickListener(new MeFragment$initClickListener$1(this));
        ((Button) _$_findCachedViewById(C0010R$id.showShowroomButton)).setOnClickListener(new MeFragment$initClickListener$2(this));
        ((CircleImageView) _$_findCachedViewById(C0010R$id.profile_image)).setOnClickListener(new MeFragment$initClickListener$3(this));
        ((LinearLayout) _$_findCachedViewById(C0010R$id.fittsPointLayout)).setOnClickListener(new MeFragment$initClickListener$4(this));
        ((LinearLayout) _$_findCachedViewById(C0010R$id.fittsCouponLayout)).setOnClickListener(new MeFragment$initClickListener$5(this));
        ((LinearLayout) _$_findCachedViewById(C0010R$id.pointGuideLayout)).setOnClickListener(new MeFragment$initClickListener$6(this));
        ((LinearLayout) _$_findCachedViewById(C0010R$id.likedListButton)).setOnClickListener(new MeFragment$initClickListener$7(this));
        ((LinearLayout) _$_findCachedViewById(C0010R$id.orderListLayout)).setOnClickListener(new MeFragment$initClickListener$8(this));
        ((LinearLayout) _$_findCachedViewById(C0010R$id.wishListLayout)).setOnClickListener(new MeFragment$initClickListener$9(this));
        ((LinearLayout) _$_findCachedViewById(C0010R$id.bookmarkListLayout)).setOnClickListener(new MeFragment$initClickListener$10(this));
        ((LinearLayout) _$_findCachedViewById(C0010R$id.eventLayout)).setOnClickListener(new MeFragment$initClickListener$11(this));
        ((LinearLayout) _$_findCachedViewById(C0010R$id.serviceCenterLayout)).setOnClickListener(new MeFragment$initClickListener$12(this));
        ((FrameLayout) _$_findCachedViewById(C0010R$id.iconCart)).setOnClickListener(new MeFragment$initClickListener$13(this));
        ((ImageView) _$_findCachedViewById(C0010R$id.imageBanner)).setOnClickListener(new MeFragment$initClickListener$14(this));
        ((LinearLayout) _$_findCachedViewById(C0010R$id.invitationButton)).setOnClickListener(new MeFragment$initClickListener$15(this));
    }

    /* access modifiers changed from: private */
    public final String getInvitationScheme() {
        int hashCode = "production".hashCode();
        return "fitts://openWeb/78";
    }

    private final void getBadgeCount() {
        CompositeDisposable compositeDisposable = this.disposables;
        UserAPI userAPI2 = this.userAPI;
        if (userAPI2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userAPI");
        }
        Disposable subscribe = userAPI2.getBadgeCount().subscribeOn(Schedulers.io()).map(MeFragment$getBadgeCount$1.INSTANCE).observeOn(AndroidSchedulers.mainThread()).subscribe(new MeFragment$getBadgeCount$2(this), new MeFragment$getBadgeCount$3(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "userAPI.getBadgeCount()\n…     }\n                })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    /* access modifiers changed from: private */
    public final void showShowroom() {
        kr.co.popone.fitts.feature.showroom.ShowRoomActivity.Companion companion = ShowRoomActivity.Companion;
        Context context = getContext();
        MyInfo myInfo = this.userInfo;
        companion.start(context, myInfo != null ? Long.valueOf(myInfo.getId()) : null, "me");
    }

    public final void showMessage(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        kr.co.popone.fitts.utils.Snackbar.Companion companion = Snackbar.Companion;
        FragmentActivity activity = getActivity();
        if (activity == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity!!");
        companion.showMessage(activity, str);
    }

    @Subscriber(mode = ThreadMode.MAIN, tag = "my_message")
    public final void onReceive(@NotNull Message message) {
        Intrinsics.checkParameterIsNotNull(message, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        int i = message.what;
        if (i != 2) {
            if (i == 3) {
                Integer num = null;
                if (message.getData().getBoolean("isLiked")) {
                    MyInfo myInfo = this.userInfo;
                    if (myInfo != null) {
                        if (myInfo != null) {
                            Integer likesCount = myInfo.getLikesCount();
                            if (likesCount != null) {
                                num = Integer.valueOf(likesCount.intValue() + 1);
                            }
                        }
                        myInfo.setLikesCount(num);
                        return;
                    }
                    return;
                }
                MyInfo myInfo2 = this.userInfo;
                if (myInfo2 != null) {
                    if (myInfo2 != null) {
                        Integer likesCount2 = myInfo2.getLikesCount();
                        if (likesCount2 != null) {
                            num = Integer.valueOf(likesCount2.intValue() - 1);
                        }
                    }
                    myInfo2.setLikesCount(num);
                }
            } else if (i == 4) {
                BaseRequestOptions error = ((RequestOptions) new RequestOptions().placeholder((int) C0008R$drawable.image_default_profile_large)).error((int) C0008R$drawable.image_default_profile_large);
                Intrinsics.checkExpressionValueIsNotNull(error, "RequestOptions().placeho…ge_default_profile_large)");
                Intrinsics.checkExpressionValueIsNotNull(Glide.with((Fragment) this).load(message.getData().getString("profileImageUrl")).apply((BaseRequestOptions<?>) (RequestOptions) error).into((ImageView) (CircleImageView) _$_findCachedViewById(C0010R$id.profile_image)), "Glide.with(this).load(me…ions).into(profile_image)");
            } else if (i == 6) {
                initData();
            }
        } else if (this.userInfo == null) {
            initData();
        } else if (message.getData().getBoolean("isFollowed")) {
            MyInfo myInfo3 = this.userInfo;
            if (myInfo3 == null) {
                Intrinsics.throwNpe();
            }
            MyInfo myInfo4 = this.userInfo;
            if (myInfo4 == null) {
                Intrinsics.throwNpe();
            }
            myInfo3.setFollowingsCount(myInfo4.getFollowingsCount() + 1);
        } else {
            MyInfo myInfo5 = this.userInfo;
            if (myInfo5 == null) {
                Intrinsics.throwNpe();
            }
            MyInfo myInfo6 = this.userInfo;
            if (myInfo6 == null) {
                Intrinsics.throwNpe();
            }
            myInfo5.setFollowingsCount(myInfo6.getFollowingsCount() - 1);
        }
    }

    public void onDestroyView() {
        Disposable disposable = this.userInfoRequest;
        if (disposable != null) {
            disposable.dispose();
        }
        this.userInfoRequest = null;
        Disposable disposable2 = this.availableCouponCountRequest;
        if (disposable2 != null) {
            disposable2.dispose();
        }
        this.availableCouponCountRequest = null;
        this.userInfo = null;
        EventBus.getDefault().unregister(this);
        this.disposables.dispose();
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }
}
