package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class SharePhotoContent extends ShareContent<SharePhotoContent, Builder> {
    public static final Creator<SharePhotoContent> CREATOR = new Creator<SharePhotoContent>() {
        public SharePhotoContent createFromParcel(Parcel parcel) {
            return new SharePhotoContent(parcel);
        }

        public SharePhotoContent[] newArray(int i) {
            return new SharePhotoContent[i];
        }
    };
    private final List<SharePhoto> photos;

    public static class Builder extends com.facebook.share.model.ShareContent.Builder<SharePhotoContent, Builder> {
        /* access modifiers changed from: private */
        public final List<SharePhoto> photos = new ArrayList();

        public Builder addPhoto(@Nullable SharePhoto sharePhoto) {
            if (sharePhoto != null) {
                this.photos.add(new com.facebook.share.model.SharePhoto.Builder().readFrom(sharePhoto).build());
            }
            return this;
        }

        public Builder addPhotos(@Nullable List<SharePhoto> list) {
            if (list != null) {
                for (SharePhoto addPhoto : list) {
                    addPhoto(addPhoto);
                }
            }
            return this;
        }

        public SharePhotoContent build() {
            return new SharePhotoContent(this);
        }

        public Builder readFrom(SharePhotoContent sharePhotoContent) {
            if (sharePhotoContent == null) {
                return this;
            }
            return ((Builder) super.readFrom(sharePhotoContent)).addPhotos(sharePhotoContent.getPhotos());
        }

        public Builder setPhotos(@Nullable List<SharePhoto> list) {
            this.photos.clear();
            addPhotos(list);
            return this;
        }
    }

    public int describeContents() {
        return 0;
    }

    private SharePhotoContent(Builder builder) {
        super((com.facebook.share.model.ShareContent.Builder) builder);
        this.photos = Collections.unmodifiableList(builder.photos);
    }

    SharePhotoContent(Parcel parcel) {
        super(parcel);
        this.photos = Collections.unmodifiableList(com.facebook.share.model.SharePhoto.Builder.readPhotoListFrom(parcel));
    }

    @Nullable
    public List<SharePhoto> getPhotos() {
        return this.photos;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        com.facebook.share.model.SharePhoto.Builder.writePhotoListTo(parcel, i, this.photos);
    }
}
