package kr.co.popone.fitts.feature.alarm;

import androidx.paging.PagedList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import kr.co.popone.fitts.model.datamodel.service.alarm.Alarm;

final class AlarmFragment$onViewCreated$2 extends FunctionReference implements Function1<PagedList<Alarm>, Unit> {
    AlarmFragment$onViewCreated$2(AlarmAdapter alarmAdapter) {
        super(1, alarmAdapter);
    }

    public final String getName() {
        return "submitList";
    }

    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(AlarmAdapter.class);
    }

    public final String getSignature() {
        return "submitList(Landroidx/paging/PagedList;)V";
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((PagedList) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(PagedList<Alarm> pagedList) {
        ((AlarmAdapter) this.receiver).submitList(pagedList);
    }
}
