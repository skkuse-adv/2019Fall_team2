package kr.co.popone.fitts.http;

import com.orhanobut.logger.Logger;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class RequestIntercept implements Interceptor {
    public static final Companion Companion = new Companion(null);
    private final GlobeHttpHandler mHandler;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String parseParams(@NotNull RequestBody requestBody, @NotNull Buffer buffer) throws UnsupportedEncodingException {
            Intrinsics.checkParameterIsNotNull(requestBody, "body");
            Intrinsics.checkParameterIsNotNull(buffer, "requestbuffer");
            if (requestBody.contentType() == null || StringsKt__StringsKt.contains$default((CharSequence) String.valueOf(requestBody.contentType()), (CharSequence) "multipart", false, 2, (Object) null)) {
                return "null";
            }
            String decode = URLDecoder.decode(buffer.readUtf8(), "UTF-8");
            Intrinsics.checkExpressionValueIsNotNull(decode, "URLDecoder.decode(reques…ffer.readUtf8(), \"UTF-8\")");
            return decode;
        }
    }

    public RequestIntercept(@Nullable GlobeHttpHandler globeHttpHandler) {
        this.mHandler = globeHttpHandler;
    }

    @Nullable
    public Response intercept(@NotNull Chain chain) throws IOException {
        String str;
        Intrinsics.checkParameterIsNotNull(chain, "chain");
        Request request = chain.request();
        GlobeHttpHandler globeHttpHandler = this.mHandler;
        if (globeHttpHandler != null) {
            Intrinsics.checkExpressionValueIsNotNull(request, "request");
            request = globeHttpHandler.onHttpRequestBefore(chain, request);
        }
        Buffer buffer = new Buffer();
        if (request.body() != null) {
            RequestBody body = request.body();
            if (body == null) {
                Intrinsics.throwNpe();
            }
            body.writeTo(buffer);
        } else {
            Logger.w("request.body() == null", new Object[0]);
        }
        Object[] objArr = new Object[4];
        objArr[0] = request.url();
        if (request.body() != null) {
            Companion companion = Companion;
            RequestBody body2 = request.body();
            if (body2 == null) {
                Intrinsics.throwNpe();
            }
            Intrinsics.checkExpressionValueIsNotNull(body2, "request.body()!!");
            str = companion.parseParams(body2, buffer);
        } else {
            str = "null";
        }
        objArr[1] = str;
        objArr[2] = chain.connection();
        objArr[3] = request.headers();
        Logger.w("Sending Request %s on %n Params --->  %s%n Connection ---> %s%n Headers ---> %s", objArr);
        long nanoTime = System.nanoTime();
        Response proceed = chain.proceed(request);
        double nanoTime2 = (double) (System.nanoTime() - nanoTime);
        Double.isNaN(nanoTime2);
        Logger.w("Received response  in %.1fms%n%s", Double.valueOf(nanoTime2 / 1000000.0d), proceed.headers());
        return proceed;
    }
}
