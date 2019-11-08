package kr.co.popone.fitts.base;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.LayoutRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.utils.ActivityAnimationType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class BaseActivity extends AppCompatActivity {
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

    @NotNull
    public abstract ActivityAnimationType finishAnimationType();

    @LayoutRes
    public abstract int layoutResource();

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(layoutResource());
    }

    public void finish() {
        super.finish();
        ActivityAnimationType finishAnimationType = finishAnimationType();
        overridePendingTransition(finishAnimationType.getEnter(), finishAnimationType.getExit());
    }

    public final void activityStartForResult(@NotNull Intent intent, int i, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(intent, "intent");
        ActivityCompat.startActivityForResult(this, intent, i, activityAnimation(i2, i3));
    }

    @Nullable
    public final Bundle activityAnimation(int i, int i2) {
        return ActivityOptionsCompat.makeCustomAnimation(this, i, i2).toBundle();
    }
}
