package kr.co.popone.fitts.feature.alarm;

import androidx.recyclerview.widget.DiffUtil.ItemCallback;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.datamodel.service.alarm.Alarm;
import org.jetbrains.annotations.NotNull;

public final class AlarmAdapter$Companion$COMPARATOR$1 extends ItemCallback<Alarm> {
    AlarmAdapter$Companion$COMPARATOR$1() {
    }

    public boolean areItemsTheSame(@NotNull Alarm alarm, @NotNull Alarm alarm2) {
        Intrinsics.checkParameterIsNotNull(alarm, "oldItem");
        Intrinsics.checkParameterIsNotNull(alarm2, "newItem");
        return alarm.getId() == alarm2.getId();
    }

    public boolean areContentsTheSame(@NotNull Alarm alarm, @NotNull Alarm alarm2) {
        Intrinsics.checkParameterIsNotNull(alarm, "oldItem");
        Intrinsics.checkParameterIsNotNull(alarm2, "newItem");
        return alarm.getId() == alarm2.getId();
    }
}
