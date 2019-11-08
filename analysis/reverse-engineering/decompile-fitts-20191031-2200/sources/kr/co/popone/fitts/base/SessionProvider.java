package kr.co.popone.fitts.base;

import org.jetbrains.annotations.Nullable;

public interface SessionProvider {
    @Nullable
    SessionManager getSessionManager();
}
