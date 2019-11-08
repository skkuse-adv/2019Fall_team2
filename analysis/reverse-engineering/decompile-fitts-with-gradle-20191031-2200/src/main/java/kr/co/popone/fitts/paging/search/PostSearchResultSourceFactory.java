package kr.co.popone.fitts.paging.search;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import androidx.paging.DataSource.Factory;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.search.view.SearchResultFragment;
import kr.co.popone.fitts.model.search.SearchResult;
import kr.co.popone.fitts.repository.SearchRepository;
import org.jetbrains.annotations.NotNull;

public final class PostSearchResultSourceFactory extends Factory<Long, SearchResult> {
    @NotNull
    private final String keyword;
    @NotNull
    private final MutableLiveData<PostSearchResultDataSource> postsResultSource = new MutableLiveData<>();
    @NotNull
    private final SearchRepository searchRepository;

    @NotNull
    public final String getKeyword() {
        return this.keyword;
    }

    @NotNull
    public final SearchRepository getSearchRepository() {
        return this.searchRepository;
    }

    public PostSearchResultSourceFactory(@NotNull String str, @NotNull SearchRepository searchRepository2) {
        Intrinsics.checkParameterIsNotNull(str, SearchResultFragment.KEY_KEYWORD);
        Intrinsics.checkParameterIsNotNull(searchRepository2, "searchRepository");
        this.keyword = str;
        this.searchRepository = searchRepository2;
    }

    @NotNull
    public final MutableLiveData<PostSearchResultDataSource> getPostsResultSource() {
        return this.postsResultSource;
    }

    @NotNull
    public DataSource<Long, SearchResult> create() {
        PostSearchResultDataSource postSearchResultDataSource = new PostSearchResultDataSource(this.keyword, this.searchRepository);
        this.postsResultSource.postValue(postSearchResultDataSource);
        return postSearchResultDataSource;
    }
}
