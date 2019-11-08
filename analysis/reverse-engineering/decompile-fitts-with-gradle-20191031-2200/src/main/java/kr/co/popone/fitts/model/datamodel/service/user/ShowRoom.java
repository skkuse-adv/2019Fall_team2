package kr.co.popone.fitts.model.datamodel.service.user;

import androidx.annotation.NonNull;
import com.google.gson.annotations.SerializedName;
import com.uber.rave.annotation.Validated;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.validation.ValidatorFactoryImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Validated(factory = ValidatorFactoryImpl.class)
public final class ShowRoom {
    @SerializedName("showroom_cover_image_url")
    @Nullable
    private final String showRoomCoverImageUrl;
    @SerializedName("showroom_intro")
    @Nullable
    private final String showRoomIntro;
    @NotNull
    private final User user;

    @NotNull
    public static /* synthetic */ ShowRoom copy$default(ShowRoom showRoom, User user2, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            user2 = showRoom.user;
        }
        if ((i & 2) != 0) {
            str = showRoom.showRoomIntro;
        }
        if ((i & 4) != 0) {
            str2 = showRoom.showRoomCoverImageUrl;
        }
        return showRoom.copy(user2, str, str2);
    }

    @NotNull
    public final User component1() {
        return this.user;
    }

    @Nullable
    public final String component2() {
        return this.showRoomIntro;
    }

    @Nullable
    public final String component3() {
        return this.showRoomCoverImageUrl;
    }

    @NotNull
    public final ShowRoom copy(@NotNull User user2, @Nullable String str, @Nullable String str2) {
        Intrinsics.checkParameterIsNotNull(user2, "user");
        return new ShowRoom(user2, str, str2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0024, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2.showRoomCoverImageUrl, (java.lang.Object) r3.showRoomCoverImageUrl) != false) goto L_0x0029;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r3) {
        /*
            r2 = this;
            if (r2 == r3) goto L_0x0029
            boolean r0 = r3 instanceof kr.co.popone.fitts.model.datamodel.service.user.ShowRoom
            if (r0 == 0) goto L_0x0027
            kr.co.popone.fitts.model.datamodel.service.user.ShowRoom r3 = (kr.co.popone.fitts.model.datamodel.service.user.ShowRoom) r3
            kr.co.popone.fitts.model.datamodel.service.user.User r0 = r2.user
            kr.co.popone.fitts.model.datamodel.service.user.User r1 = r3.user
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0027
            java.lang.String r0 = r2.showRoomIntro
            java.lang.String r1 = r3.showRoomIntro
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0027
            java.lang.String r0 = r2.showRoomCoverImageUrl
            java.lang.String r3 = r3.showRoomCoverImageUrl
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r3)
            if (r3 == 0) goto L_0x0027
            goto L_0x0029
        L_0x0027:
            r3 = 0
            return r3
        L_0x0029:
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.datamodel.service.user.ShowRoom.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        User user2 = this.user;
        int i = 0;
        int hashCode = (user2 != null ? user2.hashCode() : 0) * 31;
        String str = this.showRoomIntro;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.showRoomCoverImageUrl;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode2 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ShowRoom(user=");
        sb.append(this.user);
        sb.append(", showRoomIntro=");
        sb.append(this.showRoomIntro);
        sb.append(", showRoomCoverImageUrl=");
        sb.append(this.showRoomCoverImageUrl);
        sb.append(")");
        return sb.toString();
    }

    public ShowRoom(@NotNull User user2, @Nullable String str, @Nullable String str2) {
        Intrinsics.checkParameterIsNotNull(user2, "user");
        this.user = user2;
        this.showRoomIntro = str;
        this.showRoomCoverImageUrl = str2;
    }

    @NotNull
    @NonNull
    public final User getUser() {
        return this.user;
    }

    @Nullable
    public final String getShowRoomIntro() {
        return this.showRoomIntro;
    }

    @Nullable
    public final String getShowRoomCoverImageUrl() {
        return this.showRoomCoverImageUrl;
    }
}
