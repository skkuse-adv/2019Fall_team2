package kr.co.popone.fitts.feature.post.upload.create;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.feature.post.upload.viewmodel.CreatePostViewModel;

public final class CreatePostActivity_MembersInjector implements MembersInjector<CreatePostActivity> {
    private final Provider<CreatePostViewModel> viewModelProvider;

    public CreatePostActivity_MembersInjector(Provider<CreatePostViewModel> provider) {
        this.viewModelProvider = provider;
    }

    public static MembersInjector<CreatePostActivity> create(Provider<CreatePostViewModel> provider) {
        return new CreatePostActivity_MembersInjector(provider);
    }

    public void injectMembers(CreatePostActivity createPostActivity) {
        injectViewModel(createPostActivity, (CreatePostViewModel) this.viewModelProvider.get());
    }

    public static void injectViewModel(CreatePostActivity createPostActivity, CreatePostViewModel createPostViewModel) {
        createPostActivity.viewModel = createPostViewModel;
    }
}
