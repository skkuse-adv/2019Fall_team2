package com.google.android.gms.internal.firebase-perf;

import android.support.v4.media.session.PlaybackStateCompat;

public enum zzba {
    TERABYTES(1099511627776L),
    GIGABYTES(1073741824),
    MEGABYTES(PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED),
    KILOBYTES(PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID),
    BYTES(1);
    
    private long zzhu;

    private zzba(long j) {
        this.zzhu = j;
    }

    public final long zzp(long j) {
        return (j * this.zzhu) / KILOBYTES.zzhu;
    }
}
