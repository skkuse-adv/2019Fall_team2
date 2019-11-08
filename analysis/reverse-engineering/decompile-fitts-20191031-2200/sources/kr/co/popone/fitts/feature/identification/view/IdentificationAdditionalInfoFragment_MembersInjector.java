package kr.co.popone.fitts.feature.identification.view;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.feature.identification.viewmodel.IdentificationAdditionalInfoViewModel;

public final class IdentificationAdditionalInfoFragment_MembersInjector implements MembersInjector<IdentificationAdditionalInfoFragment> {
    private final Provider<IdentificationAdditionalInfoViewModel> viewModelProvider;

    public IdentificationAdditionalInfoFragment_MembersInjector(Provider<IdentificationAdditionalInfoViewModel> provider) {
        this.viewModelProvider = provider;
    }

    public static MembersInjector<IdentificationAdditionalInfoFragment> create(Provider<IdentificationAdditionalInfoViewModel> provider) {
        return new IdentificationAdditionalInfoFragment_MembersInjector(provider);
    }

    public void injectMembers(IdentificationAdditionalInfoFragment identificationAdditionalInfoFragment) {
        injectViewModel(identificationAdditionalInfoFragment, (IdentificationAdditionalInfoViewModel) this.viewModelProvider.get());
    }

    public static void injectViewModel(IdentificationAdditionalInfoFragment identificationAdditionalInfoFragment, IdentificationAdditionalInfoViewModel identificationAdditionalInfoViewModel) {
        identificationAdditionalInfoFragment.viewModel = identificationAdditionalInfoViewModel;
    }
}
