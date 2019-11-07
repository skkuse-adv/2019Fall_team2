package kr.co.popone.fitts.viewmodel.home.follow;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider.Factory;
import androidx.lifecycle.ViewModelProviders;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.feature.post.follow.FollowingPostActivity;
import kr.co.popone.fitts.model.user.UserAPI;
import kr.co.popone.fitts.repository.PostRepository;
import org.jetbrains.annotations.NotNull;

public final class FollowingPostModule {
    @NotNull
    public final FollowingPostViewModel provideHomeViewModel(@NotNull FollowingPostActivity followingPostActivity, @NotNull FollowingPostViewModelFactory followingPostViewModelFactory) {
        Intrinsics.checkParameterIsNotNull(followingPostActivity, "activity");
        Intrinsics.checkParameterIsNotNull(followingPostViewModelFactory, "viewModelFactory");
        ViewModel viewModel = ViewModelProviders.of((FragmentActivity) followingPostActivity, (Factory) followingPostViewModelFactory).get(FollowingPostViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel, "ViewModelProviders.of(ac…stViewModel::class.java)]");
        return (FollowingPostViewModel) viewModel;
    }

    @NotNull
    public final FollowingPostViewModelFactory providesViewModelFactory(@NotNull UserAPI userAPI, @NotNull PostRepository postRepository, @NotNull EventTracker eventTracker, @NotNull SessionManager sessionManager) {
        Intrinsics.checkParameterIsNotNull(userAPI, "userAPI");
        Intrinsics.checkParameterIsNotNull(postRepository, "postRepository");
        Intrinsics.checkParameterIsNotNull(eventTracker, "eventTracker");
        Intrinsics.checkParameterIsNotNull(sessionManager, "sessionManager");
        return new FollowingPostViewModelFactory(userAPI, postRepository, eventTracker, sessionManager);
    }
}
