package kr.co.popone.fitts.feature.ncommerce;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.kakao.message.template.MessageTemplateProtocol;
import com.orhanobut.logger.Logger;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;
import java.util.HashMap;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0001R$anim;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.base.extension.ContextExtensionKt;
import kr.co.popone.fitts.feature.identification.view.IdentificationActivity;
import kr.co.popone.fitts.ui.custom.CustomTabLayout;
import kr.co.popone.fitts.utils.ActivityAnimationType;
import kr.co.popone.fitts.viewmodel.ncommerce.NCommerceViewModel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class NCommerceActivity extends AppCompatActivity implements HasSupportFragmentInjector {
    public static final Companion Companion = new Companion(null);
    private final int CONTACT_INFO_REQUEST_CODE = 101;
    private HashMap _$_findViewCache;
    @NotNull
    public DispatchingAndroidInjector<Fragment> fragmentInjector;
    @NotNull
    private final List<Pair<String, Fragment>> fragments = CollectionsKt__CollectionsKt.listOf(new Pair("포인트 현황", PointRevenueDetailFragment.Companion.newInstance()), new Pair("포인트 내역", PointHistoryFragment.Companion.newInstance()));
    @NotNull
    public NCommerceViewModel viewModel;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void start$default(Companion companion, Context context, String str, int i, Object obj) {
            if ((i & 2) != 0) {
                str = null;
            }
            companion.start(context, str);
        }

        public final void start(@NotNull Context context, @Nullable String str) {
            Intrinsics.checkParameterIsNotNull(context, "context");
            Intent intent = new Intent(context, NCommerceActivity.class);
            intent.putExtra("init_target", str);
            ContextExtensionKt.activityStart(context, intent, ActivityAnimationType.SLIDE_RTOL);
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
    public final NCommerceViewModel getViewModel() {
        NCommerceViewModel nCommerceViewModel = this.viewModel;
        if (nCommerceViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return nCommerceViewModel;
    }

    public final void setViewModel(@NotNull NCommerceViewModel nCommerceViewModel) {
        Intrinsics.checkParameterIsNotNull(nCommerceViewModel, "<set-?>");
        this.viewModel = nCommerceViewModel;
    }

    @NotNull
    public final DispatchingAndroidInjector<Fragment> getFragmentInjector() {
        DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector = this.fragmentInjector;
        if (dispatchingAndroidInjector == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragmentInjector");
        }
        return dispatchingAndroidInjector;
    }

    public final void setFragmentInjector(@NotNull DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector) {
        Intrinsics.checkParameterIsNotNull(dispatchingAndroidInjector, "<set-?>");
        this.fragmentInjector = dispatchingAndroidInjector;
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
    public final List<Pair<String, Fragment>> getFragments() {
        return this.fragments;
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        AndroidInjection.inject((Activity) this);
        super.onCreate(bundle);
        setContentView((int) C0013R$layout.activity_ncommerce);
        ViewPager viewPager = (ViewPager) _$_findCachedViewById(C0010R$id.viewPager);
        viewPager.setAdapter(new NCommerceActivity$onCreate$$inlined$apply$lambda$1(getSupportFragmentManager(), this));
        viewPager.addOnPageChangeListener(new NCommerceActivity$onCreate$$inlined$apply$lambda$2(this));
        CustomTabLayout customTabLayout = (CustomTabLayout) _$_findCachedViewById(C0010R$id.tabLayout);
        customTabLayout.post(new NCommerceActivity$onCreate$$inlined$apply$lambda$3(customTabLayout, this));
        ((FrameLayout) _$_findCachedViewById(C0010R$id.backButton)).setOnClickListener(new NCommerceActivity$onCreate$3(this));
        ((FrameLayout) _$_findCachedViewById(C0010R$id.buttonHelp)).setOnClickListener(new NCommerceActivity$onCreate$4(this));
        String stringExtra = getIntent().getStringExtra("init_target");
        StringBuilder sb = new StringBuilder();
        sb.append("NCommerceActivity::Target = ");
        sb.append(stringExtra);
        Logger.d(sb.toString(), new Object[0]);
        if (stringExtra != null) {
            int hashCode = stringExtra.hashCode();
            if (hashCode != -1857640538) {
                if (hashCode == 3322014 && stringExtra.equals(MessageTemplateProtocol.TYPE_LIST)) {
                    ((ViewPager) _$_findCachedViewById(C0010R$id.viewPager)).post(new NCommerceActivity$onCreate$$inlined$let$lambda$2(this));
                }
            } else if (stringExtra.equals("summary")) {
                ((ViewPager) _$_findCachedViewById(C0010R$id.viewPager)).post(new NCommerceActivity$onCreate$$inlined$let$lambda$1(this));
            }
        }
        NCommerceViewModel nCommerceViewModel = this.viewModel;
        String str = "viewModel";
        if (nCommerceViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        nCommerceViewModel.getRewardPointsResultLiveData().observe(new NCommerceActivity$onCreate$6(this), new NCommerceActivity$onCreate$7(this));
        NCommerceViewModel nCommerceViewModel2 = this.viewModel;
        if (nCommerceViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        nCommerceViewModel2.getErrorLiveData().observe(new NCommerceActivity$onCreate$8(this), new NCommerceActivity$onCreate$9(this));
        NCommerceViewModel nCommerceViewModel3 = this.viewModel;
        if (nCommerceViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        nCommerceViewModel3.requestFittsPointInfo();
        NCommerceViewModel nCommerceViewModel4 = this.viewModel;
        if (nCommerceViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        nCommerceViewModel4.checkIdentityVerify(new NCommerceActivity$onCreate$10(this));
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        if (i != this.CONTACT_INFO_REQUEST_CODE) {
            super.onActivityResult(i, i2, intent);
        } else if (i2 == -1) {
            NCommerceViewModel nCommerceViewModel = this.viewModel;
            if (nCommerceViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            nCommerceViewModel.requestFittsPointInfo();
        }
    }

    /* access modifiers changed from: private */
    public final void startCouponPointInputUserInfoActivity() {
        startActivityForResult(new Intent(this, IdentificationActivity.class), this.CONTACT_INFO_REQUEST_CODE);
        overridePendingTransition(C0001R$anim.slide_up, C0001R$anim.fade_out);
    }

    public void finish() {
        super.finish();
        overridePendingTransition(ActivityAnimationType.SLIDE_LTOR.getEnter(), ActivityAnimationType.SLIDE_LTOR.getExit());
    }
}
