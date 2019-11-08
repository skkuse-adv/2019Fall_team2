package kr.co.popone.fitts.feature.intro;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.PageTransformer;
import com.facebook.CallbackManager;
import com.facebook.CallbackManager.Factory;
import com.facebook.login.LoginManager;
import com.kakao.auth.Session;
import com.kakao.usermgmt.UserManagement;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0001R$anim;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.eventtracker.EventTracker.DefaultImpls;
import kr.co.popone.fitts.feature.intro.join.JoinActivity;
import kr.co.popone.fitts.model.user.UserAPI;
import kr.co.popone.fitts.ui.ViewExtensionsKt;
import kr.co.popone.fitts.utils.UIExtensionsKt;
import me.relex.circleindicator.CircleIndicator;
import org.jetbrains.anko.internals.AnkoInternals;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class IntroActivity extends AppCompatActivity implements HasSupportFragmentInjector {
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public Disposable emailCheckRequest;
    @NotNull
    public EventTracker eventTracker;
    private final CallbackManager facebookCallback = Factory.create();
    @NotNull
    public DispatchingAndroidInjector<Fragment> fragmentInjector;
    private final IntroActivity$kakaoCallback$1 kakaoCallback = new IntroActivity$kakaoCallback$1(this);
    private final List<String> kakaoProperties = CollectionsKt__CollectionsKt.listOf("kakao_account.email", "properties.profile_image");
    @NotNull
    public SessionManager sessionManager;
    /* access modifiers changed from: private */
    public Disposable snsLoginRequest;
    @NotNull
    public UserAPI userAPI;

    public static final class DepthPageTransformer implements PageTransformer {
        private final Context context;

        public DepthPageTransformer(@NotNull Context context2) {
            Intrinsics.checkParameterIsNotNull(context2, "context");
            this.context = context2;
        }

        public void transformPage(@NotNull View view, float f) {
            View view2 = view;
            float f2 = f;
            Intrinsics.checkParameterIsNotNull(view2, "page");
            float abs = Math.abs(f);
            Integer valueOf = Integer.valueOf(1);
            float f3 = (float) 1;
            float abs2 = Math.abs(abs - f3);
            float f4 = (float) -1;
            String str = "transition_center";
            String str2 = "page.findViewWithTag<View>(\"transition_alpha6\")";
            String str3 = "transition_alpha6";
            String str4 = "page.findViewWithTag<View>(\"transition_alpha4\")";
            String str5 = "transition_alpha4";
            String str6 = "page.findViewWithTag<View>(\"bottom_background\")";
            String str7 = "bottom_background";
            Integer valueOf2 = Integer.valueOf(0);
            float f5 = f3;
            String str8 = "page.findViewWithTag<View>(\"bottom\")";
            Integer valueOf3 = Integer.valueOf(2);
            String str9 = "bottom";
            String str10 = "page.findViewWithTag<View>(\"transition_center\")";
            float f6 = f4;
            if (f4 >= f2 || f2 >= ((float) 0)) {
                Integer num = valueOf3;
                String str11 = str10;
                if (f2 <= f6) {
                    view2.setAlpha(0.0f);
                    return;
                }
                Integer num2 = valueOf2;
                if (((float) 0) >= f2 || f2 >= f5) {
                    String str12 = str6;
                    Integer num3 = num2;
                    if (f2 >= f5) {
                        view2.setAlpha(0.0f);
                        return;
                    }
                    Object tag = view.getTag();
                    if (Intrinsics.areEqual(tag, (Object) num3)) {
                        view2.setAlpha(1.0f);
                        View findViewWithTag = view2.findViewWithTag("transition_alpha");
                        Intrinsics.checkExpressionValueIsNotNull(findViewWithTag, "page.findViewWithTag<View>(\"transition_alpha\")");
                        findViewWithTag.setAlpha(1.0f);
                    } else if (Intrinsics.areEqual(tag, (Object) valueOf)) {
                        view2.setAlpha(1.0f);
                        View findViewWithTag2 = view2.findViewWithTag(str7);
                        Intrinsics.checkExpressionValueIsNotNull(findViewWithTag2, str12);
                        findViewWithTag2.setAlpha(1.0f);
                        View findViewWithTag3 = view2.findViewWithTag(str);
                        Intrinsics.checkExpressionValueIsNotNull(findViewWithTag3, str11);
                        findViewWithTag3.setAlpha(1.0f);
                        View findViewWithTag4 = view2.findViewWithTag(str5);
                        Intrinsics.checkExpressionValueIsNotNull(findViewWithTag4, str4);
                        findViewWithTag4.setAlpha(1.0f);
                        View findViewWithTag5 = view2.findViewWithTag(str3);
                        Intrinsics.checkExpressionValueIsNotNull(findViewWithTag5, str2);
                        findViewWithTag5.setAlpha(1.0f);
                        View findViewWithTag6 = view2.findViewWithTag("transition_alpha1");
                        Intrinsics.checkExpressionValueIsNotNull(findViewWithTag6, "page.findViewWithTag<View>(\"transition_alpha1\")");
                        findViewWithTag6.setAlpha(0.0f);
                        View findViewWithTag7 = view2.findViewWithTag("transition_alpha2");
                        Intrinsics.checkExpressionValueIsNotNull(findViewWithTag7, "page.findViewWithTag<View>(\"transition_alpha2\")");
                        findViewWithTag7.setAlpha(0.0f);
                        View findViewWithTag8 = view2.findViewWithTag("transition_alpha3");
                        Intrinsics.checkExpressionValueIsNotNull(findViewWithTag8, "page.findViewWithTag<View>(\"transition_alpha3\")");
                        findViewWithTag8.setAlpha(0.0f);
                    } else if (Intrinsics.areEqual(tag, (Object) Integer.valueOf(3))) {
                        View findViewWithTag9 = view2.findViewWithTag("intro3_1");
                        Intrinsics.checkExpressionValueIsNotNull(findViewWithTag9, "page.findViewWithTag<View>(\"intro3_1\")");
                        findViewWithTag9.setTranslationX(calcIntroThreeFirst(view));
                        View findViewWithTag10 = view2.findViewWithTag("intro3_2");
                        Intrinsics.checkExpressionValueIsNotNull(findViewWithTag10, "page.findViewWithTag<View>(\"intro3_2\")");
                        findViewWithTag10.setTranslationX(calcIntroThreeSecond(view));
                        View findViewWithTag11 = view2.findViewWithTag("intro3_3");
                        Intrinsics.checkExpressionValueIsNotNull(findViewWithTag11, "page.findViewWithTag<View>(\"intro3_3\")");
                        findViewWithTag11.setTranslationX(calcIntroThreeThird(view));
                    }
                } else {
                    Object tag2 = view.getTag();
                    if (Intrinsics.areEqual(tag2, (Object) valueOf)) {
                        view2.setAlpha(1.0f);
                        float f7 = -f2;
                        view2.setTranslationX(((float) view.getWidth()) * f7);
                        View findViewWithTag12 = view2.findViewWithTag("transition_alpha1");
                        Intrinsics.checkExpressionValueIsNotNull(findViewWithTag12, "page.findViewWithTag<View>(\"transition_alpha1\")");
                        float f8 = f5 - abs2;
                        findViewWithTag12.setAlpha(f8);
                        View findViewWithTag13 = view2.findViewWithTag("transition_alpha2");
                        String str13 = str6;
                        Intrinsics.checkExpressionValueIsNotNull(findViewWithTag13, "page.findViewWithTag<View>(\"transition_alpha2\")");
                        findViewWithTag13.setAlpha(f8);
                        View findViewWithTag14 = view2.findViewWithTag("transition_alpha3");
                        Intrinsics.checkExpressionValueIsNotNull(findViewWithTag14, "page.findViewWithTag<View>(\"transition_alpha3\")");
                        findViewWithTag14.setAlpha(f8);
                        View findViewWithTag15 = view2.findViewWithTag(str);
                        Intrinsics.checkExpressionValueIsNotNull(findViewWithTag15, str11);
                        findViewWithTag15.setAlpha(1.0f);
                        View findViewWithTag16 = view2.findViewWithTag(str5);
                        Intrinsics.checkExpressionValueIsNotNull(findViewWithTag16, str4);
                        findViewWithTag16.setAlpha(1.0f);
                        View findViewWithTag17 = view2.findViewWithTag(str3);
                        Intrinsics.checkExpressionValueIsNotNull(findViewWithTag17, str2);
                        findViewWithTag17.setAlpha(1.0f);
                        View findViewWithTag18 = view2.findViewWithTag("transition1");
                        Intrinsics.checkExpressionValueIsNotNull(findViewWithTag18, "page.findViewWithTag<View>(\"transition1\")");
                        float f9 = ((float) 59) * f7;
                        Resources resources = this.context.getResources();
                        Intrinsics.checkExpressionValueIsNotNull(resources, "context.resources");
                        findViewWithTag18.setTranslationY(f9 * (((float) resources.getDisplayMetrics().densityDpi) / 160.0f));
                        View findViewWithTag19 = view2.findViewWithTag("transition2");
                        Intrinsics.checkExpressionValueIsNotNull(findViewWithTag19, "page.findViewWithTag<View>(\"transition2\")");
                        float calculateTargetDp = f7 * calculateTargetDp(this.context, view2, "transition_center_wrapper", "transition2_base");
                        Resources resources2 = this.context.getResources();
                        Intrinsics.checkExpressionValueIsNotNull(resources2, "context.resources");
                        findViewWithTag19.setTranslationY(calculateTargetDp * (((float) resources2.getDisplayMetrics().densityDpi) / 160.0f));
                        View findViewWithTag20 = view2.findViewWithTag(str9);
                        Intrinsics.checkExpressionValueIsNotNull(findViewWithTag20, str8);
                        findViewWithTag20.setAlpha(abs2);
                        View findViewWithTag21 = view2.findViewWithTag(str9);
                        Intrinsics.checkExpressionValueIsNotNull(findViewWithTag21, str8);
                        findViewWithTag21.setTranslationX(((float) view.getWidth()) * f2);
                        View findViewWithTag22 = view2.findViewWithTag(str7);
                        Intrinsics.checkExpressionValueIsNotNull(findViewWithTag22, str13);
                        findViewWithTag22.setTranslationX(((float) view.getWidth()) * f2);
                        return;
                    }
                    if (Intrinsics.areEqual(tag2, (Object) num)) {
                        view2.setAlpha(1.0f);
                        view2.setTranslationX((-f2) * ((float) view.getWidth()));
                        View findViewWithTag23 = view2.findViewWithTag("transition_scale1");
                        Intrinsics.checkExpressionValueIsNotNull(findViewWithTag23, "page.findViewWithTag<View>(\"transition_scale1\")");
                        findViewWithTag23.setY(0.0f);
                        View findViewWithTag24 = view2.findViewWithTag(str);
                        Intrinsics.checkExpressionValueIsNotNull(findViewWithTag24, str11);
                        findViewWithTag24.setAlpha(abs2);
                        ViewCompat.setZ(view2.findViewWithTag("transition_scale1"), 0.1f);
                        View findViewWithTag25 = view2.findViewWithTag("transition_scale1");
                        Intrinsics.checkExpressionValueIsNotNull(findViewWithTag25, "page.findViewWithTag<View>(\"transition_scale1\")");
                        double d = (double) 1;
                        double d2 = (double) abs2;
                        Double.isNaN(d2);
                        double d3 = d2 * 1.3d;
                        Double.isNaN(d);
                        float f10 = (float) (d + d3);
                        findViewWithTag25.setScaleX(f10);
                        View findViewWithTag26 = view2.findViewWithTag("transition_scale");
                        Intrinsics.checkExpressionValueIsNotNull(findViewWithTag26, "page.findViewWithTag<View>(\"transition_scale\")");
                        findViewWithTag26.setScaleY(f10);
                        View findViewWithTag27 = view2.findViewWithTag(str5);
                        Intrinsics.checkExpressionValueIsNotNull(findViewWithTag27, str4);
                        float f11 = f5 - abs2;
                        findViewWithTag27.setAlpha(f11);
                        View findViewWithTag28 = view2.findViewWithTag(str3);
                        Intrinsics.checkExpressionValueIsNotNull(findViewWithTag28, str2);
                        findViewWithTag28.setAlpha(f11);
                        View findViewWithTag29 = view2.findViewWithTag(str9);
                        Intrinsics.checkExpressionValueIsNotNull(findViewWithTag29, str8);
                        findViewWithTag29.setTranslationX(((float) view.getWidth()) * f2);
                    } else if (Intrinsics.areEqual(tag2, (Object) Integer.valueOf(3))) {
                        view2.setAlpha(abs2);
                        view2.setTranslationX((-f2) * ((float) view.getWidth()));
                        View findViewWithTag30 = view2.findViewWithTag(str9);
                        Intrinsics.checkExpressionValueIsNotNull(findViewWithTag30, str8);
                        findViewWithTag30.setTranslationX(((float) view.getWidth()) * f2);
                        float width = (((float) view.getWidth()) - (f2 * ((float) view.getWidth()))) * -2.55f;
                        View findViewWithTag31 = view2.findViewWithTag("intro3_1");
                        int width2 = view.getWidth();
                        int width3 = view.getWidth();
                        Intrinsics.checkExpressionValueIsNotNull(findViewWithTag31, "intro1");
                        float f12 = -((float) (width2 - ((width3 - findViewWithTag31.getWidth()) / 2)));
                        if (width < f12) {
                            findViewWithTag31.setTranslationX(f12);
                        } else {
                            findViewWithTag31.setTranslationX(width);
                        }
                        View findViewWithTag32 = view2.findViewWithTag("intro3_2");
                        int width4 = view.getWidth();
                        int width5 = view.getWidth();
                        Intrinsics.checkExpressionValueIsNotNull(findViewWithTag32, "intro2");
                        float f13 = -((float) (width4 - ((width5 - findViewWithTag32.getWidth()) / 2)));
                        if (width < f13 - ((float) findViewWithTag31.getWidth())) {
                            findViewWithTag32.setTranslationX(f13 - ((float) findViewWithTag31.getWidth()));
                        } else {
                            findViewWithTag32.setTranslationX(width);
                        }
                        View findViewWithTag33 = view2.findViewWithTag("intro3_3");
                        int width6 = view.getWidth();
                        int width7 = view.getWidth();
                        Intrinsics.checkExpressionValueIsNotNull(findViewWithTag33, "intro3");
                        float f14 = -((float) (width6 - ((width7 - findViewWithTag33.getWidth()) / 2)));
                        if (width < (f14 - ((float) findViewWithTag31.getWidth())) - ((float) findViewWithTag32.getWidth())) {
                            findViewWithTag33.setTranslationX((f14 - ((float) findViewWithTag31.getWidth())) - ((float) findViewWithTag32.getWidth()));
                        } else {
                            findViewWithTag33.setTranslationX(width);
                        }
                    } else if (Intrinsics.areEqual(tag2, (Object) Integer.valueOf(4))) {
                        view2.setAlpha(abs2);
                    }
                }
            } else {
                Object tag3 = view.getTag();
                if (Intrinsics.areEqual(tag3, (Object) valueOf2)) {
                    view2.setAlpha(1.0f);
                    view2.setTranslationX(((float) view.getWidth()) * (-f2));
                    View findViewWithTag34 = view2.findViewWithTag("transition_alpha");
                    Intrinsics.checkExpressionValueIsNotNull(findViewWithTag34, "page.findViewWithTag<View>(\"transition_alpha\")");
                    findViewWithTag34.setAlpha(0.0f);
                    View findViewWithTag35 = view2.findViewWithTag(str9);
                    Intrinsics.checkExpressionValueIsNotNull(findViewWithTag35, str8);
                    findViewWithTag35.setAlpha(abs2);
                    View findViewWithTag36 = view2.findViewWithTag(str9);
                    Intrinsics.checkExpressionValueIsNotNull(findViewWithTag36, str8);
                    findViewWithTag36.setTranslationX(((float) view.getWidth()) * f2);
                    View findViewWithTag37 = view2.findViewWithTag(str7);
                    Intrinsics.checkExpressionValueIsNotNull(findViewWithTag37, str6);
                    findViewWithTag37.setTranslationX(((float) view.getWidth()) * f2);
                } else if (Intrinsics.areEqual(tag3, (Object) valueOf)) {
                    view2.setAlpha(1.0f);
                    view2.setTranslationX(((float) view.getWidth()) * (-f2));
                    View findViewWithTag38 = view2.findViewWithTag("transition_alpha1");
                    Intrinsics.checkExpressionValueIsNotNull(findViewWithTag38, "page.findViewWithTag<View>(\"transition_alpha1\")");
                    findViewWithTag38.setAlpha(0.0f);
                    View findViewWithTag39 = view2.findViewWithTag("transition_alpha2");
                    Intrinsics.checkExpressionValueIsNotNull(findViewWithTag39, "page.findViewWithTag<View>(\"transition_alpha2\")");
                    findViewWithTag39.setAlpha(0.0f);
                    View findViewWithTag40 = view2.findViewWithTag("transition_alpha3");
                    Intrinsics.checkExpressionValueIsNotNull(findViewWithTag40, "page.findViewWithTag<View>(\"transition_alpha3\")");
                    findViewWithTag40.setAlpha(0.0f);
                    View findViewWithTag41 = view2.findViewWithTag(str5);
                    Intrinsics.checkExpressionValueIsNotNull(findViewWithTag41, str4);
                    findViewWithTag41.setAlpha(0.0f);
                    View findViewWithTag42 = view2.findViewWithTag(str3);
                    Intrinsics.checkExpressionValueIsNotNull(findViewWithTag42, str2);
                    findViewWithTag42.setAlpha(0.0f);
                    View findViewWithTag43 = view2.findViewWithTag(str);
                    Intrinsics.checkExpressionValueIsNotNull(findViewWithTag43, str10);
                    findViewWithTag43.setAlpha(0.0f);
                    View findViewWithTag44 = view2.findViewWithTag(str9);
                    Intrinsics.checkExpressionValueIsNotNull(findViewWithTag44, str8);
                    findViewWithTag44.setTranslationX(f2 * ((float) view.getWidth()));
                    View findViewWithTag45 = view2.findViewWithTag(str7);
                    Intrinsics.checkExpressionValueIsNotNull(findViewWithTag45, str6);
                    findViewWithTag45.setAlpha(abs2);
                } else if (Intrinsics.areEqual(tag3, (Object) valueOf3)) {
                    view2.setTranslationX(((float) view.getWidth()) * (-f2));
                    view2.setAlpha(f5 + (((float) 2) * f2));
                    View findViewWithTag46 = view2.findViewWithTag("transition_scale1");
                    Intrinsics.checkExpressionValueIsNotNull(findViewWithTag46, "page.findViewWithTag<View>(\"transition_scale1\")");
                    findViewWithTag46.setTranslationY(((float) view.getHeight()) * f2);
                    View findViewWithTag47 = view2.findViewWithTag(str9);
                    Intrinsics.checkExpressionValueIsNotNull(findViewWithTag47, str8);
                    findViewWithTag47.setTranslationX(((float) view.getWidth()) * f2);
                } else if (Intrinsics.areEqual(tag3, (Object) Integer.valueOf(3))) {
                    view2.setAlpha(abs2);
                    View findViewWithTag48 = view2.findViewWithTag("intro3_1");
                    Intrinsics.checkExpressionValueIsNotNull(findViewWithTag48, "page.findViewWithTag<View>(\"intro3_1\")");
                    findViewWithTag48.setTranslationX(calcIntroThreeFirst(view));
                    View findViewWithTag49 = view2.findViewWithTag("intro3_2");
                    Intrinsics.checkExpressionValueIsNotNull(findViewWithTag49, "page.findViewWithTag<View>(\"intro3_2\")");
                    findViewWithTag49.setTranslationX(calcIntroThreeSecond(view));
                    View findViewWithTag50 = view2.findViewWithTag("intro3_3");
                    Intrinsics.checkExpressionValueIsNotNull(findViewWithTag50, "page.findViewWithTag<View>(\"intro3_3\")");
                    findViewWithTag50.setTranslationX(calcIntroThreeThird(view));
                } else if (Intrinsics.areEqual(tag3, (Object) Integer.valueOf(4))) {
                    view2.setAlpha(abs2);
                }
            }
        }

        private final float calcIntroThreeFirst(View view) {
            View findViewWithTag = view.findViewWithTag("intro3_1");
            int width = view.getWidth();
            int width2 = view.getWidth();
            Intrinsics.checkExpressionValueIsNotNull(findViewWithTag, "intro1");
            return -((float) (width - ((width2 - findViewWithTag.getWidth()) / 2)));
        }

        private final float calcIntroThreeSecond(View view) {
            View findViewWithTag = view.findViewWithTag("intro3_1");
            View findViewWithTag2 = view.findViewWithTag("intro3_2");
            int width = view.getWidth();
            int width2 = view.getWidth();
            Intrinsics.checkExpressionValueIsNotNull(findViewWithTag2, "intro2");
            float f = -((float) (width - ((width2 - findViewWithTag2.getWidth()) / 2)));
            Intrinsics.checkExpressionValueIsNotNull(findViewWithTag, "intro1");
            return f - ((float) findViewWithTag.getWidth());
        }

        private final float calcIntroThreeThird(View view) {
            View findViewWithTag = view.findViewWithTag("intro3_1");
            View findViewWithTag2 = view.findViewWithTag("intro3_2");
            View findViewWithTag3 = view.findViewWithTag("intro3_3");
            int width = view.getWidth();
            int width2 = view.getWidth();
            Intrinsics.checkExpressionValueIsNotNull(findViewWithTag3, "intro3");
            float f = -((float) (width - ((width2 - findViewWithTag3.getWidth()) / 2)));
            Intrinsics.checkExpressionValueIsNotNull(findViewWithTag, "intro1");
            float width3 = f - ((float) findViewWithTag.getWidth());
            Intrinsics.checkExpressionValueIsNotNull(findViewWithTag2, "intro2");
            return width3 - ((float) findViewWithTag2.getWidth());
        }

        private final float calculateTargetDp(Context context2, View view, String str, String str2) {
            View findViewWithTag = view.findViewWithTag(str);
            Intrinsics.checkExpressionValueIsNotNull(findViewWithTag, "view.findViewWithTag<View>(tagName1)");
            float y = findViewWithTag.getY();
            View findViewWithTag2 = view.findViewWithTag(str2);
            Intrinsics.checkExpressionValueIsNotNull(findViewWithTag2, "view.findViewWithTag<View>(tagName2)");
            float y2 = y - findViewWithTag2.getY();
            Resources resources = context2.getResources();
            Intrinsics.checkExpressionValueIsNotNull(resources, "context.resources");
            return y2 * (160.0f / ((float) resources.getDisplayMetrics().densityDpi));
        }
    }

    public static final class SectionsPagerAdapter extends FragmentPagerAdapter {
        public int getCount() {
            return 5;
        }

        public SectionsPagerAdapter(@NotNull FragmentManager fragmentManager) {
            Intrinsics.checkParameterIsNotNull(fragmentManager, "fm");
            super(fragmentManager);
        }

        @NotNull
        public Fragment getItem(int i) {
            if (i == 0) {
                return new IntroFirstFragment();
            }
            if (i == 1) {
                return new IntroSecondFragment();
            }
            if (i == 2) {
                return new IntroThirdFragment();
            }
            if (i != 3) {
                return new IntroLoginFragment();
            }
            return new IntroFourthFragment();
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

    /* access modifiers changed from: private */
    public final void getUserInfoFromKakao() {
        UserManagement.getInstance().me(this.kakaoProperties, new IntroActivity$getUserInfoFromKakao$1(this));
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        AndroidInjection.inject((Activity) this);
        super.onCreate(bundle);
        setContentView((int) C0013R$layout.activity_intro);
        ViewPager viewPager = (ViewPager) _$_findCachedViewById(C0010R$id.viewPager);
        String str = "viewPager";
        Intrinsics.checkExpressionValueIsNotNull(viewPager, str);
        viewPager.setAdapter(getSectionAdapter());
        ViewPager viewPager2 = (ViewPager) _$_findCachedViewById(C0010R$id.viewPager);
        Intrinsics.checkExpressionValueIsNotNull(viewPager2, str);
        viewPager2.setOffscreenPageLimit(5);
        ((CircleIndicator) _$_findCachedViewById(C0010R$id.indicatorView)).setViewPager((ViewPager) _$_findCachedViewById(C0010R$id.viewPager));
        CircleIndicator circleIndicator = (CircleIndicator) _$_findCachedViewById(C0010R$id.indicatorView);
        Intrinsics.checkExpressionValueIsNotNull(circleIndicator, "indicatorView");
        MarginLayoutParams marginLayoutParams = ViewExtensionsKt.getMarginLayoutParams(circleIndicator);
        Resources resources = getResources();
        Intrinsics.checkExpressionValueIsNotNull(resources, "resources");
        marginLayoutParams.bottomMargin = UIExtensionsKt.navigationBarHeight(resources);
        if (getIntent().getIntExtra("onBack", -1) == 1) {
            ViewPager viewPager3 = (ViewPager) _$_findCachedViewById(C0010R$id.viewPager);
            Intrinsics.checkExpressionValueIsNotNull(viewPager3, str);
            viewPager3.setCurrentItem(3);
        }
        ((ViewPager) _$_findCachedViewById(C0010R$id.viewPager)).setPageTransformer(true, new DepthPageTransformer(this));
        if (VERSION.SDK_INT >= 23) {
            Window window = getWindow();
            Intrinsics.checkExpressionValueIsNotNull(window, "window");
            View decorView = window.getDecorView();
            Intrinsics.checkExpressionValueIsNotNull(decorView, "window.decorView");
            decorView.setSystemUiVisibility(8192);
        }
        getWindow().addFlags(512);
        getWindow().addFlags(134217728);
        Session.getCurrentSession().addCallback(this.kakaoCallback);
        LoginManager.getInstance().registerCallback(this.facebookCallback, new IntroActivity$onCreate$1(this));
    }

    public void onBackPressed() {
        super.onBackPressed();
        ActivityCompat.finishAffinity(this);
        System.exit(0);
        throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        if (!Session.getCurrentSession().handleActivityResult(i, i2, intent) && !this.facebookCallback.onActivityResult(i, i2, intent)) {
            super.onActivityResult(i, i2, intent);
        }
    }

    /* access modifiers changed from: private */
    public final void requestSNSLogin(String str, String str2, String str3, String str4) {
        Disposable disposable = this.snsLoginRequest;
        if (disposable != null) {
            disposable.dispose();
        }
        UserAPI userAPI2 = this.userAPI;
        if (userAPI2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userAPI");
        }
        Single flatMap = userAPI2.requestSNSLogin(str, str2).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).flatMap(new IntroActivity$requestSNSLogin$1(this));
        IntroActivity$requestSNSLogin$2 introActivity$requestSNSLogin$2 = new IntroActivity$requestSNSLogin$2(this);
        IntroActivity$requestSNSLogin$3 introActivity$requestSNSLogin$3 = new IntroActivity$requestSNSLogin$3(this, str, str2, str3, str4);
        this.snsLoginRequest = flatMap.subscribe(introActivity$requestSNSLogin$2, introActivity$requestSNSLogin$3);
    }

    /* access modifiers changed from: private */
    public final void onEmailCheck(String str, String str2, String str3, String str4) {
        Disposable disposable = this.emailCheckRequest;
        if (disposable != null) {
            disposable.dispose();
        }
        if (str3 == null || str3.length() == 0) {
            ActivityOptionsCompat makeCustomAnimation = ActivityOptionsCompat.makeCustomAnimation(this, C0001R$anim.slide_up, C0001R$anim.fade_out);
            Intrinsics.checkExpressionValueIsNotNull(makeCustomAnimation, "ActivityOptionsCompat.ma…lide_up, R.anim.fade_out)");
            startActivity(AnkoInternals.createIntent(this, JoinActivity.class, new Pair[]{TuplesKt.to("provider", str), TuplesKt.to("token", str2), TuplesKt.to("email", str3), TuplesKt.to("profile_image", str4)}), makeCustomAnimation.toBundle());
            EventTracker eventTracker2 = this.eventTracker;
            if (eventTracker2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("eventTracker");
            }
            DefaultImpls.logCustom$default(eventTracker2, "Enter ID Page For Sign Up", null, 2, null);
            return;
        }
        UserAPI userAPI2 = this.userAPI;
        if (userAPI2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userAPI");
        }
        Observable observeOn = userAPI2.requestEmailAvailable(str3).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        IntroActivity$onEmailCheck$1 introActivity$onEmailCheck$1 = new IntroActivity$onEmailCheck$1(this, str, str2, str3, str4);
        this.emailCheckRequest = observeOn.subscribe(introActivity$onEmailCheck$1, new IntroActivity$onEmailCheck$2(this));
    }

    private final SectionsPagerAdapter getSectionAdapter() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkExpressionValueIsNotNull(supportFragmentManager, "supportFragmentManager");
        return new SectionsPagerAdapter(supportFragmentManager);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        Disposable disposable = this.emailCheckRequest;
        if (disposable != null) {
            disposable.dispose();
        }
        Disposable disposable2 = this.snsLoginRequest;
        if (disposable2 != null) {
            disposable2.dispose();
        }
        Session.getCurrentSession().removeCallback(this.kakaoCallback);
        LoginManager.getInstance().unregisterCallback(this.facebookCallback);
        super.onDestroy();
    }
}
