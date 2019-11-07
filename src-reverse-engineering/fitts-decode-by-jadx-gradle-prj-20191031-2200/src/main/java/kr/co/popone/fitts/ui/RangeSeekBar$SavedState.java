package kr.co.popone.fitts.ui;

import android.os.Parcel;
import android.view.View.BaseSavedState;

class RangeSeekBar$SavedState extends BaseSavedState {
    private int cellsCount;
    private float currSelectedMax;
    private float currSelectedMin;
    private float maxValue;
    private float minValue;
    private float reserveValue;

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.minValue);
        parcel.writeFloat(this.maxValue);
        parcel.writeFloat(this.reserveValue);
        parcel.writeInt(this.cellsCount);
        parcel.writeFloat(this.currSelectedMin);
        parcel.writeFloat(this.currSelectedMax);
    }
}
