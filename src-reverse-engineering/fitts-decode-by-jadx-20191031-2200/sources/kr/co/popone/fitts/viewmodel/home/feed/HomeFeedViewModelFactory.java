package kr.co.popone.fitts.viewmodel.home.feed;

import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.base.BaseViewModel;
import kr.co.popone.fitts.base.BaseViewModelFactory;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.model.repository.social.FittsSocialRepository;
import kr.co.popone.fitts.services.FittsSchemeHandler;
import kr.co.popone.fitts.viewmodel.home.feed.HomeFeedViewModel.FeedType;
import org.jetbrains.annotations.NotNull;

public final class HomeFeedViewModelFactory extends BaseViewModelFactory {
    @NotNull
    private final EventTracker eventTracker;
    private final FeedType homeFeedType;
    @NotNull
    private final FittsSchemeHandler schemeHandler;
    @NotNull
    private final SessionManager sessionManager;
    private final FittsSocialRepository socialRepository;

    @NotNull
    public final FittsSchemeHandler getSchemeHandler() {
        return this.schemeHandler;
    }

    @NotNull
    public final EventTracker getEventTracker() {
        return this.eventTracker;
    }

    @NotNull
    public final SessionManager getSessionManager() {
        return this.sessionManager;
    }

    public HomeFeedViewModelFactory(@NotNull FittsSocialRepository fittsSocialRepository, @NotNull FittsSchemeHandler fittsSchemeHandler, @NotNull EventTracker eventTracker2, @NotNull SessionManager sessionManager2, @NotNull FeedType feedType) {
        Intrinsics.checkParameterIsNotNull(fittsSocialRepository, "socialRepository");
        Intrinsics.checkParameterIsNotNull(fittsSchemeHandler, "schemeHandler");
        Intrinsics.checkParameterIsNotNull(eventTracker2, "eventTracker");
        Intrinsics.checkParameterIsNotNull(sessionManager2, "sessionManager");
        Intrinsics.checkParameterIsNotNull(feedType, "homeFeedType");
        this.socialRepository = fittsSocialRepository;
        this.schemeHandler = fittsSchemeHandler;
        this.eventTracker = eventTracker2;
        this.sessionManager = sessionManager2;
        this.homeFeedType = feedType;
    }

    /* access modifiers changed from: protected */
    @NotNull
    public BaseViewModel createViewModel() {
        HomeFeedViewModel homeFeedViewModel = new HomeFeedViewModel(this.socialRepository, this.schemeHandler, this.eventTracker, this.sessionManager, this.homeFeedType);
        return homeFeedViewModel;
    }
}
