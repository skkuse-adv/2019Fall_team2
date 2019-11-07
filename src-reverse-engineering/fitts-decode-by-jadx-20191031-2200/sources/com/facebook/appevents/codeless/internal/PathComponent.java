package com.facebook.appevents.codeless.internal;

import com.kakao.message.template.MessageTemplateProtocol;
import com.kakao.usermgmt.StringSet;
import org.json.JSONException;
import org.json.JSONObject;

public final class PathComponent {
    public final String className;
    public final String description;
    public final String hint;
    public final int id;
    public final int index;
    public final int matchBitmask;
    public final String tag;
    public final String text;

    public enum MatchBitmaskType {
        ID(1),
        TEXT(2),
        TAG(4),
        DESCRIPTION(8),
        HINT(16);
        
        private final int value;

        private MatchBitmaskType(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }

    PathComponent(JSONObject jSONObject) throws JSONException {
        this.className = jSONObject.getString("class_name");
        this.index = jSONObject.optInt("index", -1);
        this.id = jSONObject.optInt("id");
        this.text = jSONObject.optString("text");
        this.tag = jSONObject.optString(StringSet.tag);
        this.description = jSONObject.optString(MessageTemplateProtocol.DESCRIPTION);
        this.hint = jSONObject.optString("hint");
        this.matchBitmask = jSONObject.optInt("match_bitmask");
    }
}
