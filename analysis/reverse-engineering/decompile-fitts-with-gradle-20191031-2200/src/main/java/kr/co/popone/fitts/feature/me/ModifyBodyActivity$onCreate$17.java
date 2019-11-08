package kr.co.popone.fitts.feature.me;

import android.view.View;
import android.view.View.OnClickListener;
import kotlin.Pair;
import org.jetbrains.anko.internals.AnkoInternals;

final class ModifyBodyActivity$onCreate$17 implements OnClickListener {
    final /* synthetic */ ModifyBodyActivity this$0;

    ModifyBodyActivity$onCreate$17(ModifyBodyActivity modifyBodyActivity) {
        this.this$0 = modifyBodyActivity;
    }

    public final void onClick(View view) {
        ModifyBodyActivity modifyBodyActivity = this.this$0;
        modifyBodyActivity.startActivity(AnkoInternals.createIntent(modifyBodyActivity, SizeGuideActivity.class, new Pair[0]));
    }
}
