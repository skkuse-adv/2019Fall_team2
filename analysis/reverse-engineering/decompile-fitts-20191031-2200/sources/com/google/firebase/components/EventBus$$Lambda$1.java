package com.google.firebase.components;

import com.google.firebase.events.Event;
import com.google.firebase.events.EventHandler;
import java.util.Map.Entry;

final /* synthetic */ class EventBus$$Lambda$1 implements Runnable {
    private final Entry arg$1;
    private final Event arg$2;

    private EventBus$$Lambda$1(Entry entry, Event event) {
        this.arg$1 = entry;
        this.arg$2 = event;
    }

    public static Runnable lambdaFactory$(Entry entry, Event event) {
        return new EventBus$$Lambda$1(entry, event);
    }

    public void run() {
        ((EventHandler) this.arg$1.getKey()).handle(this.arg$2);
    }
}
