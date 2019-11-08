package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class AppGroupCreationContent implements ShareModel {
    public static final Creator<AppGroupCreationContent> CREATOR = new Creator<AppGroupCreationContent>() {
        public AppGroupCreationContent createFromParcel(Parcel parcel) {
            return new AppGroupCreationContent(parcel);
        }

        public AppGroupCreationContent[] newArray(int i) {
            return new AppGroupCreationContent[i];
        }
    };
    private final String description;
    private final String name;
    private AppGroupPrivacy privacy;

    public enum AppGroupPrivacy {
        Open,
        Closed
    }

    public int describeContents() {
        return 0;
    }

    AppGroupCreationContent(Parcel parcel) {
        this.name = parcel.readString();
        this.description = parcel.readString();
        this.privacy = (AppGroupPrivacy) parcel.readSerializable();
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public AppGroupPrivacy getAppGroupPrivacy() {
        return this.privacy;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeString(this.description);
        parcel.writeSerializable(this.privacy);
    }
}
