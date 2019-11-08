package kr.co.popone.fitts.di.module;

import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.feature.post.upload.viewmodel.CreatePostViewModel;
import kr.co.popone.fitts.model.post.PostAPI;
import org.jetbrains.annotations.NotNull;

public final class CreatePostModule {
    @NotNull
    public final CreatePostViewModel provideCreatePostViewModel(@NotNull SessionManager sessionManager, @NotNull EventTracker eventTracker, @NotNull PostAPI postAPI) {
        Intrinsics.checkParameterIsNotNull(sessionManager, "sessionManager");
        Intrinsics.checkParameterIsNotNull(eventTracker, "eventTracker");
        Intrinsics.checkParameterIsNotNull(postAPI, "postAPI");
        return new CreatePostViewModel(sessionManager, eventTracker, postAPI);
    }
}
