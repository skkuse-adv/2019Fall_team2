package kr.co.popone.fitts.paging.search;

import androidx.paging.ItemKeyedDataSource.LoadCallback;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.List;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.model.post.PostAPI.Post;
import kr.co.popone.fitts.model.remote.search.KeywordSearchPostResult;
import kr.co.popone.fitts.model.search.SearchResult.PostSearchResult;

final class PostSearchResultDataSource$loadAfter$1<T> implements Consumer<KeywordSearchPostResult> {
    final /* synthetic */ LoadCallback $callback;
    final /* synthetic */ PostSearchResultDataSource this$0;

    PostSearchResultDataSource$loadAfter$1(PostSearchResultDataSource postSearchResultDataSource, LoadCallback loadCallback) {
        this.this$0 = postSearchResultDataSource;
        this.$callback = loadCallback;
    }

    public final void accept(KeywordSearchPostResult keywordSearchPostResult) {
        this.this$0.getNetworkStateLiveData().postValue(NetworkState.Companion.getLOADED());
        LoadCallback loadCallback = this.$callback;
        List<Post> posts = keywordSearchPostResult.getPosts();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(posts, 10));
        for (Post postSearchResult : posts) {
            arrayList.add(new PostSearchResult(postSearchResult));
        }
        loadCallback.onResult(arrayList);
    }
}
