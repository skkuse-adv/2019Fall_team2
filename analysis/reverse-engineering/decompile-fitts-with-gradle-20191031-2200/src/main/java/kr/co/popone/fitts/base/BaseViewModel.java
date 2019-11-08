package kr.co.popone.fitts.base;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import org.jetbrains.annotations.NotNull;

public abstract class BaseViewModel extends ViewModel {
    @NotNull
    private final MutableLiveData<Throwable> errorLiveData = new MutableLiveData<>();

    @NotNull
    public MutableLiveData<Throwable> getErrorLiveData() {
        return this.errorLiveData;
    }
}
