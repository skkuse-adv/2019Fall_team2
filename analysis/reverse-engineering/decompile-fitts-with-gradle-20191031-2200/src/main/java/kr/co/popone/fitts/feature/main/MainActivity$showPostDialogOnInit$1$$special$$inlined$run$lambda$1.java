package kr.co.popone.fitts.feature.main;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kr.co.popone.fitts.model.datamodel.service.app.AppInfo;

final class MainActivity$showPostDialogOnInit$1$$special$$inlined$run$lambda$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ AppInfo $it$inlined;
    final /* synthetic */ MainActivity$showPostDialogOnInit$1 this$0;

    MainActivity$showPostDialogOnInit$1$$special$$inlined$run$lambda$1(MainActivity$showPostDialogOnInit$1 mainActivity$showPostDialogOnInit$1, AppInfo appInfo) {
        this.this$0 = mainActivity$showPostDialogOnInit$1;
        this.$it$inlined = appInfo;
        super(0);
    }

    public final void invoke() {
        this.this$0.this$0.showStoreMarketingToolTip(this.$it$inlined.getToolTip());
    }
}
