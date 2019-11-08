package com.kakao.message.template;

import org.json.JSONException;
import org.json.JSONObject;

public class ButtonObject {
    private final LinkObject link;
    private final String title;

    public ButtonObject(String str, LinkObject linkObject) {
        this.title = str;
        this.link = linkObject;
    }

    public JSONObject toJSONObject() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("title", this.title);
        jSONObject.put(MessageTemplateProtocol.LINK, this.link.toJSONObject());
        return jSONObject;
    }

    public String getTitle() {
        return this.title;
    }

    public LinkObject getLink() {
        return this.link;
    }
}
