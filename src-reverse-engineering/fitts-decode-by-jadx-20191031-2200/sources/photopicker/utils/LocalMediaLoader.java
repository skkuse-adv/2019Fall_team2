package photopicker.utils;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import photopicker.model.LocalMediaFolder;

public final class LocalMediaLoader {
    /* access modifiers changed from: private */
    public final FragmentActivity activity;
    @NotNull
    private final String[] imageProjection = {"_data", "_display_name", "date_added", "_id"};

    public interface LocalMediaLoadListener {
        void loadComplete(@NotNull List<LocalMediaFolder> list);
    }

    public LocalMediaLoader(@NotNull FragmentActivity fragmentActivity) {
        Intrinsics.checkParameterIsNotNull(fragmentActivity, "activity");
        this.activity = fragmentActivity;
    }

    @NotNull
    public final String[] getImageProjection() {
        return this.imageProjection;
    }

    public final void loadAllImage(@NotNull LocalMediaLoadListener localMediaLoadListener) {
        Intrinsics.checkParameterIsNotNull(localMediaLoadListener, "imageLoadListener");
        this.activity.getSupportLoaderManager().initLoader(1, new Bundle(), new LocalMediaLoader$loadAllImage$1(this, localMediaLoadListener));
    }

    /* access modifiers changed from: private */
    public final void sortFolder(List<LocalMediaFolder> list) {
        Collections.sort(list, LocalMediaLoader$sortFolder$1.INSTANCE);
    }

    /* access modifiers changed from: private */
    public final LocalMediaFolder getImageFolder(String str, List<LocalMediaFolder> list) {
        String str2;
        File parentFile = new File(str).getParentFile();
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (true) {
            str2 = "folderFile";
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            String name = ((LocalMediaFolder) next).getName();
            Intrinsics.checkExpressionValueIsNotNull(parentFile, str2);
            if (Intrinsics.areEqual((Object) name, (Object) parentFile.getName())) {
                arrayList.add(next);
            }
        }
        Iterator it2 = arrayList.iterator();
        if (it2.hasNext()) {
            return (LocalMediaFolder) it2.next();
        }
        LocalMediaFolder localMediaFolder = new LocalMediaFolder();
        Intrinsics.checkExpressionValueIsNotNull(parentFile, str2);
        localMediaFolder.setName(parentFile.getName());
        localMediaFolder.setPath(parentFile.getAbsolutePath());
        localMediaFolder.setFirstImagePath(str);
        return localMediaFolder;
    }
}
