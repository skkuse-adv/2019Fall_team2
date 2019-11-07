package kr.co.popone.fitts.model.datamodel.service.user;

import com.uber.rave.annotation.Validated;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.validation.ValidatorFactoryImpl;
import org.jetbrains.annotations.NotNull;

@Validated(factory = ValidatorFactoryImpl.class)
public final class FollowResult {
    @NotNull
    private final String message;

    @NotNull
    public static /* synthetic */ FollowResult copy$default(FollowResult followResult, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = followResult.message;
        }
        return followResult.copy(str);
    }

    @NotNull
    public final String component1() {
        return this.message;
    }

    @NotNull
    public final FollowResult copy(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        return new FollowResult(str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0010, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1.message, (java.lang.Object) ((kr.co.popone.fitts.model.datamodel.service.user.FollowResult) r2).message) != false) goto L_0x0015;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r2) {
        /*
            r1 = this;
            if (r1 == r2) goto L_0x0015
            boolean r0 = r2 instanceof kr.co.popone.fitts.model.datamodel.service.user.FollowResult
            if (r0 == 0) goto L_0x0013
            kr.co.popone.fitts.model.datamodel.service.user.FollowResult r2 = (kr.co.popone.fitts.model.datamodel.service.user.FollowResult) r2
            java.lang.String r0 = r1.message
            java.lang.String r2 = r2.message
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r2)
            if (r2 == 0) goto L_0x0013
            goto L_0x0015
        L_0x0013:
            r2 = 0
            return r2
        L_0x0015:
            r2 = 1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.datamodel.service.user.FollowResult.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        String str = this.message;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FollowResult(message=");
        sb.append(this.message);
        sb.append(")");
        return sb.toString();
    }

    public FollowResult(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        this.message = str;
    }

    @NotNull
    public final String getMessage() {
        return this.message;
    }
}
