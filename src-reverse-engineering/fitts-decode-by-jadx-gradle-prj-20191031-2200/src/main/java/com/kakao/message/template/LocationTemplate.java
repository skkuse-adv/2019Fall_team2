package com.kakao.message.template;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LocationTemplate implements TemplateParams {
    private final String address;
    private final String addressTitle;
    private final List<ButtonObject> buttons;
    private final ContentObject contentObject;
    private final SocialObject socialObject;

    public static class Builder {
        /* access modifiers changed from: private */
        public final String address;
        /* access modifiers changed from: private */
        public String addressTitle;
        /* access modifiers changed from: private */
        public List<ButtonObject> buttons = new ArrayList();
        /* access modifiers changed from: private */
        public final ContentObject contentObject;
        /* access modifiers changed from: private */
        public SocialObject socialObject;

        Builder(String str, ContentObject contentObject2) {
            this.address = str;
            this.contentObject = contentObject2;
        }

        public Builder setSocial(SocialObject socialObject2) {
            this.socialObject = socialObject2;
            return this;
        }

        public Builder addButton(ButtonObject buttonObject) {
            this.buttons.add(buttonObject);
            return this;
        }

        public Builder setAddressTitle(String str) {
            this.addressTitle = str;
            return this;
        }

        public LocationTemplate build() {
            return new LocationTemplate(this);
        }
    }

    public String getObjectType() {
        return MessageTemplateProtocol.TYPE_LOCATION;
    }

    LocationTemplate(Builder builder) {
        this.address = builder.address;
        this.addressTitle = builder.addressTitle;
        this.contentObject = builder.contentObject;
        this.socialObject = builder.socialObject;
        this.buttons = builder.buttons;
    }

    public JSONObject toJSONObject() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(MessageTemplateProtocol.OBJ_TYPE, getObjectType());
            jSONObject.put(MessageTemplateProtocol.ADDRESS, this.address);
            jSONObject.put(MessageTemplateProtocol.ADDRESS_TITLE, this.addressTitle);
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

    public static com.kakao.message.template.FeedTemplate.Builder newBuilder(ContentObject contentObject2) {
        throw new UnsupportedOperationException("LocationTemplate does not support this method.");
    }

    public static Builder newBuilder(String str, ContentObject contentObject2) {
        return new Builder(str, contentObject2);
    }
}
