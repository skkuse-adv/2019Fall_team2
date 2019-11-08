package kr.co.popone.fitts.feature.main;

import androidx.fragment.app.FragmentManager;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kr.co.popone.fitts.feature.alarm.AlarmFragment;
import kr.co.popone.fitts.feature.home.HomeFragment;
import kr.co.popone.fitts.feature.me.MeFragment;
import kr.co.popone.fitts.feature.store.StoreFragment;
import org.jetbrains.annotations.NotNull;

final class MainActivity$mainTabAdapter$2 extends Lambda implements Function0<MainAdapter> {
    final /* synthetic */ MainActivity this$0;

    MainActivity$mainTabAdapter$2(MainActivity mainActivity) {
        this.this$0 = mainActivity;
        super(0);
    }

    @NotNull
    public final MainAdapter invoke() {
        FragmentManager supportFragmentManager = this.this$0.getSupportFragmentManager();
        Intrinsics.checkExpressionValueIsNotNull(supportFragmentManager, "supportFragmentManager");
        return new MainAdapter(supportFragmentManager, CollectionsKt__CollectionsKt.listOf(new HomeFragment(), StoreFragment.Companion.newInstance(), new AlarmFragment(), new MeFragment()));
    }
}
