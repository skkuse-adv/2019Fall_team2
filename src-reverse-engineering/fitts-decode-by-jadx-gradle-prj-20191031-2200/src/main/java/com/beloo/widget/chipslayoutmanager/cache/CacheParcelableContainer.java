package com.beloo.widget.chipslayoutmanager.cache;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.LinkedList;
import java.util.NavigableSet;
import java.util.TreeSet;

public final class CacheParcelableContainer implements Parcelable {
    public static final Creator<CacheParcelableContainer> CREATOR = new Creator<CacheParcelableContainer>() {
        public CacheParcelableContainer createFromParcel(Parcel parcel) {
            return new CacheParcelableContainer(parcel);
        }

        public CacheParcelableContainer[] newArray(int i) {
            return new CacheParcelableContainer[i];
        }
    };
    private NavigableSet<Integer> endsRow;
    private NavigableSet<Integer> startsRow;

    public int describeContents() {
        return 0;
    }

    CacheParcelableContainer(NavigableSet<Integer> navigableSet, NavigableSet<Integer> navigableSet2) {
        this.startsRow = new TreeSet();
        this.endsRow = new TreeSet();
        this.startsRow = navigableSet;
        this.endsRow = navigableSet2;
    }

    private CacheParcelableContainer(Parcel parcel) {
        this.startsRow = new TreeSet();
        this.endsRow = new TreeSet();
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        parcel.readList(linkedList, Integer.class.getClassLoader());
        parcel.readList(linkedList2, Integer.class.getClassLoader());
        this.startsRow = new TreeSet(linkedList);
        this.endsRow = new TreeSet(linkedList2);
    }

    public void writeToParcel(Parcel parcel, int i) {
        LinkedList linkedList = new LinkedList(this.startsRow);
        LinkedList linkedList2 = new LinkedList(this.endsRow);
        parcel.writeList(linkedList);
        parcel.writeList(linkedList2);
    }

    /* access modifiers changed from: 0000 */
    public NavigableSet<Integer> getStartsRow() {
        return this.startsRow;
    }

    /* access modifiers changed from: 0000 */
    public NavigableSet<Integer> getEndsRow() {
        return this.endsRow;
    }
}
