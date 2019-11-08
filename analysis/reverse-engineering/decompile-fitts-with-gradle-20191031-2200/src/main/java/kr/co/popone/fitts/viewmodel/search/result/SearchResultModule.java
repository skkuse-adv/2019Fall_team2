package kr.co.popone.fitts.viewmodel.search.result;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider.Factory;
import androidx.lifecycle.ViewModelProviders;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.feature.search.view.SearchResultFragment;
import kr.co.popone.fitts.model.log.ActionLogAPI;
import kr.co.popone.fitts.repository.SearchRepository;
import kr.co.popone.fitts.repository.UserRepository;
import org.jetbrains.annotations.NotNull;

public final class SearchResultModule {
    @NotNull
    public final SearchResultViewModel provideStoreViewModel(@NotNull SearchResultFragment searchResultFragment, @NotNull SearchResultViewModelFactory searchResultViewModelFactory) {
        Intrinsics.checkParameterIsNotNull(searchResultFragment, "fragment");
        Intrinsics.checkParameterIsNotNull(searchResultViewModelFactory, "viewModelFactory");
        ViewModel viewModel = ViewModelProviders.of((Fragment) searchResultFragment, (Factory) searchResultViewModelFactory).get(SearchResultViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel, "ViewModelProviders.of(fr…ltViewModel::class.java)]");
        return (SearchResultViewModel) viewModel;
    }

    @NotNull
    public final SearchResultViewModelFactory providesViewModelFactory(@NotNull SearchResultFragment searchResultFragment, @NotNull SearchRepository searchRepository, @NotNull UserRepository userRepository, @NotNull EventTracker eventTracker, @NotNull ActionLogAPI actionLogAPI) {
        String str;
        Intrinsics.checkParameterIsNotNull(searchResultFragment, "fragment");
        Intrinsics.checkParameterIsNotNull(searchRepository, "searchRepository");
        Intrinsics.checkParameterIsNotNull(userRepository, "userRepository");
        Intrinsics.checkParameterIsNotNull(eventTracker, "eventTracker");
        Intrinsics.checkParameterIsNotNull(actionLogAPI, "actionLog");
        Bundle arguments = searchResultFragment.getArguments();
        String str2 = "";
        if (arguments != null) {
            String string = arguments.getString(SearchResultFragment.KEY_KEYWORD, str2);
            if (string != null) {
                str = string;
                SearchResultViewModelFactory searchResultViewModelFactory = new SearchResultViewModelFactory(str, searchRepository, userRepository, eventTracker, actionLogAPI);
                return searchResultViewModelFactory;
            }
        }
        str = str2;
        SearchResultViewModelFactory searchResultViewModelFactory2 = new SearchResultViewModelFactory(str, searchRepository, userRepository, eventTracker, actionLogAPI);
        return searchResultViewModelFactory2;
    }
}
