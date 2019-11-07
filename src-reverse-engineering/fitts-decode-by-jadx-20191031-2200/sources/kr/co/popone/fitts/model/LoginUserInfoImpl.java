package kr.co.popone.fitts.model;

import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.base.SessionManager;
import org.jetbrains.annotations.NotNull;

public final class LoginUserInfoImpl implements LoginUserInfo {
    private final SessionManager sessionManager;

    public LoginUserInfoImpl(@NotNull SessionManager sessionManager2) {
        Intrinsics.checkParameterIsNotNull(sessionManager2, "sessionManager");
        this.sessionManager = sessionManager2;
    }

    public long getUserID() {
        return this.sessionManager.getUserID();
    }
}
