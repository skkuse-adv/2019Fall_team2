package photopicker.view;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.utils.DataHolderManager;

public final class ImageSelectorActivity_MembersInjector implements MembersInjector<ImageSelectorActivity> {
    private final Provider<DataHolderManager> dataHolderManagerProvider;

    public ImageSelectorActivity_MembersInjector(Provider<DataHolderManager> provider) {
        this.dataHolderManagerProvider = provider;
    }

    public static MembersInjector<ImageSelectorActivity> create(Provider<DataHolderManager> provider) {
        return new ImageSelectorActivity_MembersInjector(provider);
    }

    public void injectMembers(ImageSelectorActivity imageSelectorActivity) {
        injectDataHolderManager(imageSelectorActivity, (DataHolderManager) this.dataHolderManagerProvider.get());
    }

    public static void injectDataHolderManager(ImageSelectorActivity imageSelectorActivity, DataHolderManager dataHolderManager) {
        imageSelectorActivity.dataHolderManager = dataHolderManager;
    }
}
