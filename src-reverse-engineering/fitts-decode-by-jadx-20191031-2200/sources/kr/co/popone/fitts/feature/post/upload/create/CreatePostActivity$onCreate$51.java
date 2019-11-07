package kr.co.popone.fitts.feature.post.upload.create;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.model.post.PostVariantViewData;
import org.jetbrains.annotations.Nullable;

final class CreatePostActivity$onCreate$51<T> implements Consumer<PostVariantViewData> {
    final /* synthetic */ CreatePostActivity this$0;

    CreatePostActivity$onCreate$51(CreatePostActivity createPostActivity) {
        this.this$0 = createPostActivity;
    }

    public final void accept(@Nullable PostVariantViewData postVariantViewData) {
        EditText editText = (EditText) this.this$0._$_findCachedViewById(C0010R$id.shop);
        Intrinsics.checkExpressionValueIsNotNull(editText, "this@CreatePostActivity.shop");
        editText.setEnabled(false);
        Button button = (Button) this.this$0._$_findCachedViewById(C0010R$id.search_shop_button);
        Intrinsics.checkExpressionValueIsNotNull(button, "search_shop_button");
        button.setEnabled(false);
        TextView textView = (TextView) this.this$0._$_findCachedViewById(C0010R$id.copy_shop_button);
        String str = "copy_shop_button";
        Intrinsics.checkExpressionValueIsNotNull(textView, str);
        textView.setEnabled(false);
        TextView textView2 = (TextView) this.this$0._$_findCachedViewById(C0010R$id.copy_shop_button);
        Intrinsics.checkExpressionValueIsNotNull(textView2, str);
        textView2.setVisibility(4);
    }
}
