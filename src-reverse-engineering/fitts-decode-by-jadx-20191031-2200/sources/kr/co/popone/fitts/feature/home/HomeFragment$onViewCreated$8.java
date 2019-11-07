package kr.co.popone.fitts.feature.home;

import androidx.lifecycle.Observer;
import kr.co.popone.fitts.base.extension.FragmentExtensionKt;

final class HomeFragment$onViewCreated$8<T> implements Observer<Throwable> {
    final /* synthetic */ HomeFragment this$0;

    HomeFragment$onViewCreated$8(HomeFragment homeFragment) {
        this.this$0 = homeFragment;
    }

    public final void onChanged(Throwable th) {
        if (th != null) {
            FragmentExtensionKt.handleError(this.this$0, th);
        }
    }
}
