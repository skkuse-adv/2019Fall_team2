package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

@Deprecated
public final class AppInviteContent implements ShareModel {
    @Deprecated
    public static final Creator<AppInviteContent> CREATOR = new Creator<AppInviteContent>() {
        public AppInviteContent createFromParcel(Parcel parcel) {
            return new AppInviteContent(parcel);
        }

        public AppInviteContent[] newArray(int i) {
            return new AppInviteContent[i];
        }
    };
    private final String applinkUrl;
    private final AppInviteContent$Builder$Destination destination;
    private final String previewImageUrl;
    private final String promoCode;
    private final String promoText;

    @Deprecated
    public int describeContents() {
        return 0;
    }

    @Deprecated
    AppInviteContent(Parcel parcel) {
        this.applinkUrl = parcel.readString();
        this.previewImageUrl = parcel.readString();
        this.promoText = parcel.readString();
        this.promoCode = parcel.readString();
        String readString = parcel.readString();
        if (readString.length() > 0) {
            this.destination = AppInviteContent$Builder$Destination.valueOf(readString);
        } else {
            this.destination = AppInviteContent$Builder$Destination.FACEBOOK;
        }
    }

    @Deprecated
    public String getApplinkUrl() {
        return this.applinkUrl;
    }

    @Deprecated
    public String getPreviewImageUrl() {
        return this.previewImageUrl;
    }

    @Deprecated
    public String getPromotionCode() {
        return this.promoCode;
    }

    @Deprecated
    public String getPromotionText() {
        return this.promoText;
    }

    @Deprecated
    public AppInviteContent$Builder$Destination getDestination() {
        AppInviteContent$Builder$Destination appInviteContent$Builder$Destination = this.destination;
        if (appInviteContent$Builder$Destination != null) {
            return appInviteContent$Builder$Destination;
        }
        return AppInviteContent$Builder$Destination.FACEBOOK;
    }

    @Deprecated
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.applinkUrl);
        parcel.writeString(this.previewImageUrl);
        parcel.writeString(this.promoText);
        parcel.writeString(this.promoCode);
        parcel.writeString(this.destination.toString());
    }
}
