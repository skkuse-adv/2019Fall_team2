package com.kakao.message.template;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FeedTemplate implements TemplateParams {
    private final List<ButtonObject> buttons;
    private final ContentObject contentObject;
    private final SocialObject socialObject;

    public static class Builder {
        List<ButtonObject> buttons = new ArrayList();
        ContentObject contentObject;
        SocialObject socialObject;

        public Builder(ContentObject contentObject2) {
            this.contentObject = contentObject2;
        }

        public Builder setSocial(SocialObject socialObject2) {
            this.socialObject = socialObject2;
            return this;
        }

        public Builder addButton(ButtonObject buttonObject) {
            if (buttonObject != null) {
                this.buttons.add(buttonObject);
            }
            return this;
        }

        public FeedTemplate build() {
            return new FeedTemplate(this);
        }
    }

    public String getObjectType() {
        return MessageTemplateProtocol.TYPE_FEED;
    }

    public SocialObject getSocial() {
        return this.socialObject;
    }

    public List<ButtonObject> getButtons() {
        return this.buttons;
    }

    FeedTemplate(Builder builder) {
        this.contentObject = builder.contentObject;
        this.socialObject = builder.socialObject;
        this.buttons = builder.buttons;
    }

    public JSONObject toJSONObject() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(MessageTemplateProtocol.OBJ_TYPE, getObjectType());
            if (this.contentObject != null) {
                jSONObject.put(MessageTemplateProtocol.CONTENT, this.contentObject.toJSONObject());
            }
            if (this.socialObject != null) {
                jSONObject.put("social", this.socialObject.toJSONObject());
            }
            if (this.buttons != null) {
                JSONArray jSONArray = new JSONArray();
                for (ButtonObject jSONObject2 : this.buttons) {
                    jSONArray.put(jSONObject2.toJSONObject());
                }
                jSONObject.put("buttons", jSONArray);
            }
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    public static Builder newBuilder(ContentObject contentObject2) {
        return new Builder(contentObject2);
    }

    public ContentObject getContentObject() {
        return this.contentObject;
    }
}
