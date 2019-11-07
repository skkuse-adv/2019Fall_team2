package kr.co.popone.fitts.feature.post.upload.create;

import android.content.ClipboardManager;
import android.widget.EditText;
import io.reactivex.functions.Consumer;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.ui.DialogExtensions;

final class CreatePostActivity$onCreate$21<T> implements Consumer<Unit> {
    final /* synthetic */ CreatePostActivity this$0;

    CreatePostActivity$onCreate$21(CreatePostActivity createPostActivity) {
        this.this$0 = createPostActivity;
    }

    public final void accept(Unit unit) {
        DialogExtensions.showConfirmDialog$default(DialogExtensions.INSTANCE, this.this$0, "상세 페이지가 맞나요?", "쇼핑몰홈 링크 주소가 아닌 상세페이지 링크 주소가 맞는지 확인해주세요", new Function0<Unit>(this) {
            final /* synthetic */ CreatePostActivity$onCreate$21 this$0;

            {
                this.this$0 = r1;
            }

            public final void invoke() {
                Object systemService = this.this$0.this$0.getSystemService("clipboard");
                if (systemService != null) {
                    ClipboardManager clipboardManager = (ClipboardManager) systemService;
                    if (clipboardManager.hasPrimaryClip()) {
                        ((EditText) this.this$0.this$0._$_findCachedViewById(C0010R$id.shop)).setText(clipboardManager.getPrimaryClip().getItemAt(0).coerceToText(this.this$0.this$0).toString());
                        return;
                    }
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type android.content.ClipboardManager");
            }
        }, null, "네,맞아요", "아니요,수정할게요", 0, 128, null);
    }
}
