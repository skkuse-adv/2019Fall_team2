package kr.co.popone.fitts.viewmodel.refund.apply;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.feature.refund.RefundApplyActivity;

public final class RefundModule_ProvideRefundViewModelFactory implements Factory<RefundViewModel> {
    private final Provider<RefundApplyActivity> activityProvider;
    private final RefundModule module;
    private final Provider<RefundViewModelFactory> viewModelFactoryProvider;

    public RefundModule_ProvideRefundViewModelFactory(RefundModule refundModule, Provider<RefundApplyActivity> provider, Provider<RefundViewModelFactory> provider2) {
        this.module = refundModule;
        this.activityProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public RefundViewModel get() {
        return provideInstance(this.module, this.activityProvider, this.viewModelFactoryProvider);
    }

    public static RefundViewModel provideInstance(RefundModule refundModule, Provider<RefundApplyActivity> provider, Provider<RefundViewModelFactory> provider2) {
        return proxyProvideRefundViewModel(refundModule, (RefundApplyActivity) provider.get(), (RefundViewModelFactory) provider2.get());
    }

    public static RefundModule_ProvideRefundViewModelFactory create(RefundModule refundModule, Provider<RefundApplyActivity> provider, Provider<RefundViewModelFactory> provider2) {
        return new RefundModule_ProvideRefundViewModelFactory(refundModule, provider, provider2);
    }

    public static RefundViewModel proxyProvideRefundViewModel(RefundModule refundModule, RefundApplyActivity refundApplyActivity, RefundViewModelFactory refundViewModelFactory) {
        return (RefundViewModel) Preconditions.checkNotNull(refundModule.provideRefundViewModel(refundApplyActivity, refundViewModelFactory), "Cannot return null from a non-@Nullable @Provides method");
    }
}
