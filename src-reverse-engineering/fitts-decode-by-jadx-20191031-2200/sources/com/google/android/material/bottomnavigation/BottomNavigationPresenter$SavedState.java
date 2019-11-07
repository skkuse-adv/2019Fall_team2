package com.google.android.material.bottomnavigation;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import androidx.annotation.NonNull;

class BottomNavigationPresenter$SavedState implements Parcelable {
    public static final Creator<BottomNavigationPresenter$SavedState> CREATOR = new Creator<BottomNavigationPresenter$SavedState>() {
        public BottomNavigationPresenter$SavedState createFromParcel(Parcel parcel) {
            return new BottomNavigationPresenter$SavedState(parcel);
        }

        public BottomNavigationPresenter$SavedState[] newArray(int i) {
            return new BottomNavigationPresenter$SavedState[i];
        }
    };
    int selectedItemId;

    public int describeContents() {
        return 0;
    }

    BottomNavigationPresenter$SavedState() {
    }

    BottomNavigationPresenter$SavedState(Parcel parcel) {
        this.selectedItemId = parcel.readInt();
    }

    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(this.selectedItemId);
    }
}
