package kotlin.jvm.internal;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.KotlinReflectionNotSupportedError;
import kotlin.reflect.KCallable;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;
import kotlin.reflect.KType;
import kotlin.reflect.KVisibility;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ClassReference implements KClass<Object>, ClassBasedDeclarationContainer {
    @NotNull
    private final Class<?> jClass;

    public static /* synthetic */ void isAbstract$annotations() {
    }

    public static /* synthetic */ void isCompanion$annotations() {
    }

    public static /* synthetic */ void isData$annotations() {
    }

    public static /* synthetic */ void isFinal$annotations() {
    }

    public static /* synthetic */ void isInner$annotations() {
    }

    public static /* synthetic */ void isOpen$annotations() {
    }

    public static /* synthetic */ void isSealed$annotations() {
    }

    public static /* synthetic */ void sealedSubclasses$annotations() {
    }

    public static /* synthetic */ void supertypes$annotations() {
    }

    public static /* synthetic */ void typeParameters$annotations() {
    }

    public static /* synthetic */ void visibility$annotations() {
    }

    public ClassReference(@NotNull Class<?> cls) {
        Intrinsics.checkParameterIsNotNull(cls, "jClass");
        this.jClass = cls;
    }

    @NotNull
    public Class<?> getJClass() {
        return this.jClass;
    }

    @Nullable
    public String getSimpleName() {
        error();
        throw null;
    }

    @Nullable
    public String getQualifiedName() {
        error();
        throw null;
    }

    @NotNull
    public Collection<KCallable<?>> getMembers() {
        error();
        throw null;
    }

    @NotNull
    public Collection<KFunction<Object>> getConstructors() {
        error();
        throw null;
    }

    @NotNull
    public Collection<KClass<?>> getNestedClasses() {
        error();
        throw null;
    }

    @NotNull
    public List<Annotation> getAnnotations() {
        error();
        throw null;
    }

    @Nullable
    public Object getObjectInstance() {
        error();
        throw null;
    }

    public boolean isInstance(@Nullable Object obj) {
        error();
        throw null;
    }

    @NotNull
    public List<Object> getTypeParameters() {
        error();
        throw null;
    }

    @NotNull
    public List<KType> getSupertypes() {
        error();
        throw null;
    }

    @NotNull
    public List<KClass<? extends Object>> getSealedSubclasses() {
        error();
        throw null;
    }

    @Nullable
    public KVisibility getVisibility() {
        error();
        throw null;
    }

    public boolean isFinal() {
        error();
        throw null;
    }

    public boolean isOpen() {
        error();
        throw null;
    }

    public boolean isAbstract() {
        error();
        throw null;
    }

    public boolean isSealed() {
        error();
        throw null;
    }

    public boolean isData() {
        error();
        throw null;
    }

    public boolean isInner() {
        error();
        throw null;
    }

    public boolean isCompanion() {
        error();
        throw null;
    }

    private final Void error() {
        throw new KotlinReflectionNotSupportedError();
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof ClassReference) && Intrinsics.areEqual((Object) JvmClassMappingKt.getJavaObjectType(this), (Object) JvmClassMappingKt.getJavaObjectType((KClass) obj));
    }

    public int hashCode() {
        return JvmClassMappingKt.getJavaObjectType(this).hashCode();
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getJClass().toString());
        sb.append(" (Kotlin reflection is not available)");
        return sb.toString();
    }
}
