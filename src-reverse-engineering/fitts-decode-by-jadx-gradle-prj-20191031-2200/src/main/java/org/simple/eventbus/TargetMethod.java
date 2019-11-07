package org.simple.eventbus;

import java.lang.reflect.Method;

class TargetMethod {
    public EventType eventType;
    public Method method;
    public ThreadMode threadMode;

    public TargetMethod(Method method2, EventType eventType2, ThreadMode threadMode2) {
        this.method = method2;
        this.method.setAccessible(true);
        this.eventType = eventType2;
        this.threadMode = threadMode2;
    }

    public int hashCode() {
        EventType eventType2 = this.eventType;
        int i = 0;
        int hashCode = ((eventType2 == null ? 0 : eventType2.hashCode()) + 31) * 31;
        Method method2 = this.method;
        if (method2 != null) {
            i = method2.getName().hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TargetMethod.class != obj.getClass()) {
            return false;
        }
        TargetMethod targetMethod = (TargetMethod) obj;
        EventType eventType2 = this.eventType;
        if (eventType2 == null) {
            if (targetMethod.eventType != null) {
                return false;
            }
        } else if (!eventType2.equals(targetMethod.eventType)) {
            return false;
        }
        Method method2 = this.method;
        if (method2 == null) {
            if (targetMethod.method != null) {
                return false;
            }
        } else if (!method2.getName().equals(targetMethod.method.getName())) {
            return false;
        }
        return true;
    }
}
