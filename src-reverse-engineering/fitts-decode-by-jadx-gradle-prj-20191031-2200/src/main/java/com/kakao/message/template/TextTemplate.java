package com.kakao.message.template;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TextTemplate implements TemplateParams {
    private final String buttonTitle;
    private final List<ButtonObject> buttons;
    private final LinkObject linkObject;
    private final String text;

    public static class Builder {
        String buttonTitle;
        List<ButtonObject> buttons;
        LinkObject link;
        String text;

        public Builder(String str, LinkObject linkObject) {
            if (str == null) {
                throw new IllegalArgumentException("TextTemplate's text field cannot be null.");
            } else if (linkObject != null) {
                this.text = str;
                this.link = linkObject;
                this.buttons = new ArrayList();
            } else {
                throw new IllegalArgumentException("TextTemplate's link field cannot be null.");
            }
        }

        public Builder setButtonTitle(String str) {
            this.buttonTitle = str;
            return this;
        }

        public Builder addButton(ButtonObject buttonObject) {
            if (buttonObject != null) {
                this.buttons.add(buttonObject);
            }
            return this;
        }

        public TextTemplate build() {
            return new TextTemplate(this);
        }
    }

    public String getObjectType() {
        return "text";
    }

    public TextTemplate(Builder builder) {
        this.text = builder.text;
        this.linkObject = builder.link;
        this.buttonTitle = builder.buttonTitle;
        this.buttons = builder.buttons;
    }

    public static Builder newBuilder(String str, LinkObject linkObject2) {
        return new Builder(str, linkObject2);
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(MessageTemplateProtocol.OBJ_TYPE, getObjectType());
            jSONObject.put("text", this.text);
            jSONObject.put(MessageTemplateProtocol.LINK, this.linkObject.toJSONObject());
            jSONObject.put(MessageTemplateProtocol.BUTTON_TITLE, this.buttonTitle);
            if (this.buttons != null) {
                JSONArray jSONArray = new JSONArray();
                for (ButtonObject jSONObject2 : this.buttons) {
                    jSONArray.put(jSONObject2.toJSONObject());
                }
                jSONObject.put("buttons", jSONArray);
            }
        } catch (JSONException e) {
            e.toString();
        }
        return jSONObject;
    }

    public List<ButtonObject> getButtons() {
        return this.buttons;
    }

    public LinkObject getLinkObject() {
        return this.linkObject;
    }

    public String getText() {
        return this.text;
    }

    public String getButtonTitle() {
        return this.buttonTitle;
    }
}
