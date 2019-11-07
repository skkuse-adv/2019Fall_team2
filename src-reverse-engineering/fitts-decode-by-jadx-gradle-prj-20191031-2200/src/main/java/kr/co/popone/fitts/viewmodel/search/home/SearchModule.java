package kr.co.popone.fitts.viewmodel.search.home;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider.Factory;
import androidx.lifecycle.ViewModelProviders;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.feature.search.view.SearchActivity;
import kr.co.popone.fitts.model.search.SearchHistoryRepository;
import kr.co.popone.fitts.repository.SearchRepository;
import org.jetbrains.annotations.NotNull;

public final class SearchModule {
    @NotNull
    public final SearchViewModel provideHomeViewModel(@NotNull SearchActivity searchActivity, @NotNull SearchViewModelFactory searchViewModelFactory) {
        Intrinsics.checkParameterIsNotNull(searchActivity, "activity");
        Intrinsics.checkParameterIsNotNull(searchViewModelFactory, "viewModelFactory");
        ViewModel viewModel = ViewModelProviders.of((FragmentActivity) searchActivity, (Factory) searchViewModelFactory).get(SearchViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel, "ViewModelProviders.of(ac…chViewModel::class.java)]");
        return (SearchViewModel) viewModel;
    }

    @NotNull
    public final SearchViewModelFactory providesViewModelFactory(@NotNull EventTracker eventTracker, @NotNull SearchRepository searchRepository, @NotNull SearchHistoryRepository searchHistoryRepository) {
        Intrinsics.checkParameterIsNotNull(eventTracker, "eventTracker");
        Intrinsics.checkParameterIsNotNull(searchRepository, "searchRepository");
        Intrinsics.checkParameterIsNotNull(searchHistoryRepository, "searchHistoryRepository");
        return new SearchViewModelFactory(eventTracker, searchRepository, searchHistoryRepository);
    }
}
