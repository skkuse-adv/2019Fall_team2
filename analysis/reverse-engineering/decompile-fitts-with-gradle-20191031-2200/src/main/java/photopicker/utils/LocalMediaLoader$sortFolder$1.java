package photopicker.utils;

import java.util.Comparator;
import photopicker.model.LocalMediaFolder;

final class LocalMediaLoader$sortFolder$1<T> implements Comparator<T> {
    public static final LocalMediaLoader$sortFolder$1 INSTANCE = new LocalMediaLoader$sortFolder$1();

    LocalMediaLoader$sortFolder$1() {
    }

    public final int compare(LocalMediaFolder localMediaFolder, LocalMediaFolder localMediaFolder2) {
        int imageNum = localMediaFolder.getImageNum();
        int imageNum2 = localMediaFolder2.getImageNum();
        if (imageNum == imageNum2) {
            return 0;
        }
        return imageNum < imageNum2 ? 1 : -1;
    }
}
