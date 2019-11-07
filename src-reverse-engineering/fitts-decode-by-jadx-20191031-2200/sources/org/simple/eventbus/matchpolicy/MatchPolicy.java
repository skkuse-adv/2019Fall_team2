package org.simple.eventbus.matchpolicy;

import java.util.List;
import org.simple.eventbus.EventType;

public interface MatchPolicy {
    List<EventType> findMatchEventTypes(EventType eventType, Object obj);
}
