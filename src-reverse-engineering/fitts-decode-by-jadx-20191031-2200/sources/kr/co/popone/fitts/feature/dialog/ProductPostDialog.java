package kr.co.popone.fitts.feature.dialog;

import android.content.Context;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.C0017R$style;
import kr.co.popone.fitts.feature.dialog.ProductPostAdapter.Delegate;
import kr.co.popone.fitts.model.post.PostAPI.Post;
import kr.co.popone.fitts.ui.decorator.ProductPostDecorator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ProductPostDialog extends BottomSheetDialog {
    private final Delegate delegate;
    private final List<Post> productPosts;

    public static final class Builder {
        private Delegate delegate;
        private List<Post> productPosts;

        @NotNull
        public final Builder setProductPosts(@NotNull List<Post> list) {
            Intrinsics.checkParameterIsNotNull(list, "posts");
            this.productPosts = list;
            return this;
        }

        @NotNull
        public final Builder setDelegation(@NotNull Delegate delegate2) {
            Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
            this.delegate = delegate2;
            return this;
        }

        @Nullable
        public final ProductPostDialog build(@NotNull Context context) {
            Intrinsics.checkParameterIsNotNull(context, "context");
            List<Post> list = this.productPosts;
            if (list == null || this.delegate == null) {
                return null;
            }
            if (list == null) {
                Intrinsics.throwNpe();
            }
            Delegate delegate2 = this.delegate;
            if (delegate2 == null) {
                Intrinsics.throwNpe();
            }
            return new ProductPostDialog(context, C0017R$style.AppBottomSheetDialogTheme, list, delegate2);
        }
    }

    public ProductPostDialog(@NotNull Context context, int i, @NotNull List<Post> list, @NotNull Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(list, "productPosts");
        Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
        super(context, i);
        this.productPosts = list;
        this.delegate = delegate2;
        setContentView((int) C0013R$layout.dialog_product_post);
        initView();
    }

    private final void initView() {
        TextView textView = (TextView) findViewById(C0010R$id.textProductPostTitle);
        Intrinsics.checkExpressionValueIsNotNull(textView, "textProductPostTitle");
        StringBuilder sb = new StringBuilder();
        sb.append("이 상품의 포스트 (");
        sb.append(this.productPosts.size());
        sb.append(')');
        textView.setText(sb.toString());
        ProductPostAdapter productPostAdapter = new ProductPostAdapter(this.delegate);
        RecyclerView recyclerView = (RecyclerView) findViewById(C0010R$id.recyclerProductPost);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 0, false));
        recyclerView.setAdapter(productPostAdapter);
        if (recyclerView.getItemDecorationCount() < 1) {
            recyclerView.addItemDecoration(new ProductPostDecorator());
        }
        productPostAdapter.submitList(this.productPosts);
    }
}
