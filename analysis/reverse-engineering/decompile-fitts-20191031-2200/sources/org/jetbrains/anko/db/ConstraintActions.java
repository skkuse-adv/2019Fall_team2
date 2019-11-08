package org.jetbrains.anko.db;

import com.kakao.network.ServerProtocol;
import org.jetbrains.annotations.NotNull;

public enum ConstraintActions {
    SET_NULL,
    SET_DEFAULT,
    SET_RESTRICT,
    CASCADE,
    NO_ACTION;

    @NotNull
    public String toString() {
        return StringsKt__StringsJVMKt.replace$default(super.toString(), "_", ServerProtocol.AUTHORIZATION_HEADER_DELIMITER, false, 4, (Object) null);
    }
}
