package kotlin.text;

import java.util.Collection;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.Nullable;

public interface MatchGroupCollection extends Collection<MatchGroup>, KMappedMarker {
    @Nullable
    MatchGroup get(int i);
}
