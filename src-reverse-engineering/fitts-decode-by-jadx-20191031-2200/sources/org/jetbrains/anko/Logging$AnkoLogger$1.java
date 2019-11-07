package org.jetbrains.anko;

import org.jetbrains.annotations.NotNull;

public final class Logging$AnkoLogger$1 implements AnkoLogger {
    final /* synthetic */ Class $clazz;
    @NotNull
    private final String loggerTag;

    Logging$AnkoLogger$1(Class cls) {
        this.$clazz = cls;
        this.loggerTag = Logging.getTag(cls);
    }

    @NotNull
    public String getLoggerTag() {
        return this.loggerTag;
    }
}
