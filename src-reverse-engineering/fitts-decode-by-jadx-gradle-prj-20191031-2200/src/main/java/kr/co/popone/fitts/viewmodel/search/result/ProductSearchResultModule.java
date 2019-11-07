package kr.co.popone.fitts.viewmodel.search.result;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider.Factory;
import androidx.lifecycle.ViewModelProviders;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.search.view.ProductSearchResultFragment;
import org.jetbrains.annotations.NotNull;

public final class ProductSearchResultModule {
    @NotNull
    public final SearchResultViewModel provideStoreViewModel(@NotNull ProductSearchResultFragment productSearchResultFragment, @NotNull SearchResultViewModelFactory searchResultViewModelFactory) {
        Intrinsics.checkParameterIsNotNull(productSearchResultFragment, "fragment");
        Intrinsics.checkParameterIsNotNull(searchResultViewModelFactory, "viewModelFactory");
        Fragment parentFragment = productSearchResultFragment.getParentFragment();
        if (parentFragment == null) {
            Intrinsics.throwNpe();
        }
        ViewModel viewModel = ViewModelProviders.of(parentFragment, (Factory) searchResultViewModelFactory).get(SearchResultViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel, "ViewModelProviders.of(fr…ltViewModel::class.java)]");
        return (SearchResultViewModel) viewModel;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x002b, code lost:
        if (r7 != null) goto L_0x0030;
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kr.co.popone.fitts.viewmodel.search.result.SearchResultViewModelFactory providesViewModelFactory(@org.jetbrains.annotations.NotNull kr.co.popone.fitts.feature.search.view.ProductSearchResultFragment r7, @org.jetbrains.annotations.NotNull kr.co.popone.fitts.repository.SearchRepository r8, @org.jetbrains.annotations.NotNull kr.co.popone.fitts.repository.UserRepository r9, @org.jetbrains.annotations.NotNull kr.co.popone.fitts.eventtracker.EventTracker r10, @org.jetbrains.annotations.NotNull kr.co.popone.fitts.model.log.ActionLogAPI r11) {
        /*
            r6 = this;
            java.lang.String r0 = "fragment"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r7, r0)
            java.lang.String r0 = "searchRepository"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r8, r0)
            java.lang.String r0 = "userRepository"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r9, r0)
            java.lang.String r0 = "eventTracker"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r10, r0)
            java.lang.String r0 = "actionLog"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r11, r0)
            androidx.fragment.app.Fragment r7 = r7.getParentFragment()
            if (r7 == 0) goto L_0x002e
            android.os.Bundle r7 = r7.getArguments()
            if (r7 == 0) goto L_0x002e
            java.lang.String r0 = "keyword"
            java.lang.String r7 = r7.getString(r0)
            if (r7 == 0) goto L_0x002e
            goto L_0x0030
        L_0x002e:
            java.lang.String r7 = ""
        L_0x0030:
            r1 = r7
            kr.co.popone.fitts.viewmodel.search.result.SearchResultViewModelFactory r7 = new kr.co.popone.fitts.viewmodel.search.result.SearchResultViewModelFactory
            r0 = r7
            r2 = r8
            r3 = r9
            r4 = r10
            r5 = r11
            r0.<init>(r1, r2, r3, r4, r5)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.viewmodel.search.result.ProductSearchResultModule.providesViewModelFactory(kr.co.popone.fitts.feature.search.view.ProductSearchResultFragment, kr.co.popone.fitts.repository.SearchRepository, kr.co.popone.fitts.repository.UserRepository, kr.co.popone.fitts.eventtracker.EventTracker, kr.co.popone.fitts.model.log.ActionLogAPI):kr.co.popone.fitts.viewmodel.search.result.SearchResultViewModelFactory");
    }
}
