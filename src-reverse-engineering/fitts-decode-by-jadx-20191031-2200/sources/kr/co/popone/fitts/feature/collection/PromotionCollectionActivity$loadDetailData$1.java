package kr.co.popone.fitts.feature.collection;

import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.orhanobut.logger.Logger;
import io.reactivex.functions.BiConsumer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.model.collection.CollectionAPI.CollectionDetailResponse;

final class PromotionCollectionActivity$loadDetailData$1<T1, T2> implements BiConsumer<CollectionDetailResponse, Throwable> {
    final /* synthetic */ PromotionCollectionActivity this$0;

    PromotionCollectionActivity$loadDetailData$1(PromotionCollectionActivity promotionCollectionActivity) {
        this.this$0 = promotionCollectionActivity;
    }

    public final void accept(CollectionDetailResponse collectionDetailResponse, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append("detail {response: ");
        sb.append(collectionDetailResponse);
        sb.append(", error: ");
        sb.append(th);
        sb.append('}');
        Logger.d(sb.toString(), new Object[0]);
        this.this$0.collectionDetailRequest = null;
        this.this$0.collectionDetailResponse = collectionDetailResponse;
        if (collectionDetailResponse != null) {
            PromotionCollectionActivity.access$getCollectionAdapter$p(this.this$0).setCollectionResponse(collectionDetailResponse);
            TextView textView = (TextView) this.this$0._$_findCachedViewById(C0010R$id.toolbarTitle);
            Intrinsics.checkExpressionValueIsNotNull(textView, "toolbarTitle");
            textView.setText(collectionDetailResponse.getShortTitle());
            ((RecyclerView) this.this$0._$_findCachedViewById(C0010R$id.recyclerView)).scrollToPosition(0);
        }
    }
}
