package kr.co.popone.fitts.feature.showroom;

import android.content.Intent;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import com.orhanobut.logger.Logger;
import io.reactivex.functions.BiConsumer;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.feature.intro.IntroActivity;
import kr.co.popone.fitts.model.post.PostAPI.Post;
import kr.co.popone.fitts.utils.Snackbar;
import retrofit2.HttpException;

final class ShowRoomActivity$loadShowroomData$3<T1, T2> implements BiConsumer<ArrayList<Post>, Throwable> {
    final /* synthetic */ ShowRoomActivity this$0;

    ShowRoomActivity$loadShowroomData$3(ShowRoomActivity showRoomActivity) {
        this.this$0 = showRoomActivity;
    }

    public final void accept(ArrayList<Post> arrayList, Throwable th) {
        LayoutManager layoutManager;
        this.this$0.showRoomRequest = null;
        if (arrayList != null) {
            this.this$0.postList = arrayList;
            if (arrayList.size() < this.this$0.getLimit()) {
                this.this$0.setTotalItemLoaded(true);
            }
            RecyclerView recyclerView = (RecyclerView) this.this$0._$_findCachedViewById(C0010R$id.post_list);
            String str = "post_list";
            Intrinsics.checkExpressionValueIsNotNull(recyclerView, str);
            if (this.this$0.isLinear()) {
                layoutManager = ShowRoomActivity.access$getLinearLayoutManager$p(this.this$0);
            } else if (this.this$0.postList.isEmpty()) {
                layoutManager = ShowRoomActivity.access$getLinearLayoutManager$p(this.this$0);
            } else {
                layoutManager = ShowRoomActivity.access$getGridLayoutManager$p(this.this$0);
            }
            recyclerView.setLayoutManager(layoutManager);
            RecyclerView recyclerView2 = (RecyclerView) this.this$0._$_findCachedViewById(C0010R$id.post_list);
            Intrinsics.checkExpressionValueIsNotNull(recyclerView2, str);
            Adapter adapter = recyclerView2.getAdapter();
            if (adapter != null) {
                adapter.notifyItemRangeInserted((this.this$0.postList.size() + 1) - arrayList.size(), arrayList.size());
            }
            ShowRoomActivity showRoomActivity = this.this$0;
            RecyclerView recyclerView3 = (RecyclerView) showRoomActivity._$_findCachedViewById(C0010R$id.post_list);
            Intrinsics.checkExpressionValueIsNotNull(recyclerView3, str);
            showRoomActivity.initPaginate(recyclerView3);
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
            this.this$0.startActivity(intent);
        }
    }
}
