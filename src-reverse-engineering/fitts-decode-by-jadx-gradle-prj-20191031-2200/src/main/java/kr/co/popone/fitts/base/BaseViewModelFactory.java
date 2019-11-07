package kr.co.popone.fitts.base;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider.Factory;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public abstract class BaseViewModelFactory implements Factory {
    /* access modifiers changed from: protected */
    @NotNull
    public abstract BaseViewModel createViewModel();

    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkParameterIsNotNull(cls, "modelClass");
        return createViewModel();
    }
}
