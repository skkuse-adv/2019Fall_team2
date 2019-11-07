package kr.co.popone.fitts.feature.collection;

import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.orhanobut.logger.Logger;
import io.reactivex.functions.BiConsumer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.model.collection.CollectionAPI.CollectionDetailResponse;

final class PostCollectionActivity$loadDetailData$1<T1, T2> implements BiConsumer<CollectionDetailResponse, Throwable> {
    final /* synthetic */ PostCollectionActivity this$0;

    PostCollectionActivity$loadDetailData$1(PostCollectionActivity postCollectionActivity) {
        this.this$0 = postCollectionActivity;
    }

    public final void accept(CollectionDetailResponse collectionDetailResponse, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append("{response: ");
        sb.append(collectionDetailResponse);
        sb.append(", error: ");
        sb.append(th);
        sb.append('}');
        Logger.d(sb.toString(), new Object[0]);
        this.this$0.collectionDetailRequest = null;
        if (collectionDetailResponse != null) {
            PostCollectionActivity.access$getCollectionAdapter$p(this.this$0).setCollectionResponse(collectionDetailResponse);
            TextView textView = (TextView) this.this$0._$_findCachedViewById(C0010R$id.toolbarTitle);
            Intrinsics.checkExpressionValueIsNotNull(textView, "toolbarTitle");
            textView.setText(collectionDetailResponse.getShortTitle());
            ((RecyclerView) this.this$0._$_findCachedViewById(C0010R$id.recyclerView)).scrollToPosition(0);
        }
    }
}
