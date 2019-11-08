package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzit extends IOException {
    public zzit(String str) {
        super(str);
    }

    public zzit(String str, Exception exc) {
        super(str, exc);
    }

    static zzit zzxd() {
        return new zzit("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    }

    static zzit zzxe() {
        return new zzit("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static zzit zzxf() {
        return new zzit("CodedInputStream encountered a malformed varint.");
    }
}
