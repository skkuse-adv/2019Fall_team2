package kr.co.popone.fitts.feature.collection;

import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.collection.CollectionAPI.CollectionEntry;

final class MixedCollectionActivity$outputs$$inlined$with$lambda$3<T> implements Consumer<ArrayList<CollectionEntry>> {
    final /* synthetic */ MixedCollectionActivity this$0;

    MixedCollectionActivity$outputs$$inlined$with$lambda$3(MixedCollectionActivity mixedCollectionActivity) {
        this.this$0 = mixedCollectionActivity;
    }

    public final void accept(ArrayList<CollectionEntry> arrayList) {
        MixedCollectionAdapter access$getMixedCollectionAdapter$p = this.this$0.mixedCollectionAdapter;
        Intrinsics.checkExpressionValueIsNotNull(arrayList, "it");
        access$getMixedCollectionAdapter$p.addAllReload(arrayList);
    }
}
