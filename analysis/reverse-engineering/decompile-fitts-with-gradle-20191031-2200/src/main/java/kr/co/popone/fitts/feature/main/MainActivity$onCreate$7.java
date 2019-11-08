package kr.co.popone.fitts.feature.main;

import androidx.drawerlayout.widget.DrawerLayout;
import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.event.FeedEvent$FeedSchemeEvent;
import kr.co.popone.fitts.event.MainEvent$AppFinishEvent;
import kr.co.popone.fitts.event.MainEvent$MainTabChangeEvent;
import kr.co.popone.fitts.event.NotificationEvent;
import kr.co.popone.fitts.event.PushRendingEvent$ShowCreatePostDialogEvent;
import kr.co.popone.fitts.eventtracker.EventTracker.CustomAttributes;
import kr.co.popone.fitts.feature.post.upload.create.CreatePostActivityUtil;

final class MainActivity$onCreate$7<T> implements Consumer<Object> {
    final /* synthetic */ MainActivity this$0;

    MainActivity$onCreate$7(MainActivity mainActivity) {
        this.this$0 = mainActivity;
    }

    public final void accept(Object obj) {
        if (obj instanceof PushRendingEvent$ShowCreatePostDialogEvent) {
            CreatePostActivityUtil.showCreatePostActivity$default(this.this$0.getCreatePostActivityUtil$app_productionFittsRelease(), this.this$0, "order_notice", false, null, 12, null);
        } else if (obj instanceof MainEvent$MainTabChangeEvent) {
            ((MainTabBar) this.this$0._$_findCachedViewById(C0010R$id.mainTabBar)).setSelectedTab(((MainEvent$MainTabChangeEvent) obj).getTab());
            ((DrawerLayout) this.this$0._$_findCachedViewById(C0010R$id.drawerMenu)).closeDrawer(this.this$0._$_findCachedViewById(C0010R$id.menuContainer));
        } else if (obj instanceof MainEvent$AppFinishEvent) {
            this.this$0.finish();
        } else if (obj instanceof FeedEvent$FeedSchemeEvent) {
            FeedEvent$FeedSchemeEvent feedEvent$FeedSchemeEvent = (FeedEvent$FeedSchemeEvent) obj;
            this.this$0.getSchemeHandler$app_productionFittsRelease().handleScheme(this.this$0, feedEvent$FeedSchemeEvent.getScheme());
            String title = feedEvent$FeedSchemeEvent.getTitle();
            if (title != null) {
                this.this$0.getEventTracker$app_productionFittsRelease().logCustom("Tap More Button In Home Feed", new CustomAttributes().put("title", title));
            }
        } else if (obj instanceof NotificationEvent) {
            ((MainTabBar) this.this$0._$_findCachedViewById(C0010R$id.mainTabBar)).setNotificationBadge(((NotificationEvent) obj).getBadge());
        }
    }
}
