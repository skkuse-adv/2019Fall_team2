package com.google.android.gms.common.stats;

import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public abstract class StatsEvent extends AbstractSafeParcelable implements ReflectedParcelable {
    public abstract int getEventType();

    public abstract long getTimeMillis();

    public abstract long zzu();

    public abstract String zzv();

    public String toString() {
        long timeMillis = getTimeMillis();
        int eventType = getEventType();
        long zzu = zzu();
        String zzv = zzv();
        StringBuilder sb = new StringBuilder(String.valueOf(zzv).length() + 53);
        sb.append(timeMillis);
        String str = "\t";
        sb.append(str);
        sb.append(eventType);
        sb.append(str);
        sb.append(zzu);
        sb.append(zzv);
        return sb.toString();
    }
}
