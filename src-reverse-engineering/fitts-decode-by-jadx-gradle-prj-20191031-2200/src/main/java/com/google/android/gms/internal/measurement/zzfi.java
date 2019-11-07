package com.google.android.gms.internal.measurement;

import java.io.IOException;

public class zzfi extends IOException {
    public zzfi(String str) {
        super(str);
    }

    public final zzfi zzg(zzgi zzgi) {
        return this;
    }

    static zzfi zzut() {
        return new zzfi("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    static zzfi zzuu() {
        return new zzfi("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static zzfi zzuv() {
        return new zzfi("CodedInputStream encountered a malformed varint.");
    }

    static zzfi zzuw() {
        return new zzfi("Protocol message contained an invalid tag (zero).");
    }

    static zzfi zzux() {
        return new zzfi("Protocol message end-group tag did not match expected tag.");
    }

    static zzfh zzuy() {
        return new zzfh("Protocol message tag had invalid wire type.");
    }

    static zzfi zzuz() {
        return new zzfi("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    static zzfi zzva() {
        return new zzfi("Failed to parse the message.");
    }

    static zzfi zzvb() {
        return new zzfi("Protocol message had invalid UTF-8.");
    }
}
