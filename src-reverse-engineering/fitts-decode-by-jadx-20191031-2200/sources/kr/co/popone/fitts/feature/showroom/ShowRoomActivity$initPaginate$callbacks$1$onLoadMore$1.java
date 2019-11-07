package kr.co.popone.fitts.feature.showroom;

import android.content.Intent;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import com.orhanobut.logger.Logger;
import io.reactivex.functions.BiConsumer;
import java.util.ArrayList;
import kr.co.popone.fitts.feature.intro.IntroActivity;
import kr.co.popone.fitts.model.post.PostAPI.Post;
import kr.co.popone.fitts.utils.Snackbar;
import retrofit2.HttpException;

final class ShowRoomActivity$initPaginate$callbacks$1$onLoadMore$1<T1, T2> implements BiConsumer<ArrayList<Post>, Throwable> {
    final /* synthetic */ ShowRoomActivity$initPaginate$callbacks$1 this$0;

    ShowRoomActivity$initPaginate$callbacks$1$onLoadMore$1(ShowRoomActivity$initPaginate$callbacks$1 showRoomActivity$initPaginate$callbacks$1) {
        this.this$0 = showRoomActivity$initPaginate$callbacks$1;
    }

    public final void accept(ArrayList<Post> arrayList, Throwable th) {
        this.this$0.$isLoadingData.element = false;
        if (arrayList != null) {
            if (arrayList.size() < this.this$0.this$0.getLimit()) {
                this.this$0.this$0.setTotalItemLoaded(true);
            }
            this.this$0.this$0.postList.addAll(arrayList);
            if (this.this$0.$recyclerView.getAdapter() != null) {
                Adapter adapter = this.this$0.$recyclerView.getAdapter();
                if (adapter != null) {
                    adapter.notifyItemRangeInserted((this.this$0.this$0.postList.size() + 1) - arrayList.size(), arrayList.size());
                    return;
                }
                return;
            }
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("error occured ");
        sb.append(th);
        Logger.d(sb.toString(), new Object[0]);
        if (!(th instanceof HttpException)) {
            Snackbar.Companion.showMessage(this.this$0.this$0, "죄송합니다.\n서비스가 잠시 지연되고 있습니다.\n잠시 후 다시 이용해주세요.");
        } else if (((HttpException) th).code() == 401) {
            Intent intent = new Intent(this.this$0.this$0, IntroActivity.class);
            intent.addFlags(32768);
            intent.addFlags(268435456);
            this.this$0.this$0.startActivity(intent);
        }
    }
}
