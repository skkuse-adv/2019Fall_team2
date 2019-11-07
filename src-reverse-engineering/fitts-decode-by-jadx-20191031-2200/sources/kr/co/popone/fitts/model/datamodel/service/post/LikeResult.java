package kr.co.popone.fitts.model.datamodel.service.post;

import com.uber.rave.annotation.Validated;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.validation.ValidatorFactoryImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Validated(factory = ValidatorFactoryImpl.class)
public final class LikeResult {
    private final int id;
    @NotNull
    private final String result;

    @NotNull
    public static /* synthetic */ LikeResult copy$default(LikeResult likeResult, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = likeResult.result;
        }
        if ((i2 & 2) != 0) {
            i = likeResult.id;
        }
        return likeResult.copy(str, i);
    }

    @NotNull
    public final String component1() {
        return this.result;
    }

    public final int component2() {
        return this.id;
    }

    @NotNull
    public final LikeResult copy(@NotNull String str, int i) {
        Intrinsics.checkParameterIsNotNull(str, "result");
        return new LikeResult(str, i);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof LikeResult) {
                LikeResult likeResult = (LikeResult) obj;
                if (Intrinsics.areEqual((Object) this.result, (Object) likeResult.result)) {
                    if (this.id == likeResult.id) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.result;
        return ((str != null ? str.hashCode() : 0) * 31) + this.id;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LikeResult(result=");
        sb.append(this.result);
        sb.append(", id=");
        sb.append(this.id);
        sb.append(")");
        return sb.toString();
    }

    public LikeResult(@NotNull String str, int i) {
        Intrinsics.checkParameterIsNotNull(str, "result");
        this.result = str;
        this.id = i;
    }

    public final int getId() {
        return this.id;
    }

    @NotNull
    public final String getResult() {
        return this.result;
    }
}
