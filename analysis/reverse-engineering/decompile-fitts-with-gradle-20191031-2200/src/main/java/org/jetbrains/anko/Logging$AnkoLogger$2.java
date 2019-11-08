package org.jetbrains.anko;

import kotlin._Assertions;
import org.jetbrains.annotations.NotNull;

public final class Logging$AnkoLogger$2 implements AnkoLogger {
    final /* synthetic */ String $tag;
    @NotNull
    private final String loggerTag;

    Logging$AnkoLogger$2(String str) {
        this.$tag = str;
        boolean z = str.length() <= 23;
        if (!_Assertions.ENABLED || z) {
            this.loggerTag = str;
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("The maximum tag length is 23, got ");
        sb.append(this.$tag);
        throw new AssertionError(sb.toString());
    }

    @NotNull
    public String getLoggerTag() {
        return this.loggerTag;
    }
}
