package kr.co.popone.fitts.viewmodel.home.feed;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider.Factory;
import androidx.lifecycle.ViewModelProviders;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.feature.home.feed.HomeFeedFragment;
import kr.co.popone.fitts.model.repository.social.FittsSocialRepository;
import kr.co.popone.fitts.services.FittsSchemeHandler;
import kr.co.popone.fitts.viewmodel.home.feed.HomeFeedViewModel.FeedType;
import org.jetbrains.annotations.NotNull;

public final class HomeFeedModule {
    @NotNull
    public final HomeFeedViewModel provideHomeFeedViewModel(@NotNull HomeFeedFragment homeFeedFragment, @NotNull HomeFeedViewModelFactory homeFeedViewModelFactory) {
        Intrinsics.checkParameterIsNotNull(homeFeedFragment, "fragment");
        Intrinsics.checkParameterIsNotNull(homeFeedViewModelFactory, "viewModelFactory");
        ViewModel viewModel = ViewModelProviders.of((Fragment) homeFeedFragment, (Factory) homeFeedViewModelFactory).get(HomeFeedViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel, "ViewModelProviders.of(fr…edViewModel::class.java)]");
        return (HomeFeedViewModel) viewModel;
    }

    @NotNull
    public final HomeFeedViewModelFactory providesViewModelFactory(@NotNull HomeFeedFragment homeFeedFragment, @NotNull FittsSocialRepository fittsSocialRepository, @NotNull FittsSchemeHandler fittsSchemeHandler, @NotNull EventTracker eventTracker, @NotNull SessionManager sessionManager) {
        Intrinsics.checkParameterIsNotNull(homeFeedFragment, "fragment");
        Intrinsics.checkParameterIsNotNull(fittsSocialRepository, "socialRepository");
        Intrinsics.checkParameterIsNotNull(fittsSchemeHandler, "schemeHandler");
        Intrinsics.checkParameterIsNotNull(eventTracker, "eventTracker");
        Intrinsics.checkParameterIsNotNull(sessionManager, "sessionManager");
        HomeFeedViewModelFactory homeFeedViewModelFactory = new HomeFeedViewModelFactory(fittsSocialRepository, fittsSchemeHandler, eventTracker, sessionManager, getHomeFeedType(homeFeedFragment));
        return homeFeedViewModelFactory;
    }

    private final FeedType getHomeFeedType(HomeFeedFragment homeFeedFragment) {
        Bundle arguments = homeFeedFragment.getArguments();
        if (arguments != null) {
            String str = HomeFeedFragment.KEY_FEED_REQUEST_TYPE;
            FeedType feedType = FeedType.MY;
            try {
                String string = arguments.getString(str);
                Intrinsics.checkExpressionValueIsNotNull(string, "getString(key)");
                feedType = FeedType.valueOf(string);
            } catch (Exception unused) {
            }
            if (feedType != null) {
                return feedType;
            }
        }
        return FeedType.MY;
    }
}
