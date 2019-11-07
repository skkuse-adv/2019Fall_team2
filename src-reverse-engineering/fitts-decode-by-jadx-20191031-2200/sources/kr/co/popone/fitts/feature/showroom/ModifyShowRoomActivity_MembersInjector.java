package kr.co.popone.fitts.feature.showroom;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.model.user.UserAPI;

public final class ModifyShowRoomActivity_MembersInjector implements MembersInjector<ModifyShowRoomActivity> {
    private final Provider<SessionManager> sessionManagerProvider;
    private final Provider<UserAPI> userAPIProvider;

    public ModifyShowRoomActivity_MembersInjector(Provider<SessionManager> provider, Provider<UserAPI> provider2) {
        this.sessionManagerProvider = provider;
        this.userAPIProvider = provider2;
    }

    public static MembersInjector<ModifyShowRoomActivity> create(Provider<SessionManager> provider, Provider<UserAPI> provider2) {
        return new ModifyShowRoomActivity_MembersInjector(provider, provider2);
    }

    public void injectMembers(ModifyShowRoomActivity modifyShowRoomActivity) {
        injectSessionManager(modifyShowRoomActivity, (SessionManager) this.sessionManagerProvider.get());
        injectUserAPI(modifyShowRoomActivity, (UserAPI) this.userAPIProvider.get());
    }

    public static void injectSessionManager(ModifyShowRoomActivity modifyShowRoomActivity, SessionManager sessionManager) {
        modifyShowRoomActivity.sessionManager = sessionManager;
    }

    public static void injectUserAPI(ModifyShowRoomActivity modifyShowRoomActivity, UserAPI userAPI) {
        modifyShowRoomActivity.userAPI = userAPI;
    }
}
