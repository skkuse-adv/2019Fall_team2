package kr.co.popone.fitts.viewmodel.trend;

import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.base.BaseViewModel;
import kr.co.popone.fitts.base.BaseViewModelFactory;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.model.datamodel.social.feed.TrendType;
import kr.co.popone.fitts.model.repository.social.FittsSocialRepository;
import kr.co.popone.fitts.services.FittsSchemeHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class TrendFeedViewModelFactory extends BaseViewModelFactory {
    private final EventTracker eventTracker;
    private final long id;
    private final FittsSchemeHandler schemeHandler;
    private final SessionManager sessionManager;
    private final FittsSocialRepository socialRepository;
    private final TrendType type;

    public TrendFeedViewModelFactory(long j, @Nullable TrendType trendType, @NotNull SessionManager sessionManager2, @NotNull FittsSchemeHandler fittsSchemeHandler, @NotNull EventTracker eventTracker2, @NotNull FittsSocialRepository fittsSocialRepository) {
        Intrinsics.checkParameterIsNotNull(sessionManager2, "sessionManager");
        Intrinsics.checkParameterIsNotNull(fittsSchemeHandler, "schemeHandler");
        Intrinsics.checkParameterIsNotNull(eventTracker2, "eventTracker");
        Intrinsics.checkParameterIsNotNull(fittsSocialRepository, "socialRepository");
        this.id = j;
        this.type = trendType;
        this.sessionManager = sessionManager2;
        this.schemeHandler = fittsSchemeHandler;
        this.eventTracker = eventTracker2;
        this.socialRepository = fittsSocialRepository;
    }

    /* access modifiers changed from: protected */
    @NotNull
    public BaseViewModel createViewModel() {
        TrendFeedViewModel trendFeedViewModel = new TrendFeedViewModel(this.id, this.type, this.sessionManager, this.schemeHandler, this.eventTracker, this.socialRepository);
        return trendFeedViewModel;
    }
}
