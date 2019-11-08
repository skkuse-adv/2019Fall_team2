package kr.co.popone.fitts.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.model.payment.PaymentAPI;
import retrofit2.Retrofit;

public final class ServiceModule_ProvidePaymentAPIFactory implements Factory<PaymentAPI> {
    private final ServiceModule module;
    private final Provider<Retrofit> retrofitProvider;

    public ServiceModule_ProvidePaymentAPIFactory(ServiceModule serviceModule, Provider<Retrofit> provider) {
        this.module = serviceModule;
        this.retrofitProvider = provider;
    }

    public PaymentAPI get() {
        return provideInstance(this.module, this.retrofitProvider);
    }

    public static PaymentAPI provideInstance(ServiceModule serviceModule, Provider<Retrofit> provider) {
        return proxyProvidePaymentAPI(serviceModule, (Retrofit) provider.get());
    }

    public static ServiceModule_ProvidePaymentAPIFactory create(ServiceModule serviceModule, Provider<Retrofit> provider) {
        return new ServiceModule_ProvidePaymentAPIFactory(serviceModule, provider);
    }

    public static PaymentAPI proxyProvidePaymentAPI(ServiceModule serviceModule, Retrofit retrofit) {
        return (PaymentAPI) Preconditions.checkNotNull(serviceModule.providePaymentAPI(retrofit), "Cannot return null from a non-@Nullable @Provides method");
    }
}
