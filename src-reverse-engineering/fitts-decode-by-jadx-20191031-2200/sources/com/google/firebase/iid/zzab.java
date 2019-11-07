package com.google.firebase.iid;

import android.os.Bundle;

final class zzab extends zzae<Void> {
    zzab(int i, int i2, Bundle bundle) {
        super(i, 2, bundle);
    }

    /* access modifiers changed from: 0000 */
    public final boolean zza() {
        return true;
    }

    /* access modifiers changed from: 0000 */
    public final void zza(Bundle bundle) {
        if (bundle.getBoolean("ack", false)) {
            zza(null);
        } else {
            zza(new zzad(4, "Invalid response to one way request"));
        }
    }
}
