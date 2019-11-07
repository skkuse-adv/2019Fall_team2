package kotlin.reflect;

import java.util.Collection;
import org.jetbrains.annotations.NotNull;

public interface KDeclarationContainer {
    @NotNull
    Collection<KCallable<?>> getMembers();
}
