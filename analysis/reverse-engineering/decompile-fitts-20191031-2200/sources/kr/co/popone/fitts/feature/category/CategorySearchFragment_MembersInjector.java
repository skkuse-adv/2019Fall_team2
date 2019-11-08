package kr.co.popone.fitts.feature.category;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.model.log.ActionLogAPI;
import kr.co.popone.fitts.repository.CategoryRepository;

public final class CategorySearchFragment_MembersInjector implements MembersInjector<CategorySearchFragment> {
    private final Provider<ActionLogAPI> actionLogAPIProvider;
    private final Provider<CategoryRepository> categoryRepositoryProvider;
    private final Provider<EventTracker> eventTrackerProvider;

    public CategorySearchFragment_MembersInjector(Provider<CategoryRepository> provider, Provider<EventTracker> provider2, Provider<ActionLogAPI> provider3) {
        this.categoryRepositoryProvider = provider;
        this.eventTrackerProvider = provider2;
        this.actionLogAPIProvider = provider3;
    }

    public static MembersInjector<CategorySearchFragment> create(Provider<CategoryRepository> provider, Provider<EventTracker> provider2, Provider<ActionLogAPI> provider3) {
        return new CategorySearchFragment_MembersInjector(provider, provider2, provider3);
    }

    public void injectMembers(CategorySearchFragment categorySearchFragment) {
        injectCategoryRepository(categorySearchFragment, (CategoryRepository) this.categoryRepositoryProvider.get());
        injectEventTracker(categorySearchFragment, (EventTracker) this.eventTrackerProvider.get());
        injectActionLogAPI(categorySearchFragment, (ActionLogAPI) this.actionLogAPIProvider.get());
    }

    public static void injectCategoryRepository(CategorySearchFragment categorySearchFragment, CategoryRepository categoryRepository) {
        categorySearchFragment.categoryRepository = categoryRepository;
    }

    public static void injectEventTracker(CategorySearchFragment categorySearchFragment, EventTracker eventTracker) {
        categorySearchFragment.eventTracker = eventTracker;
    }

    public static void injectActionLogAPI(CategorySearchFragment categorySearchFragment, ActionLogAPI actionLogAPI) {
        categorySearchFragment.actionLogAPI = actionLogAPI;
    }
}
