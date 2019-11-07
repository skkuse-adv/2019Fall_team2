package kr.co.popone.fitts.di.module;

import java.io.File;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.http.GlobeHttpHandler;
import okhttp3.HttpUrl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class GlobeConfigModule {
    public static final Companion Companion = new Companion(null);
    private final HttpUrl mApiUrl;
    private final GlobeHttpHandler mHandler;

    public static final class Builder {
        @NotNull
        private HttpUrl apiUrl;
        @Nullable
        private File cacheFile;
        @Nullable
        private GlobeHttpHandler handler;

        public Builder(@NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "baseUrl");
            HttpUrl parse = HttpUrl.parse(str);
            if (parse == null) {
                Intrinsics.throwNpe();
            }
            this.apiUrl = parse;
        }

        @NotNull
        public final HttpUrl getApiUrl() {
            return this.apiUrl;
        }

        public final void setApiUrl(@NotNull HttpUrl httpUrl) {
            Intrinsics.checkParameterIsNotNull(httpUrl, "<set-?>");
            this.apiUrl = httpUrl;
        }

        @Nullable
        public final GlobeHttpHandler getHandler() {
            return this.handler;
        }

        public final void setHandler(@Nullable GlobeHttpHandler globeHttpHandler) {
            this.handler = globeHttpHandler;
        }

        @Nullable
        public final File getCacheFile() {
            return this.cacheFile;
        }

        public final void setCacheFile(@Nullable File file) {
            this.cacheFile = file;
        }

        @NotNull
        public final Builder globeHttpHandler(@NotNull GlobeHttpHandler globeHttpHandler) {
            Intrinsics.checkParameterIsNotNull(globeHttpHandler, "handler");
            this.handler = globeHttpHandler;
            return this;
        }

        @NotNull
        public final GlobeConfigModule build() {
            return new GlobeConfigModule(this, null);
        }
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Builder builder(@NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "baseUrl");
            return new Builder(str);
        }
    }

    private GlobeConfigModule(Builder builder) {
        this.mApiUrl = builder.getApiUrl();
        this.mHandler = builder.getHandler();
        builder.getCacheFile();
    }

    public /* synthetic */ GlobeConfigModule(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    @NotNull
    public final HttpUrl provideBaseUrl$app_productionFittsRelease() {
        return this.mApiUrl;
    }

    @NotNull
    public final GlobeHttpHandler provideGlobeHttpHandler$app_productionFittsRelease() {
        GlobeHttpHandler globeHttpHandler = this.mHandler;
        return globeHttpHandler != null ? globeHttpHandler : GlobeHttpHandler.Companion.getEMPTY();
    }
}
