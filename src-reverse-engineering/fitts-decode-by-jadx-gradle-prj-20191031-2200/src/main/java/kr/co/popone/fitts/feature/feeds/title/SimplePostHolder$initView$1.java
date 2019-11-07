package kr.co.popone.fitts.feature.feeds.title;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.model.post.PostAPI.CategoryPostItem;

final class SimplePostHolder$initView$1 implements OnClickListener {
    final /* synthetic */ CategoryPostItem $item;
    final /* synthetic */ SimplePostHolder this$0;

    SimplePostHolder$initView$1(SimplePostHolder simplePostHolder, CategoryPostItem categoryPostItem) {
        this.this$0 = simplePostHolder;
        this.$item = categoryPostItem;
    }

    public final void onClick(View view) {
        this.this$0.delegate.onPostClick(this.$item.getPost().getId());
    }
}
