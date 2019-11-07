package kr.co.popone.fitts.http;

import okhttp3.Interceptor.Chain;
import okhttp3.Request;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface GlobeHttpHandler {
    public static final Companion Companion = Companion.$$INSTANCE;

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        @NotNull
        private static final GlobeHttpHandler EMPTY = new GlobeHttpHandler$Companion$EMPTY$1();

        private Companion() {
        }

        @NotNull
        public final GlobeHttpHandler getEMPTY() {
            return EMPTY;
        }
    }

    @Nullable
    Request onHttpRequestBefore(@NotNull Chain chain, @NotNull Request request);
}
