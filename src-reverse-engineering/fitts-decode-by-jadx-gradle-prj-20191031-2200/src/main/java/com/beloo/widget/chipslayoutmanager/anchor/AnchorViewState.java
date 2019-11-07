package com.beloo.widget.chipslayoutmanager.anchor;

import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import androidx.annotation.NonNull;
import java.util.Locale;

public class AnchorViewState implements Parcelable {
    public static final Creator<AnchorViewState> CREATOR = new Creator<AnchorViewState>() {
        public AnchorViewState createFromParcel(Parcel parcel) {
            return new AnchorViewState(parcel);
        }

        public AnchorViewState[] newArray(int i) {
            return new AnchorViewState[i];
        }
    };
    private Rect anchorViewRect;
    private Integer position;

    public int describeContents() {
        return 0;
    }

    private AnchorViewState() {
        this.position = Integer.valueOf(0);
    }

    static AnchorViewState getNotFoundState() {
        return new AnchorViewState();
    }

    AnchorViewState(int i, @NonNull Rect rect) {
        this.position = Integer.valueOf(0);
        this.position = Integer.valueOf(i);
        this.anchorViewRect = rect;
    }

    public boolean isNotFoundState() {
        return this.anchorViewRect == null;
    }

    public Integer getPosition() {
        return this.position;
    }

    public void setPosition(Integer num) {
        this.position = num;
    }

    public Rect getAnchorViewRect() {
        return this.anchorViewRect;
    }

    public void setAnchorViewRect(Rect rect) {
        this.anchorViewRect = rect;
    }

    public boolean isRemoving() {
        return getPosition().intValue() == -1;
    }

    private AnchorViewState(Parcel parcel) {
        Integer num;
        this.position = Integer.valueOf(0);
        int readInt = parcel.readInt();
        if (readInt == -1) {
            num = null;
        } else {
            num = Integer.valueOf(readInt);
        }
        this.position = num;
        this.anchorViewRect = (Rect) parcel.readParcelable(AnchorViewState.class.getClassLoader());
    }

    public void writeToParcel(Parcel parcel, int i) {
        Integer num = this.position;
        parcel.writeInt(num == null ? -1 : num.intValue());
        parcel.writeParcelable(this.anchorViewRect, 0);
    }

    public String toString() {
        return String.format(Locale.getDefault(), "AnchorState. Position = %d, Rect = %s", new Object[]{this.position, String.valueOf(this.anchorViewRect)});
    }
}
