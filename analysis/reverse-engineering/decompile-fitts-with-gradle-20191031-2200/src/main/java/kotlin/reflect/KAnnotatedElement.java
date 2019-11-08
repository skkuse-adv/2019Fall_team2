package kotlin.reflect;

import java.lang.annotation.Annotation;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public interface KAnnotatedElement {
    @NotNull
    List<Annotation> getAnnotations();
}
