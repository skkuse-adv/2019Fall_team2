package kr.co.popone.fitts.di.module;

import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.http.RequestIntercept;
import kr.co.popone.fitts.model.validation.RaveConverterFactory;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;
import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public final class ClientModule {
    public static final Companion Companion = new Companion(null);

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @NotNull
    public final Interceptor provideIntercept$app_productionFittsRelease(@NotNull RequestIntercept requestIntercept) {
        Intrinsics.checkParameterIsNotNull(requestIntercept, "intercept");
        return requestIntercept;
    }

    @NotNull
    public final Retrofit provideRetrofit$app_productionFittsRelease(@NotNull Builder builder, @NotNull OkHttpClient okHttpClient, @NotNull HttpUrl httpUrl) {
        Intrinsics.checkParameterIsNotNull(builder, "builder");
        Intrinsics.checkParameterIsNotNull(okHttpClient, "client");
        Intrinsics.checkParameterIsNotNull(httpUrl, "httpUrl");
        Retrofit build = builder.baseUrl(httpUrl).client(okHttpClient).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).addConverterFactory(RaveConverterFactory.Companion.create()).addConverterFactory(ScalarsConverterFactory.create()).addConverterFactory(GsonConverterFactory.create()).build();
        Intrinsics.checkExpressionValueIsNotNull(build, "builder\n                …\n                .build()");
        return build;
    }

    @NotNull
    public final OkHttpClient provideClient$app_productionFittsRelease(@NotNull OkHttpClient.Builder builder, @NotNull Interceptor interceptor) {
        Intrinsics.checkParameterIsNotNull(builder, "okHttpClient");
        Intrinsics.checkParameterIsNotNull(interceptor, "intercept");
        long j = (long) 60;
        OkHttpClient build = builder.connectTimeout(j, TimeUnit.SECONDS).readTimeout(j, TimeUnit.SECONDS).addNetworkInterceptor(interceptor).build();
        Intrinsics.checkExpressionValueIsNotNull(build, "builder\n                .build()");
        return build;
    }

    @NotNull
    public final Builder provideRetrofitBuilder$app_productionFittsRelease() {
        return new Builder();
    }

    @NotNull
    public final OkHttpClient.Builder provideClientBuilder$app_productionFittsRelease() {
        return new OkHttpClient.Builder();
    }
}
