package kr.co.popone.fitts.feature.identification.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxkotlin.DisposableKt;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.base.BaseActivity;
import kr.co.popone.fitts.base.extension.FragmentTransactionExtensionKt;
import kr.co.popone.fitts.event.RxBus;
import kr.co.popone.fitts.ui.DialogExtensions;
import kr.co.popone.fitts.utils.ActivityAnimationType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class IdentificationActivity extends BaseActivity implements HasSupportFragmentInjector {
    private HashMap _$_findViewCache;
    private final CompositeDisposable disposable = new CompositeDisposable();
    @NotNull
    public DispatchingAndroidInjector<Fragment> fragmentInjector;

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

    public int layoutResource() {
        return C0013R$layout.activity_identification;
    }

    @NotNull
    public ActivityAnimationType finishAnimationType() {
        return ActivityAnimationType.SLIDE_DOWN;
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

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        AndroidInjection.inject((Activity) this);
        super.onCreate(bundle);
        FragmentTransactionExtensionKt.beginTransaction((AppCompatActivity) this, 2131362058, (Fragment) IdentificationGuideFragment.Companion.newInstance());
        CompositeDisposable compositeDisposable = this.disposable;
        Disposable subscribe = RxBus.INSTANCE.toObservable().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new IdentificationActivity$onCreate$1(this), new IdentificationActivity$onCreate$2(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "RxBus.toObservable()\n   …or(it)\n                })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    /* access modifiers changed from: private */
    public final void changeFragmentWithAnim(Fragment fragment) {
        if (!isDestroyed()) {
            FragmentTransactionExtensionKt.beginTransactionWithAnim(this, 2131362058, fragment, ActivityAnimationType.SLIDE_UP, ActivityAnimationType.SLIDE_DOWN);
        }
    }

    public void onBackPressed() {
        Fragment currentFragment = FragmentTransactionExtensionKt.getCurrentFragment(this, 2131362058);
        if (!(currentFragment instanceof IdentificationGuideFragment) && !(currentFragment instanceof IdentificationDuplicateFragment) && !(currentFragment instanceof IdentificationAdditionalInfoFragment) && !(currentFragment instanceof IdentificationWebViewFragment)) {
            super.onBackPressed();
            return;
        }
        DialogExtensions.showConfirmDialog$default(DialogExtensions.INSTANCE, this, "", "정말 취소하시겠어요?", new IdentificationActivity$onBackPressed$1(this), IdentificationActivity$onBackPressed$2.INSTANCE, null, null, 0, 224, null);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.disposable.dispose();
        super.onDestroy();
    }
}
