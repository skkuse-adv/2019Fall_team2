package com.crashlytics.android.answers;

class KeepAllEventFilter implements EventFilter {
    public boolean skipEvent(SessionEvent sessionEvent) {
        return false;
    }

    KeepAllEventFilter() {
    }
}
