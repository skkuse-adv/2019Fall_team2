package org.simple.eventbus.matchpolicy;

import java.util.LinkedList;
import java.util.List;
import org.simple.eventbus.EventType;

public class DefaultMatchPolicy implements MatchPolicy {
    public List<EventType> findMatchEventTypes(EventType eventType, Object obj) {
        LinkedList linkedList = new LinkedList();
        for (Class cls = obj.getClass(); cls != null; cls = cls.getSuperclass()) {
            linkedList.add(new EventType(cls, eventType.tag));
            addInterfaces(linkedList, cls, eventType.tag);
        }
        return linkedList;
    }

    private void addInterfaces(List<EventType> list, Class<?> cls, String str) {
        Class[] interfaces;
        if (cls != null) {
            for (Class cls2 : cls.getInterfaces()) {
                if (!list.contains(cls2)) {
                    list.add(new EventType(cls2, str));
                    addInterfaces(list, cls2, str);
                }
            }
        }
    }
}
