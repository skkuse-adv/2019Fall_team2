package com.facebook.share.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.Nullable;
import java.util.Set;

public class CameraEffectArguments implements ShareModel {
    public static final Creator<CameraEffectArguments> CREATOR = new Creator<CameraEffectArguments>() {
        public CameraEffectArguments createFromParcel(Parcel parcel) {
            return new CameraEffectArguments(parcel);
        }

        public CameraEffectArguments[] newArray(int i) {
            return new CameraEffectArguments[i];
        }
    };
    /* access modifiers changed from: private */
    public final Bundle params;

    public static class Builder implements ShareModelBuilder<CameraEffectArguments, Builder> {
        /* access modifiers changed from: private */
        public Bundle params = new Bundle();

        public Builder putArgument(String str, String str2) {
            this.params.putString(str, str2);
            return this;
        }

        public Builder putArgument(String str, String[] strArr) {
            this.params.putStringArray(str, strArr);
            return this;
        }

        public Builder readFrom(CameraEffectArguments cameraEffectArguments) {
            if (cameraEffectArguments != null) {
                this.params.putAll(cameraEffectArguments.params);
            }
            return this;
        }

        public Builder readFrom(Parcel parcel) {
            return readFrom((CameraEffectArguments) parcel.readParcelable(CameraEffectArguments.class.getClassLoader()));
        }

        public CameraEffectArguments build() {
            return new CameraEffectArguments(this);
        }
    }

    public int describeContents() {
        return 0;
    }

    private CameraEffectArguments(Builder builder) {
        this.params = builder.params;
    }

    CameraEffectArguments(Parcel parcel) {
        this.params = parcel.readBundle(CameraEffectArguments.class.getClassLoader());
    }

    @Nullable
    public String getString(String str) {
        return this.params.getString(str);
    }

    @Nullable
    public String[] getStringArray(String str) {
        return this.params.getStringArray(str);
    }

    @Nullable
    public Object get(String str) {
        return this.params.get(str);
    }

    public Set<String> keySet() {
        return this.params.keySet();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeBundle(this.params);
    }
}
