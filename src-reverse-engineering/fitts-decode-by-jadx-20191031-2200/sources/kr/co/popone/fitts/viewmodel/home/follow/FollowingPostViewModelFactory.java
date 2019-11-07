package kr.co.popone.fitts.viewmodel.home.follow;

import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.base.BaseViewModel;
import kr.co.popone.fitts.base.BaseViewModelFactory;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.model.user.UserAPI;
import kr.co.popone.fitts.repository.PostRepository;
import org.jetbrains.annotations.NotNull;

public final class FollowingPostViewModelFactory extends BaseViewModelFactory {
    private final EventTracker eventTracker;
    private final PostRepository postRepository;
    private final SessionManager sessionManager;
    private final UserAPI userAPI;

    public FollowingPostViewModelFactory(@NotNull UserAPI userAPI2, @NotNull PostRepository postRepository2, @NotNull EventTracker eventTracker2, @NotNull SessionManager sessionManager2) {
        Intrinsics.checkParameterIsNotNull(userAPI2, "userAPI");
        Intrinsics.checkParameterIsNotNull(postRepository2, "postRepository");
        Intrinsics.checkParameterIsNotNull(eventTracker2, "eventTracker");
        Intrinsics.checkParameterIsNotNull(sessionManager2, "sessionManager");
        this.userAPI = userAPI2;
        this.postRepository = postRepository2;
        this.eventTracker = eventTracker2;
        this.sessionManager = sessionManager2;
    }

    /* access modifiers changed from: protected */
    @NotNull
    public BaseViewModel createViewModel() {
        return new FollowingPostViewModel(this.userAPI, this.postRepository, this.eventTracker, this.sessionManager);
    }
}
