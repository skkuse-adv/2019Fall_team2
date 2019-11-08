package kr.co.popone.fitts.di.component;

import kr.co.popone.fitts.base.FittsApplication;
import org.jetbrains.annotations.NotNull;

public interface AppComponent {
    void inject(@NotNull FittsApplication fittsApplication);
}
