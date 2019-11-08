package com.crashlytics.android.answers;

public class CustomEvent extends AnswersEvent<CustomEvent> {
    private final String eventName;

    public CustomEvent(String str) {
        if (str != null) {
            this.eventName = this.validator.limitStringLength(str);
            return;
        }
        throw new NullPointerException("eventName must not be null");
    }

    /* access modifiers changed from: 0000 */
    public String getCustomType() {
        return this.eventName;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{eventName:\"");
        sb.append(this.eventName);
        sb.append('\"');
        sb.append(", customAttributes:");
        sb.append(this.customAttributes);
        sb.append("}");
        return sb.toString();
    }
}
