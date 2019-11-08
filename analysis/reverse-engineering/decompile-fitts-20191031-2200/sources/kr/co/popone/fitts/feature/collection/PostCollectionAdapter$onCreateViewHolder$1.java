package kr.co.popone.fitts.feature.collection;

import kr.co.popone.fitts.feature.collection.PostImagesAdapter.Delegate;

public final class PostCollectionAdapter$onCreateViewHolder$1 implements Delegate {
    final /* synthetic */ PostCollectionAdapter this$0;

    PostCollectionAdapter$onCreateViewHolder$1(PostCollectionAdapter postCollectionAdapter) {
        this.this$0 = postCollectionAdapter;
    }

    public void onShowPost(int i) {
        this.this$0.delegate.showPost(i);
    }
}
