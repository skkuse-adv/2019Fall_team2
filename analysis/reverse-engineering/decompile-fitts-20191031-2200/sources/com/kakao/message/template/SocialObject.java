package com.kakao.message.template;

import org.json.JSONException;
import org.json.JSONObject;

public class SocialObject {
    private final Integer commentCount;
    private final Integer likeCount;
    private final Integer sharedCount;
    private final Integer subscriberCount;
    private final Integer viewCount;

    public static class Builder {
        /* access modifiers changed from: private */
        public Integer commentCount;
        /* access modifiers changed from: private */
        public Integer likeCount;
        /* access modifiers changed from: private */
        public Integer sharedCount;
        /* access modifiers changed from: private */
        public Integer subscriberCount;
        /* access modifiers changed from: private */
        public Integer viewCount;

        public Builder setLikeCount(int i) {
            this.likeCount = Integer.valueOf(i);
            return this;
        }

        public Builder setCommentCount(int i) {
            this.commentCount = Integer.valueOf(i);
            return this;
        }

        public Builder setSharedCount(int i) {
            this.sharedCount = Integer.valueOf(i);
            return this;
        }

        public Builder setViewCount(int i) {
            this.viewCount = Integer.valueOf(i);
            return this;
        }

        public Builder setSubscriberCount(int i) {
            this.subscriberCount = Integer.valueOf(i);
            return this;
        }

        public SocialObject build() {
            return new SocialObject(this);
        }
    }

    SocialObject(Builder builder) {
        this.likeCount = builder.likeCount;
        this.commentCount = builder.commentCount;
        this.sharedCount = builder.sharedCount;
        this.viewCount = builder.viewCount;
        this.subscriberCount = builder.subscriberCount;
    }

    public JSONObject toJSONObject() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(MessageTemplateProtocol.LIKE_COUNT, this.likeCount);
        jSONObject.put(MessageTemplateProtocol.COMMENT_COUNT, this.commentCount);
        jSONObject.put(MessageTemplateProtocol.SHARED_COUNT, this.sharedCount);
        jSONObject.put(MessageTemplateProtocol.VIEW_COUNT, this.viewCount);
        jSONObject.put("subscriber_count", this.subscriberCount);
        return jSONObject;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Integer getLikeCount() {
        return this.likeCount;
    }

    public Integer getCommentCount() {
        return this.commentCount;
    }

    public Integer getSharedCount() {
        return this.sharedCount;
    }

    public Integer getViewCount() {
        return this.viewCount;
    }

    public Integer getSubscriberCount() {
        return this.subscriberCount;
    }
}
