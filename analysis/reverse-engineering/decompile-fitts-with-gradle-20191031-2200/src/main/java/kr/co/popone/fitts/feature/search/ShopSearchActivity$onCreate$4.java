package kr.co.popone.fitts.feature.search;

import android.annotation.SuppressLint;
import android.content.Intent;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0001R$anim;
import kr.co.popone.fitts.feature.search.ShopResultAdapter.Delegate;
import kr.co.popone.fitts.feature.search.ShopSearchActivity.Parameters;
import kr.co.popone.fitts.model.search.SearchAPI.SearchShopResult.ShopEntry;
import org.jetbrains.annotations.NotNull;

public final class ShopSearchActivity$onCreate$4 implements Delegate {
    final /* synthetic */ Parameters $parameters;
    final /* synthetic */ ShopSearchActivity this$0;

    @NotNull
    public String getResultText() {
        return "";
    }

    ShopSearchActivity$onCreate$4(ShopSearchActivity shopSearchActivity, Parameters parameters) {
        this.this$0 = shopSearchActivity;
        this.$parameters = parameters;
    }

    @NotNull
    public List<ShopEntry> getShops() {
        return this.this$0.resultShops;
    }

    @SuppressLint({"RestrictedApi"})
    public void onItemClick(int i) {
        ShopEntry shopEntry = (ShopEntry) this.this$0.resultShops.get(i);
        Intent intent = new Intent(this.this$0, ShopWebViewActivity.class);
        ShopWebViewActivity.Parameters parameters = new ShopWebViewActivity.Parameters(shopEntry.getUrl(), shopEntry.getName(), true, this.$parameters.getConfirmMessage(), this.$parameters.getCopyLinkIcon(), this.$parameters.getLinkCopyTitle(), this.$parameters.getLinkCopyMessage());
        intent.putExtra("parameters", parameters);
        ActivityOptionsCompat makeCustomAnimation = ActivityOptionsCompat.makeCustomAnimation(this.this$0, C0001R$anim.slide_up, C0001R$anim.fade_out);
        Intrinsics.checkExpressionValueIsNotNull(makeCustomAnimation, "ActivityOptionsCompat.ma…lide_up, R.anim.fade_out)");
        ActivityCompat.startActivityForResult(this.this$0, intent, 100, makeCustomAnimation.toBundle());
    }
}
