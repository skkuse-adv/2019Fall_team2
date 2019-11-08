package kr.co.popone.fitts.di.module;

import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.identification.viewmodel.IdentificationAdditionalInfoViewModel;
import kr.co.popone.fitts.model.user.UserAPI;
import org.jetbrains.annotations.NotNull;

public final class IdentificationModule {
    @NotNull
    public final IdentificationAdditionalInfoViewModel provideCreatePostViewModel(@NotNull UserAPI userAPI) {
        Intrinsics.checkParameterIsNotNull(userAPI, "userApi");
        return new IdentificationAdditionalInfoViewModel(userAPI);
    }
}
