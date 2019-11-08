package kr.co.popone.fitts.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.http.RequestIntercept;
import okhttp3.Interceptor;

public final class ClientModule_ProvideIntercept$app_productionFittsReleaseFactory implements Factory<Interceptor> {
    private final Provider<RequestIntercept> interceptProvider;
    private final ClientModule module;

    public ClientModule_ProvideIntercept$app_productionFittsReleaseFactory(ClientModule clientModule, Provider<RequestIntercept> provider) {
        this.module = clientModule;
        this.interceptProvider = provider;
    }

    public Interceptor get() {
        return provideInstance(this.module, this.interceptProvider);
    }

    public static Interceptor provideInstance(ClientModule clientModule, Provider<RequestIntercept> provider) {
        return proxyProvideIntercept$app_productionFittsRelease(clientModule, (RequestIntercept) provider.get());
    }

    public static ClientModule_ProvideIntercept$app_productionFittsReleaseFactory create(ClientModule clientModule, Provider<RequestIntercept> provider) {
        return new ClientModule_ProvideIntercept$app_productionFittsReleaseFactory(clientModule, provider);
    }

    public static Interceptor proxyProvideIntercept$app_productionFittsRelease(ClientModule clientModule, RequestIntercept requestIntercept) {
        return (Interceptor) Preconditions.checkNotNull(clientModule.provideIntercept$app_productionFittsRelease(requestIntercept), "Cannot return null from a non-@Nullable @Provides method");
    }
}
