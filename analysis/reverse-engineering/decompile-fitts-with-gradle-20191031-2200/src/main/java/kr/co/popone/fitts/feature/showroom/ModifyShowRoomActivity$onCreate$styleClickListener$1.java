package kr.co.popone.fitts.feature.showroom;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import kotlin.TypeCastException;
import kr.co.popone.fitts.utils.ButtonExtensionsKt;

final class ModifyShowRoomActivity$onCreate$styleClickListener$1 implements OnClickListener {
    final /* synthetic */ ModifyShowRoomActivity this$0;

    ModifyShowRoomActivity$onCreate$styleClickListener$1(ModifyShowRoomActivity modifyShowRoomActivity) {
        this.this$0 = modifyShowRoomActivity;
    }

    public final void onClick(View view) {
        if (view != null) {
            Button button = (Button) view;
            if (this.this$0.selectedStyles.contains(button.getText().toString())) {
                button.setSelected(false);
                this.this$0.selectedStyles.remove(button.getText().toString());
            } else if (this.this$0.selectedStyles.size() < 3) {
                button.setSelected(true);
                this.this$0.selectedStyles.add(button.getText().toString());
            }
            ButtonExtensionsKt.updateStyleButton(button);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.widget.Button");
    }
}
