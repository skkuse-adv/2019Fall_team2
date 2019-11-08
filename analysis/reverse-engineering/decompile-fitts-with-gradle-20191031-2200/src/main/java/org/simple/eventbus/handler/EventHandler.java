package org.simple.eventbus.handler;

import org.simple.eventbus.Subscription;

public interface EventHandler {
    void handleEvent(Subscription subscription, Object obj);
}
