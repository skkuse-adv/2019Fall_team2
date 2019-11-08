package com.kakao.network.storage;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ImageInfo implements Parcelable {
    public static final Creator<ImageInfo> CREATOR = new Creator<ImageInfo>() {
        public ImageInfo createFromParcel(Parcel parcel) {
            return new ImageInfo(parcel);
        }

        public ImageInfo[] newArray(int i) {
            return new ImageInfo[i];
        }
    };
    private String contentType;
    private Integer height;
    private Integer length;
    private String url;
    private Integer width;

    public enum ImageSize {
        ORIGINAL("original");
        
        private final String imageSize;

        private ImageSize(String str) {
            this.imageSize = str;
        }

        public String getValue() {
            return this.imageSize;
        }
    }

    public int describeContents() {
        return 0;
    }

    ImageInfo(String str, Integer num, String str2, Integer num2, Integer num3) {
        this.url = str;
        this.length = num;
        this.contentType = str2;
        this.width = num2;
        this.height = num3;
    }

    public String getUrl() {
        return this.url;
    }

    public Integer getLength() {
        return this.length;
    }

    public String getContentType() {
        return this.contentType;
    }

    public Integer getWidth() {
        return this.width;
    }

    public Integer getHeight() {
        return this.height;
    }

    protected ImageInfo(Parcel parcel) {
        this.url = parcel.readString();
        this.length = Integer.valueOf(parcel.readInt());
        this.contentType = parcel.readString();
        this.width = Integer.valueOf(parcel.readInt());
        this.height = Integer.valueOf(parcel.readInt());
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.url);
        parcel.writeInt(this.length.intValue());
        parcel.writeString(this.contentType);
        parcel.writeInt(this.width.intValue());
        parcel.writeInt(this.height.intValue());
    }
}
