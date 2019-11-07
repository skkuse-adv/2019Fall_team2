package kr.co.popone.fitts.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.model.coupon.CouponAPI;
import retrofit2.Retrofit;

public final class ServiceModule_ProvideCouponAPIFactory implements Factory<CouponAPI> {
    private final ServiceModule module;
    private final Provider<Retrofit> retrofitProvider;

    public ServiceModule_ProvideCouponAPIFactory(ServiceModule serviceModule, Provider<Retrofit> provider) {
        this.module = serviceModule;
        this.retrofitProvider = provider;
    }

    public CouponAPI get() {
        return provideInstance(this.module, this.retrofitProvider);
    }

    public static CouponAPI provideInstance(ServiceModule serviceModule, Provider<Retrofit> provider) {
        return proxyProvideCouponAPI(serviceModule, (Retrofit) provider.get());
    }

    public static ServiceModule_ProvideCouponAPIFactory create(ServiceModule serviceModule, Provider<Retrofit> provider) {
        return new ServiceModule_ProvideCouponAPIFactory(serviceModule, provider);
    }

    public static CouponAPI proxyProvideCouponAPI(ServiceModule serviceModule, Retrofit retrofit) {
        return (CouponAPI) Preconditions.checkNotNull(serviceModule.provideCouponAPI(retrofit), "Cannot return null from a non-@Nullable @Provides method");
    }
}
