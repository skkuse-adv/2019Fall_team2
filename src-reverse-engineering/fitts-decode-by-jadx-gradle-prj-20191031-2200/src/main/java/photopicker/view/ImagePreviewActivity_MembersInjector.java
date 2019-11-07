package photopicker.view;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.utils.DataHolderManager;

public final class ImagePreviewActivity_MembersInjector implements MembersInjector<ImagePreviewActivity> {
    private final Provider<DataHolderManager> dataHolderManagerProvider;

    public ImagePreviewActivity_MembersInjector(Provider<DataHolderManager> provider) {
        this.dataHolderManagerProvider = provider;
    }

    public static MembersInjector<ImagePreviewActivity> create(Provider<DataHolderManager> provider) {
        return new ImagePreviewActivity_MembersInjector(provider);
    }

    public void injectMembers(ImagePreviewActivity imagePreviewActivity) {
        injectDataHolderManager(imagePreviewActivity, (DataHolderManager) this.dataHolderManagerProvider.get());
    }

    public static void injectDataHolderManager(ImagePreviewActivity imagePreviewActivity, DataHolderManager dataHolderManager) {
        imagePreviewActivity.dataHolderManager = dataHolderManager;
    }
}
