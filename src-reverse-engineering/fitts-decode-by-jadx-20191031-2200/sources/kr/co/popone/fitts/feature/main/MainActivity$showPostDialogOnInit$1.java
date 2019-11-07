package kr.co.popone.fitts.feature.main;

import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.feature.post.upload.create.CreatePostActivityUtil;
import kr.co.popone.fitts.model.datamodel.service.app.AppInfo;

final class MainActivity$showPostDialogOnInit$1<T> implements Consumer<AppInfo> {
    final /* synthetic */ MainActivity this$0;

    MainActivity$showPostDialogOnInit$1(MainActivity mainActivity) {
        this.this$0 = mainActivity;
    }

    public final void accept(AppInfo appInfo) {
        if (appInfo.getShowPostingDialog()) {
            CreatePostActivityUtil createPostActivityUtil$app_productionFittsRelease = this.this$0.getCreatePostActivityUtil$app_productionFittsRelease();
            createPostActivityUtil$app_productionFittsRelease.setSchemeHandler(this.this$0.getSchemeHandler$app_productionFittsRelease());
            createPostActivityUtil$app_productionFittsRelease.showCreatePostActivity(this.this$0, "home", true, new MainActivity$showPostDialogOnInit$1$$special$$inlined$run$lambda$1(this, appInfo));
            return;
        }
        this.this$0.showStoreMarketingToolTip(appInfo.getToolTip());
    }
}
