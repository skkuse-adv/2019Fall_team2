package kr.co.popone.fitts.viewmodel.search.home;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider.Factory;
import androidx.lifecycle.ViewModelProviders;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.feature.search.view.SearchHistoryFragment;
import kr.co.popone.fitts.model.search.SearchHistoryRepository;
import kr.co.popone.fitts.repository.SearchRepository;
import org.jetbrains.annotations.NotNull;

public final class SearchHistoryModule {
    @NotNull
    public final SearchViewModel provideHomeViewModel(@NotNull SearchHistoryFragment searchHistoryFragment, @NotNull SearchViewModelFactory searchViewModelFactory) {
        Intrinsics.checkParameterIsNotNull(searchHistoryFragment, "fragment");
        Intrinsics.checkParameterIsNotNull(searchViewModelFactory, "viewModelFactory");
        FragmentActivity activity = searchHistoryFragment.getActivity();
        if (activity == null) {
            Intrinsics.throwNpe();
        }
        ViewModel viewModel = ViewModelProviders.of(activity, (Factory) searchViewModelFactory).get(SearchViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel, "ViewModelProviders.of(fr…chViewModel::class.java)]");
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
