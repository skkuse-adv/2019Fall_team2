package org.simple.eventbus;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class SubsciberMethodHunter {
    Map<EventType, CopyOnWriteArrayList<Subscription>> mSubcriberMap;

    public SubsciberMethodHunter(Map<EventType, CopyOnWriteArrayList<Subscription>> map) {
        this.mSubcriberMap = map;
    }

    public void findSubcribeMethods(Object obj) {
        if (this.mSubcriberMap != null) {
            Class cls = obj.getClass();
            while (cls != null && !isSystemCalss(cls.getName())) {
                Method[] declaredMethods = cls.getDeclaredMethods();
                for (Method method : declaredMethods) {
                    Subscriber subscriber = (Subscriber) method.getAnnotation(Subscriber.class);
                    if (subscriber != null) {
                        Class[] parameterTypes = method.getParameterTypes();
                        if (parameterTypes != null && parameterTypes.length == 1) {
                            EventType eventType = new EventType(convertType(parameterTypes[0]), subscriber.tag());
                            subscibe(eventType, new TargetMethod(method, eventType, subscriber.mode()), obj);
                        }
                    }
                }
                cls = cls.getSuperclass();
            }
            return;
        }
        throw new NullPointerException("the mSubcriberMap is null. ");
    }

    private void subscibe(EventType eventType, TargetMethod targetMethod, Object obj) {
        CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) this.mSubcriberMap.get(eventType);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList();
        }
        Subscription subscription = new Subscription(obj, targetMethod);
        if (!copyOnWriteArrayList.contains(subscription)) {
            copyOnWriteArrayList.add(subscription);
            this.mSubcriberMap.put(eventType, copyOnWriteArrayList);
        }
    }

    public void removeMethodsFromMap(Object obj) {
        Iterator it = this.mSubcriberMap.values().iterator();
        while (it.hasNext()) {
            CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) it.next();
            if (copyOnWriteArrayList != null) {
                LinkedList linkedList = new LinkedList();
                Iterator it2 = copyOnWriteArrayList.iterator();
                while (it2.hasNext()) {
                    Subscription subscription = (Subscription) it2.next();
                    Object obj2 = subscription.subscriber.get();
                    if (isObjectsEqual(obj2, obj) || obj2 == null) {
                        linkedList.add(subscription);
                    }
                }
                copyOnWriteArrayList.removeAll(linkedList);
            }
            if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() == 0) {
                it.remove();
            }
        }
    }

    private boolean isObjectsEqual(Object obj, Object obj2) {
        return obj != null && obj.equals(obj2);
    }

    private Class<?> convertType(Class<?> cls) {
        if (cls.equals(Boolean.TYPE)) {
            return Boolean.class;
        }
        if (cls.equals(Integer.TYPE)) {
            return Integer.class;
        }
        if (cls.equals(Float.TYPE)) {
            return Float.class;
        }
        return cls.equals(Double.TYPE) ? Double.class : cls;
    }

    private boolean isSystemCalss(String str) {
        return str.startsWith("java.") || str.startsWith("javax.") || str.startsWith("android.");
    }
}
