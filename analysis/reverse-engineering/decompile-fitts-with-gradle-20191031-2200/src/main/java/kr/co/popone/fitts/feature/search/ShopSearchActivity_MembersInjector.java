package kr.co.popone.fitts.feature.search;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.model.search.SearchAPI;
import kr.co.popone.fitts.model.search.SearchHistoryRepository;

public final class ShopSearchActivity_MembersInjector implements MembersInjector<ShopSearchActivity> {
    private final Provider<SearchAPI> searchAPIProvider;
    private final Provider<SearchHistoryRepository> searchHistoryRepositoryProvider;

    public ShopSearchActivity_MembersInjector(Provider<SearchAPI> provider, Provider<SearchHistoryRepository> provider2) {
        this.searchAPIProvider = provider;
        this.searchHistoryRepositoryProvider = provider2;
    }

    public static MembersInjector<ShopSearchActivity> create(Provider<SearchAPI> provider, Provider<SearchHistoryRepository> provider2) {
        return new ShopSearchActivity_MembersInjector(provider, provider2);
    }

    public void injectMembers(ShopSearchActivity shopSearchActivity) {
        injectSearchAPI(shopSearchActivity, (SearchAPI) this.searchAPIProvider.get());
        injectSearchHistoryRepository(shopSearchActivity, (SearchHistoryRepository) this.searchHistoryRepositoryProvider.get());
    }

    public static void injectSearchAPI(ShopSearchActivity shopSearchActivity, SearchAPI searchAPI) {
        shopSearchActivity.searchAPI = searchAPI;
    }

    public static void injectSearchHistoryRepository(ShopSearchActivity shopSearchActivity, SearchHistoryRepository searchHistoryRepository) {
        shopSearchActivity.searchHistoryRepository = searchHistoryRepository;
    }
}
