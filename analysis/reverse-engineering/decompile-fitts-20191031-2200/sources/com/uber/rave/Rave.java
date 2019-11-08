package com.uber.rave;

import com.uber.rave.annotation.Validated;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Rave {
    private final Map<Class<?>, BaseValidator> classValidatorMap = new HashMap();
    private final UnAnnotatedModelValidator unannotatedModelValidator = new UnAnnotatedModelValidator(100);

    private static class SingletonHolder {
        private static final Rave INSTANCE = new Rave();

        public static Rave getInstance() {
            return INSTANCE;
        }
    }

    static final class UnAnnotatedModelValidator extends BaseValidator {
        private final Map<Class<?>, Set<Class<?>>> supportedClassesCache = new HashMap();
        private final Map<Class<?>, Void> unsupportedClassesCache;

        UnAnnotatedModelValidator(final int i) {
            this.unsupportedClassesCache = new LinkedHashMap<Class<?>, Void>(this) {
                public boolean removeEldestEntry(Entry<Class<?>, Void> entry) {
                    boolean z = size() > i;
                    if (z) {
                        Rave.getInstance().removeEntry((Class) entry.getKey());
                    }
                    return z;
                }
            };
        }

        /* access modifiers changed from: protected */
        public void validateAs(Object obj, Class<?> cls) throws RaveException {
            String str = "Is not supported by validation.";
            if (!this.unsupportedClassesCache.containsKey(cls)) {
                Set<Class> set = (Set) this.supportedClassesCache.get(cls);
                if (set == null || set.isEmpty()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(cls.getCanonicalName());
                    sb.append(":");
                    sb.append(str);
                    sb.append(UnAnnotatedModelValidator.class.getCanonicalName());
                    throw new IllegalArgumentException(sb.toString());
                }
                List list = null;
                for (Class reEvaluateAsSuperType : set) {
                    list = BaseValidator.mergeErrors(list, reEvaluateAsSuperType(reEvaluateAsSuperType, obj));
                }
                if (list != null && !list.isEmpty()) {
                    throw new InvalidModelException(list);
                }
                return;
            }
            throw new UnsupportedObjectException(Collections.singletonList(new RaveError(cls, "", str)));
        }

        /* access modifiers changed from: 0000 */
        public void processNonAnnotatedClasses(Class<?> cls) {
            if (((Validated) cls.getAnnotation(Validated.class)) == null) {
                if (!traverseClassHierarchy(cls, cls)) {
                    this.unsupportedClassesCache.put(cls, null);
                }
                addSupportedClass(cls);
                Rave.getInstance().registerValidatorWithClass(this, cls);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(cls.getCanonicalName());
            sb.append(" is annotated with ");
            sb.append(Validated.class.getCanonicalName());
            throw new IllegalArgumentException(sb.toString());
        }

        private boolean traverseClassHierarchy(Class<?> cls, Class<?> cls2) {
            Class superclass = cls2.getSuperclass();
            boolean evaluateInheritance = superclass != null ? evaluateInheritance(cls, superclass) : false;
            boolean z = evaluateInheritance;
            for (Class evaluateInheritance2 : cls2.getInterfaces()) {
                z = evaluateInheritance(cls, evaluateInheritance2) || z;
            }
            return z;
        }

        private boolean evaluateInheritance(Class<?> cls, Class<?> cls2) {
            if (((Validated) cls2.getAnnotation(Validated.class)) == null) {
                return traverseClassHierarchy(cls, cls2);
            }
            Set set = (Set) this.supportedClassesCache.get(cls);
            if (set == null) {
                set = new HashSet();
                this.supportedClassesCache.put(cls, set);
            }
            set.add(cls2);
            return true;
        }

        /* access modifiers changed from: private */
        public boolean hasSeen(Class<?> cls) {
            return this.supportedClassesCache.containsKey(cls) || this.unsupportedClassesCache.containsKey(cls);
        }
    }

    public static synchronized Rave getInstance() {
        Rave instance;
        synchronized (Rave.class) {
            instance = SingletonHolder.getInstance();
        }
        return instance;
    }

    public void validate(Object obj) throws RaveException {
        BaseValidator baseValidator;
        Class cls = obj.getClass();
        Validated validated = (Validated) cls.getAnnotation(Validated.class);
        synchronized (this) {
            if (validated == null) {
                if (!this.unannotatedModelValidator.hasSeen(cls)) {
                    this.unannotatedModelValidator.processNonAnnotatedClasses(cls);
                }
            }
            baseValidator = (BaseValidator) this.classValidatorMap.get(cls);
            if (baseValidator == null) {
                baseValidator = getValidatorInstance(cls);
            }
            if (baseValidator == null) {
                throw new UnsupportedObjectException(Collections.singletonList(new RaveError(cls, "", "Is not supported by validation.")));
            }
        }
        baseValidator.validate(obj);
    }

    public void validateIgnoreUnsupported(Object obj) throws InvalidModelException {
        try {
            validate(obj);
        } catch (InvalidModelException e) {
            throw e;
        } catch (RaveException unused) {
        }
    }

    /* access modifiers changed from: 0000 */
    public synchronized void registerValidator(BaseValidator baseValidator, Set<Class<?>> set) {
        for (Class cls : set) {
            BaseValidator baseValidator2 = (BaseValidator) this.classValidatorMap.put(cls, baseValidator);
            if (baseValidator2 != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Two validators are validating the same model. ");
                sb.append(baseValidator2.getClass().getCanonicalName());
                sb.append(" and ");
                sb.append(((BaseValidator) this.classValidatorMap.get(cls)).getClass().getCanonicalName());
                sb.append(" for class ");
                sb.append(cls.getCanonicalName());
                throw new IllegalStateException(sb.toString());
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void validateAs(Object obj, Class<?> cls) throws RaveException {
        BaseValidator baseValidator;
        if (cls.isInstance(obj)) {
            synchronized (this) {
                baseValidator = (BaseValidator) this.classValidatorMap.get(cls);
                if (baseValidator == null) {
                    baseValidator = getValidatorInstance(cls);
                }
                if (baseValidator == null) {
                    throw new UnsupportedObjectException(Collections.singletonList(new RaveError(obj.getClass(), "", "Is not supported by validation.")));
                }
            }
            baseValidator.validateAs(obj, cls);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Trying to validate ");
        sb.append(obj.getClass().getCanonicalName());
        sb.append(" as ");
        sb.append(cls.getCanonicalName());
        throw new IllegalArgumentException(sb.toString());
    }

    /* access modifiers changed from: private */
    public void registerValidatorWithClass(BaseValidator baseValidator, Class<?> cls) {
        this.classValidatorMap.put(cls, baseValidator);
    }

    /* access modifiers changed from: private */
    public void removeEntry(Class<?> cls) {
        this.classValidatorMap.remove(cls);
    }

    private BaseValidator getValidatorInstance(Class<?> cls) {
        Validated validated = (Validated) cls.getAnnotation(Validated.class);
        if (validated == null) {
            return null;
        }
        try {
            ((ValidatorFactory) validated.factory().newInstance()).generateValidator();
            return (BaseValidator) this.classValidatorMap.get(cls);
        } catch (IllegalAccessException | InstantiationException e) {
            throw new IllegalStateException(e);
        }
    }
}
