package photopicker.model;

import java.io.Serializable;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class LocalMediaFolder implements Serializable {
    @Nullable
    private String firstImagePath;
    private int imageNum;
    @NotNull
    private ArrayList<LocalMedia> images = new ArrayList<>();
    @Nullable
    private String name;
    @Nullable
    private String path;

    @Nullable
    public final String getName() {
        return this.name;
    }

    public final void setName(@Nullable String str) {
        this.name = str;
    }

    @Nullable
    public final String getPath() {
        return this.path;
    }

    public final void setPath(@Nullable String str) {
        this.path = str;
    }

    @Nullable
    public final String getFirstImagePath() {
        return this.firstImagePath;
    }

    public final void setFirstImagePath(@Nullable String str) {
        this.firstImagePath = str;
    }

    public final int getImageNum() {
        return this.imageNum;
    }

    public final void setImageNum(int i) {
        this.imageNum = i;
    }

    @NotNull
    public final ArrayList<LocalMedia> getImages() {
        return this.images;
    }

    public final void setImages(@NotNull ArrayList<LocalMedia> arrayList) {
        Intrinsics.checkParameterIsNotNull(arrayList, "<set-?>");
        this.images = arrayList;
    }
}
