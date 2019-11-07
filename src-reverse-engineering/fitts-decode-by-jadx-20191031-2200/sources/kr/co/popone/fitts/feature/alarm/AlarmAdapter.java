package kr.co.popone.fitts.feature.alarm;

import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.feeds.BasePagedListAdapter;
import kr.co.popone.fitts.feature.feeds.BaseViewHolder;
import kr.co.popone.fitts.model.datamodel.service.alarm.Alarm;
import org.jetbrains.annotations.NotNull;

public final class AlarmAdapter extends BasePagedListAdapter<Alarm, AlarmViewHolder> {
    private static final AlarmAdapter$Companion$COMPARATOR$1 COMPARATOR = new AlarmAdapter$Companion$COMPARATOR$1();
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final Delegate delegate;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public interface Delegate extends kr.co.popone.fitts.feature.alarm.AlarmViewHolder.Delegate {
    }

    public AlarmAdapter(@NotNull Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
        super(COMPARATOR);
        this.delegate = delegate2;
    }

    @NotNull
    public final Delegate getDelegate() {
        return this.delegate;
    }

    @NotNull
    public AlarmViewHolder onCreateViewHolderWithoutLoading(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        return AlarmViewHolder.Companion.create(viewGroup, this.delegate);
    }

    public void onBindViewHolderWithoutLoading(@NotNull AlarmViewHolder alarmViewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(alarmViewHolder, "holder");
        BaseViewHolder.bind$default(alarmViewHolder, getItem(i), null, 2, null);
    }

    public int getItemViewTypeWithoutLoading(int i) {
        return AlarmViewHolder.Companion.getId();
    }
}
