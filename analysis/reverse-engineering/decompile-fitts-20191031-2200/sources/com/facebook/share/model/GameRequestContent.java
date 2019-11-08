package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import java.util.List;

public final class GameRequestContent implements ShareModel {
    public static final Creator<GameRequestContent> CREATOR = new Creator<GameRequestContent>() {
        public GameRequestContent createFromParcel(Parcel parcel) {
            return new GameRequestContent(parcel);
        }

        public GameRequestContent[] newArray(int i) {
            return new GameRequestContent[i];
        }
    };
    private final ActionType actionType;
    private final String data;
    private final Filters filters;
    private final String message;
    private final String objectId;
    private final List<String> recipients;
    private final List<String> suggestions;
    private final String title;

    public enum ActionType {
        SEND,
        ASKFOR,
        TURN
    }

    public enum Filters {
        APP_USERS,
        APP_NON_USERS
    }

    public int describeContents() {
        return 0;
    }

    GameRequestContent(Parcel parcel) {
        this.message = parcel.readString();
        this.recipients = parcel.createStringArrayList();
        this.title = parcel.readString();
        this.data = parcel.readString();
        this.actionType = (ActionType) parcel.readSerializable();
        this.objectId = parcel.readString();
        this.filters = (Filters) parcel.readSerializable();
        this.suggestions = parcel.createStringArrayList();
        parcel.readStringList(this.suggestions);
    }

    public String getMessage() {
        return this.message;
    }

    public String getTo() {
        if (getRecipients() == null) {
            return null;
        }
        return TextUtils.join(",", getRecipients());
    }

    public List<String> getRecipients() {
        return this.recipients;
    }

    public String getTitle() {
        return this.title;
    }

    public String getData() {
        return this.data;
    }

    public ActionType getActionType() {
        return this.actionType;
    }

    public String getObjectId() {
        return this.objectId;
    }

    public Filters getFilters() {
        return this.filters;
    }

    public List<String> getSuggestions() {
        return this.suggestions;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.message);
        parcel.writeStringList(this.recipients);
        parcel.writeString(this.title);
        parcel.writeString(this.data);
        parcel.writeSerializable(this.actionType);
        parcel.writeString(this.objectId);
        parcel.writeSerializable(this.filters);
        parcel.writeStringList(this.suggestions);
    }
}
