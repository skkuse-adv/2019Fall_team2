package com.crashlytics.android.answers;

import com.crashlytics.android.answers.PredefinedEvent;
import java.util.Map;

public abstract class PredefinedEvent<T extends PredefinedEvent> extends AnswersEvent<T> {
    final AnswersAttributes predefinedAttributes = new AnswersAttributes(this.validator);

    /* access modifiers changed from: 0000 */
    public abstract String getPredefinedType();

    /* access modifiers changed from: 0000 */
    public Map<String, Object> getPredefinedAttributes() {
        return this.predefinedAttributes.attributes;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{type:\"");
        sb.append(getPredefinedType());
        sb.append('\"');
        sb.append(", predefinedAttributes:");
        sb.append(this.predefinedAttributes);
        sb.append(", customAttributes:");
        sb.append(this.customAttributes);
        sb.append("}");
        return sb.toString();
    }
}
