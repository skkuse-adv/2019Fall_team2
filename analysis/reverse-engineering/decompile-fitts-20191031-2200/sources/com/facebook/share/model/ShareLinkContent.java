package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.Nullable;

public final class ShareLinkContent extends ShareContent<ShareLinkContent, Builder> {
    public static final Creator<ShareLinkContent> CREATOR = new Creator<ShareLinkContent>() {
        public ShareLinkContent createFromParcel(Parcel parcel) {
            return new ShareLinkContent(parcel);
        }

        public ShareLinkContent[] newArray(int i) {
            return new ShareLinkContent[i];
        }
    };
    @Deprecated
    private final String contentDescription;
    @Deprecated
    private final String contentTitle;
    @Deprecated
    private final Uri imageUrl;
    private final String quote;

    public static final class Builder extends com.facebook.share.model.ShareContent.Builder<ShareLinkContent, Builder> {
        /* access modifiers changed from: private */
        @Deprecated
        public String contentDescription;
        /* access modifiers changed from: private */
        @Deprecated
        public String contentTitle;
        /* access modifiers changed from: private */
        @Deprecated
        public Uri imageUrl;
        /* access modifiers changed from: private */
        public String quote;

        @Deprecated
        public Builder setContentDescription(@Nullable String str) {
            return this;
        }

        @Deprecated
        public Builder setContentTitle(@Nullable String str) {
            return this;
        }

        @Deprecated
        public Builder setImageUrl(@Nullable Uri uri) {
            return this;
        }

        public Builder setQuote(@Nullable String str) {
            this.quote = str;
            return this;
        }

        public ShareLinkContent build() {
            return new ShareLinkContent(this);
        }

        public Builder readFrom(ShareLinkContent shareLinkContent) {
            if (shareLinkContent == null) {
                return this;
            }
            return ((Builder) super.readFrom(shareLinkContent)).setContentDescription(shareLinkContent.getContentDescription()).setImageUrl(shareLinkContent.getImageUrl()).setContentTitle(shareLinkContent.getContentTitle()).setQuote(shareLinkContent.getQuote());
        }
    }

    public int describeContents() {
        return 0;
    }

    private ShareLinkContent(Builder builder) {
        super((com.facebook.share.model.ShareContent.Builder) builder);
        this.contentDescription = builder.contentDescription;
        this.contentTitle = builder.contentTitle;
        this.imageUrl = builder.imageUrl;
        this.quote = builder.quote;
    }

    ShareLinkContent(Parcel parcel) {
        super(parcel);
        this.contentDescription = parcel.readString();
        this.contentTitle = parcel.readString();
        this.imageUrl = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.quote = parcel.readString();
    }

    @Deprecated
    public String getContentDescription() {
        return this.contentDescription;
    }

    @Deprecated
    @Nullable
    public String getContentTitle() {
        return this.contentTitle;
    }

    @Deprecated
    @Nullable
    public Uri getImageUrl() {
        return this.imageUrl;
    }

    @Nullable
    public String getQuote() {
        return this.quote;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.contentDescription);
        parcel.writeString(this.contentTitle);
        parcel.writeParcelable(this.imageUrl, 0);
        parcel.writeString(this.quote);
    }
}
