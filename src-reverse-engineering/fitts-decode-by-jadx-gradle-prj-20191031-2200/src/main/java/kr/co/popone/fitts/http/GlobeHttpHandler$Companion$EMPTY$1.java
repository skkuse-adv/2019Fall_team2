package kr.co.popone.fitts.http;

import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor.Chain;
import okhttp3.Request;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class GlobeHttpHandler$Companion$EMPTY$1 implements GlobeHttpHandler {
    @Nullable
    public Request onHttpRequestBefore(@NotNull Chain chain, @NotNull Request request) {
        Intrinsics.checkParameterIsNotNull(chain, "chain");
        Intrinsics.checkParameterIsNotNull(request, "request");
        return null;
    }

    GlobeHttpHandler$Companion$EMPTY$1() {
    }
}
