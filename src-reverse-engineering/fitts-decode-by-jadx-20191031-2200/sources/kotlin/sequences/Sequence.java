package kotlin.sequences;

import java.util.Iterator;
import org.jetbrains.annotations.NotNull;

public interface Sequence<T> {
    @NotNull
    Iterator<T> iterator();
}
