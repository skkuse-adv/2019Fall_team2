package kr.co.popone.fitts.feature.showroom;

import androidx.recyclerview.widget.RecyclerView;
import com.paginate.Paginate.Callbacks;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.rxkotlin.DisposableKt;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;
import kr.co.popone.fitts.model.post.PostAPI.Post;

public final class ShowRoomActivity$initPaginate$callbacks$1 implements Callbacks {
    final /* synthetic */ Ref$BooleanRef $isLoadingData;
    final /* synthetic */ RecyclerView $recyclerView;
    final /* synthetic */ ShowRoomActivity this$0;

    ShowRoomActivity$initPaginate$callbacks$1(ShowRoomActivity showRoomActivity, Ref$BooleanRef ref$BooleanRef, RecyclerView recyclerView) {
        this.this$0 = showRoomActivity;
        this.$isLoadingData = ref$BooleanRef;
        this.$recyclerView = recyclerView;
    }

    public void onLoadMore() {
        this.$isLoadingData.element = true;
        CompositeDisposable access$getDisposables$p = this.this$0.disposables;
        Disposable subscribe = this.this$0.getUserAPI$app_productionFittsRelease().getShowRoomPosts(this.this$0.userID, "recent", Long.valueOf(((Post) this.this$0.postList.get(this.this$0.postList.size() - 1)).getId()), this.this$0.getLimit()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new ShowRoomActivity$initPaginate$callbacks$1$onLoadMore$1<Object,Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "userAPI.getShowRoomPosts…                        }");
        DisposableKt.plusAssign(access$getDisposables$p, subscribe);
    }

    public boolean isLoading() {
        return this.$isLoadingData.element;
    }

    public boolean hasLoadedAllItems() {
        return this.this$0.isTotalItemLoaded();
    }
}
