package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class Empty implements Incomplete {
    private final boolean isActive;

    @Nullable
    public NodeList getList() {
        return null;
    }

    public Empty(boolean z) {
        this.isActive = z;
    }

    public boolean isActive() {
        return this.isActive;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Empty{");
        sb.append(isActive() ? "Active" : "New");
        sb.append('}');
        return sb.toString();
    }
}
