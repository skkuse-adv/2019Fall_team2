package kr.co.popone.fitts.feature.search.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.jakewharton.rxbinding2.InitialValueObservable;
import com.jakewharton.rxbinding2.widget.RxTextView;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;
import io.reactivex.disposables.CompositeDisposable;
import java.util.HashMap;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.base.extension.ContextExtensionKt;
import kr.co.popone.fitts.base.extension.FragmentTransactionExtensionKt;
import kr.co.popone.fitts.base.extension.KeyboardExtensionKt;
import kr.co.popone.fitts.feature.search.view.SearchHomeFragment.Delegate;
import kr.co.popone.fitts.ui.ViewExtensionsKt;
import kr.co.popone.fitts.utils.ActivityAnimationType;
import kr.co.popone.fitts.viewmodel.search.home.SearchViewModel;
import kr.co.popone.fitts.viewmodel.search.home.SearchViewModel.SearchState;
import kr.co.popone.fitts.viewmodel.search.home.SearchViewModel.SearchState.After;
import kr.co.popone.fitts.viewmodel.search.home.SearchViewModel.SearchState.Before;
import kr.co.popone.fitts.viewmodel.search.home.SearchViewModel.SearchState.Input;
import org.jetbrains.anko.internals.AnkoInternals;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class SearchActivity extends AppCompatActivity implements HasSupportFragmentInjector, Delegate, IntergratedSearchResultFragment.Delegate, SearchHistoryFragment.Delegate {
    public static final Companion Companion = new Companion(null);
    private HashMap _$_findViewCache;
    @NotNull
    private final CompositeDisposable disposable = new CompositeDisposable();
    @NotNull
    public DispatchingAndroidInjector<Fragment> fragmentInjector;
    @NotNull
    public SearchViewModel viewModel;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void start(@Nullable Context context) {
            if (context != null) {
                ContextExtensionKt.activityStart(context, AnkoInternals.createIntent(context, SearchActivity.class, new Pair[0]), ActivityAnimationType.SLIDE_UP);
            }
        }
    }

    /* access modifiers changed from: private */
    public final boolean handleKeywordInput(int i) {
        return i == 3;
    }

    public static final void start(@Nullable Context context) {
        Companion.start(context);
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
    public final SearchViewModel getViewModel() {
        SearchViewModel searchViewModel = this.viewModel;
        if (searchViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return searchViewModel;
    }

    public final void setViewModel(@NotNull SearchViewModel searchViewModel) {
        Intrinsics.checkParameterIsNotNull(searchViewModel, "<set-?>");
        this.viewModel = searchViewModel;
    }

    @NotNull
    public final CompositeDisposable getDisposable() {
        return this.disposable;
    }

    @NotNull
    public AndroidInjector<Fragment> supportFragmentInjector() {
        DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector = this.fragmentInjector;
        if (dispatchingAndroidInjector == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragmentInjector");
        }
        return dispatchingAndroidInjector;
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        AndroidInjection.inject((Activity) this);
        super.onCreate(bundle);
        setContentView((int) C0013R$layout.activity_search);
        ((ImageButton) _$_findCachedViewById(C0010R$id.buttonClear)).setOnClickListener(new SearchActivity$onCreate$1(this));
        ((TextView) _$_findCachedViewById(C0010R$id.buttonCancel)).setOnClickListener(new SearchActivity$onCreate$2(this));
        EditText editText = (EditText) _$_findCachedViewById(C0010R$id.editSearchKeyword);
        editText.requestFocus();
        editText.setOnEditorActionListener(new SearchActivity$onCreate$$inlined$apply$lambda$1(this));
        SearchViewModel searchViewModel = this.viewModel;
        String str = "viewModel";
        if (searchViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        InitialValueObservable textChanges = RxTextView.textChanges(editText);
        Intrinsics.checkExpressionValueIsNotNull(textChanges, "RxTextView.textChanges(this)");
        searchViewModel.keywordChange(textChanges);
        SearchViewModel searchViewModel2 = this.viewModel;
        if (searchViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        searchViewModel2.getSearchState().observe(new SearchActivity$onCreate$4(this), new SearchActivity$onCreate$5(this));
    }

    /* access modifiers changed from: private */
    public final void updateSearchView(SearchState searchState) {
        if (searchState instanceof Before) {
            updateViewBefore();
        } else if (searchState instanceof Input) {
            updateViewInput();
        } else if (searchState instanceof After) {
            updateViewAfter(((After) searchState).getKeyword());
        }
    }

    private final void updateViewBefore() {
        transaction(SearchHomeFragment.Companion.newInstance(), "tag_search_home");
        ImageButton imageButton = (ImageButton) _$_findCachedViewById(C0010R$id.buttonClear);
        Intrinsics.checkExpressionValueIsNotNull(imageButton, "buttonClear");
        ViewExtensionsKt.gone(imageButton);
    }

    private final void updateViewInput() {
        transaction(SearchHistoryFragment.Companion.newInstance(), "tag_search_history");
        ImageButton imageButton = (ImageButton) _$_findCachedViewById(C0010R$id.buttonClear);
        Intrinsics.checkExpressionValueIsNotNull(imageButton, "buttonClear");
        ViewExtensionsKt.visible(imageButton);
    }

    private final void updateViewAfter(String str) {
        transaction(SearchResultFragment.Companion.newInstance(str), "tag_search_result");
        ImageButton imageButton = (ImageButton) _$_findCachedViewById(C0010R$id.buttonClear);
        Intrinsics.checkExpressionValueIsNotNull(imageButton, "buttonClear");
        ViewExtensionsKt.visible(imageButton);
        EditText editText = (EditText) _$_findCachedViewById(C0010R$id.editSearchKeyword);
        Intrinsics.checkExpressionValueIsNotNull(editText, "editSearchKeyword");
        KeyboardExtensionKt.hideKeyboard((Activity) this, (View) editText);
    }

    public void onKeywordInput(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, SearchResultFragment.KEY_KEYWORD);
        updateKewordInput(str);
    }

    private final void updateKewordInput(String str) {
        ((EditText) _$_findCachedViewById(C0010R$id.editSearchKeyword)).setText(str);
        SearchViewModel searchViewModel = this.viewModel;
        if (searchViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        searchViewModel.searchButtonClick(str, "direct");
    }

    public void onSearchTabSwitch(int i) {
        Fragment currentFragment = FragmentTransactionExtensionKt.getCurrentFragment(this, C0010R$id.searchConatiner);
        if (currentFragment != null && (currentFragment instanceof SearchResultFragment)) {
            ((SearchResultFragment) currentFragment).switchSearchTab(i);
        }
    }

    public void onHistoryDelete() {
        SearchViewModel searchViewModel = this.viewModel;
        if (searchViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        searchViewModel.removeSearchKyeword();
    }

    public void onHistoryClick(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, SearchResultFragment.KEY_KEYWORD);
        ((EditText) _$_findCachedViewById(C0010R$id.editSearchKeyword)).setText(str);
        SearchViewModel searchViewModel = this.viewModel;
        if (searchViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        searchViewModel.searchButtonClick(str, "history");
    }

    private final void transaction(Fragment fragment, String str) {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(str);
        if (findFragmentByTag != null) {
            fragment = findFragmentByTag;
        }
        Intrinsics.checkExpressionValueIsNotNull(fragment, "findFragmentByTag(tag) ?: newFragment");
        supportFragmentManager.popBackStackImmediate(str, 1);
        supportFragmentManager.beginTransaction().replace(C0010R$id.searchConatiner, fragment, str).addToBackStack(str).commit();
    }

    public void onBackPressed() {
        if (FragmentTransactionExtensionKt.getBackstackCount(this) < 2) {
            finish();
        } else {
            super.onBackPressed();
        }
    }

    public void finish() {
        super.finish();
        overridePendingTransition(ActivityAnimationType.SLIDE_DOWN.getEnter(), ActivityAnimationType.SLIDE_DOWN.getExit());
    }
}
