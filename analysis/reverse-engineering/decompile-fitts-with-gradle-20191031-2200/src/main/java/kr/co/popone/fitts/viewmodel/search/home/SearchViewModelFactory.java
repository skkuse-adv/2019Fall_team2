package kr.co.popone.fitts.viewmodel.search.home;

import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.base.BaseViewModel;
import kr.co.popone.fitts.base.BaseViewModelFactory;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.model.search.SearchHistoryRepository;
import kr.co.popone.fitts.repository.SearchRepository;
import org.jetbrains.annotations.NotNull;

public final class SearchViewModelFactory extends BaseViewModelFactory {
    private final EventTracker eventTracker;
    private final SearchHistoryRepository searchHistoryRepository;
    private final SearchRepository searchRepository;

    public SearchViewModelFactory(@NotNull EventTracker eventTracker2, @NotNull SearchRepository searchRepository2, @NotNull SearchHistoryRepository searchHistoryRepository2) {
        Intrinsics.checkParameterIsNotNull(eventTracker2, "eventTracker");
        Intrinsics.checkParameterIsNotNull(searchRepository2, "searchRepository");
        Intrinsics.checkParameterIsNotNull(searchHistoryRepository2, "searchHistoryRepository");
        this.eventTracker = eventTracker2;
        this.searchRepository = searchRepository2;
        this.searchHistoryRepository = searchHistoryRepository2;
    }

    /* access modifiers changed from: protected */
    @NotNull
    public BaseViewModel createViewModel() {
        return new SearchViewModel(this.eventTracker, this.searchRepository, this.searchHistoryRepository);
    }
}
