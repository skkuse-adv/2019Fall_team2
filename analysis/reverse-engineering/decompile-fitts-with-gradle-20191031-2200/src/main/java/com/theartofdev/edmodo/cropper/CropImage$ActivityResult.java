package com.theartofdev.edmodo.cropper;

import android.graphics.Rect;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.theartofdev.edmodo.cropper.CropImageView.CropResult;

public final class CropImage$ActivityResult extends CropResult implements Parcelable {
    public static final Creator<CropImage$ActivityResult> CREATOR = new Creator<CropImage$ActivityResult>() {
        public CropImage$ActivityResult createFromParcel(Parcel parcel) {
            return new CropImage$ActivityResult(parcel);
        }

        public CropImage$ActivityResult[] newArray(int i) {
            return new CropImage$ActivityResult[i];
        }
    };

    public int describeContents() {
        return 0;
    }

    public CropImage$ActivityResult(Uri uri, Uri uri2, Exception exc, float[] fArr, Rect rect, int i, Rect rect2, int i2) {
        super(null, uri, null, uri2, exc, fArr, rect, rect2, i, i2);
    }

    protected CropImage$ActivityResult(Parcel parcel) {
        super(null, (Uri) parcel.readParcelable(Uri.class.getClassLoader()), null, (Uri) parcel.readParcelable(Uri.class.getClassLoader()), (Exception) parcel.readSerializable(), parcel.createFloatArray(), (Rect) parcel.readParcelable(Rect.class.getClassLoader()), (Rect) parcel.readParcelable(Rect.class.getClassLoader()), parcel.readInt(), parcel.readInt());
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(getOriginalUri(), i);
        parcel.writeParcelable(getUri(), i);
        parcel.writeSerializable(getError());
        parcel.writeFloatArray(getCropPoints());
        parcel.writeParcelable(getCropRect(), i);
        parcel.writeParcelable(getWholeImageRect(), i);
        parcel.writeInt(getRotation());
        parcel.writeInt(getSampleSize());
    }
}
