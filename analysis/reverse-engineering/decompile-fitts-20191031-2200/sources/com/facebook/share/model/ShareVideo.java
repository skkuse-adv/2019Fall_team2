package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.Nullable;
import com.facebook.share.model.ShareMedia.Type;

public final class ShareVideo extends ShareMedia {
    public static final Creator<ShareVideo> CREATOR = new Creator<ShareVideo>() {
        public ShareVideo createFromParcel(Parcel parcel) {
            return new ShareVideo(parcel);
        }

        public ShareVideo[] newArray(int i) {
            return new ShareVideo[i];
        }
    };
    private final Uri localUrl;

    public static final class Builder extends com.facebook.share.model.ShareMedia.Builder<ShareVideo, Builder> {
        /* access modifiers changed from: private */
        public Uri localUrl;

        public Builder setLocalUrl(@Nullable Uri uri) {
            this.localUrl = uri;
            return this;
        }

        public ShareVideo build() {
            return new ShareVideo(this);
        }

        public Builder readFrom(ShareVideo shareVideo) {
            if (shareVideo == null) {
                return this;
            }
            return ((Builder) super.readFrom(shareVideo)).setLocalUrl(shareVideo.getLocalUrl());
        }

        /* access modifiers changed from: 0000 */
        public Builder readFrom(Parcel parcel) {
            return readFrom((ShareVideo) parcel.readParcelable(ShareVideo.class.getClassLoader()));
        }
    }

    public int describeContents() {
        return 0;
    }

    private ShareVideo(Builder builder) {
        super((com.facebook.share.model.ShareMedia.Builder) builder);
        this.localUrl = builder.localUrl;
    }

    ShareVideo(Parcel parcel) {
        super(parcel);
        this.localUrl = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
    }

    @Nullable
    public Uri getLocalUrl() {
        return this.localUrl;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.localUrl, 0);
    }

    public Type getMediaType() {
        return Type.VIDEO;
    }
}
