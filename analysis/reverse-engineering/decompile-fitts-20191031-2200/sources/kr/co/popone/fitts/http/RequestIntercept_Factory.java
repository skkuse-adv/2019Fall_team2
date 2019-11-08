package kr.co.popone.fitts.http;

import dagger.internal.Factory;
import javax.inject.Provider;

public final class RequestIntercept_Factory implements Factory<RequestIntercept> {
    private final Provider<GlobeHttpHandler> mHandlerProvider;

    public RequestIntercept_Factory(Provider<GlobeHttpHandler> provider) {
        this.mHandlerProvider = provider;
    }

    public RequestIntercept get() {
        return provideInstance(this.mHandlerProvider);
    }

    public static RequestIntercept provideInstance(Provider<GlobeHttpHandler> provider) {
        return new RequestIntercept((GlobeHttpHandler) provider.get());
    }

    public static RequestIntercept_Factory create(Provider<GlobeHttpHandler> provider) {
        return new RequestIntercept_Factory(provider);
    }

    public static RequestIntercept newRequestIntercept(GlobeHttpHandler globeHttpHandler) {
        return new RequestIntercept(globeHttpHandler);
    }
}
