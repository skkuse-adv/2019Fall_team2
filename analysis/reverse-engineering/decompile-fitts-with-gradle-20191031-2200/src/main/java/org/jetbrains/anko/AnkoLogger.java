package org.jetbrains.anko;

import org.jetbrains.annotations.NotNull;

public interface AnkoLogger {

    public static final class DefaultImpls {
        @NotNull
        public static String getLoggerTag(AnkoLogger ankoLogger) {
            return Logging.getTag(ankoLogger.getClass());
        }
    }

    @NotNull
    String getLoggerTag();
}
