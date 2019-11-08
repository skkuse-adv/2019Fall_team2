package com.crashlytics.android.answers;

import java.util.HashSet;
import java.util.Set;

class SamplingEventFilter implements EventFilter {
    static final Set<Type> EVENTS_TYPE_TO_SAMPLE = new HashSet<Type>() {
        {
            add(Type.START);
            add(Type.RESUME);
            add(Type.PAUSE);
            add(Type.STOP);
        }
    };
    final int samplingRate;

    public SamplingEventFilter(int i) {
        this.samplingRate = i;
    }

    public boolean skipEvent(SessionEvent sessionEvent) {
        boolean z = EVENTS_TYPE_TO_SAMPLE.contains(sessionEvent.type) && sessionEvent.sessionEventMetadata.betaDeviceToken == null;
        boolean z2 = Math.abs(sessionEvent.sessionEventMetadata.installationId.hashCode() % this.samplingRate) != 0;
        if (!z || !z2) {
            return false;
        }
        return true;
    }
}
