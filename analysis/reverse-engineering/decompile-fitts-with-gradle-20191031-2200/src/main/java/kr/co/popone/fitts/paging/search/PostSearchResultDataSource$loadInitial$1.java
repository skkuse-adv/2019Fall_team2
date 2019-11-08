package kr.co.popone.fitts.paging.search;

import androidx.paging.ItemKeyedDataSource.LoadInitialCallback;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.List;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.model.post.PostAPI.Post;
import kr.co.popone.fitts.model.remote.search.KeywordSearchPostResult;
import kr.co.popone.fitts.model.search.SearchResult.PostSearchResult;
import kr.co.popone.fitts.model.search.SearchResult.SearchResultCount;

final class PostSearchResultDataSource$loadInitial$1<T> implements Consumer<KeywordSearchPostResult> {
    final /* synthetic */ LoadInitialCallback $callback;
    final /* synthetic */ PostSearchResultDataSource this$0;

    PostSearchResultDataSource$loadInitial$1(PostSearchResultDataSource postSearchResultDataSource, LoadInitialCallback loadInitialCallback) {
        this.this$0 = postSearchResultDataSource;
        this.$callback = loadInitialCallback;
    }

    public final void accept(KeywordSearchPostResult keywordSearchPostResult) {
        this.this$0.getNetworkStateLiveData().postValue(NetworkState.Companion.getINIT_LOADED());
        this.this$0.getEmptyListLiveData().postValue(Boolean.valueOf(keywordSearchPostResult.getCount() < 1));
        List[] listArr = new List[2];
        listArr[0] = CollectionsKt__CollectionsJVMKt.listOf(new SearchResultCount(keywordSearchPostResult.getCount(), "개의 포스트"));
        List<Post> posts = keywordSearchPostResult.getPosts();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(posts, 10));
        for (Post postSearchResult : posts) {
            arrayList.add(new PostSearchResult(postSearchResult));
        }
        listArr[1] = arrayList;
        this.$callback.onResult(CollectionsKt__IterablesKt.flatten(CollectionsKt__CollectionsKt.listOf(listArr)));
    }
}
