package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.Nullable;

public final class ShareMessengerURLActionButton extends ShareMessengerActionButton {
    public static final Creator<ShareMessengerURLActionButton> CREATOR = new Creator<ShareMessengerURLActionButton>() {
        public ShareMessengerURLActionButton createFromParcel(Parcel parcel) {
            return new ShareMessengerURLActionButton(parcel);
        }

        public ShareMessengerURLActionButton[] newArray(int i) {
            return new ShareMessengerURLActionButton[i];
        }
    };
    private final Uri fallbackUrl;
    private final boolean isMessengerExtensionURL;
    private final boolean shouldHideWebviewShareButton;
    private final Uri url;
    private final WebviewHeightRatio webviewHeightRatio;

    public enum WebviewHeightRatio {
        WebviewHeightRatioFull,
        WebviewHeightRatioTall,
        WebviewHeightRatioCompact
    }

    ShareMessengerURLActionButton(Parcel parcel) {
        super(parcel);
        this.url = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        boolean z = true;
        this.isMessengerExtensionURL = parcel.readByte() != 0;
        this.fallbackUrl = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.webviewHeightRatio = (WebviewHeightRatio) parcel.readSerializable();
        if (parcel.readByte() == 0) {
            z = false;
        }
        this.shouldHideWebviewShareButton = z;
    }

    public Uri getUrl() {
        return this.url;
    }

    public boolean getIsMessengerExtensionURL() {
        return this.isMessengerExtensionURL;
    }

    @Nullable
    public Uri getFallbackUrl() {
        return this.fallbackUrl;
    }

    @Nullable
    public WebviewHeightRatio getWebviewHeightRatio() {
        return this.webviewHeightRatio;
    }

    public boolean getShouldHideWebviewShareButton() {
        return this.shouldHideWebviewShareButton;
    }
}
