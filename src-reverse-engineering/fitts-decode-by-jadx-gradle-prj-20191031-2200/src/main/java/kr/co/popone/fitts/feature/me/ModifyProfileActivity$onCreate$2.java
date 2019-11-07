package kr.co.popone.fitts.feature.me;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.feature.post.PostType;
import kr.co.popone.fitts.model.datamodel.service.post.ImageFile;
import photopicker.view.ImageSelectorActivity;
import photopicker.view.ImageSelectorActivity.Companion;

final class ModifyProfileActivity$onCreate$2 implements OnClickListener {
    final /* synthetic */ ModifyProfileActivity this$0;

    ModifyProfileActivity$onCreate$2(ModifyProfileActivity modifyProfileActivity) {
        this.this$0 = modifyProfileActivity;
    }

    public final void onClick(View view) {
        Companion companion = ImageSelectorActivity.Companion;
        Companion.start$default(companion, (Activity) this.this$0, companion.getMODE_SINGLE(), true, ImageFile.Companion.getTYPE_PROFILE(), 0, (PostType) null, 48, (Object) null);
    }
}
