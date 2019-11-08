package kr.co.popone.fitts.feature.store.browser;

import androidx.lifecycle.Observer;
import java.util.List;
import kr.co.popone.fitts.feature.dialog.ProductPostDialog;
import kr.co.popone.fitts.feature.dialog.ProductPostDialog.Builder;
import kr.co.popone.fitts.model.post.PostAPI.Post;
import org.jetbrains.annotations.Nullable;

final class StoreBrowserActivity$onCreate$41<T> implements Observer<List<? extends Post>> {
    final /* synthetic */ StoreBrowserActivity this$0;

    StoreBrowserActivity$onCreate$41(StoreBrowserActivity storeBrowserActivity) {
        this.this$0 = storeBrowserActivity;
    }

    public final void onChanged(@Nullable List<Post> list) {
        if (list != null) {
            ProductPostDialog build = new Builder().setDelegation(this.this$0).setProductPosts(list).build(this.this$0);
            if (build != null) {
                build.show();
            }
        }
    }
}
