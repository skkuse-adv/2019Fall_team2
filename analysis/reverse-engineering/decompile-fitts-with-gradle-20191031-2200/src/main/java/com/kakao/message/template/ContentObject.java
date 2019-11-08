package com.kakao.message.template;

import org.json.JSONException;
import org.json.JSONObject;

public class ContentObject {
    private String description;
    private Integer imageHeight;
    private String imageUrl;
    private Integer imageWidth;
    private LinkObject link;
    private String title;

    public static class Builder {
        /* access modifiers changed from: private */
        public String description;
        /* access modifiers changed from: private */
        public Integer imageHeight;
        /* access modifiers changed from: private */
        public String imageUrl;
        /* access modifiers changed from: private */
        public Integer imageWidth;
        /* access modifiers changed from: private */
        public LinkObject link;
        /* access modifiers changed from: private */
        public String title;

        public Builder(String str, String str2, LinkObject linkObject) {
            this.title = str;
            this.imageUrl = str2;
            this.link = linkObject;
        }

        public Builder setImageWidth(int i) {
            this.imageWidth = Integer.valueOf(i);
            return this;
        }

        public Builder setImageHeight(int i) {
            this.imageHeight = Integer.valueOf(i);
            return this;
        }

        public Builder setDescrption(String str) {
            this.description = str;
            return this;
        }

        public ContentObject build() {
            return new ContentObject(this);
        }
    }

    public JSONObject toJSONObject() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("title", this.title);
        jSONObject.put("image_url", this.imageUrl);
        jSONObject.put(MessageTemplateProtocol.IMAGE_WIDTH, this.imageWidth);
        jSONObject.put(MessageTemplateProtocol.IMAGE_HEIGHT, this.imageHeight);
        jSONObject.put(MessageTemplateProtocol.DESCRIPTION, this.description);
        jSONObject.put(MessageTemplateProtocol.LINK, this.link.toJSONObject());
        return jSONObject;
    }

    public static Builder newBuilder(String str, String str2, LinkObject linkObject) {
        return new Builder(str, str2, linkObject);
    }

    private ContentObject(Builder builder) {
        this.title = builder.title;
        this.imageUrl = builder.imageUrl;
        this.imageWidth = builder.imageWidth;
        this.imageHeight = builder.imageHeight;
        this.description = builder.description;
        this.link = builder.link;
    }

    public String getTitle() {
        return this.title;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public Integer getImageWidth() {
        return this.imageWidth;
    }

    public Integer getImageHeight() {
        return this.imageHeight;
    }

    public String getDescription() {
        return this.description;
    }

    public LinkObject getLink() {
        return this.link;
    }
}
