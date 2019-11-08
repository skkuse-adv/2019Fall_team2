package com.crashlytics.android.core;

import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class ProcMapEntryParser {
    private static final Pattern MAP_REGEX = Pattern.compile("\\s*(\\p{XDigit}+)-\\s*(\\p{XDigit}+)\\s+(.{4})\\s+\\p{XDigit}+\\s+.+\\s+\\d+\\s+(.*)");

    private ProcMapEntryParser() {
    }

    public static ProcMapEntry parse(String str) {
        Matcher matcher = MAP_REGEX.matcher(str);
        if (!matcher.matches()) {
            return null;
        }
        try {
            long longValue = Long.valueOf(matcher.group(1), 16).longValue();
            ProcMapEntry procMapEntry = new ProcMapEntry(longValue, Long.valueOf(matcher.group(2), 16).longValue() - longValue, matcher.group(3), matcher.group(4));
            return procMapEntry;
        } catch (Exception unused) {
            Logger logger = Fabric.getLogger();
            StringBuilder sb = new StringBuilder();
            sb.append("Could not parse map entry: ");
            sb.append(str);
            logger.d(CrashlyticsCore.TAG, sb.toString());
            return null;
        }
    }
}
