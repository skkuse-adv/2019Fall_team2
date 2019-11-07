package kr.co.popone.fitts.feature.category;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SpinnerAdapter;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.base.extension.ContextExtensionKt;
import kr.co.popone.fitts.event.RxBus;
import kr.co.popone.fitts.model.category.CategoryViewData;
import kr.co.popone.fitts.ui.custom.CateSearchTypeCustomView;
import kr.co.popone.fitts.ui.custom.CateSearchTypeCustomView.CategoryFeedType;
import kr.co.popone.fitts.ui.custom.CustomIconSpinnerAdapter;
import kr.co.popone.fitts.ui.custom.CustomTabLayout;
import kr.co.popone.fitts.utils.ActivityAnimationType;
import kr.co.popone.fitts.viewmodel.category.CategorySearchViewModel;
import org.jetbrains.anko.sdk27.coroutines.Sdk27CoroutinesListenersWithCoroutinesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CategorySearchActivity extends AppCompatActivity implements HasSupportFragmentInjector {
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String KEY_CATEGORY_LIST = "category_list";
    @NotNull
    public static final String KEY_CATEGORY_POSITION = "category_position";
    @NotNull
    public static final String KEY_FEED_TYPE = "post_type";
    @NotNull
    public static final String KEY_SUB_CATEGORY_POSITION = "sub_category_position";
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public final CategorySearchAdatper categorySearchAdatper = new CategorySearchAdatper(getSupportFragmentManager());
    @NotNull
    public DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;
    private final CompositeDisposable disposable = new CompositeDisposable();
    @NotNull
    public CategorySearchViewModel viewModel;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void start(@NotNull Activity activity, @NotNull List<CategoryViewData> list, int i, int i2, @NotNull String str) {
            Intrinsics.checkParameterIsNotNull(activity, "activity");
            Intrinsics.checkParameterIsNotNull(list, "categories");
            Intrinsics.checkParameterIsNotNull(str, "postType");
            Intent intent = new Intent(activity, CategorySearchActivity.class);
            intent.putParcelableArrayListExtra(CategorySearchActivity.KEY_CATEGORY_LIST, new ArrayList(list));
            intent.putExtra(CategorySearchActivity.KEY_CATEGORY_POSITION, i);
            intent.putExtra(CategorySearchActivity.KEY_SUB_CATEGORY_POSITION, i2);
            intent.putExtra("post_type", str);
            ContextExtensionKt.activityStart(activity, intent, ActivityAnimationType.SLIDE_RTOL);
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
    public final CategorySearchViewModel getViewModel() {
        CategorySearchViewModel categorySearchViewModel = this.viewModel;
        if (categorySearchViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return categorySearchViewModel;
    }

    public final void setViewModel(@NotNull CategorySearchViewModel categorySearchViewModel) {
        Intrinsics.checkParameterIsNotNull(categorySearchViewModel, "<set-?>");
        this.viewModel = categorySearchViewModel;
    }

    @NotNull
    public final DispatchingAndroidInjector<Fragment> getDispatchingAndroidInjector() {
        DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector2 = this.dispatchingAndroidInjector;
        if (dispatchingAndroidInjector2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dispatchingAndroidInjector");
        }
        return dispatchingAndroidInjector2;
    }

    public final void setDispatchingAndroidInjector(@NotNull DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector2) {
        Intrinsics.checkParameterIsNotNull(dispatchingAndroidInjector2, "<set-?>");
        this.dispatchingAndroidInjector = dispatchingAndroidInjector2;
    }

    @NotNull
    public AndroidInjector<Fragment> supportFragmentInjector() {
        DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector2 = this.dispatchingAndroidInjector;
        if (dispatchingAndroidInjector2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dispatchingAndroidInjector");
        }
        return dispatchingAndroidInjector2;
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        CategoryViewData[] categoryViewDataArr;
        AndroidInjection.inject((Activity) this);
        super.onCreate(bundle);
        setContentView((int) C0013R$layout.activity_category_search);
        AppCompatSpinner appCompatSpinner = (AppCompatSpinner) _$_findCachedViewById(C0010R$id.spinnerCategory);
        ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra(KEY_CATEGORY_LIST);
        Context context = appCompatSpinner.getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        if (parcelableArrayListExtra == null) {
            categoryViewDataArr = null;
        } else if (parcelableArrayListExtra != null) {
            Object[] array = parcelableArrayListExtra.toArray(new CategoryViewData[0]);
            if (array != null) {
                categoryViewDataArr = (CategoryViewData[]) array;
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
            }
        } else {
            throw new TypeCastException("null cannot be cast to non-null type java.util.Collection<T>");
        }
        appCompatSpinner.setAdapter((SpinnerAdapter) new CustomIconSpinnerAdapter(context, categoryViewDataArr));
        Sdk27CoroutinesListenersWithCoroutinesKt.onItemSelectedListener$default(appCompatSpinner, null, new CategorySearchActivity$onCreate$$inlined$apply$lambda$1(parcelableArrayListExtra, this), 1, null);
        appCompatSpinner.setSelection(getIntent().getIntExtra(KEY_CATEGORY_POSITION, 0));
        ViewPager viewPager = (ViewPager) _$_findCachedViewById(C0010R$id.pagerCategorySearch);
        Intrinsics.checkExpressionValueIsNotNull(viewPager, "pagerCategorySearch");
        viewPager.setAdapter(this.categorySearchAdatper);
        CompositeDisposable compositeDisposable = this.disposable;
        Disposable subscribe = this.categorySearchAdatper.getInitialSubCategories().first(Unit.INSTANCE).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new CategorySearchActivity$onCreate$2<Object,Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "categorySearchAdatper.in…goryPos\n                }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.disposable;
        Disposable subscribe2 = RxBus.INSTANCE.toObservable().subscribeOn(Schedulers.io()).filter(CategorySearchActivity$onCreate$3.INSTANCE).map(CategorySearchActivity$onCreate$4.INSTANCE).filter(CategorySearchActivity$onCreate$5.INSTANCE).observeOn(AndroidSchedulers.mainThread()).subscribe((Consumer<? super T>) new CategorySearchActivity$onCreate$6<Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe2, "RxBus.toObservable()\n   …inish()\n                }");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
        ((CateSearchTypeCustomView) _$_findCachedViewById(C0010R$id.categoryTypeView)).getCategoryFeedTypeLiveData().observe(new CategorySearchActivity$onCreate$7(this), new CategorySearchActivity$onCreate$8(this));
        ((CateSearchTypeCustomView) _$_findCachedViewById(C0010R$id.categoryTypeView)).getCategoryFeedTypeClickLiveData().observe(new CategorySearchActivity$onCreate$9(this), new CategorySearchActivity$onCreate$10(this));
        ((CustomTabLayout) _$_findCachedViewById(C0010R$id.tabCategorySearch)).setupWithViewPager((ViewPager) _$_findCachedViewById(C0010R$id.pagerCategorySearch));
        ((ImageButton) _$_findCachedViewById(C0010R$id.closeButton)).setOnClickListener(new CategorySearchActivity$onCreate$12(this));
        if (Intrinsics.areEqual((Object) getIntent().getStringExtra("post_type"), (Object) "product")) {
            ((CateSearchTypeCustomView) _$_findCachedViewById(C0010R$id.categoryTypeView)).setCategoryFeedType(CategoryFeedType.PRODUCT);
            this.categorySearchAdatper.setType(CategoryFeedType.PRODUCT);
            return;
        }
        ((CateSearchTypeCustomView) _$_findCachedViewById(C0010R$id.categoryTypeView)).setCategoryFeedType(CategoryFeedType.POST);
        this.categorySearchAdatper.setType(CategoryFeedType.POST);
    }

    public void finish() {
        super.finish();
        overridePendingTransition(ActivityAnimationType.SLIDE_LTOR.getEnter(), ActivityAnimationType.SLIDE_LTOR.getExit());
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        ViewPager viewPager = (ViewPager) _$_findCachedViewById(C0010R$id.pagerCategorySearch);
        if (viewPager != null) {
            viewPager.setAdapter(null);
        }
        AppCompatSpinner appCompatSpinner = (AppCompatSpinner) _$_findCachedViewById(C0010R$id.spinnerCategory);
        if (appCompatSpinner != null) {
            appCompatSpinner.setAdapter((SpinnerAdapter) null);
        }
        this.disposable.dispose();
        super.onDestroy();
    }
}
