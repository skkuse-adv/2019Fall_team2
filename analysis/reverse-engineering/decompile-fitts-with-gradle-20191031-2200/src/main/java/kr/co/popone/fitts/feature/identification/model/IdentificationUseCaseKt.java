package kr.co.popone.fitts.feature.identification.model;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;

public final class IdentificationUseCaseKt {
    private static final Regex ssnRegex = new Regex("^(?:[0-9]{2}(?:0[1-9]|1[0-2])(?:0[1-9]|[1,2][0-9]|3[0,1]))-[1-4][0-9]{6}$");

    public static final boolean isValid(@NotNull IdentificationViewData identificationViewData) {
        Intrinsics.checkParameterIsNotNull(identificationViewData, "receiver$0");
        Regex regex = ssnRegex;
        StringBuilder sb = new StringBuilder();
        sb.append(identificationViewData.getSsnFirst());
        sb.append("-");
        sb.append(identificationViewData.getSsnSecond());
        return regex.matchEntire(sb.toString()) != null;
    }
}
