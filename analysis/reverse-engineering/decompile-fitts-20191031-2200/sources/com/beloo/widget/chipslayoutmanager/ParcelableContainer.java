package com.beloo.widget.chipslayoutmanager;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.SparseArray;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import com.beloo.widget.chipslayoutmanager.anchor.AnchorViewState;
import com.beloo.widget.chipslayoutmanager.cache.CacheParcelableContainer;

class ParcelableContainer implements Parcelable {
    public static final Creator<ParcelableContainer> CREATOR = new Creator<ParcelableContainer>() {
        public ParcelableContainer createFromParcel(Parcel parcel) {
            return new ParcelableContainer(parcel);
        }

        public ParcelableContainer[] newArray(int i) {
            return new ParcelableContainer[i];
        }
    };
    private AnchorViewState anchorViewState;
    private SparseArray<Object> cacheNormalizationPositionMap;
    private int orientation;
    private SparseArray<Object> orientationCacheMap;

    public int describeContents() {
        return 0;
    }

    ParcelableContainer() {
        this.orientationCacheMap = new SparseArray<>();
        this.cacheNormalizationPositionMap = new SparseArray<>();
        SparseArray<Object> sparseArray = this.cacheNormalizationPositionMap;
        Integer valueOf = Integer.valueOf(0);
        sparseArray.put(1, valueOf);
        this.cacheNormalizationPositionMap.put(2, valueOf);
    }

    /* access modifiers changed from: 0000 */
    public void putAnchorViewState(AnchorViewState anchorViewState2) {
        this.anchorViewState = anchorViewState2;
    }

    /* access modifiers changed from: 0000 */
    public AnchorViewState getAnchorViewState() {
        return this.anchorViewState;
    }

    /* access modifiers changed from: 0000 */
    public int getOrientation() {
        return this.orientation;
    }

    /* access modifiers changed from: 0000 */
    public void putOrientation(int i) {
        this.orientation = i;
    }

    private ParcelableContainer(Parcel parcel) {
        this.orientationCacheMap = new SparseArray<>();
        this.cacheNormalizationPositionMap = new SparseArray<>();
        this.anchorViewState = (AnchorViewState) AnchorViewState.CREATOR.createFromParcel(parcel);
        this.orientationCacheMap = parcel.readSparseArray(CacheParcelableContainer.class.getClassLoader());
        this.cacheNormalizationPositionMap = parcel.readSparseArray(Integer.class.getClassLoader());
        this.orientation = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        this.anchorViewState.writeToParcel(parcel, i);
        parcel.writeSparseArray(this.orientationCacheMap);
        parcel.writeSparseArray(this.cacheNormalizationPositionMap);
        parcel.writeInt(this.orientation);
    }

    /* access modifiers changed from: 0000 */
    public void putPositionsCache(int i, Parcelable parcelable) {
        this.orientationCacheMap.put(i, parcelable);
    }

    /* access modifiers changed from: 0000 */
    public void putNormalizationPosition(int i, @Nullable Integer num) {
        this.cacheNormalizationPositionMap.put(i, num);
    }

    /* access modifiers changed from: 0000 */
    @Nullable
    public Parcelable getPositionsCache(int i) {
        return (Parcelable) this.orientationCacheMap.get(i);
    }

    /* access modifiers changed from: 0000 */
    @IntRange(from = 0)
    @Nullable
    public Integer getNormalizationPosition(int i) {
        return (Integer) this.cacheNormalizationPositionMap.get(i);
    }
}
