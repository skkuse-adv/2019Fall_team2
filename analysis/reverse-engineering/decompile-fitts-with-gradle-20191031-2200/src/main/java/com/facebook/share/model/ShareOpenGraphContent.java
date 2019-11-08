package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.Nullable;
import com.facebook.share.model.ShareOpenGraphAction.Builder;

public final class ShareOpenGraphContent extends ShareContent<ShareOpenGraphContent, Object> {
    public static final Creator<ShareOpenGraphContent> CREATOR = new Creator<ShareOpenGraphContent>() {
        public ShareOpenGraphContent createFromParcel(Parcel parcel) {
            return new ShareOpenGraphContent(parcel);
        }

        public ShareOpenGraphContent[] newArray(int i) {
            return new ShareOpenGraphContent[i];
        }
    };
    private final ShareOpenGraphAction action;
    private final String previewPropertyName;

    public int describeContents() {
        return 0;
    }

    ShareOpenGraphContent(Parcel parcel) {
        super(parcel);
        this.action = new Builder().readFrom(parcel).build();
        this.previewPropertyName = parcel.readString();
    }

    @Nullable
    public ShareOpenGraphAction getAction() {
        return this.action;
    }

    @Nullable
    public String getPreviewPropertyName() {
        return this.previewPropertyName;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.action, 0);
        parcel.writeString(this.previewPropertyName);
    }
}
