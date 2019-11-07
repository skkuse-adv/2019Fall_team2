package com.uber.rave;

import com.kakao.network.ServerProtocol;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public abstract class BaseValidator {
    private final HashSet<Class<?>> supportedClasses = new HashSet<>();

    public static final class ValidationContext {
        /* access modifiers changed from: private */
        public final Class<?> clazz;
        /* access modifiers changed from: private */
        public String validatedItemName;

        private ValidationContext(Class<?> cls) {
            this.validatedItemName = "";
            this.clazz = cls;
        }

        /* access modifiers changed from: 0000 */
        public Class<?> getClazz() {
            return this.clazz;
        }

        /* access modifiers changed from: 0000 */
        public String getValidatedItemName() {
            return this.validatedItemName;
        }

        public void setValidatedItemName(String str) {
            this.validatedItemName = str;
        }
    }

    /* access modifiers changed from: protected */
    public abstract void validateAs(Object obj, Class<?> cls) throws RaveException;

    protected BaseValidator() {
    }

    /* access modifiers changed from: 0000 */
    public final void validate(Object obj) throws RaveException {
        Class cls = obj.getClass();
        if (this.supportedClasses.contains(cls)) {
            validateAs(obj, cls);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(cls.getCanonicalName());
        sb.append(":");
        sb.append("Is not supported by validation.");
        throw new IllegalArgumentException(sb.toString());
    }

    /* access modifiers changed from: protected */
    public final List<RaveError> reEvaluateAsSuperType(Class<?> cls, Object obj) {
        try {
            Rave.getInstance().validateAs(obj, cls);
            return null;
        } catch (RaveException e) {
            return e.errors;
        }
    }

    /* access modifiers changed from: protected */
    public final void registerSelf() {
        Rave.getInstance().registerValidator(this, this.supportedClasses);
    }

    /* access modifiers changed from: protected */
    public final void addSupportedClass(Class<?> cls) {
        this.supportedClasses.add(cls);
    }

    protected static ValidationContext getValidationContext(Class<?> cls) {
        return new ValidationContext(cls);
    }

    protected static List<RaveError> checkNullable(Object obj, boolean z, ValidationContext validationContext) {
        if (obj != null) {
            if (!(obj instanceof String)) {
                try {
                    Rave.getInstance().validate(obj);
                } catch (UnsupportedObjectException unused) {
                    return Collections.emptyList();
                } catch (RaveException e) {
                    return appendErrors(e, null);
                }
            }
            return Collections.emptyList();
        } else if (z) {
            return Collections.emptyList();
        } else {
            LinkedList linkedList = new LinkedList();
            linkedList.add(new RaveError(validationContext.clazz, validationContext.validatedItemName, "Item is null and shouldn't be."));
            return linkedList;
        }
    }

    protected static List<RaveError> checkNullable(Collection<?> collection, boolean z, ValidationContext validationContext) {
        List<RaveError> checkNullable = checkNullable((Object) collection, z, validationContext);
        return collection == null ? checkNullable : checkIterable(collection, checkNullable);
    }

    protected static <K, V> List<RaveError> checkNullable(Map<K, V> map, boolean z, ValidationContext validationContext) {
        List<RaveError> checkNullable = checkNullable((Object) map, z, validationContext);
        if (map == null) {
            return checkNullable;
        }
        return checkIterable(map.values(), checkIterable(map.keySet(), checkNullable));
    }

    protected static List<RaveError> mergeErrors(List<RaveError> list, List<RaveError> list2) {
        if (list == null || list.isEmpty()) {
            return list2;
        }
        if (list2 != null && !list2.isEmpty()) {
            list.addAll(list2);
        }
        return list;
    }

    protected static List<RaveError> mustBeTrue(boolean z, ValidationContext validationContext) {
        if (z) {
            return Collections.emptyList();
        }
        return createNewList(new RaveError(validationContext, "Is not true."));
    }

    protected static List<RaveError> checkIntRange(ValidationContext validationContext, long j, long j2, long j3) {
        if (j <= j3 && j >= j2) {
            return Collections.emptyList();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(j);
        sb.append(ServerProtocol.AUTHORIZATION_HEADER_DELIMITER);
        sb.append("Does not conform to the following @IntRange values:");
        sb.append(" which should be between ");
        sb.append(j2);
        sb.append(" and ");
        sb.append(j3);
        return createNewList(new RaveError(validationContext, sb.toString()));
    }

    private static <T> List<RaveError> checkIterable(Iterable<T> iterable, List<RaveError> list) {
        Rave instance = Rave.getInstance();
        for (Object next : iterable) {
            if (next != null) {
                try {
                    instance.validate(next);
                } catch (UnsupportedObjectException unused) {
                    if (list == null) {
                        list = Collections.emptyList();
                    }
                    return list;
                } catch (RaveException e) {
                    list = appendErrors(e, list);
                }
            }
        }
        if (list == null) {
            list = Collections.emptyList();
        }
        return list;
    }

    private static List<RaveError> appendErrors(RaveException raveException, List<RaveError> list) {
        if (list == null) {
            list = new LinkedList<>();
        }
        if (raveException == null) {
            return list;
        }
        try {
            list.addAll(raveException.errors);
            return list;
        } catch (UnsupportedOperationException unused) {
            LinkedList linkedList = new LinkedList();
            linkedList.addAll(raveException.errors);
            linkedList.addAll(list);
            return linkedList;
        }
    }

    private static List<RaveError> createNewList(RaveError raveError) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(raveError);
        return linkedList;
    }
}
