package kr.co.popone.fitts.viewmodel.trend;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider.Factory;
import androidx.lifecycle.ViewModelProviders;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.feature.trend.TrendFeedActivity;
import kr.co.popone.fitts.model.datamodel.social.feed.TrendTypeKt;
import kr.co.popone.fitts.model.repository.social.FittsSocialRepository;
import kr.co.popone.fitts.services.FittsSchemeHandler;
import org.jetbrains.annotations.NotNull;

public final class TrendFeedModule {
    @NotNull
    public final TrendFeedViewModel provideStoreViewModel(@NotNull TrendFeedActivity trendFeedActivity, @NotNull TrendFeedViewModelFactory trendFeedViewModelFactory) {
        Intrinsics.checkParameterIsNotNull(trendFeedActivity, "activity");
        Intrinsics.checkParameterIsNotNull(trendFeedViewModelFactory, "viewModelFactory");
        ViewModel viewModel = ViewModelProviders.of((FragmentActivity) trendFeedActivity, (Factory) trendFeedViewModelFactory).get(TrendFeedViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel, "ViewModelProviders.of(ac…edViewModel::class.java)]");
        return (TrendFeedViewModel) viewModel;
    }

    @NotNull
    public final TrendFeedViewModelFactory providesViewModelFactory(@NotNull TrendFeedActivity trendFeedActivity, @NotNull SessionManager sessionManager, @NotNull FittsSchemeHandler fittsSchemeHandler, @NotNull EventTracker eventTracker, @NotNull FittsSocialRepository fittsSocialRepository) {
        Intrinsics.checkParameterIsNotNull(trendFeedActivity, "activity");
        Intrinsics.checkParameterIsNotNull(sessionManager, "sessionManager");
        Intrinsics.checkParameterIsNotNull(fittsSchemeHandler, "schemeHandler");
        Intrinsics.checkParameterIsNotNull(eventTracker, "eventTracker");
        Intrinsics.checkParameterIsNotNull(fittsSocialRepository, "socialRepository");
        long longExtra = trendFeedActivity.getIntent().getLongExtra(TrendFeedActivity.KEY_TREND_ID, -1);
        String stringExtra = trendFeedActivity.getIntent().getStringExtra(TrendFeedActivity.KEY_TREND_TYPE);
        Intrinsics.checkExpressionValueIsNotNull(stringExtra, "type");
        TrendFeedViewModelFactory trendFeedViewModelFactory = new TrendFeedViewModelFactory(longExtra, TrendTypeKt.toTrendType(stringExtra), sessionManager, fittsSchemeHandler, eventTracker, fittsSocialRepository);
        return trendFeedViewModelFactory;
    }
}
