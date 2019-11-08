package org.simple.eventbus;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;

public class Subscription {
    public EventType eventType;
    public Reference<Object> subscriber;
    public Method targetMethod;
    public ThreadMode threadMode;

    public Subscription(Object obj, TargetMethod targetMethod2) {
        this.subscriber = new WeakReference(obj);
        this.targetMethod = targetMethod2.method;
        this.threadMode = targetMethod2.threadMode;
        this.eventType = targetMethod2.eventType;
    }

    public int hashCode() {
        Reference<Object> reference = this.subscriber;
        int i = 0;
        int hashCode = ((reference == null ? 0 : reference.hashCode()) + 31) * 31;
        Method method = this.targetMethod;
        if (method != null) {
            i = method.hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Subscription.class != obj.getClass()) {
            return false;
        }
        Subscription subscription = (Subscription) obj;
        if (this.subscriber.get() == null) {
            if (subscription.subscriber.get() != null) {
                return false;
            }
        } else if (!this.subscriber.get().equals(subscription.subscriber.get())) {
            return false;
        }
        Method method = this.targetMethod;
        if (method == null) {
            if (subscription.targetMethod != null) {
                return false;
            }
        } else if (!method.equals(subscription.targetMethod)) {
            return false;
        }
        return true;
    }
}
