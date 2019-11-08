package kotlinx.coroutines;

import org.jetbrains.annotations.Nullable;

public interface Incomplete {
    @Nullable
    NodeList getList();

    boolean isActive();
}
