package kr.co.popone.fitts.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.feature.post.upload.viewmodel.CreatePostViewModel;
import kr.co.popone.fitts.model.post.PostAPI;

public final class CreatePostModule_ProvideCreatePostViewModelFactory implements Factory<CreatePostViewModel> {
    private final Provider<EventTracker> eventTrackerProvider;
    private final CreatePostModule module;
    private final Provider<PostAPI> postAPIProvider;
    private final Provider<SessionManager> sessionManagerProvider;

    public CreatePostModule_ProvideCreatePostViewModelFactory(CreatePostModule createPostModule, Provider<SessionManager> provider, Provider<EventTracker> provider2, Provider<PostAPI> provider3) {
        this.module = createPostModule;
        this.sessionManagerProvider = provider;
        this.eventTrackerProvider = provider2;
        this.postAPIProvider = provider3;
    }

    public CreatePostViewModel get() {
        return provideInstance(this.module, this.sessionManagerProvider, this.eventTrackerProvider, this.postAPIProvider);
    }

    public static CreatePostViewModel provideInstance(CreatePostModule createPostModule, Provider<SessionManager> provider, Provider<EventTracker> provider2, Provider<PostAPI> provider3) {
        return proxyProvideCreatePostViewModel(createPostModule, (SessionManager) provider.get(), (EventTracker) provider2.get(), (PostAPI) provider3.get());
    }

    public static CreatePostModule_ProvideCreatePostViewModelFactory create(CreatePostModule createPostModule, Provider<SessionManager> provider, Provider<EventTracker> provider2, Provider<PostAPI> provider3) {
        return new CreatePostModule_ProvideCreatePostViewModelFactory(createPostModule, provider, provider2, provider3);
    }

    public static CreatePostViewModel proxyProvideCreatePostViewModel(CreatePostModule createPostModule, SessionManager sessionManager, EventTracker eventTracker, PostAPI postAPI) {
        return (CreatePostViewModel) Preconditions.checkNotNull(createPostModule.provideCreatePostViewModel(sessionManager, eventTracker, postAPI), "Cannot return null from a non-@Nullable @Provides method");
    }
}
