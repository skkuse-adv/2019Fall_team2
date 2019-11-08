package org.simple.eventbus;

public final class EventType {
    public static final String DEFAULT_TAG = "default_tag";
    public Object event;
    Class<?> paramClass;
    public String tag;

    public EventType(Class<?> cls) {
        this(cls, DEFAULT_TAG);
    }

    public EventType(Class<?> cls, String str) {
        this.tag = DEFAULT_TAG;
        this.paramClass = cls;
        this.tag = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("EventType [paramClass=");
        sb.append(this.paramClass.getName());
        sb.append(", tag=");
        sb.append(this.tag);
        sb.append("]");
        return sb.toString();
    }

    public int hashCode() {
        Class<?> cls = this.paramClass;
        int i = 0;
        int hashCode = ((cls == null ? 0 : cls.hashCode()) + 31) * 31;
        String str = this.tag;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || EventType.class != obj.getClass()) {
            return false;
        }
        EventType eventType = (EventType) obj;
        Class<?> cls = this.paramClass;
        if (cls == null) {
            if (eventType.paramClass != null) {
                return false;
            }
        } else if (!cls.equals(eventType.paramClass)) {
            return false;
        }
        String str = this.tag;
        if (str == null) {
            if (eventType.tag != null) {
                return false;
            }
        } else if (!str.equals(eventType.tag)) {
            return false;
        }
        return true;
    }
}
