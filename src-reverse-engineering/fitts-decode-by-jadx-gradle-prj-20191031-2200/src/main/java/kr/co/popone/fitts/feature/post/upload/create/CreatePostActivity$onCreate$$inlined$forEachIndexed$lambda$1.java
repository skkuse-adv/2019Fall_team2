package kr.co.popone.fitts.feature.post.upload.create;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

final class CreatePostActivity$onCreate$$inlined$forEachIndexed$lambda$1 implements OnClickListener {
    final /* synthetic */ int $index$inlined;
    final /* synthetic */ Button $styleButton;
    final /* synthetic */ CreatePostActivity this$0;

    CreatePostActivity$onCreate$$inlined$forEachIndexed$lambda$1(Button button, String str, int i, CreatePostActivity createPostActivity) {
        this.$styleButton = button;
        this.$index$inlined = i;
        this.this$0 = createPostActivity;
    }

    public final void onClick(View view) {
        this.this$0.getViewModel().styleButtonClicked(this.$index$inlined, this.$styleButton.getText().toString());
    }
}
