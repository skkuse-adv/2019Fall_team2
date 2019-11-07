package kr.co.popone.fitts.services;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.model.repository.service.FittsServiceRepository;

public final class FittsFirebaseMessagingService_MembersInjector implements MembersInjector<FittsFirebaseMessagingService> {
    private final Provider<FittsNotificationHandler> fittsNotificationHandlerProvider;
    private final Provider<FittsServiceRepository> serviceRepositoryProvider;
    private final Provider<SessionManager> sessionManagerProvider;

    public FittsFirebaseMessagingService_MembersInjector(Provider<FittsNotificationHandler> provider, Provider<FittsServiceRepository> provider2, Provider<SessionManager> provider3) {
        this.fittsNotificationHandlerProvider = provider;
        this.serviceRepositoryProvider = provider2;
        this.sessionManagerProvider = provider3;
    }

    public static MembersInjector<FittsFirebaseMessagingService> create(Provider<FittsNotificationHandler> provider, Provider<FittsServiceRepository> provider2, Provider<SessionManager> provider3) {
        return new FittsFirebaseMessagingService_MembersInjector(provider, provider2, provider3);
    }

    public void injectMembers(FittsFirebaseMessagingService fittsFirebaseMessagingService) {
        injectFittsNotificationHandler(fittsFirebaseMessagingService, (FittsNotificationHandler) this.fittsNotificationHandlerProvider.get());
        injectServiceRepository(fittsFirebaseMessagingService, (FittsServiceRepository) this.serviceRepositoryProvider.get());
        injectSessionManager(fittsFirebaseMessagingService, (SessionManager) this.sessionManagerProvider.get());
    }

    public static void injectFittsNotificationHandler(FittsFirebaseMessagingService fittsFirebaseMessagingService, FittsNotificationHandler fittsNotificationHandler) {
        fittsFirebaseMessagingService.fittsNotificationHandler = fittsNotificationHandler;
    }

    public static void injectServiceRepository(FittsFirebaseMessagingService fittsFirebaseMessagingService, FittsServiceRepository fittsServiceRepository) {
        fittsFirebaseMessagingService.serviceRepository = fittsServiceRepository;
    }

    public static void injectSessionManager(FittsFirebaseMessagingService fittsFirebaseMessagingService, SessionManager sessionManager) {
        fittsFirebaseMessagingService.sessionManager = sessionManager;
    }
}
