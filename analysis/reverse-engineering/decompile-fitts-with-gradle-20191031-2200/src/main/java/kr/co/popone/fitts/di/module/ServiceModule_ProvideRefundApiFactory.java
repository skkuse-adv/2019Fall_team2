package kr.co.popone.fitts.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.model.remote.refund.RefundApi;
import retrofit2.Retrofit;

public final class ServiceModule_ProvideRefundApiFactory implements Factory<RefundApi> {
    private final ServiceModule module;
    private final Provider<Retrofit> retrofitProvider;

    public ServiceModule_ProvideRefundApiFactory(ServiceModule serviceModule, Provider<Retrofit> provider) {
        this.module = serviceModule;
        this.retrofitProvider = provider;
    }

    public RefundApi get() {
        return provideInstance(this.module, this.retrofitProvider);
    }

    public static RefundApi provideInstance(ServiceModule serviceModule, Provider<Retrofit> provider) {
        return proxyProvideRefundApi(serviceModule, (Retrofit) provider.get());
    }

    public static ServiceModule_ProvideRefundApiFactory create(ServiceModule serviceModule, Provider<Retrofit> provider) {
        return new ServiceModule_ProvideRefundApiFactory(serviceModule, provider);
    }

    public static RefundApi proxyProvideRefundApi(ServiceModule serviceModule, Retrofit retrofit) {
        return (RefundApi) Preconditions.checkNotNull(serviceModule.provideRefundApi(retrofit), "Cannot return null from a non-@Nullable @Provides method");
    }
}
