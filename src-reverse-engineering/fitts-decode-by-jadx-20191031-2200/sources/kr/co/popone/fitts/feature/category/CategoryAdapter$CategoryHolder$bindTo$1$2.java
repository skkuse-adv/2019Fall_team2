package kr.co.popone.fitts.feature.category;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0008R$drawable;
import kr.co.popone.fitts.C0010R$id;

final class CategoryAdapter$CategoryHolder$bindTo$1$2 implements OnClickListener {
    final /* synthetic */ View $this_with;

    CategoryAdapter$CategoryHolder$bindTo$1$2(View view) {
        this.$this_with = view;
    }

    public final void onClick(View view) {
        RecyclerView recyclerView = (RecyclerView) this.$this_with.findViewById(C0010R$id.subCategoryRecyclerView);
        String str = "subCategoryRecyclerView";
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, str);
        if (recyclerView.getVisibility() == 8) {
            RecyclerView recyclerView2 = (RecyclerView) this.$this_with.findViewById(C0010R$id.subCategoryRecyclerView);
            Intrinsics.checkExpressionValueIsNotNull(recyclerView2, str);
            recyclerView2.setVisibility(0);
            ((ImageView) this.$this_with.findViewById(C0010R$id.imageIconDrop)).setImageDrawable(ContextCompat.getDrawable(this.$this_with.getContext(), C0008R$drawable.img_icon_drop_up));
            return;
        }
        RecyclerView recyclerView3 = (RecyclerView) this.$this_with.findViewById(C0010R$id.subCategoryRecyclerView);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView3, str);
        recyclerView3.setVisibility(8);
        ((ImageView) this.$this_with.findViewById(C0010R$id.imageIconDrop)).setImageDrawable(ContextCompat.getDrawable(this.$this_with.getContext(), C0008R$drawable.img_icon_drop));
    }
}
