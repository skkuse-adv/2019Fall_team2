package kotlin.reflect;

import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface KType extends KAnnotatedElement {
    @NotNull
    List<Object> getArguments();

    @Nullable
    KClassifier getClassifier();

    boolean isMarkedNullable();
}
