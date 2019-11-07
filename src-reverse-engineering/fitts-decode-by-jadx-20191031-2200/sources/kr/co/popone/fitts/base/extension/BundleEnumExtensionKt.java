package kr.co.popone.fitts.base.extension;

import android.os.Bundle;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class BundleEnumExtensionKt {
    public static final void putEnum(@NotNull Bundle bundle, @NotNull String str, @NotNull Enum<?> enumR) {
        Intrinsics.checkParameterIsNotNull(bundle, "receiver$0");
        Intrinsics.checkParameterIsNotNull(str, "key");
        Intrinsics.checkParameterIsNotNull(enumR, "enum");
        bundle.putString(str, enumR.name());
    }
}
