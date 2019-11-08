package kr.co.popone.fitts.feature.main;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import androidx.fragment.app.Fragment;
import com.orhanobut.logger.Logger;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.eventtracker.EventTracker.CustomAttributes;
import kr.co.popone.fitts.feature.appreview.AppReview;
import kr.co.popone.fitts.feature.main.MainActivity.ShopTooltipState;
import kr.co.popone.fitts.feature.main.MainActivity.WhenMappings;
import kr.co.popone.fitts.feature.main.MainTabBar.Listener;
import kr.co.popone.fitts.feature.main.MainTabBar.Tab;
import kr.co.popone.fitts.feature.me.MeFragment;
import kr.co.popone.fitts.feature.post.detail.PostActivity;
import kr.co.popone.fitts.feature.post.upload.create.CreatePostActivityUtil;
import kr.co.popone.fitts.ui.DialogExtensions;
import org.jetbrains.annotations.NotNull;
import photopicker.view.ImageSelectorActivity;

public final class MainActivity$onCreate$2 implements Listener {
    final /* synthetic */ MainActivity this$0;

    MainActivity$onCreate$2(MainActivity mainActivity) {
        this.this$0 = mainActivity;
    }

    public void onTabClicked(@NotNull Tab tab, boolean z) {
        String str = "tab";
        Intrinsics.checkParameterIsNotNull(tab, str);
        int i = WhenMappings.$EnumSwitchMapping$1[tab.ordinal()];
        String str2 = "Tap To Main Tab";
        if (i != 1) {
            if (i != 2) {
                String str3 = "Tap To Main Tab Except Home";
                if (i == 3) {
                    String str4 = "notification";
                    this.this$0.getEventTracker$app_productionFittsRelease().logCustom(str2, new CustomAttributes().put(str, str4));
                    this.this$0.getEventTracker$app_productionFittsRelease().logCustom(str3, new CustomAttributes().put(str, str4));
                    if (!z) {
                        MainActivity mainActivity = this.this$0;
                        mainActivity.scrollCurrentTop(mainActivity.getMainTabAdapter().getItem(2));
                        ((MainTabBar) this.this$0._$_findCachedViewById(C0010R$id.mainTabBar)).setNotificationBadge(0);
                    } else {
                        this.this$0.setShopTooltip(ShopTooltipState.CANCEL);
                    }
                    ((MainTabBar) this.this$0._$_findCachedViewById(C0010R$id.mainTabBar)).setNotificationBadge(0);
                    this.this$0.updateTabSelected(2);
                } else if (i == 4) {
                    MainAdapter mainTabAdapter = this.this$0.getMainTabAdapter();
                    String str5 = "my";
                    this.this$0.getEventTracker$app_productionFittsRelease().logCustom(str2, new CustomAttributes().put(str, str5));
                    this.this$0.getEventTracker$app_productionFittsRelease().logCustom(str3, new CustomAttributes().put(str, str5));
                    this.this$0.updateTabSelected(3);
                    Fragment item = mainTabAdapter.getItem(3);
                    if (!(item instanceof MeFragment)) {
                        item = null;
                    }
                    MeFragment meFragment = (MeFragment) item;
                    if (meFragment != null) {
                        meFragment.initData();
                    }
                    if (z) {
                        this.this$0.setShopTooltip(ShopTooltipState.CANCEL);
                    }
                }
            } else if (z) {
                this.this$0.updateTabSelected(1);
                this.this$0.setShopTooltip(ShopTooltipState.CANCEL);
                this.this$0.onStoreTabClicked();
            } else {
                MainActivity mainActivity2 = this.this$0;
                mainActivity2.scrollCurrentTop(mainActivity2.getMainTabAdapter().getItem(1));
            }
        } else if (z) {
            this.this$0.getEventTracker$app_productionFittsRelease().logCustom(str2, new CustomAttributes().put(str, "home"));
            this.this$0.updateTabSelected(0);
        } else {
            MainActivity mainActivity3 = this.this$0;
            mainActivity3.scrollCurrentTop(mainActivity3.getMainTabAdapter().getItem(0));
        }
    }

    public void writeButtonClicked() {
        CreatePostActivityUtil createPostActivityUtil$app_productionFittsRelease = this.this$0.getCreatePostActivityUtil$app_productionFittsRelease();
        createPostActivityUtil$app_productionFittsRelease.setSchemeHandler(this.this$0.getSchemeHandler$app_productionFittsRelease());
        CreatePostActivityUtil.showCreatePostActivity$default(createPostActivityUtil$app_productionFittsRelease, this.this$0, "home", false, null, 12, null);
    }

    public boolean homeTabLongClicked() {
        Logger.d("home button long click", new Object[0]);
        if (!Intrinsics.areEqual((Object) "production", (Object) "alpha")) {
            return false;
        }
        AppReview.INSTANCE.resetData();
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.this$0);
        Intrinsics.checkExpressionValueIsNotNull(defaultSharedPreferences, "PreferenceManager.getDef…ltSharedPreferences(this)");
        Editor edit = defaultSharedPreferences.edit();
        edit.remove(ImageSelectorActivity.Companion.getPREF_SHOWED_DETAIL_IMAGE_GUIDE());
        edit.remove(ImageSelectorActivity.Companion.getPREF_SHOWED_COVER_IMAGE_GUIDE());
        edit.remove("no_show_event");
        edit.remove(PostActivity.PREF_SHOWED_SIMILAR_BODY_DIALOG);
        edit.apply();
        DialogExtensions.showMessageDialog$default(DialogExtensions.INSTANCE, this.this$0, "", "리뷰데이터가 리셋되었습니다.", null, null, 24, null);
        return true;
    }
}
