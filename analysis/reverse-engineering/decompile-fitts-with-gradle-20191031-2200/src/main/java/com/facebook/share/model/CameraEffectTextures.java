package com.facebook.share.model;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import androidx.annotation.Nullable;
import com.facebook.internal.Utility;
import java.util.Set;

public class CameraEffectTextures implements ShareModel {
    public static final Creator<CameraEffectTextures> CREATOR = new Creator<CameraEffectTextures>() {
        public CameraEffectTextures createFromParcel(Parcel parcel) {
            return new CameraEffectTextures(parcel);
        }

        public CameraEffectTextures[] newArray(int i) {
            return new CameraEffectTextures[i];
        }
    };
    /* access modifiers changed from: private */
    public final Bundle textures;

    public static class Builder implements ShareModelBuilder<CameraEffectTextures, Builder> {
        /* access modifiers changed from: private */
        public Bundle textures = new Bundle();

        public Builder putTexture(String str, Bitmap bitmap) {
            putParcelableTexture(str, bitmap);
            return this;
        }

        public Builder putTexture(String str, Uri uri) {
            putParcelableTexture(str, uri);
            return this;
        }

        private Builder putParcelableTexture(String str, Parcelable parcelable) {
            if (!Utility.isNullOrEmpty(str) && parcelable != null) {
                this.textures.putParcelable(str, parcelable);
            }
            return this;
        }

        public Builder readFrom(CameraEffectTextures cameraEffectTextures) {
            if (cameraEffectTextures != null) {
                this.textures.putAll(cameraEffectTextures.textures);
            }
            return this;
        }

        public Builder readFrom(Parcel parcel) {
            return readFrom((CameraEffectTextures) parcel.readParcelable(CameraEffectTextures.class.getClassLoader()));
        }

        public CameraEffectTextures build() {
            return new CameraEffectTextures(this);
        }
    }

    public int describeContents() {
        return 0;
    }

    private CameraEffectTextures(Builder builder) {
        this.textures = builder.textures;
    }

    CameraEffectTextures(Parcel parcel) {
        this.textures = parcel.readBundle(CameraEffectTextures.class.getClassLoader());
    }

    @Nullable
    public Bitmap getTextureBitmap(String str) {
        Object obj = this.textures.get(str);
        if (obj instanceof Bitmap) {
            return (Bitmap) obj;
        }
        return null;
    }

    @Nullable
    public Uri getTextureUri(String str) {
        Object obj = this.textures.get(str);
        if (obj instanceof Uri) {
            return (Uri) obj;
        }
        return null;
    }

    @Nullable
    public Object get(String str) {
        return this.textures.get(str);
    }

    public Set<String> keySet() {
        return this.textures.keySet();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeBundle(this.textures);
    }
}
