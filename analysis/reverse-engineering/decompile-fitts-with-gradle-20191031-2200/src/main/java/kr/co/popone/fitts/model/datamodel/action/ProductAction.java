package kr.co.popone.fitts.model.datamodel.action;

import org.jetbrains.annotations.NotNull;

public interface ProductAction {
    void onProductClick(long j, @NotNull String str);
}
