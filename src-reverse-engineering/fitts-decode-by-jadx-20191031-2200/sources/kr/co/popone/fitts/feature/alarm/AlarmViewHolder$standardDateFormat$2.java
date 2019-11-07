package kr.co.popone.fitts.feature.alarm;

import java.text.SimpleDateFormat;
import java.util.Locale;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

final class AlarmViewHolder$standardDateFormat$2 extends Lambda implements Function0<SimpleDateFormat> {
    public static final AlarmViewHolder$standardDateFormat$2 INSTANCE = new AlarmViewHolder$standardDateFormat$2();

    AlarmViewHolder$standardDateFormat$2() {
        super(0);
    }

    @NotNull
    public final SimpleDateFormat invoke() {
        return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.getDefault());
    }
}
