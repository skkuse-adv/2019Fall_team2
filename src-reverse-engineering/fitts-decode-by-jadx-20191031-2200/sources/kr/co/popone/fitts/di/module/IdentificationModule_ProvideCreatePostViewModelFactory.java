package kr.co.popone.fitts.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.feature.identification.viewmodel.IdentificationAdditionalInfoViewModel;
import kr.co.popone.fitts.model.user.UserAPI;

public final class IdentificationModule_ProvideCreatePostViewModelFactory implements Factory<IdentificationAdditionalInfoViewModel> {
    private final IdentificationModule module;
    private final Provider<UserAPI> userApiProvider;

    public IdentificationModule_ProvideCreatePostViewModelFactory(IdentificationModule identificationModule, Provider<UserAPI> provider) {
        this.module = identificationModule;
        this.userApiProvider = provider;
    }

    public IdentificationAdditionalInfoViewModel get() {
        return provideInstance(this.module, this.userApiProvider);
    }

    public static IdentificationAdditionalInfoViewModel provideInstance(IdentificationModule identificationModule, Provider<UserAPI> provider) {
        return proxyProvideCreatePostViewModel(identificationModule, (UserAPI) provider.get());
    }

    public static IdentificationModule_ProvideCreatePostViewModelFactory create(IdentificationModule identificationModule, Provider<UserAPI> provider) {
        return new IdentificationModule_ProvideCreatePostViewModelFactory(identificationModule, provider);
    }

    public static IdentificationAdditionalInfoViewModel proxyProvideCreatePostViewModel(IdentificationModule identificationModule, UserAPI userAPI) {
        return (IdentificationAdditionalInfoViewModel) Preconditions.checkNotNull(identificationModule.provideCreatePostViewModel(userAPI), "Cannot return null from a non-@Nullable @Provides method");
    }
}
