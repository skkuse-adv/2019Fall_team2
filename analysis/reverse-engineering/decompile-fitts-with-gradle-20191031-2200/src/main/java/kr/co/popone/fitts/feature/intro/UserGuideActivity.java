package kr.co.popone.fitts.feature.intro;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import me.relex.circleindicator.CircleIndicator;
import org.jetbrains.annotations.Nullable;

public final class UserGuideActivity extends AppCompatActivity {
    private HashMap _$_findViewCache;

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    public void onBackPressed() {
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C0013R$layout.activity_user_guide);
        ViewPager viewPager = (ViewPager) _$_findCachedViewById(C0010R$id.viewPager);
        Intrinsics.checkExpressionValueIsNotNull(viewPager, "viewPager");
        viewPager.setAdapter(new UserGuideActivity$onCreate$1(this, getSupportFragmentManager()));
        ((CircleIndicator) _$_findCachedViewById(C0010R$id.indicatorView)).setViewPager((ViewPager) _$_findCachedViewById(C0010R$id.viewPager));
    }
}
