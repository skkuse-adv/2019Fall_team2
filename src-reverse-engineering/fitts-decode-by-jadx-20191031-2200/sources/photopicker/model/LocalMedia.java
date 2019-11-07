package photopicker.model;

import java.io.Serializable;
import org.jetbrains.annotations.Nullable;

public final class LocalMedia implements Serializable {
    private int num;
    @Nullable
    private String path;

    public LocalMedia(@Nullable String str) {
        this.path = str;
    }

    @Nullable
    public final String getPath() {
        return this.path;
    }

    public final void setPath(@Nullable String str) {
        this.path = str;
    }

    public final int getNum() {
        return this.num;
    }

    public final void setNum(int i) {
        this.num = i;
    }
}
