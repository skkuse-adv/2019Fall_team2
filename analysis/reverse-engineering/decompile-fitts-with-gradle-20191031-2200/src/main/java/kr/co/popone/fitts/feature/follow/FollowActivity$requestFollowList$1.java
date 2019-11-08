package kr.co.popone.fitts.feature.follow;

import android.content.Intent;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import com.orhanobut.logger.Logger;
import com.paginate.Paginate;
import io.reactivex.functions.BiConsumer;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.feature.intro.IntroActivity;
import kr.co.popone.fitts.model.datamodel.service.user.User;
import kr.co.popone.fitts.utils.Snackbar;
import retrofit2.HttpException;

final class FollowActivity$requestFollowList$1<T1, T2> implements BiConsumer<List<? extends User>, Throwable> {
    final /* synthetic */ FollowActivity this$0;

    FollowActivity$requestFollowList$1(FollowActivity followActivity) {
        this.this$0 = followActivity;
    }

    public final void accept(List<User> list, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append("{followListResult: ");
        sb.append(list);
        sb.append(", throwable: ");
        sb.append(th);
        sb.append('}');
        Logger.d(sb.toString(), new Object[0]);
        this.this$0.isLoadingData = false;
        this.this$0.followListRequest = null;
        if (list != null) {
            if (list.size() < this.this$0.limit) {
                this.this$0.isTotalItemLoaded = true;
                Paginate access$getPaginate$p = this.this$0.paginate;
                if (access$getPaginate$p != null) {
                    access$getPaginate$p.setHasMoreDataToLoad(!this.this$0.isTotalItemLoaded);
                }
            }
            if (!list.isEmpty()) {
                this.this$0.base = Long.valueOf(((User) list.get(list.size() - 1)).getId());
            }
            String str = "followListRecyclerView";
            if (this.this$0.userList.isEmpty()) {
                this.this$0.isTotalItemLoaded = false;
                this.this$0.userList = list;
                RecyclerView recyclerView = (RecyclerView) this.this$0._$_findCachedViewById(C0010R$id.followListRecyclerView);
                Intrinsics.checkExpressionValueIsNotNull(recyclerView, str);
                Adapter adapter = recyclerView.getAdapter();
                if (adapter != null) {
                    adapter.notifyDataSetChanged();
                    return;
                }
                return;
            }
            FollowActivity followActivity = this.this$0;
            followActivity.userList = CollectionsKt___CollectionsKt.plus((Collection<? extends T>) followActivity.userList, (Iterable<? extends T>) list);
            RecyclerView recyclerView2 = (RecyclerView) this.this$0._$_findCachedViewById(C0010R$id.followListRecyclerView);
            Intrinsics.checkExpressionValueIsNotNull(recyclerView2, str);
            Adapter adapter2 = recyclerView2.getAdapter();
            if (adapter2 != null) {
                adapter2.notifyItemRangeInserted((this.this$0.userList.size() + 1) - list.size(), list.size());
                return;
            }
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("error occured ");
        sb2.append(th);
        Logger.d(sb2.toString(), new Object[0]);
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
