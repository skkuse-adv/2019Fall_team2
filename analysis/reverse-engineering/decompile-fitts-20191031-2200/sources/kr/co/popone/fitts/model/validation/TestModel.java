package kr.co.popone.fitts.model.validation;

import androidx.annotation.NonNull;
import com.uber.rave.annotation.Validated;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Validated(factory = ValidatorFactoryImpl.class)
public final class TestModel {
    private final long id;
    @NotNull
    private String name;
    private final boolean valid;

    @NotNull
    public static /* synthetic */ TestModel copy$default(TestModel testModel, long j, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            j = testModel.id;
        }
        if ((i & 2) != 0) {
            str = testModel.name;
        }
        if ((i & 4) != 0) {
            z = testModel.valid;
        }
        return testModel.copy(j, str, z);
    }

    public final long component1() {
        return this.id;
    }

    @NotNull
    public final String component2() {
        return this.name;
    }

    public final boolean component3() {
        return this.valid;
    }

    @NotNull
    public final TestModel copy(long j, @NotNull String str, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, "name");
        return new TestModel(j, str, z);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof TestModel) {
                TestModel testModel = (TestModel) obj;
                if ((this.id == testModel.id) && Intrinsics.areEqual((Object) this.name, (Object) testModel.name)) {
                    if (this.valid == testModel.valid) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.name;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        boolean z = this.valid;
        if (z) {
            z = true;
        }
        return hashCode + (z ? 1 : 0);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TestModel(id=");
        sb.append(this.id);
        sb.append(", name=");
        sb.append(this.name);
        sb.append(", valid=");
        sb.append(this.valid);
        sb.append(")");
        return sb.toString();
    }

    public TestModel(long j, @NotNull String str, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, "name");
        this.id = j;
        this.name = str;
        this.valid = z;
    }

    @NonNull
    public final long getId() {
        return this.id;
    }

    @NotNull
    @NonNull
    public final String getName() {
        return this.name;
    }

    public final void setName(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.name = str;
    }

    public /* synthetic */ TestModel(long j, String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 4) != 0) {
            z = true;
        }
        this(j, str, z);
    }

    public final boolean getValid() {
        return this.valid;
    }
}
