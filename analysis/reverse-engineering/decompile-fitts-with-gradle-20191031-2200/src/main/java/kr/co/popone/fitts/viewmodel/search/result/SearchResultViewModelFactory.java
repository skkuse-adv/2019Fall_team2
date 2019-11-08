package kr.co.popone.fitts.viewmodel.search.result;

import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.base.BaseViewModel;
import kr.co.popone.fitts.base.BaseViewModelFactory;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.feature.search.view.SearchResultFragment;
import kr.co.popone.fitts.model.log.ActionLogAPI;
import kr.co.popone.fitts.repository.SearchRepository;
import kr.co.popone.fitts.repository.UserRepository;
import org.jetbrains.annotations.NotNull;

public final class SearchResultViewModelFactory extends BaseViewModelFactory {
    @NotNull
    private final ActionLogAPI actionLog;
    @NotNull
    private final EventTracker eventTracker;
    @NotNull
    private final String keyword;
    @NotNull
    private final SearchRepository searchRepository;
    @NotNull
    private final UserRepository userRepository;

    @NotNull
    public final String getKeyword() {
        return this.keyword;
    }

    @NotNull
    public final SearchRepository getSearchRepository() {
        return this.searchRepository;
    }

    @NotNull
    public final UserRepository getUserRepository() {
        return this.userRepository;
    }

    @NotNull
    public final EventTracker getEventTracker() {
        return this.eventTracker;
    }

    @NotNull
    public final ActionLogAPI getActionLog() {
        return this.actionLog;
    }

    public SearchResultViewModelFactory(@NotNull String str, @NotNull SearchRepository searchRepository2, @NotNull UserRepository userRepository2, @NotNull EventTracker eventTracker2, @NotNull ActionLogAPI actionLogAPI) {
        Intrinsics.checkParameterIsNotNull(str, SearchResultFragment.KEY_KEYWORD);
        Intrinsics.checkParameterIsNotNull(searchRepository2, "searchRepository");
        Intrinsics.checkParameterIsNotNull(userRepository2, "userRepository");
        Intrinsics.checkParameterIsNotNull(eventTracker2, "eventTracker");
        Intrinsics.checkParameterIsNotNull(actionLogAPI, "actionLog");
        this.keyword = str;
        this.searchRepository = searchRepository2;
        this.userRepository = userRepository2;
        this.eventTracker = eventTracker2;
        this.actionLog = actionLogAPI;
    }

    /* access modifiers changed from: protected */
    @NotNull
    public BaseViewModel createViewModel() {
        SearchResultViewModel searchResultViewModel = new SearchResultViewModel(this.keyword, this.searchRepository, this.userRepository, this.eventTracker, this.actionLog);
        return searchResultViewModel;
    }
}
