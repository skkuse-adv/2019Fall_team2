package kr.co.popone.fitts.feature.order.orderlist;

import com.orhanobut.logger.Logger;
import io.reactivex.functions.Consumer;

final class OrderListActivity$onCreate$8<T> implements Consumer<Throwable> {
    public static final OrderListActivity$onCreate$8 INSTANCE = new OrderListActivity$onCreate$8();

    OrderListActivity$onCreate$8() {
    }

    public final void accept(Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append("WTF ");
        sb.append(th);
        Logger.d(sb.toString(), new Object[0]);
    }
}
