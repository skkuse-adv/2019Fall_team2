package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class ShareMessengerGenericTemplateContent extends ShareContent<ShareMessengerGenericTemplateContent, Object> {
    public static final Creator<ShareMessengerGenericTemplateContent> CREATOR = new Creator<ShareMessengerGenericTemplateContent>() {
        public ShareMessengerGenericTemplateContent createFromParcel(Parcel parcel) {
            return new ShareMessengerGenericTemplateContent(parcel);
        }

        public ShareMessengerGenericTemplateContent[] newArray(int i) {
            return new ShareMessengerGenericTemplateContent[i];
        }
    };
    private final ShareMessengerGenericTemplateElement genericTemplateElement;
    private final ImageAspectRatio imageAspectRatio;
    private final boolean isSharable;

    public enum ImageAspectRatio {
        HORIZONTAL,
        SQUARE
    }

    public int describeContents() {
        return 0;
    }

    ShareMessengerGenericTemplateContent(Parcel parcel) {
        super(parcel);
        this.isSharable = parcel.readByte() != 0;
        this.imageAspectRatio = (ImageAspectRatio) parcel.readSerializable();
        this.genericTemplateElement = (ShareMessengerGenericTemplateElement) parcel.readParcelable(ShareMessengerGenericTemplateElement.class.getClassLoader());
    }

    public boolean getIsSharable() {
        return this.isSharable;
    }

    public ImageAspectRatio getImageAspectRatio() {
        return this.imageAspectRatio;
    }

    public ShareMessengerGenericTemplateElement getGenericTemplateElement() {
        return this.genericTemplateElement;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeByte(this.isSharable ? (byte) 1 : 0);
        parcel.writeSerializable(this.imageAspectRatio);
        parcel.writeParcelable(this.genericTemplateElement, i);
    }
}
