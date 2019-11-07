package kr.co.popone.fitts.model.remote.search;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.datamodel.service.user.User;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class KeywordSearchFittieResult {
    @SerializedName("total_count")
    private final int count;
    @SerializedName("results")
    @NotNull
    private final List<User> fitties;

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<kr.co.popone.fitts.model.datamodel.service.user.User>, for r1v0, types: [java.util.List] */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ kr.co.popone.fitts.model.remote.search.KeywordSearchFittieResult copy$default(kr.co.popone.fitts.model.remote.search.KeywordSearchFittieResult r0, java.util.List<kr.co.popone.fitts.model.datamodel.service.user.User> r1, int r2, int r3, java.lang.Object r4) {
        /*
            r4 = r3 & 1
            if (r4 == 0) goto L_0x0006
            java.util.List<kr.co.popone.fitts.model.datamodel.service.user.User> r1 = r0.fitties
        L_0x0006:
            r3 = r3 & 2
            if (r3 == 0) goto L_0x000c
            int r2 = r0.count
        L_0x000c:
            kr.co.popone.fitts.model.remote.search.KeywordSearchFittieResult r0 = r0.copy(r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.remote.search.KeywordSearchFittieResult.copy$default(kr.co.popone.fitts.model.remote.search.KeywordSearchFittieResult, java.util.List, int, int, java.lang.Object):kr.co.popone.fitts.model.remote.search.KeywordSearchFittieResult");
    }

    @NotNull
    public final List<User> component1() {
        return this.fitties;
    }

    public final int component2() {
        return this.count;
    }

    @NotNull
    public final KeywordSearchFittieResult copy(@NotNull List<User> list, int i) {
        Intrinsics.checkParameterIsNotNull(list, "fitties");
        return new KeywordSearchFittieResult(list, i);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof KeywordSearchFittieResult) {
                KeywordSearchFittieResult keywordSearchFittieResult = (KeywordSearchFittieResult) obj;
                if (Intrinsics.areEqual((Object) this.fitties, (Object) keywordSearchFittieResult.fitties)) {
                    if (this.count == keywordSearchFittieResult.count) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        List<User> list = this.fitties;
        return ((list != null ? list.hashCode() : 0) * 31) + this.count;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("KeywordSearchFittieResult(fitties=");
        sb.append(this.fitties);
        sb.append(", count=");
        sb.append(this.count);
        sb.append(")");
        return sb.toString();
    }

    public KeywordSearchFittieResult(@NotNull List<User> list, int i) {
        Intrinsics.checkParameterIsNotNull(list, "fitties");
        this.fitties = list;
        this.count = i;
    }

    @NotNull
    public final List<User> getFitties() {
        return this.fitties;
    }

    public final int getCount() {
        return this.count;
    }
}
