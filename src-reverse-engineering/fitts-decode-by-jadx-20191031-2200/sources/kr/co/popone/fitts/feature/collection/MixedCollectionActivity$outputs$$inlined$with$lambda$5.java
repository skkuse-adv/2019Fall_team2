package kr.co.popone.fitts.feature.collection;

import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.model.collection.CollectionAPI.CollectionDetailResponse;

final class MixedCollectionActivity$outputs$$inlined$with$lambda$5<T> implements Consumer<CollectionDetailResponse> {
    final /* synthetic */ MixedCollectionActivity this$0;

    MixedCollectionActivity$outputs$$inlined$with$lambda$5(MixedCollectionActivity mixedCollectionActivity) {
        this.this$0 = mixedCollectionActivity;
    }

    public final void accept(CollectionDetailResponse collectionDetailResponse) {
        TextView textView = (TextView) this.this$0._$_findCachedViewById(C0010R$id.toolbarTitle);
        Intrinsics.checkExpressionValueIsNotNull(textView, "toolbarTitle");
        textView.setText(collectionDetailResponse.getShortTitle());
        MixedCollectionAdapter access$getMixedCollectionAdapter$p = this.this$0.mixedCollectionAdapter;
        Intrinsics.checkExpressionValueIsNotNull(collectionDetailResponse, "it");
        access$getMixedCollectionAdapter$p.addCollectionDetail(collectionDetailResponse);
        ((RecyclerView) this.this$0._$_findCachedViewById(C0010R$id.recyclerView)).scrollToPosition(0);
    }
}
