package io.fabric.sdk.android.services.settings;

public class PromptSettingsData {
    public final String alwaysSendButtonTitle;
    public final String cancelButtonTitle;
    public final String message;
    public final String sendButtonTitle;
    public final boolean showAlwaysSendButton;
    public final boolean showCancelButton;
    public final String title;

    public PromptSettingsData(String str, String str2, String str3, boolean z, String str4, boolean z2, String str5) {
        this.title = str;
        this.message = str2;
        this.sendButtonTitle = str3;
        this.showCancelButton = z;
        this.cancelButtonTitle = str4;
        this.showAlwaysSendButton = z2;
        this.alwaysSendButtonTitle = str5;
    }
}
