package kr.co.popone.fitts.feature.intro.join;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.jvm.internal.TypeIntrinsics;
import kr.co.popone.fitts.utils.ButtonExtensionsKt;

final class JoinActivity$onCreate$styleClickListener$1 implements OnClickListener {
    final /* synthetic */ JoinActivity this$0;

    JoinActivity$onCreate$styleClickListener$1(JoinActivity joinActivity) {
        this.this$0 = joinActivity;
    }

    public final void onClick(View view) {
        if (view != null) {
            Button button = (Button) view;
            if (CollectionsKt___CollectionsKt.contains(this.this$0.selectedStyles, button.getText())) {
                button.setSelected(false);
                List access$getSelectedStyles$p = this.this$0.selectedStyles;
                CharSequence text = button.getText();
                if (access$getSelectedStyles$p != null) {
                    TypeIntrinsics.asMutableCollection(access$getSelectedStyles$p).remove(text);
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
                }
            } else if (this.this$0.selectedStyles.size() < 3) {
                button.setSelected(true);
                this.this$0.selectedStyles.add(button.getText().toString());
            }
            ButtonExtensionsKt.updateStyleButton(button);
            this.this$0.selectedStylesObservable.onNext(CollectionsKt___CollectionsKt.toList(this.this$0.selectedStyles));
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.widget.Button");
    }
}
