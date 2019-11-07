package kr.co.popone.fitts.feature.intro;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.eventtracker.EventTracker;

public final class IntroLoginFragment_MembersInjector implements MembersInjector<IntroLoginFragment> {
    private final Provider<EventTracker> eventTrackerProvider;

    public IntroLoginFragment_MembersInjector(Provider<EventTracker> provider) {
        this.eventTrackerProvider = provider;
    }

    public static MembersInjector<IntroLoginFragment> create(Provider<EventTracker> provider) {
        return new IntroLoginFragment_MembersInjector(provider);
    }

    public void injectMembers(IntroLoginFragment introLoginFragment) {
        injectEventTracker(introLoginFragment, (EventTracker) this.eventTrackerProvider.get());
    }

    public static void injectEventTracker(IntroLoginFragment introLoginFragment, EventTracker eventTracker) {
        introLoginFragment.eventTracker = eventTracker;
    }
}
