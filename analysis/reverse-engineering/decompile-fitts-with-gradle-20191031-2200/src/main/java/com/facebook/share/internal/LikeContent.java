package com.facebook.share.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.share.model.ShareModel;

@Deprecated
public class LikeContent implements ShareModel {
    @Deprecated
    public static final Creator<LikeContent> CREATOR = new Creator<LikeContent>() {
        public LikeContent createFromParcel(Parcel parcel) {
            return new LikeContent(parcel);
        }

        public LikeContent[] newArray(int i) {
            return new LikeContent[i];
        }
    };
    private final String objectId;
    private final String objectType;

    @Deprecated
    public int describeContents() {
        return 0;
    }

    @Deprecated
    LikeContent(Parcel parcel) {
        this.objectId = parcel.readString();
        this.objectType = parcel.readString();
    }

    @Deprecated
    public String getObjectId() {
        return this.objectId;
    }

    @Deprecated
    public String getObjectType() {
        return this.objectType;
    }

    @Deprecated
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.objectId);
        parcel.writeString(this.objectType);
    }
}
