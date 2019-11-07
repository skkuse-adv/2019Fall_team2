package com.kakao.message.template;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ListTemplate implements TemplateParams {
    private final List<ButtonObject> buttons;
    private final List<ContentObject> contents;
    private final LinkObject headerLink;
    private final String headerTitle;

    public static class Builder {
        /* access modifiers changed from: private */
        public List<ButtonObject> buttons = new ArrayList();
        /* access modifiers changed from: private */
        public List<ContentObject> contents = new ArrayList();
        /* access modifiers changed from: private */
        public LinkObject headerLink;
        /* access modifiers changed from: private */
        public String headerTitle;

        Builder(String str, LinkObject linkObject) {
            this.headerTitle = str;
            this.headerLink = linkObject;
        }

        public Builder addContent(ContentObject contentObject) {
            if (this.contents.size() < 3) {
                this.contents.add(contentObject);
            }
            return this;
        }

        public Builder addButton(ButtonObject buttonObject) {
            List<ButtonObject> list = this.buttons;
            if (list != null) {
                list.add(buttonObject);
            }
            return this;
        }

        public ListTemplate build() {
            return new ListTemplate(this);
        }
    }

    public String getObjectType() {
        return MessageTemplateProtocol.TYPE_LIST;
    }

    private ListTemplate(Builder builder) {
        this.headerTitle = builder.headerTitle;
        this.headerLink = builder.headerLink;
        this.contents = builder.contents;
        this.buttons = builder.buttons;
    }

    public JSONObject toJSONObject() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(MessageTemplateProtocol.OBJ_TYPE, getObjectType());
            jSONObject.put(MessageTemplateProtocol.HEADER_TITLE, this.headerTitle);
            if (this.headerLink != null) {
                jSONObject.put(MessageTemplateProtocol.HEADER_LINK, this.headerLink.toJSONObject());
            }
            if (this.contents != null) {
                JSONArray jSONArray = new JSONArray();
                for (ContentObject jSONObject2 : this.contents) {
                    jSONArray.put(jSONObject2.toJSONObject());
                }
                jSONObject.put(MessageTemplateProtocol.CONTENTS, jSONArray);
            }
            if (this.buttons != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (ButtonObject jSONObject3 : this.buttons) {
                    jSONArray2.put(jSONObject3.toJSONObject());
                }
                jSONObject.put("buttons", jSONArray2);
            }
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    public static Builder newBuilder(String str, LinkObject linkObject) {
        return new Builder(str, linkObject);
    }
}
