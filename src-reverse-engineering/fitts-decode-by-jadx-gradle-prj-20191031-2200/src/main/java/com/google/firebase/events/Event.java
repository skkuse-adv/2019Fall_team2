package com.google.firebase.events;

import com.google.android.gms.common.internal.Preconditions;

public class Event<T> {
    private final T payload;
    private final Class<T> type;

    public Event(Class<T> cls, T t) {
        this.type = (Class) Preconditions.checkNotNull(cls);
        this.payload = Preconditions.checkNotNull(t);
    }

    public Class<T> getType() {
        return this.type;
    }

    public T getPayload() {
        return this.payload;
    }

    public String toString() {
        return String.format("Event{type: %s, payload: %s}", new Object[]{this.type, this.payload});
    }
}
