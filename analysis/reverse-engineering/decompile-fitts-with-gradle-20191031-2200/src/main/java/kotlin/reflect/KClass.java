package kotlin.reflect;

import java.util.Collection;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface KClass<T> extends KDeclarationContainer, KAnnotatedElement, KClassifier {
    boolean equals(@Nullable Object obj);

    @NotNull
    Collection<KFunction<T>> getConstructors();

    @NotNull
    Collection<KCallable<?>> getMembers();

    @NotNull
    Collection<KClass<?>> getNestedClasses();

    @Nullable
    T getObjectInstance();

    @Nullable
    String getQualifiedName();

    @NotNull
    List<KClass<? extends T>> getSealedSubclasses();

    @Nullable
    String getSimpleName();

    @NotNull
    List<KType> getSupertypes();

    @NotNull
    List<Object> getTypeParameters();

    @Nullable
    KVisibility getVisibility();

    int hashCode();

    boolean isAbstract();

    boolean isCompanion();

    boolean isData();

    boolean isFinal();

    boolean isInner();

    boolean isInstance(@Nullable Object obj);

    boolean isOpen();

    boolean isSealed();
}
