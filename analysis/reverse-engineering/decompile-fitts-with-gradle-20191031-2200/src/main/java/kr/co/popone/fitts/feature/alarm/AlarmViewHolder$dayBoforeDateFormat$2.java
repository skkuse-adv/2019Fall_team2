package kr.co.popone.fitts.feature.alarm;

import java.text.SimpleDateFormat;
import java.util.Locale;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

final class AlarmViewHolder$dayBoforeDateFormat$2 extends Lambda implements Function0<SimpleDateFormat> {
    public static final AlarmViewHolder$dayBoforeDateFormat$2 INSTANCE = new AlarmViewHolder$dayBoforeDateFormat$2();

    AlarmViewHolder$dayBoforeDateFormat$2() {
        super(0);
    }

    @NotNull
    public final SimpleDateFormat invoke() {
        return new SimpleDateFormat("M월 d일", Locale.getDefault());
    }
}
