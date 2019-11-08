package com.crashlytics.android.answers;

import com.facebook.internal.ServerProtocol;

public class LevelEndEvent extends PredefinedEvent<LevelEndEvent> {
    static final String LEVEL_NAME_ATTRIBUTE = "levelName";
    static final String SCORE_ATTRIBUTE = "score";
    static final String SUCCESS_ATTRIBUTE = "success";
    static final String TYPE = "levelEnd";

    /* access modifiers changed from: 0000 */
    public String getPredefinedType() {
        return TYPE;
    }

    public LevelEndEvent putLevelName(String str) {
        this.predefinedAttributes.put(LEVEL_NAME_ATTRIBUTE, str);
        return this;
    }

    public LevelEndEvent putScore(Number number) {
        this.predefinedAttributes.put(SCORE_ATTRIBUTE, number);
        return this;
    }

    public LevelEndEvent putSuccess(boolean z) {
        this.predefinedAttributes.put("success", z ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false");
        return this;
    }
}
