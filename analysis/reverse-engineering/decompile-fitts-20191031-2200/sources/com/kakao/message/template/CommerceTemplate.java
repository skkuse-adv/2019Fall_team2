package com.kakao.message.template;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CommerceTemplate implements TemplateParams {
    private final List<ButtonObject> buttons;
    private final CommerceDetailObject commerceDetail;
    private final ContentObject contentObject;

    public static class Builder {
        List<ButtonObject> buttons = new ArrayList();
        CommerceDetailObject commerceDetail;
        ContentObject contentObject;

        public Builder(ContentObject contentObject2, CommerceDetailObject commerceDetailObject) {
            this.contentObject = contentObject2;
            this.commerceDetail = commerceDetailObject;
        }

        public Builder addButton(ButtonObject buttonObject) {
            this.buttons.add(buttonObject);
            return this;
        }

        public CommerceTemplate build() {
            return new CommerceTemplate(this);
        }
    }

    public String getObjectType() {
        return "commerce";
    }

    CommerceTemplate(Builder builder) {
        this.contentObject = builder.contentObject;
        this.commerceDetail = builder.commerceDetail;
        this.buttons = builder.buttons;
    }

    public JSONObject toJSONObject() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(MessageTemplateProtocol.OBJ_TYPE, getObjectType());
            if (this.contentObject != null) {
                jSONObject.put(MessageTemplateProtocol.CONTENT, this.contentObject.toJSONObject());
            }
            if (this.commerceDetail != null) {
                jSONObject.put("commerce", this.commerceDetail.toJSONObject());
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

    public static Builder newBuilder(ContentObject contentObject2, CommerceDetailObject commerceDetailObject) {
        return new Builder(contentObject2, commerceDetailObject);
    }
}
