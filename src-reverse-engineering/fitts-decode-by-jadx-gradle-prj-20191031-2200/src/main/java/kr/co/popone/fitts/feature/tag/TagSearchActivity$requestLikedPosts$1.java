package kr.co.popone.fitts.feature.tag;

import android.content.Intent;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import com.orhanobut.logger.Logger;
import com.paginate.Paginate;
import io.reactivex.functions.BiConsumer;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.feature.intro.IntroActivity;
import kr.co.popone.fitts.model.post.PostAPI.Post;
import kr.co.popone.fitts.utils.Snackbar;
import retrofit2.HttpException;

final class TagSearchActivity$requestLikedPosts$1<T1, T2> implements BiConsumer<ArrayList<Post>, Throwable> {
    final /* synthetic */ TagSearchActivity this$0;

    TagSearchActivity$requestLikedPosts$1(TagSearchActivity tagSearchActivity) {
        this.this$0 = tagSearchActivity;
    }

    public final void accept(ArrayList<Post> arrayList, Throwable th) {
        this.this$0.isLoadingData = false;
        this.this$0.tagPostListRequest = null;
        if (arrayList != null) {
            if (arrayList.size() < this.this$0.getLimit()) {
                this.this$0.setTotalItemLoaded(true);
                Paginate access$getPaginate$p = this.this$0.paginate;
                if (access$getPaginate$p != null) {
                    access$getPaginate$p.setHasMoreDataToLoad(!this.this$0.isTotalItemLoaded());
                }
            }
            if (!arrayList.isEmpty()) {
                this.this$0.setBase$app_productionFittsRelease(Long.valueOf(((Post) arrayList.get(arrayList.size() - 1)).getId()));
            }
            String str = "tag_post_list";
            if (this.this$0.tagPostList.isEmpty()) {
                this.this$0.setTotalItemLoaded(false);
                this.this$0.tagPostList = arrayList;
                RecyclerView recyclerView = (RecyclerView) this.this$0._$_findCachedViewById(C0010R$id.tag_post_list);
                Intrinsics.checkExpressionValueIsNotNull(recyclerView, str);
                Adapter adapter = recyclerView.getAdapter();
                if (adapter != null) {
                    adapter.notifyDataSetChanged();
                    return;
                }
                return;
            }
            this.this$0.tagPostList.addAll(arrayList);
            RecyclerView recyclerView2 = (RecyclerView) this.this$0._$_findCachedViewById(C0010R$id.tag_post_list);
            Intrinsics.checkExpressionValueIsNotNull(recyclerView2, str);
            Adapter adapter2 = recyclerView2.getAdapter();
            if (adapter2 != null) {
                adapter2.notifyItemRangeInserted((this.this$0.tagPostList.size() + 1) - arrayList.size(), arrayList.size());
                return;
            }
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("error occured ");
        sb.append(th);
        Logger.d(sb.toString(), new Object[0]);
        if (!(th instanceof HttpException)) {
            Snackbar.Companion.showMessage(this.this$0, "죄송합니다.\n서비스가 잠시 지연되고 있습니다.\n잠시 후 다시 이용해주세요.");
        } else if (((HttpException) th).code() == 401) {
            Intent intent = new Intent(this.this$0, IntroActivity.class);
            intent.addFlags(32768);
            intent.addFlags(268435456);
            this.this$0.startActivity(intent, null);
        }
    }
}
